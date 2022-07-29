package view;

import java.util.Scanner;

import util.Constant;


public class MainView implements View{

	@Override
	public void showView() {
		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println();
			
			
			
			
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("******************1. 전화번호부*********************");
			System.out.println("******************2. 학생 관리*********************");
			System.out.println("******************3. 프로그램 종료******************");
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("메뉴 선택 : ");

			int menuNumber = scanner.nextInt();
			

			if(this.menuHandling(menuNumber)) {
				break;

			}


		}
	}

	@Override
	public boolean menuHandling(int menuNumber) {
		boolean isMenuExit = false;
		switch(menuNumber) {
		case Constant.SHOW_CALLBOOKVIEW : 
			System.out.println("전화번호부 확인");
			(new CallBookView()).showView();

			//				CallBookView callBookView = new CallBookView();
			//				callBookView.showView();


			//				MainView.ShowCallBookView();
			break;
		case Constant.SHOW_MANAGEMENT_STUDENT : 
			System.out.println("학생 관리 확인");
			(new StudentManageView()).showView();
//			MainView.ManagementStudent();
			break;
			
		case Constant.MAIN_MENU_EXIT : 
			isMenuExit = true;
			break;


		default :
			wrongMenuSelected();
			break;

		}


		return isMenuExit;







	}


}
