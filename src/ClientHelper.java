
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientHelper 
{
	
	Socket socket;
	
	public void clientRun(String nickname,String res)
	{
		try 
		{
		    // 서버와 연결
	        // 메시지 송신 쓰레드와 수신 쓰레드 생성해서 시작
	        SenderThread thread1 = new SenderThread(socket,nickname);
	        //B_Login에 GUI 연동
	    	Client ca = new Client(thread1);
	    	// 채팅방 입장 후 입력을 받을 때 동작을 하는 쓰레드.
	        ReceiverThread thread2 = new ReceiverThread(socket,ca,res,nickname);
	        
	        thread1.start();
	        thread2.start();  
	     }
		 catch (Exception e) 
		 {
			 System.out.println(e.getMessage());
		 }	
	}
	
    public static void main(String[] args) 
    {
    	//클라이언트 실행
    	new ClientHelper();
//    	.clientLogin();
    }

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
    
    
   
}



