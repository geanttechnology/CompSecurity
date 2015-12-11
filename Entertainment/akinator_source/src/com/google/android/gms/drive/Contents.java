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
    final ParcelFileDescriptor zzadS;
    final DriveId zzaiA;
    final boolean zzaiB;
    final int zzaiy;
    final int zzaiz;
    final String zzrW;

    Contents(int i, ParcelFileDescriptor parcelfiledescriptor, int j, int k, DriveId driveid, boolean flag, String s)
    {
        mVersionCode = i;
        zzadS = parcelfiledescriptor;
        zzaiy = j;
        zzaiz = k;
        zzaiA = driveid;
        zzaiB = flag;
        zzrW = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public DriveId getDriveId()
    {
        return zzaiA;
    }

    public InputStream getInputStream()
    {
        return new FileInputStream(zzadS.getFileDescriptor());
    }

    public int getMode()
    {
        return zzaiz;
    }

    public OutputStream getOutputStream()
    {
        return new FileOutputStream(zzadS.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
    {
        return zzadS;
    }

    public int getRequestId()
    {
        return zzaiy;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public boolean zzqM()
    {
        return zzaiB;
    }

}
