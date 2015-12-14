// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.metrics;


// Referenced classes of package com.amazon.gallery.framework.kindle.metrics:
//            UIClickMetrics

public static final class  extends Enum
{

    private static final ManageStorageSettings $VALUES[];
    public static final ManageStorageSettings AddAlbumToFavorite;
    public static final ManageStorageSettings CloudToggle;
    public static final ManageStorageSettings DeleteAlbum;
    public static final ManageStorageSettings DeleteMediaItem;
    public static final ManageStorageSettings DeviceToggle;
    public static final ManageStorageSettings DownloadAlbum;
    public static final ManageStorageSettings DownloadMediaItem;
    public static final ManageStorageSettings EditMediaItem;
    public static final ManageStorageSettings LeftPanelAddPhotos;
    public static final ManageStorageSettings LeftPanelAlbums;
    public static final ManageStorageSettings LeftPanelAllPhotos;
    public static final ManageStorageSettings LeftPanelAllVideos;
    public static final ManageStorageSettings LeftPanelCameraRoll;
    public static final ManageStorageSettings LeftPanelDebug;
    public static final ManageStorageSettings LeftPanelFolders;
    public static final ManageStorageSettings LeftPanelHelp;
    public static final ManageStorageSettings LeftPanelLocal;
    public static final ManageStorageSettings LeftPanelManageStorage;
    public static final ManageStorageSettings LeftPanelSettings;
    public static final ManageStorageSettings LeftPanelSources;
    public static final ManageStorageSettings LeftPanelThisDay;
    public static final ManageStorageSettings ManageStorageSettings;
    public static final ManageStorageSettings OpenCamera;
    public static final ManageStorageSettings PrintMediaItem;
    public static final ManageStorageSettings RemoveAlbumFromFavorite;
    public static final ManageStorageSettings RenameAlbum;
    public static final ManageStorageSettings SelectMediaItem;
    public static final ManageStorageSettings ShareMediaItem;
    public static final ManageStorageSettings UploadMediaItem;
    public static final ManageStorageSettings ViewInfoMediaItem;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/metrics/UIClickMetrics$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LeftPanelAllPhotos = new <init>("LeftPanelAllPhotos", 0);
        LeftPanelCameraRoll = new <init>("LeftPanelCameraRoll", 1);
        LeftPanelAllVideos = new <init>("LeftPanelAllVideos", 2);
        LeftPanelAlbums = new <init>("LeftPanelAlbums", 3);
        LeftPanelSources = new <init>("LeftPanelSources", 4);
        LeftPanelLocal = new <init>("LeftPanelLocal", 5);
        LeftPanelFolders = new <init>("LeftPanelFolders", 6);
        LeftPanelThisDay = new <init>("LeftPanelThisDay", 7);
        LeftPanelAddPhotos = new <init>("LeftPanelAddPhotos", 8);
        LeftPanelSettings = new <init>("LeftPanelSettings", 9);
        LeftPanelHelp = new <init>("LeftPanelHelp", 10);
        DeviceToggle = new <init>("DeviceToggle", 11);
        CloudToggle = new <init>("CloudToggle", 12);
        OpenCamera = new <init>("OpenCamera", 13);
        EditMediaItem = new <init>("EditMediaItem", 14);
        DownloadMediaItem = new <init>("DownloadMediaItem", 15);
        UploadMediaItem = new <init>("UploadMediaItem", 16);
        ShareMediaItem = new <init>("ShareMediaItem", 17);
        DeleteMediaItem = new <init>("DeleteMediaItem", 18);
        SelectMediaItem = new <init>("SelectMediaItem", 19);
        PrintMediaItem = new <init>("PrintMediaItem", 20);
        ViewInfoMediaItem = new <init>("ViewInfoMediaItem", 21);
        RenameAlbum = new <init>("RenameAlbum", 22);
        DeleteAlbum = new <init>("DeleteAlbum", 23);
        DownloadAlbum = new <init>("DownloadAlbum", 24);
        AddAlbumToFavorite = new <init>("AddAlbumToFavorite", 25);
        RemoveAlbumFromFavorite = new <init>("RemoveAlbumFromFavorite", 26);
        LeftPanelDebug = new <init>("LeftPanelDebug", 27);
        LeftPanelManageStorage = new <init>("LeftPanelManageStorage", 28);
        ManageStorageSettings = new <init>("ManageStorageSettings", 29);
        $VALUES = (new .VALUES[] {
            LeftPanelAllPhotos, LeftPanelCameraRoll, LeftPanelAllVideos, LeftPanelAlbums, LeftPanelSources, LeftPanelLocal, LeftPanelFolders, LeftPanelThisDay, LeftPanelAddPhotos, LeftPanelSettings, 
            LeftPanelHelp, DeviceToggle, CloudToggle, OpenCamera, EditMediaItem, DownloadMediaItem, UploadMediaItem, ShareMediaItem, DeleteMediaItem, SelectMediaItem, 
            PrintMediaItem, ViewInfoMediaItem, RenameAlbum, DeleteAlbum, DownloadAlbum, AddAlbumToFavorite, RemoveAlbumFromFavorite, LeftPanelDebug, LeftPanelManageStorage, ManageStorageSettings
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
