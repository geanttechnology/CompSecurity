.class Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;
.super Ljava/lang/Object;
.source "LiveMediaPlayer.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->restartLiveStream()V
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
    .line 125
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAsyncTask()V
    .locals 0

    .prologue
    .line 138
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 4
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 133
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    const/4 v2, 0x1

    sget v3, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->STREAM_AUTHORIZATION_ERROR:I

    invoke-interface {v0, v1, v2, v3}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z

    .line 134
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 125
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;->onSuccess(Ljava/lang/String;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 1
    .param p1, "object"    # Ljava/lang/String;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->prepareAsync()V

    .line 129
    return-void
.end method
