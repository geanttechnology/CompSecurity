// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.a.c;
import com.google.b.b.g;
import com.google.b.c.a;
import com.google.b.d.b;
import com.google.b.f;
import com.google.b.i;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import com.google.b.u;
import com.google.b.x;
import com.google.b.y;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

public final class m
{
    private static final class a extends x
    {

        private final Map a;
        private final Map b;

        public final Object a(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            } else
            {
                return (Enum)a.get(a1.i());
            }
        }

        public final void a(com.google.b.d.c c1, Object obj)
        {
            obj = (Enum)obj;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = (String)b.get(obj);
            }
            c1.b(((String) (obj)));
        }

        public a(Class class1)
        {
            a = new HashMap();
            b = new HashMap();
            String s1;
            Enum aenum[];
            Enum enum;
            c c1;
            int i1;
            int j1;
            try
            {
                aenum = (Enum[])class1.getEnumConstants();
                j1 = aenum.length;
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new AssertionError();
            }
            i1 = 0;
            if (i1 >= j1)
            {
                break; /* Loop/switch isn't completed */
            }
            enum = aenum[i1];
            s1 = enum.name();
            c1 = (c)class1.getField(s1).getAnnotation(com/google/b/a/c);
            if (c1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            s1 = c1.a();
            a.put(s1, enum);
            b.put(enum, s1);
            i1++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_41;
_L1:
        }
    }


    public static final x A;
    public static final y B;
    public static final x C;
    public static final y D;
    public static final x E;
    public static final y F;
    public static final x G;
    public static final y H;
    public static final x I;
    public static final y J;
    public static final y K = new y() {

        public final x a(f f1, com.google.b.c.a a1)
        {
            if (a1.a != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new x(this, f1.a(java/util/Date)) {

                    final x a;
                    final _cls15 b;

                    public final Object a(com.google.b.d.a a1)
                    {
                        a1 = (Date)a.a(a1);
                        if (a1 != null)
                        {
                            return new Timestamp(a1.getTime());
                        } else
                        {
                            return null;
                        }
                    }

                    public final volatile void a(com.google.b.d.c c1, Object obj)
                    {
                        obj = (Timestamp)obj;
                        a.a(c1, obj);
                    }

            
            {
                b = _pcls15;
                a = x1;
                super();
            }
                };
            }
        }

    };
    public static final x L;
    public static final y M;
    public static final x N;
    public static final y O;
    public static final x P;
    public static final y Q;
    public static final y R = new y() {

        public final x a(f f1, com.google.b.c.a a1)
        {
            a1 = a1.a;
            if (!java/lang/Enum.isAssignableFrom(a1) || a1 == java/lang/Enum)
            {
                return null;
            }
            f1 = a1;
            if (!a1.isEnum())
            {
                f1 = a1.getSuperclass();
            }
            return new a(f1);
        }

    };
    public static final x a;
    public static final y b;
    public static final x c;
    public static final y d;
    public static final x e;
    public static final x f = new x() {

        public final Object a(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            } else
            {
                return Boolean.valueOf(a1.i());
            }
        }

        public final void a(com.google.b.d.c c1, Object obj)
        {
            obj = (Boolean)obj;
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((Boolean) (obj)).toString();
            }
            c1.b(((String) (obj)));
        }

    };
    public static final y g;
    public static final x h;
    public static final y i;
    public static final x j;
    public static final y k;
    public static final x l;
    public static final y m;
    public static final x n = new x() {

        private static Number b(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            }
            long l1;
            try
            {
                l1 = a1.m();
            }
            // Misplaced declaration of an exception variable
            catch (com.google.b.d.a a1)
            {
                throw new u(a1);
            }
            return Long.valueOf(l1);
        }

        public final Object a(com.google.b.d.a a1)
        {
            return b(a1);
        }

        public final volatile void a(com.google.b.d.c c1, Object obj)
        {
            c1.a((Number)obj);
        }

    };
    public static final x o = new x() {

        public final Object a(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            } else
            {
                return Float.valueOf((float)a1.l());
            }
        }

        public final volatile void a(com.google.b.d.c c1, Object obj)
        {
            c1.a((Number)obj);
        }

    };
    public static final x p = new x() {

        public final Object a(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            } else
            {
                return Double.valueOf(a1.l());
            }
        }

        public final volatile void a(com.google.b.d.c c1, Object obj)
        {
            c1.a((Number)obj);
        }

    };
    public static final x q;
    public static final y r;
    public static final x s;
    public static final y t;
    public static final x u;
    public static final x v = new x() {

        private static BigDecimal b(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            }
            try
            {
                a1 = new BigDecimal(a1.i());
            }
            // Misplaced declaration of an exception variable
            catch (com.google.b.d.a a1)
            {
                throw new u(a1);
            }
            return a1;
        }

        public final Object a(com.google.b.d.a a1)
        {
            return b(a1);
        }

        public final volatile void a(com.google.b.d.c c1, Object obj)
        {
            c1.a((BigDecimal)obj);
        }

    };
    public static final x w = new x() {

        private static BigInteger b(com.google.b.d.a a1)
        {
            if (a1.f() == b.i)
            {
                a1.k();
                return null;
            }
            try
            {
                a1 = new BigInteger(a1.i());
            }
            // Misplaced declaration of an exception variable
            catch (com.google.b.d.a a1)
            {
                throw new u(a1);
            }
            return a1;
        }

        public final Object a(com.google.b.d.a a1)
        {
            return b(a1);
        }

        public final volatile void a(com.google.b.d.c c1, Object obj)
        {
            c1.a((BigInteger)obj);
        }

    };
    public static final y x;
    public static final x y;
    public static final y z;

    public static y a(com.google.b.c.a a1, x x1)
    {
        return new y(a1, x1) {

            final com.google.b.c.a a;
            final x b;

            public final x a(f f1, com.google.b.c.a a2)
            {
                if (a2.equals(a))
                {
                    return b;
                } else
                {
                    return null;
                }
            }

            
            {
                a = a1;
                b = x1;
                super();
            }
        };
    }

    public static y a(Class class1, x x1)
    {
        return new y(class1, x1) {

            final Class a;
            final x b;

            public final x a(f f1, com.google.b.c.a a1)
            {
                if (a1.a == a)
                {
                    return b;
                } else
                {
                    return null;
                }
            }

            public final String toString()
            {
                return (new StringBuilder("Factory[type=")).append(a.getName()).append(",adapter=").append(b).append("]").toString();
            }

            
            {
                a = class1;
                b = x1;
                super();
            }
        };
    }

    public static y a(Class class1, Class class2, x x1)
    {
        return new y(class1, class2, x1) {

            final Class a;
            final Class b;
            final x c;

            public final x a(f f1, com.google.b.c.a a1)
            {
                f1 = a1.a;
                if (f1 == a || f1 == b)
                {
                    return c;
                } else
                {
                    return null;
                }
            }

            public final String toString()
            {
                return (new StringBuilder("Factory[type=")).append(b.getName()).append("+").append(a.getName()).append(",adapter=").append(c).append("]").toString();
            }

            
            {
                a = class1;
                b = class2;
                c = x1;
                super();
            }
        };
    }

    private static y b(Class class1, x x1)
    {
        return new y(class1, x1) {

            final Class a;
            final x b;

            public final x a(f f1, com.google.b.c.a a1)
            {
                if (a.isAssignableFrom(a1.a))
                {
                    return b;
                } else
                {
                    return null;
                }
            }

            public final String toString()
            {
                return (new StringBuilder("Factory[typeHierarchy=")).append(a.getName()).append(",adapter=").append(b).append("]").toString();
            }

            
            {
                a = class1;
                b = x1;
                super();
            }
        };
    }

    static 
    {
        a = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                } else
                {
                    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (Class)obj;
                if (obj == null)
                {
                    c1.f();
                    return;
                } else
                {
                    throw new UnsupportedOperationException((new StringBuilder("Attempted to serialize java.lang.Class: ")).append(((Class) (obj)).getName()).append(". Forgot to register a type adapter?").toString());
                }
            }

        };
        b = a(java/lang/Class, a);
        c = new x() {

            private static BitSet b(com.google.b.d.a a1)
            {
                b b1;
                BitSet bitset;
                int i1;
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                bitset = new BitSet();
                a1.a();
                b1 = a1.f();
                i1 = 0;
_L2:
                boolean flag;
                if (b1 == b.b)
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                static final class _cls26
                {

                    static final int a[];

                    static 
                    {
                        a = new int[com.google.b.d.b.values().length];
                        try
                        {
                            a[b.g.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            a[b.h.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            a[b.f.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            a[b.i.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            a[b.a.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            a[b.c.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[b.j.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[b.e.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[b.d.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[b.b.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (com.google.b.b.a._cls26.a[b1.ordinal()])
                {
                default:
                    throw new u((new StringBuilder("Invalid bitset value type: ")).append(b1).toString());

                case 2: // '\002'
                    break; /* Loop/switch isn't completed */

                case 3: // '\003'
                    break MISSING_BLOCK_LABEL_147;

                case 1: // '\001'
                    if (a1.n() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    break;
                }
_L3:
                if (flag)
                {
                    bitset.set(i1);
                }
                i1++;
                b1 = a1.f();
                if (true) goto _L2; else goto _L1
_L1:
                flag = a1.j();
                  goto _L3
                String s1 = a1.i();
                int j1;
                try
                {
                    j1 = Integer.parseInt(s1);
                }
                // Misplaced declaration of an exception variable
                catch (com.google.b.d.a a1)
                {
                    throw new u((new StringBuilder("Error: Expecting: bitset number value (1, 0), Found: ")).append(s1).toString());
                }
                if (j1 != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                  goto _L3
                a1.b();
                return bitset;
            }

            public final Object a(com.google.b.d.a a1)
            {
                return b(a1);
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (BitSet)obj;
                if (obj == null)
                {
                    c1.f();
                    return;
                }
                c1.b();
                int i1 = 0;
                while (i1 < ((BitSet) (obj)).length()) 
                {
                    int j1;
                    if (((BitSet) (obj)).get(i1))
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                    c1.a(j1);
                    i1++;
                }
                c1.c();
            }

        };
        d = a(java/util/BitSet, c);
        e = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                if (a1.f() == b.f)
                {
                    return Boolean.valueOf(Boolean.parseBoolean(a1.i()));
                } else
                {
                    return Boolean.valueOf(a1.j());
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (Boolean)obj;
                if (obj == null)
                {
                    c1.f();
                    return;
                } else
                {
                    c1.a(((Boolean) (obj)).booleanValue());
                    return;
                }
            }

        };
        g = a(Boolean.TYPE, java/lang/Boolean, e);
        h = new x() {

            private static Number b(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                byte byte0;
                try
                {
                    byte0 = (byte)a1.n();
                }
                // Misplaced declaration of an exception variable
                catch (com.google.b.d.a a1)
                {
                    throw new u(a1);
                }
                return Byte.valueOf(byte0);
            }

            public final Object a(com.google.b.d.a a1)
            {
                return b(a1);
            }

            public final volatile void a(com.google.b.d.c c1, Object obj)
            {
                c1.a((Number)obj);
            }

        };
        i = a(Byte.TYPE, java/lang/Byte, h);
        j = new x() {

            private static Number b(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                short word0;
                try
                {
                    word0 = (short)a1.n();
                }
                // Misplaced declaration of an exception variable
                catch (com.google.b.d.a a1)
                {
                    throw new u(a1);
                }
                return Short.valueOf(word0);
            }

            public final Object a(com.google.b.d.a a1)
            {
                return b(a1);
            }

            public final volatile void a(com.google.b.d.c c1, Object obj)
            {
                c1.a((Number)obj);
            }

        };
        k = a(Short.TYPE, java/lang/Short, j);
        l = new x() {

            private static Number b(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                int i1;
                try
                {
                    i1 = a1.n();
                }
                // Misplaced declaration of an exception variable
                catch (com.google.b.d.a a1)
                {
                    throw new u(a1);
                }
                return Integer.valueOf(i1);
            }

            public final Object a(com.google.b.d.a a1)
            {
                return b(a1);
            }

            public final volatile void a(com.google.b.d.c c1, Object obj)
            {
                c1.a((Number)obj);
            }

        };
        m = a(Integer.TYPE, java/lang/Integer, l);
        q = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                b b1 = a1.f();
                switch (com.google.b.b.a._cls26.a[b1.ordinal()])
                {
                case 2: // '\002'
                case 3: // '\003'
                default:
                    throw new u((new StringBuilder("Expecting number, got: ")).append(b1).toString());

                case 4: // '\004'
                    a1.k();
                    return null;

                case 1: // '\001'
                    return new com.google.b.b.f(a1.i());
                }
            }

            public final volatile void a(com.google.b.d.c c1, Object obj)
            {
                c1.a((Number)obj);
            }

        };
        r = a(java/lang/Number, q);
        s = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                a1 = a1.i();
                if (a1.length() != 1)
                {
                    throw new u((new StringBuilder("Expecting character, got: ")).append(a1).toString());
                } else
                {
                    return Character.valueOf(a1.charAt(0));
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (Character)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = String.valueOf(obj);
                }
                c1.b(((String) (obj)));
            }

        };
        t = a(Character.TYPE, java/lang/Character, s);
        u = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                b b1 = a1.f();
                if (b1 == b.i)
                {
                    a1.k();
                    return null;
                }
                if (b1 == b.h)
                {
                    return Boolean.toString(a1.j());
                } else
                {
                    return a1.i();
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                c1.b((String)obj);
            }

        };
        x = a(java/lang/String, u);
        y = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                } else
                {
                    return new StringBuilder(a1.i());
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (StringBuilder)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((StringBuilder) (obj)).toString();
                }
                c1.b(((String) (obj)));
            }

        };
        z = a(java/lang/StringBuilder, y);
        A = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                } else
                {
                    return new StringBuffer(a1.i());
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (StringBuffer)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((StringBuffer) (obj)).toString();
                }
                c1.b(((String) (obj)));
            }

        };
        B = a(java/lang/StringBuffer, A);
        C = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                } else
                {
                    a1 = a1.i();
                    if (!"null".equals(a1))
                    {
                        return new URL(a1);
                    }
                }
                return null;
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (URL)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((URL) (obj)).toExternalForm();
                }
                c1.b(((String) (obj)));
            }

        };
        D = a(java/net/URL, C);
        E = new x() {

            private static URI b(com.google.b.d.a a1)
            {
                if (a1.f() != b.i) goto _L2; else goto _L1
_L1:
                a1.k();
_L4:
                return null;
_L2:
                a1 = a1.i();
                if ("null".equals(a1)) goto _L4; else goto _L3
_L3:
                a1 = new URI(a1);
                return a1;
                a1;
                throw new com.google.b.m(a1);
            }

            public final Object a(com.google.b.d.a a1)
            {
                return b(a1);
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (URI)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((URI) (obj)).toASCIIString();
                }
                c1.b(((String) (obj)));
            }

        };
        F = a(java/net/URI, E);
        G = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                } else
                {
                    return InetAddress.getByName(a1.i());
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (InetAddress)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((InetAddress) (obj)).getHostAddress();
                }
                c1.b(((String) (obj)));
            }

        };
        H = b(java/net/InetAddress, G);
        I = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                } else
                {
                    return UUID.fromString(a1.i());
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (UUID)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((UUID) (obj)).toString();
                }
                c1.b(((String) (obj)));
            }

        };
        J = a(java/util/UUID, I);
        L = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                int j1 = 0;
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                a1.c();
                int k1 = 0;
                int l1 = 0;
                int i2 = 0;
                int j2 = 0;
                int k2 = 0;
                do
                {
                    if (a1.f() == b.d)
                    {
                        break;
                    }
                    String s1 = a1.h();
                    int i1 = a1.n();
                    if ("year".equals(s1))
                    {
                        k2 = i1;
                    } else
                    if ("month".equals(s1))
                    {
                        j2 = i1;
                    } else
                    if ("dayOfMonth".equals(s1))
                    {
                        i2 = i1;
                    } else
                    if ("hourOfDay".equals(s1))
                    {
                        l1 = i1;
                    } else
                    if ("minute".equals(s1))
                    {
                        k1 = i1;
                    } else
                    if ("second".equals(s1))
                    {
                        j1 = i1;
                    }
                } while (true);
                a1.d();
                return new GregorianCalendar(k2, j2, i2, l1, k1, j1);
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (Calendar)obj;
                if (obj == null)
                {
                    c1.f();
                    return;
                } else
                {
                    c1.d();
                    c1.a("year");
                    c1.a(((Calendar) (obj)).get(1));
                    c1.a("month");
                    c1.a(((Calendar) (obj)).get(2));
                    c1.a("dayOfMonth");
                    c1.a(((Calendar) (obj)).get(5));
                    c1.a("hourOfDay");
                    c1.a(((Calendar) (obj)).get(11));
                    c1.a("minute");
                    c1.a(((Calendar) (obj)).get(12));
                    c1.a("second");
                    c1.a(((Calendar) (obj)).get(13));
                    c1.e();
                    return;
                }
            }

        };
        M = new y(java/util/Calendar, java/util/GregorianCalendar, L) {

            final Class a;
            final Class b;
            final x c;

            public final x a(f f1, com.google.b.c.a a1)
            {
                f1 = a1.a;
                if (f1 == a || f1 == b)
                {
                    return c;
                } else
                {
                    return null;
                }
            }

            public final String toString()
            {
                return (new StringBuilder("Factory[type=")).append(a.getName()).append("+").append(b.getName()).append(",adapter=").append(c).append("]").toString();
            }

            
            {
                a = class1;
                b = class2;
                c = x1;
                super();
            }
        };
        N = new x() {

            public final Object a(com.google.b.d.a a1)
            {
                if (a1.f() == b.i)
                {
                    a1.k();
                    return null;
                }
                Object obj = new StringTokenizer(a1.i(), "_");
                String s1;
                if (((StringTokenizer) (obj)).hasMoreElements())
                {
                    a1 = ((StringTokenizer) (obj)).nextToken();
                } else
                {
                    a1 = null;
                }
                if (((StringTokenizer) (obj)).hasMoreElements())
                {
                    s1 = ((StringTokenizer) (obj)).nextToken();
                } else
                {
                    s1 = null;
                }
                if (((StringTokenizer) (obj)).hasMoreElements())
                {
                    obj = ((StringTokenizer) (obj)).nextToken();
                } else
                {
                    obj = null;
                }
                if (s1 == null && obj == null)
                {
                    return new Locale(a1);
                }
                if (obj == null)
                {
                    return new Locale(a1, s1);
                } else
                {
                    return new Locale(a1, s1, ((String) (obj)));
                }
            }

            public final void a(com.google.b.d.c c1, Object obj)
            {
                obj = (Locale)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((Locale) (obj)).toString();
                }
                c1.b(((String) (obj)));
            }

        };
        O = a(java/util/Locale, N);
        P = new x() {

            private void a(com.google.b.d.c c1, l l1)
            {
                if (l1 == null || (l1 instanceof n))
                {
                    c1.f();
                    return;
                }
                if (l1 instanceof r)
                {
                    l1 = l1.h();
                    if (((r) (l1)).a instanceof Number)
                    {
                        c1.a(l1.a());
                        return;
                    }
                    if (((r) (l1)).a instanceof Boolean)
                    {
                        c1.a(l1.f());
                        return;
                    } else
                    {
                        c1.b(l1.b());
                        return;
                    }
                }
                if (l1 instanceof i)
                {
                    c1.b();
                    if (l1 instanceof i)
                    {
                        for (l1 = ((i)l1).iterator(); l1.hasNext(); a(c1, (l)l1.next())) { }
                    } else
                    {
                        throw new IllegalStateException("This is not a JSON Array.");
                    }
                    c1.c();
                    return;
                }
                if (l1 instanceof o)
                {
                    c1.d();
                    java.util.Map.Entry entry;
                    for (l1 = l1.g().a.entrySet().iterator(); l1.hasNext(); a(c1, (l)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)l1.next();
                        c1.a((String)entry.getKey());
                    }

                    c1.e();
                    return;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder("Couldn't write ")).append(l1.getClass()).toString());
                }
            }

            private l b(com.google.b.d.a a1)
            {
                o o1;
                switch (com.google.b.b.a._cls26.a[a1.f().ordinal()])
                {
                default:
                    throw new IllegalArgumentException();

                case 3: // '\003'
                    return new r(a1.i());

                case 1: // '\001'
                    return new r(new com.google.b.b.f(a1.i()));

                case 2: // '\002'
                    return new r(Boolean.valueOf(a1.j()));

                case 4: // '\004'
                    a1.k();
                    return n.a;

                case 5: // '\005'
                    i i1 = new i();
                    a1.a();
                    for (; a1.e(); i1.a(b(a1))) { }
                    a1.b();
                    return i1;

                case 6: // '\006'
                    o1 = new o();
                    a1.c();
                    break;
                }
                for (; a1.e(); o1.a(a1.h(), b(a1))) { }
                a1.d();
                return o1;
            }

            public final Object a(com.google.b.d.a a1)
            {
                return b(a1);
            }

            public final volatile void a(com.google.b.d.c c1, Object obj)
            {
                a(c1, (l)obj);
            }

        };
        Q = b(com/google/b/l, P);
    }
}
