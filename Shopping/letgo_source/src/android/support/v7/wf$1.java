// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            wf, wb, we, wg

class a
    implements Runnable
{

    final wb a;
    final wf b;

    public void run()
    {
        a.h().a(a);
        for (Iterator iterator = wf.a(b).iterator(); iterator.hasNext(); ((wg)iterator.next()).a(a)) { }
        wf.a(b, a);
    }

    (wf wf1, wb wb1)
    {
        b = wf1;
        a = wb1;
        super();
    }
}
