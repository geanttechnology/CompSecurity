.class public Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;
.super Lcom/amazon/mShop/control/BaseController;
.source "AmazonPointsSummaryController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryResponseListener;


# instance fields
.field private subscriber:Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;)V
    .locals 0
    .param p1, "accountSubscriber"    # Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->subscriber:Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;

    .line 20
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 13
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;)Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->subscriber:Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 34
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;-><init>(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 47
    return-void
.end method

.method public declared-synchronized doGetPointsSummary(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 2
    .param p1, "savingTaskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 29
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/Null;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Null;-><init>()V

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->getPointsSummary(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->subscriber:Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;

    return-object v0
.end method
