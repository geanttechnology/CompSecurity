// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.JsonIOException;
import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.d;
import com.millennialmedia.google.gson.e;
import com.millennialmedia.google.gson.f;
import com.millennialmedia.google.gson.g;
import com.millennialmedia.google.gson.h;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.internal.LazilyParsedNumber;
import com.millennialmedia.google.gson.internal.LinkedHashTreeMap;
import com.millennialmedia.google.gson.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
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

// Referenced classes of package myobfuscated.ao:
//            q

public final class p
{

    public static final j A = new j() {

        public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
        {
            a1 = a1.a;
            if (!java/lang/Enum.isAssignableFrom(a1) || a1 == java/lang/Enum)
            {
                return null;
            }
            b1 = a1;
            if (!a1.isEnum())
            {
                b1 = a1.getSuperclass();
            }
            return new q(b1);
        }

    };
    private static i B;
    private static i C;
    private static i D;
    private static i E;
    private static i F;
    private static i G;
    private static i H;
    private static i I;
    private static i J;
    private static i K;
    private static i L;
    private static i M;
    private static i N;
    private static i O;
    private static i P;
    private static i Q;
    private static i R;
    public static final j a;
    public static final j b;
    public static final i c = new i() {

        public final Object a(a a1)
        {
            if (a1.f() == JsonToken.NULL)
            {
                a1.k();
                return null;
            } else
            {
                return Boolean.valueOf(a1.i());
            }
        }

        public final void a(b b1, Object obj)
        {
            obj = (Boolean)obj;
            if (obj == null)
            {
                obj = "null";
            } else
            {
                obj = ((Boolean) (obj)).toString();
            }
            b1.b(((String) (obj)));
        }

    };
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final i h = new i() {

        private static Number b(a a1)
        {
            if (a1.f() == JsonToken.NULL)
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
            catch (a a1)
            {
                throw new JsonSyntaxException(a1);
            }
            return Long.valueOf(l1);
        }

        public final Object a(a a1)
        {
            return b(a1);
        }

        public final volatile void a(b b1, Object obj)
        {
            b1.a((Number)obj);
        }

    };
    public static final i i = new i() {

        public final Object a(a a1)
        {
            if (a1.f() == JsonToken.NULL)
            {
                a1.k();
                return null;
            } else
            {
                return Float.valueOf((float)a1.l());
            }
        }

        public final volatile void a(b b1, Object obj)
        {
            b1.a((Number)obj);
        }

    };
    public static final i j = new i() {

        public final Object a(a a1)
        {
            if (a1.f() == JsonToken.NULL)
            {
                a1.k();
                return null;
            } else
            {
                return Double.valueOf(a1.l());
            }
        }

        public final volatile void a(b b1, Object obj)
        {
            b1.a((Number)obj);
        }

    };
    public static final j k;
    public static final j l;
    public static final i m = new i() {

        private static BigDecimal b(a a1)
        {
            if (a1.f() == JsonToken.NULL)
            {
                a1.k();
                return null;
            }
            try
            {
                a1 = new BigDecimal(a1.i());
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                throw new JsonSyntaxException(a1);
            }
            return a1;
        }

        public final Object a(a a1)
        {
            return b(a1);
        }

        public final volatile void a(b b1, Object obj)
        {
            b1.a((BigDecimal)obj);
        }

    };
    public static final i n = new i() {

        private static BigInteger b(a a1)
        {
            if (a1.f() == JsonToken.NULL)
            {
                a1.k();
                return null;
            }
            try
            {
                a1 = new BigInteger(a1.i());
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                throw new JsonSyntaxException(a1);
            }
            return a1;
        }

        public final Object a(a a1)
        {
            return b(a1);
        }

        public final volatile void a(b b1, Object obj)
        {
            b1.a((BigInteger)obj);
        }

    };
    public static final j o;
    public static final j p;
    public static final j q;
    public static final j r;
    public static final j s;
    public static final j t;
    public static final j u;
    public static final j v = new j() {

        public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
        {
            if (a1.a != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new i(b1.a(java/util/Date)) {

                    private i a;

                    public final Object a(a a1)
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

                    public final volatile void a(b b1, Object obj)
                    {
                        obj = (Timestamp)obj;
                        a.a(b1, obj);
                    }

            
            {
                a = i1;
                super();
            }
                };
            }
        }

    };
    public static final j w;
    public static final j x;
    public static final i y;
    public static final j z;

