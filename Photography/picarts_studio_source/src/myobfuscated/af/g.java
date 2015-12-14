// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.af;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.af:
//            h

public final class g
{

    private List a;

    public g()
    {
        a = new ArrayList();
    }

    public final com.bumptech.glide.load.g a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        int j = a.size();
        int i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L1
_L1:
        h h1 = (h)a.get(i);
        if (!h1.a.isAssignableFrom(class1)) goto _L4; else goto _L3
_L3:
        class1 = h1.b;
_L6:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        class1 = null;
        if (true) goto _L6; else goto _L5
_L5:
        class1;
        throw class1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(Class class1, com.bumptech.glide.load.g g1)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(new h(class1, g1));
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }
}
