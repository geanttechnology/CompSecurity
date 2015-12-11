.class Lco/vine/android/player/SdkVideoView$9;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Landroid/view/TextureView$SurfaceTextureListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/player/SdkVideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/player/SdkVideoView;


# direct methods
.method constructor <init>(Lco/vine/android/player/SdkVideoView;)V
    .locals 0

    .prologue
    .line 693
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;II)V
    .locals 2
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 696
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    new-instance v1, Landroid/view/Surface;

    invoke-direct {v1, p1}, Landroid/view/Surface;-><init>(Landroid/graphics/SurfaceTexture;)V

    # setter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;
    invoke-static {v0, v1}, Lco/vine/android/player/SdkVideoView;->access$602(Lco/vine/android/player/SdkVideoView;Landroid/view/Surface;)Landroid/view/Surface;

    .line 697
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSurfaceReadyListener:Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2300(Lco/vine/android/player/SdkVideoView;)Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;

    move-result-object v0

    if-nez v0, :cond_0

    .line 698
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->openVideo()V
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2400(Lco/vine/android/player/SdkVideoView;)V

    .line 702
    :goto_0
    return-void

    .line 700
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSurfaceReadyListener:Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2300(Lco/vine/android/player/SdkVideoView;)Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-interface {v0, v1}, Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;->onSurfaceTextureAvailable(Lco/vine/android/player/SdkVideoView;)V

    goto :goto_0
.end method

.method public onSurfaceTextureDestroyed(Landroid/graphics/SurfaceTexture;)Z
    .locals 5
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 721
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # setter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;
    invoke-static {v0, v4}, Lco/vine/android/player/SdkVideoView;->access$602(Lco/vine/android/player/SdkVideoView;Landroid/view/Surface;)Landroid/view/Surface;

    .line 722
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$3000(Lco/vine/android/player/SdkVideoView;)Landroid/widget/MediaController;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$3000(Lco/vine/android/player/SdkVideoView;)Landroid/widget/MediaController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 723
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$1300(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/ExoPlayer;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$1200(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 724
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$1300(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/ExoPlayer;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    invoke-static {v1}, Lco/vine/android/player/SdkVideoView;->access$1200(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    move-result-object v1

    sget-object v2, Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;->MSG_SET_SURFACE:Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v4}, Lcom/google/android/exoplayer/ExoPlayer;->blockingSendMessage(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 726
    :cond_1
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->release(Z)V
    invoke-static {v0, v3}, Lco/vine/android/player/SdkVideoView;->access$900(Lco/vine/android/player/SdkVideoView;Z)V

    .line 727
    return v3
.end method

.method public onSurfaceTextureSizeChanged(Landroid/graphics/SurfaceTexture;II)V
    .locals 6
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 706
    iget-object v4, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # setter for: Lco/vine/android/player/SdkVideoView;->mSurfaceWidth:I
    invoke-static {v4, p2}, Lco/vine/android/player/SdkVideoView;->access$2502(Lco/vine/android/player/SdkVideoView;I)I

    .line 707
    iget-object v4, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # setter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHeight:I
    invoke-static {v4, p3}, Lco/vine/android/player/SdkVideoView;->access$2602(Lco/vine/android/player/SdkVideoView;I)I

    .line 708
    iget-object v4, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mTargetState:I
    invoke-static {v4}, Lco/vine/android/player/SdkVideoView;->access$2700(Lco/vine/android/player/SdkVideoView;)I

    move-result v4

    const/4 v5, 0x6

    if-ne v4, v5, :cond_2

    move v1, v2

    .line 709
    .local v1, "isValidState":Z
    :goto_0
    iget-object v4, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    iget v4, v4, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    if-ne v4, p2, :cond_3

    iget-object v4, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    iget v4, v4, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    if-ne v4, p3, :cond_3

    move v0, v2

    .line 710
    .local v0, "hasValidSize":Z
    :goto_1
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->hasPlayer()Z
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$2800(Lco/vine/android/player/SdkVideoView;)Z

    move-result v2

    if-eqz v2, :cond_1

    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 711
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$2900(Lco/vine/android/player/SdkVideoView;)I

    move-result v2

    if-eqz v2, :cond_0

    .line 712
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    iget-object v3, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I
    invoke-static {v3}, Lco/vine/android/player/SdkVideoView;->access$2900(Lco/vine/android/player/SdkVideoView;)I

    move-result v3

    invoke-virtual {v2, v3}, Lco/vine/android/player/SdkVideoView;->seekTo(I)V

    .line 714
    :cond_0
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 716
    :cond_1
    return-void

    .end local v0    # "hasValidSize":Z
    .end local v1    # "isValidState":Z
    :cond_2
    move v1, v3

    .line 708
    goto :goto_0

    .restart local v1    # "isValidState":Z
    :cond_3
    move v0, v3

    .line 709
    goto :goto_1
.end method

.method public onSurfaceTextureUpdated(Landroid/graphics/SurfaceTexture;)V
    .locals 2
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 732
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    new-instance v1, Landroid/view/Surface;

    invoke-direct {v1, p1}, Landroid/view/Surface;-><init>(Landroid/graphics/SurfaceTexture;)V

    # setter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;
    invoke-static {v0, v1}, Lco/vine/android/player/SdkVideoView;->access$602(Lco/vine/android/player/SdkVideoView;Landroid/view/Surface;)Landroid/view/Surface;

    .line 733
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->hasPlayer()Z
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2800(Lco/vine/android/player/SdkVideoView;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mTargetState:I
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2700(Lco/vine/android/player/SdkVideoView;)I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_1

    .line 734
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I
    invoke-static {v0}, Lco/vine/android/player/SdkVideoView;->access$2900(Lco/vine/android/player/SdkVideoView;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 735
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I
    invoke-static {v1}, Lco/vine/android/player/SdkVideoView;->access$2900(Lco/vine/android/player/SdkVideoView;)I

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->seekTo(I)V

    .line 737
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$9;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 739
    :cond_1
    return-void
.end method
