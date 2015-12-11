.class public Lcom/amazon/mShop/control/device/DeviceUpdateController;
.super Lcom/amazon/mShop/control/BaseController;
.source "DeviceUpdateController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponseListener;


# static fields
.field private static final lock:Ljava/lang/Object;


# instance fields
.field private mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

.field private mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

.field private mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->lock:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;Lcom/amazon/mShop/control/device/KiangSubscriber;)V
    .locals 2
    .param p1, "security"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;
    .param p2, "state"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;
    .param p3, "mSubscriber"    # Lcom/amazon/mShop/control/device/KiangSubscriber;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 36
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 37
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->setSecurity(Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;)V

    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->setApplicationState(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;)V

    .line 41
    iput-object p3, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceUpdateController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 21
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/device/DeviceUpdateController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceUpdateController;

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/device/DeviceUpdateController;)Lcom/amazon/mShop/control/device/KiangSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceUpdateController;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceUpdateController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 21
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/device/DeviceUpdateController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceUpdateController;

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->serviceCallCompleted()V

    return-void
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 59
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;-><init>(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 80
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 84
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;

    invoke-direct {v1, p0, p2}, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;-><init>(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->getDelayTime()I

    move-result v2

    int-to-long v2, v2

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 92
    return-void
.end method

.method public getDelayTime()I
    .locals 2

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    const v1, 0xea60

    mul-int/2addr v0, v1

    return v0
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->getSubscriber()Lcom/amazon/mShop/control/device/KiangSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/device/KiangSubscriber;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    return-object v0
.end method

.method public kiangUpdate()V
    .locals 6

    .prologue
    .line 45
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndAdd(I)I

    move-result v3

    const/4 v4, 0x3

    if-ge v3, v4, :cond_0

    .line 46
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    .line 47
    .local v2, "platform":Lcom/amazon/mShop/platform/Platform;
    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 48
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    sget-object v4, Lcom/amazon/mShop/control/device/DeviceUpdateController;->lock:Ljava/lang/Object;

    monitor-enter v4

    .line 49
    :try_start_0
    const-string/jumbo v3, "kiangUpdateSequenceNumber"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 50
    .local v1, "mKiangSequenceNumber":I
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->getApplicationState()Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

    move-result-object v3

    add-int/lit8 v5, v1, 0x1

    invoke-virtual {v3, v5}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->setSequenceNumber(I)V

    .line 51
    const-string/jumbo v3, "kiangUpdateSequenceNumber"

    add-int/lit8 v5, v1, 0x1

    invoke-interface {v0, v3, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 52
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 53
    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;

    invoke-interface {v3, v4, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->kiangUpdate(Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {p0, v3, v4}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 55
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v1    # "mKiangSequenceNumber":I
    .end local v2    # "platform":Lcom/amazon/mShop/platform/Platform;
    :cond_0
    return-void

    .line 52
    .restart local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .restart local v2    # "platform":Lcom/amazon/mShop/platform/Platform;
    :catchall_0
    move-exception v3

    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3
.end method
