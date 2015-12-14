// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.framework.gallery.view.overlay.VideoOverlayHelper;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.Video;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.FileUtils;

public class ItemMetadataViewHolder extends ItemViewHolder
{

    public final CheckBox checkBox;
    public final TextView dateText;
    public final TextView sizeText;
    private final TextView videoDuration;
    private final View videoPlayOverlay;

    public ItemMetadataViewHolder(MediaItem mediaitem, View view)
    {
        super(mediaitem, view);
        setImageView((ImageView)itemView.findViewById(0x7f0c017a));
        sizeText = (TextView)view.findViewById(0x7f0c017d);
        dateText = (TextView)view.findViewById(0x7f0c017e);
        checkBox = (CheckBox)view.findViewById(0x7f0c017c);
        videoPlayOverlay = view.findViewById(0x7f0c017b);
        videoDuration = (TextView)videoPlayOverlay.findViewById(0x7f0c0208);
    }

    private void updateDateField(MediaItem mediaitem)
    {
        DateFormat dateformat = DateFormat.getDateInstance(0, Locale.getDefault());
        dateText.setText(dateformat.format(new Date(mediaitem.getDateCreatedMs())));
    }

    private void updateSizeField(MediaItem mediaitem)
    {
        mediaitem = FileUtils.byteCountToDisplaySize(mediaitem.getSize());
        sizeText.setText(String.valueOf(mediaitem));
    }

    public void updateView(MediaItem mediaitem, boolean flag)
    {
        item = mediaitem;
        if (mediaitem instanceof Video)
        {
            videoPlayOverlay.setVisibility(0);
            if (videoDuration != null)
            {
                videoDuration.setText(VideoOverlayHelper.formatVideoDurationString(mediaitem));
            }
        } else
        {
            videoPlayOverlay.setVisibility(8);
        }
        updateDateField(mediaitem);
        updateSizeField(mediaitem);
        checkBox.setChecked(flag);
    }
}
