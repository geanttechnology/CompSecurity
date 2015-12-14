// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics.customer:
//            AddPhotosMetrics

public static final class  extends Enum
{

    private static final TransferThroughUSBClicked $VALUES[];
    public static final TransferThroughUSBClicked AddFacebookClicked;
    public static final TransferThroughUSBClicked AddPhotosClicked;
    public static final TransferThroughUSBClicked FacebookOptionClicked;
    public static final TransferThroughUSBClicked MobileDeviceOptionClicked;
    public static final TransferThroughUSBClicked PCOrMacOptionClicked;
    public static final TransferThroughUSBClicked SendEmailClicked;
    public static final TransferThroughUSBClicked SendSMSClicked;
    public static final TransferThroughUSBClicked TakePhotoOptionClicked;
    public static final TransferThroughUSBClicked TransferThroughUSBClicked;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/customer/AddPhotosMetrics$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AddPhotosClicked = new <init>("AddPhotosClicked", 0);
        TakePhotoOptionClicked = new <init>("TakePhotoOptionClicked", 1);
        MobileDeviceOptionClicked = new <init>("MobileDeviceOptionClicked", 2);
        SendSMSClicked = new <init>("SendSMSClicked", 3);
        PCOrMacOptionClicked = new <init>("PCOrMacOptionClicked", 4);
        SendEmailClicked = new <init>("SendEmailClicked", 5);
        FacebookOptionClicked = new <init>("FacebookOptionClicked", 6);
        AddFacebookClicked = new <init>("AddFacebookClicked", 7);
        TransferThroughUSBClicked = new <init>("TransferThroughUSBClicked", 8);
        $VALUES = (new .VALUES[] {
            AddPhotosClicked, TakePhotoOptionClicked, MobileDeviceOptionClicked, SendSMSClicked, PCOrMacOptionClicked, SendEmailClicked, FacebookOptionClicked, AddFacebookClicked, TransferThroughUSBClicked
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
