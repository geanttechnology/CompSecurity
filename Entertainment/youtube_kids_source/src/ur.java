// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

final class ur
    implements Runnable
{

    private Handler a;
    private uq b;

    ur(uq uq1, Handler handler)
    {
        b = uq1;
        a = handler;
        super();
    }

    public final void run()
    {
        uq.a(b, a, b.n);
    }
}
