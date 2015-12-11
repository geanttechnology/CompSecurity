.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->hideInfoPanel()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;

    .prologue
    .line 1844
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1849
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1855
    return-void
.end method
