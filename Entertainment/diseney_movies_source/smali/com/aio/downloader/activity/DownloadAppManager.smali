.class public Lcom/aio/downloader/activity/DownloadAppManager;
.super Landroid/app/Activity;
.source "DownloadAppManager.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOGALLERY:Ljava/io/File;

.field private AIOGALLERYAPK:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private badgedownimg_downlaod:Lcom/aio/downloader/views/BadgeView;

.field private badgedownimg_update:Lcom/aio/downloader/views/BadgeView;

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

.field private firstsd:J

.field private iv_fb_manage:Landroid/widget/ImageView;

.field private iv_manager_download:Landroid/widget/ImageView;

.field private iv_manager_update:Landroid/widget/ImageView;

.field private lf_fb_manager:Lcom/aio/downloader/views/LFrameLayout;

.field private memoryManager:Lcom/aio/downloader/utils/MemoryManager;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private sencondsd:J

.field private tv_fb_tv:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    const-wide/16 v3, 0x0

    .line 45
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 55
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 59
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 60
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

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR_FOME:Ljava/io/File;

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

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR_TO:Ljava/io/File;

    .line 63
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 64
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

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR:Ljava/io/File;

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

    .line 69
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 70
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERY:Ljava/io/File;

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

    .line 73
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 74
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERYAPK:Ljava/io/File;

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

    const-string v2, "gallery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERY:Ljava/io/File;

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

    const-string v2, "gallery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERYAPK:Ljava/io/File;

    .line 88
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 89
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 90
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 91
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERDOWN:Ljava/io/File;

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

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERAPK:Ljava/io/File;

    .line 102
    iput-wide v3, p0, Lcom/aio/downloader/activity/DownloadAppManager;->sencondsd:J

    .line 103
    iput-wide v3, p0, Lcom/aio/downloader/activity/DownloadAppManager;->firstsd:J

    .line 45
    return-void
.end method

