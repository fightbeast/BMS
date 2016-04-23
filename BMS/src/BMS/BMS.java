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
			//注册JDBC驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//数据库URL制定 创建连接对象
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("**************************************************************");
		System.out.println("\t\t\t图书管理系统");
		System.out.println("**************************************************************");
		
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n1.查询  2.借书  3.还书  4.入库 5.借阅证管理 0.退出系统");
			System.out.print("请输入服务号：");
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
				System.out.println("服务编号错误");
			}
			
			
		}
			
		}catch (SQLException e) {
            System.out.println("MySQL操作错误");
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
			System.out.println("\n您现在选择的是	查询服务");
			System.out.println("1.查询所有馆藏 2.按照书名查询 3.按照类别查询 4.按出版社查询 5.按年份查询 6.按作者查询 7.按价格查询 0.退出");
			System.out.print("请输入服务号:");
			choice = reader.nextInt();
			switch(choice)
			{
			case 0:
				return;
			case 1:
				query = "select * from book";
				
				Statement stmt = conn.createStatement();
				ResultSet rset =stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 2:
				System.out.println("请输入书名");
				Scanner title = new Scanner(System.in);
				query = "select * from book where title ="+"'"+title.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 3:
				System.out.println("请输入类别");
				Scanner category = new Scanner(System.in);
				query = "select * from book where category ="+"'"+category.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 4:
				System.out.println("请输入出版社");
				Scanner press  = new Scanner(System.in);
				query = "select * from book where press ="+"'"+press.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 5:
				System.out.println("请输入年份区间(先输入小年份，以回车区分)");
				Scanner year  = new Scanner(System.in);
				query = "select * from book where year >="+year.nextLine()+" and year <="+year.nextLine();	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;
			case 6:
				System.out.println("请输入作者名");
				Scanner author  = new Scanner(System.in);
				query = "select * from book where author ="+"'"+author.next()+"'";	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
				System.out.println("******************************************************************************************");
				while(rset.next()){
					System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
							"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
							rset.getInt("total")+"\t"+rset.getInt("stock"));
				}
				stmt.close();
				break;	
			case 7:
				System.out.println("请输入价格区间(先输入小价格，以回车区分)");
				Scanner price  = new Scanner(System.in);
				query = "select * from book where price >="+price.nextLine()+" and price <="+price.nextLine();	
				stmt = conn.createStatement();
				rset=stmt.executeQuery(query);
				System.out.println("查询结果如下:");
				System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
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
		System.out.println("\n您现在选择的是	借书服务");
		System.out.println("请输入借阅证编号（按0退出）");
		cno = reader.next();
		if(cno.equals("0")) break;
		else
		{query="select * from book where bno=any(select bno from borrow where cno='"+cno+"');";
		Statement stmt = conn.createStatement();
		ResultSet rset =stmt.executeQuery(query);
		System.out.println("您借了这些书:");
		System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
		System.out.println("******************************************************************************************");
		while(rset.next()){
			System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
					"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
					rset.getInt("total")+"\t"+rset.getInt("stock"));
		}
		System.out.println("输入你想要借的书的书号");
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
				System.out.println("借书成功");
			}
			else
			{query = "select min(return_date) from borrow where bno='"+bno+"';";
			rset =stmt.executeQuery(query);
			while(rset.next()){
			System.out.println("暂时无库存，最近的归还时间为"+rset.getInt("min(return_date)"));
			}
			}
		}
		else System.out.println("不要卖萌，没那本书");
		stmt.close();
		}
		}
	}
	
	private static void Return_Book() throws SQLException {
		String query;
		String cno;		
		Scanner reader = new Scanner(System.in);
		while(true){
		System.out.println("\n您现在选择的是	还书服务");
		System.out.println("请输入借阅证编号（按0退出）");
		cno = reader.next();
		if(cno.equals("0")) break;
		else
		{query="select * from book where bno=any(select bno from borrow where cno='"+cno+"');";
		Statement stmt = conn.createStatement();
		ResultSet rset =stmt.executeQuery(query);
		System.out.println("您借了这些书:");
		System.out.println("书号\t类别\t\t书名\t\t出版社\t\t年份\t作者\t价格\t总藏书量\t库存");
		System.out.println("******************************************************************************************");
		while(rset.next()){
			System.out.println(rset.getString("bno")+"\t"+rset.getString("category")+"\t"+rset.getString("title")+"\t"+rset.getString("press")+"\t"+
					"\t"+rset.getInt("year")+"\t"+rset.getString("author")+"\t"+rset.getDouble("price")+"\t"+
					rset.getInt("total")+"\t"+rset.getInt("stock"));
		}
		System.out.println("输入你想要还的书的书号");
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
				System.out.println("还书成功");	
			}
		else System.out.println("不要卖萌，你没借那本书");	
		}
		}
		}
		
	private static void Add_Book() throws Exception {
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n您现在选择的是	入库服务");
			System.out.println("\n1.单本入库 2.批量入库 0.退出");
			System.out.print("请输入服务号：");
			int choice = reader.nextInt();
	   switch(choice)
			{
	    case 0:
	    	return;
		case 1:		
		System.out.println("请依次输入：书号 类别 书名 出版社 年份 作者 价格 总藏书量 库存（用回车区分）");
		Scanner book  = new Scanner(System.in);
		String sql = "insert into book values('"+book.nextLine()+"','"+book.nextLine()+"','"+book.nextLine()+"','"+book.nextLine()+"',"+
		book.nextLine()+",'"+book.nextLine()+"',"+book.nextLine()+","+book.nextLine()+","+book.nextLine()+")";
		PreparedStatement   pre = conn.prepareStatement(sql);   
		pre.executeUpdate();

			break;
		
		case 2:
		
		final String path = "D:\\eclipse\\D：\\workspace\\BMS\\FC.txt";  
		  
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

            // 解析每一条记录  
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

        

        }System.out.println("共有合法的记录" + count + "条");  
        break;	

			}
		}
	}

	private static void Proof_Manag() throws SQLException {
		Scanner reader = new Scanner(System.in);
		
		while(true){
			System.out.println("\n您现在选择的是	借阅证服务");
			System.out.println("\n1.增加 借阅证2.删除借阅证 0.退出");
			System.out.print("请输入服务号：");
			int choice = reader.nextInt();
			switch(choice)
			{
				case 0:
					return;
				case 1:		
					System.out.println("请依次输入：卡号，姓名，单位，类别（T：教师，S：学生）（用回车区分）");
					Scanner card  = new Scanner(System.in);
					String sql = "insert into card values('"+card.nextLine()+"','"+card.nextLine()+"','"+card.nextLine()+"','"+card.nextLine()+"')";
					PreparedStatement   pre = conn.prepareStatement(sql);   
					pre.executeUpdate();
				break;
				case 2:
					String query = "select * from card";
					Statement stmt = conn.createStatement();
					ResultSet rset =stmt.executeQuery(query);
					System.out.println("全部借阅证:");
					System.out.println("证号\t姓名\t单位\t类别");
					System.out.println("******************************************************************************************");
					while(rset.next()){
						System.out.println(rset.getString("cno")+"\t"+rset.getString("name")+"\t"+rset.getString("department")+"\t"+rset.getString("type"));
					}
					System.out.println("请输入你想要删除的卡号");
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
