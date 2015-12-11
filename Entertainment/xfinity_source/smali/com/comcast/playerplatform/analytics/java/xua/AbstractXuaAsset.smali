.class public abstract Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
.super Ljava/lang/Object;
.source "AbstractXuaAsset.java"


# instance fields
.field private assetClass:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CLASS"
    .end annotation
.end field

.field private assetIds:Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "IDS"
    .end annotation
.end field

.field private assetInfo:Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "INFO"
    .end annotation
.end field

.field private assetParent:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PARENT"
    .end annotation
.end field

.field private assetType:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "ID_TYPE"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAssetClass()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 73
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetClass:Ljava/lang/String;

    return-object v0
.end method

.method public getAssetIds()Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetIds:Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;

    return-object v0
.end method

.method public getAssetInfo()Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetInfo:Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;

    return-object v0
.end method

.method public getAssetParent()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetParent:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    return-object v0
.end method

.method public getAssetType()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetType:Ljava/lang/String;

    return-object v0
.end method

.method public setAssetClass(Ljava/lang/String;)V
    .locals 0
    .param p1, "assetClass"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetClass:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setAssetIds(Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;)V
    .locals 0
    .param p1, "assetIds"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 38
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetIds:Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;

    .line 39
    return-void
.end method

.method public setAssetInfo(Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;)V
    .locals 0
    .param p1, "info"    # Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetInfo:Lcom/comcast/playerplatform/analytics/java/xua/AnalyticsAssetInfo;

    .line 55
    return-void
.end method

.method public setAssetParent(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0
    .param p1, "assetParent"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetParent:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 69
    return-void
.end method

.method public setAssetType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 50
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;->assetType:Ljava/lang/String;

    .line 51
    return-void
.end method
