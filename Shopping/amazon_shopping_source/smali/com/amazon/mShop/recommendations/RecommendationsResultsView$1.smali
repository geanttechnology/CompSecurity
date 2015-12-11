.class Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;
.super Ljava/lang/Object;
.source "RecommendationsResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 222
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 3
    .param p1, "errorId"    # I

    .prologue
    const/4 v2, 0x0

    .line 226
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mProgress:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->access$000(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 227
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Landroid/widget/TextView;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    # getter for: Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mStatus:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->access$100(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView$1;->this$0:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    iget-object v0, v0, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mBrowser:Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->replayPageRequest()V

    .line 230
    return-void
.end method
