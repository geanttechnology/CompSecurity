.class Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;
.super Ljava/lang/Object;
.source "ViewItItemImageSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 71
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v1, v4, :cond_0

    .line 73
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowImageFailObserver()V

    .line 75
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;->getProducts()Ljava/util/List;

    move-result-object v2

    .line 76
    .local v2, "searchResultsVector":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 77
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mOriginalScannedOutput:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$200(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getCurrentDate()Ljava/util/Date;

    move-result-object v4

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;-><init>(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Z)V

    .line 79
    .local v0, "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->updateToShowItemContentInLoadingWindow(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 81
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowImageSuccessObserver()V

    .line 82
    const-string/jumbo v1, "fl_image_success"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 90
    .end local v0    # "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v1, v3}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$002(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 92
    .end local v2    # "searchResultsVector":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    :cond_0
    return-void

    .line 84
    .restart local v2    # "searchResultsVector":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v1

    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_no_matched_item_found:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_MATCHED_ITEM:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v1, v3, v4, v5}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->showServiceCallErrorInLoadingWindow(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 87
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemImageSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowImageSuccessObserver()V

    goto :goto_0
.end method
