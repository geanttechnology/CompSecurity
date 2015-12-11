// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.Handler;
import java.util.concurrent.locks.Lock;

final class aws
    implements awk
{

    private awq a;

    aws(awq awq1)
    {
        a = awq1;
        super();
    }

    public final void a(int i)
    {
        a.b.lock();
        a.a(i);
        i;
        JVM INSTR tableswitch 1 2: default 44
    //                   1 82
    //                   2 57;
           goto _L1 _L2 _L3
_L1:
        a.b.unlock();
        return;
_L3:
        a.a();
          goto _L1
        Exception exception;
        exception;
        a.b.unlock();
        throw exception;
_L2:
        boolean flag = a.e();
        if (flag)
        {
            a.b.unlock();
            return;
        }
        a.f = a.a;
        a.h.sendMessageDelayed(a.h.obtainMessage(1), a.g);
          goto _L1
    }

    public final void a(Bundle bundle)
    {
        a.b.lock();
        if (a.e != 1)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        a.i.putAll(bundle);
        awq.a(a);
        a.b.unlock();
        return;
        bundle;
        a.b.unlock();
        throw bundle;
    }
}
