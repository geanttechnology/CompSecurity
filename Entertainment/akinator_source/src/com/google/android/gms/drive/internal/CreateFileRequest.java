// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzn

public class CreateFileRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    final String zzaiX;
    final boolean zzajW;
    final Contents zzake;
    final MetadataBundle zzako;
    final Integer zzakp;
    final DriveId zzakq;
    final int zzakr;
    final int zzaks;

    CreateFileRequest(int i, DriveId driveid, MetadataBundle metadatabundle, Contents contents, Integer integer, boolean flag, String s, 
            int j, int k)
    {
        if (contents != null && k != 0)
        {
            boolean flag1;
            if (contents.getRequestId() == k)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            zzx.zzb(flag1, "inconsistent contents reference");
        }
        if ((integer == null || integer.intValue() == 0) && contents == null && k == 0)
        {
            throw new IllegalArgumentException("Need a valid contents");
        } else
        {
            mVersionCode = i;
            zzakq = (DriveId)zzx.zzw(driveid);
            zzako = (MetadataBundle)zzx.zzw(metadatabundle);
            zzake = contents;
            zzakp = integer;
            zzaiX = s;
            zzakr = j;
            zzajW = flag;
            zzaks = k;
            return;
        }
    }

    public CreateFileRequest(DriveId driveid, MetadataBundle metadatabundle, int i, int j, ExecutionOptions executionoptions)
    {
        this(2, driveid, metadatabundle, null, Integer.valueOf(j), executionoptions.zzqT(), executionoptions.zzqS(), executionoptions.zzqU(), i);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

}
