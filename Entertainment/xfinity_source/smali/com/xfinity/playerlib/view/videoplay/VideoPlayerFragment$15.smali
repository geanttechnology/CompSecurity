.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->configurePlayerControls()V
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
    .line 569
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 572
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onPauseButton()V

    .line 573
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 574
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_pause_selected:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(I)V

    .line 575
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_toggle_controls_are_visible:I

    # invokes: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V

    .line 577
    :cond_0
    return-void
.end method
