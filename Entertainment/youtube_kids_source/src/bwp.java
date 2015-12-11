// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

public class bwp
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new bwq();
    public final dts a;

    public bwp()
    {
        this(new dts());
    }

    public bwp(dts dts1)
    {
        a = (dts)b.a(dts1);
    }

    private dts r()
    {
        dts dts1 = new dts();
        try
        {
            eun.a(dts1, eun.a(a));
        }
        catch (eum eum1)
        {
            return new dts();
        }
        return dts1;
    }

    public final int a()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.g;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 15000;
        }
    }

    public final boolean a(bws bws1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (bwr.a[bws1.ordinal()])
        {
        default:
            if (a.b != null && a.b.a)
            {
                return true;
            }
            break;

        case 2: // '\002'
        case 3: // '\003'
            return true;

        case 1: // '\001'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final int b()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.h;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 30000;
        }
    }

    public final boolean b(bws bws1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (bwr.a[bws1.ordinal()])
        {
        default:
            if (a.b != null && a.b.b)
            {
                return true;
            }
            break;

        case 3: // '\003'
            return true;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final float c()
    {
        float f1;
        if (a.b != null)
        {
            f1 = a.b.i;
        } else
        {
            f1 = 0.0F;
        }
        if (f1 != 0.0F)
        {
            return f1;
        } else
        {
            return 0.2F;
        }
    }

    public final float d()
    {
        float f1;
        if (a.b != null)
        {
            f1 = a.b.j;
        } else
        {
            f1 = 0.0F;
        }
        if (f1 != 0.0F)
        {
            return f1;
        } else
        {
            return 0.8F;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public final int e()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.l;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 50;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof bwp)
        {
            return eun.a(a, ((bwp)obj).a);
        } else
        {
            return false;
        }
    }

    public final int f()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.m;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 8000;
        }
    }

    public final int g()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.n;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 8000;
        }
    }

    public final int h()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.q;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 500;
        }
    }

    public final boolean i()
    {
        if (a.b != null)
        {
            return a.b.v;
        } else
        {
            return false;
        }
    }

    public final int j()
    {
        if (a.c != null)
        {
            return (int)a.c.a;
        } else
        {
            return 0;
        }
    }

    public final boolean k()
    {
        if (a.e != null)
        {
            return a.e.a;
        } else
        {
            return false;
        }
    }

    public final boolean l()
    {
        if (a.e != null)
        {
            return a.e.b;
        } else
        {
            return false;
        }
    }

    public final boolean m()
    {
        if (a.i != null)
        {
            return a.i.a;
        } else
        {
            return false;
        }
    }

    public final boolean n()
    {
        if (a.h != null)
        {
            return a.h.a;
        } else
        {
            return false;
        }
    }

    public final boolean o()
    {
        if (a.b != null)
        {
            return a.b.D;
        } else
        {
            return false;
        }
    }

    public final int p()
    {
        int i1;
        if (a.b != null)
        {
            i1 = a.b.E;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return i1;
        } else
        {
            return 1;
        }
    }

    public final SparseIntArray q()
    {
        SparseIntArray sparseintarray = new SparseIntArray();
        if (a.b != null)
        {
            djj adjj[] = a.b.F;
            int j1 = adjj.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                djj djj1 = adjj[i1];
                sparseintarray.put(djj1.b, djj1.c);
            }

        }
        return sparseintarray;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        a.a(parcel, r());
    }

}
