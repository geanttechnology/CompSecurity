// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.tumblr;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.flurry.sdk.em;
import com.flurry.sdk.fi;
import com.flurry.sdk.hc;
import com.flurry.sdk.hl;
import com.flurry.sdk.js;
import com.flurry.sdk.kg;
import com.flurry.sdk.me;
import java.util.HashMap;

// Referenced classes of package com.flurry.android.tumblr:
//            Post

public class TumblrShare
{

    private static final String a = com/flurry/android/tumblr/TumblrShare.getName();

    public TumblrShare()
    {
    }

    public static Bitmap getTumblrImage()
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return null;
        }
        if (js.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized.");
        } else
        {
            hc hc1 = new hc();
            hc1.x();
            return hc1.o();
        }
    }

    public static void post(Context context, Post post1)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (js.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before posting on Tumblr");
        }
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        if (!(context instanceof Activity))
        {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        if (post1 == null)
        {
            throw new IllegalArgumentException("Post object cannot be null.");
        }
        if (TextUtils.isEmpty(em.a()))
        {
            throw new IllegalArgumentException("Consumer api key cannot be null or empty. Please set consumer key using setOAuthConfig().");
        }
        if (TextUtils.isEmpty(em.b()))
        {
            throw new IllegalArgumentException("Consumer secret cannot be null or empty. Please set consumer secret using setOAuthConfig().");
        } else
        {
            hl.a().b("ShareClick", post1.d(), new HashMap());
            me.a().a(post1.g(), post1);
            fi.a(context, post1.c());
            return;
        }
    }

    public static void setOAuthConfig(String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            kg.b(a, "Device SDK Version older than 10");
            return;
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Consumer api key cannot be null or empty.");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Consumer secret cannot be null or empty.");
        } else
        {
            em.a(s);
            em.b(s1);
            return;
        }
    }

}
