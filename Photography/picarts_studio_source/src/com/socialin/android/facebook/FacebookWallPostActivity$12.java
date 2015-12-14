// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import com.socialin.android.facebook.util.FacebookUtils;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookWallPostActivity

final class b
    implements g
{

    private String a;
    private String b;
    private FacebookWallPostActivity c;

    public final void a(String s, m m)
    {
        s = FacebookUtils.createFacebookMessage(c, null, -1L, s);
        FacebookWallPostActivity.a(c, a, s, b);
    }

    (FacebookWallPostActivity facebookwallpostactivity, String s, String s1)
    {
        c = facebookwallpostactivity;
        a = s;
        b = s1;
        super();
    }
}
