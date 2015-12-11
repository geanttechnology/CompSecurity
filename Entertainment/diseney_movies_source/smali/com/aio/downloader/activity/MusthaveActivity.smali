.class public Lcom/aio/downloader/activity/MusthaveActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "MusthaveActivity.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MusthaveActivity$MyAdapter;
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

    .line 49
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 50
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

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 51
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 52
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

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 53
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 54
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

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR:Ljava/io/File;

    .line 57
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 58
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 59
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 60
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERDOWN:Ljava/io/File;

    .line 61
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 62
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 63
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 64
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERAPK:Ljava/io/File;

    .line 66
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 67
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 68
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 69
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHSWF:Ljava/io/File;

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

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHAPK:Ljava/io/File;

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

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERY:Ljava/io/File;

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

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 85
    iput v3, p0, Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I

    .line 86
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 91
    iput-boolean v3, p0, Lcom/aio/downloader/activity/MusthaveActivity;->isfbshow:Z

    .line 95
    new-instance v0, Lcom/aio/downloader/activity/MusthaveActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MusthaveActivity$1;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->handler:Landroid/os/Handler;

    .line 46
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MusthaveActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MusthaveActivity;)Z
    .locals 1

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->isfbshow:Z

    return v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/MusthaveActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MusthaveActivity;I)V
    .locals 0

    .prologue
    .line 85
    iput p1, p0, Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MusthaveActivity;)I
    .locals 1

    .prologue
    .line 85
    iget v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->mRandom:I

    return v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/MusthaveActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 462
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 463
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
    .line 518
    const-wide/16 v1, 0x0

    .line 519
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 520
    const/4 v0, 0x0

    .line 521
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 522
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 526
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 524
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 444
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 445
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 444
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 446
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 447
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 452
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 458
    :cond_0
    :goto_0
    return-void

    .line 455
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 456
    invoke-direct {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->facebookad()V

    .line 457
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->isfbshow:Z

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 116
    const/4 v4, 0x1

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->requestWindowFeature(I)Z

    .line 117
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 118
    const v4, 0x7f030039

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->setContentView(I)V

    .line 120
    const v4, 0x7f07019a

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 121
    .local v2, "tv_ex_title":Landroid/widget/TextView;
    const-string v4, "Must-Have Apps"

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 122
    const v4, 0x7f070102

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/LImageButton;

    iput-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    .line 123
    const v4, 0x7f07006a

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopgift:Landroid/widget/ImageView;

    .line 124
    const v4, 0x7f070104

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/LImageButton;

    iput-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    .line 125
    new-instance v4, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/activity/MusthaveActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v4, v5, v6}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 126
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    new-instance v5, Lcom/aio/downloader/activity/MusthaveActivity$2;

    invoke-direct {v5, p0}, Lcom/aio/downloader/activity/MusthaveActivity$2;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 135
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    new-instance v5, Lcom/aio/downloader/activity/MusthaveActivity$3;

    invoke-direct {v5, p0}, Lcom/aio/downloader/activity/MusthaveActivity$3;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->adulttopgift:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/activity/MusthaveActivity$4;

    invoke-direct {v5, p0}, Lcom/aio/downloader/activity/MusthaveActivity$4;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 400
    const v4, 0x7f07019b

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/support/v4/view/ViewPager;

    .line 401
    .local v3, "vp":Landroid/support/v4/view/ViewPager;
    const v4, 0x7f070199

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LImageButton;

    .line 402
    .local v1, "exclusive_fan":Lcom/aio/downloader/views/LImageButton;
    new-instance v4, Lcom/aio/downloader/activity/MusthaveActivity$5;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MusthaveActivity$5;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;)V

    invoke-virtual {v1, v4}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 410
    new-instance v0, Lcom/aio/downloader/activity/MusthaveActivity$MyAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    invoke-direct {v0, p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity$MyAdapter;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;Landroid/support/v4/app/FragmentManager;)V

    .line 411
    .local v0, "adapter":Lcom/aio/downloader/activity/MusthaveActivity$MyAdapter;
    invoke-virtual {v3, v0}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 413
    new-instance v4, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "340186902832477_401790893338744"

    invoke-direct {v4, v5, v6}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 414
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v4, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 415
    iget-object v4, p0, Lcom/aio/downloader/activity/MusthaveActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v5, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v4, v5}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 416
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 469
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 513
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 514
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 515
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 474
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 475
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 477
    :try_start_0
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/MusthaveActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 478
    const-string v4, "download2.db"

    .line 477
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/MusthaveActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 478
    invoke-virtual {v4}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 477
    iput-object v2, p0, Lcom/aio/downloader/activity/MusthaveActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 479
    iget-object v0, p0, Lcom/aio/downloader/activity/MusthaveActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 480
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 479
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/MusthaveActivity;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 485
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/MusthaveActivity;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 486
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 488
    iget-object v2, p0, Lcom/aio/downloader/activity/MusthaveActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 489
    iget-object v2, p0, Lcom/aio/downloader/activity/MusthaveActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 494
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 495
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/MusthaveActivity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MusthaveActivity$6;-><init>(Lcom/aio/downloader/activity/MusthaveActivity;)V

    .line 507
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 508
    return-void

    .line 490
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :cond_1
    if-nez v6, :cond_0

    .line 492
    iget-object v2, p0, Lcom/aio/downloader/activity/MusthaveActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 481
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_0
.end method
