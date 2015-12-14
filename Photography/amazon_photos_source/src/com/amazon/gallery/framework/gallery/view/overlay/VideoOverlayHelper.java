// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.overlay;

import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.Video;

public class VideoOverlayHelper
{

    public static String formatVideoDurationString(long l)
    {
        if (l >= 3600L)
        {
            return String.format("%02d:%02d:%02d", new Object[] {
                Long.valueOf((l % 0x15180L) / 3600L), Long.valueOf((l % 3600L) / 60L), Long.valueOf(l % 60L)
            });
        } else
        {
            return String.format("%02d:%02d", new Object[] {
                Long.valueOf((l % 3600L) / 60L), Long.valueOf(l % 60L)
            });
        }
    }

    public static String formatVideoDurationString(MediaItem mediaitem)
    {
        return formatVideoDurationString(((Video)mediaitem).getDuration() / 1000L);
    }
}
