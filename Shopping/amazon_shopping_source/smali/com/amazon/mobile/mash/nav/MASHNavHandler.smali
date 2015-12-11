.class public abstract Lcom/amazon/mobile/mash/nav/MASHNavHandler;
.super Ljava/lang/Object;
.source "MASHNavHandler.java"


# instance fields
.field private mCurrentIndex:I

.field private mMASHNavigationPlugin:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

.field private mOperationList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHNavOperation;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)V
    .locals 0
    .param p1, "plugin"    # Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    .param p3, "currentIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHNavOperation;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p2, "operationList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mMASHNavigationPlugin:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    .line 30
    iput-object p2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    .line 31
    iput p3, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    .line 32
    return-void
.end method


# virtual methods
.method public getCurrentOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    .locals 3

    .prologue
    .line 64
    const/4 v0, 0x0

    .line 65
    .local v0, "currentOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    if-ltz v1, :cond_0

    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    iget-object v2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 66
    iget-object v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    iget v2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "currentOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    .line 68
    .restart local v0    # "currentOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    :cond_0
    return-object v0
.end method

.method public getMASHNavigationPlugin()Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mMASHNavigationPlugin:Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;

    return-object v0
.end method

.method public getNextOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    .locals 3

    .prologue
    .line 76
    const/4 v0, 0x0

    .line 77
    .local v0, "nextOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    if-ltz v1, :cond_0

    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    iget-object v2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ge v1, v2, :cond_0

    .line 78
    iget-object v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    iget v2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    add-int/lit8 v2, v2, 0x1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "nextOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    .line 80
    .restart local v0    # "nextOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    :cond_0
    return-object v0
.end method

.method public getPreOperation()Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    .locals 3

    .prologue
    .line 52
    const/4 v0, 0x0

    .line 53
    .local v0, "preOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    if-lez v1, :cond_0

    iget v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    iget-object v2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 54
    iget-object v1, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    iget v2, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "preOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    check-cast v0, Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    .line 56
    .restart local v0    # "preOperation":Lcom/amazon/mobile/mash/nav/MASHNavOperation;
    :cond_0
    return-object v0
.end method

.method public getRemainingOperations()[Ljava/lang/String;
    .locals 5

    .prologue
    .line 88
    const/4 v2, 0x0

    .line 89
    .local v2, "operations":[Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    .line 90
    .local v1, "operationListSize":I
    iget v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    add-int/lit8 v4, v1, -0x1

    if-ge v3, v4, :cond_0

    .line 91
    add-int/lit8 v3, v1, -0x1

    iget v4, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    sub-int/2addr v3, v4

    new-array v2, v3, [Ljava/lang/String;

    .line 92
    iget v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    add-int/lit8 v0, v3, 0x1

    .local v0, "j":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 93
    iget v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mCurrentIndex:I

    sub-int v3, v0, v3

    add-int/lit8 v4, v3, -0x1

    iget-object v3, p0, Lcom/amazon/mobile/mash/nav/MASHNavHandler;->mOperationList:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mobile/mash/nav/MASHNavOperation;

    invoke-virtual {v3}, Lcom/amazon/mobile/mash/nav/MASHNavOperation;->toJSONString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    .line 92
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 96
    .end local v0    # "j":I
    :cond_0
    return-object v2
.end method

.method public abstract navigate()V
.end method
