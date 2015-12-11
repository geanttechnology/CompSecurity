.class Lcom/amazon/mShop/home/HomeView$3;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->onPushViewCompleted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;)V
    .locals 0

    .prologue
    .line 396
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 401
    const/4 v1, 0x0

    .line 403
    .local v1, "startNormalHomeCFMetric":Z
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mIsHomeViewJustCreated:Z
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1000(Lcom/amazon/mShop/home/HomeView;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 406
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 408
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    new-instance v3, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v4, "HomeRefreshCriticalFeature"

    invoke-direct {v3, v4}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    # setter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v2, v3}, Lcom/amazon/mShop/home/HomeView;->access$1102(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/net/PageMetricsObserver;)Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 409
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 410
    const/4 v1, 0x1

    .line 413
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mNeedInvokeHomeCallStarted:Z
    invoke-static {v2, v5}, Lcom/amazon/mShop/home/HomeView;->access$1202(Lcom/amazon/mShop/home/HomeView;Z)Z

    .line 415
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    invoke-virtual {v2, v5}, Lcom/amazon/mShop/control/home/HomeController;->setReturnCartItems(Z)V

    .line 416
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    invoke-virtual {v2, v5}, Lcom/amazon/mShop/control/home/HomeController;->setReturnHomeItems(Z)V

    .line 418
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mApplicationStarted:Z
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeView;->access$1300(Lcom/amazon/mShop/home/HomeView;)Z

    move-result v3

    iget-object v4, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mApplicationStarted:Z
    invoke-static {v4}, Lcom/amazon/mShop/home/HomeView;->access$1300(Lcom/amazon/mShop/home/HomeView;)Z

    move-result v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome(ZZ)Z

    move-result v0

    .line 420
    .local v0, "phoneHomeInvoked":Z
    if-nez v0, :cond_1

    if-eqz v1, :cond_1

    .line 421
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v2

    if-nez v2, :cond_1

    .line 422
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 427
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # invokes: Lcom/amazon/mShop/home/HomeView;->addWeblabCsmMetrics(Z)V
    invoke-static {v2, v0}, Lcom/amazon/mShop/home/HomeView;->access$1400(Lcom/amazon/mShop/home/HomeView;Z)V

    .line 429
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/home/GatewayActivity;->isHomeActivityJustCreated()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 430
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v2}, Lcom/amazon/mShop/home/HomeView;->onHomeCallStarted()V

    .line 433
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # setter for: Lcom/amazon/mShop/home/HomeView;->mApplicationStarted:Z
    invoke-static {v2, v6}, Lcom/amazon/mShop/home/HomeView;->access$1302(Lcom/amazon/mShop/home/HomeView;Z)Z

    .line 434
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v2}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v2

    invoke-virtual {v2, v6}, Lcom/amazon/mShop/home/GatewayActivity;->setHomeActivityJustCreated(Z)V

    .line 439
    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$3;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v2}, Lcom/amazon/mShop/home/HomeView;->postHomePageImpression()V

    .line 441
    return-void
.end method
