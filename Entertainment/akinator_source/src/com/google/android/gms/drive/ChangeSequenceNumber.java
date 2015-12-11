// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzse;

// Referenced classes of package com.google.android.gms.drive:
//            zza

public class ChangeSequenceNumber
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final long zzaiu;
    final long zzaiv;
    final long zzaiw;
    private volatile String zzaix;

    ChangeSequenceNumber(int i, long l, long l1, long l2)
    {
        boolean flag1 = true;
        super();
        zzaix = null;
        boolean flag;
        if (l != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        if (l1 != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        if (l2 != -1L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        mVersionCode = i;
        zzaiu = l;
        zzaiv = l1;
        zzaiw = l2;
    }

    public int describeContents()
    {
        return 0;
    }

    public final String encodeToString()
    {
        if (zzaix == null)
        {
            String s = Base64.encodeToString(zzqL(), 10);
            zzaix = (new StringBuilder()).append("ChangeSequenceNumber:").append(s).toString();
        }
        return zzaix;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ChangeSequenceNumber)
        {
            if (((ChangeSequenceNumber) (obj = (ChangeSequenceNumber)obj)).zzaiv == zzaiv && ((ChangeSequenceNumber) (obj)).zzaiw == zzaiw && ((ChangeSequenceNumber) (obj)).zzaiu == zzaiu)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (new StringBuilder()).append(String.valueOf(zzaiu)).append(String.valueOf(zzaiv)).append(String.valueOf(zzaiw)).toString().hashCode();
    }

    public String toString()
    {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    final byte[] zzqL()
    {
        zzas zzas1 = new zzas();
        zzas1.versionCode = mVersionCode;
        zzas1.zzalN = zzaiu;
        zzas1.zzalO = zzaiv;
        zzas1.zzalP = zzaiw;
        return zzse.zzf(zzas1);
    }

}
