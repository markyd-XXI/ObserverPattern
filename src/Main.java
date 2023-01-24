public class Main {
    public static void main(String[] args) {
        //Coding to interface, not implementation here...
        Subject programmingBlog = new ProgrammingBlog();
        Subject cybersecurityBlog = new CybersecurityBlog();
        Subject pcHardwareBlog = new PCHardwareBlog();
        Subject gamingBlog = new GamingBlog();

        System.out.println("--------Subscribing readers--------");
        //This instantiation uses an overloaded Subscriber constructor. This demonstrates compile time polymorphism
        new Subscriber(pcHardwareBlog, "Mike"); //Subscribes mike to the pc hardware blog

        //Coding to interface, not implementation here...
        Observer bob = new Subscriber();
        bob.setId("Bob");
        Observer susan = new Subscriber();
        susan.setId("Susan");
        Observer jake = new Subscriber();
        jake.setId("Jake");


        bob.subscribe(programmingBlog);
        bob.subscribe(pcHardwareBlog);
        susan.subscribe(programmingBlog);
        susan.subscribe(cybersecurityBlog);
        susan.subscribe(programmingBlog); //Here we try to subscribe Susan to the programming blog again.
        jake.subscribe(gamingBlog); //Jake is the only one interested in the gaming blog.
        System.out.println();

        System.out.println("--------Publishing new articles--------");
        programmingBlog.publishNewArticle("Spring Boot for noobs.");
        cybersecurityBlog.publishNewArticle("Threats to the online banking industry.");
        pcHardwareBlog.publishNewArticle("The graphic card you have to buy now!");
        gamingBlog.publishNewArticle("Details on the long-awaited ES6");
        System.out.println();

        System.out.println("--------Unsubscribing--------");
        jake.unsubscribe(gamingBlog); //Now there are no subs to the gaming blog
        System.out.println();

        System.out.println("--------Publishing new articles--------");
        gamingBlog.publishNewArticle("Gaming hardware review"); //Publishing a new gaming blog will alert us that there are no subscribers to publish to.
        System.out.println();

        System.out.println("--------Subscribing readers--------");
        bob.subscribe(gamingBlog); //Now Bob likes the gaming blog
        System.out.println();

        System.out.println("--------Publishing new articles--------");
        gamingBlog.publishNewArticle("RDR2 online updates"); //Publishing gaming blog sends notification to Bob.
        System.out.println();

        System.out.println("---Let's print out all the subscribers to the different blogs.---");
        System.out.println("Gaming Blog Subscribers");
        gamingBlog.getObserverList().forEach((observer)->{System.out.printf("--%s", observer.getId()); System.out.println();});
        System.out.println();

        System.out.println("PC Hardware Blog Subscribers");
        pcHardwareBlog.getObserverList().forEach((observer)->{System.out.printf("--%s", observer.getId()); System.out.println();});
        System.out.println();

        System.out.println("Programming Blog Subscribers");
        programmingBlog.getObserverList().forEach((observer)->{System.out.printf("--%s", observer.getId()); System.out.println();});
        System.out.println();

        System.out.println("Cybersecurity Blog Subscribers");
        cybersecurityBlog.getObserverList().forEach((observer)->{System.out.printf("--%s", observer.getId()); System.out.println();});
        System.out.println();
    }

}

