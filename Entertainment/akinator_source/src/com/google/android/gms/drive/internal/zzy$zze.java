// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzy

private static class zzalj
    implements com.google.android.gms.drive.der.DriveFolderResult
{

    private final Status zzSC;
    private final DriveFolder zzalj;

    public DriveFolder getDriveFolder()
    {
        return zzalj;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public FolderResult(Status status, DriveFolder drivefolder)
    {
        zzSC = status;
        zzalj = drivefolder;
    }
}
