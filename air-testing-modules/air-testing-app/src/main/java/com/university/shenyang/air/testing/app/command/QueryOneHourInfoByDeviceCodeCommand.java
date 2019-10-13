package com.university.shenyang.air.testing.app.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by pbw on 2018/6/11.
 */
public class QueryOneHourInfoByDeviceCodeCommand extends BaseCommand{
    @NotEmpty(message = "deviceCode cannot be empty")
    private String deviceCode;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
}
