import java.util.Scanner;

public class Tms {
	private Teacher[] tcs;
	private int index;	

	
	public Tms(){
		tcs = new Teacher[6];
		index = 0;
	}

	
	public void save(Teacher tcs){
	
		if(index >= tcs.length){
			Teacher[] demo = new Teacher[tcs.length + 3];
			
			System.arraycopy(tcs,0,demo,0,index);
			tcs = demo;
		}
		tcs[index++] = tc;
	}

	
	public Teacher[] queryAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(tcs,0,demo,0,index);
		return demo;
	}

	public Teacher queryById(long id){
		
		int num = getIndexById(id);
		return num == -1?null:tcs[num];
	}

	
	private int getIndexById(long id){
		int num = -1;
		for(int i=0;i<index;i++){
			if(tcs[i].getId() == id){
				num = i;
				break;
			}
		}
		return num;
	}
	
	
	
    public void update(Teacher newTc){
		for(int i=0;i<index;i++){
			if(newTc.getId() == tcs[i].getId()){
				tcs[i].setName(newTc.getName());
				tcs[i].setAge(newTc.getAge());
			}
		}
	}
		
		
	
	public void deleteById(long id){
		int num = getIndexById(id);
		for(int i=num;i<index-1;i++){
			tcs[i] = tcs[i+1];
		}
		tcs[--index] = null;
	}
	
	public void menu(){
		System.out.println("******��ʦ����ϵͳ******");
		System.out.println("*1. ��ѯ���н�ʦ��Ϣ");
		System.out.println("*2. ¼���ʦ��Ϣ");
		System.out.println("*3. ɾ����ʦ��Ϣ");
		System.out.println("*4. ��ѯ������ʦ��Ϣ");
		System.out.println("*5. �޸Ľ�ʦ��Ϣ");
		System.out.println("*exit. �˳�");
		System.out.println("*help. ����");
		System.out.println("************************");
	}
	
	public static void main(String[] args){
		Tms tms = new Tms();
		tms.menu();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("�����빦�ܱ�ţ�");
			String option = sc.nextLine();
			
			switch(option){
				case "1":
					System.out.println("�����ǽ�ʦ����Ϣ��");
					Teacher[] arr = tms.queryAll();
					for(int i=0;i<arr.length;i++){
						System.out.println(arr[i]);
					}
					System.out.println("�ܼ� "+sms.index+" ��");
					break;
				case "2":
					while(true){
						System.out.println("�������ʦ��Ϣ��id#name#age���������롾break��������һ��Ŀ¼");
						String tcStr = sc.nextLine();
						if(tcStr.equals("break")){
							break;
						}
						String[] tcArr = tcStr.split("#");
						long id = Long.parseLong(tcArr[0]);
						String name = tcArr[1];
						int age = Integer.parseInt(tcArr[2]);
						Teacher tc = new Teacher(id,name,age);
						Tms.save(tc);
						System.out.println("����ɹ���");
					}
					
					break;
				case "3":
					while(true){
						System.out.println("������Ҫɾ����ʦ�ı�Ż������롾break��������һ��Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher oldTc = tms.queryById(id);
						if(oldTc == null){
							System.out.println("��Ҫɾ���Ľ�ʦ�����ڣ�");
							continue;
						}
						Tms.deleteById(id);
						System.out.println("ɾ���ɹ���");
					}
					break;
				case "4":
					while(true){
						System.out.println("�������Ż������롾break��������һ��Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						long id = Long.parseLong(idStr);
						Teahcer tc = Tms.queryById(id);
						System.out.println(tc==null?"Sorry,Not Found!":stu);
					}
					break;
				case "5":
					while(true){
						System.out.println("������Ҫ�޸Ľ�ʦ��Ż������롾break��������һ��Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher oldTc = Tms.queryById(id);
						if(oldTc == null){
							System.out.println("��Ҫ�޸ĵĽ�ʦ�����ڣ�");
							continue;
						}
						System.out.println("ԭ����ϢΪ��"+oldTc);
						System.out.println("��������Ϣ��name#age��");
						String newStr = sc.nextLine();
						String[] newArr = newStr.split("#");
						String name = newArr[0];
						int age = Integer.parseInt(newArr[1]);

						Teacher newTc = new Teacher(id,name,age);
						Tms.update(newTc);
						System.out.println("�޸ĳɹ�");
					}
					break;
				case "exit":
					System.out.println("�ټ�,��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				case "help":
					Tms.menu();
					break;
				default:
					System.out.println("���Ϸ����룡");

			}
		}
	}