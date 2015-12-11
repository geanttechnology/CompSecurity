// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzag

public final class FileUploadPreferencesImpl
    implements SafeParcelable, FileUploadPreferences
{

    public static final android.os.Parcelable.Creator CREATOR = new zzag();
    final int mVersionCode;
    int zzalx;
    int zzaly;
    boolean zzalz;

    FileUploadPreferencesImpl(int i, int j, int k, boolean flag)
    {
        mVersionCode = i;
        zzalx = j;
        zzaly = k;
        zzalz = flag;
    }

    public static boolean zzcS(int i)
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

    public static boolean zzcT(int i)
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
        if (!zzcT(zzaly))
        {
            return 0;
        } else
        {
            return zzaly;
        }
    }

    public int getNetworkTypePreference()
    {
        if (!zzcS(zzalx))
        {
            return 0;
        } else
        {
            return zzalx;
        }
    }

    public boolean isRoamingAllowed()
    {
        return zzalz;
    }

    public void setBatteryUsagePreference(int i)
    {
        if (!zzcT(i))
        {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        } else
        {
            zzaly = i;
            return;
        }
    }

    public void setNetworkTypePreference(int i)
    {
        if (!zzcS(i))
        {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        } else
        {
            zzalx = i;
            return;
        }
    }

    public void setRoamingAllowed(boolean flag)
    {
        zzalz = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzag.zza(this, parcel, i);
    }

}
