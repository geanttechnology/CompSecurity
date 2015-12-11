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
import java.util.Set;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, co, cm, 
//            cq, au, cf, cs, 
//            dk, cy, dh, dg, 
//            bw, cz, cg, db, 
//            cv, de

public class at
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, at at1)
            throws cf
        {
            cy1.j();
_L5:
            Object obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                String s;
                au au1;
                int i1;
                if (!at1.j())
                {
                    throw new cz((new StringBuilder("Required field 'version' was not found in serialized data! Struct: ")).append(((Object)this).toString()).toString());
                } else
                {
                    at1.n();
                    return;
                }
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 3: default 84
        //                       1 99
        //                       2 209
        //                       3 245;
               goto _L1 _L2 _L3 _L4
_L4:
            break MISSING_BLOCK_LABEL_245;
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L6:
            cy1.m();
              goto _L5
_L2:
            if (((ct) (obj)).b != 13)
            {
                break MISSING_BLOCK_LABEL_198;
            }
            obj = cy1.n();
            at1.a = new HashMap(((cv) (obj)).c * 2);
            i1 = 0;
_L7:
label0:
            {
                if (i1 < ((cv) (obj)).c)
                {
                    break label0;
                }
                cy1.o();
                at1.a(true);
            }
              goto _L6
            s = cy1.z();
            au1 = new au();
            au1.a(cy1);
            at1.a.put(s, au1);
            i1++;
              goto _L7
            db.a(cy1, ((ct) (obj)).b);
              goto _L6
_L3:
            if (((ct) (obj)).b == 8)
            {
                at1.b = cy1.w();
                at1.b(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L6
            if (((ct) (obj)).b == 11)
            {
                at1.c = cy1.z();
                at1.c(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L6
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (at)bz1);
        }

        public void b(cy cy1, at at1)
            throws cf
        {
            at1.n();
            cy1.a(at.o());
            if (at1.a == null) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(at.p());
            cy1.a(new cv((byte)11, (byte)12, at1.a.size()));
            iterator = at1.a.entrySet().iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.e();
            cy1.c();
_L2:
            cy1.a(at.q());
            cy1.a(at1.b);
            cy1.c();
            if (at1.c != null)
            {
                cy1.a(at.r());
                cy1.a(at1.c);
                cy1.c();
            }
            cy1.d();
            cy1.b();
            return;
_L4:
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            cy1.a((String)entry.getKey());
            ((au)entry.getValue()).b(cy1);
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (at)bz1);
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

        public void a(cy cy1, at at1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(at1.a.size());
            Iterator iterator = at1.a.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    cy1.a(at1.b);
                    cy1.a(at1.c);
                    return;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                cy1.a((String)entry.getKey());
                ((au)entry.getValue()).b(cy1);
            } while (true);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (at)bz1);
        }

        public void b(cy cy1, at at1)
            throws cf
        {
            cy1 = (de)cy1;
            cv cv1 = new cv((byte)11, (byte)12, cy1.w());
            at1.a = new HashMap(cv1.c * 2);
            int i1 = 0;
            do
            {
                if (i1 >= cv1.c)
                {
                    at1.a(true);
                    at1.b = cy1.w();
                    at1.b(true);
                    at1.c = cy1.z();
                    at1.c(true);
                    return;
                }
                String s = cy1.z();
                au au1 = new au();
                au1.a(cy1);
                at1.a.put(s, au1);
                i1++;
            } while (true);
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (at)bz1);
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
            return (e)Enum.valueOf(u/aly/at$e, s);
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
            a = new e("PROPERTY", 0, (short)1, "property");
            b = new e("VERSION", 1, (short)2, "version");
            c = new e("CHECKSUM", 2, (short)3, "checksum");
            g = (new e[] {
                a, b, c
            });
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/at$e).iterator();
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
    private static final dd e = new dd("Imprint");
    private static final ct f = new ct("property", (byte)13, (short)1);
    private static final ct g = new ct("version", (byte)8, (short)2);
    private static final ct h = new ct("checksum", (byte)11, (short)3);
    private static final Map i;
    private static final int j = 0;
    public Map a;
    public int b;
    public String c;
    private byte k;

    public at()
    {
        k = 0;
    }

    public at(Map map, int i1, String s)
    {
        this();
        a = map;
        b = i1;
        b(true);
        c = s;
    }

    public at(at at1)
    {
        k = 0;
        k = at1.k;
        if (!at1.f()) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = at1.a.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        a = hashmap;
_L2:
        b = at1.b;
        if (at1.m())
        {
            c = at1.c;
        }
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        hashmap.put((String)entry.getKey(), new au((au)entry.getValue()));
        if (true) goto _L6; else goto _L5
_L5:
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

    static dd o()
    {
        return e;
    }

    static ct p()
    {
        return f;
    }

    static ct q()
    {
        return g;
    }

    static ct r()
    {
        return h;
    }

    public at a()
    {
        return new at(this);
    }

    public at a(int i1)
    {
        b = i1;
        b(true);
        return this;
    }

    public at a(String s)
    {
        c = s;
        return this;
    }

    public at a(Map map)
    {
        a = map;
        return this;
    }

    public void a(String s, au au1)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        a.put(s, au1);
    }

    public void a(cy cy1)
        throws cf
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
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
        return c(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0;
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

    public int c()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.size();
        }
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

    public Map d()
    {
        return a;
    }

    public void e()
    {
        a = null;
    }

    public boolean f()
    {
        return a != null;
    }

    public bz g()
    {
        return a();
    }

    public int h()
    {
        return b;
    }

    public void i()
    {
        k = bw.b(k, 0);
    }

    public boolean j()
    {
        return bw.a(k, 0);
    }

    public String k()
    {
        return c;
    }

    public void l()
    {
        c = null;
    }

    public boolean m()
    {
        return c != null;
    }

    public void n()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'property' was not present! Struct: ")).append(toString()).toString());
        }
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'checksum' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Imprint(");
        stringbuilder.append("property:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("version:");
        stringbuilder.append(b);
        stringbuilder.append(", ");
        stringbuilder.append("checksum:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
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
        EnumMap enummap = new EnumMap(u/aly/at$e);
        enummap.put(e.a, new cl("property", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, u/aly/au))));
        enummap.put(e.b, new cl("version", (byte)1, new cm((byte)8)));
        enummap.put(e.c, new cl("checksum", (byte)1, new cm((byte)11)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/at, d);
    }
}
