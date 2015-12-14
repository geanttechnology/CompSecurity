// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.utils;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;

public class SortHelper
{

    public static final String TAG = com/amazon/gallery/framework/gallery/utils/SortHelper.getName();
    private final ComponentProfiler profiler;
    private final SortTypeDao sortTypeDao;

    public SortHelper(SortTypeDao sorttypedao, ComponentProfiler componentprofiler)
    {
        sortTypeDao = sorttypedao;
        profiler = componentprofiler;
    }

    public MediaItemSortType getSortType(int i)
    {
        MediaItemSortType mediaitemsorttype = MediaItemSortType.TIME_STAMP_DESC;
        switch (i)
        {
        default:
            return mediaitemsorttype;

        case 2131493520: 
            return MediaItemSortType.TIME_STAMP_DESC;

        case 2131493521: 
            return MediaItemSortType.DATE_ADDED_DESC;

        case 2131493518: 
            return MediaItemSortType.TIME_STAMP_DESC;

        case 2131493519: 
            return MediaItemSortType.TIME_STAMP_ASC;
        }
    }

    public void saveSortPreference(MediaContentConfiguration mediacontentconfiguration, MediaItemSortType mediaitemsorttype)
    {
        mediacontentconfiguration = mediacontentconfiguration.toViewDescriptor();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.CUSTOM_DATA_SET.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[mediacontentconfiguration.getCollectionType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            sortTypeDao.saveSortTypeById("all", mediaitemsorttype);
            return;

        case 2: // '\002'
            sortTypeDao.saveSortTypeById("camera_roll", mediaitemsorttype);
            return;

        case 3: // '\003'
            sortTypeDao.saveSortTypeById("video", mediaitemsorttype);
            return;

        case 4: // '\004'
        case 5: // '\005'
            sortTypeDao.saveSortTypeById(mediacontentconfiguration.getTag().getObjectId().toString(), mediaitemsorttype);
            break;
        }
    }

    public void trackSortMetric(MediaContentConfiguration mediacontentconfiguration, MediaItemSortType mediaitemsorttype)
    {
        boolean flag;
        mediacontentconfiguration = mediacontentconfiguration.toViewDescriptor();
        if (mediaitemsorttype == MediaItemSortType.TIME_STAMP_DESC)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[mediacontentconfiguration.getCollectionType().ordinal()];
        JVM INSTR tableswitch 1 5: default 60
    //                   1 66
    //                   2 108
    //                   3 90
    //                   4 126
    //                   5 126;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        return;
_L2:
        if (flag)
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.AllViewTimeStampToggled;
        } else
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.AllViewDateUploadedToggled;
        }
_L7:
        profiler.trackEvent(mediacontentconfiguration);
        return;
_L4:
        if (flag)
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.VideoTimeStampToggled;
        } else
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.VideoDateUploadedToggled;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.CameraRollNewestFirstToggled;
        } else
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.CameraRollOldestFirstToggled;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (flag)
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.CollectionNewestFirstToggled;
        } else
        {
            mediacontentconfiguration = com.amazon.gallery.framework.gallery.metrics.EngagementMetrics.MetricsEvent.CollectionOldestFirstToggled;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

}
