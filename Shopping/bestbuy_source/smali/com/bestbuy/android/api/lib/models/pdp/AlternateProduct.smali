.class public Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private format:Ljava/lang/String;

.field private price:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

.field private productId:Ljava/lang/String;

.field private skuId:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->price:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setFormat(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->format:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setPrice(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->price:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    .line 33
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->productId:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->skuId:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->url:Ljava/lang/String;

    .line 57
    return-void
.end method
