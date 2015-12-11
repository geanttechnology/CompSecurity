.class Lco/vine/android/player/SdkVideoView$5;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


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
    .line 497
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 4
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 500
    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p1, v1}, Landroid/media/MediaPlayer;->seekTo(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 504
    :goto_0
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mAutoPlayOnPrepared:Z
    invoke-static {v1}, Lco/vine/android/player/SdkVideoView;->access$1700(Lco/vine/android/player/SdkVideoView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 505
    invoke-virtual {p1}, Landroid/media/MediaPlayer;->start()V

    .line 508
    :cond_0
    :try_start_1
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoWidth()I

    move-result v2

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoHeight()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Lco/vine/android/player/SdkVideoView;->onVideoSizeChanged(II)V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_0

    .line 512
    :goto_1
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->onPlayerPrepared()V
    invoke-static {v1}, Lco/vine/android/player/SdkVideoView;->access$1800(Lco/vine/android/player/SdkVideoView;)V

    .line 513
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;
    invoke-static {v1}, Lco/vine/android/player/SdkVideoView;->access$1900(Lco/vine/android/player/SdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 514
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;
    invoke-static {v1}, Lco/vine/android/player/SdkVideoView;->access$1900(Lco/vine/android/player/SdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$5;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-interface {v1, v2}, Lco/vine/android/player/VideoViewInterface$OnPreparedListener;->onPrepared(Lco/vine/android/player/VideoViewInterface;)V

    .line 516
    :cond_1
    return-void

    .line 509
    :catch_0
    move-exception v0

    .line 510
    .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v1, "IllegalState happened. "

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_1

    .line 501
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v1

    goto :goto_0
.end method
