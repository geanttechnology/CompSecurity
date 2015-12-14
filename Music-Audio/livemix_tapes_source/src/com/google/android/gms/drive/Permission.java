// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.drive:
//            zzh

public class Permission
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    private String zzagY;
    private int zzagZ;
    private String zzaha;
    private String zzahb;
    private int zzahc;
    private boolean zzahd;

    Permission(int i, String s, int j, String s1, String s2, int k, boolean flag)
    {
        mVersionCode = i;
        zzagY = s;
        zzagZ = j;
        zzaha = s1;
        zzahb = s2;
        zzahc = k;
        zzahd = flag;
    }

    public static boolean zzch(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 256: 
        case 257: 
        case 258: 
            return true;
        }
    }

    public static boolean zzci(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return true;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null && obj.getClass() == getClass()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == this) goto _L4; else goto _L3
_L3:
        obj = (Permission)obj;
        if (!zzw.equal(zzagY, ((Permission) (obj)).zzagY) || zzagZ != ((Permission) (obj)).zzagZ || zzahc != ((Permission) (obj)).zzahc)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzahd == ((Permission) (obj)).zzahd) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int getRole()
    {
        if (!zzci(zzahc))
        {
            return -1;
        } else
        {
            return zzahc;
        }
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzagY, Integer.valueOf(zzagZ), Integer.valueOf(zzahc), Boolean.valueOf(zzahd)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public String zzqr()
    {
        if (!zzch(zzagZ))
        {
            return null;
        } else
        {
            return zzagY;
        }
    }

    public int zzqs()
    {
        if (!zzch(zzagZ))
        {
            return -1;
        } else
        {
            return zzagZ;
        }
    }

    public String zzqt()
    {
        return zzaha;
    }

    public String zzqu()
    {
        return zzahb;
    }

    public boolean zzqv()
    {
        return zzahd;
    }

}
