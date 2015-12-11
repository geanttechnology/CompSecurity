.class public Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
.source "GenericAsset.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
    include = .enum Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;->NON_NULL:Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "assetClass"    # Ljava/lang/String;
    .param p2, "namespace"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p3, "identifiers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;-><init>()V

    .line 21
    const-string v1, "GenericId"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;->setAssetType(Ljava/lang/String;)V

    .line 22
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;->setAssetClass(Ljava/lang/String;)V

    .line 24
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;-><init>()V

    .line 25
    .local v0, "ids":Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setNS(Ljava/lang/String;)V

    .line 26
    invoke-virtual {v0, p3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setOtherIds(Ljava/util/Map;)V

    .line 27
    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/assets/GenericAsset;->setAssetIds(Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;)V

    .line 28
    return-void
.end method
