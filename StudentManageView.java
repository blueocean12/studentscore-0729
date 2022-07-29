package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentManageController;
import dto.StudentDTO;
import util.Constant;

public class StudentManageView implements View{

	@Override
	public void showView() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println("*****************************************************");
			System.out.println("******************1. �л� ��ü ��ȸ*********************");
			System.out.println("******************2. �л� �˻� ��ȸ*********************");
			System.out.println("******************3. �л� �ű� �߰�*********************");
			System.out.println("******************4. �л� ����*************************");
			System.out.println("******************5. �л� ����*************************");
			System.out.println("******************6. �л� ���� ��ȸ*********************");
			System.out.println("******************7. �л� ���� �Է�*********************");
			System.out.println("******************8. �л� ���� ����*********************");
			System.out.println("******************9. �л� ���� ����*********************");
			System.out.println("******************10. ���α׷� ����*********************");
			System.out.println("*****************************************************");
			System.out.println("�޴� ���� : ");

			int menuNumber = scanner.nextInt();


			if(this.menuHandling(menuNumber)) {
				break;
			}



		}
	}

	@Override
	public boolean menuHandling(int menuNumber) {
		// TODO Auto-generated method stub

		boolean isMenuExit = false;
		switch(menuNumber) {
		case Constant.SELECT_ALL_STUDENT :
			System.out.println("�л� ��ü ��ȸ");
			StudentManageView.selectAllStudent();
			break;
		case Constant.SEARCH_STUDENT :
			System.out.println("�л� �˻� ��ȸ");
			StudentManageView.searchStudent();
			break;
		case Constant.INSERT_STUDENT :
			System.out.println("�л� �߰� �Է�");
			StudentManageView.insertStudent();
			break;
		case Constant.UPDATE_STUDENT :
			System.out.println("�л� ����");
			StudentManageView.updateStudent();
			break;
		case Constant.DELETE_STUDENT :
			System.out.println("�л� ����");
			StudentManageView.deleteStudent();
			break;
		case Constant.SEARCH_STUDENT_SCORE :
			System.out.println("�л� ���� ��ȸ");
			StudentManageView.searchStudentScore();
			break;
		case Constant.INSERT_STUDENT_SCORE :
			System.out.println("�л� ���� �Է�");
			StudentManageView.insertStudentScore();
			break;
		case Constant.UPDATE_STUDENT_SCORE :
			System.out.println("�л� ���� ����");
			StudentManageView.updateStudentScore();
			break;
		case Constant.DELETE_STUDENT_SCORE :
			System.out.println("�л� ���� ����");
			//			StudentManageView.deleteStudentScore();
			break;
		case Constant.CLOSE_PROGRAM :
			isMenuExit = true;

			break;
		default :
			wrongMenuSelected();
			break;
		}

		return isMenuExit;
	}

	public static void insertStudent() {
		Scanner scanner = new Scanner(System.in);
		//studentDTO��� �ν��Ͻ��� �Ʒ��� �����ض�
		StudentDTO studentDTO = new StudentDTO();


		//		System.out.println("�й� �Է� : ");
		//		String setStudentId = scanner.next();
		//		studentDTO.setStudentId(setStudentId);

		//���� �Է��� ������ �й��� �߰�

		System.out.println("�̸� �Է� : ");
		String setName = scanner.next();
		studentDTO.setName(setName);

		System.out.println("�г� �Է� : ");
		int setGrade = scanner.nextInt();
		studentDTO.setGrade(setGrade);

		System.out.println("���� �Է� : ");
		int setBirthday = scanner.nextInt();
		studentDTO.setBirthday(setBirthday);

		//		studentDTO.printStudentinfo();
		//��Ʈ�ѷ��� �����Ѵ�.
		StudentManageController.insertStudent(studentDTO);

	}



	public static void selectAllStudent() {
		System.out.println("----------------��� �л� ��ȸ---------------");
		ArrayList<StudentDTO> studentManageList = StudentManageController.selectAllStudent();
		for(int i = 0 ; i < studentManageList.size(); i++ ) {
			studentManageList.get(i).printStudentinfo();
		}
	}

	public static void searchStudent() {
		System.out.println("-------------------�л�  �˻�----------------");
		System.out.println("ã���� �ϴ� �л� �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String findStudentName = scanner.next();
		StudentDTO studentDTO = StudentManageController.searchStudent(findStudentName);

		if(studentDTO.getName() != null) {
			studentDTO.printStudentinfo();
		}
		else {
			System.out.println("��ġ�ϴ� �л��� �����ϴ�.");
		}
	}

	public static void updateStudent() {
		Scanner scanner = new Scanner(System.in);
		StudentDTO updateinfo = new StudentDTO();
		System.out.println("-----------------�л� ����-----------------");
		System.out.println("ã���� �ϴ� �л� �Է� : ");
		String findStudentName = scanner.next();

		StudentDTO temp = StudentManageController.searchStudent(findStudentName);
		if(temp.getName() != null) {
			System.out.println("������ �̸� �Է� : ");
			updateinfo.setName(scanner.next());
			System.out.println("������ �г� �Է� : ");
			updateinfo.setGrade(scanner.next());
			System.out.println("������ ���� �Է� : ");
			updateinfo.setBirthday(scanner.next());

			StudentDTO studentDTO = StudentManageController.updateStudent(findStudentName, updateinfo);
			studentDTO.printStudentinfo();
		}
		else {
			System.out.println("��ġ�ϴ� �л��� �����ϴ�.");
		}

	}


	public static void deleteStudent() {
		System.out.println("-----------------�л� ����-----------------");
		System.out.println("������ �л� �̸� �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String findStudentName = scanner.next();

		StudentDTO studentDTO = StudentManageController.deleteStudent(findStudentName);

		if(studentDTO.getName() != null) {
			System.out.println("���������� �����Ǿ����ϴ�. ");

		}
		else {
			System.out.println("��ġ�ϴ� �л��� �����ϴ�. ");
		}
	}


	public static void insertStudentScore() {
		Scanner scanner = new Scanner(System.in);
		StudentDTO studentDTO = new StudentDTO();

		System.out.println("�й� �Է� : ");
		String studentId = scanner.next();
		studentDTO.setStudentId(studentId); // �й��� �Է��ϴ� ��

		System.out.println("���� ���� �Է� :");
		String koreanScore = scanner.next();
		studentDTO.setKoreanScore(koreanScore);

		System.out.println("���� ���� �Է� :");
		String englishScore = scanner.next();
		studentDTO.setEnglishScore(englishScore);

		System.out.println("���� ���� �Է� :");
		String mathScore = scanner.next();
		studentDTO.setMathScore(mathScore);

		System.out.println("���� ���� �Է� :");
		String scienceScore = scanner.next();
		studentDTO.setScienceScore(scienceScore);
		//
		//		studentDTO.printStudentinfo();
		StudentManageController.insertStudentScore(studentDTO);

	}

	public static void searchStudentScore() {
		System.out.println("��ȸ ��� �̸� �Է� : ");
		Scanner scanner = new Scanner(System.in); // ��ĳ�ʷ� �Է¹޴´�
		
		String findStudentName = scanner.next(); // findStudentName�� ����ȴ�?

		StudentDTO studentDTO = StudentManageController.searchStudentScore(findStudentName); //

		if(studentDTO.getName() != null) { 

			System.out.println("��ȸ�� " + findStudentName + "�� ������ ������ �����ϴ�.");
			System.out.println("���� ����: " + studentDTO.getKoreanScore());
			System.out.println("���� ����: " + studentDTO.getEnglishScore());
			System.out.println("���� ����: " + studentDTO.getMathScore());
			System.out.println("���� ����: " + studentDTO.getScienceScore());
			
//			if(�̸�  = �̸� ) {
//				System.out.println("��ȸ ��� �̸� �Է� : " + );
//			}
//			
		}
		else {
			System.out.println("��ġ�ϴ� �л��� �����ϴ�.");
		}


		//if ���������� ���� ��� (�̸��� ���� ���)
		//�� �� ǥ���� �� �ֵ��� �Ͽ���


	}
	public static void updateStudentScore() {
		Scanner scanner = new Scanner(System.in);
		StudentDTO updateinfo = new StudentDTO();
		System.out.println("-----------------�л� ����-----------------");
		System.out.println("ã���� �ϴ� �й� �Է� : ");
		String findStudentId = scanner.next();
		
//		StudentDTO result = StudentManageController.updateStudentScore(findStudentId, updateinfo);
//		studentDTO.printStudentinfo();
		
		
		StudentDTO temp = StudentManageController.searchStudentScore(findStudentId);
		if(String.valueOf(temp.getStudentId()) != null ) {
			//student�й� = ������ �Էµ� �й�
			System.out.println("������ ���� ���� �Է� : ");
			updateinfo.setKoreanScore(scanner.next());
			System.out.println("������  ���� ���� �Է� : ");
			updateinfo.setEnglishScore(scanner.next());
			System.out.println("������ ���� ���� �Է� : ");
			updateinfo.setMathScore(scanner.next());
			System.out.println("������ ���� ���� �Է� : ");
			updateinfo.setScienceScore(scanner.next());
			StudentDTO result = StudentManageController.updateStudentScore(updateinfo);
			result.printStudentinfo();
			
		}
		else {
			System.out.println("��ġ�ϴ� �л��� �����ϴ�.");
		}

	}




}
