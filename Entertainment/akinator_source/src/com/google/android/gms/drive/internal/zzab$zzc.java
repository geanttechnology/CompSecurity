// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Metadata;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzab

private static class zzalr
    implements com.google.android.gms.drive.urce.MetadataResult
{

    private final Status zzSC;
    private final Metadata zzalr;

    public Metadata getMetadata()
    {
        return zzalr;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public dataResult(Status status, Metadata metadata)
    {
        zzSC = status;
        zzalr = metadata;
    }
}
