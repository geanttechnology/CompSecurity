// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import bm;
import bq;
import java.util.Hashtable;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            f

public final class a
    implements Runnable
{

    private bq a;
    private f b;

    public final void run()
    {
        a a1 = (a)f.a(b).remove(a);
        if (f.d().b())
        {
            f.d().b((new StringBuilder("TIMER run() _pendingTimerTasks.size():")).append(f.a(b).size()).append(", this:").append(this).append(", r:").append(a1).toString());
        }
        if (a1 != null)
        {
            a1.a.run();
        }
    }

    public (f f1, bq bq1)
    {
        b = f1;
        super();
        a = bq1;
        f.a(f1).put(bq1, this);
    }
}
