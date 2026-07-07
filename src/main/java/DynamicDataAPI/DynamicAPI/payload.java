package DynamicDataAPI.DynamicAPI;

public class payload {
	
	public static String Addbook(String isbn, String aisle)
	{
		return "{\r\n"
				+ "  \"name\": \"Learn API Automation with Rest Assured\",\r\n"
				+ "  \"isbn\": \""+isbn+"\",\r\n"
				+ "  \"aisle\": \""+aisle+"\",\r\n"
				+ "  \"author\": \"Mohd Afnan Jawed\"\r\n"
				+ "}";
		
	}
	
	public static String DeleteBook(String id)
	{
	    return "{\n" +
	           "    \"ID\":\"" + id + "\"\n" +
	           "}";
	}

}
