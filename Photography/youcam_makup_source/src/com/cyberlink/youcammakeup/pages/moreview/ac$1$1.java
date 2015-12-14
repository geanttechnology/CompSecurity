// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.pf.common.utility.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ac

class a
    implements Runnable
{

    final ivity.o a;

    public void run()
    {
        ac.c(a.a).o();
    }

    ger.task.bn(ger.task.bn bn)
    {
        a = bn;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/ac$1

/* anonymous class */
    class ac._cls1
        implements e
    {

        final ac a;

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            if (list == null || list.size() == 0)
            {
                return;
            }
            a a1;
            for (list = list.iterator(); list.hasNext(); ac.b(a).put(Long.valueOf(a1.a()), a1))
            {
                a1 = (a)list.next();
                com.cyberlink.youcammakeup.pages.moreview.ac.a(a).add(Long.valueOf(a1.a()));
            }

            Globals.d(new ac._cls1._cls1(this));
        }

        public void b(Object obj)
        {
            com.cyberlink.youcammakeup.pages.moreview.ac.a(a, "GetStatus", (bn)obj);
        }

        public void c(Object obj)
        {
            m.e(ac.b, obj.toString());
        }

            
            {
                a = ac1;
                super();
            }
    }

}
