.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;
.super Ljava/lang/Object;
.source "AuthenticatingState.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->callOnAmsAuthenticationException(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

.field final synthetic val$e:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    .prologue
    .line 163
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;->this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;->this$1:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3;->val$e:Ljava/lang/Exception;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onAmsAuthenticationException(Ljava/lang/Exception;)V

    .line 167
    return-void
.end method
