.class public Lco/vine/android/service/GCMNotificationService;
.super Landroid/app/Service;
.source "GCMNotificationService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/GCMNotificationService$BuildableNotification;,
        Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;,
        Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    }
.end annotation


# static fields
.field public static final ACTION_CLEAR_NOTIFICATIONS:Ljava/lang/String; = "co.vine.android.notifications.ACTION_CLEAR_NOTIFICATIONS"

.field public static final ACTION_SHOW_NOTIFICATION:Ljava/lang/String; = "co.vine.android.notifications.ACTION_SHOW_NOTIFICATION"

.field public static final ACTION_UPDATE_NOTIFICATIONS:Ljava/lang/String; = "co.vine.android.notifications.ACTION_UPDATE_NOTIFICATIONS"

.field public static final ACTIVITY_NOTIFICATION_ID:I = 0x1

.field private static final DELAY_STOP_SERVICE_MS:I = 0x7d0

.field public static final EXTRA_AM_FOLLOWING:Ljava/lang/String; = "am_following"

.field public static final EXTRA_CONVERSATION_ROW_ID:Ljava/lang/String; = "conversation_row_id"

.field public static final EXTRA_NOTIFICATIONS_JSON:Ljava/lang/String; = "notifications"

.field public static final EXTRA_NOTIFICATION_ID:Ljava/lang/String; = "notification_id"

.field public static final EXTRA_USERNAME:Ljava/lang/String; = "username"

.field public static final EXTRA_USER_ID:Ljava/lang/String; = "user_id"

.field public static final MESSAGE_NOTIFICATION_ID:I = 0x2

.field private static final NOTIFICATION_TAG:Ljava/lang/String; = "gcmGenericNotification"

.field private static final TAG:Ljava/lang/String; = "GCMNotifService"

.field private static final sConversationStateFilter:Landroid/content/IntentFilter;


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private mAppSessionListener:Lco/vine/android/client/AppSessionListener;

.field private mCameraConnection:Landroid/content/ServiceConnection;

.field private mCameraMessenger:Landroid/os/Messenger;

.field private final mConversationStateReciver:Landroid/content/BroadcastReceiver;

.field private mHandler:Landroid/os/Handler;

.field private mIsCameraServiceConnected:Z

.field private final mNotificationsToFire:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lco/vine/android/service/GCMNotificationService$BuildableNotification;",
            ">;"
        }
    .end annotation
.end field

.field private final mQueue:Lco/vine/android/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/util/SparseArray",
            "<",
            "Lco/vine/android/service/GCMNotificationService$NotificationEvent;",
            ">;"
        }
    .end annotation
.end field

.field private mStartIds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field final mStopServiceRunnable:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 88
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lco/vine/android/service/GCMNotificationService;->sConversationStateFilter:Landroid/content/IntentFilter;

    .line 90
    sget-object v0, Lco/vine/android/service/GCMNotificationService;->sConversationStateFilter:Landroid/content/IntentFilter;

    const-string v1, "co.vine.android.camera.request.conversation.state.on"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 91
    sget-object v0, Lco/vine/android/service/GCMNotificationService;->sConversationStateFilter:Landroid/content/IntentFilter;

    const-string v1, "co.vine.android.camera.request.conversation.state.off"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 92
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 57
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 85
    new-instance v0, Lco/vine/android/util/SparseArray;

    invoke-direct {v0}, Lco/vine/android/util/SparseArray;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;

    .line 93
    new-instance v0, Lco/vine/android/service/GCMNotificationService$1;

    invoke-direct {v0, p0}, Lco/vine/android/service/GCMNotificationService$1;-><init>(Lco/vine/android/service/GCMNotificationService;)V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mCameraConnection:Landroid/content/ServiceConnection;

    .line 107
    new-instance v0, Lco/vine/android/service/GCMNotificationService$2;

    invoke-direct {v0, p0}, Lco/vine/android/service/GCMNotificationService$2;-><init>(Lco/vine/android/service/GCMNotificationService;)V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mConversationStateReciver:Landroid/content/BroadcastReceiver;

    .line 125
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;

    .line 235
    new-instance v0, Lco/vine/android/service/GCMNotificationService$3;

    invoke-direct {v0, p0}, Lco/vine/android/service/GCMNotificationService$3;-><init>(Lco/vine/android/service/GCMNotificationService;)V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mStopServiceRunnable:Ljava/lang/Runnable;

    .line 602
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/service/GCMNotificationService;)Landroid/os/Messenger;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mCameraMessenger:Landroid/os/Messenger;

    return-object v0
