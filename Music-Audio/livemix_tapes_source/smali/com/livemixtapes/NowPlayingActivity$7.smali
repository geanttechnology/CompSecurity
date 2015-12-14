.class Lcom/livemixtapes/NowPlayingActivity$7;
.super Ljava/lang/Object;
.source "NowPlayingActivity.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/NowPlayingActivity;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/NowPlayingActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/NowPlayingActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/NowPlayingActivity$7;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    .line 633
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 8
    .param p1, "seekBar"    # Landroid/widget/SeekBar;
    .param p2, "progress"    # I
    .param p3, "fromUser"    # Z

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 655
    iget-object v2, p0, Lcom/livemixtapes/NowPlayingActivity$7;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    iget-boolean v2, v2, Lcom/livemixtapes/NowPlayingActivity;->touchtracking:Z

    if-eqz v2, :cond_0

    if-eqz p3, :cond_0

    .line 657
    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->trackDuration:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .local v0, "tempMax":I
    new-array v2, v7, [Ljava/lang/Object;

    .line 658
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SEEKING TO UPDATE: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    new-array v2, v7, [Ljava/lang/Object;

    .line 659
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "TRACK DURATION: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->trackDuration:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 661
    int-to-double v2, p2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    .line 662
    int-to-double v4, v0

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    .line 661
    mul-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    .line 662
    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    .line 661
    div-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    .line 663
    .local v1, "tempSet":Ljava/lang/Double;
    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    new-array v2, v7, [Ljava/lang/Object;

    .line 664
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SEEKING TO "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Double;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 668
    :try_start_0
    sget-object v2, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Ljava/lang/Double;->intValue()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->seekTo(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 677
    .end local v0    # "tempMax":I
    .end local v1    # "tempSet":Ljava/lang/Double;
    :cond_0
    :goto_0
    return-void

    .line 669
    .restart local v0    # "tempMax":I
    .restart local v1    # "tempSet":Ljava/lang/Double;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 645
    iget-object v0, p0, Lcom/livemixtapes/NowPlayingActivity$7;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/livemixtapes/NowPlayingActivity;->touchtracking:Z

    .line 646
    # getter for: Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->access$2()Lcom/livemixtapes/MediaObserver;

    move-result-object v0

    invoke-virtual {v0}, Lcom/livemixtapes/MediaObserver;->stop()V

    .line 648
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 2
    .param p1, "seekBar"    # Landroid/widget/SeekBar;

    .prologue
    .line 637
    iget-object v0, p0, Lcom/livemixtapes/NowPlayingActivity$7;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/livemixtapes/NowPlayingActivity;->touchtracking:Z

    .line 638
    # getter for: Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->access$2()Lcom/livemixtapes/MediaObserver;

    move-result-object v0

    invoke-virtual {v0}, Lcom/livemixtapes/MediaObserver;->unstop()V

    .line 640
    return-void
.end method
