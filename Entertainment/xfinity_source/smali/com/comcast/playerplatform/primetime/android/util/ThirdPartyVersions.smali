.class public Lcom/comcast/playerplatform/primetime/android/util/ThirdPartyVersions;
.super Ljava/lang/Object;
.source "ThirdPartyVersions.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAdobeVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    invoke-static {}, Lcom/adobe/mediacore/Version;->getVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDisneyVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->version:Ljava/lang/String;

    return-object v0
.end method

.method public static getEspnVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDK_VERSION:Ljava/lang/String;

    return-object v0
.end method

.method public static getThirdPartyVersions()Ljava/util/Map;
    .locals 3
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
    .line 20
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 21
    .local v0, "versions":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "ESPN"

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDK_VERSION:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    const-string v1, "Disney"

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->version:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    const-string v1, "Adobe"

    invoke-static {}, Lcom/adobe/mediacore/Version;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    return-object v0
.end method
