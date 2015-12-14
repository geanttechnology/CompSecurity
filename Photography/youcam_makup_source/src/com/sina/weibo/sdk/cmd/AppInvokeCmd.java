// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            BaseCmd

class AppInvokeCmd extends BaseCmd
{

    private String appPackage;
    private String scheme;
    private String url;

    public AppInvokeCmd()
    {
    }

    public AppInvokeCmd(String s)
    {
        super(s);
    }

    public AppInvokeCmd(JSONObject jsonobject)
    {
        super(jsonobject);
    }

    public String getAppPackage()
    {
        return appPackage;
    }

    public String getScheme()
    {
        return scheme;
    }

    public String getUrl()
    {
        return url;
    }

    public void initFromJsonObj(JSONObject jsonobject)
    {
        super.initFromJsonObj(jsonobject);
        appPackage = jsonobject.optString("package");
        scheme = jsonobject.optString("scheme");
        url = jsonobject.optString("url");
    }

    public void setAppPackage(String s)
    {
        appPackage = s;
    }

    public void setScheme(String s)
    {
        scheme = s;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
