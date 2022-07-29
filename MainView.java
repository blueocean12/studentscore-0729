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
			System.out.println("******************1. ��ȭ��ȣ��*********************");
			System.out.println("******************2. �л� ����*********************");
			System.out.println("******************3. ���α׷� ����******************");
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("�޴� ���� : ");

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
			System.out.println("��ȭ��ȣ�� Ȯ��");
			(new CallBookView()).showView();

			//				CallBookView callBookView = new CallBookView();
			//				callBookView.showView();


			//				MainView.ShowCallBookView();
			break;
		case Constant.SHOW_MANAGEMENT_STUDENT : 
			System.out.println("�л� ���� Ȯ��");
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
