.class public abstract Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field protected backordered:Z

.field protected cost:D

.field protected description:Ljava/lang/String;

.field protected extraCosts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;",
            ">;"
        }
    .end annotation
.end field

.field protected itemId:Ljava/lang/String;

.field protected shippingCost:D

.field protected sku:Ljava/lang/String;

.field protected taxCost:D

.field protected unitPrice:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCost()D
    .locals 2

    .prologue
    .line 42
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->cost:D

    return-wide v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getExtraCosts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/capi/order/ExtraCost;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->extraCosts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingCost()D
    .locals 2

    .prologue
    .line 45
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->shippingCost:D

    return-wide v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getTaxCost()D
    .locals 2

    .prologue
    .line 48
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->taxCost:D

    return-wide v0
.end method

.method public getUnitPrice()D
    .locals 2

    .prologue
    .line 39
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->unitPrice:D

    return-wide v0
.end method

.method public isBackordered()Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/order/cart/CartItem;->backordered:Z

    return v0
.end method
