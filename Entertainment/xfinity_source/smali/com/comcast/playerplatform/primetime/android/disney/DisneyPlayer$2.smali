.class Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;
.super Ljava/lang/Object;
.source "DisneyPlayer.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
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
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAsyncTask()V
    .locals 0

    .prologue
    .line 270
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 246
    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$700()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "TeaTime-error: "

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 247
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 248
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->onBufferComplete()V

    .line 249
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->handleDisneyException(Ljava/lang/Exception;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$600(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Ljava/lang/Exception;)V

    .line 251
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->release()V

    .line 252
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 243
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->onSuccess(Ljava/lang/String;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 257
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    # setter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$902(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 258
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    # invokes: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 259
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isDrmComplete:Z

    .line 260
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->onBufferComplete()V

    .line 264
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    const/4 v1, 0x0

    # setter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$1102(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Z)Z

    .line 265
    return-void
.end method
