import java.util.List;

public interface Subject {

    boolean addSubscriber(Observer observer);

    void removeSubscriber(Observer observer);

    void notifySubscribers(String articleTitle);

    void publishNewArticle(String publishNewArticle);

    void createNewArticle(String publishNewArticle);

    String getLatestArticle();

    String getTopic();

    List<Observer> getObserverList();
}
