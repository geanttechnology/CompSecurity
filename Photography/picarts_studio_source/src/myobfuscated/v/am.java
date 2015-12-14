// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.v:
//            ap, an, ao, ag, 
//            ae, ak

public final class am
{

    private static final ap a = new ap();
    private static final ae b = new an((byte)0);
    private final List c;
    private final Context d;
    private final Set e;
    private final android.support.v4.util.Pools.Pool f;

    public am(Context context, android.support.v4.util.Pools.Pool pool)
    {
        this(context, pool, a);
    }

    private am(Context context, android.support.v4.util.Pools.Pool pool, ap ap1)
    {
        c = new ArrayList();
        e = new HashSet();
        f = pool;
        d = context.getApplicationContext();
    }

    private ae a(ao ao1)
    {
        return (ae)m.a(ao1.b.build(d, this), "Argument must not be null");
    }

    final List a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        try
        {
            arraylist = new ArrayList();
            Iterator iterator = c.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ao ao1 = (ao)iterator.next();
                if (!e.contains(ao1) && ao1.a(class1))
                {
                    e.add(ao1);
                    arraylist.add(a(ao1));
                    e.remove(ao1);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_120;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1) { }
        finally
        {
            this;
        }
        e.clear();
        throw class1;
        throw class1;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public final ae a(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = c.iterator();
        boolean flag = false;
_L1:
        ao ao1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        ao1 = (ao)iterator.next();
        if (!e.contains(ao1))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        flag = true;
          goto _L1
        boolean flag1;
        if (ao1.a(class1) && ao1.a.isAssignableFrom(class2))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L1; else goto _L2
_L2:
        e.add(ao1);
        arraylist.add(a(ao1));
        e.remove(ao1);
          goto _L1
        class1;
        e.clear();
        throw class1;
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        if (arraylist.size() <= 1) goto _L4; else goto _L3
_L3:
        class1 = new ak(arraylist, f);
_L6:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L4:
label0:
        {
            if (arraylist.size() != 1)
            {
                break label0;
            }
            class1 = (ae)arraylist.get(0);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        class1 = b;
          goto _L6
        throw new com.bumptech.glide.Registry.NoModelLoaderAvailableException(class1, class2);
          goto _L1
    }

    final void a(Class class1, Class class2, ag ag1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = new ao(class1, class2, ag1);
        c.add(c.size(), class1);
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    final List b(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        Iterator iterator = c.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ao ao1 = (ao)iterator.next();
            if (!arraylist.contains(ao1.a) && ao1.a(class1))
            {
                arraylist.add(ao1.a);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_83;
        class1;
        throw class1;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

}
