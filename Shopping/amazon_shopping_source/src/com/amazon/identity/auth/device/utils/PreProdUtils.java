// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            EnvironmentUtils

public final class PreProdUtils extends EnvironmentUtils
{

    public PreProdUtils()
    {
    }

    public String getAmazonCNDomain()
    {
        return "cn-pre-prod.amazon.com";
    }

    public String getAmazonJPDomain()
    {
        return "jp-pre-prod.amazon.com";
    }

    public String getAmazonUKDomain()
    {
        return "uk-pre-prod.amazon.com";
    }

    public String getAmazonUSDomain()
    {
        return "pre-prod.amazon.com";
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
        return EnvironmentUtils.Environment.pre_prod;
    }

    public String getDCAHost()
    {
        return "dcape-na-preprod.amazon.com";
    }

    public String getDefaultAmazonDomain()
    {
        return "pre-prod.amazon.com";
    }

    public String getFIRSHost()
    {
        return "firs-ta-g7g-preprod.amazon.com";
    }

    public String getPandaHost(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
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
