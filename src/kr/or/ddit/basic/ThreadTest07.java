package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 문제) 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
     - 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
     - 사용자는 showInputDialog()메서드를 이용해서 입력 받는다.
     - 입력시간은 5초로 제한 입력시간 초과시 게임에서 진것으로 처리하고 종료
     - 5초안에 입력하면 승패를 구해서 출력한다.
 5초안에 입력이 완료되었을때  결과 예시) 
     -- 결과 예시 -- 
     컴퓨터 : 가위
     사용자 : 바위
     결   과 : 당신이 이겼습니다.
   5초안에 입력이 없었을때 결과 예시
     시간이 초과되어 당신이 졌습니다.
 */
public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new rcpPut();
		Thread th2 = new rcpCountDown();

		th1.start();
		th2.start();
	}

}

class rcpPut extends Thread {
	public static boolean inputCheck;

	@Override
	public void run() {

		int com = (int) (Math.random() * 3 + 1);

		String str = JOptionPane.showInputDialog("가위 바위 보 입력");
		inputCheck = true;
		if (com == 1) {
			System.out.println("컴퓨터 : ✌");
		} else if (com == 2) {
			System.out.println("컴퓨터 : ✊");
		} else if (com == 3) {
			System.out.println("컴퓨터 : ✋");
		}
		if (str.equals("가위") && com == 1) {
			System.out.println("사용자 : " + str);
			System.out.println("비겼습니다.");
		} else if (str.equals("가위") && com == 2) {
			System.out.println("사용자 : " + str);
			System.out.println("당신이 발렸습니다.");
		} else if (str.equals("가위") && com == 3) {
			System.out.println("사용자 : " + str);
			System.out.println("당신이 이겼습니다 ㅊㅋㅊㅋ");
		}
		if (str.equals("바위") && com == 1) {
			System.out.println("사용자 : " + str);
			System.out.println("당신이 이겼습니다 ㅊㅋㅊㅋ");
		} else if (str.equals("바위") && com == 2) {
			System.out.println("사용자 : " + str);
			System.out.println("비겼습니다.");
		} else if (str.equals("바위") && com == 3) {
			System.out.println("사용자 : " + str);
			System.out.println("당신이 발렸습니다.");
		}
		if (str.equals("보") && com == 1) {
			System.out.println("사용자 : " + str);
			System.out.println("당신이 발렸습니다.");
		} else if (str.equals("보") && com == 2) {
			System.out.println("사용자 : " + str);
			System.out.println("당신이 이겼습니다ㅊㅋㅊㅋ");

			System.out.println("사용자 : " + str);
			System.out.println("비겼습니다.");
		}
	}

}

class rcpCountDown extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if (rcpPut.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("5초 경과 발렸습니다");
		System.exit(1);
	}
}