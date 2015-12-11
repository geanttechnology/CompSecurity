// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.CountDownTimer;
import android.widget.TextView;

final class acu extends CountDownTimer
{

    private act a;

    acu(act act1, long l, long l1)
    {
        a = act1;
        super(3200L, 1000L);
    }

    public final void onFinish()
    {
        this;
        JVM INSTR monitorenter ;
        act.e(a);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onTick(long l)
    {
        this;
        JVM INSTR monitorenter ;
        TextView textview = act.d(a);
        l /= 1000L;
        textview.setText((new StringBuilder(20)).append(l).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
