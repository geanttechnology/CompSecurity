.class Lcom/amazon/mShop/feature/Features$1$1;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/Features$1;->completed(Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/feature/Features$1;

.field final synthetic val$response:Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features$1;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;)V
    .locals 0

    .prologue
    .line 454
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$1$1;->this$1:Lcom/amazon/mShop/feature/Features$1;

    iput-object p2, p0, Lcom/amazon/mShop/feature/Features$1$1;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 457
    iget-object v6, p0, Lcom/amazon/mShop/feature/Features$1$1;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;->getFeatureStates()Ljava/util/List;

    move-result-object v5

    .line 460
    .local v5, "receivedFeatureStates":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Feature;>;"
    new-instance v4, Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/amazon/mShop/feature/Features$1$1;->this$1:Lcom/amazon/mShop/feature/Features$1;

    iget-object v6, v6, Lcom/amazon/mShop/feature/Features$1;->this$0:Lcom/amazon/mShop/feature/Features;

    # getter for: Lcom/amazon/mShop/feature/Features;->mFeatureNames:Ljava/util/List;
    invoke-static {v6}, Lcom/amazon/mShop/feature/Features;->access$000(Lcom/amazon/mShop/feature/Features;)Ljava/util/List;

    move-result-object v6

    invoke-direct {v4, v6}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 461
    .local v4, "missingFeaturesNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    .line 462
    .local v1, "f":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getFeatureName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 464
    .end local v1    # "f":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    :cond_0
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 465
    .local v2, "featureName":Ljava/lang/String;
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;-><init>()V

    .line 466
    .local v0, "controlFeature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setFeatureName(Ljava/lang/String;)V

    .line 472
    const-string/jumbo v6, ""

    invoke-virtual {v0, v6}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setClientTreatmentPath(Ljava/lang/String;)V

    .line 473
    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setSendTrigger(Ljava/lang/Boolean;)V

    .line 474
    const/4 v6, 0x0

    invoke-virtual {v0, v6}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->setCacheStamp(Ljava/lang/Integer;)V

    .line 475
    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 477
    .end local v0    # "controlFeature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .end local v2    # "featureName":Ljava/lang/String;
    :cond_1
    iget-object v6, p0, Lcom/amazon/mShop/feature/Features$1$1;->this$1:Lcom/amazon/mShop/feature/Features$1;

    iget-object v6, v6, Lcom/amazon/mShop/feature/Features$1;->this$0:Lcom/amazon/mShop/feature/Features;

    # invokes: Lcom/amazon/mShop/feature/Features;->notifyFeatureStateReceived(Ljava/util/List;)V
    invoke-static {v6, v5}, Lcom/amazon/mShop/feature/Features;->access$100(Lcom/amazon/mShop/feature/Features;Ljava/util/List;)V

    .line 478
    return-void
.end method
