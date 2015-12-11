.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->addToWishList(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

.field final synthetic val$asin:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 458
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;->val$asin:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 461
    new-instance v0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;-><init>(Z)V

    .line 462
    .local v0, "addToWishListAction":Lcom/amazon/mShop/wishlist/AddToWishlistAction;
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;->this$0:Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    # getter for: Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;->val$asin:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->addItem(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    .line 463
    const-string/jumbo v1, "dp_buy_wl"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 464
    return-void
.end method
