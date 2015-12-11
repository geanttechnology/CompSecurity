.class public Lcom/amazon/mShop/details/MarketPlaceAction;
.super Ljava/lang/Object;
.source "MarketPlaceAction.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final activity:Lcom/amazon/mShop/AmazonActivity;

.field private final productController:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 0
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceAction;->activity:Lcom/amazon/mShop/AmazonActivity;

    .line 24
    iput-object p2, p0, Lcom/amazon/mShop/details/MarketPlaceAction;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 25
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceAction;->activity:Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceView;

    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceAction;->activity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/details/MarketPlaceAction;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v1, v2, v3}, Lcom/amazon/mShop/details/MarketPlaceView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 35
    instance-of v0, p1, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v0, :cond_0

    .line 37
    const-string/jumbo v0, "dp_buy_opt"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 42
    :goto_0
    return-void

    .line 40
    :cond_0
    const-string/jumbo v0, "dp_olp"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
