.class public Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;
.super Ljava/lang/Object;
.source "TextCanvasInfo.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 150
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_TextCanvasInfo()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;-><init>(JZ)V

    .line 151
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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_TextCanvasInfo(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->delete()V

    .line 26
    return-void
.end method

.method public getAllEntities()Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;
    .locals 4

    .prologue
    .line 109
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_allEntities_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 110
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;-><init>(JZ)V

    goto :goto_0
.end method

.method public getBusinessCard()Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;
    .locals 4

    .prologue
    .line 118
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_businessCard_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 119
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;-><init>(JZ)V

    goto :goto_0
.end method

.method public getCanvasBounds()Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;
    .locals 4

    .prologue
    .line 91
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_canvasBounds_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 92
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;-><init>(JZ)V

    goto :goto_0
.end method

.method public getCanvasType()Lcom/a9/vs/mobile/library/impl/jni/TextCanvasType;
    .locals 2

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_canvasType_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasType;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/TextCanvasType;

    move-result-object v0

    return-object v0
.end method

.method public getDegreesClockwiseToAlign()I
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_degreesClockwiseToAlign_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)I

    move-result v0

    return v0
.end method

.method public getId()I
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_id_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)I

    move-result v0

    return v0
.end method

.method public getIsVerified()Z
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_isVerified_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)Z

    move-result v0

    return v0
.end method

.method public getLayout()Ljava/lang/String;
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_layout_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getScaledCanvasBounds()Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;
    .locals 4

    .prologue
    .line 127
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_scaledCanvasBounds_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 128
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;-><init>(JZ)V

    goto :goto_0
.end method

.method public getScaledScreenBounds()Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;
    .locals 4

    .prologue
    .line 136
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_scaledScreenBounds_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 137
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;-><init>(JZ)V

    goto :goto_0
.end method

.method public getScaledWords()Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;
    .locals 4

    .prologue
    .line 145
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_scaledWords_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 146
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;-><init>(JZ)V

    goto :goto_0
.end method

.method public getUniqueID()Ljava/lang/String;
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_uniqueID_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVisibleWords()Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;
    .locals 4

    .prologue
    .line 100
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_visibleWords_get(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)J

    move-result-wide v0

    .line 101
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;-><init>(JZ)V

    goto :goto_0
.end method

.method public setAllEntities(Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;

    .prologue
    .line 105
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_allEntities_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V

    .line 106
    return-void
.end method

.method public setBusinessCard(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;

    .prologue
    .line 114
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_businessCard_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/BusinessCardInfo;)V

    .line 115
    return-void
.end method

.method public setCanvasBounds(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_canvasBounds_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 88
    return-void
.end method

.method public setCanvasType(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasType;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasType;

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasType;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_canvasType_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;I)V

    .line 80
    return-void
.end method

.method public setDegreesClockwiseToAlign(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_degreesClockwiseToAlign_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;I)V

    .line 56
    return-void
.end method

.method public setId(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 39
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_id_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;I)V

    .line 40
    return-void
.end method

.method public setIsVerified(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_isVerified_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;Z)V

    .line 64
    return-void
.end method

.method public setLayout(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_layout_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;Ljava/lang/String;)V

    .line 72
    return-void
.end method

.method public setScaledCanvasBounds(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 123
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_scaledCanvasBounds_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 124
    return-void
.end method

.method public setScaledScreenBounds(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 132
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_scaledScreenBounds_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 133
    return-void
.end method

.method public setScaledWords(Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;

    .prologue
    .line 141
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_scaledWords_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V

    .line 142
    return-void
.end method

.method public setUniqueID(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_uniqueID_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public setVisibleWords(Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;

    .prologue
    .line 96
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->TextCanvasInfo_visibleWords_set(JLcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfObjectInfo;)V

    .line 97
    return-void
.end method
