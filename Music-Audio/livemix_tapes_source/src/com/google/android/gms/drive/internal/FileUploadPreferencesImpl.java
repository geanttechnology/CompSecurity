// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaf

public final class FileUploadPreferencesImpl
    implements SafeParcelable, FileUploadPreferences
{

    public static final android.os.Parcelable.Creator CREATOR = new zzaf();
    final int mVersionCode;
    int zzajj;
    int zzajk;
    boolean zzajl;

    FileUploadPreferencesImpl(int i, int j, int k, boolean flag)
    {
        mVersionCode = i;
        zzajj = j;
        zzajk = k;
        zzajl = flag;
    }

    public static boolean zzcM(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    public static boolean zzcN(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 256: 
        case 257: 
            return true;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public int getBatteryUsagePreference()
    {
        if (!zzcN(zzajk))
        {
            return 0;
        } else
        {
            return zzajk;
        }
    }

    public int getNetworkTypePreference()
    {
        if (!zzcM(zzajj))
        {
            return 0;
        } else
        {
            return zzajj;
        }
    }

    public boolean isRoamingAllowed()
    {
        return zzajl;
    }

    public void setBatteryUsagePreference(int i)
    {
        if (!zzcN(i))
        {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        } else
        {
            zzajk = i;
            return;
        }
    }

    public void setNetworkTypePreference(int i)
    {
        if (!zzcM(i))
        {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        } else
        {
            zzajj = i;
            return;
        }
    }

    public void setRoamingAllowed(boolean flag)
    {
        zzajl = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzaf.zza(this, parcel, i);
    }

}
