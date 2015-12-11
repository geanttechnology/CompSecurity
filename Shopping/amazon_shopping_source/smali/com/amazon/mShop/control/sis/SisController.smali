.class public Lcom/amazon/mShop/control/sis/SisController;
.super Ljava/lang/Object;
.source "SisController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponseListener;


# static fields
.field private static final logger:Lcom/amazon/rio/j2me/client/util/Logger;

.field private static sInstance:Lcom/amazon/mShop/control/sis/SisController;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 23
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    const-class v1, Lcom/amazon/mShop/control/sis/SisController;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->getLogger(Ljava/lang/Class;)Lcom/amazon/rio/j2me/client/util/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/control/sis/SisController;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized clearInstance()V
    .locals 2

    .prologue
    .line 37
    const-class v0, Lcom/amazon/mShop/control/sis/SisController;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    sput-object v1, Lcom/amazon/mShop/control/sis/SisController;->sInstance:Lcom/amazon/mShop/control/sis/SisController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 38
    monitor-exit v0

    return-void

    .line 37
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/control/sis/SisController;
    .locals 2

    .prologue
    .line 30
    const-class v1, Lcom/amazon/mShop/control/sis/SisController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/control/sis/SisController;->sInstance:Lcom/amazon/mShop/control/sis/SisController;

    if-nez v0, :cond_0

    .line 31
    new-instance v0, Lcom/amazon/mShop/control/sis/SisController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/sis/SisController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/sis/SisController;->sInstance:Lcom/amazon/mShop/control/sis/SisController;

    .line 33
    :cond_0
    sget-object v0, Lcom/amazon/mShop/control/sis/SisController;->sInstance:Lcom/amazon/mShop/control/sis/SisController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 30
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 48
    sget-object v0, Lcom/amazon/mShop/control/sis/SisController;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    const-string/jumbo v1, "SIS call cancelled"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/util/Logger;->info(Ljava/lang/String;)V

    .line 49
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 54
    sget-object v0, Lcom/amazon/mShop/control/sis/SisController;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "SIS call completed: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/util/Logger;->info(Ljava/lang/String;)V

    .line 55
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 42
    sget-object v0, Lcom/amazon/mShop/control/sis/SisController;->logger:Lcom/amazon/rio/j2me/client/util/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "SIS call Exception: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/util/Logger;->error(Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method public startIdentifyUserSessionWithSis(Ljava/util/List;Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p1, "deviceInfo":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    .local p2, "deviceNativeData":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;-><init>()V

    .line 60
    .local v0, "sisRequest":Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, p1}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;->setDeviceInfo(Ljava/util/List;)V

    .line 61
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1, p2}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;->setDeviceNativeData(Ljava/util/List;)V

    .line 62
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->identifyUserWithSis(Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 63
    return-void
.end method
