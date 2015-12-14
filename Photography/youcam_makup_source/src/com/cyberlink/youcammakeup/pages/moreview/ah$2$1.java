// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.os.Handler;
import com.cyberlink.youcammakeup.database.more.f.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aa;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bo;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ah

class a
    implements Runnable
{

    final bo a;
    final ger.task.bo b;

    public void run()
    {
        Collection collection = a.a();
        b b1;
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ah.f(b.b).put(Long.valueOf(b1.a()), b1))
        {
            b1 = (b)iterator.next();
            long l = b1.a();
            ah.e(b.b).add(Long.valueOf(l));
        }

        ah ah1 = b.b;
        boolean flag;
        if (collection.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ah.d(ah1, flag);
        if (ah.g(b.b) && ah.h(b.b) != a.b())
        {
            ah.a(b.b, a.b());
            z.e(ah.a(b.b), ah.h(b.b));
            com.cyberlink.youcammakeup.pages.moreview.ah.b(b.b, false);
        }
        b.b.notifyDataSetChanged();
        ah.c(b.b);
    }

    ger.task.bo(ger.task.bo bo1, bo bo2)
    {
        b = bo1;
        a = bo2;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ah$2

/* anonymous class */
    class ah._cls2
        implements aa
    {

        final ah a;

        public void a(bn bn1)
        {
            ah.d(a).post(new ah._cls2._cls2(bn1));
        }

        public void a(bo bo1)
        {
            ah.d(a).post(new ah._cls2._cls1(this, bo1));
        }

        public volatile void a(Object obj)
        {
            a((bo)obj);
        }

        public void a(Void void1)
        {
            ah.d(a).post(new ah._cls2._cls3());
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

        // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ah$2$2

/* anonymous class */
        class ah._cls2._cls2
            implements Runnable
        {

            final bn a;
            final ah._cls2 b;

            public void run()
            {
                ah.c(b.a);
                ah.a(b.a, NetworkManager.a(a.a()));
            }

                    
                    {
                        b = ah._cls2.this;
                        a = bn1;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ah$2$3

/* anonymous class */
        class ah._cls2._cls3
            implements Runnable
        {

            final ah._cls2 a;

            public void run()
            {
                ah.c(a.a);
                ah.a(a.a, "");
            }

                    
                    {
                        a = ah._cls2.this;
                        super();
                    }
        }

    }

}
