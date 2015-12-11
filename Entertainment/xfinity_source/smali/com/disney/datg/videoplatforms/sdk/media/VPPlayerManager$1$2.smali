.class Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2;
.super Ljava/lang/Object;
.source "VPPlayerManager.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->call()Landroid/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;)V
    .locals 0

    .prologue
    .line 280
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 285
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v0, :cond_0

    .line 286
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onSuccess(Ljava/lang/Object;)V

    .line 288
    :cond_0
    return-void
.end method
