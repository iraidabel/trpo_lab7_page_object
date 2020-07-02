package ru.volsu.qa.config.deprecated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Deprecated
public class Config {

    private String baseUrl;
    private int baseTimeout;

    public void setBaseTimeout(int baseTimeout) {
        this.baseTimeout = baseTimeout;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getBaseTimeout() {
        return baseTimeout;
    }
}
