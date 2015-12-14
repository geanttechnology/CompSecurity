// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.mediaitem;

import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.MediaItemDaoChangeList;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.tags.Tag;

public interface LocalMediaItemDao
{

    public abstract MediaItem getItemById(ObjectID objectid);

    public abstract MediaItemCollection getItemsByTag(Tag tag);

    public abstract MediaItemCollection getItemsByTag(Tag tag, MediaFilter mediafilter);

    public abstract MediaItemDaoChangeList save(MediaItem mediaitem);
}
