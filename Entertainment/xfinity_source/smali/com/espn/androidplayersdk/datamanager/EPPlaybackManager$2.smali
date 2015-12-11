.class Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;
.super Ljava/lang/Object;
.source "EPPlaybackManager.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateLiveEventSessionForLinearNetwork(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    .line 218
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleError(I)V
    .locals 2
    .param p1, "errorCode"    # I

    .prologue
    .line 236
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v1, "Unable to retrive live event for linear network"

    invoke-interface {v0, v1}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    .line 238
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 223
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 3
    .param p1, "object"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 227
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {v1, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->parse(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v0

    .line 228
    .local v0, "eventId":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 229
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    const/4 v2, 0x1

    # invokes: Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;Z)V
    invoke-static {v1, v0, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->access$0(Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Ljava/lang/String;Z)V

    .line 232
    :goto_0
    return-void

    .line 231
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$2;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v1, v1, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v2, "Unable to retrive live event for linear network"

    invoke-interface {v1, v2}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    goto :goto_0
.end method
