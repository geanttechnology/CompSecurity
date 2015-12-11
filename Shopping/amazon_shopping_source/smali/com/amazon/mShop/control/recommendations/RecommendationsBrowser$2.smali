.class Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;
.super Ljava/lang/Object;
.source "RecommendationsBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->imageReceived([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

.field final synthetic val$image:[B

.field final synthetic val$intraPageIndex:I

.field final synthetic val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;I[BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    iput p2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$intraPageIndex:I

    iput-object p3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$image:[B

    iput-object p4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 194
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->currentRequestPageIndex:I
    invoke-static {v4}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$500(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I

    move-result v4

    iget-object v5, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->pageSize:I
    invoke-static {v5}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$600(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)I

    move-result v5

    mul-int/2addr v4, v5

    iget v5, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$intraPageIndex:I

    add-int v3, v4, v5

    .line 195
    .local v3, "serverSideIndex":I
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->hasDeletedAt(I)Z

    move-result v2

    .line 196
    .local v2, "key":Z
    if-nez v2, :cond_0

    .line 197
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->amountHasDelted(I)I

    move-result v0

    .line 198
    .local v0, "delta":I
    iget v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$intraPageIndex:I

    sub-int v1, v4, v0

    .line 199
    .local v1, "index":I
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    iget-object v5, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->listingImages:Ljava/util/List;
    invoke-static {v5}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$700(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;)Ljava/util/List;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$image:[B

    iget-object v7, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$2;->val$serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->addToListAndNotify(Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v4, v5, v6, v1, v7}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->access$800(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;Ljava/util/List;Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 202
    .end local v0    # "delta":I
    .end local v1    # "index":I
    :cond_0
    return-void
.end method
