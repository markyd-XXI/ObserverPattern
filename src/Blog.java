import java.util.ArrayList;
import java.util.List;

public class Blog implements Subject {
    private final List<Observer> observerList;
    protected String topic = "";

    protected List<String> articles;

    public Blog() {
        observerList = new ArrayList<>();
        articles = new ArrayList<>();
    }

    @Override
    public boolean addSubscriber(Observer observer) {
        if(!observerList.contains(observer))
        {
            observerList.add(observer);
            return true;
        }
        else
        {
            System.out.printf("***Subscriber not added. %s is already subscribed to the %s topic.***%n", observer.getId(), topic);
            return false;
        }
    }

    @Override
    public void removeSubscriber(Observer observer) {
        observerList.remove(observer);
    }

    public void notifySubscribers(String articleTitle) {
        if(!observerList.isEmpty()){
            for (Observer observer : observerList) {
                System.out.printf("--Notification of new %s article titled \"%s\" has been sent to reader, %s.%n", topic, articleTitle, observer.getId());
                observer.update(this, articleTitle);
            }
        }
        else
        {
            System.out.printf("***There are no subscribers to the %s blog to notify.***%n", topic);
        }

    }

    public void publishNewArticle(String articleTitle) {
        System.out.printf("[New %s article published!]%n", topic);
        createNewArticle(articleTitle);
        notifySubscribers(articleTitle);
    }

    public void createNewArticle(String articleTitle)
    {
        articles.add(articleTitle);
    }

    public String getLatestArticle()
    {
        return articles.get(articles.size() - 1);
    }

    public String getTopic() {
        return topic;
    }

    public List<Observer> getObserverList() {
        return observerList;
    }
}
