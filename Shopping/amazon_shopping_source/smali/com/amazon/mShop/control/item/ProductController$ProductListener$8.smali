.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$8;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V
    .locals 0

    .prologue
    .line 2139
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$8;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 2143
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$8;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyCancelled()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$1800(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2148
    return-void
.end method
