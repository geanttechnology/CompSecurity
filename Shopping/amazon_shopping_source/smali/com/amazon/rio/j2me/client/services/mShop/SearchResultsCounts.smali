.class public Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;
.super Ljava/lang/Object;
.source "SearchResultsCounts.java"


# instance fields
.field private availableCount:I

.field private totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailableCount()I
    .locals 1

    .prologue
    .line 28
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;->availableCount:I

    return v0
.end method

.method public setAvailableCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 33
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;->availableCount:I

    .line 34
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 23
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;->totalCount:I

    .line 24
    return-void
.end method
