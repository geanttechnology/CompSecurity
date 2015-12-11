.class public Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;
.super Lcom/a9/vs/mobile/library/impl/jni/ServerDelegateInterface;
.source "ServerDelegate.java"


# instance fields
.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 54
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ServerDelegate()J

    move-result-wide v0

    invoke-direct {p0, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;-><init>(JZ)V

    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    iget-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCMemOwn:Z

    invoke-static {p0, v0, v1, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_director_connect(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JZZ)V

    .line 56
    return-void
.end method

.method protected constructor <init>(JZ)V
    .locals 2
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-static {p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_SWIGUpcast(J)J

    move-result-wide v0

    invoke-direct {p0, v0, v1, p3}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegateInterface;-><init>(JZ)V

    .line 16
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    .line 17
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;

    .prologue
    .line 20
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 28
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 29
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 30
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCMemOwn:Z

    .line 31
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_ServerDelegate(J)V

    .line 33
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    .line 35
    :cond_1
    invoke-super {p0}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegateInterface;->delete()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    monitor-exit p0

    return-void

    .line 28
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->delete()V

    .line 25
    return-void
.end method

.method public pushServerResponse(Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;)V
    .locals 6
    .param p1, "response"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_pushServerResponse(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)V

    .line 64
    return-void
.end method

.method public sendServerRequest(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
    .locals 6
    .param p1, "request"    # Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;

    .prologue
    .line 59
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_sendServerRequest(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_sendServerRequestSwigExplicitServerDelegate(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z

    move-result v0

    goto :goto_0
.end method

.method protected sendServerRequestImpl(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
    .locals 6
    .param p1, "request"    # Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_sendServerRequestImpl(JLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z

    move-result v0

    return v0
.end method

.method protected swigDirectorDisconnect()V
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCMemOwn:Z

    .line 40
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->delete()V

    .line 41
    return-void
.end method

.method public swigReleaseOwnership()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 44
    iput-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCMemOwn:Z

    .line 45
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JZ)V

    .line 46
    return-void
.end method

.method public swigTakeOwnership()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 49
    iput-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCMemOwn:Z

    .line 50
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->swigCPtr:J

    invoke-static {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerDelegate_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JZ)V

    .line 51
    return-void
.end method
