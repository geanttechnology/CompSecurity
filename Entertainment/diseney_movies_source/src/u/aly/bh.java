// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, cm, ca, 
//            cf, cs, dk, cz, 
//            cy, dh, dg, bw, 
//            cg, db, de

public class bh
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, bh bh1)
            throws cf
        {
            cy1.j();
_L12:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!bh1.o())
                {
                    throw new cz((new StringBuilder("Required field 'serial_num' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                }
                break MISSING_BLOCK_LABEL_447;
            }
            ct1.c;
            JVM INSTR tableswitch 1 9: default 108
        //                       1 123
        //                       2 159
        //                       3 195
        //                       4 231
        //                       5 267
        //                       6 303
        //                       7 339
        //                       8 375
        //                       9 411;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
            break MISSING_BLOCK_LABEL_411;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L13:
            cy1.m();
            if (true) goto _L12; else goto _L11
_L11:
            if (ct1.b == 11)
            {
                bh1.a = cy1.z();
                bh1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L3:
            if (ct1.b == 11)
            {
                bh1.b = cy1.z();
                bh1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L4:
            if (ct1.b == 11)
            {
                bh1.c = cy1.z();
                bh1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L5:
            if (ct1.b == 8)
            {
                bh1.d = cy1.w();
                bh1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L6:
            if (ct1.b == 8)
            {
                bh1.e = cy1.w();
                bh1.e(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L7:
            if (ct1.b == 8)
            {
                bh1.f = cy1.w();
                bh1.f(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L8:
            if (ct1.b == 11)
            {
                bh1.g = cy1.A();
                bh1.g(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
_L9:
            if (ct1.b == 11)
            {
                bh1.h = cy1.z();
                bh1.h(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
            if (ct1.b == 11)
            {
                bh1.i = cy1.z();
                bh1.i(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L13
            if (!bh1.r())
            {
                throw new cz((new StringBuilder("Required field 'ts_secs' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            }
            if (!bh1.u())
            {
                throw new cz((new StringBuilder("Required field 'length' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            } else
            {
                bh1.F();
                return;
            }
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bh)bz1);
        }

        public void b(cy cy1, bh bh1)
            throws cf
        {
            bh1.F();
            cy1.a(bh.G());
            if (bh1.a != null)
            {
                cy1.a(bh.H());
                cy1.a(bh1.a);
                cy1.c();
            }
            if (bh1.b != null)
            {
                cy1.a(bh.I());
                cy1.a(bh1.b);
                cy1.c();
            }
            if (bh1.c != null)
            {
                cy1.a(bh.J());
                cy1.a(bh1.c);
                cy1.c();
            }
            cy1.a(bh.K());
            cy1.a(bh1.d);
            cy1.c();
            cy1.a(bh.L());
            cy1.a(bh1.e);
            cy1.c();
            cy1.a(bh.M());
            cy1.a(bh1.f);
            cy1.c();
            if (bh1.g != null)
            {
                cy1.a(bh.N());
                cy1.a(bh1.g);
                cy1.c();
            }
            if (bh1.h != null)
            {
                cy1.a(bh.O());
                cy1.a(bh1.h);
                cy1.c();
            }
            if (bh1.i != null)
            {
                cy1.a(bh.P());
                cy1.a(bh1.i);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bh)bz1);
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

        public void a(cy cy1, bh bh1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(bh1.a);
            cy1.a(bh1.b);
            cy1.a(bh1.c);
            cy1.a(bh1.d);
            cy1.a(bh1.e);
            cy1.a(bh1.f);
            cy1.a(bh1.g);
            cy1.a(bh1.h);
            cy1.a(bh1.i);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bh)bz1);
        }

        public void b(cy cy1, bh bh1)
            throws cf
        {
            cy1 = (de)cy1;
            bh1.a = cy1.z();
            bh1.a(true);
            bh1.b = cy1.z();
            bh1.b(true);
            bh1.c = cy1.z();
            bh1.c(true);
            bh1.d = cy1.w();
            bh1.d(true);
            bh1.e = cy1.w();
            bh1.e(true);
            bh1.f = cy1.w();
            bh1.f(true);
            bh1.g = cy1.A();
            bh1.g(true);
            bh1.h = cy1.z();
            bh1.h(true);
            bh1.i = cy1.z();
            bh1.i(true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bh)bz1);
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
        public static final e d;
        public static final e e;
        public static final e f;
        public static final e g;
        public static final e h;
        public static final e i;
        private static final Map j;
        private static final e m[];
        private final short k;
        private final String l;

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

            case 4: // '\004'
                return d;

            case 5: // '\005'
                return e;

            case 6: // '\006'
                return f;

            case 7: // '\007'
                return g;

            case 8: // '\b'
                return h;

            case 9: // '\t'
                return i;
            }
        }

        public static e a(String s1)
        {
            return (e)j.get(s1);
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

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(u/aly/bh$e, s1);
        }

        public static e[] values()
        {
            e ae[] = m;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return k;
        }

        public String b()
        {
            return l;
        }

        static 
        {
            a = new e("VERSION", 0, (short)1, "version");
            b = new e("ADDRESS", 1, (short)2, "address");
            c = new e("SIGNATURE", 2, (short)3, "signature");
            d = new e("SERIAL_NUM", 3, (short)4, "serial_num");
            e = new e("TS_SECS", 4, (short)5, "ts_secs");
            f = new e("LENGTH", 5, (short)6, "length");
            g = new e("ENTITY", 6, (short)7, "entity");
            h = new e("GUID", 7, (short)8, "guid");
            i = new e("CHECKSUM", 8, (short)9, "checksum");
            m = (new e[] {
                a, b, c, d, e, f, g, h, i
            });
            j = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bh$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                j.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            k = word0;
            l = s2;
        }
    }


    public static final Map j;
    private static final dd k = new dd("UMEnvelope");
    private static final ct l = new ct("version", (byte)11, (short)1);
    private static final ct m = new ct("address", (byte)11, (short)2);
    private static final ct n = new ct("signature", (byte)11, (short)3);
    private static final ct o = new ct("serial_num", (byte)8, (short)4);
    private static final ct p = new ct("ts_secs", (byte)8, (short)5);
    private static final ct q = new ct("length", (byte)8, (short)6);
    private static final ct r = new ct("entity", (byte)11, (short)7);
    private static final ct s = new ct("guid", (byte)11, (short)8);
    private static final ct t = new ct("checksum", (byte)11, (short)9);
    private static final Map u;
    private static final int v = 0;
    private static final int w = 1;
    private static final int x = 2;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    private byte y;

    public bh()
    {
        y = 0;
    }

    public bh(String s1, String s2, String s3, int i1, int j1, int k1, ByteBuffer bytebuffer, 
            String s4, String s5)
    {
        this();
        a = s1;
        b = s2;
        c = s3;
        d = i1;
        d(true);
        e = j1;
        e(true);
        f = k1;
        f(true);
        g = bytebuffer;
        h = s4;
        i = s5;
    }

    public bh(bh bh1)
    {
        y = 0;
        y = bh1.y;
        if (bh1.e())
        {
            a = bh1.a;
        }
        if (bh1.i())
        {
            b = bh1.b;
        }
        if (bh1.l())
        {
            c = bh1.c;
        }
        d = bh1.d;
        e = bh1.e;
        f = bh1.f;
        if (bh1.y())
        {
            g = ca.d(bh1.g);
        }
        if (bh1.B())
        {
            h = bh1.h;
        }
        if (bh1.E())
        {
            i = bh1.i;
        }
    }

    static dd G()
    {
        return k;
    }

    static ct H()
    {
        return l;
    }

    static ct I()
    {
        return m;
    }

    static ct J()
    {
        return n;
    }

    static ct K()
    {
        return o;
    }

    static ct L()
    {
        return p;
    }

    static ct M()
    {
        return q;
    }

    static ct N()
    {
        return r;
    }

    static ct O()
    {
        return s;
    }

    static ct P()
    {
        return t;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            y = 0;
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

    public void A()
    {
        h = null;
    }

    public boolean B()
    {
        return h != null;
    }

    public String C()
    {
        return i;
    }

    public void D()
    {
        i = null;
    }

    public boolean E()
    {
        return i != null;
    }

    public void F()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'version' was not present! Struct: ")).append(toString()).toString());
        }
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'address' was not present! Struct: ")).append(toString()).toString());
        }
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'signature' was not present! Struct: ")).append(toString()).toString());
        }
        if (g == null)
        {
            throw new cz((new StringBuilder("Required field 'entity' was not present! Struct: ")).append(toString()).toString());
        }
        if (h == null)
        {
            throw new cz((new StringBuilder("Required field 'guid' was not present! Struct: ")).append(toString()).toString());
        }
        if (i == null)
        {
            throw new cz((new StringBuilder("Required field 'checksum' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public bh a()
    {
        return new bh(this);
    }

    public bh a(int i1)
    {
        d = i1;
        d(true);
        return this;
    }

    public bh a(String s1)
    {
        a = s1;
        return this;
    }

    public bh a(ByteBuffer bytebuffer)
    {
        g = bytebuffer;
        return this;
    }

    public bh a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            abyte0 = null;
        } else
        {
            abyte0 = ByteBuffer.wrap(abyte0);
        }
        a(((ByteBuffer) (abyte0)));
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)u.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public bh b(String s1)
    {
        b = s1;
        return this;
    }

    public cg b(int i1)
    {
        return e(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c = null;
        d(false);
        d = 0;
        e(false);
        e = 0;
        f(false);
        f = 0;
        g = null;
        h = null;
        i = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)u.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public String c()
    {
        return a;
    }

    public bh c(int i1)
    {
        e = i1;
        e(true);
        return this;
    }

    public bh c(String s1)
    {
        c = s1;
        return this;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public bh d(int i1)
    {
        f = i1;
        f(true);
        return this;
    }

    public bh d(String s1)
    {
        h = s1;
        return this;
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        y = bw.a(y, 0, flag);
    }

    public e e(int i1)
    {
        return e.a(i1);
    }

    public bh e(String s1)
    {
        i = s1;
        return this;
    }

    public void e(boolean flag)
    {
        y = bw.a(y, 1, flag);
    }

    public boolean e()
    {
        return a != null;
    }

    public String f()
    {
        return b;
    }

    public void f(boolean flag)
    {
        y = bw.a(y, 2, flag);
    }

    public bz g()
    {
        return a();
    }

    public void g(boolean flag)
    {
        if (!flag)
        {
            g = null;
        }
    }

    public void h()
    {
        b = null;
    }

    public void h(boolean flag)
    {
        if (!flag)
        {
            h = null;
        }
    }

    public void i(boolean flag)
    {
        if (!flag)
        {
            i = null;
        }
    }

    public boolean i()
    {
        return b != null;
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

    public int m()
    {
        return d;
    }

    public void n()
    {
        y = bw.b(y, 0);
    }

    public boolean o()
    {
        return bw.a(y, 0);
    }

    public int p()
    {
        return e;
    }

    public void q()
    {
        y = bw.b(y, 1);
    }

    public boolean r()
    {
        return bw.a(y, 1);
    }

    public int s()
    {
        return f;
    }

    public void t()
    {
        y = bw.b(y, 2);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("UMEnvelope(");
        stringbuilder.append("version:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("address:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        stringbuilder.append(", ");
        stringbuilder.append("signature:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(", ");
        stringbuilder.append("serial_num:");
        stringbuilder.append(d);
        stringbuilder.append(", ");
        stringbuilder.append("ts_secs:");
        stringbuilder.append(e);
        stringbuilder.append(", ");
        stringbuilder.append("length:");
        stringbuilder.append(f);
        stringbuilder.append(", ");
        stringbuilder.append("entity:");
        if (g == null)
        {
            stringbuilder.append("null");
        } else
        {
            ca.a(g, stringbuilder);
        }
        stringbuilder.append(", ");
        stringbuilder.append("guid:");
        if (h == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(h);
        }
        stringbuilder.append(", ");
        stringbuilder.append("checksum:");
        if (i == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(i);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public boolean u()
    {
        return bw.a(y, 2);
    }

    public byte[] v()
    {
        a(ca.c(g));
        if (g == null)
        {
            return null;
        } else
        {
            return g.array();
        }
    }

    public ByteBuffer w()
    {
        return g;
    }

    public void x()
    {
        g = null;
    }

    public boolean y()
    {
        return g != null;
    }

    public String z()
    {
        return h;
    }

    static 
    {
        u = new HashMap();
        u.put(u/aly/di, new b(null));
        u.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/bh$e);
        enummap.put(e.a, new cl("version", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("address", (byte)1, new cm((byte)11)));
        enummap.put(e.c, new cl("signature", (byte)1, new cm((byte)11)));
        enummap.put(e.d, new cl("serial_num", (byte)1, new cm((byte)8)));
        enummap.put(e.e, new cl("ts_secs", (byte)1, new cm((byte)8)));
        enummap.put(e.f, new cl("length", (byte)1, new cm((byte)8)));
        enummap.put(e.g, new cl("entity", (byte)1, new cm((byte)11, true)));
        enummap.put(e.h, new cl("guid", (byte)1, new cm((byte)11)));
        enummap.put(e.i, new cl("checksum", (byte)1, new cm((byte)11)));
        j = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bh, j);
    }
}
