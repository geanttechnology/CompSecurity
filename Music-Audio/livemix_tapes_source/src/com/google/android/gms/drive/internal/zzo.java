// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzo extends Metadata
{

    private final MetadataBundle zzaig;

    public zzo(MetadataBundle metadatabundle)
    {
        zzaig = metadatabundle;
    }

    public Object freeze()
    {
        return zzqo();
    }

    public boolean isDataValid()
    {
        return zzaig != null;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Metadata [mImpl=").append(zzaig).append("]").toString();
    }

    public Object zza(MetadataField metadatafield)
    {
        return zzaig.zza(metadatafield);
    }

    public Metadata zzqo()
    {
        return new zzo(MetadataBundle.zza(zzaig));
    }
}
