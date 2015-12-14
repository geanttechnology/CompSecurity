// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.gallery.widget.holder.TagViewHolder;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            AbstractCoverViewFactory

public class TagCoverViewFactory extends AbstractCoverViewFactory
{

    protected GalleryDownloadManager downloadManager;

    protected TagCoverViewFactory(int i)
    {
        super(i);
        downloadManager = (GalleryDownloadManager)ThorGalleryApplication.getBean(Keys.GALLERY_DOWNLOAD_MANAGER);
    }

    public volatile ItemViewHolder createViewHolder(Persistable persistable, View view)
    {
        return createViewHolder((Tag)persistable, view);
    }

    public ItemViewHolder createViewHolder(Tag tag, View view)
    {
        return new TagViewHolder(tag, view, downloadManager);
    }
}
