// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;
import java.util.Collection;

// Referenced classes of package com.google.a.a:
//            d, h, g

public final class i
{
    private static final class a
        implements h, Serializable
    {

        private final Collection a;

        public final boolean a(Object obj)
        {
            boolean flag;
            try
            {
                flag = a.contains(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            return flag;
        }

        public final boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                obj = (a)obj;
                return a.equals(((a) (obj)).a);
            } else
            {
                return false;
            }
        }

        public final int hashCode()
        {
            return a.hashCode();
        }

        public final String toString()
        {
            String s = String.valueOf(String.valueOf(a));
            return (new StringBuilder(s.length() + 15)).append("Predicates.in(").append(s).append(")").toString();
        }

        private a(Collection collection)
        {
            a = (Collection)g.a(collection);
        }

        a(Collection collection, byte byte0)
        {
            this(collection);
        }
    }

    private static final class b
        implements h, Serializable
    {

        private final Object a;

        public final boolean a(Object obj)
        {
            return a.equals(obj);
        }

        public final boolean equals(Object obj)
        {
            if (obj instanceof b)
            {
                obj = (b)obj;
                return a.equals(((b) (obj)).a);
            } else
            {
                return false;
            }
        }

        public final int hashCode()
        {
            return a.hashCode();
        }

        public final String toString()
        {
            String s = String.valueOf(String.valueOf(a));
            return (new StringBuilder(s.length() + 20)).append("Predicates.equalTo(").append(s).append(")").toString();
        }

        private b(Object obj)
        {
            a = obj;
        }

        b(Object obj, byte byte0)
        {
            this(obj);
        }
    }

    private static final class c
        implements h, Serializable
    {

        final h a;

        public final boolean a(Object obj)
        {
            return !a.a(obj);
        }

        public final boolean equals(Object obj)
        {
            if (obj instanceof c)
            {
                obj = (c)obj;
                return a.equals(((c) (obj)).a);
            } else
            {
                return false;
            }
        }

        public final int hashCode()
        {
            return ~a.hashCode();
        }

        public final String toString()
        {
            String s = String.valueOf(String.valueOf(a.toString()));
            return (new StringBuilder(s.length() + 16)).append("Predicates.not(").append(s).append(")").toString();
        }

        c(h h1)
        {
            a = (h)g.a(h1);
        }
    }

    static abstract class d extends Enum
        implements h
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        private static final d e[];

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/google/a/a/i$d, s);
        }

        public static d[] values()
        {
            return (d[])e.clone();
        }

        static 
        {
            a = new d("ALWAYS_TRUE") {

                public final boolean a(Object obj)
                {
                    return true;
                }

                public final String toString()
                {
                    return "Predicates.alwaysTrue()";
                }

            };
            b = new d("ALWAYS_FALSE") {

                public final boolean a(Object obj)
                {
                    return false;
                }

                public final String toString()
                {
                    return "Predicates.alwaysFalse()";
                }

            };
            c = new d("IS_NULL") {

                public final boolean a(Object obj)
                {
                    return obj == null;
                }

                public final String toString()
                {
                    return "Predicates.isNull()";
                }

            };
            d = new d("NOT_NULL") {

                public final boolean a(Object obj)
                {
                    return obj != null;
                }

                public final String toString()
                {
                    return "Predicates.notNull()";
                }

            };
            e = (new d[] {
                a, b, c, d
            });
        }

        private d(String s, int j)
        {
            super(s, j);
        }

        d(String s, int j, byte byte0)
        {
            this(s, j);
        }
    }


    private static final com.google.a.a.d a = com.google.a.a.d.a(',');

    public static h a(h h)
    {
        return new c(h);
    }

    public static h a(Object obj)
    {
        if (obj == null)
        {
            return d.c;
        } else
        {
            return new b(obj, (byte)0);
        }
    }

    public static h a(Collection collection)
    {
        return new a(collection, (byte)0);
    }

}
