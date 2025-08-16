package punit;
import java.util.Scanner;
//class of employee
class Employee {	
	

	int emp_id;
	String first_name;
	String last_name;
	String job_title;
	double salary;
	int department;
	String email;
// parameter constructor
 Employee(int id,String f_name,String l_name,String job,double salary,int dept,String email){
	 this.emp_id=id;
	 this.first_name=f_name;
	 this.last_name=l_name;
	 this.job_title=job;
	 this.salary=salary;
	 this.department=dept;
	 this.email=email;
 }

}
//main class
public class emp_dept {
	private static final int MAX_EMP=100;
	private static Employee[] employee = new Employee[MAX_EMP];
	private static int empdata=0;
public static void main(String[] args) {
	
	 Scanner scanner = new Scanner(System.in);
	 
	 String password = "emp@123";
	    String input, confirm;

	    System.out.print("Enter the password: ");
	    input = scanner.nextLine();
	    System.out.print("Confirm the password: ");
	    confirm = scanner.nextLine();
 
	    if (input.equals(password) && input.equals(confirm)) {
	        System.out.println("Password is correct and confirmed!");
	    } else {
	        System.out.println("Access denied. Incorrect password");
	        return;
	    }
	    
		employee[empdata] =new Employee(101,"James","Carter","Software Engineer",85000,101,"james@gmail.com");
		empdata++;
		employee[empdata] =new Employee(102," Sophia"," Martinez"," Marketing Manager",70000,102,"sophia@gmail.com");
		empdata++;
		employee[empdata] =new Employee(103," Daniel"," Robinson","  HR Coordinator",55000,101,"daniel@gmail.com");
		empdata++;
		employee[empdata] =new Employee(104," Emily"," Thompson"," Sales Executive",60000,102,"emily@gmail.com");
		empdata++;
		employee[empdata] =new Employee(105," Michael"," Harris"," Financial Analyst",65000,103,"michael@gmail.com");
		empdata++;
		 while (true) {
			 
		        System.out.println("\nEmployee Management System");
		        System.out.println("1. Add EmployeeData");
		        System.out.println("2. Update EmployeeData");
		        System.out.println("3. Delete EmployeeData");
		        System.out.println("4. Search EmployeeData");
		        System.out.println("5. View EmployeeData");
		        System.out.println("6. Exit");
		        System.out.print("Enter your choice: ");
		        int choice = scanner.nextInt();
		        scanner.nextLine();
		        switch (choice) {
		            case 1:
		            	add_emp(scanner);
		                break;
		            case 2:
		                System.out.print("Enter the Employee ID to update: ");
		                int updateId = scanner.nextInt();
		                update_emp(scanner, updateId);
		                break;
		            case 3:
		                System.out.print("Enter the Employee ID to delete: ");
		                int deleteId = scanner.nextInt();
		                datele_emp(deleteId);
		                break;
		            case 4:
		                System.out.print("Enter the Employee ID to search: ");
		                int searchId = scanner.nextInt();
		                search_empdata(searchId);
		                break;
		            case 5:
		            	view_empdata();
		                break;
		            case 6:
		                scanner.close();
		                return;
		            default:
		                System.out.println("Invalid choice. Please try again.");
		        }
		 }

 }
// add the employee details
private static void add_emp(Scanner scanner) {
	System.out.println("how many enter the employee detailes to add");
	int n=scanner.nextInt();
	scanner.nextLine();
	
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter employee id");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter employee first name");
		String f_name=scanner.next();
		scanner.nextLine();
		System.out.println("Enter employee last_name");
		String l_name=scanner.next();
		scanner.nextLine();
		System.out.println("Enter employee job_title");
		String job=scanner.next();
		scanner.nextLine();
		System.out.println("Enter employee salary");
		double salary=scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter employee department ");
		int dept=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter employee email");
		String email=scanner.next();
		scanner.nextLine();
     employee[empdata++] =new Employee(id,f_name,l_name,job,salary,dept,email);
	}
	
	System.out.println("amployee data add successfully");
		
	}	
// find employee data
private static int find_emp_data(int id) {
	
	for(int i=0;i<empdata;i++) {
		if(employee[i].emp_id==id)
		{
			return i;
			
		}
	}
	return -1; 
}
//update the employee data
private static void update_emp(Scanner scanner,int id) {
	int index = find_emp_data(id);
	if(index != -1) {
			 System.out.print("Enter the updated employee first name: ");
		        employee[index].first_name = scanner.nextLine();	
		        
			 System.out.print("Enter the updated employee last name: ");
		        employee[index].last_name = scanner.nextLine();	

			 System.out.print("Enter the updated employee job name: ");
		        employee[index].job_title = scanner.nextLine();	

			 System.out.print("Enter the updated employee salary: ");
		        employee[index].salary = scanner.nextDouble();	

			 System.out.print("Enter the updated employee department: ");
		        employee[index].department =scanner.nextInt();

			 System.out.print("Enter the updated employee email: ");
		        employee[index].email = scanner.nextLine();		

	}
}
//delete the employees data
	private static void datele_emp(int id) {
		int index =find_emp_data(id);
		if(index != -1) {
			for(int i=index;i<empdata-1;i++) {
				employee[i]=employee[i+1];
			}
			empdata--;
			System.out.println("employee id:"+id+"deleted successfully");
		}
		else {
			System.out.println("emlployee id is not found"+id);
		}
	}
//search the employee data
	private static void search_empdata(int id) {
		int index =find_emp_data(id);
		if(index != -1) {
			System.out.println("employee data is found");
			System.out.println("employee ID:"+" "+employee[index].emp_id);
			System.out.println("employee FristName:"+" "+employee[index].first_name);
			System.out.println("employee LastName:"+" "+employee[index].last_name);
			System.out.println("employee Job:"+" "+employee[index].job_title);
			System.out.println("employee Salary:"+" "+employee[index].salary);
			System.out.println("employee Department:"+" "+employee[index].department);
			System.out.println("employee Email:"+" "+employee[index].email);
		}
		else {
			System.out.println("emlployee id is not found"+id);
		}
		
	}
//print the employee data
	private static void view_empdata() {
		
		System.out.println("------------------------------------Employee data---------------------------------");
		System.out.printf("%-6s  %-10s %-20s %-10s %-8s %-6s %-15s %n","ID","FristName","LastName","Job","Salary(INR)","Department","Email","Number");
		System.out.println("------------------------------------------------------------------------------------------------");
		for(int i=0;i<empdata;i++)
		{
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.printf("%-6s  %-10s %-10s %-20s %-10.2f %-8d %-15s %n",employee[i].emp_id,employee[i].first_name,employee[i].last_name,employee[i].job_title,employee[i].salary,employee[i].department,employee[i].email);
		}
	}

}