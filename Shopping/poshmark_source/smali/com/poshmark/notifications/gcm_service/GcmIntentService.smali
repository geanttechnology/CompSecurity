.class public Lcom/poshmark/notifications/gcm_service/GcmIntentService;
.super Landroid/app/IntentService;
.source "GcmIntentService.java"


# instance fields
.field NEWS:I

.field PARTY:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    const-string v0, "GcmIntentService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 36
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/notifications/gcm_service/GcmIntentService;->PARTY:I

    .line 37
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/notifications/gcm_service/GcmIntentService;->NEWS:I

    .line 41
    return-void
.end method

.method private fireNotification(Landroid/os/Bundle;)V
    .locals 25
    .param p1, "msgBundle"    # Landroid/os/Bundle;

    .prologue
    .line 93
    const-string v21, "message"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 94
    .local v11, "msg":Ljava/lang/String;
    const-string v21, "priority"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 95
    .local v15, "priority":Ljava/lang/String;
    const-string v21, "badge"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 96
    .local v5, "badgeCount":Ljava/lang/String;
    const-string v21, "type"

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 97
    .local v12, "msgType":Ljava/lang/String;
    if-nez v15, :cond_0

    .line 98
    new-instance v15, Ljava/lang/String;

    .end local v15    # "priority":Ljava/lang/String;
    const-string v21, "1"

    move-object/from16 v0, v21

    invoke-direct {v15, v0}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 101
    .restart local v15    # "priority":Ljava/lang/String;
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v19

    .line 102
    .local v19, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v19, :cond_1

    .line 104
    const-string v21, "com.poshmark.intents.PUSH_NOTIFICATION"

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 106
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 107
    .local v4, "b":Landroid/os/Bundle;
    const-string v21, "TAB_INDEX"

    const/16 v22, 0x3

    move-object/from16 v0, v21

    move/from16 v1, v22

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 108
    const-string v21, "com.poshmark.intents.SWITCH_TAB"

    move-object/from16 v0, v21

    invoke-static {v0, v4}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 112
    .end local v4    # "b":Landroid/os/Bundle;
    :cond_1
    new-instance v21, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    const v22, 0x7f0200b3

    invoke-virtual/range {v21 .. v22}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v9

    .line 117
    .local v9, "mBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    new-instance v20, Lcom/poshmark/utils/NMostRecentPushNotifications;

    invoke-direct/range {v20 .. v20}, Lcom/poshmark/utils/NMostRecentPushNotifications;-><init>()V

    .line 118
    .local v20, "visibleNotifications":Lcom/poshmark/utils/NMostRecentPushNotifications;
    invoke-virtual/range {v20 .. v20}, Lcom/poshmark/utils/NMostRecentPushNotifications;->loadAll()V

    .line 122
    new-instance v16, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    move-object/from16 v0, v16

    invoke-direct {v0, v11, v15}, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    .local v16, "pushMsg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    move-object/from16 v0, v20

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/NMostRecentPushNotifications;->add(Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;)V

    .line 124
    invoke-virtual/range {v20 .. v20}, Lcom/poshmark/utils/NMostRecentPushNotifications;->getCount()I

    move-result v6

    .line 126
    .local v6, "count":I
    new-instance v18, Ljava/lang/String;

    invoke-direct/range {v18 .. v18}, Ljava/lang/String;-><init>()V

    .line 127
    .local v18, "title":Ljava/lang/String;
    const/16 v21, 0x1

    move/from16 v0, v21

    if-ne v6, v0, :cond_2

    .line 128
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v21

    const v22, 0x7f06027f

    invoke-virtual/range {v21 .. v22}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 129
    invoke-virtual {v9, v11}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 138
    :goto_0
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 139
    .restart local v4    # "b":Landroid/os/Bundle;
    const-string v21, "TYPE"

    const/16 v22, 0x1

    move-object/from16 v0, v21

    move/from16 v1, v22

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 140
    const-string v21, "PUSH_MESSAGE"

    move-object/from16 v0, v21

    invoke-virtual {v4, v0, v11}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    const-string v21, "BADGE"

    move-object/from16 v0, v21

    invoke-virtual {v4, v0, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    const-string v21, "PUSH_MESSAGE_TYPE"

    move-object/from16 v0, v21

    invoke-virtual {v4, v0, v12}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    new-instance v8, Landroid/support/v4/app/NotificationCompat$InboxStyle;

    invoke-direct {v8}, Landroid/support/v4/app/NotificationCompat$InboxStyle;-><init>()V

    .line 149
    .local v8, "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    if-ge v7, v6, :cond_3

    .line 150
    move-object/from16 v0, v20

    invoke-virtual {v0, v7}, Lcom/poshmark/utils/NMostRecentPushNotifications;->get(I)Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->getMessage()Ljava/lang/CharSequence;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v8, v0}, Landroid/support/v4/app/NotificationCompat$InboxStyle;->addLine(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$InboxStyle;

    .line 149
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 131
    .end local v4    # "b":Landroid/os/Bundle;
    .end local v7    # "i":I
    .end local v8    # "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    :cond_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v21

    const v22, 0x7f0601ab

    invoke-virtual/range {v21 .. v22}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v21

    const/16 v22, 0x1

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v24

    aput-object v24, v22, v23

    invoke-static/range {v21 .. v22}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 132
    move-object/from16 v0, v18

    invoke-virtual {v9, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 133
    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentInfo(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 134
    invoke-virtual/range {v20 .. v20}, Lcom/poshmark/utils/NMostRecentPushNotifications;->getVIPMessage()Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->getMessage()Ljava/lang/CharSequence;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v9, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    goto :goto_0

    .line 153
    .restart local v4    # "b":Landroid/os/Bundle;
    .restart local v7    # "i":I
    .restart local v8    # "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    :cond_3
    invoke-virtual {v9, v8}, Landroid/support/v4/app/NotificationCompat$Builder;->setStyle(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 156
    new-instance v17, Landroid/content/Intent;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v21

    const-class v22, Lcom/poshmark/ui/PmNotificationRecieverActivity;

    move-object/from16 v0, v17

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 157
    .local v17, "resultIntent":Landroid/content/Intent;
    const-string v21, "NOTIFICATION_BUNDLE"

    move-object/from16 v0, v17

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 159
    const/16 v21, 0x0

    const/high16 v22, 0x10000000

    move-object/from16 v0, p0

    move/from16 v1, v21

    move-object/from16 v2, v17

    move/from16 v3, v22

    invoke-static {v0, v1, v2, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v14

    .line 161
    .local v14, "pIntent":Landroid/app/PendingIntent;
    invoke-virtual {v9, v14}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 163
    invoke-virtual {v9}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v13

    .line 164
    .local v13, "notification":Landroid/app/Notification;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v21

    const-string v22, "notification"

    invoke-virtual/range {v21 .. v22}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/app/NotificationManager;

    .line 167
    .local v10, "mNotificationManager":Landroid/app/NotificationManager;
    iget v0, v13, Landroid/app/Notification;->flags:I

    move/from16 v21, v0

    or-int/lit8 v21, v21, 0x10

    move/from16 v0, v21

    iput v0, v13, Landroid/app/Notification;->flags:I

    .line 168
    sget v21, Lcom/poshmark/application/PMApplication;->PM_PUSH_NOTIFICATION_ID:I

    move/from16 v0, v21

    invoke-virtual {v10, v0, v13}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 170
    invoke-virtual/range {v20 .. v20}, Lcom/poshmark/utils/NMostRecentPushNotifications;->flush()V

    .line 174
    return-void
.end method

.method private handleNotification(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "msgBundle"    # Landroid/os/Bundle;

    .prologue
    .line 81
    invoke-static {}, Lcom/poshmark/data_model/models/BadgeCount;->incrementCount()V

    .line 82
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v1

    .line 83
    .local v1, "topActivity":Lcom/poshmark/ui/PMActivity;
    const-string v2, "message"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "partyTitle":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-nez v2, :cond_1

    .line 85
    :cond_0
    invoke-direct {p0, p1}, Lcom/poshmark/notifications/gcm_service/GcmIntentService;->fireNotification(Landroid/os/Bundle;)V

    .line 89
    :goto_0
    return-void

    .line 87
    :cond_1
    const-string v2, "com.poshmark.intents.PUSH_NOTIFICATION"

    invoke-static {v2, p1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 45
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.google.android.c2dm.intent.RECEIVE"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 46
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 47
    .local v0, "extras":Landroid/os/Bundle;
    invoke-static {p0}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v1

    .line 48
    .local v1, "gcm":Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    invoke-virtual {v1, p1}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getMessageType(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v2

    .line 50
    .local v2, "messageType":Ljava/lang/String;
    invoke-virtual {v0}, Landroid/os/Bundle;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 51
    const-string v4, "gcm"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 52
    invoke-direct {p0, v0}, Lcom/poshmark/notifications/gcm_service/GcmIntentService;->handleNotification(Landroid/os/Bundle;)V

    .line 76
    .end local v0    # "extras":Landroid/os/Bundle;
    .end local v1    # "gcm":Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    .end local v2    # "messageType":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 55
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "android.intent.action.MY_PACKAGE_REPLACED"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 56
    const-string v4, "PM Intent"

    const-string v5, "updating app"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    new-instance v3, Lcom/poshmark/utils/GCMUtils;

    invoke-direct {v3}, Lcom/poshmark/utils/GCMUtils;-><init>()V

    .line 58
    .local v3, "utils":Lcom/poshmark/utils/GCMUtils;
    invoke-virtual {v3, p0}, Lcom/poshmark/utils/GCMUtils;->checkPlayServices(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 59
    const-string v4, "PM update"

    const-string v5, "forcing a registration"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/utils/GCMUtils;->forceRegisterWithGCM(Landroid/content/Context;)V

    goto :goto_0

    .line 62
    .end local v3    # "utils":Lcom/poshmark/utils/GCMUtils;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.poshmark.intents.FETCH_GCM_TOKEN"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 63
    new-instance v3, Lcom/poshmark/utils/GCMUtils;

    invoke-direct {v3}, Lcom/poshmark/utils/GCMUtils;-><init>()V

    .line 64
    .restart local v3    # "utils":Lcom/poshmark/utils/GCMUtils;
    invoke-virtual {v3, p0}, Lcom/poshmark/utils/GCMUtils;->checkPlayServices(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 65
    const-string v4, "PM update"

    const-string v5, "forcing a registration"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 66
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/utils/GCMUtils;->forceRegisterWithGCM(Landroid/content/Context;)V

    .line 67
    invoke-virtual {v3}, Lcom/poshmark/utils/GCMUtils;->setTimerForFreshGcmTokenFetch()V

    goto :goto_0

    .line 69
    .end local v3    # "utils":Lcom/poshmark/utils/GCMUtils;
    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "android.intent.action.BOOT_COMPLETED"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 70
    new-instance v3, Lcom/poshmark/utils/GCMUtils;

    invoke-direct {v3}, Lcom/poshmark/utils/GCMUtils;-><init>()V

    .line 71
    .restart local v3    # "utils":Lcom/poshmark/utils/GCMUtils;
    invoke-virtual {v3, p0}, Lcom/poshmark/utils/GCMUtils;->checkPlayServices(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 72
    const-string v4, "PM update"

    const-string v5, "system rebooted"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/utils/GCMUtils;->forceRegisterWithGCM(Landroid/content/Context;)V

    goto :goto_0
.end method
