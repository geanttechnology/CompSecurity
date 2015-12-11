.class Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;
.super Ljava/lang/Object;
.source "ViewItItemBarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 164
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v0, v1, :cond_0

    .line 165
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$500(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$700(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->val$e:Ljava/lang/Exception;

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/UIUtils;->getMessageForException(Landroid/content/Context;Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_MSHOP_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v0, v3, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->showServiceCallErrorInLoadingWindow(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v0, v3}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$002(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 168
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowBarcodeFailObserver()V

    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeNoMatchesObserver()V

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeSuccessObserver()V

    .line 172
    :cond_0
    return-void
.end method
