// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

public final class acr
{

    public CountDownTimer a;
    public long b;
    public long c;
    public final Context d;
    public boolean e;
    public boolean f;

    public acr(Context context)
    {
        d = context;
        c();
    }

    private void c()
    {
        b = 0x1b7740L;
        c = b;
        e = false;
        f = false;
    }

    public final long a()
    {
        return (long)Math.ceil((double)c / 60000D);
    }

    public final void b()
    {
        if (a != null)
        {
            a.cancel();
            a = null;
            bw.a(d).a(new Intent("time_limit_cancel_intent"));
        }
        c();
    }
}
