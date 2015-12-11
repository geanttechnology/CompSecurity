.class public Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;
.super Ljava/lang/Object;
.source "ViewItAccelerometerManager.java"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# instance fields
.field private mAccelerometerThreshold:F

.field private mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

.field private mIsRunning:Z

.field private mIsSteady:Z

.field private mLastAccelX:F

.field private mLastAccelY:F

.field private mLastAccelZ:F

.field private mLastSteadyStatus:Z

.field private mSensorManager:Landroid/hardware/SensorManager;

.field private mSteadinessThreshold:I

.field private mSteadyFrames:I


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastSteadyStatus:Z

    .line 21
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .line 22
    return-void
.end method


# virtual methods
.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0
    .param p1, "a_sensor"    # Landroid/hardware/Sensor;
    .param p2, "a_accuracy"    # I

    .prologue
    .line 96
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 12
    .param p1, "a_event"    # Landroid/hardware/SensorEvent;

    .prologue
    const/4 v3, 0x1

    const/4 v9, 0x0

    .line 56
    iget-object v10, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v0, v10, v9

    .line 57
    .local v0, "accelX":F
    iget-object v10, p1, Landroid/hardware/SensorEvent;->values:[F

    aget v1, v10, v3

    .line 58
    .local v1, "accelY":F
    iget-object v10, p1, Landroid/hardware/SensorEvent;->values:[F

    const/4 v11, 0x2

    aget v2, v10, v11

    .line 60
    .local v2, "accelZ":F
    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelX:F

    sub-float/2addr v10, v0

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v4

    .line 61
    .local v4, "deltaX":F
    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelY:F

    sub-float/2addr v10, v1

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v5

    .line 62
    .local v5, "deltaY":F
    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelZ:F

    sub-float/2addr v10, v2

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v6

    .line 64
    .local v6, "deltaZ":F
    iput v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelX:F

    .line 65
    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelY:F

    .line 66
    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelZ:F

    .line 68
    iget v8, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mAccelerometerThreshold:F

    .line 69
    .local v8, "threshold":F
    cmpg-float v10, v4, v8

    if-gez v10, :cond_1

    cmpg-float v10, v5, v8

    if-gez v10, :cond_1

    cmpg-float v10, v6, v8

    if-gez v10, :cond_1

    .line 70
    .local v3, "currentlySteady":Z
    :goto_0
    const/4 v7, 0x0

    .line 71
    .local v7, "isSteadyEnough":Z
    monitor-enter p0

    .line 72
    :try_start_0
    iget-boolean v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsRunning:Z

    if-eqz v9, :cond_0

    .line 74
    if-eqz v3, :cond_3

    .line 75
    iget v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadyFrames:I

    iget v10, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadinessThreshold:I

    if-lt v9, v10, :cond_2

    .line 76
    const/4 v7, 0x1

    .line 83
    :goto_1
    iput-boolean v7, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsSteady:Z

    .line 85
    iget-boolean v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsSteady:Z

    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastSteadyStatus:Z

    if-eq v9, v10, :cond_0

    .line 86
    iget-boolean v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsSteady:Z

    iput-boolean v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastSteadyStatus:Z

    .line 87
    iget-object v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    invoke-virtual {v9}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v9

    iget-boolean v10, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsSteady:Z

    invoke-virtual {v9, v10}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->updateSteadyStatus(Z)V

    .line 90
    :cond_0
    monitor-exit p0

    .line 91
    return-void

    .end local v3    # "currentlySteady":Z
    .end local v7    # "isSteadyEnough":Z
    :cond_1
    move v3, v9

    .line 69
    goto :goto_0

    .line 78
    .restart local v3    # "currentlySteady":Z
    .restart local v7    # "isSteadyEnough":Z
    :cond_2
    iget v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadyFrames:I

    add-int/lit8 v9, v9, 0x1

    iput v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadyFrames:I

    goto :goto_1

    .line 90
    :catchall_0
    move-exception v9

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v9

    .line 81
    :cond_3
    const/4 v9, 0x0

    :try_start_1
    iput v9, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadyFrames:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method public start()V
    .locals 5

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 25
    const/high16 v2, 0x40000000    # 2.0f

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mAccelerometerThreshold:F

    .line 26
    const/4 v2, 0x5

    iput v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadinessThreshold:I

    .line 27
    iput v4, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelX:F

    .line 28
    iput v4, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelY:F

    .line 29
    iput v4, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mLastAccelZ:F

    .line 30
    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSteadyFrames:I

    .line 31
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsRunning:Z

    .line 32
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsSteady:Z

    .line 34
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    const-string/jumbo v4, "sensor"

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/SensorManager;

    iput-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSensorManager:Landroid/hardware/SensorManager;

    .line 35
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v2, v3}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v0

    .line 36
    .local v0, "accelerometer":Landroid/hardware/Sensor;
    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSensorManager:Landroid/hardware/SensorManager;

    const/4 v4, 0x3

    invoke-virtual {v2, p0, v0, v4}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    move-result v2

    if-eqz v2, :cond_0

    move v1, v3

    .line 37
    .local v1, "success":Z
    :cond_0
    if-nez v1, :cond_1

    .line 39
    iput-boolean v3, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsSteady:Z

    .line 41
    :cond_1
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 44
    monitor-enter p0

    .line 45
    const/4 v0, 0x0

    :try_start_0
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mIsRunning:Z

    .line 46
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSensorManager:Landroid/hardware/SensorManager;

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSensorManager:Landroid/hardware/SensorManager;

    invoke-virtual {v0, p0}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 51
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAccelerometerManager;->mSensorManager:Landroid/hardware/SensorManager;

    .line 52
    return-void

    .line 46
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
