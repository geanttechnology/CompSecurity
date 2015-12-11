// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzy

private static class zzali
    implements com.google.android.gms.drive.der.DriveFileResult
{

    private final Status zzSC;
    private final DriveFile zzali;

    public DriveFile getDriveFile()
    {
        return zzali;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public FileResult(Status status, DriveFile drivefile)
    {
        zzSC = status;
        zzali = drivefile;
    }
}
