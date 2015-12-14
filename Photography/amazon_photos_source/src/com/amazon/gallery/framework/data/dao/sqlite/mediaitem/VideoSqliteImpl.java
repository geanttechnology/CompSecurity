// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            MediaItemSqliteImpl, LocalMediaItemDaoSqliteImpl

public class VideoSqliteImpl extends MediaItemSqliteImpl
    implements Video
{

    private long duration;

    public VideoSqliteImpl(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        super(localmediaitemdaosqliteimpl);
    }

    public long getDuration()
    {
        return duration;
    }

    public MediaType getType()
    {
        return MediaType.VIDEO;
    }

    public void setDuration(long l)
    {
        duration = l;
    }
}
