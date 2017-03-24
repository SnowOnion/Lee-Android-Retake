package xyz.sonion.uktv;

/**
 * Created by sonion on 2017/3/24.
 */

public class Music {
//    private int id;
    private String displayName;
    private String directURL;

    public Music(String displayName, String directURL) {
        this.displayName = displayName;
        this.directURL = directURL;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDirectURL() {
        return directURL;
    }

    public void setDirectURL(String directURL) {
        this.directURL = directURL;
    }
}
