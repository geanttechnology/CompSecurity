.class public Lcom/aio/downloader/service/GetBroadcast;
.super Landroid/content/BroadcastReceiver;
.source "GetBroadcast.java"


# static fields
.field private static mIntentFilter:Landroid/content/IntentFilter;

.field private static mReceiver:Lcom/aio/downloader/service/GetBroadcast;


# instance fields
.field private final ACTION_NAME_VER:Ljava/lang/String;

.field private final DOWNLOADINSTALL:Ljava/lang/String;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;

.field private appId:Ljava/lang/String;

.field private itemsOnClick4:Landroid/view/View$OnClickListener;

.field private size:Ljava/lang/String;

.field private uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/aio/downloader/service/GetBroadcast;

    invoke-direct {v0}, Lcom/aio/downloader/service/GetBroadcast;-><init>()V

    sput-object v0, Lcom/aio/downloader/service/GetBroadcast;->mReceiver:Lcom/aio/downloader/service/GetBroadcast;

    .line 43
    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 45
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 46
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

    iput-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_FOME:Ljava/io/File;

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

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_TO:Ljava/io/File;

    .line 49
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 50
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

    iput-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR:Ljava/io/File;

    .line 61
    const-string v0, "downloadinstall"

    iput-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->DOWNLOADINSTALL:Ljava/lang/String;

    .line 69
    const-string v0, "wocaonima"

    iput-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->ACTION_NAME_VER:Ljava/lang/String;

    .line 41
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/AnzhuangDialog;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/GetBroadcast;)Ljava/io/File;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/GetBroadcast;)Lcom/aio/downloader/dialog/UninstallDailog;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;

    return-object v0
.end method

