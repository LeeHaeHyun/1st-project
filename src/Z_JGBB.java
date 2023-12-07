import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Z_JGBB extends JFrame
{

// 프레임 생성
	JFrame frm = new JFrame("인생은 짱겜뽀");

// 버튼 생성
	JButton btn1 = new JButton("가위");
	JButton btn2 = new JButton("바위");
	JButton btn3 = new JButton("보");
	JButton btn4 = new JButton("G A M E S T A R T");

// 상태 글씨 설정
	JLabel lbl = new JLabel();
// ★ 레이아웃 설정
	FlowLayout fLay = new FlowLayout();

// 코인 라벨 생성
	JLabel coin = new JLabel("코인 : " + (lifetx));

// ★ 시작 이미지 : 느린 gif
	JLabel strLbl = new JLabel();
// ★ 시작 이미지 : 느린 gif
	ImageIcon ssimage = new ImageIcon(("image/back.gif"));
// ★ 실행 이미지 : 빠른 gif
	JLabel playLbl = new JLabel();
// ★ 실행 이미지 : 빠른 gif
	ImageIcon psimage = new ImageIcon(("image/back01.gif"));

// ★ 가위 라벨 생성
	JLabel sLbl = new JLabel();

// ★ 가위 라벨 이미지
	ImageIcon simage = new ImageIcon(("image/SIS.png"));

// ★ 바위 라벨 생성
	JLabel rLbl = new JLabel();

// ★ 바위 라벨 이미지
	ImageIcon rimage = new ImageIcon(("image/ROCK.png"));

// ★ 보 라벨 생성
	JLabel bLbl = new JLabel();

// ★ 보 라벨 이미지
	ImageIcon bimage = new ImageIcon(("image/PAPER.png"));

	boolean check = true;
	static int lifetx = 100;

	boolean cNum = false;

	Z_JGBB() // 디폴트 생성자
	{
// ★ 버튼 위치와 크기 설정
		btn1.setBounds(68, 350, 60, 60);
		btn2.setBounds(220, 350, 60, 60);
		btn3.setBounds(372, 350, 60, 60);
		btn4.setBounds(128, 276, 244, 53);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		frm.getContentPane().add(btn1); // 가위 버튼 생성
		frm.getContentPane().add(btn2); // 바위 버튼 생성
		frm.getContentPane().add(btn3); // 보 버튼 생성
		frm.getContentPane().add(btn4); // 시작 버튼 생성
		frm.getContentPane().add(lbl); // 상태 글씨 패널추가
		frm.getContentPane().add(sLbl); // 가위 이미지 패널추가
		frm.getContentPane().add(rLbl); // 바위 이미지 패널추가
		frm.getContentPane().add(bLbl); // 바위 이미지 패널추가
		frm.getContentPane().setLayout(null); // 자유 레이아웃
		frm.getContentPane().add(coin); // 코인 글씨 패널추가
		frm.getContentPane().add(strLbl); // 시작 이미지 패널추가
		frm.getContentPane().add(playLbl); // 실행 이미지 패널추가
// ★ 시작 이미지 : 느린 gif
		strLbl.setIcon(ssimage);
		strLbl.setBounds(174, 65, 153, 153);
		strLbl.setHorizontalAlignment(JLabel.CENTER);
// ★ 실행 이미지 : 빠른 gif
		playLbl.setIcon(psimage);
		playLbl.setHorizontalAlignment(JLabel.CENTER);

// ★ 라벨 설정
		lbl.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		lbl.setBounds(166, 217, 172, 60);
		lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬

// ★ 코인 라벨 셋팅
		coin.setHorizontalAlignment(SwingConstants.CENTER);
		coin.setFont(new Font("나눔고딕", Font.BOLD, 33));
		coin.setBounds(351, 0, 133, 59);

// ★ 가위 옵션 설정
		sLbl.setIcon(simage); // 라벨 아이콘 설정
		sLbl.setHorizontalAlignment(JLabel.CENTER);

// ★ 바위 옵션 설정
		rLbl.setIcon(rimage); // 바위 라벨 아이콘 설정
		rLbl.setHorizontalAlignment(JLabel.CENTER);

// ★ 보 옵션 설정
		bLbl.setIcon(bimage); // 바위 라벨 아이콘 설정
		bLbl.setHorizontalAlignment(JLabel.CENTER);
	
		frm.setSize(500, 500); // 프레임 크기 설정
		frm.setResizable(false); // 창 고정
		frm.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
		frm.setVisible(true);
		start();
	}

	// 가독성을 높이기 위해 코드를 단축01 : gui 호출 파트
	public void guist(String b, boolean btn1, boolean btn2, boolean btn3, boolean btn4)
	{
		this.lbl.setText(b);
		this.btn1.setEnabled(btn1);
		this.btn2.setEnabled(btn2);
		this.btn3.setEnabled(btn3);
		this.btn4.setEnabled(btn4);
	}
	
	// 가독성을 높이기 위해 이미지 호출 파트 : 실행 움직이는 이미지 파트
	public void butonsh(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, 153, 153); // 실행 이미지
		this.sLbl.setBounds(num1, num2, num3, num4); // 가위 이미지
		this.rLbl.setBounds(num1, num2, num3, num4); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, num3, num4); // 보 이미지
	}
	
	// 가독성을 높이기 위해 이미지 호출 파트 : 가위만 보이는 파트
	public void butonsh00(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, num3, num4); // 실행 이미지
		this.sLbl.setBounds(num1, num2, 153, 153); // 가위 이미지
		this.rLbl.setBounds(num1, num2, num3, num4); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, num3, num4); // 보 이미지
	}
	
	// 가독성을 높이기 위해 이미지 호출 파트 : 주먹만 보이는 파트
	public void butonsh01(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, num3, num4); // 실행 이미지
		this.sLbl.setBounds(num1, num2, num3, num4); // 가위 이미지
		this.rLbl.setBounds(num1, num2, 153, 153); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, num3, num4); // 보 이미지
	}
	
	// 가독성을 높이기 위해 이미지 호출 파트 : 보자기만 보이는 파트
	public void butonsh02(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, num3, num4); // 실행 이미지
		this.sLbl.setBounds(num1, num2, num3, num4); // 가위 이미지
		this.rLbl.setBounds(num1, num2, num3, num4); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, 153, 153); // 보 이미지
	}	
	// 가독성을 높이기 위해 이미지 호출 파트 : 가위로 비기는 파트
	public void butonsh03(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, 153, 153); // 실행 이미지
		this.sLbl.setBounds(num1, num2, 153, 153); // 가위 이미지
		this.rLbl.setBounds(num1, num2, num3, num4); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, num3, num4); // 보 이미지
	}
	
	// 가독성을 높이기 위해 이미지 호출 파트 : 주먹으로 비기는 파트
	public void butonsh04(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, 153, 153); // 실행 이미지
		this.sLbl.setBounds(num1, num2, num3, num4); // 가위 이미지
		this.rLbl.setBounds(num1, num2, 153, 153); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, num3, num4); // 보 이미지
	}	
	// 가독성을 높이기 위해 이미지 호출 파트 : 보로 비기는 파트
	public void butonsh05(int num1, int num2, int num3, int num4)
	{
		this.strLbl.setBounds(num1, num2, num3, num4); // 시작 이미지
		this.playLbl.setBounds(num1, num2, 153, 153); // 실행 이미지
		this.sLbl.setBounds(num1, num2, num3, num4); // 가위 이미지
		this.rLbl.setBounds(num1, num2, num3, num4); // 주먹 이미지 
		this.bLbl.setBounds(num1, num2, 153, 153); // 보 이미지
	}	
	
	public static void audio00(String a)
	{
		try
		{
			// TimeUnit.MILLISECONDS.sleep(500);
			File file = new File(a);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			// clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	private void start()
	{
		ActionListener listener = new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				Calendar c = Calendar.getInstance();
				int milliSecond = c.get(Calendar.MILLISECOND);
				System.out.println(milliSecond); // 랜덤 숫자보기
				// Random random = new Random();
				// int cNum = random.nextInt(3);

				if (lifetx >= 1 && (!(lbl.getText().equals("비겼다! 한판 더!"))))
				{
					System.out.println("첫시작");
					guist("가위바위보", true, true, true, false); // 매개변수 호출
					butonsh(174, 65, 0, 0);
					coin.setText("코인 : " + --lifetx);
					if (btn4.equals(e.getSource()))
					{
						audio00("sound/start.wav");
						check = false;

					}

				}
				// 처음 시작: 무엇을 내던지 지는 파트
				if (lbl.getText().equals("가위바위보") && milliSecond >= 500 && 
						(btn1.equals(e.getSource())||btn2.equals(e.getSource())||btn3.equals(e.getSource())))
				{
					if(btn1.equals(e.getSource()))
					{
						guist("졌다!", false, false, false, true);
						audio00("sound/lost01.wav");
						butonsh01(174, 65, 0, 0); // 주먹이 보인다.
						System.out.println("가위로 졌다!!");
					}
					if(btn2.equals(e.getSource()))
					{
						guist("졌다!", false, false, false, true);
						audio00("sound/lost01.wav");
						butonsh02(174, 65, 0, 0); // 보가 보인다.
						System.out.println("바위로 졌다!!");
					}
					if(btn3.equals(e.getSource()))
					{
						guist("졌다!", false, false, false, true);
						audio00("sound/lost01.wav");
						butonsh00(174, 65, 0, 0); // 가위가 보인다.
						System.out.println("보로 졌다!!");
					}

				}
				
				// 비김 이후: 무엇을 내던지 지는 파트
				if (lbl.getText().equals("비겼다! 한판 더!") && milliSecond >= 500 && 
						(btn1.equals(e.getSource())||btn2.equals(e.getSource())||btn3.equals(e.getSource())))
				{
					if(btn1.equals(e.getSource()))
					{
						guist("졌다!", false, false, false, true);
						audio00("sound/lost02.wav");
						butonsh01(174, 65, 0, 0); // 주먹이 보인다.
						System.out.println("비기고 가위로 졌다!!");
					}
					if(btn2.equals(e.getSource()))
					{
						guist("졌다!", false, false, false, true);
						audio00("sound/lost02.wav");
						butonsh02(174, 65, 0, 0); // 보가 보인다.
						System.out.println("비기고 바위로 졌다!!");
					}
					if(btn3.equals(e.getSource()))
					{
						guist("졌다!", false, false, false, true);
						audio00("sound/lost02.wav");
						butonsh00(174, 65, 0, 0); // 가위가 보인다.
						System.out.println("비기고 보로 졌다!!");
					}
				}
				
				
				// 무엇을 내던지 비기는 파트
				if (milliSecond >= 200 && milliSecond < 500
						&& (btn1.equals(e.getSource())||btn2.equals(e.getSource())||btn3.equals(e.getSource())))
				{
					if(btn1.equals(e.getSource()))
					{
						butonsh03(174, 65, 0, 0); // 가위와 움직임 이미지 출력
						audio00("sound/Same01.wav"); 
						guist("비겼다! 한판 더!", true, true, true, false);
						System.out.println("가위로 비긴 상태!!");		
					}
					if(btn2.equals(e.getSource()))
					{
						butonsh04(174, 65, 0, 0); // 바위와 움직임 이미지 출력
						audio00("sound/Same01.wav"); 
						guist("비겼다! 한판 더!", true, true, true, false);
						System.out.println("주먹으로 비긴 상태!!");		
					}
					if(btn3.equals(e.getSource()))
					{
						butonsh05(174, 65, 0, 0); // 보와 움직임 이미지 출력
						audio00("sound/Same01.wav");
						guist("비겼다! 한판 더!", true, true, true, false);
						System.out.println("보로 비긴 상태!!");		
					}
				}

				// 처음 시작: 무엇을 내던지 이기는 파트
				if (milliSecond >= 0 && milliSecond < 200 && lbl.getText().equals("가위바위보")
						&& (btn1.equals(e.getSource())||btn2.equals(e.getSource())||btn3.equals(e.getSource())))
				{
					if(btn1.equals(e.getSource()))
					{
						butonsh02(174, 65, 0, 0); // 보자기 이미지 출력
						audio00("sound/Win01.wav");
						guist("이겼다!", false, false, false, true);
						System.out.println("가위로 이겼다.");
					}
					if(btn2.equals(e.getSource()))
					{
						butonsh00(174, 65, 0, 0); // 가위 이미지 출력
						audio00("sound/Win01.wav");
						guist("이겼다!", false, false, false, true);
						System.out.println("바위로 이겼다.");
					}
					if(btn3.equals(e.getSource()))
					{
						butonsh01(174, 65, 0, 0); // 바위 이미지 출력
						audio00("sound/Win01.wav");
						guist("이겼다!", false, false, false, true);
						System.out.println("보로 이겼다.");
					}
				}
				// 비김: 가위를 냈더니 이김
				if (milliSecond >= 0 && milliSecond < 200 && lbl.getText().equals("비겼다! 한판 더!")
						&& (btn1.equals(e.getSource())||btn2.equals(e.getSource())||btn3.equals(e.getSource())))
				{
					if(btn1.equals(e.getSource()))
					{
						butonsh02(174, 65, 0, 0); // 보자기 이미지 출력
						audio00("sound/Win02.wav");
						guist("이겼다!", false, false, false, true);
						System.out.println("비기고 가위로 이겼다.");
					}
					if(btn2.equals(e.getSource()))
					{
						butonsh00(174, 65, 0, 0); // 가위 이미지 출력
						audio00("sound/Win02.wav");
						guist("이겼다!", false, false, false, true);
						System.out.println("비기고 바위로 이겼다.");
					}
					if(btn3.equals(e.getSource()))
					{
						butonsh01(174, 65, 0, 0); // 바위 이미지 출력
						audio00("sound/Win02.wav");
						guist("이겼다!", false, false, false, true);
						System.out.println("비기고 보로 이겼다.");
					}
				}

			}
		};
		btn4.addActionListener(listener);
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
	}
}