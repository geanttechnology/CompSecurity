.class Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;
.super Ljava/lang/Object;
.source "RecommendationsBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->objectReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

.field final synthetic val$intraPageIndex:I

.field final synthetic val$o:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

.field final synthetic val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;ILcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    iput p2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$intraPageIndex:I

    iput-object p3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$o:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    iput-object p4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 153
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->currentRequestPageIndex:I
    invoke-static {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$000(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I

    move-result v2

    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->pageSize:I
    invoke-static {v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$100(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I

    move-result v3

    mul-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$intraPageIndex:I

    add-int v1, v2, v3

    .line 154
    .local v1, "serverIndex":I
    iget v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$intraPageIndex:I

    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRatingPendingIndexSet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->size()I

    move-result v3

    sub-int v0, v2, v3

    .line 155
    .local v0, "index":I
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingIndices:Ljava/util/List;
    invoke-static {v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$200(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)Ljava/util/List;

    move-result-object v2

    new-instance v3, Ljava/lang/Integer;

    invoke-direct {v3, v1}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 156
    iget-object v2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingObjects:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$300(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)Ljava/util/List;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$o:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    iget-object v5, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$1;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v2, v3, v4, v0, v5}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$400(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 157
    return-void
.end method
