// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ay;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ba;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.Deque;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager, RevisionState

class b
    implements ba
{

    final NetworkManager a;
    private int b;

    public void a(ay ay1)
    {
        NetworkManager.a(a, ay1);
        NetworkManager.a(a, new RevisionState(NetworkManager.g(a)));
        NetworkManager.h(a);
        NetworkManager.i(a).a(NetworkManager.g(a));
        NetworkManager.a(a, null);
        z.e(NetworkManager.g(a).o());
    }

    public void a(bn bn1)
    {
label0:
        {
            NetworkManager.a(a, null);
            if (!NetworkManager.a(a, bn1))
            {
                return;
            }
            if (b <= 0)
            {
                if (NetworkManager.j(a).size() <= 0)
                {
                    break label0;
                }
                NetworkManager.a((String)NetworkManager.j(a).remove(0));
                b = 3;
            }
            b = b - 1;
            NetworkManager.e(a).addFirst(NetworkManager.l(a));
            try
            {
                Thread.sleep(NetworkManager.f(a));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (bn bn1)
            {
                return;
            }
        }
        NetworkManager.h(a);
        NetworkManager.k(a);
    }

    public volatile void a(Object obj)
    {
        a((ay)obj);
    }

    public void a(Void void1)
    {
        NetworkManager.h(a);
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    te(NetworkManager networkmanager)
    {
        a = networkmanager;
        super();
        b = 3;
    }
}
