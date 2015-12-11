.class public Lcom/igexin/sdk/SdkService;
.super Landroid/app/Service;
.source "SdkService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;,
        Lcom/igexin/sdk/SdkService$ClientIdReceiver;,
        Lcom/igexin/sdk/SdkService$PackageInstallReceiver;,
        Lcom/igexin/sdk/SdkService$InternalReceiver;,
        Lcom/igexin/sdk/SdkService$MyHandler;,
        Lcom/igexin/sdk/SdkService$MsgLooperThread;
    }
.end annotation


# static fields
.field private static instance:Lcom/igexin/sdk/SdkService;

.field private static volatile isThreadInit:B

.field public static msgLooperHandler:Landroid/os/Handler;

.field public static pkgName:Ljava/lang/String;


# instance fields
.field private actionMananger:Lcom/igexin/sdk/ActionManager;

.field private clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

.field private connectivityManager:Landroid/net/ConnectivityManager;

.field private dbHelper:Lcom/igexin/sdk/db/DBHelper;

.field private doActionReceiver:Lcom/igexin/sdk/SdkService$InternalReceiver;

.field private metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field private packageInstallReceiver:Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

.field private packageUninstallReceiver:Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 54
    sput-object v1, Lcom/igexin/sdk/SdkService;->instance:Lcom/igexin/sdk/SdkService;

    .line 55
    const/4 v0, 0x0

    sput-byte v0, Lcom/igexin/sdk/SdkService;->isThreadInit:B

    .line 59
    sput-object v1, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 792
    return-void
.end method

.method static synthetic access$000(Lcom/igexin/sdk/SdkService;)V
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkService;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->initClientIDReceiver()V

    return-void
.end method

.method static synthetic access$100(Lcom/igexin/sdk/SdkService;)V
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkService;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->register()V

    return-void
.end method

