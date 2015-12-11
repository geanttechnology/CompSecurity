.class public Lcom/poshmark/utils/MetaItemList;
.super Ljava/util/ArrayList;
.source "MetaItemList.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/ArrayList",
        "<",
        "Lcom/poshmark/data_model/models/MetaItem;",
        ">;"
    }
.end annotation


# instance fields
.field private final limit:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "limit"    # I

    .prologue
    .line 20
    .local p0, "this":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<TT;>;"
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 21
    iput p1, p0, Lcom/poshmark/utils/MetaItemList;->limit:I

    .line 22
    return-void
.end method


# virtual methods
.method public addToGlobalList(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 2
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 40
    .local p0, "this":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<TT;>;"
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v0

    iget v1, p0, Lcom/poshmark/utils/MetaItemList;->limit:I

    if-lt v0, v1, :cond_0

    .line 41
    invoke-virtual {p0}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/MetaItemList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 43
    :cond_0
    const/4 v0, 0x0

    invoke-super {p0, v0, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 45
    const/4 v0, 0x1

    return v0
.end method

.method public addToRecentList(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 2
    .param p1, "metaItem"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 30
    .local p0, "this":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<TT;>;"
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v0

    iget v1, p0, Lcom/poshmark/utils/MetaItemList;->limit:I

    if-lt v0, v1, :cond_0

    .line 31
    invoke-virtual {p0}, Lcom/poshmark/utils/MetaItemList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/MetaItemList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 33
    :cond_0
    const/4 v0, 0x0

    invoke-super {p0, v0, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 35
    const/4 v0, 0x1

    return v0
.end method

.method public getLimit()I
    .locals 1

    .prologue
    .line 25
    .local p0, "this":Lcom/poshmark/utils/MetaItemList;, "Lcom/poshmark/utils/MetaItemList<TT;>;"
    iget v0, p0, Lcom/poshmark/utils/MetaItemList;->limit:I

    return v0
.end method
