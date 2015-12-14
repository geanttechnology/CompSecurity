// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager, l, a

class b
    implements l
{

    final String a;
    final com.cyberlink.youcammakeup.kernelctrl.networkmanager.l b;
    final NetworkManager c;

    public void a(a a1)
    {
        b.d(a1);
    }

    public void a(bn bn1)
    {
        b.b(bn1);
    }

    public void a(File file)
    {
        File file1 = new File(a);
        file.renameTo(file1);
        b.a(file1.toString());
    }

    public volatile void a(Object obj)
    {
        a((File)obj);
    }

    public void a(Void void1)
    {
        b.c(void1);
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

    (NetworkManager networkmanager, String s, com.cyberlink.youcammakeup.kernelctrl.networkmanager.l l1)
    {
        c = networkmanager;
        a = s;
        b = l1;
        super();
    }
}
