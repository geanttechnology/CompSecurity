// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.CountDownTimer;

public final class acs extends CountDownTimer
{

    private acr a;

    public acs(acr acr1, long l, long l1)
    {
        a = acr1;
        super(l, 1000L);
    }

    public final void onFinish()
    {
        a.c = 0L;
        a.e = false;
        a.f = true;
        bw.a(a.d).a(new Intent("time_limit_expired_intent"));
    }

    public final void onTick(long l)
    {
        a.c = l;
        bw.a(a.d).a(new Intent("time_limit_update_intent"));
    }
}
