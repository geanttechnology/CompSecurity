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

public class ba
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ba ba1)
            throws cf
        {
            cy1.j();
_L2:
            ct ct1;
            ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!ba1.e())
                {
                    throw new cz((new StringBuilder("Required field 'height' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                }
                break MISSING_BLOCK_LABEL_167;
            }
            switch (ct1.c)
            {
            default:
                db.a(cy1, ct1.b);
                break;

            case 1: // '\001'
                break; /* Loop/switch isn't completed */

            case 2: // '\002'
                break MISSING_BLOCK_LABEL_131;
            }
_L3:
            cy1.m();
            if (true) goto _L2; else goto _L1
_L1:
            if (ct1.b == 8)
            {
                ba1.a = cy1.w();
                ba1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L3
            if (ct1.b == 8)
            {
                ba1.b = cy1.w();
                ba1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L3
            if (!ba1.i())
            {
                throw new cz((new StringBuilder("Required field 'width' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
            } else
            {
                ba1.j();
                return;
            }
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ba)bz1);
        }

        public void b(cy cy1, ba ba1)
            throws cf
        {
            ba1.j();
            cy1.a(ba.k());
            cy1.a(ba.l());
            cy1.a(ba1.a);
            cy1.c();
            cy1.a(ba.m());
            cy1.a(ba1.b);
            cy1.c();
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ba)bz1);
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

        public void a(cy cy1, ba ba1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(ba1.a);
            cy1.a(ba1.b);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ba)bz1);
        }

        public void b(cy cy1, ba ba1)
            throws cf
        {
            cy1 = (de)cy1;
            ba1.a = cy1.w();
            ba1.a(true);
            ba1.b = cy1.w();
            ba1.b(true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ba)bz1);
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
        private static final Map c;
        private static final e f[];
        private final short d;
        private final String e;

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
            }
        }

        public static e a(String s)
        {
            return (e)c.get(s);
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
            return (e)Enum.valueOf(u/aly/ba$e, s);
        }

        public static e[] values()
        {
            e ae[] = f;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return d;
        }

        public String b()
        {
            return e;
        }

        static 
        {
            a = new e("HEIGHT", 0, (short)1, "height");
            b = new e("WIDTH", 1, (short)2, "width");
            f = (new e[] {
                a, b
            });
            c = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ba$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                c.put(e1.b(), e1);
            } while (true);
        }

        private e(String s, int i1, short word0, String s1)
        {
            super(s, i1);
            d = word0;
            e = s1;
        }
    }


    public static final Map c;
    private static final dd d = new dd("Resolution");
    private static final ct e = new ct("height", (byte)8, (short)1);
    private static final ct f = new ct("width", (byte)8, (short)2);
    private static final Map g;
    private static final int h = 0;
    private static final int i = 1;
    public int a;
    public int b;
    private byte j;

    public ba()
    {
        j = 0;
    }

    public ba(int i1, int j1)
    {
        this();
        a = i1;
        a(true);
        b = j1;
        b(true);
    }

    public ba(ba ba1)
    {
        j = 0;
        j = ba1.j;
        a = ba1.a;
        b = ba1.b;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            j = 0;
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

    static dd k()
    {
        return d;
    }

    static ct l()
    {
        return e;
    }

    static ct m()
    {
        return f;
    }

    public ba a()
    {
        return new ba(this);
    }

    public ba a(int i1)
    {
        a = i1;
        a(true);
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)g.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        j = bw.a(j, 0, flag);
    }

    public cg b(int i1)
    {
        return d(i1);
    }

    public void b()
    {
        a(false);
        a = 0;
        b(false);
        b = 0;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)g.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        j = bw.a(j, 1, flag);
    }

    public int c()
    {
        return a;
    }

    public ba c(int i1)
    {
        b = i1;
        b(true);
        return this;
    }

    public e d(int i1)
    {
        return e.a(i1);
    }

    public void d()
    {
        j = bw.b(j, 0);
    }

    public boolean e()
    {
        return bw.a(j, 0);
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
        j = bw.b(j, 1);
    }

    public boolean i()
    {
        return bw.a(j, 1);
    }

    public void j()
        throws cf
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Resolution(");
        stringbuilder.append("height:");
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append("width:");
        stringbuilder.append(b);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        g = new HashMap();
        g.put(u/aly/di, new b(null));
        g.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ba$e);
        enummap.put(e.a, new cl("height", (byte)1, new cm((byte)8)));
        enummap.put(e.b, new cl("width", (byte)1, new cm((byte)8)));
        c = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ba, c);
    }
}
