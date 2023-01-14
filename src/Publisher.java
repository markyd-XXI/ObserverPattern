public interface Publisher {

    boolean addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers(String articleTitle);

    void publishNewArticle(String publishNewArticle);

    void createNewArticle(String publishNewArticle);

    String getLatestArticle();

    String getTopic();
}
