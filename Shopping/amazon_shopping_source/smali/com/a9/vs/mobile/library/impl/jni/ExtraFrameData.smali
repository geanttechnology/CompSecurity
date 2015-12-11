.class public Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;
.super Ljava/lang/Object;
.source "ExtraFrameData.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ExtraFrameData__SWIG_0()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;-><init>(JZ)V

    .line 40
    return-void
.end method

.method public constructor <init>(IIIIZID)V
    .locals 3
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "isFlat"    # Z
    .param p6, "orient"    # I
    .param p7, "timeStamp"    # D

    .prologue
    .line 43
    invoke-static/range {p1 .. p8}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_ExtraFrameData__SWIG_1(IIIIZID)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_ExtraFrameData(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->delete()V

    .line 26
    return-void
.end method

.method public getFlat()Z
    .locals 2

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_flat_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)Z

    move-result v0

    return v0
.end method

.method public getHeightDisp()I
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_heightDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I

    move-result v0

    return v0
.end method

.method public getScreenOrient()I
    .locals 2

    .prologue
    .line 91
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_screenOrient_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I

    move-result v0

    return v0
.end method

.method public getTimeSinceInit()D
    .locals 2

    .prologue
    .line 99
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_timeSinceInit_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)D

    move-result-wide v0

    return-wide v0
.end method

.method public getWidthDisp()I
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_widthDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I

    move-result v0

    return v0
.end method

.method public getXDisp()I
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_xDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I

    move-result v0

    return v0
.end method

.method public getYDisp()I
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_yDisp_get(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;)I

    move-result v0

    return v0
.end method

.method public setFlat(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_flat_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;Z)V

    .line 80
    return-void
.end method

.method public setHeightDisp(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_heightDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V

    .line 72
    return-void
.end method

.method public setScreenOrient(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_screenOrient_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V

    .line 88
    return-void
.end method

.method public setTimeSinceInit(D)V
    .locals 2
    .param p1, "value"    # D

    .prologue
    .line 95
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_timeSinceInit_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;D)V

    .line 96
    return-void
.end method

.method public setWidthDisp(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_widthDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V

    .line 64
    return-void
.end method

.method public setXDisp(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_xDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V

    .line 48
    return-void
.end method

.method public setYDisp(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->ExtraFrameData_yDisp_set(JLcom/a9/vs/mobile/library/impl/jni/ExtraFrameData;I)V

    .line 56
    return-void
.end method
