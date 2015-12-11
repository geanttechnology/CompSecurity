.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$18;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->configureVolumeAndBrightnessControls()V
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
    .line 2237
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$18;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 2240
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$18;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$18;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->setMuteState(Z)V

    .line 2241
    return-void

    .line 2240
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
