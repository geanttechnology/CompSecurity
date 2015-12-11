.class public Lcom/a9/vs/mobile/library/impl/jni/StringPair;
.super Ljava/lang/Object;
.source "StringPair.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_StringPair__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/StringPair;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/StringPair;)V
    .locals 3
    .param p1, "p"    # Lcom/a9/vs/mobile/library/impl/jni/StringPair;

    .prologue
    .line 47
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/StringPair;)J

    move-result-wide v0

    invoke-static {v0, v1, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_StringPair__SWIG_2(JLcom/a9/vs/mobile/library/impl/jni/StringPair;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/StringPair;-><init>(JZ)V

    .line 48
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "first"    # Ljava/lang/String;
    .param p2, "second"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-static {p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_StringPair__SWIG_1(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/StringPair;-><init>(JZ)V

    .line 44
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/StringPair;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/StringPair;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_StringPair(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->delete()V

    .line 26
    return-void
.end method

.method public getFirst()Ljava/lang/String;
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->StringPair_first_get(JLcom/a9/vs/mobile/library/impl/jni/StringPair;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSecond()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->StringPair_second_get(JLcom/a9/vs/mobile/library/impl/jni/StringPair;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setFirst(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->StringPair_first_set(JLcom/a9/vs/mobile/library/impl/jni/StringPair;Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public setSecond(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/StringPair;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->StringPair_second_set(JLcom/a9/vs/mobile/library/impl/jni/StringPair;Ljava/lang/String;)V

    .line 60
    return-void
.end method
