.class public Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;
.super Ljava/lang/Object;
.source "VectorOfImageBuffer.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_VectorOfImageBuffer__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;-><init>(JZ)V

    .line 40
    return-void
.end method

.method public constructor <init>(J)V
    .locals 3
    .param p1, "n"    # J

    .prologue
    .line 43
    invoke-static {p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_VectorOfImageBuffer__SWIG_1(J)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;-><init>(JZ)V

    .line 44
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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public add(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V
    .locals 6
    .param p1, "x"    # Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V

    .line 68
    return-void
.end method

.method public capacity()J
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J

    move-result-wide v0

    return-wide v0
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)V

    .line 64
    return-void
.end method

.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_VectorOfImageBuffer(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->delete()V

    .line 26
    return-void
.end method

.method public get(I)Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;
    .locals 4
    .param p1, "i"    # I

    .prologue
    .line 71
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;

    iget-wide v1, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v1, v2, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;I)J

    move-result-wide v1

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;-><init>(JZ)V

    return-object v0
.end method

.method public isEmpty()Z
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)Z

    move-result v0

    return v0
.end method

.method public reserve(J)V
    .locals 2
    .param p1, "n"    # J

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;J)V

    .line 56
    return-void
.end method

.method public set(ILcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V
    .locals 7
    .param p1, "i"    # I
    .param p2, "val"    # Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)J

    move-result-wide v4

    move-object v2, p0

    move v3, p1

    move-object v6, p2

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;IJLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)V

    .line 76
    return-void
.end method

.method public size()J
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfImageBuffer_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J

    move-result-wide v0

    return-wide v0
.end method
