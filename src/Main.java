public class Main {
    public static void main(String[] args) {
        Subject programmingBlog = new ProgrammingBlog();
        Subject cybersecurityBlog = new CybersecurityBlog();
        Subject pcHardwareBlog = new PCHardwareBlog();
        Subject gamingBlog = new GamingBlog();

        Observer bob = new Subscriber();
        bob.setId("Bob");
        Observer susan = new Subscriber();
        susan.setId("Susan");
        Observer jake = new Subscriber();
        jake.setId("Jake");

        System.out.println("--------Subscribing readers--------");
        bob.subscribe(programmingBlog);
        bob.subscribe(pcHardwareBlog);
        susan.subscribe(programmingBlog);
        susan.subscribe(cybersecurityBlog);
        susan.subscribe(programmingBlog);
        jake.subscribe(gamingBlog);
        System.out.println();

        System.out.println("--------Publishing new articles--------");
        programmingBlog.publishNewArticle("Spring Boot for noobs.");
        cybersecurityBlog.publishNewArticle("Threats to the online banking industry.");
        pcHardwareBlog.publishNewArticle("The graphic card you have to buy now!");
        gamingBlog.publishNewArticle("Details on the long-awaited ES6");
        System.out.println();

        System.out.println("--------Unsubscribing--------");
        jake.unsubscribe(gamingBlog);
        System.out.println();

        System.out.println("--------Publishing new articles--------");
        gamingBlog.publishNewArticle("Gaming hardware review");
        System.out.println();


        System.out.println("--------Subscribing readers--------");
        bob.subscribe(gamingBlog);
        System.out.println();

        System.out.println("--------Publishing new articles--------");
        gamingBlog.publishNewArticle("RDR2 online updates");
    }

}

