.class Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;
.super Ljava/lang/Object;
.source "BarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field final synthetic val$index:I

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;I)V
    .locals 0

    .prologue
    .line 223
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    iput p3, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;->val$index:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 226
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    # getter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$300(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    iget v2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$8;->val$index:I

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;->onSearchResultReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;I)V

    .line 227
    return-void
.end method
