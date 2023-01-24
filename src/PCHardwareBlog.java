public class PCHardwareBlog extends Blog {
    public PCHardwareBlog(){
        super();
        this.topic = "PC Hardware";
    }

    /**
     * PC Hardware blog is special and wants the hardware vendors who pay for ad space in the blog to be notified when a new pc hardware article is published
     * This overridden method is an implementation of runtime polymorphism
     * @param articleTitle The title of the article being published.
     */
    public void publishNewArticle(String articleTitle) {
        System.out.printf("[New %s article published!]%n", topic);
        System.out.printf("**Notified hardware vendors of new topic published, %s**", topic);
        System.out.println();
        createNewArticle(articleTitle);
        notifySubscribers(articleTitle);
    }
}
