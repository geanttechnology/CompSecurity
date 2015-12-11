.class public Lcom/aio/downloader/activity/FunActivity1;
.super Landroid/support/v4/app/FragmentActivity;
.source "FunActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;
    }
.end annotation


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private adView:Lcom/google/ads/AdView;

.field private adapter:Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;

.field private adulttopgift:Landroid/widget/ImageView;

.field private adulttopsearch:Lcom/aio/downloader/views/LImageButton;

.field private app:Landroid/content/BroadcastReceiver;

.field private appbanner:Landroid/widget/LinearLayout;

.field private appfan:Lcom/aio/downloader/views/LImageButton;

.field private apptodown:Lcom/aio/downloader/views/LImageButton;

.field private badgedownimg:Lcom/aio/downloader/views/BadgeView;

.field private banner_type_name:Ljava/lang/String;

.field private db:Lnet/tsz/afinal/FinalDBChen;

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

.field private handler:Landroid/os/Handler;

.field private isfbshow:Z

.field private listtitle:Landroid/widget/TextView;

.field private mAnimImageView:Landroid/widget/ImageView;

.field private mAnimation:Landroid/view/animation/Animation;

.field private mRandom:I

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private pager:Landroid/support/v4/view/ViewPager;

.field private pubTools:Lcom/aio/downloader/utils/publicTools;

.field private sp_config:Landroid/content/SharedPreferences;

.field tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

.field tagtitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 66
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 69
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 70
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

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR_FOME:Ljava/io/File;

    .line 71
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 72
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

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR_TO:Ljava/io/File;

    .line 73
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 74
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

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR:Ljava/io/File;

    .line 77
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 78
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 79
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 80
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERDOWN:Ljava/io/File;

    .line 81
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 82
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 83
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 84
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERAPK:Ljava/io/File;

    .line 86
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 87
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 88
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 89
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHSWF:Ljava/io/File;

    .line 90
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 91
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 92
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 93
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHAPK:Ljava/io/File;

    .line 96
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 97
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 98
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 99
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERY:Ljava/io/File;

    .line 100
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 101
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 102
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 103
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERYAPK:Ljava/io/File;

    .line 105
    iput v3, p0, Lcom/aio/downloader/activity/FunActivity1;->mRandom:I

    .line 106
    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 122
    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->sp_config:Landroid/content/SharedPreferences;

    .line 126
    iput-boolean v3, p0, Lcom/aio/downloader/activity/FunActivity1;->isfbshow:Z

    .line 133
    new-instance v0, Lcom/aio/downloader/activity/FunActivity1$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FunActivity1$1;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->handler:Landroid/os/Handler;

    .line 152
    new-instance v0, Lcom/aio/downloader/activity/FunActivity1$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FunActivity1$2;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->app:Landroid/content/BroadcastReceiver;

    .line 66
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/FunActivity1;Lnet/tsz/afinal/FinalDBChen;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/aio/downloader/activity/FunActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/FunActivity1;)I
    .locals 1

    .prologue
    .line 105
    iget v0, p0, Lcom/aio/downloader/activity/FunActivity1;->mRandom:I

    return v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/FunActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/FunActivity1;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/FunActivity1;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/FunActivity1;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/aio/downloader/activity/FunActivity1;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/FunActivity1;)Ljava/util/List;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/FunActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->mAnimImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/FunActivity1;)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->mAnimation:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/FunActivity1;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/FunActivity1;)Z
    .locals 1

    .prologue
    .line 126
    iget-boolean v0, p0, Lcom/aio/downloader/activity/FunActivity1;->isfbshow:Z

    return v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/FunActivity1;I)V
    .locals 0

    .prologue
    .line 105
    iput p1, p0, Lcom/aio/downloader/activity/FunActivity1;->mRandom:I

    return-void
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 686
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 687
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 243
    const v0, 0x7f070073

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->mAnimImageView:Landroid/widget/ImageView;

    .line 245
    const v0, 0x7f040007

    .line 244
    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->mAnimation:Landroid/view/animation/Animation;

    .line 246
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->mAnimation:Landroid/view/animation/Animation;

    new-instance v1, Lcom/aio/downloader/activity/FunActivity1$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FunActivity1$3;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 268
    const v0, 0x7f070099

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->listtitle:Landroid/widget/TextView;

    .line 269
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->listtitle:Landroid/widget/TextView;

    const-string v1, "Funny"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 270
    const v0, 0x7f070102

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    .line 271
    const v0, 0x7f07006a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopgift:Landroid/widget/ImageView;

    .line 273
    const v0, 0x7f070104

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    .line 274
    new-instance v0, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 275
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/FunActivity1$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FunActivity1$4;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 284
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/FunActivity1$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FunActivity1$5;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 293
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopgift:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/FunActivity1$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FunActivity1$6;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 548
    return-void
