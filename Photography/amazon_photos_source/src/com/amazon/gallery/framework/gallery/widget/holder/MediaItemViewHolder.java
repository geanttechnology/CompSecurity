// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.metrics.LaunchTimeMetrics;
import com.amazon.gallery.framework.gallery.view.overlay.VideoOverlayHelper;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.Video;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            ItemViewHolder

public class MediaItemViewHolder extends ItemViewHolder
{

    private TextView videoDuration;
    protected View videoPlayOverlay;

    public MediaItemViewHolder(MediaItem mediaitem, View view)
    {
        super(mediaitem, view);
        initViews(view);
    }

    public MediaItemViewHolder(MediaItem mediaitem, LaunchTimeMetrics launchtimemetrics, View view)
    {
        this(mediaitem, view);
        launchTimeMetrics = launchtimemetrics;
    }

    protected void initViews(View view)
    {
        setImageView((ImageView)view.findViewById(0x7f0c0173));
        videoPlayOverlay = view.findViewById(0x7f0c0205);
        videoDuration = (TextView)videoPlayOverlay.findViewById(0x7f0c0208);
    }

    public volatile void updateView(Persistable persistable, Context context)
    {
        updateView((MediaItem)persistable, context);
    }

    public void updateView(MediaItem mediaitem, Context context)
    {
        super.updateView(mediaitem, context);
        if (mediaitem instanceof Video)
        {
            videoPlayOverlay.setVisibility(0);
            if (videoDuration != null)
            {
                videoDuration.setText(VideoOverlayHelper.formatVideoDurationString(mediaitem));
            }
            return;
        } else
        {
            videoPlayOverlay.setVisibility(8);
            return;
        }
    }
}
