.class public final Lcom/amazon/mShop/util/SisUtil;
.super Ljava/lang/Object;
.source "SisUtil.java"


# static fields
.field private static sHomeSubscriber:Lcom/amazon/mShop/control/home/HomeSubscriber;

.field private static final sIdentifyUserListener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

.field private static final sRegInfoListener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

.field private static sUserListener:Lcom/amazon/mShop/model/auth/UserListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 150
    new-instance v0, Lcom/amazon/mShop/util/SisUtil$3;

    invoke-direct {v0}, Lcom/amazon/mShop/util/SisUtil$3;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/SisUtil;->sRegInfoListener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    .line 164
    new-instance v0, Lcom/amazon/mShop/util/SisUtil$4;

    invoke-direct {v0}, Lcom/amazon/mShop/util/SisUtil$4;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/SisUtil;->sIdentifyUserListener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static identify()V
    .locals 0

    .prologue
    .line 146
    invoke-static {}, Lcom/amazon/mShop/util/SisUtil;->identifyDeviceAppIfNeeded()V

    .line 147
    invoke-static {}, Lcom/amazon/mShop/util/SisUtil;->identifyUserSessionIfNeeded()V

    .line 148
    return-void
.end method

.method public static identifyDeviceAppIfNeeded()V
    .locals 5

    .prologue
    .line 215
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 216
    .local v0, "appContext":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "referrerSource"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 217
    .local v2, "referrerSource":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 220
    invoke-static {v0, v2}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->setReferrer(Landroid/content/Context;Ljava/lang/String;)V

    .line 229
    :cond_0
    :goto_0
    const/4 v3, 0x1

    invoke-static {v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->enableTLS(Z)V

    .line 230
    invoke-static {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->registerApp(Landroid/content/Context;)V

    .line 231
    return-void

    .line 223
    :cond_1
    invoke-static {v0}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 224
    .local v1, "associatesTag":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 226
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "OEM-PRE-INSTALL: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->setReferrer(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static identifyUserSession(Ljava/util/Map;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 185
    .local p0, "deviceInfoParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 186
    .local v1, "deviceInfo":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 187
    .local v2, "deviceNativeData":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    invoke-static {}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->getDeviceNativeParams()Ljava/util/Map;

    move-result-object v3

    .line 188
    .local v3, "deviceNativeDataParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p0, :cond_0

    .line 189
    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 190
    .local v5, "mapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;-><init>()V

    .line 191
    .local v6, "pair":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->setKey(Ljava/lang/String;)V

    .line 192
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->setValue(Ljava/lang/String;)V

    .line 193
    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 196
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "mapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "pair":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    :cond_0
    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .restart local v4    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 197
    .restart local v5    # "mapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;-><init>()V

    .line 198
    .restart local v6    # "pair":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->setKey(Ljava/lang/String;)V

    .line 199
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v6, v7}, Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;->setValue(Ljava/lang/String;)V

    .line 200
    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 202
    .end local v5    # "mapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "pair":Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/control/sis/SisController;->getInstance()Lcom/amazon/mShop/control/sis/SisController;

    move-result-object v7

    invoke-virtual {v7, v1, v2}, Lcom/amazon/mShop/control/sis/SisController;->startIdentifyUserSessionWithSis(Ljava/util/List;Ljava/util/List;)V

    .line 207
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v7

    invoke-interface {v7}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 208
    .local v0, "appContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->updateLastIdentifyUserWithSISTime(Landroid/content/Context;)V

    .line 209
    return-void
.end method

.method public static identifyUserSessionIfNeeded()V
    .locals 2

    .prologue
    .line 176
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 177
    .local v0, "appContext":Landroid/content/Context;
    sget-object v1, Lcom/amazon/mShop/util/SisUtil;->sIdentifyUserListener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    .line 178
    return-void
.end method

.method public static identifyUserWhenRegInfoReady()V
    .locals 2

    .prologue
    .line 160
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 161
    .local v0, "appContext":Landroid/content/Context;
    sget-object v1, Lcom/amazon/mShop/util/SisUtil;->sRegInfoListener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    .line 162
    return-void
.end method

.method public static declared-synchronized reset(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    const-class v1, Lcom/amazon/mShop/util/SisUtil;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/control/sis/SisController;->clearInstance()V

    .line 77
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    sget-object v2, Lcom/amazon/mShop/util/SisUtil;->sHomeSubscriber:Lcom/amazon/mShop/control/home/HomeSubscriber;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/home/HomeController;->removeSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 80
    sget-object v0, Lcom/amazon/mShop/util/SisUtil;->sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 83
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/util/SisUtil;->sHomeSubscriber:Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 84
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/util/SisUtil;->sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    .line 88
    new-instance v0, Lcom/amazon/mShop/util/SisUtil$1;

    invoke-direct {v0}, Lcom/amazon/mShop/util/SisUtil$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/SisUtil;->sHomeSubscriber:Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 128
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    sget-object v2, Lcom/amazon/mShop/util/SisUtil;->sHomeSubscriber:Lcom/amazon/mShop/control/home/HomeSubscriber;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/home/HomeController;->addSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 130
    new-instance v0, Lcom/amazon/mShop/util/SisUtil$2;

    invoke-direct {v0}, Lcom/amazon/mShop/util/SisUtil$2;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/SisUtil;->sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    .line 142
    sget-object v0, Lcom/amazon/mShop/util/SisUtil;->sUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 143
    monitor-exit v1

    return-void

    .line 74
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
