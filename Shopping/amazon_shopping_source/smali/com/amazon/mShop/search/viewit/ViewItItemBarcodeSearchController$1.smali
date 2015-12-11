.class Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;
.super Ljava/lang/Object;
.source "ViewItItemBarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 112
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 114
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v4

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v4, v7, :cond_1

    .line 116
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeFailObserver()V

    .line 118
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 119
    .local v2, "searchResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->getBarcodeSearchResultType()I
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$200(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)I

    move-result v6

    .line 120
    .local v6, "resultType":I
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v7}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->getTypeValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mBarcodeString:Ljava/lang/String;
    invoke-static {v7}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 121
    .local v1, "originalScannedOutput":Ljava/lang/String;
    if-ne v6, v5, :cond_2

    .line 122
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 123
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-static {}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getCurrentDate()Ljava/util/Date;

    move-result-object v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;-><init>(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Z)V

    .line 125
    .local v0, "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$500(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->updateToShowItemContentInLoadingWindow(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 127
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeNoMatchesObserver()V

    .line 128
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowBarcodeSuccessObserver()V

    .line 129
    const-string/jumbo v4, "fl_barcode_success"

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 154
    .end local v0    # "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v4, v3}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$002(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 156
    .end local v1    # "originalScannedOutput":Ljava/lang/String;
    .end local v2    # "searchResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .end local v6    # "resultType":I
    :cond_1
    return-void

    .line 130
    .restart local v1    # "originalScannedOutput":Ljava/lang/String;
    .restart local v2    # "searchResults":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    .restart local v6    # "resultType":I
    :cond_2
    const/4 v4, 0x2

    if-ne v6, v4, :cond_5

    .line 131
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 132
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 134
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$600(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Ljava/util/List;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 135
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$600(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Ljava/util/List;

    move-result-object v4

    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v7}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$400(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v7

    invoke-static {v4, v7}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeIfContained(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Z

    .line 136
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mSearchResultsList:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$600(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 139
    :cond_4
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    invoke-static {}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getCurrentDate()Ljava/util/Date;

    move-result-object v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;-><init>(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Z)V

    .line 141
    .restart local v0    # "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$500(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->updateToShowItemContentInLoadingWindow(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 143
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeNoMatchesObserver()V

    .line 144
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowBarcodeSuccessObserver()V

    .line 145
    const-string/jumbo v4, "fl_barcode_success"

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 146
    .end local v0    # "object":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    :cond_5
    if-nez v6, :cond_0

    .line 147
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mViewItScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$500(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v5}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$700(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_no_matched_item_found:I

    invoke-virtual {v5, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    sget-object v7, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_MATCHED_ITEM:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v4, v3, v5, v7}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->showServiceCallErrorInLoadingWindow(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 150
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->finishFlowBarcodeNoMatchesObserver()V

    .line 151
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mMetricHelper:Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;
    invoke-static {v4}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$100(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->cancelFlowBarcodeSuccessObserver()V

    .line 152
    const-string/jumbo v4, "fl_barcode_nomatch"

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
