.class public Lcom/comcast/playerplatform/analytics/java/xua/assets/StreamingAsset;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
.source "StreamingAsset.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
    include = .enum Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;->NON_NULL:Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;-><init>()V

    .line 19
    const-string v1, "StreamId"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/StreamingAsset;->setAssetType(Ljava/lang/String;)V

    .line 20
    const-string v1, "Linear"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/StreamingAsset;->setAssetClass(Ljava/lang/String;)V

    .line 21
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;-><init>()V

    .line 22
    .local v0, "ids":Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setSTRID(Ljava/lang/String;)V

    .line 23
    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/assets/StreamingAsset;->setAssetIds(Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;)V

    .line 24
    return-void
.end method
