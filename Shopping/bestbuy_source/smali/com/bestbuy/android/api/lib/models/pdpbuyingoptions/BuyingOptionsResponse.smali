.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private buyingOptions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private names:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;

.field private productType:Ljava/lang/String;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBuyingOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->buyingOptions:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->names:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setBuyingOptions(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->buyingOptions:Ljava/util/ArrayList;

    .line 26
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->names:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;

    .line 34
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->productType:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->skuId:Ljava/lang/String;

    .line 50
    return-void
.end method
