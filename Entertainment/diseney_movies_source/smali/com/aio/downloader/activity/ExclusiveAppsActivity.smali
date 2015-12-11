.class public Lcom/aio/downloader/activity/ExclusiveAppsActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "ExclusiveAppsActivity.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/ExclusiveAppsActivity$MyAdapter;
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

.field private adulttopgift:Landroid/widget/ImageView;

.field private adulttopsearch:Lcom/aio/downloader/views/LImageButton;

.field private apptodown:Lcom/aio/downloader/views/LImageButton;

.field private badgedownimg:Lcom/aio/downloader/views/BadgeView;

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

.field private mRandom:I

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field packageInfo:Landroid/content/pm/PackageInfo;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 46
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 48
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 49
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

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 50
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 51
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

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 52
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 53
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

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR:Ljava/io/File;

    .line 56
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 57
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 58
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 59
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERDOWN:Ljava/io/File;

    .line 60
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 61
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 62
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 63
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERAPK:Ljava/io/File;

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

    .line 67
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 68
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 70
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 71
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 72
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 73
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHAPK:Ljava/io/File;

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

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERY:Ljava/io/File;

    .line 80
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 81
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 82
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 83
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 85
    iput v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I

    .line 86
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 91
    iput-boolean v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->isfbshow:Z

    .line 95
    new-instance v0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$1;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->handler:Landroid/os/Handler;

    .line 46
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Z
    .locals 1

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->isfbshow:Z

    return v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/ExclusiveAppsActivity;I)V
    .locals 0

    .prologue
    .line 85
    iput p1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)I
    .locals 1

    .prologue
    .line 85
    iget v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->mRandom:I

    return v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 475
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 476
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
    .line 531
    const-wide/16 v1, 0x0

    .line 532
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 533
    const/4 v0, 0x0

    .line 534
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 535
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 539
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 537
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 457
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 458
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 457
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 459
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 460
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 465
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 471
    :cond_0
    :goto_0
    return-void

    .line 468
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 469
    invoke-direct {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->facebookad()V

    .line 470
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->isfbshow:Z

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 116
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->requestWindowFeature(I)Z

    .line 117
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 118
    const v3, 0x7f030039

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->setContentView(I)V

    .line 120
    const v3, 0x7f070102

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LImageButton;

    iput-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    .line 121
    const v3, 0x7f07006a

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopgift:Landroid/widget/ImageView;

    .line 122
    const v3, 0x7f070104

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LImageButton;

    iput-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    .line 124
    new-instance v3, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v3, v4, v5}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 126
    iget-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$2;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$2;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 135
    iget-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$3;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$3;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    iget-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->adulttopgift:Landroid/widget/ImageView;

    new-instance v4, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$4;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 413
    const v3, 0x7f07019b

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/support/v4/view/ViewPager;

    .line 414
    .local v2, "vp":Landroid/support/v4/view/ViewPager;
    const v3, 0x7f070199

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LImageButton;

    .line 415
    .local v1, "exclusive_fan":Lcom/aio/downloader/views/LImageButton;
    new-instance v3, Lcom/aio/downloader/activity/ExclusiveAppsActivity$5;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$5;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V

    invoke-virtual {v1, v3}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 423
    new-instance v0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$MyAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$MyAdapter;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;Landroid/support/v4/app/FragmentManager;)V

    .line 424
    .local v0, "adapter":Lcom/aio/downloader/activity/ExclusiveAppsActivity$MyAdapter;
    invoke-virtual {v2, v0}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 426
    new-instance v3, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "340186902832477_401790893338744"

    invoke-direct {v3, v4, v5}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 427
    iget-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 428
    iget-object v3, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v4, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v3, v4}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 429
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 482
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 526
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 527
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 528
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 487
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 488
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 490
    :try_start_0
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 491
    const-string v4, "download2.db"

    .line 490
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 491
    invoke-virtual {v4}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 490
    iput-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 492
    iget-object v0, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 493
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 492
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 498
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 499
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 501
    iget-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 502
    iget-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 507
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 508
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/ExclusiveAppsActivity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/ExclusiveAppsActivity$6;-><init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;)V

    .line 520
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 521
    return-void

    .line 503
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :cond_1
    if-nez v6, :cond_0

    .line 505
    iget-object v2, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 494
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_0
.end method
