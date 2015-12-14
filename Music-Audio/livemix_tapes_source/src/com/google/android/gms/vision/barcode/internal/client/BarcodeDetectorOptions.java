// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode.internal.client:
//            zza

public class BarcodeDetectorOptions
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    final int versionCode;
    public int zzaVt;

    public BarcodeDetectorOptions()
    {
        versionCode = 1;
    }

    public BarcodeDetectorOptions(int i, int j)
    {
        versionCode = i;
        zzaVt = j;
    }

    public int describeContents()
    {
        zza zza1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza zza1 = CREATOR;
        zza.zza(this, parcel, i);
    }

}
