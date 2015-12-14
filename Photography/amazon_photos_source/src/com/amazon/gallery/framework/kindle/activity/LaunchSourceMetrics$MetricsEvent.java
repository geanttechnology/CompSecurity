// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;


// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            LaunchSourceMetrics

public static final class  extends Enum
{

    private static final Crop $VALUES[];
    public static final Crop AdToAddPhotosPage;
    public static final Crop AdToAllView;
    public static final Crop AdToCameraRoll;
    public static final Crop AdToCloudCollection;
    public static final Crop AdToDeviceCollection;
    public static final Crop AdToFTUE;
    public static final Crop AdToSettings;
    public static final Crop AdToVideoView;
    public static final Crop CameraToGallery;
    public static final Crop Carousel;
    public static final Crop Crop;
    public static final Crop GalleryToCamera;
    public static final Crop Misc;
    public static final Crop NewPromotionNotification;
    public static final Crop PhotoTab;
    public static final Crop PhotoViewMode;
    public static final Crop PickMode;
    public static final Crop VideoPlayMode;
    public static final Crop VideoTab;
    public static final Crop WallpaperPicker;
    public static final Crop WallpaperSetAndCrop;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/activity/LaunchSourceMetrics$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Carousel = new <init>("Carousel", 0);
        PhotoTab = new <init>("PhotoTab", 1);
        VideoTab = new <init>("VideoTab", 2);
        PickMode = new <init>("PickMode", 3);
        VideoPlayMode = new <init>("VideoPlayMode", 4);
        PhotoViewMode = new <init>("PhotoViewMode", 5);
        GalleryToCamera = new <init>("GalleryToCamera", 6);
        CameraToGallery = new <init>("CameraToGallery", 7);
        Misc = new <init>("Misc", 8);
        NewPromotionNotification = new <init>("NewPromotionNotification", 9);
        AdToFTUE = new <init>("AdToFTUE", 10);
        AdToAddPhotosPage = new <init>("AdToAddPhotosPage", 11);
        AdToCloudCollection = new <init>("AdToCloudCollection", 12);
        AdToDeviceCollection = new <init>("AdToDeviceCollection", 13);
        AdToSettings = new <init>("AdToSettings", 14);
        AdToAllView = new <init>("AdToAllView", 15);
        AdToVideoView = new <init>("AdToVideoView", 16);
        AdToCameraRoll = new <init>("AdToCameraRoll", 17);
        WallpaperSetAndCrop = new <init>("WallpaperSetAndCrop", 18);
        WallpaperPicker = new <init>("WallpaperPicker", 19);
        Crop = new <init>("Crop", 20);
        $VALUES = (new .VALUES[] {
            Carousel, PhotoTab, VideoTab, PickMode, VideoPlayMode, PhotoViewMode, GalleryToCamera, CameraToGallery, Misc, NewPromotionNotification, 
            AdToFTUE, AdToAddPhotosPage, AdToCloudCollection, AdToDeviceCollection, AdToSettings, AdToAllView, AdToVideoView, AdToCameraRoll, WallpaperSetAndCrop, WallpaperPicker, 
            Crop
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
