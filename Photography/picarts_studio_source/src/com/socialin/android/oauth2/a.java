// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.oauth2;

import android.content.Intent;
import android.content.SharedPreferences;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.util.b;

public final class a
{

    public static void a(Intent intent, SharedPreferences sharedpreferences)
    {
        long l = 0L;
        String s1 = intent.getStringExtra("oauth2AccessToken");
        String s = null;
        if (intent.hasExtra("oauth2RefreshToken"))
        {
            s = intent.getStringExtra("oauth2RefreshToken");
        }
        if (intent.hasExtra("oauth2TokenExpiresIn"))
        {
            l = intent.getLongExtra("oauth2TokenExpiresIn", 0L);
        }
        intent = sharedpreferences.edit();
        intent.putString("oauth2AccessToken", s1);
        intent.putString("oauth2RefreshToken", s);
        intent.putLong("oauth2TokenExpiresIn", l);
        intent.commit();
    }

    public static void a(SharedPreferences sharedpreferences)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.clear();
        sharedpreferences.commit();
        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
        {
            com.socialin.android.util.b.a(SocialinV3.getInstance().getContext()).a("Connected Dropbox", false);
        }
    }

    public static void a(SharedPreferences sharedpreferences, String s, String s1, String s2)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString("oauth2userFirstName", s);
        sharedpreferences.putString("oauth2userLastName", s1);
        sharedpreferences.putString("oauth2userPhoto", s2);
        sharedpreferences.commit();
    }

    public static boolean b(SharedPreferences sharedpreferences)
    {
        return sharedpreferences.getString("oauth2AccessToken", null) != null;
    }

}
