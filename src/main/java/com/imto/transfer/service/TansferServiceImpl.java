package com.imto.transfer.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imto.transfer.datastore.DataStore;
import com.imto.transfer.dto.Headers;
import com.imto.transfer.dto.TransferDTO;
import com.imto.transfer.dto.TransferWebhookDTO;
import com.imto.transfer.endpoint.TransferEndPoint;
import com.imto.transfer.model.Transfer;
import com.imto.transfer.response.ResponseHttp;
import com.imto.transfer.response.TransferResponse;
import com.imto.transfer.response.WebhookTransferResponse;
import com.imto.transfer.utils.Constants;
import com.imto.transfer.utils.PostClient;

public class TansferServiceImpl implements TansferService {

	private static Logger _log = Logger.getLogger(TransferEndPoint.class.getName());


	public Response getTransactionStatus(int transferId) {

		_log.info("printing transferId");

		_log.info(transferId);

		String url = Constants.FLUTTER_WAVE_BASE_URL;

		String secret = Constants.SECRET_KEY;

		ResponseHttp rsp = PostClient.makeGetRequest(url + "/" + transferId, secret);

		_log.info("rsp.getResponseCode()");

		_log.info(rsp.getResponseData());

		TransferResponse transResponse = new TransferResponse();
		try {

			_log.info("json");
			_log.info(rsp.getResponseData());

			JSONObject jsonRspObj = new JSONObject(rsp.getResponseData());

			String data = jsonRspObj.optString("data").trim();

			if (rsp.getResponseCode() == 200) {
				transResponse.setMessage("SUCCESSFUL");
				transResponse.setStatus(00);
				transResponse.setData(data);
				return Response.status(Response.Status.OK).entity(transResponse).build();

			} else {
				transResponse.setMessage(rsp.getResponseData());
				transResponse.setStatus(01);
				transResponse.setData(data);
				return Response.status(Response.Status.BAD_REQUEST).entity(transResponse).build();

			}
		} catch (Exception e) {

			transResponse.setMessage(rsp.getResponseData());
			transResponse.setStatus(02);

			return Response.status(Response.Status.BAD_REQUEST).entity(transResponse).build();
		}

	}



	public Response createTransfer(TransferDTO transferDTO) {

		_log.info("called createTransfer");
		_log.info("==============printing data===============");
		_log.info(transferDTO);

		Headers headers = new Headers();

		headers.setAuthorization(Constants.SECRET_KEY);

		System.out.println("headers:: " + headers);
		System.out.println();

		System.out.println();
		String url = Constants.FLUTTER_WAVE_BASE_URL;

		TransferResponse response = new TransferResponse();

		ResponseHttp rsp = PostClient.makePostRequest("POST", url, headers, transferDTO.toString());

		JSONObject jsonRspObj = new JSONObject(rsp.getResponseData());

		_log.info("json");
		_log.info(jsonRspObj);

		try {
			String data = jsonRspObj.optString("data").trim();

			Gson gson = new GsonBuilder().create();
			Transfer transfer = gson.fromJson(data, Transfer.class);

			List<Transfer> listOfTransfers = DataStore.getListOfTransfers();
			_log.info("listOfTransfers");

			_log.info(listOfTransfers);

			if (rsp.getResponseCode() == 200) {

				response.setMessage("SUCCESSFUL");

				response.setStatus(00);

				response.setData(transfer.getData());

				listOfTransfers.add(transfer);

				return Response.status(Response.Status.CREATED).entity(response).build();

			} else {
				response.setMessage("FAILED");
				response.setStatus(01);
				return Response.status(Response.Status.BAD_REQUEST).entity(response).build();

			}
		} catch (Exception e) {

			response.setMessage("FAILED");
			response.setStatus(02);
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}

	}

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public Response recieveRequest(TransferWebhookDTO transferWebhookDTO) {

		_log.info("calling recieveRequest");

		_log.info("printing data");

		_log.info(transferWebhookDTO);

		WebhookTransferResponse rsp = new WebhookTransferResponse();

		Transfer transfer = DataStore.getTransferByTransId(transferWebhookDTO.getData().getId());

		if (transfer != null) {
			_log.info("transfer");

			_log.info(transfer);

			modelMapper.map(transferWebhookDTO, transfer);

			rsp.setTransfer(transfer);

			rsp.setMessage("Transfer Webhook Successful");

			rsp.setStatus("00");

			return Response.status(Response.Status.CREATED).entity(rsp).build();
		} else {
			rsp.setMessage("Transfer Webhook Faild");

			rsp.setStatus("01");

			return Response.status(Response.Status.BAD_REQUEST).entity(rsp).build();
		}
	}

}
