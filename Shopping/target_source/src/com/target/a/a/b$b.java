// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.a.a;

import com.google.a.a.b;
import com.target.mothership.util.o;

// Referenced classes of package com.target.a.a:
//            b

public static class e
    implements e
{

    public static final b a = new b() {

        public volatile Object a(Object obj)
        {
            return a((String)obj);
        }

        public String a(String s)
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "(empty message)";
            }
            return s1;
        }

    };
    public static final b b = new b() {

        public volatile Object a(Object obj)
        {
            return a((String)obj);
        }

        public String a(String s)
        {
            return o.b(s, 23);
        }

    };
    private final b c;
    private final b d;
    private final ip.util.o.b e;

    public void a(int i, String s, String s1)
    {
        e.a(i, (String)c.a(s), (String)d.a(s1));
    }

    public void a(int i, String s, String s1, Throwable throwable)
    {
        e.a(i, (String)c.a(s), (String)d.a(s1), throwable);
    }


    public _cls2(b b1, b b2, _cls2 _pcls2)
    {
        c = b1;
        d = b2;
        e = _pcls2;
    }
}
