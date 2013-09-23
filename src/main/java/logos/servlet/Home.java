package logos.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logos.twitter.TwitterClient;

public class Home extends HttpServlet {

	private static final long serialVersionUID = 8118734349788591708L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, twitter");
				
		String tweet = req.getParameter("tweet");
		if(tweet != null) {
			TwitterClient.directTweet(tweet);
		}
	}

}