// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzx

private static class zzaiU
    implements com.google.android.gms.drive.der.DriveFileResult
{

    private final Status zzQA;
    private final DriveFile zzaiU;

    public DriveFile getDriveFile()
    {
        return zzaiU;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public FileResult(Status status, DriveFile drivefile)
    {
        zzQA = status;
        zzaiU = drivefile;
    }
}
