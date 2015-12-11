.class public Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;
.super Ljava/lang/Object;
.source "ObjectInfo.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 43
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ObjectInfo__SWIG_1()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;)V
    .locals 3
    .param p1, "_type"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .prologue
    .line 39
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ObjectInfo__SWIG_0(I)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;-><init>(JZ)V

    .line 40
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_ObjectInfo(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->delete()V

    .line 26
    return-void
.end method

.method public getAlternatives()Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .locals 4

    .prologue
    .line 132
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_alternatives_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J

    move-result-wide v0

    .line 133
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;-><init>(JZ)V

    goto :goto_0
.end method

.method public getContent()Ljava/lang/String;
    .locals 2

    .prologue
    .line 107
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_content_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getEntityType()Ljava/lang/String;
    .locals 2

    .prologue
    .line 99
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_entityType_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getId()I
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_id_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)I

    move-result v0

    return v0
.end method

.method public getLocation()Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;
    .locals 4

    .prologue
    .line 123
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_location_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)J

    move-result-wide v0

    .line 124
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

.method public getObjType()Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .locals 2

    .prologue
    .line 91
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_objType_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    move-result-object v0

    return-object v0
.end method

.method public getQueryID()Ljava/lang/String;
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_queryID_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getQueryStr()Ljava/lang/String;
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_queryStr_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getScore()F
    .locals 2

    .prologue
    .line 115
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_score_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)F

    move-result v0

    return v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 2

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_tag_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUniqueID()Ljava/lang/String;
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_uniqueID_get(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setAlternatives(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    .prologue
    .line 128
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_alternatives_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfString;)V

    .line 129
    return-void
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 103
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_content_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V

    .line 104
    return-void
.end method

.method public setEntityType(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 95
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_entityType_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V

    .line 96
    return-void
.end method

.method public setId(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_id_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;I)V

    .line 48
    return-void
.end method

.method public setLocation(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 119
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_location_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;JLcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V

    .line 120
    return-void
.end method

.method public setObjType(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_objType_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;I)V

    .line 88
    return-void
.end method

.method public setQueryID(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_queryID_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public setQueryStr(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_queryStr_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V

    .line 72
    return-void
.end method

.method public setScore(F)V
    .locals 2
    .param p1, "value"    # F

    .prologue
    .line 111
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_score_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;F)V

    .line 112
    return-void
.end method

.method public setTag(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_tag_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V

    .line 80
    return-void
.end method

.method public setUniqueID(Ljava/lang/String;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ObjectInfo_uniqueID_set(JLcom/a9/vs/mobile/library/impl/jni/ObjectInfo;Ljava/lang/String;)V

    .line 56
    return-void
.end method
