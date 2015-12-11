.class public Lcom/aio/downloader/jpush/MyReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MyReceiver.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "JPush"


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private AIOGALLERY:Ljava/io/File;

.field private AIOGALLERYAPK:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 36
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 37
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

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR_FOME:Ljava/io/File;

    .line 38
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 39
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

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR_TO:Ljava/io/File;

    .line 40
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 41
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

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR:Ljava/io/File;

    .line 44
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 45
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 46
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 47
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCALLERDOWN:Ljava/io/File;

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

    .line 50
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 51
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCALLERAPK:Ljava/io/File;

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

    const-string v2, "gallery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOGALLERY:Ljava/io/File;

    .line 58
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 59
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 60
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 61
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOGALLERYAPK:Ljava/io/File;

    .line 63
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 64
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 65
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 66
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOBATTERY:Ljava/io/File;

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

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOBATTERYAPK:Ljava/io/File;

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

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCRUSHSWF:Ljava/io/File;

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

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCRUSHAPK:Ljava/io/File;

    .line 33
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/jpush/MyReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/jpush/MyReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/jpush/MyReceiver;)Ljava/io/File;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/jpush/MyReceiver;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method private static printBundle(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 5
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 428
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 429
    .local v1, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 436
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 429
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 430
    .local v0, "key":Ljava/lang/String;
    sget-object v3, Lcn/jpush/android/api/JPushInterface;->EXTRA_NOTIFICATION_ID:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 431
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\nkey:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", value:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 433
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\nkey:"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", value:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method private processCustomMessage(Landroid/content/Context;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 441
    sget-boolean v3, Lcom/aio/downloader/jpush/JpushMainActivity;->isForeground:Z

    if-eqz v3, :cond_0

    .line 442
    sget-object v3, Lcn/jpush/android/api/JPushInterface;->EXTRA_MESSAGE:Ljava/lang/String;

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 443
    .local v1, "message":Ljava/lang/String;
    sget-object v3, Lcn/jpush/android/api/JPushInterface;->EXTRA_EXTRA:Ljava/lang/String;

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 444
    .local v0, "extras":Ljava/lang/String;
    new-instance v2, Landroid/content/Intent;

    .line 445
    const-string v3, "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION"

    .line 444
    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 446
    .local v2, "msgIntent":Landroid/content/Intent;
    const-string v3, "message"

    invoke-virtual {v2, v3, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 448
    invoke-virtual {p1, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 450
    .end local v0    # "extras":Ljava/lang/String;
    .end local v1    # "message":Ljava/lang/String;
    .end local v2    # "msgIntent":Landroid/content/Intent;
    :cond_0
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
    .line 454
    const-wide/16 v1, 0x0

    .line 455
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 456
    const/4 v0, 0x0

    .line 457
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 458
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 462
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 460
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 27
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 83
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 84
    .local v4, "bundle":Landroid/os/Bundle;
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    .line 86
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->ACTION_REGISTRATION_ID:Ljava/lang/String;

    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_1

    .line 88
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->EXTRA_REGISTRATION_ID:Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 90
    .local v18, "regId":Ljava/lang/String;
    const-string v23, "registration"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "[MyReceiver] \u63a5\u6536Registration Id : "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 424
    .end local v18    # "regId":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 100
    :cond_1
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->ACTION_MESSAGE_RECEIVED:Ljava/lang/String;

    .line 101
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v24

    .line 100
    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    .line 101
    if-eqz v23, :cond_2

    .line 102
    const-string v23, "JPush"

    .line 103
    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "[MyReceiver] \u63a5\u6536\u5230\u63a8\u9001\u4e0b\u6765\u7684\u81ea\u5b9a\u4e49\u6d88\u606f: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 104
    sget-object v25, Lcn/jpush/android/api/JPushInterface;->EXTRA_MESSAGE:Ljava/lang/String;

    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    .line 103
    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 102
    invoke-static/range {v23 .. v24}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v4}, Lcom/aio/downloader/jpush/MyReceiver;->processCustomMessage(Landroid/content/Context;Landroid/os/Bundle;)V

    goto :goto_0

    .line 107
    :cond_2
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->ACTION_NOTIFICATION_RECEIVED:Ljava/lang/String;

    .line 108
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v24

    .line 107
    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    .line 108
    if-eqz v23, :cond_3

    .line 109
    const-string v23, "JPush"

    const-string v24, "[MyReceiver] \u63a5\u6536\u5230\u63a8\u9001\u4e0b\u6765\u7684\u901a\u77e5"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->EXTRA_NOTIFICATION_ID:Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v13

    .line 112
    .local v13, "notifactionId":I
    const-string v23, "JPush"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "[MyReceiver] \u63a5\u6536\u5230\u63a8\u9001\u4e0b\u6765\u7684\u901a\u77e5\u7684ID: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 114
    .end local v13    # "notifactionId":I
    :cond_3
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->ACTION_NOTIFICATION_OPENED:Ljava/lang/String;

    .line 115
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v24

    .line 114
    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    .line 115
    if-eqz v23, :cond_15

    .line 116
    const-string v23, "JPush"

    const-string v24, "[MyReceiver] \u7528\u6237\u70b9\u51fb\u6253\u5f00\u4e86\u901a\u77e5"

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->EXTRA_MSG_ID:Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 118
    move-object/from16 v0, p1

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Lcn/jpush/android/api/JPushInterface;->reportNotificationOpened(Landroid/content/Context;Ljava/lang/String;)V

    .line 124
    :try_start_0
    new-instance v14, Lorg/json/JSONObject;

    .line 125
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->EXTRA_EXTRA:Ljava/lang/String;

    move-object/from16 v0, v23

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 124
    move-object/from16 v0, v23

    invoke-direct {v14, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 126
    .local v14, "object":Lorg/json/JSONObject;
    const-string v23, "key"

    move-object/from16 v0, v23

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v23

    if-eqz v23, :cond_4

    .line 127
    new-instance v21, Landroid/content/Intent;

    const-class v23, Lcom/aio/downloader/start/MainActivity;

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 128
    .local v21, "tihome":Landroid/content/Intent;
    const/high16 v23, 0x10000000

    move-object/from16 v0, v21

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 129
    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 131
    .end local v21    # "tihome":Landroid/content/Intent;
    :cond_4
    const-string v23, "key"

    move-object/from16 v0, v23

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 132
    .local v16, "object2string":Ljava/lang/String;
    new-instance v15, Lorg/json/JSONObject;

    invoke-direct/range {v15 .. v16}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 134
    .local v15, "object2":Lorg/json/JSONObject;
    const-string v23, "type"

    move-object/from16 v0, v23

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    const-string v24, "base"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 136
    const-string v23, "page"

    move-object/from16 v0, v23

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 137
    .local v19, "str":Ljava/lang/String;
    const-string v23, "home"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_5

    .line 138
    new-instance v6, Landroid/content/Intent;

    const-class v23, Lcom/aio/downloader/start/MainActivity;

    move-object/from16 v0, p1

    move-object/from16 v1, v23

    invoke-direct {v6, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    .local v6, "i":Landroid/content/Intent;
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v6, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 140
    const-string v23, "jpush"

    const-string v24, "jpushfan"

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-virtual {v6, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 141
    move-object/from16 v0, p1

    invoke-virtual {v0, v6}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 408
    .end local v6    # "i":Landroid/content/Intent;
    .end local v14    # "object":Lorg/json/JSONObject;
    .end local v15    # "object2":Lorg/json/JSONObject;
    .end local v16    # "object2string":Ljava/lang/String;
    .end local v19    # "str":Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 410
    .local v5, "e":Lorg/json/JSONException;
    invoke-virtual {v5}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0

    .line 142
    .end local v5    # "e":Lorg/json/JSONException;
    .restart local v14    # "object":Lorg/json/JSONObject;
    .restart local v15    # "object2":Lorg/json/JSONObject;
    .restart local v16    # "object2string":Ljava/lang/String;
    .restart local v19    # "str":Ljava/lang/String;
    :cond_5
    :try_start_1
    const-string v23, "recommendid"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_11

    .line 143
    const-string v23, "id"

    move-object/from16 v0, v23

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 144
    .local v7, "id":Ljava/lang/String;
    new-instance v20, Landroid/content/Intent;

    invoke-direct/range {v20 .. v20}, Landroid/content/Intent;-><init>()V

    .line 145
    .local v20, "ti":Landroid/content/Intent;
    const-string v23, "myid"

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 146
    const-string v23, "linkurl"

    const-string v24, ""

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    const-string v23, "myjpush"

    const/16 v24, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 150
    const-string v23, "com.evzapp.cleanmaster"

    move-object/from16 v0, v23

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v23

    if-eqz v23, :cond_8

    .line 151
    const/16 v17, 0x0

    .line 153
    .local v17, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v23

    .line 155
    const-string v24, "com.evzapp.cleanmaster"

    const/16 v25, 0x0

    .line 154
    invoke-virtual/range {v23 .. v25}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v17

    .line 159
    :goto_1
    if-nez v17, :cond_7

    .line 160
    :try_start_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR_FOME:Ljava/io/File;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->exists()Z

    move-result v23

    if-eqz v23, :cond_6

    .line 161
    new-instance v3, Landroid/content/Intent;

    const-string v23, "android.intent.action.VIEW"

    move-object/from16 v0, v23

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 163
    .local v3, "aa":Landroid/content/Intent;
    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "file://"

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR:Ljava/io/File;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 164
    sget-object v24, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 165
    const-string v24, "cleaner.apk"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 163
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v23

    .line 166
    const-string v24, "application/vnd.android.package-archive"

    .line 162
    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 167
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v3, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 168
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 156
    .end local v3    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v5

    .line 157
    .local v5, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 169
    .end local v5    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->PRO_DIR_TO:Ljava/io/File;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->exists()Z

    move-result v23

    if-eqz v23, :cond_0

    .line 170
    new-instance v23, Lcom/aio/downloader/jpush/MyReceiver$1;

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver$1;-><init>(Lcom/aio/downloader/jpush/MyReceiver;)V

    const/16 v24, 0x0

    move/from16 v0, v24

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v24, v0

    .line 196
    invoke-virtual/range {v23 .. v24}, Lcom/aio/downloader/jpush/MyReceiver$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 199
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    .line 200
    invoke-virtual/range {v23 .. v23}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v23

    .line 202
    const-string v24, "com.evzapp.cleanmaster"

    .line 201
    invoke-virtual/range {v23 .. v24}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v11

    .line 204
    .local v11, "intent_cleaner":Landroid/content/Intent;
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v11, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 205
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v11}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 207
    .end local v11    # "intent_cleaner":Landroid/content/Intent;
    .end local v17    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_8
    const-string v23, "com.allinone.callerid"

    move-object/from16 v0, v23

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    move-result v23

    if-eqz v23, :cond_a

    .line 209
    :try_start_4
    const-string v23, "myjpush"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "getFileSizes(AIOCALLERAPK)="

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 210
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    invoke-virtual/range {v24 .. v26}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 209
    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 211
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->exists()Z

    move-result v23

    if-eqz v23, :cond_9

    .line 212
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v23

    const-wide/32 v25, 0x4e87bd

    cmp-long v23, v23, v25

    if-ltz v23, :cond_9

    .line 213
    new-instance v10, Landroid/content/Intent;

    .line 214
    const-string v23, "android.intent.action.VIEW"

    .line 213
    move-object/from16 v0, v23

    invoke-direct {v10, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 217
    .local v10, "intent_caller":Landroid/content/Intent;
    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "file://"

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 218
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCALLERAPK:Ljava/io/File;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 217
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v23

    .line 219
    const-string v24, "application/vnd.android.package-archive"

    .line 216
    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-virtual {v10, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 221
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v10, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 222
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v10}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_0

    goto/16 :goto_0

    .line 260
    .end local v10    # "intent_caller":Landroid/content/Intent;
    :catch_2
    move-exception v5

    .line 262
    .local v5, "e":Ljava/lang/Exception;
    :try_start_5
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_0

    .line 256
    .end local v5    # "e":Ljava/lang/Exception;
    :cond_9
    :try_start_6
    const-class v23, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 255
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 257
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 258
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_0

    goto/16 :goto_0

    .line 264
    :cond_a
    :try_start_7
    const-string v23, "com.androidapp.gallary3d"

    move-object/from16 v0, v23

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_7
    .catch Lorg/json/JSONException; {:try_start_7 .. :try_end_7} :catch_0

    move-result v23

    if-eqz v23, :cond_c

    .line 266
    :try_start_8
    const-string v23, "myjpush"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "getFileSizes(AIOGALLERYAPK)="

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 267
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOGALLERYAPK:Ljava/io/File;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v25

    invoke-virtual/range {v24 .. v26}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 266
    invoke-static/range {v23 .. v24}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 268
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOGALLERYAPK:Ljava/io/File;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->exists()Z

    move-result v23

    if-eqz v23, :cond_b

    .line 269
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOGALLERYAPK:Ljava/io/File;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v23

    const-wide/32 v25, 0x1bff04

    cmp-long v23, v23, v25

    if-ltz v23, :cond_b

    .line 270
    new-instance v12, Landroid/content/Intent;

    .line 271
    const-string v23, "android.intent.action.VIEW"

    .line 270
    move-object/from16 v0, v23

    invoke-direct {v12, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 274
    .local v12, "intent_gallery":Landroid/content/Intent;
    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "file://"

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 275
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOGALLERYAPK:Ljava/io/File;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 274
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v23

    .line 276
    const-string v24, "application/vnd.android.package-archive"

    .line 273
    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-virtual {v12, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 278
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v12, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 279
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v12}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_3
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_0

    goto/16 :goto_0

    .line 312
    .end local v12    # "intent_gallery":Landroid/content/Intent;
    :catch_3
    move-exception v5

    .line 314
    .restart local v5    # "e":Ljava/lang/Exception;
    :try_start_9
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_0

    goto/16 :goto_0

    .line 308
    .end local v5    # "e":Ljava/lang/Exception;
    :cond_b
    :try_start_a
    const-class v23, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 307
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 309
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 310
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_3
    .catch Lorg/json/JSONException; {:try_start_a .. :try_end_a} :catch_0

    goto/16 :goto_0

    .line 316
    :cond_c
    :try_start_b
    const-string v23, "com.aioapp.battery"

    move-object/from16 v0, v23

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_b
    .catch Lorg/json/JSONException; {:try_start_b .. :try_end_b} :catch_0

    move-result v23

    if-eqz v23, :cond_e

    .line 318
    :try_start_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOBATTERYAPK:Ljava/io/File;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->exists()Z

    move-result v23

    if-eqz v23, :cond_d

    .line 319
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOBATTERYAPK:Ljava/io/File;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v23

    const-wide/32 v25, 0x377eff

    cmp-long v23, v23, v25

    if-ltz v23, :cond_d

    .line 320
    new-instance v9, Landroid/content/Intent;

    .line 321
    const-string v23, "android.intent.action.VIEW"

    .line 320
    move-object/from16 v0, v23

    invoke-direct {v9, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 324
    .local v9, "intent_battery":Landroid/content/Intent;
    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "file://"

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 325
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOBATTERYAPK:Ljava/io/File;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 324
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v23

    .line 326
    const-string v24, "application/vnd.android.package-archive"

    .line 323
    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-virtual {v9, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 328
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v9, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 329
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v9}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_4
    .catch Lorg/json/JSONException; {:try_start_c .. :try_end_c} :catch_0

    goto/16 :goto_0

    .line 336
    .end local v9    # "intent_battery":Landroid/content/Intent;
    :catch_4
    move-exception v5

    .line 338
    .restart local v5    # "e":Ljava/lang/Exception;
    :try_start_d
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_d
    .catch Lorg/json/JSONException; {:try_start_d .. :try_end_d} :catch_0

    goto/16 :goto_0

    .line 332
    .end local v5    # "e":Ljava/lang/Exception;
    :cond_d
    :try_start_e
    const-class v23, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 331
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 333
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 334
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_4
    .catch Lorg/json/JSONException; {:try_start_e .. :try_end_e} :catch_0

    goto/16 :goto_0

    .line 340
    :cond_e
    :try_start_f
    const-string v23, "com.freepezzle.hexcrush"

    move-object/from16 v0, v23

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_f
    .catch Lorg/json/JSONException; {:try_start_f .. :try_end_f} :catch_0

    move-result v23

    if-eqz v23, :cond_10

    .line 342
    :try_start_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/io/File;->exists()Z

    move-result v23

    if-eqz v23, :cond_f

    .line 343
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/aio/downloader/jpush/MyReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v23

    const-wide/32 v25, 0x19edc6

    cmp-long v23, v23, v25

    if-ltz v23, :cond_f

    .line 344
    new-instance v9, Landroid/content/Intent;

    .line 345
    const-string v23, "android.intent.action.VIEW"

    .line 344
    move-object/from16 v0, v23

    invoke-direct {v9, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 348
    .restart local v9    # "intent_battery":Landroid/content/Intent;
    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "file://"

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 349
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 348
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v23

    .line 350
    const-string v24, "application/vnd.android.package-archive"

    .line 347
    move-object/from16 v0, v23

    move-object/from16 v1, v24

    invoke-virtual {v9, v0, v1}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 352
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v9, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 353
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/jpush/MyReceiver;->mContext:Landroid/content/Context;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    invoke-virtual {v0, v9}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_5
    .catch Lorg/json/JSONException; {:try_start_10 .. :try_end_10} :catch_0

    goto/16 :goto_0

    .line 360
    .end local v9    # "intent_battery":Landroid/content/Intent;
    :catch_5
    move-exception v5

    .line 362
    .restart local v5    # "e":Ljava/lang/Exception;
    :try_start_11
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_11
    .catch Lorg/json/JSONException; {:try_start_11 .. :try_end_11} :catch_0

    goto/16 :goto_0

    .line 356
    .end local v5    # "e":Ljava/lang/Exception;
    :cond_f
    :try_start_12
    const-class v23, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 355
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 357
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 358
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_12 .. :try_end_12} :catch_5
    .catch Lorg/json/JSONException; {:try_start_12 .. :try_end_12} :catch_0

    goto/16 :goto_0

    .line 366
    :cond_10
    :try_start_13
    const-class v23, Lcom/aio/downloader/activity/AppDetailsActivity;

    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 367
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 368
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 371
    .end local v7    # "id":Ljava/lang/String;
    .end local v20    # "ti":Landroid/content/Intent;
    :cond_11
    const-string v23, "todaypickid"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_12

    .line 372
    const-string v23, "todayid"

    move-object/from16 v0, v23

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 373
    .restart local v7    # "id":Ljava/lang/String;
    new-instance v20, Landroid/content/Intent;

    invoke-direct/range {v20 .. v20}, Landroid/content/Intent;-><init>()V

    .line 374
    .restart local v20    # "ti":Landroid/content/Intent;
    const-string v23, "todayid"

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 375
    const-string v23, "myjpush"

    const/16 v24, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 378
    const-class v23, Lcom/aio/downloader/activity/TodaysPickActivity;

    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 382
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 383
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 384
    .end local v7    # "id":Ljava/lang/String;
    .end local v20    # "ti":Landroid/content/Intent;
    :cond_12
    const-string v23, "googleid"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_13

    .line 385
    const-string v23, "google_id"

    move-object/from16 v0, v23

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 387
    .restart local v7    # "id":Ljava/lang/String;
    new-instance v23, Ljava/lang/StringBuilder;

    const-string v24, "https://play.google.com/store/apps/details?id="

    invoke-direct/range {v23 .. v24}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 388
    move-object/from16 v0, v23

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    .line 387
    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-static/range {v23 .. v23}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v22

    .line 389
    .local v22, "uri":Landroid/net/Uri;
    new-instance v20, Landroid/content/Intent;

    const-string v23, "android.intent.action.VIEW"

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 390
    .restart local v20    # "ti":Landroid/content/Intent;
    const/high16 v23, 0x10000000

    move-object/from16 v0, v20

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 391
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 393
    .end local v7    # "id":Ljava/lang/String;
    .end local v20    # "ti":Landroid/content/Intent;
    .end local v22    # "uri":Landroid/net/Uri;
    :cond_13
    const-string v23, "fun"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_14

    .line 394
    new-instance v6, Landroid/content/Intent;

    const-class v23, Lcom/aio/downloader/activity/FunActivity1;

    move-object/from16 v0, p1

    move-object/from16 v1, v23

    invoke-direct {v6, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 395
    .restart local v6    # "i":Landroid/content/Intent;
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v6, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 396
    move-object/from16 v0, p1

    invoke-virtual {v0, v6}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 397
    .end local v6    # "i":Landroid/content/Intent;
    :cond_14
    const-string v23, "search"

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 398
    const-string v23, "searchid"

    move-object/from16 v0, v23

    invoke-virtual {v15, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 399
    .restart local v7    # "id":Ljava/lang/String;
    new-instance v8, Landroid/content/Intent;

    .line 400
    const-class v23, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    .line 399
    move-object/from16 v0, p1

    move-object/from16 v1, v23

    invoke-direct {v8, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 401
    .local v8, "intent2":Landroid/content/Intent;
    const-string v23, "searchid"

    move-object/from16 v0, v23

    invoke-virtual {v8, v0, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 402
    const-string v23, "searchint"

    const/16 v24, 0x1

    move-object/from16 v0, v23

    move/from16 v1, v24

    invoke-virtual {v8, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 403
    const/high16 v23, 0x10000000

    move/from16 v0, v23

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 404
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_13
    .catch Lorg/json/JSONException; {:try_start_13 .. :try_end_13} :catch_0

    goto/16 :goto_0

    .line 413
    .end local v7    # "id":Ljava/lang/String;
    .end local v8    # "intent2":Landroid/content/Intent;
    .end local v14    # "object":Lorg/json/JSONObject;
    .end local v15    # "object2":Lorg/json/JSONObject;
    .end local v16    # "object2string":Ljava/lang/String;
    .end local v19    # "str":Ljava/lang/String;
    :cond_15
    sget-object v23, Lcn/jpush/android/api/JPushInterface;->ACTION_RICHPUSH_CALLBACK:Ljava/lang/String;

    .line 414
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v24

    .line 413
    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    .line 414
    if-eqz v23, :cond_16

    .line 415
    const-string v23, "JPush"

    .line 416
    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "[MyReceiver] \u7528\u6237\u6536\u5230\u5230RICH PUSH CALLBACK: "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 417
    sget-object v25, Lcn/jpush/android/api/JPushInterface;->EXTRA_EXTRA:Ljava/lang/String;

    move-object/from16 v0, v25

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    .line 416
    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 415
    invoke-static/range {v23 .. v24}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 422
    :cond_16
    const-string v23, "JPush"

    new-instance v24, Ljava/lang/StringBuilder;

    const-string v25, "[MyReceiver] Unhandled intent - "

    invoke-direct/range {v24 .. v25}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method