.method static synthetic access$200(Lcom/igexin/sdk/SdkService;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkService;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-direct {p0, p1, p2, p3}, Lcom/igexin/sdk/SdkService;->broadcastToCarrier(ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/igexin/sdk/SdkService;)V
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkService;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->init()V

    return-void
.end method

.method static synthetic access$402(B)B
    .locals 0
    .param p0, "x0"    # B

    .prologue
    .line 52
    sput-byte p0, Lcom/igexin/sdk/SdkService;->isThreadInit:B

    return p0
.end method

.method static synthetic access$500(Lcom/igexin/sdk/SdkService;Landroid/content/Intent;)V
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkService;
    .param p1, "x1"    # Landroid/content/Intent;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/igexin/sdk/SdkService;->onInternalReceiver(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$600(Lcom/igexin/sdk/SdkService;)V
    .locals 0
    .param p0, "x0"    # Lcom/igexin/sdk/SdkService;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->getDynamicConfigAndRegister()V

    return-void
.end method

.method private broadcastToCarrier(ILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "type"    # I
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 351
    new-instance v0, Landroid/content/Intent;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "com.igexin.sdk.action.carrier."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 352
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "type"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 353
    invoke-virtual {v0, p2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 354
    invoke-virtual {p0, v0}, Lcom/igexin/sdk/SdkService;->sendBroadcast(Landroid/content/Intent;)V

    .line 355
    return-void
.end method

.method private delDir(Ljava/io/File;)V
    .locals 6
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 336
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 337
    .local v2, "files":[Ljava/io/File;
    move-object v0, v2

    .local v0, "arr$":[Ljava/io/File;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_3

    aget-object v1, v0, v3

    .line 338
    .local v1, "f":Ljava/io/File;
    :cond_0
    :goto_1
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 339
    invoke-virtual {v1}, Ljava/io/File;->isFile()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 340
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    goto :goto_1

    .line 342
    :cond_1
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v5

    if-nez v5, :cond_0

    .line 343
    invoke-direct {p0, v1}, Lcom/igexin/sdk/SdkService;->delDir(Ljava/io/File;)V

    goto :goto_1

    .line 337
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 346
    .end local v1    # "f":Ljava/io/File;
    :cond_3
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    .line 348
    return-void
.end method

.method private getCidByPackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 606
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "cid pkgname = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 607
    invoke-static {p1}, Lcom/igexin/sdk/data/BasicDataManager;->getClientid(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getDynamicConfigAndRegister()V
    .locals 4

    .prologue
    .line 154
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/igexin/sdk/data/BasicDataManager;->lastGetConfigTime:J

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x5265c00

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 155
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->actionMananger:Lcom/igexin/sdk/ActionManager;

    new-instance v1, Lcom/igexin/sdk/SdkService$1;

    invoke-direct {v1, p0}, Lcom/igexin/sdk/SdkService$1;-><init>(Lcom/igexin/sdk/SdkService;)V

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/ActionManager;->getConfig(Lcom/igexin/sdk/CallbackListener;)V

    .line 184
    :goto_0
    return-void

    .line 182
    :cond_0
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->register()V

    goto :goto_0
.end method

.method public static getInstance()Lcom/igexin/sdk/SdkService;
    .locals 1

    .prologue
    .line 616
    sget-object v0, Lcom/igexin/sdk/SdkService;->instance:Lcom/igexin/sdk/SdkService;

    return-object v0
.end method

.method private init()V
    .locals 8

    .prologue
    .line 93
    const-string/jumbo v5, "connectivity"

    invoke-virtual {p0, v5}, Lcom/igexin/sdk/SdkService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/net/ConnectivityManager;

    iput-object v5, p0, Lcom/igexin/sdk/SdkService;->connectivityManager:Landroid/net/ConnectivityManager;

    .line 94
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getPackageName()Ljava/lang/String;

    move-result-object v5

    sput-object v5, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    .line 97
    const-string/jumbo v2, ""

    .line 98
    .local v2, "vpushAppID":Ljava/lang/String;
    const-string/jumbo v4, ""

    .line 99
    .local v4, "vpushAppsecret":Ljava/lang/String;
    const-string/jumbo v3, ""

    .line 103
    .local v3, "vpushAppkey":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    sget-object v6, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    const/16 v7, 0x80

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 104
    .local v0, "appInfo":Landroid/content/pm/ApplicationInfo;
    if-eqz v0, :cond_2

    iget-object v5, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v5, :cond_2

    .line 105
    iget-object v5, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string/jumbo v6, "VPUSH_APPID"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 106
    iget-object v5, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string/jumbo v6, "VPUSH_APPSECRET"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 107
    iget-object v5, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string/jumbo v6, "VPUSH_APPKEY"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_1

    iget-object v5, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string/jumbo v6, "VPUSH_APPKEY"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 122
    :goto_0
    sput-object v2, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    .line 123
    sput-object v3, Lcom/igexin/sdk/Consts;->VPUSH_APPKEY:Ljava/lang/String;

    .line 124
    sput-object v4, Lcom/igexin/sdk/Consts;->VPUSH_APPSECRET:Ljava/lang/String;

    .line 127
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->loadConfigFromFile()V

    .line 130
    new-instance v5, Lcom/igexin/sdk/db/DBHelper;

    invoke-direct {v5, p0}, Lcom/igexin/sdk/db/DBHelper;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    .line 132
    invoke-static {p0}, Lcom/igexin/sdk/data/BasicDataManager;->init(Landroid/content/Context;)V

    .line 133
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->init()V

    .line 135
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->initDoActionReceiver()V

    .line 136
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->initPackageInstallReceiver()V

    .line 137
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->initPackageUninstallReceiver()V

    .line 138
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->initClientIDReceiver()V

    .line 140
    new-instance v5, Lcom/igexin/sdk/ActionManager;

    invoke-direct {v5}, Lcom/igexin/sdk/ActionManager;-><init>()V

    iput-object v5, p0, Lcom/igexin/sdk/SdkService;->actionMananger:Lcom/igexin/sdk/ActionManager;

    .line 142
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v5

    iput-object v5, p0, Lcom/igexin/sdk/SdkService;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 144
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterPkgName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/igexin/sdk/SdkService;->checkAppInstall(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 147
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->startMasterService()V

    .line 150
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :cond_0
    :goto_1
    return-void

    .line 107
    .restart local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :cond_1
    const/4 v3, 0x0

    goto :goto_0

    .line 110
    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->stopService()V
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 114
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    :catch_0
    move-exception v1

    .line 115
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 118
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->stopService()V

    goto :goto_1
.end method

.method private initClientIDReceiver()V
    .locals 4

    .prologue
    .line 188
    iget-object v2, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    if-eqz v2, :cond_0

    .line 189
    iget-object v2, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    invoke-virtual {p0, v2}, Lcom/igexin/sdk/SdkService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 190
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    .line 193
    :cond_0
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterAppID()Ljava/lang/String;

    move-result-object v0

    .line 194
    .local v0, "appId":Ljava/lang/String;
    iget-object v2, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    if-nez v2, :cond_1

    if-eqz v0, :cond_1

    const-string/jumbo v2, ""

    if-eq v0, v2, :cond_1

    .line 195
    new-instance v2, Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    invoke-direct {v2, p0}, Lcom/igexin/sdk/SdkService$ClientIdReceiver;-><init>(Lcom/igexin/sdk/SdkService;)V

    iput-object v2, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    .line 197
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 198
    .local v1, "filter":Landroid/content/IntentFilter;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "com.igexin.sdk.action."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 199
    iget-object v2, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    invoke-virtual {p0, v2, v1}, Lcom/igexin/sdk/SdkService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 202
    .end local v1    # "filter":Landroid/content/IntentFilter;
    :cond_1
    return-void
.end method

.method private initDoActionReceiver()V
    .locals 2

    .prologue
    .line 358
    iget-object v1, p0, Lcom/igexin/sdk/SdkService;->doActionReceiver:Lcom/igexin/sdk/SdkService$InternalReceiver;

    if-nez v1, :cond_0

    .line 359
    new-instance v1, Lcom/igexin/sdk/SdkService$InternalReceiver;

    invoke-direct {v1, p0}, Lcom/igexin/sdk/SdkService$InternalReceiver;-><init>(Lcom/igexin/sdk/SdkService;)V

    iput-object v1, p0, Lcom/igexin/sdk/SdkService;->doActionReceiver:Lcom/igexin/sdk/SdkService$InternalReceiver;

    .line 360
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 361
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string/jumbo v1, "com.igexin.sdk.action.doaction"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 362
    iget-object v1, p0, Lcom/igexin/sdk/SdkService;->doActionReceiver:Lcom/igexin/sdk/SdkService$InternalReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/igexin/sdk/SdkService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 364
    .end local v0    # "filter":Landroid/content/IntentFilter;
    :cond_0
    return-void
.end method

.method private initPackageInstallReceiver()V
    .locals 2

    .prologue
    .line 367
    iget-object v1, p0, Lcom/igexin/sdk/SdkService;->packageInstallReceiver:Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

    if-nez v1, :cond_0

    .line 368
    new-instance v1, Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

    invoke-direct {v1, p0}, Lcom/igexin/sdk/SdkService$PackageInstallReceiver;-><init>(Lcom/igexin/sdk/SdkService;)V

    iput-object v1, p0, Lcom/igexin/sdk/SdkService;->packageInstallReceiver:Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

    .line 370
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 371
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string/jumbo v1, "android.intent.action.PACKAGE_ADDED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 372
    const-string/jumbo v1, "package"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 373
    iget-object v1, p0, Lcom/igexin/sdk/SdkService;->packageInstallReceiver:Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/igexin/sdk/SdkService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 376
    .end local v0    # "filter":Landroid/content/IntentFilter;
    :cond_0
    return-void
.end method

.method private initPackageUninstallReceiver()V
    .locals 2

    .prologue
    .line 379
    iget-object v1, p0, Lcom/igexin/sdk/SdkService;->packageUninstallReceiver:Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;

    if-nez v1, :cond_0

    .line 381
    new-instance v1, Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;

    invoke-direct {v1, p0}, Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;-><init>(Lcom/igexin/sdk/SdkService;)V

    iput-object v1, p0, Lcom/igexin/sdk/SdkService;->packageUninstallReceiver:Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;

    .line 383
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 384
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string/jumbo v1, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 385
    const-string/jumbo v1, "package"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 386
    iget-object v1, p0, Lcom/igexin/sdk/SdkService;->packageUninstallReceiver:Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/igexin/sdk/SdkService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 388
    .end local v0    # "filter":Landroid/content/IntentFilter;
    :cond_0
    return-void
.end method

.method private isAppInstalled(Ljava/lang/String;Ljava/util/List;)Z
    .locals 3
    .param p1, "targetPkgName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/PackageInfo;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 598
    .local p2, "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 599
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 600
    const/4 v2, 0x1

    .line 602
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private onInternalReceiver(Landroid/content/Intent;)V
    .locals 13
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 693
    if-eqz p1, :cond_0

    .line 695
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "com.igexin.sdk.action.doaction"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 697
    const-string/jumbo v9, "taskid"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 698
    .local v8, "taskId":Ljava/lang/String;
    const-string/jumbo v9, "messageid"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 699
    .local v5, "messageId":Ljava/lang/String;
    const-string/jumbo v9, "actionid"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 700
    .local v1, "actionId":Ljava/lang/String;
    const-string/jumbo v9, "accesstoken"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 702
    .local v0, "accesstoken":Ljava/lang/String;
    sget-object v9, Lcom/igexin/sdk/data/BasicDataManager;->internalBroadcastAccessToken:Ljava/lang/String;

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 703
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v9

    invoke-virtual {v9, v8, v5}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 704
    .local v3, "cacheId":Ljava/lang/String;
    sget-object v9, Lcom/igexin/sdk/data/BasicDataManager;->pushMessageMap:Ljava/util/Map;

    invoke-interface {v9, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/igexin/sdk/bean/PushMessageBean;

    .line 706
    .local v7, "pushMessageBean":Lcom/igexin/sdk/bean/PushMessageBean;
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v9

    invoke-virtual {v9, v7, v1}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 743
    .end local v0    # "accesstoken":Ljava/lang/String;
    .end local v1    # "actionId":Ljava/lang/String;
    .end local v3    # "cacheId":Ljava/lang/String;
    .end local v5    # "messageId":Ljava/lang/String;
    .end local v7    # "pushMessageBean":Lcom/igexin/sdk/bean/PushMessageBean;
    .end local v8    # "taskId":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 708
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "android.intent.action.PACKAGE_ADDED"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 710
    invoke-virtual {p1}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    .line 712
    .local v6, "packageName":Ljava/lang/String;
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterPkgName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 715
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->startMasterService()V

    goto :goto_0

    .line 718
    .end local v6    # "packageName":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "android.intent.action.PACKAGE_REMOVED"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 720
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->scanThirdPartCids()Ljava/util/List;

    move-result-object v4

    .line 721
    .local v4, "cids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v4, :cond_3

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_0

    .line 724
    :cond_3
    const-wide/16 v9, 0x0

    sput-wide v9, Lcom/igexin/sdk/data/BasicDataManager;->lastBindAppTime:J

    .line 725
    const/4 v9, 0x3

    const-string/jumbo v10, "lastBindAppTime"

    sget-wide v11, Lcom/igexin/sdk/data/BasicDataManager;->lastBindAppTime:J

    invoke-static {v11, v12}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v11

    invoke-static {v9, v10, v11}, Lcom/igexin/sdk/data/BasicDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 727
    const/4 v9, 0x2

    const-string/jumbo v10, "url"

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getDownloadUrl()Ljava/lang/String;

    move-result-object v11

    invoke-direct {p0, v9, v10, v11}, Lcom/igexin/sdk/SdkService;->broadcastToCarrier(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 729
    .end local v4    # "cids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_4
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "com.igexin.sdk.action."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterAppID()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 731
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 732
    .local v2, "bundle":Landroid/os/Bundle;
    const-string/jumbo v9, "action"

    invoke-virtual {v2, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v9

    packed-switch v9, :pswitch_data_0

    goto/16 :goto_0

    .line 736
    :pswitch_0
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->registerNow()V

    goto/16 :goto_0

    .line 732
    nop

    :pswitch_data_0
    .packed-switch 0x2712
        :pswitch_0
    .end packed-switch
.end method

.method private register()V
    .locals 4

    .prologue
    .line 206
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/igexin/sdk/data/BasicDataManager;->lastBindAppTime:J

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x5265c00

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 207
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->registerNow()V

    .line 213
    :goto_0
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->rmDownloadImgCache()V

    .line 214
    return-void

    .line 209
    :cond_0
    const/4 v0, 0x1

    const-string/jumbo v1, "vcid"

    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/igexin/sdk/SdkService;->broadcastToCarrier(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private registerNow()V
    .locals 13

    .prologue
    .line 218
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->scanThirdPartCids()Ljava/util/List;

    move-result-object v2

    .line 220
    .local v2, "cids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v2, :cond_5

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v10

    if-lez v10, :cond_5

    .line 221
    invoke-static {v2}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 223
    const/4 v4, 0x0

    .line 224
    .local v4, "isCIDUpdate":Z
    const/4 v5, 0x0

    .line 227
    .local v5, "isInfoUpdate":Z
    invoke-static {v2}, Lorg/json/simple/JSONArray;->toJSONString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/igexin/sdk/util/StringUtils;->getMD5Str(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 228
    .local v1, "cidListMd5":Ljava/lang/String;
    sget-object v10, Lcom/igexin/sdk/data/BasicDataManager;->lastCidLists:Ljava/lang/String;

    invoke-virtual {v1, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 229
    const/4 v4, 0x1

    .line 230
    sput-object v1, Lcom/igexin/sdk/data/BasicDataManager;->lastCidLists:Ljava/lang/String;

    .line 231
    const/4 v10, 0x5

    const-string/jumbo v11, "lastCidLists"

    invoke-static {v10, v11, v1}, Lcom/igexin/sdk/data/BasicDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 234
    :cond_0
    const/4 v8, 0x0

    .line 235
    .local v8, "uploadCids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v9, 0x3

    .line 236
    .local v9, "uploadCntLimit":I
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v10

    if-gt v10, v9, :cond_4

    .line 237
    move-object v8, v2

    .line 246
    :cond_1
    sget-object v10, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-virtual {v10}, Lcom/igexin/sdk/data/PhoneInfo;->getJsonMap()Ljava/util/Map;

    move-result-object v10

    invoke-static {v10}, Lorg/json/simple/JSONObject;->toJSONString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/igexin/sdk/util/StringUtils;->getMD5Str(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 247
    .local v6, "phoneInfoMd5":Ljava/lang/String;
    sget-object v10, Lcom/igexin/sdk/data/BasicDataManager;->lastPhoneInfo:Ljava/lang/String;

    invoke-virtual {v6, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_2

    .line 248
    const/4 v5, 0x1

    .line 249
    sput-object v6, Lcom/igexin/sdk/data/BasicDataManager;->lastPhoneInfo:Ljava/lang/String;

    .line 250
    const/4 v10, 0x6

    const-string/jumbo v11, "lastPhoneInfo"

    invoke-static {v10, v11, v6}, Lcom/igexin/sdk/data/BasicDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 254
    :cond_2
    if-eqz v8, :cond_3

    .line 255
    iget-object v10, p0, Lcom/igexin/sdk/SdkService;->actionMananger:Lcom/igexin/sdk/ActionManager;

    new-instance v11, Lcom/igexin/sdk/SdkService$2;

    invoke-direct {v11, p0}, Lcom/igexin/sdk/SdkService$2;-><init>(Lcom/igexin/sdk/SdkService;)V

    invoke-virtual {v10, v8, v4, v5, v11}, Lcom/igexin/sdk/ActionManager;->register(Ljava/util/List;ZZLcom/igexin/sdk/CallbackListener;)V

    .line 296
    .end local v1    # "cidListMd5":Ljava/lang/String;
    .end local v4    # "isCIDUpdate":Z
    .end local v5    # "isInfoUpdate":Z
    .end local v6    # "phoneInfoMd5":Ljava/lang/String;
    .end local v8    # "uploadCids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v9    # "uploadCntLimit":I
    :cond_3
    :goto_0
    return-void

    .line 239
    .restart local v1    # "cidListMd5":Ljava/lang/String;
    .restart local v4    # "isCIDUpdate":Z
    .restart local v5    # "isInfoUpdate":Z
    .restart local v8    # "uploadCids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v9    # "uploadCntLimit":I
    :cond_4
    new-instance v8, Ljava/util/ArrayList;

    .end local v8    # "uploadCids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 240
    .restart local v8    # "uploadCids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, v9, :cond_1

    .line 241
    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    invoke-interface {v8, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 240
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 278
    .end local v1    # "cidListMd5":Ljava/lang/String;
    .end local v3    # "i":I
    .end local v4    # "isCIDUpdate":Z
    .end local v5    # "isInfoUpdate":Z
    .end local v8    # "uploadCids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v9    # "uploadCntLimit":I
    :cond_5
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getDownloadUrl()Ljava/lang/String;

    move-result-object v10

    if-eqz v10, :cond_3

    .line 281
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterAppID()Ljava/lang/String;

    move-result-object v0

    .line 282
    .local v0, "appId":Ljava/lang/String;
    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterPkgName()Ljava/lang/String;

    move-result-object v7

    .line 284
    .local v7, "pkgName":Ljava/lang/String;
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v12, "Download MasterSDK MasterAppID = "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, " MasterPkgName = "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 286
    invoke-virtual {p0, v7}, Lcom/igexin/sdk/SdkService;->checkAppInstall(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 289
    invoke-direct {p0}, Lcom/igexin/sdk/SdkService;->startMasterService()V

    goto :goto_0

    .line 292
    :cond_6
    const/4 v10, 0x2

    const-string/jumbo v11, "url"

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getDownloadUrl()Ljava/lang/String;

    move-result-object v12

    invoke-direct {p0, v10, v11, v12}, Lcom/igexin/sdk/SdkService;->broadcastToCarrier(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private rmDownloadImgCache()V
    .locals 15

    .prologue
    .line 303
    const-string/jumbo v12, ""

    .line 304
    .local v12, "taskid":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/32 v2, 0x240c8400

    sub-long v13, v0, v2

    .line 306
    .local v13, "time":J
    const/4 v8, 0x0

    .line 308
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    iget-object v0, v0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    const-string/jumbo v1, "image"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string/jumbo v4, "taskid"

    aput-object v4, v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "createtime < \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13, v14}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const-string/jumbo v5, "taskid"

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Lcom/igexin/sdk/db/DBHelper;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 311
    if-eqz v8, :cond_2

    .line 313
    :cond_0
    :goto_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 315
    const-string/jumbo v0, "taskid"

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 317
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    iget-object v0, v0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    const-string/jumbo v1, "image"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string/jumbo v4, "taskid"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v12, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/igexin/sdk/db/DBHelper;->delete(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 318
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/igexin/sdk/Consts;->IMGPATHDIR:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 319
    .local v11, "fileName":Ljava/lang/String;
    new-instance v10, Ljava/io/File;

    invoke-direct {v10, v11}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 321
    .local v10, "file":Ljava/io/File;
    invoke-virtual {v10}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 322
    invoke-direct {p0, v10}, Lcom/igexin/sdk/SdkService;->delDir(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 326
    .end local v10    # "file":Ljava/io/File;
    .end local v11    # "fileName":Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 327
    .local v9, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v9}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 329
    if-eqz v8, :cond_1

    .line 330
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 333
    .end local v9    # "e":Ljava/lang/Exception;
    :cond_1
    :goto_1
    return-void

    .line 329
    :cond_2
    if-eqz v8, :cond_1

    .line 330
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 329
    :catchall_0
    move-exception v0

    if-eqz v8, :cond_3

    .line 330
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0
.end method

.method public static sendMessage(Landroid/os/Message;)V
    .locals 1
    .param p0, "msg"    # Landroid/os/Message;

    .prologue
    .line 687
    sget-object v0, Lcom/igexin/sdk/SdkService;->msgLooperHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 688
    sget-object v0, Lcom/igexin/sdk/SdkService;->msgLooperHandler:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 689
    :cond_0
    return-void
.end method

.method private startMasterService()V
    .locals 4

    .prologue
    .line 747
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 749
    .local v0, "packageName":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterServiceAction()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 751
    .local v1, "startIntent":Landroid/content/Intent;
    const-string/jumbo v2, "appid"

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getMasterAppID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 752
    const-string/jumbo v2, "action"

    const-string/jumbo v3, "com.igexin.action.initialize"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 753
    const-string/jumbo v2, "op_app"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 754
    const-string/jumbo v2, "isSlave"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 755
    invoke-virtual {p0, v1}, Lcom/igexin/sdk/SdkService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 756
    return-void
.end method


# virtual methods
.method public checkAppInstall(Ljava/lang/String;)Z
    .locals 5
    .param p1, "packName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 418
    if-eqz p1, :cond_0

    const-string/jumbo v4, ""

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 426
    :cond_0
    :goto_0
    return v3

    .line 421
    :cond_1
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v1

    .line 422
    .local v1, "appInfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/PackageInfo;

    .line 423
    .local v0, "appInfo":Landroid/content/pm/PackageInfo;
    iget-object v4, v0, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 424
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public checkAppLauncher(Ljava/lang/String;)Z
    .locals 8
    .param p1, "packName"    # Ljava/lang/String;

    .prologue
    .line 436
    const/4 v2, 0x0

    .line 437
    .local v2, "flag":Z
    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v6, "android.intent.action.MAIN"

    const/4 v7, 0x0

    invoke-direct {v4, v6, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 438
    .local v4, "mainIntent":Landroid/content/Intent;
    const-string/jumbo v6, "android.intent.category.LAUNCHER"

    invoke-virtual {v4, v6}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 439
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v4, v7}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 441
    .local v1, "apps":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    .line 442
    .local v0, "app":Landroid/content/pm/ResolveInfo;
    iget-object v6, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v5, v6, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    .line 443
    .local v5, "pkg":Ljava/lang/String;
    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 444
    const/4 v2, 0x1

    .line 448
    .end local v0    # "app":Landroid/content/pm/ResolveInfo;
    .end local v5    # "pkg":Ljava/lang/String;
    :cond_1
    return v2
.end method

.method public getDBHelper()Lcom/igexin/sdk/db/DBHelper;
    .locals 1

    .prologue
    .line 620
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    return-object v0
.end method

.method public getDownloadImgCache(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 462
    const-string/jumbo v8, ""

    .line 463
    .local v8, "fileName":Ljava/lang/String;
    const/4 v6, 0x0

    .line 465
    .local v6, "cursor":Landroid/database/Cursor;
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getDBHelper()Lcom/igexin/sdk/db/DBHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    .line 468
    :try_start_0
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    const-string/jumbo v1, "image"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string/jumbo v4, "imageurl"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/igexin/sdk/db/DBHelper;->query(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 470
    if-eqz v6, :cond_2

    .line 472
    :cond_0
    :goto_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 474
    const-string/jumbo v0, "imagesrc"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 475
    new-instance v9, Ljava/io/File;

    invoke-direct {v9, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 477
    .local v9, "files":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    .line 478
    const-string/jumbo v8, ""

    .line 479
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    const-string/jumbo v1, "image"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string/jumbo v4, "imageurl"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/igexin/sdk/db/DBHelper;->delete(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 483
    .end local v9    # "files":Ljava/io/File;
    :catch_0
    move-exception v7

    .line 484
    .local v7, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 486
    if-eqz v6, :cond_1

    .line 487
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 491
    .end local v7    # "e":Ljava/lang/Exception;
    :cond_1
    :goto_1
    return-object v8

    .line 486
    :cond_2
    if-eqz v6, :cond_1

    .line 487
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 486
    :catchall_0
    move-exception v0

    if-eqz v6, :cond_3

    .line 487
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v0
.end method

.method public getMetricsFactory()Lcom/amazon/client/metrics/MetricsFactory;
    .locals 1

    .prologue
    .line 623
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    return-object v0
.end method

.method public getNetworkType()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 495
    iget-object v2, p0, Lcom/igexin/sdk/SdkService;->connectivityManager:Landroid/net/ConnectivityManager;

    if-nez v2, :cond_1

    .line 505
    :cond_0
    :goto_0
    return-object v1

    .line 498
    :cond_1
    iget-object v2, p0, Lcom/igexin/sdk/SdkService;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v2}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 499
    .local v0, "networkInfo":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    .line 500
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_2

    .line 501
    const-string/jumbo v1, "wifi"

    goto :goto_0

    .line 502
    :cond_2
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    if-nez v2, :cond_0

    .line 503
    const-string/jumbo v1, "mobile"

    goto :goto_0
.end method

.method public isSdkActivitySet()Z
    .locals 11

    .prologue
    const/4 v8, 0x1

    .line 400
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    .line 402
    .local v7, "packageName":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    const/4 v10, 0x1

    invoke-virtual {v9, v7, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    .line 403
    .local v6, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v1, v6, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    .line 404
    .local v1, "activityInfos":[Landroid/content/pm/ActivityInfo;
    if-eqz v1, :cond_1

    .line 405
    move-object v2, v1

    .local v2, "arr$":[Landroid/content/pm/ActivityInfo;
    array-length v5, v2

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_1

    aget-object v0, v2, v4

    .line 406
    .local v0, "activityInfo":Landroid/content/pm/ActivityInfo;
    iget-object v9, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    const-string/jumbo v10, "SdkActivity"

    invoke-virtual {v9, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v9

    const/4 v10, -0x1

    if-eq v9, v10, :cond_0

    .line 413
    .end local v0    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .end local v1    # "activityInfos":[Landroid/content/pm/ActivityInfo;
    .end local v2    # "arr$":[Landroid/content/pm/ActivityInfo;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    .end local v6    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_1
    return v8

    .line 405
    .restart local v0    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .restart local v1    # "activityInfos":[Landroid/content/pm/ActivityInfo;
    .restart local v2    # "arr$":[Landroid/content/pm/ActivityInfo;
    .restart local v4    # "i$":I
    .restart local v5    # "len$":I
    .restart local v6    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 410
    .end local v0    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .end local v1    # "activityInfos":[Landroid/content/pm/ActivityInfo;
    .end local v2    # "arr$":[Landroid/content/pm/ActivityInfo;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    .end local v6    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v3

    .line 411
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 413
    .end local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    const/4 v8, 0x0

    goto :goto_1
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "arg0"    # Landroid/content/Intent;

    .prologue
    .line 612
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 0

    .prologue
    .line 510
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 511
    sput-object p0, Lcom/igexin/sdk/SdkService;->instance:Lcom/igexin/sdk/SdkService;

    .line 512
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 516
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    if-eqz v0, :cond_0

    .line 517
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    invoke-virtual {v0}, Lcom/igexin/sdk/db/DBHelper;->close()V

    .line 519
    :cond_0
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->doActionReceiver:Lcom/igexin/sdk/SdkService$InternalReceiver;

    if-eqz v0, :cond_1

    .line 520
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->doActionReceiver:Lcom/igexin/sdk/SdkService$InternalReceiver;

    invoke-virtual {p0, v0}, Lcom/igexin/sdk/SdkService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 523
    :cond_1
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->packageInstallReceiver:Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

    if-eqz v0, :cond_2

    .line 524
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->packageInstallReceiver:Lcom/igexin/sdk/SdkService$PackageInstallReceiver;

    invoke-virtual {p0, v0}, Lcom/igexin/sdk/SdkService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 527
    :cond_2
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    if-eqz v0, :cond_3

    .line 528
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->clientIDReceiver:Lcom/igexin/sdk/SdkService$ClientIdReceiver;

    invoke-virtual {p0, v0}, Lcom/igexin/sdk/SdkService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 531
    :cond_3
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->packageUninstallReceiver:Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;

    if-eqz v0, :cond_4

    .line 532
    iget-object v0, p0, Lcom/igexin/sdk/SdkService;->packageUninstallReceiver:Lcom/igexin/sdk/SdkService$PackageUninstallReceiver;

    invoke-virtual {p0, v0}, Lcom/igexin/sdk/SdkService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 535
    :cond_4
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 536
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const/4 v2, 0x1

    .line 541
    sget-byte v1, Lcom/igexin/sdk/SdkService;->isThreadInit:B

    if-ne v1, v2, :cond_0

    if-eqz p1, :cond_0

    .line 542
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 543
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x2af8

    iput v1, v0, Landroid/os/Message;->what:I

    .line 544
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 545
    invoke-static {v0}, Lcom/igexin/sdk/SdkService;->sendMessage(Landroid/os/Message;)V

    .line 549
    .end local v0    # "msg":Landroid/os/Message;
    :goto_0
    return v2

    .line 547
    :cond_0
    new-instance v1, Lcom/igexin/sdk/SdkService$MsgLooperThread;

    invoke-direct {v1, p1}, Lcom/igexin/sdk/SdkService$MsgLooperThread;-><init>(Landroid/content/Intent;)V

    invoke-virtual {v1}, Lcom/igexin/sdk/SdkService$MsgLooperThread;->start()V

    goto :goto_0
.end method

.method public scanThirdPartCids()Ljava/util/List;
    .locals 15
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 557
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v12

    const-string/jumbo v13, "mounted"

    invoke-virtual {v12, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 558
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v10

    .line 559
    .local v10, "rootPath":Ljava/lang/String;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string/jumbo v13, "/libs"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 561
    .local v7, "libsDir":Ljava/lang/String;
    sget-object v12, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "libsDir = "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 563
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 564
    .local v3, "file":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v12

    if-eqz v12, :cond_1

    .line 565
    new-instance v12, Lcom/igexin/sdk/SdkService$3;

    invoke-direct {v12, p0}, Lcom/igexin/sdk/SdkService$3;-><init>(Lcom/igexin/sdk/SdkService;)V

    invoke-virtual {v3, v12}, Ljava/io/File;->list(Ljava/io/FilenameFilter;)[Ljava/lang/String;

    move-result-object v4

    .line 575
    .local v4, "fileNames":[Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 576
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v12

    const/4 v13, 0x0

    invoke-virtual {v12, v13}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v9

    .line 577
    .local v9, "packageInfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 578
    .local v2, "cids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/String;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_2

    aget-object v8, v0, v5

    .line 579
    .local v8, "name":Ljava/lang/String;
    const/4 v12, 0x0

    const-string/jumbo v13, ".db"

    invoke-virtual {v8, v13}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v13

    invoke-virtual {v8, v12, v13}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v11

    .line 581
    .local v11, "targetPkgName":Ljava/lang/String;
    invoke-direct {p0, v11, v9}, Lcom/igexin/sdk/SdkService;->isAppInstalled(Ljava/lang/String;Ljava/util/List;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 582
    invoke-direct {p0, v8}, Lcom/igexin/sdk/SdkService;->getCidByPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 583
    .local v1, "cid":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 584
    sget-object v12, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string/jumbo v14, ":"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 585
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 578
    .end local v1    # "cid":Ljava/lang/String;
    :cond_0
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 594
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "cids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "file":Ljava/io/File;
    .end local v4    # "fileNames":[Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    .end local v7    # "libsDir":Ljava/lang/String;
    .end local v8    # "name":Ljava/lang/String;
    .end local v9    # "packageInfos":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    .end local v10    # "rootPath":Ljava/lang/String;
    .end local v11    # "targetPkgName":Ljava/lang/String;
    :cond_1
    const/4 v2, 0x0

    :cond_2
    return-object v2
.end method

.method public stopService()V
    .locals 0

    .prologue
    .line 553
    invoke-virtual {p0}, Lcom/igexin/sdk/SdkService;->stopSelf()V

    .line 554
    return-void
.end method
