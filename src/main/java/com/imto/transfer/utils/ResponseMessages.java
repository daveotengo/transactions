package com.imto.transfer.utils;


public enum ResponseMessages {
	
	NOT_FOUND {
		public String toString() {
			return "Object was not found";
		}
	},
	
	NO_BODY_PROVIDED {
		public String toString() {
			return "Wrong message body. Check if the JSON content of the message fulfill all the requirements.";
		}
	},
	
	UNPROCESSABLE_REQUEST {
		public String toString() {
			return "Wrong Date format!!. Please Check your date format.";
		}
	},
	
	REQUEST_WITH_FUTURE_DATE {
		public String toString() {
			return "Future Date Entry!!. Please Check your date..You have entered a future date.";
		}
	},
	
	RESOURCE_ALREADY_PRESENT {
		public String toString() {
			return "The resource can't be added due to a conflict. This resource is already present.";
		}
	},
	
	RESOURCE_NOT_PRESENT {
		public String toString() {
			return "The resource can't be updated, it was not found on the system.";
		}
	},
	
	CANNOT_EXECUTE {
		public String toString() {
			return "Resource not found on the system.";
		}
	},
	
	SUCCESSFULLY_ADDED {
		public String toString() {
			return "The resource was successfully added to the system.";
		}
	},
	
	SUCCESSFULLY_REMOVED {
		public String toString() {
			return "The resources were successfully removed from the system.";
		}
	},
	
	SUCCESSFULLY_UPDATED {
		public String toString() {
			return "The resource was successfully updated.";
		}
	}

}