.method private ExistSDCard()Z
    .locals 2

    .prologue
    .line 597
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    .line 598
    const-string v1, "mounted"

    .line 597
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 598
    if-eqz v0, :cond_0

    .line 599
    const/4 v0, 0x1

    .line 601
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/DownloadAppManager;)Ljava/io/File;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method private backupApp(Ljava/lang/String;)V
    .locals 8
    .param p1, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 606
    new-instance v4, Ljava/io/File;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "/data/app/"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ".apk"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 607
    .local v4, "in":Ljava/io/File;
    new-instance v5, Ljava/io/File;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 608
    const-string v7, "AIO_BACKUPAPP"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ".apk"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 607
    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 609
    .local v5, "out":Ljava/io/File;
    invoke-virtual {v5}, Ljava/io/File;->createNewFile()Z

    .line 610
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v4}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 611
    .local v2, "fis":Ljava/io/FileInputStream;
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 614
    .local v3, "fos":Ljava/io/FileOutputStream;
    const/high16 v6, 0x40000

    new-array v0, v6, [B

    .line 615
    .local v0, "buffer":[B
    :goto_0
    invoke-virtual {v2, v0}, Ljava/io/FileInputStream;->read([B)I

    move-result v1

    .local v1, "count":I
    if-gtz v1, :cond_0

    .line 619
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    .line 620
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V

    .line 621
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V

    .line 622
    return-void

    .line 616
    :cond_0
    const/4 v6, 0x0

    invoke-virtual {v3, v0, v6, v1}, Ljava/io/FileOutputStream;->write([BII)V

    goto :goto_0
.end method

.method private backupApplication(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "appId"    # Ljava/lang/String;
    .param p2, "dest"    # Ljava/lang/String;

    .prologue
    .line 633
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v10

    if-eqz v10, :cond_0

    if-eqz p2, :cond_0

    .line 634
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v10

    if-nez v10, :cond_2

    .line 635
    :cond_0
    const-string v10, "illegal parameters"

    .line 693
    :cond_1
    :goto_0
    return-object v10

    .line 640
    :cond_2
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "/data/app/"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "-1.apk"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 641
    .local v1, "apkPath":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 642
    .local v0, "apkFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_3

    .line 643
    const-string v10, "backup"

    const-string v11, "apkfile\u4e3a\u7a7a"

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 647
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_3

    .line 648
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, " doesn\'t exist!"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    goto :goto_0

    .line 651
    :cond_3
    const/4 v6, 0x0

    .line 653
    .local v6, "in":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    .end local v6    # "in":Ljava/io/FileInputStream;
    invoke-direct {v6, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 659
    .restart local v6    # "in":Ljava/io/FileInputStream;
    const/16 v10, 0x2f

    invoke-virtual {p2, v10}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v5

    .line 660
    .local v5, "i":I
    const/4 v10, -0x1

    if-eq v5, v10, :cond_4

    .line 661
    new-instance v3, Ljava/io/File;

    const/4 v10, 0x0

    invoke-virtual {p2, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v3, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 662
    .local v3, "dirs":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->mkdirs()Z

    .line 666
    .end local v3    # "dirs":Ljava/io/File;
    :cond_4
    const/16 v10, 0x400

    new-array v2, v10, [B

    .line 668
    .local v2, "c":[B
    const/4 v7, 0x0

    .line 670
    .local v7, "out":Ljava/io/FileOutputStream;
    :try_start_1
    new-instance v8, Ljava/io/FileOutputStream;

    invoke-direct {v8, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 671
    .end local v7    # "out":Ljava/io/FileOutputStream;
    .local v8, "out":Ljava/io/FileOutputStream;
    :goto_1
    const/4 v10, 0x0

    :try_start_2
    array-length v11, v2

    invoke-virtual {v6, v2, v10, v11}, Ljava/io/FileInputStream;->read([BII)I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v9

    .local v9, "slen":I
    const/4 v10, -0x1

    if-ne v9, v10, :cond_7

    .line 677
    if-eqz v8, :cond_5

    .line 679
    :try_start_3
    invoke-virtual {v8}, Ljava/io/FileOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_6

    .line 684
    :cond_5
    if-eqz v6, :cond_6

    .line 686
    :try_start_4
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7

    .line 693
    :cond_6
    const-string v10, "success"

    goto :goto_0

    .line 654
    .end local v2    # "c":[B
    .end local v5    # "i":I
    .end local v6    # "in":Ljava/io/FileInputStream;
    .end local v8    # "out":Ljava/io/FileOutputStream;
    .end local v9    # "slen":I
    :catch_0
    move-exception v4

    .line 655
    .local v4, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->printStackTrace()V

    .line 656
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 672
    .end local v4    # "e":Ljava/io/FileNotFoundException;
    .restart local v2    # "c":[B
    .restart local v5    # "i":I
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v8    # "out":Ljava/io/FileOutputStream;
    .restart local v9    # "slen":I
    :cond_7
    const/4 v10, 0x0

    :try_start_5
    invoke-virtual {v8, v2, v10, v9}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_1

    .line 673
    .end local v9    # "slen":I
    :catch_1
    move-exception v4

    move-object v7, v8

    .line 674
    .end local v8    # "out":Ljava/io/FileOutputStream;
    .local v4, "e":Ljava/io/IOException;
    .restart local v7    # "out":Ljava/io/FileOutputStream;
    :goto_2
    :try_start_6
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 675
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v10

    .line 677
    if-eqz v7, :cond_8

    .line 679
    :try_start_7
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3

    .line 684
    :cond_8
    if-eqz v6, :cond_1

    .line 686
    :try_start_8
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2

    goto/16 :goto_0

    .line 687
    :catch_2
    move-exception v4

    .line 688
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 689
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 680
    :catch_3
    move-exception v4

    .line 681
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 682
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 676
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 677
    :goto_3
    if-eqz v7, :cond_9

    .line 679
    :try_start_9
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_4

    .line 684
    :cond_9
    if-eqz v6, :cond_a

    .line 686
    :try_start_a
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_5

    .line 692
    :cond_a
    throw v10

    .line 680
    :catch_4
    move-exception v4

    .line 681
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 682
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 687
    .end local v4    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v4

    .line 688
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 689
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 680
    .end local v4    # "e":Ljava/io/IOException;
    .end local v7    # "out":Ljava/io/FileOutputStream;
    .restart local v8    # "out":Ljava/io/FileOutputStream;
    .restart local v9    # "slen":I
    :catch_6
    move-exception v4

    .line 681
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 682
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 687
    .end local v4    # "e":Ljava/io/IOException;
    :catch_7
    move-exception v4

    .line 688
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 689
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 676
    .end local v4    # "e":Ljava/io/IOException;
    .end local v9    # "slen":I
    :catchall_1
    move-exception v10

    move-object v7, v8

    .end local v8    # "out":Ljava/io/FileOutputStream;
    .restart local v7    # "out":Ljava/io/FileOutputStream;
    goto :goto_3

    .line 673
    :catch_8
    move-exception v4

    goto :goto_2
.end method

.method private facebookad()V
    .locals 3

    .prologue
    .line 568
    iget-object v1, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd;->getAdIcon()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 569
    .local v0, "adIcon":Lcom/facebook/ads/NativeAd$Image;
    iget-object v1, p0, Lcom/aio/downloader/activity/DownloadAppManager;->iv_fb_manage:Landroid/widget/ImageView;

    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 571
    iget-object v1, p0, Lcom/aio/downloader/activity/DownloadAppManager;->tv_fb_tv:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2}, Lcom/facebook/ads/NativeAd;->getAdTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 572
    iget-object v1, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    iget-object v2, p0, Lcom/aio/downloader/activity/DownloadAppManager;->lf_fb_manager:Lcom/aio/downloader/views/LFrameLayout;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 573
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
    .line 549
    const-wide/16 v1, 0x0

    .line 550
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 551
    const/4 v0, 0x0

    .line 552
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 553
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 557
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 555
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 564
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 578
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 588
    :cond_0
    :goto_0
    return-void

    .line 583
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 586
    invoke-direct {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->facebookad()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 12
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 157
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v8

    packed-switch v8, :pswitch_data_0

    .line 503
    :goto_0
    :pswitch_0
    return-void

    .line 159
    :pswitch_1
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    const-class v9, Lcom/aio/downloader/unstall/Unstall;

    invoke-direct {v2, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 160
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 163
    .end local v2    # "intent":Landroid/content/Intent;
    :pswitch_2
    new-instance v7, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 164
    const-class v9, Lcom/aio/downloader/activity/UpdateActivity;

    .line 163
    invoke-direct {v7, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 165
    .local v7, "intent_update":Landroid/content/Intent;
    invoke-virtual {p0, v7}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 168
    .end local v7    # "intent_update":Landroid/content/Intent;
    :pswitch_3
    new-instance v6, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 169
    const-class v9, Lcom/aio/downloader/unstall/MyAppActivity;

    .line 168
    invoke-direct {v6, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 170
    .local v6, "intent_myapp":Landroid/content/Intent;
    invoke-virtual {p0, v6}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 173
    .end local v6    # "intent_myapp":Landroid/content/Intent;
    :pswitch_4
    new-instance v5, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 174
    const-class v9, Lcom/aio/downloader/activity/MyDownloaderList;

    .line 173
    invoke-direct {v5, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 175
    .local v5, "intent_ll_manager":Landroid/content/Intent;
    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 178
    .end local v5    # "intent_ll_manager":Landroid/content/Intent;
    :pswitch_5
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->finish()V

    goto :goto_0

    .line 183
    :pswitch_6
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 184
    const-string v9, "com.evzapp.cleanmaster"

    const/4 v10, 0x0

    .line 183
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 188
    :goto_1
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v8, :cond_2

    .line 189
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 190
    new-instance v0, Landroid/content/Intent;

    const-string v8, "android.intent.action.VIEW"

    invoke-direct {v0, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 192
    .local v0, "aa":Landroid/content/Intent;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "file://"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    .line 193
    const-string v9, "cleaner.apk"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    .line 192
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 194
    const-string v9, "application/vnd.android.package-archive"

    .line 191
    invoke-virtual {v0, v8, v9}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 195
    const/high16 v8, 0x10000000

    invoke-virtual {v0, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 196
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 185
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 186
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 197
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_0
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->PRO_DIR_TO:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 198
    new-instance v8, Lcom/aio/downloader/activity/DownloadAppManager$1;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/DownloadAppManager$1;-><init>(Lcom/aio/downloader/activity/DownloadAppManager;)V

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Void;

    .line 219
    invoke-virtual {v8, v9}, Lcom/aio/downloader/activity/DownloadAppManager$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 221
    :cond_1
    new-instance v3, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 222
    const-class v9, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 221
    invoke-direct {v3, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 223
    .local v3, "intent_1":Landroid/content/Intent;
    const-string v8, "myid"

    const-string v9, "com.evzapp.cleanmaster"

    invoke-virtual {v3, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 224
    const/high16 v8, 0x10000000

    invoke-virtual {v3, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 225
    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 228
    .end local v3    # "intent_1":Landroid/content/Intent;
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 229
    const-string v9, "com.evzapp.cleanmaster"

    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v4

    .line 230
    .local v4, "intent_cleaner":Landroid/content/Intent;
    const/high16 v8, 0x10000000

    invoke-virtual {v4, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 231
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 236
    .end local v4    # "intent_cleaner":Landroid/content/Intent;
    :pswitch_7
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 237
    const-string v9, "com.aioapp.battery"

    const/4 v10, 0x0

    .line 236
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 241
    :goto_2
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v8, :cond_5

    .line 243
    :try_start_2
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 244
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->getFileSizes(Ljava/io/File;)J

    move-result-wide v8

    const-wide/32 v10, 0x377eff

    cmp-long v8, v8, v10

    if-ltz v8, :cond_3

    .line 245
    new-instance v2, Landroid/content/Intent;

    const-string v8, "android.intent.action.VIEW"

    invoke-direct {v2, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 247
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "file://"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 248
    const-string v9, "application/vnd.android.package-archive"

    .line 246
    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 249
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 250
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    .line 282
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 284
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 238
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 239
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 251
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_3
    :try_start_3
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 252
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->getFileSizes(Ljava/io/File;)J

    move-result-wide v8

    const-wide/32 v10, 0x377eff

    cmp-long v8, v8, v10

    if-ltz v8, :cond_4

    .line 253
    new-instance v8, Lcom/aio/downloader/activity/DownloadAppManager$2;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/DownloadAppManager$2;-><init>(Lcom/aio/downloader/activity/DownloadAppManager;)V

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Void;

    .line 273
    invoke-virtual {v8, v9}, Lcom/aio/downloader/activity/DownloadAppManager$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 275
    :cond_4
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 276
    const-class v9, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 275
    invoke-direct {v2, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 277
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v8, "myid"

    const-string v9, "com.aioapp.battery"

    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 279
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 280
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_0

    .line 287
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_5
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 288
    const-string v9, "com.aioapp.battery"

    .line 287
    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 289
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 290
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 295
    .end local v2    # "intent":Landroid/content/Intent;
    :pswitch_8
    :try_start_4
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 296
    const-string v9, "com.aioapp.gallery"

    const/4 v10, 0x0

    .line 295
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 300
    :goto_3
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v8, :cond_8

    .line 302
    :try_start_5
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 303
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->getFileSizes(Ljava/io/File;)J

    move-result-wide v8

    const-wide/32 v10, 0x1bff04

    cmp-long v8, v8, v10

    if-ltz v8, :cond_6

    .line 304
    new-instance v2, Landroid/content/Intent;

    const-string v8, "android.intent.action.VIEW"

    invoke-direct {v2, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 306
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "file://"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 307
    const-string v9, "application/vnd.android.package-archive"

    .line 305
    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 308
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 309
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 343
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 345
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 297
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 298
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 310
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_6
    :try_start_6
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 311
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->getFileSizes(Ljava/io/File;)J

    move-result-wide v8

    const-wide/32 v10, 0x1bff04

    cmp-long v8, v8, v10

    if-ltz v8, :cond_7

    .line 313
    new-instance v8, Lcom/aio/downloader/activity/DownloadAppManager$3;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/DownloadAppManager$3;-><init>(Lcom/aio/downloader/activity/DownloadAppManager;)V

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Void;

    .line 334
    invoke-virtual {v8, v9}, Lcom/aio/downloader/activity/DownloadAppManager$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 337
    :cond_7
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 338
    const-class v9, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 337
    invoke-direct {v2, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 339
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v8, "myid"

    const-string v9, "com.androidapp.gallary3d"

    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 340
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 341
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_0

    .line 348
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_8
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 349
    const-string v9, "com.aioapp.gallery"

    .line 348
    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 350
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 351
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 356
    .end local v2    # "intent":Landroid/content/Intent;
    :pswitch_9
    :try_start_7
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 357
    const-string v9, "com.aioapp.wallpaper"

    const/4 v10, 0x0

    .line 356
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_5

    .line 361
    :goto_4
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v8, :cond_9

    .line 362
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 363
    const-class v9, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 362
    invoke-direct {v2, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 364
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v8, "myid"

    const-string v9, "com.aioapp.wallpaper"

    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 365
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 366
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 358
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 359
    .restart local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 368
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_9
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 369
    const-string v9, "com.aioapp.wallpaper"

    .line 368
    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 370
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 371
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 376
    .end local v2    # "intent":Landroid/content/Intent;
    :pswitch_a
    :try_start_8
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 377
    const-string v9, "com.evzapp.mydiylocker"

    const/4 v10, 0x0

    .line 376
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_8
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_8 .. :try_end_8} :catch_6

    .line 381
    :goto_5
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v8, :cond_a

    .line 382
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 383
    const-class v9, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 382
    invoke-direct {v2, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 384
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v8, "myid"

    const-string v9, "com.evzapp.mydiylocker"

    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 385
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 386
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 378
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_6
    move-exception v1

    .line 379
    .restart local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_5

    .line 388
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_a
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 389
    const-string v9, "com.evzapp.mydiylocker"

    .line 388
    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 390
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 391
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 397
    .end local v2    # "intent":Landroid/content/Intent;
    :pswitch_b
    :try_start_9
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 398
    const-string v9, "com.allinone.callerid"

    const/4 v10, 0x0

    .line 397
    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_9
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_9 .. :try_end_9} :catch_8

    .line 402
    :goto_6
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v8, :cond_d

    .line 404
    :try_start_a
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_b

    .line 405
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->getFileSizes(Ljava/io/File;)J

    move-result-wide v8

    const-wide/32 v10, 0x357458

    cmp-long v8, v8, v10

    if-ltz v8, :cond_b

    .line 406
    new-instance v2, Landroid/content/Intent;

    const-string v8, "android.intent.action.VIEW"

    invoke-direct {v2, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 408
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "file://"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 409
    const-string v9, "application/vnd.android.package-archive"

    .line 407
    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 410
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 411
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_7

    goto/16 :goto_0

    .line 447
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_7
    move-exception v1

    .line 449
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 399
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_8
    move-exception v1

    .line 400
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_6

    .line 412
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_b
    :try_start_b
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_c

    .line 413
    iget-object v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->getFileSizes(Ljava/io/File;)J

    move-result-wide v8

    const-wide/32 v10, 0x357458

    cmp-long v8, v8, v10

    if-ltz v8, :cond_c

    .line 415
    new-instance v8, Lcom/aio/downloader/activity/DownloadAppManager$4;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/DownloadAppManager$4;-><init>(Lcom/aio/downloader/activity/DownloadAppManager;)V

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Void;

    .line 438
    invoke-virtual {v8, v9}, Lcom/aio/downloader/activity/DownloadAppManager$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 441
    :cond_c
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 442
    const-class v9, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 441
    invoke-direct {v2, v8, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 443
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v8, "myid"

    const-string v9, "com.allinone.callerid"

    invoke-virtual {v2, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 444
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 445
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_7

    goto/16 :goto_0

    .line 452
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_d
    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 453
    const-string v9, "com.allinone.callerid"

    .line 452
    invoke-virtual {v8, v9}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 454
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v8, 0x10000000

    invoke-virtual {v2, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 455
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 460
    .end local v2    # "intent":Landroid/content/Intent;
    :pswitch_c
    iget-wide v8, p0, Lcom/aio/downloader/activity/DownloadAppManager;->sencondsd:J

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-nez v8, :cond_e

    .line 461
    new-instance v8, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 462
    const-class v10, Lcom/aio/downloader/unstall/Move2NOSD;

    invoke-direct {v8, v9, v10}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 461
    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    .line 467
    :goto_7
    const-string v8, "qqq"

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "diyi="

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lcom/aio/downloader/activity/DownloadAppManager;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {v10}, Lcom/aio/downloader/utils/MemoryManager;->getSDTotalSize()J

    move-result-wide v10

    invoke-virtual {v9, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "dier="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 468
    iget-object v10, p0, Lcom/aio/downloader/activity/DownloadAppManager;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {v10}, Lcom/aio/downloader/utils/MemoryManager;->getSecondSDTotalSize()J

    move-result-wide v10

    invoke-virtual {v9, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "guangfang="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 469
    invoke-direct {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->ExistSDCard()Z

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 467
    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 464
    :cond_e
    new-instance v8, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 465
    const-class v10, Lcom/aio/downloader/unstall/Move2SDActivity;

    invoke-direct {v8, v9, v10}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 464
    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto :goto_7

    .line 496
    :pswitch_d
    new-instance v8, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 497
    const-class v10, Lcom/aio/downloader/activity/BackupActivity;

    invoke-direct {v8, v9, v10}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 496
    invoke-virtual {p0, v8}, Lcom/aio/downloader/activity/DownloadAppManager;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 157
    nop

    :pswitch_data_0
    .packed-switch 0x7f0702fe
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_c
        :pswitch_d
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 108
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 109
    const v4, 0x7f030081

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->setContentView(I)V

    .line 111
    const v4, 0x7f070303

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->lf_fb_manager:Lcom/aio/downloader/views/LFrameLayout;

    .line 112
    const v4, 0x7f070304

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->iv_fb_manage:Landroid/widget/ImageView;

    .line 113
    const v4, 0x7f070305

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->tv_fb_tv:Landroid/widget/TextView;

    .line 115
    const v4, 0x7f070306

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LFrameLayout;

    .line 116
    .local v2, "ll_uninstall":Lcom/aio/downloader/views/LFrameLayout;
    const v4, 0x7f070301

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LFrameLayout;

    .line 117
    .local v3, "ll_update":Lcom/aio/downloader/views/LFrameLayout;
    const v4, 0x7f070307

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LFrameLayout;

    .line 118
    .local v1, "ll_myapp":Lcom/aio/downloader/views/LFrameLayout;
    const v4, 0x7f0702ff

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LFrameLayout;

    .line 120
    .local v0, "ll_manager":Lcom/aio/downloader/views/LFrameLayout;
    new-instance v4, Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/aio/downloader/utils/MemoryManager;-><init>(Landroid/content/Context;)V

    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    .line 121
    iget-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {v4}, Lcom/aio/downloader/utils/MemoryManager;->getSecondSDTotalSize()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->sencondsd:J

    .line 122
    iget-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {v4}, Lcom/aio/downloader/utils/MemoryManager;->getSDTotalSize()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->firstsd:J

    .line 123
    const v4, 0x7f0702fe

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    const v4, 0x7f070308

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 125
    const v4, 0x7f070309

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 127
    const v4, 0x7f07030a

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    const v4, 0x7f07030b

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 129
    const v4, 0x7f07030c

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    const v4, 0x7f07030d

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    const v4, 0x7f07030e

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    const v4, 0x7f07030f

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 134
    const v4, 0x7f070300

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->iv_manager_download:Landroid/widget/ImageView;

    .line 135
    const v4, 0x7f070302

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/DownloadAppManager;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->iv_manager_update:Landroid/widget/ImageView;

    .line 137
    invoke-virtual {v2, p0}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 138
    invoke-virtual {v3, p0}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 139
    invoke-virtual {v1, p0}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    new-instance v4, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 143
    iget-object v6, p0, Lcom/aio/downloader/activity/DownloadAppManager;->iv_manager_download:Landroid/widget/ImageView;

    invoke-direct {v4, v5, v6}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 142
    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_downlaod:Lcom/aio/downloader/views/BadgeView;

    .line 144
    new-instance v4, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 145
    iget-object v6, p0, Lcom/aio/downloader/activity/DownloadAppManager;->iv_manager_update:Landroid/widget/ImageView;

    invoke-direct {v4, v5, v6}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 144
    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_update:Lcom/aio/downloader/views/BadgeView;

    .line 147
    new-instance v4, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 148
    const-string v6, "340186902832477_436045399913293"

    invoke-direct {v4, v5, v6}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 147
    iput-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 149
    iget-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v4, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 150
    iget-object v4, p0, Lcom/aio/downloader/activity/DownloadAppManager;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v5, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v4, v5}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 152
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 594
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 543
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 544
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 545
    return-void
.end method

.method public onResume()V
    .locals 8

    .prologue
    .line 508
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 509
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 512
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/DownloadAppManager;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 513
    const-string v2, "download2.db"

    .line 512
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/DownloadAppManager;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 513
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 512
    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 514
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 515
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 514
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 520
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->ds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v6

    .line 521
    .local v6, "number":I
    if-eqz v6, :cond_2

    .line 523
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_downlaod:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 524
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_downlaod:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 530
    :cond_0
    :goto_1
    invoke-static {}, Lcom/aio/downloader/utils/Updatesize;->getUpdatesize()Lcom/aio/downloader/utils/Updatesize;

    move-result-object v0

    iget-object v0, v0, Lcom/aio/downloader/utils/Updatesize;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v7

    .line 531
    .local v7, "updatesize":I
    if-eqz v7, :cond_3

    .line 533
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_update:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 534
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_update:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 538
    :cond_1
    :goto_2
    return-void

    .line 525
    .end local v7    # "updatesize":I
    :cond_2
    if-nez v6, :cond_0

    .line 527
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_downlaod:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 535
    .restart local v7    # "updatesize":I
    :cond_3
    if-nez v7, :cond_1

    .line 536
    iget-object v0, p0, Lcom/aio/downloader/activity/DownloadAppManager;->badgedownimg_update:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_2

    .line 516
    .end local v6    # "number":I
    .end local v7    # "updatesize":I
    :catch_0
    move-exception v0

    goto :goto_0
.end method
