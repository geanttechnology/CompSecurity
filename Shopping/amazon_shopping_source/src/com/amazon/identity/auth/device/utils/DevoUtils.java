// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            EnvironmentUtils

public final class DevoUtils extends EnvironmentUtils
{

    public DevoUtils()
    {
    }

    public String getAmazonCNDomain()
    {
        return "cn-development.amazon.com";
    }

    public String getAmazonJPDomain()
    {
        return "jp-development.amazon.com";
    }

    public String getAmazonUKDomain()
    {
        return "uk-development.amazon.com";
    }

    public String getAmazonUSDomain()
    {
        return "development.amazon.com";
    }

    public String getCompleteAuthPortalDomain(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            return s;
        } else
        {
            return getAmazonUSDomain();
        }
    }

    protected EnvironmentUtils.Environment getCurrentEnvironment()
    {
        return EnvironmentUtils.Environment.devo;
    }

    public String getDCAHost()
    {
        return "dcape-na.integ.amazon.com";
    }

    public String getDefaultAmazonDomain()
    {
        return "development.amazon.com";
    }

    public String getFIRSHost()
    {
        return "firs-ta-g7g.vipinteg.amazon.com";
    }

    public String getPandaHost(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = getDefaultAmazonDomain();
        }
        if (s1.endsWith(".co.uk"))
        {
            s = "uk-";
        } else
        if (s1.endsWith(".co.jp"))
        {
            s = "jp-";
        } else
        if (s1.endsWith(".de"))
        {
            s = "de-";
        } else
        if (s1.endsWith(".fr"))
        {
            s = "fr-";
        } else
        if (s1.endsWith(".cn"))
        {
            s = "cn-";
        } else
        {
            s = "us-";
        }
        return (new StringBuilder()).append(s).append("api.integ.amazon.com").toString();
    }
}
