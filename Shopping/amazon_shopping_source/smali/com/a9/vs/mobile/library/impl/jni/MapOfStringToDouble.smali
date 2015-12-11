.class public Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;
.super Ljava/lang/Object;
.source "MapOfStringToDouble.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_MapOfStringToDouble__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V
    .locals 3
    .param p1, "arg0"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;

    .prologue
    .line 43
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v0

    invoke-static {v0, v1, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_MapOfStringToDouble__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;-><init>(JZ)V

    .line 44
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    goto :goto_0
.end method

.method public static getKeysForDoubleMap(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .locals 4
    .param p0, "a_map"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;

    .prologue
    .line 75
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    invoke-static {p0}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v1

    invoke-static {v1, v2, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_getKeysForDoubleMap(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v1

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;-><init>(JZ)V

    return-object v0
.end method


# virtual methods
.method public clear()V
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_clear(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V

    .line 56
    return-void
.end method

.method public del(Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_del(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_MapOfStringToDouble(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J
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

.method public empty()Z
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_empty(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)Z

    move-result v0

    return v0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->delete()V

    .line 26
    return-void
.end method

.method public get(Ljava/lang/String;)D
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_get(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method

.method public has_key(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_has_key(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public set(Ljava/lang/String;D)V
    .locals 6
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "x"    # D

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    move-object v2, p0

    move-object v3, p1

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_set(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Ljava/lang/String;D)V

    .line 64
    return-void
.end method

.method public size()J
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MapOfStringToDouble_size(JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v0

    return-wide v0
.end method
