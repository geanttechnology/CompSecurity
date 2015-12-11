// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.advertiser;

import android.content.Context;
import android.content.SharedPreferences;

public class SponsorPayAdvertiserState
{

    public static final String PREFERENCES_FILE_NAME = "SponsorPayAdvertiserState";
    private static final String STATE_GOT_SUCCESSFUL_RESPONSE_KEY = "SponsorPayAdvertiserState";
    private static final String STATE_INSTALL_REFERRER_KEY = "InstallReferrer";
    private static final String STATE_INSTALL_SUBID_KEY = "InstallSubId";
    private SharedPreferences mPrefs;

    public SponsorPayAdvertiserState(Context context)
    {
        mPrefs = context.getSharedPreferences("SponsorPayAdvertiserState", 0);
    }

    public String getCallbackReceivedSuccessfulResponse(String s)
    {
        return mPrefs.getString((new StringBuilder("SponsorPayAdvertiserState")).append(s).toString(), "0");
    }

    public String getInstallReferrer()
    {
        return mPrefs.getString("InstallReferrer", "");
    }

    public String getInstallSubId()
    {
        return mPrefs.getString("InstallSubId", "");
    }

    public void setCallbackReceivedSuccessfulResponse(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        String s1 = (new StringBuilder("SponsorPayAdvertiserState")).append(s).toString();
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        editor.putString(s1, s);
        editor.commit();
    }

    public void setInstallReferrer(String s)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("InstallReferrer", s);
        editor.commit();
    }

    public void setInstallSubId(String s)
    {
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("InstallSubId", s);
        editor.commit();
    }
}
