.class public Lcom/aio/downloader/activity/MyDownloaderList;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "MyDownloaderList.java"

# interfaces
.implements Lcom/facebook/ads/AdListener;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;,
        Lcom/aio/downloader/activity/MyDownloaderList$SeekBarChangeEvent;
    }
.end annotation


# static fields
.field public static downloadinglist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static mNotificationManager:Landroid/app/NotificationManager;


# instance fields
.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private final DOWNLOADSUCCESS:Ljava/lang/String;

.field private acquire_url_start:Ljava/lang/String;

.field private adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

.field private aio:I

.field private animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private app_download_bt:Landroid/widget/Button;

.field private app_ratingbar:Landroid/widget/RatingBar;

.field private appauthortitle:Landroid/widget/TextView;

.field private appicon:Landroid/widget/ImageView;

.field private appprice:Landroid/widget/TextView;

.field private appsuccessful:Landroid/content/BroadcastReceiver;

.field private apptitle:Landroid/widget/TextView;

.field private bt_complement:Landroid/widget/Button;

.field private champ3:Landroid/widget/ImageView;

.field currenttime:Landroid/widget/TextView;

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private displayMetrics:Landroid/util/DisplayMetrics;

.field private downloadingnotice1:Landroid/widget/TextView;

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

.field private fb:Z

.field private gvlist:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field handler:Landroid/os/Handler;

.field private imgurl:Ljava/lang/String;

.field private inmobtop:Landroid/widget/RelativeLayout;

.field private istag:Ljava/lang/Boolean;

.field private iv_ioio:Landroid/widget/ImageView;

.field private listdd:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private listview_lin:Landroid/widget/LinearLayout;

.field private ll_download_complement:Landroid/widget/LinearLayout;

.field private ll_downnull:Landroid/widget/LinearLayout;

.field private mBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

.field private mlistview:Lcom/aio/downloader/views/MyListView;

.field private mp3play:Landroid/content/BroadcastReceiver;

.field private musicProgress:Landroid/widget/SeekBar;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private nativeAdgift:Lcom/facebook/ads/NativeAd;

.field private official:Landroid/widget/TextView;

.field private playbarmp3:Landroid/widget/RelativeLayout;

.field private player:Lcom/aio/downloader/utils/Player;

.field private playpausemp3:Landroid/widget/ImageView;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private rl_downloading:Landroid/widget/RelativeLayout;

.field private screenWidth:I

.field private successful:Landroid/content/BroadcastReceiver;

.field private task:Ljava/util/TimerTask;

.field private timer:Ljava/util/Timer;

.field title:Landroid/widget/TextView;

.field totaltime:Landroid/widget/TextView;

.field private tv_delete_all_down:Landroid/widget/TextView;

.field private tv_downloaded:Landroid/widget/TextView;

.field private tv_downloading:Landroid/widget/TextView;

.field private typeFace:Landroid/graphics/Typeface;

