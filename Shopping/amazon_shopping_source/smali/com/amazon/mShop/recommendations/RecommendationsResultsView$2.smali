.class Lcom/amazon/mShop/recommendations/RecommendationsResultsView$2;
.super Ljava/lang/Object;
.source "RecommendationsResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->showErrorDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V
    .locals 0

    .prologue
    .line 348
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 352
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->access$200(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/recommendations/RecommendationsActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/recommendations/RecommendationsActivity;->constructUserUniqueInfo()Ljava/lang/String;

    move-result-object v0

    .line 353
    .local v0, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->eraseRatingRequestErrorInfo(Ljava/lang/String;)V

    .line 354
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$2;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    # invokes: Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->refresh()V
    invoke-static {v1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->access$300(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    .line 355
    return-void
.end method
