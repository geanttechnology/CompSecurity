// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.wearable.internal.ap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class awb extends avx
{

    private final List a;

    awb(qk qk, List list)
    {
        super(qk);
        a = list;
    }

    public void a(ap ap1)
    {
        a(new awj(avt.a(ap1.b), ap1.c));
        if (ap1.b != 0)
        {
            for (ap1 = a.iterator(); ap1.hasNext(); ((FutureTask)ap1.next()).cancel(true)) { }
        }
    }
}
