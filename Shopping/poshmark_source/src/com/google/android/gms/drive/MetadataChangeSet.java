// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.ft;
import java.util.Date;

public final class MetadataChangeSet
{
    public static class Builder
    {

        private final MetadataBundle Dj = MetadataBundle.fh();

        public MetadataChangeSet build()
        {
            return new MetadataChangeSet(Dj);
        }

        public Builder setIndexableText(String s)
        {
            Dj.b(fs.EC, s);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date)
        {
            Dj.b(ft.LAST_VIEWED_BY_ME, date);
            return this;
        }

        public Builder setMimeType(String s)
        {
            Dj.b(fs.MIME_TYPE, s);
            return this;
        }

        public Builder setPinned(boolean flag)
        {
            Dj.b(fs.IS_PINNED, Boolean.valueOf(flag));
            return this;
        }

        public Builder setStarred(boolean flag)
        {
            Dj.b(fs.STARRED, Boolean.valueOf(flag));
            return this;
        }

        public Builder setTitle(String s)
        {
            Dj.b(fs.TITLE, s);
            return this;
        }

        public Builder setViewed(boolean flag)
        {
            Dj.b(fs.Ew, Boolean.valueOf(flag));
            return this;
        }

        public Builder()
        {
        }
    }


    private final MetadataBundle Dj;

    private MetadataChangeSet(MetadataBundle metadatabundle)
    {
        Dj = MetadataBundle.a(metadatabundle);
    }


    public MetadataBundle eS()
    {
        return Dj;
    }

    public String getIndexableText()
    {
        return (String)Dj.a(fs.EC);
    }

    public Date getLastViewedByMeDate()
    {
        return (Date)Dj.a(ft.LAST_VIEWED_BY_ME);
    }

    public String getMimeType()
    {
        return (String)Dj.a(fs.MIME_TYPE);
    }

    public String getTitle()
    {
        return (String)Dj.a(fs.TITLE);
    }

    public Boolean isPinned()
    {
        return (Boolean)Dj.a(fs.IS_PINNED);
    }

    public Boolean isStarred()
    {
        return (Boolean)Dj.a(fs.STARRED);
    }

    public Boolean isViewed()
    {
        return (Boolean)Dj.a(fs.Ew);
    }
}
