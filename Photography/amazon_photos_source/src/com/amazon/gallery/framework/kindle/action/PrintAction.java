// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.app.Activity;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.print.GalleryPrintContext;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import java.util.Iterator;
import java.util.List;

public class PrintAction extends MediaItemAction
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent MultiSelectPrintPhotoActivated;
        public static final MetricsEvent MultiSelectPrintVideoActivated;
        public static final MetricsEvent SingleViewPrintPhotoActivated;
        public static final MetricsEvent SingleViewPrintVideoActivated;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/action/PrintAction$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            MultiSelectPrintPhotoActivated = new MetricsEvent("MultiSelectPrintPhotoActivated", 0);
            MultiSelectPrintVideoActivated = new MetricsEvent("MultiSelectPrintVideoActivated", 1);
            SingleViewPrintVideoActivated = new MetricsEvent("SingleViewPrintVideoActivated", 2);
            SingleViewPrintPhotoActivated = new MetricsEvent("SingleViewPrintPhotoActivated", 3);
            $VALUES = (new MetricsEvent[] {
                MultiSelectPrintPhotoActivated, MultiSelectPrintVideoActivated, SingleViewPrintVideoActivated, SingleViewPrintPhotoActivated
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TAG = com/amazon/gallery/framework/kindle/action/PrintAction.getName();
    private final GalleryPrintContext printContext;
    private final ShareStore shareStore;

    public PrintAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, GalleryPrintContext galleryprintcontext, ShareStore sharestore)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e004b);
        shareStore = sharestore;
        printContext = galleryprintcontext;
    }

    public boolean canExecute(List list)
    {
        return super.canExecute(list) && printContext.canExecute(list);
    }

    public void execute(List list)
    {
        GLogger.d(TAG, "Executing PrintAction on a List<MediaItem>:", new Object[0]);
        if (!list.isEmpty())
        {
            super.execute(list);
            if (((MediaItem)list.get(0)).hasProperty(CommonMediaProperty.LOCAL) || !networkConnectivity.promptIfOffline(context))
            {
                printContext.setContext(context);
                printContext.setShareStore(shareStore);
                printContext.prepareItemsToPrint(list);
                return;
            }
        }
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
        if (actionSource != null && profiler != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        list = list.iterator();
_L7:
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[];
            static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource = new int[com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.MULTISELECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.SINGLE_VIEW_HAB.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
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

        Object obj;
        if (list.hasNext())
        {
            MediaItem mediaitem = (MediaItem)list.next();
            switch (_cls1..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaitem.getType().ordinal()])
            {
            case 1: // '\001'
                flag1 = true;
                break;

            case 2: // '\002'
                flag = true;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        list = null;
        obj = null;
        _cls1..SwitchMap.com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource[actionSource.ordinal()];
        JVM INSTR tableswitch 1 2: default 132
    //                   1 184
    //                   2 195;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_195;
_L9:
        if (flag1)
        {
            profiler.trackEvent(list);
        }
        if (flag)
        {
            profiler.trackEvent(((Enum) (obj)));
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L7; else goto _L6
_L6:
        if (!isWhisperPlayMode()) goto _L1; else goto _L8
_L8:
        list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPPrintAction;
        profiler.trackEvent(list, CustomerMetricsHelper.getExtraEventTag(list.toString()));
        return;
_L4:
        list = MetricsEvent.MultiSelectPrintPhotoActivated;
        obj = MetricsEvent.MultiSelectPrintVideoActivated;
          goto _L9
        list = MetricsEvent.SingleViewPrintPhotoActivated;
        obj = MetricsEvent.SingleViewPrintVideoActivated;
          goto _L9
    }

}
