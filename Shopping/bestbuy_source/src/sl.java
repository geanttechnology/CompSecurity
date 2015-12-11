// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

public class sl
{

    private final Handler a;

    public sl(Handler handler)
    {
        a = handler;
    }

    public void a(Runnable runnable)
    {
        a.removeCallbacks(runnable);
    }

    public boolean a(Runnable runnable, long l)
    {
        return a.postDelayed(runnable, l);
    }
}
