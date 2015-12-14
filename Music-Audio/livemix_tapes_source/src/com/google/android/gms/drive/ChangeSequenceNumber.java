// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzar;
import com.google.android.gms.internal.zzrx;

// Referenced classes of package com.google.android.gms.drive:
//            zza

public class ChangeSequenceNumber
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final long zzagm;
    final long zzagn;
    final long zzago;
    private volatile String zzagp;

    ChangeSequenceNumber(int i, long l, long l1, long l2)
    {
        boolean flag1 = true;
        super();
        zzagp = null;
        boolean flag;
        if (l != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        if (l1 != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        if (l2 != -1L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        mVersionCode = i;
        zzagm = l;
        zzagn = l1;
        zzago = l2;
    }

    public int describeContents()
    {
        return 0;
    }

    public final String encodeToString()
    {
        if (zzagp == null)
        {
            String s = Base64.encodeToString(zzqe(), 10);
            zzagp = (new StringBuilder()).append("ChangeSequenceNumber:").append(s).toString();
        }
        return zzagp;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ChangeSequenceNumber)
        {
            if (((ChangeSequenceNumber) (obj = (ChangeSequenceNumber)obj)).zzagn == zzagn && ((ChangeSequenceNumber) (obj)).zzago == zzago && ((ChangeSequenceNumber) (obj)).zzagm == zzagm)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (new StringBuilder()).append(String.valueOf(zzagm)).append(String.valueOf(zzagn)).append(String.valueOf(zzago)).toString().hashCode();
    }

    public String toString()
    {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    final byte[] zzqe()
    {
        zzar zzar1 = new zzar();
        zzar1.versionCode = mVersionCode;
        zzar1.zzajy = zzagm;
        zzar1.zzajz = zzagn;
        zzar1.zzajA = zzago;
        return zzrx.zzf(zzar1);
    }

}
