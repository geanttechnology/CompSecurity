// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, co, cm, 
//            cq, ar, cn, aq, 
//            cf, cs, dk, cy, 
//            dh, dg, cz, cg, 
//            db, cv, cu, de

public class as
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, as as1)
            throws cf
        {
            cy1.j();
_L6:
            Object obj;
            obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                as1.p();
                return;
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 3: default 56
        //                       1 71
        //                       2 181
        //                       3 281;
               goto _L1 _L2 _L3 _L4
_L2:
            break; /* Loop/switch isn't completed */
_L4:
            break MISSING_BLOCK_LABEL_281;
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L7:
            cy1.m();
            if (true) goto _L6; else goto _L5
_L5:
            int i1;
            if (((ct) (obj)).b != 13)
            {
                break MISSING_BLOCK_LABEL_170;
            }
            obj = cy1.n();
            as1.a = new HashMap(((cv) (obj)).c * 2);
            i1 = 0;
_L8:
label0:
            {
                if (i1 < ((cv) (obj)).c)
                {
                    break label0;
                }
                cy1.o();
                as1.a(true);
            }
              goto _L7
            String s1 = cy1.z();
            ar ar1 = new ar();
            ar1.a(cy1);
            as1.a.put(s1, ar1);
            i1++;
              goto _L8
            db.a(cy1, ((ct) (obj)).b);
              goto _L7
_L3:
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_270;
            }
            obj = cy1.p();
            as1.b = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L9:
