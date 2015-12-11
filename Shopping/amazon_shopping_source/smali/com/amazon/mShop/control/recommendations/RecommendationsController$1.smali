.class Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;
.super Ljava/lang/Object;
.source "RecommendationsController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/recommendations/RecommendationsController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 153
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 156
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    const/4 v5, 0x0

    # setter for: Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mHasPendingCall:Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->access$002(Lcom/amazon/mShop/control/recommendations/RecommendationsController;Z)Z

    .line 157
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "userRatingRequestErrorSet"

    invoke-interface {v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 158
    .local v3, "userRatingRequestErrorSet":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 159
    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mUserKey:Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->access$100(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)Ljava/lang/String;

    move-result-object v3

    .line 163
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const-string/jumbo v5, "userRatingRequestErrorSet"

    invoke-interface {v4, v5, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    new-instance v2, Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mSubscribers:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->access$200(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)Ljava/util/List;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 165
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;

    .line 166
    .local v1, "subscriber":Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;->onRecsRatingCallError()V

    goto :goto_1

    .line 161
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;
    .end local v2    # "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;>;"
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsController$1;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    # getter for: Lcom/amazon/mShop/control/recommendations/RecommendationsController;->mUserKey:Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->access$100(Lcom/amazon/mShop/control/recommendations/RecommendationsController;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 168
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/recommendations/RecommendationsRatingSubscriber;>;"
    :cond_1
    return-void
.end method
