// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzax, FileUploadPreferencesImpl

public class OnDeviceUsagePreferenceResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzax();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzalY;

    OnDeviceUsagePreferenceResponse(int i, FileUploadPreferencesImpl fileuploadpreferencesimpl)
    {
        mVersionCode = i;
        zzalY = fileuploadpreferencesimpl;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzax.zza(this, parcel, i);
    }

    public FileUploadPreferencesImpl zzrx()
    {
        return zzalY;
    }

}
