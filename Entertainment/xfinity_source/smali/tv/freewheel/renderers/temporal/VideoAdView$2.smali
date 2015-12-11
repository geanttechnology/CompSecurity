.class Ltv/freewheel/renderers/temporal/VideoAdView$2;
.super Ljava/lang/Object;
.source "VideoAdView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/renderers/temporal/VideoAdView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/temporal/VideoAdView;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/temporal/VideoAdView;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 6
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    const/4 v4, 0x3

    .line 157
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;

    move-result-object v1

    const-string v2, "OnPrepared"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 159
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    const/4 v2, 0x2

    # setter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I
    invoke-static {v1, v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$102(Ltv/freewheel/renderers/temporal/VideoAdView;I)I

    .line 160
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$500(Ltv/freewheel/renderers/temporal/VideoAdView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 161
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$400(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoRenderer;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewLoaded()V

    .line 198
    :goto_0
    return-void

    .line 165
    :cond_0
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$600(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v0

    .line 166
    .local v0, "seekToPosition":I
    if-eqz v0, :cond_1

    .line 167
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v1, v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->seekTo(I)V

    .line 169
    :cond_1
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 170
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/MediaController;->setEnabled(Z)V

    .line 172
    :cond_2
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoWidth()I

    move-result v2

    # setter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I
    invoke-static {v1, v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$702(Ltv/freewheel/renderers/temporal/VideoAdView;I)I

    .line 173
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoHeight()I

    move-result v2

    # setter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I
    invoke-static {v1, v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$802(Ltv/freewheel/renderers/temporal/VideoAdView;I)I

    .line 174
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "videoWidth: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I
    invoke-static {v3}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$700(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", videoHeight: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I
    invoke-static {v3}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$800(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 175
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$700(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$800(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v1

    if-eqz v1, :cond_6

    .line 176
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I
    invoke-static {v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$700(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I
    invoke-static {v3}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$800(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v3

    invoke-interface {v1, v2, v3}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    .line 177
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mSurfaceWidth:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$900(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v1

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I
    invoke-static {v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$700(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v2

    if-ne v1, v2, :cond_3

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mSurfaceHeight:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1000(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v1

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I
    invoke-static {v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$800(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v2

    if-ne v1, v2, :cond_3

    .line 178
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$200(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v1

    if-ne v1, v4, :cond_4

    .line 179
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->start()V

    .line 180
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 181
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/MediaController;->show()V

    .line 197
    :cond_3
    :goto_1
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$400(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoRenderer;

    move-result-object v1

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewMediaPrepared()V

    goto/16 :goto_0

    .line 183
    :cond_4
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1100(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/media/MediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v1

    if-nez v1, :cond_3

    if-nez v0, :cond_5

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->getPlayheadTime()D

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmpl-double v1, v2, v4

    if-lez v1, :cond_3

    .line 185
    :cond_5
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 187
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/MediaController;->show(I)V

    goto :goto_1

    .line 192
    :cond_6
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$200(Ltv/freewheel/renderers/temporal/VideoAdView;)I

    move-result v1

    if-ne v1, v4, :cond_3

    .line 193
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$2;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->start()V

    goto :goto_1
.end method
