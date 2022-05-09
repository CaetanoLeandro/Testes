import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class JsonToObj {

    private String url_api;
    private String jsonObj;

    public String getJsonObj() {
        return jsonObj;
    }

    public String getUrl_api() {
        return url_api;
    }

    public void setUrl_api(String url_api) {
        this.url_api = url_api;
    }

    public void setJsonObj(String next) {
        this.jsonObj = jsonObj;
    }


}
