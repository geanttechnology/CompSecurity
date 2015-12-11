// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.sponsorpay.advertiser.SponsorPayAdvertiser;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.mediation.SPMediationConfigurationRequester;
import com.sponsorpay.utils.HostInfo;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import com.sponsorpay.utils.cookies.PersistentHttpCookieStore;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SponsorPay
{

    public static final int BUGFIX_RELEASE_NUMBER = 2;
    protected static SponsorPay INSTANCE = new SponsorPay();
    public static final int MAJOR_RELEASE_NUMBER = 6;
    public static final int MINOR_RELEASE_NUMBER = 5;
    public static final String RELEASE_VERSION_STRING = "6.5.2";
    public static final String TAG = "SponsorPay";
    private SPCredentials currentCredentials;
    private HostInfo mHostInfo;
    private HashMap tokensMap;

    protected SponsorPay()
    {
        tokensMap = new HashMap();
    }

    public static Set getAllCredentials()
    {
        return INSTANCE.tokensMap.keySet();
    }

    public static SPCredentials getCredentials(String s)
    {
        return INSTANCE.getCredentialsFromToken(s);
    }

    private SPCredentials getCredentialsFromToken(String s)
    {
        SPCredentials spcredentials = (SPCredentials)tokensMap.get(s);
        if (spcredentials == null)
        {
            throw new RuntimeException((new StringBuilder("There are no credentials identified by ")).append(s).append("\nYou have to execute SponsorPay.start method first.").toString());
        } else
        {
            return spcredentials;
        }
    }

    public static SPCredentials getCurrentCredentials()
    {
        if (INSTANCE.currentCredentials == null)
        {
            throw new RuntimeException("Please start the SDK before accessing any of its resources.\nYou have to execute SponsorPay.start method first.");
        } else
        {
            return INSTANCE.currentCredentials;
        }
    }

    public static HostInfo getHostInfo()
    {
        return INSTANCE.mHostInfo;
    }

    public static String start(String s, String s1, String s2, Activity activity)
    {
        HashSet hashset = new HashSet(getAllCredentials());
        Context context = activity.getApplicationContext();
        s = INSTANCE.getCredentialsToken(s, s1, s2, context);
        if (HostInfo.isDeviceSupported())
        {
            if (hashset.isEmpty())
            {
                HostInfo.getHostInfo(context);
                CookieSyncManager.createInstance(activity);
                CookieHandler.setDefault(new CookieManager(new PersistentHttpCookieStore(activity), CookiePolicy.ACCEPT_ORIGINAL_SERVER));
                SPMediationConfigurationRequester.requestConfig(INSTANCE.currentCredentials, activity);
            }
            if (!hashset.contains(s))
            {
                SponsorPayAdvertiser.register(context);
            }
            return s;
        }
        if (SponsorPayLogger.isLogging())
        {
            SponsorPayLogger.i("SponsorPay", "Only devices running Android API level 10 and above are supported");
            return s;
        } else
        {
            Log.i("SponsorPay", "Only devices running Android API level 10 and above are supported");
            return s;
        }
    }

    protected String getCredentialsToken(String s, String s1, String s2, Context context)
    {
        SPCredentials spcredentials = (SPCredentials)tokensMap.get(SPCredentials.getCredentialsToken(s, s1));
        if (spcredentials != null) goto _L2; else goto _L1
_L1:
        s = new SPCredentials(s, s1, s2, context);
        tokensMap.put(s.getCredentialsToken(), s);
_L4:
        currentCredentials = s;
        return currentCredentials.getCredentialsToken();
_L2:
        s = spcredentials;
        if (StringUtils.notNullNorEmpty(s2))
        {
            spcredentials.setSecurityToken(s2);
            s = spcredentials;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