.field private xian:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 412
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->downloadinglist:Ljava/util/List;

    .line 415
    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 80
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 83
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 84
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 85
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 86
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHSWF:Ljava/io/File;

    .line 87
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 88
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 89
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 90
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHAPK:Ljava/io/File;

    .line 92
    new-instance v0, Lcom/aio/downloader/activity/MyDownloaderList$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyDownloaderList$1;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->handler:Landroid/os/Handler;

    .line 143
    new-instance v0, Lcom/aio/downloader/activity/MyDownloaderList$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyDownloaderList$2;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mp3play:Landroid/content/BroadcastReceiver;

    .line 180
    new-instance v0, Lcom/aio/downloader/activity/MyDownloaderList$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyDownloaderList$3;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 247
    new-instance v0, Lcom/aio/downloader/activity/MyDownloaderList$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyDownloaderList$4;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->successful:Landroid/content/BroadcastReceiver;

    .line 303
    new-instance v0, Lcom/aio/downloader/activity/MyDownloaderList$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyDownloaderList$5;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    .line 410
    iput-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 417
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->fb:Z

    .line 437
    iput-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->typeFace:Landroid/graphics/Typeface;

    .line 442
    const-string v0, "downloadsuccess"

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->DOWNLOADSUCCESS:Ljava/lang/String;

    .line 447
    iput-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    .line 456
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->istag:Ljava/lang/Boolean;

    .line 467
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->acquire_url_start:Ljava/lang/String;

    .line 561
    new-instance v0, Lcom/aio/downloader/activity/MyDownloaderList$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyDownloaderList$6;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appsuccessful:Landroid/content/BroadcastReceiver;

    .line 80
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyDownloaderList;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 409
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 407
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 461
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->timer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/TimerTask;)V
    .locals 0

    .prologue
    .line 462
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->task:Ljava/util/TimerTask;

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 461
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/TimerTask;
    .locals 1

    .prologue
    .line 462
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->task:Ljava/util/TimerTask;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 406
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 405
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 410
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/MyDownloaderList;Lcom/aio/downloader/db/TypeDbUtils;)V
    .locals 0

    .prologue
    .line 410
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-void
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/adapter/AppDownloadedAdapter;
    .locals 1

    .prologue
    .line 447
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/views/MyListView;
    .locals 1

    .prologue
    .line 444
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mlistview:Lcom/aio/downloader/views/MyListView;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 456
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->istag:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 451
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->playpausemp3:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 456
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$23(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/io/File;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$24(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/io/File;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 575
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 571
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloading:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;
    .locals 1

    .prologue
    .line 446
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 573
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloaded:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 579
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->rl_downloading:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/utils/Player;
    .locals 1

    .prologue
    .line 453
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/MyDownloaderList;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->playbarmp3:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public static bitmapToDrawble(Landroid/graphics/Bitmap;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;
    .param p1, "mcontext"    # Landroid/content/Context;

    .prologue
    .line 1048
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 1049
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    return-object v0
.end method

.method private buildLister()V
    .locals 2

    .prologue
    .line 675
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->tv_delete_all_down:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 676
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->musicProgress:Landroid/widget/SeekBar;

    new-instance v1, Lcom/aio/downloader/activity/MyDownloaderList$SeekBarChangeEvent;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyDownloaderList$SeekBarChangeEvent;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 678
    new-instance v0, Lcom/aio/downloader/utils/Player;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->musicProgress:Landroid/widget/SeekBar;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/utils/Player;-><init>(Landroid/content/Context;Landroid/widget/SeekBar;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    .line 679
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->playpausemp3:Landroid/widget/ImageView;

    .line 680
    new-instance v1, Lcom/aio/downloader/activity/MyDownloaderList$8;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyDownloaderList$8;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 700
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->champ3:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/MyDownloaderList$9;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyDownloaderList$9;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 718
    return-void
.end method

.method private download_file()V
    .locals 29

    .prologue
    .line 749
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;

    move-object/from16 v24, v0

    invoke-interface/range {v24 .. v24}, Ljava/util/List;->size()I

    move-result v24

    if-eqz v24, :cond_1

    .line 753
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;

    move-object/from16 v24, v0

    invoke-interface/range {v24 .. v24}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v24

    :cond_0
    :goto_0
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->hasNext()Z

    move-result v25

    if-nez v25, :cond_2

    .line 861
    :cond_1
    return-void

    .line 753
    :cond_2
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 755
    .local v10, "downloadMovieItem":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v25

    .line 756
    const v26, 0x7f030068

    const/16 v27, 0x0

    .line 755
    invoke-virtual/range {v25 .. v27}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v23

    .line 757
    .local v23, "view":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 759
    const v25, 0x7f07027a

    move-object/from16 v0, v23

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .line 758
    check-cast v11, Landroid/widget/ProgressBar;

    .line 760
    .local v11, "dp":Landroid/widget/ProgressBar;
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getResources()Landroid/content/res/Resources;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/MyDownloaderList;->displayMetrics:Landroid/util/DisplayMetrics;

    .line 761
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->displayMetrics:Landroid/util/DisplayMetrics;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    move/from16 v25, v0

    move/from16 v0, v25

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/MyDownloaderList;->screenWidth:I

    .line 763
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->screenWidth:I

    move/from16 v25, v0

    const/16 v26, 0x1f4

    move/from16 v0, v25

    move/from16 v1, v26

    if-ge v0, v1, :cond_3

    .line 764
    invoke-virtual {v11}, Landroid/widget/ProgressBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v18

    .line 765
    .local v18, "para":Landroid/view/ViewGroup$LayoutParams;
    const/16 v25, 0xba

    move/from16 v0, v25

    move-object/from16 v1, v18

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 766
    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 769
    .end local v18    # "para":Landroid/view/ViewGroup$LayoutParams;
    :cond_3
    const v25, 0x7f070278

    move-object/from16 v0, v23

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Landroid/widget/TextView;

    .line 770
    .local v20, "t":Landroid/widget/TextView;
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v20

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 771
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->typeFace:Landroid/graphics/Typeface;

    move-object/from16 v25, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 774
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v19

    .line 776
    .local v19, "stsize":Ljava/lang/String;
    const v25, 0x7f07027c

    move-object/from16 v0, v23

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 775
    check-cast v7, Landroid/widget/TextView;

    .line 777
    .local v7, "cp":Landroid/widget/TextView;
    const v25, 0x7f070279

    move-object/from16 v0, v23

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Landroid/widget/TextView;

    .line 780
    .local v22, "tsize":Landroid/widget/TextView;
    const v25, 0x7f070277

    move-object/from16 v0, v23

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    .line 779
    check-cast v17, Landroid/widget/ImageView;

    .line 781
    .local v17, "movie_headimage":Landroid/widget/ImageView;
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/MyDownloaderList;->imgurl:Ljava/lang/String;

    .line 783
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->imgurl:Ljava/lang/String;

    move-object/from16 v26, v0

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 789
    const-wide/16 v12, 0x0

    .line 790
    .local v12, "file_size":D
    :try_start_0
    const-string v25, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v25

    if-nez v25, :cond_4

    if-eqz v19, :cond_4

    .line 791
    const-string v25, "MB"

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v25

    if-eqz v25, :cond_7

    .line 792
    const-string v25, "MB"

    const-string v26, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v19

    .line 794
    invoke-static/range {v19 .. v19}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v25

    const-wide/high16 v27, 0x4090000000000000L    # 1024.0

    mul-double v12, v25, v27

    .line 801
    :cond_4
    :goto_1
    const-wide/high16 v25, 0x4069000000000000L    # 200.0

    cmpg-double v25, v12, v25

    if-gez v25, :cond_8

    .line 802
    const-string v25, "Invalid"

    move-object/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 803
    const-string v25, "#f39801"

    invoke-static/range {v25 .. v25}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v25

    move/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setTextColor(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 811
    :goto_2
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getCurrentProgress()Ljava/lang/Long;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    .line 814
    .local v8, "currentSize":J
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-static {v0, v8, v9}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v21

    .line 816
    .local v21, "ts":Ljava/lang/String;
    const-string v25, "null"

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v25

    if-eqz v25, :cond_5

    .line 817
    const-string v19, "0.00B"

    .line 820
    :cond_5
    new-instance v25, Ljava/lang/StringBuilder;

    invoke-static/range {v21 .. v21}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v26

    invoke-direct/range {v25 .. v26}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v26, "/"

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 822
    const v25, 0x7f070276

    move-object/from16 v0, v23

    move/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 821
    check-cast v4, Landroid/widget/TextView;

    .line 824
    .local v4, "bt":Landroid/widget/TextView;
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getProgressCount()Ljava/lang/Long;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 825
    .local v5, "count":J
    long-to-int v0, v5

    move/from16 v25, v0

    move/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 826
    long-to-int v0, v8

    move/from16 v25, v0

    move/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 827
    invoke-virtual {v4}, Landroid/widget/TextView;->getVisibility()I

    move-result v25

    const/16 v26, 0x4

    move/from16 v0, v25

    move/from16 v1, v26

    if-ne v0, v1, :cond_6

    .line 829
    const/16 v25, 0x0

    move/from16 v0, v25

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 831
    :cond_6
    const/16 v25, 0x0

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v15

    .line 833
    .local v15, "isFromDb":Ljava/lang/Boolean;
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_3
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v25, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    invoke-interface/range {v25 .. v25}, Ljava/util/List;->size()I

    move-result v25

    move/from16 v0, v25

    if-lt v14, v0, :cond_9

    .line 849
    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v25

    if-nez v25, :cond_0

    .line 856
    new-instance v25, Lcom/aio/downloader/mydownload/DownloadTask;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v26

    const/16 v27, 0x1

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    move-object/from16 v2, v23

    move/from16 v3, v27

    invoke-direct {v0, v1, v2, v10, v3}, Lcom/aio/downloader/mydownload/DownloadTask;-><init>(Landroid/content/Context;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Z)V

    .line 857
    new-instance v26, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;

    move-object/from16 v27, v0

    move-object/from16 v0, v26

    move-object/from16 v1, p0

    move-object/from16 v2, v27

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;Landroid/widget/LinearLayout;)V

    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/mydownload/DownloadTask;->setOnDeleteTaskListener(Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;)V

    goto/16 :goto_0

    .line 796
    .end local v4    # "bt":Landroid/widget/TextView;
    .end local v5    # "count":J
    .end local v8    # "currentSize":J
    .end local v14    # "i":I
    .end local v15    # "isFromDb":Ljava/lang/Boolean;
    .end local v21    # "ts":Ljava/lang/String;
    :cond_7
    :try_start_1
    const-string v25, "KB"

    const-string v26, ""

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v19

    .line 798
    invoke-static/range {v19 .. v19}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v12

    goto/16 :goto_1

    .line 805
    :cond_8
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPercentage()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2

    .line 807
    :catch_0
    move-exception v25

    goto/16 :goto_2

    .line 834
    .restart local v4    # "bt":Landroid/widget/TextView;
    .restart local v5    # "count":J
    .restart local v8    # "currentSize":J
    .restart local v14    # "i":I
    .restart local v15    # "isFromDb":Ljava/lang/Boolean;
    .restart local v21    # "ts":Ljava/lang/String;
    :cond_9
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v25, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    move-object/from16 v0, v25

    invoke-interface {v0, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 835
    .local v16, "item":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual/range {v16 .. v16}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadUrl()Ljava/lang/String;

    move-result-object v25

    .line 836
    invoke-virtual {v10}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloadUrl()Ljava/lang/String;

    move-result-object v26

    .line 835
    invoke-virtual/range {v25 .. v26}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v25

    .line 836
    if-eqz v25, :cond_a

    .line 840
    new-instance v25, Lcom/aio/downloader/mydownload/DownloadTask;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v26

    .line 841
    const/16 v27, 0x0

    .line 840
    move-object/from16 v0, v25

    move-object/from16 v1, v26

    move-object/from16 v2, v23

    move/from16 v3, v27

    invoke-direct {v0, v1, v2, v10, v3}, Lcom/aio/downloader/mydownload/DownloadTask;-><init>(Landroid/content/Context;Landroid/view/View;Lcom/aio/downloader/mydownload/DownloadMovieItem;Z)V

    .line 842
    new-instance v26, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;

    .line 843
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;

    move-object/from16 v27, v0

    .line 842
    move-object/from16 v0, v26

    move-object/from16 v1, p0

    move-object/from16 v2, v27

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/activity/MyDownloaderList$DeleteTask;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;Landroid/widget/LinearLayout;)V

    invoke-virtual/range {v25 .. v26}, Lcom/aio/downloader/mydownload/DownloadTask;->setOnDeleteTaskListener(Lcom/aio/downloader/mydownload/DownloadTask$OnDeleteTaskListener;)V

    .line 844
    const/16 v25, 0x1

    invoke-static/range {v25 .. v25}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v15

    .line 833
    :cond_a
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_3
.end method

.method private facebookad()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    .line 587
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->apptitle:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 589
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appauthortitle:Landroid/widget/TextView;

    const-string v3, "Download Complete"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 592
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2}, Lcom/facebook/ads/NativeAd;->getAdIcon()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 593
    .local v0, "adIcon":Lcom/facebook/ads/NativeAd$Image;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appicon:Landroid/widget/ImageView;

    invoke-static {v0, v2}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 595
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2}, Lcom/facebook/ads/NativeAd;->getAdStarRating()Lcom/facebook/ads/NativeAd$Rating;

    move-result-object v1

    .line 596
    .local v1, "rating":Lcom/facebook/ads/NativeAd$Rating;
    if-eqz v1, :cond_0

    .line 597
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app_ratingbar:Landroid/widget/RatingBar;

    invoke-virtual {v2, v4}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 598
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app_ratingbar:Landroid/widget/RatingBar;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd$Rating;->getScale()D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {v2, v3}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 599
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app_ratingbar:Landroid/widget/RatingBar;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd$Rating;->getValue()D

    move-result-wide v3

    double-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/widget/RatingBar;->setRating(F)V

    .line 604
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->inmobtop:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 606
    return-void

    .line 601
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app_ratingbar:Landroid/widget/RatingBar;

    invoke-virtual {v2, v4}, Landroid/widget/RatingBar;->setVisibility(I)V

    goto :goto_0
.end method

.method private init()V
    .locals 9

    .prologue
    const/4 v1, 0x0

    .line 610
    const v0, 0x7f070187

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->rl_downloading:Landroid/widget/RelativeLayout;

    .line 611
    const v0, 0x7f070189

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->tv_delete_all_down:Landroid/widget/TextView;

    .line 612
    const v0, 0x7f07018c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->downloadingnotice1:Landroid/widget/TextView;

    .line 613
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 614
    const v0, 0x7f070172

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listview_lin:Landroid/widget/LinearLayout;

    .line 615
    const v0, 0x7f07018a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/MyListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mlistview:Lcom/aio/downloader/views/MyListView;

    .line 616
    const v0, 0x7f070186

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloading:Landroid/widget/TextView;

    .line 617
    const v0, 0x7f070188

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->tv_downloaded:Landroid/widget/TextView;

    .line 618
    const v0, 0x7f070181

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/aio/downloader/views/LImageButton;

    .line 619
    .local v6, "header_left_download":Lcom/aio/downloader/views/LImageButton;
    const v0, 0x7f07018d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->iv_ioio:Landroid/widget/ImageView;

    .line 620
    const v0, 0x7f07018b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;

    .line 621
    const v0, 0x7f070184

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_download_complement:Landroid/widget/LinearLayout;

    .line 622
    const v0, 0x7f070185

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->bt_complement:Landroid/widget/Button;

    .line 623
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_download_complement:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 624
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->bt_complement:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 625
    invoke-virtual {v6, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 626
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 627
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    const-string v2, "notification"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 626
    check-cast v0, Landroid/app/NotificationManager;

    sput-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    .line 629
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 630
    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 629
    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 635
    :goto_0
    new-instance v7, Landroid/content/IntentFilter;

    invoke-direct {v7}, Landroid/content/IntentFilter;-><init>()V

    .line 636
    .local v7, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v0, "download_aio"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 637
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v2, v7}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 641
    new-instance v8, Landroid/content/IntentFilter;

    invoke-direct {v8}, Landroid/content/IntentFilter;-><init>()V

    .line 642
    .local v8, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v0, "successful"

    invoke-virtual {v8, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 643
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->successful:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v2, v8}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 644
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 645
    const-string v4, "download2.db"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 644
    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 646
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 647
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    move-object v2, v1

    move-object v5, v1

    .line 646
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;

    .line 648
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 649
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 653
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    invoke-virtual {v0}, Lcom/aio/downloader/db/TypeDbUtils;->myqueryfile()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    .line 654
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 655
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    .line 657
    :cond_1
    new-instance v0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    .line 658
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mlistview:Lcom/aio/downloader/views/MyListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/MyListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 662
    const v0, 0x7f07018f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->playpausemp3:Landroid/widget/ImageView;

    .line 663
    const v0, 0x7f070190

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->champ3:Landroid/widget/ImageView;

    .line 665
    const v0, 0x7f07018e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->playbarmp3:Landroid/widget/RelativeLayout;

    .line 666
    const v0, 0x7f0700ec

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->totaltime:Landroid/widget/TextView;

    .line 667
    const v0, 0x7f0700ea

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->currenttime:Landroid/widget/TextView;

    .line 668
    const v0, 0x7f0700e7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->title:Landroid/widget/TextView;

    .line 669
    const v0, 0x7f0700eb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->musicProgress:Landroid/widget/SeekBar;

    .line 671
    return-void

    .line 631
    .end local v7    # "myIntentFilter":Landroid/content/IntentFilter;
    .end local v8    # "myIntentFilter2":Landroid/content/IntentFilter;
    :catch_0
    move-exception v0

    goto/16 :goto_0
.end method


# virtual methods
.method public Appdeletall()V
    .locals 4

    .prologue
    .line 1227
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    invoke-virtual {v2}, Lcom/aio/downloader/db/TypeDbUtils;->deleteall()V

    .line 1230
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_0

    .line 1240
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 1242
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    invoke-virtual {v2}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->notifyDataSetChanged()V

    .line 1243
    return-void

    .line 1231
    :cond_0
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1232
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1234
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 1230
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
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
    .line 1270
    const-wide/16 v1, 0x0

    .line 1271
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1272
    const/4 v0, 0x0

    .line 1273
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 1274
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 1278
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 1276
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public initView()V
    .locals 0

    .prologue
    .line 971
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 972
    return-void
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 1011
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 1016
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_2

    .line 1017
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 1039
    :cond_0
    :goto_0
    return-void

    .line 1022
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 1023
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->fb:Z

    .line 1026
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->facebookad()V

    .line 1027
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->inmobtop:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1028
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_download_complement:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1029
    :catch_0
    move-exception v0

    goto :goto_0

    .line 1031
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 1032
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 1035
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 1037
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 11
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v9, 0x19ee4c

    const/4 v7, 0x1

    .line 1088
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v6

    packed-switch v6, :pswitch_data_0

    .line 1222
    :goto_0
    :pswitch_0
    return-void

    .line 1090
    :pswitch_1
    iget v6, p0, Lcom/aio/downloader/activity/MyDownloaderList;->aio:I

    if-ne v6, v7, :cond_0

    .line 1092
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    .line 1093
    const-class v7, Lcom/aio/downloader/activity/MyMainActivity;

    .line 1092
    invoke-direct {v2, v6, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1094
    .local v2, "intent":Landroid/content/Intent;
    const-string v6, "acquire_url_start"

    const-string v7, ""

    invoke-virtual {v2, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1095
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 1098
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_0
    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 1100
    .local v5, "ver":Ljava/lang/String;
    const-string v6, "5"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1101
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    .line 1102
    const-class v7, Lcom/aio/downloader/activity/MyMainActivity;

    .line 1101
    invoke-direct {v2, v6, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1103
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v6, "acquire_url_start"

    const-string v7, ""

    invoke-virtual {v2, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1104
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 1106
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/MyDownloaderList;->moveTaskToBack(Z)Z

    goto :goto_0

    .line 1111
    .end local v5    # "ver":Ljava/lang/String;
    :pswitch_2
    new-instance v6, Landroid/app/AlertDialog$Builder;

    invoke-direct {v6, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1112
    const v7, 0x7f0b0034

    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 1113
    const v7, 0x7f0b0041

    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 1115
    const v7, 0x7f0b003c

    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 1116
    new-instance v8, Lcom/aio/downloader/activity/MyDownloaderList$10;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/MyDownloaderList$10;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    .line 1114
    invoke-virtual {v6, v7, v8}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 1126
    const v7, 0x7f0b003b

    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 1127
    new-instance v8, Lcom/aio/downloader/activity/MyDownloaderList$11;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/MyDownloaderList$11;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    .line 1125
    invoke-virtual {v6, v7, v8}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 1134
    invoke-virtual {v6}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 1163
    :pswitch_3
    const/4 v4, 0x0

    .line 1165
    .local v4, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 1166
    const-string v7, "com.freepezzle.hexcrush"

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v4

    .line 1170
    :goto_1
    if-nez v4, :cond_4

    .line 1172
    :try_start_1
    iget-object v6, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 1173
    iget-object v6, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v6}, Lcom/aio/downloader/activity/MyDownloaderList;->getFileSizes(Ljava/io/File;)J

    move-result-wide v6

    cmp-long v6, v6, v9

    if-ltz v6, :cond_2

    .line 1174
    new-instance v0, Landroid/content/Intent;

    const-string v6, "android.intent.action.VIEW"

    invoke-direct {v0, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1176
    .local v0, "aa":Landroid/content/Intent;
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "file://"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 1177
    const-string v7, "application/vnd.android.package-archive"

    .line 1175
    invoke-virtual {v0, v6, v7}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 1178
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 1207
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 1208
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 1167
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    .line 1168
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 1179
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_2
    :try_start_2
    iget-object v6, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 1180
    iget-object v6, p0, Lcom/aio/downloader/activity/MyDownloaderList;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v6}, Lcom/aio/downloader/activity/MyDownloaderList;->getFileSizes(Ljava/io/File;)J

    move-result-wide v6

    cmp-long v6, v6, v9

    if-ltz v6, :cond_3

    .line 1181
    new-instance v6, Lcom/aio/downloader/activity/MyDownloaderList$12;

    invoke-direct {v6, p0}, Lcom/aio/downloader/activity/MyDownloaderList$12;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Void;

    .line 1199
    invoke-virtual {v6, v7}, Lcom/aio/downloader/activity/MyDownloaderList$12;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 1201
    :cond_3
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    .line 1202
    const-class v7, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1201
    invoke-direct {v0, v6, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1203
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v6, "myid"

    const-string v7, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1204
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 1211
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_4
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 1213
    const-string v7, "com.freepezzle.hexcrush"

    .line 1212
    invoke-virtual {v6, v7}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 1214
    .local v3, "intent5":Landroid/content/Intent;
    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1088
    nop

    :pswitch_data_0
    .packed-switch 0x7f070181
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v10, 0x0

    .line 472
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 474
    const-string v2, "gak"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "aaaa="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-boolean v4, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    sget-boolean v2, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    if-nez v2, :cond_0

    .line 483
    new-instance v6, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 484
    const-class v3, Lcom/aio/downloader/activity/MyMainActivity;

    .line 483
    invoke-direct {v6, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 485
    .local v6, "intent":Landroid/content/Intent;
    const-string v2, "acquire_url_start"

    const-string v3, ""

    invoke-virtual {v6, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 486
    invoke-virtual {p0, v6}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V

    .line 487
    const v2, 0x7f04000c

    const v3, 0x7f040011

    invoke-virtual {p0, v2, v3}, Lcom/aio/downloader/activity/MyDownloaderList;->overridePendingTransition(II)V

    .line 488
    const/4 v2, 0x1

    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->iswidget:Z

    .line 490
    .end local v6    # "intent":Landroid/content/Intent;
    :cond_0
    const v2, 0x7f030034

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->setContentView(I)V

    .line 492
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->setmContext(Landroid/content/Context;)V

    .line 493
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->init()V

    .line 494
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->initView()V

    .line 495
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->download_file()V

    .line 496
    invoke-direct {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->buildLister()V

    .line 499
    new-instance v7, Landroid/content/IntentFilter;

    invoke-direct {v7}, Landroid/content/IntentFilter;-><init>()V

    .line 500
    .local v7, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v2, "delete"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 501
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v7}, Lcom/aio/downloader/activity/MyDownloaderList;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 504
    new-instance v8, Landroid/content/IntentFilter;

    invoke-direct {v8}, Landroid/content/IntentFilter;-><init>()V

    .line 505
    .local v8, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v2, "successful"

    invoke-virtual {v8, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 506
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appsuccessful:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v8}, Lcom/aio/downloader/activity/MyDownloaderList;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 509
    new-instance v9, Landroid/content/IntentFilter;

    invoke-direct {v9}, Landroid/content/IntentFilter;-><init>()V

    .line 510
    .local v9, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v2, "mymp3play"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 511
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->mp3play:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v9}, Lcom/aio/downloader/activity/MyDownloaderList;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 513
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 514
    .local v0, "time":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/MyDownloaderList$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyDownloaderList$7;-><init>(Lcom/aio/downloader/activity/MyDownloaderList;)V

    .line 525
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 527
    const v2, 0x7f0700fb

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appicon:Landroid/widget/ImageView;

    .line 528
    const v2, 0x7f0700c4

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->apptitle:Landroid/widget/TextView;

    .line 529
    const v2, 0x7f0700fc

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->official:Landroid/widget/TextView;

    .line 530
    const v2, 0x7f0700c0

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appprice:Landroid/widget/TextView;

    .line 531
    const v2, 0x7f0700c6

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->appauthortitle:Landroid/widget/TextView;

    .line 532
    const v2, 0x7f0700be

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RatingBar;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app_ratingbar:Landroid/widget/RatingBar;

    .line 533
    const v2, 0x7f0700c7

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->app_download_bt:Landroid/widget/Button;

    .line 534
    const v2, 0x7f0700c2

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->inmobtop:Landroid/widget/RelativeLayout;

    .line 535
    const v2, 0x7f0700c1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->xian:Landroid/widget/TextView;

    .line 538
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 539
    invoke-virtual {v2}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v2

    const-string v3, "Roboto-Light.ttf"

    .line 538
    invoke-static {v2, v3}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->typeFace:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 545
    :goto_0
    new-instance v2, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 546
    const-string v4, "340186902832477_418871068297393"

    invoke-direct {v2, v3, v4}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 545
    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 547
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 548
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 550
    new-instance v2, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 551
    const-string v4, "340186902832477_436045469913286"

    invoke-direct {v2, v3, v4}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 550
    iput-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    .line 552
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 553
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->nativeAdgift:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 555
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "aio"

    invoke-virtual {v2, v3, v10}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/activity/MyDownloaderList;->aio:I

    .line 556
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const/16 v3, 0x8

    const/4 v4, 0x7

    const/16 v5, 0x3b

    invoke-static {v2, v3, v10, v4, v5}, Lcn/jpush/android/api/JPushInterface;->setSilenceTime(Landroid/content/Context;IIII)V

    .line 558
    return-void

    .line 541
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1248
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onDestroy()V

    .line 1250
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 1252
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 1253
    iput-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->timer:Ljava/util/Timer;

    .line 1255
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->task:Ljava/util/TimerTask;

    if-eqz v0, :cond_1

    .line 1256
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->task:Ljava/util/TimerTask;

    invoke-virtual {v0}, Ljava/util/TimerTask;->cancel()Z

    .line 1257
    iput-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->task:Ljava/util/TimerTask;

    .line 1259
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1260
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 1261
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->stop()V

    .line 1263
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    if-eqz v0, :cond_3

    .line 1265
    iput-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;

    .line 1267
    :cond_3
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 1043
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->inmobtop:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1044
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_download_complement:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1045
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x1

    .line 1055
    const/4 v3, 0x4

    if-ne p1, v3, :cond_2

    .line 1057
    iget v3, p0, Lcom/aio/downloader/activity/MyDownloaderList;->aio:I

    if-ne v3, v2, :cond_0

    .line 1059
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 1060
    const-class v4, Lcom/aio/downloader/activity/MyMainActivity;

    .line 1059
    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1061
    .local v0, "intent":Landroid/content/Intent;
    const-string v3, "acquire_url_start"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1062
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V

    .line 1082
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_0
    return v2

    .line 1065
    :cond_0
    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 1067
    .local v1, "ver":Ljava/lang/String;
    const-string v3, "5"

    invoke-virtual {v1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1068
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 1069
    const-class v4, Lcom/aio/downloader/activity/MyMainActivity;

    .line 1068
    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1070
    .restart local v0    # "intent":Landroid/content/Intent;
    const-string v3, "acquire_url_start"

    const-string v4, ""

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1071
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 1073
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->moveTaskToBack(Z)Z

    goto :goto_0

    .line 1078
    .end local v1    # "ver":Ljava/lang/String;
    :cond_2
    const/4 v3, 0x3

    if-ne v3, p1, :cond_3

    .line 1079
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->moveTaskToBack(Z)Z

    goto :goto_0

    .line 1082
    :cond_3
    invoke-super {p0, p1, p2}, Lcom/aio/downloader/mydownload/BaseActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v2

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 998
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 999
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 1001
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->stop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1005
    :goto_0
    return-void

    .line 1002
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 977
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 978
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MyDownloaderList;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 981
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->notifyDataSetChanged()V

    .line 983
    sget-boolean v0, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->ll_downnull:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 984
    const-string v0, "qaz"

    const-string v1, "qazqazqzaza"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 986
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->iv_ioio:Landroid/widget/ImageView;

    const v1, 0x7f040006

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 987
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->iv_ioio:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    .line 988
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList;->animationDrawable:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 993
    :cond_0
    :goto_0
    return-void

    .line 989
    :catch_0
    move-exception v0

    goto :goto_0
.end method
