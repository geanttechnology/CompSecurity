.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V
    .locals 0

    .prologue
    .line 1920
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 1924
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1925
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->setPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V

    .line 1932
    :cond_0
    return-void
.end method
