.class Lcom/amazon/mShop/control/item/ProductController$1;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Lcom/amazon/mShop/control/ObjectSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/item/ProductController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0

    .prologue
    .line 1800
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAvailableCountReceived(I)V
    .locals 1
    .param p1, "count"    # I

    .prologue
    .line 1804
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyBrowserAvailableCountChanged()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$300(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 1805
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 1830
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 1843
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v0, p1, p2}, Lcom/amazon/mShop/control/item/ProductController;->access$1000(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 1844
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 1
    .param p1, "model"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 1812
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$400(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentIndex()I

    move-result v0

    if-ne v0, p2, :cond_0

    .line 1813
    instance-of v0, p1, [B

    if-eqz v0, :cond_1

    .line 1815
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyImageChanged()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$500(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 1822
    :cond_0
    :goto_0
    return-void

    .line 1817
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->updateWithObject(Ljava/lang/Object;)V
    invoke-static {v0, p1}, Lcom/amazon/mShop/control/item/ProductController;->access$600(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/Object;)V

    .line 1818
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$700(Lcom/amazon/mShop/control/item/ProductController;)V

    goto :goto_0
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 1850
    return-void
.end method

.method public onPageComplete()V
    .locals 1

    .prologue
    .line 1837
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyServiceCallComplete()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$800(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 1838
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$1;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->productRequestEnded()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$900(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 1839
    return-void
.end method
