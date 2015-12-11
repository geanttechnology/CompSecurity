.class Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;
.super Ljava/lang/Object;
.source "LiveMediaPlayer.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->reauthorization()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAsyncTask()V
    .locals 0

    .prologue
    .line 320
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 4
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 302
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->stop()V

    .line 303
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    const/4 v1, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doingAuthZ:Z
    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;Z)Z

    .line 304
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    const/4 v2, 0x1

    sget v3, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->STREAM_AUTHORIZATION_ERROR:I

    invoke-interface {v0, v1, v2, v3}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z

    .line 305
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 296
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->onSuccess(Ljava/lang/String;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 2
    .param p1, "assetUrl"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 311
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doingAuthZ:Z
    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;Z)Z

    .line 312
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->forceAuthZ:Z
    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->access$202(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;Z)Z

    .line 314
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->access$300()Ljava/lang/String;

    move-result-object v0

    const-string v1, "AUTHZ Success --restarting interval"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 315
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    # invokes: Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->startLiveIntervalAuthTimer()V
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->access$400(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V

    .line 316
    return-void
.end method
