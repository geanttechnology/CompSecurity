// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;

import java.util.HashMap;
import java.util.Map;

public final class CustomerMetricEvent extends Enum
{

    private static final CustomerMetricEvent $VALUES[];
    public static final CustomerMetricEvent ADD_LOCAL_FILE;
    public static final CustomerMetricEvent ALBUMS_ADD_DYNAMIC;
    public static final CustomerMetricEvent ALBUMS_ADD_PHOTOS;
    public static final CustomerMetricEvent ALBUMS_ADD_PHOTOS_ERROR;
    public static final CustomerMetricEvent ALBUMS_ADD_PHOTOS_TIME;
    public static final CustomerMetricEvent ALBUMS_ALBUMS_VIEW_ALL;
    public static final CustomerMetricEvent ALBUMS_ALBUM_VIEW_ALL;
    public static final CustomerMetricEvent ALBUMS_CREATE_PHOTO_ALBUM;
    public static final CustomerMetricEvent ALBUMS_CREATE_PHOTO_ALBUM_ERROR;
    public static final CustomerMetricEvent ALBUMS_CREATE_PHOTO_ALBUM_TIME;
    public static final CustomerMetricEvent ALBUMS_DELETE_PHOTO_ALBUM;
    public static final CustomerMetricEvent ALBUMS_DELETE_PHOTO_ALBUM_ERROR;
    public static final CustomerMetricEvent ALBUMS_DELETE_PHOTO_ALBUM_TIME;
    public static final CustomerMetricEvent ALBUMS_DELETE_PHOTO_ALBUM_UNDO;
    public static final CustomerMetricEvent ALBUMS_DELETE_PHOTO_ALBUM_UNDO_ERROR;
    public static final CustomerMetricEvent ALBUMS_FOLDER_MIGRATIONS_VIEW_ALL;
    public static final CustomerMetricEvent ALBUMS_FOLDER_MIGRATION_VIEW_ALL;
    public static final CustomerMetricEvent ALBUMS_PHOTOS_ALBUMS_LETTER_CLOSE;
    public static final CustomerMetricEvent ALBUMS_PHOTOS_ALBUMS_LETTER_VIEW;
    public static final CustomerMetricEvent ALBUMS_REMOVE_DYNAMIC;
    public static final CustomerMetricEvent ALBUMS_REMOVE_PHOTOS;
    public static final CustomerMetricEvent ALBUMS_REMOVE_PHOTOS_ERROR;
    public static final CustomerMetricEvent ALBUMS_REMOVE_PHOTOS_TIME;
    public static final CustomerMetricEvent ALBUMS_REMOVE_PHOTOS_UNDO;
    public static final CustomerMetricEvent ALBUMS_REMOVE_PHOTOS_UNDO_ERROR;
    public static final CustomerMetricEvent ALBUMS_RENAME_PHOTO_ALBUM;
    public static final CustomerMetricEvent ALBUMS_RENAME_PHOTO_ALBUM_ERROR;
    public static final CustomerMetricEvent ALBUMS_RENAME_PHOTO_ALBUM_TIME;
    public static final CustomerMetricEvent ALBUMS_RENAME_PHOTO_ALBUM_UNDO;
    public static final CustomerMetricEvent ALBUMS_RENAME_PHOTO_ALBUM_UNDO_ERROR;
    public static final CustomerMetricEvent ALBUMS_SET_PHOTO_ALBUM_COVER;
    public static final CustomerMetricEvent ALBUMS_SET_PHOTO_ALBUM_COVER_ERROR;
    public static final CustomerMetricEvent ALBUMS_SET_PHOTO_ALBUM_COVER_TIME;
    public static final CustomerMetricEvent ALBUMS_SHARE_PHOTO_ALBUM;
    public static final CustomerMetricEvent ALBUMS_SHARE_PHOTO_ALBUM_ERROR;
    public static final CustomerMetricEvent ALBUMS_SHARE_PHOTO_ALBUM_TIME;
    public static final CustomerMetricEvent ALBUMS_VIEW_ALBUM_INFO;
    public static final CustomerMetricEvent ALBUMS_VIEW_ALBUM_INFO_TIME;
    public static final CustomerMetricEvent ALL_VIEW_DATE_TAKEN_TOGGLED;
    public static final CustomerMetricEvent ALL_VIEW_DATE_UPLOADED_TOGGLED;
    public static final CustomerMetricEvent APP_DOWNLOAD;
    public static final CustomerMetricEvent APP_LAUNCHED;
    public static final CustomerMetricEvent AUTO_SAVE_EDITED_FILE;
    public static final CustomerMetricEvent AUTO_SAVE_FILE;
    public static final CustomerMetricEvent AUTO_UPLOAD_DISABLED_FIRST_START;
    public static final CustomerMetricEvent AUTO_UPLOAD_ENABLED_FIRST_START;
    public static final CustomerMetricEvent CAMERA_ROLL_NEWEST_FIRST_TOGGLED;
    public static final CustomerMetricEvent CAMERA_ROLL_OLDEST_FIRST_TOGGLED;
    public static final CustomerMetricEvent CLIENT_FIRST_START;
    public static final CustomerMetricEvent COLLECTION_NEWEST_FIRST_TOGGLED;
    public static final CustomerMetricEvent COLLECTION_OLDEST_FIRST_TOGGLED;
    public static final CustomerMetricEvent DELETE_FILE;
    public static final CustomerMetricEvent DISABLE_AUTO_PHOTO_SAVE;
    public static final CustomerMetricEvent DISABLE_AUTO_VIDEO_SAVE;
    public static final CustomerMetricEvent ENABLE_AUTO_PHOTO_SAVE;
    public static final CustomerMetricEvent ENABLE_AUTO_VIDEO_SAVE;
    public static final CustomerMetricEvent END_FTUE;
    public static final CustomerMetricEvent END_VIDEO;
    public static final CustomerMetricEvent FACEBOOK_IMPORT;
    private static final Map MAPPING;
    public static final CustomerMetricEvent PHOTOS_DOWNLOAD_PHOTO;
    public static final CustomerMetricEvent PHOTOS_VIEW_ALBUM;
    public static final CustomerMetricEvent PHOTOS_VIEW_PHOTO;
    public static final CustomerMetricEvent PRELOAD_VIDEO;
    public static final CustomerMetricEvent REBUFFER_VIDEO;
    public static final CustomerMetricEvent REFFERED_APP_FIRST_SIGNIN;
    public static final CustomerMetricEvent SESSION_END;
    public static final CustomerMetricEvent SESSION_START;
    public static final CustomerMetricEvent SHARE_FILE;
    public static final CustomerMetricEvent START_FTUE;
    public static final CustomerMetricEvent START_VIDEO;
    public static final CustomerMetricEvent TAG_ALBUM_NAME_TOGGLED;
    public static final CustomerMetricEvent TAG_DATE_TAKEN_TOGGLED;
    public static final CustomerMetricEvent THIS_DAY_BANNER_DISPLAY;
    public static final CustomerMetricEvent THIS_DAY_BANNER_OPEN;
    public static final CustomerMetricEvent THIS_DAY_NOTIFICATIONS_TOGGLE;
    public static final CustomerMetricEvent THIS_DAY_OPEN_NOTIFICATION;
    public static final CustomerMetricEvent THIS_DAY_POST_NOTIFICATION;
    public static final CustomerMetricEvent THIS_DAY_SHUFFLE_VIEW_SINGLE;
    public static final CustomerMetricEvent THIS_DAY_VIEW_ALL;
    public static final CustomerMetricEvent THIS_DAY_YEAR_VIEW_ALL;
    public static final CustomerMetricEvent THIS_DAY_YEAR_VIEW_SINGLE;
    public static final CustomerMetricEvent THIS_WEEK_YEAR_VIEW_ALL;
    public static final CustomerMetricEvent THIS_WEEK_YEAR_VIEW_SINGLE;
    public static final CustomerMetricEvent UPLOAD_FILE;
    public static final CustomerMetricEvent VIDEO_DATE_TAKEN_TOGGLED;
    public static final CustomerMetricEvent VIDEO_DATE_UPLOADED_TOGGLED;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_DELETE;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_DOWNLOAD;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_EDIT;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_INFO;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_PRINT;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_SHARE;
    public static final CustomerMetricEvent WHISPER_PLAY_ACTION_UPLOAD;
    public static final CustomerMetricEvent WHISPER_PLAY_CONNECT;
    public static final CustomerMetricEvent WHISPER_PLAY_CONNECTION_STATUS_FAIL;
    public static final CustomerMetricEvent WHISPER_PLAY_CONNECTION_STATUS_NO_DEVICE;
    public static final CustomerMetricEvent WHISPER_PLAY_CONNECTION_STATUS_NO_PERMISSION;
    public static final CustomerMetricEvent WHISPER_PLAY_CONNECTION_STATUS_SUCCESS;
    public static final CustomerMetricEvent WHISPER_PLAY_CONNECTION_STATUS_TIME_OUT;
    public static final CustomerMetricEvent WHISPER_PLAY_DISCONNECT;
    public static final CustomerMetricEvent WHISPER_PLAY_PHOTO_FLUNG_MANUAL;
    public static final CustomerMetricEvent WHISPER_PLAY_PHOTO_FLUNG_SLIDE_SHOW;
    public static final CustomerMetricEvent WHISPER_PLAY_SLIDE_SHOW_END;
    public static final CustomerMetricEvent WHISPER_PLAY_SLIDE_SHOW_START;
    public static final CustomerMetricEvent WHISPER_PLAY_VIDEO_FLUNG_MANUAL;
    public static final CustomerMetricEvent WHISPER_PLAY_VIDEO_FLUNG_SLIDE_SHOW;
    private final String customerMetricEvent;
    private final String pmetMetricEvent;

