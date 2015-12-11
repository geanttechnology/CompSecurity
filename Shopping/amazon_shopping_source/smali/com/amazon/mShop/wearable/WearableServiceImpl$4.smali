.class Lcom/amazon/mShop/wearable/WearableServiceImpl$4;
.super Ljava/lang/Object;
.source "WearableServiceImpl.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/WearableServiceImpl;->purchaseProduct(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;Lcom/amazon/mShop/wearable/ResultListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

.field final synthetic val$listener:Lcom/amazon/mShop/wearable/ResultListener;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/WearableServiceImpl;Lcom/amazon/mShop/wearable/ResultListener;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 230
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    const-string/jumbo v1, "Cancelled while trying to buy"

    new-instance v2, Ljava/lang/Throwable;

    const-string/jumbo v3, "Call cancelled"

    invoke-direct {v2, v3}, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 231
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 235
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->getConfirmedOrderId()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->getConfirmedOrderId()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 236
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    invoke-interface {v0}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V

    .line 245
    :goto_0
    return-void

    .line 240
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->getPurchaseStatus()Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 241
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseOrderResponse;->getPurchaseStatus()Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;->getNextStep()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/Throwable;

    const-string/jumbo v3, "BuyNow order not completed"

    invoke-direct {v2, v3}, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 243
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    const-string/jumbo v1, "Unknown error"

    new-instance v2, Ljava/lang/Throwable;

    const-string/jumbo v3, "BuyNow order not completed"

    invoke-direct {v2, v3}, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 224
    # getter for: Lcom/amazon/mShop/wearable/WearableServiceImpl;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/wearable/WearableServiceImpl;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Error while trying to buy "

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 225
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$4;->this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

    const-string/jumbo v2, "buyNow"

    # invokes: Lcom/amazon/mShop/wearable/WearableServiceImpl;->handleErrorMessage(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;
    invoke-static {v1, v2, p1}, Lcom/amazon/mShop/wearable/WearableServiceImpl;->access$100(Lcom/amazon/mShop/wearable/WearableServiceImpl;Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 226
    return-void
.end method
