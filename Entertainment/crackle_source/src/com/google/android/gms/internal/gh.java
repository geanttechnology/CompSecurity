// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            gi

public class gh
    implements SafeParcelable, Cloneable
{

    public static final gi CREATOR = new gi();
    private final int kg;
    private final boolean xK;
    private final boolean xL;
    private final boolean xM;
    private final boolean xN;
    private final ArrayList xO;

    public gh(int i, boolean flag, boolean flag1, boolean flag2, boolean flag3, ArrayList arraylist)
    {
        kg = i;
        xK = flag;
        xL = flag1;
        xM = flag2;
        xN = flag3;
        xO = arraylist;
    }

    public Object clone()
    {
        int i = kg;
        boolean flag = xK;
        boolean flag1 = xL;
        boolean flag2 = xM;
        boolean flag3 = xN;
        ArrayList arraylist;
        if (xO == null)
        {
            arraylist = null;
        } else
        {
            arraylist = (ArrayList)xO.clone();
        }
        return new gh(i, flag, flag1, flag2, flag3, arraylist);
    }

    public boolean dD()
    {
        return xL;
    }

    public boolean dE()
    {
        return xM;
    }

    public boolean dF()
    {
        return xN;
    }

    public List dG()
    {
        return xO;
    }

    public int describeContents()
    {
        gi gi1 = CREATOR;
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
            if (xO == null)
            {
                if (((gh) (obj)).xO != null)
                {
                    return false;
                }
            } else
            if (!xO.equals(((gh) (obj)).xO))
            {
                return false;
            }
            if (xK != ((gh) (obj)).xK)
            {
                return false;
            }
            if (xL != ((gh) (obj)).xL)
            {
                return false;
            }
            if (xN != ((gh) (obj)).xN)
            {
                return false;
            }
            if (xM != ((gh) (obj)).xM)
            {
                return false;
            }
            if (kg != ((gh) (obj)).kg)
            {
                return false;
            }
        }
        return true;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        char c3 = '\u04CF';
        int i;
        char c;
        char c1;
        char c2;
        if (xO == null)
        {
            i = 0;
        } else
        {
            i = xO.hashCode();
        }
        if (xK)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (xL)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        if (xN)
        {
            c2 = '\u04CF';
        } else
        {
            c2 = '\u04D5';
        }
        if (!xM)
        {
            c3 = '\u04D5';
        }
        return ((c2 + (c1 + (c + (i + 31) * 31) * 31) * 31) * 31 + c3) * 31 + kg;
    }

    public boolean isEnabled()
    {
        return xK;
    }

    public String toString()
    {
        return (new StringBuilder()).append("CopresenceSettings [mVersionCode=").append(kg).append(", mEnabled=").append(xK).append(",").append("mAcl={").append(((Object) (xO.toArray()))).append("},").append(", mNotifiedForNonAcl=").append(xM).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        gi gi1 = CREATOR;
        gi.a(this, parcel, i);
    }

}
