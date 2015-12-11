// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.Intent;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            SplashFragment, HomeActivity

class a
    implements Runnable
{

    final SplashFragment a;

    public void run()
    {
        Intent intent = new Intent(a.a, com/bestbuy/android/activities/home/HomeActivity);
        a.f.a(false);
        intent.setFlags(0x4000000);
        a.a.startActivity(intent);
        a.a.finish();
    }

    (SplashFragment splashfragment)
    {
        a = splashfragment;
        super();
    }
}
