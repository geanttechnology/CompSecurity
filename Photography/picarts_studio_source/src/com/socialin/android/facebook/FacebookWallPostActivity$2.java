// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import com.socialin.android.facebook.util.FacebookUtils;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class d
    implements g
{

    private String a;
    private String b;
    private String c;
    private boolean d;
    private FacebookWallPostActivity e;

    public final void a(String s, m m)
    {
        s = FacebookUtils.createFacebookMessage(e, FacebookWallPostActivity.h(e), FacebookWallPostActivity.i(e), s);
        FacebookWallPostActivity.a(e, a, b, s, c, d);
    }

    (FacebookWallPostActivity facebookwallpostactivity, String s, String s1, String s2, boolean flag)
    {
        e = facebookwallpostactivity;
        a = s;
        b = s1;
        c = s2;
        d = flag;
        super();
    }
}
