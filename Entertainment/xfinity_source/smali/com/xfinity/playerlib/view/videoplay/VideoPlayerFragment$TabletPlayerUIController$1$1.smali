.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1$1;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;)V
    .locals 0
    .param p1, "this$2"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;

    .prologue
    .line 1849
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1852
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1$1;->this$2:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController$1;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$5000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1853
    return-void
.end method
