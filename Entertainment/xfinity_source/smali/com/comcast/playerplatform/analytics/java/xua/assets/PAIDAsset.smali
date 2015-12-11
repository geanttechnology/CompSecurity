.class public Lcom/comcast/playerplatform/analytics/java/xua/assets/PAIDAsset;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
.source "PAIDAsset.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
    include = .enum Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;->NON_NULL:Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "assetClass"    # Ljava/lang/String;
    .param p2, "pid"    # Ljava/lang/String;
    .param p3, "aid"    # Ljava/lang/String;
    .param p4, "mediaGuid"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;-><init>()V

    .line 23
    const-string v1, "PAID"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/PAIDAsset;->setAssetType(Ljava/lang/String;)V

    .line 24
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/PAIDAsset;->setAssetClass(Ljava/lang/String;)V

    .line 25
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;-><init>()V

    .line 26
    .local v0, "ids":Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    invoke-virtual {v0, p2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setPID(Ljava/lang/String;)V

    .line 27
    invoke-virtual {v0, p3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setAID(Ljava/lang/String;)V

    .line 28
    invoke-virtual {v0, p4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setMediaGUID(Ljava/lang/String;)V

    .line 29
    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/assets/PAIDAsset;->setAssetIds(Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;)V

    .line 30
    return-void
.end method
