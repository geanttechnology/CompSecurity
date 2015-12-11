// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
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

// Referenced classes of package android.support.v7:
//            afa, afl, afm, afp, 
//            afb, afi, agq, aeu, 
//            aff, afx, afc, aex, 
//            afd

public final class agp
{
    private static final class a extends afl
    {

        private final Map a;
        private final Map b;

        public Enum a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return (Enum)a.get(jsonreader.nextString());
            }
        }

        public void a(JsonWriter jsonwriter, Enum enum)
            throws IOException
        {
            if (enum == null)
            {
                enum = null;
            } else
            {
                enum = (String)b.get(enum);
            }
            jsonwriter.value(enum);
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (Enum)obj);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

        public a(Class class1)
        {
            a = new HashMap();
            b = new HashMap();
            String s1;
            Enum aenum[];
            Enum enum;
            afp afp1;
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
            afp1 = (afp)class1.getField(s1).getAnnotation(android/support/v7/afp);
            if (afp1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            s1 = afp1.a();
            a.put(s1, enum);
            b.put(enum, s1);
            i1++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_41;
_L1:
        }
    }


    public static final afl A;
    public static final afm B;
    public static final afl C;
    public static final afm D;
    public static final afl E;
    public static final afm F;
    public static final afl G;
    public static final afm H;
    public static final afl I;
    public static final afm J;
    public static final afm K = new afm() {

        public afl a(aeu aeu1, agq agq1)
        {
            if (agq1.a() != java/sql/Timestamp)
            {
                return null;
            } else
            {
                return new afl(this, aeu1.a(java/util/Date)) {

                    final afl a;
                    final _cls15 b;

                    public Timestamp a(JsonReader jsonreader)
                        throws IOException
                    {
                        jsonreader = (Date)a.b(jsonreader);
                        if (jsonreader != null)
                        {
                            return new Timestamp(jsonreader.getTime());
                        } else
                        {
                            return null;
                        }
                    }

                    public volatile void a(JsonWriter jsonwriter, Object obj)
                        throws IOException
                    {
                        a(jsonwriter, (Timestamp)obj);
                    }

                    public void a(JsonWriter jsonwriter, Timestamp timestamp)
                        throws IOException
                    {
                        a.a(jsonwriter, timestamp);
                    }

                    public Object b(JsonReader jsonreader)
                        throws IOException
                    {
                        return a(jsonreader);
                    }

            
            {
                b = _pcls15;
                a = afl1;
                super();
            }
                };
            }
        }

    };
    public static final afl L;
    public static final afm M;
    public static final afl N;
    public static final afm O;
    public static final afl P;
    public static final afm Q;
    public static final afm R = new afm() {

        public afl a(aeu aeu, agq agq1)
        {
            agq1 = agq1.a();
            if (!java/lang/Enum.isAssignableFrom(agq1) || agq1 == java/lang/Enum)
            {
                return null;
            }
            aeu = agq1;
            if (!agq1.isEnum())
            {
                aeu = agq1.getSuperclass();
            }
            return new a(aeu);
        }

    };
    public static final afl a;
    public static final afm b;
    public static final afl c;
    public static final afm d;
    public static final afl e;
    public static final afl f = new afl() {

        public Boolean a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Boolean.valueOf(jsonreader.nextString());
            }
        }

        public void a(JsonWriter jsonwriter, Boolean boolean1)
            throws IOException
        {
            if (boolean1 == null)
            {
                boolean1 = "null";
            } else
            {
                boolean1 = boolean1.toString();
            }
            jsonwriter.value(boolean1);
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (Boolean)obj);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

    };
    public static final afm g;
    public static final afl h;
    public static final afm i;
    public static final afl j;
    public static final afm k;
    public static final afl l;
    public static final afm m;
    public static final afl n = new afl() {

        public Number a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            long l1;
            try
            {
                l1 = jsonreader.nextLong();
            }
            // Misplaced declaration of an exception variable
            catch (JsonReader jsonreader)
            {
                throw new afi(jsonreader);
            }
            return Long.valueOf(l1);
        }

        public void a(JsonWriter jsonwriter, Number number)
            throws IOException
        {
            jsonwriter.value(number);
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (Number)obj);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

    };
    public static final afl o = new afl() {

        public Number a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Float.valueOf((float)jsonreader.nextDouble());
            }
        }

        public void a(JsonWriter jsonwriter, Number number)
            throws IOException
        {
            jsonwriter.value(number);
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (Number)obj);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

    };
    public static final afl p = new afl() {

        public Number a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            } else
            {
                return Double.valueOf(jsonreader.nextDouble());
            }
        }

        public void a(JsonWriter jsonwriter, Number number)
            throws IOException
        {
            jsonwriter.value(number);
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (Number)obj);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

    };
    public static final afl q;
    public static final afm r;
    public static final afl s;
    public static final afm t;
    public static final afl u;
    public static final afl v = new afl() {

        public BigDecimal a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            try
            {
                jsonreader = new BigDecimal(jsonreader.nextString());
            }
            // Misplaced declaration of an exception variable
            catch (JsonReader jsonreader)
            {
                throw new afi(jsonreader);
            }
            return jsonreader;
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (BigDecimal)obj);
        }

        public void a(JsonWriter jsonwriter, BigDecimal bigdecimal)
            throws IOException
        {
            jsonwriter.value(bigdecimal);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

    };
    public static final afl w = new afl() {

        public BigInteger a(JsonReader jsonreader)
            throws IOException
        {
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            try
            {
                jsonreader = new BigInteger(jsonreader.nextString());
            }
            // Misplaced declaration of an exception variable
            catch (JsonReader jsonreader)
            {
                throw new afi(jsonreader);
            }
            return jsonreader;
        }

        public volatile void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            a(jsonwriter, (BigInteger)obj);
        }

        public void a(JsonWriter jsonwriter, BigInteger biginteger)
            throws IOException
        {
            jsonwriter.value(biginteger);
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            return a(jsonreader);
        }

    };
    public static final afm x;
    public static final afl y;
    public static final afm z;

    public static afm a(Class class1, afl afl)
    {
        return new afm(class1, afl) {

            final Class a;
            final afl b;

            public afl a(aeu aeu, agq agq1)
            {
                if (agq1.a() == a)
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
                b = afl;
                super();
            }
        };
    }

    public static afm a(Class class1, Class class2, afl afl)
    {
        return new afm(class1, class2, afl) {

            final Class a;
            final Class b;
            final afl c;

            public afl a(aeu aeu, agq agq1)
            {
                aeu = agq1.a();
                if (aeu == a || aeu == b)
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
                c = afl;
                super();
            }
        };
    }

    public static afm b(Class class1, afl afl)
    {
        return new afm(class1, afl) {

            final Class a;
            final afl b;

            public afl a(aeu aeu, agq agq1)
            {
                if (a.isAssignableFrom(agq1.a()))
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
                b = afl;
                super();
            }
        };
    }

    public static afm b(Class class1, Class class2, afl afl)
    {
        return new afm(class1, class2, afl) {

            final Class a;
            final Class b;
            final afl c;

            public afl a(aeu aeu, agq agq1)
            {
                aeu = agq1.a();
                if (aeu == a || aeu == b)
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
                c = afl;
                super();
            }
        };
    }

    static 
    {
        a = new afl() {

            public Class a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
                }
            }

            public void a(JsonWriter jsonwriter, Class class1)
                throws IOException
            {
                if (class1 == null)
                {
                    jsonwriter.nullValue();
                    return;
                } else
                {
                    throw new UnsupportedOperationException((new StringBuilder()).append("Attempted to serialize java.lang.Class: ").append(class1.getName()).append(". Forgot to register a type adapter?").toString());
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Class)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        b = a(java/lang/Class, a);
        c = new afl() {

            public BitSet a(JsonReader jsonreader)
                throws IOException
            {
                JsonToken jsontoken;
                BitSet bitset;
                int i1;
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                bitset = new BitSet();
                jsonreader.beginArray();
                jsontoken = jsonreader.peek();
                i1 = 0;
_L2:
                boolean flag;
                if (jsontoken == JsonToken.END_ARRAY)
                {
                    break MISSING_BLOCK_LABEL_209;
                }
                static class _cls25
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

                switch (_cls25.a[jsontoken.ordinal()])
                {
                default:
                    throw new afi((new StringBuilder()).append("Invalid bitset value type: ").append(jsontoken).toString());

                case 2: // '\002'
                    break; /* Loop/switch isn't completed */

                case 3: // '\003'
                    break MISSING_BLOCK_LABEL_153;

                case 1: // '\001'
                    if (jsonreader.nextInt() != 0)
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
                jsontoken = jsonreader.peek();
                if (true) goto _L2; else goto _L1
_L1:
                flag = jsonreader.nextBoolean();
                  goto _L3
                String s1 = jsonreader.nextString();
                int j1;
                try
                {
                    j1 = Integer.parseInt(s1);
                }
                // Misplaced declaration of an exception variable
                catch (JsonReader jsonreader)
                {
                    throw new afi((new StringBuilder()).append("Error: Expecting: bitset number value (1, 0), Found: ").append(s1).toString());
                }
                if (j1 != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                  goto _L3
                jsonreader.endArray();
                return bitset;
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (BitSet)obj);
            }

            public void a(JsonWriter jsonwriter, BitSet bitset)
                throws IOException
            {
                if (bitset == null)
                {
                    jsonwriter.nullValue();
                    return;
                }
                jsonwriter.beginArray();
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
                    jsonwriter.value(j1);
                    i1++;
                }
                jsonwriter.endArray();
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        d = a(java/util/BitSet, c);
        e = new afl() {

            public Boolean a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                if (jsonreader.peek() == JsonToken.STRING)
                {
                    return Boolean.valueOf(Boolean.parseBoolean(jsonreader.nextString()));
                } else
                {
                    return Boolean.valueOf(jsonreader.nextBoolean());
                }
            }

            public void a(JsonWriter jsonwriter, Boolean boolean1)
                throws IOException
            {
                if (boolean1 == null)
                {
                    jsonwriter.nullValue();
                    return;
                } else
                {
                    jsonwriter.value(boolean1.booleanValue());
                    return;
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Boolean)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        g = a(Boolean.TYPE, java/lang/Boolean, e);
        h = new afl() {

            public Number a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                byte byte0;
                try
                {
                    byte0 = (byte)jsonreader.nextInt();
                }
                // Misplaced declaration of an exception variable
                catch (JsonReader jsonreader)
                {
                    throw new afi(jsonreader);
                }
                return Byte.valueOf(byte0);
            }

            public void a(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Number)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        i = a(Byte.TYPE, java/lang/Byte, h);
        j = new afl() {

            public Number a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                short word0;
                try
                {
                    word0 = (short)jsonreader.nextInt();
                }
                // Misplaced declaration of an exception variable
                catch (JsonReader jsonreader)
                {
                    throw new afi(jsonreader);
                }
                return Short.valueOf(word0);
            }

            public void a(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Number)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        k = a(Short.TYPE, java/lang/Short, j);
        l = new afl() {

            public Number a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                int i1;
                try
                {
                    i1 = jsonreader.nextInt();
                }
                // Misplaced declaration of an exception variable
                catch (JsonReader jsonreader)
                {
                    throw new afi(jsonreader);
                }
                return Integer.valueOf(i1);
            }

            public void a(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Number)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        m = a(Integer.TYPE, java/lang/Integer, l);
        q = new afl() {

            public Number a(JsonReader jsonreader)
                throws IOException
            {
                JsonToken jsontoken = jsonreader.peek();
                switch (_cls25.a[jsontoken.ordinal()])
                {
                case 2: // '\002'
                case 3: // '\003'
                default:
                    throw new afi((new StringBuilder()).append("Expecting number, got: ").append(jsontoken).toString());

                case 4: // '\004'
                    jsonreader.nextNull();
                    return null;

                case 1: // '\001'
                    return new afx(jsonreader.nextString());
                }
            }

            public void a(JsonWriter jsonwriter, Number number)
                throws IOException
            {
                jsonwriter.value(number);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Number)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        r = a(java/lang/Number, q);
        s = new afl() {

            public Character a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                jsonreader = jsonreader.nextString();
                if (jsonreader.length() != 1)
                {
                    throw new afi((new StringBuilder()).append("Expecting character, got: ").append(jsonreader).toString());
                } else
                {
                    return Character.valueOf(jsonreader.charAt(0));
                }
            }

            public void a(JsonWriter jsonwriter, Character character)
                throws IOException
            {
                if (character == null)
                {
                    character = null;
                } else
                {
                    character = String.valueOf(character);
                }
                jsonwriter.value(character);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Character)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        t = a(Character.TYPE, java/lang/Character, s);
        u = new afl() {

            public String a(JsonReader jsonreader)
                throws IOException
            {
                JsonToken jsontoken = jsonreader.peek();
                if (jsontoken == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                if (jsontoken == JsonToken.BOOLEAN)
                {
                    return Boolean.toString(jsonreader.nextBoolean());
                } else
                {
                    return jsonreader.nextString();
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (String)obj);
            }

            public void a(JsonWriter jsonwriter, String s1)
                throws IOException
            {
                jsonwriter.value(s1);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        x = a(java/lang/String, u);
        y = new afl() {

            public StringBuilder a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return new StringBuilder(jsonreader.nextString());
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (StringBuilder)obj);
            }

            public void a(JsonWriter jsonwriter, StringBuilder stringbuilder)
                throws IOException
            {
                if (stringbuilder == null)
                {
                    stringbuilder = null;
                } else
                {
                    stringbuilder = stringbuilder.toString();
                }
                jsonwriter.value(stringbuilder);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        z = a(java/lang/StringBuilder, y);
        A = new afl() {

            public StringBuffer a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return new StringBuffer(jsonreader.nextString());
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (StringBuffer)obj);
            }

            public void a(JsonWriter jsonwriter, StringBuffer stringbuffer)
                throws IOException
            {
                if (stringbuffer == null)
                {
                    stringbuffer = null;
                } else
                {
                    stringbuffer = stringbuffer.toString();
                }
                jsonwriter.value(stringbuffer);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        B = a(java/lang/StringBuffer, A);
        C = new afl() {

            public URL a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                } else
                {
                    jsonreader = jsonreader.nextString();
                    if (!"null".equals(jsonreader))
                    {
                        return new URL(jsonreader);
                    }
                }
                return null;
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (URL)obj);
            }

            public void a(JsonWriter jsonwriter, URL url)
                throws IOException
            {
                if (url == null)
                {
                    url = null;
                } else
                {
                    url = url.toExternalForm();
                }
                jsonwriter.value(url);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        D = a(java/net/URL, C);
        E = new afl() {

            public URI a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
                jsonreader.nextNull();
_L4:
                return null;
_L2:
                jsonreader = jsonreader.nextString();
                if ("null".equals(jsonreader)) goto _L4; else goto _L3
_L3:
                jsonreader = new URI(jsonreader);
                return jsonreader;
                jsonreader;
                throw new afb(jsonreader);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (URI)obj);
            }

            public void a(JsonWriter jsonwriter, URI uri)
                throws IOException
            {
                if (uri == null)
                {
                    uri = null;
                } else
                {
                    uri = uri.toASCIIString();
                }
                jsonwriter.value(uri);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        F = a(java/net/URI, E);
        G = new afl() {

            public InetAddress a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return InetAddress.getByName(jsonreader.nextString());
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (InetAddress)obj);
            }

            public void a(JsonWriter jsonwriter, InetAddress inetaddress)
                throws IOException
            {
                if (inetaddress == null)
                {
                    inetaddress = null;
                } else
                {
                    inetaddress = inetaddress.getHostAddress();
                }
                jsonwriter.value(inetaddress);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        H = b(java/net/InetAddress, G);
        I = new afl() {

            public UUID a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                } else
                {
                    return UUID.fromString(jsonreader.nextString());
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (UUID)obj);
            }

            public void a(JsonWriter jsonwriter, UUID uuid)
                throws IOException
            {
                if (uuid == null)
                {
                    uuid = null;
                } else
                {
                    uuid = uuid.toString();
                }
                jsonwriter.value(uuid);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        J = a(java/util/UUID, I);
        L = new afl() {

            public Calendar a(JsonReader jsonreader)
                throws IOException
            {
                int j1 = 0;
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                jsonreader.beginObject();
                int k1 = 0;
                int l1 = 0;
                int i2 = 0;
                int j2 = 0;
                int k2 = 0;
                do
                {
                    if (jsonreader.peek() == JsonToken.END_OBJECT)
                    {
                        break;
                    }
                    String s1 = jsonreader.nextName();
                    int i1 = jsonreader.nextInt();
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
                jsonreader.endObject();
                return new GregorianCalendar(k2, j2, i2, l1, k1, j1);
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Calendar)obj);
            }

            public void a(JsonWriter jsonwriter, Calendar calendar)
                throws IOException
            {
                if (calendar == null)
                {
                    jsonwriter.nullValue();
                    return;
                } else
                {
                    jsonwriter.beginObject();
                    jsonwriter.name("year");
                    jsonwriter.value(calendar.get(1));
                    jsonwriter.name("month");
                    jsonwriter.value(calendar.get(2));
                    jsonwriter.name("dayOfMonth");
                    jsonwriter.value(calendar.get(5));
                    jsonwriter.name("hourOfDay");
                    jsonwriter.value(calendar.get(11));
                    jsonwriter.name("minute");
                    jsonwriter.value(calendar.get(12));
                    jsonwriter.name("second");
                    jsonwriter.value(calendar.get(13));
                    jsonwriter.endObject();
                    return;
                }
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        M = b(java/util/Calendar, java/util/GregorianCalendar, L);
        N = new afl() {

            public Locale a(JsonReader jsonreader)
                throws IOException
            {
                if (jsonreader.peek() == JsonToken.NULL)
                {
                    jsonreader.nextNull();
                    return null;
                }
                Object obj = new StringTokenizer(jsonreader.nextString(), "_");
                String s1;
                if (((StringTokenizer) (obj)).hasMoreElements())
                {
                    jsonreader = ((StringTokenizer) (obj)).nextToken();
                } else
                {
                    jsonreader = null;
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
                    return new Locale(jsonreader);
                }
                if (obj == null)
                {
                    return new Locale(jsonreader, s1);
                } else
                {
                    return new Locale(jsonreader, s1, ((String) (obj)));
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (Locale)obj);
            }

            public void a(JsonWriter jsonwriter, Locale locale)
                throws IOException
            {
                if (locale == null)
                {
                    locale = null;
                } else
                {
                    locale = locale.toString();
                }
                jsonwriter.value(locale);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        O = a(java/util/Locale, N);
        P = new afl() {

            public afa a(JsonReader jsonreader)
                throws IOException
            {
                afd afd1;
                switch (_cls25.a[jsonreader.peek().ordinal()])
                {
                default:
                    throw new IllegalArgumentException();

                case 3: // '\003'
                    return new aff(jsonreader.nextString());

                case 1: // '\001'
                    return new aff(new afx(jsonreader.nextString()));

                case 2: // '\002'
                    return new aff(Boolean.valueOf(jsonreader.nextBoolean()));

                case 4: // '\004'
                    jsonreader.nextNull();
                    return afc.a;

                case 5: // '\005'
                    aex aex1 = new aex();
                    jsonreader.beginArray();
                    for (; jsonreader.hasNext(); aex1.a(a(jsonreader))) { }
                    jsonreader.endArray();
                    return aex1;

                case 6: // '\006'
                    afd1 = new afd();
                    jsonreader.beginObject();
                    break;
                }
                for (; jsonreader.hasNext(); afd1.a(jsonreader.nextName(), a(jsonreader))) { }
                jsonreader.endObject();
                return afd1;
            }

            public void a(JsonWriter jsonwriter, afa afa1)
                throws IOException
            {
                if (afa1 == null || afa1.j())
                {
                    jsonwriter.nullValue();
                    return;
                }
                if (afa1.i())
                {
                    afa1 = afa1.m();
                    if (afa1.p())
                    {
                        jsonwriter.value(afa1.a());
                        return;
                    }
                    if (afa1.o())
                    {
                        jsonwriter.value(afa1.f());
                        return;
                    } else
                    {
                        jsonwriter.value(afa1.b());
                        return;
                    }
                }
                if (afa1.g())
                {
                    jsonwriter.beginArray();
                    for (afa1 = afa1.l().iterator(); afa1.hasNext(); a(jsonwriter, (afa)afa1.next())) { }
                    jsonwriter.endArray();
                    return;
                }
                if (afa1.h())
                {
                    jsonwriter.beginObject();
                    java.util.Map.Entry entry;
                    for (afa1 = afa1.k().o().iterator(); afa1.hasNext(); a(jsonwriter, (afa)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)afa1.next();
                        jsonwriter.name((String)entry.getKey());
                    }

                    jsonwriter.endObject();
                    return;
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Couldn't write ").append(afa1.getClass()).toString());
                }
            }

            public volatile void a(JsonWriter jsonwriter, Object obj)
                throws IOException
            {
                a(jsonwriter, (afa)obj);
            }

            public Object b(JsonReader jsonreader)
                throws IOException
            {
                return a(jsonreader);
            }

        };
        Q = b(android/support/v7/afa, P);
    }
}
