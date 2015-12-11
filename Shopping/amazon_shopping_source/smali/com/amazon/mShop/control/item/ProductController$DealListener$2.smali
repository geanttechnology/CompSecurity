.class Lcom/amazon/mShop/control/item/ProductController$DealListener$2;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$DealListener;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$DealListener;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 2455
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 2459
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController$DealListener;->access$3700(Lcom/amazon/mShop/control/item/ProductController$DealListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 2460
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->val$e:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/control/item/ProductController;->access$1000(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 2463
    :cond_0
    return-void
.end method
