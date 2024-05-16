@SpringBootApplication
public class SpringKafkaBatchApplication implements CommandLineRunner {
  
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaBatchApplication.class, args);
    }
  
    @Autowired
    private Sender sender;
  
    @Override
    public void run(String... strings) throws Exception {
        for (int i = 1; i < 11; i++){
            sender.send("Message-" + i);
        }
    }
  
}
