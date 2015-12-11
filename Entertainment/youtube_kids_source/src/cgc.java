// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class cgc
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new cgd();
    public final cge a;
    public final cgn b;
    public final cgr c;
    public final String d;
    public final cgb e;
    public final cgj f;
    private final cgv g;

    public cgc(cgr cgr1, String s, cgb cgb1, cgj cgj1)
    {
        this(cgr1, s, cgb1, cgj1, cgn.a);
    }

    public cgc(cgr cgr1, String s, cgb cgb1, cgj cgj1, cgn cgn1)
    {
        a = cge.a;
        g = null;
        c = cgr1;
        d = s;
        e = cgb1;
        f = cgj1;
        b = cgn1;
    }

    public cgc(cgv cgv1, String s)
    {
        a = cge.b;
        g = cgv1;
        c = null;
        d = s;
        e = null;
        f = new cgj(cgv1.toString());
        b = cgn.a;
    }

    public final cgc a(cgj cgj1)
    {
        b.a(cgj1);
        boolean flag;
        if (a == cge.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        return new cgc(c, d, e, cgj1, b);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (cgc)obj;
        if (a != ((cgc) (obj)).a)
        {
            return false;
        }
        if (b != ((cgc) (obj)).b)
        {
            return false;
        }
        if (d == null)
        {
            if (((cgc) (obj)).d != null)
            {
                return false;
            }
        } else
        if (!d.equals(((cgc) (obj)).d))
        {
            return false;
        }
        if (e == null)
        {
            if (((cgc) (obj)).e != null)
            {
                return false;
            }
        } else
        if (!e.equals(((cgc) (obj)).e))
        {
            return false;
        }
        if (c == null)
        {
            if (((cgc) (obj)).c != null)
            {
                return false;
            }
        } else
        if (!c.equals(((cgc) (obj)).c))
        {
            return false;
        }
        if (g != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((cgc) (obj)).g == null) goto _L1; else goto _L3
_L3:
        return false;
        if (g.equals(((cgc) (obj)).g)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int j1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (g != null)
        {
            j1 = g.hashCode();
        }
        return (i1 + (l + (k + (j + (i + 31) * 31) * 31) * 31) * 31) * 31 + j1;
    }

    public String toString()
    {
        return String.format("CloudScreen [accessType=%s, pairingType=%s, screenId=%s, name=%s]", new Object[] {
            a, b, c, d
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(a.ordinal());
        parcel.writeInt(b.ordinal());
        parcel.writeString(d);
        if (a == cge.a)
        {
            parcel.writeParcelable(c, i);
            parcel.writeSerializable(f);
            if (e != null)
            {
                parcel.writeSerializable(e);
            }
            return;
        } else
        {
            parcel.writeSerializable(g);
            return;
        }
    }

}
