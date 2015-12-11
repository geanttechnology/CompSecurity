.class Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;
.super Ljava/lang/Object;
.source "RecommendationsBrowser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->receivedNoRecommendationsExplanation(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

.field final synthetic val$value:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    iput-object p2, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;->val$value:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;->this$0:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRecSubscriber()Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser$3;->val$value:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsSubscriber;->onReceivedNoRecommendationsExplanation(Ljava/lang/String;)V

    .line 230
    return-void
.end method
