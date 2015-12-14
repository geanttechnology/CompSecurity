// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.tags.TagType;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            LaunchSourceMetrics

public class AdLaunchHelper
{
    private static final class AdLaunchType extends Enum
    {

        private static final AdLaunchType $VALUES[];
        public static final AdLaunchType ADD_PHOTOS;
        public static final AdLaunchType ALL;
        public static final AdLaunchType CAMERA_ROLL;
        public static final AdLaunchType CLOUD;
        public static final AdLaunchType DEVICE;
        public static final AdLaunchType FTUE;
        public static final AdLaunchType SETTINGS;
        public static final AdLaunchType VIDEO;

        public static AdLaunchType valueOf(String s)
        {
            return (AdLaunchType)Enum.valueOf(com/amazon/gallery/framework/kindle/activity/AdLaunchHelper$AdLaunchType, s);
        }

        public static AdLaunchType[] values()
        {
            return (AdLaunchType[])$VALUES.clone();
        }

        static 
        {
            FTUE = new AdLaunchType("FTUE", 0);
            ADD_PHOTOS = new AdLaunchType("ADD_PHOTOS", 1);
            SETTINGS = new AdLaunchType("SETTINGS", 2);
            CLOUD = new AdLaunchType("CLOUD", 3);
            DEVICE = new AdLaunchType("DEVICE", 4);
            ALL = new AdLaunchType("ALL", 5);
            VIDEO = new AdLaunchType("VIDEO", 6);
            CAMERA_ROLL = new AdLaunchType("CAMERA_ROLL", 7);
            $VALUES = (new AdLaunchType[] {
                FTUE, ADD_PHOTOS, SETTINGS, CLOUD, DEVICE, ALL, VIDEO, CAMERA_ROLL
            });
        }

        private AdLaunchType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String TAG = com/amazon/gallery/framework/kindle/activity/AdLaunchHelper.getName();

    public AdLaunchHelper()
    {
    }

    private static AdLaunchType getAdLaunchType(Intent intent)
    {
        if (intent.hasCategory("amazon.intent.category.PHOTOS_FTUE"))
        {
            if (intent.hasExtra("addPhotosPage"))
            {
                return AdLaunchType.ADD_PHOTOS;
            } else
            {
                return AdLaunchType.FTUE;
            }
        }
        if (intent.hasCategory("amazon.intent.category.PHOTOS_COLLECTION"))
        {
            if (intent.hasExtra("cloudCollection"))
            {
                return AdLaunchType.CLOUD;
            }
            if (intent.hasExtra("deviceCollection"))
            {
                return AdLaunchType.DEVICE;
            }
        } else
        {
            if (intent.hasCategory("amazon.intent.category.PHOTOS_SETTINGS"))
            {
                return AdLaunchType.SETTINGS;
            }
            if (intent.hasCategory("amazon.intent.category.PHOTOS"))
            {
                if (intent.hasExtra("videoView"))
                {
                    return AdLaunchType.VIDEO;
                }
                if (intent.hasExtra("cameraRoll"))
                {
                    return AdLaunchType.CAMERA_ROLL;
                } else
                {
                    return AdLaunchType.ALL;
                }
            }
        }
        GLogger.d(TAG, "Could not determine launch type", new Object[0]);
        return null;
    }

    public static boolean isAdLaunch(Intent intent)
    {
        return intent.hasCategory("amazon.intent.category.AD");
    }

    public static void logLaunchMetric(LaunchSourceMetrics launchsourcemetrics, Intent intent)
    {
        intent = getAdLaunchType(intent);
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType = new int[AdLaunchType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.FTUE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.ADD_PHOTOS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.SETTINGS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.CLOUD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.DEVICE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.ALL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.VIDEO.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$activity$AdLaunchHelper$AdLaunchType[AdLaunchType.CAMERA_ROLL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.activity.AdLaunchHelper.AdLaunchType[intent.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToFTUE);
            return;

        case 2: // '\002'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToAddPhotosPage);
            return;

        case 3: // '\003'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToSettings);
            return;

        case 4: // '\004'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToCloudCollection);
            return;

        case 5: // '\005'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToDeviceCollection);
            return;

        case 6: // '\006'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToAllView);
            return;

        case 7: // '\007'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToVideoView);
            return;

        case 8: // '\b'
            launchsourcemetrics.trackEvent(LaunchSourceMetrics.MetricsEvent.AdToCameraRoll);
            break;
        }
    }

    public static void process(Intent intent)
    {
        AdLaunchType adlaunchtype = getAdLaunchType(intent);
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.activity.AdLaunchHelper.AdLaunchType[adlaunchtype.ordinal()])
        {
        case 3: // '\003'
        case 6: // '\006'
        default:
            return;

        case 2: // '\002'
            intent.putExtra("single_page_index", intent.getIntExtra("addPhotosPage", 0));
            intent.putExtra("START_AT_END", true);
            return;

        case 4: // '\004'
            intent.putExtra("tagType", TagType.FOLDER.toString());
            return;

        case 5: // '\005'
            intent.putExtra("tagType", TagType.LOCAL_FOLDER.toString());
            return;

        case 7: // '\007'
            intent.setType("video/*");
            break;
        }
    }

}
