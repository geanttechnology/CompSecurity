// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.sku.g;
import com.cyberlink.youcammakeup.utility.be;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            l, f, h, b

class e
    implements l
{

    final com.cyberlink.youcammakeup.kernelctrl.sku.nfo.DownloadType a;
    final g b;
    final h c;
    final b d;
    final NetworkManager e;

    public void a(a a1)
    {
        c.a(a1);
    }

    public void a(bn bn1)
    {
        c.a(bn1);
    }

    public void a(File file)
    {
        Object obj;
        String s;
        s = be.a(file.getPath().toString());
        obj = "";
        if (a != com.cyberlink.youcammakeup.kernelctrl.sku.nfo.DownloadType.a) goto _L2; else goto _L1
_L1:
        obj = b.a().n();
_L4:
        if (!s.equals(obj))
        {
            obj = new bn(null, new Exception("MD5 error"));
            c.a(((bn) (obj)));
            file.delete();
        }
        obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.f.a(b, file);
        if (!NetworkManager.a())
        {
            file.delete();
        }
        if (obj == null)
        {
            file = new bn(null, new Exception("unzip failed"));
            c.a(file);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (a == com.cyberlink.youcammakeup.kernelctrl.sku.nfo.DownloadType.b)
        {
            obj = b.a().o();
        } else
        if (a == com.cyberlink.youcammakeup.kernelctrl.sku.nfo.DownloadType.c)
        {
            obj = b.a().p();
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (d != null)
        {
            d.a(((File) (obj)), b);
            d.a(e, b);
        }
        c.a(((File) (obj)).getAbsolutePath());
        return;
    }

    public volatile void a(Object obj)
    {
        a((File)obj);
    }

    public void a(Void void1)
    {
        c.a();
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

    kManager(com.cyberlink.youcammakeup.kernelctrl.sku.nfo.DownloadType downloadtype, g g1, h h1, b b1, NetworkManager networkmanager)
    {
        a = downloadtype;
        b = g1;
        c = h1;
        d = b1;
        e = networkmanager;
        super();
    }
}
