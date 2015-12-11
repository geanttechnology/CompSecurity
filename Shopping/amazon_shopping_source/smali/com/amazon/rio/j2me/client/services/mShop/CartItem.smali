.class public Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
.super Ljava/lang/Object;
.source "CartItem.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private badge:Lcom/amazon/rio/j2me/client/services/mShop/Badge;

.field private binding:Ljava/lang/String;

.field private byLine:Ljava/lang/String;

.field private deprecatedEligibleForPrimeShipping:Ljava/lang/Boolean;

.field private eligibleForSuperSaverShipping:Ljava/lang/Boolean;

.field private imageUrl:Ljava/lang/String;

.field private isMinimumThresholdRequired:Ljava/lang/Boolean;

.field private isQuantityEditable:Z

.field private isSavedItem:Z

.field private itemId:Ljava/lang/String;

.field private merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

.field private messages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private msToExpiry:Ljava/lang/Integer;

.field private offerId:Ljava/lang/String;

.field private points:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private quantity:I

.field private shippingCharge:Ljava/lang/String;

.field private shortDescription:Ljava/lang/String;

.field private title:Ljava/lang/String;


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
    .line 57
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getIsSavedItem()Z
    .locals 1

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->isSavedItem:Z

    return v0
.end method

.method public getItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    return-object v0
.end method

.method public getMsToExpiry()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->msToExpiry:Ljava/lang/Integer;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getQuantity()I
    .locals 1

    .prologue
    .line 100
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->quantity:I

    return v0
.end method

.method public getShortDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->shortDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->asin:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setBadge(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .prologue
    .line 268
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->badge:Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .line 269
    return-void
.end method

.method public setBinding(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 242
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->binding:Ljava/lang/String;

    .line 243
    return-void
.end method

.method public setByLine(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 190
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->byLine:Ljava/lang/String;

    .line 191
    return-void
.end method

.method public setDeprecatedEligibleForPrimeShipping(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 216
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->deprecatedEligibleForPrimeShipping:Ljava/lang/Boolean;

    .line 217
    return-void
.end method

.method public setEligibleForSuperSaverShipping(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 229
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->eligibleForSuperSaverShipping:Ljava/lang/Boolean;

    .line 230
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->imageUrl:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public setIsMinimumThresholdRequired(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 281
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->isMinimumThresholdRequired:Ljava/lang/Boolean;

    .line 282
    return-void
.end method

.method public setIsQuantityEditable(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 138
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->isQuantityEditable:Z

    .line 139
    return-void
.end method

.method public setIsSavedItem(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 128
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->isSavedItem:Z

    .line 129
    return-void
.end method

.method public setItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->itemId:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setMerchantInfo(Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    .prologue
    .line 255
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    .line 256
    return-void
.end method

.method public setMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 118
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->messages:Ljava/util/List;

    .line 119
    return-void
.end method

.method public setMsToExpiry(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->msToExpiry:Ljava/lang/Integer;

    .line 165
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->offerId:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setPoints(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->points:Ljava/lang/String;

    .line 152
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->price:Ljava/lang/String;

    .line 96
    return-void
.end method

.method public setQuantity(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 105
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->quantity:I

    .line 106
    return-void
.end method

.method public setShippingCharge(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 203
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->shippingCharge:Ljava/lang/String;

    .line 204
    return-void
.end method

.method public setShortDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->shortDescription:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->title:Ljava/lang/String;

    .line 73
    return-void
.end method
