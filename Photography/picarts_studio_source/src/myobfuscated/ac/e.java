// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package myobfuscated.ac:
//            g, f, d

public final class e
{

    private final List a = new ArrayList();

    public e()
    {
    }

    public final d a(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        if (!class2.isAssignableFrom(class1))
        {
            break MISSING_BLOCK_LABEL_18;
        }
        class1 = g.a();
_L1:
        this;
        JVM INSTR monitorexit ;
        return class1;
label0:
        {
            Iterator iterator = a.iterator();
            f f1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                f1 = (f)iterator.next();
            } while (!f1.a(class1, class2));
            class1 = f1.a;
        }
          goto _L1
        throw new IllegalArgumentException((new StringBuilder("No transcoder registered to transcode from ")).append(class1).append(" to ").append(class2).toString());
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public final void a(Class class1, Class class2, d d)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(new f(class1, class2, d));
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    public final List b(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList();
        if (!class2.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
        arraylist.add(class2);
_L4:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        Iterator iterator = a.iterator();
        while (iterator.hasNext()) 
        {
            if (((f)iterator.next()).a(class1, class2))
            {
                arraylist.add(class2);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        class1;
        throw class1;
    }
}
