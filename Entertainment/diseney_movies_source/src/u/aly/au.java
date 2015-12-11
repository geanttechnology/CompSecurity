// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, cm, cf, 
//            cs, dk, cy, dh, 
//            dg, bw, cz, cg, 
//            db, de

public class au
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, au au1)
            throws cf
        {
            cy1.j();
_L5:
            ct ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!au1.i())
                {
                    throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    au1.m();
                    return;
                }
            }
            ct1.c;
            JVM INSTR tableswitch 1 3: default 84
        //                       1 99
        //                       2 135
        //                       3 171;
               goto _L1 _L2 _L3 _L4
_L4:
            break MISSING_BLOCK_LABEL_171;
_L1:
            db.a(cy1, ct1.b);
_L6:
            cy1.m();
              goto _L5
_L2:
            if (ct1.b == 11)
            {
                au1.a = cy1.z();
                au1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L6
_L3:
            if (ct1.b == 10)
            {
                au1.b = cy1.x();
                au1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L6
            if (ct1.b == 11)
            {
                au1.c = cy1.z();
                au1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L6
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (au)bz1);
        }

        public void b(cy cy1, au au1)
            throws cf
        {
            au1.m();
            cy1.a(au.n());
            if (au1.a != null && au1.e())
            {
                cy1.a(au.o());
                cy1.a(au1.a);
                cy1.c();
            }
            cy1.a(au.p());
            cy1.a(au1.b);
            cy1.c();
            if (au1.c != null)
            {
                cy1.a(au.q());
                cy1.a(au1.c);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (au)bz1);
        }

        private a()
        {
        }

        a(a a1)
        {
            this();
        }
    }

    private static class b
        implements dh
    {

        public a a()
        {
            return new a(null);
        }

        public dg b()
        {
            return a();
        }

        private b()
        {
        }

        b(b b1)
        {
            this();
        }
    }

    private static class c extends dj
    {

        public void a(cy cy1, au au1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(au1.b);
            cy1.a(au1.c);
            BitSet bitset = new BitSet();
            if (au1.e())
            {
                bitset.set(0);
            }
            cy1.a(bitset, 1);
            if (au1.e())
            {
                cy1.a(au1.a);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (au)bz1);
        }

        public void b(cy cy1, au au1)
            throws cf
        {
            cy1 = (de)cy1;
            au1.b = cy1.x();
            au1.b(true);
            au1.c = cy1.z();
            au1.c(true);
            if (cy1.b(1).get(0))
            {
                au1.a = cy1.z();
                au1.a(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (au)bz1);
        }

        private c()
        {
        }

        c(c c1)
        {
            this();
        }
    }

    private static class d
        implements dh
    {

        public c a()
        {
            return new c(null);
        }

        public dg b()
        {
            return a();
        }

        private d()
        {
        }

        d(d d1)
        {
            this();
        }
    }

    public static final class e extends Enum
        implements cg
    {

        public static final e a;
        public static final e b;
        public static final e c;
        private static final Map d;
        private static final e g[];
        private final short e;
        private final String f;

        public static e a(int i1)
        {
            switch (i1)
            {
            default:
                return null;

            case 1: // '\001'
                return a;

            case 2: // '\002'
                return b;

            case 3: // '\003'
                return c;
            }
        }

        public static e a(String s)
        {
            return (e)d.get(s);
        }

        public static e b(int i1)
        {
            e e1 = a(i1);
            if (e1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());
            } else
            {
                return e1;
            }
        }

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(u/aly/au$e, s);
        }

        public static e[] values()
        {
            e ae[] = g;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return e;
        }

        public String b()
        {
            return f;
        }

        static 
        {
            a = new e("VALUE", 0, (short)1, "value");
            b = new e("TS", 1, (short)2, "ts");
            c = new e("GUID", 2, (short)3, "guid");
            g = (new e[] {
                a, b, c
            });
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/au$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                d.put(e1.b(), e1);
            } while (true);
        }

        private e(String s, int i1, short word0, String s1)
        {
            super(s, i1);
            e = word0;
            f = s1;
        }
    }


    public static final Map d;
    private static final dd e = new dd("ImprintValue");
    private static final ct f = new ct("value", (byte)11, (short)1);
    private static final ct g = new ct("ts", (byte)10, (short)2);
    private static final ct h = new ct("guid", (byte)11, (short)3);
    private static final Map i;
    private static final int j = 0;
    public String a;
    public long b;
    public String c;
    private byte k;
    private e l[];

    public au()
    {
        k = 0;
        l = (new e[] {
            e.a
        });
    }

    public au(long l1, String s)
    {
        this();
        b = l1;
        b(true);
        c = s;
    }

    public au(au au1)
    {
        k = 0;
        l = (new e[] {
            e.a
        });
        k = au1.k;
        if (au1.e())
        {
            a = au1.a;
        }
        b = au1.b;
        if (au1.l())
        {
            c = au1.c;
        }
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            k = 0;
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

    static dd n()
    {
        return e;
    }

    static ct o()
    {
        return f;
    }

    static ct p()
    {
        return g;
    }

    static ct q()
    {
        return h;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public au a()
    {
        return new au(this);
    }

    public au a(long l1)
    {
        b = l1;
        b(true);
        return this;
    }

    public au a(String s)
    {
        a = s;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public au b(String s)
    {
        c = s;
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0L;
        c = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)i.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        k = bw.a(k, 0, flag);
    }

    public String c()
    {
        return a;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public void d()
    {
        a = null;
    }

    public boolean e()
    {
        return a != null;
    }

    public long f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        k = bw.b(k, 0);
    }

    public boolean i()
    {
        return bw.a(k, 0);
    }

    public String j()
    {
        return c;
    }

    public void k()
    {
        c = null;
    }

    public boolean l()
    {
        return c != null;
    }

    public void m()
        throws cf
    {
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'guid' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ImprintValue(");
        boolean flag = true;
        if (e())
        {
            stringbuilder.append("value:");
            if (a == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(a);
            }
            flag = false;
        }
        if (!flag)
        {
            stringbuilder.append(", ");
        }
        stringbuilder.append("ts:");
        stringbuilder.append(b);
        stringbuilder.append(", ");
        stringbuilder.append("guid:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        i = new HashMap();
        i.put(u/aly/di, new b(null));
        i.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/au$e);
        enummap.put(e.a, new cl("value", (byte)2, new cm((byte)11)));
        enummap.put(e.b, new cl("ts", (byte)1, new cm((byte)10)));
        enummap.put(e.c, new cl("guid", (byte)1, new cm((byte)11)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/au, d);
    }
}
