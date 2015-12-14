// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.content.Context;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.widget.pipeline.AssetLoader;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.bumptech.glide.Priority;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.glide:
//            ModelFetcher

public class TagModelFetcher
    implements ModelFetcher
{

    private final AssetLoader assetLoader;

    public TagModelFetcher(Context context)
    {
        context = ((BeanAwareApplication)context).getBeanFactory();
        assetLoader = new AssetLoader((DiskStore)context.getBean(Keys.DISK_STORE), (NetworkStore)context.getBean(Keys.NETWORK_STORE));
    }

    public void cancel()
    {
    }

    public volatile String getId(Persistable persistable, int i, int j)
    {
        return getId((Tag)persistable, i, j);
    }

    public String getId(Tag tag, int i, int j)
    {
        ObjectID objectid;
        String s;
        if (tag.hasProperty(TagProperty.CLOUD) && tag.getCoverId() != null)
        {
            objectid = tag.getCoverId();
        } else
        {
            objectid = tag.getCustomCoverId();
        }
        s = tag.getObjectId().toString();
        if (objectid != null)
        {
            tag = objectid.toString();
        } else
        {
            tag = "";
        }
        return String.format("%s@%s@%dx%d", new Object[] {
            s, tag, Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public volatile File loadData(Persistable persistable, Priority priority, int i, int j)
    {
        return loadData((Tag)persistable, priority, i, j);
    }

    public File loadData(Tag tag, Priority priority, int i, int j)
    {
        MediaItem mediaitem;
        mediaitem = tag.getCoverItem();
        if (mediaitem == null && BuildFlavors.isDebug())
        {
            throw new RuntimeException("Tag does not have cover media item set");
        }
        if (!tag.getType().equals(TagType.ALBUM)) goto _L2; else goto _L1
_L1:
        priority = mediaitem;
        if (mediaitem != null)
        {
            priority = mediaitem;
            if (!tag.getCoverId().equals(mediaitem.getObjectId()))
            {
                priority = ((MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO)).getItemById(tag.getCoverId());
            }
        }
_L4:
        return assetLoader.load(priority, i, j);
_L2:
        priority = mediaitem;
        if (mediaitem != null)
        {
            priority = mediaitem;
            if (!tag.getCustomCoverId().equals(mediaitem.getObjectId()))
            {
                priority = ((MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO)).getItemById(tag.getCustomCoverId());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
