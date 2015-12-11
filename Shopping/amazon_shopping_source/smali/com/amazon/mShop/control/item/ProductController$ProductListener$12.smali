.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receivedDealId(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$value:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2258
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->val$value:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2262
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->val$value:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setDealId(Ljava/lang/String;)V

    .line 2263
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->val$value:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2267
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->val$value:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v1, v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController;->access$2600(Lcom/amazon/mShop/control/item/ProductController;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2268
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v1, v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ProductController;->getDealId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->requestDeal(Ljava/lang/String;)V

    .line 2273
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$2602(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;)Ljava/lang/String;

    .line 2274
    return-void

    .line 2270
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$12;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyDealBlockUpdated()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$3100(Lcom/amazon/mShop/control/item/ProductController;)V

    goto :goto_0
.end method
