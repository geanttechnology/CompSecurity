.class public Lcom/comcast/playerplatform/analytics/java/xua/assets/RecordingAsset;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
.source "RecordingAsset.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "recordingId"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;-><init>()V

    .line 13
    const-string v1, "RecordingId"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/RecordingAsset;->setAssetType(Ljava/lang/String;)V

    .line 14
    const-string v1, "cDVR"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/assets/RecordingAsset;->setAssetClass(Ljava/lang/String;)V

    .line 16
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;-><init>()V

    .line 17
    .local v0, "ids":Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->setRECID(Ljava/lang/String;)V

    .line 18
    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/analytics/java/xua/assets/RecordingAsset;->setAssetIds(Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;)V

    .line 19
    return-void
.end method
