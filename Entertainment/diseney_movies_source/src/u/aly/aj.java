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
//            dg, bw, cg, cz, 
//            db, de

public class aj
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, aj aj1)
            throws cf
        {
            cy1.j();
_L6:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!aj1.e())
                {
                    throw new cz((new StringBuilder("Required field 'successful_requests' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                }
                break MISSING_BLOCK_LABEL_207;
            }
            ct1.c;
            JVM INSTR tableswitch 1 3: default 84
        //                       1 99
        //                       2 135
        //                       3 171;
               goto _L1 _L2 _L3 _L4
_L4:
            break MISSING_BLOCK_LABEL_171;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ct1.b);
_L7:
            cy1.m();
            if (true) goto _L6; else goto _L5
_L5:
            if (ct1.b == 8)
            {
                aj1.a = cy1.w();
                aj1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
_L3:
            if (ct1.b == 8)
            {
                aj1.b = cy1.w();
                aj1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
            if (ct1.b == 8)
            {
                aj1.c = cy1.w();
                aj1.c(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L7
            if (!aj1.i())
            {
                throw new cz((new StringBuilder("Required field 'failed_requests' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            } else
            {
                aj1.m();
                return;
            }
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (aj)bz1);
        }

        public void b(cy cy1, aj aj1)
            throws cf
        {
            aj1.m();
            cy1.a(aj.n());
            cy1.a(aj.o());
            cy1.a(aj1.a);
            cy1.c();
            cy1.a(aj.p());
            cy1.a(aj1.b);
            cy1.c();
            if (aj1.l())
            {
                cy1.a(aj.q());
                cy1.a(aj1.c);
                cy1.c();
            }
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (aj)bz1);
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

        public void a(cy cy1, aj aj1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(aj1.a);
            cy1.a(aj1.b);
            BitSet bitset = new BitSet();
            if (aj1.l())
            {
                bitset.set(0);
            }
            cy1.a(bitset, 1);
            if (aj1.l())
            {
                cy1.a(aj1.c);
            }
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (aj)bz1);
        }

        public void b(cy cy1, aj aj1)
            throws cf
        {
            cy1 = (de)cy1;
            aj1.a = cy1.w();
            aj1.a(true);
            aj1.b = cy1.w();
            aj1.b(true);
            if (cy1.b(1).get(0))
            {
                aj1.c = cy1.w();
                aj1.c(true);
            }
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (aj)bz1);
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
            return (e)Enum.valueOf(u/aly/aj$e, s);
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
            a = new e("SUCCESSFUL_REQUESTS", 0, (short)1, "successful_requests");
            b = new e("FAILED_REQUESTS", 1, (short)2, "failed_requests");
            c = new e("LAST_REQUEST_SPENT_MS", 2, (short)3, "last_request_spent_ms");
            g = (new e[] {
                a, b, c
            });
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/aj$e).iterator();
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
    private static final dd e = new dd("ClientStats");
    private static final ct f = new ct("successful_requests", (byte)8, (short)1);
    private static final ct g = new ct("failed_requests", (byte)8, (short)2);
    private static final ct h = new ct("last_request_spent_ms", (byte)8, (short)3);
    private static final Map i;
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    public int a;
    public int b;
    public int c;
    private byte m;
    private e n[];

    public aj()
    {
        m = 0;
        n = (new e[] {
            e.c
        });
        a = 0;
        b = 0;
    }

    public aj(int i1, int j1)
    {
        this();
        a = i1;
        a(true);
        b = j1;
        b(true);
    }

    public aj(aj aj1)
    {
        m = 0;
        n = (new e[] {
            e.c
        });
        m = aj1.m;
        a = aj1.a;
        b = aj1.b;
        c = aj1.c;
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

    public aj a()
    {
        return new aj(this);
    }

    public aj a(int i1)
    {
        a = i1;
        a(true);
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

    public cg b(int i1)
    {
        return e(i1);
    }

    public void b()
    {
        a = 0;
        b = 0;
        c(false);
        c = 0;
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

    public int c()
    {
        return a;
    }

    public aj c(int i1)
    {
        b = i1;
        b(true);
        return this;
    }

    public void c(boolean flag)
    {
        m = bw.a(m, 2, flag);
    }

    public aj d(int i1)
    {
        c = i1;
        c(true);
        return this;
    }

    public void d()
    {
        m = bw.b(m, 0);
    }

    public e e(int i1)
    {
        return e.a(i1);
    }

    public boolean e()
    {
        return bw.a(m, 0);
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
        m = bw.b(m, 1);
    }

    public boolean i()
    {
        return bw.a(m, 1);
    }

    public int j()
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
        StringBuilder stringbuilder = new StringBuilder("ClientStats(");
        stringbuilder.append("successful_requests:");
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append("failed_requests:");
        stringbuilder.append(b);
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("last_request_spent_ms:");
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
        EnumMap enummap = new EnumMap(u/aly/aj$e);
        enummap.put(e.a, new cl("successful_requests", (byte)1, new cm((byte)8)));
        enummap.put(e.b, new cl("failed_requests", (byte)1, new cm((byte)8)));
        enummap.put(e.c, new cl("last_request_spent_ms", (byte)2, new cm((byte)8)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/aj, d);
    }
}
