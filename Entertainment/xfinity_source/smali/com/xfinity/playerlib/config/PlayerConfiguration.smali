.class public abstract Lcom/xfinity/playerlib/config/PlayerConfiguration;
.super Ljava/lang/Object;
.source "PlayerConfiguration.java"

# interfaces
.implements Lcom/comcast/cim/config/CALConfiguration;


# instance fields
.field private CONSECUTIVE_TIME_IN_PLAYER_BEFORE_RATINGS_PROMPT:J

.field protected CONSUMABLES_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

.field protected EDITORIAL_COVERS_URI:Ljava/net/URI;

.field protected EDITORIAL_VIDEO_URI:Ljava/net/URI;

.field protected TVE_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

.field protected XIP_URI:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    const-wide/32 v0, 0xdbba0

    iput-wide v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->CONSECUTIVE_TIME_IN_PLAYER_BEFORE_RATINGS_PROMPT:J

    return-void
.end method


# virtual methods
.method public getConsumablesHypermediaUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->CONSUMABLES_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

    return-object v0
.end method

.method public getDataRevalidationIntervalInMillis()J
    .locals 2

    .prologue
    .line 56
    const-wide/32 v0, 0xdbba0

    return-wide v0
.end method

.method public getDeveloperConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    return-object v0
.end method

.method public getEditorialCoversUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->EDITORIAL_COVERS_URI:Ljava/net/URI;

    return-object v0
.end method

.method public getEditorialVideoUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->EDITORIAL_VIDEO_URI:Ljava/net/URI;

    return-object v0
.end method

.method public getEntityThumbnailUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    const-string v0, "http://xfinitytv.comcast.net/api/entity/thumbnail"

    return-object v0
.end method

.method public abstract getFlyinMenuOptions()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;",
            ">;>;"
        }
    .end annotation
.end method

.method public getHypermediaRevalidationInterval()I
    .locals 1

    .prologue
    .line 36
    const v0, 0x5265c00

    return v0
.end method

.method public getMinVersionCheckRevalidationIntervalInMillis()J
    .locals 2

    .prologue
    .line 60
    const-wide/32 v0, 0x5265c00

    return-wide v0
.end method

.method public getRobotoFamilyName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    const-string v0, "roboto"

    return-object v0
.end method

.method public getSplunkAppName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    const-string v0, "androidplayer"

    return-object v0
.end method

.method public getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt()J
    .locals 2

    .prologue
    .line 91
    iget-wide v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->CONSECUTIVE_TIME_IN_PLAYER_BEFORE_RATINGS_PROMPT:J

    return-wide v0
.end method

.method public getTveHypermediaUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->TVE_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

    return-object v0
.end method

.method public getUserAgentPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    const-string v0, "XfinityTVPlayer"

    return-object v0
.end method

.method public getXfinitySansFamilyName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    const-string v0, "xfinitysans"

    return-object v0
.end method

.method public getXipUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xfinity/playerlib/config/PlayerConfiguration;->XIP_URI:Ljava/lang/String;

    return-object v0
.end method

.method public isDarkStreamsEnabled()Z
    .locals 1

    .prologue
    .line 115
    const/4 v0, 0x0

    return v0
.end method

.method public isDeveloperModeAllowed()Z
    .locals 1

    .prologue
    .line 103
    const/4 v0, 0x0

    return v0
.end method

.method public isDeveloperModeEnabled()Z
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x0

    return v0
.end method

.method public setDarkStreamsEnabled(Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "darkStreamsEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 119
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Developer options not available for non-developer builds"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setDeveloperConfiguration(Lcom/xfinity/playerlib/config/PlayerConfiguration;)V
    .locals 2
    .param p1, "configuration"    # Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .prologue
    .line 107
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Developer mode not available for non-developer builds"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setDeveloperModeEnabled(Z)V
    .locals 2
    .param p1, "devMode"    # Z

    .prologue
    .line 99
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Developer mode not available for non-developer builds"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public abstract shouldSuppressNetworkLogos()Z
.end method
