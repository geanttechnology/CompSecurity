.class public Lcom/espn/androidplayersdk/datamanager/EPStream;
.super Ljava/lang/Object;
.source "EPStream.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x62d5f77dc02b9034L


# instance fields
.field adInsertionEnabled:Z

.field airingId:Ljava/lang/String;

.field alternatePlaybackUrl:Ljava/lang/String;

.field authorizationCookieName:Ljava/lang/String;

.field cdn:Ljava/lang/String;

.field domain:Ljava/lang/String;

.field eventId:Ljava/lang/String;

.field fwSyncTokenUrl:Ljava/lang/String;

.field maintainUrl:Ljava/lang/String;

.field networkId:Ljava/lang/String;

.field playbackUrl:Ljava/lang/String;

.field programChangeUrl:Ljava/lang/String;

.field resource:Ljava/lang/String;

.field token:Ljava/lang/String;

.field ttl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p1, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const-string v0, "eventId"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->eventId:Ljava/lang/String;

    .line 32
    const-string v0, "airingId"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->airingId:Ljava/lang/String;

    .line 33
    const-string v0, "networkId"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->networkId:Ljava/lang/String;

    .line 34
    const-string v0, "playbackUrl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->playbackUrl:Ljava/lang/String;

    .line 35
    const-string v0, "alternatePlaybackUrl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->alternatePlaybackUrl:Ljava/lang/String;

    .line 36
    const-string v0, "token"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->token:Ljava/lang/String;

    .line 37
    const-string v0, "authorizationCookieName"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->authorizationCookieName:Ljava/lang/String;

    .line 38
    const-string v0, "maintainUrl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->maintainUrl:Ljava/lang/String;

    .line 39
    const-string v0, "programChangeUrl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->programChangeUrl:Ljava/lang/String;

    .line 40
    const-string v0, "ttl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->ttl:Ljava/lang/String;

    .line 41
    const-string v0, "domain"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->domain:Ljava/lang/String;

    .line 42
    const-string v0, "cdn"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->cdn:Ljava/lang/String;

    .line 43
    const-string v0, "resource"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->resource:Ljava/lang/String;

    .line 44
    const-string v0, "fwSyncTokenUrl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->fwSyncTokenUrl:Ljava/lang/String;

    .line 45
    const-string v0, "adInsertionEnabled"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->adInsertionEnabled:Z

    .line 46
    return-void
.end method


# virtual methods
.method public getAiringId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->airingId:Ljava/lang/String;

    return-object v0
.end method

.method public getAlternatePlaybackUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->alternatePlaybackUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthCookieName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->authorizationCookieName:Ljava/lang/String;

    return-object v0
.end method

.method protected getCdn()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->cdn:Ljava/lang/String;

    return-object v0
.end method

.method protected getCdnResource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->resource:Ljava/lang/String;

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->domain:Ljava/lang/String;

    return-object v0
.end method

.method public getEventId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->eventId:Ljava/lang/String;

    return-object v0
.end method

.method protected getMaintainUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->maintainUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->networkId:Ljava/lang/String;

    return-object v0
.end method

.method public getPlaybackUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->playbackUrl:Ljava/lang/String;

    return-object v0
.end method

.method protected getProgramChangeUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->programChangeUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->token:Ljava/lang/String;

    return-object v0
.end method

.method public getTtl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->ttl:Ljava/lang/String;

    return-object v0
.end method

.method protected getfwSyncTokenUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->fwSyncTokenUrl:Ljava/lang/String;

    return-object v0
.end method

.method protected isAdInsertionEnabled()Z
    .locals 1

    .prologue
    .line 105
    iget-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/EPStream;->adInsertionEnabled:Z

    return v0
.end method
