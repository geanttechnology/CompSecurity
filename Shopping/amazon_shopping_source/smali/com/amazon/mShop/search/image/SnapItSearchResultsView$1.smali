.class Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;
.super Ljava/lang/Object;
.source "SnapItSearchResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->access$100(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)Lcom/amazon/mShop/control/search/image/ImageSearchController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mResizedImage:[B
    invoke-static {v1}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->access$000(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->doImageSearch([B)V

    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->access$200(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 109
    return-void
.end method
