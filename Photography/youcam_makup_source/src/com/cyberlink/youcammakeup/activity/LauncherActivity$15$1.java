// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.b.e;
import com.cyberlink.youcammakeup.kernelctrl.sku.j;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (LauncherActivity.f(a.a) != null)
        {
            LauncherActivity.f(a.a).v();
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$15

/* anonymous class */
    class LauncherActivity._cls15
        implements j
    {

        final LauncherActivity a;

        public void a()
        {
            a.runOnUiThread(new LauncherActivity._cls15._cls1(this));
        }

        public void a(String s)
        {
        }

        public void b(String s)
        {
        }

            
            {
                a = launcheractivity;
                super();
            }
    }

}
