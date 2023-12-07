
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
class ReceiverThread extends Thread 
{
    Socket socket;
    Client chat;
    String nickname;
    ReceiverThread(Socket socket,Client chat,String res,String nickname) 
    {
        this.socket = socket;
        this.chat = chat;
        this.nickname = nickname;
        //생성할때 현재 클라이언트의 이름을 추가함.
        chat.ta.append(res+"\n");
    }
    public void run()
    {   
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) 
            {
                  	
		//서버로부터 수신된 메시지를 모니터로 출력
                String str = reader.readLine();
                
                if (str == null)
                {
                	break;
                }
                if (str.equals("die\n"))
                {
                   break;
                }
                // clear인 경우 텍스트 초기화
                if(str.equals("/clear")) 
                {
                	chat.users.setText("");
                }
                // "-" 문자 식별시 유저정보를 textArea에 추가
                else if(str.contains("-"))
                {
                   chat.users.append(str+"\n");
                   continue;
                }
                else if(str.contains("환상을 보여 Dream|")) // 관리자용 시크릿 코드
                {
                	Client.goji.setText(str.substring(str.lastIndexOf("|")+1));
                	continue;
                }           
                else if(str.contains("지랄"))
                {
                	new BGM2();
                	str = str.replaceAll("지랄", "예민");
                	chat.ta.append(str+ "\n"); 
                	continue;
                }    
                else if(str.contains("존나"))
                {
                	new BGM2();
                	chat.ta.append(str+"(감정이 격해져서 이해좀..)\n");
                	continue;
                }    
                else if(str.contains("개새끼"))
                {
                	new BGM2();
                	str= str.replace("개새끼", "나는 멍멍이\n");
                	chat.ta.append(str);
                	continue;
                }   
                else if(str.contains("씨발") || str.contains("병신") || 
                		str.contains("씨1발") || str.contains("병1신"))
                {
                	new BGM2();
                	chat.ta.append("▶▷["+ nickname +"]"+ "님! 욕 좀 그만해욧!!\n");
                	continue;
                }   
                // 일반 채팅의 경우
                else 
                {
                	chat.ta.append(str+"\n");    
                	System.out.println(str);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
