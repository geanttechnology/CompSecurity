.class Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;
.super Ljava/lang/Object;
.source "BarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->receivedMatchedItem(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    # setter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSearchResult:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$402(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 145
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    # getter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$300(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$3;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;->onMatchedItemReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V

    .line 146
    return-void
.end method
