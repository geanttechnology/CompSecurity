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

class c
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
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(d, new g(bh1, i) {

                final bh a;
                final int b;
                final a._cls2 c;
                private int d;

                public void c(long l)
                {
                    Iterator iterator1 = a.b().iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        if (((c)iterator1.next()).a() == l)
                        {
                            d = d + 1;
                        }
                    } while (true);
                    Log.i("CollageTemplateRequest", (new StringBuilder()).append("requestCollageTemplatesList download (").append(d).append("/").append(b).append(")").toString());
                    if (d == b)
                    {
                        z.a("BEFORE_AFTER_COLLAGE_LAST_MODIFIED_DATE", Long.valueOf(c.a), Globals.d().getApplicationContext());
                        z.a("BEFORE_AFTER_COLLAGE_DOWNLOADED", Boolean.valueOf(true), Globals.d().getApplicationContext());
                        c.b.b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(c.d));
                    }
                }

            
            {
                c = a._cls2.this;
                a = bh1;
                b = i;
                super();
                d = 0;
            }
            });
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

    kManager(a a1, long l, NetworkManager networkmanager, int i)
    {
        d = a1;
        a = l;
        b = networkmanager;
        c = i;
        super();
    }
}
