.class Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;
.super Ljava/lang/Object;
.source "AdvSearchResultsBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->receivedMainResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

.field final synthetic val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;)V
    .locals 0

    .prologue
    .line 349
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 354
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getCurrentServiceCall()Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    if-ne v0, v1, :cond_3

    .line 357
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->cancelServiceCallForStubs()V

    .line 363
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    # getter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mHasCorrectedResults:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$000(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 365
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getTotalCount()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mMainTotalCount:I
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$102(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;I)I

    .line 369
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResultsDesc()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 370
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResultsDesc()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mMainResultsTitle:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$202(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;

    .line 372
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getTotalCount()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mTotalCount:I

    .line 373
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchResults:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$302(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;)Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    .line 374
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getRefinements()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 375
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getRefinements()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mRefinementBins:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$402(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;

    .line 376
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getFilters()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mFilters:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$502(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;

    .line 377
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mToggleRefinements:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$602(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;

    .line 378
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getBreadcrumbs()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mBreadCrumbs:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$702(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;

    .line 381
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getSortOptions()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 382
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getSortOptions()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mSortOptions:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$802(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;

    .line 384
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    # getter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;
    invoke-static {v0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$900(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    move-result-object v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    # getter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mSortOptions:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$800(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_3

    .line 385
    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    # getter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mSortOptions:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$800(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;
    invoke-static {v1, v0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$902(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/SortOption;)Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    .line 390
    :cond_3
    return-void
.end method
