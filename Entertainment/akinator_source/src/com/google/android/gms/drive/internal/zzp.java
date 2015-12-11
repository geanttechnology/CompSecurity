// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzp extends Metadata
{

    private final MetadataBundle zzakt;

    public zzp(MetadataBundle metadatabundle)
    {
        zzakt = metadatabundle;
    }

    public Object freeze()
    {
        return zzqV();
    }

    public boolean isDataValid()
    {
        return zzakt != null;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Metadata [mImpl=").append(zzakt).append("]").toString();
    }

    public Object zza(MetadataField metadatafield)
    {
        return zzakt.zza(metadatafield);
    }

    public Metadata zzqV()
    {
        return new zzp(MetadataBundle.zza(zzakt));
    }
}
