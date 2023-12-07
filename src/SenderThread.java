
import java.net.*;


import java.io.*;
class SenderThread extends Thread 
{
    Socket socket;
    String name;
    String st;
    PrintWriter writer;
    SenderThread(Socket socket, String name) 
    { 
        this.socket = socket;
        this.name = name;
        //데몬 설정으로 ReceiverThread가 죽으면 같이 끝남.
        setDaemon(true);
    }

	public void run() {
        try {
        	
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(socket.getOutputStream());
            
	    // 제일 먼저 서버로 대화명 송신한다.
//	        writer.println(name);
//	        writer.flush();
	           
		   // 키보드로 입력된 메시지를 서버로 송신 
		    while (true) 
		    {
	                String str = reader.readLine();
	                if (str.equals("bye"))
	                    break;
	                writer.println(str);
	                writer.flush();
	            }
	        
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        finally 
        {
            try 
            { 
                socket.close(); 
            } 
            catch (Exception ignored) 
            {
            }
        }
    }
}
