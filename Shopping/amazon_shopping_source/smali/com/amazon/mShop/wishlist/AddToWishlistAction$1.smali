.class Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;
.super Ljava/lang/Object;
.source "AddToWishlistAction.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wishlist/AddToWishlistAction;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/wishlist/AddToWishlistAction;

.field final synthetic val$currentView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wishlist/AddToWishlistAction;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;->this$0:Lcom/amazon/mShop/wishlist/AddToWishlistAction;

    iput-object p2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;->val$currentView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 119
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1$1;-><init>(Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 127
    return-void
.end method
