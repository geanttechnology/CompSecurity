.class public Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
.super Ljava/lang/Object;
.source "HomeItem.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

.field private basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

.field private clickStreamOrigin:Ljava/lang/String;

.field private imageUrl:Ljava/lang/String;

.field private itemDescription:Ljava/lang/String;

.field private link:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

.field private remembersId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    return-object v0
.end method

.method public getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->asin:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->basicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .line 59
    return-void
.end method

.method public setBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->basicProduct:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .line 46
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->clickStreamOrigin:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->imageUrl:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setItemDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->itemDescription:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public setLink(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->link:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .line 124
    return-void
.end method

.method public setRemembersId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->remembersId:Ljava/lang/String;

    .line 72
    return-void
.end method
