// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.MetadataBuffer;

// Referenced classes of package com.google.android.gms.drive.internal:
//            l

static class Dy
    implements com.google.android.gms.drive.eApi.MetadataBufferResult
{

    private final MetadataBuffer Dy;
    private final Status vl;

    public MetadataBuffer getMetadataBuffer()
    {
        return Dy;
    }

    public Status getStatus()
    {
        return vl;
    }

    public r(Status status, MetadataBuffer metadatabuffer)
    {
        vl = status;
        Dy = metadatabuffer;
    }
}
