// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.util.Iterator;

final class t
    implements android.text.TextUtils.StringSplitter
{

    private String a;
    private int b;
    private boolean c;
    private int d;
    private int e;

    t(String s)
    {
        a = s;
        b = 3976;
        c = true;
        d = 0;
        e = 0;
    }

    static int a(t t1)
    {
        return t1.e;
    }

    static int a(t t1, int i)
    {
        t1.d = i;
        return i;
    }

    static int b(t t1, int i)
    {
        t1.e = i;
        return i;
    }

    static String b(t t1)
    {
        return t1.a;
    }

    static int c(t t1)
    {
        return t1.d;
    }

    static int d(t t1)
    {
        return t1.b;
    }

    static boolean e(t t1)
    {
        return t1.c;
    }

    public final Iterator iterator()
    {
        return new Iterator() {

            final t a;

            public final boolean hasNext()
            {
                return t.a(a) < t.b(a).length();
            }

            public final Object next()
            {
                if (!hasNext())
                {
                    return null;
                }
                t.a(a, t.a(a));
                int i = Math.min(t.c(a) + t.d(a), t.b(a).length());
                if (i == t.c(a))
                {
                    return null;
                }
                if (t.e(a))
                {
                    int j = t.b(a).lastIndexOf('\n', i);
                    t t1 = a;
                    if (j > t.c(a))
                    {
                        i = j + 1;
                    }
                    t.b(t1, i);
                } else
                {
                    t.b(a, i);
                }
                return t.b(a).substring(t.c(a), t.a(a));
            }

            public final void remove()
            {
                throw new UnsupportedOperationException("Remove not allowed on this iterator!");
            }

            
            {
                a = t.this;
                super();
            }
        };
    }

    public final void setString(String s)
    {
    }
}
