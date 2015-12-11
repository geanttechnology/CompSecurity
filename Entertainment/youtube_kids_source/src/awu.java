// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.locks.Lock;

final class awu
    implements avt
{

    private awc a;
    private awq b;

    awu(awq awq1, awc awc)
    {
        b = awq1;
        a = awc;
        super();
    }

    public final void a(avq avq)
    {
        b.b.lock();
label0:
        {
            if (b.c != null)
            {
                awc awc = a;
                if (0x7fffffff >= b.d)
                {
                    break label0;
                }
            }
            b.c = avq;
            avq = b;
            awc awc1 = a;
            avq.d = 0x7fffffff;
        }
        awq.a(b);
        b.b.unlock();
        return;
        avq;
        b.b.unlock();
        throw avq;
    }
}
