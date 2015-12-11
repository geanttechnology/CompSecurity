.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receivedBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 0

    .prologue
    .line 1941
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1945
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1946
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$1400(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 1948
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1949
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyImageChanged()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$500(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 1955
    :cond_0
    return-void
.end method
