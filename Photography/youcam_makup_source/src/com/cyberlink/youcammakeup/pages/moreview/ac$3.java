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

class c
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
        Globals.d(new Runnable(q1) {

            final q a;
            final ac._cls3 b;

            public void run()
            {
                if (ac.c(b.d) != null)
                {
                    Object obj = new ArrayList();
                    Map map = a.b();
                    for (Iterator iterator = b.a.iterator(); iterator.hasNext(); ((List) (obj)).add(map.get((String)iterator.next()))) { }
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        r r1 = (r)((Iterator) (obj)).next();
                        if (r1 != null && r1.a != null && r1.b != null)
                        {
                            long l = ((Long)b.b.get(r1.a)).longValue();
                            if ((a)ac.b(b.d).get(Long.valueOf(l)) == null && ac.c(b.d) != null)
                            {
                                ac.c(b.d).a(l, 8);
                            } else
                            {
                                com.cyberlink.youcammakeup.pages.moreview.ac.a(b.d, (ad)b.c.get(Long.valueOf(l)));
                                com.cyberlink.youcammakeup.pages.moreview.ac.a(b.d, (a)ac.b(b.d).get(Long.valueOf(l)), r1.b, (ad)b.c.get(Long.valueOf(l)));
                            }
                        }
                    }
                }
            }

            
            {
                b = ac._cls3.this;
                a = q1;
                super();
            }
        });
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

    _cls1.a(ac ac1, ArrayList arraylist, Map map, Map map1)
    {
        d = ac1;
        a = arraylist;
        b = map;
        c = map1;
        super();
    }
}
