// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.bean;


// Referenced classes of package com.igexin.sdk.bean:
//            BaseBean

public class StartAppBean extends BaseBean
{

    private String appid;
    private String doUninstallId;
    private String isAutoStart;
    private String packageName;

    public StartAppBean()
    {
        packageName = "";
        appid = "";
        doUninstallId = "";
        isAutoStart = "false";
    }

    public String getAppid()
    {
        return appid;
    }

    public String getDoUninstallId()
    {
        return doUninstallId;
    }

    public String getIsAutoStart()
    {
        return isAutoStart;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public void setAppid(String s)
    {
        appid = s;
    }

    public void setDoUninstallId(String s)
    {
        doUninstallId = s;
    }

    public void setIsAutoStart(String s)
    {
        isAutoStart = s;
    }

    public void setPackageName(String s)
    {
        packageName = s;
    }
}
