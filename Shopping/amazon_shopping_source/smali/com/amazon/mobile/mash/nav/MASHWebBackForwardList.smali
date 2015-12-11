.class public Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;
.super Ljava/lang/Object;
.source "MASHWebBackForwardList.java"


# instance fields
.field private mCurrentIndex:I

.field private mWebHistoryItemList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mWebHistoryItemList:Ljava/util/List;

    .line 28
    return-void
.end method


# virtual methods
.method public addHistoryItem(Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;)V
    .locals 4
    .param p1, "item"    # Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    .prologue
    .line 87
    iget v3, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    .line 90
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mWebHistoryItemList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    .line 91
    .local v2, "size":I
    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    .line 92
    .local v1, "newPos":I
    if-eq v1, v2, :cond_0

    .line 93
    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-lt v0, v1, :cond_0

    .line 94
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mWebHistoryItemList:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 93
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 98
    .end local v0    # "i":I
    :cond_0
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mWebHistoryItemList:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 99
    return-void
.end method

.method public getCurrentIndex()I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    return v0
.end method

.method public getCurrentItem()Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->getItemAtIndex(I)Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    move-result-object v0

    return-object v0
.end method

.method public getItemAtIndex(I)Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 65
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->getSize()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 66
    :cond_0
    const/4 v0, 0x0

    .line 68
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mWebHistoryItemList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHWebHistoryItem;

    goto :goto_0
.end method

.method public getSize()I
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mWebHistoryItemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public setCurrentIndex(I)V
    .locals 0
    .param p1, "currentIndex"    # I

    .prologue
    .line 53
    iput p1, p0, Lcom/amazon/mobile/mash/nav/MASHWebBackForwardList;->mCurrentIndex:I

    .line 54
    return-void
.end method
