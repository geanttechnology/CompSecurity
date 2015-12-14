// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.util.SparseArray;

// Referenced classes of package com.google.android.gms.vision:
//            Detector

public static class zzaUZ
{

    private SparseArray zzaUX;
    private zzaUY zzaUY;
    private boolean zzaUZ;

    public boolean detectorIsOperational()
    {
        return zzaUZ;
    }

    public SparseArray getDetectedItems()
    {
        return zzaUX;
    }

    public zzaUX getFrameMetadata()
    {
        return zzaUY;
    }

    public (SparseArray sparsearray,  , boolean flag)
    {
        zzaUX = sparsearray;
        zzaUY = ;
        zzaUZ = flag;
    }
}
