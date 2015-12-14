// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;

// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            FTUEMetricsHelper

public class AddPhotosMetrics extends ComponentProfiler
    implements FTUEMetricsHelper
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AddFacebookClicked;
        public static final MetricsEvent AddPhotosClicked;
        public static final MetricsEvent FacebookOptionClicked;
        public static final MetricsEvent MobileDeviceOptionClicked;
        public static final MetricsEvent PCOrMacOptionClicked;
        public static final MetricsEvent SendEmailClicked;
        public static final MetricsEvent SendSMSClicked;
        public static final MetricsEvent TakePhotoOptionClicked;
        public static final MetricsEvent TransferThroughUSBClicked;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/AddPhotosMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            AddPhotosClicked = new MetricsEvent("AddPhotosClicked", 0);
            TakePhotoOptionClicked = new MetricsEvent("TakePhotoOptionClicked", 1);
            MobileDeviceOptionClicked = new MetricsEvent("MobileDeviceOptionClicked", 2);
            SendSMSClicked = new MetricsEvent("SendSMSClicked", 3);
            PCOrMacOptionClicked = new MetricsEvent("PCOrMacOptionClicked", 4);
            SendEmailClicked = new MetricsEvent("SendEmailClicked", 5);
            FacebookOptionClicked = new MetricsEvent("FacebookOptionClicked", 6);
            AddFacebookClicked = new MetricsEvent("AddFacebookClicked", 7);
            TransferThroughUSBClicked = new MetricsEvent("TransferThroughUSBClicked", 8);
            $VALUES = (new MetricsEvent[] {
                AddPhotosClicked, TakePhotoOptionClicked, MobileDeviceOptionClicked, SendSMSClicked, PCOrMacOptionClicked, SendEmailClicked, FacebookOptionClicked, AddFacebookClicked, TransferThroughUSBClicked
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public AddPhotosMetrics(Profiler profiler)
    {
        super(profiler, com/amazon/gallery/framework/kindle/metrics/customer/AddPhotosMetrics);
    }

    public void logClickEvent(FTUEMetricsHelper.ClickSource clicksource, long l)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$metrics$customer$FTUEMetricsHelper$ClickSource[];

            static 
            {
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
            trackEvent(MetricsEvent.AddFacebookClicked);
            return;

        case 2: // '\002'
            trackEvent(MetricsEvent.SendEmailClicked);
            return;

        case 3: // '\003'
            trackEvent(MetricsEvent.SendSMSClicked);
            break;
        }
    }
}
