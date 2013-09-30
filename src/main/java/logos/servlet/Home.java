package logos.servlet;

import gapi.GoogleAPI;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logos.twitter.TwitterClient;

public class Home extends HttpServlet {

	private static final long serialVersionUID = 8118734349788591708L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		GoogleAPI google = new GoogleAPI();		
		String tweet = google.spreadsheet("0AiEZezeUULf3dHh3UEdOSXE3YzJmTXNmRVNJWkI4NEE").worksheet("test").getValue(1, 1);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, twitter: " +  tweet);
		
		//String tweet = req.getParameter("tweet");
		
		if(tweet != null) {
			TwitterClient.directTweet(tweet);
		}
	}

}