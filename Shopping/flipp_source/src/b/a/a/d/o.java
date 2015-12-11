// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.i;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package b.a.a.d:
//            t, x, u

final class o extends Enum
    implements t, x
{

    public static final o a;
    static final Set b;
    static final int c;
    private static final o d[];

    private o(String s)
    {
        super(s, 0);
    }

    public static o valueOf(String s)
    {
        return (o)Enum.valueOf(b/a/a/d/o, s);
    }

    public static final o[] values()
    {
        return (o[])d.clone();
    }

    public final int a()
    {
        return c;
    }

    public final int a(u u1, String s, int j)
    {
        String s3;
        Iterator iterator;
        s3 = s.substring(j);
        s = null;
        iterator = b.iterator();
_L2:
        String s1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        String s2 = (String)iterator.next();
        if (!s3.startsWith(s2))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s1 = s2;
        if (s != null)
        {
            if (s2.length() <= s.length())
            {
                break MISSING_BLOCK_LABEL_104;
            }
            s1 = s2;
        }
_L3:
        s = s1;
        if (true) goto _L2; else goto _L1
_L1:
        if (s != null)
        {
            u1.a(i.a(s));
            return s.length() + j;
        } else
        {
            return ~j;
        }
        s1 = s;
          goto _L3
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int j, i k, Locale locale)
    {
        if (k != null)
        {
            a1 = k.c;
        } else
        {
            a1 = "";
        }
        stringbuffer.append(a1);
    }

    public final void a(StringBuffer stringbuffer, aa aa, Locale locale)
    {
    }

    public final int b()
    {
        return c;
    }

    static 
    {
        a = new o("INSTANCE");
        d = (new o[] {
            a
        });
        b = i.b();
        Iterator iterator = b.iterator();
        int j;
        for (j = 0; iterator.hasNext(); j = Math.max(j, ((String)iterator.next()).length())) { }
        c = j;
    }
}
