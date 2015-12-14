// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzx

private static class zzaiV
    implements com.google.android.gms.drive.der.DriveFolderResult
{

    private final Status zzQA;
    private final DriveFolder zzaiV;

    public DriveFolder getDriveFolder()
    {
        return zzaiV;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public FolderResult(Status status, DriveFolder drivefolder)
    {
        zzQA = status;
        zzaiV = drivefolder;
    }
}
