// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bb;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bd;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            f

class a
    implements Runnable
{

    final bn a;
    final ager.task.bn b;

    public void run()
    {
        f.b(b.b, false);
        f.a(b.b, NetworkManager.a(a.a()));
    }

    ager.task.bn(ager.task.bn bn1, bn bn2)
    {
        b = bn1;
        a = bn2;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/f$2

/* anonymous class */
    class f._cls2
        implements bd
    {

        final f a;

        public void a(bb bb1)
        {
            f.c(a).clear();
            a.a.clear();
            com.cyberlink.youcammakeup.pages.moreview.f.d(a).clear();
            bb1 = bb1.a().iterator();
            do
            {
                if (!bb1.hasNext())
                {
                    break;
                }
                d d1 = (d)bb1.next();
                Long long1 = Long.valueOf(d1.a());
                if (f.c(a) != null)
                {
                    f.c(a).put(long1, d1);
                    a.a.put(long1, f.a(a, d1));
                }
                if (com.cyberlink.youcammakeup.pages.moreview.f.d(a) != null && !com.cyberlink.youcammakeup.pages.moreview.f.d(a).contains(long1))
                {
                    com.cyberlink.youcammakeup.pages.moreview.f.d(a).add(long1);
                }
            } while (true);
            f.c(a, false);
            if (f.c(a) != null)
            {
                a.a();
            }
            f.b(a, false);
        }

        public void a(bn bn1)
        {
            if (bn1 == null);
            Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.i);
            if (activity == null)
            {
                return;
            } else
            {
                activity.runOnUiThread(new f._cls2._cls1(this, bn1));
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((bb)obj);
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
                a = f1;
                super();
            }
    }

}
