// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.env;

import android.text.TextUtils;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.env:
//            EnvironmentUtils

final class ProdUtils extends EnvironmentUtils
{

    private static final String TAG = com/amazon/identity/auth/device/env/ProdUtils.getName();

    ProdUtils()
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
                throw new RuntimeException((new StringBuilder("Input was non-empty and doesn't look like a valid partial domain in production: ")).append(s).append(". If you were attempting to hit devo or pre-prod, please try following the steps to switch again.").toString());
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

    public String getDomainWithoutWWW(String s)
    {
        String s1;
        if (s.startsWith("www."))
        {
            s1 = s.substring(3);
        } else
        {
            s1 = s;
            if (!s.startsWith("."))
            {
                return (new StringBuilder(".")).append(s).toString();
            }
        }
        return s1;
    }

    public String getFIRSHost()
    {
        return "firs-ta-g7g.amazon.com";
    }

    public String getPVTinyURLPatternString()
    {
        return "(https:\\/\\/|http:\\/\\/)?(z\\.cn|amzn\\.asia|a\\.co|amzn\\.co|amzn\\.eu)\\/\\S*#verify";
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
                    throw new RuntimeException((new StringBuilder("Input was non-empty and doesn't look like a valid partial domain in production: ")).append(s).append(". If you were attempting to hit devo or pre-prod, please try following the steps to switch again.").toString());
                }
            }
        }
        return s1;
    }

    static 
    {
        ASSOC_HANDLE_MAP.put("www.amazon.com.mx", "amzn_device_mx");
        ASSOC_HANDLE_MAP.put("www.amazon.co.uk", "amzn_device_uk");
        ASSOC_HANDLE_MAP.put("www.amazon.ca", "amzn_device_ca");
        ASSOC_HANDLE_MAP.put("www.amazon.de", "amzn_device_de");
        ASSOC_HANDLE_MAP.put("www.amazon.fr", "amzn_device_fr");
        ASSOC_HANDLE_MAP.put("www.amazon.it", "amzn_device_it");
        ASSOC_HANDLE_MAP.put("www.amazon.in", "amzn_device_in");
        ASSOC_HANDLE_MAP.put("www.amazon.es", "amzn_device_es");
        ASSOC_HANDLE_MAP.put("www.amazon.co.jp", "amzn_device_jp");
        ASSOC_HANDLE_MAP.put("www.amazon.cn", "amzn_device_cn");
        ASSOC_HANDLE_MAP.put("www.amazon.com.br", "amzn_device_br");
        ASSOC_HANDLE_MAP.put("www.amazon.nl", "amzn_device_nl");
        ASSOC_HANDLE_MAP.put("www.amazon.com.au", "amzn_device_au");
        ASSOC_HANDLE_MAP.put("www.amazon.ru", "amzn_device_ru");
    }
}
