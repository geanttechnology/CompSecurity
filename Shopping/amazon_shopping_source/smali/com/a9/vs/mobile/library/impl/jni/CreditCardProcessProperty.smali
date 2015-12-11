.class public Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;
.super Ljava/lang/Object;
.source "CreditCardProcessProperty.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 39
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_CreditCardProcessProperty()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;-><init>(JZ)V

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
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_CreditCardProcessProperty(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J
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
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->delete()V

    .line 26
    return-void
.end method

.method public getAutoFlip()Z
    .locals 2

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_autoFlip_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)Z

    move-result v0

    return v0
.end method

.method public getCameraMode()Lcom/a9/vs/mobile/library/impl/jni/CameraMode;
    .locals 2

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_cameraMode_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/CameraMode;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/CameraMode;

    move-result-object v0

    return-object v0
.end method

.method public getMultiThread()Z
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_multiThread_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)Z

    move-result v0

    return v0
.end method

.method public getOrient()Lcom/a9/vs/mobile/library/impl/jni/Orientation;
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_orient_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    move-result-object v0

    return-object v0
.end method

.method public getReadDate()Z
    .locals 2

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_readDate_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)Z

    move-result v0

    return v0
.end method

.method public getScanMode()Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_scanMode_get(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)I

    move-result v0

    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    move-result-object v0

    return-object v0
.end method

.method public setAutoFlip(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_autoFlip_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;Z)V

    .line 84
    return-void
.end method

.method public setCameraMode(Lcom/a9/vs/mobile/library/impl/jni/CameraMode;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/CameraMode;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/CameraMode;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_cameraMode_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;I)V

    .line 60
    return-void
.end method

.method public setMultiThread(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_multiThread_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;Z)V

    .line 68
    return-void
.end method

.method public setOrient(Lcom/a9/vs/mobile/library/impl/jni/Orientation;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_orient_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;I)V

    .line 52
    return-void
.end method

.method public setReadDate(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_readDate_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;Z)V

    .line 76
    return-void
.end method

.method public setScanMode(Lcom/a9/vs/mobile/library/impl/jni/ScanMode;)V
    .locals 3
    .param p1, "value"    # Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardProcessProperty_scanMode_set(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;I)V

    .line 44
    return-void
.end method
