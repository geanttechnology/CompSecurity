// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzr

private static class zzags
    implements com.google.android.gms.drive..DriveIdResult
{

    private final Status zzQA;
    private final DriveId zzags;

    public DriveId getDriveId()
    {
        return zzags;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public esult(Status status, DriveId driveid)
    {
        zzQA = status;
        zzags = driveid;
    }
}
