// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.accessibility.utils;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class ContentDescriptionHelper
{

    private static final DateFormat DATE_FORMAT;
    private static android.view.View.AccessibilityDelegate accessibilityDelegate = new android.view.View.AccessibilityDelegate() {

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
        {
            super.onPopulateAccessibilityEvent(view, accessibilityevent);
            if (accessibilityevent != null && accessibilityevent.getEventType() == 32768)
            {
                if ((accessibilityevent = ContentDescriptionHelper.getMediaItemFromView(view)) != null)
                {
                    view.setContentDescription(ContentDescriptionHelper.getContentDescription(accessibilityevent));
                    return;
                }
            }
        }

    };

    private static void appendDurationDescription(Video video, StringBuilder stringbuilder)
    {
        long l = video.getDuration() / 1000L;
        long l1 = l / 60L;
        long l2 = l1 / 60L;
        long l3 = l1 - 60L * l2;
        if (l2 > 0L)
        {
            stringbuilder.append(l2).append(" hours");
        }
        if (l3 > 0L)
        {
            stringbuilder.append(l3).append(" minutes");
        }
        stringbuilder.append(l - 60L * l1).append(" seconds");
    }

    public static String getContentDescription(MediaItem mediaitem)
    {
        StringBuilder stringbuilder = new StringBuilder();
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 94
    //                   2 134;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_134;
_L1:
        stringbuilder.append("Unknown type");
_L4:
        stringbuilder.append(", ");
        String s;
        if (mediaitem.getDateCreatedMs() != 0L)
        {
            stringbuilder.append(DATE_FORMAT.format(Long.valueOf(mediaitem.getDateCreatedMs())));
        } else
        {
            stringbuilder.append("No date");
        }
        return stringbuilder.toString();
_L2:
        stringbuilder.append("Photo, ");
        if (mediaitem.getWidth() > mediaitem.getHeight())
        {
            s = "Landscape";
        } else
        {
            s = "Portrait";
        }
        stringbuilder.append(s);
          goto _L4
        stringbuilder.append("Video, Duration ");
        appendDurationDescription((Video)mediaitem, stringbuilder);
          goto _L4
    }

    private static MediaItem getMediaItemFromView(View view)
    {
        view = ((View) (view.getTag()));
        if (view instanceof ItemViewHolder)
        {
            view = ((ItemViewHolder)view).getItem();
            if (view instanceof MediaItem)
            {
                return (MediaItem)view;
            }
        }
        return null;
    }

    public static void setupAccessibilityContent(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            view.setAccessibilityDelegate(accessibilityDelegate);
        }
        MediaItem mediaitem = getMediaItemFromView(view);
        if (mediaitem != null)
        {
            view.setContentDescription(mediaitem.getType().name());
        }
    }

    static 
    {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.ROOT);
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

}
