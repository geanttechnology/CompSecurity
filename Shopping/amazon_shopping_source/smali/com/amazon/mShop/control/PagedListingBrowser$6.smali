.class Lcom/amazon/mShop/control/PagedListingBrowser$6;
.super Ljava/lang/Object;
.source "PagedListingBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/PagedListingBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

.field final synthetic val$objects:Ljava/util/List;

.field final synthetic val$requestFinished:Z

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/PagedListingBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;Z)V
    .locals 0

    .prologue
    .line 862
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$6;, "Lcom/amazon/mShop/control/PagedListingBrowser.6;"
    iput-object p1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$objects:Ljava/util/List;

    iput-boolean p4, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$requestFinished:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 865
    .local p0, "this":Lcom/amazon/mShop/control/PagedListingBrowser$6;, "Lcom/amazon/mShop/control/PagedListingBrowser.6;"
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v1, v1, Lcom/amazon/mShop/control/PagedListingBrowser;->currentRequest:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    # getter for: Lcom/amazon/mShop/control/PagedListingBrowser;->hasPendingCancellation:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$000(Lcom/amazon/mShop/control/PagedListingBrowser;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 866
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$objects:Ljava/util/List;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 867
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    iget-object v0, v0, Lcom/amazon/mShop/control/PagedListingBrowser;->listingObjects:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$objects:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 869
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    # invokes: Lcom/amazon/mShop/control/PagedListingBrowser;->notifyObjectsReceived()V
    invoke-static {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->access$300(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 871
    iget-boolean v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$requestFinished:Z

    if-eqz v0, :cond_1

    .line 872
    iget-object v0, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->this$0:Lcom/amazon/mShop/control/PagedListingBrowser;

    const/4 v1, 0x0

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/mShop/control/PagedListingBrowser$6;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->requestFinished(ILjava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 875
    :cond_1
    return-void
.end method
