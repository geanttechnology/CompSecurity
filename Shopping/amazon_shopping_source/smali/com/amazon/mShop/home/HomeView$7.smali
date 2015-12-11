.class Lcom/amazon/mShop/home/HomeView$7;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->handlerError(Ljava/lang/Exception;)V
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
    .line 856
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$7;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 4
    .param p1, "errorId"    # I

    .prologue
    const/4 v3, 0x1

    .line 860
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$7;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShoveler0:Lcom/amazon/mShop/home/HomeShovelerView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1900(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 861
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$7;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mShoveler1:Lcom/amazon/mShop/home/HomeShovelerView;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$2000(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/HomeShovelerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeShovelerView;->clear()V

    .line 863
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$7;->this$0:Lcom/amazon/mShop/home/HomeView;

    new-instance v1, Lcom/amazon/mShop/net/PageMetricsObserver;

    const-string/jumbo v2, "HomeRefreshCriticalFeature"

    invoke-direct {v1, v2}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    # setter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0, v1}, Lcom/amazon/mShop/home/HomeView;->access$1102(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/mShop/net/PageMetricsObserver;)Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 864
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$7;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mPageMetricsRefreshCriticalFeatureObserver:Lcom/amazon/mShop/net/PageMetricsObserver;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$7;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v1}, Lcom/amazon/mShop/home/HomeView;->access$100(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/PageMetricsObserver;->startForObject(Ljava/lang/String;)V

    .line 865
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    invoke-virtual {v0, v3, v3}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome(ZZ)Z

    .line 866
    return-void
.end method
