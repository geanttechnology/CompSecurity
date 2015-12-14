// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            l, a, e, b

class d
    implements l
{

    final e a;
    final NetworkManager b;
    final b c;
    final f d;

    public void a(a a1)
    {
        b.a(a.l(), a1);
        if (d != null)
        {
            d.d(a1);
        }
    }

    public void a(bn bn1)
    {
        b.a(a.l(), bn1);
        if (d != null)
        {
            d.b(bn1);
        }
    }

    public void a(File file)
    {
        File file1 = com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.a(a, file);
        if (!NetworkManager.a())
        {
            file.delete();
        }
        if (file1 == null)
        {
            file = new bn(null, new Exception("unzip failed"));
            b.a(a.l(), file);
        } else
        {
            c.a(file1, a);
            c.a(b, a);
            c.b(file1, a);
            long l1 = a.l();
            b.b(l1);
            if (d != null)
            {
                d.a(null);
                return;
            }
        }
    }

    public volatile void a(Object obj)
    {
        a((File)obj);
    }

    public void a(Void void1)
    {
        b.c(a.l());
        if (d != null)
        {
            d.c(void1);
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

    public void d(Object obj)
    {
        a((a)obj);
    }

    kManager(e e1, NetworkManager networkmanager, b b1, f f1)
    {
        a = e1;
        b = networkmanager;
        c = b1;
        d = f1;
        super();
    }
}
