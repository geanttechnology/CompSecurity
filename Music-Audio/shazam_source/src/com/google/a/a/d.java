// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.IOException;
import java.util.Iterator;

// Referenced classes of package com.google.a.a:
//            g

public class d
{
    public static final class a
    {

        private final d a;
        private final String b;

        public final StringBuilder a(StringBuilder stringbuilder, Iterator iterator)
        {
            try
            {
                g.a(stringbuilder);
                if (iterator.hasNext())
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    stringbuilder.append(a.a(entry.getKey()));
                    stringbuilder.append(b);
                    stringbuilder.append(a.a(entry.getValue()));
                    java.util.Map.Entry entry1;
                    for (; iterator.hasNext(); stringbuilder.append(a.a(entry1.getValue())))
                    {
                        stringbuilder.append(a.a);
                        entry1 = (java.util.Map.Entry)iterator.next();
                        stringbuilder.append(a.a(entry1.getKey()));
                        stringbuilder.append(b);
                    }

                }
            }
            // Misplaced declaration of an exception variable
            catch (StringBuilder stringbuilder)
            {
                throw new AssertionError(stringbuilder);
            }
            return stringbuilder;
        }

        private a(d d1, String s)
        {
            a = d1;
            b = (String)g.a(s);
        }

        public a(d d1, String s, byte byte0)
        {
            this(d1, s);
        }
    }


    final String a;

    private d(d d1)
    {
        a = d1.a;
    }

    d(d d1, byte byte0)
    {
        this(d1);
    }

    private d(String s)
    {
        a = (String)g.a(s);
    }

    public static d a(char c)
    {
        return new d(String.valueOf(c));
    }

    public static d a(String s)
    {
        return new d(s);
    }

    CharSequence a(Object obj)
    {
        g.a(obj);
        if (obj instanceof CharSequence)
        {
            return (CharSequence)obj;
        } else
        {
            return obj.toString();
        }
    }

    public final String a(Iterable iterable)
    {
        iterable = iterable.iterator();
        return a(new StringBuilder(), ((Iterator) (iterable))).toString();
    }

    public final StringBuilder a(StringBuilder stringbuilder, Iterator iterator)
    {
        try
        {
            g.a(stringbuilder);
            if (iterator.hasNext())
            {
                stringbuilder.append(a(iterator.next()));
                for (; iterator.hasNext(); stringbuilder.append(a(iterator.next())))
                {
                    stringbuilder.append(a);
                }

            }
        }
        // Misplaced declaration of an exception variable
        catch (StringBuilder stringbuilder)
        {
            throw new AssertionError(stringbuilder);
        }
        return stringbuilder;
    }

    public d b(String s)
    {
        g.a(s);
        return new d(this, s) {

            final String b;
            final d c;

            final CharSequence a(Object obj)
            {
                if (obj == null)
                {
                    return b;
                } else
                {
                    return c.a(obj);
                }
            }

            public final d b(String s1)
            {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            
            {
                c = d.this;
                b = s;
                super(d2, (byte)0);
            }
        };
    }
}
