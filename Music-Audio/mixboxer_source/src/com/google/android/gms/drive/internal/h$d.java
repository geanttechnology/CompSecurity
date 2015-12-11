// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            h

static class qG
    implements com.google.android.gms.drive.eApi.DriveIdResult
{

    private final Status jY;
    private final DriveId qG;

    public DriveId getDriveId()
    {
        return qG;
    }

    public Status getStatus()
    {
        return jY;
    }

    public eIdResult(Status status, DriveId driveid)
    {
        jY = status;
        qG = driveid;
    }
}
