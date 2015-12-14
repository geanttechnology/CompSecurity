// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.LocalMediaItemDaoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.PhotoSqliteImpl;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import java.util.List;

public abstract class AbstractOrderedGroupPhotoSqlite extends PhotoSqliteImpl
    implements OrderedGroupPhoto
{

    private List frames;

    protected AbstractOrderedGroupPhotoSqlite(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        super(localmediaitemdaosqliteimpl);
    }

    public void clearFrames()
    {
        if (frames != null)
        {
            frames.clear();
        }
    }

    public List getFrames()
    {
        if (frames == null)
        {
            frames = mediaItemDao.getFramesByMediaItem(this);
        }
        return frames;
    }

    public void setFrames(List list)
    {
        frames = list;
    }
}
