.class public Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.source "ESPNAsset.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .prologue
    .line 16
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2, p3}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V

    .line 17
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "eventId"    # Ljava/lang/String;
    .param p3, "drmKey"    # Ljava/lang/String;
    .param p4, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .prologue
    .line 25
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;-><init>(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)V

    .line 26
    return-void
.end method