    public static j a(Class class1, i i1)
    {
        return new j(class1, i1) {

            private Class a;
            private i b;

            public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
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
                b = i1;
                super();
            }
        };
    }

    public static j a(Class class1, Class class2, i i1)
    {
        return new j(class1, class2, i1) {

            private Class a;
            private Class b;
            private i c;

            public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
            {
                b1 = a1.a;
                if (b1 == a || b1 == b)
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
                c = i1;
                super();
            }
        };
    }

    private static j b(Class class1, i i1)
    {
        return new j(class1, i1) {

            private Class a;
            private i b;

            public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
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
                b = i1;
                super();
            }
        };
    }

    static 
    {
        B = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                } else
                {
                    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (Class)obj;
                if (obj == null)
                {
                    b1.e();
                    return;
                } else
                {
                    throw new UnsupportedOperationException((new StringBuilder("Attempted to serialize java.lang.Class: ")).append(((Class) (obj)).getName()).append(". Forgot to register a type adapter?").toString());
                }
            }

        };
        a = a(java/lang/Class, B);
        C = new i() {

            private static BitSet b(a a1)
            {
                JsonToken jsontoken;
                BitSet bitset;
                int i1;
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                }
                bitset = new BitSet();
                a1.a();
                jsontoken = a1.f();
                i1 = 0;
_L2:
                boolean flag;
                if (jsontoken == JsonToken.END_ARRAY)
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                final class _cls25
                {

                    static final int a[];

                    static 
                    {
                        a = new int[JsonToken.values().length];
                        try
                        {
                            a[JsonToken.NUMBER.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            a[JsonToken.BOOLEAN.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            a[JsonToken.STRING.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            a[JsonToken.NULL.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            a[JsonToken.END_DOCUMENT.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            a[JsonToken.NAME.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            a[JsonToken.END_OBJECT.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            a[JsonToken.END_ARRAY.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (myobfuscated.ao._cls25.a[jsontoken.ordinal()])
                {
                default:
                    throw new JsonSyntaxException((new StringBuilder("Invalid bitset value type: ")).append(jsontoken).toString());

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
                jsontoken = a1.f();
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
                catch (a a1)
                {
                    throw new JsonSyntaxException((new StringBuilder("Error: Expecting: bitset number value (1, 0), Found: ")).append(s1).toString());
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

            public final Object a(a a1)
            {
                return b(a1);
            }

            public final void a(b b1, Object obj)
            {
                obj = (BitSet)obj;
                if (obj == null)
                {
                    b1.e();
                    return;
                }
                b1.a();
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
                    b1.a(j1);
                    i1++;
                }
                b1.b();
            }

        };
        b = a(java/util/BitSet, C);
        D = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                }
                if (a1.f() == JsonToken.STRING)
                {
                    return Boolean.valueOf(Boolean.parseBoolean(a1.i()));
                } else
                {
                    return Boolean.valueOf(a1.j());
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (Boolean)obj;
                if (obj == null)
                {
                    b1.e();
                    return;
                } else
                {
                    b1.a(((Boolean) (obj)).booleanValue());
                    return;
                }
            }

        };
        d = a(Boolean.TYPE, java/lang/Boolean, D);
        E = new i() {

            private static Number b(a a1)
            {
                if (a1.f() == JsonToken.NULL)
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
                catch (a a1)
                {
                    throw new JsonSyntaxException(a1);
                }
                return Byte.valueOf(byte0);
            }

            public final Object a(a a1)
            {
                return b(a1);
            }

            public final volatile void a(b b1, Object obj)
            {
                b1.a((Number)obj);
            }

        };
        e = a(Byte.TYPE, java/lang/Byte, E);
        F = new i() {

            private static Number b(a a1)
            {
                if (a1.f() == JsonToken.NULL)
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
                catch (a a1)
                {
                    throw new JsonSyntaxException(a1);
                }
                return Short.valueOf(word0);
            }

            public final Object a(a a1)
            {
                return b(a1);
            }

            public final volatile void a(b b1, Object obj)
            {
                b1.a((Number)obj);
            }

        };
        f = a(Short.TYPE, java/lang/Short, F);
        G = new i() {

            private static Number b(a a1)
            {
                if (a1.f() == JsonToken.NULL)
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
                catch (a a1)
                {
                    throw new JsonSyntaxException(a1);
                }
                return Integer.valueOf(i1);
            }

            public final Object a(a a1)
            {
                return b(a1);
            }

            public final volatile void a(b b1, Object obj)
            {
                b1.a((Number)obj);
            }

        };
        g = a(Integer.TYPE, java/lang/Integer, G);
        H = new i() {

            public final Object a(a a1)
            {
                JsonToken jsontoken = a1.f();
                switch (myobfuscated.ao._cls25.a[jsontoken.ordinal()])
                {
                case 2: // '\002'
                case 3: // '\003'
                default:
                    throw new JsonSyntaxException((new StringBuilder("Expecting number, got: ")).append(jsontoken).toString());

                case 4: // '\004'
                    a1.k();
                    return null;

                case 1: // '\001'
                    return new LazilyParsedNumber(a1.i());
                }
            }

            public final volatile void a(b b1, Object obj)
            {
                b1.a((Number)obj);
            }

        };
        k = a(java/lang/Number, H);
        I = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                }
                a1 = a1.i();
                if (a1.length() != 1)
                {
                    throw new JsonSyntaxException((new StringBuilder("Expecting character, got: ")).append(a1).toString());
                } else
                {
                    return Character.valueOf(a1.charAt(0));
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (Character)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = String.valueOf(obj);
                }
                b1.b(((String) (obj)));
            }

        };
        l = a(Character.TYPE, java/lang/Character, I);
        J = new i() {

            public final Object a(a a1)
            {
                JsonToken jsontoken = a1.f();
                if (jsontoken == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                }
                if (jsontoken == JsonToken.BOOLEAN)
                {
                    return Boolean.toString(a1.j());
                } else
                {
                    return a1.i();
                }
            }

            public final void a(b b1, Object obj)
            {
                b1.b((String)obj);
            }

        };
        o = a(java/lang/String, J);
        K = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                } else
                {
                    return new StringBuilder(a1.i());
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (StringBuilder)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((StringBuilder) (obj)).toString();
                }
                b1.b(((String) (obj)));
            }

        };
        p = a(java/lang/StringBuilder, K);
        L = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                } else
                {
                    return new StringBuffer(a1.i());
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (StringBuffer)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((StringBuffer) (obj)).toString();
                }
                b1.b(((String) (obj)));
            }

        };
        q = a(java/lang/StringBuffer, L);
        M = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
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

            public final void a(b b1, Object obj)
            {
                obj = (URL)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((URL) (obj)).toExternalForm();
                }
                b1.b(((String) (obj)));
            }

        };
        r = a(java/net/URL, M);
        N = new i() {

            private static URI b(a a1)
            {
                if (a1.f() != JsonToken.NULL) goto _L2; else goto _L1
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
                throw new JsonIOException(a1);
            }

            public final Object a(a a1)
            {
                return b(a1);
            }

            public final void a(b b1, Object obj)
            {
                obj = (URI)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((URI) (obj)).toASCIIString();
                }
                b1.b(((String) (obj)));
            }

        };
        s = a(java/net/URI, N);
        O = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                } else
                {
                    return InetAddress.getByName(a1.i());
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (InetAddress)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((InetAddress) (obj)).getHostAddress();
                }
                b1.b(((String) (obj)));
            }

        };
        t = b(java/net/InetAddress, O);
        P = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
                {
                    a1.k();
                    return null;
                } else
                {
                    return UUID.fromString(a1.i());
                }
            }

            public final void a(b b1, Object obj)
            {
                obj = (UUID)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((UUID) (obj)).toString();
                }
                b1.b(((String) (obj)));
            }

        };
        u = a(java/util/UUID, P);
        Q = new i() {

            public final Object a(a a1)
            {
                int j1 = 0;
                if (a1.f() == JsonToken.NULL)
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
                    if (a1.f() == JsonToken.END_OBJECT)
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

            public final void a(b b1, Object obj)
            {
                obj = (Calendar)obj;
                if (obj == null)
                {
                    b1.e();
                    return;
                } else
                {
                    b1.c();
                    b1.a("year");
                    b1.a(((Calendar) (obj)).get(1));
                    b1.a("month");
                    b1.a(((Calendar) (obj)).get(2));
                    b1.a("dayOfMonth");
                    b1.a(((Calendar) (obj)).get(5));
                    b1.a("hourOfDay");
                    b1.a(((Calendar) (obj)).get(11));
                    b1.a("minute");
                    b1.a(((Calendar) (obj)).get(12));
                    b1.a("second");
                    b1.a(((Calendar) (obj)).get(13));
                    b1.d();
                    return;
                }
            }

        };
        w = new j(java/util/Calendar, java/util/GregorianCalendar, Q) {

            private Class a;
            private Class b;
            private i c;

            public final i a(com.millennialmedia.google.gson.b b1, myobfuscated.ap.a a1)
            {
                b1 = a1.a;
                if (b1 == a || b1 == b)
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
                c = i1;
                super();
            }
        };
        R = new i() {

            public final Object a(a a1)
            {
                if (a1.f() == JsonToken.NULL)
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

            public final void a(b b1, Object obj)
            {
                obj = (Locale)obj;
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((Locale) (obj)).toString();
                }
                b1.b(((String) (obj)));
            }

        };
        x = a(java/util/Locale, R);
        y = new i() {

            private void a(b b1, e e1)
            {
                if (e1 == null || (e1 instanceof f))
                {
                    b1.e();
                    return;
                }
                if (e1 instanceof h)
                {
                    e1 = e1.g();
                    if (((h) (e1)).a instanceof Number)
                    {
                        b1.a(e1.a());
                        return;
                    }
                    if (((h) (e1)).a instanceof Boolean)
                    {
                        b1.a(e1.f());
                        return;
                    } else
                    {
                        b1.b(e1.b());
                        return;
                    }
                }
                if (e1 instanceof d)
                {
                    b1.a();
                    if (e1 instanceof d)
                    {
                        for (e1 = ((d)e1).iterator(); e1.hasNext(); a(b1, (e)e1.next())) { }
                    } else
                    {
                        throw new IllegalStateException("This is not a JSON Array.");
                    }
                    b1.b();
                    return;
                }
                if (e1 instanceof g)
                {
                    b1.c();
                    if (e1 instanceof g)
                    {
                        java.util.Map.Entry entry;
                        for (e1 = ((g)e1).a.entrySet().iterator(); e1.hasNext(); a(b1, (e)entry.getValue()))
                        {
                            entry = (java.util.Map.Entry)e1.next();
                            b1.a((String)entry.getKey());
                        }

                    } else
                    {
                        throw new IllegalStateException((new StringBuilder("Not a JSON Object: ")).append(e1).toString());
                    }
                    b1.d();
                    return;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder("Couldn't write ")).append(e1.getClass()).toString());
                }
            }

            private e b(a a1)
            {
                g g1;
                switch (myobfuscated.ao._cls25.a[a1.f().ordinal()])
                {
                default:
                    throw new IllegalArgumentException();

                case 3: // '\003'
                    return new h(a1.i());

                case 1: // '\001'
                    return new h(new LazilyParsedNumber(a1.i()));

                case 2: // '\002'
                    return new h(Boolean.valueOf(a1.j()));

                case 4: // '\004'
                    a1.k();
                    return f.a;

                case 5: // '\005'
                    d d1 = new d();
                    a1.a();
                    for (; a1.e(); d1.a(b(a1))) { }
                    a1.b();
                    return d1;

                case 6: // '\006'
                    g1 = new g();
                    a1.c();
                    break;
                }
                for (; a1.e(); g1.a(a1.h(), b(a1))) { }
                a1.d();
                return g1;
            }

            public final Object a(a a1)
            {
                return b(a1);
            }

            public final volatile void a(b b1, Object obj)
            {
                a(b1, (e)obj);
            }

        };
        z = b(com/millennialmedia/google/gson/e, y);
    }
}
