.class public abstract Lcom/comcast/cim/model/hal/HalVideoFilter;
.super Ljava/lang/Object;
.source "HalVideoFilter.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public filter(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 11
    .local p1, "input":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 13
    .local v1, "filtered":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .line 14
    .local v0, "element":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/model/hal/HalVideoFilter;->matches(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 15
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 18
    .end local v0    # "element":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    :cond_1
    return-object v1
.end method

.method protected abstract matches(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;)Z
.end method
