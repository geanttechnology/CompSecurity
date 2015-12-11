.class public Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;
.super Ljava/lang/Object;
.source "RecommendedItemsRequest.java"


# instance fields
.field private category:Ljava/lang/String;

.field private context:Ljava/lang/String;

.field private count:I

.field private maxImageDimension:I

.field private startOffset:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->context:Ljava/lang/String;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 54
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->count:I

    return v0
.end method

.method public getMaxImageDimension()I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->maxImageDimension:I

    return v0
.end method

.method public getStartOffset()I
    .locals 1

    .prologue
    .line 44
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->startOffset:I

    return v0
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->category:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 59
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->count:I

    .line 60
    return-void
.end method

.method public setMaxImageDimension(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 26
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->maxImageDimension:I

    .line 27
    return-void
.end method

.method public setStartOffset(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 49
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;->startOffset:I

    .line 50
    return-void
.end method
