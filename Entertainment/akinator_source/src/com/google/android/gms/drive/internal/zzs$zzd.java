// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs

private static class zzaiA
    implements com.google.android.gms.drive..DriveIdResult
{

    private final Status zzSC;
    private final DriveId zzaiA;

    public DriveId getDriveId()
    {
        return zzaiA;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public esult(Status status, DriveId driveid)
    {
        zzSC = status;
        zzaiA = driveid;
    }
}
