// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;

import android.os.SystemClock;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;

// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            FTUEMetricsHelper

public class FTUEMetrics extends ComponentProfiler
    implements FTUEMetricsHelper
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AddFacebookPhotosClicked;
        public static final MetricsEvent EmailLinkClicked;
        public static final MetricsEvent EndFTUE;
        public static final MetricsEvent FTUELaunched;
        public static final MetricsEvent FacebookScreenDismissedBackButton;
        public static final MetricsEvent FacebookScreenDismissedCloseButton;
        public static final MetricsEvent FacebookScreenDismissedDoNotUseButton;
        public static final MetricsEvent FacebookScreenDisplayed;
        public static final MetricsEvent GetStartedClicked;
        public static final MetricsEvent LearnMoreClicked;
        public static final MetricsEvent MobileDismissedBackButton;
        public static final MetricsEvent MobileDismissedCloseButton;
        public static final MetricsEvent MobileDismissedDoNotUseButton;
        public static final MetricsEvent MobileScreenDisplayed;
        public static final MetricsEvent PCScreenDismissedBackButton;
        public static final MetricsEvent PCScreenDismissedCloseButton;
        public static final MetricsEvent PCScreenDismissedDoNotUseButton;
        public static final MetricsEvent PCScreenDisplayed;
        public static final MetricsEvent PhoneNumberEntered;
        public static final MetricsEvent SendSMSClicked;
        public static final MetricsEvent StartFTUE;
        public static final MetricsEvent WelcomeDismissedCloseButton;
        private MetricsEventType metricType;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        MetricsEventType getMetricType()
        {
            return metricType;
        }

        static 
        {
            FTUELaunched = new MetricsEvent("FTUELaunched", 0, MetricsEventType.PMET);
            GetStartedClicked = new MetricsEvent("GetStartedClicked", 1, MetricsEventType.PMET_CLICKSTREAM);
            LearnMoreClicked = new MetricsEvent("LearnMoreClicked", 2, MetricsEventType.PMET_CLICKSTREAM);
            WelcomeDismissedCloseButton = new MetricsEvent("WelcomeDismissedCloseButton", 3, MetricsEventType.PMET_CLICKSTREAM);
            MobileScreenDisplayed = new MetricsEvent("MobileScreenDisplayed", 4, MetricsEventType.PMET);
            MobileDismissedBackButton = new MetricsEvent("MobileDismissedBackButton", 5, MetricsEventType.PMET);
            MobileDismissedCloseButton = new MetricsEvent("MobileDismissedCloseButton", 6, MetricsEventType.PMET_CLICKSTREAM);
            MobileDismissedDoNotUseButton = new MetricsEvent("MobileDismissedDoNotUseButton", 7, MetricsEventType.PMET_CLICKSTREAM);
            SendSMSClicked = new MetricsEvent("SendSMSClicked", 8, MetricsEventType.PMET_CLICKSTREAM);
            PhoneNumberEntered = new MetricsEvent("PhoneNumberEntered", 9, MetricsEventType.PMET_CLICKSTREAM);
            PCScreenDisplayed = new MetricsEvent("PCScreenDisplayed", 10, MetricsEventType.PMET);
            EmailLinkClicked = new MetricsEvent("EmailLinkClicked", 11, MetricsEventType.PMET_CLICKSTREAM);
            PCScreenDismissedBackButton = new MetricsEvent("PCScreenDismissedBackButton", 12, MetricsEventType.PMET);
            PCScreenDismissedCloseButton = new MetricsEvent("PCScreenDismissedCloseButton", 13, MetricsEventType.PMET_CLICKSTREAM);
            PCScreenDismissedDoNotUseButton = new MetricsEvent("PCScreenDismissedDoNotUseButton", 14, MetricsEventType.PMET_CLICKSTREAM);
            FacebookScreenDisplayed = new MetricsEvent("FacebookScreenDisplayed", 15, MetricsEventType.PMET);
            AddFacebookPhotosClicked = new MetricsEvent("AddFacebookPhotosClicked", 16, MetricsEventType.PMET_CLICKSTREAM);
            FacebookScreenDismissedBackButton = new MetricsEvent("FacebookScreenDismissedBackButton", 17, MetricsEventType.PMET);
            FacebookScreenDismissedCloseButton = new MetricsEvent("FacebookScreenDismissedCloseButton", 18, MetricsEventType.PMET_CLICKSTREAM);
            FacebookScreenDismissedDoNotUseButton = new MetricsEvent("FacebookScreenDismissedDoNotUseButton", 19, MetricsEventType.PMET_CLICKSTREAM);
            StartFTUE = new MetricsEvent("StartFTUE", 20, MetricsEventType.PMET);
            EndFTUE = new MetricsEvent("EndFTUE", 21, MetricsEventType.PMET);
            $VALUES = (new MetricsEvent[] {
                FTUELaunched, GetStartedClicked, LearnMoreClicked, WelcomeDismissedCloseButton, MobileScreenDisplayed, MobileDismissedBackButton, MobileDismissedCloseButton, MobileDismissedDoNotUseButton, SendSMSClicked, PhoneNumberEntered, 
                PCScreenDisplayed, EmailLinkClicked, PCScreenDismissedBackButton, PCScreenDismissedCloseButton, PCScreenDismissedDoNotUseButton, FacebookScreenDisplayed, AddFacebookPhotosClicked, FacebookScreenDismissedBackButton, FacebookScreenDismissedCloseButton, FacebookScreenDismissedDoNotUseButton, 
                StartFTUE, EndFTUE
            });
        }

        private MetricsEvent(String s, int i, MetricsEventType metricseventtype)
        {
            super(s, i);
            metricType = metricseventtype;
        }
    }

    private static final class MetricsEventType extends Enum
    {

        private static final MetricsEventType $VALUES[];
        public static final MetricsEventType PMET;
        public static final MetricsEventType PMET_CLICKSTREAM;

        public static MetricsEventType valueOf(String s)
        {
            return (MetricsEventType)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetrics$MetricsEventType, s);
        }

        public static MetricsEventType[] values()
        {
            return (MetricsEventType[])$VALUES.clone();
        }

        static 
        {
            PMET = new MetricsEventType("PMET", 0);
            PMET_CLICKSTREAM = new MetricsEventType("PMET_CLICKSTREAM", 1);
            $VALUES = (new MetricsEventType[] {
                PMET, PMET_CLICKSTREAM
            });
        }

        private MetricsEventType(String s, int i)
        {
            super(s, i);
        }
    }


    public FTUEMetrics(Profiler profiler)
    {
        super(profiler, com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetrics);
    }

    public void logClickEvent(FTUEMetricsHelper.ClickSource clicksource, long l)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType[];
            static final int $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType = new int[MetricsEventType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType[MetricsEventType.PMET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetrics$MetricsEventType[MetricsEventType.PMET_CLICKSTREAM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource = new int[FTUEMetricsHelper.ClickSource.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[FTUEMetricsHelper.ClickSource.FACEBOOK_CLICK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[FTUEMetricsHelper.ClickSource.DESKTOP_CLICK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[FTUEMetricsHelper.ClickSource.MOBILE_CLICK.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetricsHelper.ClickSource[clicksource.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            trackTimer(MetricsEvent.AddFacebookPhotosClicked, SystemClock.uptimeMillis() - l);
            return;

        case 2: // '\002'
            trackTimer(MetricsEvent.EmailLinkClicked, SystemClock.uptimeMillis() - l);
            return;

        case 3: // '\003'
            trackTimer(MetricsEvent.SendSMSClicked, SystemClock.uptimeMillis() - l);
            break;
        }
    }

    public void trackTimer(Enum enum, long l)
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEventType[((MetricsEvent)enum).getMetricType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            super.trackTimer(enum, l);
            return;

        case 2: // '\002'
            trackTimer(enum, l, ClickstreamEventHelper.createClickstreamExtra("FTUE-Event", HitType.PAGE_TOUCH));
            break;
        }
    }
}
