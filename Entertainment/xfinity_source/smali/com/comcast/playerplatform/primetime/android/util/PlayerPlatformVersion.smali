.class public Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;
.super Ljava/lang/Object;
.source "PlayerPlatformVersion.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAdobeVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThirdPartyVersions;->getAdobeVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDisneyVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThirdPartyVersions;->getDisneyVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getEspnVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThirdPartyVersions;->getEspnVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getPlayerPlatformVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    const-string v0, "3.4.2.4"

    return-object v0
.end method

.method public static getThirdPartyVersions()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThirdPartyVersions;->getThirdPartyVersions()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method
