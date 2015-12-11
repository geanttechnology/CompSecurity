.class public Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;
.super Ljava/lang/Object;
.source "NotificationProviderFactory.java"


# static fields
.field private static sInstance:Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;
    .locals 2

    .prologue
    .line 13
    const-class v1, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;->sInstance:Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;

    if-nez v0, :cond_0

    .line 14
    new-instance v0, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;

    invoke-direct {v0}, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;-><init>()V

    sput-object v0, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;->sInstance:Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;

    .line 16
    :cond_0
    sget-object v0, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;->sInstance:Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 13
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public newNotificationProvider()Lcom/amazon/mShop/pushnotification/NotificationProvider;
    .locals 2

    .prologue
    .line 20
    const-string/jumbo v0, "zh_CN"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21
    new-instance v0, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;

    invoke-direct {v0}, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;-><init>()V

    .line 23
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;

    invoke-direct {v0}, Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;-><init>()V

    goto :goto_0
.end method
