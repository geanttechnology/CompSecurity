// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            EnvironmentUtils

public final class ProdUtils extends EnvironmentUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/ProdUtils.getName();

    public ProdUtils()
    {
    }

    public String getAmazonCNDomain()
    {
        return ".amazon.cn";
    }

    public String getAmazonJPDomain()
    {
        return ".amazon.co.jp";
    }

    public String getAmazonUKDomain()
    {
        return ".amazon.co.uk";
    }

    public String getAmazonUSDomain()
    {
        return ".amazon.com";
    }

    public String getCompleteAuthPortalDomain(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s = TAG;
            s1 = "www.amazon.com";
        } else
        {
            if (s.startsWith("."))
            {
                return (new StringBuilder("www")).append(s).toString();
            }
            if (s.startsWith("amazon."))
            {
                return (new StringBuilder("www.")).append(s).toString();
            }
            s1 = s;
            if (!s.startsWith("www"))
            {
                throw new RuntimeException((new StringBuilder("Input was non-empty and doesn't look like a partial domain: ")).append(s).toString());
            }
        }
        return s1;
    }

    protected EnvironmentUtils.Environment getCurrentEnvironment()
    {
        return EnvironmentUtils.Environment.prod;
    }

    public String getDCAHost()
    {
        return "dcape-na.amazon.com";
    }

    public String getDefaultAmazonDomain()
    {
        return "www.amazon.com";
    }

    public String getFIRSHost()
    {
        return "firs-ta-g7g.amazon.com";
    }

    public String getPandaHost(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s = TAG;
            s1 = "api.amazon.com";
        } else
        {
            if (s.startsWith("."))
            {
                return (new StringBuilder("api")).append(s).toString();
            }
            if (s.startsWith("amazon."))
            {
                return (new StringBuilder("api.")).append(s).toString();
            }
            s1 = s;
            if (!s.startsWith("api.amazon"))
            {
                if (s.startsWith("www"))
                {
                    return (new StringBuilder("api")).append(s.substring(3)).toString();
                } else
                {
                    throw new RuntimeException((new StringBuilder("Input was non-empty and doesn't look like a partial domain: ")).append(s).toString());
                }
            }
        }
        return s1;
    }

}
