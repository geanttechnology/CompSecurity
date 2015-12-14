// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.af;

import com.bumptech.glide.load.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package myobfuscated.af:
//            f

public final class e
{

    private final List a = new ArrayList();

    public e()
    {
    }

    public final List a(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            myobfuscated.af.f f1 = (myobfuscated.af.f)iterator.next();
            if (f1.a(class1, class2))
            {
                arraylist.add(f1.b);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        class1;
        throw class1;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public final void a(f f1, Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(new myobfuscated.af.f(class1, class2, f1));
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public final List b(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            myobfuscated.af.f f1 = (myobfuscated.af.f)iterator.next();
            if (f1.a(class1, class2))
            {
                arraylist.add(f1.a);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        class1;
        throw class1;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public final void b(f f1, Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(0, new myobfuscated.af.f(class1, class2, f1));
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }
}
