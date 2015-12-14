// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ac, ad

class a
    implements Runnable
{

    final String a;
    final b b;

    public void run()
    {
        while (ac.c(b.b) == null || b.b == null || b.b.b() != b.b) 
        {
            return;
        }
        b.b.a(a);
        b.b.b(b.b.b());
        b.b.a(0xff000000);
        ac.c(b.b).a(b.b.b(), b.b);
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ac$4

/* anonymous class */
    class ac._cls4
        implements l
    {

        final ad a;
        final long b;
        final a c;
        final ac d;

        public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
        {
        }

        public void a(bn bn1)
        {
            if (bn1 == null);
        }

        public volatile void a(Object obj)
        {
            a((String)obj);
        }

        public void a(String s)
        {
            Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
            if (activity == null || ac.c(d) == null)
            {
                return;
            } else
            {
                activity.runOnUiThread(new ac._cls4._cls1(this, s));
                return;
            }
        }

        public void a(Void void1)
        {
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

        public void d(Object obj)
        {
            a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
        }

            
            {
                d = ac1;
                a = ad1;
                b = l1;
                c = a1;
                super();
            }
    }

}
