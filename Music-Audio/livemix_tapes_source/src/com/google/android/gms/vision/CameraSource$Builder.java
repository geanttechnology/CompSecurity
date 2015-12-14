// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.content.Context;

// Referenced classes of package com.google.android.gms.vision:
//            CameraSource, Detector

public static class zzaUL
{

    private final Detector zzaUK;
    private CameraSource zzaUL;

    public CameraSource build()
    {
        CameraSource camerasource = zzaUL;
        CameraSource camerasource1 = zzaUL;
        camerasource1.getClass();
        CameraSource.zza(camerasource, new t>(camerasource1, zzaUK));
        return zzaUL;
    }

    public zzaUL setFacing(int i)
    {
        if (i != 0 && i != 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid camera: ").append(i).toString());
        } else
        {
            CameraSource.zzc(zzaUL, i);
            return this;
        }
    }

    public zzaUL setRequestedFps(float f)
    {
        if (f <= 0.0F)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid fps: ").append(f).toString());
        } else
        {
            CameraSource.zza(zzaUL, f);
            return this;
        }
    }

    public zzaUL setRequestedPreviewSize(int i, int j)
    {
        if (i <= 0 || i > 0xf4240 || j <= 0 || j > 0xf4240)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid preview size: ").append(i).append("x").append(j).toString());
        } else
        {
            CameraSource.zza(zzaUL, i);
            CameraSource.zzb(zzaUL, j);
            return this;
        }
    }

    public (Context context, Detector detector)
    {
        zzaUL = new CameraSource(null);
        if (context == null)
        {
            throw new IllegalArgumentException("No context supplied.");
        }
        if (detector == null)
        {
            throw new IllegalArgumentException("No detector supplied.");
        } else
        {
            zzaUK = detector;
            CameraSource.zza(zzaUL, context);
            return;
        }
    }
}
