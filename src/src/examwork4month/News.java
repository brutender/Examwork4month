package examwork4month;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class News extends Connect {
    //- создания новой новости.
    //- отображения новости (заголовок и текст)
    //- удаления новости по Id
    //- изменения текста и заголовка новости, по Id

    Scanner sc = new Scanner(System.in);

    private Integer id;
    private String title;
    private String text_news;
    private String datatime;

    public void insertNews(News news) throws ParseException{
        String insert = "insert into \"news\".news (id, title, datatime, text_news) values (?, ?, ?, ?)";
        System.out.println("Введите id");
        id = sc.nextInt();

        System.out.println("Введите заголовок");
        title = sc.nextLine();

        System.out.println("Введите дату публикации");
        datatime = sc.nextLine();
        Date date = new SimpleDateFormat("YYYY-MM-DD").parse(datatime);
        Date dateTime = new java.sql.Date(date.getTime());

        System.out.println("Введите текст");
        text_news = sc.nextLine();

        try {
            Connection conn = connect();
            PreparedStatement preparedStatement = conn.prepareStatement(insert);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, title);
            preparedStatement.setDate(3, (java.sql.Date) dateTime);
            preparedStatement.setString(4, text_news);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            rs.next();
        } catch (SQLException e){
                throw new RuntimeException(e);
        }
    }
    public void selectNews(News news) {
        String select = "select title, text_news from \"news\".news";
        try {
            Statement statement = connect().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title")
                        + " " + resultSet.getString("text_news"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNews (News news) {
        String delete = "DELETE FROM \"news\".news WHERE id = ?";
        System.out.println("Выберите id новости, чтобы удалить");
        id = sc.nextInt();
        try {
            PreparedStatement prstmn = connect().prepareStatement(delete); {
                prstmn.setInt(1, id);
                prstmn.executeUpdate();
                ResultSet resultSet = prstmn.getResultSet();
                resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateNews (News news) {
        String update = "UPDATE \"news\".news SET title = ?, text_news = ? WHERE id = ?";
        System.out.println("Введите id записи которую хотите изменить");
        id = sc.nextInt();
        System.out.println("Введите новый заголовок");
        title = sc.nextLine();
        System.out.println("Введите новый текст новости");
        text_news = sc.nextLine();
        try {
            Connection conn = connect();
            PreparedStatement preparedStatement = conn.prepareStatement(update);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, text_news);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getResultSet();
            rs.next();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}