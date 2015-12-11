// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class cfy
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new cfz();
    public final String a;
    public final cgr b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final Uri g;

    public cfy(int i)
    {
        this(i, null, null, null, true, false, false);
    }

    private cfy(int i, Uri uri, String s, cgr cgr1, boolean flag, boolean flag1, boolean flag2)
    {
        c = i;
        g = null;
        a = null;
        b = null;
        d = true;
        e = false;
        f = false;
    }

    public cfy(cga cga1)
    {
        c = cga1.d;
        g = cga1.a;
        a = cga1.b;
        b = cga1.c;
        d = cga1.e;
        e = cga1.f;
        f = cga1.g;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (cfy)obj;
            if (g == null)
            {
                if (((cfy) (obj)).g != null)
                {
                    return false;
                }
            } else
            if (!g.equals(((cfy) (obj)).g))
            {
                return false;
            }
            if (a == null)
            {
                if (((cfy) (obj)).a != null)
                {
                    return false;
                }
            } else
            if (!a.equals(((cfy) (obj)).a))
            {
                return false;
            }
            if (b == null)
            {
                if (((cfy) (obj)).b != null)
                {
                    return false;
                }
            } else
            if (!b.equals(((cfy) (obj)).b))
            {
                return false;
            }
            if (c != ((cfy) (obj)).c)
            {
                return false;
            }
            if (d != ((cfy) (obj)).d)
            {
                return false;
            }
            if (e != ((cfy) (obj)).e)
            {
                return false;
            }
            if (f != ((cfy) (obj)).f)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j1 = 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int k1;
        if (g == null)
        {
            i = 0;
        } else
        {
            i = g.hashCode();
        }
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        k1 = c;
        if (d)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (e)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (!f)
        {
            j1 = 0;
        }
        return (i1 + (l + ((k + (j + (i + 31) * 31) * 31) * 31 + k1) * 31) * 31) * 31 + j1;
    }

    public String toString()
    {
        String s = a;
        String s1 = String.valueOf(b);
        int i = c;
        boolean flag = f;
        return (new StringBuilder(String.valueOf(s).length() + 76 + String.valueOf(s1).length())).append("AppStatus [runningPathSegment=").append(s).append(", screenId=").append(s1).append(", status=").append(i).append(", CastV2=").append(flag).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(c);
        parcel.writeParcelable(g, i);
        parcel.writeString(a);
        parcel.writeSerializable(b);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (e)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (f)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
