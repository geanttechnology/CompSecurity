// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.DialogInterface;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, s

class a
    implements android.content.nClickListener
{

    final SplashActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        h.b().a("none");
        SplashActivity.a(a).f = Boolean.valueOf(true);
        SplashActivity.b(a);
    }

    (SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }
}
