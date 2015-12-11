// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.drive:
//            zzi

public class Permission
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    final int mVersionCode;
    private String zzajj;
    private int zzajk;
    private String zzajl;
    private String zzajm;
    private int zzajn;
    private boolean zzajo;

    Permission(int i, String s, int j, String s1, String s2, int k, boolean flag)
    {
        mVersionCode = i;
        zzajj = s;
        zzajk = j;
        zzajl = s1;
        zzajm = s2;
        zzajn = k;
        zzajo = flag;
    }

    public static boolean zzcm(int i)
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

    public static boolean zzcn(int i)
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
        if (!zzw.equal(zzajj, ((Permission) (obj)).zzajj) || zzajk != ((Permission) (obj)).zzajk || zzajn != ((Permission) (obj)).zzajn)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzajo == ((Permission) (obj)).zzajo) goto _L4; else goto _L5
_L5:
        return false;
    }

    public int getRole()
    {
        if (!zzcn(zzajn))
        {
            return -1;
        } else
        {
            return zzajn;
        }
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzajj, Integer.valueOf(zzajk), Integer.valueOf(zzajn), Boolean.valueOf(zzajo)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

    public String zzqY()
    {
        if (!zzcm(zzajk))
        {
            return null;
        } else
        {
            return zzajj;
        }
    }

    public int zzqZ()
    {
        if (!zzcm(zzajk))
        {
            return -1;
        } else
        {
            return zzajk;
        }
    }

    public String zzra()
    {
        return zzajl;
    }

    public String zzrb()
    {
        return zzajm;
    }

    public boolean zzrc()
    {
        return zzajo;
    }

}
