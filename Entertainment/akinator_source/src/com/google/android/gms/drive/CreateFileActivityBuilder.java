// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzl;
import com.google.android.gms.drive.internal.zzv;

// Referenced classes of package com.google.android.gms.drive:
//            DriveContents, Contents, DriveId, MetadataChangeSet

public class CreateFileActivityBuilder
{

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzl zzaiC = new zzl(0);
    private DriveContents zzaiD;
    private boolean zzaiE;

    public CreateFileActivityBuilder()
    {
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        zzx.zzb(Boolean.valueOf(zzaiE), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzx.zza(googleapiclient.isConnected(), "Client must be connected");
        if (zzaiD != null)
        {
            zzaiD.zzqP();
        }
        return zzaiC.build(googleapiclient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveid)
    {
        zzaiC.zza(driveid);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String s)
    {
        zzaiC.zzcE(s);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents drivecontents)
    {
        if (drivecontents != null)
        {
            if (!(drivecontents instanceof zzv))
            {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            }
            if (drivecontents.getDriveId() != null)
            {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            }
            if (drivecontents.zzqQ())
            {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
            zzaiC.zzcI(drivecontents.zzqO().getRequestId());
            zzaiD = drivecontents;
        } else
        {
            zzaiC.zzcI(1);
        }
        zzaiE = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadatachangeset)
    {
        zzaiC.zza(metadatachangeset);
        return this;
    }
}
