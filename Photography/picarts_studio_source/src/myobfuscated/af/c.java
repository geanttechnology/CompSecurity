// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.af;

import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.engine.ab;
import java.util.concurrent.atomic.AtomicReference;
import myobfuscated.aj.i;

public final class c
{

    public final ArrayMap a = new ArrayMap();
    private final AtomicReference b = new AtomicReference();

    public c()
    {
    }

    private i c(Class class1, Class class2, Class class3)
    {
        i k = (i)b.getAndSet(null);
        i j = k;
        if (k == null)
        {
            j = new i();
        }
        j.a(class1, class2, class3);
        return j;
    }

    public final boolean a(Class class1, Class class2, Class class3)
    {
        class2 = c(class1, class2, class3);
        boolean flag;
        synchronized (a)
        {
            flag = a.containsKey(class2);
        }
        b.set(class2);
        return flag;
        class2;
        class1;
        JVM INSTR monitorexit ;
        throw class2;
    }

    public final ab b(Class class1, Class class2, Class class3)
    {
        class2 = c(class1, class2, class3);
        synchronized (a)
        {
            class3 = (ab)a.get(class2);
        }
        b.set(class2);
        return class3;
        class2;
        class1;
        JVM INSTR monitorexit ;
        throw class2;
    }
}
