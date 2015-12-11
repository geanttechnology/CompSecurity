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
//            dj, cl, cm, ck, 
//            bc, cf, cs, dk, 
//            bw, cz, cy, dh, 
//            dg, cg, db, de

public class ai
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ai ai1)
            throws cf
        {
            cy1.j();
_L13:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                ai1.H();
                return;
            }
            ct1.c;
            JVM INSTR tableswitch 1 10: default 84
        //                       1 99
        //                       2 135
        //                       3 171
        //                       4 207
        //                       5 243
        //                       6 282
        //                       7 318
        //                       8 354
        //                       9 390
        //                       10 426;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
            break MISSING_BLOCK_LABEL_426;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L14:
            cy1.m();
            if (true) goto _L13; else goto _L12
_L12:
            if (ct1.b == 11)
            {
                ai1.a = cy1.z();
                ai1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L3:
            if (ct1.b == 11)
            {
                ai1.b = cy1.z();
                ai1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L4:
            if (ct1.b == 8)
            {
                ai1.c = cy1.w();
                ai1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L5:
            if (ct1.b == 11)
            {
                ai1.d = cy1.z();
                ai1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L6:
            if (ct1.b == 8)
            {
                ai1.e = bc.a(cy1.w());
                ai1.e(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L7:
            if (ct1.b == 11)
            {
                ai1.f = cy1.z();
                ai1.f(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L8:
            if (ct1.b == 11)
            {
                ai1.g = cy1.z();
                ai1.g(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L9:
            if (ct1.b == 11)
            {
                ai1.h = cy1.z();
                ai1.h(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
_L10:
            if (ct1.b == 11)
            {
                ai1.i = cy1.z();
                ai1.i(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
            if (ct1.b == 8)
            {
                ai1.j = cy1.w();
                ai1.j(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L14
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ai)bz1);
        }

        public void b(cy cy1, ai ai1)
            throws cf
        {
            ai1.H();
            cy1.a(ai.I());
            if (ai1.a != null)
            {
                cy1.a(ai.J());
                cy1.a(ai1.a);
                cy1.c();
            }
            if (ai1.b != null && ai1.i())
            {
                cy1.a(ai.K());
                cy1.a(ai1.b);
                cy1.c();
            }
            if (ai1.l())
            {
                cy1.a(ai.L());
                cy1.a(ai1.c);
                cy1.c();
            }
            if (ai1.d != null && ai1.o())
            {
                cy1.a(ai.M());
                cy1.a(ai1.d);
                cy1.c();
            }
            if (ai1.e != null)
            {
                cy1.a(ai.N());
                cy1.a(ai1.e.a());
                cy1.c();
            }
            if (ai1.f != null)
            {
                cy1.a(ai.O());
                cy1.a(ai1.f);
                cy1.c();
            }
            if (ai1.g != null)
            {
                cy1.a(ai.P());
                cy1.a(ai1.g);
                cy1.c();
            }
            if (ai1.h != null && ai1.A())
            {
                cy1.a(ai.Q());
                cy1.a(ai1.h);
                cy1.c();
            }
            if (ai1.i != null && ai1.D())
            {
                cy1.a(ai.R());
                cy1.a(ai1.i);
                cy1.c();
            }
            if (ai1.G())
            {
                cy1.a(ai.S());
                cy1.a(ai1.j);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ai)bz1);
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

        public void a(cy cy1, ai ai1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(ai1.a);
            cy1.a(ai1.e.a());
            cy1.a(ai1.f);
            cy1.a(ai1.g);
            BitSet bitset = new BitSet();
            if (ai1.i())
            {
                bitset.set(0);
            }
            if (ai1.l())
            {
                bitset.set(1);
            }
            if (ai1.o())
            {
                bitset.set(2);
            }
            if (ai1.A())
            {
                bitset.set(3);
            }
            if (ai1.D())
            {
                bitset.set(4);
            }
            if (ai1.G())
            {
                bitset.set(5);
            }
            cy1.a(bitset, 6);
            if (ai1.i())
            {
                cy1.a(ai1.b);
            }
            if (ai1.l())
            {
                cy1.a(ai1.c);
            }
            if (ai1.o())
            {
                cy1.a(ai1.d);
            }
            if (ai1.A())
            {
                cy1.a(ai1.h);
            }
            if (ai1.D())
            {
                cy1.a(ai1.i);
            }
            if (ai1.G())
            {
                cy1.a(ai1.j);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ai)bz1);
        }

        public void b(cy cy1, ai ai1)
            throws cf
        {
            cy1 = (de)cy1;
            ai1.a = cy1.z();
            ai1.a(true);
            ai1.e = bc.a(cy1.w());
            ai1.e(true);
            ai1.f = cy1.z();
            ai1.f(true);
            ai1.g = cy1.z();
            ai1.g(true);
            BitSet bitset = cy1.b(6);
            if (bitset.get(0))
            {
                ai1.b = cy1.z();
                ai1.b(true);
            }
            if (bitset.get(1))
            {
                ai1.c = cy1.w();
                ai1.c(true);
            }
            if (bitset.get(2))
            {
                ai1.d = cy1.z();
                ai1.d(true);
            }
            if (bitset.get(3))
            {
                ai1.h = cy1.z();
                ai1.h(true);
            }
            if (bitset.get(4))
            {
                ai1.i = cy1.z();
                ai1.i(true);
            }
            if (bitset.get(5))
            {
                ai1.j = cy1.w();
                ai1.j(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ai)bz1);
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
        public static final e j;
        private static final Map k;
        private static final e n[];
        private final short l;
        private final String m;

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

            case 10: // '\n'
                return j;
            }
        }

        public static e a(String s1)
        {
            return (e)k.get(s1);
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
            return (e)Enum.valueOf(u/aly/ai$e, s1);
        }

        public static e[] values()
        {
            e ae[] = n;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return l;
        }

        public String b()
        {
            return m;
        }

        static 
        {
            a = new e("KEY", 0, (short)1, "key");
            b = new e("VERSION", 1, (short)2, "version");
            c = new e("VERSION_INDEX", 2, (short)3, "version_index");
            d = new e("PACKAGE_NAME", 3, (short)4, "package_name");
            e = new e("SDK_TYPE", 4, (short)5, "sdk_type");
            f = new e("SDK_VERSION", 5, (short)6, "sdk_version");
            g = new e("CHANNEL", 6, (short)7, "channel");
            h = new e("WRAPPER_TYPE", 7, (short)8, "wrapper_type");
            i = new e("WRAPPER_VERSION", 8, (short)9, "wrapper_version");
            j = new e("VERTICAL_TYPE", 9, (short)10, "vertical_type");
            n = (new e[] {
                a, b, c, d, e, f, g, h, i, j
            });
            k = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ai$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                k.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            l = word0;
            m = s2;
        }
    }


    public static final Map k;
    private static final dd l = new dd("AppInfo");
    private static final ct m = new ct("key", (byte)11, (short)1);
    private static final ct n = new ct("version", (byte)11, (short)2);
    private static final ct o = new ct("version_index", (byte)8, (short)3);
    private static final ct p = new ct("package_name", (byte)11, (short)4);
    private static final ct q = new ct("sdk_type", (byte)8, (short)5);
    private static final ct r = new ct("sdk_version", (byte)11, (short)6);
    private static final ct s = new ct("channel", (byte)11, (short)7);
    private static final ct t = new ct("wrapper_type", (byte)11, (short)8);
    private static final ct u = new ct("wrapper_version", (byte)11, (short)9);
    private static final ct v = new ct("vertical_type", (byte)8, (short)10);
    private static final Map w;
    private static final int x = 0;
    private static final int y = 1;
    private e A[];
    public String a;
    public String b;
    public int c;
    public String d;
    public bc e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    private byte z;

    public ai()
    {
        z = 0;
        A = (new e[] {
            e.b, e.c, e.d, e.h, e.i, e.j
        });
    }

    public ai(String s1, bc bc1, String s2, String s3)
    {
        this();
        a = s1;
        e = bc1;
        f = s2;
        g = s3;
    }

    public ai(ai ai1)
    {
        z = 0;
        A = (new e[] {
            e.b, e.c, e.d, e.h, e.i, e.j
        });
        z = ai1.z;
        if (ai1.e())
        {
            a = ai1.a;
        }
        if (ai1.i())
        {
            b = ai1.b;
        }
        c = ai1.c;
        if (ai1.o())
        {
            d = ai1.d;
        }
        if (ai1.r())
        {
            e = ai1.e;
        }
        if (ai1.u())
        {
            f = ai1.f;
        }
        if (ai1.x())
        {
            g = ai1.g;
        }
        if (ai1.A())
        {
            h = ai1.h;
        }
        if (ai1.D())
        {
            i = ai1.i;
        }
        j = ai1.j;
    }

    static dd I()
    {
        return l;
    }

    static ct J()
    {
        return m;
    }

    static ct K()
    {
        return n;
    }

    static ct L()
    {
        return o;
    }

    static ct M()
    {
        return p;
    }

    static ct N()
    {
        return q;
    }

    static ct O()
    {
        return r;
    }

    static ct P()
    {
        return s;
    }

    static ct Q()
    {
        return t;
    }

    static ct R()
    {
        return u;
    }

    static ct S()
    {
        return v;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            z = 0;
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

    public boolean A()
    {
        return h != null;
    }

    public String B()
    {
        return i;
    }

    public void C()
    {
        i = null;
    }

    public boolean D()
    {
        return i != null;
    }

    public int E()
    {
        return j;
    }

    public void F()
    {
        z = bw.b(z, 1);
    }

    public boolean G()
    {
        return bw.a(z, 1);
    }

    public void H()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'key' was not present! Struct: ")).append(toString()).toString());
        }
        if (e == null)
        {
            throw new cz((new StringBuilder("Required field 'sdk_type' was not present! Struct: ")).append(toString()).toString());
        }
        if (f == null)
        {
            throw new cz((new StringBuilder("Required field 'sdk_version' was not present! Struct: ")).append(toString()).toString());
        }
        if (g == null)
        {
            throw new cz((new StringBuilder("Required field 'channel' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public ai a()
    {
        return new ai(this);
    }

    public ai a(int i1)
    {
        c = i1;
        c(true);
        return this;
    }

    public ai a(String s1)
    {
        a = s1;
        return this;
    }

    public ai a(bc bc1)
    {
        e = bc1;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)w.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public ai b(String s1)
    {
        b = s1;
        return this;
    }

    public cg b(int i1)
    {
        return d(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c(false);
        c = 0;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j(false);
        j = 0;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)w.get(cy1.D())).b().b(cy1, this);
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

    public ai c(int i1)
    {
        j = i1;
        j(true);
        return this;
    }

    public ai c(String s1)
    {
        d = s1;
        return this;
    }

    public void c(boolean flag)
    {
        z = bw.a(z, 0, flag);
    }

    public e d(int i1)
    {
        return e.a(i1);
    }

    public ai d(String s1)
    {
        f = s1;
        return this;
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        if (!flag)
        {
            d = null;
        }
    }

    public ai e(String s1)
    {
        g = s1;
        return this;
    }

    public void e(boolean flag)
    {
        if (!flag)
        {
            e = null;
        }
    }

    public boolean e()
    {
        return a != null;
    }

    public String f()
    {
        return b;
    }

    public ai f(String s1)
    {
        h = s1;
        return this;
    }

    public void f(boolean flag)
    {
        if (!flag)
        {
            f = null;
        }
    }

    public ai g(String s1)
    {
        i = s1;
        return this;
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

    public int j()
    {
        return c;
    }

    public void j(boolean flag)
    {
        z = bw.a(z, 1, flag);
    }

    public void k()
    {
        z = bw.b(z, 0);
    }

    public boolean l()
    {
        return bw.a(z, 0);
    }

    public String m()
    {
        return d;
    }

    public void n()
    {
        d = null;
    }

    public boolean o()
    {
        return d != null;
    }

    public bc p()
    {
        return e;
    }

    public void q()
    {
        e = null;
    }

    public boolean r()
    {
        return e != null;
    }

    public String s()
    {
        return f;
    }

    public void t()
    {
        f = null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("AppInfo(");
        stringbuilder.append("key:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        if (i())
        {
            stringbuilder.append(", ");
            stringbuilder.append("version:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("version_index:");
            stringbuilder.append(c);
        }
        if (o())
        {
            stringbuilder.append(", ");
            stringbuilder.append("package_name:");
            if (d == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(d);
            }
        }
        stringbuilder.append(", ");
        stringbuilder.append("sdk_type:");
        if (e == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(e);
        }
        stringbuilder.append(", ");
        stringbuilder.append("sdk_version:");
        if (f == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(f);
        }
        stringbuilder.append(", ");
        stringbuilder.append("channel:");
        if (g == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(g);
        }
        if (A())
        {
            stringbuilder.append(", ");
            stringbuilder.append("wrapper_type:");
            if (h == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(h);
            }
        }
        if (D())
        {
            stringbuilder.append(", ");
            stringbuilder.append("wrapper_version:");
            if (i == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(i);
            }
        }
        if (G())
        {
            stringbuilder.append(", ");
            stringbuilder.append("vertical_type:");
            stringbuilder.append(j);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public boolean u()
    {
        return f != null;
    }

    public String v()
    {
        return g;
    }

    public void w()
    {
        g = null;
    }

    public boolean x()
    {
        return g != null;
    }

    public String y()
    {
        return h;
    }

    public void z()
    {
        h = null;
    }

    static 
    {
        w = new HashMap();
        w.put(u/aly/di, new b(null));
        w.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ai$e);
        enummap.put(e.a, new cl("key", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("version", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("version_index", (byte)2, new cm((byte)8)));
        enummap.put(e.d, new cl("package_name", (byte)2, new cm((byte)11)));
        enummap.put(e.e, new cl("sdk_type", (byte)1, new ck((byte)16, u/aly/bc)));
        enummap.put(e.f, new cl("sdk_version", (byte)1, new cm((byte)11)));
        enummap.put(e.g, new cl("channel", (byte)1, new cm((byte)11)));
        enummap.put(e.h, new cl("wrapper_type", (byte)2, new cm((byte)11)));
        enummap.put(e.i, new cl("wrapper_version", (byte)2, new cm((byte)11)));
        enummap.put(e.j, new cl("vertical_type", (byte)2, new cm((byte)8)));
        k = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ai, k);
    }
}
