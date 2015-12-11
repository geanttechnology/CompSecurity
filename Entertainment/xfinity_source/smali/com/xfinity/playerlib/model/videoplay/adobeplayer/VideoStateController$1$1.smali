.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;
.super Ljava/lang/Object;
.source "VideoStateController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->callOnAMSContinueException(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;

.field final synthetic val$e:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;

    .prologue
    .line 686
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;->this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 689
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;->this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1$1;->val$e:Ljava/lang/Exception;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onAMSContinueException(Ljava/lang/Exception;)V

    .line 690
    return-void
.end method
