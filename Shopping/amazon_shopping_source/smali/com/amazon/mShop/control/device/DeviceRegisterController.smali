.class public Lcom/amazon/mShop/control/device/DeviceRegisterController;
.super Lcom/amazon/mShop/control/BaseController;
.source "DeviceRegisterController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponseListener;


# instance fields
.field private mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

.field private mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

.field private mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;Lcom/amazon/mShop/control/device/KiangSubscriber;)V
    .locals 2
    .param p1, "appinfo"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
    .param p2, "appInstanceInfo"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;
    .param p3, "pushInfo"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    .param p4, "mSubscriber"    # Lcom/amazon/mShop/control/device/KiangSubscriber;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 35
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 36
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->setApplicationInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;)V

    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

    invoke-virtual {v0, p2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->setApplicationInstanceInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;)V

    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

    invoke-virtual {v0, p3}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;->setPushInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;)V

    .line 41
    iput-object p4, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceRegisterController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 18
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/device/DeviceRegisterController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceRegisterController;

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/device/DeviceRegisterController;)Lcom/amazon/mShop/control/device/KiangSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceRegisterController;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceRegisterController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 18
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/device/DeviceRegisterController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/device/DeviceRegisterController;

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->serviceCallCompleted()V

    return-void
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 55
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;-><init>(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 90
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 95
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;

    invoke-direct {v1, p0, p2}, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;-><init>(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->getDelayTime()I

    move-result v2

    int-to-long v2, v2

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 105
    return-void
.end method

.method public getDelayTime()I
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    const v1, 0xea60

    mul-int/2addr v0, v1

    return v0
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->getSubscriber()Lcom/amazon/mShop/control/device/KiangSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/device/KiangSubscriber;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    return-object v0
.end method

.method public kiangRegister()V
    .locals 3

    .prologue
    .line 45
    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRetryCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndAdd(I)I

    move-result v1

    const/4 v2, 0x3

    if-ge v1, v2, :cond_0

    .line 46
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    .line 47
    .local v0, "platform":Lcom/amazon/mShop/platform/Platform;
    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mRequest:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;

    invoke-interface {v1, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->kiangRegister(Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 51
    .end local v0    # "platform":Lcom/amazon/mShop/platform/Platform;
    :goto_0
    return-void

    .line 49
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;

    invoke-interface {v1}, Lcom/amazon/mShop/control/device/KiangSubscriber;->onRegisterError()V

    goto :goto_0
.end method
