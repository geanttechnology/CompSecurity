.class Lcom/mixerbox/mixerbox3b/MainPage$28;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# instance fields
.field state:I

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 1

    .prologue
    .line 1539
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1540
    const/4 v0, 0x0

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->state:I

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 3

    .prologue
    .line 1544
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->tvTimeStart:Landroid/widget/TextView;

    int-to-double v1, p2

    invoke-static {v1, v2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Math;->round(D)J

    move-result-wide v1

    long-to-int v1, v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1545
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1549
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 1550
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->canUpdateSeekbar:Z

    .line 1551
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 1554
    :cond_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1555
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->state:I

    .line 1556
    :cond_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 1558
    :cond_2
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 1562
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v3, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1563
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->canUpdateSeekbar:Z

    .line 1564
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_3

    .line 1566
    :cond_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_2

    .line 1567
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v1

    mul-int/lit16 v1, v1, 0x3e8

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 1568
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->state:I

    if-ne v0, v3, :cond_2

    .line 1569
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 1573
    :cond_2
    :goto_0
    return-void

    .line 1572
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$28;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:seekTo("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
