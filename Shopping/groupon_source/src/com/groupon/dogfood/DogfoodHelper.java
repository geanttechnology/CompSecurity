// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.dogfood;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.groupon.cookies.CookieFactory;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.sso.SSOHelper;
import com.groupon.sso.UserCredential;
import com.groupon.util.ArraySharedPreferences;
import roboguice.util.Strings;

public class DogfoodHelper
{

    private static final String PREF_KEY_STATUS_SERVICE = "StatusService";
    private final String AB_TESTS = "com.groupon.dogfood:abtest:";
    private final String DOG_FOOD = "com.groupon.dogfood";
    private final String TEST_FAIRY_CORRELATION_ID = "testfairy-correlation-id";
    private final String TEST_FAIRY_SECURE_VIEW_ID = "testfairy-secure-viewid";
    private final String USER_EMAIL = "com.groupon.dogfood:email:";
    private Application application;
    private Context context;
    private CookieFactory cookieFactory;
    private CurrentCountryManager currentCountryManager;
    private ArraySharedPreferences loginPrefs;
    private String packageName;
    ArraySharedPreferences statusServiceSharedPreferences;

    public DogfoodHelper()
    {
    }

    private void init()
    {
        packageName = context.getPackageName();
    }

    public boolean isDogfood()
    {
        return packageName.equals("com.groupon.dogfood");
    }

    public void logAbTests()
    {
        String s;
        if (isDogfood())
        {
            if (Strings.notEmpty(s = statusServiceSharedPreferences.getString("StatusService", "")))
            {
                Log.d("com.groupon.dogfood:abtest:", s);
                return;
            }
        }
    }

    public void logAbTests(String s)
    {
        if (!isDogfood())
        {
            return;
        } else
        {
            Log.d("com.groupon.dogfood:abtest:", s);
            return;
        }
    }

    public void logCorrelationId()
    {
        if (!isDogfood())
        {
            return;
        } else
        {
            Log.d("testfairy-correlation-id", cookieFactory.getBrowserCookie());
            return;
        }
    }

    public void logEmailAddress()
    {
        Object obj;
        if (isDogfood())
        {
            if ((obj = currentCountryManager.getCurrentCountry()) != null)
            {
                obj = SSOHelper.getAppAccount(application, ((Country) (obj)).isoName);
                if (obj != null)
                {
                    Log.d("com.groupon.dogfood:email:", ((UserCredential) (obj)).getUsername());
                    return;
                }
                obj = loginPrefs.getString("primaryEmailAddress", "");
                if (Strings.notEmpty(obj))
                {
                    Log.d("com.groupon.dogfood:email:", ((String) (obj)));
                    return;
                }
            }
        }
    }

    public void logHideViewId(int i)
    {
        if (!isDogfood())
        {
            return;
        } else
        {
            Log.d("testfairy-secure-viewid", String.valueOf(i));
            return;
        }
    }

    public void logStartupInformation()
    {
        if (!isDogfood())
        {
            return;
        } else
        {
            logCorrelationId();
            logEmailAddress();
            logAbTests();
            return;
        }
    }
}
