// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import java.util.List;

// Referenced classes of package com.google.android.gms.vision:
//            MultiDetector, Detector

public static class zzaVk
{

    private MultiDetector zzaVk;

    public zzaVk add(Detector detector)
    {
        MultiDetector.zza(zzaVk).add(detector);
        return this;
    }

    public MultiDetector build()
    {
        if (MultiDetector.zza(zzaVk).size() == 0)
        {
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        } else
        {
            return zzaVk;
        }
    }

    public _cls9()
    {
        zzaVk = new MultiDetector(null);
    }
}
