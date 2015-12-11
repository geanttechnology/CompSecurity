.class Lcom/amazon/mShop/cart/AddToCartAction$1$1;
.super Ljava/lang/Object;
.source "AddToCartAction.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cart/AddToCartAction$1;->onActionButtonClick(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/cart/AddToCartAction$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cart/AddToCartAction$1;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/mShop/cart/AddToCartAction$1$1;->this$1:Lcom/amazon/mShop/cart/AddToCartAction$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/cart/AddToCartAction$1$1;->this$1:Lcom/amazon/mShop/cart/AddToCartAction$1;

    iget-object v0, v0, Lcom/amazon/mShop/cart/AddToCartAction$1;->this$0:Lcom/amazon/mShop/cart/AddToCartAction;

    iget-object v0, v0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/cart/AddToCartAction$1$1;->this$1:Lcom/amazon/mShop/cart/AddToCartAction$1;

    iget-object v1, v1, Lcom/amazon/mShop/cart/AddToCartAction$1;->val$currentView:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->clearErrorOnView(Landroid/view/View;)V

    .line 122
    return-void
.end method