.method public static registerReceiver(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 72
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lcom/aio/downloader/service/GetBroadcast;->mIntentFilter:Landroid/content/IntentFilter;

    .line 73
    sget-object v0, Lcom/aio/downloader/service/GetBroadcast;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "package"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 74
    sget-object v0, Lcom/aio/downloader/service/GetBroadcast;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.PACKAGE_ADDED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 75
    sget-object v0, Lcom/aio/downloader/service/GetBroadcast;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 76
    sget-object v0, Lcom/aio/downloader/service/GetBroadcast;->mIntentFilter:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.PACKAGE_REPLACED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 78
    sget-object v0, Lcom/aio/downloader/service/GetBroadcast;->mReceiver:Lcom/aio/downloader/service/GetBroadcast;

    sget-object v1, Lcom/aio/downloader/service/GetBroadcast;->mIntentFilter:Landroid/content/IntentFilter;

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 79
    return-void
.end method

.method public static unregisterReceiver(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    sget-object v0, Lcom/aio/downloader/service/GetBroadcast;->mReceiver:Lcom/aio/downloader/service/GetBroadcast;

    invoke-virtual {p0, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 83
    return-void
.end method


# virtual methods
.method public getAppInfoByPackageName(Ljava/lang/String;Landroid/content/Context;)Lcom/aio/downloader/model/AppInstalledEntity;
    .locals 13
    .param p1, "packagename"    # Ljava/lang/String;
    .param p2, "ctx"    # Landroid/content/Context;

    .prologue
    .line 474
    new-instance v1, Lcom/aio/downloader/model/AppInstalledEntity;

    invoke-direct {v1}, Lcom/aio/downloader/model/AppInstalledEntity;-><init>()V

    .line 475
    .local v1, "appInstalled":Lcom/aio/downloader/model/AppInstalledEntity;
    const/4 v8, 0x0

    .line 477
    .local v8, "pI":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    const/4 v10, 0x0

    invoke-virtual {v9, p1, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 482
    :goto_0
    const-string v9, "1"

    invoke-virtual {v1, v9}, Lcom/aio/downloader/model/AppInstalledEntity;->setAppId(Ljava/lang/String;)V

    .line 484
    iget-object v9, v8, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v9

    .line 485
    invoke-interface {v9}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    .line 486
    .local v2, "appName":Ljava/lang/String;
    invoke-virtual {v1, v2}, Lcom/aio/downloader/model/AppInstalledEntity;->setAppname(Ljava/lang/String;)V

    .line 487
    iget-object v9, v8, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v0, v9, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    .line 488
    .local v0, "apkpath":Ljava/lang/String;
    invoke-virtual {v1, v0}, Lcom/aio/downloader/model/AppInstalledEntity;->setApkpath(Ljava/lang/String;)V

    .line 489
    const-string v9, "www"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "ppppppppp="

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 492
    invoke-virtual {v1, p1}, Lcom/aio/downloader/model/AppInstalledEntity;->setAckageinfo(Ljava/lang/String;)V

    .line 494
    iget-object v9, v8, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 495
    .local v6, "icon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1, v6}, Lcom/aio/downloader/model/AppInstalledEntity;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 497
    iget-object v9, v8, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/aio/downloader/model/AppInstalledEntity;->setVersion(Ljava/lang/String;)V

    .line 499
    new-instance v9, Ljava/io/File;

    iget-object v10, v8, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v10, v10, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v9, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v9

    const-wide/16 v11, 0x400

    div-long v3, v9, v11

    .line 500
    .local v3, "appSize":J
    long-to-double v9, v3

    const-wide/high16 v11, 0x4090000000000000L    # 1024.0

    div-double/2addr v9, v11

    const-wide/high16 v11, 0x4059000000000000L    # 100.0

    mul-double/2addr v9, v11

    double-to-int v9, v9

    int-to-double v9, v9

    const-wide/high16 v11, 0x4059000000000000L    # 100.0

    div-double/2addr v9, v11

    double-to-float v7, v9

    .line 501
    .local v7, "lastSize":F
    const-wide/16 v9, 0x400

    cmp-long v9, v3, v9

    if-ltz v9, :cond_0

    .line 502
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "MB"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/aio/downloader/model/AppInstalledEntity;->setSize(Ljava/lang/String;)V

    .line 506
    :goto_1
    return-object v1

    .line 478
    .end local v0    # "apkpath":Ljava/lang/String;
    .end local v2    # "appName":Ljava/lang/String;
    .end local v3    # "appSize":J
    .end local v6    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v7    # "lastSize":F
    :catch_0
    move-exception v5

    .line 479
    .local v5, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v5}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 504
    .end local v5    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v0    # "apkpath":Ljava/lang/String;
    .restart local v2    # "appName":Ljava/lang/String;
    .restart local v3    # "appSize":J
    .restart local v6    # "icon":Landroid/graphics/drawable/Drawable;
    .restart local v7    # "lastSize":F
    :cond_0
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "KB"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Lcom/aio/downloader/model/AppInstalledEntity;->setSize(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 511
    const-wide/16 v1, 0x0

    .line 512
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 513
    const/4 v0, 0x0

    .line 514
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 515
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 519
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 517
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 26
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 88
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    .line 89
    .local v7, "packageName":Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    .line 90
    .local v9, "action":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 91
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v11

    .line 92
    .local v11, "asset":Landroid/content/res/AssetManager;
    const/16 v16, 0x0

    .line 94
    .local v16, "f":Ljava/io/File;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    .line 95
    const-string v2, "cleaner.apk"

    invoke-virtual {v11, v2}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v20

    .line 96
    .local v20, "is":Ljava/io/InputStream;
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->PRO_DIR:Ljava/io/File;

    const-string v3, "cleaner.apk"

    move-object/from16 v0, v17

    invoke-direct {v0, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_7

    .line 97
    .end local v16    # "f":Ljava/io/File;
    .local v17, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual/range {v17 .. v17}, Ljava/io/File;->createNewFile()Z

    .line 98
    new-instance v18, Ljava/io/FileOutputStream;

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 99
    .local v18, "fOut":Ljava/io/FileOutputStream;
    const/16 v2, 0x400

    new-array v12, v2, [B

    .line 100
    .local v12, "buffer":[B
    const/16 v21, 0x0

    .line 101
    .local v21, "len":I
    :goto_0
    move-object/from16 v0, v20

    invoke-virtual {v0, v12}, Ljava/io/InputStream;->read([B)I

    move-result v21

    const/4 v2, -0x1

    move/from16 v0, v21

    if-ne v0, v2, :cond_2

    .line 104
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->flush()V

    .line 105
    invoke-virtual/range {v20 .. v20}, Ljava/io/InputStream;->close()V

    .line 106
    invoke-virtual/range {v18 .. v18}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 113
    .end local v11    # "asset":Landroid/content/res/AssetManager;
    .end local v12    # "buffer":[B
    .end local v17    # "f":Ljava/io/File;
    .end local v18    # "fOut":Ljava/io/FileOutputStream;
    .end local v20    # "is":Ljava/io/InputStream;
    .end local v21    # "len":I
    :cond_0
    :goto_1
    const/16 v25, 0x0

    .line 115
    .local v25, "packageInfo_ins":Landroid/content/pm/PackageInfo;
    :try_start_2
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 116
    const/4 v3, 0x0

    .line 115
    invoke-virtual {v2, v7, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v25

    .line 122
    :goto_2
    const-string v2, "android.intent.action.PACKAGE_ADDED"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 123
    const-string v2, "www"

    const-string v3, "PACKAGE_ADDED"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    :try_start_3
    new-instance v19, Landroid/content/Intent;

    const-string v2, "downloadinstall"

    move-object/from16 v0, v19

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 136
    .local v19, "intent_install":Landroid/content/Intent;
    const-string v2, "appidinstall"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 137
    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 138
    const-string v2, "installsuccess"

    move-object/from16 v0, p1

    invoke-static {v0, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_6

    .line 143
    .end local v19    # "intent_install":Landroid/content/Intent;
    :goto_3
    const/16 v23, 0x0

    .line 145
    .local v23, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_4
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 146
    const-string v3, "com.evzapp.cleanmaster"

    const/4 v4, 0x0

    .line 145
    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_2

    move-result-object v23

    .line 151
    :goto_4
    if-nez v23, :cond_1

    .line 154
    :try_start_5
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v7, v1}, Lcom/aio/downloader/service/GetBroadcast;->getAppInfoByPackageName(Ljava/lang/String;Landroid/content/Context;)Lcom/aio/downloader/model/AppInstalledEntity;

    move-result-object v10

    .line 156
    .local v10, "appInstalled":Lcom/aio/downloader/model/AppInstalledEntity;
    invoke-virtual {v10}, Lcom/aio/downloader/model/AppInstalledEntity;->getAppname()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->appId:Ljava/lang/String;

    .line 157
    invoke-virtual {v10}, Lcom/aio/downloader/model/AppInstalledEntity;->getSize()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->size:Ljava/lang/String;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    .line 163
    .end local v10    # "appInstalled":Lcom/aio/downloader/model/AppInstalledEntity;
    :goto_5
    new-instance v2, Lcom/aio/downloader/service/GetBroadcast$1;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/aio/downloader/service/GetBroadcast$1;-><init>(Lcom/aio/downloader/service/GetBroadcast;)V

    .line 173
    invoke-virtual {v2}, Lcom/aio/downloader/service/GetBroadcast$1;->start()V

    .line 174
    const-string v2, "Installpop"

    move-object/from16 v0, p1

    invoke-static {v0, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 175
    new-instance v2, Lcom/aio/downloader/service/GetBroadcast$2;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v2, v0, v1}, Lcom/aio/downloader/service/GetBroadcast$2;-><init>(Lcom/aio/downloader/service/GetBroadcast;Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->itemsOnClick4:Landroid/view/View$OnClickListener;

    .line 265
    new-instance v2, Lcom/aio/downloader/dialog/AnzhuangDialog;

    .line 266
    const v4, 0x7f0c0010

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/GetBroadcast;->itemsOnClick4:Landroid/view/View$OnClickListener;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/service/GetBroadcast;->appId:Ljava/lang/String;

    .line 267
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/aio/downloader/service/GetBroadcast;->size:Ljava/lang/String;

    move-object/from16 v3, p1

    invoke-direct/range {v2 .. v8}, Lcom/aio/downloader/dialog/AnzhuangDialog;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;

    .line 269
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/AnzhuangDialog;->setCanceledOnTouchOutside(Z)V

    .line 270
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->anzhuangDialog:Lcom/aio/downloader/dialog/AnzhuangDialog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->getWindow()Landroid/view/Window;

    move-result-object v2

    .line 271
    const/16 v3, 0x7d3

    .line 270
    invoke-virtual {v2, v3}, Landroid/view/Window;->setType(I)V

    .line 272
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/aio/downloader/service/GetBroadcast$3;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v3, v0, v1}, Lcom/aio/downloader/service/GetBroadcast$3;-><init>(Lcom/aio/downloader/service/GetBroadcast;Landroid/content/Context;)V

    .line 296
    const-wide/16 v4, 0x1388

    .line 272
    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 461
    .end local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    :goto_6
    return-void

    .line 102
    .end local v25    # "packageInfo_ins":Landroid/content/pm/PackageInfo;
    .restart local v11    # "asset":Landroid/content/res/AssetManager;
    .restart local v12    # "buffer":[B
    .restart local v17    # "f":Ljava/io/File;
    .restart local v18    # "fOut":Ljava/io/FileOutputStream;
    .restart local v20    # "is":Ljava/io/InputStream;
    .restart local v21    # "len":I
    :cond_2
    const/4 v2, 0x0

    :try_start_6
    move-object/from16 v0, v18

    move/from16 v1, v21

    invoke-virtual {v0, v12, v2, v1}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0

    goto/16 :goto_0

    .line 107
    .end local v12    # "buffer":[B
    .end local v18    # "fOut":Ljava/io/FileOutputStream;
    .end local v21    # "len":I
    :catch_0
    move-exception v14

    move-object/from16 v16, v17

    .line 108
    .end local v17    # "f":Ljava/io/File;
    .end local v20    # "is":Ljava/io/InputStream;
    .local v14, "e":Ljava/io/IOException;
    .restart local v16    # "f":Ljava/io/File;
    :goto_7
    invoke-virtual {v14}, Ljava/io/IOException;->printStackTrace()V

    goto/16 :goto_1

    .line 117
    .end local v11    # "asset":Landroid/content/res/AssetManager;
    .end local v14    # "e":Ljava/io/IOException;
    .end local v16    # "f":Ljava/io/File;
    .restart local v25    # "packageInfo_ins":Landroid/content/pm/PackageInfo;
    :catch_1
    move-exception v15

    .line 118
    .local v15, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/16 v25, 0x0

    .line 119
    invoke-virtual {v15}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 147
    .end local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_2
    move-exception v15

    .line 148
    .restart local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/16 v23, 0x0

    .line 149
    invoke-virtual {v15}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_4

    .line 300
    .end local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_3
    const-string v2, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 301
    const-string v2, "com.evzapp.cleanmaster"

    invoke-virtual {v7, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 302
    if-nez v25, :cond_4

    .line 303
    const/16 v24, 0x0

    .line 305
    .local v24, "packageInfo1":Landroid/content/pm/PackageInfo;
    :try_start_7
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 306
    const-string v3, "com.evzapp.cleanmaster"

    const/4 v4, 0x0

    .line 305
    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_3

    move-result-object v24

    .line 311
    :goto_8
    if-nez v24, :cond_1

    .line 312
    const/16 v23, 0x0

    .line 314
    .restart local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_8
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 315
    const/4 v3, 0x0

    .line 314
    invoke-virtual {v2, v7, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_8
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_8 .. :try_end_8} :catch_4

    move-result-object v23

    .line 325
    :goto_9
    sget-boolean v2, Lcom/aio/downloader/utils/publicTools;->tagtanchuang:Z

    if-nez v2, :cond_1

    .line 326
    new-instance v2, Lcom/aio/downloader/service/GetBroadcast$4;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/aio/downloader/service/GetBroadcast$4;-><init>(Lcom/aio/downloader/service/GetBroadcast;)V

    .line 336
    invoke-virtual {v2}, Lcom/aio/downloader/service/GetBroadcast$4;->start()V

    .line 337
    const-string v2, "UnInstallpop"

    move-object/from16 v0, p1

    invoke-static {v0, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 346
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    mul-double/2addr v2, v4

    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    add-double/2addr v2, v4

    double-to-int v13, v2

    .line 347
    .local v13, "dd":I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v13}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "kb"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 348
    .local v8, "Unsize":Ljava/lang/String;
    new-instance v2, Lcom/aio/downloader/service/GetBroadcast$5;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v2, v0, v1}, Lcom/aio/downloader/service/GetBroadcast$5;-><init>(Lcom/aio/downloader/service/GetBroadcast;Landroid/content/Context;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->itemsOnClick4:Landroid/view/View$OnClickListener;

    .line 444
    new-instance v3, Lcom/aio/downloader/dialog/UninstallDailog;

    .line 445
    const v5, 0x7f0c0010

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/service/GetBroadcast;->itemsOnClick4:Landroid/view/View$OnClickListener;

    move-object/from16 v4, p1

    .line 446
    invoke-direct/range {v3 .. v8}, Lcom/aio/downloader/dialog/UninstallDailog;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V

    .line 444
    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;

    .line 447
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/UninstallDailog;->setCanceledOnTouchOutside(Z)V

    .line 448
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UninstallDailog;->getWindow()Landroid/view/Window;

    move-result-object v2

    .line 449
    const/16 v3, 0x7d3

    .line 448
    invoke-virtual {v2, v3}, Landroid/view/Window;->setType(I)V

    .line 450
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/service/GetBroadcast;->uninstallDailog:Lcom/aio/downloader/dialog/UninstallDailog;

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/UninstallDailog;->show()V

    goto/16 :goto_6

    .line 307
    .end local v8    # "Unsize":Ljava/lang/String;
    .end local v13    # "dd":I
    .end local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_3
    move-exception v15

    .line 308
    .restart local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/16 v24, 0x0

    .line 309
    invoke-virtual {v15}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_8

    .line 316
    .end local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_4
    move-exception v15

    .line 317
    .restart local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/16 v23, 0x0

    .line 318
    invoke-virtual {v15}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_9

    .line 454
    .end local v15    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v24    # "packageInfo1":Landroid/content/pm/PackageInfo;
    :cond_4
    const-string v2, "android.intent.action.PACKAGE_REPLACED"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 455
    new-instance v22, Landroid/content/Intent;

    const-string v2, "wocaonima"

    move-object/from16 v0, v22

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 456
    .local v22, "mIntent":Landroid/content/Intent;
    const-string v2, "MyUpver"

    const/4 v3, 0x1

    move-object/from16 v0, v22

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 458
    move-object/from16 v0, p1

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_6

    .line 159
    .end local v22    # "mIntent":Landroid/content/Intent;
    .restart local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_5
    move-exception v2

    goto/16 :goto_5

    .line 139
    .end local v23    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_6
    move-exception v2

    goto/16 :goto_3

    .line 107
    .end local v25    # "packageInfo_ins":Landroid/content/pm/PackageInfo;
    .restart local v11    # "asset":Landroid/content/res/AssetManager;
    .restart local v16    # "f":Ljava/io/File;
    :catch_7
    move-exception v14

    goto/16 :goto_7
.end method
