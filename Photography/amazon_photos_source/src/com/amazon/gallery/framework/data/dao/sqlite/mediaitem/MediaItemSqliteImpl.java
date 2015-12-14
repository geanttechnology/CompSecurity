// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.model.MediaItemBeanImpl;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaProperty;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

public abstract class MediaItemSqliteImpl extends MediaItemBeanImpl
    implements MediaItem
{

    protected final LocalMediaItemDaoSqliteImpl mediaItemDao;
    private boolean metadataLoaded;
    private boolean propertiesLoaded;
    private boolean tagsLoaded;

    public MediaItemSqliteImpl(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        tagsLoaded = false;
        metadataLoaded = false;
        propertiesLoaded = false;
        mediaItemDao = localmediaitemdaosqliteimpl;
    }

    public long getId()
    {
        if (id == -1L && objectId != null)
        {
            MediaItemSqliteImpl mediaitemsqliteimpl = (MediaItemSqliteImpl)mediaItemDao.getItemById(objectId);
            if (mediaitemsqliteimpl != null && mediaitemsqliteimpl.getObjectId() != null)
            {
                id = mediaitemsqliteimpl.getId();
            }
        }
        return id;
    }

    public Map getMetadata()
    {
        if (!metadataLoaded)
        {
            metadata = mediaItemDao.getMetadataByMediaItem(this);
            metadataLoaded = true;
        }
        return metadata;
    }

    public Set getProperties()
    {
        if (!propertiesLoaded)
        {
            properties = mediaItemDao.getPropertiesByMediaItem(this);
            propertiesLoaded = true;
        }
        return properties;
    }

    public Set getTags()
    {
        if (!tagsLoaded)
        {
            tags = mediaItemDao.getTagsByMediaItem(this);
            tagsLoaded = true;
        }
        return tags;
    }

    public boolean hasProperty(MediaProperty mediaproperty)
    {
        if (mediaproperty == CommonMediaProperty.LOCAL)
        {
            return localPath != null;
        }
        if (!propertiesLoaded)
        {
            properties = mediaItemDao.getPropertiesByMediaItem(this);
            propertiesLoaded = true;
        }
        return properties.contains(mediaproperty);
    }

    public void setMetadata(Map map)
    {
        super.setMetadata(map);
        metadataLoaded = true;
    }

    public void setProperties(Set set)
    {
        super.setProperties(set);
        propertiesLoaded = true;
    }

    public void setTags(Set set)
    {
        super.setTags(set);
        tagsLoaded = true;
    }
}
