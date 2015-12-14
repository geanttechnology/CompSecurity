// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import android.content.Context;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.Deque;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager

class c
    implements b
{

    final Context a;
    final NetworkManager b;
    private int c;

    public void a(bn bn1)
    {
        if (!NetworkManager.a(b, bn1))
        {
            return;
        }
        if (c <= 0)
        {
            NetworkManager.a(b, z.b(a));
            return;
        }
        c = c - 1;
        NetworkManager.e(b).addFirst(NetworkManager.d(b));
        try
        {
            Thread.sleep(NetworkManager.f(b));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bn bn1)
        {
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        NetworkManager.a(b, s);
        NetworkManager.a(b, null);
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

    (NetworkManager networkmanager, Context context)
    {
        b = networkmanager;
        a = context;
        super();
        c = 3;
    }
}
