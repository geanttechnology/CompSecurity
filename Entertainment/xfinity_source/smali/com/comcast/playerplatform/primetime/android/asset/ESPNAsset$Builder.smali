.class public Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
.source "ESPNAsset.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "eventId"    # Ljava/lang/String;
    .param p3, "drmKey"    # Ljava/lang/String;
    .param p4, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;-><init>()V

    .line 30
    invoke-virtual {p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;->forEspn(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 31
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;-><init>()V

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->withStreamId(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->build()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;->withAssetInfo(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 34
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;->asStreamType(Lcom/comcast/playerplatform/primetime/android/enums/StreamType;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 35
    invoke-virtual {p0, p3}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;->withCustomDRMKey(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 36
    invoke-virtual {p0, p4}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;->withDisneyEspnTokenDelegate(Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 37
    return-void
.end method
