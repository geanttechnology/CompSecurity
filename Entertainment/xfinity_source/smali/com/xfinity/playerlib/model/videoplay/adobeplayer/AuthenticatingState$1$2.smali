.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$2;
.super Ljava/lang/Object;
.source "AuthenticatingState.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->callOnAmsPinRequired()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$2;->this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$2;->this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onAmsPinRequired()V

    .line 158
    return-void
.end method
