.class public Lcom/bestbuy/android/api/lib/models/cart/CartRequest;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private childType:Ljava/lang/String;

.field private giftItem:Lcom/bestbuy/android/api/lib/models/cart/GiftItem;

.field private listingId:Ljava/lang/String;

.field private lpnId:Ljava/lang/String;

.field private parentLineItemId:Ljava/lang/String;

.field private quantity:I

.field private sellerId:Ljava/lang/String;

.field private shipToStore:Z

.field private skuId:Ljava/lang/String;

.field private storeId:Ljava/lang/String;

.field private strClrFlg:Z

.field private warrantyItem:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getChildType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->childType:Ljava/lang/String;

    return-object v0
.end method

.method public getGiftItem()Lcom/bestbuy/android/api/lib/models/cart/GiftItem;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->giftItem:Lcom/bestbuy/android/api/lib/models/cart/GiftItem;

    return-object v0
.end method

.method public getListingId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->listingId:Ljava/lang/String;

    return-object v0
.end method

.method public getLpnId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->lpnId:Ljava/lang/String;

    return-object v0
.end method

.method public getParentLineItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->parentLineItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getQuantity()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->quantity:I

    return v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->sellerId:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->storeId:Ljava/lang/String;

    return-object v0
.end method

.method public isShipToStore()Z
    .locals 1

    .prologue
    .line 99
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->shipToStore:Z

    return v0
.end method

.method public isStrClrFlg()Z
    .locals 1

    .prologue
    .line 59
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->strClrFlg:Z

    return v0
.end method

.method public isWarrantyItem()Z
    .locals 1

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->warrantyItem:Z

    return v0
.end method

.method public setChildType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->childType:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setGiftItem(Lcom/bestbuy/android/api/lib/models/cart/GiftItem;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->giftItem:Lcom/bestbuy/android/api/lib/models/cart/GiftItem;

    .line 96
    return-void
.end method

.method public setListingId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->listingId:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setLpnId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->lpnId:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setParentLineItemId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->parentLineItemId:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setQuantity(I)V
    .locals 0

    .prologue
    .line 39
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->quantity:I

    .line 40
    return-void
.end method

.method public setSellerId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->sellerId:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public setShipToStore(Z)V
    .locals 0

    .prologue
    .line 103
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->shipToStore:Z

    .line 104
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->skuId:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setStoreId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->storeId:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setStrClrFlg(Z)V
    .locals 0

    .prologue
    .line 63
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->strClrFlg:Z

    .line 64
    return-void
.end method

.method public setWarrantyItem(Z)V
    .locals 0

    .prologue
    .line 127
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->warrantyItem:Z

    .line 128
    return-void
.end method
