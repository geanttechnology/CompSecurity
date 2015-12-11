.class public Lcom/bestbuy/android/api/lib/models/home/PriceBlock;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x5fa15d3b671867cdL


# instance fields
.field private attributes:Lcom/bestbuy/android/api/lib/models/home/Attributes;

.field private availability:Lcom/bestbuy/android/api/lib/models/home/availability/Availability;

.field private brand:Lcom/bestbuy/android/api/lib/models/home/Brand;

.field private buttonState:Lcom/bestbuy/android/api/lib/models/home/ButtonState;

.field private condition:Ljava/lang/String;

.field private names:Lcom/bestbuy/android/api/lib/models/home/Names;

.field private price:Lcom/bestbuy/android/api/lib/models/home/Price;

.field private productId:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private properties:Lcom/bestbuy/android/api/lib/models/home/Properties;

.field private sellerInfo:Lcom/bestbuy/android/api/lib/models/home/SellerInfo;

.field private skuId:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAttributes()Lcom/bestbuy/android/api/lib/models/home/Attributes;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->attributes:Lcom/bestbuy/android/api/lib/models/home/Attributes;

    return-object v0
.end method

.method public getAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/Availability;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->availability:Lcom/bestbuy/android/api/lib/models/home/availability/Availability;

    return-object v0
.end method

.method public getBrand()Lcom/bestbuy/android/api/lib/models/home/Brand;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->brand:Lcom/bestbuy/android/api/lib/models/home/Brand;

    return-object v0
.end method

.method public getButtonState()Lcom/bestbuy/android/api/lib/models/home/ButtonState;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->buttonState:Lcom/bestbuy/android/api/lib/models/home/ButtonState;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/home/Names;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    return-object v0
.end method

.method public getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->price:Lcom/bestbuy/android/api/lib/models/home/Price;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Lcom/bestbuy/android/api/lib/models/home/Properties;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->properties:Lcom/bestbuy/android/api/lib/models/home/Properties;

    return-object v0
.end method

.method public getSellerInfo()Lcom/bestbuy/android/api/lib/models/home/SellerInfo;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->sellerInfo:Lcom/bestbuy/android/api/lib/models/home/SellerInfo;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setAttributes(Lcom/bestbuy/android/api/lib/models/home/Attributes;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->attributes:Lcom/bestbuy/android/api/lib/models/home/Attributes;

    .line 114
    return-void
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/home/availability/Availability;)V
    .locals 0

    .prologue
    .line 119
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->availability:Lcom/bestbuy/android/api/lib/models/home/availability/Availability;

    .line 120
    return-void
.end method

.method public setBrand(Lcom/bestbuy/android/api/lib/models/home/Brand;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->brand:Lcom/bestbuy/android/api/lib/models/home/Brand;

    .line 126
    return-void
.end method

.method public setButtonState(Lcom/bestbuy/android/api/lib/models/home/ButtonState;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->buttonState:Lcom/bestbuy/android/api/lib/models/home/ButtonState;

    .line 144
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->condition:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/home/Names;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    .line 138
    return-void
.end method

.method public setPrice(Lcom/bestbuy/android/api/lib/models/home/Price;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->price:Lcom/bestbuy/android/api/lib/models/home/Price;

    .line 150
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->productId:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->productType:Ljava/lang/String;

    .line 162
    return-void
.end method

.method public setProperties(Lcom/bestbuy/android/api/lib/models/home/Properties;)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->properties:Lcom/bestbuy/android/api/lib/models/home/Properties;

    .line 168
    return-void
.end method

.method public setSellerInfo(Lcom/bestbuy/android/api/lib/models/home/SellerInfo;)V
    .locals 0

    .prologue
    .line 185
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->sellerInfo:Lcom/bestbuy/android/api/lib/models/home/SellerInfo;

    .line 186
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->skuId:Ljava/lang/String;

    .line 174
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 179
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PriceBlock;->url:Ljava/lang/String;

    .line 180
    return-void
.end method
