package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json");
	
	private String apiResource;
	
	APIResources(String apiResource) {
		this.apiResource=apiResource;
	}
	
	public String getAPIResource() {
		return apiResource;
	}

}
