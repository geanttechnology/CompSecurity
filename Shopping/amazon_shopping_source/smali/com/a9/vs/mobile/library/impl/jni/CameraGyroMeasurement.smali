.class public Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;
.super Ljava/lang/Object;
.source "CameraGyroMeasurement.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_CameraGyroMeasurement()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_CameraGyroMeasurement(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->delete()V

    .line 26
    return-void
.end method

.method public getM_omega()Lcom/a9/vs/mobile/library/impl/jni/Point3d;
    .locals 4

    .prologue
    .line 55
    iget-wide v2, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    invoke-static {v2, v3, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CameraGyroMeasurement_m_omega_get(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)J

    move-result-wide v0

    .line 56
    .local v0, "cPtr":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Lcom/a9/vs/mobile/library/impl/jni/Point3d;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/Point3d;-><init>(JZ)V

    goto :goto_0
.end method

.method public getM_timeSinceInit()D
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CameraGyroMeasurement_m_timeSinceInit_get(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;)D

    move-result-wide v0

    return-wide v0
.end method

.method public setM_omega(Lcom/a9/vs/mobile/library/impl/jni/Point3d;)V
    .locals 6
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/Point3d;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/Point3d;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/Point3d;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CameraGyroMeasurement_m_omega_set(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;JLcom/a9/vs/mobile/library/impl/jni/Point3d;)V

    .line 52
    return-void
.end method

.method public setM_timeSinceInit(D)V
    .locals 2
    .param p1, "value"    # D

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;->swigCPtr:J

    invoke-static {v0, v1, p0, p1, p2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CameraGyroMeasurement_m_timeSinceInit_set(JLcom/a9/vs/mobile/library/impl/jni/CameraGyroMeasurement;D)V

    .line 44
    return-void
.end method
