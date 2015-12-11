.class public Lcom/amazon/mShop/control/item/BuyButtonController;
.super Ljava/lang/Object;
.source "BuyButtonController.java"


# instance fields
.field private final dealId:Ljava/lang/String;

.field private final offerId:Ljava/lang/String;

.field private primeOneClickShippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

.field private final productController:Lcom/amazon/mShop/control/item/ProductController;

.field private final shippingSpeed:Ljava/lang/String;

.field private final type:Lcom/amazon/mShop/control/item/BuyButtonType;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 1
    .param p1, "type"    # Lcom/amazon/mShop/control/item/BuyButtonType;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    const/4 v0, 0x0

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->type:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 63
    iput-object p2, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 64
    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->offerId:Ljava/lang/String;

    .line 65
    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->dealId:Ljava/lang/String;

    .line 66
    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->shippingSpeed:Ljava/lang/String;

    .line 67
    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->primeOneClickShippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .line 68
    return-void
.end method

.method constructor <init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "type"    # Lcom/amazon/mShop/control/item/BuyButtonType;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "offerId"    # Ljava/lang/String;
    .param p4, "dealId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput-object p1, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->type:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 53
    iput-object p2, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 54
    iput-object p3, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->offerId:Ljava/lang/String;

    .line 55
    iput-object p4, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->dealId:Ljava/lang/String;

    .line 56
    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->shippingSpeed:Ljava/lang/String;

    .line 57
    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->primeOneClickShippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .line 58
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;)V
    .locals 1
    .param p1, "type"    # Lcom/amazon/mShop/control/item/BuyButtonType;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "offerId"    # Ljava/lang/String;
    .param p4, "dealId"    # Ljava/lang/String;
    .param p5, "primeOneClickShippingOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->type:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 28
    iput-object p2, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 29
    iput-object p3, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->offerId:Ljava/lang/String;

    .line 30
    iput-object p4, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->dealId:Ljava/lang/String;

    .line 31
    invoke-virtual {p5}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getShipOption()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->shippingSpeed:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->primeOneClickShippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .line 33
    return-void
.end method

.method constructor <init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "type"    # Lcom/amazon/mShop/control/item/BuyButtonType;
    .param p2, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "offerId"    # Ljava/lang/String;
    .param p4, "dealId"    # Ljava/lang/String;
    .param p5, "shippingSpeed"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->type:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 41
    iput-object p2, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 42
    iput-object p3, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->offerId:Ljava/lang/String;

    .line 43
    iput-object p4, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->dealId:Ljava/lang/String;

    .line 44
    iput-object p5, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->shippingSpeed:Ljava/lang/String;

    .line 45
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->primeOneClickShippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .line 46
    return-void
.end method


# virtual methods
.method public getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->type:Lcom/amazon/mShop/control/item/BuyButtonType;

    return-object v0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->dealId:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimeOneClickShippingOffer()Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->primeOneClickShippingOffer:Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    return-object v0
.end method

.method public getProductController()Lcom/amazon/mShop/control/item/ProductController;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    return-object v0
.end method

.method public getShippingSpeed()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyButtonController;->shippingSpeed:Ljava/lang/String;

    return-object v0
.end method
