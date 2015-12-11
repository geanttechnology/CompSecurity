// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.s;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class d
{

    static volatile boolean a = false;
    private static final String b = com/facebook/ads/d.getSimpleName();
    private static final Collection c = new HashSet();
    private static final Collection d;
    private static String e = null;
    private static boolean f = false;
    private static String g = null;

    public d()
    {
    }

    public static String a()
    {
        return e;
    }

    public static boolean a(Context context)
    {
        if (!d.contains(Build.PRODUCT)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (g != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        SharedPreferences sharedpreferences = context.getSharedPreferences("FBAdPrefs", 0);
        String s1 = sharedpreferences.getString("deviceIdHash", null);
        g = s1;
        if (!s.a(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = com.facebook.ads.a.f.g.a(context.getContentResolver());
        if (!s.a(((com.facebook.ads.a.f.g.a) (context)).b))
        {
            g = s.b(((com.facebook.ads.a.f.g.a) (context)).b);
        } else
        if (!s.a(((com.facebook.ads.a.f.g.a) (context)).a))
        {
            g = s.b(((com.facebook.ads.a.f.g.a) (context)).a);
        } else
        {
            g = s.b(UUID.randomUUID().toString());
        }
        sharedpreferences.edit().putString("deviceIdHash", g).apply();
        if (c.contains(g)) goto _L1; else goto _L3
_L3:
        context = g;
        if (!a)
        {
            a = true;
            (new StringBuilder("When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"")).append(context).append("\");");
        }
        return false;
    }

    public static boolean b()
    {
        return f;
    }

    static 
    {
        HashSet hashset = new HashSet();
        d = hashset;
        hashset.add("sdk");
        d.add("google_sdk");
        d.add("vbox86p");
        d.add("vbox86tp");
    }
}
