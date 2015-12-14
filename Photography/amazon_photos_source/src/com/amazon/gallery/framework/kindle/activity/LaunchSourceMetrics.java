// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;

public class LaunchSourceMetrics extends ComponentProfiler
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AdToAddPhotosPage;
        public static final MetricsEvent AdToAllView;
        public static final MetricsEvent AdToCameraRoll;
        public static final MetricsEvent AdToCloudCollection;
        public static final MetricsEvent AdToDeviceCollection;
        public static final MetricsEvent AdToFTUE;
        public static final MetricsEvent AdToSettings;
        public static final MetricsEvent AdToVideoView;
        public static final MetricsEvent CameraToGallery;
        public static final MetricsEvent Carousel;
        public static final MetricsEvent Crop;
        public static final MetricsEvent GalleryToCamera;
        public static final MetricsEvent Misc;
        public static final MetricsEvent NewPromotionNotification;
        public static final MetricsEvent PhotoTab;
        public static final MetricsEvent PhotoViewMode;
        public static final MetricsEvent PickMode;
        public static final MetricsEvent VideoPlayMode;
        public static final MetricsEvent VideoTab;
        public static final MetricsEvent WallpaperPicker;
        public static final MetricsEvent WallpaperSetAndCrop;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/activity/LaunchSourceMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            Carousel = new MetricsEvent("Carousel", 0);
            PhotoTab = new MetricsEvent("PhotoTab", 1);
            VideoTab = new MetricsEvent("VideoTab", 2);
            PickMode = new MetricsEvent("PickMode", 3);
            VideoPlayMode = new MetricsEvent("VideoPlayMode", 4);
            PhotoViewMode = new MetricsEvent("PhotoViewMode", 5);
            GalleryToCamera = new MetricsEvent("GalleryToCamera", 6);
            CameraToGallery = new MetricsEvent("CameraToGallery", 7);
            Misc = new MetricsEvent("Misc", 8);
            NewPromotionNotification = new MetricsEvent("NewPromotionNotification", 9);
            AdToFTUE = new MetricsEvent("AdToFTUE", 10);
            AdToAddPhotosPage = new MetricsEvent("AdToAddPhotosPage", 11);
            AdToCloudCollection = new MetricsEvent("AdToCloudCollection", 12);
            AdToDeviceCollection = new MetricsEvent("AdToDeviceCollection", 13);
            AdToSettings = new MetricsEvent("AdToSettings", 14);
            AdToAllView = new MetricsEvent("AdToAllView", 15);
            AdToVideoView = new MetricsEvent("AdToVideoView", 16);
            AdToCameraRoll = new MetricsEvent("AdToCameraRoll", 17);
            WallpaperSetAndCrop = new MetricsEvent("WallpaperSetAndCrop", 18);
            WallpaperPicker = new MetricsEvent("WallpaperPicker", 19);
            Crop = new MetricsEvent("Crop", 20);
            $VALUES = (new MetricsEvent[] {
                Carousel, PhotoTab, VideoTab, PickMode, VideoPlayMode, PhotoViewMode, GalleryToCamera, CameraToGallery, Misc, NewPromotionNotification, 
                AdToFTUE, AdToAddPhotosPage, AdToCloudCollection, AdToDeviceCollection, AdToSettings, AdToAllView, AdToVideoView, AdToCameraRoll, WallpaperSetAndCrop, WallpaperPicker, 
                Crop
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public LaunchSourceMetrics(Profiler profiler)
    {
        super(profiler, com/amazon/gallery/framework/kindle/activity/LaunchSourceMetrics);
    }
}
