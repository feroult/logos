package logos.api;

import gapi.GoogleAPI;

public class LogosAPI {

	public Quote pickOneQuote() {
		GoogleAPI google = new GoogleAPI();		
		google.spreadsheet(Setup.spreadsheetKey()).worksheet("quotes").asMap();
		
		return null;
	}

}
