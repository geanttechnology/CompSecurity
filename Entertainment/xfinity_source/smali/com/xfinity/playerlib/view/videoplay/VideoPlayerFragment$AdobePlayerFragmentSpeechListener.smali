.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;
.super Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.source "VideoPlayerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdobePlayerFragmentSpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0

    .prologue
    .line 2429
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;

    .prologue
    .line 2429
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponsePause()Z
    .locals 4

    .prologue
    .line 2450
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PauseRunnable;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PauseRunnable;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 2451
    const/4 v0, 0x1

    return v0
.end method

.method public onSpeechResponsePlay([Ljava/lang/String;)Z
    .locals 4
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 2434
    array-length v0, p1

    if-nez v0, :cond_1

    .line 2436
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayingBeforeSpeechSwipe:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2437
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayRunnable;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayRunnable;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 2442
    :goto_0
    const/4 v0, 0x1

    .line 2445
    :goto_1
    return v0

    .line 2439
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->video_already_playing:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(I)V

    goto :goto_0

    .line 2445
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public onSpeechResponseSeek([Ljava/lang/String;)Z
    .locals 2
    .param p1, "terms"    # [Ljava/lang/String;

    .prologue
    .line 2469
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    const v1, 0x1b7740

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->seek(I)Z

    .line 2470
    const/4 v0, 0x1

    return v0
.end method
