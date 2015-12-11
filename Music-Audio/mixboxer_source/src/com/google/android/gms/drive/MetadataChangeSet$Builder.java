// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fh;

// Referenced classes of package com.google.android.gms.drive:
//            MetadataChangeSet

public static class Bundle
{

    private final MetadataBundle qV = MetadataBundle.cX();

    public MetadataChangeSet build()
    {
        return new MetadataChangeSet(qV, null);
    }

    public Bundle setMimeType(String s)
    {
        qV.b(fh.MIME_TYPE, s);
        return this;
    }

    public Bundle.b setStarred(boolean flag)
    {
        qV.b(fh.STARRED, Boolean.valueOf(flag));
        return this;
    }

    public Bundle.b setTitle(String s)
    {
        qV.b(fh.TITLE, s);
        return this;
    }

    public Bundle()
    {
    }
}
