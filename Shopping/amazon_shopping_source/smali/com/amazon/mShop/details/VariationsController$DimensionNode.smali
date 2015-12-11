.class Lcom/amazon/mShop/details/VariationsController$DimensionNode;
.super Ljava/lang/Object;
.source "VariationsController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/VariationsController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DimensionNode"
.end annotation


# instance fields
.field private mChildren:[Lcom/amazon/mShop/details/VariationsController$DimensionNode;

.field private mDimension:I

.field private mOption:I


# virtual methods
.method public getChildAt(I)Lcom/amazon/mShop/details/VariationsController$DimensionNode;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 390
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->mChildren:[Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getDimension()I
    .locals 1

    .prologue
    .line 378
    iget v0, p0, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->mDimension:I

    return v0
.end method

.method public getNumChildren()I
    .locals 1

    .prologue
    .line 386
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->mChildren:[Lcom/amazon/mShop/details/VariationsController$DimensionNode;

    array-length v0, v0

    return v0
.end method

.method public getOption()I
    .locals 1

    .prologue
    .line 382
    iget v0, p0, Lcom/amazon/mShop/details/VariationsController$DimensionNode;->mOption:I

    return v0
.end method
