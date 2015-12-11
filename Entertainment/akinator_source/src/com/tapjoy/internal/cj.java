// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            ch, cn, cm

public final class cj
    implements Runnable
{

    private final ch a;
    private final cm b;

    protected cj(ch ch1, cm cm1)
    {
        a = ch1;
        b = cm1;
    }

    public final void run()
    {
        Object obj = a.f();
        if (b != null)
        {
            if (!(b instanceof cn))
            {
                break MISSING_BLOCK_LABEL_79;
            }
            obj = b;
            obj = a;
        }
_L2:
        return;
        obj;
        if (b == null) goto _L2; else goto _L1
_L1:
        if (b instanceof cn)
        {
            obj = b;
            obj = a;
            return;
        } else
        {
            b.a(a);
            return;
        }
        b.a(a, obj);
        return;
    }
}
