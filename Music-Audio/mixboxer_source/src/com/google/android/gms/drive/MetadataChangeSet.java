// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fh;

public final class MetadataChangeSet
{
    public static class Builder
    {

        private final MetadataBundle qV = MetadataBundle.cX();

        public MetadataChangeSet build()
        {
            return new MetadataChangeSet(qV);
        }

        public Builder setMimeType(String s)
        {
            qV.b(fh.MIME_TYPE, s);
            return this;
        }

        public Builder setStarred(boolean flag)
        {
            qV.b(fh.STARRED, Boolean.valueOf(flag));
            return this;
        }

        public Builder setTitle(String s)
        {
            qV.b(fh.TITLE, s);
            return this;
        }

        public Builder()
        {
        }
    }


    private final MetadataBundle qV;

    private MetadataChangeSet(MetadataBundle metadatabundle)
    {
        qV = MetadataBundle.a(metadatabundle);
    }


    public MetadataBundle cM()
    {
        return qV;
    }

    public String getMimeType()
    {
        return (String)qV.a(fh.MIME_TYPE);
    }

    public String getTitle()
    {
        return (String)qV.a(fh.TITLE);
    }

    public Boolean isStarred()
    {
        return (Boolean)qV.a(fh.STARRED);
    }
}
