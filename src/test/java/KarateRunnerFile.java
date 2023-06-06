import com.intuit.karate.junit5.Karate;

public class KarateRunnerFile {
	 @Karate.Test
	    Karate testApi() {
	        return Karate.run("classpath:APITests.feature");
	    }
}
