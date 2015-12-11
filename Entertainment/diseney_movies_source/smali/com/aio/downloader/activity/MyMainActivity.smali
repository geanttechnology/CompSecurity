.class public Lcom/aio/downloader/activity/MyMainActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "MyMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;
.implements Lcom/facebook/ads/InterstitialAdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_cleaner;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_crush;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_free;,
        Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_gallery;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya1;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya2;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya3;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya4;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya5;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya6;,
        Lcom/aio/downloader/activity/MyMainActivity$Mya_rush;
    }
.end annotation


# static fields
.field private static final DOWNLOAD_THREAD_POOL_SIZE:I = 0x4

.field private static final FILE1:Ljava/lang/String; = "http://apk.downloadatoz.com/package/com.allinone.free.apk"

.field private static final FILE_BATTERY:Ljava/lang/String; = "http://apktop.downloadatoz.com/upload_swf/com.freeapp.batterysaver.swf"

.field private static final FILE_CALLER:Ljava/lang/String; = "http://apktop.downloadatoz.com/upload_swf/com.allinone.callerid.swf"

.field private static final FILE_CLEANER:Ljava/lang/String; = "http://apktop.downloadatoz.com/upload_swf/com.evzapp.cleanmaster.swf"

.field private static final FILE_CRUSH:Ljava/lang/String; = "http://apktop.downloadatoz.com/upload_swf/com.freepezzle.hexcrush.swf"

.field private static final FILE_FREE:Ljava/lang/String; = "http://apktop.downloadatoz.com/upload_swf/com.osamahq.freestore.swf"

.field private static final FILE_GALLERY:Ljava/lang/String; = "http://apktop.downloadatoz.com/upload_swf/com.androidapp.gallary3d.swf"

.field public static final UPDATE_TAG:I = 0x234

.field public static mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;


# instance fields
.field private final ACTION_NAME:Ljava/lang/String;

.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCLEANERAPK:Ljava/io/File;

.field private AIOCLEANERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private AIOFREE:Ljava/io/File;

.field private AIOFREEAPK:Ljava/io/File;

.field private AIOGALLERY:Ljava/io/File;

.field private AIOGALLERYAPK:Ljava/io/File;

.field private AIOUPDATEFILE:Ljava/io/File;

.field private AIOUPDATEFILE1:Ljava/io/File;

.field private AIOUPDATEFILE2:Ljava/io/File;

.field private final FIRST:Ljava/lang/String;

.field private final PAIDPPP:Ljava/lang/String;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private aa_app:Landroid/content/Intent;

.field private aa_change:Landroid/content/Intent;

.field private aa_lev:Landroid/content/Intent;

.field private aa_temp:Landroid/content/Intent;

.field private acquire_url_start:Ljava/lang/String;

.field private adapter:Lcom/aio/downloader/adapter/Home_Listview_Adapter;

.field private aio_intent:Landroid/content/Intent;

.field private apkname:Ljava/lang/String;

.field private apkname_google:Ljava/lang/String;

.field private apkname_mp3:Ljava/lang/String;

.field private apkname_mp4:Ljava/lang/String;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private appHandler:Landroid/os/Handler;

.field private appIcon:Landroid/graphics/drawable/Drawable;

.field private appName:Ljava/lang/String;

.field private appVersion:Ljava/lang/String;

.field private appbanner:Landroid/widget/LinearLayout;

.field private appid:Ljava/lang/String;

.field private appline:Landroid/widget/LinearLayout;

.field private apptopgift:Landroid/widget/ImageView;

.field private badgedownimg:Lcom/aio/downloader/views/BadgeView;

.field private badgedowntv:Lcom/aio/downloader/views/BadgeView;

.field private badgetv:Landroid/widget/TextView;

.field private banner_type_name:Ljava/lang/String;

.field private batterylow:Lcom/aio/downloader/dialog/Batterylow;

.field callerD:Z

.field private dEVICE_ID:Ljava/lang/String;

.field private datingline:Landroid/widget/LinearLayout;

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private default_options:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private downloadId1:I

.field private downloadId_battery:I

.field private downloadId_caller:I

.field private downloadId_cleaner:I

.field private downloadId_crush:I

.field private downloadId_free:I

.field private downloadId_gallery:I

.field private downloadManager:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downloadManager_battery:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downloadManager_caller:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downloadManager_cleaner:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downloadManager_crush:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downloadManager_free:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downloadManager_gallery:Lcom/thin/downloadmanager/ThinDownloadManager;

.field private downrelelativetv:Landroid/widget/RelativeLayout;

.field private drawerButtonLeft:Lcom/aio/downloader/views/LImageButton;

.field private ds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field editor:Landroid/content/SharedPreferences$Editor;

.field private gameline:Landroid/widget/LinearLayout;

.field private gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;

.field handler:Landroid/os/Handler;

.field handlertimer:Landroid/os/Handler;

.field handlerversion:Landroid/os/Handler;

.field handlerversoin:Landroid/os/Handler;

.field private havetryline:Landroid/widget/LinearLayout;

.field private hidehomeapp:Landroid/content/BroadcastReceiver;

.field private homeapp:Landroid/content/BroadcastReceiver;

.field private icon_pick:Ljava/lang/String;

.field private icon_pick1:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private id_meiri:Ljava/lang/String;

.field private id_meiribig:Ljava/lang/String;

.field private img_pick:Ljava/lang/String;

.field public in_control:I

.field info:Lcom/aio/downloader/model/GameInfosVersionModel;

.field private info2:Lcom/aio/downloader/model/Info;

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Info;",
            ">;"
        }
    .end annotation
.end field

.field private infos2:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Info;",
            ">;"
        }
    .end annotation
.end field

.field private intent_float:Landroid/content/Intent;

.field private interstitialAd:Lcom/facebook/ads/InterstitialAd;

.field private isfbshow:Z

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field itemsOnClick2:Landroid/view/View$OnClickListener;

.field private iv_fb_fragment:Landroid/widget/ImageView;

.field private iv_tianchi:Landroid/widget/ImageView;

.field private iv_tianchi1:Landroid/widget/ImageView;

.field private iv_tianchi2:Landroid/widget/ImageView;

.field private iv_tianchi3:Landroid/widget/ImageView;

.field private iv_tianchi4:Landroid/widget/ImageView;

.field private iv_tianchi5:Landroid/widget/ImageView;

.field private iv_tianchi6:Landroid/widget/ImageView;

.field private iv_tianchi7:Landroid/widget/ImageView;

.field private iv_tianchi8:Landroid/widget/ImageView;

.field private iv_tianchi9:Landroid/widget/ImageView;

.field private iv_updata:Landroid/widget/ImageView;

.field private iv_updata_bt:Landroid/widget/ImageView;

.field private jsonArray:Lorg/json/JSONArray;

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;>;"
        }
    .end annotation
.end field

.field private list2:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field list3:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private listView:Lcom/aio/downloader/refresh/PullableListView;

.field list_fun:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/FunModel;",
            ">;"
        }
    .end annotation
.end field

.field list_fun_app:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/Fun_appModel;",
            ">;"
        }
    .end annotation
.end field

.field list_pick:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private list_update:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private ll_updata:Landroid/widget/LinearLayout;

.field private load_more:Landroid/content/BroadcastReceiver;

.field private lp:Landroid/view/ViewGroup$LayoutParams;

.field private mAnimImageView:Landroid/widget/ImageView;

.field private mAnimation:Landroid/view/animation/Animation;

.field private mLeftGravityView:Landroid/view/View;

.field public mListInfo:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/AppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mNotificationManager8:Landroid/app/NotificationManager;

.field private mProgress1:Landroid/widget/ProgressBar;

.field private mRandom:I

.field private main_tab_top:Landroid/widget/RelativeLayout;

.field private myDownloadStatusListener:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;

.field private myDownloadStatusListener_battery:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;

.field private myDownloadStatusListener_caller:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;

.field private myDownloadStatusListener_cleaner:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_cleaner;

.field private myDownloadStatusListener_crush:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_crush;

.field private myDownloadStatusListener_free:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_free;

.field private myDownloadStatusListener_gallery:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_gallery;

.field private myIntent:Landroid/content/Intent;

.field private myIntent2:Landroid/content/Intent;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field private newVersionUrl:Ljava/lang/String;

.field private next:I

.field private notification_app:Landroid/app/Notification;

.field private notification_change:Landroid/app/Notification;

.field private notification_lev:Landroid/app/Notification;

.field private notification_ram:Landroid/app/Notification;

.field private notification_temp:Landroid/app/Notification;

.field private numbertip:Landroid/content/BroadcastReceiver;

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private page:I

.field private paidline:Landroid/widget/LinearLayout;

.field private pen_mem:I

.field private playnowline:Landroid/widget/RelativeLayout;

.field private ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private recommendurl:Ljava/lang/String;

.field private record:I

.field private request1:Lcom/thin/downloadmanager/DownloadRequest;

.field private request_battery:Lcom/thin/downloadmanager/DownloadRequest;

.field private request_caller:Lcom/thin/downloadmanager/DownloadRequest;

.field private request_cleaner:Lcom/thin/downloadmanager/DownloadRequest;

.field private request_crush:Lcom/thin/downloadmanager/DownloadRequest;

.field private request_free:Lcom/thin/downloadmanager/DownloadRequest;

.field private request_gallery:Lcom/thin/downloadmanager/DownloadRequest;

.field private run_time:I

.field private s2:Ljava/lang/String;

.field sharedPreferences:Landroid/content/SharedPreferences;

.field private short_desc:Ljava/lang/String;

.field private short_desc1:Ljava/lang/String;

.field private showhomeapp:Landroid/content/BroadcastReceiver;

.field private showup:I

.field private sp_config:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;

.field public status:I

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

.field private tab_app:Lcom/aio/downloader/views/LImageButton;

.field private tab_down:Lcom/aio/downloader/views/LImageButton;

.field private tab_game:Lcom/aio/downloader/views/LImageButton;

.field private tab_group:Landroid/widget/RadioGroup;

.field private tab_search:Lcom/aio/downloader/views/LImageButton;

.field private title_pick:Ljava/lang/String;

.field private title_pick1:Ljava/lang/String;

.field private todayid:Ljava/lang/String;

.field private tv_current_version:Landroid/widget/TextView;

.field private tv_updata_name:Landroid/widget/TextView;

.field private tv_updata_size:Landroid/widget/TextView;

.field private tv_updata_version:Landroid/widget/TextView;

.field private typeFace:Landroid/graphics/Typeface;

.field private upJsonStr:Ljava/lang/String;

.field private updateDialog:Lcom/aio/downloader/dialog/UpdateDialogVerison;

.field updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

.field updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

.field private urlPath:Ljava/lang/String;

.field private urlPath_battery:Ljava/lang/String;

.field private urlPath_caller:Ljava/lang/String;

.field private urlPath_cleaner:Ljava/lang/String;

.field private urlPath_crush:Ljava/lang/String;

.field private urlPath_free:Ljava/lang/String;

.field private urlPath_gallery:Ljava/lang/String;

.field private url_id:Ljava/lang/String;

.field private version:Ljava/lang/String;

.field private view_kong:Landroid/view/View;

.field private windowFocus:Z

.field private wuyule:I


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 151
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 155
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 156
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 157
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 158
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 159
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 160
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR:Ljava/io/File;

    .line 162
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->mRandom:I

    .line 185
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;

    .line 186
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_battery:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;

    .line 187
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_free;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_free;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_free:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_free;

    .line 188
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_gallery;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_gallery;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_gallery:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_gallery;

    .line 189
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_cleaner;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_cleaner;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_cleaner:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_cleaner;

    .line 190
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_caller:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;

    .line 191
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_crush;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_crush;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_crush:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_crush;

    .line 193
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId1:I

    .line 194
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I

    .line 195
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_free:I

    .line 196
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_gallery:I

    .line 197
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_cleaner:I

    .line 198
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I

    .line 199
    iput v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_crush:I

    .line 218
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mListInfo:Ljava/util/List;

    .line 224
    const-string v0, "\u53d1\u9001\u5e7f\u64ad"

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->ACTION_NAME:Ljava/lang/String;

    .line 225
    const-string v0, "diyicianzhuang"

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->FIRST:Ljava/lang/String;

    .line 226
    const-string v0, "paidppp"

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PAIDPPP:Ljava/lang/String;

    .line 227
    iput-boolean v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->callerD:Z

    .line 231
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->appHandler:Landroid/os/Handler;

    .line 253
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$2;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->handlerversion:Landroid/os/Handler;

    .line 333
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$3;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->load_more:Landroid/content/BroadcastReceiver;

    .line 342
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$4;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->homeapp:Landroid/content/BroadcastReceiver;

    .line 378
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$5;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->showhomeapp:Landroid/content/BroadcastReceiver;

    .line 384
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$6;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->hidehomeapp:Landroid/content/BroadcastReceiver;

    .line 395
    iput-boolean v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->windowFocus:Z

    .line 396
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->newVersionUrl:Ljava/lang/String;

    .line 401
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion:Lcom/aio/downloader/dialog/UpdateDialogVerison;

    .line 402
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->updateDialogVersion2:Lcom/aio/downloader/dialog/UpdateDialogVerison2;

    .line 407
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 408
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->banner_type_name:Ljava/lang/String;

    .line 411
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_fun:Ljava/util/ArrayList;

    .line 412
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_fun_app:Ljava/util/ArrayList;

    .line 413
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    .line 415
    invoke-static {}, Lcom/aio/downloader/utils/Updatesize;->getUpdatesize()Lcom/aio/downloader/utils/Updatesize;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Updatesize;->list_update:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_update:Ljava/util/ArrayList;

    .line 419
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->infos2:Ljava/util/List;

    .line 423
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$7;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$7;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->handlerversoin:Landroid/os/Handler;

    .line 521
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$8;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$8;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->handlertimer:Landroid/os/Handler;

    .line 634
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$9;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$9;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->numbertip:Landroid/content/BroadcastReceiver;

    .line 644
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$10;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$10;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    .line 854
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 855
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->url_id:Ljava/lang/String;

    .line 856
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->recommendurl:Ljava/lang/String;

    .line 859
    iput v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->run_time:I

    .line 862
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->typeFace:Landroid/graphics/Typeface;

    .line 872
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 874
    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 893
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list:Ljava/util/ArrayList;

    .line 895
    iput v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->page:I

    .line 896
    iput v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->next:I

    .line 900
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->infos:Ljava/util/List;

    .line 902
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 903
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/AIOUPDATE"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE:Ljava/io/File;

    .line 905
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 906
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 907
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 908
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;

    .line 909
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 910
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 911
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 912
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 914
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 915
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 916
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 917
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOGALLERY:Ljava/io/File;

    .line 918
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 919
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 920
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 921
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOGALLERYAPK:Ljava/io/File;

    .line 923
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 924
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 925
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 926
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCLEANERDOWN:Ljava/io/File;

    .line 927
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 928
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 929
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 930
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCLEANERAPK:Ljava/io/File;

    .line 932
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 933
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 934
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 935
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;

    .line 936
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 937
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 938
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 939
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERAPK:Ljava/io/File;

    .line 941
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 942
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 943
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 944
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 945
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 946
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 947
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 948
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 950
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 951
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "freestore.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOFREE:Ljava/io/File;

    .line 952
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 953
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 954
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 955
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "freestore.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOFREEAPK:Ljava/io/File;

    .line 956
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 957
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 958
    const-string v2, "/AIOUPDATE"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 959
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "aioupdate.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE1:Ljava/io/File;

    .line 960
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 961
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 962
    const-string v2, "/com.aio.downloader"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 963
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "com.allinone.downloader.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE2:Ljava/io/File;

    .line 969
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    .line 1020
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list3:Ljava/util/ArrayList;

    .line 2207
    iput-boolean v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->isfbshow:Z

    .line 151
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 2937
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 2938
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 2939
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 2940
    const-string v1, "Ok"

    .line 2941
    new-instance v2, Lcom/aio/downloader/activity/MyMainActivity$32;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MyMainActivity$32;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 2940
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 2947
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 2949
    return-void
