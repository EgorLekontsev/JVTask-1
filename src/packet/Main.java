package packet;
import java.sql.*; //Импортируем необходимые инструменты для работы с бд
public class Main {
	public static void main(String[] args) {
		try{ //На случай возникновения ошибок
			Connection connection = DriverManager.getConnection("jdbc:sqlite:staff.db");
            String sqlQuery = "SELECT surname FROM employees ORDER BY experience DESC LIMIT 1 OFFSET 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { //Если есть сотрудники
            	String surname = resultSet.getString("surname"); //Получаем данные
                System.out.println("Фамилия сотрудника со вторым максимальным опытом работы: " + surname);
            }else{
                System.out.println("Нет данных о сотрудниках.");
             }
   
        }catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
	}
}
