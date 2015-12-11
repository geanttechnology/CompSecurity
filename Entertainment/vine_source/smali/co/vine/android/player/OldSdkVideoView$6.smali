.class Lco/vine/android/player/OldSdkVideoView$6;
.super Ljava/lang/Object;
.source "OldSdkVideoView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnErrorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/player/OldSdkVideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/player/OldSdkVideoView;


# direct methods
.method constructor <init>(Lco/vine/android/player/OldSdkVideoView;)V
    .locals 0

    .prologue
    .line 400
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 4
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "framework_err"    # I
    .param p3, "impl_err"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v2, -0x1

    .line 402
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Error: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 403
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # setter for: Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I
    invoke-static {v0, v2}, Lco/vine/android/player/OldSdkVideoView;->access$502(Lco/vine/android/player/OldSdkVideoView;I)I

    .line 404
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # setter for: Lco/vine/android/player/OldSdkVideoView;->mTargetState:I
    invoke-static {v0, v2}, Lco/vine/android/player/OldSdkVideoView;->access$1502(Lco/vine/android/player/OldSdkVideoView;I)I

    .line 405
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1100(Lco/vine/android/player/OldSdkVideoView;)Landroid/widget/MediaController;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 406
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1100(Lco/vine/android/player/OldSdkVideoView;)Landroid/widget/MediaController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 410
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1800(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 411
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1800(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView$6;->this$0:Lco/vine/android/player/OldSdkVideoView;

    invoke-interface {v0, v1, p2, p3}, Lco/vine/android/player/VideoViewInterface$OnErrorListener;->onError(Lco/vine/android/player/VideoViewInterface;II)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 417
    :goto_0
    return v3

    .line 416
    :cond_1
    const-string v0, "Cannot play this video."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_0
.end method
