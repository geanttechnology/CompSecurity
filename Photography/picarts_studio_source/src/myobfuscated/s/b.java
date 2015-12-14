// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.s:
//            k, o, a, m, 
//            i, n

public final class b
{

    private k a;
    private o b;
    private Map c;
    private Map d;
    private int e;
    private int f;

    public b(int j)
    {
        a = new k();
        b = new o((byte)0);
        c = new HashMap();
        d = new HashMap();
        e = j;
    }

    private NavigableMap a(Class class1)
    {
        NavigableMap navigablemap = (NavigableMap)c.get(class1);
        Object obj = navigablemap;
        if (navigablemap == null)
        {
            obj = new TreeMap();
            c.put(class1, obj);
        }
        return ((NavigableMap) (obj));
    }

    private a b(Class class1)
    {
        a a1 = (a)d.get(class1);
        Object obj = a1;
        if (a1 == null)
        {
            if (class1.equals([I))
            {
                obj = new myobfuscated.s.m();
            } else
            if (class1.equals([B))
            {
                obj = new i();
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("No array pool found for: ")).append(class1.getSimpleName()).toString());
            }
            d.put(class1, obj);
        }
        return ((a) (obj));
    }

    private void b(int j)
    {
        do
        {
            if (f <= j)
            {
                break;
            }
            Object obj = a.a();
            m.a(obj, "Argument must not be null");
            a a1 = b(obj.getClass());
            f = f - a1.a(obj) * a1.b();
            b(a1.a(obj), obj.getClass());
            if (Log.isLoggable(a1.a(), 2))
            {
                (new StringBuilder("evicted: ")).append(a1.a(obj));
            }
        } while (true);
    }

    private void b(int j, Class class1)
    {
        class1 = a(class1);
        Integer integer = (Integer)class1.get(Integer.valueOf(j));
        if (integer == null)
        {
            throw new NullPointerException((new StringBuilder("Tried to decrement empty size, size: ")).append(j).append(", this: ").append(this).toString());
        }
        if (integer.intValue() == 1)
        {
            class1.remove(Integer.valueOf(j));
            return;
        } else
        {
            class1.put(Integer.valueOf(j), Integer.valueOf(integer.intValue() - 1));
            return;
        }
    }

    public final Object a(int j, Class class1)
    {
        boolean flag2 = true;
        a a1 = b(class1);
        this;
        JVM INSTR monitorenter ;
        Object obj = (Integer)a(class1).ceilingKey(Integer.valueOf(j));
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1;
        if (f != 0 && e / f < 2)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        flag1 = flag2;
        if (flag) goto _L4; else goto _L3
_L3:
        if (((Integer) (obj)).intValue() > j * 8) goto _L2; else goto _L5
_L5:
        flag1 = flag2;
_L4:
        if (!flag1) goto _L7; else goto _L6
_L6:
        obj = b.a(((Integer) (obj)).intValue(), class1);
_L9:
        obj = a.a(((s) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        f = f - a1.a(obj) * a1.b();
        b(a1.a(obj), class1);
        this;
        JVM INSTR monitorexit ;
          goto _L8
_L2:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L7:
        obj = b.a(j, class1);
          goto _L9
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
_L8:
        if (obj != null)
        {
            a1.b(obj);
            return obj;
        }
        if (Log.isLoggable(a1.a(), 2))
        {
            (new StringBuilder("Allocated ")).append(j).append(" bytes");
        }
        return a1.a(j);
        if (true) goto _L4; else goto _L10
_L10:
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        b(0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (j < 40) goto _L2; else goto _L1
_L1:
        a();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j < 20)
        {
            continue; /* Loop/switch isn't completed */
        }
        b(e / 2);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Object obj, Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        int j;
        int l;
        a1 = b(class1);
        l = a1.a(obj);
        j = e / 2;
        boolean flag;
        if (l <= j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i1;
        n n1 = b.a(l, class1);
        a.a(n1, obj);
        obj = a(class1);
        class1 = (Integer)((NavigableMap) (obj)).get(Integer.valueOf(n1.a));
        i1 = n1.a;
        if (class1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
_L4:
        ((NavigableMap) (obj)).put(Integer.valueOf(i1), Integer.valueOf(flag));
        f = f + a1.b() * l;
        b(e);
        if (true) goto _L1; else goto _L3
        obj;
        throw obj;
_L3:
        flag = class1.intValue();
        flag++;
          goto _L4
    }
}
