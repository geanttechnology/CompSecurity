// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveContents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzr

static class zzagv
    implements Releasable, com.google.android.gms.drive..DriveContentsResult
{

    private final Status zzQA;
    private final DriveContents zzagv;

    public DriveContents getDriveContents()
    {
        return zzagv;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public void release()
    {
        if (zzagv != null)
        {
            zzagv.zzqi();
        }
    }

    public tentsResult(Status status, DriveContents drivecontents)
    {
        zzQA = status;
        zzagv = drivecontents;
    }
}
