// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class cgw
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cgx();
    public final cfy a;
    public final Uri b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final cgt g;
    public final String h;
    public final Integer i;

    public cgw(cgy cgy1)
    {
        boolean flag;
        flag = true;
        super();
        c = cgy1.c;
        e = cgy1.e;
        f = cgy1.f;
        g = cgy1.g;
        b = cgy1.b;
        d = cgy1.d;
        a = cgy1.a;
        h = cgy1.h;
        i = cgy1.i;
        if (!d) goto _L2; else goto _L1
_L1:
        if (b == null)
        {
            flag = false;
        }
_L4:
        b.b(flag);
        return;
_L2:
        if (b != null)
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String a(cgw cgw1)
    {
        return cgw1.c;
    }

    static String b(cgw cgw1)
    {
        return cgw1.e;
    }

    static String c(cgw cgw1)
    {
        return cgw1.f;
    }

    static cgt d(cgw cgw1)
    {
        return cgw1.g;
    }

    static Uri e(cgw cgw1)
    {
        return cgw1.b;
    }

    static boolean f(cgw cgw1)
    {
        return cgw1.d;
    }

    static cfy g(cgw cgw1)
    {
        return cgw1.a;
    }

    static String h(cgw cgw1)
    {
        return cgw1.h;
    }

    static Integer i(cgw cgw1)
    {
        return cgw1.i;
    }

    public final boolean a()
    {
        return a != null;
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
        obj = (cgw)obj;
        if (b == null)
        {
            if (((cgw) (obj)).b != null)
            {
                return false;
            }
        } else
        if (!b.equals(((cgw) (obj)).b))
        {
            return false;
        }
        if (c == null)
        {
            if (((cgw) (obj)).c != null)
            {
                return false;
            }
        } else
        if (!c.equals(((cgw) (obj)).c))
        {
            return false;
        }
        if (d != ((cgw) (obj)).d)
        {
            return false;
        }
        if (e == null)
        {
            if (((cgw) (obj)).e != null)
            {
                return false;
            }
        } else
        if (!e.equals(((cgw) (obj)).e))
        {
            return false;
        }
        if (f == null)
        {
            if (((cgw) (obj)).f != null)
            {
                return false;
            }
        } else
        if (!f.equals(((cgw) (obj)).f))
        {
            return false;
        }
        if (g == null)
        {
            if (((cgw) (obj)).g != null)
            {
                return false;
            }
        } else
        if (!g.equals(((cgw) (obj)).g))
        {
            return false;
        }
        if (h == null)
        {
            if (((cgw) (obj)).h != null)
            {
                return false;
            }
        } else
        if (!h.equals(((cgw) (obj)).h))
        {
            return false;
        }
        if (i != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((cgw) (obj)).i == null) goto _L1; else goto _L3
_L3:
        return false;
        if (i.equals(((cgw) (obj)).i)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int l1 = 0;
        int j;
        int k;
        char c1;
        int l;
        int i1;
        int j1;
        int k1;
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (d)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
        }
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (i != null)
        {
            l1 = i.hashCode();
        }
        return (k1 + (j1 + (i1 + (l + (c1 + (k + (j + 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l1;
    }

    public String toString()
    {
        String s = c;
        String s1 = String.valueOf(g);
        return (new StringBuilder(String.valueOf(s).length() + 36 + String.valueOf(s1).length())).append("YouTubeDevice [deviceName=").append(s).append(", ssdpId=").append(s1).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeString(c);
        parcel.writeString(e);
        parcel.writeString(f);
        parcel.writeSerializable(g);
        parcel.writeParcelable(b, j);
        int k;
        if (d)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        parcel.writeByte((byte)k);
        parcel.writeParcelable(a, j);
        parcel.writeString(h);
        parcel.writeInt(i.intValue());
    }

}
