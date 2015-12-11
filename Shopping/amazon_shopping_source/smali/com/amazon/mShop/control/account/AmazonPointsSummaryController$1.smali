.class Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;
.super Ljava/lang/Object;
.source "AmazonPointsSummaryController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->this$0:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->this$0:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    iget-object v1, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->access$000(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->this$0:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    # invokes: Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->access$100(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;)V

    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->this$0:Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;

    # getter for: Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->subscriber:Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;->access$200(Lcom/amazon/mShop/control/account/AmazonPointsSummaryController;)Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/account/AmazonPointsSummaryController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PointsSummaryResponse;->getSummaryRows()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;->onReceiveAmazonPointsSummary(Ljava/util/List;)V

    .line 45
    :cond_0
    return-void
.end method
