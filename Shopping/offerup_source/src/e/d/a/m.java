// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import android.support.v4.e.a;
import e.f;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package e.d.a:
//            n

final class m extends AtomicLong
    implements f
{

    private n a;

    public m(n n1)
    {
        a = n1;
    }

    public final void a(long l)
    {
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        if (get() != 0x7fffffffffffffffL) goto _L4; else goto _L3
_L3:
        return;
_L4:
        android.support.v4.e.a.a(this, l);
        a.f();
        return;
_L2:
        if (l < 0L)
        {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (true) goto _L3; else goto _L5
_L5:
    }
}
