.class public Lcom/amazon/mShop/control/account/OneClickController;
.super Lcom/amazon/mShop/control/BaseController;
.source "OneClickController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigResponseListener;
.implements Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigResponseListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
    }
.end annotation


# static fields
.field private static oneClickAutoActivationState:I

.field private static final sOneClickListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/account/OneClickListener;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mRequestId:Ljava/lang/String;

.field private oneClickAddresses:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;"
        }
    .end annotation
.end field

.field private oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

.field private selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

.field private selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

.field private final subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

.field private userSelectedDeviceName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 159
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/account/OneClickController;->sOneClickListeners:Ljava/util/List;

    .line 638
    const/4 v0, -0x1

    sput v0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;)V
    .locals 0
    .param p1, "accountSubscriber"    # Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    .prologue
    .line 176
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 177
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    .line 178
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/account/OneClickController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$1000()Ljava/util/List;
    .locals 1

    .prologue
    .line 114
    sget-object v0, Lcom/amazon/mShop/control/account/OneClickController;->sOneClickListeners:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    .prologue
    .line 114
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickConfigResponse(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/account/OneClickController;)Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/account/OneClickController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/mShop/control/account/OneClickController;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 114
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickAddresses(Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/account/OneClickController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;

    .prologue
    .line 114
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$900(Lcom/amazon/mShop/control/account/OneClickController;Ljava/lang/Boolean;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/OneClickController;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 114
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickStatusEnabled(Ljava/lang/Boolean;)V

    return-void
.end method

.method public static getDefaultDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 352
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDeviceName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getOneClickAutoActivationState()I
    .locals 3

    .prologue
    .line 641
    const/4 v1, -0x1

    sget v2, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    if-ne v1, v2, :cond_0

    .line 642
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 647
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "oneClickAutoSetupState"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v1

    sput v1, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    .line 649
    :cond_0
    sget v1, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    return v1
.end method

.method public static isOneClickNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)Z
    .locals 2
    .param p0, "notification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 618
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getType()I

    move-result v0

    .line 619
    .local v0, "type":I
    const/4 v1, 0x3

    if-eq v1, v0, :cond_0

    const/4 v1, 0x4

    if-ne v1, v0, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static setDidAttemptAutoActivationOnFirstSignIn(Z)V
    .locals 1
    .param p0, "succeeded"    # Z

    .prologue
    .line 689
    if-eqz p0, :cond_0

    .line 690
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickAutoActivationState(I)V

    .line 694
    :goto_0
    return-void

    .line 692
    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickAutoActivationState(I)V

    goto :goto_0
.end method

.method private declared-synchronized setOneClickAddresses(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 406
    .local p1, "addresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAddresses:Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 407
    monitor-exit p0

    return-void

    .line 406
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private static setOneClickAutoActivationState(I)V
    .locals 3
    .param p0, "newActivationState"    # I

    .prologue
    .line 653
    sget v1, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    if-eq p0, v1, :cond_0

    .line 654
    sput p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    .line 655
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 656
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "oneClickAutoSetupState"

    sget v2, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAutoActivationState:I

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 658
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    return-void
.end method

.method private declared-synchronized setOneClickConfigResponse(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
    .locals 1
    .param p1, "config"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    .prologue
    .line 300
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    .line 301
    if-eqz p1, :cond_0

    .line 302
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getOneClickStatus()Z

    move-result v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->setOneClickEnabled(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 304
    :cond_0
    monitor-exit p0

    return-void

    .line 300
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized setOneClickStatusEnabled(Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 391
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    if-eqz v0, :cond_0

    .line 392
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->setOneClickStatus(Z)V

    .line 393
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->setOneClickEnabled(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 394
    monitor-exit p0

    return-void

    .line 391
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static shouldAttempAutoActivationOnSignIn()Z
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 675
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v1

    .line 676
    .local v1, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 679
    :cond_0
    :goto_0
    return v2

    .line 678
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->getOneClickAutoActivationState()I

    move-result v0

    .line 679
    .local v0, "state":I
    if-nez v0, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 543
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/OneClickController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/OneClickController$1;-><init>(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 560
    return-void
.end method

.method public completed(Ljava/lang/Boolean;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/Boolean;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 592
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/OneClickController$3;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/OneClickController$3;-><init>(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Boolean;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 608
    return-void
.end method

.method public completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 570
    .local p1, "value":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/OneClickController$2;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/OneClickController$2;-><init>(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 582
    return-void
.end method

.method public declared-synchronized doGetOneClickAddresses(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 4
    .param p1, "loadingTaskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 250
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getOneClickAddresses()Ljava/util/List;

    move-result-object v0

    .line 251
    .local v0, "currentOneClickAddresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    if-eqz v0, :cond_0

    .line 253
    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    invoke-interface {v1, v0}, Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;->onReceiveOneClickAddresses(Ljava/util/List;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 261
    :goto_0
    monitor-exit p0

    return-void

    .line 257
    :cond_0
    :try_start_1
    const-string/jumbo v1, "get_one_click_addresses_v21"

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 258
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/Null;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Null;-><init>()V

    invoke-interface {v1, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getOneClickAddresses(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p1}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 250
    .end local v0    # "currentOneClickAddresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized doGetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "loadingTaskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 196
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    .line 197
    const-string/jumbo v0, "get_one_click_config_v21"

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 198
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/Null;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Null;-><init>()V

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 199
    monitor-exit p0

    return-void

    .line 196
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized doSetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 11
    .param p1, "savingTaskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 213
    monitor-enter p0

    const/4 v8, 0x2

    :try_start_0
    invoke-static {v8}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickAutoActivationState(I)V

    .line 215
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getDeviceName()Ljava/lang/String;

    move-result-object v2

    .line 216
    .local v2, "deviceName":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 217
    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->getDefaultDeviceName()Ljava/lang/String;

    move-result-object v2

    .line 219
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getSelectedOneClickAddress()Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    move-result-object v3

    .line 220
    .local v3, "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v0

    .line 221
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddressId()Ljava/lang/String;

    move-result-object v1

    .line 223
    .local v1, "addressId":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getSelectedPaymentMethod()Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    move-result-object v6

    .line 224
    .local v6, "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getCardId()Ljava/lang/String;

    move-result-object v5

    .line 226
    .local v5, "paymentId":Ljava/lang/String;
    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 228
    .local v4, "oneClickStatus":Ljava/lang/Boolean;
    new-instance v7, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;

    invoke-direct {v7}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;-><init>()V

    .line 230
    .local v7, "request":Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;
    invoke-virtual {v7, v2}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->setDeviceName(Ljava/lang/String;)V

    .line 231
    invoke-virtual {v7, v1}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->setAddressId(Ljava/lang/String;)V

    .line 232
    invoke-virtual {v7, v5}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->setPaymentId(Ljava/lang/String;)V

    .line 233
    invoke-virtual {v7, v4}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;->setOneClickStatus(Ljava/lang/Boolean;)V

    .line 236
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    .line 237
    const-string/jumbo v8, "set_one_click_config_v21"

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    invoke-static {v8, v9, v10}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 238
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v8

    invoke-interface {v8, v7, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->setOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v8

    invoke-virtual {p0, v8, p1}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 240
    monitor-exit p0

    return-void

    .line 213
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v1    # "addressId":Ljava/lang/String;
    .end local v2    # "deviceName":Ljava/lang/String;
    .end local v3    # "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    .end local v4    # "oneClickStatus":Ljava/lang/Boolean;
    .end local v5    # "paymentId":Ljava/lang/String;
    .end local v6    # "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    .end local v7    # "request":Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8
.end method

.method public declared-synchronized doSetOneClickEnabled(ZLcom/amazon/mShop/control/TaskCallback;)V
    .locals 4
    .param p1, "enabled"    # Z
    .param p2, "savingTaskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 272
    monitor-enter p0

    const/4 v1, 0x2

    :try_start_0
    invoke-static {v1}, Lcom/amazon/mShop/control/account/OneClickController;->setOneClickAutoActivationState(I)V

    .line 274
    if-eqz p1, :cond_0

    .line 275
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getDeviceName()Ljava/lang/String;

    move-result-object v0

    .line 278
    .local v0, "deviceName":Ljava/lang/String;
    const-string/jumbo v1, "enable_one_click_v1"

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 279
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->enableOneClick(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 288
    .end local v0    # "deviceName":Ljava/lang/String;
    :goto_0
    monitor-exit p0

    return-void

    .line 284
    :cond_0
    :try_start_1
    const-string/jumbo v1, "disable_one_click_v1"

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController;->mRequestId:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 285
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    new-instance v2, Lcom/amazon/rio/j2me/client/services/mShop/Null;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Null;-><init>()V

    invoke-interface {v1, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->disableOneClick(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lcom/amazon/mShop/control/account/OneClickController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 272
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 324
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->userSelectedDeviceName:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 325
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->userSelectedDeviceName:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 330
    :goto_0
    monitor-exit p0

    return-object v0

    .line 327
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getDeviceName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 328
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getDeviceName()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    .line 330
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 324
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getOneClickAddresses()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;"
        }
    .end annotation

    .prologue
    .line 402
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAddresses:Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getOneClickConfigResponse()Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
    .locals 1

    .prologue
    .line 296
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getSelectedOneClickAddress()Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    .locals 6

    .prologue
    .line 419
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    if-eqz v4, :cond_0

    .line 420
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .line 433
    :goto_0
    return-object v4

    .line 421
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAddresses:Ljava/util/List;

    if-eqz v4, :cond_3

    .line 422
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v0

    .line 423
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    if-nez v0, :cond_1

    .line 424
    const/4 v4, 0x0

    goto :goto_0

    .line 425
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickAddresses:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .line 426
    .local v3, "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v1

    .line 427
    .local v1, "anAddress":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddressId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddressId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 428
    iput-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .line 433
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v1    # "anAddress":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    goto :goto_0
.end method

.method public getSelectedPaymentMethod()Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    .locals 6

    .prologue
    .line 487
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    if-eqz v4, :cond_0

    .line 488
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 522
    :goto_0
    return-object v4

    .line 490
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    if-eqz v4, :cond_2

    .line 494
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getSelectedOneClickAddress()Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    move-result-object v1

    .line 500
    .local v1, "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    if-eqz v1, :cond_2

    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v4

    if-eqz v4, :cond_2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddressId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getAddressId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 506
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getPaymentMethod()Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    move-result-object v3

    .line 508
    .local v3, "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    if-eqz v3, :cond_2

    .line 513
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getPaymentMethod()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 514
    .local v2, "oneClickPaymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getCardId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;->getCardId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 515
    iput-object v2, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 522
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    .end local v2    # "oneClickPaymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    .end local v3    # "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    goto :goto_0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    return-object v0
.end method

.method public isDeviceNameSet()Z
    .locals 1

    .prologue
    .line 361
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/OneClickController;->getDeviceName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized isOneClickStatusEnabled()Z
    .locals 1

    .prologue
    .line 383
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    if-eqz v0, :cond_0

    .line 384
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController;->oneClickConfigResponse:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getOneClickStatus()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 386
    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    :try_start_1
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 383
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setDeviceName(Ljava/lang/String;)V
    .locals 1
    .param p1, "userDeviceName"    # Ljava/lang/String;

    .prologue
    .line 342
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 346
    :goto_0
    return-void

    .line 345
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController;->userSelectedDeviceName:Ljava/lang/String;

    goto :goto_0
.end method

.method public setSelectedOneClickAddress(Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)V
    .locals 3
    .param p1, "oneClickAddress"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .prologue
    .line 453
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getPaymentMethod()Ljava/util/List;

    move-result-object v0

    .line 454
    .local v0, "methods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    const/4 v1, 0x1

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 456
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    iput-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 460
    :goto_0
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .line 461
    return-void

    .line 458
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    goto :goto_0
.end method

.method public setSelectedPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)V
    .locals 0
    .param p1, "newSelectedPaymentMethod"    # Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .prologue
    .line 528
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController;->selectedPaymentMethod:Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 529
    return-void
.end method
