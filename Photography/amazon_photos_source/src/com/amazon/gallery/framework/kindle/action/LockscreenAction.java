// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.app.Activity;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.actions.PrepareMediaItemsHelper;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.kindle.action.wallpaper.LockscreenTask;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LockscreenAction extends MediaItemAction
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent LockscreenMultiSelectClicked;
        public static final MetricsEvent LockscreenSetFailure;
        public static final MetricsEvent LockscreenSetSuccessfully;
        public static final MetricsEvent LockscreenSingleViewClicked;
        public static final MetricsEvent WallpaperSetFailure;
        public static final MetricsEvent WallpaperSetSuccessfully;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/action/LockscreenAction$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            LockscreenMultiSelectClicked = new MetricsEvent("LockscreenMultiSelectClicked", 0);
            LockscreenSingleViewClicked = new MetricsEvent("LockscreenSingleViewClicked", 1);
            LockscreenSetSuccessfully = new MetricsEvent("LockscreenSetSuccessfully", 2);
            LockscreenSetFailure = new MetricsEvent("LockscreenSetFailure", 3);
            WallpaperSetSuccessfully = new MetricsEvent("WallpaperSetSuccessfully", 4);
            WallpaperSetFailure = new MetricsEvent("WallpaperSetFailure", 5);
            $VALUES = (new MetricsEvent[] {
                LockscreenMultiSelectClicked, LockscreenSingleViewClicked, LockscreenSetSuccessfully, LockscreenSetFailure, WallpaperSetSuccessfully, WallpaperSetFailure
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/action/LockscreenAction.getName();
    private Set locationTarget;
    private final PrepareMediaItemsHelper prepareItemsHelper;
    private final ShareStore shareStore;

    public LockscreenAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, ShareStore sharestore, PrepareMediaItemsHelper preparemediaitemshelper)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e004a);
        locationTarget = EnumSet.noneOf(com/amazon/gallery/framework/kindle/action/wallpaper/WallpaperConstants$TargetLocations);
        shareStore = sharestore;
        prepareItemsHelper = preparemediaitemshelper;
    }

    public void addLocationTarget(com.amazon.gallery.framework.kindle.action.wallpaper.WallpaperConstants.TargetLocations targetlocations)
    {
        locationTarget.add(targetlocations);
    }

    public boolean canExecute(List list)
    {
        boolean flag1 = false;
        if (BuildFlavors.isFos5()) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
_L4:
        return flag;
_L2:
        int i = list.size();
        flag = flag1;
        if (i == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (i > 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = true;
        list = list.iterator();
        do
        {
            flag = flag1;
            if (!list.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            MediaItem mediaitem = (MediaItem)list.next();
            if (mediaitem == null || mediaitem.getType() != MediaType.PHOTO)
            {
                return false;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean canSetLockscreen()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (BuildFlavors.isFos5())
        {
            flag = flag1;
            if (android.provider.Settings.Global.getInt(context.getContentResolver(), "LOCKSCREEN_AD_ENABLED", 0) == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void execute(List list)
    {
        GLogger.i(TAG, "Executing...", new Object[0]);
        GlobalMessagingBus.post(new ActionCompleteEvent());
        boolean flag1 = false;
        Object obj = list.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (((MediaItem)((Iterator) (obj)).next()).hasProperty(CommonMediaProperty.LOCAL))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        if (flag && networkConnectivity.promptIfOffline(context))
        {
            return;
        }
        super.execute(list);
        obj = context.getString(0x7f0e018e);
        list = new LockscreenTask(context, shareStore, prepareItemsHelper, list);
        if (locationTarget != null)
        {
            list.setLocationTargets(locationTarget);
        }
        (new BlockingSpinnerDialog(context, list, ((String) (obj)))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource = new int[com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.SINGLE_VIEW_HAB.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.MULTISELECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource[actionSource.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        list = MetricsEvent.LockscreenSingleViewClicked;
_L5:
        profiler.trackEvent(list, ClickstreamEventHelper.createClickstreamExtra("ActionEvent", HitType.APP_ACTION));
        return;
_L3:
        list = MetricsEvent.LockscreenMultiSelectClicked;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
