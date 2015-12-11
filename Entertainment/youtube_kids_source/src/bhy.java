// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;

public final class bhy extends bib
{

    private final Handler a;
    private final Thread b;

    private bhy(Handler handler, bhv bhv)
    {
        super(bhv);
        a = (Handler)b.a(handler);
        b = handler.getLooper().getThread();
    }

    public static bhy a(Handler handler, bhv bhv)
    {
        return new bhy(handler, bhv);
    }

    protected final void a(Runnable runnable)
    {
        if (Thread.currentThread() != b)
        {
            a.post(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }
}
