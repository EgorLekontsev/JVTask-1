package packet;
import java.sql.*; //Импортируем необходимые инструменты для работы с бд
public class Main {
	public static void main(String[] args) {
		try{ //На случай возникновения ошибок
			Connection con = DriverManager.getConnection("jdbc:sqlite:staff.db");//Подключаемся
            String sqlQuery = "SELECT surname FROM employees ORDER BY experience DESC LIMIT 1 OFFSET 1"; //Выбираем фамилии из таблицы, сортируя опыт по убыванию и выбираем вторую строчку
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);//Выполняем запрос
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { //Если есть сотрудники
            	String surname = resultSet.getString("surname"); //Получаем данные
                System.out.println("Фамилия сотрудника со вторым максимальным опытом работы: " + surname);
            }else{
                System.out.println("Нет данных о сотрудниках.");
             }
            con.close();//Отключаемся
   
        }catch (SQLException e) { //Выписываем ошибки при работе с бд
        	System.out.println(e.getMessage());
        }
	}
}
