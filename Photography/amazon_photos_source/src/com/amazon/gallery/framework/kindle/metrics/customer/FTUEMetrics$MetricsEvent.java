// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            FTUEMetrics

public static final class metricType extends Enum
{

    private static final EndFTUE $VALUES[];
    public static final EndFTUE AddFacebookPhotosClicked;
    public static final EndFTUE EmailLinkClicked;
    public static final EndFTUE EndFTUE;
    public static final EndFTUE FTUELaunched;
    public static final EndFTUE FacebookScreenDismissedBackButton;
    public static final EndFTUE FacebookScreenDismissedCloseButton;
    public static final EndFTUE FacebookScreenDismissedDoNotUseButton;
    public static final EndFTUE FacebookScreenDisplayed;
    public static final EndFTUE GetStartedClicked;
    public static final EndFTUE LearnMoreClicked;
    public static final EndFTUE MobileDismissedBackButton;
    public static final EndFTUE MobileDismissedCloseButton;
    public static final EndFTUE MobileDismissedDoNotUseButton;
    public static final EndFTUE MobileScreenDisplayed;
    public static final EndFTUE PCScreenDismissedBackButton;
    public static final EndFTUE PCScreenDismissedCloseButton;
    public static final EndFTUE PCScreenDismissedDoNotUseButton;
    public static final EndFTUE PCScreenDisplayed;
    public static final EndFTUE PhoneNumberEntered;
    public static final EndFTUE SendSMSClicked;
    public static final EndFTUE StartFTUE;
    public static final EndFTUE WelcomeDismissedCloseButton;
    private ype metricType;

    public static metricType valueOf(String s)
    {
        return (metricType)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/FTUEMetrics$MetricsEvent, s);
    }

    public static metricType[] values()
    {
        return (metricType[])$VALUES.clone();
    }

    ype getMetricType()
    {
        return metricType;
    }

    static 
    {
        FTUELaunched = new <init>("FTUELaunched", 0, ype.PMET);
        GetStartedClicked = new <init>("GetStartedClicked", 1, ype.PMET_CLICKSTREAM);
        LearnMoreClicked = new <init>("LearnMoreClicked", 2, ype.PMET_CLICKSTREAM);
        WelcomeDismissedCloseButton = new <init>("WelcomeDismissedCloseButton", 3, ype.PMET_CLICKSTREAM);
        MobileScreenDisplayed = new <init>("MobileScreenDisplayed", 4, ype.PMET);
        MobileDismissedBackButton = new <init>("MobileDismissedBackButton", 5, ype.PMET);
        MobileDismissedCloseButton = new <init>("MobileDismissedCloseButton", 6, ype.PMET_CLICKSTREAM);
        MobileDismissedDoNotUseButton = new <init>("MobileDismissedDoNotUseButton", 7, ype.PMET_CLICKSTREAM);
        SendSMSClicked = new <init>("SendSMSClicked", 8, ype.PMET_CLICKSTREAM);
        PhoneNumberEntered = new <init>("PhoneNumberEntered", 9, ype.PMET_CLICKSTREAM);
        PCScreenDisplayed = new <init>("PCScreenDisplayed", 10, ype.PMET);
        EmailLinkClicked = new <init>("EmailLinkClicked", 11, ype.PMET_CLICKSTREAM);
        PCScreenDismissedBackButton = new <init>("PCScreenDismissedBackButton", 12, ype.PMET);
        PCScreenDismissedCloseButton = new <init>("PCScreenDismissedCloseButton", 13, ype.PMET_CLICKSTREAM);
        PCScreenDismissedDoNotUseButton = new <init>("PCScreenDismissedDoNotUseButton", 14, ype.PMET_CLICKSTREAM);
        FacebookScreenDisplayed = new <init>("FacebookScreenDisplayed", 15, ype.PMET);
        AddFacebookPhotosClicked = new <init>("AddFacebookPhotosClicked", 16, ype.PMET_CLICKSTREAM);
        FacebookScreenDismissedBackButton = new <init>("FacebookScreenDismissedBackButton", 17, ype.PMET);
        FacebookScreenDismissedCloseButton = new <init>("FacebookScreenDismissedCloseButton", 18, ype.PMET_CLICKSTREAM);
        FacebookScreenDismissedDoNotUseButton = new <init>("FacebookScreenDismissedDoNotUseButton", 19, ype.PMET_CLICKSTREAM);
        StartFTUE = new <init>("StartFTUE", 20, ype.PMET);
        EndFTUE = new <init>("EndFTUE", 21, ype.PMET);
        $VALUES = (new .VALUES[] {
            FTUELaunched, GetStartedClicked, LearnMoreClicked, WelcomeDismissedCloseButton, MobileScreenDisplayed, MobileDismissedBackButton, MobileDismissedCloseButton, MobileDismissedDoNotUseButton, SendSMSClicked, PhoneNumberEntered, 
            PCScreenDisplayed, EmailLinkClicked, PCScreenDismissedBackButton, PCScreenDismissedCloseButton, PCScreenDismissedDoNotUseButton, FacebookScreenDisplayed, AddFacebookPhotosClicked, FacebookScreenDismissedBackButton, FacebookScreenDismissedCloseButton, FacebookScreenDismissedDoNotUseButton, 
            StartFTUE, EndFTUE
        });
    }

    private ype(String s, int i, ype ype)
    {
        super(s, i);
        metricType = ype;
    }
}
