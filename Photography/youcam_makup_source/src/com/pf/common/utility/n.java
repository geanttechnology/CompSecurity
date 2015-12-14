// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import com.cyberlink.youcammakeup.Globals;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pf.common.utility:
//            o, q

public final class n
{

    private final WeakReference a;
    private final o b = new o(this);

    public n(q q1)
    {
        a = new WeakReference(q1);
        Globals.d().registerComponentCallbacks(b);
    }

    public static int a(int i, int j)
    {
        if (j >= 80)
        {
            return -1;
        }
        if (j >= 40)
        {
            return i / 4;
        }
        if (j >= 20)
        {
            return i / 2;
        } else
        {
            return (i * 3) / 4;
        }
    }

    static q a(n n1)
    {
        return n1.b();
    }

    private q b()
    {
        q q1 = (q)a.get();
        if (q1 == null)
        {
            a();
        }
        return q1;
    }

    public void a()
    {
        Globals.d().unregisterComponentCallbacks(b);
    }
}
