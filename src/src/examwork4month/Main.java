package examwork4month;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, SQLException, NullPointerException {
        Connect connect = new Connect();
        connect.connect();
        News news = new News();
        //news.insertNews(news);
        //news.selectNews(news);
        //news.deleteNews(news);
        //news.updateNews(news);
    }
}
//Методы работают, но почему-то когда вводишь данные в консоли, не получается ввести заголовок, после него сразу идет установление даты публикации...
