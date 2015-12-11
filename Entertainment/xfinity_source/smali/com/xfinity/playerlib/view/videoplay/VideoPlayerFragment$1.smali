.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/media/AudioManager$OnAudioFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAudioFocusChange(I)V
    .locals 2
    .param p1, "focusChange"    # I

    .prologue
    .line 278
    const/4 v0, -0x2

    if-ne p1, v0, :cond_1

    .line 284
    :cond_0
    :goto_0
    return-void

    .line 279
    :cond_1
    const/4 v0, 0x1

    if-eq p1, v0, :cond_0

    .line 280
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 281
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/media/AudioManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mRemoteControlResponder:Landroid/content/ComponentName;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/content/ComponentName;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->unregisterMediaButtonEventReceiver(Landroid/content/ComponentName;)V

    .line 282
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/media/AudioManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/media/AudioManager$OnAudioFocusChangeListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->abandonAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I

    goto :goto_0
.end method
