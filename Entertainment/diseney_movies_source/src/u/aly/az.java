// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package u.aly:
//            cj, dd, ct, cl, 
//            cm, cf, cs, dk, 
//            cy, db, cz, ca, 
//            cg, bz

public class az extends cj
{
    public static final class a extends Enum
        implements cg
    {

        public static final a a;
        public static final a b;
        private static final Map c;
        private static final a f[];
        private final short d;
        private final String e;

        public static a a(int j)
        {
            switch (j)
            {
            default:
                return null;

            case 1: // '\001'
                return a;

            case 2: // '\002'
                return b;
            }
        }

        public static a a(String s)
        {
            return (a)c.get(s);
        }

        public static a b(int j)
        {
            a a1 = a(j);
            if (a1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(j).append(" doesn't exist!").toString());
            } else
            {
                return a1;
            }
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(u/aly/az$a, s);
        }

        public static a[] values()
        {
            a aa[] = f;
            int j = aa.length;
            a aa1[] = new a[j];
            System.arraycopy(aa, 0, aa1, 0, j);
            return aa1;
        }

        public short a()
        {
            return d;
        }

        public String b()
        {
            return e;
        }

        static 
        {
            a = new a("STRING_VALUE", 0, (short)1, "string_value");
            b = new a("LONG_VALUE", 1, (short)2, "long_value");
            f = (new a[] {
                a, b
            });
            c = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/az$a).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                a a1 = (a)iterator.next();
                c.put(a1.b(), a1);
            } while (true);
        }

        private a(String s, int j, short word0, String s1)
        {
            super(s, j);
            d = word0;
            e = s1;
        }
    }


    public static final Map a;
    private static final dd d = new dd("PropertyValue");
    private static final ct e = new ct("string_value", (byte)11, (short)1);
    private static final ct f = new ct("long_value", (byte)10, (short)2);
    private static int g[];

    public az()
    {
    }

    public az(a a1, Object obj)
    {
        super(a1, obj);
    }

    public az(az az1)
    {
        super(az1);
    }

    public static az a(long l)
    {
        az az1 = new az();
        az1.b(l);
        return az1;
    }

    public static az a(String s)
    {
        az az1 = new az();
        az1.b(s);
        return az1;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            a(((cy) (new cs(new dk(objectinputstream)))));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInputStream objectinputstream)
        {
            throw new IOException(objectinputstream.getMessage());
        }
    }

    private void a(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        try
        {
            b(new cs(new dk(objectoutputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOutputStream objectoutputstream)
        {
            throw new IOException(objectoutputstream.getMessage());
        }
    }

    static int[] i()
    {
        int ai[] = g;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[a.values().length];
        try
        {
            ai[a.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[a.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        g = ai;
        return ai;
    }

    protected Object a(cy cy1, ct ct1)
        throws cf
    {
label0:
        {
label1:
            {
                String s = null;
                a a1 = a.a(ct1.c);
                if (a1 != null)
                {
                    switch (i()[a1.ordinal()])
                    {
                    default:
                        throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");

                    case 2: // '\002'
                        break label0;

                    case 1: // '\001'
                        break;
                    }
                    if (ct1.b != e.b)
                    {
                        break label1;
                    }
                    s = cy1.z();
                }
                return s;
            }
            db.a(cy1, ct1.b);
            return null;
        }
        if (ct1.b == f.b)
        {
            return Long.valueOf(cy1.x());
        } else
        {
            db.a(cy1, ct1.b);
            return null;
        }
    }

    protected Object a(cy cy1, short word0)
        throws cf
    {
        a a1 = a.a(word0);
        if (a1 != null)
        {
            switch (i()[a1.ordinal()])
            {
            default:
                throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");

            case 1: // '\001'
                return cy1.z();

            case 2: // '\002'
                return Long.valueOf(cy1.x());
            }
        } else
        {
            throw new cz((new StringBuilder("Couldn't find a field with field id ")).append(word0).toString());
        }
    }

    public a a(int j)
    {
        return a.a(j);
    }

    protected a a(short word0)
    {
        return a.b(word0);
    }

    public az a()
    {
        return new az(this);
    }

    protected ct a(a a1)
    {
        switch (i()[a1.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown field id ")).append(a1).toString());

        case 1: // '\001'
            return e;

        case 2: // '\002'
            return f;
        }
    }

    protected volatile ct a(cg cg)
    {
        return a((a)cg);
    }

    protected void a(a a1, Object obj)
        throws ClassCastException
    {
        i()[a1.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 56
    //                   2 94;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown field id ")).append(a1).toString());
_L2:
        if (!(obj instanceof String)) goto _L5; else goto _L4
_L4:
        return;
_L5:
        throw new ClassCastException((new StringBuilder("Was expecting value of type String for field 'string_value', but got ")).append(obj.getClass().getSimpleName()).toString());
_L3:
        if (!(obj instanceof Long))
        {
            throw new ClassCastException((new StringBuilder("Was expecting value of type Long for field 'long_value', but got ")).append(obj.getClass().getSimpleName()).toString());
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected volatile void a(cg cg, Object obj)
        throws ClassCastException
    {
        a((a)cg, obj);
    }

    public boolean a(az az1)
    {
        return az1 != null && j() == az1.j() && k().equals(az1.k());
    }

    public int b(az az1)
    {
        int k = ca.a((Comparable)j(), (Comparable)az1.j());
        int j = k;
        if (k == 0)
        {
            j = ca.a(k(), az1.k());
        }
        return j;
    }

    public cg b(int j)
    {
        return a(j);
    }

    protected cg b(short word0)
    {
        return a(word0);
    }

    public void b(long l)
    {
        c = a.b;
        b = Long.valueOf(l);
    }

    public void b(String s)
    {
        if (s == null)
        {
            throw new NullPointerException();
        } else
        {
            c = a.a;
            b = s;
            return;
        }
    }

    protected dd c()
    {
        return d;
    }

    protected void c(cy cy1)
        throws cf
    {
        switch (i()[((a)c).ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Cannot write union with unknown field ")).append(c).toString());

        case 1: // '\001'
            cy1.a((String)b);
            return;

        case 2: // '\002'
            cy1.a(((Long)b).longValue());
            break;
        }
    }

    public String d()
    {
        if (j() == a.a)
        {
            return (String)k();
        } else
        {
            throw new RuntimeException((new StringBuilder("Cannot get field 'string_value' because union is currently set to ")).append(a((a)j()).a).toString());
        }
    }

    protected void d(cy cy1)
        throws cf
    {
        switch (i()[((a)c).ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Cannot write union with unknown field ")).append(c).toString());

        case 1: // '\001'
            cy1.a((String)b);
            return;

        case 2: // '\002'
            cy1.a(((Long)b).longValue());
            break;
        }
    }

    public long e()
    {
        if (j() == a.b)
        {
            return ((Long)k()).longValue();
        } else
        {
            throw new RuntimeException((new StringBuilder("Cannot get field 'long_value' because union is currently set to ")).append(a((a)j()).a).toString());
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof az)
        {
            return a((az)obj);
        } else
        {
            return false;
        }
    }

    public boolean f()
    {
        return c == a.a;
    }

    public bz g()
    {
        return a();
    }

    public boolean h()
    {
        return c == a.b;
    }

    public int hashCode()
    {
        return 0;
    }

    static 
    {
        EnumMap enummap = new EnumMap(u/aly/az$a);
        enummap.put(a.a, new cl("string_value", (byte)3, new cm((byte)11)));
        enummap.put(a.b, new cl("long_value", (byte)3, new cm((byte)10)));
        a = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/az, a);
    }
}
