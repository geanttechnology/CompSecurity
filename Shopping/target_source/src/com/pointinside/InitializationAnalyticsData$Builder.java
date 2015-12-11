// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside;


// Referenced classes of package com.pointinside:
//            InitializationAnalyticsData

static class _cls9
{

    private String appName;
    private String appVersion;
    private String devModel;
    private String libName;
    private String libVersion;
    private String osVersion;

    public _cls9 appName(String s)
    {
        appName = s;
        return this;
    }

    public appName appVersion(String s)
    {
        appVersion = s;
        return this;
    }

    public InitializationAnalyticsData build()
    {
        return new InitializationAnalyticsData(this, null);
    }

    public appVersion devModel(String s)
    {
        devModel = s;
        return this;
    }

    public devModel libName(String s)
    {
        libName = s;
        return this;
    }

    public libName libVersion(String s)
    {
        libVersion = s;
        return this;
    }

    public libVersion osVersion(String s)
    {
        osVersion = s;
        return this;
    }







    public _cls9()
    {
    }
}
