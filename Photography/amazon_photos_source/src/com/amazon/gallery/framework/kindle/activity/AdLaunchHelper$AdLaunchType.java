// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;


// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            AdLaunchHelper

private static final class  extends Enum
{

    private static final CAMERA_ROLL $VALUES[];
    public static final CAMERA_ROLL ADD_PHOTOS;
    public static final CAMERA_ROLL ALL;
    public static final CAMERA_ROLL CAMERA_ROLL;
    public static final CAMERA_ROLL CLOUD;
    public static final CAMERA_ROLL DEVICE;
    public static final CAMERA_ROLL FTUE;
    public static final CAMERA_ROLL SETTINGS;
    public static final CAMERA_ROLL VIDEO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/activity/AdLaunchHelper$AdLaunchType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FTUE = new <init>("FTUE", 0);
        ADD_PHOTOS = new <init>("ADD_PHOTOS", 1);
        SETTINGS = new <init>("SETTINGS", 2);
        CLOUD = new <init>("CLOUD", 3);
        DEVICE = new <init>("DEVICE", 4);
        ALL = new <init>("ALL", 5);
        VIDEO = new <init>("VIDEO", 6);
        CAMERA_ROLL = new <init>("CAMERA_ROLL", 7);
        $VALUES = (new .VALUES[] {
            FTUE, ADD_PHOTOS, SETTINGS, CLOUD, DEVICE, ALL, VIDEO, CAMERA_ROLL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
