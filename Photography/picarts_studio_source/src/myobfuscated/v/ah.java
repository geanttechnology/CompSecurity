// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package myobfuscated.v:
//            am, ai, aj, ae, 
//            ag

public final class ah
{

    private final am a;
    private final ai b;

    public ah(Context context, android.support.v4.util.Pools.Pool pool)
    {
        this(new am(context, pool));
    }

    private ah(am am1)
    {
        b = new ai((byte)0);
        a = am1;
    }

    public final List a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = a.b(class1);
        this;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        throw class1;
    }

    public final List a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        Object obj2;
        obj2 = obj.getClass();
        obj1 = (aj)b.a.get(obj2);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        obj1 = null;
_L1:
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        obj1 = Collections.unmodifiableList(a.a(((Class) (obj2))));
        if ((aj)b.a.put(obj2, new aj(((List) (obj1)))) != null)
        {
            throw new IllegalStateException((new StringBuilder("Already cached loaders for model: ")).append(obj2).toString());
        }
        break MISSING_BLOCK_LABEL_110;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj1 = ((aj) (obj1)).a;
          goto _L1
        int j;
        j = ((List) (obj1)).size();
        obj2 = new ArrayList(j);
        int i = 0;
_L4:
        if (i >= j) goto _L3; else goto _L2
_L2:
        ae ae1 = (ae)((List) (obj1)).get(i);
        if (ae1.handles(obj))
        {
            ((List) (obj2)).add(ae1);
        }
        i++;
          goto _L4
_L3:
        return ((List) (obj2));
    }

    public final void a(Class class1, Class class2, ag ag)
    {
        this;
        JVM INSTR monitorenter ;
        a.a(class1, class2, ag);
        b.a.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }
}
