import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Join_Member extends JPanel 
{
	JTextField idTf;
	JPasswordField passTf;
	JPasswordField passReTf;
	JTextField emailTf;
	JTextField yearTf;
	JTextField phoneTf;
	JPanel mainPanel;
	JPanel subPanel;
	JComboBox<String> monthComboBox;
	JComboBox<String> dayComboBox;
	JComboBox<String> mbtiComboBox;
	JRadioButton menButton;
	JRadioButton girlButton;
	JButton registerButton;
	JButton cancelButton = new JButton("취소");
	Calendar now1 = Calendar.getInstance();
	Font font = new Font("회원가입", Font.BOLD, 40);

	String year = "", month = "", day = "", mbtig = "";
	String id = "", pass = "", passRe = "", email = "", sex = "", phone = "";
	B_Login lp;

	public Join_Member(B_Login lp) 
	{
		this.lp = lp;
		subPanel = new JPanel();
		subPanel.setLayout(new GridBagLayout());
		subPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		JLabel idLabel = new JLabel("별명(ID) : ");
		idLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel passLabel = new JLabel("비밀번호 : ");
		passLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel passReLabel = new JLabel("비밀번호 재확인 : ");
		JLabel emailLabel = new JLabel("이메일 : ");
		emailLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel birthLabel = new JLabel("생년월일 : ");
		birthLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel sexLabel = new JLabel("성별 : ");
		sexLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel mbtiLabel = new JLabel("MBTI : ");
		mbtiLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel phoneLabel = new JLabel("연락처 : ");
		phoneLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel todayLabel = new JLabel("가입일자 : "); //가입일: (입력불가)
		todayLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		JLabel joiny = new JLabel();
		joiny.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		idTf = new JTextField(15);
		passTf = new JPasswordField(15);
		passReTf = new JPasswordField(15);
		emailTf = new JTextField(15);
		yearTf = new JTextField(4);
		phoneTf = new JTextField(11);

		monthComboBox = new JComboBox<String>(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" });
		dayComboBox = new JComboBox<String>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31" });
		mbtiComboBox = new JComboBox<String>(
				new String[] {"INTJ", "INTP", "ENTJ", "ENTP", "INFJ",
						"INFP","ENFJ","ENFP","ISTJ","ISFJ",
						"ESTJ","ESFJ","ISTP","ISFP","ESTP","ESFP"});

		menButton = new JRadioButton("남");
		menButton.setFont(new Font("나눔고딕", Font.BOLD, 15));
		girlButton = new JRadioButton("여");
		girlButton.setFont(new Font("나눔고딕", Font.BOLD, 15));
		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(menButton);
		sexGroup.add(girlButton);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 3, 0, 0);

		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(idLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		subPanel.add(idTf, c); // 아이디

		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(passLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		subPanel.add(passTf, c); // pass
		
		c.gridx = 2;
		c.gridy = 1; 
		subPanel.add(new JLabel("특수문자 + 8자"),c); //보안설정

		c.gridx = 0;
		c.gridy = 2;
		subPanel.add(passReLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		subPanel.add(passReTf, c); // password 재확인

		c.gridx = 0;
		c.gridy = 3;
		subPanel.add(emailLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		subPanel.add(emailTf, c); // 이름

		c.gridx = 0;
		c.gridy = 4;
		subPanel.add(birthLabel, c);

		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0.6;
		subPanel.add(yearTf, c);

		c.gridx = 2;
		c.gridy = 4;
		c.weightx = 0.2;
		subPanel.add(monthComboBox, c);

		c.gridx = 3;
		c.gridy = 4;
		c.weightx = 0.2;
		subPanel.add(dayComboBox, c);

		c.gridx = 0;
		c.gridy = 5;
		subPanel.add(sexLabel, c);

		c.gridx = 1;
		c.gridy = 5;
		subPanel.add(menButton, c);

		c.gridx = 2;
		c.gridy = 5;
		subPanel.add(girlButton, c);

		c.gridx = 0;
		c.gridy = 6;
		subPanel.add(mbtiLabel, c);
		
		c.gridx = 1;
		c.gridy = 6;
		c.weightx = 0.7;
		subPanel.add(mbtiComboBox, c); // mbti
		
		c.gridx = 0;
		c.gridy = 7;
		subPanel.add(phoneLabel, c);

		c.gridx = 1;
		c.gridy = 7;
		subPanel.add(phoneTf, c);
		
		c.gridx = 0;
		c.gridy = 8;
		subPanel.add(todayLabel, c);
		
		c.gridx = 1;
		c.gridy = 8;
		String t1 = now1.get(Calendar.YEAR) + " 년 " +
				(now1.get(Calendar.MONTH)+1) + " 월 " + now1.get(Calendar.DAY_OF_MONTH) + "일 "
				 + now1.get(Calendar.HOUR_OF_DAY) + ": " + now1.get(Calendar.MINUTE) + "";
		joiny.setText(t1);
		subPanel.add(joiny, c);
		
		c.gridx = 1;
		c.gridy = 9; 
		subPanel.add(new JLabel("			"),c); //보안 메세지
		
		c.gridx = 1;
		c.gridy = 10; 
		subPanel.add(new JLabel("▶ 개인정보는"),c); //보안 메세지
		
		c.gridx = 1;
		c.gridy = 11; 
		subPanel.add(new JLabel("▷ 채팅방 서비스 이외의"),c); //보안 메세지
		
		c.gridx = 1;
		c.gridy = 12; 
		subPanel.add(new JLabel("▶ 용도로는 절대"),c); //보안 메세지
		
		c.gridx = 1;
		c.gridy = 13; 
		subPanel.add(new JLabel("▷ 이용되지 않습니다."),c); //보안설정
		
				
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JLabel signupLabel = new JLabel("MBTI 회원가입");
		signupLabel.setForeground(new Color(128, 128, 255));
		signupLabel.setFont(new Font("나눔고딕", Font.BOLD, 25));
		signupLabel.setFont(font);
		signupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		registerButton = new JButton("회원가입");
		registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		registerButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		registerButton.setFont(new Font("나눔고딕", Font.BOLD, 35));

		cancelButton = new JButton("돌아가기");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelButton.setAlignmentY(Component.CENTER_ALIGNMENT);
		cancelButton.setFont(new Font("나눔고딕", Font.BOLD, 35));
		
		mainPanel.add(signupLabel);
		mainPanel.add(subPanel);
		mainPanel.add(registerButton); 
		mainPanel.add(cancelButton);
		

		monthComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == monthComboBox) {
					JComboBox monthBox = (JComboBox) e.getSource();
					month = (String) monthBox.getSelectedItem();
				}

			}
		});
		dayComboBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (e.getSource() == dayComboBox) {
					JComboBox dayBox = (JComboBox) e.getSource();
					day = (String) dayBox.getSelectedItem();
				}
			}
		});
		
		mbtiComboBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (e.getSource() == mbtiComboBox) 
				{
					JComboBox mbtiBox = (JComboBox) e.getSource();
					mbtig = (String) mbtiBox.getSelectedItem();
				}
			}
		});

		menButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
				sex = e.getActionCommand();
			}
		});

		girlButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				sex = e.getActionCommand();
			}
		});
		
		//취소 되돌아가기
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				lp.card.next(lp.cardPanel);
			}
		});
		
		registerButton.addActionListener(new ActionListener() 
		{      //회원가입버튼
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				id = idTf.getText();
				pass = new String(passTf.getPassword());
				passRe = new String(passReTf.getPassword());
				email = emailTf.getText();
				year = yearTf.getText();
				phone = phoneTf.getText();

				String sql = "insert into 회원DB(별명_ID, 비밀번호_PW, 이메일, 생년월일, 성별, MBTI, 연락처, 가입일) values (?,?,?,?,?,?,?,?)";

				Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$"); //8자 영문+특문+숫자
				Matcher passMatcher = passPattern1.matcher(pass);

				if (!passMatcher.find()) 
				{
					JOptionPane.showMessageDialog(null, "비밀번호는 영문 + 특수문자 + 숫자 8자 이상으로 구성되어야 합니다", "비밀번호 오류", 2);
				} 
				else if (!pass.equals(passRe)) 
				{
					JOptionPane.showMessageDialog(null, "비밀번호가 서로 맞지 않습니다", "비밀번호 오류", 2);
				} 
				else 
				{
					try 
					{
						Connection conn = lp.getConnection();

						PreparedStatement pstmt = conn.prepareStatement(sql);

						String date = yearTf.getText() + "-" + month + "-" + day;
						String mbti = mbtig;
						
						pstmt.setString(1, idTf.getText());
						pstmt.setString(2, pass);
						pstmt.setString(3, emailTf.getText());
						pstmt.setString(4, date);
						pstmt.setString(5, sex);
						pstmt.setString(6, mbti);						
						pstmt.setString(7, phoneTf.getText());
						pstmt.setString(8, t1);
						
						int r = pstmt.executeUpdate();
						System.out.println("성공적으로 회원가입 완료 " + r);
						JOptionPane.showMessageDialog(null, "회원 가입 완료!", "회원가입", 1);
						lp.card.previous(lp.cardPanel); // 다 완료되면 로그인 화면으로
					} 
					catch (SQLException e1) 
					{
						System.out.println("SQL error" + e1.getMessage());
						if (e1.getMessage().contains("ORA-00001")) 
						{
							JOptionPane.showMessageDialog(null, id+"(은)는 다른 이용자가 이미 사용중인 ID입니다.","아이디 중복 오류",2);							
						} else
							JOptionPane.showMessageDialog(null, "잘못 입력하였습니다. 다시 확인해주세요!", "오류", 2);
					} // try ,catch
				}
			}
		});
	}
}