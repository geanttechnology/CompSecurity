// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            ih

public class gh
    implements SafeParcelable, Cloneable
{

    public static final ih CREATOR = new ih();
    final int a;
    final boolean b;
    final boolean c;
    final boolean d;
    final boolean e;
    final ArrayList f;

    public gh(int i, boolean flag, boolean flag1, boolean flag2, boolean flag3, ArrayList arraylist)
    {
        a = i;
        b = flag;
        c = flag1;
        d = flag2;
        e = flag3;
        f = arraylist;
    }

    public Object clone()
    {
        int i = a;
        boolean flag = b;
        boolean flag1 = c;
        boolean flag2 = d;
        boolean flag3 = e;
        ArrayList arraylist;
        if (f == null)
        {
            arraylist = null;
        } else
        {
            arraylist = (ArrayList)f.clone();
        }
        return new gh(i, flag, flag1, flag2, flag3, arraylist);
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
            obj = (gh)obj;
            if (f == null)
            {
                if (((gh) (obj)).f != null)
                {
                    return false;
                }
            } else
            if (!f.equals(((gh) (obj)).f))
            {
                return false;
            }
            if (b != ((gh) (obj)).b)
            {
                return false;
            }
            if (c != ((gh) (obj)).c)
            {
                return false;
            }
            if (e != ((gh) (obj)).e)
            {
                return false;
            }
            if (d != ((gh) (obj)).d)
            {
                return false;
            }
            if (a != ((gh) (obj)).a)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        char c4 = '\u04CF';
        int i;
        char c1;
        char c2;
        char c3;
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
        }
        if (b)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        if (c)
        {
            c2 = '\u04CF';
        } else
        {
            c2 = '\u04D5';
        }
        if (e)
        {
            c3 = '\u04CF';
        } else
        {
            c3 = '\u04D5';
        }
        if (!d)
        {
            c4 = '\u04D5';
        }
        return ((c3 + (c2 + (c1 + (i + 31) * 31) * 31) * 31) * 31 + c4) * 31 + a;
    }

    public String toString()
    {
        return (new StringBuilder("CopresenceSettings [mVersionCode=")).append(a).append(", mEnabled=").append(b).append(",mAcl={").append(((Object) (f.toArray()))).append("},, mNotifiedForNonAcl=").append(d).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ih.a(this, parcel);
    }

}
