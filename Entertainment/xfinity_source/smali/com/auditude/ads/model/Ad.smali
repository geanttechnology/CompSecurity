.class public Lcom/auditude/ads/model/Ad;
.super Lcom/auditude/ads/model/BaseElement;
.source "Ad.java"


# instance fields
.field private allowMultipleAds:Ljava/lang/String;

.field private assets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/Asset;",
            ">;"
        }
    .end annotation
.end field

.field private assetsBySegment:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Lcom/auditude/ads/model/Asset;",
            ">;"
        }
    .end annotation
.end field

.field private auditudeParams:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private dispatchError:Ljava/lang/Boolean;

.field private followRedirects:Ljava/lang/Boolean;

.field private isFromVmapDoc:Ljava/lang/Boolean;

.field private isNetworkAd:Z

.field private networkAdSource:Ljava/lang/Object;

.field private networkAdType:Ljava/lang/String;

.field private repackagingEnabled:Z

.field private trackingAssets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/Asset;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;)V
    .locals 3
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 25
    invoke-direct {p0, p1}, Lcom/auditude/ads/model/BaseElement;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 11
    iput-boolean v1, p0, Lcom/auditude/ads/model/Ad;->repackagingEnabled:Z

    .line 14
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->followRedirects:Ljava/lang/Boolean;

    .line 15
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->dispatchError:Ljava/lang/Boolean;

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->trackingAssets:Ljava/util/ArrayList;

    .line 20
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->auditudeParams:Ljava/util/HashMap;

    .line 21
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->isFromVmapDoc:Ljava/lang/Boolean;

    .line 26
    return-void
.end method

