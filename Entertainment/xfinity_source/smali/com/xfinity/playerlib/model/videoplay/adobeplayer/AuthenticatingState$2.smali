.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;
.super Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;
.source "AuthenticatingState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->onAuthorizationTokenRequest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;)V
    .locals 6
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    .prologue
    .line 192
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;-><init>()V

    .line 193
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getVideoAuthToken()Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 194
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->getVideoAuthToken()Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->getRawData()Ljava/lang/String;

    move-result-object v0

    .line 196
    .local v0, "token":Ljava/lang/String;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 197
    .local v1, "tokenParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "token_type"

    const-string v3, "offsite.comcast"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 198
    const-string v2, "token"

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 199
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;->setTokenParameters(Ljava/util/Map;)V

    .line 203
    .end local v0    # "token":Ljava/lang/String;
    .end local v1    # "tokenParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-void

    .line 201
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    new-instance v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;

    iget-object v4, v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const-string v5, "Disney Media Authorization failed: VideoAuthToken is null"

    invoke-direct {v3, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
