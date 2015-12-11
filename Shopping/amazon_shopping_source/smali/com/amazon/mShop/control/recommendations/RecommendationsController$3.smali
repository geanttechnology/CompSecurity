.class Lcom/amazon/mShop/control/recommendations/RecommendationsController$3;
.super Ljava/lang/Object;
.source "RecommendationsController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/recommendations/RecommendationsController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)V
    .locals 0

    .prologue
    .line 192
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$3;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 195
    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$3;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    const/4 v4, 0x0

    # setter for: Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z
    invoke-static {v3, v4}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->access$002(Lcom/amazon/mShop/control/recommendations/RecommendationsController;Z)Z

    .line 196
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$3;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->access$200(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 197
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;

    .line 198
    .local v1, "subscriber":Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;->onRecsRatingCallCompleted()V

    goto :goto_0

    .line 200
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
    :cond_0
    return-void
.end method
