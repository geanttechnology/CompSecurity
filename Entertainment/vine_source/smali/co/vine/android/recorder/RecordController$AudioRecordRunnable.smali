.class public Lco/vine/android/recorder/RecordController$AudioRecordRunnable;
.super Ljava/lang/Object;
.source "RecordController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/RecordController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "AudioRecordRunnable"
.end annotation


# instance fields
.field public forceQuit:Z

.field public volatile isInitialized:Z

.field private mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

.field private final mAudioRecord:Landroid/media/AudioRecord;

.field private mCount:I

.field private final mOutput:Ljava/lang/String;

.field final synthetic this$0:Lco/vine/android/recorder/RecordController;


# direct methods
.method private constructor <init>(Lco/vine/android/recorder/RecordController;Ljava/lang/String;I)V
    .locals 6
    .param p2, "file"    # Ljava/lang/String;
    .param p3, "initialCount"    # I

    .prologue
    .line 1037
    iput-object p1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1027
    new-instance v0, Landroid/media/AudioRecord;

    const/4 v1, 0x1

    const v2, 0xac44

    const/16 v3, 0x10

    const/4 v4, 0x2

    sget v5, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_RUNNABLE_SAMPLE_SIZE:I

    invoke-direct/range {v0 .. v5}, Landroid/media/AudioRecord;-><init>(IIIII)V

    iput-object v0, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    .line 1038
    iput p3, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mCount:I

    .line 1039
    iput-object p2, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mOutput:Ljava/lang/String;

    .line 1040
    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/recorder/RecordController;Ljava/lang/String;ILco/vine/android/recorder/RecordController$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/recorder/RecordController;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # I
    .param p4, "x3"    # Lco/vine/android/recorder/RecordController$1;

    .prologue
    .line 1025
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;-><init>(Lco/vine/android/recorder/RecordController;Ljava/lang/String;I)V

    return-void
.end method

