.class Lcom/amazon/mShop/control/history/HistoryBrowser$2;
.super Ljava/lang/Object;
.source "HistoryBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/history/HistoryBrowser;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

.field final synthetic val$exp:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/history/HistoryBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->val$exp:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/history/HistoryBrowser;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->this$0:Lcom/amazon/mShop/control/history/HistoryBrowser;

    # getter for: Lcom/amazon/mShop/control/history/HistoryBrowser;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/history/HistoryBrowser;->access$100(Lcom/amazon/mShop/control/history/HistoryBrowser;)Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->val$exp:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/history/HistoryBrowser$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/control/home/BasicProductsSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 106
    return-void
.end method
