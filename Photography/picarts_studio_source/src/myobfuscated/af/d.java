// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.af;

import android.support.v4.util.ArrayMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import myobfuscated.aj.i;

public final class d
{

    public final ArrayMap a = new ArrayMap();
    private final AtomicReference b = new AtomicReference();

    public d()
    {
    }

    public final List a(Class class1, Class class2)
    {
        Object obj = (i)b.getAndSet(null);
        if (obj == null)
        {
            class1 = new i(class1, class2);
        } else
        {
            ((i) (obj)).a(class1, class2, null);
            class1 = ((Class) (obj));
        }
        synchronized (a)
        {
            obj = (List)a.get(class1);
        }
        b.set(class1);
        return ((List) (obj));
        class1;
        class2;
        JVM INSTR monitorexit ;
        throw class1;
    }
}
