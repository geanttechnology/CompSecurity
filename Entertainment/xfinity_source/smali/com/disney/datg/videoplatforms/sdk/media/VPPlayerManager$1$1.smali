.class Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;
.super Ljava/lang/Object;
.source "VPPlayerManager.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->call()Landroid/media/MediaPlayer;
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
.field final synthetic this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

.field final synthetic val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;)V
    .locals 0

    .prologue
    .line 247
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAsyncTask()V
    .locals 0

    .prologue
    .line 276
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 266
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v2, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 267
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 268
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v0, v1, p1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    .line 269
    .local v0, "ex":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    if-eqz v1, :cond_0

    .line 270
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->val$handler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    invoke-interface {v1, v0}, Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;->onError(Ljava/lang/Exception;)V

    .line 272
    :cond_0
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 247
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->onSuccess(Ljava/lang/String;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 2
    .param p1, "object"    # Ljava/lang/String;

    .prologue
    .line 252
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    const/4 v1, 0x0

    # setter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z

    .line 253
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z
    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 262
    :goto_0
    return-void

    .line 257
    :cond_0
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->access$300()Ljava/lang/String;

    move-result-object v0

    const-string v1, "setDatasource with VPMedia successfull"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 258
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setAudioStreamType(I)V

    .line 259
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 260
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$1;->val$mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->prepareAsync()V

    goto :goto_0
.end method
