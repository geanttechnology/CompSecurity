.class public Lcom/aio/downloader/start/MainActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "MainActivity.java"


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private AIOFREE:Ljava/io/File;

.field private AIOFREEAPK:Ljava/io/File;

.field private AIOGALLERY:Ljava/io/File;

.field private AIOGALLERYAPK:Ljava/io/File;

.field private AIOSWFFILE:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private animation:Landroid/view/animation/Animation;

.field private bitmap:Landroid/graphics/Bitmap;

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

.field private h:I

.field private i:I

.field private id:Ljava/lang/String;

.field private ll_start:Landroid/widget/LinearLayout;

.field private loginimg:Landroid/widget/ImageView;

.field private out:Ljava/io/PrintWriter;

.field private tv_aio:Landroid/widget/TextView;

.field private w:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 53
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 54
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 55
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 56
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

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

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 62
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 63
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

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    .line 64
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 65
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 66
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 67
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "freestore.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;

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

    .line 71
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 72
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

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

    const-string v2, "gallery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    .line 78
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 79
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 80
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 81
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

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

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

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

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

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

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 96
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/start/MainActivity;->i:I

    .line 98
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 99
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    .line 744
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 745
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

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR:Ljava/io/File;

    .line 746
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 747
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

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 748
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 749
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

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 43
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 746
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 748
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 753
    invoke-direct {p0}, Lcom/aio/downloader/start/MainActivity;->getAssetFile()Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 777
    invoke-direct {p0}, Lcom/aio/downloader/start/MainActivity;->getAssetFile_swf()Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    return-object v0
.end method

