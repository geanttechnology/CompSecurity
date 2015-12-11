.class public Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;
.super Ljava/lang/Object;
.source "VectorOfInt.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_VectorOfInt__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;-><init>(JZ)V

    .line 40
    return-void
.end method

.method public constructor <init>(J)V
    .locals 3
    .param p1, "n"    # J

    .prologue
    .line 43
    invoke-static {p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_VectorOfInt__SWIG_1(J)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public add(I)V
    .locals 2
    .param p1, "x"    # I

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_add(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;I)V

    .line 68
    return-void
.end method

.method public capacity()J
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_capacity(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)J

    move-result-wide v0

    return-wide v0
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_clear(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)V

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_VectorOfInt(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->delete()V

    .line 26
    return-void
.end method

.method public get(I)I
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_get(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;I)I

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_isEmpty(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)Z

    move-result v0

    return v0
.end method

.method public reserve(J)V
    .locals 2
    .param p1, "n"    # J

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_reserve(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;J)V

    .line 56
    return-void
.end method

.method public set(II)V
    .locals 2
    .param p1, "i"    # I
    .param p2, "val"    # I

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_set(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;II)V

    .line 76
    return-void
.end method

.method public size()J
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfInt;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->VectorOfInt_size(JLcom/a9/vs/mobile/library/impl/jni/VectorOfInt;)J

    move-result-wide v0

    return-wide v0
.end method
