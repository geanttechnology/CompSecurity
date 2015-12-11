.class public Lco/vine/android/recorder/CameraManager$StartPreviewThread;
.super Ljava/lang/Thread;
.source "CameraManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/CameraManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "StartPreviewThread"
.end annotation


# instance fields
.field private final config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

.field private final currentDuration:J

.field private final frameRate:I

.field private releasedAlready:Z

.field final synthetic this$0:Lco/vine/android/recorder/CameraManager;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/CameraManager;IJ)V
    .locals 1
    .param p2, "frameRate"    # I
    .param p3, "currentDuration"    # J

    .prologue
    .line 392
    iput-object p1, p0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    .line 393
    const-string v0, "StartPreviewThread"

    invoke-direct {p0, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 394
    iput p2, p0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->frameRate:I

    .line 395
    iput-wide p3, p0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->currentDuration:J

    .line 396
    # getter for: Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;
    invoke-static {p1}, Lco/vine/android/recorder/CameraManager;->access$400(Lco/vine/android/recorder/CameraManager;)Lco/vine/android/recorder/RecordController;

    move-result-object v0

    iget-object v0, v0, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .line 397
    return-void
.end method


# virtual methods
.method public notifyReleasedAlready()V
    .locals 1

    .prologue
    .line 400
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    .line 401
    return-void
.end method

.method public run()V
    .locals 20

    .prologue
    .line 406
    new-instance v2, Lco/vine/android/recorder/CameraManager$AddBufferThread;

    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    invoke-direct {v2, v15}, Lco/vine/android/recorder/CameraManager$AddBufferThread;-><init>(Lco/vine/android/recorder/CameraManager;)V

    .line 407
    .local v2, "addThread":Lco/vine/android/recorder/CameraManager$AddBufferThread;
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$400(Lco/vine/android/recorder/CameraManager;)Lco/vine/android/recorder/RecordController;

    move-result-object v15

    if-eqz v15, :cond_b

    .line 408
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    iget v9, v15, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    .line 409
    .local v9, "maxDuration":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    iget v15, v15, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->bufferCount:I

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->frameRate:I

    move/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    move/from16 v17, v0

    div-int v16, v16, v17

    mul-int v15, v15, v16

    int-to-float v15, v15

    int-to-long v0, v9

    move-wide/from16 v16, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->currentDuration:J

    move-wide/from16 v18, v0

    sub-long v16, v16, v18

    move-wide/from16 v0, v16

    long-to-float v0, v0

    move/from16 v16, v0

    int-to-float v0, v9

    move/from16 v17, v0

    div-float v16, v16, v17

    mul-float v15, v15, v16

    float-to-int v15, v15

    const/16 v16, 0x1e

    invoke-static/range {v15 .. v16}, Ljava/lang/Math;->max(II)I

    move-result v15

    div-int/lit8 v4, v15, 0xa

    .line 413
    .local v4, "bufferCount":I
    const-string v15, "Buffer count: {}."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 414
    const/4 v15, 0x0

    move-object/from16 v0, p0

    iput-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    .line 415
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mLOCK:[I
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$500(Lco/vine/android/recorder/CameraManager;)[I

    move-result-object v16

    monitor-enter v16

    .line 416
    :try_start_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;

    move-result-object v15

    if-eqz v15, :cond_0

    move-object/from16 v0, p0

    iget-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    if-nez v15, :cond_0

    .line 417
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$600(Lco/vine/android/recorder/CameraManager;)Ljava/util/Set;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [B

    .line 418
    .local v3, "b":[B
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;

    move-result-object v15

    invoke-virtual {v15, v3}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 419
    add-int/lit8 v4, v4, -0x1

    .line 420
    goto :goto_0

    .line 422
    .end local v3    # "b":[B
    .end local v8    # "i$":Ljava/util/Iterator;
    :cond_0
    const/4 v15, 0x1

    move-object/from16 v0, p0

    iput-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    .line 423
    const-string v15, "Camera was released already."

    invoke-static {v15}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 425
    :cond_1
    monitor-exit v16
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 426
    move-object/from16 v0, p0

    iget-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    if-nez v15, :cond_2

    .line 427
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$300(Lco/vine/android/recorder/CameraManager;)Ljava/util/concurrent/ConcurrentLinkedQueue;

    move-result-object v15

    invoke-virtual {v15}, Ljava/util/concurrent/ConcurrentLinkedQueue;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .restart local v8    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [B

    .line 428
    .restart local v3    # "b":[B
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    invoke-virtual {v15, v3}, Lco/vine/android/recorder/CameraManager;->addCallbackBuffer([B)V

    .line 429
    add-int/lit8 v4, v4, -0x1

    .line 430
    goto :goto_1

    .line 425
    .end local v3    # "b":[B
    .end local v8    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v15

    :try_start_1
    monitor-exit v16
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v15

    .line 432
    :cond_2
    const-string v15, "After reused buffer count: {}."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 433
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 434
    .local v12, "start":J
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mLOCK:[I
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$500(Lco/vine/android/recorder/CameraManager;)[I

    move-result-object v16

    monitor-enter v16

    .line 435
    :try_start_2
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;

    move-result-object v15

    if-eqz v15, :cond_7

    move-object/from16 v0, p0

    iget-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    if-nez v15, :cond_7

    .line 436
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/CameraManager;->access$400(Lco/vine/android/recorder/CameraManager;)Lco/vine/android/recorder/RecordController;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/hardware/Camera;->setPreviewCallbackWithBuffer(Landroid/hardware/Camera$PreviewCallback;)V

    .line 437
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/CameraManager;->access$400(Lco/vine/android/recorder/CameraManager;)Lco/vine/android/recorder/RecordController;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    # setter for: Lco/vine/android/recorder/CameraManager;->mControllerId:Ljava/lang/String;
    invoke-static {v15, v0}, Lco/vine/android/recorder/CameraManager;->access$702(Lco/vine/android/recorder/CameraManager;Ljava/lang/String;)Ljava/lang/String;

    .line 438
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Current camera callback: "

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/CameraManager;->mControllerId:Ljava/lang/String;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/CameraManager;->access$700(Lco/vine/android/recorder/CameraManager;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 442
    :goto_2
    monitor-exit v16
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 443
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 444
    move-object/from16 v0, p0

    iget-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    if-nez v15, :cond_a

    .line 445
    const/4 v11, 0x0

    .line 446
    .local v11, "oomPreAlloc":Z
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    iget-boolean v15, v15, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocateBuffer:Z

    if-eqz v15, :cond_4

    # getter for: Lco/vine/android/recorder/CameraManager;->hasPreallocateBuffers:Z
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->access$800()Z

    move-result v15

    if-nez v15, :cond_4

    .line 447
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mFrameSize:I
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$900(Lco/vine/android/recorder/CameraManager;)I

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v16, v0

    # getter for: Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;
    invoke-static/range {v16 .. v16}, Lco/vine/android/recorder/CameraManager;->access$300(Lco/vine/android/recorder/CameraManager;)Ljava/util/concurrent/ConcurrentLinkedQueue;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I

    move-result v16

    sub-int v16, v4, v16

    mul-int v15, v15, v16

    int-to-double v15, v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-wide v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocRatio:D

    move-wide/from16 v17, v0

    mul-double v15, v15, v17

    double-to-int v10, v15

    .line 448
    .local v10, "n":I
    const-string v15, "Pre-allocate buffer {}: {}."

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-wide v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocRatio:D

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v18

    aput-object v18, v16, v17

    const/16 v17, 0x1

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 449
    const/4 v15, 0x1

    # setter for: Lco/vine/android/recorder/CameraManager;->hasPreallocateBuffers:Z
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$802(Z)Z

    .line 452
    :try_start_3
    new-array v14, v10, [B
    :try_end_3
    .catch Ljava/lang/OutOfMemoryError; {:try_start_3 .. :try_end_3} :catch_0

    .line 458
    .local v14, "tempBuffer":[B
    :goto_3
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v16, v0

    # getter for: Lco/vine/android/recorder/CameraManager;->mFrameSize:I
    invoke-static/range {v16 .. v16}, Lco/vine/android/recorder/CameraManager;->access$900(Lco/vine/android/recorder/CameraManager;)I

    move-result v16

    move/from16 v0, v16

    new-array v0, v0, [B

    move-object/from16 v16, v0

    invoke-static/range {v16 .. v16}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v16

    # setter for: Lco/vine/android/recorder/CameraManager;->mSharedByteBuffer:Ljava/nio/ByteBuffer;
    invoke-static/range {v15 .. v16}, Lco/vine/android/recorder/CameraManager;->access$1002(Lco/vine/android/recorder/CameraManager;Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 459
    if-eqz v14, :cond_3

    .line 460
    const/4 v15, 0x0

    const/16 v16, 0x1

    aput-byte v16, v14, v15

    .line 462
    :cond_3
    const/4 v15, 0x0

    new-array v14, v15, [B

    .line 463
    const/4 v14, 0x0

    .line 464
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 466
    .end local v10    # "n":I
    .end local v14    # "tempBuffer":[B
    :cond_4
    if-eqz v11, :cond_5

    .line 467
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    iget-wide v15, v15, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocRatio:D

    const-wide/high16 v17, 0x3ff0000000000000L    # 1.0

    cmpg-double v15, v15, v17

    if-gtz v15, :cond_5

    int-to-double v15, v4

    const-wide/high16 v17, 0x3fe0000000000000L    # 0.5

    mul-double v15, v15, v17

    double-to-int v4, v15

    .line 471
    :cond_5
    const/4 v15, 0x0

    invoke-static {v4, v15}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 473
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mSharedByteBuffer:Ljava/nio/ByteBuffer;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$1000(Lco/vine/android/recorder/CameraManager;)Ljava/nio/ByteBuffer;

    move-result-object v15

    if-nez v15, :cond_8

    .line 474
    add-int/lit8 v15, v4, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v16, v0

    # getter for: Lco/vine/android/recorder/CameraManager;->mFrameSize:I
    invoke-static/range {v16 .. v16}, Lco/vine/android/recorder/CameraManager;->access$900(Lco/vine/android/recorder/CameraManager;)I

    move-result v16

    filled-new-array/range {v15 .. v16}, [I

    move-result-object v15

    sget-object v16, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    move-object/from16 v0, v16

    invoke-static {v0, v15}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [[B

    .line 475
    .local v5, "buffers":[[B
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    aget-object v16, v5, v4

    invoke-static/range {v16 .. v16}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v16

    # setter for: Lco/vine/android/recorder/CameraManager;->mSharedByteBuffer:Ljava/nio/ByteBuffer;
    invoke-static/range {v15 .. v16}, Lco/vine/android/recorder/CameraManager;->access$1002(Lco/vine/android/recorder/CameraManager;Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 479
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    if-nez v15, :cond_9

    const/4 v15, 0x1

    :goto_5
    move-object/from16 v0, v16

    # setter for: Lco/vine/android/recorder/CameraManager;->mRunAddBufferThread:Z
    invoke-static {v0, v15}, Lco/vine/android/recorder/CameraManager;->access$002(Lco/vine/android/recorder/CameraManager;Z)Z

    .line 480
    invoke-virtual {v2}, Lco/vine/android/recorder/CameraManager$AddBufferThread;->start()V

    .line 481
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_6
    if-ge v7, v4, :cond_a

    .line 482
    rem-int/lit8 v15, v7, 0xf

    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v15, v0, :cond_6

    .line 483
    const-string v15, "Add buffer {}."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 485
    :cond_6
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    aget-object v16, v5, v7

    const/16 v17, 0x0

    invoke-virtual/range {v15 .. v17}, Lco/vine/android/recorder/CameraManager;->addBuffer([BZ)V

    .line 481
    add-int/lit8 v7, v7, 0x1

    goto :goto_6

    .line 440
    .end local v5    # "buffers":[[B
    .end local v7    # "i":I
    .end local v11    # "oomPreAlloc":Z
    :cond_7
    const/4 v15, 0x1

    :try_start_4
    move-object/from16 v0, p0

    iput-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    goto/16 :goto_2

    .line 442
    :catchall_1
    move-exception v15

    monitor-exit v16
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v15

    .line 453
    .restart local v10    # "n":I
    .restart local v11    # "oomPreAlloc":Z
    :catch_0
    move-exception v6

    .line 454
    .local v6, "e":Ljava/lang/OutOfMemoryError;
    const/4 v14, 0x0

    .line 455
    .restart local v14    # "tempBuffer":[B
    const/4 v11, 0x1

    .line 456
    const-string v15, "Pre-allocation failed with ratio {}, ignore pre-allocation step."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->config:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-wide v0, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->preAllocRatio:D

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_3

    .line 477
    .end local v6    # "e":Ljava/lang/OutOfMemoryError;
    .end local v10    # "n":I
    .end local v14    # "tempBuffer":[B
    :cond_8
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mFrameSize:I
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$900(Lco/vine/android/recorder/CameraManager;)I

    move-result v15

    filled-new-array {v4, v15}, [I

    move-result-object v15

    sget-object v16, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    move-object/from16 v0, v16

    invoke-static {v0, v15}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [[B

    .restart local v5    # "buffers":[[B
    goto/16 :goto_4

    .line 479
    :cond_9
    const/4 v15, 0x0

    goto :goto_5

    .line 488
    .end local v5    # "buffers":[[B
    .end local v11    # "oomPreAlloc":Z
    :cond_a
    const-string v15, "Waiting for adding to be done."

    invoke-static {v15}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 489
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    const/16 v16, 0x0

    # setter for: Lco/vine/android/recorder/CameraManager;->mRunAddBufferThread:Z
    invoke-static/range {v15 .. v16}, Lco/vine/android/recorder/CameraManager;->access$002(Lco/vine/android/recorder/CameraManager;Z)Z

    .line 490
    const-string v15, "Making buffer took {} ms."

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    sub-long v18, v18, v12

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 492
    .end local v4    # "bufferCount":I
    .end local v9    # "maxDuration":I
    .end local v12    # "start":J
    :cond_b
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mLOCK:[I
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$500(Lco/vine/android/recorder/CameraManager;)[I

    move-result-object v16

    monitor-enter v16

    .line 493
    :try_start_5
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;

    move-result-object v15

    if-eqz v15, :cond_c

    move-object/from16 v0, p0

    iget-boolean v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->releasedAlready:Z

    if-nez v15, :cond_c

    .line 494
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    const-wide/16 v17, -0x1

    move-wide/from16 v0, v17

    # setter for: Lco/vine/android/recorder/CameraManager;->mLastPreviewFrameTimestamp:J
    invoke-static {v15, v0, v1}, Lco/vine/android/recorder/CameraManager;->access$1102(Lco/vine/android/recorder/CameraManager;J)J

    .line 495
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    const-wide/16 v17, 0x0

    move-wide/from16 v0, v17

    # setter for: Lco/vine/android/recorder/CameraManager;->mFramesReceived:J
    invoke-static {v15, v0, v1}, Lco/vine/android/recorder/CameraManager;->access$1202(Lco/vine/android/recorder/CameraManager;J)J

    .line 496
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v17

    move-wide/from16 v0, v17

    # setter for: Lco/vine/android/recorder/CameraManager;->mPreviewStartTime:J
    invoke-static {v15, v0, v1}, Lco/vine/android/recorder/CameraManager;->access$1302(Lco/vine/android/recorder/CameraManager;J)J

    .line 497
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->this$0:Lco/vine/android/recorder/CameraManager;

    # getter for: Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    invoke-static {v15}, Lco/vine/android/recorder/CameraManager;->access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;

    move-result-object v15

    invoke-virtual {v15}, Landroid/hardware/Camera;->startPreview()V

    .line 499
    :cond_c
    monitor-exit v16
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 501
    :try_start_6
    invoke-virtual {v2}, Lco/vine/android/recorder/CameraManager$AddBufferThread;->join()V
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_1

    .line 505
    :goto_7
    return-void

    .line 499
    :catchall_2
    move-exception v15

    :try_start_7
    monitor-exit v16
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    throw v15

    .line 502
    :catch_1
    move-exception v6

    .line 503
    .local v6, "e":Ljava/lang/InterruptedException;
    const-string v15, "Couldn\'t wait for add thread to join."

    invoke-static {v15}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_7
.end method
