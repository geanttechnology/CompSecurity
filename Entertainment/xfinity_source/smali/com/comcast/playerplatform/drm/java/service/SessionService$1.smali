.class Lcom/comcast/playerplatform/drm/java/service/SessionService$1;
.super Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
.source "SessionService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/drm/java/service/SessionService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/service/SessionService;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 43
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 45
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-virtual {v1, p1, p2, p3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 47
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 48
    return-void
.end method

.method public serverSecurityError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "majorError"    # Ljava/lang/String;
    .param p3, "majorErrorDesc"    # Ljava/lang/String;
    .param p4, "messageId"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 55
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 57
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-virtual {v1, p1, p2, p3, p4}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->serverSecurityError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 59
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 60
    return-void
.end method

.method public sessionCreated()V
    .locals 4

    .prologue
    .line 64
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 66
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 68
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->sessionCreated()V

    goto :goto_0

    .line 70
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 71
    return-void
.end method

.method public unprovisionedError()V
    .locals 4

    .prologue
    .line 29
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v3

    monitor-enter v3

    .line 31
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/service/SessionService$1;->this$0:Lcom/comcast/playerplatform/drm/java/service/SessionService;

    # getter for: Lcom/comcast/playerplatform/drm/java/service/SessionService;->listeners:Ljava/util/Vector;
    invoke-static {v2}, Lcom/comcast/playerplatform/drm/java/service/SessionService;->access$000(Lcom/comcast/playerplatform/drm/java/service/SessionService;)Ljava/util/Vector;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    .line 33
    .local v1, "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-virtual {v1}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->unprovisionedError()V

    goto :goto_0

    .line 35
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 36
    return-void
.end method