.end method

.method static synthetic access$002(Lco/vine/android/service/GCMNotificationService;Landroid/os/Messenger;)Landroid/os/Messenger;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p1, "x1"    # Landroid/os/Messenger;

    .prologue
    .line 57
    iput-object p1, p0, Lco/vine/android/service/GCMNotificationService;->mCameraMessenger:Landroid/os/Messenger;

    return-object p1
.end method

.method static synthetic access$102(Lco/vine/android/service/GCMNotificationService;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p1, "x1"    # Z

    .prologue
    .line 57
    iput-boolean p1, p0, Lco/vine/android/service/GCMNotificationService;->mIsCameraServiceConnected:Z

    return p1
.end method

.method static synthetic access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/service/GCMNotificationService;IJ)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p1, "x1"    # I
    .param p2, "x2"    # J

    .prologue
    .line 57
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/service/GCMNotificationService;->updateNotification(IJ)V

    return-void
.end method

.method static synthetic access$500(Lco/vine/android/service/GCMNotificationService;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;

    .prologue
    .line 57
    invoke-direct {p0}, Lco/vine/android/service/GCMNotificationService;->stopService()V

    return-void
.end method

.method static synthetic access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;

    .prologue
    .line 57
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p1, "x1"    # Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lco/vine/android/service/GCMNotificationService;->showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$800(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p1, "x1"    # Lco/vine/android/api/VineSingleNotification;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lco/vine/android/service/GCMNotificationService;->getNotificationId(Lco/vine/android/api/VineSingleNotification;)I

    move-result v0

    return v0
.end method

.method static synthetic access$900(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p1, "x1"    # Lco/vine/android/api/VineSingleNotification;
    .param p2, "x2"    # Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .prologue
    .line 57
    invoke-direct {p0, p1, p2}, Lco/vine/android/service/GCMNotificationService;->buildNotification(Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V

    return-void
.end method

.method private buildNotification(Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V
    .locals 18
    .param p1, "notification"    # Lco/vine/android/api/VineSingleNotification;
    .param p2, "event"    # Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .prologue
    .line 290
    new-instance v14, Landroid/support/v4/app/NotificationCompat$Builder;

    move-object/from16 v0, p0

    invoke-direct {v14, v0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p2

    iput-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    .line 295
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    const/4 v15, 0x1

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 296
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Notification - "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p2

    iget v15, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 297
    move-object/from16 v0, p2

    iget v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    const/4 v15, 0x1

    if-ne v14, v15, :cond_2

    .line 298
    new-instance v6, Landroid/content/Intent;

    const-string v14, "co.vine.android.ACTIVITY_NOTIFICATION_PRESSED"

    invoke-direct {v6, v14}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 299
    .local v6, "intent":Landroid/content/Intent;
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    move-object/from16 v0, p1

    iget-object v15, v0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 300
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Notification - "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p1

    iget-object v15, v0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 301
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    const v15, 0x7f0e0044

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lco/vine/android/service/GCMNotificationService;->getString(I)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setSubText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 306
    :goto_0
    const-class v14, Lco/vine/android/StartActivity;

    move-object/from16 v0, p0

    invoke-virtual {v6, v0, v14}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 308
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    const v15, 0x7f0201ff

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 310
    move-object/from16 v0, p2

    iget-object v12, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notifications:Ljava/util/ArrayList;

    .line 312
    .local v12, "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    if-nez v12, :cond_0

    .line 313
    new-instance v12, Ljava/util/ArrayList;

    .end local v12    # "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 316
    .restart local v12    # "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_0
    move-object/from16 v0, p2

    iget v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    const/4 v15, 0x2

    if-ne v14, v15, :cond_6

    .line 318
    move-object/from16 v0, p1

    iget-object v14, v0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    invoke-virtual {v14}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/util/image/ImageKey;

    .line 319
    .local v4, "imageKey":Lco/vine/android/util/image/ImageKey;
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    invoke-virtual {v14, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    if-nez v14, :cond_1

    .line 320
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    const/4 v15, 0x0

    invoke-static {v15}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v15

    invoke-virtual {v14, v4, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 321
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v14, v4}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v14

    if-eqz v14, :cond_1

    .line 322
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    const/4 v15, 0x1

    invoke-static {v15}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v15

    invoke-virtual {v14, v4, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 303
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "imageKey":Lco/vine/android/util/image/ImageKey;
    .end local v6    # "intent":Landroid/content/Intent;
    .end local v12    # "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_2
    new-instance v6, Landroid/content/Intent;

    const-string v14, "co.vine.android.MESSAGE_NOTIFICATION_PRESSED"

    invoke-direct {v6, v14}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .restart local v6    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 327
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v12    # "unclearedNotifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    :cond_3
    move-object/from16 v0, p1

    iget-object v14, v0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    invoke-virtual {v14}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lco/vine/android/util/video/VideoKey;

    .line 328
    .local v13, "videoKey":Lco/vine/android/util/video/VideoKey;
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    invoke-virtual {v14, v13}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    if-nez v14, :cond_4

    .line 329
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    const/4 v15, 0x0

    invoke-static {v15}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v15

    invoke-virtual {v14, v13, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 330
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v14, v13}, Lco/vine/android/client/AppController;->getVideoFilePath(Lco/vine/android/util/video/VideoKey;)Ljava/lang/String;

    move-result-object v14

    if-eqz v14, :cond_4

    .line 331
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    const/4 v15, 0x1

    invoke-static {v15}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v15

    invoke-virtual {v14, v13, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 337
    .end local v13    # "videoKey":Lco/vine/android/util/video/VideoKey;
    :cond_5
    move-object/from16 v0, p1

    iget v14, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    const/4 v15, 0x1

    if-le v14, v15, :cond_7

    .line 338
    const v14, 0x7f0e013f

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/Util;->getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    move-object/from16 v0, p1

    iget v0, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v15}, Lco/vine/android/service/GCMNotificationService;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 342
    .local v7, "message":Ljava/lang/String;
    :goto_3
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v14, v7}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 343
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Notification - "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 344
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    const v15, 0x7f0e013e

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lco/vine/android/service/GCMNotificationService;->getString(I)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setSubText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 348
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v7    # "message":Ljava/lang/String;
    :cond_6
    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v14

    const/4 v15, 0x1

    if-le v14, v15, :cond_c

    .line 349
    new-instance v5, Landroid/support/v4/app/NotificationCompat$InboxStyle;

    invoke-direct {v5}, Landroid/support/v4/app/NotificationCompat$InboxStyle;-><init>()V

    .line 350
    .local v5, "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    move-object/from16 v0, p2

    iget v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    const/4 v15, 0x1

    if-ne v14, v15, :cond_8

    .line 351
    const v14, 0x7f0e0043

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lco/vine/android/service/GCMNotificationService;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v5, v14}, Landroid/support/v4/app/NotificationCompat$InboxStyle;->setBigContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$InboxStyle;

    .line 355
    :goto_4
    invoke-virtual {v12}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_b

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lco/vine/android/api/VineSingleNotification;

    .line 357
    .local v11, "unclearedNotification":Lco/vine/android/api/VineSingleNotification;
    move-object/from16 v0, p2

    iget v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    const/4 v15, 0x2

    if-ne v14, v15, :cond_a

    .line 358
    move-object/from16 v0, p1

    iget v14, v0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    const/4 v15, 0x1

    if-le v14, v15, :cond_9

    .line 359
    const v14, 0x7f0e013f

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    iget-object v0, v11, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/Util;->getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    iget v0, v11, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v15}, Lco/vine/android/service/GCMNotificationService;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 366
    .restart local v7    # "message":Ljava/lang/String;
    :goto_6
    invoke-virtual {v5, v7}, Landroid/support/v4/app/NotificationCompat$InboxStyle;->addLine(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$InboxStyle;

    goto :goto_5

    .line 340
    .end local v5    # "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    .end local v7    # "message":Ljava/lang/String;
    .end local v11    # "unclearedNotification":Lco/vine/android/api/VineSingleNotification;
    :cond_7
    move-object/from16 v0, p1

    iget-object v14, v0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    invoke-static {v14}, Lco/vine/android/util/Util;->stripUsernameEntities(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .restart local v7    # "message":Ljava/lang/String;
    goto/16 :goto_3

    .line 353
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v7    # "message":Ljava/lang/String;
    .restart local v5    # "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    :cond_8
    const v14, 0x7f0e013d

    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lco/vine/android/service/GCMNotificationService;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v5, v14}, Landroid/support/v4/app/NotificationCompat$InboxStyle;->setBigContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$InboxStyle;

    goto :goto_4

    .line 361
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v11    # "unclearedNotification":Lco/vine/android/api/VineSingleNotification;
    :cond_9
    const v14, 0x7f0e0140

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    iget-object v0, v11, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/Util;->getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    iget v0, v11, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v15}, Lco/vine/android/service/GCMNotificationService;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .restart local v7    # "message":Ljava/lang/String;
    goto :goto_6

    .line 364
    .end local v7    # "message":Ljava/lang/String;
    :cond_a
    iget-object v7, v11, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .restart local v7    # "message":Ljava/lang/String;
    goto :goto_6

    .line 368
    .end local v7    # "message":Ljava/lang/String;
    .end local v11    # "unclearedNotification":Lco/vine/android/api/VineSingleNotification;
    :cond_b
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v14, v5}, Landroid/support/v4/app/NotificationCompat$Builder;->setStyle(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 369
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v15

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setNumber(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 372
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v5    # "inboxStyle":Landroid/support/v4/app/NotificationCompat$InboxStyle;
    :cond_c
    move-object/from16 v0, p2

    iget v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    const/4 v15, 0x2

    if-ne v14, v15, :cond_13

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v14

    const/4 v15, 0x1

    if-ne v14, v15, :cond_13

    .line 373
    const-string v14, "Notification - converstaion."

    invoke-static {v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 374
    move-object/from16 v0, p1

    iget-wide v14, v0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    invoke-static {v14, v15}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v14

    invoke-virtual {v6, v14}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 375
    const-string v14, "username"

    move-object/from16 v0, p1

    iget-object v15, v0, Lco/vine/android/api/VineSingleNotification;->username:Ljava/lang/String;

    invoke-virtual {v6, v14, v15}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 376
    const-string v14, "user_id"

    move-object/from16 v0, p1

    iget-wide v15, v0, Lco/vine/android/api/VineSingleNotification;->userId:J

    move-wide v0, v15

    invoke-virtual {v6, v14, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 377
    const-string v14, "am_following"

    move-object/from16 v0, p1

    iget v15, v0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    invoke-virtual {v6, v14, v15}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 383
    :goto_7
    invoke-static/range {p0 .. p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v10

    .line 384
    .local v10, "sp":Landroid/content/SharedPreferences;
    const/4 v2, 0x0

    .line 385
    .local v2, "defaults":I
    const-string v14, "pref_notifications_sound"

    const/4 v15, 0x1

    invoke-interface {v10, v14, v15}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v14

    if-eqz v14, :cond_d

    .line 386
    move-object/from16 v0, p2

    iget v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    const/4 v15, 0x2

    if-ne v14, v15, :cond_14

    .line 387
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    const v15, 0x7f060003

    move-object/from16 v0, p0

    invoke-static {v0, v15}, Lco/vine/android/util/Util;->getUriFromResouce(Landroid/content/Context;I)Landroid/net/Uri;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setSound(Landroid/net/Uri;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 398
    :cond_d
    :goto_8
    const-string v14, "pref_notifications_vibrate"

    const/4 v15, 0x0

    invoke-interface {v10, v14, v15}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v14

    if-eqz v14, :cond_e

    .line 399
    or-int/lit8 v2, v2, 0x2

    .line 401
    :cond_e
    const-string v14, "pref_notifications_light"

    const/4 v15, 0x1

    invoke-interface {v10, v14, v15}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v14

    if-eqz v14, :cond_f

    .line 402
    or-int/lit8 v2, v2, 0x4

    .line 404
    :cond_f
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v14, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setDefaults(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 406
    const/4 v14, 0x0

    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-static {v0, v14, v6, v15}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v8

    .line 408
    .local v8, "pendingIntent":Landroid/app/PendingIntent;
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v14, v8}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 409
    move-object/from16 v0, p1

    iget-object v14, v0, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    if-eqz v14, :cond_10

    .line 410
    new-instance v14, Lco/vine/android/util/image/ImageKey;

    move-object/from16 v0, p1

    iget-object v15, v0, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    const/16 v16, 0x1

    invoke-direct/range {v14 .. v16}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    move-object/from16 v0, p2

    iput-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 411
    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v0, p2

    iget-object v15, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {v14, v15}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v14

    move-object/from16 v0, p2

    iput-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    .line 413
    :cond_10
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    if-nez v14, :cond_11

    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    if-nez v14, :cond_12

    .line 414
    :cond_11
    const/4 v14, 0x0

    move-object/from16 v0, p2

    iput-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 415
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lco/vine/android/service/GCMNotificationService;->showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z

    .line 417
    :cond_12
    return-void

    .line 379
    .end local v2    # "defaults":I
    .end local v8    # "pendingIntent":Landroid/app/PendingIntent;
    .end local v10    # "sp":Landroid/content/SharedPreferences;
    :cond_13
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Notification - home - "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 390
    .restart local v2    # "defaults":I
    .restart local v10    # "sp":Landroid/content/SharedPreferences;
    :cond_14
    const-string v14, "pref_notifications_ringtone"

    const-string v15, ""

    invoke-interface {v10, v14, v15}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 391
    .local v9, "ringtonePath":Ljava/lang/String;
    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_15

    .line 392
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-static {v9}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/support/v4/app/NotificationCompat$Builder;->setSound(Landroid/net/Uri;)Landroid/support/v4/app/NotificationCompat$Builder;

    goto/16 :goto_8

    .line 394
    :cond_15
    or-int/lit8 v2, v2, 0x1

    goto/16 :goto_8
.end method

.method private clearNotification(I)V
    .locals 5
    .param p1, "notificationId"    # I

    .prologue
    .line 420
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Lco/vine/android/service/GCMNotificationService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 422
    .local v0, "manager":Landroid/app/NotificationManager;
    const-string v1, "gcmGenericNotification"

    invoke-virtual {v0, v1, p1}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 423
    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService;->mStopServiceRunnable:Ljava/lang/Runnable;

    const-wide/16 v3, 0x7d0

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 424
    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    const-wide/16 v2, -0x1

    invoke-virtual {v1, p1, v2, v3}, Lco/vine/android/client/AppController;->removeNotification(IJ)V

    .line 425
    return-void
.end method

.method public static getClearNotificationIntent(Landroid/content/Context;I)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "notificationId"    # I

    .prologue
    .line 483
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/GCMNotificationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 484
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "co.vine.android.notifications.ACTION_CLEAR_NOTIFICATIONS"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 485
    const-string v1, "notification_id"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 486
    return-object v0
.end method

.method private getNotificationId(Lco/vine/android/api/VineSingleNotification;)I
    .locals 1
    .param p1, "notification"    # Lco/vine/android/api/VineSingleNotification;

    .prologue
    .line 286
    invoke-virtual {p1}, Lco/vine/android/api/VineSingleNotification;->isMessaging()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x2

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static getUpdateNotificationIntent(Landroid/content/Context;IJ)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "notificationId"    # I
    .param p2, "conversationRowId"    # J

    .prologue
    .line 475
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/GCMNotificationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 476
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "co.vine.android.notifications.ACTION_UPDATE_NOTIFICATIONS"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 477
    const-string v1, "notification_id"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 478
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, p2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 479
    return-object v0
.end method

.method private notificationCommentToString(Lco/vine/android/api/VineSingleNotification;)Ljava/lang/String;
    .locals 5
    .param p1, "notification"    # Lco/vine/android/api/VineSingleNotification;

    .prologue
    .line 276
    iget-object v2, p1, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .line 277
    .local v2, "rawMessage":Ljava/lang/String;
    iget-object v0, p1, Lco/vine/android/api/VineSingleNotification;->entities:Ljava/util/ArrayList;

    .line 278
    .local v0, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 279
    .local v1, "message":Landroid/text/SpannableStringBuilder;
    if-eqz v0, :cond_0

    .line 280
    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v0, v1, v3, v4}, Lco/vine/android/util/Util;->adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V

    .line 282
    :cond_0
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method private prepareNotification(Ljava/lang/String;)V
    .locals 8
    .param p1, "notifications"    # Ljava/lang/String;

    .prologue
    const-wide/16 v6, 0x7d0

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 243
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 246
    :try_start_0
    invoke-static {p1}, Lco/vine/android/api/VineParsers;->createParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v1

    .line 247
    .local v1, "p":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-static {v1}, Lco/vine/android/api/VineParsers;->parsePushNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineSingleNotification;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 254
    .local v2, "vineNotification":Lco/vine/android/api/VineSingleNotification;
    if-nez v2, :cond_1

    .line 255
    const-string v3, "GCMNotifService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Invalid GCM notification payload, notifications="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    const-string v3, "Invalid GCM notification payload."

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 257
    iget-object v3, p0, Lco/vine/android/service/GCMNotificationService;->mHandler:Landroid/os/Handler;

    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService;->mStopServiceRunnable:Ljava/lang/Runnable;

    invoke-virtual {v3, v4, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 271
    :goto_0
    iget-object v3, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->fetchActivityCounts()Ljava/lang/String;

    .line 273
    .end local v1    # "p":Lcom/fasterxml/jackson/core/JsonParser;
    .end local v2    # "vineNotification":Lco/vine/android/api/VineSingleNotification;
    :cond_0
    :goto_1
    return-void

    .line 248
    :catch_0
    move-exception v0

    .line 249
    .local v0, "e":Ljava/io/IOException;
    const-string v3, "Exception while parsing GCM push notification payload."

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v0, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 250
    iget-object v3, p0, Lco/vine/android/service/GCMNotificationService;->mHandler:Landroid/os/Handler;

    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService;->mStopServiceRunnable:Ljava/lang/Runnable;

    invoke-virtual {v3, v4, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_1

    .line 259
    .end local v0    # "e":Ljava/io/IOException;
    .restart local v1    # "p":Lcom/fasterxml/jackson/core/JsonParser;
    .restart local v2    # "vineNotification":Lco/vine/android/api/VineSingleNotification;
    :cond_1
    iget-object v3, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->isLoggedInReadOnly()Z

    move-result v3

    if-nez v3, :cond_2

    .line 260
    const-string v3, "User not logged in, we should drop this message."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 262
    :cond_2
    invoke-virtual {v2}, Lco/vine/android/api/VineSingleNotification;->isMessaging()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 263
    iget-object v3, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3, v5, v4, v5}, Lco/vine/android/client/AppController;->fetchConversations(IZI)Ljava/lang/String;

    .line 265
    :cond_3
    iget-wide v3, v2, Lco/vine/android/api/VineSingleNotification;->recipientUserId:J

    iget-object v5, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v5}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    .line 266
    const-string v3, "This message is intended for someone else {}."

    iget-wide v4, v2, Lco/vine/android/api/VineSingleNotification;->recipientUserId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    .line 269
    :cond_4
    iget-object v3, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {p0, v2}, Lco/vine/android/service/GCMNotificationService;->notificationCommentToString(Lco/vine/android/api/VineSingleNotification;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Lco/vine/android/client/AppController;->mergePushNotification(Lco/vine/android/api/VineSingleNotification;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z
    .locals 9
    .param p1, "event"    # Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .prologue
    const/4 v4, 0x1

    .line 428
    invoke-virtual {p1}, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->isReady()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 429
    iget-object v5, p1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    if-nez v5, :cond_0

    .line 430
    invoke-virtual {p0}, Lco/vine/android/service/GCMNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f020198

    invoke-static {v5, v6}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v5

    iput-object v5, p1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    .line 432
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/service/GCMNotificationService;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0b0060

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 434
    .local v1, "l":I
    iget-object v5, p1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    invoke-static {v5, v1, v1, v4}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 436
    .local v0, "bm":Landroid/graphics/Bitmap;
    iget-object v5, p1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v5, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 438
    const-string v5, "notification"

    invoke-virtual {p0, v5}, Lco/vine/android/service/GCMNotificationService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/NotificationManager;

    .line 440
    .local v2, "manager":Landroid/app/NotificationManager;
    iget-object v5, p1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v5}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v3

    .line 441
    .local v3, "notification":Landroid/app/Notification;
    const v5, -0xff0100

    iput v5, v3, Landroid/app/Notification;->ledARGB:I

    .line 442
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->traceNotificationShown()V

    .line 444
    :try_start_0
    const-string v5, "gcmGenericNotification"

    iget v6, p1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    invoke-virtual {v2, v5, v6, v3}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 448
    :goto_0
    iget-object v5, p0, Lco/vine/android/service/GCMNotificationService;->mHandler:Landroid/os/Handler;

    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService;->mStopServiceRunnable:Ljava/lang/Runnable;

    const-wide/16 v7, 0x7d0

    invoke-virtual {v5, v6, v7, v8}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 451
    .end local v0    # "bm":Landroid/graphics/Bitmap;
    .end local v1    # "l":I
    .end local v2    # "manager":Landroid/app/NotificationManager;
    .end local v3    # "notification":Landroid/app/Notification;
    :goto_1
    return v4

    :cond_1
    const/4 v4, 0x0

    goto :goto_1

    .line 445
    .restart local v0    # "bm":Landroid/graphics/Bitmap;
    .restart local v1    # "l":I
    .restart local v2    # "manager":Landroid/app/NotificationManager;
    .restart local v3    # "notification":Landroid/app/Notification;
    :catch_0
    move-exception v5

    goto :goto_0
.end method

.method private stopService()V
    .locals 5

    .prologue
    .line 468
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService;->mStartIds:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 469
    .local v1, "startId":I
    const-string v2, "GCMNotifService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Stopping service for startId="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 470
    invoke-virtual {p0, v1}, Lco/vine/android/service/GCMNotificationService;->stopSelf(I)V

    goto :goto_0

    .line 472
    .end local v1    # "startId":I
    :cond_0
    return-void
.end method

.method private updateNotification(IJ)V
    .locals 1
    .param p1, "notificationId"    # I
    .param p2, "conversationRowId"    # J

    .prologue
    .line 229
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/client/AppController;->removeNotification(IJ)V

    .line 230
    return-void
.end method


# virtual methods
.method public getNotificationEvent(I)Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .locals 2
    .param p1, "notificationId"    # I

    .prologue
    .line 176
    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;

    invoke-virtual {v1, p1}, Lco/vine/android/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .line 177
    .local v0, "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    if-nez v0, :cond_0

    .line 178
    new-instance v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .end local v0    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    invoke-direct {v0, p1}, Lco/vine/android/service/GCMNotificationService$NotificationEvent;-><init>(I)V

    .line 179
    .restart local v0    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Lco/vine/android/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 181
    :cond_0
    return-object v0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 620
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 186
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 187
    const-string v0, "GCMNotifService"

    const-string v1, "Service created."

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    .line 189
    new-instance v0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;

    invoke-direct {v0, p0, v3}, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;-><init>(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$1;)V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 190
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->addListener(Lco/vine/android/client/AppSessionListener;)V

    .line 191
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mStartIds:Ljava/util/ArrayList;

    .line 192
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mHandler:Landroid/os/Handler;

    .line 193
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mConversationStateReciver:Landroid/content/BroadcastReceiver;

    sget-object v1, Lco/vine/android/service/GCMNotificationService;->sConversationStateFilter:Landroid/content/IntentFilter;

    const-string v2, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1, v2, v3}, Lco/vine/android/service/GCMNotificationService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 194
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/ResourceService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mCameraConnection:Landroid/content/ServiceConnection;

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lco/vine/android/service/GCMNotificationService;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 195
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 457
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 458
    iget-boolean v0, p0, Lco/vine/android/service/GCMNotificationService;->mIsCameraServiceConnected:Z

    if-eqz v0, :cond_0

    .line 459
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mCameraConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0}, Lco/vine/android/service/GCMNotificationService;->unbindService(Landroid/content/ServiceConnection;)V

    .line 461
    :cond_0
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mConversationStateReciver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/service/GCMNotificationService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 462
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v0, :cond_1

    .line 463
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->removeListener(Lco/vine/android/client/AppSessionListener;)V

    .line 465
    :cond_1
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x2

    .line 199
    const-string v2, "GCMNotifService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "onStartCommand, startId="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", startIds="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService;->mStartIds:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService;->mStartIds:Ljava/util/ArrayList;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 201
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService;->mHandler:Landroid/os/Handler;

    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 202
    if-eqz p1, :cond_0

    .line 203
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 204
    .local v0, "action":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 205
    invoke-direct {p0}, Lco/vine/android/service/GCMNotificationService;->stopService()V

    .line 225
    .end local v0    # "action":Ljava/lang/String;
    :cond_0
    :goto_0
    return v4

    .line 207
    .restart local v0    # "action":Ljava/lang/String;
    :cond_1
    const/4 v2, -0x1

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v5

    sparse-switch v5, :sswitch_data_0

    :cond_2
    :goto_1
    packed-switch v2, :pswitch_data_0

    .line 220
    invoke-direct {p0}, Lco/vine/android/service/GCMNotificationService;->stopService()V

    goto :goto_0

    .line 207
    :sswitch_0
    const-string v5, "co.vine.android.notifications.ACTION_CLEAR_NOTIFICATIONS"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    const/4 v2, 0x0

    goto :goto_1

    :sswitch_1
    const-string v5, "co.vine.android.notifications.ACTION_SHOW_NOTIFICATION"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    move v2, v3

    goto :goto_1

    :sswitch_2
    const-string v5, "co.vine.android.notifications.ACTION_UPDATE_NOTIFICATIONS"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    move v2, v4

    goto :goto_1

    .line 209
    :pswitch_0
    const-string v2, "notification_id"

    invoke-virtual {p1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    invoke-direct {p0, v2}, Lco/vine/android/service/GCMNotificationService;->clearNotification(I)V

    goto :goto_0

    .line 212
    :pswitch_1
    const-string v2, "notifications"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 213
    .local v1, "payload":Ljava/lang/String;
    invoke-direct {p0, v1}, Lco/vine/android/service/GCMNotificationService;->prepareNotification(Ljava/lang/String;)V

    goto :goto_0

    .line 216
    .end local v1    # "payload":Ljava/lang/String;
    :pswitch_2
    const-string v2, "notification_id"

    invoke-virtual {p1, v2, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    const-string v3, "conversation_row_id"

    const-wide/16 v5, -0x1

    invoke-virtual {p1, v3, v5, v6}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v5

    invoke-direct {p0, v2, v5, v6}, Lco/vine/android/service/GCMNotificationService;->updateNotification(IJ)V

    goto :goto_0

    .line 207
    :sswitch_data_0
    .sparse-switch
        -0x5a188df5 -> :sswitch_1
        -0x49108c0c -> :sswitch_2
        0x120601d4 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
