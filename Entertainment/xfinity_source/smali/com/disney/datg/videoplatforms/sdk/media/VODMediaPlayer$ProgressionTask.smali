.class Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;
.super Ljava/util/TimerTask;
.source "VODMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ProgressionTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)V
    .locals 0

    .prologue
    .line 144
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/16 v9, 0x63

    const/16 v8, 0x4b

    const/16 v7, 0x32

    const/16 v6, 0x19

    .line 148
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->isPlaying()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 152
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentPosition()I

    move-result v0

    .line 154
    .local v0, "currentPosition":I
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-virtual {v4, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->isCurrentTimeInAdBreak(I)Z

    .line 156
    div-int/lit16 v1, v0, 0x3e8

    .line 157
    .local v1, "currentSeconds":I
    mul-int/lit8 v4, v0, 0x64

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getDuration()I

    move-result v5

    div-int v2, v4, v5

    .line 159
    .local v2, "currentWatchedPercentage":I
    if-lt v2, v9, :cond_2

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$100(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)I

    move-result v4

    if-ge v4, v9, :cond_2

    .line 160
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4, v9}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;I)I

    .line 161
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->COMPLETE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 176
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-nez v4, :cond_1

    .line 178
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->nextPingTime:I

    if-lt v1, v4, :cond_1

    .line 180
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-boolean v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->needsPing:Z

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    if-eqz v4, :cond_1

    .line 182
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    const/4 v5, 0x0

    iput-boolean v5, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->needsPing:Z

    .line 183
    if-nez v1, :cond_5

    .line 186
    :try_start_0
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    const-string v6, "start"

    invoke-virtual {v4, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->ping(ILjava/lang/String;)Ljava/util/concurrent/Future;

    move-result-object v4

    const-wide/16 v6, 0x5

    sget-object v8, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v4, v6, v7, v8}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    iput v4, v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->nextPingTime:I
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2

    .line 213
    .end local v0    # "currentPosition":I
    .end local v1    # "currentSeconds":I
    .end local v2    # "currentWatchedPercentage":I
    :cond_1
    :goto_1
    return-void

    .line 163
    .restart local v0    # "currentPosition":I
    .restart local v1    # "currentSeconds":I
    .restart local v2    # "currentWatchedPercentage":I
    :cond_2
    if-lt v2, v8, :cond_3

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$100(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)I

    move-result v4

    if-ge v4, v8, :cond_3

    .line 164
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;I)I

    .line 165
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->COMPLETE_75:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    goto :goto_0

    .line 167
    :cond_3
    if-lt v2, v7, :cond_4

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$100(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)I

    move-result v4

    if-ge v4, v7, :cond_4

    .line 168
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4, v7}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;I)I

    .line 169
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->COMPLETE_50:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    goto :goto_0

    .line 171
    :cond_4
    if-lt v2, v6, :cond_0

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$100(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)I

    move-result v4

    if-ge v4, v6, :cond_0

    .line 172
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I
    invoke-static {v4, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;I)I

    .line 173
    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->COMPLETE_25:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    goto :goto_0

    .line 188
    :catch_0
    move-exception v3

    .line 189
    .local v3, "e":Ljava/lang/InterruptedException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 190
    .end local v3    # "e":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v3

    .line 191
    .local v3, "e":Ljava/util/concurrent/ExecutionException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 192
    .end local v3    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_2
    move-exception v3

    .line 193
    .local v3, "e":Ljava/util/concurrent/TimeoutException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 199
    .end local v3    # "e":Ljava/util/concurrent/TimeoutException;
    :cond_5
    :try_start_1
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v4, v4, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    const/4 v6, 0x0

    invoke-virtual {v4, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->ping(ILjava/lang/String;)Ljava/util/concurrent/Future;

    move-result-object v4

    const-wide/16 v6, 0x5

    sget-object v8, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v4, v6, v7, v8}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    iput v4, v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->nextPingTime:I
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_5

    goto/16 :goto_1

    .line 200
    :catch_3
    move-exception v3

    .line 201
    .local v3, "e":Ljava/lang/InterruptedException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 202
    .end local v3    # "e":Ljava/lang/InterruptedException;
    :catch_4
    move-exception v3

    .line 203
    .local v3, "e":Ljava/util/concurrent/ExecutionException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 204
    .end local v3    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_5
    move-exception v3

    .line 205
    .local v3, "e":Ljava/util/concurrent/TimeoutException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1
.end method