.end method


# virtual methods
.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 696
    const-wide/16 v1, 0x0

    .line 697
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 698
    const/4 v0, 0x0

    .line 699
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 700
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 704
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 702
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 668
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 669
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 668
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 670
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 671
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 676
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 682
    :cond_0
    :goto_0
    return-void

    .line 679
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 680
    invoke-direct {p0}, Lcom/aio/downloader/activity/FunActivity1;->facebookad()V

    .line 681
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/FunActivity1;->isfbshow:Z

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 604
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 612
    :goto_0
    return-void

    .line 606
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->finish()V

    goto :goto_0

    .line 604
    :pswitch_data_0
    .packed-switch 0x7f0700fd
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ResourceAsColor"
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 196
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 198
    const v4, 0x7f03004b

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/FunActivity1;->setContentView(I)V

    .line 199
    invoke-direct {p0}, Lcom/aio/downloader/activity/FunActivity1;->init()V

    .line 200
    const v4, 0x7f0700fd

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/LImageButton;

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->appfan:Lcom/aio/downloader/views/LImageButton;

    .line 201
    const v4, 0x7f0701f9

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    .line 202
    const v4, 0x7f0701fa

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/support/v4/view/ViewPager;

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->pager:Landroid/support/v4/view/ViewPager;

    .line 203
    new-instance v4, Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v5

    invoke-direct {v4, p0, v5}, Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;-><init>(Lcom/aio/downloader/activity/FunActivity1;Landroid/support/v4/app/FragmentManager;)V

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->adapter:Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;

    .line 204
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->pager:Landroid/support/v4/view/ViewPager;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1;->adapter:Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;

    invoke-virtual {v4, v5}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 205
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    .line 207
    const/4 v4, 0x1

    const/high16 v5, 0x40800000    # 4.0f

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 208
    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    .line 206
    invoke-static {v4, v5, v6}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v4

    float-to-int v3, v4

    .line 209
    .local v3, "pageMargin":I
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v4, v3}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 211
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 212
    .local v1, "intent":Landroid/content/Intent;
    const-string v4, "current"

    invoke-virtual {v1, v4, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 213
    .local v0, "current":I
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v4, v0}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 214
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FunActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f080033

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setBackgroundColor(I)V

    .line 217
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->appfan:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v4, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 219
    const v4, 0x7f070070

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/FunActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->appbanner:Landroid/widget/LinearLayout;

    .line 220
    const-string v4, "banner_type"

    invoke-virtual {p0, v4, v7}, Lcom/aio/downloader/activity/FunActivity1;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->sp_config:Landroid/content/SharedPreferences;

    .line 221
    new-instance v4, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v4, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->pubTools:Lcom/aio/downloader/utils/publicTools;

    .line 222
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->sp_config:Landroid/content/SharedPreferences;

    const-string v5, "banner_type"

    const-string v6, "admob"

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->banner_type_name:Ljava/lang/String;

    .line 223
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->banner_type_name:Ljava/lang/String;

    const-string v5, "admob"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 224
    new-instance v4, Lcom/google/ads/AdView;

    sget-object v5, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 225
    const-string v6, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v4, p0, v5, v6}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 224
    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->adView:Lcom/google/ads/AdView;

    .line 226
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->appbanner:Landroid/widget/LinearLayout;

    iget-object v5, p0, Lcom/aio/downloader/activity/FunActivity1;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 227
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->adView:Lcom/google/ads/AdView;

    new-instance v5, Lcom/google/ads/AdRequest;

    invoke-direct {v5}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v4, v5}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 230
    :cond_0
    new-instance v4, Lcom/facebook/ads/NativeAd;

    const-string v5, "340186902832477_401790893338744"

    invoke-direct {v4, p0, v5}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 231
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v4, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 232
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v5, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v4, v5}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 235
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 236
    .local v2, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v4, "app"

    invoke-virtual {v2, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 237
    iget-object v4, p0, Lcom/aio/downloader/activity/FunActivity1;->app:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v4, v2}, Lcom/aio/downloader/activity/FunActivity1;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 239
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 693
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 662
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/FragmentActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 656
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 657
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 658
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 616
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 618
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 620
    :try_start_0
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    const-string v3, "download2.db"

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/FunActivity1;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 621
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 620
    iput-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 622
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 623
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 622
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 628
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 629
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 631
    iget-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 632
    iget-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 637
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 638
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/FunActivity1$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FunActivity1$7;-><init>(Lcom/aio/downloader/activity/FunActivity1;)V

    .line 650
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 652
    return-void

    .line 633
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :cond_1
    if-nez v6, :cond_0

    .line 635
    iget-object v2, p0, Lcom/aio/downloader/activity/FunActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 624
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_0
.end method
