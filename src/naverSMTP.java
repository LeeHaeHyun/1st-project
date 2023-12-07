import java.util.Properties; 

import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.PasswordAuthentication; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 

public class naverSMTP 
{ 
	String t1 = "",t2 ="",str="",t3="";
	naverSMTP(String t1, String t2, String str, String t3)
	{	
//		String host = "127.0.0.1"; 
		final String user = "보내는 사람 이메일 입력";  
		final String password = "보내는 사람 비밀번호 입력";
		//수신 메일
		String to = "받는 사람 이메일주소"; 
		// Get the session object 
		// java.util.Properties 클래스를 사용하여 STMP 서버와 관련되 정보를 지정 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", "smtp.naver.com"); // 이 부분은 건들지 마세요
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		// Properties에 저장디어있는 설정 값을 getDefaultInstance() 메소드로 설정값을 저장하여 세션 생성 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
		{ 
			protected PasswordAuthentication getPasswordAuthentication() 
		{ 
				return new PasswordAuthentication(user, password); 
   } 
  }); 
   
  // Compose the message 
  try 
  { 
   MimeMessage message = new MimeMessage(session); 
   //발신자 셋팅 
   message.setFrom(new InternetAddress(user)); 
    
//   메일 보내는 사람이 한명일 경우 
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
    
   //메일 보내는 사람이 다수일 경우 [ 다중 이메일 구현 ]
//   InternetAddress[] toAddr = new InternetAddress[0]; 
//   toAddr[0] = new InternetAddress ("easycross@naver.com"); 

   //수신자 셋팅 (두가지 셋팅방법이 있지만 동일한걸로 생각됨..)
//    message.addRecipients(Message.RecipientType.TO, toAddr); 
//   message.setRecipients(Message.RecipientType.TO, toAddr ); 

    
   // 메일 제목을 입력
   message.setSubject("(신고) ["+ (t1) +"]님께서 ["+(t2)+"]을(를) 신고", "UTF-8"); 
    
   // 메일 내용을 입력
   message.setText(str+"회신은 "+ "["+ t3 + "]" + "으로 주세요!", "UTF-8"); 

   // 메세지 보내는 성공 알림
   Transport.send(message); 
   System.out.println("성공적으로 메일이 전송되었습니다."); 

  } 
  catch (MessagingException e) 
  { 
   e.printStackTrace(); 
  } 

} 

}