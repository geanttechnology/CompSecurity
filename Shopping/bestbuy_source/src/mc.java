// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class mc
{

    private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new md());
    private final Activity b;
    private ScheduledFuture c;

    public mc(Activity activity)
    {
        c = null;
        b = activity;
        a();
    }

    private void c()
    {
        if (c != null)
        {
            c.cancel(true);
            c = null;
        }
    }

    public void a()
    {
        c();
        c = a.schedule(new mb(b), 300L, TimeUnit.SECONDS);
    }

    public void b()
    {
        c();
        a.shutdown();
    }
}
