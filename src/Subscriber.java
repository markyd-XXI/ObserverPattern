public interface Subscriber {
    void subscribe(Publisher publisher);

    void unsubscribe(Publisher publisher);

    void update(Publisher topic, String articleTitle);

    void setId(String id);

    String getId();
}
