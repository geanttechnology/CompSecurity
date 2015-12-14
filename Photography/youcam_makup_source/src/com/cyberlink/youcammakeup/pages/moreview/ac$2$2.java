// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.b;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ac, DownloadItemUtility

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        Globals.d().i().h(ac.c(a.a));
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ac$2

/* anonymous class */
    class ac._cls2
        implements ao
    {

        final ac a;

        public void a(ap ap1)
        {
label0:
            {
                Object obj = ap1.i().b();
                int i = ((Collection) (obj)).size();
                if (i > 0)
                {
                    if (z.c(Globals.d(), "KEY_MAKEUP_CATEGORY_ALL", Long.valueOf(0L)).longValue() < ap1.c())
                    {
                        z.d(Globals.d(), "KEY_MAKEUP_CATEGORY_ALL", Long.valueOf(ap1.c()));
                    }
                    ac.a(a, new HashMap(i));
                    for (ap1 = ((Collection) (obj)).iterator(); ap1.hasNext(); ac.d(a).put(Long.valueOf(((b) (obj)).a()), obj))
                    {
                        obj = (b)ap1.next();
                    }

                    ap1 = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
                    if (ap1 != null)
                    {
                        break label0;
                    }
                }
                return;
            }
            ap1.runOnUiThread(new ac._cls2._cls1());
        }

        public void a(bn bn1)
        {
            ac.a(a, "GetStatus", bn1);
        }

        public volatile void a(Object obj)
        {
            a((ap)obj);
        }

        public void a(Void void1)
        {
            void1 = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
            if (void1 == null)
            {
                return;
            } else
            {
                void1.runOnUiThread(new ac._cls2._cls2(this));
                return;
            }
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
                a = ac1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ac$2$1

/* anonymous class */
        class ac._cls2._cls1
            implements Runnable
        {

            final ac._cls2 a;

            public void run()
            {
                if (ac.c(a.a) == null)
                {
                    return;
                } else
                {
                    Globals.d().i().h(ac.c(a.a));
                    ac.e(a.a).a(MakeupItemTreeManager.a);
                    return;
                }
            }

                    
                    {
                        a = ac._cls2.this;
                        super();
                    }
        }

    }

}
