// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ax;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager

class e
{

    final com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e a;
    final ax b;
    final NetworkManager c;

    public e(NetworkManager networkmanager, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e e1, ax ax)
    {
        c = networkmanager;
        super();
        if (e1 == null || ax == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            a = e1;
            b = ax;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof e) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s;
        String s1;
        boolean flag;
        boolean flag1;
        obj = (e)obj;
        flag1 = true;
        s = a.m();
        s1 = ((e) (obj)).a.m();
        if (s != null || s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = false;
_L4:
        if (a.l() == ((e) (obj)).a.l())
        {
            return flag;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (!s.equals(s1))
            {
                flag = false;
            }
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public int hashCode()
    {
        if (a.m() != null)
        {
            return a.m().hashCode();
        } else
        {
            return (int)a.l();
        }
    }
}
