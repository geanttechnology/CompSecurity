.class public Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;
.super Landroid/app/IntentService;
.source "DownloadsNotificationReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationBuilderService"
.end annotation


# static fields
.field private static action:Ljava/lang/String;

.field private static notificationBuilderMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Landroid/support/v4/app/NotificationCompat$Builder;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final deepLinkingScheme:Ljava/lang/String;

.field private final downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

.field private final programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private final volatileFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->notificationBuilderMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 81
    const-class v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 69
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVolatileDownloadableFileCache()Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->volatileFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    .line 70
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadableFileFactory()Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    .line 71
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 72
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 74
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createProgramDetailArtImageLoader()Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    .line 75
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDeepLinkingScheme()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->deepLinkingScheme:Ljava/lang/String;

    .line 76
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getNotificationQueueManager()Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    .line 82
    return-void
.end method

.method private buildBigPictureNotification(Landroid/app/PendingIntent;Landroid/content/res/Resources;Lcom/xfinity/playerlib/model/consumable/Watchable;Landroid/graphics/Bitmap;Landroid/support/v4/app/NotificationCompat$Builder;ILjava/lang/String;)Landroid/app/Notification;
    .locals 6
    .param p1, "contentIntent"    # Landroid/app/PendingIntent;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p4, "assetCoverBitmap"    # Landroid/graphics/Bitmap;
    .param p5, "notificationBuilder"    # Landroid/support/v4/app/NotificationCompat$Builder;
    .param p6, "notificationId"    # I
    .param p7, "notificationTag"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 364
    invoke-virtual {p5, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$drawable;->ic_stat:I

    .line 365
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->download_complete_notification:I

    new-array v2, v5, [Ljava/lang/Object;

    .line 366
    invoke-interface {p3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p2, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 367
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 368
    invoke-virtual {v0, v5}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 369
    invoke-interface {p3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->download_complete_subtext:I

    .line 370
    invoke-virtual {p2, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    new-instance v1, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;

    invoke-direct {v1}, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;-><init>()V

    .line 372
    invoke-virtual {v1, p4}, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;->bigPicture(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$BigPictureStyle;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->download_complete_subtext:I

    .line 373
    invoke-virtual {p2, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;->setSummaryText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigPictureStyle;

    move-result-object v1

    .line 374
    invoke-interface {p3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$BigPictureStyle;->setBigContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigPictureStyle;

    move-result-object v1

    .line 371
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setStyle(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    const-string v1, "Watch"

    .line 375
    invoke-direct {p0, p3, p6, p7}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createPlaybackPendingIntent(Lcom/xfinity/playerlib/model/consumable/Watchable;ILjava/lang/String;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-virtual {v0, v4, v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    const-string v1, "Manage Downloads"

    .line 376
    invoke-direct {p0, p6, p7}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createDownloadPendingIntent(ILjava/lang/String;)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-virtual {v0, v4, v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->addAction(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 377
    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method private cancelAllNotifications()V
    .locals 2

    .prologue
    .line 291
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 292
    .local v0, "manager":Landroid/app/NotificationManager;
    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 293
    return-void
.end method

.method private createDownloadIntent()Landroid/content/Intent;
    .locals 4

    .prologue
    .line 325
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.xfinity.playerlib.DOWNLOADS_NOTIFICATION"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 326
    .local v0, "intent":Landroid/content/Intent;
    new-instance v1, Landroid/content/ComponentName;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 327
    return-object v0
.end method

.method private createDownloadPendingIntent(ILjava/lang/String;)Landroid/app/PendingIntent;
    .locals 4
    .param p1, "notificationId"    # I
    .param p2, "notificationTag"    # Ljava/lang/String;

    .prologue
    .line 408
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.xfinity.playerlib.DOWNLOADS_NOTIFICATION.MANAGE_BUTTON"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 409
    .local v0, "intent":Landroid/content/Intent;
    new-instance v1, Landroid/content/ComponentName;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 410
    const-string v1, "EXTRA_NOTIFICATION_ID_TO_CANCEL"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 411
    const-string v1, "EXTRA_NOTIFICATION_TAG_TO_CANCEL"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 413
    const/4 v1, 0x2

    const/high16 v2, 0x8000000

    invoke-static {p0, v1, v0, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    return-object v1
.end method

.method private createEntityPendingIntent(Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/app/PendingIntent;
    .locals 3
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 381
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->deepLinkingScheme:Ljava/lang/String;

    .line 383
    invoke-interface {p1, v1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getEntityDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getIntentForDeeplinkUri(Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v1

    const/high16 v2, 0x8000000

    .line 381
    invoke-static {p0, v0, v1, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    return-object v0
.end method

.method public static createIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "broadcastIntent"    # Landroid/content/Intent;

    .prologue
    .line 85
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 86
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "BROADCAST_INTENT"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 87
    return-object v0
.end method

.method private createPlaybackPendingIntent(Lcom/xfinity/playerlib/model/consumable/Watchable;ILjava/lang/String;)Landroid/app/PendingIntent;
    .locals 3
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p2, "notificationId"    # I
    .param p3, "notificationTag"    # Ljava/lang/String;

    .prologue
    .line 388
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->deepLinkingScheme:Ljava/lang/String;

    .line 390
    invoke-interface {p1, v1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getPlaybackDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-direct {p0, v1, p2, p3}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getIntentForDeeplinkUri(Landroid/net/Uri;ILjava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    const/high16 v2, 0x8000000

    .line 388
    invoke-static {p0, v0, v1, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    return-object v0
.end method

.method private createSettingsIntent()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 331
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 332
    .local v0, "cellularDataIntent":Landroid/content/Intent;
    const-string v1, "resource"

    const-string v2, "use_cellular_prefs"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 333
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 334
    const/high16 v1, 0x20000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 335
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 336
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 337
    return-object v0
.end method

.method private getDownloadableFile(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .locals 4
    .param p1, "asset"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .prologue
    .line 342
    instance-of v2, p1, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    if-eqz v2, :cond_1

    .line 343
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v0

    .line 345
    .local v0, "cacheKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->volatileFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    monitor-enter v3

    .line 346
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->volatileFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-virtual {v2, v0}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 347
    .local v1, "playerDownloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-nez v1, :cond_0

    .line 348
    iget-object v2, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->downloadableFileFactory:Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    invoke-virtual {v2, p1}, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->create(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v1

    .line 349
    iget-object v2, p0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->volatileFileCache:Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-virtual {v2, v0, v1}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 353
    :goto_0
    monitor-exit v3

    .line 357
    .end local v0    # "cacheKey":Ljava/lang/String;
    .end local v1    # "playerDownloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :goto_1
    return-object v1

    .line 351
    .restart local v0    # "cacheKey":Ljava/lang/String;
    .restart local v1    # "playerDownloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->setAsset(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    goto :goto_0

    .line 353
    .end local v1    # "playerDownloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 357
    .end local v0    # "cacheKey":Ljava/lang/String;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private getIntentForDeeplinkUri(Landroid/net/Uri;)Landroid/content/Intent;
    .locals 2
    .param p1, "deeplinkUri"    # Landroid/net/Uri;

    .prologue
    .line 402
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 403
    .local v0, "uriIntent":Landroid/content/Intent;
    return-object v0
.end method

.method private getIntentForDeeplinkUri(Landroid/net/Uri;ILjava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p1, "deeplinkUri"    # Landroid/net/Uri;
    .param p2, "notificationId"    # I
    .param p3, "notificationTag"    # Ljava/lang/String;

    .prologue
    .line 395
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getIntentForDeeplinkUri(Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    .line 396
    .local v0, "uriIntent":Landroid/content/Intent;
    const-string v1, "EXTRA_NOTIFICATION_ID_TO_CANCEL"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 397
    const-string v1, "EXTRA_NOTIFICATION_TAG_TO_CANCEL"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 398
    return-object v0
.end method

.method private getProgressView(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;I)Landroid/widget/RemoteViews;
    .locals 11
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "numDownloads"    # I

    .prologue
    const/4 v7, 0x0

    const/4 v5, 0x1

    .line 296
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    .line 297
    .local v4, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 298
    .local v2, "resources":Landroid/content/res/Resources;
    new-instance v3, Landroid/widget/RemoteViews;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getPackageName()Ljava/lang/String;

    move-result-object v6

    sget v8, Lcom/xfinity/playerlib/R$layout;->progress_notification:I

    invoke-direct {v3, v6, v8}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 299
    .local v3, "view":Landroid/widget/RemoteViews;
    sget v6, Lcom/xfinity/playerlib/R$id;->downloadTitle:I

    sget v8, Lcom/xfinity/playerlib/R$string;->downloading_notification:I

    new-array v9, v5, [Ljava/lang/Object;

    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v7

    invoke-virtual {v2, v8, v9}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v6, v8}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 301
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPercentComplete()I

    move-result v6

    if-le v6, v5, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPercentComplete()I

    move-result v0

    .line 302
    .local v0, "percentComplete":I
    :goto_0
    sget v6, Lcom/xfinity/playerlib/R$id;->progressBar:I

    const/16 v8, 0x64

    invoke-virtual {v3, v6, v8, v0, v7}, Landroid/widget/RemoteViews;->setProgressBar(IIIZ)V

    .line 303
    sget v6, Lcom/xfinity/playerlib/R$id;->downloadSizeInfo:I

    sget v8, Lcom/xfinity/playerlib/R$string;->download_size_notification:I

    new-array v9, v5, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpectedFileSizeInMb()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v7

    invoke-virtual {v2, v8, v9}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v6, v8}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 304
    sget v8, Lcom/xfinity/playerlib/R$id;->progressBar:I

    const-string v9, "setEnabled"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v6

    invoke-interface {v6}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v6

    sget-object v10, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v6, v10, :cond_1

    move v6, v5

    :goto_1
    invoke-virtual {v3, v8, v9, v6}, Landroid/widget/RemoteViews;->setBoolean(ILjava/lang/String;Z)V

    .line 306
    if-le p2, v5, :cond_2

    .line 307
    sget v6, Lcom/xfinity/playerlib/R$id;->remainingDownloads:I

    invoke-virtual {v3, v6, v7}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 308
    add-int/lit8 v1, p2, -0x1

    .line 309
    .local v1, "remaining":I
    sget v6, Lcom/xfinity/playerlib/R$id;->remainingDownloads:I

    sget v8, Lcom/xfinity/playerlib/R$plurals;->downloads_in_queue_notification:I

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v5, v7

    invoke-virtual {v2, v8, v1, v5}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v6, v5}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 314
    .end local v1    # "remaining":I
    :goto_2
    return-object v3

    .end local v0    # "percentComplete":I
    :cond_0
    move v0, v5

    .line 301
    goto :goto_0

    .restart local v0    # "percentComplete":I
    :cond_1
    move v6, v7

    .line 304
    goto :goto_1

    .line 311
    :cond_2
    sget v5, Lcom/xfinity/playerlib/R$id;->remainingDownloads:I

    const/16 v6, 0x8

    invoke-virtual {v3, v5, v6}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    goto :goto_2
.end method

.method private showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V
    .locals 5
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "pIntent"    # Landroid/app/PendingIntent;

    .prologue
    const/4 v4, 0x1

    .line 417
    new-instance v2, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getBaseContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 418
    .local v2, "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    sget v3, Lcom/xfinity/playerlib/R$drawable;->ic_stat:I

    invoke-virtual {v2, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    .line 419
    invoke-virtual {v3, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    .line 420
    invoke-virtual {v3, p2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    .line 421
    invoke-virtual {v3, p3}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v1

    .line 423
    .local v1, "notification":Landroid/app/Notification;
    const-string v3, "notification"

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 424
    .local v0, "manager":Landroid/app/NotificationManager;
    const-string v3, "ProgressView"

    invoke-virtual {v0, v3, v4}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 425
    const-string v3, "ProgressView"

    invoke-virtual {v0, v3, v4, v1}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V

    .line 426
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 36
    .param p1, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 96
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v4

    if-nez v4, :cond_1

    .line 97
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->cancelAllNotifications()V

    .line 288
    :cond_0
    :goto_0
    return-void

    .line 101
    :cond_1
    const-string v4, "BROADCAST_INTENT"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v13

    check-cast v13, Landroid/content/Intent;

    .line 103
    .local v13, "broadcastIntent":Landroid/content/Intent;
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    if-eqz v4, :cond_3

    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    invoke-virtual {v13}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    const/16 v23, 0x1

    .line 104
    .local v23, "isNewAction":Z
    :goto_1
    invoke-virtual {v13}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    .line 106
    const-string v4, "notification"

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v25

    check-cast v25, Landroid/app/NotificationManager;

    .line 108
    .local v25, "manager":Landroid/app/NotificationManager;
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 109
    .local v6, "resources":Landroid/content/res/Resources;
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createDownloadIntent()Landroid/content/Intent;

    move-result-object v21

    .line 110
    .local v21, "intent":Landroid/content/Intent;
    const/4 v4, 0x0

    const/high16 v10, 0x8000000

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    invoke-static {v0, v4, v1, v10}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v28

    .line 112
    .local v28, "pIntent":Landroid/app/PendingIntent;
    invoke-virtual {v13}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v19

    .line 113
    .local v19, "extras":Landroid/os/Bundle;
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 115
    const-string v4, "notification_file"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v12

    check-cast v12, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 116
    .local v12, "asset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getDownloadableFile(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v14

    .line 117
    .local v14, "dlFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    const/4 v7, 0x0

    .line 118
    .local v7, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    if-eqz v14, :cond_2

    .line 119
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v7

    .line 122
    :cond_2
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    const-string v10, ".NOTIFICATION_DOWNLOAD_STOPPED"

    invoke-virtual {v4, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_16

    .line 123
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->values()[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v4

    const-string v10, "notification_engine_status_ordinal"

    move-object/from16 v0, v19

    invoke-virtual {v0, v10}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v10

    aget-object v15, v4, v10

    .line 124
    .local v15, "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->values()[Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-result-object v4

    const-string v10, "notification_engine_status_info_ordinal"

    move-object/from16 v0, v19

    invoke-virtual {v0, v10}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v10

    aget-object v16, v4, v10

    .line 126
    .local v16, "engineStatusInfo":Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
    const-string v4, "notification_num_queued_files"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v27

    .line 128
    .local v27, "numFilesInQueue":I
    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v15, v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_10

    .line 132
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedBattery:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 133
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->low_battery:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 134
    .local v18, "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_battery_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 172
    .local v17, "errorStatus":Ljava/lang/String;
    :goto_2
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v17

    move-object/from16 v3, v28

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V

    goto/16 :goto_0

    .line 103
    .end local v6    # "resources":Landroid/content/res/Resources;
    .end local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    .end local v12    # "asset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v14    # "dlFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v15    # "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .end local v16    # "engineStatusInfo":Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    .end local v19    # "extras":Landroid/os/Bundle;
    .end local v21    # "intent":Landroid/content/Intent;
    .end local v23    # "isNewAction":Z
    .end local v25    # "manager":Landroid/app/NotificationManager;
    .end local v27    # "numFilesInQueue":I
    .end local v28    # "pIntent":Landroid/app/PendingIntent;
    :cond_3
    const/16 v23, 0x0

    goto/16 :goto_1

    .line 135
    .restart local v6    # "resources":Landroid/content/res/Resources;
    .restart local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    .restart local v12    # "asset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .restart local v14    # "dlFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .restart local v15    # "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .restart local v16    # "engineStatusInfo":Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
    .restart local v19    # "extras":Landroid/os/Bundle;
    .restart local v21    # "intent":Landroid/content/Intent;
    .restart local v23    # "isNewAction":Z
    .restart local v25    # "manager":Landroid/app/NotificationManager;
    .restart local v27    # "numFilesInQueue":I
    .restart local v28    # "pIntent":Landroid/app/PendingIntent;
    :cond_4
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedCell:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 136
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v30

    check-cast v30, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 138
    .local v30, "theUser":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    if-eqz v30, :cond_5

    .line 139
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->data_not_enabled:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 140
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_no_wifi_or_cell_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 141
    .restart local v17    # "errorStatus":Ljava/lang/String;
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createSettingsIntent()Landroid/content/Intent;

    move-result-object v29

    .line 142
    .local v29, "settingsIntent":Landroid/content/Intent;
    const/4 v4, 0x0

    const/high16 v10, 0x8000000

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-static {v0, v4, v1, v10}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v28

    .line 143
    goto :goto_2

    .line 144
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    .end local v29    # "settingsIntent":Landroid/content/Intent;
    :cond_5
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->no_wifi:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 145
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_no_wifi_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto :goto_2

    .line 147
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    .end local v30    # "theUser":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    :cond_6
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedStorage:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 148
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->low_storage:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 149
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_storage_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto/16 :goto_2

    .line 150
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    :cond_7
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorNetwork:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_8

    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorsMaxed:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 151
    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 152
    :cond_8
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v4}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 153
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->bad_network:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 154
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v10, Lcom/xfinity/playerlib/R$string;->blocked_bad_network_notification:I

    const/4 v4, 0x1

    new-array v11, v4, [Ljava/lang/Object;

    const/16 v34, 0x0

    if-eqz v7, :cond_9

    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v4

    :goto_3
    aput-object v4, v11, v34

    invoke-virtual {v6, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto/16 :goto_2

    .end local v17    # "errorStatus":Ljava/lang/String;
    :cond_9
    const-string v4, ""

    goto :goto_3

    .line 156
    .end local v18    # "errorTitle":Ljava/lang/String;
    :cond_a
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->offline:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 157
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_offline_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto/16 :goto_2

    .line 159
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    :cond_b
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFile:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 160
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->sdcard:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 161
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_sdcard_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto/16 :goto_2

    .line 162
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    :cond_c
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EBlockedErrorHTTP:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_d

    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileExpectedSize:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 163
    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_d

    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFileMimeType:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    .line 164
    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_f

    .line 165
    :cond_d
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->http_error:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 166
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v10, Lcom/xfinity/playerlib/R$string;->blocked_http_error_notification:I

    const/4 v4, 0x1

    new-array v11, v4, [Ljava/lang/Object;

    const/16 v34, 0x0

    if-eqz v7, :cond_e

    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v4

    :goto_4
    aput-object v4, v11, v34

    invoke-virtual {v6, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto/16 :goto_2

    .end local v17    # "errorStatus":Ljava/lang/String;
    :cond_e
    const-string v4, ""

    goto :goto_4

    .line 168
    .end local v18    # "errorTitle":Ljava/lang/String;
    :cond_f
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->unknown:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    .line 169
    .restart local v18    # "errorTitle":Ljava/lang/String;
    sget v4, Lcom/xfinity/playerlib/R$string;->blocked_unknown_notification:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    .restart local v17    # "errorStatus":Ljava/lang/String;
    goto/16 :goto_2

    .line 173
    .end local v17    # "errorStatus":Ljava/lang/String;
    .end local v18    # "errorTitle":Ljava/lang/String;
    :cond_10
    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v15, v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_14

    .line 174
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorNetwork:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_11

    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorsMaxed:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_12

    .line 175
    :cond_11
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->offline:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->blocked_offline_notification:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v4, v10, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V

    goto/16 :goto_0

    .line 176
    :cond_12
    sget-object v4, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->EErrorFile:Lcom/penthera/virtuososdk/Common$EngineStatusInfo;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/penthera/virtuososdk/Common$EngineStatusInfo;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_13

    .line 177
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->sdcard:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->blocked_sdcard_notification:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v4, v10, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V

    goto/16 :goto_0

    .line 179
    :cond_13
    sget v4, Lcom/xfinity/playerlib/R$string;->error_notification_title:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    sget v34, Lcom/xfinity/playerlib/R$string;->unknown:I

    move/from16 v0, v34

    invoke-virtual {v6, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v34

    aput-object v34, v10, v11

    invoke-virtual {v6, v4, v10}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->blocked_unknown_notification:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v4, v10, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V

    goto/16 :goto_0

    .line 181
    :cond_14
    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v15, v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_15

    .line 182
    sget v4, Lcom/xfinity/playerlib/R$string;->paused_notification_title:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->paused_notification:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v4, v10, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V

    goto/16 :goto_0

    .line 183
    :cond_15
    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v15, v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 185
    if-nez v27, :cond_0

    .line 186
    const-string v4, "ProgressView"

    const/4 v10, 0x1

    move-object/from16 v0, v25

    invoke-virtual {v0, v4, v10}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 190
    .end local v15    # "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .end local v16    # "engineStatusInfo":Lcom/penthera/virtuososdk/Common$EngineStatusInfo;
    .end local v27    # "numFilesInQueue":I
    :cond_16
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    const-string v10, ".NOTIFICATION_DOWNLOADS_PAUSED"

    invoke-virtual {v4, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_17

    .line 191
    sget v4, Lcom/xfinity/playerlib/R$string;->paused_notification_title:I

    invoke-virtual {v6, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->paused_notification:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v4, v10, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->showDownloadEventNotification(Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;)V

    goto/16 :goto_0

    .line 195
    :cond_17
    if-eqz v7, :cond_0

    .line 196
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    const-string v10, ".NOTIFICATION_DOWNLOAD_COMPLETE"

    invoke-virtual {v4, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1d

    .line 197
    const-string v4, "ProgressView"

    const/4 v10, 0x1

    move-object/from16 v0, v25

    invoke-virtual {v0, v4, v10}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 199
    const/16 v22, 0x0

    .line 200
    .local v22, "isAdult":Z
    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v32

    .line 201
    .local v32, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-interface/range {v32 .. v32}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v24

    .line 202
    .local v24, "iter":Ljava/util/Iterator;
    :cond_18
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_19

    .line 203
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v31

    check-cast v31, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 204
    .local v31, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual/range {v31 .. v31}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isAdult()Z

    move-result v4

    if-eqz v4, :cond_18

    .line 205
    const/16 v22, 0x1

    .line 211
    .end local v31    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_19
    if-eqz v22, :cond_1a

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 213
    :cond_1a
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v10, 0x10

    if-ge v4, v10, :cond_1b

    .line 214
    const/4 v4, 0x0

    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createDownloadIntent()Landroid/content/Intent;

    move-result-object v10

    const/high16 v11, 0x8000000

    move-object/from16 v0, p0

    invoke-static {v0, v4, v10, v11}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    .line 220
    .local v5, "downloadedIntent":Landroid/app/PendingIntent;
    :goto_5
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->getBitmapFromCache(Lcom/xfinity/playerlib/model/MerlinId;)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 221
    .local v8, "assetCoverBitmap":Landroid/graphics/Bitmap;
    new-instance v9, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getBaseContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v9, v4}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 222
    .local v9, "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    if-eqz v8, :cond_1c

    .line 223
    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->id()I

    move-result v10

    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v4, p0

    invoke-direct/range {v4 .. v11}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->buildBigPictureNotification(Landroid/app/PendingIntent;Landroid/content/res/Resources;Lcom/xfinity/playerlib/model/consumable/Watchable;Landroid/graphics/Bitmap;Landroid/support/v4/app/NotificationCompat$Builder;ILjava/lang/String;)Landroid/app/Notification;

    move-result-object v26

    .line 236
    .local v26, "notification":Landroid/app/Notification;
    :goto_6
    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->id()I

    move-result v10

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v0, v4, v10, v1}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V

    .line 238
    if-eqz v22, :cond_0

    .line 239
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->id()I

    move-result v11

    invoke-virtual {v4, v10, v11}, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->registerAdultDownloadNotification(Ljava/lang/String;I)Z

    goto/16 :goto_0

    .line 216
    .end local v5    # "downloadedIntent":Landroid/app/PendingIntent;
    .end local v8    # "assetCoverBitmap":Landroid/graphics/Bitmap;
    .end local v9    # "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    .end local v26    # "notification":Landroid/app/Notification;
    :cond_1b
    move-object/from16 v0, p0

    invoke-direct {v0, v7}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->createEntityPendingIntent(Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/app/PendingIntent;

    move-result-object v5

    .restart local v5    # "downloadedIntent":Landroid/app/PendingIntent;
    goto :goto_5

    .line 225
    .restart local v8    # "assetCoverBitmap":Landroid/graphics/Bitmap;
    .restart local v9    # "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    :cond_1c
    invoke-virtual {v9, v5}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$drawable;->ic_stat:I

    .line 226
    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->download_complete_notification:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/16 v34, 0x0

    .line 227
    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v35

    aput-object v35, v11, v34

    invoke-virtual {v6, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 228
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-virtual {v4, v10, v11}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    const/4 v10, 0x1

    .line 229
    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 230
    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->download_complete_subtext:I

    .line 231
    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 232
    invoke-virtual {v4}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v26

    .restart local v26    # "notification":Landroid/app/Notification;
    goto :goto_6

    .line 242
    .end local v5    # "downloadedIntent":Landroid/app/PendingIntent;
    .end local v8    # "assetCoverBitmap":Landroid/graphics/Bitmap;
    .end local v9    # "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    .end local v22    # "isAdult":Z
    .end local v24    # "iter":Ljava/util/Iterator;
    .end local v26    # "notification":Landroid/app/Notification;
    .end local v32    # "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    :cond_1d
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    const-string v10, ".NOTIFICATION_DOWNLOAD_START"

    invoke-virtual {v4, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1e

    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    const-string v10, ".NOTIFICATION_DOWNLOAD_UPDATE"

    invoke-virtual {v4, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 243
    :cond_1e
    const-string v4, "notification_num_queued_files"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v27

    .line 245
    .restart local v27    # "numFilesInQueue":I
    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-direct {v0, v14, v1}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getProgressView(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;I)Landroid/widget/RemoteViews;

    move-result-object v33

    .line 247
    .local v33, "view":Landroid/widget/RemoteViews;
    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v20

    .line 249
    .local v20, "idOfFile":Lcom/xfinity/playerlib/model/MerlinId;
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->action:Ljava/lang/String;

    const-string v10, ".NOTIFICATION_DOWNLOAD_START"

    invoke-virtual {v4, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_21

    .line 250
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v10

    invoke-virtual {v4, v10}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->preCacheDrawable(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 255
    :cond_1f
    # setter for: Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->prevId:Lcom/xfinity/playerlib/model/MerlinId;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->access$002(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/MerlinId;

    .line 258
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->notificationBuilderMap:Ljava/util/Map;

    move-object/from16 v0, v20

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_22

    .line 259
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->notificationBuilderMap:Ljava/util/Map;

    move-object/from16 v0, v20

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/support/v4/app/NotificationCompat$Builder;

    .line 275
    .restart local v9    # "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    :goto_7
    move-object/from16 v0, v33

    invoke-virtual {v9, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContent(Landroid/widget/RemoteViews;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 276
    move-object/from16 v0, v28

    invoke-virtual {v9, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 278
    invoke-virtual {v9}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v26

    .line 279
    .restart local v26    # "notification":Landroid/app/Notification;
    move-object/from16 v0, v33

    move-object/from16 v1, v26

    iput-object v0, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 281
    if-eqz v23, :cond_20

    .line 282
    const-string v4, "ProgressView"

    const/4 v10, 0x1

    move-object/from16 v0, v25

    invoke-virtual {v0, v4, v10}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 285
    :cond_20
    const-string v4, "ProgressView"

    const/4 v10, 0x1

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v0, v4, v10, v1}, Landroid/app/NotificationManager;->notify(Ljava/lang/String;ILandroid/app/Notification;)V

    goto/16 :goto_0

    .line 251
    .end local v9    # "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    .end local v26    # "notification":Landroid/app/Notification;
    :cond_21
    # getter for: Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->prevId:Lcom/xfinity/playerlib/model/MerlinId;
    invoke-static {}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->access$000()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    if-eqz v4, :cond_1f

    # getter for: Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->prevId:Lcom/xfinity/playerlib/model/MerlinId;
    invoke-static {}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver;->access$000()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1f

    goto/16 :goto_0

    .line 261
    :cond_22
    new-instance v9, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->getBaseContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v9, v4}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 262
    .restart local v9    # "notificationBuilder":Landroid/support/v4/app/NotificationCompat$Builder;
    sget-object v4, Lcom/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService;->notificationBuilderMap:Ljava/util/Map;

    move-object/from16 v0, v20

    invoke-interface {v4, v0, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    const/4 v4, 0x1

    .line 264
    invoke-virtual {v9, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 265
    move-object/from16 v0, v28

    invoke-virtual {v4, v0}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    .line 266
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-virtual {v4, v10, v11}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$drawable;->ic_stat:I

    .line 267
    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    sget v10, Lcom/xfinity/playerlib/R$string;->downloading_notification:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/16 v34, 0x0

    .line 268
    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v35

    aput-object v35, v11, v34

    invoke-virtual {v6, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v4

    const/4 v10, 0x1

    .line 269
    invoke-virtual {v4, v10}, Landroid/support/v4/app/NotificationCompat$Builder;->setOnlyAlertOnce(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    goto :goto_7
.end method
