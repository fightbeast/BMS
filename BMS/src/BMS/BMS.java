package BMS;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*

;public class BMS {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bms";
	static final  String USER = "root";
	static final String PASS = "gaodiaoai";

	
	
	static Connection conn;
	public static void main(String[] args) {
		
		try{
			//ע��JDBC��������
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ�URL�ƶ� �������Ӷ���
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("**************************************************************");
		System.out.println("\t\t\tͼ�����ϵͳ");
		System.out.println("**************************************************************");
		
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n1.��ѯ  2.����  3.����  4.��� 5.����֤���� 0.�˳�ϵͳ");
			System.out.print("���������ţ�");
			int choice = reader.nextInt();
			switch(choice)
			{
			case 0:
				conn.close();
				return;
			case 1:
				Check_Book();
				break;
			case 2:
				Borrow_Book();
				break;
			case 3:
				Return_Book();
				break;
			case 4:
				Add_Book();
				break;
			case 5:
				Proof_Manag();
				break;
			default:
				System.out.println("�����Ŵ���");
			}
			
			
		}
			
		}catch (SQLException e) {
            System.out.println("MySQL��������");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
	}
	



	private static void Check_Book() throws SQLException {
		String query;
		int choice = 0;
		
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n������ѡ�����	��ѯ����");
			System.out.println("1.��ѯ���йݲ� 2.����������ѯ 3.��������ѯ 4.���������ѯ 5.����ݲ�ѯ 6.�����߲�ѯ 7.���۸��ѯ 0.�˳�");
			System.out.print("����������:");
			choice = reader.nextInt();
			switch(choice)
			{
			case 0:
				return;
			case 1:
				query = "select * from book";
				
				Statement stmt = conn.createStatement();
				ResultSet rset =stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 2:
				System.out.println("����������");
				Scanner title = new Scanner(System.in);
				query = "select * from book where title ="+"'"+title.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 3:
				System.out.println("���������");
				Scanner category = new Scanner(System.in);
				query = "select * from book where category ="+"'"+category.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 4:
				System.out.println("�����������");
				Scanner press  = new Scanner(System.in);
				query = "select * from book where press ="+"'"+press.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 5:
				System.out.println("�������������(������С��ݣ��Իس�����)");
				Scanner year  = new Scanner(System.in);
				query = "select * from book where year >="+year.nextLine()+" and year <="+year.nextLine();	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 6:
				System.out.println("������������");
				Scanner author  = new Scanner(System.in);
				query = "select * from book where author ="+"'"+author.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;	
			case 7:
				System.out.println("������۸�����(������С�۸��Իس�����)");
				Scanner price  = new Scanner(System.in);
				query = "select * from book where price >="+price.nextLine()+" and price <="+price.nextLine();	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("��ѯ�������:");
				System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;	
				default:
					System.out.println();
				
			}
			
		}
		
	}
	
	private static void Borrow_Book() throws SQLException {
		SimpleDateFormat Date = new SimpleDateFormat("yyyyMMdd");
		Calendar calendarT = Calendar.getInstance(Locale.CHINA);
		calendarT.add(Calendar.MONTH, +2);
		String query;
		String cno;		
		Scanner reader = new Scanner(System.in);
		while(true){
		System.out.println("\n������ѡ�����	�������");
		System.out.println("���������֤��ţ���0�˳���");
		cno = reader.next();
		if(cno.equals("0")) break;
		else
		{query="select * from book where bno=any(select bno from borrow where cno='"+cno+"');";
		Statement stmt = conn.createStatement();
		ResultSet rset =stmt.executeQuery(query);
		System.out.println("��������Щ��:");
		System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
		System.out.println("******************************************************************************************");
		while(rset.next()){
			System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
					"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
					rset.getInt("total")+"\t"+rset.getInt("stock"));
		}
		System.out.println("��������Ҫ���������");
		Scanner reader2 = new Scanner(System.in);
		String bno =reader2.next();
		query = "select stock from book where bno="+"'"+bno+"'";
		rset =stmt.executeQuery(query);
		if(rset.next()){
			if(rset.getInt("stock")>0){

				int borrowdate = Integer.parseInt(Date.format(Calendar.getInstance().getTime()));
				int returndate = Integer.parseInt(Date.format(calendarT.getTime()));
				String sql = "insert into borrow values('"+cno+"','"+bno+"',"+borrowdate+","+returndate+")";
				PreparedStatement   pre = conn.prepareStatement(sql);   
				pre.executeUpdate();
				sql = "update book SET stock = stock-1 WHERE bno='"+bno+"';";
			    pre = conn.prepareStatement(sql);   
				pre.executeUpdate();
				System.out.println("����ɹ�");
			}
			else
			{query = "select min(return_date) from borrow where bno='"+bno+"';";
			rset =stmt.executeQuery(query);
			while(rset.next()){
			System.out.println("��ʱ�޿�棬����Ĺ黹ʱ��Ϊ"+rset.getInt("min(return_date)"));
			}
			}
		}
		else System.out.println("��Ҫ���ȣ�û�Ǳ���");
		stmt.close();
		}
		}
	}
	
	private static void Return_Book() throws SQLException {
		String query;
		String cno;		
		Scanner reader = new Scanner(System.in);
		while(true){
		System.out.println("\n������ѡ�����	�������");
		System.out.println("���������֤��ţ���0�˳���");
		cno = reader.next();
		if(cno.equals("0")) break;
		else
		{query="select * from book where bno=any(select bno from borrow where cno='"+cno+"');";
		Statement stmt = conn.createStatement();
		ResultSet rset =stmt.executeQuery(query);
		System.out.println("��������Щ��:");
		System.out.println("���\t���\t\t����\t\t������\t\t���\t����\t�۸�\t�ܲ�����\t���");
		System.out.println("******************************************************************************************");
		while(rset.next()){
			System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
					"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
					rset.getInt("total")+"\t"+rset.getInt("stock"));
		}
		System.out.println("��������Ҫ����������");
		Scanner reader2 = new Scanner(System.in);
		String bno =reader2.next();
		query = "select * from borrow where bno="+"'"+bno+"' and cno='"+cno+"'";
		rset =stmt.executeQuery(query);
		if(rset.next()){

				String sql = "DELETE FROM borrow where bno="+"'"+bno+"' and cno='"+cno+"'";
				PreparedStatement   pre = conn.prepareStatement(sql);   
				pre.executeUpdate();
				sql = "update book SET stock = stock+1 WHERE bno='"+bno+"';";
				pre = conn.prepareStatement(sql);   
				pre.executeUpdate();
				System.out.println("����ɹ�");	
			}
		else System.out.println("��Ҫ���ȣ���û���Ǳ���");	
		}
		}
		}
		
	private static void Add_Book() throws Exception {
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n������ѡ�����	������");
			System.out.println("\n1.������� 2.������� 0.�˳�");
			System.out.print("���������ţ�");
			int choice = reader.nextInt();
	   switch(choice)
			{
	    case 0:
	    	return;
		case 1:		
		System.out.println("���������룺��� ��� ���� ������ ��� ���� �۸� �ܲ����� ��棨�ûس����֣�");
		Scanner book  = new Scanner(System.in);
		String sql = "insert into book values('"+book.nextLine()+"','"+book.nextLine()+"','"+book.nextLine()+"','"+book.nextLine()+"',"+
		book.nextLine()+",'"+book.nextLine()+"',"+book.nextLine()+","+book.nextLine()+","+book.nextLine()+")";
		PreparedStatement   pre = conn.prepareStatement(sql);   
		pre.executeUpdate();

			break;
		
		case 2:
		
		final String path = "D:\\eclipse\\D��\\workspace\\BMS\\FC.txt";  
		  
	    final String openFileStyle = "r";  
	  
	    final String fieldLimitChar = ",";  
	  
	    final int fieldAllCount = 9;    
	  
	    String bno;  
	  
	    String category;  
	  
	    String title;  
	  
	    String press;  
	  
	    String year;  
	  
	    String author;  
	  
	    String price;  
	  
	    String total;
	    
	    String stock;
	    
	    int count = 0;
	    
	    RandomAccessFile raf = new RandomAccessFile(path, openFileStyle);  
	    
        String line_record = raf.readLine();  

        while (line_record != null) {  

            // ����ÿһ����¼  
        	String[] fields = line_record.split(fieldLimitChar);  
  		  
            if (fields.length == fieldAllCount) {  
      
            	bno = tranStr(fields[0]);  
      
            	category = tranStr(fields[1]);  
      
            	title = tranStr(fields[2]);  
      
            	press = tranStr(fields[3]);  
      
            	year = tranStr(fields[4]);  
      
            	author = tranStr(fields[5]);  
      
            	price = tranStr(fields[6]);  
      
            	total = tranStr(fields[7]);  
      
            	stock = tranStr(fields[8]);  
        
                   
				count++;  
    			sql = "insert into book values('"+bno+"','"+category+"','"+title+"','"+press+"',"+
    					year+",'"+author+"',"+price+","+total+","+stock+")";
				pre = conn.prepareStatement(sql);   
				pre.executeUpdate();
            line_record = raf.readLine();  

        }  

        

        }System.out.println("���кϷ��ļ�¼" + count + "��");  
        break;	

			}
		}
	}

	private static void Proof_Manag() throws SQLException {
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n������ѡ�����	����֤����");
			System.out.println("\n1.���� ����֤2.ɾ������֤ 0.�˳�");
			System.out.print("���������ţ�");
			int choice = reader.nextInt();
			switch(choice)
			{
				case 0:
					return;
				case 1:		
					System.out.println("���������룺���ţ���������λ�����T����ʦ��S��ѧ�������ûس����֣�");
					Scanner card  = new Scanner(System.in);
					String sql = "insert into card values('"+card.nextLine()+"','"+card.nextLine()+"','"+card.nextLine()+"','"+card.nextLine()+"')";
					PreparedStatement   pre = conn.prepareStatement(sql);   
					pre.executeUpdate();
				break;
				case 2:
					String query = "select * from card";
					Statement stmt = conn.createStatement();
					ResultSet rset =stmt.executeQuery(query);
					System.out.println("ȫ������֤:");
					System.out.println("֤��\t����\t��λ\t���");
					System.out.println("******************************************************************************************");
					while(rset.next()){
						System.out.println(rset.getString("cno")+"\t"+rset.getString("name")+"\t"+rset.getString("department")+"\t"+rset.getString("type"));
					}
					System.out.println("����������Ҫɾ���Ŀ���");
					Scanner card1  = new Scanner(System.in);
					sql = "DELETE FROM card where cno='"+card1.next()+"'";
					pre = conn.prepareStatement(sql);   
					pre.executeUpdate();
				break;
			}
	}
	}
	public static String tranStr(String oldstr) {  
		  
        String newstr = "";  
  
        try {  
  
            newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");  
  
        } catch (UnsupportedEncodingException e) {  
  
            e.printStackTrace();  
  
        }  
  
        return newstr;  
  
    }  
}
