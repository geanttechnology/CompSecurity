.class public Lcom/aio/downloader/service/MyService;
.super Landroid/app/Service;
.source "MyService.java"


# instance fields
.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field mAlarmManager:Landroid/app/AlarmManager;

.field mPendingIntent:Landroid/app/PendingIntent;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 19
    iput-object v0, p0, Lcom/aio/downloader/service/MyService;->mAlarmManager:Landroid/app/AlarmManager;

    .line 20
    iput-object v0, p0, Lcom/aio/downloader/service/MyService;->mPendingIntent:Landroid/app/PendingIntent;

    .line 21
    iput-object v0, p0, Lcom/aio/downloader/service/MyService;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 18
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/MyService;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/aio/downloader/service/MyService;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 112
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 10

    .prologue
    .line 25
    iget-object v0, p0, Lcom/aio/downloader/service/MyService;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 26
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/service/MyService;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 28
    :cond_0
    new-instance v8, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/service/MyService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-class v1, Lcom/aio/downloader/service/MyService;

    invoke-direct {v8, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 29
    .local v8, "intent":Landroid/content/Intent;
    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/aio/downloader/service/MyService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    iput-object v0, p0, Lcom/aio/downloader/service/MyService;->mAlarmManager:Landroid/app/AlarmManager;

    .line 30
    const/4 v0, 0x0

    .line 31
    const/high16 v1, 0x10000000

    .line 30
    invoke-static {p0, v0, v8, v1}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/service/MyService;->mPendingIntent:Landroid/app/PendingIntent;

    .line 32
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 34
    .local v2, "now":J
    iget-object v0, p0, Lcom/aio/downloader/service/MyService;->mAlarmManager:Landroid/app/AlarmManager;

    const/4 v1, 0x1

    .line 35
    const-wide/32 v4, 0x1499700

    iget-object v6, p0, Lcom/aio/downloader/service/MyService;->mPendingIntent:Landroid/app/PendingIntent;

    .line 34
    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    .line 39
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 41
    new-instance v7, Landroid/content/IntentFilter;

    invoke-direct {v7}, Landroid/content/IntentFilter;-><init>()V

    .line 42
    .local v7, "filter":Landroid/content/IntentFilter;
    const-string v0, "android.intent.action.SCREEN_ON"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 43
    const-string v0, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 44
    const-string v0, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 45
    const/16 v0, 0x3e8

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->setPriority(I)V

    .line 46
    new-instance v9, Lcom/aio/downloader/service/ScreenReceiver;

    invoke-direct {v9}, Lcom/aio/downloader/service/ScreenReceiver;-><init>()V

    .line 47
    .local v9, "screenReceiver":Lcom/aio/downloader/service/ScreenReceiver;
    invoke-virtual {p0, v9, v7}, Lcom/aio/downloader/service/MyService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 66
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 118
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 119
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 71
    :try_start_0
    new-instance v0, Lcom/aio/downloader/service/MyService$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/MyService$1;-><init>(Lcom/aio/downloader/service/MyService;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 93
    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/MyService$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 98
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 94
    :catch_0
    move-exception v0

    goto :goto_0
.end method
