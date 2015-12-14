// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.os.Handler;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aq;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ah

class a
    implements Runnable
{

    final bn a;
    final ger.task.bn b;

    public void run()
    {
        ah.c(b.b);
        ah.a(b.b, NetworkManager.a(a.a()));
    }

    ger.task.bn(ger.task.bn bn1, bn bn2)
    {
        b = bn1;
        a = bn2;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ah$1

/* anonymous class */
    class ah._cls1
        implements ao
    {

        final ah a;

        public void a(ap ap1)
        {
            ah.a(a, false);
            long l = ap1.e().b();
            if (Long.valueOf(z.d(ah.a(a), 0L)).longValue() < l)
            {
                ah.a(a, true);
                z.c(ah.a(a), l);
            }
            if (!ah.b(a))
            {
                ah.b(a, false);
                ah.a(a, z.f(ah.a(a), 0L));
            }
            ah.c(a, ah.b(a));
        }

        public void a(bn bn1)
        {
            ah.d(a).post(new ah._cls1._cls1(this, bn1));
        }

        public volatile void a(Object obj)
        {
            a((ap)obj);
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

            
            {
                a = ah1;
                super();
            }
    }

}
