.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 2211
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;->val$e:Ljava/lang/Exception;

    iput-object p3, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 2215
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;->val$e:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$10;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/control/item/ProductController;->access$1000(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 2220
    return-void
.end method
