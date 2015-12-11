// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a.d;
import b.a.a.aa;
import b.a.a.c;
import b.a.a.c.a;
import b.a.a.i;
import b.a.a.t;
import b.a.a.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package b.a.a.d:
//            t, x, u, v

final class n
    implements b.a.a.d.t, x
{

    private static Map a = new HashMap();
    private final b.a.a.d b;
    private final boolean c;

    n(b.a.a.d d1, boolean flag)
    {
        b = d1;
        c = flag;
    }

    public final int a()
    {
        return !c ? 20 : 6;
    }

    public final int a(b.a.a.d.u u1, String s, int j)
    {
        Locale locale = u1.d;
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Object obj = (Map)a.get(locale);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj = new HashMap();
        a.put(locale, obj);
        Object obj1 = ((Object) ((Object[])((Map) (obj)).get(b)));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj2;
        b.a.a.d d1;
        obj1 = new HashSet(32);
        obj2 = new t(i.a);
        d1 = b;
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        u1;
        map;
        JVM INSTR monitorexit ;
        throw u1;
        int k;
        int i1;
        c c1 = d1.a(((d) (obj2)).b);
        if (!c1.c())
        {
            throw new IllegalArgumentException((new StringBuilder("Field '")).append(d1).append("' is not supported").toString());
        }
        obj2 = new u(((t) (obj2)), c1);
        k = ((a) (obj2)).a().g();
        i1 = ((a) (obj2)).a().h();
        if (i1 - k <= 32)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        map;
        JVM INSTR monitorexit ;
        return ~j;
        int l = ((a) (obj2)).a().a(locale);
_L4:
        if (k > i1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((u) (obj2)).a.a(((u) (obj2)).b.b(((d) (((u) (obj2)).a)).a, k));
        ((Set) (obj1)).add(((u) (obj2)).b(locale));
        ((Set) (obj1)).add(((u) (obj2)).b(locale).toLowerCase(locale));
        ((Set) (obj1)).add(((u) (obj2)).b(locale).toUpperCase(locale));
        ((Set) (obj1)).add(((u) (obj2)).a(locale));
        ((Set) (obj1)).add(((u) (obj2)).a(locale).toLowerCase(locale));
        ((Set) (obj1)).add(((u) (obj2)).a(locale).toUpperCase(locale));
        k++;
        if (true) goto _L4; else goto _L3
_L3:
        k = l;
        if (!"en".equals(locale.getLanguage()))
        {
            break MISSING_BLOCK_LABEL_465;
        }
        k = l;
        if (b != b.a.a.d.w())
        {
            break MISSING_BLOCK_LABEL_465;
        }
        ((Set) (obj1)).add("BCE");
        ((Set) (obj1)).add("bce");
        ((Set) (obj1)).add("CE");
        ((Set) (obj1)).add("ce");
        k = 3;
        ((Map) (obj)).put(b, ((Object) (new Object[] {
            obj1, Integer.valueOf(k)
        })));
        obj = obj1;
_L8:
        map;
        JVM INSTR monitorexit ;
        k = Math.min(s.length(), k + j);
_L6:
        if (k <= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = s.substring(j, k);
        if (((Set) (obj)).contains(obj1))
        {
            u1.a(new v(b.a(u1.a), ((String) (obj1)), locale));
            return k;
        }
        k--;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = (Set)obj1[0];
        k = ((Integer)obj1[1]).intValue();
        continue; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        return ~j;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(StringBuffer stringbuffer, long l, b.a.a.a a1, int j, i k, Locale locale)
    {
        a1 = b.a(a1);
        if (!c)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        a1 = a1.b(l, locale);
_L1:
        stringbuffer.append(a1);
        return;
        try
        {
            a1 = a1.a(l, locale);
        }
        // Misplaced declaration of an exception variable
        catch (b.a.a.a a1)
        {
            stringbuffer.append('\uFFFD');
            return;
        }
          goto _L1
    }

    public final void a(StringBuffer stringbuffer, aa aa1, Locale locale)
    {
        c c1;
        if (!aa1.b(b))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        c1 = b.a(aa1.a());
        if (!c) goto _L2; else goto _L1
_L1:
        aa1 = c1.b(aa1, locale);
_L3:
        stringbuffer.append(aa1);
        return;
_L2:
        try
        {
            aa1 = c1.a(aa1, locale);
        }
        // Misplaced declaration of an exception variable
        catch (aa aa1)
        {
            stringbuffer.append('\uFFFD');
            return;
        }
          goto _L3
        aa1 = "\uFFFD";
          goto _L3
    }

    public final int b()
    {
        return a();
    }

}
