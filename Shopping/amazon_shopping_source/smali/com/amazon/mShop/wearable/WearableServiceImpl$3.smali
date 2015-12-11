.class Lcom/amazon/mShop/wearable/WearableServiceImpl$3;
.super Ljava/lang/Object;
.source "WearableServiceImpl.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/WearableServiceImpl;->addProductToWishList(Ljava/lang/String;Lcom/amazon/mShop/wearable/ResultListener;)V
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
    .line 184
    iput-object p1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;->this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 194
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 198
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    invoke-interface {v0}, Lcom/amazon/mShop/wearable/ResultListener;->onSuccess()V

    .line 199
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 187
    # getter for: Lcom/amazon/mShop/wearable/WearableServiceImpl;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/wearable/WearableServiceImpl;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Add to wishlist encountered Exception"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 188
    iget-object v0, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;->val$listener:Lcom/amazon/mShop/wearable/ResultListener;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableServiceImpl$3;->this$0:Lcom/amazon/mShop/wearable/WearableServiceImpl;

    const-string/jumbo v2, "add to wishlist"

    # invokes: Lcom/amazon/mShop/wearable/WearableServiceImpl;->handleErrorMessage(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;
    invoke-static {v1, v2, p1}, Lcom/amazon/mShop/wearable/WearableServiceImpl;->access$100(Lcom/amazon/mShop/wearable/WearableServiceImpl;Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Lcom/amazon/mShop/wearable/ResultListener;->onError(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 189
    return-void
.end method
