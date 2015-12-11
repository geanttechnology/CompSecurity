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

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            dj, cl, cm, cn, 
//            cq, am, ao, cf, 
//            cs, dk, cy, dh, 
//            dg, cz, cg, db, 
//            cu, de

public class av
    implements Serializable, Cloneable, bz
{
    private static class a extends di
    {

        public void a(cy cy1, av av1)
            throws cf
        {
            cy1.j();
_L7:
            Object obj;
            obj = cy1.l();
            if (((ct) (obj)).b == 0)
            {
                cy1.k();
                av1.v();
                return;
            }
            ((ct) (obj)).c;
            JVM INSTR tableswitch 1 4: default 60
        //                       1 75
        //                       2 111
        //                       3 211
        //                       4 311;
               goto _L1 _L2 _L3 _L4 _L5
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            db.a(cy1, ((ct) (obj)).b);
_L8:
            cy1.m();
            if (true) goto _L7; else goto _L6
_L6:
            if (((ct) (obj)).b == 11)
            {
                av1.a = cy1.z();
                av1.a(true);
            } else
            {
                db.a(cy1, ((ct) (obj)).b);
            }
              goto _L8
_L3:
            int i1;
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_200;
            }
            obj = cy1.p();
            av1.b = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L9:
label0:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label0;
                }
                cy1.q();
                av1.b(true);
            }
              goto _L8
            am am1 = new am();
            am1.a(cy1);
            av1.b.add(am1);
            i1++;
              goto _L9
            db.a(cy1, ((ct) (obj)).b);
              goto _L8
_L4:
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_300;
            }
            obj = cy1.p();
            av1.c = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L10:
label1:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label1;
                }
                cy1.q();
                av1.c(true);
            }
              goto _L8
            ao ao1 = new ao();
            ao1.a(cy1);
            av1.c.add(ao1);
            i1++;
              goto _L10
            db.a(cy1, ((ct) (obj)).b);
              goto _L8
_L5:
            if (((ct) (obj)).b != 15)
            {
                break MISSING_BLOCK_LABEL_400;
            }
            obj = cy1.p();
            av1.d = new ArrayList(((cu) (obj)).b);
            i1 = 0;
