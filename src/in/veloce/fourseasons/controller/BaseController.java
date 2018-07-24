/**
 * 
 */
package in.veloce.fourseasons.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.veloce.fourseasons.beans.SendMessage;
import in.veloce.fourseasons.services.SendMsgService;

/**
 * @author dubeyd
 *
 */
public class BaseController {

	@Autowired
    private SendMsgService sendMsgService;
	
	private SendMessage sendMessage;
	
	@RequestMapping(value = "send_msg", method = RequestMethod.POST)
	 public final void revokeDenial(final HttpServletRequest request, final HttpServletResponse response)
	            throws UnsupportedEncodingException {
	       // logger.debug("ClaimDetailController : revokeDenial : Entry ");
	        final String name = request.getParameter("name");
	        final String email = request.getParameter("email");
	        final String msg = request.getParameter("msg");
	        sendMessage.setEmail(email);
	        sendMessage.setMessage(msg);
	        sendMessage.setName(name);
	        sendMsgService.sendmsg(sendMessage);
	        
	       

	        //JSONObject result = claimDetailTabButtonService.revokeDenial(revokeDenialDTO);
	        //logger.debug("ClaimDetailController : revokeDenial : Exit ");
	       // return result.toString().getBytes("UTF-8");
	    }
	
}
