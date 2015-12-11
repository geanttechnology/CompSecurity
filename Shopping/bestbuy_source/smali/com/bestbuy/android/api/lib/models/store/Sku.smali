.class public Lcom/bestbuy/android/api/lib/models/store/Sku;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private attributes:Lcom/bestbuy/android/api/lib/models/store/Attributes;

.field private availability:Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

.field private names:Lcom/bestbuy/android/api/lib/models/store/Names;

.field private productType:Ljava/lang/String;

.field private sellerInfo:Lcom/bestbuy/android/api/lib/models/store/SellerInfo;

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
.method public getAttributes()Lcom/bestbuy/android/api/lib/models/store/Attributes;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->attributes:Lcom/bestbuy/android/api/lib/models/store/Attributes;

    return-object v0
.end method

.method public getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->availability:Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/store/Names;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->names:Lcom/bestbuy/android/api/lib/models/store/Names;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerInfo()Lcom/bestbuy/android/api/lib/models/store/SellerInfo;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->sellerInfo:Lcom/bestbuy/android/api/lib/models/store/SellerInfo;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setAttributes(Lcom/bestbuy/android/api/lib/models/store/Attributes;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->attributes:Lcom/bestbuy/android/api/lib/models/store/Attributes;

    .line 73
    return-void
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/store/availability/Availability;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->availability:Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    .line 65
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/store/Names;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->names:Lcom/bestbuy/android/api/lib/models/store/Names;

    .line 33
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->productType:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setSellerInfo(Lcom/bestbuy/android/api/lib/models/store/SellerInfo;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->sellerInfo:Lcom/bestbuy/android/api/lib/models/store/SellerInfo;

    .line 41
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->skuId:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 77
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [names = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->names:Lcom/bestbuy/android/api/lib/models/store/Names;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", sellerInfo = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->sellerInfo:Lcom/bestbuy/android/api/lib/models/store/SellerInfo;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", skuId = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->skuId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", productType = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->productType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", availability = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Sku;->availability:Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
