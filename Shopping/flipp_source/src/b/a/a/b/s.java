// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.a;
import b.a.a.i;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package b.a.a.b:
//            i, v, a, b

public final class s extends b.a.a.b.i
{

    private static final s l;
    private static final Map m = new HashMap();

    private s(a a1, int j)
    {
        super(a1, j);
    }

    public static s U()
    {
        return l;
    }

    private static s a(i j, int k)
    {
        i i1;
        i1 = j;
        if (j == null)
        {
            i1 = i.a();
        }
        Map map = m;
        map;
        JVM INSTR monitorenter ;
        j = (s[])m.get(i1);
        Object obj;
        obj = j;
        if (j != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj = new s[7];
        m.put(i1, obj);
        Object obj1;
        obj1 = obj[k - 1];
        j = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        if (i1 != i.a) goto _L4; else goto _L3
_L3:
        j = new s(null, k);
          goto _L5
_L2:
        map;
        JVM INSTR monitorexit ;
        return j;
        j;
        map;
        JVM INSTR monitorexit ;
        throw j;
_L4:
        j = new s(b.a.a.b.v.a(a(i.a, k), i1), k);
_L5:
        obj[k - 1] = j;
        if (true) goto _L2; else goto _L6
_L6:
    }

    final int N()
    {
        return 0xee943c92;
    }

    final int O()
    {
        return 0x116bd2d1;
    }

    final long Q()
    {
        return 0x758f0dfc0L;
    }

    final long R()
    {
        return 0x9cbebd50L;
    }

    public final a a(i j)
    {
        i k = j;
        if (j == null)
        {
            k = i.a();
        }
        if (k == a())
        {
            return this;
        } else
        {
            return a(k, 4);
        }
    }

    protected final void a(b b1)
    {
        if (super.a == null)
        {
            super.a(b1);
        }
    }

    public final a b()
    {
        return l;
    }

    final boolean c(int j)
    {
        return (j & 3) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    final long d(int j)
    {
        int k = j / 100;
        if (j >= 0) goto _L2; else goto _L1
_L1:
        k = ((k + 3 >> 2) + ((j + 3 >> 2) - k)) - 1;
_L4:
        long l1 = j;
        return ((long)(k - 0xafaa7) + l1 * 365L) * 0x5265c00L;
_L2:
        int i1 = (k >> 2) + ((j >> 2) - k);
        k = i1;
        if (c(j))
        {
            k = i1 - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        l = a(i.a, 4);
    }
}
