.class Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;
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
        "Landroid/media/MediaPlayer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)V
    .locals 0

    .prologue
    .line 273
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAsyncTask()V
    .locals 0

    .prologue
    .line 290
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 276
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

    .line 277
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 278
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->handleDisneyException(Ljava/lang/Exception;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$600(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Ljava/lang/Exception;)V

    .line 280
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$800(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->release()V

    .line 281
    return-void
.end method

.method public onSuccess(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 285
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setUpPlayer(Landroid/media/MediaPlayer;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$1200(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Landroid/media/MediaPlayer;)V

    .line 286
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 273
    check-cast p1, Landroid/media/MediaPlayer;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;->onSuccess(Landroid/media/MediaPlayer;)V

    return-void
.end method
