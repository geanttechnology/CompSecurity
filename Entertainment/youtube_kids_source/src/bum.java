// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;

public final class bum
    implements Parcelable, bnj, bvz
{

    public static final android.os.Parcelable.Creator CREATOR = new bun();
    public final ede a;
    public final bsz b;
    public final bso c;
    public final dre d;
    public final String e;
    private final btk f;

    bum(Parcel parcel)
    {
        this((ede)a.b(parcel, new ede()));
    }

    public bum(ede ede1)
    {
        a = (ede)b.a(ede1);
        Object obj = null;
        d = ede1.c;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        bso bso1;
        bsz bsz1;
        doo doo1;
        int i;
        int j;
        if (d != null)
        {
            byte abyte0[] = d.a;
            dwt adwt[];
            dom dom1;
            doo adoo[];
            int k;
            int l;
            if (d.e != null)
            {
                obj = d.e.a;
            } else
            if (d.i != null)
            {
                obj = d.i.a;
            }
        } else
        {
            obj1 = bqd.a;
        }
        e = ((String) (obj));
        if (ede1.a != null)
        {
            obj2 = ede1.a.a;
        } else
        {
            obj2 = null;
        }
        ede1 = null;
        obj = null;
        abyte0 = null;
        obj3 = null;
        if (obj2 != null)
        {
            ede1 = ((ede) (obj));
            if (((dyl) (obj2)).a != null)
            {
                ede1 = ((dyl) (obj2)).a.a;
            }
            obj = abyte0;
            if (((dyl) (obj2)).b != null)
            {
                obj = abyte0;
                if (((dyl) (obj2)).b.a != null)
                {
                    obj = new bsz(((dyl) (obj2)).b.a);
                }
            }
            obj1 = obj3;
            if (((dyl) (obj2)).c != null)
            {
                obj1 = obj3;
                if (((dyl) (obj2)).c.a != null)
                {
                    obj1 = new bso(((dyl) (obj2)).c.a);
                }
            }
            if (((dyl) (obj2)).d != null && ((dyl) (obj2)).d.a != null)
            {
                new brk(((dyl) (obj2)).d.a);
            }
            bsz1 = ((bsz) (obj));
            bso1 = ((bso) (obj1));
        } else
        {
            bso1 = null;
            bsz1 = null;
        }
        obj4 = null;
        obj = null;
        obj3 = null;
        obj1 = null;
        if (ede1 == null)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        f = new btk(ede1);
        adwt = ((dwq) (ede1)).a;
        k = adwt.length;
        obj2 = null;
        i = 0;
        ede1 = ((ede) (obj));
        obj = obj2;
        obj2 = obj;
        obj3 = obj1;
        obj4 = ede1;
        if (i >= k) goto _L2; else goto _L1
_L1:
        dom1 = adwt[i].b;
        obj2 = obj;
        obj3 = obj1;
        obj4 = ede1;
        if (dom1 == null) goto _L4; else goto _L3
_L3:
        adoo = dom1.a;
        l = adoo.length;
        j = 0;
_L13:
        obj2 = obj;
        obj3 = obj1;
        obj4 = ede1;
        if (j >= l) goto _L4; else goto _L5
_L5:
        doo1 = adoo[j];
        if (ede1 != null || doo1.h == null) goto _L7; else goto _L6
_L6:
        obj = doo1.h;
        ede1 = new bsd(dom1, f);
        obj3 = ede1;
        obj4 = obj1;
        obj2 = obj;
        if (obj1 == null) goto _L9; else goto _L8
_L8:
        obj4 = obj;
        obj3 = obj1;
        obj2 = ede1;
_L2:
        if (obj4 != null)
        {
            new bub(((ebn) (obj4)), ((bvz) (obj2)));
        }
        if (obj3 != null)
        {
            new bto(((dxw) (obj3)));
        }
        b = bsz1;
        c = bso1;
        return;
_L7:
        obj3 = obj;
        obj4 = obj1;
        obj2 = ede1;
        if (obj1 != null) goto _L9; else goto _L10
_L10:
        obj3 = obj;
        obj4 = obj1;
        obj2 = ede1;
        if (doo1.z == null) goto _L9; else goto _L11
_L11:
        obj1 = doo1.z;
        obj2 = obj;
        obj3 = obj1;
        obj4 = ede1;
        if (ede1 != null) goto _L2; else goto _L12
_L12:
        obj2 = ede1;
        obj4 = obj1;
        obj3 = obj;
_L9:
        j++;
        obj = obj3;
        obj1 = obj4;
        ede1 = ((ede) (obj2));
          goto _L13
_L4:
        i++;
        obj = obj2;
        obj1 = obj3;
        ede1 = ((ede) (obj4));
        break MISSING_BLOCK_LABEL_284;
        f = null;
        obj2 = null;
          goto _L2
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
        if (c != null)
        {
            bnk1.a();
        }
        Object obj = f;
        if (obj != null)
        {
            ((btk) (obj)).a(bnk1);
        }
        obj = b;
        if (obj != null)
        {
            ((bsz) (obj)).a(bnk1);
        }
    }

    public final byte[] a()
    {
        return a.d;
    }

    public final bvz b()
    {
        return null;
    }

    public final dcj c()
    {
        if (a.e != null)
        {
            return a.e.a;
        } else
        {
            return null;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(parcel, a);
    }

}
