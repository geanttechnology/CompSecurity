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
//            zzm

public class CreateFileRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    final String zzagM;
    final boolean zzahM;
    final Contents zzahR;
    final MetadataBundle zzaib;
    final Integer zzaic;
    final DriveId zzaid;
    final int zzaie;
    final int zzaif;

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
            zzaid = (DriveId)zzx.zzv(driveid);
            zzaib = (MetadataBundle)zzx.zzv(metadatabundle);
            zzahR = contents;
            zzaic = integer;
            zzagM = s;
            zzaie = j;
            zzahM = flag;
            zzaif = k;
            return;
        }
    }

    public CreateFileRequest(DriveId driveid, MetadataBundle metadatabundle, int i, int j, ExecutionOptions executionoptions)
    {
        this(2, driveid, metadatabundle, null, Integer.valueOf(j), executionoptions.zzqm(), executionoptions.zzql(), executionoptions.zzqn(), i);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

}