.method private record(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/AudioArray;I)V
    .locals 2
    .param p1, "segment"    # Lco/vine/android/recorder/RecordSegment;
    .param p2, "buffer"    # Lco/vine/android/recorder/AudioArray;
    .param p3, "limit"    # I

    .prologue
    .line 1053
    iget-object v0, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioDataBufferMax:Lco/vine/android/recorder/AudioArray;
    invoke-static {v0}, Lco/vine/android/recorder/RecordController;->access$500(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    iget v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mCount:I

    invoke-virtual {p2, v0, v1, p3}, Lco/vine/android/recorder/AudioArray;->putInto(Lco/vine/android/recorder/AudioArray;II)V

    .line 1054
    new-instance v0, Lco/vine/android/recorder/AudioData;

    iget v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mCount:I

    invoke-direct {v0, v1, p3}, Lco/vine/android/recorder/AudioData;-><init>(II)V

    invoke-virtual {p1, v0}, Lco/vine/android/recorder/RecordSegment;->addAudioData(Lco/vine/android/recorder/AudioData;)V

    .line 1055
    iget v0, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mCount:I

    add-int/2addr v0, p3

    iput v0, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mCount:I

    .line 1056
    return-void
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 1060
    const/16 v5, -0x13

    invoke-static {v5}, Landroid/os/Process;->setThreadPriority(I)V

    .line 1061
    const-string v5, "mAudioRecord.startRecording()"

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1062
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mHardwareEncoding:Z
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$600(Lco/vine/android/recorder/RecordController;)Z

    move-result v5

    if-eqz v5, :cond_0

    sget-object v4, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .line 1064
    .local v4, "type":Lco/vine/android/recorder/AudioArray$AudioArrayType;
    :goto_0
    invoke-static {v4}, Lco/vine/android/service/ResourceService;->getAudioDataBuffer(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

    .line 1065
    const-string v5, "Buffer size {}."

    iget-object v6, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

    iget v6, v6, Lco/vine/android/recorder/AudioArray;->length:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1066
    iput-boolean v9, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    .line 1067
    :goto_1
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    invoke-virtual {v5}, Landroid/media/AudioRecord;->getState()I

    move-result v5

    if-nez v5, :cond_1

    .line 1069
    const-wide/16 v5, 0x64

    :try_start_0
    invoke-static {v5, v6}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 1070
    :catch_0
    move-exception v5

    goto :goto_1

    .line 1062
    .end local v4    # "type":Lco/vine/android/recorder/AudioArray$AudioArrayType;
    :cond_0
    sget-object v4, Lco/vine/android/recorder/AudioArray$AudioArrayType;->SHORT:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    goto :goto_0

    .line 1074
    .restart local v4    # "type":Lco/vine/android/recorder/AudioArray$AudioArrayType;
    :cond_1
    iput-boolean v10, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    .line 1075
    const-string v5, "mAudioRecord.isInitialized: {}."

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mOutput:Ljava/lang/String;

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1076
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    invoke-virtual {v5}, Landroid/media/AudioRecord;->startRecording()V

    .line 1081
    :cond_2
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mRunAudioThread:Z
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$700(Lco/vine/android/recorder/RecordController;)Z

    move-result v5

    if-nez v5, :cond_3

    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$800(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v5

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v7}, Lco/vine/android/recorder/RecordController;->access$300(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-lez v5, :cond_4

    :cond_3
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mIsRecordingEnded:Z
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$900(Lco/vine/android/recorder/RecordController;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 1082
    iget-boolean v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->forceQuit:Z

    if-eqz v5, :cond_5

    .line 1123
    :cond_4
    :goto_2
    invoke-static {v4}, Lco/vine/android/service/ResourceService;->releaseAudioBuffer(Lco/vine/android/recorder/AudioArray$AudioArrayType;)V

    .line 1124
    const-string v5, "AudioThread Finished, release mAudioRecord"

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1125
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    invoke-virtual {v5}, Landroid/media/AudioRecord;->stop()V

    .line 1126
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    invoke-virtual {v5}, Landroid/media/AudioRecord;->release()V

    .line 1127
    iput-boolean v9, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->isInitialized:Z

    .line 1128
    const-string v5, "mAudioRecord released: {} {} {}."

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mRunAudioThread:Z
    invoke-static {v7}, Lco/vine/android/recorder/RecordController;->access$700(Lco/vine/android/recorder/RecordController;)Z

    move-result v7

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    aput-object v7, v6, v9

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mIsRecordingEnded:Z
    invoke-static {v7}, Lco/vine/android/recorder/RecordController;->access$900(Lco/vine/android/recorder/RecordController;)Z

    move-result v7

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    aput-object v7, v6, v10

    const/4 v7, 0x2

    iget-object v8, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mOutput:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1129
    return-void

    .line 1085
    :cond_5
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->updateTimestamp()V

    .line 1086
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

    iget-object v6, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

    iget v7, v7, Lco/vine/android/recorder/AudioArray;->length:I

    invoke-virtual {v5, v6, v7}, Lco/vine/android/recorder/AudioArray;->readFrom(Landroid/media/AudioRecord;I)I

    move-result v0

    .line 1087
    .local v0, "bufferReadResult":I
    const/4 v5, -0x3

    if-ne v0, v5, :cond_6

    .line 1088
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Audio Record in invalid state: (valid = 3) "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioRecord:Landroid/media/AudioRecord;

    invoke-virtual {v6}, Landroid/media/AudioRecord;->getState()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_2

    .line 1091
    :cond_6
    if-lez v0, :cond_2

    .line 1092
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTrim:Z
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$1000(Lco/vine/android/recorder/RecordController;)Z

    move-result v5

    if-nez v5, :cond_8

    move v3, v0

    .line 1094
    .local v3, "shouldPut":I
    :goto_3
    if-lez v3, :cond_2

    .line 1095
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mCurrentSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$1100(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/RecordSegment;

    move-result-object v2

    .line 1096
    .local v2, "segment":Lco/vine/android/recorder/RecordSegment;
    if-eqz v2, :cond_9

    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->recordingAudio:Z
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$1200(Lco/vine/android/recorder/RecordController;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 1097
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

    invoke-direct {p0, v2, v5, v3}, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->record(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/AudioArray;I)V

    .line 1098
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # setter for: Lco/vine/android/recorder/RecordController;->mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v5, v2}, Lco/vine/android/recorder/RecordController;->access$1302(Lco/vine/android/recorder/RecordController;Lco/vine/android/recorder/RecordSegment;)Lco/vine/android/recorder/RecordSegment;

    .line 1112
    :cond_7
    :goto_4
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    iget-object v5, v5, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    if-eqz v5, :cond_4

    .line 1115
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    iget-object v5, v5, Lco/vine/android/recorder/RecordController;->mParent:Lco/vine/android/recorder/BasicVineRecorder;

    invoke-virtual {v5}, Lco/vine/android/recorder/BasicVineRecorder;->getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v1

    .line 1116
    .local v1, "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    if-eqz v1, :cond_4

    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$300(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v5

    iget v7, v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->maxDuration:I

    mul-int/lit16 v7, v7, 0x3e8

    int-to-long v7, v7

    cmp-long v5, v5, v7

    if-ltz v5, :cond_2

    goto/16 :goto_2

    .line 1092
    .end local v1    # "config":Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .end local v2    # "segment":Lco/vine/android/recorder/RecordSegment;
    .end local v3    # "shouldPut":I
    :cond_8
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$800(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v5

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v7}, Lco/vine/android/recorder/RecordController;->access$300(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v7

    sub-long/2addr v5, v7

    long-to-double v5, v5

    const-wide v7, 0x3fa694467381d7dcL    # 0.0441

    mul-double/2addr v5, v7

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    add-double/2addr v5, v7

    int-to-double v7, v0

    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->min(DD)D

    move-result-wide v5

    double-to-int v3, v5

    goto :goto_3

    .line 1100
    .restart local v2    # "segment":Lco/vine/android/recorder/RecordSegment;
    .restart local v3    # "shouldPut":I
    :cond_9
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mLastAudioRecordingSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$1300(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/RecordSegment;

    move-result-object v2

    .line 1101
    if-nez v2, :cond_a

    .line 1102
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mLastVideoSegment:Lco/vine/android/recorder/RecordSegment;
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$1400(Lco/vine/android/recorder/RecordController;)Lco/vine/android/recorder/RecordSegment;

    move-result-object v2

    .line 1104
    :cond_a
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J
    invoke-static {v5}, Lco/vine/android/recorder/RecordController;->access$800(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v5

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v7}, Lco/vine/android/recorder/RecordController;->access$300(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-lez v5, :cond_7

    .line 1105
    if-nez v2, :cond_b

    .line 1106
    const-string v5, "Recording have not started yet? {} vs {}."

    iget-object v6, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mVideoTimestamp:J
    invoke-static {v6}, Lco/vine/android/recorder/RecordController;->access$800(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    iget-object v7, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v7}, Lco/vine/android/recorder/RecordController;->access$300(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-static {v5, v6, v7}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_4

    .line 1108
    :cond_b
    iget-object v5, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mAudioDataBuffer:Lco/vine/android/recorder/AudioArray;

    invoke-direct {p0, v2, v5, v3}, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->record(Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/AudioArray;I)V

    goto :goto_4
.end method

.method public updateTimestamp()V
    .locals 5

    .prologue
    .line 1043
    iget-object v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mOutput:Ljava/lang/String;
    invoke-static {v1}, Lco/vine/android/recorder/RecordController;->access$200(Lco/vine/android/recorder/RecordController;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1044
    iget v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->mCount:I

    invoke-static {v1}, Lco/vine/android/recorder/RecordConfigUtils;->getTimeStampInNsFromSampleCounted(I)I

    move-result v0

    .line 1045
    .local v0, "newStamp":I
    iget-object v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    # getter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v1}, Lco/vine/android/recorder/RecordController;->access$300(Lco/vine/android/recorder/RecordController;)J

    move-result-wide v1

    int-to-long v3, v0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_0

    .line 1046
    iget-object v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    int-to-long v2, v0

    # setter for: Lco/vine/android/recorder/RecordController;->mAudioTimestamp:J
    invoke-static {v1, v2, v3}, Lco/vine/android/recorder/RecordController;->access$302(Lco/vine/android/recorder/RecordController;J)J

    .line 1047
    iget-object v1, p0, Lco/vine/android/recorder/RecordController$AudioRecordRunnable;->this$0:Lco/vine/android/recorder/RecordController;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    # setter for: Lco/vine/android/recorder/RecordController;->mAudioTimeRecorded:J
    invoke-static {v1, v2, v3}, Lco/vine/android/recorder/RecordController;->access$402(Lco/vine/android/recorder/RecordController;J)J

    .line 1050
    .end local v0    # "newStamp":I
    :cond_0
    return-void
.end method
