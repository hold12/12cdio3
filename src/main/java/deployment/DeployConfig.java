package deployment;

/**
 * Created by Christian on 28-04-2017.
 */
public class DeployConfig {
    private static final String CAMPUSNET_REDIRECT_URL = "CAMPUSNET_REDIRECT_URL";
    private static final String DEFAULT_CN_REDIRECT_URL = "https://f1712cdio3.herokuapp.com/rest/cn";
    public static final String CN_REDIRECT_URL = (System.getenv(CAMPUSNET_REDIRECT_URL) != null) ?
            System.getenv(CAMPUSNET_REDIRECT_URL): DEFAULT_CN_REDIRECT_URL;
}
