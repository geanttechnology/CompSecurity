// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.q;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.r;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ac, ad

class a
    implements Runnable
{

    final q a;
    final ger.task.q b;

    public void run()
    {
        if (ac.c(b.b) != null)
        {
            Object obj = new ArrayList();
            Map map = a.b();
            for (Iterator iterator = b.b.iterator(); iterator.hasNext(); ((List) (obj)).add(map.get((String)iterator.next()))) { }
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                r r1 = (r)((Iterator) (obj)).next();
                if (r1 != null && r1.a != null && r1.b != null)
                {
                    long l = ((Long)b.b.get(r1.a)).longValue();
                    if ((a)ac.b(b.b).get(Long.valueOf(l)) == null && ac.c(b.b) != null)
                    {
                        ac.c(b.b).a(l, 8);
                    } else
                    {
                        com.cyberlink.youcammakeup.pages.moreview.ac.a(b.b, (ad)b.b.get(Long.valueOf(l)));
                        com.cyberlink.youcammakeup.pages.moreview.ac.a(b.b, (a)ac.b(b.b).get(Long.valueOf(l)), r1.b, (ad)b.b.get(Long.valueOf(l)));
                    }
                }
            }
        }
    }

    ger.task.q(ger.task.q q1, q q2)
    {
        b = q1;
        a = q2;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ac$3

/* anonymous class */
    class ac._cls3
        implements t
    {

        final ArrayList a;
        final Map b;
        final Map c;
        final ac d;

        public void a(bn bn1)
        {
            com.cyberlink.youcammakeup.pages.moreview.ac.a(d, "GetDownloadItemTask", bn1);
        }

        public void a(q q1)
        {
            Globals.d(new ac._cls3._cls1(this, q1));
        }

        public volatile void a(Object obj)
        {
            a((q)obj);
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
                d = ac1;
                a = arraylist;
                b = map;
                c = map1;
                super();
            }
    }

}
