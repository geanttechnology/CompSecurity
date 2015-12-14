// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.MetadataBuffer;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzr

static class zzaio
    implements com.google.android.gms.drive..MetadataBufferResult
{

    private final Status zzQA;
    private final MetadataBuffer zzain;
    private final boolean zzaio;

    public MetadataBuffer getMetadataBuffer()
    {
        return zzain;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public void release()
    {
        if (zzain != null)
        {
            zzain.release();
        }
    }

    public BufferResult(Status status, MetadataBuffer metadatabuffer, boolean flag)
    {
        zzQA = status;
        zzain = metadatabuffer;
        zzaio = flag;
    }
}
