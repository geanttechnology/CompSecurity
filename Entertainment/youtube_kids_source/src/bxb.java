// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.Set;

public final class bxb
    implements Parcelable, bvz
{

    public static final android.os.Parcelable.Creator CREATOR = new bxc();
    public final duc a;
    public final long b;
    public final byte c[];
    public final bww d;
    public buz e;
    private bss f;
    private bst g;
    private bwp h;
    private bry i;
    private bxd j;
    private bsv k;
    private dck l;
    private ecf m;

    public bxb(duc duc1, long l1)
    {
        this(duc1, 0L, bqd.a, a(new bwy(new bwz[0]), duc1, 0L));
    }

    public bxb(duc duc1, long l1, byte abyte0[], bww bww)
    {
        a = (duc)b.a(duc1);
        b = l1;
        c = (byte[])b.a(abyte0);
        d = bww;
    }

    private static SparseArray a(dla adla[])
    {
        SparseArray sparsearray = new SparseArray();
        for (int i1 = adla.length - 1; i1 >= 0; i1--)
        {
            dla dla1 = adla[i1];
            sparsearray.put(dla1.b, dla1);
        }

        return sparsearray;
    }

    public static final bww a(bwy bwy1, duc duc1, long l1)
    {
        if (duc1.b == null)
        {
            return null;
        }
        long l2;
        if (duc1.g != null)
        {
            l2 = duc1.g.c;
        } else
        {
            l2 = 0L;
        }
        return bwy1.a(duc1.b, a(duc1), 1000L * l2, l1, b(duc1));
    }

    public static String a(duc duc1)
    {
        if (duc1.g != null)
        {
            return duc1.g.a;
        } else
        {
            return "";
        }
    }

    private static dla[] a(SparseArray sparsearray)
    {
        int i1 = sparsearray.size();
        dla adla[] = new dla[i1];
        for (i1--; i1 >= 0; i1--)
        {
            adla[i1] = (dla)sparsearray.valueAt(i1);
        }

        return adla;
    }

    public static boolean b(duc duc1)
    {
        if (duc1.g != null)
        {
            return duc1.g.d;
        } else
        {
            return false;
        }
    }

    public final bxb a(bwb bwb1, bwb bwb2)
    {
        Object obj = a.b;
        dyz dyz1;
        long l1;
        long l2;
        if (obj != null)
        {
            l1 = ((dyz) (obj)).a;
        } else
        {
            l1 = 0L;
        }
        l2 = b;
        obj = new duc();
        eun.a(((eun) (obj)), eun.a(a));
        dyz1 = ((duc) (obj)).b;
        if (dyz1 != null)
        {
            SparseArray sparsearray;
            if (l1 > 0L)
            {
                dyz1.a = l1;
            } else
            {
                dyz1.a = 0L;
            }
            sparsearray = a(dyz1.c);
            if (bwb1 != null)
            {
                if (bwd.h().contains(Integer.valueOf(bwb1.a.b)))
                {
                    sparsearray.put(bwb1.a.b, bwb1.a());
                } else
                {
                    SparseArray sparsearray1 = a(dyz1.b);
                    sparsearray1.put(bwb1.a.b, bwb1.a());
                    dyz1.b = a(sparsearray1);
                }
            }
            if (bwb2 != null)
            {
                sparsearray.put(bwb2.a.b, bwb2.a());
            }
            dyz1.c = a(sparsearray);
        }
        return new bxb(((duc) (obj)), l2, c, a(new bwy(new bwz[0]), ((duc) (obj)), l2));
    }

    public final byte[] a()
    {
        return a.l;
    }

    public final bvz b()
    {
        return null;
    }

    public final String c()
    {
        if (a.g != null)
        {
            return a.g.b;
        } else
        {
            return "";
        }
    }

    public final btu d()
    {
        dzp dzp;
        if (a.g != null)
        {
            dzp = a.g.e;
        } else
        {
            dzp = null;
        }
        return new btu(dzp);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int e()
    {
        if (a.g != null)
        {
            return (int)a.g.c;
        } else
        {
            return 0;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof bxb))
            {
                return false;
            }
            obj = (bxb)obj;
            if (!b.a(a(a), a(((bxb) (obj)).a)) || !b.a(f(), ((bxb) (obj)).f()))
            {
                return false;
            }
        }
        return true;
    }

    public final bss f()
    {
        if (f == null && a.a != null)
        {
            f = new bss(a.a);
        }
        return f;
    }

    public final bst g()
    {
        if (g == null)
        {
            g = new bst(a.e);
        }
        return g;
    }

    public final bwp h()
    {
        if (h == null)
        {
            bwp bwp1;
            if (a.j != null)
            {
                bwp1 = new bwp(a.j);
            } else
            {
                bwp1 = new bwp(new dts());
            }
            h = bwp1;
        }
        return h;
    }

    public final int hashCode()
    {
        int j1 = a(a).hashCode();
        int i1;
        if (f() == null)
        {
            i1 = 0;
        } else
        {
            i1 = f().hashCode();
        }
        return i1 + (j1 + 19) * 19;
    }

    public final bry i()
    {
        if (i == null && a.k != null && a.k.a != null)
        {
            i = new bry(a.k.a);
        }
        return i;
    }

    public final bxd j()
    {
        if (j == null && a.p != null && a.p.a != null)
        {
            j = new bxd(a.p.a, this);
        }
        return j;
    }

    public final String k()
    {
        if (m != null) goto _L2; else goto _L1
_L1:
        dtj adtj[];
        int i1;
        int j1;
        adtj = a.d;
        j1 = adtj.length;
        i1 = 0;
_L7:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        dtj dtj1 = adtj[i1];
        if (dtj1.b == null) goto _L5; else goto _L4
_L4:
        m = dtj1.b;
_L2:
        ecf ecf1 = m;
        if (ecf1 != null)
        {
            return ecf1.a;
        } else
        {
            return null;
        }
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final bsv l()
    {
        if (k == null && a.m != null && a.m.a != null)
        {
            k = new bsv(a.m.a);
        }
        return k;
    }

    public final dck m()
    {
        if (l == null && a.j != null)
        {
            l = a.j.d;
        }
        return l;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        a.a(parcel, a);
        parcel.writeLong(b);
        parcel.writeInt(c.length);
        parcel.writeByteArray(c);
        parcel.writeParcelable(d, 0);
    }

}
