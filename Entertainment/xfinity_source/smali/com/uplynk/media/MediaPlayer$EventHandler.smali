.class Lcom/uplynk/media/MediaPlayer$EventHandler;
.super Landroid/os/Handler;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EventHandler"
.end annotation


# instance fields
.field private mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

.field final synthetic this$0:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method public constructor <init>(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer;Landroid/os/Looper;)V
    .locals 0
    .param p2, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p3, "looper"    # Landroid/os/Looper;

    .prologue
    .line 607
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    .line 608
    invoke-direct {p0, p3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 609
    iput-object p2, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    .line 610
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 14
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 615
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mNativeContext:I
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$0(Lcom/uplynk/media/MediaPlayer;)I

    move-result v9

    if-nez v9, :cond_1

    .line 616
    const-string v9, "upLynkMediaPlayer"

    const-string v10, "mediaplayer went away with unhandled events"

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 802
    :cond_0
    :goto_0
    :sswitch_0
    return-void

    .line 622
    :cond_1
    iget v9, p1, Landroid/os/Message;->what:I

    sparse-switch v9, :sswitch_data_0

    .line 799
    const-string v9, "upLynkMediaPlayer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Unknown message type "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v11, p1, Landroid/os/Message;->what:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 625
    :sswitch_1
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnPreparedListener:Lcom/uplynk/media/MediaPlayer$OnPreparedListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$1(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 626
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnPreparedListener:Lcom/uplynk/media/MediaPlayer$OnPreparedListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$1(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {v9, v10}, Lcom/uplynk/media/MediaPlayer$OnPreparedListener;->onPrepared(Lcom/uplynk/media/MediaPlayer;)V

    goto :goto_0

    .line 630
    :sswitch_2
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$2(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    move-result-object v9

    if-eqz v9, :cond_2

    .line 631
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$2(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {v9, v10}, Lcom/uplynk/media/MediaPlayer$OnCompletionListener;->onCompletion(Lcom/uplynk/media/MediaPlayer;)V

    .line 632
    :cond_2
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v10, 0x0

    # invokes: Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V
    invoke-static {v9, v10}, Lcom/uplynk/media/MediaPlayer;->access$3(Lcom/uplynk/media/MediaPlayer;Z)V

    .line 633
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 634
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    invoke-virtual {v9}, Lcom/uplynk/media/CaptionManager;->reset()V

    goto :goto_0

    .line 638
    :sswitch_3
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnBufferingUpdateListener:Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$5(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 639
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnBufferingUpdateListener:Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$5(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget v11, p1, Landroid/os/Message;->arg1:I

    invoke-interface {v9, v10, v11}, Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;->onBufferingUpdate(Lcom/uplynk/media/MediaPlayer;I)V

    goto :goto_0

    .line 643
    :sswitch_4
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnSeekCompleteListener:Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$6(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 644
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnSeekCompleteListener:Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$6(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {v9, v10}, Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;->onSeekComplete(Lcom/uplynk/media/MediaPlayer;)V

    goto/16 :goto_0

    .line 648
    :sswitch_5
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnVideoSizeChangedListener:Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$7(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

    move-result-object v9

    if-eqz v9, :cond_3

    .line 649
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnVideoSizeChangedListener:Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$7(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget v11, p1, Landroid/os/Message;->arg1:I

    iget v12, p1, Landroid/os/Message;->arg2:I

    invoke-interface {v9, v10, v11, v12}, Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;->onVideoSizeChanged(Lcom/uplynk/media/MediaPlayer;II)V

    .line 650
    :cond_3
    const-string v9, "upLynkMediaPlayer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Video Resolution Changed: "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v11, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "x"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v11, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 655
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 656
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    iget v10, p1, Landroid/os/Message;->arg1:I

    iget v11, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v9, v10, v11}, Lcom/uplynk/media/CaptionManager;->setVideoSize(II)V

    goto/16 :goto_0

    .line 663
    :sswitch_6
    # getter for: Lcom/uplynk/media/MediaPlayer;->SET_FIXED_SURFACE_SIZE:Z
    invoke-static {}, Lcom/uplynk/media/MediaPlayer;->access$8()Z

    move-result v9

    if-eqz v9, :cond_4

    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$9(Lcom/uplynk/media/MediaPlayer;)Landroid/view/SurfaceHolder;

    move-result-object v9

    if-eqz v9, :cond_4

    .line 664
    const-string v9, "upLynkMediaPlayer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Setting window to fixed size of "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v11, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "x"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v11, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 665
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$9(Lcom/uplynk/media/MediaPlayer;)Landroid/view/SurfaceHolder;

    move-result-object v9

    iget v10, p1, Landroid/os/Message;->arg1:I

    iget v11, p1, Landroid/os/Message;->arg2:I

    invoke-interface {v9, v10, v11}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    .line 668
    :cond_4
    const-string v9, "upLynkMediaPlayer"

    const-string v10, "Video Window Size Changed: %dx%d"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    iget v13, p1, Landroid/os/Message;->arg1:I

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x1

    iget v13, p1, Landroid/os/Message;->arg2:I

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 674
    :sswitch_7
    const-string v9, "upLynkMediaPlayer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Error ("

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v11, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ","

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v11, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ")"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 675
    const/4 v4, 0x0

    .line 676
    .local v4, "error_was_handled":Z
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnErrorListener:Lcom/uplynk/media/MediaPlayer$OnErrorListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$10(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnErrorListener;

    move-result-object v9

    if-eqz v9, :cond_5

    .line 677
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnErrorListener:Lcom/uplynk/media/MediaPlayer$OnErrorListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$10(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnErrorListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget v11, p1, Landroid/os/Message;->arg1:I

    iget v12, p1, Landroid/os/Message;->arg2:I

    invoke-interface {v9, v10, v11, v12}, Lcom/uplynk/media/MediaPlayer$OnErrorListener;->onError(Lcom/uplynk/media/MediaPlayer;II)Z

    move-result v4

    .line 679
    :cond_5
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$2(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    move-result-object v9

    if-eqz v9, :cond_6

    if-nez v4, :cond_6

    .line 680
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$2(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {v9, v10}, Lcom/uplynk/media/MediaPlayer$OnCompletionListener;->onCompletion(Lcom/uplynk/media/MediaPlayer;)V

    .line 682
    :cond_6
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v10, 0x0

    # invokes: Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V
    invoke-static {v9, v10}, Lcom/uplynk/media/MediaPlayer;->access$3(Lcom/uplynk/media/MediaPlayer;Z)V

    .line 683
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    if-eqz v9, :cond_7

    .line 684
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    invoke-virtual {v9}, Lcom/uplynk/media/CaptionManager;->reset()V

    .line 686
    :cond_7
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v10, 0x0

    invoke-static {v9, v10}, Lcom/uplynk/media/MediaPlayer;->access$11(Lcom/uplynk/media/MediaPlayer;Z)V

    goto/16 :goto_0

    .line 692
    .end local v4    # "error_was_handled":Z
    :sswitch_8
    const-string v9, "upLynkMediaPlayer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Info ("

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v11, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ","

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget v11, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ")"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 693
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnInfoListener:Lcom/uplynk/media/MediaPlayer$OnInfoListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$12(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnInfoListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 694
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnInfoListener:Lcom/uplynk/media/MediaPlayer$OnInfoListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$12(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnInfoListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget v11, p1, Landroid/os/Message;->arg1:I

    iget v12, p1, Landroid/os/Message;->arg2:I

    invoke-interface {v9, v10, v11, v12}, Lcom/uplynk/media/MediaPlayer$OnInfoListener;->onInfo(Lcom/uplynk/media/MediaPlayer;II)Z

    goto/16 :goto_0

    .line 701
    :sswitch_9
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v10, 0x1

    invoke-static {v9, v10}, Lcom/uplynk/media/MediaPlayer;->access$11(Lcom/uplynk/media/MediaPlayer;Z)V

    goto/16 :goto_0

    .line 710
    :sswitch_a
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$13(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 712
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$13(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    const/4 v11, 0x0

    invoke-interface {v9, v10, v11}, Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;->onAssetBoundary(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 719
    :sswitch_b
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # invokes: Lcom/uplynk/media/MediaPlayer;->getMetadata()Ljava/lang/String;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$14(Lcom/uplynk/media/MediaPlayer;)Ljava/lang/String;

    move-result-object v2

    .line 720
    .local v2, "data":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 721
    const-string v9, "_"

    invoke-virtual {v2, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 723
    .local v6, "parts":[Ljava/lang/String;
    array-length v9, v6

    const/4 v10, 0x3

    if-ne v9, v10, :cond_0

    .line 725
    const/4 v9, 0x0

    aget-object v1, v6, v9

    .line 726
    .local v1, "assetID":Ljava/lang/String;
    if-eqz v1, :cond_12

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v9

    const/16 v10, 0x20

    if-ne v9, v10, :cond_12

    .line 728
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_currentAssetID:Ljava/lang/String;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$15(Lcom/uplynk/media/MediaPlayer;)Ljava/lang/String;

    move-result-object v9

    if-eqz v9, :cond_8

    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_currentAssetID:Ljava/lang/String;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$15(Lcom/uplynk/media/MediaPlayer;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_a

    .line 731
    :cond_8
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-static {v9, v1}, Lcom/uplynk/media/MediaPlayer;->access$16(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V

    .line 732
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    if-eqz v9, :cond_9

    .line 733
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;

    move-result-object v9

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Lcom/uplynk/media/CaptionManager;->clearDisplay(Z)V

    .line 736
    :cond_9
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$13(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    move-result-object v9

    if-eqz v9, :cond_a

    .line 738
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$13(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {v9, v10, v1}, Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;->onAssetBoundary(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V

    .line 743
    :cond_a
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$17(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v9

    if-eqz v9, :cond_b

    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$17(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v9

    iget-object v9, v9, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_assetID:Ljava/lang/String;

    invoke-virtual {v9, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_d

    .line 745
    :cond_b
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # invokes: Lcom/uplynk/media/MediaPlayer;->getAssetInfo(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v9, v1}, Lcom/uplynk/media/MediaPlayer;->access$18(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 747
    .local v5, "jsonInfo":Ljava/lang/String;
    const/4 v7, 0x0

    .line 750
    .local v7, "tries":I
    :goto_1
    if-nez v5, :cond_c

    const/16 v9, 0xf

    if-lt v7, v9, :cond_f

    .line 763
    :cond_c
    if-eqz v5, :cond_11

    .line 767
    new-instance v0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {v0, v9, v5}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;-><init>(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V

    .line 768
    .local v0, "ai":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    iget-boolean v10, v0, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->_isValid:Z

    if-eqz v10, :cond_10

    .end local v0    # "ai":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :goto_2
    invoke-static {v9, v0}, Lcom/uplynk/media/MediaPlayer;->access$19(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;)V

    .line 775
    .end local v5    # "jsonInfo":Ljava/lang/String;
    .end local v7    # "tries":I
    :cond_d
    :goto_3
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnUplynkMetadataListener:Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$20(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 777
    new-instance v8, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    invoke-direct {v8, v9, v6}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;-><init>(Lcom/uplynk/media/MediaPlayer;[Ljava/lang/String;)V

    .line 779
    .local v8, "u":Lcom/uplynk/media/MediaPlayer$UplynkMetadata;
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$17(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v9

    if-eqz v9, :cond_e

    .line 780
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->_currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$17(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v9

    iput-object v9, v8, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->_assetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    .line 782
    :cond_e
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnUplynkMetadataListener:Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$20(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

    move-result-object v9

    iget-object v10, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-interface {v9, v10, v8}, Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;->onUplynkMetadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)Z

    goto/16 :goto_0

    .line 754
    .end local v8    # "u":Lcom/uplynk/media/MediaPlayer$UplynkMetadata;
    .restart local v5    # "jsonInfo":Ljava/lang/String;
    .restart local v7    # "tries":I
    :cond_f
    :try_start_0
    const-string v9, "upLynkMediaPlayer"

    const-string v10, "AssetInfo not yet available, sleeping"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 755
    const-wide/16 v10, 0x96

    invoke-static {v10, v11}, Ljava/lang/Thread;->sleep(J)V

    .line 756
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # invokes: Lcom/uplynk/media/MediaPlayer;->getAssetInfo(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v9, v1}, Lcom/uplynk/media/MediaPlayer;->access$18(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 757
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 758
    :catch_0
    move-exception v3

    .line 759
    .local v3, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v3}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1

    .line 768
    .end local v3    # "e":Ljava/lang/InterruptedException;
    .restart local v0    # "ai":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_10
    const/4 v0, 0x0

    goto :goto_2

    .line 771
    .end local v0    # "ai":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_11
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    const/4 v10, 0x0

    invoke-static {v9, v10}, Lcom/uplynk/media/MediaPlayer;->access$19(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;)V

    goto :goto_3

    .line 786
    .end local v5    # "jsonInfo":Ljava/lang/String;
    .end local v7    # "tries":I
    :cond_12
    const-string v9, "upLynkMediaPlayer"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Invalid Metadata: "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 792
    .end local v1    # "assetID":Ljava/lang/String;
    .end local v2    # "data":Ljava/lang/String;
    .end local v6    # "parts":[Ljava/lang/String;
    :sswitch_c
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$21(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    move-result-object v9

    if-eqz v9, :cond_0

    .line 794
    iget-object v9, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->this$0:Lcom/uplynk/media/MediaPlayer;

    # getter for: Lcom/uplynk/media/MediaPlayer;->mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;
    invoke-static {v9}, Lcom/uplynk/media/MediaPlayer;->access$21(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    move-result-object v10

    iget-object v11, p0, Lcom/uplynk/media/MediaPlayer$EventHandler;->mMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget-object v9, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v9, Lcom/uplynk/media/MediaPlayer$UplynkID3;

    invoke-interface {v10, v11, v9}, Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;->onID3Metadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkID3;)Z

    goto/16 :goto_0

    .line 622
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x4 -> :sswitch_4
        0x5 -> :sswitch_5
        0x6 -> :sswitch_6
        0x7 -> :sswitch_a
        0x64 -> :sswitch_7
        0xc8 -> :sswitch_8
        0xc9 -> :sswitch_9
        0x190 -> :sswitch_b
        0x191 -> :sswitch_c
    .end sparse-switch
.end method
