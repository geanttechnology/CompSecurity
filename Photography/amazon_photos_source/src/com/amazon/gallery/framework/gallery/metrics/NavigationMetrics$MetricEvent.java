// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.metrics;


// Referenced classes of package com.amazon.gallery.framework.gallery.metrics:
//            NavigationMetrics

public static final class  extends Enum
{

    private static final TimeToLoadScene $VALUES[];
    public static final TimeToLoadScene CameraLaunchedFromApp;
    public static final TimeToLoadScene PhotoViewed;
    public static final TimeToLoadScene ScreenRotation;
    public static final TimeToLoadScene TimeInAll;
    public static final TimeToLoadScene TimeInCameraRoll;
    public static final TimeToLoadScene TimeInCloudCollection;
    public static final TimeToLoadScene TimeInCloudDrive;
    public static final TimeToLoadScene TimeInDevice;
    public static final TimeToLoadScene TimeInDeviceCollection;
    public static final TimeToLoadScene TimeInVideos;
    public static final TimeToLoadScene TimeToLoadHighResolutionInSingle;
    public static final TimeToLoadScene TimeToLoadScene;
    public static final TimeToLoadScene VideoViewed;
    public static final TimeToLoadScene ViewAdjacentPhoto;
    public static final TimeToLoadScene ViewCollection;
    public static final TimeToLoadScene ViewPhoto;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/metrics/NavigationMetrics$MetricEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ViewCollection = new <init>("ViewCollection", 0);
        ViewPhoto = new <init>("ViewPhoto", 1);
        ViewAdjacentPhoto = new <init>("ViewAdjacentPhoto", 2);
        ScreenRotation = new <init>("ScreenRotation", 3);
        TimeInAll = new <init>("TimeInAll", 4);
        TimeInVideos = new <init>("TimeInVideos", 5);
        TimeInCameraRoll = new <init>("TimeInCameraRoll", 6);
        TimeInDeviceCollection = new <init>("TimeInDeviceCollection", 7);
        TimeInCloudCollection = new <init>("TimeInCloudCollection", 8);
        TimeInCloudDrive = new <init>("TimeInCloudDrive", 9);
        TimeInDevice = new <init>("TimeInDevice", 10);
        PhotoViewed = new <init>("PhotoViewed", 11);
        VideoViewed = new <init>("VideoViewed", 12);
        CameraLaunchedFromApp = new <init>("CameraLaunchedFromApp", 13);
        TimeToLoadHighResolutionInSingle = new <init>("TimeToLoadHighResolutionInSingle", 14);
        TimeToLoadScene = new <init>("TimeToLoadScene", 15);
        $VALUES = (new .VALUES[] {
            ViewCollection, ViewPhoto, ViewAdjacentPhoto, ScreenRotation, TimeInAll, TimeInVideos, TimeInCameraRoll, TimeInDeviceCollection, TimeInCloudCollection, TimeInCloudDrive, 
            TimeInDevice, PhotoViewed, VideoViewed, CameraLaunchedFromApp, TimeToLoadHighResolutionInSingle, TimeToLoadScene
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
