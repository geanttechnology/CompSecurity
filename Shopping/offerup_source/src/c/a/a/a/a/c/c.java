// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package c.a.a.a.a.c:
//            k, a

final class c extends k
{

    private a b;

    c(a a1)
    {
        b = a1;
        super((byte)0);
    }

    public final Object call()
    {
        a.a(b).set(true);
        Process.setThreadPriority(10);
        return a.a(b, b.a(a));
    }
}
