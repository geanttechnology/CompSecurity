// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.gallery.widget.holder.MediaItemViewHolder;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            AbstractCoverViewFactory

public class MediaItemCoverViewFactory extends AbstractCoverViewFactory
{

    private final LaunchTimeMetrics launchTimeMetrics;

    public MediaItemCoverViewFactory(LaunchTimeMetrics launchtimemetrics)
    {
        super(0x7f03009a);
        launchTimeMetrics = launchtimemetrics;
    }

    public volatile ItemViewHolder createViewHolder(Persistable persistable, View view)
    {
        return createViewHolder((MediaItem)persistable, view);
    }

    public ItemViewHolder createViewHolder(MediaItem mediaitem, View view)
    {
        return new MediaItemViewHolder(mediaitem, launchTimeMetrics, view);
    }
}
