// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;


// Referenced classes of package com.google.android.gms.vision:
//            MultiProcessor

public static class zzaVo
{

    private MultiProcessor zzaVo;

    public MultiProcessor build()
    {
        return zzaVo;
    }

    public zzaVo setMaxGapFrames(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid max gap: ").append(i).toString());
        } else
        {
            MultiProcessor.zza(zzaVo, i);
            return this;
        }
    }

    public ( )
    {
        zzaVo = new MultiProcessor(null);
        if ( == null)
        {
            throw new IllegalArgumentException("No factory supplied.");
        } else
        {
            MultiProcessor.zza(zzaVo, );
            return;
        }
    }
}
