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

public class ah
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ah ah1)
            throws cf
        {
            cy1.j();
_L1:
            ct ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!ah1.e())
                {
                    throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    ah1.f();
                    return;
                }
            }
            switch (ct1.c)
            {
            default:
                db.a(cy1, ct1.b);
                break;

            case 1: // '\001'
                break MISSING_BLOCK_LABEL_91;
            }
            cy1.m();
              goto _L1
            if (ct1.b == 10)
            {
                ah1.a = cy1.x();
                ah1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
            break MISSING_BLOCK_LABEL_84;
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ah)bz1);
        }

        public void b(cy cy1, ah ah1)
            throws cf
        {
            ah1.f();
            cy1.a(ah.h());
            cy1.a(ah.i());
            cy1.a(ah1.a);
            cy1.c();
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ah)bz1);
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

        public void a(cy cy1, ah ah1)
            throws cf
        {
            ((de)cy1).a(ah1.a);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ah)bz1);
        }

        public void b(cy cy1, ah ah1)
            throws cf
        {
            ah1.a = ((de)cy1).x();
            ah1.a(true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ah)bz1);
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
        private static final Map b;
        private static final e e[];
        private final short c;
        private final String d;

        public static e a(int j)
        {
            switch (j)
            {
            default:
                return null;

            case 1: // '\001'
                return a;
            }
        }

        public static e a(String s)
        {
            return (e)b.get(s);
        }

        public static e b(int j)
        {
            e e1 = a(j);
            if (e1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(j).append(" doesn't exist!").toString());
            } else
            {
                return e1;
            }
        }

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(u/aly/ah$e, s);
        }

        public static e[] values()
        {
            e ae[] = e;
            int j = ae.length;
            e ae1[] = new e[j];
            System.arraycopy(ae, 0, ae1, 0, j);
            return ae1;
        }

        public short a()
        {
            return c;
        }

        public String b()
        {
            return d;
        }

        static 
        {
            a = new e("TS", 0, (short)1, "ts");
            e = (new e[] {
                a
            });
            b = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ah$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                b.put(e1.b(), e1);
            } while (true);
        }

        private e(String s, int j, short word0, String s1)
        {
            super(s, j);
            c = word0;
            d = s1;
        }
    }


    public static final Map b;
    private static final dd c = new dd("ActivateMsg");
    private static final ct d = new ct("ts", (byte)10, (short)1);
    private static final Map e;
    private static final int f = 0;
    public long a;
    private byte g;

    public ah()
    {
        g = 0;
    }

    public ah(long l)
    {
        this();
        a = l;
        a(true);
    }

    public ah(ah ah1)
    {
        g = 0;
        g = ah1.g;
        a = ah1.a;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            g = 0;
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

    static dd h()
    {
        return c;
    }

    static ct i()
    {
        return d;
    }

    public e a(int j)
    {
        return e.a(j);
    }

    public ah a()
    {
        return new ah(this);
    }

    public ah a(long l)
    {
        a = l;
        a(true);
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)e.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        g = bw.a(g, 0, flag);
    }

    public cg b(int j)
    {
        return a(j);
    }

    public void b()
    {
        a(false);
        a = 0L;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)e.get(cy1.D())).b().b(cy1, this);
    }

    public long c()
    {
        return a;
    }

    public void d()
    {
        g = bw.b(g, 0);
    }

    public boolean e()
    {
        return bw.a(g, 0);
    }

    public void f()
        throws cf
    {
    }

    public bz g()
    {
        return a();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ActivateMsg(");
        stringbuilder.append("ts:");
        stringbuilder.append(a);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        e = new HashMap();
        e.put(u/aly/di, new b(null));
        e.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ah$e);
        enummap.put(e.a, new cl("ts", (byte)1, new cm((byte)10)));
        b = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ah, b);
    }
}
