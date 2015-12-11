.class Lcom/aio/downloader/service/ServiceToggle$1;
.super Landroid/content/BroadcastReceiver;
.source "ServiceToggle.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceToggle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceToggle;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceToggle;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    .line 110
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 20
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 114
    const-string v17, "toggletag"

    const-string v18, "toggle_on"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 115
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v17

    const-string v18, "toggle_on"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_1

    .line 116
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    move-object/from16 v17, v0

    const-string v19, "notification"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/aio/downloader/service/ServiceToggle;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Landroid/app/NotificationManager;

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Lcom/aio/downloader/service/ServiceToggle;->access$0(Lcom/aio/downloader/service/ServiceToggle;Landroid/app/NotificationManager;)V

    .line 117
    new-instance v9, Landroid/app/Notification;

    invoke-direct {v9}, Landroid/app/Notification;-><init>()V

    .line 118
    .local v9, "notification2":Landroid/app/Notification;
    const/16 v17, 0x2

    move/from16 v0, v17

    iput v0, v9, Landroid/app/Notification;->flags:I

    .line 119
    const v17, 0x7f0200eb

    move/from16 v0, v17

    iput v0, v9, Landroid/app/Notification;->icon:I

    .line 124
    new-instance v7, Landroid/content/Intent;

    const-string v17, "home"

    move-object/from16 v0, v17

    invoke-direct {v7, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 126
    .local v7, "buttonIntent_home":Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    .line 125
    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v7, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v10

    .line 128
    .local v10, "pendButtonIntent":Landroid/app/PendingIntent;
    new-instance v3, Landroid/content/Intent;

    const-string v17, "boost"

    move-object/from16 v0, v17

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 130
    .local v3, "buttonIntent_boost":Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v3, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v11

    .line 132
    .local v11, "pendButtonIntent_boost":Landroid/app/PendingIntent;
    new-instance v6, Landroid/content/Intent;

    const-string v17, "games"

    move-object/from16 v0, v17

    invoke-direct {v6, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 134
    .local v6, "buttonIntent_games":Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v6, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v14

    .line 136
    .local v14, "pendButtonIntent_games":Landroid/app/PendingIntent;
    new-instance v4, Landroid/content/Intent;

    const-string v17, "camera"

    move-object/from16 v0, v17

    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 138
    .local v4, "buttonIntent_camera":Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v4, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v12

    .line 140
    .local v12, "pendButtonIntent_camera":Landroid/app/PendingIntent;
    new-instance v8, Landroid/content/Intent;

    const-string v17, "set"

    move-object/from16 v0, v17

    invoke-direct {v8, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 142
    .local v8, "buttonIntent_set":Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v8, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v15

    .line 144
    .local v15, "pendButtonIntent_set":Landroid/app/PendingIntent;
    new-instance v5, Landroid/content/Intent;

    const-string v17, "flash"

    move-object/from16 v0, v17

    invoke-direct {v5, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 146
    .local v5, "buttonIntent_flash":Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v5, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v13

    .line 148
    .local v13, "pendButtonIntent_flash":Landroid/app/PendingIntent;
    new-instance v16, Landroid/widget/RemoteViews;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/aio/downloader/service/ServiceToggle;->getApplicationContext()Landroid/content/Context;

    move-result-object v17

    .line 149
    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v17

    const v18, 0x7f030095

    .line 148
    invoke-direct/range {v16 .. v18}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 150
    .local v16, "rv2":Landroid/widget/RemoteViews;
    const v17, 0x7f070347

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v10}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 152
    const v17, 0x7f070348

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v11}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 154
    const v17, 0x7f070349

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v14}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 156
    const v17, 0x7f07034a

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v12}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 158
    const v17, 0x7f07034c

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v15}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 160
    const v17, 0x7f07034b

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v13}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 162
    move-object/from16 v0, v16

    iput-object v0, v9, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 163
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    move-object/from16 v17, v0

    # getter for: Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;
    invoke-static/range {v17 .. v17}, Lcom/aio/downloader/service/ServiceToggle;->access$1(Lcom/aio/downloader/service/ServiceToggle;)Landroid/app/NotificationManager;

    move-result-object v17

    const/16 v18, 0x45f

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v0, v1, v9}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 171
    .end local v3    # "buttonIntent_boost":Landroid/content/Intent;
    .end local v4    # "buttonIntent_camera":Landroid/content/Intent;
    .end local v5    # "buttonIntent_flash":Landroid/content/Intent;
    .end local v6    # "buttonIntent_games":Landroid/content/Intent;
    .end local v7    # "buttonIntent_home":Landroid/content/Intent;
    .end local v8    # "buttonIntent_set":Landroid/content/Intent;
    .end local v9    # "notification2":Landroid/app/Notification;
    .end local v10    # "pendButtonIntent":Landroid/app/PendingIntent;
    .end local v11    # "pendButtonIntent_boost":Landroid/app/PendingIntent;
    .end local v12    # "pendButtonIntent_camera":Landroid/app/PendingIntent;
    .end local v13    # "pendButtonIntent_flash":Landroid/app/PendingIntent;
    .end local v14    # "pendButtonIntent_games":Landroid/app/PendingIntent;
    .end local v15    # "pendButtonIntent_set":Landroid/app/PendingIntent;
    .end local v16    # "rv2":Landroid/widget/RemoteViews;
    :cond_0
    :goto_0
    return-void

    .line 165
    :cond_1
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v17

    const-string v18, "toggle_off"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_0

    .line 167
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    move-object/from16 v17, v0

    # getter for: Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;
    invoke-static/range {v17 .. v17}, Lcom/aio/downloader/service/ServiceToggle;->access$1(Lcom/aio/downloader/service/ServiceToggle;)Landroid/app/NotificationManager;

    move-result-object v17

    if-eqz v17, :cond_0

    .line 168
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceToggle$1;->this$0:Lcom/aio/downloader/service/ServiceToggle;

    move-object/from16 v17, v0

    # getter for: Lcom/aio/downloader/service/ServiceToggle;->mNotificationManager3:Landroid/app/NotificationManager;
    invoke-static/range {v17 .. v17}, Lcom/aio/downloader/service/ServiceToggle;->access$1(Lcom/aio/downloader/service/ServiceToggle;)Landroid/app/NotificationManager;

    move-result-object v17

    const/16 v18, 0x45f

    invoke-virtual/range {v17 .. v18}, Landroid/app/NotificationManager;->cancel(I)V

    goto :goto_0
.end method
