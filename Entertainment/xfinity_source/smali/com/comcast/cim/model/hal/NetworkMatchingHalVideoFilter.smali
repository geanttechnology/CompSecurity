.class public Lcom/comcast/cim/model/hal/NetworkMatchingHalVideoFilter;
.super Lcom/comcast/cim/model/hal/HalVideoFilter;
.source "NetworkMatchingHalVideoFilter.java"


# instance fields
.field private final matchingNetworkIds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# virtual methods
.method protected matches(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;)Z
    .locals 4
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/model/hal/NetworkMatchingHalVideoFilter;->matchingNetworkIds:Ljava/util/List;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getProvider()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
