.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$3;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    .prologue
    .line 1118
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$3;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1121
    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$400()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Calling hide from runnable"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1122
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$3;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    .line 1123
    return-void
.end method