.end method

.method private Recommed_Url()V
    .locals 5

    .prologue
    .line 2671
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const/high16 v4, 0x7f050000

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v1

    .line 2672
    .local v1, "in":Ljava/io/InputStream;
    invoke-virtual {v1}, Ljava/io/InputStream;->available()I

    move-result v2

    .line 2673
    .local v2, "length":I
    new-array v0, v2, [B

    .line 2674
    .local v0, "buffer":[B
    invoke-virtual {v1, v0}, Ljava/io/InputStream;->read([B)I

    .line 2675
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 2676
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v0}, Ljava/lang/String;-><init>([B)V

    iput-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->url_id:Ljava/lang/String;

    .line 2677
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "http://android.downloadatoz.com/_201409/market/recommend_list_more.php?id="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2678
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->url_id:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 2677
    iput-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->recommendurl:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2684
    .end local v0    # "buffer":[B
    .end local v1    # "in":Ljava/io/InputStream;
    .end local v2    # "length":I
    :goto_0
    return-void

    .line 2680
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 4571
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsefeatured(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 4572
    const-string v0, "eee"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "page="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->page:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4573
    new-instance v0, Lcom/aio/downloader/adapter/Home_Listview_Adapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->list:Ljava/util/ArrayList;

    .line 4574
    const-string v2, "homefeatured"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_fun:Ljava/util/ArrayList;

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/aio/downloader/adapter/Home_Listview_Adapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 4573
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->adapter:Lcom/aio/downloader/adapter/Home_Listview_Adapter;

    .line 4575
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->page:I

    if-ne v0, v4, :cond_0

    .line 4577
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 4578
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->adapter:Lcom/aio/downloader/adapter/Home_Listview_Adapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 4577
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 4579
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 4580
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 4582
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 4583
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 4584
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->adapter:Lcom/aio/downloader/adapter/Home_Listview_Adapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/Home_Listview_Adapter;->notifyDataSetChanged()V

    .line 4586
    return-void
.end method

.method private ShowResult1(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 4567
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_fun:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->funList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 4568
    return-void
.end method

.method private ShowResult2(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 4562
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_fun_app:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->fun_appList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 4563
    return-void
.end method

.method private ShowResult6(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 4446
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsetodaypick(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 4447
    const-string v0, "lpl"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "list_pick="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4449
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->icon_pick:Ljava/lang/String;

    .line 4450
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->title_pick:Ljava/lang/String;

    .line 4451
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getShort_desc()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->short_desc:Ljava/lang/String;

    .line 4452
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->img_pick:Ljava/lang/String;

    .line 4453
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->id_meiribig:Ljava/lang/String;

    .line 4455
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->icon_pick1:Ljava/lang/String;

    .line 4456
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->title_pick1:Ljava/lang/String;

    .line 4457
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getShort_desc()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->short_desc1:Ljava/lang/String;

    .line 4458
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_pick:Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->id_meiri:Ljava/lang/String;

    .line 4460
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->icon_pick:Ljava/lang/String;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 4461
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->img_pick:Ljava/lang/String;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi9:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 4463
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->icon_pick1:Ljava/lang/String;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi2:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4470
    :goto_0
    const-string v0, "record"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "record====="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->record:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4526
    return-void

    .line 4465
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 396
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->newVersionUrl:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->newVersionUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 883
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 878
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 879
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedowntv:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 854
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/MyMainActivity;)Z
    .locals 1

    .prologue
    .line 395
    iget-boolean v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->windowFocus:Z

    return v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 877
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 876
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 2936
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V

    return-void
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 858
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 860
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 960
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE2:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 985
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi6:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 980
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi1:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 981
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi2:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$23(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 982
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi3:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$24(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 983
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi4:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$25(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 984
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi5:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$26(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 986
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi7:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$27(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 987
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi8:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$28(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 998
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$29(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 856
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->recommendurl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4833
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyMainActivity;->updateaioApk1()V

    return-void
.end method

.method static synthetic access$30(Lcom/aio/downloader/activity/MyMainActivity;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 857
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->list2:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$31(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 858
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-void
.end method

.method static synthetic access$32(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 859
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->run_time:I

    return v0
.end method

.method static synthetic access$33(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 857
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list2:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$34(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 895
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->page:I

    return v0
.end method

.method static synthetic access$35(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 4570
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$36(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 4565
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity;->ShowResult1(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$37(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 4445
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity;->ShowResult6(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$38(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->upJsonStr:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$39(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 414
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->list_update:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 873
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$40(Lcom/aio/downloader/activity/MyMainActivity;I)V
    .locals 0

    .prologue
    .line 223
    iput p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->showup:I

    return-void
.end method

.method static synthetic access$41(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 1000
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->ll_updata:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$42(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 223
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->showup:I

    return v0
.end method

.method static synthetic access$43(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->appName:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$44(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->appVersion:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$45(Lcom/aio/downloader/activity/MyMainActivity;Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->appIcon:Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method static synthetic access$46(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 1001
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_updata:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$47(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->appIcon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$48(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1002
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_updata_name:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$49(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->appName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 2906
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V

    return-void
.end method

.method static synthetic access$50(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1003
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_current_version:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$51(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->appVersion:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$52(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1004
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_updata_version:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$53(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 1005
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_updata_size:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$54(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 4560
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity;->ShowResult2(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$55(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 902
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$56(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 898
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mNotificationManager8:Landroid/app/NotificationManager;

    return-object v0
.end method

.method static synthetic access$57(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4824
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyMainActivity;->updateaioApk()V

    return-void
.end method

.method static synthetic access$58(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 193
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId1:I

    return v0
.end method

.method static synthetic access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 872
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$60(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 905
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$61(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 909
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$62(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 194
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I

    return v0
.end method

.method static synthetic access$63(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 950
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOFREE:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$64(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 952
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOFREEAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$65(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 195
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_free:I

    return v0
.end method

.method static synthetic access$66(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 914
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOGALLERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$67(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 918
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOGALLERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$68(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 196
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_gallery:I

    return v0
.end method

.method static synthetic access$69(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 923
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCLEANERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/MyMainActivity;Lnet/tsz/afinal/FinalDBChen;)V
    .locals 0

    .prologue
    .line 871
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-void
.end method

.method static synthetic access$70(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 927
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCLEANERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$71(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 197
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_cleaner:I

    return v0
.end method

.method static synthetic access$72(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 932
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$73(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 936
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$74(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 198
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I

    return v0
.end method

.method static synthetic access$75(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 941
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$76(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 945
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$77(Lcom/aio/downloader/activity/MyMainActivity;)I
    .locals 1

    .prologue
    .line 199
    iget v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_crush:I

    return v0
.end method

.method static synthetic access$78(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 977
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->appid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$79(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 874
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/MyMainActivity;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 871
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$80(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 970
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$81(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 971
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->apkname:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$82(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 973
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$83(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 974
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$84(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 972
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_google:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$85(Lcom/aio/downloader/activity/MyMainActivity;)Lorg/json/JSONArray;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->jsonArray:Lorg/json/JSONArray;

    return-object v0
.end method

.method static synthetic access$86(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 978
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->dEVICE_ID:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$87(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->upJsonStr:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$88(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->appHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$89(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/MyMainActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 883
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$90(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$91(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$92(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 870
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$93(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 969
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$94(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 408
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->banner_type_name:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$95(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 408
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->banner_type_name:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$96(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->sp_config:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$97(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/thin/downloadmanager/ThinDownloadManager;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager:Lcom/thin/downloadmanager/ThinDownloadManager;

    return-object v0
.end method

.method static synthetic access$98(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/thin/downloadmanager/DownloadRequest;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->request1:Lcom/thin/downloadmanager/DownloadRequest;

    return-object v0
.end method

.method static synthetic access$99(Lcom/aio/downloader/activity/MyMainActivity;I)V
    .locals 0

    .prologue
    .line 193
    iput p1, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId1:I

    return-void
.end method

.method private buildlistener()V
    .locals 1

    .prologue
    .line 2197
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_group:Landroid/widget/RadioGroup;

    invoke-virtual {v0, p0}, Landroid/widget/RadioGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2198
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_app:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2199
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_game:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2200
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_search:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2201
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_down:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2202
    return-void
.end method

.method private count()V
    .locals 22

    .prologue
    .line 5365
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->sharedPreferences:Landroid/content/SharedPreferences;

    move-object/from16 v19, v0

    const-string v20, "first"

    const/16 v21, 0x0

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v19

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->record:I

    .line 5366
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->sharedPreferences:Landroid/content/SharedPreferences;

    move-object/from16 v19, v0

    const-string v20, "iFirst1"

    const/16 v21, 0x0

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v11

    .line 5367
    .local v11, "installFirst":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->sharedPreferences:Landroid/content/SharedPreferences;

    move-object/from16 v19, v0

    const-string v20, "shortcut"

    const/16 v21, 0x0

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v18

    .line 5368
    .local v18, "shortcut":I
    const-string v19, "tag"

    new-instance v20, Ljava/lang/StringBuilder;

    const-string v21, "shortcut="

    invoke-direct/range {v20 .. v21}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v20

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v19 .. v20}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5369
    if-nez v18, :cond_2

    .line 5371
    const/4 v15, 0x0

    .line 5373
    .local v15, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v19

    .line 5374
    const-string v20, "com.aioapp.battery"

    const/16 v21, 0x0

    .line 5373
    invoke-virtual/range {v19 .. v21}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v15

    .line 5379
    :goto_0
    const/16 v16, 0x0

    .line 5381
    .local v16, "packageInfo_cleaner":Landroid/content/pm/PackageInfo;
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v19

    .line 5382
    const-string v20, "com.evzapp.cleanmaster"

    const/16 v21, 0x0

    .line 5381
    invoke-virtual/range {v19 .. v21}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v16

    .line 5387
    :goto_1
    const/16 v17, 0x0

    .line 5389
    .local v17, "packageInfo_crush":Landroid/content/pm/PackageInfo;
    :try_start_2
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v19

    .line 5390
    const-string v20, "com.freepezzle.hexcrush"

    const/16 v21, 0x0

    .line 5389
    invoke-virtual/range {v19 .. v21}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v17

    .line 5396
    :goto_2
    if-nez v15, :cond_0

    .line 5397
    :try_start_3
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v19

    const-string v20, "shortcut_battery"

    invoke-static/range {v19 .. v20}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 5398
    new-instance v3, Landroid/content/Intent;

    .line 5399
    const-string v19, "com.android.launcher.action.INSTALL_SHORTCUT"

    .line 5398
    move-object/from16 v0, v19

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 5401
    .local v3, "addIntent":Landroid/content/Intent;
    const v19, 0x7f0200ee

    .line 5400
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Landroid/content/Intent$ShortcutIconResource;->fromContext(Landroid/content/Context;I)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v8

    .line 5402
    .local v8, "icon":Landroid/os/Parcelable;
    new-instance v12, Landroid/content/Intent;

    .line 5403
    const-class v19, Lcom/aio/downloader/activity/WidgeGametActivity;

    .line 5402
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v12, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 5404
    .local v12, "myIntent":Landroid/content/Intent;
    const-string v19, "android.intent.extra.shortcut.NAME"

    .line 5405
    const v20, 0x7f0b0001

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getString(I)Ljava/lang/String;

    move-result-object v20

    .line 5404
    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 5406
    const-string v19, "duplicate"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 5407
    const-string v19, "android.intent.extra.shortcut.ICON_RESOURCE"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 5409
    const-string v19, "android.intent.extra.shortcut.INTENT"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0, v12}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 5410
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 5412
    .end local v3    # "addIntent":Landroid/content/Intent;
    .end local v8    # "icon":Landroid/os/Parcelable;
    .end local v12    # "myIntent":Landroid/content/Intent;
    :cond_0
    if-nez v16, :cond_1

    .line 5413
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v19

    const-string v20, "shortcut_cleaner"

    invoke-static/range {v19 .. v20}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 5414
    new-instance v4, Landroid/content/Intent;

    .line 5415
    const-string v19, "com.android.launcher.action.INSTALL_SHORTCUT"

    .line 5414
    move-object/from16 v0, v19

    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 5417
    .local v4, "addIntent2":Landroid/content/Intent;
    const v19, 0x7f0200f8

    .line 5416
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Landroid/content/Intent$ShortcutIconResource;->fromContext(Landroid/content/Context;I)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v9

    .line 5418
    .local v9, "icon2":Landroid/os/Parcelable;
    new-instance v13, Landroid/content/Intent;

    .line 5419
    const-class v19, Lcom/aio/downloader/activity/WidgePaidActivity;

    .line 5418
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v13, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 5420
    .local v13, "myIntent2":Landroid/content/Intent;
    const-string v19, "android.intent.extra.shortcut.NAME"

    .line 5421
    const v20, 0x7f0b0002

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getString(I)Ljava/lang/String;

    move-result-object v20

    .line 5420
    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v4, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 5422
    const-string v19, "duplicate"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v4, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 5423
    const-string v19, "android.intent.extra.shortcut.ICON_RESOURCE"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 5426
    const-string v19, "android.intent.extra.shortcut.INTENT"

    move-object/from16 v0, v19

    invoke-virtual {v4, v0, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 5427
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 5429
    .end local v4    # "addIntent2":Landroid/content/Intent;
    .end local v9    # "icon2":Landroid/os/Parcelable;
    .end local v13    # "myIntent2":Landroid/content/Intent;
    :cond_1
    if-nez v17, :cond_2

    .line 5430
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v19

    const-string v20, "shortcut_crush"

    invoke-static/range {v19 .. v20}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 5431
    new-instance v5, Landroid/content/Intent;

    .line 5432
    const-string v19, "com.android.launcher.action.INSTALL_SHORTCUT"

    .line 5431
    move-object/from16 v0, v19

    invoke-direct {v5, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 5434
    .local v5, "addIntent3":Landroid/content/Intent;
    const v19, 0x7f0200d0

    .line 5433
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-static {v0, v1}, Landroid/content/Intent$ShortcutIconResource;->fromContext(Landroid/content/Context;I)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v10

    .line 5435
    .local v10, "icon3":Landroid/os/Parcelable;
    new-instance v14, Landroid/content/Intent;

    .line 5436
    const-class v19, Lcom/aio/downloader/activity/HexCrushActivity;

    .line 5435
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v14, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 5437
    .local v14, "myIntent3":Landroid/content/Intent;
    const-string v19, "android.intent.extra.shortcut.NAME"

    .line 5438
    const v20, 0x7f0b0003

    move-object/from16 v0, p0

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getString(I)Ljava/lang/String;

    move-result-object v20

    .line 5437
    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v5, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 5439
    const-string v19, "duplicate"

    const/16 v20, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v5, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 5440
    const-string v19, "android.intent.extra.shortcut.ICON_RESOURCE"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 5443
    const-string v19, "android.intent.extra.shortcut.INTENT"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0, v14}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 5444
    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 5453
    .end local v5    # "addIntent3":Landroid/content/Intent;
    .end local v10    # "icon3":Landroid/os/Parcelable;
    .end local v14    # "myIntent3":Landroid/content/Intent;
    .end local v15    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v16    # "packageInfo_cleaner":Landroid/content/pm/PackageInfo;
    .end local v17    # "packageInfo_crush":Landroid/content/pm/PackageInfo;
    :cond_2
    :goto_3
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->record:I

    move/from16 v19, v0

    add-int/lit8 v19, v19, 0x1

    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->record:I

    .line 5454
    add-int/lit8 v11, v11, 0x1

    .line 5455
    add-int/lit8 v18, v18, 0x1

    .line 5457
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->editor:Landroid/content/SharedPreferences$Editor;

    move-object/from16 v19, v0

    const-string v20, "first"

    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->record:I

    move/from16 v21, v0

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 5458
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->editor:Landroid/content/SharedPreferences$Editor;

    move-object/from16 v19, v0

    const-string v20, "iFirst1"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-interface {v0, v1, v11}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 5459
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->editor:Landroid/content/SharedPreferences$Editor;

    move-object/from16 v19, v0

    const-string v20, "shortcut"

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move/from16 v2, v18

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 5461
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->editor:Landroid/content/SharedPreferences$Editor;

    move-object/from16 v19, v0

    invoke-interface/range {v19 .. v19}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 5463
    return-void

    .line 5375
    .restart local v15    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v6

    .line 5376
    .local v6, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 5383
    .end local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v16    # "packageInfo_cleaner":Landroid/content/pm/PackageInfo;
    :catch_1
    move-exception v6

    .line 5384
    .restart local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1

    .line 5391
    .end local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v17    # "packageInfo_crush":Landroid/content/pm/PackageInfo;
    :catch_2
    move-exception v6

    .line 5392
    .restart local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 5447
    .end local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_3
    move-exception v7

    .line 5449
    .local v7, "e1":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3
.end method

.method private downwifi()V
    .locals 4

    .prologue
    .line 2907
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    .line 2908
    const v3, 0x7f0c000e

    .line 2907
    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 2909
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 2910
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 2911
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 2912
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 2913
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/activity/MyMainActivity$30;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/MyMainActivity$30;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2922
    new-instance v3, Lcom/aio/downloader/activity/MyMainActivity$31;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/MyMainActivity$31;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2933
    return-void
.end method

.method public static drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v6, 0x0

    .line 5469
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    .line 5471
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    .line 5473
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v2

    const/4 v5, -0x1

    if-eq v2, v5, :cond_0

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 5467
    :goto_0
    invoke-static {v3, v4, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 5477
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 5481
    .local v1, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 5482
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    .line 5481
    invoke-virtual {p0, v6, v6, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 5484
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 5486
    return-object v0

    .line 5475
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    :cond_0
    sget-object v2, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    goto :goto_0
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 2212
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 2213
    return-void
.end method

.method private getBytesDownloaded(IJ)Ljava/lang/String;
    .locals 10
    .param p1, "progress"    # I
    .param p2, "totalBytes"    # J

    .prologue
    const v9, 0x49742400    # 1000000.0f

    const/high16 v8, 0x447a0000    # 1000.0f

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 5113
    int-to-long v2, p1

    mul-long/2addr v2, p2

    const-wide/16 v4, 0x64

    div-long v0, v2, v4

    .line 5114
    .local v0, "bytesCompleted":J
    const-wide/32 v2, 0xf4240

    cmp-long v2, p2, v2

    if-ltz v2, :cond_0

    .line 5115
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 5116
    const-string v3, "%.1f"

    new-array v4, v7, [Ljava/lang/Object;

    long-to-float v5, v0

    div-float/2addr v5, v9

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 5117
    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 5118
    const-string v3, "%.1f"

    new-array v4, v7, [Ljava/lang/Object;

    long-to-float v5, p2

    div-float/2addr v5, v9

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "MB"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 5115
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5125
    :goto_0
    return-object v2

    .line 5120
    :cond_0
    const-wide/16 v2, 0x3e8

    cmp-long v2, p2, v2

    if-ltz v2, :cond_1

    .line 5121
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "%.1f"

    new-array v4, v7, [Ljava/lang/Object;

    long-to-float v5, v0

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 5122
    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "%.1f"

    new-array v4, v7, [Ljava/lang/Object;

    long-to-float v5, p2

    div-float/2addr v5, v8

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Kb"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 5121
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 5125
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method private getCpuInfo()[Ljava/lang/String;
    .locals 12

    .prologue
    const/4 v7, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 5555
    const-string v5, "/proc/cpuinfo"

    .line 5556
    .local v5, "str1":Ljava/lang/String;
    const-string v6, ""

    .line 5557
    .local v6, "str2":Ljava/lang/String;
    new-array v1, v7, [Ljava/lang/String;

    const-string v7, ""

    aput-object v7, v1, v10

    const-string v7, ""

    aput-object v7, v1, v11

    .line 5560
    .local v1, "cpuInfo":[Ljava/lang/String;
    :try_start_0
    new-instance v2, Ljava/io/FileReader;

    invoke-direct {v2, v5}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    .line 5561
    .local v2, "fr":Ljava/io/FileReader;
    new-instance v4, Ljava/io/BufferedReader;

    const/16 v7, 0x2000

    invoke-direct {v4, v2, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    .line 5562
    .local v4, "localBufferedReader":Ljava/io/BufferedReader;
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .line 5563
    const-string v7, "\\s+"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 5564
    .local v0, "arrayOfString":[Ljava/lang/String;
    const/4 v3, 0x2

    .local v3, "i":I
    :goto_0
    array-length v7, v0

    if-lt v3, v7, :cond_0

    .line 5567
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .line 5568
    const-string v7, "\\s+"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 5569
    const/4 v7, 0x1

    aget-object v8, v1, v7

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v8, 0x2

    aget-object v8, v0, v8

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v1, v7

    .line 5570
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 5573
    .end local v0    # "arrayOfString":[Ljava/lang/String;
    .end local v2    # "fr":Ljava/io/FileReader;
    .end local v3    # "i":I
    .end local v4    # "localBufferedReader":Ljava/io/BufferedReader;
    :goto_1
    const-string v7, "qwa"

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "cpuinfo:"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v9, v1, v10

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    aget-object v9, v1, v11

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5574
    return-object v1

    .line 5565
    .restart local v0    # "arrayOfString":[Ljava/lang/String;
    .restart local v2    # "fr":Ljava/io/FileReader;
    .restart local v3    # "i":I
    .restart local v4    # "localBufferedReader":Ljava/io/BufferedReader;
    :cond_0
    const/4 v7, 0x0

    :try_start_1
    new-instance v8, Ljava/lang/StringBuilder;

    const/4 v9, 0x0

    aget-object v9, v1, v9

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v9, v0, v3

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v1, v7
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 5564
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 5571
    .end local v0    # "arrayOfString":[Ljava/lang/String;
    .end local v2    # "fr":Ljava/io/FileReader;
    .end local v3    # "i":I
    .end local v4    # "localBufferedReader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v7

    goto :goto_1
.end method

.method private getNewApps()V
    .locals 2

    .prologue
    .line 1896
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/activity/MyMainActivity$23;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyMainActivity$23;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1944
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1945
    return-void
.end method

.method public static getmem_TOLAL()J
    .locals 12

    .prologue
    .line 4601
    const-string v9, "/proc/meminfo"

    .line 4602
    .local v9, "path":Ljava/lang/String;
    const/4 v3, 0x0

    .line 4603
    .local v3, "content":Ljava/lang/String;
    const/4 v1, 0x0

    .line 4605
    .local v1, "br":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/FileReader;

    invoke-direct {v10, v9}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    const/16 v11, 0x8

    invoke-direct {v2, v10, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4607
    .end local v1    # "br":Ljava/io/BufferedReader;
    .local v2, "br":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    .local v6, "line":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 4608
    move-object v3, v6

    .line 4615
    :cond_0
    if-eqz v2, :cond_3

    .line 4617
    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5

    move-object v1, v2

    .line 4624
    .end local v2    # "br":Ljava/io/BufferedReader;
    .end local v6    # "line":Ljava/lang/String;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    :cond_1
    :goto_0
    const/16 v10, 0x3a

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 4626
    .local v0, "begin":I
    const/16 v10, 0x6b

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    .line 4627
    .local v5, "end":I
    add-int/lit8 v10, v0, 0x1

    invoke-virtual {v3, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 4628
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    int-to-long v7, v10

    .line 4629
    .local v7, "mTotal":J
    return-wide v7

    .line 4610
    .end local v0    # "begin":I
    .end local v5    # "end":I
    .end local v7    # "mTotal":J
    :catch_0
    move-exception v4

    .line 4611
    .local v4, "e":Ljava/io/FileNotFoundException;
    :goto_1
    :try_start_3
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 4615
    if-eqz v1, :cond_1

    .line 4617
    :try_start_4
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 4618
    :catch_1
    move-exception v4

    .line 4619
    .local v4, "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 4612
    .end local v4    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v4

    .line 4613
    .restart local v4    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_5
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 4615
    if-eqz v1, :cond_1

    .line 4617
    :try_start_6
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_0

    .line 4618
    :catch_3
    move-exception v4

    .line 4619
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 4614
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 4615
    :goto_3
    if-eqz v1, :cond_2

    .line 4617
    :try_start_7
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    .line 4622
    :cond_2
    :goto_4
    throw v10

    .line 4618
    :catch_4
    move-exception v4

    .line 4619
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 4618
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    .restart local v6    # "line":Ljava/lang/String;
    :catch_5
    move-exception v4

    .line 4619
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .end local v4    # "e":Ljava/io/IOException;
    :cond_3
    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_0

    .line 4614
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v6    # "line":Ljava/lang/String;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v10

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_3

    .line 4612
    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catch_6
    move-exception v4

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_2

    .line 4610
    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catch_7
    move-exception v4

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_1
.end method

.method private init()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    .line 2070
    const v5, 0x7f07006f

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/refresh/PullableListView;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 2071
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v5, p0}, Lcom/aio/downloader/refresh/PullableListView;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;)V

    .line 2072
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v5, v10}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 2073
    const v5, 0x7f07006d

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->downrelelativetv:Landroid/widget/RelativeLayout;

    .line 2075
    const v5, 0x7f070266

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgetv:Landroid/widget/TextView;

    .line 2077
    const v5, 0x7f07006a

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;

    .line 2078
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;

    invoke-virtual {v5, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2080
    const-string v5, "banner_type"

    invoke-virtual {p0, v5, v10}, Lcom/aio/downloader/activity/MyMainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 2081
    const v5, 0x7f070073

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;

    .line 2083
    const v5, 0x7f070070

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->appbanner:Landroid/widget/LinearLayout;

    .line 2084
    new-instance v0, Lcom/google/ads/AdView;

    .line 2085
    sget-object v5, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 2086
    const-string v6, "ca-app-pub-2192624499353475/5842010949"

    .line 2084
    invoke-direct {v0, p0, v5, v6}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 2087
    .local v0, "adView":Lcom/google/ads/AdView;
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->appbanner:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 2088
    new-instance v5, Lcom/google/ads/AdRequest;

    invoke-direct {v5}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v0, v5}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 2092
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v5

    const-string v6, "Roboto-Light.ttf"

    .line 2091
    invoke-static {v5, v6}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->typeFace:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 2096
    :goto_0
    const v5, 0x7f070072

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 2097
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 2099
    const v5, 0x7f070066

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RadioGroup;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_group:Landroid/widget/RadioGroup;

    .line 2100
    const v5, 0x7f070068

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/views/LImageButton;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_app:Lcom/aio/downloader/views/LImageButton;

    .line 2101
    const v5, 0x7f070069

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/views/LImageButton;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_game:Lcom/aio/downloader/views/LImageButton;

    .line 2104
    const v5, 0x7f07006b

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/views/LImageButton;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_search:Lcom/aio/downloader/views/LImageButton;

    .line 2105
    const v5, 0x7f07006c

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/views/LImageButton;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->tab_down:Lcom/aio/downloader/views/LImageButton;

    .line 2106
    const v5, 0x7f070064

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/support/v4/widget/DrawerLayout;

    sput-object v5, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    .line 2107
    const v5, 0x7f070067

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/views/LImageButton;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->drawerButtonLeft:Lcom/aio/downloader/views/LImageButton;

    .line 2108
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->drawerButtonLeft:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v5, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2109
    const v5, 0x7f070071

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->mLeftGravityView:Landroid/view/View;

    .line 2110
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->mLeftGravityView:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->lp:Landroid/view/ViewGroup$LayoutParams;

    .line 2112
    const-string v5, "window"

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 2111
    check-cast v4, Landroid/view/WindowManager;

    .line 2113
    .local v4, "wm":Landroid/view/WindowManager;
    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 2114
    .local v1, "display":Landroid/view/Display;
    invoke-virtual {v1}, Landroid/view/Display;->getHeight()I

    move-result v2

    .line 2115
    .local v2, "h1":I
    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v3

    .line 2116
    .local v3, "w1":I
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->lp:Landroid/view/ViewGroup$LayoutParams;

    int-to-double v6, v3

    const-wide v8, 0x3feccccccccccccdL    # 0.9

    mul-double/2addr v6, v8

    double-to-int v6, v6

    iput v6, v5, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 2117
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->lp:Landroid/view/ViewGroup$LayoutParams;

    iput v2, v5, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 2118
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->mLeftGravityView:Landroid/view/View;

    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity;->lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v5, v6}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2121
    const v5, 0x7f040008

    .line 2120
    invoke-static {p0, v5}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;

    .line 2124
    new-instance v5, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v5, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 2125
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;

    .line 2126
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;

    const-string v6, "save_cookie"

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2127
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;

    const-string v6, "send_cookie"

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2128
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;

    const-string v6, "show_header"

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2129
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;

    const-string v6, "redirect"

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2132
    :try_start_1
    new-instance v5, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getmContext()Landroid/content/Context;

    move-result-object v6

    .line 2133
    const-string v7, "download2.db"

    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v7

    invoke-virtual {v7}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 2132
    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 2136
    :goto_1
    const-string v5, "network"

    invoke-virtual {p0, v5, v10}, Lcom/aio/downloader/activity/MyMainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;

    .line 2138
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v5, :cond_0

    .line 2139
    new-instance v5, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v5, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 2142
    :cond_0
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;

    new-instance v6, Lcom/aio/downloader/activity/MyMainActivity$24;

    invoke-direct {v6, p0}, Lcom/aio/downloader/activity/MyMainActivity$24;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    invoke-virtual {v5, v6}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 2161
    new-instance v5, Lcom/aio/downloader/views/BadgeView;

    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity;->downrelelativetv:Landroid/widget/RelativeLayout;

    invoke-direct {v5, p0, v6}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 2162
    new-instance v5, Lcom/aio/downloader/views/BadgeView;

    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgetv:Landroid/widget/TextView;

    invoke-direct {v5, p0, v6}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedowntv:Lcom/aio/downloader/views/BadgeView;

    .line 2163
    const v5, 0x7f070065

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->main_tab_top:Landroid/widget/RelativeLayout;

    .line 2165
    new-instance v5, Lcom/facebook/ads/NativeAd;

    const-string v6, "340186902832477_401790893338744"

    invoke-direct {v5, p0, v6}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 2166
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v5, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 2167
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v6, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v5, v6}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 2170
    const v5, 0x7f070297

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2172
    const v5, 0x7f070298

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2173
    const v5, 0x7f070299

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2174
    const v5, 0x7f07029a

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2176
    const v5, 0x7f07029b

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2177
    const v5, 0x7f07029c

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2178
    const v5, 0x7f07029d

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2179
    const v5, 0x7f07029e

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2180
    const v5, 0x7f07029f

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2182
    const v5, 0x7f0702a0

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2183
    const v5, 0x7f0702a1

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2184
    const v5, 0x7f0702a2

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2185
    const v5, 0x7f0702a3

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2186
    const v5, 0x7f0702a4

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2188
    const v5, 0x7f0702a5

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2189
    const v5, 0x7f0702a6

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2190
    const v5, 0x7f0702a7

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2191
    const v5, 0x7f0702a8

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2192
    const v5, 0x7f0702a9

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2193
    return-void

    .line 2134
    :catch_0
    move-exception v5

    goto/16 :goto_1

    .line 2093
    .end local v1    # "display":Landroid/view/Display;
    .end local v2    # "h1":I
    .end local v3    # "w1":I
    .end local v4    # "wm":Landroid/view/WindowManager;
    :catch_1
    move-exception v5

    goto/16 :goto_0
.end method

.method private initDownload()V
    .locals 4

    .prologue
    .line 4636
    :try_start_0
    const-string v2, "http://apk.downloadatoz.com/package/com.allinone.free.apk"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4637
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4638
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4639
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4640
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4641
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4642
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4639
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request1:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4647
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4643
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initDownload_battery()V
    .locals 4

    .prologue
    .line 4651
    :try_start_0
    const-string v2, "http://apktop.downloadatoz.com/upload_swf/com.freeapp.batterysaver.swf"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4652
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_battery:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4653
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_battery:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4654
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4655
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4656
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4657
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_battery:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4654
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request_battery:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4662
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4658
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initDownload_caller()V
    .locals 4

    .prologue
    .line 4711
    :try_start_0
    const-string v2, "http://apktop.downloadatoz.com/upload_swf/com.allinone.callerid.swf"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4712
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_caller:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4713
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_caller:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4714
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4715
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4716
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4717
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_caller:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4714
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request_caller:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4722
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4718
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initDownload_cleaner()V
    .locals 4

    .prologue
    .line 4696
    :try_start_0
    const-string v2, "http://apktop.downloadatoz.com/upload_swf/com.evzapp.cleanmaster.swf"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4697
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_cleaner:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4698
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_cleaner:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4699
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4700
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4701
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4702
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_cleaner:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_cleaner;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4699
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request_cleaner:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4707
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4703
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initDownload_crush()V
    .locals 4

    .prologue
    .line 4726
    :try_start_0
    const-string v2, "http://apktop.downloadatoz.com/upload_swf/com.freepezzle.hexcrush.swf"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4727
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_crush:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4728
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_crush:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4729
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4730
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4731
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4732
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_crush:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_crush;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4729
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request_crush:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4737
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4733
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initDownload_free()V
    .locals 4

    .prologue
    .line 4666
    :try_start_0
    const-string v2, "http://apktop.downloadatoz.com/upload_swf/com.osamahq.freestore.swf"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4667
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_free:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4668
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_free:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4669
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4670
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4671
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4672
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_free:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_free;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4669
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request_free:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4677
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4673
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initDownload_gallery()V
    .locals 4

    .prologue
    .line 4681
    :try_start_0
    const-string v2, "http://apktop.downloadatoz.com/upload_swf/com.androidapp.gallary3d.swf"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4682
    .local v1, "downloadUri":Landroid/net/Uri;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_gallery:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 4683
    .local v0, "destinationUri":Landroid/net/Uri;
    const-string v2, "jone"

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_gallery:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4684
    new-instance v2, Lcom/thin/downloadmanager/DownloadRequest;

    invoke-direct {v2, v1}, Lcom/thin/downloadmanager/DownloadRequest;-><init>(Landroid/net/Uri;)V

    .line 4685
    invoke-virtual {v2, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4686
    sget-object v3, Lcom/thin/downloadmanager/DownloadRequest$Priority;->HIGH:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4687
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity;->myDownloadStatusListener_gallery:Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_gallery;

    invoke-virtual {v2, v3}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;

    move-result-object v2

    .line 4684
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->request_gallery:Lcom/thin/downloadmanager/DownloadRequest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4692
    .end local v0    # "destinationUri":Landroid/net/Uri;
    .end local v1    # "downloadUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 4688
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method private initupdate()V
    .locals 2

    .prologue
    .line 4740
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4741
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4742
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4743
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4745
    return-void
.end method

.method private initupdate_battery()V
    .locals 2

    .prologue
    .line 4748
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4749
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4750
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4751
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4752
    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    .line 4751
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_battery:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4754
    return-void
.end method

.method private initupdate_caller()V
    .locals 2

    .prologue
    .line 4784
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4785
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4786
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4787
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4788
    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    .line 4787
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_caller:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4790
    return-void
.end method

.method private initupdate_cleaner()V
    .locals 2

    .prologue
    .line 4775
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4776
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4777
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4778
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4779
    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    .line 4778
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_cleaner:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4781
    return-void
.end method

.method private initupdate_crush()V
    .locals 2

    .prologue
    .line 4793
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4794
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4795
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4796
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4797
    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    .line 4796
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_crush:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4799
    return-void
.end method

.method private initupdate_free()V
    .locals 2

    .prologue
    .line 4757
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4758
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4759
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4760
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4761
    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    .line 4760
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_free:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4763
    return-void
.end method

.method private initupdate_gallery()V
    .locals 2

    .prologue
    .line 4766
    const v0, 0x7f070074

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    .line 4767
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 4768
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4769
    new-instance v0, Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4770
    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lcom/thin/downloadmanager/ThinDownloadManager;-><init>(I)V

    .line 4769
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_gallery:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 4772
    return-void
.end method

.method public static isBackground(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "ippid"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 5526
    .line 5527
    const-string v4, "activity"

    invoke-virtual {p0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 5526
    check-cast v0, Landroid/app/ActivityManager;

    .line 5529
    .local v0, "activityManager":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v2

    .line 5530
    .local v2, "appProcesses":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 5541
    :goto_0
    return v3

    .line 5530
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 5531
    .local v1, "appProcess":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget-object v5, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 5532
    iget v4, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v5, 0x190

    if-ne v4, v5, :cond_2

    .line 5533
    const-string v4, "\u540e\u53f0"

    iget-object v5, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 5536
    :cond_2
    const-string v3, "\u524d\u53f0"

    iget-object v4, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5537
    const/4 v3, 0x1

    goto :goto_0
.end method

.method private loadInterstitialAd()V
    .locals 2

    .prologue
    .line 5320
    new-instance v0, Lcom/facebook/ads/InterstitialAd;

    .line 5321
    const-string v1, "340186902832477_401798000004700"

    invoke-direct {v0, p0, v1}, Lcom/facebook/ads/InterstitialAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 5320
    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    .line 5322
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    invoke-virtual {v0, p0}, Lcom/facebook/ads/InterstitialAd;->setAdListener(Lcom/facebook/ads/InterstitialAdListener;)V

    .line 5324
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/facebook/ads/InterstitialAd;->loadAd()V

    .line 5326
    return-void
.end method

.method private neiTui()V
    .locals 2

    .prologue
    .line 3979
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/activity/MyMainActivity$42;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyMainActivity$42;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 4129
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 4130
    return-void
.end method

.method private updateaioApk()V
    .locals 3

    .prologue
    .line 4825
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 4827
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 4828
    const-string v2, "aioupdate.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 4827
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4829
    const-string v2, "application/vnd.android.package-archive"

    .line 4826
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 4830
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 4831
    return-void
.end method

.method private updateaioApk1()V
    .locals 3

    .prologue
    .line 4834
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 4836
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 4837
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 4838
    const-string v2, "/com.aio.downloader"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 4839
    const-string v2, "com.allinone.downloader.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 4836
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 4840
    const-string v2, "application/vnd.android.package-archive"

    .line 4835
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 4841
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 4842
    return-void
.end method

.method private viewtop()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2036
    const v1, 0x7f030070

    invoke-static {p0, v1, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 2038
    .local v0, "viewtop":Landroid/view/View;
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Lcom/aio/downloader/refresh/PullableListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 2039
    const v1, 0x7f0701a6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_fb_fragment:Landroid/widget/ImageView;

    .line 2040
    const v1, 0x7f0702aa

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->appline:Landroid/widget/LinearLayout;

    .line 2041
    const v1, 0x7f0702ab

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->gameline:Landroid/widget/LinearLayout;

    .line 2042
    const v1, 0x7f0702ac

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->paidline:Landroid/widget/LinearLayout;

    .line 2043
    const v1, 0x7f0702ad

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->datingline:Landroid/widget/LinearLayout;

    .line 2044
    const v1, 0x7f0702af

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->playnowline:Landroid/widget/RelativeLayout;

    .line 2045
    const v1, 0x7f0702b0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->havetryline:Landroid/widget/LinearLayout;

    .line 2046
    const v1, 0x7f0702b1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->view_kong:Landroid/view/View;

    .line 2048
    const v1, 0x7f0702b2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->ll_updata:Landroid/widget/LinearLayout;

    .line 2049
    const v1, 0x7f0702b3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_updata:Landroid/widget/ImageView;

    .line 2050
    const v1, 0x7f0702b4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_updata_name:Landroid/widget/TextView;

    .line 2052
    const v1, 0x7f0702b5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 2051
    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_current_version:Landroid/widget/TextView;

    .line 2054
    const v1, 0x7f0702b6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 2053
    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_updata_version:Landroid/widget/TextView;

    .line 2055
    const v1, 0x7f0702b7

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->tv_updata_size:Landroid/widget/TextView;

    .line 2056
    const v1, 0x7f0702b8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_updata_bt:Landroid/widget/ImageView;

    .line 2058
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->appline:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2059
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->gameline:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2060
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->paidline:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2061
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->datingline:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2062
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->playnowline:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2063
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->havetryline:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2064
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_updata_bt:Landroid/widget/ImageView;

    invoke-virtual {v1, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2065
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->ll_updata:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2066
    return-void
.end method


# virtual methods
.method public MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 3101
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 3103
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 3104
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 3106
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3108
    const-string v0, "Failed to connect server. Please try again."

    .line 3107
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 3109
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3224
    :goto_0
    return-void

    .line 3112
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$34;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/MyMainActivity$34;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 3222
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$34;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk1(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 3344
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 3346
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 3347
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 3349
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3351
    const-string v0, "Failed to connect server. Please try again."

    .line 3350
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 3352
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3455
    :goto_0
    return-void

    .line 3355
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$36;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/MyMainActivity$36;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 3453
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$36;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk2(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    .line 3459
    const-string v0, "gak"

    const-string v1, "MydownloadApk2"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 3461
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$37;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/aio/downloader/activity/MyMainActivity$37;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 3522
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$37;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 3523
    return-void
.end method

.method public MydownloadApk3(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 3786
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 3788
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 3789
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 3791
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3793
    const-string v0, "Failed to connect server. Please try again."

    .line 3792
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 3794
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3897
    :goto_0
    return-void

    .line 3797
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$40;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/MyMainActivity$40;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 3895
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$40;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk4(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 3671
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 3673
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 3674
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 3676
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3678
    const-string v0, "Failed to connect server. Please try again."

    .line 3677
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 3679
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3782
    :goto_0
    return-void

    .line 3682
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$39;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/MyMainActivity$39;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 3780
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$39;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk5(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 3527
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 3529
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 3530
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 3532
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3534
    const-string v0, "Failed to connect server. Please try again."

    .line 3533
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 3535
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3638
    :goto_0
    return-void

    .line 3538
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$38;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/MyMainActivity$38;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 3636
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$38;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk6(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 2974
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 2976
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 2977
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 2979
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2981
    const-string v0, "Failed to connect server. Please try again."

    .line 2980
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 2982
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3097
    :goto_0
    return-void

    .line 2985
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$33;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/MyMainActivity$33;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 3095
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$33;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk_Update(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I
    .param p5, "mIcon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 3228
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 3230
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 3231
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 3233
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3235
    const-string v0, "Failed to connect server. Please try again."

    .line 3236
    const/4 v1, 0x0

    .line 3234
    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 3236
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 3340
    :goto_0
    return-void

    .line 3239
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$35;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    move-object v9, p5

    invoke-direct/range {v0 .. v9}, Lcom/aio/downloader/activity/MyMainActivity$35;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 3338
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$35;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public createSDCardDir(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5130
    const-string v4, "mounted"

    .line 5131
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5130
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5131
    if-eqz v4, :cond_1

    .line 5132
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5133
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOUPDATE"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5134
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5135
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5136
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5138
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5139
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5141
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5144
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath:Ljava/lang/String;

    .line 5147
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath:Ljava/lang/String;

    return-object v4

    .line 5142
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public createSDCardDir_Battery(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5151
    const-string v4, "mounted"

    .line 5152
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5151
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5152
    if-eqz v4, :cond_1

    .line 5153
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5154
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOSWF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5155
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5156
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5157
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5159
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5160
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5162
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5165
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_battery:Ljava/lang/String;

    .line 5168
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_battery:Ljava/lang/String;

    return-object v4

    .line 5163
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public createSDCardDir_caller(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5235
    const-string v4, "mounted"

    .line 5236
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5235
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5236
    if-eqz v4, :cond_1

    .line 5237
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5238
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOSWF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5239
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5240
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5241
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5243
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5244
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5246
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5249
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_caller:Ljava/lang/String;

    .line 5252
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_caller:Ljava/lang/String;

    return-object v4

    .line 5247
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public createSDCardDir_cleaner(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5214
    const-string v4, "mounted"

    .line 5215
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5214
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5215
    if-eqz v4, :cond_1

    .line 5216
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5217
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOSWF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5218
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5219
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5220
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5222
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5223
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5225
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5228
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_cleaner:Ljava/lang/String;

    .line 5231
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_cleaner:Ljava/lang/String;

    return-object v4

    .line 5226
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public createSDCardDir_crush(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5256
    const-string v4, "mounted"

    .line 5257
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5256
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5257
    if-eqz v4, :cond_1

    .line 5258
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5259
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOSWF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5260
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5261
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5262
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5264
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5265
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5267
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5270
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_crush:Ljava/lang/String;

    .line 5273
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_crush:Ljava/lang/String;

    return-object v4

    .line 5268
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public createSDCardDir_free(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5172
    const-string v4, "mounted"

    .line 5173
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5172
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5173
    if-eqz v4, :cond_1

    .line 5174
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5175
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOSWF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5176
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5177
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5178
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5180
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5181
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5183
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5186
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_free:Ljava/lang/String;

    .line 5189
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_free:Ljava/lang/String;

    return-object v4

    .line 5184
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method public createSDCardDir_gallary(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 5193
    const-string v4, "mounted"

    .line 5194
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v5

    .line 5193
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 5194
    if-eqz v4, :cond_1

    .line 5195
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 5196
    .local v3, "sdcardDir":Ljava/io/File;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/AIOSWF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 5197
    .local v2, "path":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5198
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 5199
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 5201
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 5202
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    .line 5204
    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5207
    :goto_0
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_gallery:Ljava/lang/String;

    .line 5210
    .end local v0    # "dir":Ljava/io/File;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "path":Ljava/lang/String;
    .end local v3    # "sdcardDir":Ljava/io/File;
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity;->urlPath_gallery:Ljava/lang/String;

    return-object v4

    .line 5205
    .restart local v0    # "dir":Ljava/io/File;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "path":Ljava/lang/String;
    .restart local v3    # "sdcardDir":Ljava/io/File;
    :catch_0
    move-exception v4

    goto :goto_0
.end method

.method protected excuteSuCMD(Ljava/lang/String;)I
    .locals 6
    .param p1, "cmd"    # Ljava/lang/String;

    .prologue
    .line 5493
    :try_start_0
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v4

    const-string v5, "su"

    invoke-virtual {v4, v5}, Ljava/lang/Runtime;->exec(Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v2

    .line 5494
    .local v2, "process":Ljava/lang/Process;
    new-instance v0, Ljava/io/DataOutputStream;

    .line 5495
    invoke-virtual {v2}, Ljava/lang/Process;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    .line 5494
    invoke-direct {v0, v4}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 5497
    .local v0, "dos":Ljava/io/DataOutputStream;
    const-string v4, "export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n"

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 5498
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 5499
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 5500
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 5501
    const-string v4, "exit\n"

    invoke-virtual {v0, v4}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 5502
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 5503
    invoke-virtual {v2}, Ljava/lang/Process;->waitFor()I

    .line 5504
    invoke-virtual {v2}, Ljava/lang/Process;->exitValue()I

    move-result v3

    .line 5505
    .local v3, "result":I
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 5508
    .end local v0    # "dos":Ljava/io/DataOutputStream;
    .end local v2    # "process":Ljava/lang/Process;
    .end local v3    # "result":I
    :goto_0
    return v4

    .line 5506
    :catch_0
    move-exception v1

    .line 5507
    .local v1, "localException":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 5508
    const/4 v4, -0x1

    goto :goto_0
.end method

.method public finish()V
    .locals 2

    .prologue
    .line 2661
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MAIN"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2662
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 2663
    const-string v1, "android.intent.category.HOME"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 2664
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2665
    return-void
.end method

.method public getAllAppInfo()V
    .locals 20

    .prologue
    .line 1949
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v14

    .line 1951
    .local v14, "pm":Landroid/content/pm/PackageManager;
    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v13

    .line 1953
    .local v13, "packs":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    const-string v15, "qew"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1955
    new-instance v15, Lorg/json/JSONArray;

    invoke-direct {v15}, Lorg/json/JSONArray;-><init>()V

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/aio/downloader/activity/MyMainActivity;->jsonArray:Lorg/json/JSONArray;

    .line 1957
    new-instance v5, Landroid/os/Build;

    invoke-direct {v5}, Landroid/os/Build;-><init>()V

    .line 1958
    .local v5, "bd":Landroid/os/Build;
    const/4 v8, 0x0

    .line 1959
    .local v8, "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v8, Ljava/util/HashMap;

    .end local v8    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 1960
    .restart local v8    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v15

    if-lt v7, v15, :cond_0

    .line 2024
    const-string v15, "qew"

    new-instance v16, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->mListInfo:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2025
    const-string v15, "qew"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "jsonArray="

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->jsonArray:Lorg/json/JSONArray;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2027
    return-void

    .line 1962
    :cond_0
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 1964
    .local v10, "object":Lorg/json/JSONObject;
    new-instance v9, Lcom/aio/downloader/model/AppInfo;

    invoke-direct {v9}, Lcom/aio/downloader/model/AppInfo;-><init>()V

    .line 1966
    .local v9, "info":Lcom/aio/downloader/model/AppInfo;
    invoke-interface {v13, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/pm/PackageInfo;

    .line 1968
    .local v11, "p":Landroid/content/pm/PackageInfo;
    iget-object v2, v11, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 1970
    .local v2, "app":Landroid/content/pm/ApplicationInfo;
    iget v15, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v15, v15, 0x1

    if-gtz v15, :cond_1

    .line 1977
    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v15

    invoke-interface {v15}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1979
    .local v3, "appname":Ljava/lang/String;
    iget-object v12, v11, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    .line 1981
    .local v12, "packagename":Ljava/lang/String;
    iget-object v4, v11, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 1983
    .local v4, "appversion":Ljava/lang/String;
    const-string v15, "appname"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    .line 1984
    iget-object v0, v11, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 1983
    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1986
    invoke-virtual {v9, v3}, Lcom/aio/downloader/model/AppInfo;->setAppname(Ljava/lang/String;)V

    .line 1988
    invoke-virtual {v9, v12}, Lcom/aio/downloader/model/AppInfo;->setP_name(Ljava/lang/String;)V

    .line 1990
    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v15

    invoke-virtual {v9, v15}, Lcom/aio/downloader/model/AppInfo;->setAvatar(Landroid/graphics/drawable/Drawable;)V

    .line 1992
    invoke-virtual {v9, v4}, Lcom/aio/downloader/model/AppInfo;->setVersion(Ljava/lang/String;)V

    .line 2006
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/MyMainActivity;->mListInfo:Ljava/util/List;

    invoke-interface {v15, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2009
    :try_start_0
    const-string v15, "title"

    invoke-virtual {v10, v15, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2010
    const-string v15, "url_id"

    invoke-virtual {v10, v15, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2011
    const-string v15, "version"

    invoke-virtual {v10, v15, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 2012
    const-string v15, "install_time"

    .line 2013
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    .line 2012
    move-wide/from16 v0, v16

    invoke-virtual {v10, v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2019
    :goto_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/MyMainActivity;->jsonArray:Lorg/json/JSONArray;

    invoke-virtual {v15, v10}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 1960
    .end local v3    # "appname":Ljava/lang/String;
    .end local v4    # "appversion":Ljava/lang/String;
    .end local v12    # "packagename":Ljava/lang/String;
    :cond_1
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_0

    .line 2014
    .restart local v3    # "appname":Ljava/lang/String;
    .restart local v4    # "appversion":Ljava/lang/String;
    .restart local v12    # "packagename":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 2016
    .local v6, "e":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 5514
    const-wide/16 v1, 0x0

    .line 5515
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 5516
    const/4 v0, 0x0

    .line 5517
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 5518
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 5522
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 5520
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public getHeight(II)I
    .locals 1
    .param p1, "with"    # I
    .param p2, "height"    # I

    .prologue
    .line 2030
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    mul-int/2addr v0, p2

    div-int/2addr v0, p1

    return v0
.end method

.method public getmem_UNUSED(Landroid/content/Context;)J
    .locals 8
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 4590
    .line 4591
    const-string v4, "activity"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 4590
    check-cast v2, Landroid/app/ActivityManager;

    .line 4592
    .local v2, "am":Landroid/app/ActivityManager;
    new-instance v3, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v3}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 4593
    .local v3, "mi":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v2, v3}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 4594
    iget-wide v4, v3, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    const-wide/16 v6, 0x400

    div-long v0, v4, v6

    .line 4595
    .local v0, "MEM_UNUSED":J
    return-wide v0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 3901
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 3903
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 3904
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 3903
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V

    .line 3906
    return-void
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 5278
    const-string v0, "qwer"

    const-string v1, "onAdClicked"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5279
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 5280
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 5279
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 5281
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 5282
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 3
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 5286
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-ne v1, p1, :cond_2

    .line 5287
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v1, p1, :cond_1

    .line 5310
    :cond_0
    :goto_0
    return-void

    .line 5290
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 5291
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyMainActivity;->facebookad()V

    .line 5292
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->isfbshow:Z

    goto :goto_0

    .line 5293
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v1, p1, :cond_0

    .line 5294
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v1, p1, :cond_0

    .line 5297
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 5298
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_fb_fragment:Landroid/widget/ImageView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 5301
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 5302
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_fb_fragment:Landroid/widget/ImageView;

    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 5304
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->iv_fb_fragment:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 5305
    .end local v0    # "adCover":Lcom/facebook/ads/NativeAd$Image;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 30
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 2217
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v25

    sparse-switch v25, :sswitch_data_0

    .line 2657
    :cond_0
    :goto_0
    return-void

    .line 2219
    :sswitch_0
    new-instance v25, Landroid/content/Intent;

    const-class v26, Lcom/aio/downloader/activity/AppActivity1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 2222
    :sswitch_1
    new-instance v25, Landroid/content/Intent;

    const-class v26, Lcom/aio/downloader/activity/GameActivity1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 2225
    :sswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2226
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v26

    const-wide/16 v28, 0x7530

    add-long v26, v26, v28

    .line 2225
    invoke-static/range {v25 .. v27}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 2227
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;

    move-object/from16 v25, v0

    const v26, 0x7f0200d7

    invoke-virtual/range {v25 .. v26}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 2230
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->isfbshow:Z

    move/from16 v25, v0

    if-nez v25, :cond_0

    .line 2234
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v25

    const-wide/high16 v27, 0x4010000000000000L    # 4.0

    mul-double v25, v25, v27

    move-wide/from16 v0, v25

    double-to-int v0, v0

    move/from16 v25, v0

    add-int/lit8 v25, v25, 0x1

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->mRandom:I

    .line 2235
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->mRandom:I

    move/from16 v25, v0

    const/16 v26, 0x1

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_4

    .line 2238
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2239
    const-string v26, "com.evzapp.cleanmaster"

    const/16 v27, 0x0

    .line 2238
    invoke-virtual/range {v25 .. v27}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2243
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    move-object/from16 v25, v0

    if-nez v25, :cond_3

    .line 2244
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR_FOME:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_1

    .line 2245
    new-instance v3, Landroid/content/Intent;

    const-string v25, "android.intent.action.VIEW"

    move-object/from16 v0, v25

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2247
    .local v3, "aa":Landroid/content/Intent;
    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "file://"

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR:Ljava/io/File;

    move-object/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    .line 2248
    sget-object v26, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    const-string v26, "cleaner.apk"

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    .line 2247
    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v25 .. v25}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v25

    .line 2249
    const-string v26, "application/vnd.android.package-archive"

    .line 2246
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2250
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v3, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2251
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2240
    .end local v3    # "aa":Landroid/content/Intent;
    :catch_0
    move-exception v5

    .line 2241
    .local v5, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 2252
    .end local v5    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->PRO_DIR_TO:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_2

    .line 2253
    new-instance v25, Lcom/aio/downloader/activity/MyMainActivity$25;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$25;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v26, v0

    .line 2276
    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/activity/MyMainActivity$25;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2278
    :cond_2
    new-instance v7, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2279
    const-class v26, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2278
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2280
    .local v7, "intent":Landroid/content/Intent;
    const-string v25, "myid"

    const-string v26, "com.evzapp.cleanmaster"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v7, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2281
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2282
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2285
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2287
    const-string v26, "com.evzapp.cleanmaster"

    .line 2286
    invoke-virtual/range {v25 .. v26}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v7

    .line 2288
    .restart local v7    # "intent":Landroid/content/Intent;
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2289
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2291
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_4
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->mRandom:I

    move/from16 v25, v0

    const/16 v26, 0x2

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_8

    .line 2293
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2294
    invoke-virtual/range {v25 .. v25}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2295
    const-string v26, "com.freepezzle.hexcrush"

    const/16 v27, 0x0

    .line 2294
    invoke-virtual/range {v25 .. v27}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v25

    .line 2293
    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 2299
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    move-object/from16 v25, v0

    if-nez v25, :cond_7

    .line 2301
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_5

    .line 2302
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    const-wide/32 v27, 0x19ee4c

    cmp-long v25, v25, v27

    if-ltz v25, :cond_5

    .line 2303
    new-instance v3, Landroid/content/Intent;

    const-string v25, "android.intent.action.VIEW"

    move-object/from16 v0, v25

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2305
    .restart local v3    # "aa":Landroid/content/Intent;
    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "file://"

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v25 .. v25}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v25

    .line 2306
    const-string v26, "application/vnd.android.package-archive"

    .line 2304
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2307
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    .line 2338
    .end local v3    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v5

    .line 2339
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 2296
    .end local v5    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v5

    .line 2297
    .local v5, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 2308
    .end local v5    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_5
    :try_start_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHSWF:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_6

    .line 2309
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHSWF:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    const-wide/32 v27, 0x19ee4c

    cmp-long v25, v25, v27

    if-ltz v25, :cond_6

    .line 2310
    new-instance v25, Lcom/aio/downloader/activity/MyMainActivity$26;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$26;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v26, v0

    .line 2330
    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/activity/MyMainActivity$26;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2332
    :cond_6
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2333
    const-class v26, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2332
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v3, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2334
    .restart local v3    # "aa":Landroid/content/Intent;
    const-string v25, "myid"

    const-string v26, "com.freepezzle.hexcrush"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2335
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_0

    .line 2342
    .end local v3    # "aa":Landroid/content/Intent;
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2344
    const-string v26, "com.freepezzle.hexcrush"

    .line 2343
    invoke-virtual/range {v25 .. v26}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v8

    .line 2345
    .local v8, "intent5":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2348
    .end local v8    # "intent5":Landroid/content/Intent;
    :cond_8
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->mRandom:I

    move/from16 v25, v0

    const/16 v26, 0x3

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_c

    .line 2350
    :try_start_4
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2351
    const-string v26, "com.allinone.callerid"

    const/16 v27, 0x0

    .line 2350
    invoke-virtual/range {v25 .. v27}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 2355
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    move-object/from16 v25, v0

    if-nez v25, :cond_b

    .line 2357
    :try_start_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_9

    .line 2358
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    const-wide/32 v27, 0x357458

    cmp-long v25, v25, v27

    if-ltz v25, :cond_9

    .line 2359
    new-instance v7, Landroid/content/Intent;

    const-string v25, "android.intent.action.VIEW"

    move-object/from16 v0, v25

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2361
    .restart local v7    # "intent":Landroid/content/Intent;
    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "file://"

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v25 .. v25}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v25

    .line 2362
    const-string v26, "application/vnd.android.package-archive"

    .line 2360
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v7, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2363
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2364
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 2403
    .end local v7    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v5

    .line 2405
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 2352
    .end local v5    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v5

    .line 2353
    .local v5, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 2365
    .end local v5    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    :try_start_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_a

    .line 2366
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    const-wide/32 v27, 0x357458

    cmp-long v25, v25, v27

    if-ltz v25, :cond_a

    .line 2368
    new-instance v25, Lcom/aio/downloader/activity/MyMainActivity$27;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$27;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v26, v0

    .line 2393
    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/activity/MyMainActivity$27;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2396
    :cond_a
    new-instance v7, Landroid/content/Intent;

    .line 2397
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2398
    const-class v26, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2396
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2399
    .restart local v7    # "intent":Landroid/content/Intent;
    const-string v25, "myid"

    const-string v26, "com.allinone.callerid"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v7, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2400
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2401
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_0

    .line 2408
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_b
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2410
    const-string v26, "com.allinone.callerid"

    .line 2409
    invoke-virtual/range {v25 .. v26}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v7

    .line 2411
    .restart local v7    # "intent":Landroid/content/Intent;
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2412
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2414
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_c
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->mRandom:I

    move/from16 v25, v0

    const/16 v26, 0x4

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_0

    .line 2416
    :try_start_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2417
    const-string v26, "com.aioapp.battery"

    const/16 v27, 0x0

    .line 2416
    invoke-virtual/range {v25 .. v27}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 2421
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    move-object/from16 v25, v0

    if-nez v25, :cond_f

    .line 2423
    :try_start_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERYAPK:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_d

    .line 2424
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERYAPK:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    const-wide/32 v27, 0x377eff

    cmp-long v25, v25, v27

    if-ltz v25, :cond_d

    .line 2425
    new-instance v7, Landroid/content/Intent;

    const-string v25, "android.intent.action.VIEW"

    move-object/from16 v0, v25

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2427
    .restart local v7    # "intent":Landroid/content/Intent;
    new-instance v25, Ljava/lang/StringBuilder;

    const-string v26, "file://"

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERYAPK:Ljava/io/File;

    move-object/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v25 .. v25}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v25

    .line 2428
    const-string v26, "application/vnd.android.package-archive"

    .line 2426
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v7, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2429
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2430
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_0

    .line 2465
    .end local v7    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v5

    .line 2467
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 2418
    .end local v5    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v5

    .line 2419
    .local v5, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 2431
    .end local v5    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_d
    :try_start_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/io/File;->exists()Z

    move-result v25

    if-eqz v25, :cond_e

    .line 2432
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    const-wide/32 v27, 0x377eff

    cmp-long v25, v25, v27

    if-ltz v25, :cond_e

    .line 2433
    new-instance v25, Lcom/aio/downloader/activity/MyMainActivity$28;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$28;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v26, v0

    .line 2455
    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/activity/MyMainActivity$28;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2457
    :cond_e
    new-instance v7, Landroid/content/Intent;

    .line 2458
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2459
    const-class v26, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2457
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2460
    .restart local v7    # "intent":Landroid/content/Intent;
    const-string v25, "myid"

    const-string v26, "com.aioapp.battery"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v7, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2462
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2463
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_0

    .line 2470
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_f
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v25

    .line 2471
    const-string v26, "com.aioapp.battery"

    invoke-virtual/range {v25 .. v26}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v7

    .line 2472
    .restart local v7    # "intent":Landroid/content/Intent;
    const/high16 v25, 0x10000000

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2473
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2480
    .end local v7    # "intent":Landroid/content/Intent;
    :sswitch_3
    new-instance v25, Landroid/content/Intent;

    .line 2481
    const-class v26, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2480
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2484
    :sswitch_4
    new-instance v25, Landroid/content/Intent;

    .line 2485
    const-class v26, Lcom/aio/downloader/activity/DownloadAppManager;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2484
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2488
    :sswitch_5
    new-instance v25, Landroid/content/Intent;

    const-class v26, Lcom/aio/downloader/activity/AppActivity1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2491
    :sswitch_6
    new-instance v25, Landroid/content/Intent;

    const-class v26, Lcom/aio/downloader/activity/GameActivity1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2494
    :sswitch_7
    new-instance v25, Landroid/content/Intent;

    .line 2495
    const-class v26, Lcom/aio/downloader/activity/MusthaveActivity;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2494
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2498
    :sswitch_8
    new-instance v25, Landroid/content/Intent;

    const-class v26, Lcom/aio/downloader/activity/FunActivity1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2501
    :sswitch_9
    new-instance v25, Landroid/content/Intent;

    .line 2502
    const-class v26, Lcom/aio/downloader/activity/TodaysPickActivity;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2501
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2505
    :sswitch_a
    new-instance v25, Landroid/content/Intent;

    .line 2506
    const-class v26, Lcom/aio/downloader/activity/PaidforFreeActivity1;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2505
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2510
    :sswitch_b
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x5

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v25

    if-eqz v25, :cond_10

    .line 2511
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x5

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 2513
    :cond_10
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v25

    if-eqz v25, :cond_11

    .line 2514
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2516
    :cond_11
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    goto/16 :goto_0

    .line 2521
    :sswitch_c
    new-instance v11, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2522
    const-class v26, Lcom/aio/downloader/activity/MyDownloaderList;

    .line 2521
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v11, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2523
    .local v11, "intent_left_download":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2524
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2527
    .end local v11    # "intent_left_download":Landroid/content/Intent;
    :sswitch_d
    new-instance v21, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2528
    const-class v26, Lcom/aio/downloader/activity/UpdateActivity;

    .line 2527
    move-object/from16 v0, v21

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2529
    .local v21, "intent_left_update":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2530
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2533
    .end local v21    # "intent_left_update":Landroid/content/Intent;
    :sswitch_e
    new-instance v20, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2534
    const-class v26, Lcom/aio/downloader/unstall/Unstall;

    .line 2533
    move-object/from16 v0, v20

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2535
    .local v20, "intent_left_uninstall":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2536
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2539
    .end local v20    # "intent_left_uninstall":Landroid/content/Intent;
    :sswitch_f
    new-instance v15, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2540
    const-class v26, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 2539
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v15, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2541
    .local v15, "intent_left_manage":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2542
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2546
    .end local v15    # "intent_left_manage":Landroid/content/Intent;
    :sswitch_10
    new-instance v18, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2547
    const-class v26, Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 2546
    move-object/from16 v0, v18

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2548
    .local v18, "intent_left_pick":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2549
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2553
    .end local v18    # "intent_left_pick":Landroid/content/Intent;
    :sswitch_11
    new-instance v16, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2554
    const-class v26, Lcom/aio/downloader/activity/MusthaveActivity;

    .line 2553
    move-object/from16 v0, v16

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2555
    .local v16, "intent_left_must":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2556
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2559
    .end local v16    # "intent_left_must":Landroid/content/Intent;
    :sswitch_12
    new-instance v19, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2560
    const-class v26, Lcom/aio/downloader/activity/AdultActivity1;

    .line 2559
    move-object/from16 v0, v19

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2561
    .local v19, "intent_left_sex":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2562
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2565
    .end local v19    # "intent_left_sex":Landroid/content/Intent;
    :sswitch_13
    new-instance v17, Landroid/content/Intent;

    .line 2566
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    const-class v26, Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 2565
    move-object/from16 v0, v17

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2567
    .local v17, "intent_left_paidforfree":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2568
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2571
    .end local v17    # "intent_left_paidforfree":Landroid/content/Intent;
    :sswitch_14
    new-instance v12, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2572
    const-class v26, Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    .line 2571
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v12, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2573
    .local v12, "intent_left_exclusive":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2574
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2578
    .end local v12    # "intent_left_exclusive":Landroid/content/Intent;
    :sswitch_15
    new-instance v23, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2579
    const-class v26, Lcom/aio/downloader/activity/FunActivity1;

    .line 2578
    move-object/from16 v0, v23

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2581
    .local v23, "intent_left_wallpapers":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2582
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2585
    .end local v23    # "intent_left_wallpapers":Landroid/content/Intent;
    :sswitch_16
    new-instance v10, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2586
    const-class v26, Lcom/aio/downloader/activity/FunActivity1;

    .line 2585
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v10, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2587
    .local v10, "intent_left_adult":Landroid/content/Intent;
    const-string v25, "current"

    const/16 v26, 0x3

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v10, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 2588
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2589
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2592
    .end local v10    # "intent_left_adult":Landroid/content/Intent;
    :sswitch_17
    new-instance v13, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2593
    const-class v26, Lcom/aio/downloader/activity/FunActivity1;

    .line 2592
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v13, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2594
    .local v13, "intent_left_gags":Landroid/content/Intent;
    const-string v25, "current"

    const/16 v26, 0x4

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v13, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 2595
    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2596
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2599
    .end local v13    # "intent_left_gags":Landroid/content/Intent;
    :sswitch_18
    new-instance v14, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2600
    const-class v26, Lcom/aio/downloader/activity/FunActivity1;

    .line 2599
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v14, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2601
    .local v14, "intent_left_gif":Landroid/content/Intent;
    const-string v25, "current"

    const/16 v26, 0x5

    move-object/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v14, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 2602
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2603
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2606
    .end local v14    # "intent_left_gif":Landroid/content/Intent;
    :sswitch_19
    new-instance v22, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v25

    .line 2607
    const-class v26, Lcom/aio/downloader/activity/FunActivity1;

    .line 2606
    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2608
    .local v22, "intent_left_video":Landroid/content/Intent;
    const-string v25, "current"

    const/16 v26, 0x6

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    move/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 2609
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2610
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2614
    .end local v22    # "intent_left_video":Landroid/content/Intent;
    :sswitch_1a
    new-instance v25, Landroid/content/Intent;

    const-class v26, Lcom/aio/downloader/activity/MySettingsActivity;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2615
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2618
    :sswitch_1b
    new-instance v25, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v26, v0

    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 2619
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2623
    :sswitch_1c
    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v6, v0, [Ljava/lang/String;

    const/16 v25, 0x0

    const-string v26, "aio.downloader@yahoo.com.sg"

    aput-object v26, v6, v25

    .line 2624
    .local v6, "email":[Ljava/lang/String;
    new-instance v9, Landroid/content/Intent;

    const-string v25, "android.intent.action.SEND"

    move-object/from16 v0, v25

    invoke-direct {v9, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2625
    .local v9, "intent_email":Landroid/content/Intent;
    const-string v25, "message/rfc822"

    move-object/from16 v0, v25

    invoke-virtual {v9, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 2626
    const-string v25, "android.intent.extra.EMAIL"

    move-object/from16 v0, v25

    invoke-virtual {v9, v0, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 2627
    const-string v25, "E-mail"

    move-object/from16 v0, v25

    invoke-static {v9, v0}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v25

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2631
    .end local v6    # "email":[Ljava/lang/String;
    .end local v9    # "intent_email":Landroid/content/Intent;
    :sswitch_1d
    new-instance v7, Landroid/content/Intent;

    const-string v25, "android.intent.action.SEND"

    move-object/from16 v0, v25

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2632
    .restart local v7    # "intent":Landroid/content/Intent;
    const-string v25, "text/plain"

    move-object/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 2633
    const-string v25, "android.intent.extra.TEXT"

    .line 2634
    const-string v26, "http://tinyurl.com/allinone-downloader"

    .line 2633
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v7, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2635
    const-string v25, "AIO Downloaded"

    move-object/from16 v0, v25

    invoke-static {v7, v0}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v25

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 2636
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2639
    .end local v7    # "intent":Landroid/content/Intent;
    :sswitch_1e
    new-instance v4, Lcom/aio/downloader/dialog/AboutCustomDialog;

    .line 2640
    const v25, 0x7f0c000e

    .line 2639
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v4, v0, v1}, Lcom/aio/downloader/dialog/AboutCustomDialog;-><init>(Landroid/content/Context;I)V

    .line 2641
    .local v4, "dialog":Lcom/aio/downloader/dialog/AboutCustomDialog;
    const/16 v25, 0x0

    move/from16 v0, v25

    invoke-virtual {v4, v0}, Lcom/aio/downloader/dialog/AboutCustomDialog;->setCanceledOnTouchOutside(Z)V

    .line 2642
    invoke-virtual {v4}, Lcom/aio/downloader/dialog/AboutCustomDialog;->show()V

    .line 2643
    const v25, 0x7f07001e

    move/from16 v0, v25

    invoke-virtual {v4, v0}, Lcom/aio/downloader/dialog/AboutCustomDialog;->findViewById(I)Landroid/view/View;

    move-result-object v24

    check-cast v24, Landroid/widget/Button;

    .line 2644
    .local v24, "ok":Landroid/widget/Button;
    new-instance v25, Lcom/aio/downloader/activity/MyMainActivity$29;

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v4}, Lcom/aio/downloader/activity/MyMainActivity$29;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/AboutCustomDialog;)V

    invoke-virtual/range {v24 .. v25}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2652
    sget-object v25, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/16 v26, 0x3

    invoke-virtual/range {v25 .. v26}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 2217
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f070067 -> :sswitch_b
        0x7f070068 -> :sswitch_0
        0x7f070069 -> :sswitch_1
        0x7f07006a -> :sswitch_2
        0x7f07006b -> :sswitch_3
        0x7f07006c -> :sswitch_4
        0x7f070297 -> :sswitch_c
        0x7f070298 -> :sswitch_d
        0x7f070299 -> :sswitch_e
        0x7f07029a -> :sswitch_f
        0x7f07029b -> :sswitch_10
        0x7f07029c -> :sswitch_11
        0x7f07029d -> :sswitch_12
        0x7f07029e -> :sswitch_13
        0x7f07029f -> :sswitch_14
        0x7f0702a0 -> :sswitch_15
        0x7f0702a1 -> :sswitch_16
        0x7f0702a2 -> :sswitch_17
        0x7f0702a3 -> :sswitch_18
        0x7f0702a4 -> :sswitch_19
        0x7f0702a5 -> :sswitch_1a
        0x7f0702a6 -> :sswitch_1b
        0x7f0702a7 -> :sswitch_1c
        0x7f0702a8 -> :sswitch_1d
        0x7f0702a9 -> :sswitch_1e
        0x7f0702aa -> :sswitch_5
        0x7f0702ab -> :sswitch_6
        0x7f0702ac -> :sswitch_7
        0x7f0702ad -> :sswitch_8
        0x7f0702af -> :sswitch_9
        0x7f0702b0 -> :sswitch_a
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 38
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 1026
    invoke-super/range {p0 .. p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 1027
    const v4, 0x7f030009

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->setContentView(I)V

    .line 1028
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->setmContext(Landroid/content/Context;)V

    .line 1034
    const-string v4, "gak"

    const-string v5, "shouyeonCreate"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1037
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$11;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$11;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1118
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$11;->start()V

    .line 1123
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/floatwindow/FloatWindowService;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->intent_float:Landroid/content/Intent;

    .line 1125
    const-string v4, "floatctri"

    .line 1126
    const/4 v5, 0x0

    .line 1125
    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v5}, Lcom/aio/downloader/activity/MyMainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v37

    .line 1127
    .local v37, "userInfo_float":Landroid/content/SharedPreferences;
    const-string v4, "fctri"

    const/4 v5, 0x1

    move-object/from16 v0, v37

    invoke-interface {v0, v4, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v32

    .line 1128
    .local v32, "showfloat":Z
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/floatwindow/FloatWindowService;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->intent_float:Landroid/content/Intent;

    .line 1129
    if-eqz v32, :cond_d

    .line 1131
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->intent_float:Landroid/content/Intent;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1135
    :goto_0
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1139
    const v4, 0x7f07005a

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi:Landroid/widget/ImageView;

    .line 1140
    const v4, 0x7f07005b

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi1:Landroid/widget/ImageView;

    .line 1141
    const v4, 0x7f07005c

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi2:Landroid/widget/ImageView;

    .line 1142
    const v4, 0x7f07005d

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi3:Landroid/widget/ImageView;

    .line 1143
    const v4, 0x7f07005e

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi4:Landroid/widget/ImageView;

    .line 1144
    const v4, 0x7f07005f

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi5:Landroid/widget/ImageView;

    .line 1145
    const v4, 0x7f070060

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi6:Landroid/widget/ImageView;

    .line 1146
    const v4, 0x7f070061

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi7:Landroid/widget/ImageView;

    .line 1147
    const v4, 0x7f070062

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi8:Landroid/widget/ImageView;

    .line 1148
    const v4, 0x7f070063

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi9:Landroid/widget/ImageView;

    .line 1150
    const-string v4, "notification"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/app/NotificationManager;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->mNotificationManager8:Landroid/app/NotificationManager;

    .line 1152
    const-string v4, "countName_first"

    .line 1153
    const/4 v5, 0x0

    .line 1152
    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v5}, Lcom/aio/downloader/activity/MyMainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 1154
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->editor:Landroid/content/SharedPreferences$Editor;

    .line 1157
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v5, "first"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v28

    .line 1159
    .local v28, "record":I
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->count()V

    .line 1160
    const-string v4, "record"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "record="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, v28

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1161
    const/4 v4, 0x1

    sput-boolean v4, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    .line 1164
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "todayid"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->todayid:Ljava/lang/String;

    .line 1165
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "myid"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->id:Ljava/lang/String;

    .line 1166
    const-string v4, "rtrt"

    new-instance v5, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->id:Ljava/lang/String;

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "3333333333333"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1167
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->id:Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 1168
    new-instance v35, Landroid/content/Intent;

    .line 1169
    const-class v4, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1168
    move-object/from16 v0, v35

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1170
    .local v35, "ti":Landroid/content/Intent;
    const-string v4, "tuijianboolean"

    const/4 v5, 0x1

    move-object/from16 v0, v35

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1171
    const-string v4, "linkurl"

    const-string v5, ""

    move-object/from16 v0, v35

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1172
    const-string v4, "myid"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->id:Ljava/lang/String;

    move-object/from16 v0, v35

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1173
    move-object/from16 v0, p0

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    .line 1175
    .end local v35    # "ti":Landroid/content/Intent;
    :cond_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->todayid:Ljava/lang/String;

    if-eqz v4, :cond_1

    .line 1176
    new-instance v35, Landroid/content/Intent;

    .line 1177
    const-class v4, Lcom/aio/downloader/activity/TodaysPickActivity;

    .line 1176
    move-object/from16 v0, v35

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1178
    .restart local v35    # "ti":Landroid/content/Intent;
    const-string v4, "todayboolean"

    const/4 v5, 0x1

    move-object/from16 v0, v35

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1179
    const-string v4, "todayid"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->todayid:Ljava/lang/String;

    move-object/from16 v0, v35

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1180
    move-object/from16 v0, p0

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_f

    .line 1186
    .end local v35    # "ti":Landroid/content/Intent;
    :cond_1
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    .line 1187
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1188
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1187
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->make_path_ready(Ljava/lang/String;)V

    .line 1189
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1190
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "AIO_PICTURE"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1189
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->make_path_ready(Ljava/lang/String;)V

    .line 1191
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1192
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "AIO_GIF"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1191
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->make_path_ready(Ljava/lang/String;)V

    .line 1193
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1194
    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "AIO_BACKUPAPP"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 1193
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->make_path_ready(Ljava/lang/String;)V

    .line 1196
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->recoverSetting()V

    .line 1197
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->record_run_times()V

    .line 1198
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V

    .line 1199
    const/4 v4, 0x1

    sput-boolean v4, Lcom/aio/downloader/utils/Myutils;->detail_save:Z

    .line 1200
    const/4 v4, 0x1

    sput-boolean v4, Lcom/aio/downloader/utils/Myutils;->today_save:Z

    .line 1204
    :try_start_1
    invoke-static/range {p0 .. p0}, Lcom/aio/downloader/utils/publicTools;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 1205
    new-instance v10, Lcom/aio/downloader/dialog/NointentDialog;

    .line 1206
    const v4, 0x7f0c000e

    .line 1205
    move-object/from16 v0, p0

    invoke-direct {v10, v0, v4}, Lcom/aio/downloader/dialog/NointentDialog;-><init>(Landroid/content/Context;I)V

    .line 1207
    .local v10, "dialog":Lcom/aio/downloader/dialog/NointentDialog;
    const/4 v4, 0x0

    invoke-virtual {v10, v4}, Lcom/aio/downloader/dialog/NointentDialog;->setCanceledOnTouchOutside(Z)V

    .line 1208
    invoke-virtual {v10}, Lcom/aio/downloader/dialog/NointentDialog;->show()V

    .line 1210
    const v4, 0x7f070141

    invoke-virtual {v10, v4}, Lcom/aio/downloader/dialog/NointentDialog;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .line 1209
    check-cast v25, Landroid/widget/Button;

    .line 1211
    .local v25, "networkcancel":Landroid/widget/Button;
    const v4, 0x7f070142

    invoke-virtual {v10, v4}, Lcom/aio/downloader/dialog/NointentDialog;->findViewById(I)Landroid/view/View;

    move-result-object v26

    check-cast v26, Landroid/widget/Button;

    .line 1212
    .local v26, "networkok":Landroid/widget/Button;
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$12;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v10}, Lcom/aio/downloader/activity/MyMainActivity$12;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/NointentDialog;)V

    move-object/from16 v0, v25

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1220
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$13;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v10}, Lcom/aio/downloader/activity/MyMainActivity$13;-><init>(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/dialog/NointentDialog;)V

    move-object/from16 v0, v26

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_e

    .line 1238
    .end local v10    # "dialog":Lcom/aio/downloader/dialog/NointentDialog;
    .end local v25    # "networkcancel":Landroid/widget/Button;
    .end local v26    # "networkok":Landroid/widget/Button;
    :cond_2
    :goto_2
    :try_start_2
    invoke-static/range {p0 .. p0}, Lcom/aio/downloader/utils/publicTools;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 1239
    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->set_a_random_user_agent()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_d

    .line 1248
    :cond_3
    :goto_3
    :try_start_3
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "run_times"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    move-object/from16 v0, p0

    iput v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->run_time:I
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    .line 1255
    :goto_4
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initView()V

    .line 1256
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->init()V

    .line 1257
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->buildlistener()V

    .line 1258
    invoke-static/range {p0 .. p0}, Lcom/aio/downloader/utils/publicTools;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 1259
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->neiTui()V

    .line 1260
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->Recommed_Url()V

    .line 1262
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$Mya3;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya3;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$Mya3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1263
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$Mya2;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya2;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$Mya2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1265
    move-object/from16 v0, p0

    iget v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->run_time:I

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    .line 1266
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$Mya1;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1268
    :cond_4
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$Mya4;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya4;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$Mya4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1269
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$Mya5;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$Mya5;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1272
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 1274
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetPiadTime(Landroid/content/Context;)J

    move-result-wide v6

    .line 1272
    sub-long v14, v4, v6

    .line 1275
    .local v14, "i1":J
    const-string v4, "qwer"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "ppp="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v14, v15}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1283
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$14;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$14;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1331
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$14;->start()V

    .line 1337
    .end local v14    # "i1":J
    :cond_5
    new-instance v4, Lcom/facebook/ads/NativeAd;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "340186902832477_436045309913302"

    invoke-direct {v4, v5, v6}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 1338
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    move-object/from16 v0, p0

    invoke-virtual {v4, v0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 1339
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v5, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v4, v5}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 1342
    new-instance v21, Landroid/content/IntentFilter;

    invoke-direct/range {v21 .. v21}, Landroid/content/IntentFilter;-><init>()V

    .line 1343
    .local v21, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v4, "homeapp"

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1344
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->numbertip:Landroid/content/BroadcastReceiver;

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-virtual {v0, v4, v1}, Lcom/aio/downloader/activity/MyMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1347
    new-instance v22, Landroid/content/IntentFilter;

    invoke-direct/range {v22 .. v22}, Landroid/content/IntentFilter;-><init>()V

    .line 1348
    .local v22, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v4, "showhomefeatured"

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1349
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->showhomeapp:Landroid/content/BroadcastReceiver;

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-virtual {v0, v4, v1}, Lcom/aio/downloader/activity/MyMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1351
    new-instance v23, Landroid/content/IntentFilter;

    invoke-direct/range {v23 .. v23}, Landroid/content/IntentFilter;-><init>()V

    .line 1352
    .local v23, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v4, "hidehomefeatured"

    move-object/from16 v0, v23

    invoke-virtual {v0, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1353
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->hidehomeapp:Landroid/content/BroadcastReceiver;

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v4, v1}, Lcom/aio/downloader/activity/MyMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1355
    new-instance v24, Landroid/content/IntentFilter;

    invoke-direct/range {v24 .. v24}, Landroid/content/IntentFilter;-><init>()V

    .line 1356
    .local v24, "myIntentFilter4":Landroid/content/IntentFilter;
    const-string v4, "homeapp"

    move-object/from16 v0, v24

    invoke-virtual {v0, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1357
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->homeapp:Landroid/content/BroadcastReceiver;

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v4, v1}, Lcom/aio/downloader/activity/MyMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1359
    new-instance v20, Landroid/content/IntentFilter;

    invoke-direct/range {v20 .. v20}, Landroid/content/IntentFilter;-><init>()V

    .line 1360
    .local v20, "loadmore":Landroid/content/IntentFilter;
    const-string v4, "load_more"

    move-object/from16 v0, v20

    invoke-virtual {v0, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1361
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->load_more:Landroid/content/BroadcastReceiver;

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v4, v1}, Lcom/aio/downloader/activity/MyMainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1362
    new-instance v17, Landroid/content/Intent;

    const-class v4, Lcom/aio/downloader/service/MyService;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1363
    .local v17, "intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1364
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->viewtop()V

    .line 1366
    :try_start_4
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "shotcut"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 1367
    invoke-static/range {p0 .. p0}, Lcom/aio/downloader/utils/Myutils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 1368
    const-string v5, "3.3.9"

    .line 1367
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 1368
    if-nez v4, :cond_e

    .line 1369
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "shotcut"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 1370
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_1

    .line 1389
    :cond_6
    :goto_5
    const-string v4, "aioupdate.apk"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir(Ljava/lang/String;)Ljava/lang/String;

    .line 1390
    const-string v4, "battery.swf"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir_Battery(Ljava/lang/String;)Ljava/lang/String;

    .line 1391
    const-string v4, "freestore.swf"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir_free(Ljava/lang/String;)Ljava/lang/String;

    .line 1392
    const-string v4, "gallery.swf"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir_gallary(Ljava/lang/String;)Ljava/lang/String;

    .line 1393
    const-string v4, "cleaner.swf"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir_cleaner(Ljava/lang/String;)Ljava/lang/String;

    .line 1394
    const-string v4, "caller.swf"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir_caller(Ljava/lang/String;)Ljava/lang/String;

    .line 1395
    const-string v4, "crush.swf"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->createSDCardDir_crush(Ljava/lang/String;)Ljava/lang/String;

    .line 1397
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate()V

    .line 1398
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate_battery()V

    .line 1399
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate_free()V

    .line 1400
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate_gallery()V

    .line 1401
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate_cleaner()V

    .line 1402
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate_caller()V

    .line 1403
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initupdate_crush()V

    .line 1405
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload()V

    .line 1406
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload_battery()V

    .line 1407
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload_free()V

    .line 1408
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload_gallery()V

    .line 1409
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload_cleaner()V

    .line 1410
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload_caller()V

    .line 1411
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->initDownload_crush()V

    .line 1413
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 1414
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v27

    .line 1416
    .local v27, "pm":Landroid/content/pm/PackageManager;
    const/16 v4, 0x2000

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v8

    .line 1417
    .local v8, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_6
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v4

    if-lt v13, v4, :cond_f

    .line 1426
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE2:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 1427
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE2:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    .line 1429
    :cond_7
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v5, "com.allinone.downloader"

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_8

    .line 1431
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v5, "com.allinone.downloader"

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->deletefile(Ljava/lang/String;)V

    .line 1437
    :cond_8
    :try_start_5
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_battery:Lcom/thin/downloadmanager/ThinDownloadManager;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->query(I)I

    move-result v4

    const/16 v5, 0x20

    if-ne v4, v5, :cond_9

    .line 1438
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-gez v4, :cond_9

    .line 1439
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_9

    .line 1440
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_battery:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 1441
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->request_battery:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->add(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v4

    .line 1440
    move-object/from16 v0, p0

    iput v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I

    .line 1442
    const-string v4, "download"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "downloadId_battery="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catch Ljava/lang/IllegalArgumentException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4

    .line 1470
    :cond_9
    :goto_7
    :try_start_6
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_gallery:Lcom/thin/downloadmanager/ThinDownloadManager;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_gallery:I

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->query(I)I

    move-result v4

    const/16 v5, 0x20

    if-ne v4, v5, :cond_a

    .line 1471
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOGALLERY:Ljava/io/File;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x1bff04

    cmp-long v4, v4, v6

    if-gez v4, :cond_a

    .line 1472
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_a

    .line 1473
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_gallery:Lcom/thin/downloadmanager/ThinDownloadManager;

    .line 1474
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->request_gallery:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->add(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v4

    .line 1473
    move-object/from16 v0, p0

    iput v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_gallery:I

    .line 1475
    const-string v4, "download"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "downloadId_gallery="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_gallery:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catch Ljava/lang/IllegalArgumentException; {:try_start_6 .. :try_end_6} :catch_5
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_6

    .line 1486
    :cond_a
    :goto_8
    :try_start_7
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_caller:Lcom/thin/downloadmanager/ThinDownloadManager;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->query(I)I

    move-result v4

    const/16 v5, 0x20

    if-ne v4, v5, :cond_b

    .line 1487
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x4e87bd

    cmp-long v4, v4, v6

    if-gez v4, :cond_b

    .line 1488
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_b

    .line 1489
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_caller:Lcom/thin/downloadmanager/ThinDownloadManager;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->request_caller:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->add(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v4

    move-object/from16 v0, p0

    iput v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I

    .line 1490
    const-string v4, "download"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "downloadId_caller="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_7
    .catch Ljava/lang/IllegalArgumentException; {:try_start_7 .. :try_end_7} :catch_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_8

    .line 1501
    :cond_b
    :goto_9
    :try_start_8
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_crush:Lcom/thin/downloadmanager/ThinDownloadManager;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_crush:I

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->query(I)I

    move-result v4

    const/16 v5, 0x20

    if-ne v4, v5, :cond_c

    .line 1502
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->AIOCRUSHSWF:Ljava/io/File;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19edc6

    cmp-long v4, v4, v6

    if-gez v4, :cond_c

    .line 1503
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_c

    .line 1504
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_crush:Lcom/thin/downloadmanager/ThinDownloadManager;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->request_crush:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v4, v5}, Lcom/thin/downloadmanager/ThinDownloadManager;->add(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v4

    move-object/from16 v0, p0

    iput v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_crush:I

    .line 1505
    const-string v4, "download"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "downloadId_crush="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->downloadId_crush:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_9

    .line 1531
    :cond_c
    :goto_a
    :try_start_9
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "acquire_url_start"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_c

    .line 1536
    :goto_b
    const-string v4, "acquire_url_start"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "acquire_url_start="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1537
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_12

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    if-eqz v4, :cond_12

    .line 1538
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "aio"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_14

    .line 1539
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "acquire_aio"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1540
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v33

    .line 1541
    .local v33, "str":[Ljava/lang/String;
    move-object/from16 v0, v33

    array-length v4, v0

    add-int/lit8 v4, v4, -0x1

    aget-object v4, v33, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->version:Ljava/lang/String;

    .line 1542
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "bundle_id="

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v34

    .line 1543
    .local v34, "str2":[Ljava/lang/String;
    const/4 v4, 0x1

    aget-object v30, v34, v4

    .line 1544
    .local v30, "s2":Ljava/lang/String;
    const-string v4, "&"

    move-object/from16 v0, v30

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v31

    .line 1545
    .local v31, "s3":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v31, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->appid:Ljava/lang/String;

    .line 1546
    const-string v4, "goo"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "++++"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->appid:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1547
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;

    const-string v5, "isopen"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-eqz v4, :cond_11

    .line 1549
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-eq v4, v5, :cond_11

    .line 1550
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V

    .line 1892
    .end local v30    # "s2":Ljava/lang/String;
    .end local v31    # "s3":[Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :goto_c
    return-void

    .line 1133
    .end local v8    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .end local v13    # "i":I
    .end local v17    # "intent":Landroid/content/Intent;
    .end local v20    # "loadmore":Landroid/content/IntentFilter;
    .end local v21    # "myIntentFilter":Landroid/content/IntentFilter;
    .end local v22    # "myIntentFilter2":Landroid/content/IntentFilter;
    .end local v23    # "myIntentFilter3":Landroid/content/IntentFilter;
    .end local v24    # "myIntentFilter4":Landroid/content/IntentFilter;
    .end local v27    # "pm":Landroid/content/pm/PackageManager;
    .end local v28    # "record":I
    :cond_d
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->intent_float:Landroid/content/Intent;

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->stopService(Landroid/content/Intent;)Z

    goto/16 :goto_0

    .line 1250
    .restart local v28    # "record":I
    :catch_0
    move-exception v11

    .line 1252
    .local v11, "e":Lorg/json/JSONException;
    invoke-virtual {v11}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_4

    .line 1373
    .end local v11    # "e":Lorg/json/JSONException;
    .restart local v17    # "intent":Landroid/content/Intent;
    .restart local v20    # "loadmore":Landroid/content/IntentFilter;
    .restart local v21    # "myIntentFilter":Landroid/content/IntentFilter;
    .restart local v22    # "myIntentFilter2":Landroid/content/IntentFilter;
    .restart local v23    # "myIntentFilter3":Landroid/content/IntentFilter;
    .restart local v24    # "myIntentFilter4":Landroid/content/IntentFilter;
    :cond_e
    :try_start_a
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "shotcut"

    const/4 v6, 0x1

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 1374
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_a
    .catch Lorg/json/JSONException; {:try_start_a .. :try_end_a} :catch_1

    goto/16 :goto_5

    .line 1378
    :catch_1
    move-exception v11

    .line 1380
    .restart local v11    # "e":Lorg/json/JSONException;
    :try_start_b
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "shotcut"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 1381
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_b
    .catch Lorg/json/JSONException; {:try_start_b .. :try_end_b} :catch_2

    .line 1386
    :goto_d
    invoke-virtual {v11}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_5

    .line 1382
    :catch_2
    move-exception v12

    .line 1384
    .local v12, "e1":Lorg/json/JSONException;
    invoke-virtual {v12}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_d

    .line 1418
    .end local v11    # "e":Lorg/json/JSONException;
    .end local v12    # "e1":Lorg/json/JSONException;
    .restart local v8    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .restart local v13    # "i":I
    .restart local v27    # "pm":Landroid/content/pm/PackageManager;
    :cond_f
    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget v4, v4, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v4, v4, 0x1

    if-nez v4, :cond_10

    .line 1419
    new-instance v16, Lcom/aio/downloader/model/Info;

    invoke-direct/range {v16 .. v16}, Lcom/aio/downloader/model/Info;-><init>()V

    .line 1420
    .local v16, "info":Lcom/aio/downloader/model/Info;
    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/aio/downloader/model/Info;->setName(Ljava/lang/String;)V

    .line 1421
    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    move-object/from16 v0, v27

    invoke-virtual {v4, v0}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/aio/downloader/model/Info;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 1422
    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/aio/downloader/model/Info;->setPackagename(Ljava/lang/String;)V

    .line 1423
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->infos:Ljava/util/List;

    move-object/from16 v0, v16

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1417
    .end local v16    # "info":Lcom/aio/downloader/model/Info;
    :cond_10
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_6

    .line 1444
    :catch_3
    move-exception v12

    .line 1446
    .local v12, "e1":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v12}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto/16 :goto_7

    .line 1447
    .end local v12    # "e1":Ljava/lang/IllegalArgumentException;
    :catch_4
    move-exception v12

    .line 1449
    .local v12, "e1":Ljava/lang/Exception;
    invoke-virtual {v12}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_7

    .line 1477
    .end local v12    # "e1":Ljava/lang/Exception;
    :catch_5
    move-exception v12

    .line 1479
    .local v12, "e1":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v12}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto/16 :goto_8

    .line 1480
    .end local v12    # "e1":Ljava/lang/IllegalArgumentException;
    :catch_6
    move-exception v12

    .line 1482
    .local v12, "e1":Ljava/lang/Exception;
    invoke-virtual {v12}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_8

    .line 1492
    .end local v12    # "e1":Ljava/lang/Exception;
    :catch_7
    move-exception v12

    .line 1494
    .local v12, "e1":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v12}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto/16 :goto_9

    .line 1495
    .end local v12    # "e1":Ljava/lang/IllegalArgumentException;
    :catch_8
    move-exception v12

    .line 1497
    .local v12, "e1":Ljava/lang/Exception;
    invoke-virtual {v12}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_9

    .line 1507
    .end local v12    # "e1":Ljava/lang/Exception;
    :catch_9
    move-exception v11

    .line 1509
    .local v11, "e":Ljava/lang/Exception;
    invoke-virtual {v11}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_a

    .line 1555
    .end local v11    # "e":Ljava/lang/Exception;
    .restart local v30    # "s2":Ljava/lang/String;
    .restart local v31    # "s3":[Ljava/lang/String;
    .restart local v33    # "str":[Ljava/lang/String;
    .restart local v34    # "str2":[Ljava/lang/String;
    :cond_11
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->appid:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_13

    .line 1556
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$15;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$15;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1568
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$15;->start()V

    .line 1569
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$16;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$16;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 1625
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity$16;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1859
    .end local v30    # "s2":Ljava/lang/String;
    .end local v31    # "s3":[Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_12
    :goto_e
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 1860
    const-class v6, Lcom/aio/downloader/service/BatteryInfoService1;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1859
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1861
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/service/ServiceGallery;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1862
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/service/ServiceToggle;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1864
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/service/ServiceCleaner;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1865
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/aio/downloader/service/ServiceUpdate;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 1867
    sget-object v9, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 1868
    .local v9, "banbeng":Ljava/lang/String;
    const-string v4, "qwa"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "==="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1871
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getAllAppInfo()V

    .line 1873
    const-string v4, "phone"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v36

    .line 1872
    check-cast v36, Landroid/telephony/TelephonyManager;

    .line 1874
    .local v36, "tm":Landroid/telephony/TelephonyManager;
    invoke-virtual/range {v36 .. v36}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dEVICE_ID:Ljava/lang/String;

    .line 1875
    const-string v4, "gog"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "DEVICE_ID="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->dEVICE_ID:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u624b\u673a\u578b\u53f7\uff1a"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 1876
    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1875
    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1878
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getNewApps()V

    .line 1879
    new-instance v2, Ljava/util/Timer;

    invoke-direct {v2}, Ljava/util/Timer;-><init>()V

    .line 1880
    .local v2, "timer":Ljava/util/Timer;
    new-instance v3, Lcom/aio/downloader/activity/MyMainActivity$22;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/aio/downloader/activity/MyMainActivity$22;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1890
    .local v3, "task":Ljava/util/TimerTask;
    const-wide/16 v4, 0x3e8

    const-wide/16 v6, 0x7530

    invoke-virtual/range {v2 .. v7}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    goto/16 :goto_c

    .line 1628
    .end local v2    # "timer":Ljava/util/Timer;
    .end local v3    # "task":Ljava/util/TimerTask;
    .end local v9    # "banbeng":Ljava/lang/String;
    .end local v36    # "tm":Landroid/telephony/TelephonyManager;
    .restart local v30    # "s2":Ljava/lang/String;
    .restart local v31    # "s3":[Ljava/lang/String;
    .restart local v33    # "str":[Ljava/lang/String;
    .restart local v34    # "str2":[Ljava/lang/String;
    :cond_13
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V

    goto/16 :goto_e

    .line 1631
    .end local v30    # "s2":Ljava/lang/String;
    .end local v31    # "s3":[Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_14
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "http"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_15

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    .line 1632
    const-string v5, "https"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_19

    :cond_15
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, ".apk"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_19

    .line 1633
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v33

    .line 1634
    .restart local v33    # "str":[Ljava/lang/String;
    const/4 v4, 0x1

    aget-object v29, v33, v4

    .line 1635
    .local v29, "s1":Ljava/lang/String;
    const-string v4, ".apk"

    move-object/from16 v0, v29

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v34

    .line 1636
    .restart local v34    # "str2":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v34, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    .line 1637
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_16

    .line 1638
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    .line 1640
    :cond_16
    const-string v4, "gak"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "acquire_url_start____http==========="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1641
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "acquire_apk"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1642
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;

    const-string v5, "isopen"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-eqz v4, :cond_17

    .line 1644
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-eq v4, v5, :cond_17

    .line 1645
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V

    goto/16 :goto_c

    .line 1650
    :cond_17
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_18

    .line 1651
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$17;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$17;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1663
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$17;->start()V

    .line 1665
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    .line 1666
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->s2:Ljava/lang/String;

    .line 1667
    const-string v6, "http://android.downloadatoz.com/_201409/img/aio_default_icon.png"

    .line 1668
    const v7, 0x2488f0

    .line 1664
    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v5, v6, v7}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk3(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_e

    .line 1670
    :cond_18
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V

    goto/16 :goto_e

    .line 1672
    .end local v29    # "s1":Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_19
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "market"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1a

    .line 1673
    const-string v4, "gak"

    const-string v5, "market"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1675
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v33

    .line 1676
    .restart local v33    # "str":[Ljava/lang/String;
    const/4 v4, 0x1

    aget-object v29, v33, v4

    .line 1677
    .restart local v29    # "s1":Ljava/lang/String;
    const-string v4, "&"

    move-object/from16 v0, v29

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v34

    .line 1678
    .restart local v34    # "str2":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v34, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname:Ljava/lang/String;

    .line 1679
    const-string v4, "gak"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "s1="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1680
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 1681
    const-string v5, "acquire__market"

    .line 1680
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1682
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$18;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$18;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1694
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$18;->start()V

    .line 1695
    new-instance v18, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 1696
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1695
    move-object/from16 v0, v18

    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1697
    .local v18, "intent_2":Landroid/content/Intent;
    const-string v4, "myid"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1698
    const-string v4, "linkurl"

    const-string v5, ""

    move-object/from16 v0, v18

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1699
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_e

    .line 1700
    .end local v18    # "intent_2":Landroid/content/Intent;
    .end local v29    # "s1":Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_1a
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "http"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1b

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    .line 1701
    const-string v5, "https"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1f

    .line 1702
    :cond_1b
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, ".mp3"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1f

    .line 1703
    const-string v4, "gak"

    const-string v5, "mp3"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1704
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "acquire_mp3"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1705
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v33

    .line 1706
    .restart local v33    # "str":[Ljava/lang/String;
    move-object/from16 v0, v33

    array-length v4, v0

    add-int/lit8 v4, v4, -0x1

    aget-object v29, v33, v4

    .line 1707
    .restart local v29    # "s1":Ljava/lang/String;
    const-string v4, ".mp3"

    move-object/from16 v0, v29

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v34

    .line 1708
    .restart local v34    # "str2":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v34, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    .line 1709
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1c

    .line 1710
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    .line 1714
    :cond_1c
    :try_start_c
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    const-string v5, "utf-8"

    invoke-static {v4, v5}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;
    :try_end_c
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_c .. :try_end_c} :catch_a

    .line 1720
    :goto_f
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;

    const-string v5, "isopen"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-eqz v4, :cond_1d

    .line 1722
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-eq v4, v5, :cond_1d

    .line 1723
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V

    goto/16 :goto_c

    .line 1715
    :catch_a
    move-exception v11

    .line 1717
    .local v11, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v11}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_f

    .line 1728
    .end local v11    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1d
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_1e

    .line 1729
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$19;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$19;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1741
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$19;->start()V

    .line 1743
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    .line 1744
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp3:Ljava/lang/String;

    .line 1745
    const-string v6, "http://android.downloadatoz.com/_201409/market/img/mp3.png"

    .line 1746
    const v7, 0x2488f0

    .line 1742
    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v5, v6, v7}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk4(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_e

    .line 1748
    :cond_1e
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V

    goto/16 :goto_e

    .line 1750
    .end local v29    # "s1":Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_1f
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "http"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_20

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    .line 1751
    const-string v5, "https"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_24

    .line 1752
    :cond_20
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, ".mp4"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_24

    .line 1753
    const-string v4, "gak"

    const-string v5, "mp4"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1754
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "acquire_mp4"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1755
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v33

    .line 1756
    .restart local v33    # "str":[Ljava/lang/String;
    move-object/from16 v0, v33

    array-length v4, v0

    add-int/lit8 v4, v4, -0x1

    aget-object v29, v33, v4

    .line 1757
    .restart local v29    # "s1":Ljava/lang/String;
    const-string v4, ".mp4"

    move-object/from16 v0, v29

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v34

    .line 1758
    .restart local v34    # "str2":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v34, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    .line 1759
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_21

    .line 1760
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    .line 1764
    :cond_21
    :try_start_d
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    const-string v5, "utf-8"

    invoke-static {v4, v5}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;
    :try_end_d
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_d .. :try_end_d} :catch_b

    .line 1770
    :goto_10
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->spnetworkre:Landroid/content/SharedPreferences;

    const-string v5, "isopen"

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-eqz v4, :cond_22

    .line 1772
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v4

    const/4 v5, 0x1

    if-eq v4, v5, :cond_22

    .line 1773
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->downwifi()V

    goto/16 :goto_c

    .line 1765
    :catch_b
    move-exception v11

    .line 1767
    .restart local v11    # "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v11}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_10

    .line 1778
    .end local v11    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_22
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_23

    .line 1779
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$20;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$20;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1791
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$20;->start()V

    .line 1793
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    .line 1794
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_mp4:Ljava/lang/String;

    .line 1795
    const-string v6, "http://android.downloadatoz.com/_201409/img/video_icon.png"

    .line 1796
    const v7, 0x2488f0

    .line 1792
    move-object/from16 v0, p0

    invoke-virtual {v0, v4, v5, v6, v7}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk5(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_e

    .line 1798
    :cond_23
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V

    goto/16 :goto_e

    .line 1801
    .end local v29    # "s1":Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_24
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "http"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_25

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    .line 1802
    const-string v5, "https"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_26

    .line 1803
    :cond_25
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "play.google.com"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_26

    .line 1804
    const-string v4, "gak"

    const-string v5, "market"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1805
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    const-string v5, "id="

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v33

    .line 1806
    .restart local v33    # "str":[Ljava/lang/String;
    move-object/from16 v0, v33

    array-length v4, v0

    add-int/lit8 v4, v4, -0x1

    aget-object v29, v33, v4

    .line 1807
    .restart local v29    # "s1":Ljava/lang/String;
    const-string v4, "&"

    move-object/from16 v0, v29

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v34

    .line 1808
    .restart local v34    # "str2":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v4, v34, v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_google:Ljava/lang/String;

    .line 1809
    const-string v4, "gak"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "s1="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_google:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1810
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "acquire_play"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1811
    new-instance v4, Lcom/aio/downloader/activity/MyMainActivity$21;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/aio/downloader/activity/MyMainActivity$21;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 1823
    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity$21;->start()V

    .line 1825
    new-instance v18, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 1826
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1825
    move-object/from16 v0, v18

    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1827
    .restart local v18    # "intent_2":Landroid/content/Intent;
    const-string v4, "myid"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->apkname_google:Ljava/lang/String;

    move-object/from16 v0, v18

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1828
    const-string v4, "linkurl"

    const-string v5, ""

    move-object/from16 v0, v18

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1830
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_e

    .line 1832
    .end local v18    # "intent_2":Landroid/content/Intent;
    .end local v29    # "s1":Ljava/lang/String;
    .end local v33    # "str":[Ljava/lang/String;
    .end local v34    # "str2":[Ljava/lang/String;
    :cond_26
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 1833
    const-string v5, "acquire_webview"

    .line 1832
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1834
    new-instance v19, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 1835
    const-class v5, Lcom/aio/downloader/activity/AcquireWebview;

    .line 1834
    move-object/from16 v0, v19

    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1836
    .local v19, "intent_3":Landroid/content/Intent;
    const-string v4, "url_load"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1837
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_e

    .line 1532
    .end local v19    # "intent_3":Landroid/content/Intent;
    :catch_c
    move-exception v4

    goto/16 :goto_b

    .line 1243
    .end local v8    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .end local v13    # "i":I
    .end local v17    # "intent":Landroid/content/Intent;
    .end local v20    # "loadmore":Landroid/content/IntentFilter;
    .end local v21    # "myIntentFilter":Landroid/content/IntentFilter;
    .end local v22    # "myIntentFilter2":Landroid/content/IntentFilter;
    .end local v23    # "myIntentFilter3":Landroid/content/IntentFilter;
    .end local v24    # "myIntentFilter4":Landroid/content/IntentFilter;
    .end local v27    # "pm":Landroid/content/pm/PackageManager;
    :catch_d
    move-exception v4

    goto/16 :goto_3

    .line 1232
    :catch_e
    move-exception v4

    goto/16 :goto_2

    .line 1182
    :catch_f
    move-exception v4

    goto/16 :goto_1
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 4804
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onDestroy()V

    .line 4806
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4807
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_battery:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4808
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_free:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4809
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_gallery:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4810
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_cleaner:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4811
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_caller:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4812
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->downloadManager_crush:Lcom/thin/downloadmanager/ThinDownloadManager;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/ThinDownloadManager;->release()V

    .line 4814
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->mNotificationManager8:Landroid/app/NotificationManager;

    const/16 v1, 0x13

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4819
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    if-eqz v0, :cond_0

    .line 4820
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->interstitialAd:Lcom/facebook/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/facebook/ads/InterstitialAd;->destroy()V

    .line 4822
    :cond_0
    return-void

    .line 4815
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 4196
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 3
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 5314
    const-string v0, "www"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "error"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/facebook/ads/AdError;->getErrorMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5315
    const/4 v0, 0x0

    sput-boolean v0, Lcom/aio/downloader/utils/Myutils;->fb_ad:Z

    .line 5316
    return-void
.end method

.method public onInterstitialDismissed(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 5332
    return-void
.end method

.method public onInterstitialDisplayed(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 5338
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x3

    .line 5353
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 5354
    sget-object v0, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 5356
    sget-object v0, Lcom/aio/downloader/activity/MyMainActivity;->mDrawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 5357
    const/4 v0, 0x1

    .line 5359
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/aio/downloader/mydownload/BaseActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView;

    .prologue
    const/4 v3, 0x0

    .line 4202
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 4203
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 4204
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->next:I

    .line 4206
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 4207
    iget v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->page:I

    .line 4208
    new-instance v1, Lcom/aio/downloader/activity/MyMainActivity$Mya2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyMainActivity$Mya2;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/MyMainActivity$Mya2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 4213
    :goto_0
    return-void

    .line 4210
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 3963
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 3964
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 3965
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->windowFocus:Z

    .line 3967
    const-string v0, "www"

    const-string v1, "onPause"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 3969
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    .line 3911
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 3912
    const-string v2, "gak"

    const-string v3, "shouyeonResume"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 3914
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 3915
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->windowFocus:Z

    .line 3922
    :try_start_0
    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->getKey()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 3926
    :goto_0
    :try_start_1
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    const-string v3, "download2.db"

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/MyMainActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 3927
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 3926
    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 3928
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 3929
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 3928
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->ds:Ljava/util/List;

    .line 3930
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 3931
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 3932
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 3933
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 3935
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedowntv:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 3936
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedowntv:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 3941
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 3942
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/MyMainActivity$41;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyMainActivity$41;-><init>(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 3954
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 3959
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    .end local v6    # "number":I
    :goto_2
    return-void

    .line 3937
    .restart local v6    # "number":I
    :cond_1
    if-nez v6, :cond_0

    .line 3938
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    .line 3939
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity;->badgedowntv:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 3956
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_2

    .line 3923
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 3973
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onStop()V

    .line 3974
    const/4 v0, 0x0

    sput-boolean v0, Lcom/aio/downloader/utils/publicTools;->tagtanchuang:Z

    .line 3976
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 2953
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 2954
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyMainActivity;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 2955
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 2956
    const-string v1, "download_aio"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 2955
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 2959
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 2960
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2961
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 2959
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 2962
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 2964
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 2970
    :goto_0
    return-void

    .line 2967
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 2968
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 2967
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
