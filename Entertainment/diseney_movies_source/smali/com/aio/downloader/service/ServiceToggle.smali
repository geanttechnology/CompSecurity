.class public Lcom/aio/downloader/service/ServiceToggle;
.super Landroid/app/Service;
.source "ServiceToggle.java"


# instance fields
.field private mNotificationManager3:Landroid/app/NotificationManager;

.field onoff:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 110
    new-instance v0, Lcom/aio/downloader/service/ServiceToggle$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ServiceToggle$1;-><init>(Lcom/aio/downloader/service/ServiceToggle;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceToggle;->onoff:Landroid/content/BroadcastReceiver;

    .line 18
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceToggle;Landroid/app/NotificationManager;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceToggle;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;

    return-object v0
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 99
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 22

    .prologue
    .line 26
    invoke-super/range {p0 .. p0}, Landroid/app/Service;->onCreate()V

    .line 30
    new-instance v9, Landroid/content/IntentFilter;

    invoke-direct {v9}, Landroid/content/IntentFilter;-><init>()V

    .line 31
    .local v9, "filter_onoff":Landroid/content/IntentFilter;
    const-string v20, "toggle_on"

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 32
    const-string v20, "toggle_off"

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 33
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle;->onoff:Landroid/content/BroadcastReceiver;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1, v9}, Lcom/aio/downloader/service/ServiceToggle;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 35
    const-string v20, "battery_low"

    .line 36
    const/16 v21, 0x0

    .line 35
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/service/ServiceToggle;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v19

    .line 37
    .local v19, "userInfo_low":Landroid/content/SharedPreferences;
    const-string v20, "b_low"

    const/16 v21, 0x0

    invoke-interface/range {v19 .. v21}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v18

    .line 39
    .local v18, "show":I
    if-nez v18, :cond_1

    .line 41
    const-string v20, "notification"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceToggle;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Landroid/app/NotificationManager;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;

    .line 42
    new-instance v10, Landroid/app/Notification;

    invoke-direct {v10}, Landroid/app/Notification;-><init>()V

    .line 43
    .local v10, "notification2":Landroid/app/Notification;
    const/16 v20, 0x2

    move/from16 v0, v20

    iput v0, v10, Landroid/app/Notification;->flags:I

    .line 44
    const v20, 0x7f0200eb

    move/from16 v0, v20

    iput v0, v10, Landroid/app/Notification;->icon:I

    .line 49
    new-instance v7, Landroid/content/Intent;

    const-string v20, "home"

    move-object/from16 v0, v20

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 51
    .local v7, "buttonIntent_home":Landroid/content/Intent;
    const/16 v20, 0x0

    const/16 v21, 0x0

    .line 50
    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v7, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v11

    .line 53
    .local v11, "pendButtonIntent":Landroid/app/PendingIntent;
    new-instance v3, Landroid/content/Intent;

    const-string v20, "boost"

    move-object/from16 v0, v20

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 55
    .local v3, "buttonIntent_boost":Landroid/content/Intent;
    const/16 v20, 0x0

    const/16 v21, 0x0

    .line 54
    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v3, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v12

    .line 57
    .local v12, "pendButtonIntent_boost":Landroid/app/PendingIntent;
    new-instance v6, Landroid/content/Intent;

    const-string v20, "games"

    move-object/from16 v0, v20

    invoke-direct {v6, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 59
    .local v6, "buttonIntent_games":Landroid/content/Intent;
    const/16 v20, 0x0

    const/16 v21, 0x0

    .line 58
    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v6, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v15

    .line 61
    .local v15, "pendButtonIntent_games":Landroid/app/PendingIntent;
    new-instance v4, Landroid/content/Intent;

    const-string v20, "camera"

    move-object/from16 v0, v20

    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 63
    .local v4, "buttonIntent_camera":Landroid/content/Intent;
    const/16 v20, 0x0

    const/16 v21, 0x0

    .line 62
    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v4, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v13

    .line 65
    .local v13, "pendButtonIntent_camera":Landroid/app/PendingIntent;
    new-instance v8, Landroid/content/Intent;

    const-string v20, "set"

    move-object/from16 v0, v20

    invoke-direct {v8, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 67
    .local v8, "buttonIntent_set":Landroid/content/Intent;
    const/16 v20, 0x0

    const/16 v21, 0x0

    .line 66
    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v8, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v16

    .line 69
    .local v16, "pendButtonIntent_set":Landroid/app/PendingIntent;
    new-instance v5, Landroid/content/Intent;

    const-string v20, "flash"

    move-object/from16 v0, v20

    invoke-direct {v5, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 71
    .local v5, "buttonIntent_flash":Landroid/content/Intent;
    const/16 v20, 0x0

    const/16 v21, 0x0

    .line 70
    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v0, v1, v5, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v14

    .line 73
    .local v14, "pendButtonIntent_flash":Landroid/app/PendingIntent;
    new-instance v17, Landroid/widget/RemoteViews;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/service/ServiceToggle;->getApplicationContext()Landroid/content/Context;

    move-result-object v20

    .line 74
    invoke-virtual/range {v20 .. v20}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v20

    const v21, 0x7f030095

    .line 73
    move-object/from16 v0, v17

    move-object/from16 v1, v20

    move/from16 v2, v21

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 75
    .local v17, "rv2":Landroid/widget/RemoteViews;
    const v20, 0x7f070347

    move-object/from16 v0, v17

    move/from16 v1, v20

    invoke-virtual {v0, v1, v11}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 76
    const v20, 0x7f070348

    move-object/from16 v0, v17

    move/from16 v1, v20

    invoke-virtual {v0, v1, v12}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 78
    const v20, 0x7f070349

    move-object/from16 v0, v17

    move/from16 v1, v20

    invoke-virtual {v0, v1, v15}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 80
    const v20, 0x7f07034a

    move-object/from16 v0, v17

    move/from16 v1, v20

    invoke-virtual {v0, v1, v13}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 82
    const v20, 0x7f07034c

    move-object/from16 v0, v17

    move/from16 v1, v20

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 84
    const v20, 0x7f07034b

    move-object/from16 v0, v17

    move/from16 v1, v20

    invoke-virtual {v0, v1, v14}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 86
    move-object/from16 v0, v17

    iput-object v0, v10, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 87
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;

    move-object/from16 v20, v0

    const/16 v21, 0x45f

    move-object/from16 v0, v20

    move/from16 v1, v21

    invoke-virtual {v0, v1, v10}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 95
    .end local v3    # "buttonIntent_boost":Landroid/content/Intent;
    .end local v4    # "buttonIntent_camera":Landroid/content/Intent;
    .end local v5    # "buttonIntent_flash":Landroid/content/Intent;
    .end local v6    # "buttonIntent_games":Landroid/content/Intent;
    .end local v7    # "buttonIntent_home":Landroid/content/Intent;
    .end local v8    # "buttonIntent_set":Landroid/content/Intent;
    .end local v10    # "notification2":Landroid/app/Notification;
    .end local v11    # "pendButtonIntent":Landroid/app/PendingIntent;
    .end local v12    # "pendButtonIntent_boost":Landroid/app/PendingIntent;
    .end local v13    # "pendButtonIntent_camera":Landroid/app/PendingIntent;
    .end local v14    # "pendButtonIntent_flash":Landroid/app/PendingIntent;
    .end local v15    # "pendButtonIntent_games":Landroid/app/PendingIntent;
    .end local v16    # "pendButtonIntent_set":Landroid/app/PendingIntent;
    .end local v17    # "rv2":Landroid/widget/RemoteViews;
    :cond_0
    :goto_0
    return-void

    .line 89
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;

    move-object/from16 v20, v0

    if-eqz v20, :cond_0

    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;

    move-object/from16 v20, v0

    const/16 v21, 0x45f

    invoke-virtual/range {v20 .. v21}, Landroid/app/NotificationManager;->cancel(I)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 105
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 106
    return-void
.end method
