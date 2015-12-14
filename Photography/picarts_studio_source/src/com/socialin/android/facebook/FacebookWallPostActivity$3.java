// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.text.TextUtils;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class c
    implements Runnable
{

    private String a;
    private String b;
    private String c;
    private FacebookWallPostActivity d;

    public final void run()
    {
        if (!TextUtils.isEmpty(FacebookWallPostActivity.j(d)))
        {
            Request request = new Request((new StringBuilder("https://graph.facebook.com/v2.4/")).append(FacebookWallPostActivity.j(d)).append("/feed").toString(), null, "POST");
            request.b("name", a);
            request.b("link", b);
            request.b("access_token", FacebookWallPostActivity.k(d));
            request.b("message", c);
            FacebookWallPostActivity.a(d, request);
        }
    }

    (FacebookWallPostActivity facebookwallpostactivity, String s, String s1, String s2)
    {
        d = facebookwallpostactivity;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
