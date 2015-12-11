.class public Lcom/aio/downloader/service/ServiceCleaner;
.super Landroid/app/Service;
.source "ServiceCleaner.java"


# instance fields
.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private biaoshi:Z

.field private mRandom:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 46
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 47
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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR_FOME:Ljava/io/File;

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

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR_TO:Ljava/io/File;

    .line 50
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 51
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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR:Ljava/io/File;

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

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERDOWN:Ljava/io/File;

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

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;

    .line 62
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 63
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 64
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 65
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCRUSHSWF:Ljava/io/File;

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

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCRUSHAPK:Ljava/io/File;

    .line 71
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I

    .line 73
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->biaoshi:Z

    .line 44
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceCleaner;I)V
    .locals 0

    .prologue
    .line 71
    iput p1, p0, Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceCleaner;)I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I

    return v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/service/ServiceCleaner;)Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->biaoshi:Z

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ServiceCleaner;Z)V
    .locals 0

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/aio/downloader/service/ServiceCleaner;->biaoshi:Z

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/service/ServiceCleaner;)Ljava/io/File;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner;->AIOCRUSHSWF:Ljava/io/File;

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
    .line 640
    const-wide/16 v1, 0x0

    .line 641
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 642
    const/4 v0, 0x0

    .line 643
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 644
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 648
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 646
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 629
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 77
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 80
    const-string v2, "countName_first"

    .line 79
    invoke-virtual {p0, v2, v3}, Lcom/aio/downloader/service/ServiceCleaner;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 81
    .local v1, "userInfo_cishu":Landroid/content/SharedPreferences;
    const-string v2, "first"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 82
    .local v0, "cichu":I
    const-string v2, "zxcv"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "cichu="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-int/lit8 v4, v0, 0x2

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 83
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->Getneitui(Landroid/content/Context;)J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    rem-int/lit8 v2, v0, 0x2

    if-nez v2, :cond_0

    .line 84
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/aio/downloader/service/ServiceCleaner$1;

    invoke-direct {v3, p0}, Lcom/aio/downloader/service/ServiceCleaner$1;-><init>(Lcom/aio/downloader/service/ServiceCleaner;)V

    .line 621
    const-wide/32 v4, 0x2bf20

    .line 84
    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 625
    :cond_0
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 635
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 636
    return-void
.end method
