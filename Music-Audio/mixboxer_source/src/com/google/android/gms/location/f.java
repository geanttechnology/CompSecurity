// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location:
//            g

public class f
    implements SafeParcelable
{

    public static final g CREATOR = new g();
    private final int kg;
    private final String xJ;
    private final PendingIntent xr;

    public f(int i, PendingIntent pendingintent, String s)
    {
        kg = i;
        xr = pendingintent;
        xJ = s;
    }

    public PendingIntent dB()
    {
        return xr;
    }

    public String dC()
    {
        return xJ;
    }

    public int describeContents()
    {
        g g1 = CREATOR;
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
        obj = (f)obj;
        if (xr == null)
        {
            if (((f) (obj)).xr != null)
            {
                return false;
            }
        } else
        if (!xr.equals(((f) (obj)).xr))
        {
            return false;
        }
        if (xJ != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((f) (obj)).xJ == null) goto _L1; else goto _L3
_L3:
        return false;
        if (xJ.equals(((f) (obj)).xJ)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (xr == null)
        {
            i = 0;
        } else
        {
            i = xr.hashCode();
        }
        if (xJ != null)
        {
            j = xJ.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        g g1 = CREATOR;
        g.a(this, parcel, i);
    }

}
