// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;


// Referenced classes of package com.google.android.gms.vision:
//            CameraSource

private class <init>
    implements android.hardware.lback
{

    final CameraSource zzaUM;
    private terCallback zzaUS;

    static terCallback zza(terCallback tercallback, terCallback tercallback1)
    {
        tercallback.zzaUS = tercallback1;
        return tercallback1;
    }

    public void onShutter()
    {
        if (zzaUS != null)
        {
            zzaUS.onShutter();
        }
    }

    private terCallback(CameraSource camerasource)
    {
        zzaUM = camerasource;
        super();
    }

    zzaUM(CameraSource camerasource, zzaUM zzaum)
    {
        this(camerasource);
    }
}
