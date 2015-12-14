// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.d;

import android.util.Log;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.l.c;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bh;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.f;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.d:
//            a

class d
    implements g
{

    final bh a;
    final int b;
    final c c;
    private int d;

    public void c(long l)
    {
        Iterator iterator = a.b().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((c)iterator.next()).a() == l)
            {
                d = d + 1;
            }
        } while (true);
        Log.i("CollageTemplateRequest", (new StringBuilder()).append("requestCollageTemplatesList download (").append(d).append("/").append(b).append(")").toString());
        if (d == b)
        {
            z.a("BEFORE_AFTER_COLLAGE_LAST_MODIFIED_DATE", Long.valueOf(c.c), Globals.d().getApplicationContext());
            z.a("BEFORE_AFTER_COLLAGE_DOWNLOADED", Boolean.valueOf(true), Globals.d().getApplicationContext());
            c.c.b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(c.c));
        }
    }

    anager(anager anager, bh bh1, int i)
    {
        c = anager;
        a = bh1;
        b = i;
        super();
        d = 0;
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/kernelctrl/networkmanager/d/a$2

/* anonymous class */
    class a._cls2
        implements bj
    {

        final long a;
        final NetworkManager b;
        final int c;
        final a d;

        public void a(bh bh1)
        {
            int i = bh1.c();
            f.a("ListTemplateTask");
            f.a("ListTemplateTask", bh1.a());
            if (com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(d) == null)
            {
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(d, new a._cls2._cls1(this, bh1, i));
                b.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(d));
            }
            for (Iterator iterator = bh1.b().iterator(); iterator.hasNext();)
            {
                c c1 = (c)iterator.next();
                try
                {
                    b.a(c1.a(), c1, null);
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
            }

            if (bh1.b().size() + c < i)
            {
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(d, b, bh1.b().size() + c, a);
            }
        }

        public void a(bn bn1)
        {
            if (bn1 == null);
        }

        public volatile void a(Object obj)
        {
            a((bh)obj);
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
                d = a1;
                a = l;
                b = networkmanager;
                c = i;
                super();
            }
    }

}