label1:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label1;
                }
                cy1.q();
                as1.b(true);
            }
              goto _L7
            aq aq1 = new aq();
            aq1.a(cy1);
            as1.b.add(aq1);
            i1++;
              goto _L9
            db.a(cy1, ((ct) (obj)).b);
              goto _L7
            if (((ct) (obj)).b == 11)
            {
                as1.c = cy1.z();
                as1.c(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L7
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (as)bz1);
        }

        public void b(cy cy1, as as1)
            throws cf
        {
            as1.p();
            cy1.a(as.q());
            if (as1.a == null) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(as.r());
            cy1.a(new cv((byte)11, (byte)12, as1.a.size()));
            iterator = as1.a.entrySet().iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.e();
            cy1.c();
_L2:
            if (as1.b != null && as1.l())
            {
                cy1.a(as.s());
                cy1.a(new cu((byte)12, as1.b.size()));
                java.util.Map.Entry entry;
                for (iterator = as1.b.iterator(); iterator.hasNext(); ((aq)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_235;
                }

                cy1.f();
                cy1.c();
            }
            if (as1.c != null && as1.o())
            {
                cy1.a(as.t());
                cy1.a(as1.c);
                cy1.c();
            }
            cy1.d();
            cy1.b();
            return;
_L4:
            entry = (java.util.Map.Entry)iterator.next();
            cy1.a((String)entry.getKey());
            ((ar)entry.getValue()).b(cy1);
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (as)bz1);
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

        public void a(cy cy1, as as1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(as1.a.size());
            Object obj = as1.a.entrySet().iterator();
            do
            {
label0:
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        obj = new BitSet();
                        if (as1.l())
                        {
                            ((BitSet) (obj)).set(0);
                        }
                        if (as1.o())
                        {
                            ((BitSet) (obj)).set(1);
                        }
                        cy1.a(((BitSet) (obj)), 2);
                        if (as1.l())
                        {
                            cy1.a(as1.b.size());
                            java.util.Map.Entry entry;
                            for (obj = as1.b.iterator(); ((Iterator) (obj)).hasNext(); ((aq)((Iterator) (obj)).next()).b(cy1))
                            {
                                break label0;
                            }

                        }
                        if (as1.o())
                        {
                            cy1.a(as1.c);
                        }
                        return;
                    }
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    cy1.a((String)entry.getKey());
                    ((ar)entry.getValue()).b(cy1);
                }
            } while (true);
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (as)bz1);
        }

        public void b(cy cy1, as as1)
            throws cf
        {
            Object obj;
            int i1;
            boolean flag;
            flag = false;
            cy1 = (de)cy1;
            obj = new cv((byte)11, (byte)12, cy1.w());
            as1.a = new HashMap(((cv) (obj)).c * 2);
            i1 = 0;
_L5:
            if (i1 < ((cv) (obj)).c) goto _L2; else goto _L1
_L1:
            as1.a(true);
            obj = cy1.b(2);
            if (!((BitSet) (obj)).get(0)) goto _L4; else goto _L3
_L3:
            cu cu1;
            cu1 = new cu((byte)12, cy1.w());
            as1.b = new ArrayList(cu1.b);
            i1 = ((flag) ? 1 : 0);
_L6:
            if (i1 < cu1.b)
            {
                break MISSING_BLOCK_LABEL_188;
            }
            as1.b(true);
_L4:
            if (((BitSet) (obj)).get(1))
            {
                as1.c = cy1.z();
                as1.c(true);
            }
            return;
_L2:
            String s1 = cy1.z();
            ar ar1 = new ar();
            ar1.a(cy1);
            as1.a.put(s1, ar1);
            i1++;
              goto _L5
            aq aq1 = new aq();
            aq1.a(cy1);
            as1.b.add(aq1);
            i1++;
              goto _L6
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (as)bz1);
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

        public static e a(String s1)
        {
            return (e)d.get(s1);
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
            return (e)Enum.valueOf(u/aly/as$e, s1);
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
            a = new e("SNAPSHOTS", 0, (short)1, "snapshots");
            b = new e("JOURNALS", 1, (short)2, "journals");
            c = new e("CHECKSUM", 2, (short)3, "checksum");
            g = (new e[] {
                a, b, c
            });
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/as$e).iterator();
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

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            e = word0;
            f = s2;
        }
    }


    public static final Map d;
    private static final dd e = new dd("IdTracking");
    private static final ct f = new ct("snapshots", (byte)13, (short)1);
    private static final ct g = new ct("journals", (byte)15, (short)2);
    private static final ct h = new ct("checksum", (byte)11, (short)3);
    private static final Map i;
    public Map a;
    public List b;
    public String c;
    private e j[];

    public as()
    {
        j = (new e[] {
            e.b, e.c
        });
    }

    public as(Map map)
    {
        this();
        a = map;
    }

    public as(as as1)
    {
        j = (new e[] {
            e.b, e.c
        });
        if (!as1.f()) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = new HashMap();
        iterator = as1.a.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        a = ((Map) (obj));
_L2:
        if (as1.l())
        {
            obj = new ArrayList();
            java.util.Map.Entry entry;
            for (iterator = as1.b.iterator(); iterator.hasNext(); ((List) (obj)).add(new aq((aq)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_171;
            }

            b = ((List) (obj));
        }
        if (as1.o())
        {
            c = as1.c;
        }
        return;
_L4:
        entry = (java.util.Map.Entry)iterator.next();
        ((Map) (obj)).put((String)entry.getKey(), new ar((ar)entry.getValue()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        try
        {
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
        return e;
    }

    static ct r()
    {
        return f;
    }

    static ct s()
    {
        return g;
    }

    static ct t()
    {
        return h;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public as a()
    {
        return new as(this);
    }

    public as a(String s1)
    {
        c = s1;
        return this;
    }

    public as a(List list)
    {
        b = list;
        return this;
    }

    public as a(Map map)
    {
        a = map;
        return this;
    }

    public void a(String s1, ar ar1)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        a.put(s1, ar1);
    }

    public void a(aq aq1)
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        b.add(aq1);
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
        return a(i1);
    }

    public void b()
    {
        a = null;
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
        if (!flag)
        {
            b = null;
        }
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
        if (b == null)
        {
            return 0;
        } else
        {
            return b.size();
        }
    }

    public Iterator i()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.iterator();
        }
    }

    public List j()
    {
        return b;
    }

    public void k()
    {
        b = null;
    }

    public boolean l()
    {
        return b != null;
    }

    public String m()
    {
        return c;
    }

    public void n()
    {
        c = null;
    }

    public boolean o()
    {
        return c != null;
    }

    public void p()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'snapshots' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("IdTracking(");
        stringbuilder.append("snapshots:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("journals:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        if (o())
        {
            stringbuilder.append(", ");
            stringbuilder.append("checksum:");
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
        EnumMap enummap = new EnumMap(u/aly/as$e);
        enummap.put(e.a, new cl("snapshots", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, u/aly/ar))));
        enummap.put(e.b, new cl("journals", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/aq))));
        enummap.put(e.c, new cl("checksum", (byte)2, new cm((byte)11)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/as, d);
    }
}
