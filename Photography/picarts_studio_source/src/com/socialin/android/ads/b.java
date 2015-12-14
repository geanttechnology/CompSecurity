// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.os.Handler;
import com.socialin.android.apiv3.SocialinV3;

// Referenced classes of package com.socialin.android.ads:
//            a, SocialinAdView, SocialinAdManager

public final class b
    implements a
{

    private static b a;
    private static String b = "";

    private b(String s)
    {
        b = s;
    }

    public static a a(String s)
    {
        if (a == null)
        {
            a = new b(s);
        }
        return a;
    }

    public final void a(SocialinAdView socialinadview)
    {
        SocialinAdManager.a(socialinadview, SocialinAdView.b, SocialinV3.getInstance().getAppProps(), new Handler(), b);
    }

}
