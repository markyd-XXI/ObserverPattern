public class Subscriber implements Observer {

    /**
     * The overloaded Subscriber constructors are implementations of compile time polymorphism.
     */
    public Subscriber() {}

    public Subscriber(Subject subject, String id)
    {
        this.id = id;
        subscribe(subject);
    }

    private String id;

    public void subscribe(Subject subject) {
        if(subject.addSubscriber(this)){
            System.out.printf("%s is now subscribed to the %s blog%n", id, subject.getTopic());
        }
    }

    public void unsubscribe(Subject subject) {
        subject.removeSubscriber(this);
        System.out.printf("%s is now un-subscribed from the %s blog%n", id, subject.getTopic());
    }

    public void update(Subject subject, String articleTitle) {
        System.out.printf("----Notification of new %s article titled \"%s\" has been received by reader, %s.%n", subject.getTopic(), articleTitle, id);
        String latestArticle = subject.getLatestArticle();
        System.out.printf("----%s has successfully retrieved the latest %s article titled \"%s\"%n", id, subject.getTopic(), latestArticle);
        System.out.println();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
