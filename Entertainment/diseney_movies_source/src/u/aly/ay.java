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
//            dg, bw, cz, cg, 
//            db, de

public class ay
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, ay ay1)
            throws cf
        {
            cy1.j();
_L4:
            ct ct1 = cy1.l();
            if (ct1.b == 0)
            {
                cy1.k();
                if (!ay1.i())
                {
                    throw new cz((new StringBuilder("Required field 'duration' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    ay1.j();
                    return;
                }
            }
            ct1.c;
            JVM INSTR tableswitch 1 2: default 80
        //                       1 95
        //                       2 131;
               goto _L1 _L2 _L3
_L3:
            break MISSING_BLOCK_LABEL_131;
_L1:
            db.a(cy1, ct1.b);
_L5:
            cy1.m();
              goto _L4
_L2:
            if (ct1.b == 11)
            {
                ay1.a = cy1.z();
                ay1.a(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L5
            if (ct1.b == 10)
            {
                ay1.b = cy1.x();
                ay1.b(true);
            } else
            {
                db.a(cy1, ct1.b);
            }
              goto _L5
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ay)bz1);
        }

        public void b(cy cy1, ay ay1)
            throws cf
        {
            ay1.j();
            cy1.a(ay.k());
            if (ay1.a != null)
            {
                cy1.a(ay.l());
                cy1.a(ay1.a);
                cy1.c();
            }
            cy1.a(ay.m());
            cy1.a(ay1.b);
            cy1.c();
            cy1.d();
            cy1.b();
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ay)bz1);
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

        public void a(cy cy1, ay ay1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(ay1.a);
            cy1.a(ay1.b);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (ay)bz1);
        }

        public void b(cy cy1, ay ay1)
            throws cf
        {
            cy1 = (de)cy1;
            ay1.a = cy1.z();
            ay1.a(true);
            ay1.b = cy1.x();
            ay1.b(true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (ay)bz1);
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
            return (e)Enum.valueOf(u/aly/ay$e, s);
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
            a = new e("PAGE_NAME", 0, (short)1, "page_name");
            b = new e("DURATION", 1, (short)2, "duration");
            f = (new e[] {
                a, b
            });
            c = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ay$e).iterator();
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
    private static final dd d = new dd("Page");
    private static final ct e = new ct("page_name", (byte)11, (short)1);
    private static final ct f = new ct("duration", (byte)10, (short)2);
    private static final Map g;
    private static final int h = 0;
    public String a;
    public long b;
    private byte i;

    public ay()
    {
        i = 0;
    }

    public ay(String s, long l1)
    {
        this();
        a = s;
        b = l1;
        b(true);
    }

    public ay(ay ay1)
    {
        i = 0;
        i = ay1.i;
        if (ay1.e())
        {
            a = ay1.a;
        }
        b = ay1.b;
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
            i = 0;
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

    public e a(int i1)
    {
        return e.a(i1);
    }

    public ay a()
    {
        return new ay(this);
    }

    public ay a(long l1)
    {
        b = l1;
        b(true);
        return this;
    }

    public ay a(String s)
    {
        a = s;
        return this;
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)g.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0L;
    }

    public void b(cy cy1)
        throws cf
    {
        ((dh)g.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        i = bw.a(i, 0, flag);
    }

    public String c()
    {
        return a;
    }

    public void d()
    {
        a = null;
    }

    public boolean e()
    {
        return a != null;
    }

    public long f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        i = bw.b(i, 0);
    }

    public boolean i()
    {
        return bw.a(i, 0);
    }

    public void j()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'page_name' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Page(");
        stringbuilder.append("page_name:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("duration:");
        stringbuilder.append(b);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        g = new HashMap();
        g.put(u/aly/di, new b(null));
        g.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/ay$e);
        enummap.put(e.a, new cl("page_name", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("duration", (byte)1, new cm((byte)10)));
        c = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ay, c);
    }
}
