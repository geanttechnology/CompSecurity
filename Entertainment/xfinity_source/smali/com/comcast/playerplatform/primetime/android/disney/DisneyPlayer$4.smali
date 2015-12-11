.class Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;
.super Ljava/lang/Object;
.source "DisneyPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->onAuthorizationTokenRequest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

.field final synthetic val$mediaToAuthorize:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 0

    .prologue
    .line 623
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->val$mediaToAuthorize:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 626
    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$700()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "TeaTime-Disney Player Auth Token request received"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 628
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDisneyEspnTokenDelegate()Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    move-result-object v0

    .line 630
    .local v0, "authDelegate":Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    iget-boolean v1, v1, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isDrmComplete:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$1100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 631
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->this$0:Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;->onTokenExpired(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setDrmKey(Ljava/lang/String;)V

    .line 634
    :cond_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;->val$mediaToAuthorize:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4$1;

    invoke-direct {v2, p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4$1;-><init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;)V

    invoke-virtual {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authorizeMediaWithAuthToken(Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;)V

    .line 642
    return-void
.end method
