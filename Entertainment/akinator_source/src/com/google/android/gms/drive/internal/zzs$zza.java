// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveContents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs

static class zzaiD
    implements Releasable, com.google.android.gms.drive..DriveContentsResult
{

    private final Status zzSC;
    private final DriveContents zzaiD;

    public DriveContents getDriveContents()
    {
        return zzaiD;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public void release()
    {
        if (zzaiD != null)
        {
            zzaiD.zzqP();
        }
    }

    public tentsResult(Status status, DriveContents drivecontents)
    {
        zzSC = status;
        zzaiD = drivecontents;
    }
}
