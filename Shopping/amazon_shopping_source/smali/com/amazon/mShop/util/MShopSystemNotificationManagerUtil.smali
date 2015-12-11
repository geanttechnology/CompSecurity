.class public Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;
.super Ljava/lang/Object;
.source "MShopSystemNotificationManagerUtil.java"


# static fields
.field public static final TAG:Ljava/lang/String;

.field public static sNotificationId:I

.field private static sNotificationMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->TAG:Ljava/lang/String;

    .line 25
    const/4 v0, 0x0

    sput v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->sNotificationId:I

    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->sNotificationMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getNextUniqueNotificationId()I
    .locals 2

    .prologue
    .line 71
    const-class v1, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;

    monitor-enter v1

    :try_start_0
    sget v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->sNotificationId:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->sNotificationId:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static newNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;Landroid/support/v4/app/NotificationCompat$Style;II)Landroid/app/Notification;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/String;
    .param p2, "contentMessage"    # Ljava/lang/String;
    .param p3, "tickerText"    # Ljava/lang/String;
    .param p4, "contentIntent"    # Landroid/app/PendingIntent;
    .param p5, "deleteIntent"    # Landroid/app/PendingIntent;
    .param p6, "style"    # Landroid/support/v4/app/NotificationCompat$Style;
    .param p7, "smallIconResourceId"    # I
    .param p8, "largeIconResourceId"    # I

    .prologue
    .line 118
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 120
    .local v2, "when":J
    new-instance v1, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v1, p0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 122
    .local v1, "builder":Landroid/support/v4/app/NotificationCompat$Builder;
    if-eqz p1, :cond_0

    .line 123
    invoke-virtual {v1, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 126
    :cond_0
    if-eqz p2, :cond_1

    .line 127
    invoke-virtual {v1, p2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 130
    :cond_1
    if-eqz p3, :cond_2

    .line 131
    invoke-virtual {v1, p3}, Landroid/support/v4/app/NotificationCompat$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 134
    :cond_2
    if-eqz p4, :cond_3

    .line 135
    invoke-virtual {v1, p4}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 138
    :cond_3
    if-eqz p5, :cond_4

    .line 139
    invoke-virtual {v1, p5}, Landroid/support/v4/app/NotificationCompat$Builder;->setDeleteIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 142
    :cond_4
    if-eqz p6, :cond_5

    .line 143
    invoke-virtual {v1, p6}, Landroid/support/v4/app/NotificationCompat$Builder;->setStyle(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 145
    :cond_5
    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 146
    invoke-virtual {v1, p7}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 148
    if-eqz p8, :cond_6

    .line 149
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, p8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .line 150
    .local v0, "bitmapDrawable":Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 153
    .end local v0    # "bitmapDrawable":Landroid/graphics/drawable/BitmapDrawable;
    :cond_6
    invoke-virtual {v1}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v4

    return-object v4
.end method

.method public static notifyToSystem(ILandroid/app/Notification;Landroid/content/Context;)V
    .locals 2
    .param p0, "notificationID"    # I
    .param p1, "notification"    # Landroid/app/Notification;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    const-string/jumbo v1, "notification"

    invoke-virtual {p2, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 61
    .local v0, "notificationManager":Landroid/app/NotificationManager;
    invoke-virtual {v0, p0, p1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 62
    return-void
.end method

.method public static notifyToSystem(Landroid/app/Notification;Landroid/content/Context;)V
    .locals 1
    .param p0, "notification"    # Landroid/app/Notification;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    invoke-static {}, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->getNextUniqueNotificationId()I

    move-result v0

    invoke-static {v0, p0, p1}, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->notifyToSystem(ILandroid/app/Notification;Landroid/content/Context;)V

    .line 56
    return-void
.end method

.method public static declared-synchronized removeStackedNotifications(Ljava/lang/String;)V
    .locals 2
    .param p0, "notificationType"    # Ljava/lang/String;

    .prologue
    .line 38
    const-class v1, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->sNotificationMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 39
    monitor-exit v1

    return-void

    .line 38
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