    private CustomerMetricEvent(String s, int i, String s1)
    {
        this(s, i, s1, s1);
    }

    private CustomerMetricEvent(String s, int i, String s1, String s2)
    {
        super(s, i);
        customerMetricEvent = s1;
        pmetMetricEvent = s2;
    }

    public static String getCustomerMetricEventName(String s)
    {
        return (String)MAPPING.get(s);
    }

    public static CustomerMetricEvent valueOf(String s)
    {
        return (CustomerMetricEvent)Enum.valueOf(com/amazon/gallery/foundation/metrics/customer/CustomerMetricEvent, s);
    }

    public static CustomerMetricEvent[] values()
    {
        return (CustomerMetricEvent[])$VALUES.clone();
    }

    public String getEventName()
    {
        return customerMetricEvent;
    }

    static 
    {
        PHOTOS_VIEW_ALBUM = new CustomerMetricEvent("PHOTOS_VIEW_ALBUM", 0, "PhotosViewAlbum", "ViewedCollections");
        PHOTOS_VIEW_PHOTO = new CustomerMetricEvent("PHOTOS_VIEW_PHOTO", 1, "PhotosViewPhoto", "ViewedItems");
        APP_LAUNCHED = new CustomerMetricEvent("APP_LAUNCHED", 2, "AppLaunched");
        CLIENT_FIRST_START = new CustomerMetricEvent("CLIENT_FIRST_START", 3, "ClientFirstStart");
        AUTO_UPLOAD_ENABLED_FIRST_START = new CustomerMetricEvent("AUTO_UPLOAD_ENABLED_FIRST_START", 4, "FirstTimeAutoUploadEnabled");
        AUTO_UPLOAD_DISABLED_FIRST_START = new CustomerMetricEvent("AUTO_UPLOAD_DISABLED_FIRST_START", 5, "FirstTimeAutoUploadDisabled");
        START_VIDEO = new CustomerMetricEvent("START_VIDEO", 6, "StartVideo");
        END_VIDEO = new CustomerMetricEvent("END_VIDEO", 7, "EndVideo");
        AUTO_SAVE_FILE = new CustomerMetricEvent("AUTO_SAVE_FILE", 8, "AutoSaveFile");
        AUTO_SAVE_EDITED_FILE = new CustomerMetricEvent("AUTO_SAVE_EDITED_FILE", 9, "AutoSaveEditedFile");
        ENABLE_AUTO_PHOTO_SAVE = new CustomerMetricEvent("ENABLE_AUTO_PHOTO_SAVE", 10, "EnableAutoPhotoSave");
        DISABLE_AUTO_PHOTO_SAVE = new CustomerMetricEvent("DISABLE_AUTO_PHOTO_SAVE", 11, "DisableAutoPhotoSave");
        ENABLE_AUTO_VIDEO_SAVE = new CustomerMetricEvent("ENABLE_AUTO_VIDEO_SAVE", 12, "EnableAutoVideoSave");
        DISABLE_AUTO_VIDEO_SAVE = new CustomerMetricEvent("DISABLE_AUTO_VIDEO_SAVE", 13, "DisableAutoVideoSave");
        UPLOAD_FILE = new CustomerMetricEvent("UPLOAD_FILE", 14, "UploadFile");
        SHARE_FILE = new CustomerMetricEvent("SHARE_FILE", 15, "ShareFile");
        FACEBOOK_IMPORT = new CustomerMetricEvent("FACEBOOK_IMPORT", 16, "ImportFacebook", "FacebookImport");
        PRELOAD_VIDEO = new CustomerMetricEvent("PRELOAD_VIDEO", 17, "PreloadVideo");
        REBUFFER_VIDEO = new CustomerMetricEvent("REBUFFER_VIDEO", 18, "RebufferVideo");
        ADD_LOCAL_FILE = new CustomerMetricEvent("ADD_LOCAL_FILE", 19, "AddLocalFile");
        DELETE_FILE = new CustomerMetricEvent("DELETE_FILE", 20, "DeleteFile");
        SESSION_START = new CustomerMetricEvent("SESSION_START", 21, "SessionStart");
        SESSION_END = new CustomerMetricEvent("SESSION_END", 22, "SessionStop");
        START_FTUE = new CustomerMetricEvent("START_FTUE", 23, "StartFTUE");
        END_FTUE = new CustomerMetricEvent("END_FTUE", 24, "EndFTUE");
        ALL_VIEW_DATE_TAKEN_TOGGLED = new CustomerMetricEvent("ALL_VIEW_DATE_TAKEN_TOGGLED", 25, "PhotosSort", "AllViewDateTakenToggled");
        ALL_VIEW_DATE_UPLOADED_TOGGLED = new CustomerMetricEvent("ALL_VIEW_DATE_UPLOADED_TOGGLED", 26, "PhotosSort", "AllViewDateUploadedToggled");
        CAMERA_ROLL_NEWEST_FIRST_TOGGLED = new CustomerMetricEvent("CAMERA_ROLL_NEWEST_FIRST_TOGGLED", 27, "PhotosSort", "CameraRollNewestFirstToggled");
        CAMERA_ROLL_OLDEST_FIRST_TOGGLED = new CustomerMetricEvent("CAMERA_ROLL_OLDEST_FIRST_TOGGLED", 28, "PhotosSort", "CameraRollOldestFirstToggled");
        VIDEO_DATE_TAKEN_TOGGLED = new CustomerMetricEvent("VIDEO_DATE_TAKEN_TOGGLED", 29, "PhotosSort", "VideoDateTakenToggled");
        VIDEO_DATE_UPLOADED_TOGGLED = new CustomerMetricEvent("VIDEO_DATE_UPLOADED_TOGGLED", 30, "PhotosSort", "VideoDateUploadedToggled");
        COLLECTION_NEWEST_FIRST_TOGGLED = new CustomerMetricEvent("COLLECTION_NEWEST_FIRST_TOGGLED", 31, "PhotosSort", "CollectionNewestFirstToggled");
        COLLECTION_OLDEST_FIRST_TOGGLED = new CustomerMetricEvent("COLLECTION_OLDEST_FIRST_TOGGLED", 32, "PhotosSort", "CollectionOldestFirstToggled");
        TAG_ALBUM_NAME_TOGGLED = new CustomerMetricEvent("TAG_ALBUM_NAME_TOGGLED", 33, "PhotosSort", "TagAlbumNameToggled");
        TAG_DATE_TAKEN_TOGGLED = new CustomerMetricEvent("TAG_DATE_TAKEN_TOGGLED", 34, "PhotosSort", "TagDateTakenToggled");
        PHOTOS_DOWNLOAD_PHOTO = new CustomerMetricEvent("PHOTOS_DOWNLOAD_PHOTO", 35, "PhotosDownloadPhoto", "DownloadPhoto");
        WHISPER_PLAY_CONNECT = new CustomerMetricEvent("WHISPER_PLAY_CONNECT", 36, "WhisperPlayConnect", "WPInitiateConnection");
        WHISPER_PLAY_DISCONNECT = new CustomerMetricEvent("WHISPER_PLAY_DISCONNECT", 37, "WhisperPlayDisconnect", "WPEndConnection");
        WHISPER_PLAY_CONNECTION_STATUS_NO_DEVICE = new CustomerMetricEvent("WHISPER_PLAY_CONNECTION_STATUS_NO_DEVICE", 38, "WhisperPlayConnectionStatus", "WPConnectionStatusNoDevice");
        WHISPER_PLAY_CONNECTION_STATUS_SUCCESS = new CustomerMetricEvent("WHISPER_PLAY_CONNECTION_STATUS_SUCCESS", 39, "WhisperPlayConnectionStatus", "WPConnectionStatusSuccess");
        WHISPER_PLAY_CONNECTION_STATUS_FAIL = new CustomerMetricEvent("WHISPER_PLAY_CONNECTION_STATUS_FAIL", 40, "WhisperPlayConnectionStatus", "WPConnectionStatusFail");
        WHISPER_PLAY_CONNECTION_STATUS_TIME_OUT = new CustomerMetricEvent("WHISPER_PLAY_CONNECTION_STATUS_TIME_OUT", 41, "WhisperPlayConnectionStatus", "WPConnectionStatusTimeOut");
        WHISPER_PLAY_CONNECTION_STATUS_NO_PERMISSION = new CustomerMetricEvent("WHISPER_PLAY_CONNECTION_STATUS_NO_PERMISSION", 42, "WhisperPlayConnectionStatus", "WPConnectionStatusNoPermission");
        WHISPER_PLAY_SLIDE_SHOW_START = new CustomerMetricEvent("WHISPER_PLAY_SLIDE_SHOW_START", 43, "WhisperPlaySlideshow", "WPSlideshowStarted");
        WHISPER_PLAY_SLIDE_SHOW_END = new CustomerMetricEvent("WHISPER_PLAY_SLIDE_SHOW_END", 44, "WhisperPlaySlideshow", "WPSlideshowPaused");
        WHISPER_PLAY_PHOTO_FLUNG_MANUAL = new CustomerMetricEvent("WHISPER_PLAY_PHOTO_FLUNG_MANUAL", 45, "WhisperPlayPhotoFlung", "WPPhotoFlungManually");
        WHISPER_PLAY_PHOTO_FLUNG_SLIDE_SHOW = new CustomerMetricEvent("WHISPER_PLAY_PHOTO_FLUNG_SLIDE_SHOW", 46, "WhisperPlayPhotoFlung", "WPPhotoFlungBySlideshow");
        WHISPER_PLAY_VIDEO_FLUNG_MANUAL = new CustomerMetricEvent("WHISPER_PLAY_VIDEO_FLUNG_MANUAL", 47, "WhisperPlayVideoFlung", "WPVideoFlungManually");
        WHISPER_PLAY_VIDEO_FLUNG_SLIDE_SHOW = new CustomerMetricEvent("WHISPER_PLAY_VIDEO_FLUNG_SLIDE_SHOW", 48, "WhisperPlayVideoFlung", "WPVideoFlungBySlideshow");
        WHISPER_PLAY_ACTION_SHARE = new CustomerMetricEvent("WHISPER_PLAY_ACTION_SHARE", 49, "WhisperPlayAction", "WPShareAction");
        WHISPER_PLAY_ACTION_DELETE = new CustomerMetricEvent("WHISPER_PLAY_ACTION_DELETE", 50, "WhisperPlayAction", "WPDeleteAction");
        WHISPER_PLAY_ACTION_EDIT = new CustomerMetricEvent("WHISPER_PLAY_ACTION_EDIT", 51, "WhisperPlayAction", "WPEditAction");
        WHISPER_PLAY_ACTION_DOWNLOAD = new CustomerMetricEvent("WHISPER_PLAY_ACTION_DOWNLOAD", 52, "WhisperPlayAction", "WPDownloadAction");
        WHISPER_PLAY_ACTION_UPLOAD = new CustomerMetricEvent("WHISPER_PLAY_ACTION_UPLOAD", 53, "WhisperPlayAction", "WPUploadAction");
        WHISPER_PLAY_ACTION_PRINT = new CustomerMetricEvent("WHISPER_PLAY_ACTION_PRINT", 54, "WhisperPlayAction", "WPPrintAction");
        WHISPER_PLAY_ACTION_INFO = new CustomerMetricEvent("WHISPER_PLAY_ACTION_INFO", 55, "WhisperPlayAction", "WPInfoAction");
        REFFERED_APP_FIRST_SIGNIN = new CustomerMetricEvent("REFFERED_APP_FIRST_SIGNIN", 56, "ReferredAppFirstSignIn");
        THIS_DAY_VIEW_ALL = new CustomerMetricEvent("THIS_DAY_VIEW_ALL", 57, "ThisDayViewAll");
        THIS_DAY_YEAR_VIEW_ALL = new CustomerMetricEvent("THIS_DAY_YEAR_VIEW_ALL", 58, "ThisDayYearViewAll");
        THIS_WEEK_YEAR_VIEW_ALL = new CustomerMetricEvent("THIS_WEEK_YEAR_VIEW_ALL", 59, "ThisWeekYearViewAll");
        THIS_DAY_YEAR_VIEW_SINGLE = new CustomerMetricEvent("THIS_DAY_YEAR_VIEW_SINGLE", 60, "ThisDayYearViewSingle");
        THIS_WEEK_YEAR_VIEW_SINGLE = new CustomerMetricEvent("THIS_WEEK_YEAR_VIEW_SINGLE", 61, "ThisWeekYearViewSingle");
        THIS_DAY_SHUFFLE_VIEW_SINGLE = new CustomerMetricEvent("THIS_DAY_SHUFFLE_VIEW_SINGLE", 62, "ThisDayShuffleViewSingle");
        THIS_DAY_POST_NOTIFICATION = new CustomerMetricEvent("THIS_DAY_POST_NOTIFICATION", 63, "ThisDayPostNotification");
        THIS_DAY_OPEN_NOTIFICATION = new CustomerMetricEvent("THIS_DAY_OPEN_NOTIFICATION", 64, "ThisDayOpenNotification");
        APP_DOWNLOAD = new CustomerMetricEvent("APP_DOWNLOAD", 65, "AppDownload");
        THIS_DAY_NOTIFICATIONS_TOGGLE = new CustomerMetricEvent("THIS_DAY_NOTIFICATIONS_TOGGLE", 66, "ThisDayNotificationsToggle");
        THIS_DAY_BANNER_DISPLAY = new CustomerMetricEvent("THIS_DAY_BANNER_DISPLAY", 67, "ThisDayBannerDisplay");
        THIS_DAY_BANNER_OPEN = new CustomerMetricEvent("THIS_DAY_BANNER_OPEN", 68, "ThisDayBannerOpen");
        ALBUMS_PHOTOS_ALBUMS_LETTER_VIEW = new CustomerMetricEvent("ALBUMS_PHOTOS_ALBUMS_LETTER_VIEW", 69, "PhotoAlbumsLetterView");
        ALBUMS_PHOTOS_ALBUMS_LETTER_CLOSE = new CustomerMetricEvent("ALBUMS_PHOTOS_ALBUMS_LETTER_CLOSE", 70, "PhotoAlbumsLetterClose");
        ALBUMS_CREATE_PHOTO_ALBUM = new CustomerMetricEvent("ALBUMS_CREATE_PHOTO_ALBUM", 71, "CreatePhotoAlbum");
        ALBUMS_CREATE_PHOTO_ALBUM_ERROR = new CustomerMetricEvent("ALBUMS_CREATE_PHOTO_ALBUM_ERROR", 72, "CreatePhotoAlbumError");
        ALBUMS_CREATE_PHOTO_ALBUM_TIME = new CustomerMetricEvent("ALBUMS_CREATE_PHOTO_ALBUM_TIME", 73, "CreatePhotoAlbumTime");
        ALBUMS_DELETE_PHOTO_ALBUM = new CustomerMetricEvent("ALBUMS_DELETE_PHOTO_ALBUM", 74, "DeletePhotoAlbum");
        ALBUMS_DELETE_PHOTO_ALBUM_ERROR = new CustomerMetricEvent("ALBUMS_DELETE_PHOTO_ALBUM_ERROR", 75, "DeletePhotoAlbumError");
        ALBUMS_DELETE_PHOTO_ALBUM_UNDO = new CustomerMetricEvent("ALBUMS_DELETE_PHOTO_ALBUM_UNDO", 76, "DeletePhotoAlbumUndo");
        ALBUMS_DELETE_PHOTO_ALBUM_UNDO_ERROR = new CustomerMetricEvent("ALBUMS_DELETE_PHOTO_ALBUM_UNDO_ERROR", 77, "DeletePhotoAlbumUndoError");
        ALBUMS_DELETE_PHOTO_ALBUM_TIME = new CustomerMetricEvent("ALBUMS_DELETE_PHOTO_ALBUM_TIME", 78, "DeletePhotoAlbumTime");
        ALBUMS_ALBUM_VIEW_ALL = new CustomerMetricEvent("ALBUMS_ALBUM_VIEW_ALL", 79, "PhotoAlbumViewAll");
        ALBUMS_ALBUMS_VIEW_ALL = new CustomerMetricEvent("ALBUMS_ALBUMS_VIEW_ALL", 80, "PhotoAlbumsViewAll");
        ALBUMS_FOLDER_MIGRATION_VIEW_ALL = new CustomerMetricEvent("ALBUMS_FOLDER_MIGRATION_VIEW_ALL", 81, "FolderMigrationViewAll");
        ALBUMS_FOLDER_MIGRATIONS_VIEW_ALL = new CustomerMetricEvent("ALBUMS_FOLDER_MIGRATIONS_VIEW_ALL", 82, "FolderMigrationsViewAll");
        ALBUMS_ADD_PHOTOS = new CustomerMetricEvent("ALBUMS_ADD_PHOTOS", 83, "AddPhotos");
        ALBUMS_ADD_PHOTOS_ERROR = new CustomerMetricEvent("ALBUMS_ADD_PHOTOS_ERROR", 84, "AddPhotosError");
        ALBUMS_ADD_PHOTOS_TIME = new CustomerMetricEvent("ALBUMS_ADD_PHOTOS_TIME", 85, "AddPhotosTime");
        ALBUMS_REMOVE_PHOTOS = new CustomerMetricEvent("ALBUMS_REMOVE_PHOTOS", 86, "RemovePhotos");
        ALBUMS_REMOVE_PHOTOS_ERROR = new CustomerMetricEvent("ALBUMS_REMOVE_PHOTOS_ERROR", 87, "RemovePhotosError");
        ALBUMS_REMOVE_PHOTOS_UNDO = new CustomerMetricEvent("ALBUMS_REMOVE_PHOTOS_UNDO", 88, "RemovePhotosUndo");
        ALBUMS_REMOVE_PHOTOS_UNDO_ERROR = new CustomerMetricEvent("ALBUMS_REMOVE_PHOTOS_UNDO_ERROR", 89, "RemovePhotosUndoError");
        ALBUMS_REMOVE_PHOTOS_TIME = new CustomerMetricEvent("ALBUMS_REMOVE_PHOTOS_TIME", 90, "RemovePhotosTime");
        ALBUMS_SHARE_PHOTO_ALBUM = new CustomerMetricEvent("ALBUMS_SHARE_PHOTO_ALBUM", 91, "SharePhotoAlbum");
        ALBUMS_SHARE_PHOTO_ALBUM_ERROR = new CustomerMetricEvent("ALBUMS_SHARE_PHOTO_ALBUM_ERROR", 92, "SharePhotoAlbumError");
        ALBUMS_SHARE_PHOTO_ALBUM_TIME = new CustomerMetricEvent("ALBUMS_SHARE_PHOTO_ALBUM_TIME", 93, "SharePhotoAlbumTime");
        ALBUMS_SET_PHOTO_ALBUM_COVER = new CustomerMetricEvent("ALBUMS_SET_PHOTO_ALBUM_COVER", 94, "SetPhotoAlbumCover");
        ALBUMS_SET_PHOTO_ALBUM_COVER_ERROR = new CustomerMetricEvent("ALBUMS_SET_PHOTO_ALBUM_COVER_ERROR", 95, "SetPhotoAlbumCoverError");
        ALBUMS_SET_PHOTO_ALBUM_COVER_TIME = new CustomerMetricEvent("ALBUMS_SET_PHOTO_ALBUM_COVER_TIME", 96, "SetPhotoAlbumCoverTime");
        ALBUMS_RENAME_PHOTO_ALBUM = new CustomerMetricEvent("ALBUMS_RENAME_PHOTO_ALBUM", 97, "RenamePhotoAlbum");
        ALBUMS_RENAME_PHOTO_ALBUM_ERROR = new CustomerMetricEvent("ALBUMS_RENAME_PHOTO_ALBUM_ERROR", 98, "RenamePhotoAlbumError");
        ALBUMS_RENAME_PHOTO_ALBUM_UNDO = new CustomerMetricEvent("ALBUMS_RENAME_PHOTO_ALBUM_UNDO", 99, "RenamePhotoAlbumUndo");
        ALBUMS_RENAME_PHOTO_ALBUM_UNDO_ERROR = new CustomerMetricEvent("ALBUMS_RENAME_PHOTO_ALBUM_UNDO_ERROR", 100, "RenamePhotoAlbumUndoError");
        ALBUMS_RENAME_PHOTO_ALBUM_TIME = new CustomerMetricEvent("ALBUMS_RENAME_PHOTO_ALBUM_TIME", 101, "RenamePhotoAlbumTime");
        ALBUMS_VIEW_ALBUM_INFO = new CustomerMetricEvent("ALBUMS_VIEW_ALBUM_INFO", 102, "ViewAlbumInfo");
        ALBUMS_VIEW_ALBUM_INFO_TIME = new CustomerMetricEvent("ALBUMS_VIEW_ALBUM_INFO_TIME", 103, "ViewAlbumInfoTime");
        ALBUMS_ADD_DYNAMIC = new CustomerMetricEvent("ALBUMS_ADD_DYNAMIC", 104, "AddDynamic");
        ALBUMS_REMOVE_DYNAMIC = new CustomerMetricEvent("ALBUMS_REMOVE_DYNAMIC", 105, "RemoveDynamic");
        $VALUES = (new CustomerMetricEvent[] {
            PHOTOS_VIEW_ALBUM, PHOTOS_VIEW_PHOTO, APP_LAUNCHED, CLIENT_FIRST_START, AUTO_UPLOAD_ENABLED_FIRST_START, AUTO_UPLOAD_DISABLED_FIRST_START, START_VIDEO, END_VIDEO, AUTO_SAVE_FILE, AUTO_SAVE_EDITED_FILE, 
            ENABLE_AUTO_PHOTO_SAVE, DISABLE_AUTO_PHOTO_SAVE, ENABLE_AUTO_VIDEO_SAVE, DISABLE_AUTO_VIDEO_SAVE, UPLOAD_FILE, SHARE_FILE, FACEBOOK_IMPORT, PRELOAD_VIDEO, REBUFFER_VIDEO, ADD_LOCAL_FILE, 
            DELETE_FILE, SESSION_START, SESSION_END, START_FTUE, END_FTUE, ALL_VIEW_DATE_TAKEN_TOGGLED, ALL_VIEW_DATE_UPLOADED_TOGGLED, CAMERA_ROLL_NEWEST_FIRST_TOGGLED, CAMERA_ROLL_OLDEST_FIRST_TOGGLED, VIDEO_DATE_TAKEN_TOGGLED, 
            VIDEO_DATE_UPLOADED_TOGGLED, COLLECTION_NEWEST_FIRST_TOGGLED, COLLECTION_OLDEST_FIRST_TOGGLED, TAG_ALBUM_NAME_TOGGLED, TAG_DATE_TAKEN_TOGGLED, PHOTOS_DOWNLOAD_PHOTO, WHISPER_PLAY_CONNECT, WHISPER_PLAY_DISCONNECT, WHISPER_PLAY_CONNECTION_STATUS_NO_DEVICE, WHISPER_PLAY_CONNECTION_STATUS_SUCCESS, 
            WHISPER_PLAY_CONNECTION_STATUS_FAIL, WHISPER_PLAY_CONNECTION_STATUS_TIME_OUT, WHISPER_PLAY_CONNECTION_STATUS_NO_PERMISSION, WHISPER_PLAY_SLIDE_SHOW_START, WHISPER_PLAY_SLIDE_SHOW_END, WHISPER_PLAY_PHOTO_FLUNG_MANUAL, WHISPER_PLAY_PHOTO_FLUNG_SLIDE_SHOW, WHISPER_PLAY_VIDEO_FLUNG_MANUAL, WHISPER_PLAY_VIDEO_FLUNG_SLIDE_SHOW, WHISPER_PLAY_ACTION_SHARE, 
            WHISPER_PLAY_ACTION_DELETE, WHISPER_PLAY_ACTION_EDIT, WHISPER_PLAY_ACTION_DOWNLOAD, WHISPER_PLAY_ACTION_UPLOAD, WHISPER_PLAY_ACTION_PRINT, WHISPER_PLAY_ACTION_INFO, REFFERED_APP_FIRST_SIGNIN, THIS_DAY_VIEW_ALL, THIS_DAY_YEAR_VIEW_ALL, THIS_WEEK_YEAR_VIEW_ALL, 
            THIS_DAY_YEAR_VIEW_SINGLE, THIS_WEEK_YEAR_VIEW_SINGLE, THIS_DAY_SHUFFLE_VIEW_SINGLE, THIS_DAY_POST_NOTIFICATION, THIS_DAY_OPEN_NOTIFICATION, APP_DOWNLOAD, THIS_DAY_NOTIFICATIONS_TOGGLE, THIS_DAY_BANNER_DISPLAY, THIS_DAY_BANNER_OPEN, ALBUMS_PHOTOS_ALBUMS_LETTER_VIEW, 
            ALBUMS_PHOTOS_ALBUMS_LETTER_CLOSE, ALBUMS_CREATE_PHOTO_ALBUM, ALBUMS_CREATE_PHOTO_ALBUM_ERROR, ALBUMS_CREATE_PHOTO_ALBUM_TIME, ALBUMS_DELETE_PHOTO_ALBUM, ALBUMS_DELETE_PHOTO_ALBUM_ERROR, ALBUMS_DELETE_PHOTO_ALBUM_UNDO, ALBUMS_DELETE_PHOTO_ALBUM_UNDO_ERROR, ALBUMS_DELETE_PHOTO_ALBUM_TIME, ALBUMS_ALBUM_VIEW_ALL, 
            ALBUMS_ALBUMS_VIEW_ALL, ALBUMS_FOLDER_MIGRATION_VIEW_ALL, ALBUMS_FOLDER_MIGRATIONS_VIEW_ALL, ALBUMS_ADD_PHOTOS, ALBUMS_ADD_PHOTOS_ERROR, ALBUMS_ADD_PHOTOS_TIME, ALBUMS_REMOVE_PHOTOS, ALBUMS_REMOVE_PHOTOS_ERROR, ALBUMS_REMOVE_PHOTOS_UNDO, ALBUMS_REMOVE_PHOTOS_UNDO_ERROR, 
            ALBUMS_REMOVE_PHOTOS_TIME, ALBUMS_SHARE_PHOTO_ALBUM, ALBUMS_SHARE_PHOTO_ALBUM_ERROR, ALBUMS_SHARE_PHOTO_ALBUM_TIME, ALBUMS_SET_PHOTO_ALBUM_COVER, ALBUMS_SET_PHOTO_ALBUM_COVER_ERROR, ALBUMS_SET_PHOTO_ALBUM_COVER_TIME, ALBUMS_RENAME_PHOTO_ALBUM, ALBUMS_RENAME_PHOTO_ALBUM_ERROR, ALBUMS_RENAME_PHOTO_ALBUM_UNDO, 
            ALBUMS_RENAME_PHOTO_ALBUM_UNDO_ERROR, ALBUMS_RENAME_PHOTO_ALBUM_TIME, ALBUMS_VIEW_ALBUM_INFO, ALBUMS_VIEW_ALBUM_INFO_TIME, ALBUMS_ADD_DYNAMIC, ALBUMS_REMOVE_DYNAMIC
        });
        CustomerMetricEvent acustomermetricevent[] = values();
        MAPPING = new HashMap(acustomermetricevent.length);
        int j = acustomermetricevent.length;
        for (int i = 0; i < j; i++)
        {
            CustomerMetricEvent customermetricevent = acustomermetricevent[i];
            MAPPING.put(customermetricevent.pmetMetricEvent, customermetricevent.customerMetricEvent);
        }

    }
}
