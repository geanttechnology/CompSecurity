.class Lcom/amazon/mShop/control/cart/CartController$1;
.super Ljava/lang/Object;
.source "CartController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/cart/CartController;->setupTimer()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/cart/CartController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/cart/CartController;)V
    .locals 0

    .prologue
    .line 346
    iput-object p1, p0, Lcom/amazon/mShop/control/cart/CartController$1;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$1;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->updateCheckOutTime()V
    invoke-static {v0}, Lcom/amazon/mShop/control/cart/CartController;->access$000(Lcom/amazon/mShop/control/cart/CartController;)V

    .line 350
    return-void
.end method
