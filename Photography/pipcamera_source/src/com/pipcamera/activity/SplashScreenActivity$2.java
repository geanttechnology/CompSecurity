// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.SharedPreferences;
import kf;

// Referenced classes of package com.pipcamera.activity:
//            SplashScreenActivity

class b
    implements Runnable
{

    final boolean a;
    final SharedPreferences b;
    final SplashScreenActivity c;

    public void run()
    {
        if (!kf.b())
        {
            c.b();
            return;
        }
        if (a)
        {
            android.content.r r = b.edit();
            StringBuilder stringbuilder = (new StringBuilder()).append("isGotoGuideView_");
            kf.c();
            r.putBoolean(stringbuilder.append(kf.a).toString(), false);
            r.apply();
            c.a();
            return;
        } else
        {
            c.b();
            return;
        }
    }

    (SplashScreenActivity splashscreenactivity, boolean flag, SharedPreferences sharedpreferences)
    {
        c = splashscreenactivity;
        a = flag;
        b = sharedpreferences;
        super();
    }
}
