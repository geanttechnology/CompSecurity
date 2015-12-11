.class public Lcom/bestbuy/android/api/lib/models/store/Attributes;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private lowPriceGuaranteedProduct:Ljava/lang/String;

.field private magnoliaProduct:Ljava/lang/String;

.field private onlineOnly:Ljava/lang/String;

.field private specialOrderDelivery:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLowPriceGuaranteedProduct()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->lowPriceGuaranteedProduct:Ljava/lang/String;

    return-object v0
.end method

.method public getMagnoliaProduct()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->magnoliaProduct:Ljava/lang/String;

    return-object v0
.end method

.method public getOnlineOnly()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->onlineOnly:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialOrderDelivery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->specialOrderDelivery:Ljava/lang/String;

    return-object v0
.end method

.method public setLowPriceGuaranteedProduct(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->lowPriceGuaranteedProduct:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setMagnoliaProduct(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->magnoliaProduct:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setOnlineOnly(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->onlineOnly:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setSpecialOrderDelivery(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->specialOrderDelivery:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 55
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ClassPojo [magnoliaProduct = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->magnoliaProduct:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", specialOrderDelivery = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->specialOrderDelivery:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", lowPriceGuaranteedProduct = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->lowPriceGuaranteedProduct:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", onlineOnly = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/models/store/Attributes;->onlineOnly:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
