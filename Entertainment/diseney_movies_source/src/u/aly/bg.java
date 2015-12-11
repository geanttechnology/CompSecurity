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
//            dj, cl, ck, ap, 
//            cm, cf, cs, dk, 
//            cy, dh, dg, bw, 
//            cg, db, de

public class bg
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, bg bg1)
            throws cf
        {
            cy1.j();
_L7:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                bg1.p();
                return;
            }
            ct1.c;
            JVM INSTR tableswitch 1 4: default 60
        //                       1 75
        //                       2 114
        //                       3 150
        //                       4 186;
               goto _L1 _L2 _L3 _L4 _L5
_L5:
            break MISSING_BLOCK_LABEL_186;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L8:
            cy1.m();
            if (true) goto _L7; else goto _L6
_L6:
            if (ct1.b == 8)
            {
                bg1.a = ap.a(cy1.w());
                bg1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L8
_L3:
            if (ct1.b == 8)
            {
                bg1.b = cy1.w();
                bg1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L8
_L4:
            if (ct1.b == 11)
            {
                bg1.c = cy1.z();
                bg1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L8
            if (ct1.b == 11)
            {
                bg1.d = cy1.z();
                bg1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L8
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bg)bz1);
        }

        public void b(cy cy1, bg bg1)
            throws cf
        {
            bg1.p();
            cy1.a(bg.q());
            if (bg1.a != null && bg1.e())
            {
                cy1.a(bg.r());
                cy1.a(bg1.a.a());
                cy1.c();
            }
            if (bg1.i())
            {
                cy1.a(bg.s());
                cy1.a(bg1.b);
                cy1.c();
            }
            if (bg1.c != null && bg1.l())
            {
                cy1.a(bg.t());
                cy1.a(bg1.c);
                cy1.c();
            }
            if (bg1.d != null && bg1.o())
            {
                cy1.a(bg.u());
                cy1.a(bg1.d);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bg)bz1);
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

        public void a(cy cy1, bg bg1)
            throws cf
        {
            cy1 = (de)cy1;
            BitSet bitset = new BitSet();
            if (bg1.e())
            {
                bitset.set(0);
            }
            if (bg1.i())
            {
                bitset.set(1);
            }
            if (bg1.l())
            {
                bitset.set(2);
            }
            if (bg1.o())
            {
                bitset.set(3);
            }
            cy1.a(bitset, 4);
            if (bg1.e())
            {
                cy1.a(bg1.a.a());
            }
            if (bg1.i())
            {
                cy1.a(bg1.b);
            }
            if (bg1.l())
            {
                cy1.a(bg1.c);
            }
            if (bg1.o())
            {
                cy1.a(bg1.d);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (bg)bz1);
        }

        public void b(cy cy1, bg bg1)
            throws cf
        {
            cy1 = (de)cy1;
            BitSet bitset = cy1.b(4);
            if (bitset.get(0))
            {
                bg1.a = ap.a(cy1.w());
                bg1.a(true);
            }
            if (bitset.get(1))
            {
                bg1.b = cy1.w();
                bg1.b(true);
            }
            if (bitset.get(2))
            {
                bg1.c = cy1.z();
                bg1.c(true);
            }
            if (bitset.get(3))
            {
                bg1.d = cy1.z();
                bg1.d(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (bg)bz1);
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
        private static final Map e;
        private static final e h[];
        private final short f;
        private final String g;

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
            }
        }

        public static e a(String s1)
        {
            return (e)e.get(s1);
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
            return (e)Enum.valueOf(u/aly/bg$e, s1);
        }

        public static e[] values()
        {
            e ae[] = h;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return f;
        }

        public String b()
        {
            return g;
        }

        static 
        {
            a = new e("GENDER", 0, (short)1, "gender");
            b = new e("AGE", 1, (short)2, "age");
            c = new e("ID", 2, (short)3, "id");
            d = new e("SOURCE", 3, (short)4, "source");
            h = (new e[] {
                a, b, c, d
            });
            e = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bg$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                e.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            f = word0;
            g = s2;
        }
    }


    public static final Map e;
    private static final dd f = new dd("UserInfo");
    private static final ct g = new ct("gender", (byte)8, (short)1);
    private static final ct h = new ct("age", (byte)8, (short)2);
    private static final ct i = new ct("id", (byte)11, (short)3);
    private static final ct j = new ct("source", (byte)11, (short)4);
    private static final Map k;
    private static final int l = 0;
    public ap a;
    public int b;
    public String c;
    public String d;
    private byte m;
    private e n[];

    public bg()
    {
        m = 0;
        n = (new e[] {
            e.a, e.b, e.c, e.d
        });
    }

    public bg(bg bg1)
    {
        m = 0;
        n = (new e[] {
            e.a, e.b, e.c, e.d
        });
        m = bg1.m;
        if (bg1.e())
        {
            a = bg1.a;
        }
        b = bg1.b;
        if (bg1.l())
        {
            c = bg1.c;
        }
        if (bg1.o())
        {
            d = bg1.d;
        }
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

    static dd q()
    {
        return f;
    }

    static ct r()
    {
        return g;
    }

    static ct s()
    {
        return h;
    }

    static ct t()
    {
        return i;
    }

    static ct u()
    {
        return j;
    }

    public bg a()
    {
        return new bg(this);
    }

    public bg a(int i1)
    {
        b = i1;
        b(true);
        return this;
    }

    public bg a(String s1)
    {
        c = s1;
        return this;
    }

    public bg a(ap ap1)
    {
        a = ap1;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)k.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public bg b(String s1)
    {
        d = s1;
        return this;
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0;
        c = null;
        d = null;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)k.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        m = bw.a(m, 0, flag);
    }

    public ap c()
    {
        return a;
    }

    public e c(int i1)
    {
        return e.a(i1);
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

    public void d(boolean flag)
    {
        if (!flag)
        {
            d = null;
        }
    }

    public boolean e()
    {
        return a != null;
    }

    public int f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        m = bw.b(m, 0);
    }

    public boolean i()
    {
        return bw.a(m, 0);
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

    public void p()
        throws cf
    {
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("UserInfo(");
        boolean flag = true;
        boolean flag1;
        if (e())
        {
            stringbuilder.append("gender:");
            if (a == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(a);
            }
            flag = false;
        }
        flag1 = flag;
        if (i())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("age:");
            stringbuilder.append(b);
            flag1 = false;
        }
        if (l())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("id:");
            if (c == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(c);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (o())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("source:");
            if (d == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(d);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        k = new HashMap();
        k.put(u/aly/di, new b(null));
        k.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/bg$e);
        enummap.put(e.a, new cl("gender", (byte)2, new ck((byte)16, u/aly/ap)));
        enummap.put(e.b, new cl("age", (byte)2, new cm((byte)8)));
        enummap.put(e.c, new cl("id", (byte)2, new cm((byte)11)));
        enummap.put(e.d, new cl("source", (byte)2, new cm((byte)11)));
        e = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bg, e);
    }
}
