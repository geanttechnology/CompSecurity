// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive:
//            Metadata

public final class b extends Metadata
{

    private final MetadataBundle qN;

    public b(MetadataBundle metadatabundle)
    {
        qN = metadatabundle;
    }

    protected Object a(MetadataField metadatafield)
    {
        return qN.a(metadatafield);
    }

    public Metadata cK()
    {
        return new b(MetadataBundle.a(qN));
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
