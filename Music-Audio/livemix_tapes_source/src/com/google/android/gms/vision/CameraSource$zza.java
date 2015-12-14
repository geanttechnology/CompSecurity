// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.hardware.Camera;

// Referenced classes of package com.google.android.gms.vision:
//            CameraSource

private class <init>
    implements android.hardware.lback
{

    final CameraSource zzaUM;

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        CameraSource.zzc(zzaUM).zza(abyte0, camera);
    }

    private (CameraSource camerasource)
    {
        zzaUM = camerasource;
        super();
    }

    zzaUM(CameraSource camerasource, zzaUM zzaum)
    {
        this(camerasource);
    }
}
