// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.af;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package myobfuscated.af:
//            b

public final class a
{

    private final List a = new ArrayList();

    public a()
    {
    }

    public final com.bumptech.glide.load.a a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = a.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        b b1 = (b)iterator.next();
        if (!b1.a.isAssignableFrom(class1)) goto _L4; else goto _L3
_L3:
        class1 = b1.b;
_L6:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        class1 = null;
        if (true) goto _L6; else goto _L5
_L5:
        class1;
        throw class1;
    }

    public final void a(Class class1, com.bumptech.glide.load.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(new b(class1, a1));
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }
}
