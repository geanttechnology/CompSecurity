.class Lco/vine/android/player/OldSdkVideoView$4;
.super Ljava/lang/Object;
.source "OldSdkVideoView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;


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
    .line 376
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    const/4 v1, 0x5

    .line 378
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # setter for: Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I
    invoke-static {v0, v1}, Lco/vine/android/player/OldSdkVideoView;->access$502(Lco/vine/android/player/OldSdkVideoView;I)I

    .line 379
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # setter for: Lco/vine/android/player/OldSdkVideoView;->mTargetState:I
    invoke-static {v0, v1}, Lco/vine/android/player/OldSdkVideoView;->access$1502(Lco/vine/android/player/OldSdkVideoView;I)I

    .line 380
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1100(Lco/vine/android/player/OldSdkVideoView;)Landroid/widget/MediaController;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 381
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1100(Lco/vine/android/player/OldSdkVideoView;)Landroid/widget/MediaController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 383
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1600(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 384
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    # getter for: Lco/vine/android/player/OldSdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;
    invoke-static {v0}, Lco/vine/android/player/OldSdkVideoView;->access$1600(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView$4;->this$0:Lco/vine/android/player/OldSdkVideoView;

    invoke-interface {v0, v1}, Lco/vine/android/player/VideoViewInterface$OnCompletionListener;->onCompletion(Lco/vine/android/player/VideoViewInterface;)V

    .line 386
    :cond_1
    return-void
.end method
