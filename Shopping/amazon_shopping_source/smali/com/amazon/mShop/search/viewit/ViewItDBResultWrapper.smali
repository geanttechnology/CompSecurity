.class public Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;
.super Lcom/amazon/mShop/search/viewit/ResultWrapper;
.source "ViewItDBResultWrapper.java"


# instance fields
.field private mAsinsSequence:Ljava/lang/String;

.field private mSearchResultAsins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V
    .locals 1
    .param p1, "originalScannedOutput"    # Ljava/lang/String;
    .param p2, "asinsSequence"    # Ljava/lang/String;
    .param p3, "scanDate"    # Ljava/util/Date;

    .prologue
    .line 22
    invoke-direct {p0, p1, p3}, Lcom/amazon/mShop/search/viewit/ResultWrapper;-><init>(Ljava/lang/String;Ljava/util/Date;)V

    .line 23
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->mAsinsSequence:Ljava/lang/String;

    .line 24
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->splitAsinSequenceToList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->mSearchResultAsins:Ljava/util/List;

    .line 25
    return-void
.end method

.method private splitAsinSequenceToList()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->mAsinsSequence:Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 42
    iget-object v6, p0, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->mAsinsSequence:Ljava/lang/String;

    const-string/jumbo v7, ","

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 43
    .local v2, "asins":[Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 44
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 45
    .local v5, "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object v0, v2

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 46
    .local v1, "asin":Ljava/lang/String;
    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 45
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 52
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "asin":Ljava/lang/String;
    .end local v2    # "asins":[Ljava/lang/String;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    const/4 v5, 0x0

    :cond_1
    return-object v5
.end method


# virtual methods
.method public getAsinList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDBResultWrapper;->mSearchResultAsins:Ljava/util/List;

    return-object v0
.end method
