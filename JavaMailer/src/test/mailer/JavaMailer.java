package test.mailer;
import java.util.ResourceBundle;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class JavaMailer {	

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("test.mailer.myProp");
		
		//System.out.println(rb.getString("hostname"));
		HtmlEmail htmlemail = new HtmlEmail();
		//Email email = new SimpleEmail();

		htmlemail.setHostName(rb.getString("hostname"));
		htmlemail.setSmtpPort(Integer.parseInt(rb.getString("port")));
		htmlemail.setAuthenticator(new DefaultAuthenticator(rb.getString("user"), rb.getString("password")));
		htmlemail.setStartTLSEnabled(true);
		try {
			htmlemail.setFrom("user@domain.com");
			htmlemail.setSubject("Eclipse Test");		    
			htmlemail.setMsg("This is a test <b> html email </b> ... :-)" );
			htmlemail.addTo("user@domain.com");
			htmlemail.send();
		} catch (EmailException e) {
		    e.printStackTrace();	    
	    
		}
	}
}
