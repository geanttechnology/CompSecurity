// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.util.ArrayList;
import java.util.Deque;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            d, NetworkManager

class a
    implements d
{

    final ax a;
    final NetworkManager b;

    public void a(Exception exception)
    {
        if (a instanceof a)
        {
            a a1 = (a)a;
            synchronized (NetworkManager.n(b))
            {
                NetworkManager.n(b).remove(Long.valueOf(a1.c().l()));
            }
        }
        a.a(new bn(null, exception));
        NetworkManager.m(b).b(exception);
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        if (NetworkManager.g(b) != null)
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.e(b).addFirst(a);
            NetworkManager.m(b).a(void1);
            return;
        } else
        {
            void1 = new Exception("NetworkManager can't initialize.");
            a.a(new bn(null, void1));
            NetworkManager.m(b).b(void1);
            return;
        }
    }

    public void b(Object obj)
    {
        a((Exception)obj);
    }

    public void b(Void void1)
    {
        NetworkManager.m(b).c(void1);
    }

    public void c(Object obj)
    {
        b((Void)obj);
    }

    (NetworkManager networkmanager, ax ax1)
    {
        b = networkmanager;
        a = ax1;
        super();
    }
}
