// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zza, zzf

public class ApplicationStatus
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private String zzYx;

    public ApplicationStatus()
    {
        this(1, null);
    }

    ApplicationStatus(int i, String s)
    {
        mVersionCode = i;
        zzYx = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ApplicationStatus))
        {
            return false;
        } else
        {
            obj = (ApplicationStatus)obj;
            return zzf.zza(zzYx, ((ApplicationStatus) (obj)).zzYx);
        }
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzYx
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public String zzmO()
    {
        return zzYx;
    }

}
