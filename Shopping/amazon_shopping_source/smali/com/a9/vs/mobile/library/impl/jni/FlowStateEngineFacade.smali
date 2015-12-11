.class public Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;
.super Ljava/lang/Object;
.source "FlowStateEngineFacade.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)V
    .locals 3
    .param p1, "eventDelegate"    # Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;

    .prologue
    .line 39
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)J

    move-result-wide v0

    invoke-static {v0, v1, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_FlowStateEngineFacade(JLcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;-><init>(JZ)V

    .line 40
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)V
    .locals 7
    .param p1, "a_objType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "a_serverDelegate"    # Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)J

    move-result-wide v4

    move-object v2, p0

    move-object v6, p2

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_addObjectModule__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)V

    .line 88
    return-void
.end method

.method public addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
    .locals 10
    .param p1, "a_objType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "a_serverDelegate"    # Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;
    .param p3, "a_props"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    .prologue
    .line 99
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)J

    move-result-wide v4

    invoke-static {p3}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v7

    move-object v2, p0

    move-object v6, p2

    move-object v9, p3

    invoke-static/range {v0 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_addObjectModule__SWIG_2(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    .line 100
    return-void
.end method

.method public addObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Ljava/lang/String;)V
    .locals 8
    .param p1, "a_objType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "a_serverDelegate"    # Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;
    .param p3, "a_props"    # Ljava/lang/String;

    .prologue
    .line 91
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;)J

    move-result-wide v4

    move-object v2, p0

    move-object v6, p2

    move-object v7, p3

    invoke-static/range {v0 .. v7}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_addObjectModule__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/ServerDelegate;Ljava/lang/String;)V

    .line 92
    return-void
.end method

.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_FlowStateEngineFacade(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J
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

.method public enableEventLogging()V
    .locals 2

    .prologue
    .line 143
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_enableEventLogging(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 144
    return-void
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->delete()V

    .line 26
    return-void
.end method

.method public getAndClearMetrics(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Z)V
    .locals 10
    .param p1, "a_countMap"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;
    .param p2, "a_timeMap"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;
    .param p3, "a_onlyNonZeroes"    # Z

    .prologue
    .line 139
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)J

    move-result-wide v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v6

    move-object v2, p0

    move-object v5, p1

    move-object v8, p2

    move v9, p3

    invoke-static/range {v0 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_getAndClearMetrics(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;Z)V

    .line 140
    return-void
.end method

.method public getCameraResRequirement(Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)V
    .locals 6
    .param p1, "a_requirement"    # Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_getCameraResRequirement(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/CameraResRequirement;)V

    .line 44
    return-void
.end method

.method public getDecodeFrame(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;Z)Z
    .locals 8
    .param p1, "a_uniqueID"    # Ljava/lang/String;
    .param p2, "a_image"    # Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;
    .param p3, "remove"    # Z

    .prologue
    .line 131
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;)J

    move-result-wide v4

    move-object v2, p0

    move-object v3, p1

    move-object v6, p2

    move v7, p3

    invoke-static/range {v0 .. v7}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_getDecodeFrame(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;Z)Z

    move-result v0

    return v0
.end method

.method public getRequestImageBuffers(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;Lcom/a9/vs/mobile/library/impl/jni/FrameID;)V
    .locals 9
    .param p1, "a_images"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;
    .param p2, "frameId"    # Lcom/a9/vs/mobile/library/impl/jni/FrameID;

    .prologue
    .line 119
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J

    move-result-wide v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/FrameID;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/FrameID;)J

    move-result-wide v6

    move-object v2, p0

    move-object v5, p1

    move-object v8, p2

    invoke-static/range {v0 .. v8}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_getRequestImageBuffers(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/FrameID;)V

    .line 120
    return-void
.end method

.method public getRequestImageDefs(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)V
    .locals 6
    .param p1, "a_imageDefs"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;

    .prologue
    .line 115
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_getRequestImageDefs(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageDef;)V

    .line 116
    return-void
.end method

.method public pauseEngine()V
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_pauseEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 80
    return-void
.end method

