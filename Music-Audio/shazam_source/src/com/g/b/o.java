// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.a.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class o
{
    public static final class a
    {

        public final List a = new ArrayList(20);

        private a c(String s, String s1)
        {
            a.add(s);
            a.add(s1.trim());
            return this;
        }

        final a a(String s)
        {
            int i = s.indexOf(":", 1);
            if (i != -1)
            {
                return c(s.substring(0, i), s.substring(i + 1));
            }
            if (s.startsWith(":"))
            {
                return c("", s.substring(1));
            } else
            {
                return c("", s);
            }
        }

        public final a a(String s, String s1)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("name == null");
            }
            if (s1 == null)
            {
                throw new IllegalArgumentException("value == null");
            }
            if (s.length() == 0 || s.indexOf('\0') != -1 || s1.indexOf('\0') != -1)
            {
                throw new IllegalArgumentException((new StringBuilder("Unexpected header: ")).append(s).append(": ").append(s1).toString());
            } else
            {
                return c(s, s1);
            }
        }

        public final o a()
        {
            return new o(this, (byte)0);
        }

        public final a b(String s)
        {
            int j;
            for (int i = 0; i < a.size(); i = j + 2)
            {
                j = i;
                if (s.equalsIgnoreCase((String)a.get(i)))
                {
                    a.remove(i);
                    a.remove(i);
                    j = i - 2;
                }
            }

            return this;
        }

        public final a b(String s, String s1)
        {
            b(s);
            a(s, s1);
            return this;
        }

        public a()
        {
        }
    }


    public final String a[];

    private o(a a1)
    {
        a = (String[])a1.a.toArray(new String[a1.a.size()]);
    }

    o(a a1, byte byte0)
    {
        this(a1);
    }

    public final a a()
    {
        a a1 = new a();
        Collections.addAll(a1.a, a);
        return a1;
    }

    public final String a(int i)
    {
        i *= 2;
        if (i < 0 || i >= a.length)
        {
            return null;
        } else
        {
            return a[i];
        }
    }

    public final String a(String s)
    {
        String as[] = a;
        for (int i = as.length - 2; i >= 0; i -= 2)
        {
            if (s.equalsIgnoreCase(as[i]))
            {
                return as[i + 1];
            }
        }

        return null;
    }

    public final String b(int i)
    {
        i = i * 2 + 1;
        if (i < 0 || i >= a.length)
        {
            return null;
        } else
        {
            return a[i];
        }
    }

    public final Date b(String s)
    {
        s = a(s);
        if (s != null)
        {
            return f.a(s);
        } else
        {
            return null;
        }
    }

    public final List c(String s)
    {
        int j = a.length / 2;
        ArrayList arraylist = null;
        for (int i = 0; i < j;)
        {
            ArrayList arraylist1 = arraylist;
            if (s.equalsIgnoreCase(a(i)))
            {
                arraylist1 = arraylist;
                if (arraylist == null)
                {
                    arraylist1 = new ArrayList(2);
                }
                arraylist1.add(b(i));
            }
            i++;
            arraylist = arraylist1;
        }

        if (arraylist != null)
        {
            return Collections.unmodifiableList(arraylist);
        } else
        {
            return Collections.emptyList();
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        for (int j = a.length / 2; i < j; i++)
        {
            stringbuilder.append(a(i)).append(": ").append(b(i)).append("\n");
        }

        return stringbuilder.toString();
    }
}
