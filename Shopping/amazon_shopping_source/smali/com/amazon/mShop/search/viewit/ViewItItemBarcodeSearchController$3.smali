.class Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;
.super Ljava/lang/Object;
.source "ViewItItemBarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v0, v1, :cond_0

    .line 181
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$500(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->dismissAnimationWindow(Z)V

    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$002(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeNoMatchesObserver()V

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeFailObserver()V

    .line 186
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeSuccessObserver()V

    .line 188
    :cond_0
    return-void
.end method
