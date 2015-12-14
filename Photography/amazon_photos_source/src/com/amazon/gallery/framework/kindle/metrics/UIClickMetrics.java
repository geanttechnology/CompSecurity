// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;

public class UIClickMetrics extends ComponentProfiler
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent AddAlbumToFavorite;
        public static final MetricsEvent CloudToggle;
        public static final MetricsEvent DeleteAlbum;
        public static final MetricsEvent DeleteMediaItem;
        public static final MetricsEvent DeviceToggle;
        public static final MetricsEvent DownloadAlbum;
        public static final MetricsEvent DownloadMediaItem;
        public static final MetricsEvent EditMediaItem;
        public static final MetricsEvent LeftPanelAddPhotos;
        public static final MetricsEvent LeftPanelAlbums;
        public static final MetricsEvent LeftPanelAllPhotos;
        public static final MetricsEvent LeftPanelAllVideos;
        public static final MetricsEvent LeftPanelCameraRoll;
        public static final MetricsEvent LeftPanelDebug;
        public static final MetricsEvent LeftPanelFolders;
        public static final MetricsEvent LeftPanelHelp;
        public static final MetricsEvent LeftPanelLocal;
        public static final MetricsEvent LeftPanelManageStorage;
        public static final MetricsEvent LeftPanelSettings;
        public static final MetricsEvent LeftPanelSources;
        public static final MetricsEvent LeftPanelThisDay;
        public static final MetricsEvent ManageStorageSettings;
        public static final MetricsEvent OpenCamera;
        public static final MetricsEvent PrintMediaItem;
        public static final MetricsEvent RemoveAlbumFromFavorite;
        public static final MetricsEvent RenameAlbum;
        public static final MetricsEvent SelectMediaItem;
        public static final MetricsEvent ShareMediaItem;
        public static final MetricsEvent UploadMediaItem;
        public static final MetricsEvent ViewInfoMediaItem;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/UIClickMetrics$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            LeftPanelAllPhotos = new MetricsEvent("LeftPanelAllPhotos", 0);
            LeftPanelCameraRoll = new MetricsEvent("LeftPanelCameraRoll", 1);
            LeftPanelAllVideos = new MetricsEvent("LeftPanelAllVideos", 2);
            LeftPanelAlbums = new MetricsEvent("LeftPanelAlbums", 3);
            LeftPanelSources = new MetricsEvent("LeftPanelSources", 4);
            LeftPanelLocal = new MetricsEvent("LeftPanelLocal", 5);
            LeftPanelFolders = new MetricsEvent("LeftPanelFolders", 6);
            LeftPanelThisDay = new MetricsEvent("LeftPanelThisDay", 7);
            LeftPanelAddPhotos = new MetricsEvent("LeftPanelAddPhotos", 8);
            LeftPanelSettings = new MetricsEvent("LeftPanelSettings", 9);
            LeftPanelHelp = new MetricsEvent("LeftPanelHelp", 10);
            DeviceToggle = new MetricsEvent("DeviceToggle", 11);
            CloudToggle = new MetricsEvent("CloudToggle", 12);
            OpenCamera = new MetricsEvent("OpenCamera", 13);
            EditMediaItem = new MetricsEvent("EditMediaItem", 14);
            DownloadMediaItem = new MetricsEvent("DownloadMediaItem", 15);
            UploadMediaItem = new MetricsEvent("UploadMediaItem", 16);
            ShareMediaItem = new MetricsEvent("ShareMediaItem", 17);
            DeleteMediaItem = new MetricsEvent("DeleteMediaItem", 18);
            SelectMediaItem = new MetricsEvent("SelectMediaItem", 19);
            PrintMediaItem = new MetricsEvent("PrintMediaItem", 20);
            ViewInfoMediaItem = new MetricsEvent("ViewInfoMediaItem", 21);
            RenameAlbum = new MetricsEvent("RenameAlbum", 22);
            DeleteAlbum = new MetricsEvent("DeleteAlbum", 23);
            DownloadAlbum = new MetricsEvent("DownloadAlbum", 24);
            AddAlbumToFavorite = new MetricsEvent("AddAlbumToFavorite", 25);
            RemoveAlbumFromFavorite = new MetricsEvent("RemoveAlbumFromFavorite", 26);
            LeftPanelDebug = new MetricsEvent("LeftPanelDebug", 27);
            LeftPanelManageStorage = new MetricsEvent("LeftPanelManageStorage", 28);
            ManageStorageSettings = new MetricsEvent("ManageStorageSettings", 29);
            $VALUES = (new MetricsEvent[] {
                LeftPanelAllPhotos, LeftPanelCameraRoll, LeftPanelAllVideos, LeftPanelAlbums, LeftPanelSources, LeftPanelLocal, LeftPanelFolders, LeftPanelThisDay, LeftPanelAddPhotos, LeftPanelSettings, 
                LeftPanelHelp, DeviceToggle, CloudToggle, OpenCamera, EditMediaItem, DownloadMediaItem, UploadMediaItem, ShareMediaItem, DeleteMediaItem, SelectMediaItem, 
                PrintMediaItem, ViewInfoMediaItem, RenameAlbum, DeleteAlbum, DownloadAlbum, AddAlbumToFavorite, RemoveAlbumFromFavorite, LeftPanelDebug, LeftPanelManageStorage, ManageStorageSettings
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public UIClickMetrics(Profiler profiler)
    {
        super(profiler, com/amazon/gallery/framework/kindle/metrics/UIClickMetrics);
    }
}
