// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.util.Log;
import com.cyberlink.you.g;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.friends:
//            l, q

final class b extends Thread
{

    final String a;
    final boolean b;

    public void run()
    {
        boolean flag;
        Thread.currentThread().setName("loadCommandUrl");
        flag = l.a(g.a().e(g.a()), a, b);
        Object obj = l.k();
        obj;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        Log.d("FriendsClient", "init success.");
        for (Iterator iterator = l.l().iterator(); iterator.hasNext(); ((q)iterator.next()).a()) { }
        break MISSING_BLOCK_LABEL_130;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Log.d("FriendsClient", "init fail.");
        for (Iterator iterator1 = l.l().iterator(); iterator1.hasNext(); ((q)iterator1.next()).b()) { }
        l.l().clear();
        l.a(false);
        obj;
        JVM INSTR monitorexit ;
    }

    (String s, boolean flag)
    {
        a = s;
        b = flag;
        super();
    }
}
