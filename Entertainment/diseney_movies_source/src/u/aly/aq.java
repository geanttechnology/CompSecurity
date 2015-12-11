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

public class aq
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, aq aq1)
            throws cf
        {
            cy1.j();
_L6:
            ct ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!aq1.o())
                {
                    throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    aq1.p();
                    return;
                }
            }
            ct1.c;
            JVM INSTR tableswitch 1 4: default 88
        //                       1 103
        //                       2 139
        //                       3 175
        //                       4 211;
               goto _L1 _L2 _L3 _L4 _L5
_L5:
            break MISSING_BLOCK_LABEL_211;
_L1:
            db.a(cy1, ct1.b);
_L7:
            cy1.m();
              goto _L6
_L2:
            if (ct1.b == 11)
            {
                aq1.a = cy1.z();
                aq1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
_L3:
            if (ct1.b == 11)
            {
                aq1.b = cy1.z();
                aq1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
_L4:
            if (ct1.b == 11)
            {
                aq1.c = cy1.z();
                aq1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
            if (ct1.b == 10)
            {
                aq1.d = cy1.x();
                aq1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (aq)bz1);
        }

        public void b(cy cy1, aq aq1)
            throws cf
        {
            aq1.p();
            cy1.a(aq.q());
            if (aq1.a != null)
            {
                cy1.a(aq.r());
                cy1.a(aq1.a);
                cy1.c();
            }
            if (aq1.b != null && aq1.i())
            {
                cy1.a(aq.s());
                cy1.a(aq1.b);
                cy1.c();
            }
            if (aq1.c != null)
            {
                cy1.a(aq.t());
                cy1.a(aq1.c);
                cy1.c();
            }
            cy1.a(aq.u());
            cy1.a(aq1.d);
            cy1.c();
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (aq)bz1);
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

        public void a(cy cy1, aq aq1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(aq1.a);
            cy1.a(aq1.c);
            cy1.a(aq1.d);
            BitSet bitset = new BitSet();
            if (aq1.i())
            {
                bitset.set(0);
            }
            cy1.a(bitset, 1);
            if (aq1.i())
            {
                cy1.a(aq1.b);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (aq)bz1);
        }

        public void b(cy cy1, aq aq1)
            throws cf
        {
            cy1 = (de)cy1;
            aq1.a = cy1.z();
            aq1.a(true);
            aq1.c = cy1.z();
            aq1.c(true);
            aq1.d = cy1.x();
            aq1.d(true);
            if (cy1.b(1).get(0))
            {
                aq1.b = cy1.z();
                aq1.b(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (aq)bz1);
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
            return (e)Enum.valueOf(u/aly/aq$e, s1);
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
            a = new e("DOMAIN", 0, (short)1, "domain");
            b = new e("OLD_ID", 1, (short)2, "old_id");
            c = new e("NEW_ID", 2, (short)3, "new_id");
            d = new e("TS", 3, (short)4, "ts");
            h = (new e[] {
                a, b, c, d
            });
            e = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/aq$e).iterator();
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
    private static final dd f = new dd("IdJournal");
    private static final ct g = new ct("domain", (byte)11, (short)1);
    private static final ct h = new ct("old_id", (byte)11, (short)2);
    private static final ct i = new ct("new_id", (byte)11, (short)3);
    private static final ct j = new ct("ts", (byte)10, (short)4);
    private static final Map k;
    private static final int l = 0;
    public String a;
    public String b;
    public String c;
    public long d;
    private byte m;
    private e n[];

    public aq()
    {
        m = 0;
        n = (new e[] {
            e.b
        });
    }

    public aq(String s1, String s2, long l1)
    {
        this();
        a = s1;
        c = s2;
        d = l1;
        d(true);
    }

    public aq(aq aq1)
    {
        m = 0;
        n = (new e[] {
            e.b
        });
        m = aq1.m;
        if (aq1.e())
        {
            a = aq1.a;
        }
        if (aq1.i())
        {
            b = aq1.b;
        }
        if (aq1.l())
        {
            c = aq1.c;
        }
        d = aq1.d;
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

    public e a(int i1)
    {
        return e.a(i1);
    }

    public aq a()
    {
        return new aq(this);
    }

    public aq a(long l1)
    {
        d = l1;
        d(true);
        return this;
    }

    public aq a(String s1)
    {
        a = s1;
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

    public aq b(String s1)
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
        d(false);
        d = 0L;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)k.get(cy1.D())).b().b(cy1, this);
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

    public aq c(String s1)
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

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        m = bw.a(m, 0, flag);
    }

    public boolean e()
    {
        return a != null;
    }

    public String f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        b = null;
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

    public long m()
    {
        return d;
    }

    public void n()
    {
        m = bw.b(m, 0);
    }

    public boolean o()
    {
        return bw.a(m, 0);
    }

    public void p()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'domain' was not present! Struct: ")).append(toString()).toString());
        }
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'new_id' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("IdJournal(");
        stringbuilder.append("domain:");
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
            stringbuilder.append("old_id:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        stringbuilder.append(", ");
        stringbuilder.append("new_id:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(", ");
        stringbuilder.append("ts:");
        stringbuilder.append(d);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        k = new HashMap();
        k.put(u/aly/di, new b(null));
        k.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/aq$e);
        enummap.put(e.a, new cl("domain", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("old_id", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("new_id", (byte)1, new cm((byte)11)));
        enummap.put(e.d, new cl("ts", (byte)1, new cm((byte)10)));
        e = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/aq, e);
    }
}
