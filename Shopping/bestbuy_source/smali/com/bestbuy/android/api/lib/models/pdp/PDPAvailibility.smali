.class public Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

.field private availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

.field private names:Lcom/bestbuy/android/api/lib/models/home/Names;

.field private productType:Ljava/lang/String;

.field private sellerInfo:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    return-object v0
.end method

.method public getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/home/Names;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerInfo()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->sellerInfo:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setAttributes(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    .line 29
    return-void
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    .line 37
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/home/Names;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    .line 45
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->productType:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setSellerInfo(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->sellerInfo:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    .line 61
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPAvailibility;->skuId:Ljava/lang/String;

    .line 69
    return-void
.end method
