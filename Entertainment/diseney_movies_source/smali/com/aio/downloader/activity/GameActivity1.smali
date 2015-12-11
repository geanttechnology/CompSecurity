.class public Lcom/aio/downloader/activity/GameActivity1;
.super Landroid/support/v4/app/FragmentActivity;
.source "GameActivity1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;
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

.field private adapter:Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;

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

.field private game:Landroid/content/BroadcastReceiver;

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

    .line 64
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

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

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR_FOME:Ljava/io/File;

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

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR_TO:Ljava/io/File;

    .line 71
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 72
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

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR:Ljava/io/File;

    .line 73
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 74
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 75
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 76
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERDOWN:Ljava/io/File;

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

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERAPK:Ljava/io/File;

    .line 82
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 83
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 84
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 85
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHSWF:Ljava/io/File;

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

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHAPK:Ljava/io/File;

    .line 92
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 93
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 94
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 95
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERY:Ljava/io/File;

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

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERYAPK:Ljava/io/File;

    .line 101
    iput v3, p0, Lcom/aio/downloader/activity/GameActivity1;->mRandom:I

    .line 102
    iput-object v4, p0, Lcom/aio/downloader/activity/GameActivity1;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 117
    iput-object v4, p0, Lcom/aio/downloader/activity/GameActivity1;->sp_config:Landroid/content/SharedPreferences;

    .line 121
    iput-boolean v3, p0, Lcom/aio/downloader/activity/GameActivity1;->isfbshow:Z

    .line 128
    new-instance v0, Lcom/aio/downloader/activity/GameActivity1$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/GameActivity1$1;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->handler:Landroid/os/Handler;

    .line 147
    new-instance v0, Lcom/aio/downloader/activity/GameActivity1$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/GameActivity1$2;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->game:Landroid/content/BroadcastReceiver;

    .line 64
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/GameActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/GameActivity1;Lnet/tsz/afinal/FinalDBChen;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/aio/downloader/activity/GameActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/GameActivity1;)I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/aio/downloader/activity/GameActivity1;->mRandom:I

    return v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/GameActivity1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/GameActivity1;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/GameActivity1;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/GameActivity1;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/aio/downloader/activity/GameActivity1;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/GameActivity1;)Ljava/util/List;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/GameActivity1;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->mAnimImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/GameActivity1;)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->mAnimation:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/GameActivity1;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/GameActivity1;)Z
    .locals 1

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/aio/downloader/activity/GameActivity1;->isfbshow:Z

    return v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/GameActivity1;I)V
    .locals 0

    .prologue
    .line 101
    iput p1, p0, Lcom/aio/downloader/activity/GameActivity1;->mRandom:I

    return-void
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 679
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 680
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 235
    const v0, 0x7f070073

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->mAnimImageView:Landroid/widget/ImageView;

    .line 237
    const v0, 0x7f040007

    .line 236
    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->mAnimation:Landroid/view/animation/Animation;

    .line 238
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->mAnimation:Landroid/view/animation/Animation;

    new-instance v1, Lcom/aio/downloader/activity/GameActivity1$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/GameActivity1$3;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 260
    const v0, 0x7f070099

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->listtitle:Landroid/widget/TextView;

    .line 261
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->listtitle:Landroid/widget/TextView;

    const-string v1, "Game"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    const v0, 0x7f070102

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    .line 263
    const v0, 0x7f07006a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopgift:Landroid/widget/ImageView;

    .line 265
    const v0, 0x7f070104

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    .line 266
    new-instance v0, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 267
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->apptodown:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/GameActivity1$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/GameActivity1$4;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 276
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/GameActivity1$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/GameActivity1$5;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 285
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopgift:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/GameActivity1$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/GameActivity1$6;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 540
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
    .line 689
    const-wide/16 v1, 0x0

    .line 690
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 691
    const/4 v0, 0x0

    .line 692
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 693
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 697
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 695
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 661
    invoke-virtual {p0}, Lcom/aio/downloader/activity/GameActivity1;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 662
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 661
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 663
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 664
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 669
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 675
    :cond_0
    :goto_0
    return-void

    .line 672
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 673
    invoke-direct {p0}, Lcom/aio/downloader/activity/GameActivity1;->facebookad()V

    .line 674
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/GameActivity1;->isfbshow:Z

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 597
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 605
    :goto_0
    return-void

    .line 599
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/GameActivity1;->finish()V

    goto :goto_0

    .line 597
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
    .line 191
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 193
    const v2, 0x7f03004b

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/GameActivity1;->setContentView(I)V

    .line 194
    invoke-direct {p0}, Lcom/aio/downloader/activity/GameActivity1;->init()V

    .line 195
    const v2, 0x7f0700fd

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LImageButton;

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->appfan:Lcom/aio/downloader/views/LImageButton;

    .line 196
    const v2, 0x7f0701f9

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    .line 197
    const v2, 0x7f0701fa

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/support/v4/view/ViewPager;

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->pager:Landroid/support/v4/view/ViewPager;

    .line 198
    new-instance v2, Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/GameActivity1;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;-><init>(Lcom/aio/downloader/activity/GameActivity1;Landroid/support/v4/app/FragmentManager;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->adapter:Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;

    .line 199
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->pager:Landroid/support/v4/view/ViewPager;

    iget-object v3, p0, Lcom/aio/downloader/activity/GameActivity1;->adapter:Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;

    invoke-virtual {v2, v3}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 200
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/activity/GameActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    .line 202
    const/4 v2, 0x1

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {p0}, Lcom/aio/downloader/activity/GameActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 203
    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    .line 201
    invoke-static {v2, v3, v4}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v1, v2

    .line 204
    .local v1, "pageMargin":I
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->pager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 206
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->tabs:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/GameActivity1;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080033

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setBackgroundColor(I)V

    .line 209
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->appfan:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v2, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 211
    const v2, 0x7f070070

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/GameActivity1;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->appbanner:Landroid/widget/LinearLayout;

    .line 212
    const-string v2, "banner_type"

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Lcom/aio/downloader/activity/GameActivity1;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->sp_config:Landroid/content/SharedPreferences;

    .line 213
    new-instance v2, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v2, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->pubTools:Lcom/aio/downloader/utils/publicTools;

    .line 214
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->sp_config:Landroid/content/SharedPreferences;

    const-string v3, "banner_type"

    const-string v4, "admob"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->banner_type_name:Ljava/lang/String;

    .line 215
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->banner_type_name:Ljava/lang/String;

    const-string v3, "admob"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 216
    new-instance v2, Lcom/google/ads/AdView;

    sget-object v3, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 217
    const-string v4, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v2, p0, v3, v4}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 216
    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->adView:Lcom/google/ads/AdView;

    .line 218
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->appbanner:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/aio/downloader/activity/GameActivity1;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 219
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->adView:Lcom/google/ads/AdView;

    new-instance v3, Lcom/google/ads/AdRequest;

    invoke-direct {v3}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v2, v3}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 222
    :cond_0
    new-instance v2, Lcom/facebook/ads/NativeAd;

    const-string v3, "340186902832477_401790893338744"

    invoke-direct {v2, p0, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 223
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 224
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 227
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 228
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v2, "game"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 229
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->game:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v0}, Lcom/aio/downloader/activity/GameActivity1;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 231
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 686
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 655
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/FragmentActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 649
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 650
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 651
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 609
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 611
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 613
    :try_start_0
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    const-string v3, "download2.db"

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/GameActivity1;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 614
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 613
    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 615
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 616
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 615
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 621
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 622
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 624
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 625
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 630
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 631
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/GameActivity1$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/GameActivity1$7;-><init>(Lcom/aio/downloader/activity/GameActivity1;)V

    .line 643
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 645
    return-void

    .line 626
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :cond_1
    if-nez v6, :cond_0

    .line 628
    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 617
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_0
.end method
