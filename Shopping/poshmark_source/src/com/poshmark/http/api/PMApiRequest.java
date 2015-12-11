// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.PMHttpRequest;
import com.poshmark.http.httpCore.PMApiExecutor;
import java.util.Map;

// Referenced classes of package com.poshmark.http.api:
//            PMApiResponseHandler

public class PMApiRequest extends PMHttpRequest
{

    public Class dataClass;

    public PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE request_type, String s, Class class1)
    {
        super(request_type, (new StringBuilder()).append("https://api.poshmark.com").append(s).toString());
        setupDefaults(class1);
    }

    public PMApiRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE request_type, String s, Class class1, String s1)
    {
        super(request_type, (new StringBuilder()).append(s1).append(s).toString());
        setupDefaults(class1);
    }

    public void callAPI(PMApiResponseHandler pmapiresponsehandler)
    {
        responseHandler = pmapiresponsehandler;
        (new PMApiExecutor(this)).execute();
    }

    protected void setupDefaults(Class class1)
    {
        dataClass = class1;
        class1 = PMApplicationSession.GetPMSession();
        String s = class1.getAccessToken();
        if (s != null)
        {
            headers.put("X-HTTP_AUTHORIZATION", (new StringBuilder()).append("oauth ").append(s).toString());
            headers.put("X-HTTP_AUTHORIZATION", (new StringBuilder()).append("oauth ").append(s).toString());
            queryParams.put("username", class1.getUserName());
        }
        class1 = AppInfo.getInstance();
        queryParams.put("format", "json");
        queryParams.put("api_version", "0.2");
        queryParams.put("app_version", ((AppInfo) (class1)).versionName);
        queryParams.put("app_versionCode", ((AppInfo) (class1)).versionCodeString);
        queryParams.put("app_type", "android");
    }
}
