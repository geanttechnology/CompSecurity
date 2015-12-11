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
//            dj, cl, cm, cq, 
//            ba, cf, cs, dk, 
//            bw, cy, dh, dg, 
//            cg, db, de

public class ak
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ak ak1)
            throws cf
        {
            cy1.j();
_L20:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                ak1.ac();
                return;
            }
            ct1.c;
            JVM INSTR tableswitch 1 17: default 112
        //                       1 127
        //                       2 163
        //                       3 199
        //                       4 235
        //                       5 271
        //                       6 307
        //                       7 343
        //                       8 379
        //                       9 415
        //                       10 462
        //                       11 497
        //                       12 532
        //                       13 568
        //                       14 604
        //                       15 640
        //                       16 676
        //                       17 712;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L18:
            break MISSING_BLOCK_LABEL_712;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L21:
            cy1.m();
            if (true) goto _L20; else goto _L19
_L19:
            if (ct1.b == 11)
            {
                ak1.a = cy1.z();
                ak1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L3:
            if (ct1.b == 11)
            {
                ak1.b = cy1.z();
                ak1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L4:
            if (ct1.b == 11)
            {
                ak1.c = cy1.z();
                ak1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L5:
            if (ct1.b == 11)
            {
                ak1.d = cy1.z();
                ak1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L6:
            if (ct1.b == 11)
            {
                ak1.e = cy1.z();
                ak1.e(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L7:
            if (ct1.b == 11)
            {
                ak1.f = cy1.z();
                ak1.f(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L8:
            if (ct1.b == 11)
            {
                ak1.g = cy1.z();
                ak1.g(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L9:
            if (ct1.b == 11)
            {
                ak1.h = cy1.z();
                ak1.h(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L10:
            if (ct1.b == 12)
            {
                ak1.i = new ba();
                ak1.i.a(cy1);
                ak1.i(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L11:
            if (ct1.b == 2)
            {
                ak1.j = cy1.t();
                ak1.k(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L12:
            if (ct1.b == 2)
            {
                ak1.k = cy1.t();
                ak1.m(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L13:
            if (ct1.b == 11)
            {
                ak1.l = cy1.z();
                ak1.n(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L14:
            if (ct1.b == 11)
            {
                ak1.m = cy1.z();
                ak1.o(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L15:
            if (ct1.b == 10)
            {
                ak1.n = cy1.x();
                ak1.p(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L16:
            if (ct1.b == 11)
            {
                ak1.o = cy1.z();
                ak1.q(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
_L17:
            if (ct1.b == 11)
            {
                ak1.p = cy1.z();
                ak1.r(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
            if (ct1.b == 11)
            {
                ak1.q = cy1.z();
                ak1.s(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L21
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ak)bz1);
        }

        public void b(cy cy1, ak ak1)
            throws cf
        {
            ak1.ac();
            cy1.a(ak.ad());
            if (ak1.a != null && ak1.e())
            {
                cy1.a(ak.ae());
                cy1.a(ak1.a);
                cy1.c();
            }
            if (ak1.b != null && ak1.i())
            {
                cy1.a(ak.af());
                cy1.a(ak1.b);
                cy1.c();
            }
            if (ak1.c != null && ak1.l())
            {
                cy1.a(ak.ag());
                cy1.a(ak1.c);
                cy1.c();
            }
            if (ak1.d != null && ak1.o())
            {
                cy1.a(ak.ah());
                cy1.a(ak1.d);
                cy1.c();
            }
            if (ak1.e != null && ak1.r())
            {
                cy1.a(ak.ai());
                cy1.a(ak1.e);
                cy1.c();
            }
            if (ak1.f != null && ak1.u())
            {
                cy1.a(ak.aj());
                cy1.a(ak1.f);
                cy1.c();
            }
            if (ak1.g != null && ak1.x())
            {
                cy1.a(ak.ak());
                cy1.a(ak1.g);
                cy1.c();
            }
            if (ak1.h != null && ak1.A())
            {
                cy1.a(ak.al());
                cy1.a(ak1.h);
                cy1.c();
            }
            if (ak1.i != null && ak1.D())
            {
                cy1.a(ak.am());
                ak1.i.b(cy1);
                cy1.c();
            }
            if (ak1.G())
            {
                cy1.a(ak.an());
                cy1.a(ak1.j);
                cy1.c();
            }
            if (ak1.J())
            {
                cy1.a(ak.ao());
                cy1.a(ak1.k);
                cy1.c();
            }
            if (ak1.l != null && ak1.M())
            {
                cy1.a(ak.ap());
                cy1.a(ak1.l);
                cy1.c();
            }
            if (ak1.m != null && ak1.P())
            {
                cy1.a(ak.aq());
                cy1.a(ak1.m);
                cy1.c();
            }
            if (ak1.S())
            {
                cy1.a(ak.ar());
                cy1.a(ak1.n);
                cy1.c();
            }
            if (ak1.o != null && ak1.V())
            {
                cy1.a(ak.as());
                cy1.a(ak1.o);
                cy1.c();
            }
            if (ak1.p != null && ak1.Y())
            {
                cy1.a(ak.at());
                cy1.a(ak1.p);
                cy1.c();
            }
            if (ak1.q != null && ak1.ab())
            {
                cy1.a(ak.au());
                cy1.a(ak1.q);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ak)bz1);
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

        public void a(cy cy1, ak ak1)
            throws cf
        {
            cy1 = (de)cy1;
            BitSet bitset = new BitSet();
            if (ak1.e())
            {
                bitset.set(0);
            }
            if (ak1.i())
            {
                bitset.set(1);
            }
            if (ak1.l())
            {
                bitset.set(2);
            }
            if (ak1.o())
            {
                bitset.set(3);
            }
            if (ak1.r())
            {
                bitset.set(4);
            }
            if (ak1.u())
            {
                bitset.set(5);
            }
            if (ak1.x())
            {
                bitset.set(6);
            }
            if (ak1.A())
            {
                bitset.set(7);
            }
            if (ak1.D())
            {
                bitset.set(8);
            }
            if (ak1.G())
            {
                bitset.set(9);
            }
            if (ak1.J())
            {
                bitset.set(10);
            }
            if (ak1.M())
            {
                bitset.set(11);
            }
            if (ak1.P())
            {
                bitset.set(12);
            }
            if (ak1.S())
            {
                bitset.set(13);
            }
            if (ak1.V())
            {
                bitset.set(14);
            }
            if (ak1.Y())
            {
                bitset.set(15);
            }
            if (ak1.ab())
            {
                bitset.set(16);
            }
            cy1.a(bitset, 17);
            if (ak1.e())
            {
                cy1.a(ak1.a);
            }
            if (ak1.i())
            {
                cy1.a(ak1.b);
            }
            if (ak1.l())
            {
                cy1.a(ak1.c);
            }
            if (ak1.o())
            {
                cy1.a(ak1.d);
            }
            if (ak1.r())
            {
                cy1.a(ak1.e);
            }
            if (ak1.u())
            {
                cy1.a(ak1.f);
            }
            if (ak1.x())
            {
                cy1.a(ak1.g);
            }
            if (ak1.A())
            {
                cy1.a(ak1.h);
            }
            if (ak1.D())
            {
                ak1.i.b(cy1);
            }
            if (ak1.G())
            {
                cy1.a(ak1.j);
            }
            if (ak1.J())
            {
                cy1.a(ak1.k);
            }
            if (ak1.M())
            {
                cy1.a(ak1.l);
            }
            if (ak1.P())
            {
                cy1.a(ak1.m);
            }
            if (ak1.S())
            {
                cy1.a(ak1.n);
            }
            if (ak1.V())
            {
                cy1.a(ak1.o);
            }
            if (ak1.Y())
            {
                cy1.a(ak1.p);
            }
            if (ak1.ab())
            {
                cy1.a(ak1.q);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ak)bz1);
        }

        public void b(cy cy1, ak ak1)
            throws cf
        {
            cy1 = (de)cy1;
            BitSet bitset = cy1.b(17);
            if (bitset.get(0))
            {
                ak1.a = cy1.z();
                ak1.a(true);
            }
            if (bitset.get(1))
            {
                ak1.b = cy1.z();
                ak1.b(true);
            }
            if (bitset.get(2))
            {
                ak1.c = cy1.z();
                ak1.c(true);
            }
            if (bitset.get(3))
            {
                ak1.d = cy1.z();
                ak1.d(true);
            }
            if (bitset.get(4))
            {
                ak1.e = cy1.z();
                ak1.e(true);
            }
            if (bitset.get(5))
            {
                ak1.f = cy1.z();
                ak1.f(true);
            }
            if (bitset.get(6))
            {
                ak1.g = cy1.z();
                ak1.g(true);
            }
            if (bitset.get(7))
            {
                ak1.h = cy1.z();
                ak1.h(true);
            }
            if (bitset.get(8))
            {
                ak1.i = new ba();
                ak1.i.a(cy1);
                ak1.i(true);
            }
            if (bitset.get(9))
            {
                ak1.j = cy1.t();
                ak1.k(true);
            }
            if (bitset.get(10))
            {
                ak1.k = cy1.t();
                ak1.m(true);
            }
            if (bitset.get(11))
            {
                ak1.l = cy1.z();
                ak1.n(true);
            }
            if (bitset.get(12))
            {
                ak1.m = cy1.z();
                ak1.o(true);
            }
            if (bitset.get(13))
            {
                ak1.n = cy1.x();
                ak1.p(true);
            }
            if (bitset.get(14))
            {
                ak1.o = cy1.z();
                ak1.q(true);
            }
            if (bitset.get(15))
            {
                ak1.p = cy1.z();
                ak1.r(true);
            }
            if (bitset.get(16))
            {
                ak1.q = cy1.z();
                ak1.s(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ak)bz1);
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
        public static final e k;
        public static final e l;
        public static final e m;
        public static final e n;
        public static final e o;
        public static final e p;
        public static final e q;
        private static final Map r;
        private static final e u[];
        private final short s;
        private final String t;

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

            case 11: // '\013'
                return k;

            case 12: // '\f'
                return l;

            case 13: // '\r'
                return m;

            case 14: // '\016'
                return n;

            case 15: // '\017'
                return o;

            case 16: // '\020'
                return p;

            case 17: // '\021'
                return q;
            }
        }

        public static e a(String s1)
        {
            return (e)r.get(s1);
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
            return (e)Enum.valueOf(u/aly/ak$e, s1);
        }

        public static e[] values()
        {
            e ae1[] = u;
            int i1 = ae1.length;
            e ae2[] = new e[i1];
            System.arraycopy(ae1, 0, ae2, 0, i1);
            return ae2;
        }

        public short a()
        {
            return s;
        }

        public String b()
        {
            return t;
        }

        static 
        {
            a = new e("DEVICE_ID", 0, (short)1, "device_id");
            b = new e("IDMD5", 1, (short)2, "idmd5");
            c = new e("MAC_ADDRESS", 2, (short)3, "mac_address");
            d = new e("OPEN_UDID", 3, (short)4, "open_udid");
            e = new e("MODEL", 4, (short)5, "model");
            f = new e("CPU", 5, (short)6, "cpu");
            g = new e("OS", 6, (short)7, "os");
            h = new e("OS_VERSION", 7, (short)8, "os_version");
            i = new e("RESOLUTION", 8, (short)9, "resolution");
            j = new e("IS_JAILBROKEN", 9, (short)10, "is_jailbroken");
            k = new e("IS_PIRATED", 10, (short)11, "is_pirated");
            l = new e("DEVICE_BOARD", 11, (short)12, "device_board");
            m = new e("DEVICE_BRAND", 12, (short)13, "device_brand");
            n = new e("DEVICE_MANUTIME", 13, (short)14, "device_manutime");
            o = new e("DEVICE_MANUFACTURER", 14, (short)15, "device_manufacturer");
            p = new e("DEVICE_MANUID", 15, (short)16, "device_manuid");
            q = new e("DEVICE_NAME", 16, (short)17, "device_name");
            u = (new e[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q
            });
            r = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ak$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                r.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            s = word0;
            t = s2;
        }
    }


    private static final ct A = new ct("os_version", (byte)11, (short)8);
    private static final ct B = new ct("resolution", (byte)12, (short)9);
    private static final ct C = new ct("is_jailbroken", (byte)2, (short)10);
    private static final ct D = new ct("is_pirated", (byte)2, (short)11);
    private static final ct E = new ct("device_board", (byte)11, (short)12);
    private static final ct F = new ct("device_brand", (byte)11, (short)13);
    private static final ct G = new ct("device_manutime", (byte)10, (short)14);
    private static final ct H = new ct("device_manufacturer", (byte)11, (short)15);
    private static final ct I = new ct("device_manuid", (byte)11, (short)16);
    private static final ct J = new ct("device_name", (byte)11, (short)17);
    private static final Map K;
    private static final int L = 0;
    private static final int M = 1;
    private static final int N = 2;
    public static final Map r;
    private static final dd s = new dd("DeviceInfo");
    private static final ct t = new ct("device_id", (byte)11, (short)1);
    private static final ct u = new ct("idmd5", (byte)11, (short)2);
    private static final ct v = new ct("mac_address", (byte)11, (short)3);
    private static final ct w = new ct("open_udid", (byte)11, (short)4);
    private static final ct x = new ct("model", (byte)11, (short)5);
    private static final ct y = new ct("cpu", (byte)11, (short)6);
    private static final ct z = new ct("os", (byte)11, (short)7);
    private byte O;
    private e P[];
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public ba i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public long n;
    public String o;
    public String p;
    public String q;

    public ak()
    {
        O = 0;
        P = (new e[] {
            e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, 
            e.k, e.l, e.m, e.n, e.o, e.p, e.q
        });
    }

    public ak(ak ak1)
    {
        O = 0;
        P = (new e[] {
            e.a, e.b, e.c, e.d, e.e, e.f, e.g, e.h, e.i, e.j, 
            e.k, e.l, e.m, e.n, e.o, e.p, e.q
        });
        O = ak1.O;
        if (ak1.e())
        {
            a = ak1.a;
        }
        if (ak1.i())
        {
            b = ak1.b;
        }
        if (ak1.l())
        {
            c = ak1.c;
        }
        if (ak1.o())
        {
            d = ak1.d;
        }
        if (ak1.r())
        {
            e = ak1.e;
        }
        if (ak1.u())
        {
            f = ak1.f;
        }
        if (ak1.x())
        {
            g = ak1.g;
        }
        if (ak1.A())
        {
            h = ak1.h;
        }
        if (ak1.D())
        {
            i = new ba(ak1.i);
        }
        j = ak1.j;
        k = ak1.k;
        if (ak1.M())
        {
            l = ak1.l;
        }
        if (ak1.P())
        {
            m = ak1.m;
        }
        n = ak1.n;
        if (ak1.V())
        {
            o = ak1.o;
        }
        if (ak1.Y())
        {
            p = ak1.p;
        }
        if (ak1.ab())
        {
            q = ak1.q;
        }
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            O = 0;
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

    static dd ad()
    {
        return s;
    }

    static ct ae()
    {
        return t;
    }

    static ct af()
    {
        return u;
    }

    static ct ag()
    {
        return v;
    }

    static ct ah()
    {
        return w;
    }

    static ct ai()
    {
        return x;
    }

    static ct aj()
    {
        return y;
    }

    static ct ak()
    {
        return z;
    }

    static ct al()
    {
        return A;
    }

    static ct am()
    {
        return B;
    }

    static ct an()
    {
        return C;
    }

    static ct ao()
    {
        return D;
    }

    static ct ap()
    {
        return E;
    }

    static ct aq()
    {
        return F;
    }

    static ct ar()
    {
        return G;
    }

    static ct as()
    {
        return H;
    }

    static ct at()
    {
        return I;
    }

    static ct au()
    {
        return J;
    }

    public boolean A()
    {
        return h != null;
    }

    public ba B()
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

    public boolean E()
    {
        return j;
    }

    public void F()
    {
        O = bw.b(O, 0);
    }

    public boolean G()
    {
        return bw.a(O, 0);
    }

    public boolean H()
    {
        return k;
    }

    public void I()
    {
        O = bw.b(O, 1);
    }

    public boolean J()
    {
        return bw.a(O, 1);
    }

    public String K()
    {
        return l;
    }

    public void L()
    {
        l = null;
    }

    public boolean M()
    {
        return l != null;
    }

    public String N()
    {
        return m;
    }

    public void O()
    {
        m = null;
    }

    public boolean P()
    {
        return m != null;
    }

    public long Q()
    {
        return n;
    }

    public void R()
    {
        O = bw.b(O, 2);
    }

    public boolean S()
    {
        return bw.a(O, 2);
    }

    public String T()
    {
        return o;
    }

    public void U()
    {
        o = null;
    }

    public boolean V()
    {
        return o != null;
    }

    public String W()
    {
        return p;
    }

    public void X()
    {
        p = null;
    }

    public boolean Y()
    {
        return p != null;
    }

    public String Z()
    {
        return q;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public ak a()
    {
        return new ak(this);
    }

    public ak a(long l1)
    {
        n = l1;
        p(true);
        return this;
    }

    public ak a(String s1)
    {
        a = s1;
        return this;
    }

    public ak a(ba ba1)
    {
        i = ba1;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)K.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public void aa()
    {
        q = null;
    }

    public boolean ab()
    {
        return q != null;
    }

    public void ac()
        throws cf
    {
        if (i != null)
        {
            i.j();
        }
    }

    public ak b(String s1)
    {
        b = s1;
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        k(false);
        j = false;
        m(false);
        k = false;
        l = null;
        m = null;
        p(false);
        n = 0L;
        o = null;
        p = null;
        q = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)K.get(cy1.D())).b().b(cy1, this);
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

    public ak c(String s1)
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

    public ak d(String s1)
    {
        d = s1;
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

    public ak e(String s1)
    {
        e = s1;
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

    public ak f(String s1)
    {
        f = s1;
        return this;
    }

    public void f(boolean flag)
    {
        if (!flag)
        {
            f = null;
        }
    }

    public ak g(String s1)
    {
        g = s1;
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

    public ak h(String s1)
    {
        h = s1;
        return this;
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

    public ak i(String s1)
    {
        l = s1;
        return this;
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

    public ak j(String s1)
    {
        m = s1;
        return this;
    }

    public ak j(boolean flag)
    {
        j = flag;
        k(true);
        return this;
    }

    public ak k(String s1)
    {
        o = s1;
        return this;
    }

    public void k()
    {
        c = null;
    }

    public void k(boolean flag)
    {
        O = bw.a(O, 0, flag);
    }

    public ak l(String s1)
    {
        p = s1;
        return this;
    }

    public ak l(boolean flag)
    {
        k = flag;
        m(true);
        return this;
    }

    public boolean l()
    {
        return c != null;
    }

    public String m()
    {
        return d;
    }

    public ak m(String s1)
    {
        q = s1;
        return this;
    }

    public void m(boolean flag)
    {
        O = bw.a(O, 1, flag);
    }

    public void n()
    {
        d = null;
    }

    public void n(boolean flag)
    {
        if (!flag)
        {
            l = null;
        }
    }

    public void o(boolean flag)
    {
        if (!flag)
        {
            m = null;
        }
    }

    public boolean o()
    {
        return d != null;
    }

    public String p()
    {
        return e;
    }

    public void p(boolean flag)
    {
        O = bw.a(O, 2, flag);
    }

    public void q()
    {
        e = null;
    }

    public void q(boolean flag)
    {
        if (!flag)
        {
            o = null;
        }
    }

    public void r(boolean flag)
    {
        if (!flag)
        {
            p = null;
        }
    }

    public boolean r()
    {
        return e != null;
    }

    public String s()
    {
        return f;
    }

    public void s(boolean flag)
    {
        if (!flag)
        {
            q = null;
        }
    }

    public void t()
    {
        f = null;
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("DeviceInfo(");
        boolean flag1 = true;
        boolean flag;
        if (e())
        {
            stringbuilder.append("device_id:");
            if (a == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(a);
            }
            flag1 = false;
        }
        flag = flag1;
        if (i())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("idmd5:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
            flag = false;
        }
        flag1 = flag;
        if (l())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("mac_address:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
            flag1 = false;
        }
        flag = flag1;
        if (o())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("open_udid:");
            if (d == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(d);
            }
            flag = false;
        }
        flag1 = flag;
        if (r())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("model:");
            if (e == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(e);
            }
            flag1 = false;
        }
        flag = flag1;
        if (u())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("cpu:");
            if (f == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(f);
            }
            flag = false;
        }
        flag1 = flag;
        if (x())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("os:");
            if (g == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(g);
            }
            flag1 = false;
        }
        flag = flag1;
        if (A())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("os_version:");
            if (h == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(h);
            }
            flag = false;
        }
        flag1 = flag;
        if (D())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("resolution:");
            if (i == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(i);
            }
            flag1 = false;
        }
        flag = flag1;
        if (G())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("is_jailbroken:");
            stringbuilder.append(j);
            flag = false;
        }
        flag1 = flag;
        if (J())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("is_pirated:");
            stringbuilder.append(k);
            flag1 = false;
        }
        flag = flag1;
        if (M())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_board:");
            if (l == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(l);
            }
            flag = false;
        }
        flag1 = flag;
        if (P())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_brand:");
            if (m == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(m);
            }
            flag1 = false;
        }
        flag = flag1;
        if (S())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_manutime:");
            stringbuilder.append(n);
            flag = false;
        }
        flag1 = flag;
        if (V())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_manufacturer:");
            if (o == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(o);
            }
            flag1 = false;
        }
        if (Y())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_manuid:");
            if (p == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(p);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (ab())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_name:");
            if (q == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(q);
            }
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
        K = new HashMap();
        K.put(u/aly/di, new b(null));
        K.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ak$e);
        enummap.put(e.a, new cl("device_id", (byte)2, new cm((byte)11)));
        enummap.put(e.b, new cl("idmd5", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("mac_address", (byte)2, new cm((byte)11)));
        enummap.put(e.d, new cl("open_udid", (byte)2, new cm((byte)11)));
        enummap.put(e.e, new cl("model", (byte)2, new cm((byte)11)));
        enummap.put(e.f, new cl("cpu", (byte)2, new cm((byte)11)));
        enummap.put(e.g, new cl("os", (byte)2, new cm((byte)11)));
        enummap.put(e.h, new cl("os_version", (byte)2, new cm((byte)11)));
        enummap.put(e.i, new cl("resolution", (byte)2, new cq((byte)12, u/aly/ba)));
        enummap.put(e.j, new cl("is_jailbroken", (byte)2, new cm((byte)2)));
        enummap.put(e.k, new cl("is_pirated", (byte)2, new cm((byte)2)));
        enummap.put(e.l, new cl("device_board", (byte)2, new cm((byte)11)));
        enummap.put(e.m, new cl("device_brand", (byte)2, new cm((byte)11)));
        enummap.put(e.n, new cl("device_manutime", (byte)2, new cm((byte)10)));
        enummap.put(e.o, new cl("device_manufacturer", (byte)2, new cm((byte)11)));
        enummap.put(e.p, new cl("device_manuid", (byte)2, new cm((byte)11)));
        enummap.put(e.q, new cl("device_name", (byte)2, new cm((byte)11)));
        r = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ak, r);
    }
}
