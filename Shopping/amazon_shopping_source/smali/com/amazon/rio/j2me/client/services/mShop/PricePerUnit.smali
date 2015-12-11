.class public Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;
.super Ljava/lang/Object;
.source "PricePerUnit.java"


# instance fields
.field private count:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private units:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->count:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getUnits()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->units:Ljava/lang/String;

    return-object v0
.end method

.method public setCount(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->count:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->price:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setUnits(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->units:Ljava/lang/String;

    .line 45
    return-void
.end method
