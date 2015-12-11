.class Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;
.super Ljava/lang/Object;
.source "BarcodeSearchController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iput-object p2, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    const/4 v1, 0x2

    # setter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mBarcodeSearchStatus:I
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$002(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;I)I

    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$100(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    # invokes: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$200(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)V

    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController$1;->this$0:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    # getter for: Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->mSubscriber:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->access$300(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;->onCompleted()V

    .line 112
    :cond_0
    return-void
.end method
