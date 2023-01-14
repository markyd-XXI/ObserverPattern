public class Reader implements Subscriber {

    private String id;

    public void subscribe(Publisher publisher) {
        if(publisher.addSubscriber(this)){
            System.out.println(String.format("%s is now subscribed to the %s blog", id, publisher.getTopic()));
        }
    }

    public void unsubscribe(Publisher publisher) {
        publisher.removeSubscriber(this);
        System.out.println(String.format("%s is now un-subscribed from the %s blog", id, publisher.getTopic()));
    }

    public void update(Publisher publisher, String articleTitle) {
        System.out.println(String.format("----Notification of new %s article titled \"%s\" has been received by reader, %s." , publisher.getTopic(), articleTitle, id));
        String latestArticle = publisher.getLatestArticle();
        System.out.println(String.format("----%s has successfully retrieved the latest %s article titled \"%s\"", id, publisher.getTopic(), latestArticle));
        System.out.println("");
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
