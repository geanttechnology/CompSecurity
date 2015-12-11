// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics;

import com.target.a.a.b;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.target.ui.analytics:
//            f

private abstract class <init>
    implements Runnable
{

    final long submittedTime;
    final f this$0;

    abstract void a();

    boolean a(int i, TimeUnit timeunit, long l)
    {
        long l1 = timeunit.toMillis(i);
        return submittedTime > l1 + l;
    }

    public void run()
    {
        try
        {
            a();
            return;
        }
        catch (Exception exception)
        {
            com.target.a.a.b.a(f.c(), "Error while trying to perform lifecycle metrics work: ", exception);
        }
    }

    private t()
    {
        this$0 = f.this;
        super();
        submittedTime = System.currentTimeMillis();
    }

    Millis(Millis millis)
    {
        this();
    }
}
