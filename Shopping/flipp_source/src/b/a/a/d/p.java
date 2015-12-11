// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.e.j;
import b.a.a.f;
import b.a.a.i;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package b.a.a.d:
//            t, x, u

final class p
    implements t, x
{

    private final Map a = null;
    private final int b;

    p(int k)
    {
        b = k;
    }

    public final int a()
    {
        return b != 1 ? 20 : 4;
    }

    public final int a(u u1, String s, int k)
    {
        String s1;
        Map map;
        map = a;
        String s2;
        String s3;
        Iterator iterator;
        if (map == null)
        {
            map = f.b();
        }
        s3 = s.substring(k);
        s = null;
        iterator = map.keySet().iterator();
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = (String)iterator.next();
        if (!s3.startsWith(s2))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        s1 = s2;
        if (s != null)
        {
            if (s2.length() <= s.length())
            {
                break MISSING_BLOCK_LABEL_134;
            }
            s1 = s2;
        }
_L4:
        s = s1;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_34;
_L1:
        if (s != null)
        {
            u1.a((i)map.get(s));
            return s.length() + k;
        } else
        {
            return ~k;
        }
        s1 = s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int k, i i1, Locale locale)
    {
        l -= k;
        if (i1 == null) goto _L2; else goto _L1
_L1:
        b;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 48
    //                   1 127;
           goto _L2 _L3 _L4
_L2:
        a1 = "";
_L6:
        stringbuffer.append(a1);
        return;
_L3:
        a1 = locale;
        if (locale == null)
        {
            a1 = Locale.getDefault();
        }
        locale = i1.a(l);
        if (locale == null)
        {
            a1 = i1.c;
        } else
        {
            locale = i.b.b(a1, i1.c, locale);
            a1 = locale;
            if (locale == null)
            {
                a1 = i.b(i1.b(l));
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        a1 = locale;
        if (locale == null)
        {
            a1 = Locale.getDefault();
        }
        locale = i1.a(l);
        if (locale == null)
        {
            a1 = i1.c;
        } else
        {
            locale = i.b.a(a1, i1.c, locale);
            a1 = locale;
            if (locale == null)
            {
                a1 = i.b(i1.b(l));
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(StringBuffer stringbuffer, aa aa, Locale locale)
    {
    }

    public final int b()
    {
        return b != 1 ? 20 : 4;
    }
}
