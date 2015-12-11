.class public Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
.super Ljava/lang/Object;
.source "EventDelegateBase.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 54
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_EventDelegateBase()J

    move-result-wide v0

    invoke-direct {p0, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;-><init>(JZ)V

    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    iget-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    invoke-static {p0, v0, v1, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_director_connect(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JZZ)V

    .line 56
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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_EventDelegateBase(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J
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

.method public didDecode(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 6
    .param p1, "objInfoOut"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 71
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDecode(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 72
    :goto_0
    return-void

    .line 71
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDecodeSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    goto :goto_0
.end method

.method public didDecodeFreeText(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V
    .locals 10
    .param p1, "nounsBrandsModelnums"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .param p2, "words"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .param p3, "layout"    # Ljava/lang/String;

    .prologue
    .line 87
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J

    move-result-wide v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J

    move-result-wide v6

    move-object v2, p0

    move-object v5, p1

    move-object v8, p2

    move-object v9, p3

    invoke-static/range {v0 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDecodeFreeText(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V

    .line 88
    :goto_0
    return-void

    .line 87
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J

    move-result-wide v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J

    move-result-wide v6

    move-object v2, p0

    move-object v5, p1

    move-object v8, p2

    move-object v9, p3

    invoke-static/range {v0 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDecodeFreeTextSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public didDecodeTextCanvas(ILjava/lang/String;)V
    .locals 2
    .param p1, "sessionId"    # I
    .param p2, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 95
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDecodeTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ILjava/lang/String;)V

    .line 96
    :goto_0
    return-void

    .line 95
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDecodeTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ILjava/lang/String;)V

    goto :goto_0
.end method

.method public didDetect(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 6
    .param p1, "objInfoOut"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 67
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDetect(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 68
    :goto_0
    return-void

    .line 67
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDetectSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    goto :goto_0
.end method

.method public didDetectInterestPoints(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 6
    .param p1, "points"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 91
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDetectInterestPoints(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 92
    :goto_0
    return-void

    .line 91
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didDetectInterestPointsSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    goto :goto_0
.end method

.method public didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/StatusID;II)V
    .locals 7
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "status"    # Lcom/a9/vs/mobile/library/impl/jni/StatusID;
    .param p3, "processFrameID"    # I
    .param p4, "intentStage"    # I

    .prologue
    .line 63
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/StatusID;->swigValue()I

    move-result v4

    move-object v2, p0

    move v5, p3

    move v6, p4

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didProcessFrame(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IIII)V

    .line 64
    :goto_0
    return-void

    .line 63
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/StatusID;->swigValue()I

    move-result v4

    move-object v2, p0

    move v5, p3

    move v6, p4

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didProcessFrameSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IIII)V

    goto :goto_0
.end method

.method public didProcessFrameDecision(Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;D)V
    .locals 6
    .param p1, "stabilityIssue"    # Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;
    .param p2, "intentScore"    # D

    .prologue
    .line 131
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;->swigValue()I

    move-result v3

    move-object v2, p0

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didProcessFrameDecision(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ID)V

    .line 132
    :goto_0
    return-void

    .line 131
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CameraStabilityIssue;->swigValue()I

    move-result v3

    move-object v2, p0

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didProcessFrameDecisionSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;ID)V

    goto :goto_0
.end method

.method public didProcessModuleDecision(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;)V
    .locals 4
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "judgeOnModule"    # Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .prologue
    .line 135
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue()I

    move-result v3

    invoke-static {v0, v1, p0, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didProcessModuleDecision(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V

    .line 136
    :goto_0
    return-void

    .line 135
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue()I

    move-result v3

    invoke-static {v0, v1, p0, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didProcessModuleDecisionSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V

    goto :goto_0
.end method

.method public didReceieveBadTextCanvasDecode()V
    .locals 2

    .prologue
    .line 111
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didReceieveBadTextCanvasDecode(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    .line 112
    :goto_0
    return-void

    .line 111
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didReceieveBadTextCanvasDecodeSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    goto :goto_0
.end method

.method public didReceiveEvent(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ActionID;Lcom/a9/vs/mobile/library/impl/jni/StatusID;)V
    .locals 6
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "actionType"    # Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    .param p3, "statID"    # Lcom/a9/vs/mobile/library/impl/jni/StatusID;

    .prologue
    .line 59
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue()I

    move-result v4

    invoke-virtual {p3}, Lcom/a9/vs/mobile/library/impl/jni/StatusID;->swigValue()I

    move-result v5

    move-object v2, p0

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didReceiveEvent(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;III)V

    .line 60
    :goto_0
    return-void

    .line 59
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue()I

    move-result v4

    invoke-virtual {p3}, Lcom/a9/vs/mobile/library/impl/jni/StatusID;->swigValue()I

    move-result v5

    move-object v2, p0

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didReceiveEventSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;III)V

    goto :goto_0
.end method

.method public didReceiveServerError(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;)V
    .locals 4
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "reason"    # Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .prologue
    .line 115
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue()I

    move-result v3

    invoke-static {v0, v1, p0, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didReceiveServerError(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V

    .line 116
    :goto_0
    return-void

    .line 115
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue()I

    move-result v3

    invoke-static {v0, v1, p0, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didReceiveServerErrorSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;II)V

    goto :goto_0
.end method

.method public didStopTrackingTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 6
    .param p1, "canvas"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 107
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didStopTrackingTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 108
    :goto_0
    return-void

    .line 107
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didStopTrackingTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    goto :goto_0
.end method

.method public didTrack(ILcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 7
    .param p1, "id"    # I
    .param p2, "loc"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 75
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v4

    move-object v2, p0

    move v3, p1

    move-object v6, p2

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didTrack(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IJLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 76
    :goto_0
    return-void

    .line 75
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v4

    move-object v2, p0

    move v3, p1

    move-object v6, p2

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didTrackSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;IJLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    goto :goto_0
.end method

.method public didTrackFail(I)V
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 79
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didTrackFail(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V

    .line 80
    :goto_0
    return-void

    .line 79
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didTrackFailSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V

    goto :goto_0
.end method

.method public didTrackTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 6
    .param p1, "canvas"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 103
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didTrackTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 104
    :goto_0
    return-void

    .line 103
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didTrackTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    goto :goto_0
.end method

.method public didUpdateTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 6
    .param p1, "canvas"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 99
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didUpdateTextCanvas(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 100
    :goto_0
    return-void

    .line 99
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didUpdateTextCanvasSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    goto :goto_0
.end method

.method public didVerify(I)V
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 83
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didVerify(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V

    .line 84
    :goto_0
    return-void

    .line 83
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_didVerifySwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;I)V

    goto :goto_0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->delete()V

    .line 26
    return-void
.end method

.method public showMessage(Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 127
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_showMessage(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;Ljava/lang/String;)V

    .line 128
    :goto_0
    return-void

    .line 127
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_showMessageSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public suggestBoringEvent()V
    .locals 2

    .prologue
    .line 123
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_suggestBoringEvent(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    .line 124
    :goto_0
    return-void

    .line 123
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_suggestBoringEventSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    goto :goto_0
.end method

.method public suggestStuckEvent()V
    .locals 2

    .prologue
    .line 119
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_suggestStuckEvent(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    .line 120
    :goto_0
    return-void

    .line 119
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_suggestStuckEventSwigExplicitEventDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V

    goto :goto_0
.end method

.method protected swigDirectorDisconnect()V
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    .line 40
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->delete()V

    .line 41
    return-void
.end method

.method public swigReleaseOwnership()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 44
    iput-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    .line 45
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JZ)V

    .line 46
    return-void
.end method

.method public swigTakeOwnership()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 49
    iput-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCMemOwn:Z

    .line 50
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->swigCPtr:J

    invoke-static {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->EventDelegateBase_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;JZ)V

    .line 51
    return-void
.end method
