public class Main {
    public static void main(String[] args) {
        Publisher programmingBlog = new ProgrammingBlog();
        Publisher cybersecurityBlog = new CybersecurityBlog();
        Publisher pcHardwareBlog = new PCHardwareBlog();
        Publisher gamingBlog = new GamingBlog();

        Subscriber bob = new Reader();
        bob.setId("Bob");
        Subscriber susan = new Reader();
        susan.setId("Susan");
        Subscriber jake = new Reader();
        jake.setId("Jake");

        System.out.println("--------Subscribing readers--------");
        bob.subscribe(programmingBlog);
        bob.subscribe(pcHardwareBlog);
        susan.subscribe(programmingBlog);
        susan.subscribe(cybersecurityBlog);
        susan.subscribe(programmingBlog);
        jake.subscribe(gamingBlog);
        System.out.println("");

        System.out.println("--------Publishing new articles--------");
        programmingBlog.publishNewArticle("Spring Boot for noobs.");
        cybersecurityBlog.publishNewArticle("Threats to the online banking industry.");
        pcHardwareBlog.publishNewArticle("The graphic card you have to buy now!");
        gamingBlog.publishNewArticle("Details on the long-awaited ES6");
        System.out.println("");

        System.out.println("--------Unsubscribing--------");
        jake.unsubscribe(gamingBlog);
        System.out.println("");

        System.out.println("--------Publishing new articles--------");
        gamingBlog.publishNewArticle("Gaming hardware review");
        System.out.println("");


        System.out.println("--------Subscribing readers--------");
        bob.subscribe(gamingBlog);
        System.out.println("");

        System.out.println("--------Publishing new articles--------");
        gamingBlog.publishNewArticle("RDR2 online updates");
    }

}

