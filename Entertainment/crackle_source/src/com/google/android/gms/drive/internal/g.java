// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class g extends Metadata
{

    private final MetadataBundle qN;

    public g(MetadataBundle metadatabundle)
    {
        qN = metadatabundle;
    }

    protected Object a(MetadataField metadatafield)
    {
        return qN.a(metadatafield);
    }

    public Metadata cK()
    {
        return new g(MetadataBundle.a(qN));
    }

    public Object freeze()
    {
        return cK();
    }

    public boolean isDataValid()
    {
        return qN != null;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Metadata [mImpl=").append(qN).append("]").toString();
    }
}
