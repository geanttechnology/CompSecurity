.class public Lcom/aio/downloader/service/ServiceGallery;
.super Landroid/app/Service;
.source "ServiceGallery.java"


# static fields
.field protected static final STATUS_BAR_COVER_CLICK_UPDATE:Ljava/lang/String; = "update"

.field protected static final STATUS_BAR_COVER_PAID:Ljava/lang/String; = "paid"

.field protected static final STATUS_BAR_COVER_PICK:Ljava/lang/String; = "pick"

.field protected static final STATUS_BAR_COVER_PICK_BIG:Ljava/lang/String; = "pick_big"

.field protected static final STATUS_BAR_DOWNLOAD_INSTALL:Ljava/lang/String; = "status_bar_download_install"

.field protected static final STATUS_BAR_DOWNLOAD_SUCCESS:Ljava/lang/String; = "status_bar_download_success"


# instance fields
.field private AIOGALLERY:Ljava/io/File;

.field private AIOGALLERYAPK:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

.field private gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;

.field private handler:Landroid/os/Handler;

.field itemsOnClick:Landroid/view/View$OnClickListener;

.field private itemsOnClick4:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 52
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 55
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 56
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 57
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 58
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "gallery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERY:Ljava/io/File;

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

    const-string v2, "gallery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERYAPK:Ljava/io/File;

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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR_FOME:Ljava/io/File;

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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR_TO:Ljava/io/File;

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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR:Ljava/io/File;

    .line 84
    new-instance v0, Lcom/aio/downloader/service/ServiceGallery$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ServiceGallery$1;-><init>(Lcom/aio/downloader/service/ServiceGallery;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->handler:Landroid/os/Handler;

    .line 52
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/InstallfirstDialog;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceGallery;)Lcom/aio/downloader/dialog/GralleryDialog;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->AIOGALLERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/service/ServiceGallery;)Ljava/io/File;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/service/ServiceGallery;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceGallery;->handler:Landroid/os/Handler;

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
    .line 403
    const-wide/16 v1, 0x0

    .line 404
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 405
    const/4 v0, 0x0

    .line 406
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 407
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 411
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 409
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 392
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 14

    .prologue
    const v13, 0x7f0c0010

    const/16 v12, 0x7d3

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 117
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 119
    new-instance v6, Lcom/aio/downloader/service/ServiceGallery$2;

    invoke-direct {v6, p0}, Lcom/aio/downloader/service/ServiceGallery$2;-><init>(Lcom/aio/downloader/service/ServiceGallery;)V

    iput-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 200
    new-instance v6, Lcom/aio/downloader/dialog/GralleryDialog;

    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    .line 201
    iget-object v8, p0, Lcom/aio/downloader/service/ServiceGallery;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-direct {v6, v7, v13, v8}, Lcom/aio/downloader/dialog/GralleryDialog;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 200
    iput-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;

    .line 202
    iget-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;

    invoke-virtual {v6, v11}, Lcom/aio/downloader/dialog/GralleryDialog;->setCanceledOnTouchOutside(Z)V

    .line 203
    iget-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->gralleryDialog:Lcom/aio/downloader/dialog/GralleryDialog;

    invoke-virtual {v6}, Lcom/aio/downloader/dialog/GralleryDialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v12}, Landroid/view/Window;->setType(I)V

    .line 205
    const/4 v3, 0x0

    .line 207
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceGallery;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 208
    const-string v7, "com.aioapp.gallery"

    const/4 v8, 0x0

    .line 207
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 212
    :goto_0
    const-string v6, "qwer"

    .line 213
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "time="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 215
    invoke-static {p0}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetGalleryClickTime(Landroid/content/Context;)J

    move-result-wide v8

    .line 214
    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 213
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 212
    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 217
    const-string v6, "countName_first"

    .line 216
    invoke-virtual {p0, v6, v10}, Lcom/aio/downloader/service/ServiceGallery;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 218
    .local v5, "userInfo_cishu":Landroid/content/SharedPreferences;
    const-string v6, "first"

    invoke-interface {v5, v6, v10}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 219
    .local v0, "cichu":I
    const-string v6, "zxcv"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "gallerycishu="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-int/lit8 v8, v0, 0x2

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 256
    const/4 v4, 0x0

    .line 258
    .local v4, "packageInfocleaner":Landroid/content/pm/PackageInfo;
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceGallery;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 259
    const-string v7, "com.evzapp.cleanmaster"

    const/4 v8, 0x0

    .line 258
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    .line 265
    :goto_1
    if-ne v0, v11, :cond_0

    if-nez v4, :cond_0

    .line 267
    new-instance v6, Lcom/aio/downloader/service/ServiceGallery$3;

    invoke-direct {v6, p0}, Lcom/aio/downloader/service/ServiceGallery$3;-><init>(Lcom/aio/downloader/service/ServiceGallery;)V

    iput-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->itemsOnClick4:Landroid/view/View$OnClickListener;

    .line 357
    new-instance v6, Lcom/aio/downloader/dialog/InstallfirstDialog;

    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceGallery;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    .line 358
    iget-object v8, p0, Lcom/aio/downloader/service/ServiceGallery;->itemsOnClick4:Landroid/view/View$OnClickListener;

    invoke-direct {v6, v7, v13, v8}, Lcom/aio/downloader/dialog/InstallfirstDialog;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V

    .line 357
    iput-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

    .line 359
    iget-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

    invoke-virtual {v6, v11}, Lcom/aio/downloader/dialog/InstallfirstDialog;->setCanceledOnTouchOutside(Z)V

    .line 360
    iget-object v6, p0, Lcom/aio/downloader/service/ServiceGallery;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

    invoke-virtual {v6}, Lcom/aio/downloader/dialog/InstallfirstDialog;->getWindow()Landroid/view/Window;

    move-result-object v6

    invoke-virtual {v6, v12}, Landroid/view/Window;->setType(I)V

    .line 362
    new-instance v6, Lcom/aio/downloader/service/ServiceGallery$4;

    invoke-direct {v6, p0}, Lcom/aio/downloader/service/ServiceGallery$4;-><init>(Lcom/aio/downloader/service/ServiceGallery;)V

    .line 380
    invoke-virtual {v6}, Lcom/aio/downloader/service/ServiceGallery$4;->start()V

    .line 388
    :cond_0
    return-void

    .line 209
    .end local v0    # "cichu":I
    .end local v4    # "packageInfocleaner":Landroid/content/pm/PackageInfo;
    .end local v5    # "userInfo_cishu":Landroid/content/SharedPreferences;
    :catch_0
    move-exception v1

    .line 210
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 260
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v0    # "cichu":I
    .restart local v4    # "packageInfocleaner":Landroid/content/pm/PackageInfo;
    .restart local v5    # "userInfo_cishu":Landroid/content/SharedPreferences;
    :catch_1
    move-exception v2

    .line 261
    .local v2, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v4, 0x0

    .line 262
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 398
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 399
    return-void
.end method
