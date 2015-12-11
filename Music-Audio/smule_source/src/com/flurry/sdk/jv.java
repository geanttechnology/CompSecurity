// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

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
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

// Referenced classes of package com.flurry.sdk:
//            ig, ir, is, jx, 
//            jy, jz, ih, io, 
//            jw, ia, il, jd, 
//            ii, id, ij

public final class jv
{

    public static final ir A;
    public static final is B;
    public static final ir C;
    public static final is D;
    public static final ir E;
    public static final is F;
    public static final ir G;
    public static final is H;
    public static final ir I;
    public static final is J;
    public static final is K = new is() {

        public ir a(ia ia1, jw jw1)
        {
            if (jw1.a() != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new ir(this, ia1.a(java/util/Date)) {

                    final ir a;
                    final _cls15 b;

                    public Timestamp a(jx jx)
                    {
                        jx = (Date)a.b(jx);
                        if (jx != null)
                        {
                            return new Timestamp(jx.getTime());
                        } else
                        {
                            return null;
                        }
                    }

                    public volatile void a(jz jz, Object obj)
                    {
                        a(jz, (Timestamp)obj);
                    }

                    public void a(jz jz, Timestamp timestamp)
                    {
                        a.a(jz, timestamp);
                    }

                    public Object b(jx jx)
                    {
                        return a(jx);
                    }

            
            {
                b = _pcls15;
                a = ir1;
                super();
            }
                };
            }
        }

    };
    public static final ir L;
    public static final is M;
    public static final ir N;
    public static final is O;
    public static final ir P;
    public static final is Q;
    public static final is R = a();
    public static final ir a;
    public static final is b;
    public static final ir c;
    public static final is d;
    public static final ir e;
    public static final ir f = new ir() {

        public Boolean a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            } else
            {
                return Boolean.valueOf(jx1.h());
            }
        }

        public void a(jz jz1, Boolean boolean1)
        {
            if (boolean1 == null)
            {
                boolean1 = "null";
            } else
            {
                boolean1 = boolean1.toString();
            }
            jz1.b(boolean1);
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (Boolean)obj);
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

    };
    public static final is g;
    public static final ir h;
    public static final is i;
    public static final ir j;
    public static final is k;
    public static final ir l;
    public static final is m;
    public static final ir n = new ir() {

        public Number a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            }
            long l1;
            try
            {
                l1 = jx1.l();
            }
            // Misplaced declaration of an exception variable
            catch (jx jx1)
            {
                throw new io(jx1);
            }
            return Long.valueOf(l1);
        }

        public void a(jz jz1, Number number)
        {
            jz1.a(number);
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (Number)obj);
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

    };
    public static final ir o = new ir() {

        public Number a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            } else
            {
                return Float.valueOf((float)jx1.k());
            }
        }

        public void a(jz jz1, Number number)
        {
            jz1.a(number);
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (Number)obj);
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

    };
    public static final ir p = new ir() {

        public Number a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            } else
            {
                return Double.valueOf(jx1.k());
            }
        }

        public void a(jz jz1, Number number)
        {
            jz1.a(number);
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (Number)obj);
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

    };
    public static final ir q;
    public static final is r;
    public static final ir s;
    public static final is t;
    public static final ir u;
    public static final ir v = new ir() {

        public BigDecimal a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            }
            try
            {
                jx1 = new BigDecimal(jx1.h());
            }
            // Misplaced declaration of an exception variable
            catch (jx jx1)
            {
                throw new io(jx1);
            }
            return jx1;
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (BigDecimal)obj);
        }

        public void a(jz jz1, BigDecimal bigdecimal)
        {
            jz1.a(bigdecimal);
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

    };
    public static final ir w = new ir() {

        public BigInteger a(jx jx1)
        {
            if (jx1.f() == jy.i)
            {
                jx1.j();
                return null;
            }
            try
            {
                jx1 = new BigInteger(jx1.h());
            }
            // Misplaced declaration of an exception variable
            catch (jx jx1)
            {
                throw new io(jx1);
            }
            return jx1;
        }

        public volatile void a(jz jz1, Object obj)
        {
            a(jz1, (BigInteger)obj);
        }

        public void a(jz jz1, BigInteger biginteger)
        {
            jz1.a(biginteger);
        }

        public Object b(jx jx1)
        {
            return a(jx1);
        }

    };
    public static final is x;
    public static final ir y;
    public static final is z;

    public static is a()
    {
        return new is() {

            public ir a(ia ia, jw jw1)
            {
                jw1 = jw1.a();
                if (!java/lang/Enum.isAssignableFrom(jw1) || jw1 == java/lang/Enum)
                {
                    return null;
                }
                ia = jw1;
                if (!jw1.isEnum())
                {
                    ia = jw1.getSuperclass();
                }
                return new a(ia);
            }


            private class a extends ir
            {

                private final Map a;
                private final Map b;

                public Enum a(jx jx1)
                {
                    if (jx1.f() == jy.i)
                    {
                        jx1.j();
                        return null;
                    } else
                    {
                        return (Enum)a.get(jx1.h());
                    }
                }

                public void a(jz jz1, Enum enum)
                {
                    if (enum == null)
                    {
                        enum = null;
                    } else
                    {
                        enum = (String)b.get(enum);
                    }
                    jz1.b(enum);
                }

                public volatile void a(jz jz1, Object obj)
                {
                    a(jz1, (Enum)obj);
                }

                public Object b(jx jx1)
                {
                    return a(jx1);
                }

                public a(Class class1)
                {
                    a = new HashMap();
                    b = new HashMap();
                    String s1;
                    Enum aenum[];
                    Enum enum;
                    iv iv1;
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
                    iv1 = (iv)class1.getField(s1).getAnnotation(com/flurry/sdk/iv);
                    if (iv1 == null)
                    {
                        break MISSING_BLOCK_LABEL_88;
                    }
                    s1 = iv1.a();
                    a.put(s1, enum);
                    b.put(enum, s1);
                    i1++;
                    if (true) goto _L2; else goto _L1
_L2:
                    break MISSING_BLOCK_LABEL_41;
_L1:
                }
            }

        };
    }

    public static is a(Class class1, ir ir)
    {
        return new is(class1, ir) {

            final Class a;
            final ir b;

            public ir a(ia ia, jw jw1)
            {
                if (jw1.a() == a)
                {
                    return b;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[type=").append(a.getName()).append(",adapter=").append(b).append("]").toString();
            }

            
            {
                a = class1;
                b = ir;
                super();
            }
        };
    }

    public static is a(Class class1, Class class2, ir ir)
    {
        return new is(class1, class2, ir) {

            final Class a;
            final Class b;
            final ir c;

            public ir a(ia ia, jw jw1)
            {
                ia = jw1.a();
                if (ia == a || ia == b)
                {
                    return c;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[type=").append(b.getName()).append("+").append(a.getName()).append(",adapter=").append(c).append("]").toString();
            }

            
            {
                a = class1;
                b = class2;
                c = ir;
                super();
            }
        };
    }

    public static is b(Class class1, ir ir)
    {
        return new is(class1, ir) {

            final Class a;
            final ir b;

            public ir a(ia ia, jw jw1)
            {
                if (a.isAssignableFrom(jw1.a()))
                {
                    return b;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[typeHierarchy=").append(a.getName()).append(",adapter=").append(b).append("]").toString();
            }

            
            {
                a = class1;
                b = ir;
                super();
            }
        };
    }

    public static is b(Class class1, Class class2, ir ir)
    {
        return new is(class1, class2, ir) {

            final Class a;
            final Class b;
            final ir c;

            public ir a(ia ia, jw jw1)
            {
                ia = jw1.a();
                if (ia == a || ia == b)
                {
                    return c;
                } else
                {
                    return null;
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append("Factory[type=").append(a.getName()).append("+").append(b.getName()).append(",adapter=").append(c).append("]").toString();
            }

            
            {
                a = class1;
                b = class2;
                c = ir;
                super();
            }
        };
    }

    static 
    {
        a = new ir() {

            public Class a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                } else
                {
                    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
                }
            }

            public void a(jz jz1, Class class1)
            {
                if (class1 == null)
                {
                    jz1.f();
                    return;
                } else
                {
                    throw new UnsupportedOperationException((new StringBuilder()).append("Attempted to serialize java.lang.Class: ").append(class1.getName()).append(". Forgot to register a type adapter?").toString());
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Class)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        b = a(java/lang/Class, a);
        c = new ir() {

            public BitSet a(jx jx1)
            {
                jy jy1;
                BitSet bitset;
                int i1;
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                bitset = new BitSet();
                jx1.a();
                jy1 = jx1.f();
                i1 = 0;
_L2:
                boolean flag;
                if (jy1 == jy.b)
                {
                    break MISSING_BLOCK_LABEL_209;
                }
                class _cls25
                {

                    static final int a[];

                    static 
                    {
                        a = new int[jy.values().length];
                        try
                        {
                            a[jy.g.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            a[jy.h.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            a[jy.f.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            a[jy.i.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            a[jy.a.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            a[jy.c.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[jy.j.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[jy.e.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[jy.d.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[jy.b.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls25.a[jy1.ordinal()])
                {
                default:
                    throw new io((new StringBuilder()).append("Invalid bitset value type: ").append(jy1).toString());

                case 2: // '\002'
                    break; /* Loop/switch isn't completed */

                case 3: // '\003'
                    break MISSING_BLOCK_LABEL_153;

                case 1: // '\001'
                    if (jx1.m() != 0)
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
                jy1 = jx1.f();
                if (true) goto _L2; else goto _L1
_L1:
                flag = jx1.i();
                  goto _L3
                String s1 = jx1.h();
                int j1;
                try
                {
                    j1 = Integer.parseInt(s1);
                }
                // Misplaced declaration of an exception variable
                catch (jx jx1)
                {
                    throw new io((new StringBuilder()).append("Error: Expecting: bitset number value (1, 0), Found: ").append(s1).toString());
                }
                if (j1 != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                  goto _L3
                jx1.b();
                return bitset;
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (BitSet)obj);
            }

            public void a(jz jz1, BitSet bitset)
            {
                if (bitset == null)
                {
                    jz1.f();
                    return;
                }
                jz1.b();
                int i1 = 0;
                while (i1 < bitset.length()) 
                {
                    int j1;
                    if (bitset.get(i1))
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                    jz1.a(j1);
                    i1++;
                }
                jz1.c();
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        d = a(java/util/BitSet, c);
        e = new ir() {

            public Boolean a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                if (jx1.f() == jy.f)
                {
                    return Boolean.valueOf(Boolean.parseBoolean(jx1.h()));
                } else
                {
                    return Boolean.valueOf(jx1.i());
                }
            }

            public void a(jz jz1, Boolean boolean1)
            {
                if (boolean1 == null)
                {
                    jz1.f();
                    return;
                } else
                {
                    jz1.a(boolean1.booleanValue());
                    return;
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Boolean)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        g = a(Boolean.TYPE, java/lang/Boolean, e);
        h = new ir() {

            public Number a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                byte byte0;
                try
                {
                    byte0 = (byte)jx1.m();
                }
                // Misplaced declaration of an exception variable
                catch (jx jx1)
                {
                    throw new io(jx1);
                }
                return Byte.valueOf(byte0);
            }

            public void a(jz jz1, Number number)
            {
                jz1.a(number);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Number)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        i = a(Byte.TYPE, java/lang/Byte, h);
        j = new ir() {

            public Number a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                short word0;
                try
                {
                    word0 = (short)jx1.m();
                }
                // Misplaced declaration of an exception variable
                catch (jx jx1)
                {
                    throw new io(jx1);
                }
                return Short.valueOf(word0);
            }

            public void a(jz jz1, Number number)
            {
                jz1.a(number);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Number)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        k = a(Short.TYPE, java/lang/Short, j);
        l = new ir() {

            public Number a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                int i1;
                try
                {
                    i1 = jx1.m();
                }
                // Misplaced declaration of an exception variable
                catch (jx jx1)
                {
                    throw new io(jx1);
                }
                return Integer.valueOf(i1);
            }

            public void a(jz jz1, Number number)
            {
                jz1.a(number);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Number)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        m = a(Integer.TYPE, java/lang/Integer, l);
        q = new ir() {

            public Number a(jx jx1)
            {
                jy jy1 = jx1.f();
                switch (_cls25.a[jy1.ordinal()])
                {
                case 2: // '\002'
                case 3: // '\003'
                default:
                    throw new io((new StringBuilder()).append("Expecting number, got: ").append(jy1).toString());

                case 4: // '\004'
                    jx1.j();
                    return null;

                case 1: // '\001'
                    return new jd(jx1.h());
                }
            }

            public void a(jz jz1, Number number)
            {
                jz1.a(number);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Number)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        r = a(java/lang/Number, q);
        s = new ir() {

            public Character a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                jx1 = jx1.h();
                if (jx1.length() != 1)
                {
                    throw new io((new StringBuilder()).append("Expecting character, got: ").append(jx1).toString());
                } else
                {
                    return Character.valueOf(jx1.charAt(0));
                }
            }

            public void a(jz jz1, Character character)
            {
                if (character == null)
                {
                    character = null;
                } else
                {
                    character = String.valueOf(character);
                }
                jz1.b(character);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Character)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        t = a(Character.TYPE, java/lang/Character, s);
        u = new ir() {

            public String a(jx jx1)
            {
                jy jy1 = jx1.f();
                if (jy1 == jy.i)
                {
                    jx1.j();
                    return null;
                }
                if (jy1 == jy.h)
                {
                    return Boolean.toString(jx1.i());
                } else
                {
                    return jx1.h();
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (String)obj);
            }

            public void a(jz jz1, String s1)
            {
                jz1.b(s1);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        x = a(java/lang/String, u);
        y = new ir() {

            public StringBuilder a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                } else
                {
                    return new StringBuilder(jx1.h());
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (StringBuilder)obj);
            }

            public void a(jz jz1, StringBuilder stringbuilder)
            {
                if (stringbuilder == null)
                {
                    stringbuilder = null;
                } else
                {
                    stringbuilder = stringbuilder.toString();
                }
                jz1.b(stringbuilder);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        z = a(java/lang/StringBuilder, y);
        A = new ir() {

            public StringBuffer a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                } else
                {
                    return new StringBuffer(jx1.h());
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (StringBuffer)obj);
            }

            public void a(jz jz1, StringBuffer stringbuffer)
            {
                if (stringbuffer == null)
                {
                    stringbuffer = null;
                } else
                {
                    stringbuffer = stringbuffer.toString();
                }
                jz1.b(stringbuffer);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        B = a(java/lang/StringBuffer, A);
        C = new ir() {

            public URL a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                } else
                {
                    jx1 = jx1.h();
                    if (!"null".equals(jx1))
                    {
                        return new URL(jx1);
                    }
                }
                return null;
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (URL)obj);
            }

            public void a(jz jz1, URL url)
            {
                if (url == null)
                {
                    url = null;
                } else
                {
                    url = url.toExternalForm();
                }
                jz1.b(url);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        D = a(java/net/URL, C);
        E = new ir() {

            public URI a(jx jx1)
            {
                if (jx1.f() != jy.i) goto _L2; else goto _L1
_L1:
                jx1.j();
_L4:
                return null;
_L2:
                jx1 = jx1.h();
                if ("null".equals(jx1)) goto _L4; else goto _L3
_L3:
                jx1 = new URI(jx1);
                return jx1;
                jx1;
                throw new ih(jx1);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (URI)obj);
            }

            public void a(jz jz1, URI uri)
            {
                if (uri == null)
                {
                    uri = null;
                } else
                {
                    uri = uri.toASCIIString();
                }
                jz1.b(uri);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        F = a(java/net/URI, E);
        G = new ir() {

            public InetAddress a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                } else
                {
                    return InetAddress.getByName(jx1.h());
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (InetAddress)obj);
            }

            public void a(jz jz1, InetAddress inetaddress)
            {
                if (inetaddress == null)
                {
                    inetaddress = null;
                } else
                {
                    inetaddress = inetaddress.getHostAddress();
                }
                jz1.b(inetaddress);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        H = b(java/net/InetAddress, G);
        I = new ir() {

            public UUID a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                } else
                {
                    return UUID.fromString(jx1.h());
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (UUID)obj);
            }

            public void a(jz jz1, UUID uuid)
            {
                if (uuid == null)
                {
                    uuid = null;
                } else
                {
                    uuid = uuid.toString();
                }
                jz1.b(uuid);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        J = a(java/util/UUID, I);
        L = new ir() {

            public Calendar a(jx jx1)
            {
                int j1 = 0;
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                jx1.c();
                int k1 = 0;
                int l1 = 0;
                int i2 = 0;
                int j2 = 0;
                int k2 = 0;
                do
                {
                    if (jx1.f() == jy.d)
                    {
                        break;
                    }
                    String s1 = jx1.g();
                    int i1 = jx1.m();
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
                jx1.d();
                return new GregorianCalendar(k2, j2, i2, l1, k1, j1);
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Calendar)obj);
            }

            public void a(jz jz1, Calendar calendar)
            {
                if (calendar == null)
                {
                    jz1.f();
                    return;
                } else
                {
                    jz1.d();
                    jz1.a("year");
                    jz1.a(calendar.get(1));
                    jz1.a("month");
                    jz1.a(calendar.get(2));
                    jz1.a("dayOfMonth");
                    jz1.a(calendar.get(5));
                    jz1.a("hourOfDay");
                    jz1.a(calendar.get(11));
                    jz1.a("minute");
                    jz1.a(calendar.get(12));
                    jz1.a("second");
                    jz1.a(calendar.get(13));
                    jz1.e();
                    return;
                }
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        M = b(java/util/Calendar, java/util/GregorianCalendar, L);
        N = new ir() {

            public Locale a(jx jx1)
            {
                if (jx1.f() == jy.i)
                {
                    jx1.j();
                    return null;
                }
                Object obj = new StringTokenizer(jx1.h(), "_");
                String s1;
                if (((StringTokenizer) (obj)).hasMoreElements())
                {
                    jx1 = ((StringTokenizer) (obj)).nextToken();
                } else
                {
                    jx1 = null;
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
                    return new Locale(jx1);
                }
                if (obj == null)
                {
                    return new Locale(jx1, s1);
                } else
                {
                    return new Locale(jx1, s1, ((String) (obj)));
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (Locale)obj);
            }

            public void a(jz jz1, Locale locale)
            {
                if (locale == null)
                {
                    locale = null;
                } else
                {
                    locale = locale.toString();
                }
                jz1.b(locale);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        O = a(java/util/Locale, N);
        P = new ir() {

            public ig a(jx jx1)
            {
                ij ij1;
                switch (_cls25.a[jx1.f().ordinal()])
                {
                default:
                    throw new IllegalArgumentException();

                case 3: // '\003'
                    return new il(jx1.h());

                case 1: // '\001'
                    return new il(new jd(jx1.h()));

                case 2: // '\002'
                    return new il(Boolean.valueOf(jx1.i()));

                case 4: // '\004'
                    jx1.j();
                    return ii.a;

                case 5: // '\005'
                    id id1 = new id();
                    jx1.a();
                    for (; jx1.e(); id1.a(a(jx1))) { }
                    jx1.b();
                    return id1;

                case 6: // '\006'
                    ij1 = new ij();
                    jx1.c();
                    break;
                }
                for (; jx1.e(); ij1.a(jx1.g(), a(jx1))) { }
                jx1.d();
                return ij1;
            }

            public void a(jz jz1, ig ig1)
            {
                if (ig1 == null || ig1.j())
                {
                    jz1.f();
                    return;
                }
                if (ig1.i())
                {
                    ig1 = ig1.m();
                    if (ig1.p())
                    {
                        jz1.a(ig1.a());
                        return;
                    }
                    if (ig1.o())
                    {
                        jz1.a(ig1.f());
                        return;
                    } else
                    {
                        jz1.b(ig1.b());
                        return;
                    }
                }
                if (ig1.g())
                {
                    jz1.b();
                    for (ig1 = ig1.l().iterator(); ig1.hasNext(); a(jz1, (ig)ig1.next())) { }
                    jz1.c();
                    return;
                }
                if (ig1.h())
                {
                    jz1.d();
                    java.util.Map.Entry entry;
                    for (ig1 = ig1.k().o().iterator(); ig1.hasNext(); a(jz1, (ig)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)ig1.next();
                        jz1.a((String)entry.getKey());
                    }

                    jz1.e();
                    return;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Couldn't write ").append(ig1.getClass()).toString());
                }
            }

            public volatile void a(jz jz1, Object obj)
            {
                a(jz1, (ig)obj);
            }

            public Object b(jx jx1)
            {
                return a(jx1);
            }

        };
        Q = b(com/flurry/sdk/ig, P);
    }
}
