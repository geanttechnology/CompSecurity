// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzk;
import com.google.android.gms.drive.internal.zzu;

// Referenced classes of package com.google.android.gms.drive:
//            Drive, DriveContents, Contents, DriveId, 
//            MetadataChangeSet

public class CreateFileActivityBuilder
{

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzk zzagu = new zzk(0);
    private DriveContents zzagv;
    private boolean zzagw;

    public CreateFileActivityBuilder()
    {
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        zzx.zzb(Boolean.valueOf(zzagw), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzx.zza(googleapiclient.isConnected(), "Client must be connected");
        boolean flag;
        if (googleapiclient.zza(Drive.SCOPE_FILE) || googleapiclient.zza(Drive.zzagx))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "The apiClient must have suitable scope to create files");
        if (zzagv != null)
        {
            zzagv.zzqi();
        }
        return zzagu.build(googleapiclient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveid)
    {
        zzagu.zza(driveid);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String s)
    {
        zzagu.zzcF(s);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents drivecontents)
    {
        if (drivecontents != null)
        {
            if (!(drivecontents instanceof zzu))
            {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if (drivecontents.getDriveId() != null)
            {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if (drivecontents.zzqj())
            {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
            zzagu.zzcC(drivecontents.zzqh().getRequestId());
            zzagv = drivecontents;
        } else
        {
            zzagu.zzcC(1);
        }
        zzagw = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadatachangeset)
    {
        zzagu.zza(metadatachangeset);
        return this;
    }
}
