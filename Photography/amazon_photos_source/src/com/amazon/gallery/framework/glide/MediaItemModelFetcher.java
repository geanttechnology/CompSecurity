// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.content.Context;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.widget.pipeline.AssetLoader;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.bumptech.glide.Priority;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.glide:
//            ModelFetcher

public class MediaItemModelFetcher
    implements ModelFetcher
{

    private final AssetLoader assetLoader;

    public MediaItemModelFetcher(Context context)
    {
        context = ((BeanAwareApplication)context).getBeanFactory();
        assetLoader = new AssetLoader((DiskStore)context.getBean(Keys.DISK_STORE), (NetworkStore)context.getBean(Keys.NETWORK_STORE));
    }

    public void cancel()
    {
    }

    public volatile String getId(Persistable persistable, int i, int j)
    {
        return getId((MediaItem)persistable, i, j);
    }

    public String getId(MediaItem mediaitem, int i, int j)
    {
        return String.format("%s@%dx%d", new Object[] {
            mediaitem.getObjectId().toString(), Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public volatile File loadData(Persistable persistable, Priority priority, int i, int j)
    {
        return loadData((MediaItem)persistable, priority, i, j);
    }

    public File loadData(MediaItem mediaitem, Priority priority, int i, int j)
    {
        return assetLoader.load(mediaitem, i, j);
    }
}
