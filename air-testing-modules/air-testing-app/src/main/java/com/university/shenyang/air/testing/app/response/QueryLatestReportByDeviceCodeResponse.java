package com.university.shenyang.air.testing.app.response;

import com.university.shenyang.air.testing.common.response.BaseResponse;
import com.university.shenyang.air.testing.model.ReportInfo;

import java.util.List;

/**
 * Created by pbw on 2018/5/25.
 */
public class QueryLatestReportByDeviceCodeResponse extends AppBaseResponse {
    private List<ReportInfo> data;

    public List<ReportInfo> getData() {
        return data;
    }

    public void setData(List<ReportInfo> data) {
        this.data = data;
    }
}