.method private getAssetFile()Ljava/io/File;
    .locals 10

    .prologue
    .line 754
    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 755
    .local v0, "asset":Landroid/content/res/AssetManager;
    const/4 v3, 0x0

    .line 757
    .local v3, "f":Ljava/io/File;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 758
    const-string v8, "cleaner.apk"

    invoke-virtual {v0, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v6

    .line 759
    .local v6, "is":Ljava/io/InputStream;
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR:Ljava/io/File;

    const-string v9, "cleaner.apk"

    invoke-direct {v4, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 760
    .end local v3    # "f":Ljava/io/File;
    .local v4, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 761
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 762
    .local v5, "fOut":Ljava/io/FileOutputStream;
    const/16 v8, 0x400

    new-array v1, v8, [B

    .line 763
    .local v1, "buffer":[B
    const/4 v7, 0x0

    .line 764
    .local v7, "len":I
    :goto_0
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_0

    .line 767
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->flush()V

    .line 768
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 769
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    move-object v3, v4

    .line 774
    .end local v1    # "buffer":[B
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "len":I
    .restart local v3    # "f":Ljava/io/File;
    :goto_1
    return-object v4

    .line 765
    .end local v3    # "f":Ljava/io/File;
    .restart local v1    # "buffer":[B
    .restart local v4    # "f":Ljava/io/File;
    .restart local v5    # "fOut":Ljava/io/FileOutputStream;
    .restart local v6    # "is":Ljava/io/InputStream;
    .restart local v7    # "len":I
    :cond_0
    const/4 v8, 0x0

    invoke-virtual {v5, v1, v8, v7}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 771
    .end local v1    # "buffer":[B
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v7    # "len":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 772
    .end local v4    # "f":Ljava/io/File;
    .end local v6    # "is":Ljava/io/InputStream;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "f":Ljava/io/File;
    :goto_2
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 774
    const/4 v4, 0x0

    goto :goto_1

    .line 771
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private getAssetFile_swf()Ljava/io/File;
    .locals 10

    .prologue
    .line 778
    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 779
    .local v0, "asset":Landroid/content/res/AssetManager;
    const/4 v3, 0x0

    .line 781
    .local v3, "f":Ljava/io/File;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 782
    const-string v8, "cleaner.apk"

    invoke-virtual {v0, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v6

    .line 783
    .local v6, "is":Ljava/io/InputStream;
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/aio/downloader/start/MainActivity;->PRO_DIR:Ljava/io/File;

    const-string v9, "cleaner.swf"

    invoke-direct {v4, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 784
    .end local v3    # "f":Ljava/io/File;
    .local v4, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 785
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 786
    .local v5, "fOut":Ljava/io/FileOutputStream;
    const/16 v8, 0x400

    new-array v1, v8, [B

    .line 787
    .local v1, "buffer":[B
    const/4 v7, 0x0

    .line 788
    .local v7, "len":I
    :goto_0
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_0

    .line 791
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->flush()V

    .line 792
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 793
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    move-object v3, v4

    .line 798
    .end local v1    # "buffer":[B
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "len":I
    .restart local v3    # "f":Ljava/io/File;
    :goto_1
    return-object v4

    .line 789
    .end local v3    # "f":Ljava/io/File;
    .restart local v1    # "buffer":[B
    .restart local v4    # "f":Ljava/io/File;
    .restart local v5    # "fOut":Ljava/io/FileOutputStream;
    .restart local v6    # "is":Ljava/io/InputStream;
    .restart local v7    # "len":I
    :cond_0
    const/4 v8, 0x0

    invoke-virtual {v5, v1, v8, v7}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 795
    .end local v1    # "buffer":[B
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v7    # "len":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 796
    .end local v4    # "f":Ljava/io/File;
    .end local v6    # "is":Ljava/io/InputStream;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "f":Ljava/io/File;
    :goto_2
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 798
    const/4 v4, 0x0

    goto :goto_1

    .line 795
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_2
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
    .line 803
    const-wide/16 v1, 0x0

    .line 804
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 805
    const/4 v0, 0x0

    .line 806
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 807
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 811
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 809
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 594
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 597
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 598
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 597
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 604
    :goto_0
    return-void

    .line 599
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 104
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 105
    invoke-virtual {p0, p0}, Lcom/aio/downloader/start/MainActivity;->setmContext(Landroid/content/Context;)V

    .line 106
    const v0, 0x7f03006e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->setContentView(I)V

    .line 107
    const-string v0, "gak"

    const-string v1, "onCreate"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 109
    const/4 v0, 0x0

    sput-boolean v0, Lcom/aio/downloader/utils/Myutils;->iswidget2:Z

    .line 112
    new-instance v0, Lcom/aio/downloader/start/MainActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$1;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 146
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 148
    const v0, 0x7f070292

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->ll_start:Landroid/widget/LinearLayout;

    .line 149
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->ll_start:Landroid/widget/LinearLayout;

    const v1, 0x7f02000e

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 150
    const v0, 0x7f070294

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->tv_aio:Landroid/widget/TextView;

    .line 152
    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->initView()V

    .line 154
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    .line 155
    const-string v2, "download2.db"

    .line 154
    invoke-virtual {p0, v2}, Lcom/aio/downloader/start/MainActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 155
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 154
    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 156
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 157
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 156
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->ds:Ljava/util/List;

    .line 158
    const v0, 0x7f070293

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/start/MainActivity;->loginimg:Landroid/widget/ImageView;

    .line 161
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 162
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x677f5b

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x291a8b

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    .line 164
    :cond_0
    new-instance v8, Ljava/io/File;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 165
    const-string v1, "battery.swf"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 164
    invoke-direct {v8, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 166
    .local v8, "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 167
    const-string v0, "jone"

    const-string v1, "2693771battery6782811"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 171
    .end local v8    # "file":Ljava/io/File;
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 172
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x677f5b

    cmp-long v0, v0, v2

    if-eqz v0, :cond_2

    .line 173
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x291a8b

    cmp-long v0, v0, v2

    if-nez v0, :cond_3

    .line 174
    :cond_2
    new-instance v8, Ljava/io/File;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 175
    const-string v1, "battery.apk"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 174
    invoke-direct {v8, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 176
    .restart local v8    # "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 177
    const-string v0, "jone"

    const-string v1, "2693771battery6782811"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 188
    .end local v8    # "file":Ljava/io/File;
    :cond_3
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 189
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x19edc6

    cmp-long v0, v0, v2

    if-nez v0, :cond_4

    .line 190
    new-instance v8, Ljava/io/File;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 191
    const-string v1, "battery.swf"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 190
    invoke-direct {v8, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 192
    .restart local v8    # "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 193
    const-string v0, "jone"

    const-string v1, "delete crush swf"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    .end local v8    # "file":Ljava/io/File;
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 198
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x19edc6

    cmp-long v0, v0, v2

    if-nez v0, :cond_5

    .line 199
    new-instance v8, Ljava/io/File;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 200
    const-string v1, "battery.apk"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 199
    invoke-direct {v8, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 201
    .restart local v8    # "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 202
    const-string v0, "jone"

    const-string v1, "delete crush apk"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_12

    .line 210
    .end local v8    # "file":Ljava/io/File;
    :cond_5
    :goto_1
    :try_start_2
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 211
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x357458

    cmp-long v0, v0, v2

    if-eqz v0, :cond_6

    .line 212
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e5bb9

    cmp-long v0, v0, v2

    if-eqz v0, :cond_6

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e8608

    cmp-long v0, v0, v2

    if-nez v0, :cond_7

    .line 214
    :cond_6
    const-string v0, "gag"

    const-string v1, "cleanersize=go on swf"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 215
    new-instance v8, Ljava/io/File;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 216
    const-string v1, "caller.swf"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 215
    invoke-direct {v8, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 217
    .restart local v8    # "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 218
    const-string v0, "jone"

    const-string v1, "3503192cleaner5135289"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 222
    .end local v8    # "file":Ljava/io/File;
    :cond_7
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 223
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x357458

    cmp-long v0, v0, v2

    if-eqz v0, :cond_8

    .line 224
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e5bb9

    cmp-long v0, v0, v2

    if-eqz v0, :cond_8

    .line 225
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e8608

    cmp-long v0, v0, v2

    if-nez v0, :cond_9

    .line 226
    :cond_8
    const-string v0, "gag"

    const-string v1, "cleanersize=go on apk"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    new-instance v8, Ljava/io/File;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOSWFFILE:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 228
    const-string v1, "caller.apk"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 227
    invoke-direct {v8, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 229
    .restart local v8    # "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 230
    const-string v0, "jone"

    const-string v1, "3503192cleaner5135289"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_11

    .line 238
    .end local v8    # "file":Ljava/io/File;
    :cond_9
    :goto_2
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 241
    :try_start_3
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "aiobattery="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 242
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x377eff

    cmp-long v0, v0, v2

    if-gez v0, :cond_a

    .line 243
    new-instance v0, Lcom/aio/downloader/start/MainActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$2;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 260
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 267
    :cond_a
    :goto_3
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 270
    :try_start_4
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "aiobattery="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 271
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x377eff

    cmp-long v0, v0, v2

    if-gez v0, :cond_b

    .line 272
    new-instance v0, Lcom/aio/downloader/start/MainActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$3;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 289
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .line 297
    :cond_b
    :goto_4
    :try_start_5
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x377eff

    cmp-long v0, v0, v2

    if-ltz v0, :cond_c

    .line 298
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_c

    .line 299
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERY:Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOBATTERYAPK:Ljava/io/File;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    .line 307
    :cond_c
    :goto_5
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 309
    :try_start_6
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x40a6ca

    cmp-long v0, v0, v2

    if-gez v0, :cond_d

    .line 310
    new-instance v0, Lcom/aio/downloader/start/MainActivity$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$4;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 327
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    .line 334
    :cond_d
    :goto_6
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 336
    :try_start_7
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x40a6ca

    cmp-long v0, v0, v2

    if-gez v0, :cond_e

    .line 337
    new-instance v0, Lcom/aio/downloader/start/MainActivity$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$5;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 354
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_5

    .line 362
    :cond_e
    :goto_7
    :try_start_8
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x40a6ca

    cmp-long v0, v0, v2

    if-ltz v0, :cond_f

    .line 363
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_f

    .line 364
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREE:Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOFREEAPK:Ljava/io/File;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_6

    .line 373
    :cond_f
    :goto_8
    :try_start_9
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 374
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x2d0afc

    cmp-long v0, v0, v2

    if-nez v0, :cond_10

    .line 375
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 379
    :cond_10
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 380
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x2d0afc

    cmp-long v0, v0, v2

    if-nez v0, :cond_11

    .line 381
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_7

    .line 391
    :cond_11
    :goto_9
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 393
    :try_start_a
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x1bff04

    cmp-long v0, v0, v2

    if-gez v0, :cond_12

    .line 394
    new-instance v0, Lcom/aio/downloader/start/MainActivity$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$6;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 411
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$6;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_8

    .line 418
    :cond_12
    :goto_a
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 420
    :try_start_b
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x1bff04

    cmp-long v0, v0, v2

    if-gez v0, :cond_13

    .line 421
    new-instance v0, Lcom/aio/downloader/start/MainActivity$7;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$7;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 438
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$7;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_9

    .line 446
    :cond_13
    :goto_b
    :try_start_c
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_14

    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x1bff04

    cmp-long v0, v0, v2

    if-ltz v0, :cond_14

    .line 447
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_14

    .line 448
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERY:Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOGALLERYAPK:Ljava/io/File;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_a

    .line 457
    :cond_14
    :goto_c
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 459
    :try_start_d
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "aiocaller="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 460
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e8608

    cmp-long v0, v0, v2

    if-gez v0, :cond_15

    .line 461
    new-instance v0, Lcom/aio/downloader/start/MainActivity$8;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$8;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 478
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$8;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_b

    .line 485
    :cond_15
    :goto_d
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_16

    .line 487
    :try_start_e
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "aiocaller="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 488
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e8608

    cmp-long v0, v0, v2

    if-gez v0, :cond_16

    .line 489
    new-instance v0, Lcom/aio/downloader/start/MainActivity$9;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$9;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 506
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$9;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_c

    .line 514
    :cond_16
    :goto_e
    :try_start_f
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_17

    .line 515
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x4e8608

    cmp-long v0, v0, v2

    if-ltz v0, :cond_17

    .line 516
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_17

    .line 517
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERDOWN:Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOCALLERAPK:Ljava/io/File;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_f} :catch_d

    .line 525
    :cond_17
    :goto_f
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 527
    :try_start_10
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x19ee4c

    cmp-long v0, v0, v2

    if-gez v0, :cond_18

    .line 528
    new-instance v0, Lcom/aio/downloader/start/MainActivity$10;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$10;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 545
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$10;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_e

    .line 552
    :cond_18
    :goto_10
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_19

    .line 554
    :try_start_11
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "aiocrush="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v2}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 555
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x19ee4c

    cmp-long v0, v0, v2

    if-gez v0, :cond_19

    .line 556
    new-instance v0, Lcom/aio/downloader/start/MainActivity$11;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/MainActivity$11;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 573
    invoke-virtual {v0, v1}, Lcom/aio/downloader/start/MainActivity$11;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_11
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_11} :catch_f

    .line 581
    :cond_19
    :goto_11
    :try_start_12
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/start/MainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v0

    const-wide/32 v2, 0x19ee4c

    cmp-long v0, v0, v2

    if-ltz v0, :cond_1a

    .line 582
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_1a

    .line 583
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHSWF:Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/start/MainActivity;->AIOCRUSHAPK:Ljava/io/File;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_10

    .line 590
    :cond_1a
    :goto_12
    return-void

    .line 182
    :catch_0
    move-exception v7

    .line 184
    .local v7, "e1":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 262
    .end local v7    # "e1":Ljava/lang/Exception;
    :catch_1
    move-exception v6

    .line 264
    .local v6, "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_3

    .line 291
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v6

    .line 293
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_4

    .line 302
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v6

    .line 304
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_5

    .line 329
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v6

    .line 331
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_6

    .line 356
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_5
    move-exception v6

    .line 358
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_7

    .line 367
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v6

    .line 369
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_8

    .line 386
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_7
    move-exception v7

    .line 388
    .restart local v7    # "e1":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_9

    .line 413
    .end local v7    # "e1":Ljava/lang/Exception;
    :catch_8
    move-exception v6

    .line 415
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_a

    .line 440
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_9
    move-exception v6

    .line 442
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_b

    .line 451
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_a
    move-exception v6

    .line 453
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_c

    .line 480
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_b
    move-exception v6

    .line 482
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_d

    .line 508
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_c
    move-exception v6

    .line 510
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_e

    .line 520
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_d
    move-exception v6

    .line 522
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_f

    .line 547
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_e
    move-exception v6

    .line 549
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_10

    .line 575
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_f
    move-exception v6

    .line 577
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_11

    .line 586
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_10
    move-exception v6

    .line 588
    .restart local v6    # "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_12

    .line 234
    .end local v6    # "e":Ljava/lang/Exception;
    :catch_11
    move-exception v0

    goto/16 :goto_2

    .line 206
    :catch_12
    move-exception v0

    goto/16 :goto_1
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 740
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 741
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 742
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    .line 607
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 608
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 609
    const-string v3, "gak"

    const-string v4, "onResume"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 611
    :try_start_0
    invoke-static {}, Lcom/aio/downloader/utils/Updatesize;->getUpdatesize()Lcom/aio/downloader/utils/Updatesize;

    move-result-object v3

    iget-object v3, v3, Lcom/aio/downloader/utils/Updatesize;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 616
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 617
    .local v1, "intent_acquire":Landroid/content/Intent;
    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 618
    .local v0, "action":Ljava/lang/String;
    const-string v3, "gak"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "action="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 619
    const-string v3, "android.intent.action.VIEW"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 621
    invoke-virtual {v1}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v2

    .line 622
    .local v2, "url":Ljava/lang/String;
    const-string v3, "gak"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "url==========="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 624
    const-string v3, "aio"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 626
    new-instance v3, Lcom/aio/downloader/start/MainActivity$12;

    invoke-direct {v3, p0}, Lcom/aio/downloader/start/MainActivity$12;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    .line 707
    invoke-virtual {v3}, Lcom/aio/downloader/start/MainActivity$12;->start()V

    .line 710
    :cond_0
    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    if-eqz v2, :cond_1

    .line 711
    iget v3, p0, Lcom/aio/downloader/start/MainActivity;->i:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/aio/downloader/start/MainActivity;->i:I

    .line 712
    new-instance v1, Landroid/content/Intent;

    .end local v1    # "intent_acquire":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/aio/downloader/start/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 713
    const-class v4, Lcom/aio/downloader/activity/MyMainActivity;

    .line 712
    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 714
    .restart local v1    # "intent_acquire":Landroid/content/Intent;
    const-string v3, "acquire_url_start"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 715
    invoke-virtual {p0, v1}, Lcom/aio/downloader/start/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 719
    .end local v2    # "url":Ljava/lang/String;
    :cond_1
    iget v3, p0, Lcom/aio/downloader/start/MainActivity;->i:I

    if-nez v3, :cond_2

    .line 720
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    new-instance v4, Lcom/aio/downloader/start/MainActivity$13;

    invoke-direct {v4, p0}, Lcom/aio/downloader/start/MainActivity$13;-><init>(Lcom/aio/downloader/start/MainActivity;)V

    .line 732
    const-wide/16 v5, 0x1388

    .line 720
    invoke-virtual {v3, v4, v5, v6}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 735
    :cond_2
    return-void

    .line 612
    .end local v0    # "action":Ljava/lang/String;
    .end local v1    # "intent_acquire":Landroid/content/Intent;
    :catch_0
    move-exception v3

    goto/16 :goto_0
.end method
