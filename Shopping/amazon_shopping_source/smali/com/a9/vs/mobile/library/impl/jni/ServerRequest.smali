.class public Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;
.super Ljava/lang/Object;
.source "ServerRequest.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ServerRequest__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;)V
    .locals 3
    .param p1, "_data"    # Lcom/a9/vs/mobile/library/impl/jni/ByteArray;
    .param p2, "_id"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;)J

    move-result-wide v0

    invoke-static {v0, v1, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ServerRequest__SWIG_3(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;-><init>(JZ)V

    .line 52
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
    .locals 7
    .param p1, "_data"    # Lcom/a9/vs/mobile/library/impl/jni/ByteArray;
    .param p2, "_id"    # Ljava/lang/String;
    .param p3, "_params"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    .prologue
    .line 47
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;)J

    move-result-wide v0

    invoke-static {p3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v4

    move-object v2, p1

    move-object v3, p2

    move-object v6, p3

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ServerRequest__SWIG_2(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;-><init>(JZ)V

    .line 48
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
    .locals 10
    .param p1, "_data"    # Lcom/a9/vs/mobile/library/impl/jni/ByteArray;
    .param p2, "_id"    # Ljava/lang/String;
    .param p3, "_params"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    .param p4, "_metadata"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    .prologue
    .line 43
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;)J

    move-result-wide v0

    invoke-static {p3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v4

    invoke-static {p4}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v7

    move-object v2, p1

    move-object v3, p2

    move-object v6, p3

    move-object v9, p4

    invoke-static/range {v0 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ServerRequest__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;-><init>(JZ)V

    .line 44
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public clear()V
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_clear(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)V

    .line 56
    return-void
.end method

.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_ServerRequest(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->delete()V

    .line 26
    return-void
.end method

.method public getData()Lcom/a9/vs/mobile/library/impl/jni/ByteArray;
    .locals 4

    .prologue
    .line 89
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_data_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v0

    .line 90
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;-><init>(JZ)V

    goto :goto_0
.end method

.method public getId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_id_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMetadata()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    .locals 4

    .prologue
    .line 80
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_metadata_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v0

    .line 81
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;-><init>(JZ)V

    goto :goto_0
.end method

.method public getParams()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;
    .locals 4

    .prologue
    .line 71
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_params_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v0

    .line 72
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;-><init>(JZ)V

    goto :goto_0
.end method

.method public getResponseHandler()Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;
    .locals 4

    .prologue
    .line 98
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_responseHandler_get(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;)J

    move-result-wide v0

    .line 99
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;-><init>(JZ)V

    goto :goto_0
.end method

.method public setData(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ByteArray;

    .prologue
    .line 85
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_data_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/ByteArray;)V

    .line 86
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_id_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;Ljava/lang/String;)V

    .line 60
    return-void
.end method

.method public setMetadata(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    .prologue
    .line 76
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_metadata_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    .line 77
    return-void
.end method

.method public setParams(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_params_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    .line 68
    return-void
.end method

.method public setResponseHandler(Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;

    .prologue
    .line 94
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ServerRequest_responseHandler_set(JLcom/a9/vs/mobile/library/impl/jni/ServerRequest;JLcom/a9/vs/mobile/library/impl/jni/ServerResponseHandler;)V

    .line 95
    return-void
.end method
