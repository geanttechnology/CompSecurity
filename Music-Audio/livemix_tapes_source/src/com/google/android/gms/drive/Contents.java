// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.google.android.gms.drive:
//            zzb, DriveId

public class Contents
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    final ParcelFileDescriptor zzabN;
    final int zzagq;
    final int zzagr;
    final DriveId zzags;
    final boolean zzagt;
    final String zzrL;

    Contents(int i, ParcelFileDescriptor parcelfiledescriptor, int j, int k, DriveId driveid, boolean flag, String s)
    {
        mVersionCode = i;
        zzabN = parcelfiledescriptor;
        zzagq = j;
        zzagr = k;
        zzags = driveid;
        zzagt = flag;
        zzrL = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public DriveId getDriveId()
    {
        return zzags;
    }

    public InputStream getInputStream()
    {
        return new FileInputStream(zzabN.getFileDescriptor());
    }

    public int getMode()
    {
        return zzagr;
    }

    public OutputStream getOutputStream()
    {
        return new FileOutputStream(zzabN.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
    {
        return zzabN;
    }

    public int getRequestId()
    {
        return zzagq;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public boolean zzqf()
    {
        return zzagt;
    }

}
