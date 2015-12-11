// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.speech.callback.Callback;

final class czu
    implements Callback
{

    volatile boolean a;
    private final Callback b;
    private final czq c;

    czu(Callback callback, czq czq1)
    {
        b = callback;
        c = czq1;
    }

    public final void a(dap dap1)
    {
        if (!a)
        {
            b.onError(dap1);
        }
        c.onError();
    }

    public final void onError(Object obj)
    {
        a((dap)obj);
    }

    public final void onResult(Object obj)
    {
        obj = (exf)obj;
        if (!a)
        {
            b.onResult(obj);
        }
        c.onDataReceived();
    }
}
