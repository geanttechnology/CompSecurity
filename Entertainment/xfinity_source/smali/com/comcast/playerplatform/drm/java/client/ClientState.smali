.class public Lcom/comcast/playerplatform/drm/java/client/ClientState;
.super Ljava/lang/Object;
.source "ClientState.java"

# interfaces
.implements Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;


# instance fields
.field private tokens:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;",
            "Lcom/comcast/playerplatform/drm/java/client/SecurityToken;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    .line 14
    return-void
.end method


# virtual methods
.method public addSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityToken;)V
    .locals 3
    .param p1, "securityToken"    # Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    .prologue
    .line 39
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    monitor-enter v1

    .line 41
    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->getType()Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    monitor-exit v1

    .line 43
    return-void

    .line 42
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public deleteAllSecurityTokens()V
    .locals 1

    .prologue
    .line 63
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    .line 64
    return-void
.end method

.method public getTokens()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;",
            "Lcom/comcast/playerplatform/drm/java/client/SecurityToken;",
            ">;"
        }
    .end annotation

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    return-object v0
.end method

.method public retrieveSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    .locals 2
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    .prologue
    .line 47
    iget-object v1, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    monitor-enter v1

    .line 49
    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    monitor-exit v1

    return-object v0

    .line 50
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public setTokens(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;",
            "Lcom/comcast/playerplatform/drm/java/client/SecurityToken;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p1, "tokens":Ljava/util/Map;, "Ljava/util/Map<Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Lcom/comcast/playerplatform/drm/java/client/SecurityToken;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/ClientState;->tokens:Ljava/util/Map;

    .line 22
    return-void
.end method
