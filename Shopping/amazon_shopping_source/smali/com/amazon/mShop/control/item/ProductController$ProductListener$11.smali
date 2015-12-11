.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receivedMultiImage(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$index:I

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;ILcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V
    .locals 0

    .prologue
    .line 2227
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->val$index:I

    iput-object p3, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2231
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2232
    iget v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->val$index:I

    if-nez v0, :cond_0

    .line 2233
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->clearMultiImages()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$2700(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2234
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->setMultiImages(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$2800(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;)V

    .line 2238
    iget v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->val$index:I

    if-nez v0, :cond_1

    .line 2239
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$11;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyImageChanged()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$500(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2241
    :cond_1
    return-void
.end method
