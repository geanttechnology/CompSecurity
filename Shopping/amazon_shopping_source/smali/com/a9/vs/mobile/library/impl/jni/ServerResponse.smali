.class public Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;
.super Ljava/lang/Object;
.source "ServerResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    }
.end annotation


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ServerResponse()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;-><init>(JZ)V

    .line 40
    return-void
.end method

.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_ServerResponse(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    :cond_1
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->delete()V

    .line 26
    return-void
.end method

.method public getCompressed()Z
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_compressed_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)Z

    move-result v0

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_id_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getResponseStr()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_responseStr_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getResponseType()Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_responseType_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    move-result-object v0

    return-object v0
.end method

.method public getRoundtripTime()D
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_roundtripTime_get(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;)D

    move-result-wide v0

    return-wide v0
.end method

.method public setCompressed(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_compressed_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;Z)V

    .line 52
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_id_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method public setResponseStr(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_responseStr_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method public setResponseType(Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_responseType_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;I)V

    .line 68
    return-void
.end method

.method public setRoundtripTime(D)V
    .locals 2
    .param p1, "value"    # D

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerResponse_roundtripTime_set(JLcom/a9/vs/mobile/library/impl/jni/ServerResponse;D)V

    .line 76
    return-void
.end method
