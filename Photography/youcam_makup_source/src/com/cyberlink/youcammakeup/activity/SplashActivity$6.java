// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.AlertDialog;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity

class a
    implements Runnable
{

    final AlertDialog a;
    final SplashActivity b;

    public void run()
    {
        if (a != null && a.isShowing())
        {
            a.dismiss();
        }
        b.finish();
    }

    (SplashActivity splashactivity, AlertDialog alertdialog)
    {
        b = splashactivity;
        a = alertdialog;
        super();
    }
}
