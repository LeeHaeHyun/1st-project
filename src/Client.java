
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class Client extends JFrame implements ActionListener
{
	JPanel p1, p2, p3, p4, p5;
	JTextField tf;
	JScrollPane sp;
	JTextArea ta, users;
	JButton b1, b2;
	JButton[] roomlist;
	SenderThread st;
	static JLabel goji;
	B_Login lp;

	public Client(SenderThread st)
	{
		super("MBTI 채팅방 [Made By 이해현]");
		p1 = new JPanel();
		p1.setBounds(12, 380, 840, 46);
		p2 = new JPanel();
		p2.setBounds(12, 44, 674, 339);
		p4 = new JPanel();
		p4.setBounds(0, 0, 6, 383);
		p5 = new JPanel();
		p5.setBounds(683, 0, 32, 383);
		ta = new JTextArea(23, 42); //
		ta.setFont(new Font("나눔고딕", Font.BOLD, 15));
		sp = new JScrollPane(ta, 20, 31);
		sp.setBounds(0, 0, 674, 345);
		p1.setLayout(null);
		p2.setLayout(null);
		p2.add(sp);
		p5.setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(p1);
		
		JButton btnmbti = new JButton("(Mbti) 궁금해요!");
		btnmbti.setBounds(163, 6, 139, 35);
		p1.add(btnmbti);
		btnmbti.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JButton admin119 = new JButton("(신고) 너무해요!");
		admin119.setBounds(314, 6, 139, 35);
		p1.add(admin119);
		admin119.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JButton gameroom = new JButton("(게임) 심심해요!");
		gameroom.setBounds(12, 6, 139, 35);
		p1.add(gameroom);
		gameroom.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		JButton goodbye = new JButton("(탈퇴) 바꼈어요!");
		goodbye.setBounds(465, 6, 139, 35);
		p1.add(goodbye);
		goodbye.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		goodbye.addActionListener(new ActionListener() // 회원탈퇴 입장
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Z_Bye_Member(lp);
			}
			
		});
		

		// ============================ 버튼 액션 파트 ================================
		gameroom.addActionListener(new ActionListener() // 게임방 입장
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Z_GameShop();
			}
			
		});
		
		admin119.addActionListener(new ActionListener() // 신고 입장
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Z_Mail119();
			}
			
		});
		
		btnmbti.addActionListener(new ActionListener() // MBTI 사전 입장
		{
			public void actionPerformed(ActionEvent e) 
			{
				new Z_Mbti_Dic();
			}
			
		});
		getContentPane().add(p2);
		getContentPane().add(p4);
		p4.setLayout(null);
		getContentPane().add(p5);
		setVisible(true);
		ta.setEditable(false);

		goji = new JLabel("공지사항");
		goji.setHorizontalAlignment(SwingConstants.CENTER);
		goji.setBounds(12, 0, 668, 46);
		getContentPane().add(goji);
		goji.setFont(new Font("나눔고딕", Font.BOLD, 20));
		users = new JTextArea(16, 20);
		users.setBounds(715, 44, 137, 339);
		getContentPane().add(users);
		users.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("현재 접속자");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(715, 1, 139, 40);
		getContentPane().add(lblNewLabel);
		
		users.setEditable(false);
		tf = new JTextField(24);
		tf.setBounds(12, 436, 533, 35);
		getContentPane().add(tf);
		tf.setFont(new Font("나눔고딕", Font.BOLD, 18)); //
		b1 = new JButton("전송");
		b1.setBounds(561, 435, 291, 35);
		getContentPane().add(b1);
		b1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		b1.addActionListener(this);
		tf.addKeyListener(this.new KeyEventHandler());
		setLocation(600, 400);
		setResizable(false);
		setSize(880, 521);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.st = st;
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		if (str.equals("전송"))
		{
			if (!tf.getText().equals("")) // 공백이 아닐 경우
			{
				// GUI로 SenderThread를 제어
				st.writer.println(tf.getText());
				st.writer.flush();
				tf.setText("");
			}
		} else if (str.equals("Exit"))
		{
			System.exit(0);
		}
	}

	class KeyEventHandler extends KeyAdapter
	{
		public void keyTyped(KeyEvent e)
		{
			if (e.getKeyChar() == KeyEvent.VK_ENTER)
			{
				if (!tf.getText().equals(""))
				{
					st.writer.println(tf.getText());
					st.writer.flush();
					tf.setText("");
				}
			}
		}
	}
}