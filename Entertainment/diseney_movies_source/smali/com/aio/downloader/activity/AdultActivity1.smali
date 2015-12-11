.class public Lcom/aio/downloader/activity/AdultActivity1;
.super Landroid/support/v4/app/FragmentActivity;
.source "AdultActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;
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

.field private adapter:Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;

.field private adult:Landroid/content/BroadcastReceiver;

.field private adulttopgift:Landroid/widget/ImageView;

.field private adulttopsearch:Lcom/aio/downloader/views/LImageButton;

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

    .line 62
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 65
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 66
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR_FOME:Ljava/io/File;

    .line 67
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 68
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR_TO:Ljava/io/File;

    .line 69
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 70
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR:Ljava/io/File;

    .line 72
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 73
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 74
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 75
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERDOWN:Ljava/io/File;

    .line 76
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 77
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 78
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 79
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERAPK:Ljava/io/File;

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

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHSWF:Ljava/io/File;

    .line 85
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 86
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 87
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 88
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHAPK:Ljava/io/File;

    .line 91
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 92
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 93
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 94
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERY:Ljava/io/File;

    .line 95
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 96
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 97
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 98
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERYAPK:Ljava/io/File;

    .line 101
    iput v3, p0, Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I

    .line 102
    iput-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 118
    iput-object v4, p0, Lcom/aio/downloader/activity/AdultActivity1;->sp_config:Landroid/content/SharedPreferences;

    .line 122
    iput-boolean v3, p0, Lcom/aio/downloader/activity/AdultActivity1;->isfbshow:Z

    .line 129
    new-instance v0, Lcom/aio/downloader/activity/AdultActivity1$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AdultActivity1$1;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->handler:Landroid/os/Handler;

    .line 148
    new-instance v0, Lcom/aio/downloader/activity/AdultActivity1$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AdultActivity1$2;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adult:Landroid/content/BroadcastReceiver;

    .line 62
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/AdultActivity1;Lnet/tsz/afinal/FinalDBChen;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/aio/downloader/activity/AdultActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/AdultActivity1;)I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I

    return v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/AdultActivity1;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/AdultActivity1;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/aio/downloader/activity/AdultActivity1;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/AdultActivity1;)Ljava/util/List;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->mAnimImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/AdultActivity1;)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->mAnimation:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/AdultActivity1;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/AdultActivity1;)Z
    .locals 1

    .prologue
    .line 122
    iget-boolean v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->isfbshow:Z

    return v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/AdultActivity1;I)V
    .locals 0

    .prologue
    .line 101
    iput p1, p0, Lcom/aio/downloader/activity/AdultActivity1;->mRandom:I

    return-void
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 674
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 675
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 237
    const v0, 0x7f070073

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->mAnimImageView:Landroid/widget/ImageView;

    .line 239
    const v0, 0x7f040007

    .line 238
    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->mAnimation:Landroid/view/animation/Animation;

    .line 240
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->mAnimation:Landroid/view/animation/Animation;

    new-instance v1, Lcom/aio/downloader/activity/AdultActivity1$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AdultActivity1$3;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 262
    const v0, 0x7f070099

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->listtitle:Landroid/widget/TextView;

    .line 263
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->listtitle:Landroid/widget/TextView;

    const-string v1, "Adult"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 264
    const v0, 0x7f070102

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    .line 265
    const v0, 0x7f07006a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopgift:Landroid/widget/ImageView;

    .line 267
    const v0, 0x7f070104

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    .line 268
    new-instance v0, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 269
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/AdultActivity1$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AdultActivity1$4;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 278
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/AdultActivity1$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AdultActivity1$5;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 287
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopgift:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/AdultActivity1$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AdultActivity1$6;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 542
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
    .line 684
    const-wide/16 v1, 0x0

    .line 685
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 686
    const/4 v0, 0x0

    .line 687
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 688
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 692
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 690
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 656
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AdultActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 657
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 656
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 658
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 659
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 664
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 670
    :cond_0
    :goto_0
    return-void

    .line 667
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 668
    invoke-direct {p0}, Lcom/aio/downloader/activity/AdultActivity1;->facebookad()V

    .line 669
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->isfbshow:Z

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 592
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 600
    :goto_0
    return-void

    .line 594
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AdultActivity1;->finish()V

    goto :goto_0

    .line 592
    :pswitch_data_0
    .packed-switch 0x7f0700fd
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ResourceAsColor"
        }
    .end annotation

    .prologue
    .line 192
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 194
    const v2, 0x7f03004b

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AdultActivity1;->setContentView(I)V

    .line 195
    invoke-direct {p0}, Lcom/aio/downloader/activity/AdultActivity1;->init()V

    .line 196
    const v2, 0x7f0700fd

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LImageButton;

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->appfan:Lcom/aio/downloader/views/LImageButton;

    .line 197
    const v2, 0x7f0701f9

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    .line 198
    const v2, 0x7f0701fa

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/support/v4/view/ViewPager;

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->pager:Landroid/support/v4/view/ViewPager;

    .line 199
    new-instance v2, Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AdultActivity1;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;-><init>(Lcom/aio/downloader/activity/AdultActivity1;Landroid/support/v4/app/FragmentManager;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->adapter:Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;

    .line 200
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->pager:Landroid/support/v4/view/ViewPager;

    iget-object v3, p0, Lcom/aio/downloader/activity/AdultActivity1;->adapter:Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;

    invoke-virtual {v2, v3}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 201
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/activity/AdultActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    .line 203
    const/4 v2, 0x1

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AdultActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 204
    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    .line 202
    invoke-static {v2, v3, v4}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v1, v2

    .line 205
    .local v1, "pageMargin":I
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 207
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AdultActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080033

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setBackgroundColor(I)V

    .line 208
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setTextColor(I)V

    .line 210
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->appfan:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v2, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    const v2, 0x7f070070

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AdultActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->appbanner:Landroid/widget/LinearLayout;

    .line 213
    const-string v2, "banner_type"

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Lcom/aio/downloader/activity/AdultActivity1;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->sp_config:Landroid/content/SharedPreferences;

    .line 214
    new-instance v2, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v2, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->pubTools:Lcom/aio/downloader/utils/publicTools;

    .line 215
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->sp_config:Landroid/content/SharedPreferences;

    const-string v3, "banner_type"

    const-string v4, "admob"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->banner_type_name:Ljava/lang/String;

    .line 216
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->banner_type_name:Ljava/lang/String;

    const-string v3, "admob"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 217
    new-instance v2, Lcom/google/ads/AdView;

    sget-object v3, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 218
    const-string v4, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v2, p0, v3, v4}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 217
    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->adView:Lcom/google/ads/AdView;

    .line 219
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->appbanner:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/aio/downloader/activity/AdultActivity1;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 220
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->adView:Lcom/google/ads/AdView;

    new-instance v3, Lcom/google/ads/AdRequest;

    invoke-direct {v3}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v2, v3}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 224
    :cond_0
    new-instance v2, Lcom/facebook/ads/NativeAd;

    const-string v3, "340186902832477_401790893338744"

    invoke-direct {v2, p0, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 225
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 226
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 229
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 230
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v2, "adult"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 231
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->adult:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v0}, Lcom/aio/downloader/activity/AdultActivity1;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 233
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 681
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 650
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/FragmentActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 644
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 645
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 646
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 604
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 606
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 608
    :try_start_0
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    const-string v3, "download2.db"

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AdultActivity1;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 609
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 608
    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 610
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 611
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 610
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 616
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 617
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 619
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 620
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 625
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 626
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/AdultActivity1$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AdultActivity1$7;-><init>(Lcom/aio/downloader/activity/AdultActivity1;)V

    .line 638
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 640
    return-void

    .line 621
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :cond_1
    if-nez v6, :cond_0

    .line 623
    iget-object v2, p0, Lcom/aio/downloader/activity/AdultActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 612
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_0
.end method
