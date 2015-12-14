// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            BaseCmd

class AppInstallCmd extends BaseCmd
{

    private List appPackages;
    private String appSign;
    private long appVersion;
    private String downloadUrl;

    public AppInstallCmd()
    {
    }

    public AppInstallCmd(String s)
    {
        super(s);
    }

    public AppInstallCmd(JSONObject jsonobject)
    {
        super(jsonobject);
    }

    public List getAppPackage()
    {
        return appPackages;
    }

    public String getAppSign()
    {
        return appSign;
    }

    public long getAppVersion()
    {
        return appVersion;
    }

    public String getDownloadUrl()
    {
        return downloadUrl;
    }

    public void initFromJsonObj(JSONObject jsonobject)
    {
        super.initFromJsonObj(jsonobject);
        downloadUrl = jsonobject.optString("download_url");
        String s = jsonobject.optString("app_package");
        if (!TextUtils.isEmpty(s))
        {
            appPackages = Arrays.asList(s.split("\\|"));
        }
        appSign = jsonobject.optString("app_sign");
        appVersion = jsonobject.optLong("app_version");
    }

    public void setAppPackage(List list)
    {
        appPackages = list;
    }

    public void setAppSign(String s)
    {
        appSign = s;
    }

    public void setAppVersion(long l)
    {
        appVersion = l;
    }

    public void setDownloadUrl(String s)
    {
        downloadUrl = s;
    }
}
