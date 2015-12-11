// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;

final class cmy
    implements Runnable
{

    private cmw a;

    cmy(cmw cmw1)
    {
        a = cmw1;
        super();
    }

    public final void run()
    {
        Looper.prepare();
        a.b = Looper.myLooper();
        a.d = new Handler();
        Looper.loop();
    }
}
