// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a;

import java.lang.reflect.Array;

// Referenced classes of package b.a:
//            l

class f
{

    static int a(int i, int j)
    {
        return i * 37 + j;
    }

    static int a(int i, Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        int k = a(i, 0);
_L4:
        return k;
_L2:
        if (!b(obj))
        {
            return a(i, obj.hashCode());
        }
        int i1 = Array.getLength(obj);
        int j = 0;
        do
        {
            k = i;
            if (j >= i1)
            {
                continue;
            }
            i = a(i, Array.get(obj, j));
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int a(Comparable comparable, Comparable comparable1, int i)
    {
        int k = 0;
        if (comparable == null || comparable1 == null) goto _L2; else goto _L1
_L1:
        k = comparable.compareTo(comparable1);
_L4:
        return k;
_L2:
        int j;
label0:
        {
            if (comparable == null)
            {
                j = k;
                if (comparable1 == null)
                {
                    break label0;
                }
            }
            if (comparable != null || comparable1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            j = -1;
        }
_L5:
        k = j;
        if (l.b == i)
        {
            return j * -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        j = k;
        if (comparable != null)
        {
            j = k;
            if (comparable1 == null)
            {
                j = 1;
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    static String a(Object obj)
    {
        return (new StringBuilder("'")).append(String.valueOf(obj)).append("'").toString();
    }

    static boolean a(Object obj, Object obj1)
    {
        if (b(obj) || b(obj1))
        {
            throw new IllegalArgumentException("This method does not currently support arrays.");
        }
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    static boolean a(String s)
    {
        return s != null && s.trim().length() > 0;
    }

    private static boolean b(Object obj)
    {
        return obj != null && obj.getClass().isArray();
    }
}
