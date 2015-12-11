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
//            an, cf, cs, dk, 
//            cy, dh, dg, bw, 
//            cz, cg, db, de

public class am
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, am am1)
            throws cf
        {
            cy1.j();
_L5:
            ct ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!am1.e())
                {
                    throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    am1.m();
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
            if (ct1.b == 10)
            {
                am1.a = cy1.x();
                am1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L6
_L3:
            if (ct1.b == 11)
            {
                am1.b = cy1.z();
                am1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L6
            if (ct1.b == 8)
            {
                am1.c = an.a(cy1.w());
                am1.d(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L6
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (am)bz1);
        }

        public void b(cy cy1, am am1)
            throws cf
        {
            am1.m();
            cy1.a(am.n());
            cy1.a(am.o());
            cy1.a(am1.a);
            cy1.c();
            if (am1.b != null)
            {
                cy1.a(am.p());
                cy1.a(am1.b);
                cy1.c();
            }
            if (am1.c != null && am1.l())
            {
                cy1.a(am.q());
                cy1.a(am1.c.a());
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (am)bz1);
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

        public void a(cy cy1, am am1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(am1.a);
            cy1.a(am1.b);
            BitSet bitset = new BitSet();
            if (am1.l())
            {
                bitset.set(0);
            }
            cy1.a(bitset, 1);
            if (am1.l())
            {
                cy1.a(am1.c.a());
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (am)bz1);
        }

        public void b(cy cy1, am am1)
            throws cf
        {
            cy1 = (de)cy1;
            am1.a = cy1.x();
            am1.b(true);
            am1.b = cy1.z();
            am1.c(true);
            if (cy1.b(1).get(0))
            {
                am1.c = an.a(cy1.w());
                am1.d(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (am)bz1);
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
            return (e)Enum.valueOf(u/aly/am$e, s);
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
            a = new e("TS", 0, (short)1, "ts");
            b = new e("CONTEXT", 1, (short)2, "context");
            c = new e("SOURCE", 2, (short)3, "source");
            g = (new e[] {
                a, b, c
            });
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/am$e).iterator();
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
    private static final dd e = new dd("Error");
    private static final ct f = new ct("ts", (byte)10, (short)1);
    private static final ct g = new ct("context", (byte)11, (short)2);
    private static final ct h = new ct("source", (byte)8, (short)3);
    private static final Map i;
    private static final int j = 0;
    public long a;
    public String b;
    public an c;
    private byte k;
    private e l[];

    public am()
    {
        k = 0;
        l = (new e[] {
            e.c
        });
    }

    public am(long l1, String s)
    {
        this();
        a = l1;
        b(true);
        b = s;
    }

    public am(am am1)
    {
        k = 0;
        l = (new e[] {
            e.c
        });
        k = am1.k;
        a = am1.a;
        if (am1.i())
        {
            b = am1.b;
        }
        if (am1.l())
        {
            c = am1.c;
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

    public am a()
    {
        return new am(this);
    }

    public am a(long l1)
    {
        a = l1;
        b(true);
        return this;
    }

    public am a(String s)
    {
        b = s;
        return this;
    }

    public am a(an an1)
    {
        c = an1;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        b(false);
        a = 0L;
        b = null;
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

    public long c()
    {
        return a;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public void d()
    {
        k = bw.b(k, 0);
    }

    public void d(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public boolean e()
    {
        return bw.a(k, 0);
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

    public an j()
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
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'context' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Error(");
        stringbuilder.append("ts:");
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append("context:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("source:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        i = new HashMap();
        i.put(u/aly/di, new b(null));
        i.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/am$e);
        enummap.put(e.a, new cl("ts", (byte)1, new cm((byte)10)));
        enummap.put(e.b, new cl("context", (byte)1, new cm((byte)11)));
        enummap.put(e.c, new cl("source", (byte)2, new ck((byte)16, u/aly/an)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/am, d);
    }
}
