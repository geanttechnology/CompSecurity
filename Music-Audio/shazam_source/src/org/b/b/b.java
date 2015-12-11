// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.b;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.b.a;

// Referenced classes of package org.b.b:
//            a

class b
    implements a
{

    private final ConcurrentMap a = new ConcurrentHashMap();

    b()
    {
    }

    private static String b(String s)
    {
        int i = s.length();
        int j = s.lastIndexOf('.');
        if (j != -1 && i - (j + 1) <= 23)
        {
            return s.substring(j + 1);
        } else
        {
            return (new StringBuilder("*")).append(s.substring((i - 23) + 1)).toString();
        }
    }

    public final org.b.b a(String s)
    {
        int j = 0;
        if (s != null) goto _L2; else goto _L1
_L1:
        Object obj = "null";
_L4:
        org.b.b b1 = (org.b.b)a.get(obj);
        s = b1;
        if (b1 == null)
        {
            org.b.b.a a1 = new org.b.b.a(((String) (obj)));
            obj = (org.b.b)a.putIfAbsent(obj, a1);
            s = ((String) (obj));
            if (obj == null)
            {
                s = a1;
            }
        }
        return s;
_L2:
        int l = s.length();
        obj = s;
        if (l <= 23)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new StringBuilder(26);
        int i = 0;
        do
        {
            int k = s.indexOf('.', j);
            if (k == -1)
            {
                break;
            }
            ((StringBuilder) (obj)).append(s.charAt(j));
            if (k - j > 1)
            {
                ((StringBuilder) (obj)).append('*');
            }
            ((StringBuilder) (obj)).append('.');
            j = k + 1;
            k = ((StringBuilder) (obj)).length();
            i = k;
            if (k > 23)
            {
                obj = b(s);
                continue; /* Loop/switch isn't completed */
            }
        } while (true);
        if (i == 0 || i + (l - j) > 23)
        {
            obj = b(s);
        } else
        {
            ((StringBuilder) (obj)).append(s, j, l);
            obj = ((StringBuilder) (obj)).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
