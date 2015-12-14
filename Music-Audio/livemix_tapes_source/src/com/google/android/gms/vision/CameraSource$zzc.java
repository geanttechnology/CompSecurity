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
    private ureCallback zzaUR;

    static ureCallback zza(ureCallback urecallback, ureCallback urecallback1)
    {
        urecallback.zzaUR = urecallback1;
        return urecallback1;
    }

    public void onPictureTaken(byte abyte0[], Camera camera)
    {
        if (zzaUR != null)
        {
            zzaUR.onPictureTaken(abyte0);
        }
        synchronized (CameraSource.zza(zzaUM))
        {
            if (CameraSource.zzb(zzaUM) != null)
            {
                CameraSource.zzb(zzaUM).startPreview();
            }
        }
        return;
        camera;
        abyte0;
        JVM INSTR monitorexit ;
        throw camera;
    }

    private ureCallback(CameraSource camerasource)
    {
        zzaUM = camerasource;
        super();
    }

    zzaUM(CameraSource camerasource, zzaUM zzaum)
    {
        this(camerasource);
    }
}
