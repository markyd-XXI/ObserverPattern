public interface Observer {
    void subscribe(Subject subject);

    void unsubscribe(Subject subject);

    void update(Subject topic, String articleTitle);

    void setId(String id);

    String getId();
}
