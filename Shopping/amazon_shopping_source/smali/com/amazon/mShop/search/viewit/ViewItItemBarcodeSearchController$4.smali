.class Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;
.super Ljava/lang/Object;
.source "ViewItItemBarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->receivedMatchedItem(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V
    .locals 0

    .prologue
    .line 194
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v0, v1, :cond_0

    .line 197
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    # setter for: Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->mOneMatchedSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;->access$402(Lcom/amazon/mShop/search/viewit/ViewItItemBarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 199
    :cond_0
    return-void
.end method
