.class public Lcom/amazon/mShop/opl/BuyNowAction;
.super Ljava/lang/Object;
.source "BuyNowAction.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 12
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 30
    instance-of v1, p1, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v1, :cond_1

    move-object v8, p1

    .line 31
    check-cast v8, Lcom/amazon/mShop/details/BuyButtonView;

    .line 32
    .local v8, "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    invoke-virtual {v8}, Lcom/amazon/mShop/details/BuyButtonView;->getBuyButtonController()Lcom/amazon/mShop/control/item/BuyButtonController;

    move-result-object v10

    .line 33
    .local v10, "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v11

    .line 34
    .local v11, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v9

    check-cast v9, Landroid/app/Activity;

    .line 36
    .local v9, "context":Landroid/app/Activity;
    instance-of v1, v9, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v1, :cond_0

    move-object v1, v9

    .line 38
    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->skipNextStopBehavior()V

    .line 41
    :cond_0
    new-instance v0, Lcom/amazon/mShop/opl/PurchaseParams;

    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getOfferId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/ProductController;->getListId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/ProductController;->getListItemId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getDealId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getShippingSpeed()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/ProductController;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/opl/PurchaseParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    .local v0, "parameters":Lcom/amazon/mShop/opl/PurchaseParams;
    invoke-static {v9, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startPurchaseActivity(Landroid/content/Context;Lcom/amazon/mShop/opl/PurchaseParams;)V

    .line 46
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v1, v2, :cond_2

    .line 48
    const-string/jumbo v1, "dp_buy"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 60
    .end local v0    # "parameters":Lcom/amazon/mShop/opl/PurchaseParams;
    .end local v8    # "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    .end local v9    # "context":Landroid/app/Activity;
    .end local v10    # "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    .end local v11    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_1
    :goto_0
    return-void

    .line 49
    .restart local v0    # "parameters":Lcom/amazon/mShop/opl/PurchaseParams;
    .restart local v8    # "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    .restart local v9    # "context":Landroid/app/Activity;
    .restart local v10    # "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    .restart local v11    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_2
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-eq v1, v2, :cond_3

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v1, v2, :cond_4

    .line 52
    :cond_3
    const-string/jumbo v1, "dp_buy_1clk"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 53
    :cond_4
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-eq v1, v2, :cond_5

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-eq v1, v2, :cond_5

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v1, v2, :cond_1

    .line 57
    :cond_5
    const-string/jumbo v1, "dp_buy_pre"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
