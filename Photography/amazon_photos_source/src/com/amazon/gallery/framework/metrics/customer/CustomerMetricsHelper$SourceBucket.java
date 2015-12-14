// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.customer;


// Referenced classes of package com.amazon.gallery.framework.metrics.customer:
//            CustomerMetricsHelper

static final class  extends Enum
{

    private static final Cloud $VALUES[];
    public static final Cloud Attachments;
    public static final Cloud CameraRoll;
    public static final Cloud Cloud;
    public static final Cloud Downloads;
    public static final Cloud FreeTime;
    public static final Cloud Personal;
    public static final Cloud Screenshots;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/metrics/customer/CustomerMetricsHelper$SourceBucket, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CameraRoll = new <init>("CameraRoll", 0);
        FreeTime = new <init>("FreeTime", 1);
        Screenshots = new <init>("Screenshots", 2);
        Attachments = new <init>("Attachments", 3);
        Downloads = new <init>("Downloads", 4);
        Personal = new <init>("Personal", 5);
        Cloud = new <init>("Cloud", 6);
        $VALUES = (new .VALUES[] {
            CameraRoll, FreeTime, Screenshots, Attachments, Downloads, Personal, Cloud
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