_L11:
label2:
            {
                if (i1 < ((cu) (obj)).b)
                {
                    break label2;
                }
                cy1.q();
                av1.d(true);
            }
              goto _L8
            ao ao2 = new ao();
            ao2.a(cy1);
            av1.d.add(ao2);
            i1++;
              goto _L11
            db.a(cy1, ((ct) (obj)).b);
              goto _L8
        }

        public volatile void a(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (av)bz1);
        }

        public void b(cy cy1, av av1)
            throws cf
        {
            av1.v();
            cy1.a(av.w());
            if (av1.a != null)
            {
                cy1.a(av.x());
                cy1.a(av1.a);
                cy1.c();
            }
            if (av1.b == null || !av1.k()) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(av.y());
            cy1.a(new cu((byte)12, av1.b.size()));
            iterator = av1.b.iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            cy1.f();
            cy1.c();
_L2:
            if (av1.c != null && av1.p())
            {
                cy1.a(av.z());
                cy1.a(new cu((byte)12, av1.c.size()));
                for (iterator = av1.c.iterator(); iterator.hasNext(); ((ao)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_272;
                }

                cy1.f();
                cy1.c();
            }
            if (av1.d != null && av1.u())
            {
                cy1.a(av.A());
                cy1.a(new cu((byte)12, av1.d.size()));
                for (av1 = av1.d.iterator(); av1.hasNext(); ((ao)av1.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_288;
                }

                cy1.f();
                cy1.c();
            }
            cy1.d();
            cy1.b();
            return;
_L4:
            ((am)iterator.next()).b(cy1);
            if (true) goto _L6; else goto _L5
_L5:
        }

        public volatile void b(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (av)bz1);
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

        public void a(cy cy1, av av1)
            throws cf
        {
            cy1 = (de)cy1;
            cy1.a(av1.a);
            BitSet bitset = new BitSet();
            if (av1.k())
            {
                bitset.set(0);
            }
            if (av1.p())
            {
                bitset.set(1);
            }
            if (av1.u())
            {
                bitset.set(2);
            }
            cy1.a(bitset, 3);
            if (!av1.k()) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            cy1.a(av1.b.size());
            iterator = av1.b.iterator();
_L5:
            if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
            if (av1.p())
            {
                cy1.a(av1.c.size());
                for (iterator = av1.c.iterator(); iterator.hasNext(); ((ao)iterator.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_197;
                }

            }
            if (av1.u())
            {
                cy1.a(av1.d.size());
                for (av1 = av1.d.iterator(); av1.hasNext(); ((ao)av1.next()).b(cy1))
                {
                    break MISSING_BLOCK_LABEL_213;
                }

            }
            return;
_L3:
            ((am)iterator.next()).b(cy1);
            if (true) goto _L5; else goto _L4
_L4:
        }

        public void a(cy cy1, bz bz1)
            throws cf
        {
            b(cy1, (av)bz1);
        }

        public void b(cy cy1, av av1)
            throws cf
        {
            Object obj;
            boolean flag;
            flag = false;
            cy1 = (de)cy1;
            av1.a = cy1.z();
            av1.a(true);
            obj = cy1.b(3);
            if (!((BitSet) (obj)).get(0)) goto _L2; else goto _L1
_L1:
            cu cu1;
            int i1;
            cu1 = new cu((byte)12, cy1.w());
            av1.b = new ArrayList(cu1.b);
            i1 = 0;
_L11:
            if (i1 < cu1.b) goto _L4; else goto _L3
_L3:
            av1.b(true);
_L2:
            if (!((BitSet) (obj)).get(1)) goto _L6; else goto _L5
_L5:
            cu1 = new cu((byte)12, cy1.w());
            av1.c = new ArrayList(cu1.b);
            i1 = 0;
_L12:
            if (i1 < cu1.b) goto _L8; else goto _L7
_L7:
            av1.c(true);
_L6:
            if (!((BitSet) (obj)).get(2)) goto _L10; else goto _L9
_L9:
            obj = new cu((byte)12, cy1.w());
            av1.d = new ArrayList(((cu) (obj)).b);
            i1 = ((flag) ? 1 : 0);
_L13:
            if (i1 < ((cu) (obj)).b)
            {
                break MISSING_BLOCK_LABEL_269;
            }
            av1.d(true);
_L10:
            return;
_L4:
            am am1 = new am();
            am1.a(cy1);
            av1.b.add(am1);
            i1++;
              goto _L11
_L8:
            ao ao2 = new ao();
            ao2.a(cy1);
            av1.c.add(ao2);
            i1++;
              goto _L12
            ao ao1 = new ao();
            ao1.a(cy1);
            av1.d.add(ao1);
            i1++;
              goto _L13
        }

        public void b(cy cy1, bz bz1)
            throws cf
        {
            a(cy1, (av)bz1);
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
            return (e)Enum.valueOf(u/aly/av$e, s1);
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
            a = new e("ID", 0, (short)1, "id");
            b = new e("ERRORS", 1, (short)2, "errors");
            c = new e("EVENTS", 2, (short)3, "events");
            d = new e("GAME_EVENTS", 3, (short)4, "game_events");
            h = (new e[] {
                a, b, c, d
            });
            e = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/av$e).iterator();
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
    private static final dd f = new dd("InstantMsg");
    private static final ct g = new ct("id", (byte)11, (short)1);
    private static final ct h = new ct("errors", (byte)15, (short)2);
    private static final ct i = new ct("events", (byte)15, (short)3);
    private static final ct j = new ct("game_events", (byte)15, (short)4);
    private static final Map k;
    public String a;
    public List b;
    public List c;
    public List d;
    private e l[];

    public av()
    {
        l = (new e[] {
            e.b, e.c, e.d
        });
    }

    public av(String s1)
    {
        this();
        a = s1;
    }

    public av(av av1)
    {
        l = (new e[] {
            e.b, e.c, e.d
        });
        if (av1.e())
        {
            a = av1.a;
        }
        if (!av1.k()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = av1.b.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        b = arraylist;
_L2:
        if (av1.p())
        {
            arraylist = new ArrayList();
            for (iterator = av1.c.iterator(); iterator.hasNext(); arraylist.add(new ao((ao)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_189;
            }

            c = arraylist;
        }
        if (av1.u())
        {
            arraylist = new ArrayList();
            for (av1 = av1.d.iterator(); av1.hasNext(); arraylist.add(new ao((ao)av1.next())))
            {
                break MISSING_BLOCK_LABEL_215;
            }

            d = arraylist;
        }
        return;
_L4:
        arraylist.add(new am((am)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static ct A()
    {
        return j;
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

    static dd w()
    {
        return f;
    }

    static ct x()
    {
        return g;
    }

    static ct y()
    {
        return h;
    }

    static ct z()
    {
        return i;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public av a()
    {
        return new av(this);
    }

    public av a(String s1)
    {
        a = s1;
        return this;
    }

    public av a(List list)
    {
        b = list;
        return this;
    }

    public void a(am am1)
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        b.add(am1);
    }

    public void a(ao ao1)
    {
        if (c == null)
        {
            c = new ArrayList();
        }
        c.add(ao1);
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

    public av b(List list)
    {
        c = list;
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
    }

    public void b(ao ao1)
    {
        if (d == null)
        {
            d = new ArrayList();
        }
        d.add(ao1);
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

    public av c(List list)
    {
        d = list;
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
        if (b == null)
        {
            return 0;
        } else
        {
            return b.size();
        }
    }

    public bz g()
    {
        return a();
    }

    public Iterator h()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.iterator();
        }
    }

    public List i()
    {
        return b;
    }

    public void j()
    {
        b = null;
    }

    public boolean k()
    {
        return b != null;
    }

    public int l()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.size();
        }
    }

    public Iterator m()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.iterator();
        }
    }

    public List n()
    {
        return c;
    }

    public void o()
    {
        c = null;
    }

    public boolean p()
    {
        return c != null;
    }

    public int q()
    {
        if (d == null)
        {
            return 0;
        } else
        {
            return d.size();
        }
    }

    public Iterator r()
    {
        if (d == null)
        {
            return null;
        } else
        {
            return d.iterator();
        }
    }

    public List s()
    {
        return d;
    }

    public void t()
    {
        d = null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("InstantMsg(");
        stringbuilder.append("id:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        if (k())
        {
            stringbuilder.append(", ");
            stringbuilder.append("errors:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        if (p())
        {
            stringbuilder.append(", ");
            stringbuilder.append("events:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
        }
        if (u())
        {
            stringbuilder.append(", ");
            stringbuilder.append("game_events:");
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

    public boolean u()
    {
        return d != null;
    }

    public void v()
        throws cf
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'id' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    static 
    {
        k = new HashMap();
        k.put(u/aly/di, new b(null));
        k.put(u/aly/dj, new d(null));
        EnumMap enummap = new EnumMap(u/aly/av$e);
        enummap.put(e.a, new cl("id", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("errors", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/am))));
        enummap.put(e.c, new cl("events", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/ao))));
        enummap.put(e.d, new cl("game_events", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/ao))));
        e = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/av, e);
    }
}
