package kr.or.ddit.basic;

import java.util.Arrays;

/*
 문제) 10마리의 말들이 경주하는 경마 프로그램 작성하기
      
           경주마는 Horse 라는 이름의 클래스로 구성하고 
           이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
           그리고, 이 클래스에는 등수를 오름차순으로 처리하는 내부 정렬 기준이 있다.
            (Comparable 인터페이스 구현하기)
      - 이 Horse 클래스는 쓰레드로 작성한다.
      
      - 경기 구간은 1 ~ 50구간으로 되어 있다.
      
      - 경기 중 중간 중간에 각 말들의 위치를 나타내시오.
      
      예)
      01번말 : ->--------------------------------------------
      02번말 : ----->----------------------------------------
      03번말 : --------------------------------------->------
      
      -경기가 끝나면 등수 순으로 경기 결과를 출력한다.
 */
public class ThreatTest13 {

	public static void main(String[] args) {
		DisplayHorse[] players = new DisplayHorse[] { new DisplayHorse("1번말"), new DisplayHorse("2번말"),
				new DisplayHorse("3번말") };

		for (DisplayHorse player : players) {
			player.start();
		}

		for (DisplayHorse player : players) {
			try {
				player.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		System.out.println();
		System.out.println("경기 결과 : " + DisplayHorse.rank);

	}

}

class DisplayHorse extends Thread {
	public static String rank = ""; // 빨리 출력한 순서대로 저장할 변수 선언
	private String name;

	// 생성자
	public DisplayHorse(String name) {
		this.name = name;

	}

	@Override
	public void run() {
		String ne = "";
		int loc = 0;
		// for (int i = 0; i < 50; i++) {
		// ne += "-";
		// }

		for (int i = 0; i < 50; i++) {
			loc++;
			for (int j = 0; j < 50; j++) {
				if (j == loc) {
					ne += ">";
				} else {
					ne += "-";
				}
			}

			System.out.println(name + ne);

			// int loc = 0;
			// for (int i = 0; i < 50; i++) {
			// if(loc== 1) {
			// System.out.print("-");
			// }

			try {

				Thread.sleep((int) (Math.random() * 500 + 100));
			} catch (InterruptedException e) {

			}

		} // for문
		System.out.println(name + " 도착");
		DisplayHorse.rank += name + "   ";
	}
}