.method public process(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;Lcom/a9/vs/mobile/library/impl/jni/SensorData;)V
    .locals 12
    .param p1, "a_image"    # Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;
    .param p2, "a_extraFrameData"    # Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;
    .param p3, "a_sensorData"    # Lcom/a9/vs/mobile/library/impl/jni/SensorData;

    .prologue
    .line 123
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ImageBuffer;)J

    move-result-wide v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)J

    move-result-wide v6

    invoke-static {p3}, Lcom/a9/vs/mobile/library/impl/jni/SensorData;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/SensorData;)J

    move-result-wide v9

    move-object v2, p0

    move-object v5, p1

    move-object v8, p2

    move-object v11, p3

    invoke-static/range {v0 .. v11}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_process__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;JLcom/a9/vs/mobile/library/impl/jni/ImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;JLcom/a9/vs/mobile/library/impl/jni/SensorData;)V

    .line 124
    return-void
.end method

.method public process(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;Lcom/a9/vs/mobile/library/impl/jni/SensorData;)V
    .locals 13
    .param p1, "a_frameId"    # Ljava/lang/String;
    .param p2, "a_images"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;
    .param p3, "a_extraFrameData"    # Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;
    .param p4, "a_sensorData"    # Lcom/a9/vs/mobile/library/impl/jni/SensorData;

    .prologue
    .line 127
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;)J

    move-result-wide v4

    invoke-static/range {p3 .. p3}, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)J

    move-result-wide v7

    invoke-static/range {p4 .. p4}, Lcom/a9/vs/mobile/library/impl/jni/SensorData;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/SensorData;)J

    move-result-wide v10

    move-object v2, p0

    move-object v3, p1

    move-object v6, p2

    move-object/from16 v9, p3

    move-object/from16 v12, p4

    invoke-static/range {v0 .. v12}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_process__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;JLcom/a9/vs/mobile/library/impl/jni/VectorOfImageBuffer;JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;JLcom/a9/vs/mobile/library/impl/jni/SensorData;)V

    .line 128
    return-void
.end method

.method public readObjectModuleProps(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V
    .locals 7
    .param p1, "a_objType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "a_props"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    .prologue
    .line 103
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)J

    move-result-wide v4

    move-object v2, p0

    move-object v6, p2

    invoke-static/range {v0 .. v6}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_readObjectModuleProps__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;IJLcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)V

    .line 104
    return-void
.end method

.method public readObjectModuleProps(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Ljava/lang/String;)V
    .locals 3
    .param p1, "a_objType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "a_props"    # Ljava/lang/String;

    .prologue
    .line 95
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_readObjectModuleProps__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;ILjava/lang/String;)V

    .line 96
    return-void
.end method

.method public readProps(Ljava/lang/String;)V
    .locals 2
    .param p1, "a_props"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_readProps(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public removeAllObjectModules()V
    .locals 2

    .prologue
    .line 111
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_removeAllObjectModules(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 112
    return-void
.end method

.method public removeObject(I)V
    .locals 2
    .param p1, "a_id"    # I

    .prologue
    .line 135
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_removeObject(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;I)V

    .line 136
    return-void
.end method

.method public removeObjectModule(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;)V
    .locals 3
    .param p1, "a_objType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .prologue
    .line 107
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_removeObjectModule(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;I)V

    .line 108
    return-void
.end method

.method public resumeEngine()V
    .locals 2

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_resumeEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 84
    return-void
.end method

.method public saveEventLog(Ljava/lang/String;)V
    .locals 2
    .param p1, "a_filepath"    # Ljava/lang/String;

    .prologue
    .line 147
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_saveEventLog(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V

    .line 148
    return-void
.end method

.method public setLanguage(Ljava/lang/String;)V
    .locals 2
    .param p1, "lang"    # Ljava/lang/String;

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_setLanguage(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V

    .line 64
    return-void
.end method

.method public setZipcodeDatabase(Ljava/lang/String;)V
    .locals 2
    .param p1, "a_file"    # Ljava/lang/String;

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_setZipcodeDatabase(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method public setupLocalTextRecognitionEngine(Ljava/lang/String;)V
    .locals 2
    .param p1, "a_configFile"    # Ljava/lang/String;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_setupLocalTextRecognitionEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public signalStrongNetworkConnection()V
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_signalStrongNetworkConnection(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 60
    return-void
.end method

.method public signalWeakNetworkConnection()V
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_signalWeakNetworkConnection(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 56
    return-void
.end method

.method public startEngine()V
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_startEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 72
    return-void
.end method

.method public stopEngine()V
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->FlowStateEngineFacade_stopEngine(JLcom/a9/vs/mobile/library/impl/jni/FlowStateEngineFacade;)V

    .line 76
    return-void
.end method
