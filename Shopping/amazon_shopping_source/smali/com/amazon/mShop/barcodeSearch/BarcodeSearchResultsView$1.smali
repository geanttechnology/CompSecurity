.class Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;
.super Ljava/lang/Object;
.source "BarcodeSearchResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    # invokes: Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->startBarcodeSearch()V
    invoke-static {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->access$000(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;)V

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    # getter for: Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->access$100(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;->this$0:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 150
    return-void
.end method
