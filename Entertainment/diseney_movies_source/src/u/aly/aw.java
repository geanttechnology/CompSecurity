// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
//            dg, bw, cg, cz, 
//            db, de

public class aw
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, aw aw1)
            throws cf
        {
            cy1.j();
_L6:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!aw1.e())
                {
                    throw new cz((new StringBuilder("Required field 'lat' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                }
                break MISSING_BLOCK_LABEL_205;
            }
            ct1.c;
            JVM INSTR tableswitch 1 3: default 84
        //                       1 99
        //                       2 134
        //                       3 169;
               goto _L1 _L2 _L3 _L4
_L4:
            break MISSING_BLOCK_LABEL_169;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L7:
            cy1.m();
            if (true) goto _L6; else goto _L5
_L5:
            if (ct1.b == 4)
            {
                aw1.a = cy1.y();
                aw1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
_L3:
            if (ct1.b == 4)
            {
                aw1.b = cy1.y();
                aw1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
            if (ct1.b == 10)
            {
                aw1.c = cy1.x();
                aw1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
            if (!aw1.i())
            {
                throw new cz((new StringBuilder("Required field 'lng' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            }
            if (!aw1.l())
            {
                throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            } else
            {
                aw1.m();
                return;
            }
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (aw)bz1);
        }

        public void b(cy cy1, aw aw1)
            throws cf
        {
            aw1.m();
            cy1.a(aw.n());
            cy1.a(aw.o());
            cy1.a(aw1.a);
            cy1.c();
            cy1.a(aw.p());
            cy1.a(aw1.b);
            cy1.c();
            cy1.a(aw.q());
            cy1.a(aw1.c);
            cy1.c();
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (aw)bz1);
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

        public void a(cy cy1, aw aw1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(aw1.a);
            cy1.a(aw1.b);
            cy1.a(aw1.c);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (aw)bz1);
        }

        public void b(cy cy1, aw aw1)
            throws cf
        {
            cy1 = (de)cy1;
            aw1.a = cy1.y();
            aw1.a(true);
            aw1.b = cy1.y();
            aw1.b(true);
            aw1.c = cy1.x();
            aw1.c(true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (aw)bz1);
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
            return (e)Enum.valueOf(u/aly/aw$e, s);
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
            a = new e("LAT", 0, (short)1, "lat");
            b = new e("LNG", 1, (short)2, "lng");
            c = new e("TS", 2, (short)3, "ts");
            g = (new e[] {
                a, b, c
            });
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/aw$e).iterator();
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
    private static final dd e = new dd("Location");
    private static final ct f = new ct("lat", (byte)4, (short)1);
    private static final ct g = new ct("lng", (byte)4, (short)2);
    private static final ct h = new ct("ts", (byte)10, (short)3);
    private static final Map i;
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    public double a;
    public double b;
    public long c;
    private byte m;

    public aw()
    {
        m = 0;
    }

    public aw(double d1, double d2, long l1)
    {
        this();
        a = d1;
        a(true);
        b = d2;
        b(true);
        c = l1;
        c(true);
    }

    public aw(aw aw1)
    {
        m = 0;
        m = aw1.m;
        a = aw1.a;
        b = aw1.b;
        c = aw1.c;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            m = 0;
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

    public aw a()
    {
        return new aw(this);
    }

    public aw a(double d1)
    {
        a = d1;
        a(true);
        return this;
    }

    public aw a(long l1)
    {
        c = l1;
        c(true);
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        m = bw.a(m, 0, flag);
    }

    public aw b(double d1)
    {
        b = d1;
        b(true);
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a(false);
        a = 0.0D;
        b(false);
        b = 0.0D;
        c(false);
        c = 0L;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)i.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        m = bw.a(m, 1, flag);
    }

    public double c()
    {
        return a;
    }

    public void c(boolean flag)
    {
        m = bw.a(m, 2, flag);
    }

    public void d()
    {
        m = bw.b(m, 0);
    }

    public boolean e()
    {
        return bw.a(m, 0);
    }

    public double f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        m = bw.b(m, 1);
    }

    public boolean i()
    {
        return bw.a(m, 1);
    }

    public long j()
    {
        return c;
    }

    public void k()
    {
        m = bw.b(m, 2);
    }

    public boolean l()
    {
        return bw.a(m, 2);
    }

    public void m()
        throws cf
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Location(");
        stringbuilder.append("lat:");
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append("lng:");
        stringbuilder.append(b);
        stringbuilder.append(", ");
        stringbuilder.append("ts:");
        stringbuilder.append(c);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        i = new HashMap();
        i.put(u/aly/di, new b(null));
        i.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/aw$e);
        enummap.put(e.a, new cl("lat", (byte)1, new cm((byte)4)));
        enummap.put(e.b, new cl("lng", (byte)1, new cm((byte)4)));
        enummap.put(e.c, new cl("ts", (byte)1, new cm((byte)10)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/aw, d);
    }
}
