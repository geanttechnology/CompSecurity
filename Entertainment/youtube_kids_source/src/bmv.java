// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Process;

final class bmv
    implements Runnable
{

    private Runnable a;
    private bmu b;

    bmv(bmu bmu1, Runnable runnable)
    {
        b = bmu1;
        a = runnable;
        super();
    }

    public final void run()
    {
        Process.setThreadPriority(bmu.a(b));
        a.run();
    }
}
