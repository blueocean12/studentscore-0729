package view;


//������ = �������̽�
public interface View {
	public void showView();
	public boolean menuHandling(int menuNumber);
	
	default void wrongMenuSelected() {
		System.out.println("�޴��� �߸� �����߽��ϴ�.");
		System.out.println("�ٽ� �������ּ���.");
		
	}

}
