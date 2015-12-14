// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import kh;
import la;

// Referenced classes of package com.pipcamera.activity:
//            SplashScreenActivity

class a
    implements kh
{

    final SplashScreenActivity a;

    public void a(boolean flag)
    {
        if (flag)
        {
            la.b(a.getApplicationContext(), "appnewuser", false);
        }
    }

    (SplashScreenActivity splashscreenactivity)
    {
        a = splashscreenactivity;
        super();
    }
}
