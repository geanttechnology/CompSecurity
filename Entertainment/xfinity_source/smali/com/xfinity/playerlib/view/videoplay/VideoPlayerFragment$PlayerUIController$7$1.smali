.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/SelectionListDialogFragment$OnSelectionChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;

.field final synthetic val$mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;)V
    .locals 0
    .param p1, "this$2"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;

    .prologue
    .line 1575
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;->val$mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSelectionChanged(I)V
    .locals 2
    .param p1, "selection"    # I

    .prologue
    .line 1578
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;->val$mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setLanguage(I)V

    .line 1579
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$7;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;

    move-result-object v1

    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 1580
    return-void

    .line 1579
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
