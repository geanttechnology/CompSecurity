.class Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;
.super Ljava/lang/Object;
.source "AdvSearchResultsBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->receivedAdvSearchResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;)V
    .locals 0

    .prologue
    .line 486
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 489
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mHasCorrectedResults:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$002(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Z)Z

    .line 490
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResultsDesc()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCorrectedResultsTitle:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$1302(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;

    .line 491
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getTotalCount()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mTotalCount:I

    .line 492
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getQuery()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 494
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getQuery()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mQuery:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$1402(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;

    .line 496
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->this$0:Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getFilters()Ljava/lang/String;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mFilters:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->access$502(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;

    .line 497
    return-void
.end method