.method public static consolidateOnPageAsset(Ljava/util/ArrayList;Lcom/auditude/ads/model/Asset;)V
    .locals 8
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/Asset;",
            ">;",
            "Lcom/auditude/ads/model/Asset;",
            ")V"
        }
    .end annotation

    .prologue
    .line 219
    .local p0, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    instance-of v5, p1, Lcom/auditude/ads/model/OnPageAsset;

    if-eqz v5, :cond_0

    if-nez p0, :cond_1

    .line 245
    :cond_0
    :goto_0
    return-void

    .line 224
    :cond_1
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/Asset;

    .line 227
    .local v1, "tempAsset":Lcom/auditude/ads/model/Asset;
    if-eq v1, p1, :cond_2

    instance-of v6, v1, Lcom/auditude/ads/model/OnPageAsset;

    if-eqz v6, :cond_2

    invoke-virtual {v1}, Lcom/auditude/ads/model/Asset;->getWidth()I

    move-result v6

    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getWidth()I

    move-result v7

    if-ne v6, v7, :cond_2

    invoke-virtual {v1}, Lcom/auditude/ads/model/Asset;->getHeight()I

    move-result v6

    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getHeight()I

    move-result v7

    if-ne v6, v7, :cond_2

    move-object v5, p1

    .line 229
    check-cast v5, Lcom/auditude/ads/model/OnPageAsset;

    invoke-static {v5}, Lcom/auditude/ads/model/Ad;->getCompanionPriority(Lcom/auditude/ads/model/OnPageAsset;)I

    move-result v0

    .local v0, "assetPriority":I
    move-object v5, v1

    .line 230
    check-cast v5, Lcom/auditude/ads/model/OnPageAsset;

    invoke-static {v5}, Lcom/auditude/ads/model/Ad;->getCompanionPriority(Lcom/auditude/ads/model/OnPageAsset;)I

    move-result v2

    .line 233
    .local v2, "tempPriority":I
    if-ge v2, v0, :cond_4

    move-object v4, v1

    .line 234
    .local v4, "toRemove":Lcom/auditude/ads/model/Asset;
    :goto_1
    if-ge v2, v0, :cond_5

    move-object v3, p1

    .line 237
    .local v3, "toKeep":Lcom/auditude/ads/model/Asset;
    :goto_2
    invoke-virtual {v4}, Lcom/auditude/ads/model/Asset;->getResourceType()Ljava/lang/String;

    move-result-object v5

    const-string v6, "static"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 239
    check-cast v3, Lcom/auditude/ads/model/OnPageAsset;

    .end local v3    # "toKeep":Lcom/auditude/ads/model/Asset;
    move-object v5, v4

    check-cast v5, Lcom/auditude/ads/model/OnPageAsset;

    invoke-virtual {v3, v5}, Lcom/auditude/ads/model/OnPageAsset;->setStaticAsset(Lcom/auditude/ads/model/IOnPageAsset;)V

    .line 241
    :cond_3
    invoke-virtual {p0, v4}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v5

    invoke-virtual {p0, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .end local v4    # "toRemove":Lcom/auditude/ads/model/Asset;
    :cond_4
    move-object v4, p1

    .line 233
    goto :goto_1

    .restart local v4    # "toRemove":Lcom/auditude/ads/model/Asset;
    :cond_5
    move-object v3, v1

    .line 234
    goto :goto_2
.end method

.method private static getCompanionPriority(Lcom/auditude/ads/model/OnPageAsset;)I
    .locals 3
    .param p0, "companion"    # Lcom/auditude/ads/model/OnPageAsset;

    .prologue
    .line 249
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getCreativeType()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getCreativeType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "application/x-shockwave-flash"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 251
    const/4 v1, 0x0

    .line 260
    :goto_0
    return v1

    .line 255
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 256
    .local v0, "priority":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    const-string v1, "static"

    const/4 v2, 0x3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 257
    const-string v1, "iframe"

    const/4 v2, 0x2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 258
    const-string v1, "html"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 260
    invoke-virtual {p0}, Lcom/auditude/ads/model/OnPageAsset;->getResourceType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0
.end method


# virtual methods
.method public final addAsset(Lcom/auditude/ads/model/Asset;)V
    .locals 1
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;

    .prologue
    .line 120
    if-nez p1, :cond_0

    .line 129
    :goto_0
    return-void

    .line 122
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assets:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 124
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->assets:Ljava/util/ArrayList;

    .line 127
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assets:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 128
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assets:Ljava/util/ArrayList;

    invoke-static {v0, p1}, Lcom/auditude/ads/model/Ad;->consolidateOnPageAsset(Ljava/util/ArrayList;Lcom/auditude/ads/model/Asset;)V

    goto :goto_0
.end method

.method public final addSegmentById(Ljava/lang/String;[Lcom/auditude/ads/model/Asset;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "assets"    # [Lcom/auditude/ads/model/Asset;

    .prologue
    .line 192
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assetsBySegment:Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 194
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/Ad;->assetsBySegment:Ljava/util/HashMap;

    .line 197
    :cond_0
    if-eqz p2, :cond_1

    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 199
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assetsBySegment:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 201
    :cond_1
    return-void
.end method

.method public final addTrackingAsset(Lcom/auditude/ads/model/Asset;)V
    .locals 1
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;

    .prologue
    .line 158
    if-eqz p1, :cond_0

    .line 160
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->trackingAssets:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 162
    :cond_0
    return-void
.end method

.method public final getAllowMultipleAds()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->allowMultipleAds:Ljava/lang/String;

    return-object v0
.end method

.method public final getAssetById(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;
    .locals 3
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 133
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/auditude/ads/model/Ad;->assets:Ljava/util/ArrayList;

    if-eqz v1, :cond_1

    .line 135
    iget-object v1, p0, Lcom/auditude/ads/model/Ad;->assets:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_2

    .line 144
    :cond_1
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 135
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Asset;

    .line 137
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0
.end method

.method public final getAssetsBySegment(Ljava/lang/String;)[Lcom/auditude/ads/model/Asset;
    .locals 1
    .param p1, "segmentId"    # Ljava/lang/String;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assetsBySegment:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assetsBySegment:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 151
    :cond_0
    const/4 v0, 0x0

    .line 153
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->assetsBySegment:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/auditude/ads/model/Asset;

    goto :goto_0
.end method

.method public final getDispatchError()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->dispatchError:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getFollowRedirects()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->followRedirects:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getIsFromVmapDoc()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->isFromVmapDoc:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getIsNetworkAd()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/auditude/ads/model/Ad;->isNetworkAd:Z

    return v0
.end method

.method public final getNetworkAdSource()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->networkAdSource:Ljava/lang/Object;

    return-object v0
.end method

.method public final getNetworkAdType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/auditude/ads/model/Ad;->networkAdType:Ljava/lang/String;

    return-object v0
.end method

.method public final getTrackingAssetByType(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;
    .locals 3
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 166
    iget-object v1, p0, Lcom/auditude/ads/model/Ad;->trackingAssets:Ljava/util/ArrayList;

    if-eqz v1, :cond_1

    .line 168
    iget-object v1, p0, Lcom/auditude/ads/model/Ad;->trackingAssets:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_3

    .line 187
    :cond_1
    const/4 v0, 0x0

    :cond_2
    :goto_0
    return-object v0

    .line 168
    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Asset;

    .line 170
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    instance-of v2, v0, Lcom/auditude/ads/model/ILinearAsset;

    if-eqz v2, :cond_4

    const-string v2, "linear"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 175
    :cond_4
    instance-of v2, v0, Lcom/auditude/ads/model/INonLinearAsset;

    if-eqz v2, :cond_5

    const-string v2, "nonlinear"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 180
    :cond_5
    instance-of v2, v0, Lcom/auditude/ads/model/IOnPageAsset;

    if-eqz v2, :cond_0

    const-string v2, "companion"

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0
.end method

.method public final isRepackagingEnabled()Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/auditude/ads/model/Ad;->repackagingEnabled:Z

    return v0
.end method

.method public final setAllowMultipleAds(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->allowMultipleAds:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public final setAuditudeParams(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "value":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->auditudeParams:Ljava/util/HashMap;

    .line 36
    return-void
.end method

.method public final setDispatchError(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->dispatchError:Ljava/lang/Boolean;

    .line 96
    return-void
.end method

.method public final setFollowRedirects(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->followRedirects:Ljava/lang/Boolean;

    .line 86
    return-void
.end method

.method public final setIsFromVmapDoc(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->isFromVmapDoc:Ljava/lang/Boolean;

    .line 111
    return-void
.end method

.method public final setIsNetworkAd(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/auditude/ads/model/Ad;->isNetworkAd:Z

    .line 56
    return-void
.end method

.method public final setNetworkAdSource(Ljava/lang/Object;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->networkAdSource:Ljava/lang/Object;

    .line 66
    return-void
.end method

.method public final setNetworkAdType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/auditude/ads/model/Ad;->networkAdType:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public final setRepackagingEnabled(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/auditude/ads/model/Ad;->repackagingEnabled:Z

    .line 46
    return-void
.end method
