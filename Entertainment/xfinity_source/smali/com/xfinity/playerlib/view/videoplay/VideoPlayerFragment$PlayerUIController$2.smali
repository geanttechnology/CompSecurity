.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$2;
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
    .line 1111
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$2;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1114
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController$2;->this$1:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->moveAdsActionBarUp(Z)V

    .line 1115
    return-void
.end method
