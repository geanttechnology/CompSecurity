.class public Lcom/aio/downloader/utils/Player;
.super Ljava/lang/Object;
.source "Player.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnBufferingUpdateListener;
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# instance fields
.field ctx:Landroid/content/Context;

.field handler:Landroid/os/Handler;

.field private mTimer:Ljava/util/Timer;

.field public mediaPlayer:Landroid/media/MediaPlayer;

.field private seekBar:Landroid/widget/SeekBar;

.field timerTask:Ljava/util/TimerTask;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/SeekBar;)V
    .locals 7
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/Player;->mTimer:Ljava/util/Timer;

    .line 45
    new-instance v0, Lcom/aio/downloader/utils/Player$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/Player$1;-><init>(Lcom/aio/downloader/utils/Player;)V

    iput-object v0, p0, Lcom/aio/downloader/utils/Player;->timerTask:Ljava/util/TimerTask;

    .line 57
    new-instance v0, Lcom/aio/downloader/utils/Player$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/Player$2;-><init>(Lcom/aio/downloader/utils/Player;)V

    iput-object v0, p0, Lcom/aio/downloader/utils/Player;->handler:Landroid/os/Handler;

    .line 30
    iput-object p2, p0, Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;

    .line 31
    iput-object p1, p0, Lcom/aio/downloader/utils/Player;->ctx:Landroid/content/Context;

    .line 33
    :try_start_0
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 34
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 35
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 36
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mTimer:Ljava/util/Timer;

    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->timerTask:Ljava/util/TimerTask;

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 42
    return-void

    .line 37
    :catch_0
    move-exception v6

    .line 38
    .local v6, "e":Ljava/lang/Exception;
    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/utils/Player;)Landroid/widget/SeekBar;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;

    return-object v0
.end method

.method public static formatTime(J)Ljava/lang/String;
    .locals 8
    .param p0, "time"    # J

    .prologue
    const/4 v7, 0x2

    const-wide/32 v5, 0xea60

    .line 145
    new-instance v2, Ljava/lang/StringBuilder;

    div-long v3, p0, v5

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 146
    .local v0, "min":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    rem-long v3, p0, v5

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 147
    .local v1, "sec":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v2, v7, :cond_1

    .line 148
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    div-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 152
    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_2

    .line 153
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 161
    :cond_0
    :goto_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 150
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    div-long v3, p0, v5

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 154
    :cond_2
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_3

    .line 155
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "00"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 156
    goto :goto_1

    :cond_3
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-ne v2, v7, :cond_4

    .line 157
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "000"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 158
    goto :goto_1

    :cond_4
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 159
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0000"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    rem-long v3, p0, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method


# virtual methods
.method public onBufferingUpdate(Landroid/media/MediaPlayer;I)V
    .locals 4
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "percent"    # I

    .prologue
    .line 133
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;

    invoke-virtual {v1, p2}, Landroid/widget/SeekBar;->setSecondaryProgress(I)V

    .line 134
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->seekBar:Landroid/widget/SeekBar;

    invoke-virtual {v1}, Landroid/widget/SeekBar;->getMax()I

    move-result v1

    iget-object v2, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v2

    mul-int/2addr v1, v2

    iget-object v2, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v2

    div-int v0, v1, v2

    .line 135
    .local v0, "currentProgress":I
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "% play"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " buffer"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 136
    return-void
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 125
    const-string v0, "mediaPlayer"

    const-string v1, "onCompletion"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 126
    return-void
.end method

.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 115
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 116
    .local v0, "ti":Landroid/content/Intent;
    const-string v1, "show"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 117
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 118
    invoke-virtual {p1}, Landroid/media/MediaPlayer;->start()V

    .line 120
    const-string v1, "mediaPlayer"

    const-string v2, "onPrepared"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 121
    return-void
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 101
    return-void
.end method

.method public play()V
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 71
    return-void
.end method

.method public playUrl(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 80
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v1

    if-eqz v1, :cond_0

    .line 81
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->reset()V

    .line 84
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, p1}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 86
    iget-object v1, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->prepare()V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3

    .line 96
    :goto_0
    return-void

    .line 87
    :catch_0
    move-exception v0

    .line 88
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0

    .line 89
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v0

    .line 90
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-virtual {v0}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_0

    .line 91
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_2
    move-exception v0

    .line 92
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_0

    .line 93
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_3
    move-exception v0

    .line 94
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 106
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 107
    iget-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 108
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 110
    :cond_0
    return-void
.end method
