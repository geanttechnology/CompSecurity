// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.MetadataBuffer;

// Referenced classes of package com.google.android.gms.drive.internal:
//            h

static class rf
    implements com.google.android.gms.drive.eApi.MetadataBufferResult
{

    private final Status jY;
    private final MetadataBuffer rf;

    public MetadataBuffer getMetadataBuffer()
    {
        return rf;
    }

    public Status getStatus()
    {
        return jY;
    }

    public r(Status status, MetadataBuffer metadatabuffer)
    {
        jY = status;
        rf = metadatabuffer;
    }
}
