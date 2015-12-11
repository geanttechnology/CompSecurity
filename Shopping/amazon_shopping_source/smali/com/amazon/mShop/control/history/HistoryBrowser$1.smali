.class Lcom/amazon/mShop/control/history/HistoryBrowser$1;
.super Ljava/lang/Object;
.source "HistoryBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/history/HistoryBrowser;->completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

.field final synthetic val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/history/HistoryBrowser;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    iput-object p3, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;->getProducts()Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/history/HistoryBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/control/history/HistoryBrowser;->access$000(Lcom/amazon/mShop/control/history/HistoryBrowser;Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

    # getter for: Lcom/amazon/mShop/control/history/HistoryBrowser;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/history/HistoryBrowser;->access$100(Lcom/amazon/mShop/control/history/HistoryBrowser;)Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$1;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/home/BasicProductsSubscriber;->onBasicProductsReceived(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V

    .line 93
    return-void
.end method
