// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class AmazonDomainHelper
{

    private static final String TAG = com/amazon/identity/auth/device/utils/AmazonDomainHelper.getName();

    private AmazonDomainHelper()
    {
    }

    public static String getAuthDomainForDirectedId(ServiceWrappingContext servicewrappingcontext, String s)
    {
        return servicewrappingcontext.getDataStorage().getUserData(s, "authDomain");
    }

    public static String getAuthPortalDomainBasedOnAccountPool(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            MAPLog.i(TAG, "Empty account pool, returning null domain ");
            return null;
        }
        EnvironmentUtils environmentutils = EnvironmentUtils.getInstance();
        if (s.equalsIgnoreCase("Amazon"))
        {
            return environmentutils.getAmazonUSDomain();
        }
        if (s.equalsIgnoreCase("AmazonCN"))
        {
            return environmentutils.getAmazonCNDomain();
        }
        if (s.equalsIgnoreCase("AmazonJP"))
        {
            return environmentutils.getAmazonJPDomain();
        } else
        {
            MAPLog.e(TAG, (new StringBuilder("Ignoring unknown account pool:  ")).append(s).toString());
            return null;
        }
    }

    public static String getAuthPortalDomainBasedOnCustomerRegion(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            MAPLog.i(TAG, "Empty customer region, returning null domain ");
            return null;
        }
        EnvironmentUtils environmentutils = EnvironmentUtils.getInstance();
        if (s.equalsIgnoreCase("NA"))
        {
            return environmentutils.getAmazonUSDomain();
        }
        if (s.equalsIgnoreCase("EU"))
        {
            return environmentutils.getAmazonUKDomain();
        }
        if (s.equalsIgnoreCase("FE"))
        {
            return environmentutils.getAmazonJPDomain();
        }
        if (s.equalsIgnoreCase("CN"))
        {
            return environmentutils.getAmazonCNDomain();
        } else
        {
            MAPLog.e(TAG, (new StringBuilder("Ignoring unknown customer region:  ")).append(s).toString());
            return null;
        }
    }

    public static String getCompleteAuthPortalDomain(String s)
    {
        return EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(s);
    }

    public static String getCompleteCookieDomain(String s)
    {
        return EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(s);
    }

    public static String getDomainFromCompleteUrl(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s1 = ".amazon.com";
        } else
        {
            s1 = s;
            if (!s.startsWith("."))
            {
                if (s.startsWith("amazon."))
                {
                    return (new StringBuilder(".")).append(s).toString();
                }
                if (s.startsWith("www"))
                {
                    return s.substring(3);
                }
                if (s.contains(".amazon"))
                {
                    return s.substring(s.indexOf(".amazon"));
                } else
                {
                    throw new RuntimeException((new StringBuilder("Input was non-empty and doesn't look like a valid url: ")).append(s).toString());
                }
            }
        }
        return s1;
    }

    public static String getDomainWithoutWWW(String s)
    {
        return EnvironmentUtils.getInstance().getDomainWithoutWWW(s);
    }

    public static String getPartialAmazonDomainFromAPIBundle(Bundle bundle)
    {
        String s;
        if (bundle == null)
        {
            s = null;
        } else
        {
            String s1 = bundle.getString("com.amazon.identity.ap.domain");
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                return bundle.getString("com.amazon.dcp.sso.AddAccount.options.AmazonDomain");
            }
        }
        return s;
    }

}
