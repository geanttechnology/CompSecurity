// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.Persistable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.amazon.gallery.framework.glide:
//            ModelFetcher

public class GalleryDataFetcher
    implements DataFetcher
{

    private static final String TAG = com/amazon/gallery/framework/glide/GalleryDataFetcher.getName();
    private final int height;
    private final String id;
    private InputStream inputStream;
    private final Persistable item;
    private final ModelFetcher modelFetcher;
    private final int width;

    public GalleryDataFetcher(ModelFetcher modelfetcher, Persistable persistable, int i, int j)
    {
        item = persistable;
        modelFetcher = modelfetcher;
        width = i;
        height = j;
        id = modelfetcher.getId(persistable, i, j);
    }

    public void cancel()
    {
        modelFetcher.cancel();
    }

    public void cleanup()
    {
        IOUtils.closeQuietly(inputStream);
    }

    public String getId()
    {
        return id;
    }

    public InputStream loadData(Priority priority)
        throws Exception
    {
        priority = modelFetcher.loadData(item, priority, width, height);
        if (priority != null && priority.exists())
        {
            try
            {
                inputStream = new FileInputStream(priority);
                GLogger.d(TAG, "Asset loaded for %s, path:%s", new Object[] {
                    item.getObjectId(), priority.getAbsolutePath()
                });
                priority = inputStream;
            }
            // Misplaced declaration of an exception variable
            catch (Priority priority)
            {
                GLogger.e(TAG, "error loading asset for %s. %s", new Object[] {
                    item.getObjectId(), priority.getMessage()
                });
                return null;
            }
            return priority;
        } else
        {
            GLogger.e(TAG, "error loading asset for %s", new Object[] {
                item.getObjectId()
            });
            return null;
        }
    }

    public volatile Object loadData(Priority priority)
        throws Exception
    {
        return loadData(priority);
    }

}
