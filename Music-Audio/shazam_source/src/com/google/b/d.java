// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import java.lang.reflect.Field;

// Referenced classes of package com.google.b:
//            e

public abstract class d extends Enum
    implements e
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    private static final d f[];

    private d(String s, int i)
    {
        super(s, i);
    }

    d(String s, int i, byte byte0)
    {
        this(s, i);
    }

    static String a(String s)
    {
        int i = 0;
        StringBuilder stringbuilder = new StringBuilder();
        char c1;
        for (c1 = s.charAt(0); i < s.length() - 1 && !Character.isLetter(c1); c1 = s.charAt(i))
        {
            stringbuilder.append(c1);
            i++;
        }

        String s1;
        if (i == s.length())
        {
            s1 = stringbuilder.toString();
        } else
        {
            s1 = s;
            if (!Character.isUpperCase(c1))
            {
                c1 = Character.toUpperCase(c1);
                i++;
                if (i < s.length())
                {
                    s = (new StringBuilder()).append(c1).append(s.substring(i)).toString();
                } else
                {
                    s = String.valueOf(c1);
                }
                return stringbuilder.append(s).toString();
            }
        }
        return s1;
    }

    static String a(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            if (Character.isUpperCase(c1) && stringbuilder.length() != 0)
            {
                stringbuilder.append(s1);
            }
            stringbuilder.append(c1);
        }

        return stringbuilder.toString();
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/google/b/d, s);
    }

    public static d[] values()
    {
        return (d[])f.clone();
    }

    static 
    {
        a = new d("IDENTITY") {

            public final String a(Field field)
            {
                return field.getName();
            }

        };
        b = new d("UPPER_CAMEL_CASE") {

            public final String a(Field field)
            {
                return d.a(field.getName());
            }

        };
        c = new d("UPPER_CAMEL_CASE_WITH_SPACES") {

            public final String a(Field field)
            {
                return d.a(d.a(field.getName(), " "));
            }

        };
        d = new d("LOWER_CASE_WITH_UNDERSCORES") {

            public final String a(Field field)
            {
                return d.a(field.getName(), "_").toLowerCase();
            }

        };
        e = new d("LOWER_CASE_WITH_DASHES") {

            public final String a(Field field)
            {
                return d.a(field.getName(), "-").toLowerCase();
            }

        };
        f = (new d[] {
            a, b, c, d, e
        });
    }
}
