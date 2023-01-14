import java.util.ArrayList;
import java.util.List;

public class Blog implements Publisher {
    private List<Subscriber> subscriberList;
    protected String topic = "";

    protected List<String> articles;

    public Blog() {
        subscriberList = new ArrayList<>();
        articles = new ArrayList<>();
    }

    @Override
    public boolean addSubscriber(Subscriber subscriber) {
        if(!subscriberList.contains(subscriber))
        {
            subscriberList.add(subscriber);
            return true;
        }
        else
        {
            System.out.println(String.format("***Subscriber not added. %s is already subscribed to the %s topic.***", subscriber.getId(), topic));
            return false;
        }
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void notifySubscribers(String articleTitle) {
        if(!subscriberList.isEmpty()){
            for (Subscriber subscriber : subscriberList) {
                System.out.println(String.format("--Notification of new %s article titled \"%s\" has been sent to reader, %s." , topic, articleTitle, subscriber.getId()));
                subscriber.update(this, articleTitle);
            }
        }
        else
        {
            System.out.println(String.format("***There are no subscribers to the %s blog to notify.***" , topic));
        }

    }

    public void publishNewArticle(String articleTitle) {
        System.out.println(String.format("[New %s article published!]", topic));
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
}
