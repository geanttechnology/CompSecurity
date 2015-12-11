// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.MetadataBuffer;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs

static class zzakB
    implements com.google.android.gms.drive..MetadataBufferResult
{

    private final Status zzSC;
    private final MetadataBuffer zzakA;
    private final boolean zzakB;

    public MetadataBuffer getMetadataBuffer()
    {
        return zzakA;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public void release()
    {
        if (zzakA != null)
        {
            zzakA.release();
        }
    }

    public BufferResult(Status status, MetadataBuffer metadatabuffer, boolean flag)
    {
        zzSC = status;
        zzakA = metadatabuffer;
        zzakB = flag;
    }
}
