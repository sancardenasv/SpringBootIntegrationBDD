package starter.dto;

import java.util.HashMap;
import java.util.Map;

public class RestResponse {
    private String status;
    private String reason;
    private Map<String, Object> data;

    public RestResponse() {

    }

    public RestResponse(String status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RestResponse{");
        sb.append("status='").append(status).append('\'');
        sb.append(", reason='").append(reason).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    public void addDataEntry(String key, Object entry) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.putIfAbsent(key, entry);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
