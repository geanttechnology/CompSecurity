// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.shazam.android.ae:
//            p, n, u, e, 
//            k, v, f, l, 
//            o

public final class a
    implements p
{

    private static final Map b;

    public a()
    {
    }

    public final void a(n n1, String s, String s1)
    {
        n1 = (l)b.get(n1);
        if (s1.length() <= 3976)
        {
            n1.a(s, s1);
        } else
        {
            int i = 0;
            s1 = o.a(s1).iterator();
            do
            {
                if (!s1.hasNext())
                {
                    break;
                }
                i++;
                if (i > 7)
                {
                    break;
                }
                n1.a(s, (String)s1.next());
            } while (true);
            if (s1.hasNext())
            {
                n1.a(s, "Suppressing rest of chunks");
                return;
            }
        }
    }

    public final void a(n n1, String s, String s1, Throwable throwable)
    {
        ((l)b.get(n1)).a(s, s1, throwable);
    }

    public final transient void a(n n1, String s, Throwable throwable, String s1, Object aobj[])
    {
        a(n1, s, String.format(s1, aobj), throwable);
    }

    static 
    {
        EnumMap enummap = new EnumMap(com/shazam/android/ae/n);
        b = enummap;
        enummap.put(n.a, new u());
        b.put(n.b, new e());
        b.put(n.c, new k());
        b.put(n.d, new v());
        b.put(n.e, new f());
    }
}
