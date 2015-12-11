.class Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;
.super Ljava/lang/Object;
.source "PlaybackSession.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/PlaybackSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    .line 143
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleError(I)V
    .locals 2
    .param p1, "errorCode"    # I

    .prologue
    .line 199
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v1, "Session authorization failed"

    invoke-interface {v0, v1}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    .line 200
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 204
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 9
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
    .line 148
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p1, :cond_0

    .line 149
    :try_start_0
    new-instance v2, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;

    invoke-direct {v2}, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;-><init>()V

    .line 150
    .local v2, "sessionParser":Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
    invoke-virtual {v2, p1, p3}, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;->parse(Lorg/json/JSONObject;Ljava/util/HashMap;)Lcom/espn/androidplayersdk/datamanager/EPStream;

    move-result-object v3

    .line 151
    .local v3, "stream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    # getter for: Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->isSessionCancelled:Z
    invoke-static {v4}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->access$0(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)Z

    move-result v4

    if-nez v4, :cond_2

    if-eqz v3, :cond_2

    .line 153
    invoke-virtual {v2, v3}, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;->getFWToken(Lcom/espn/androidplayersdk/datamanager/EPStream;)Lcom/espn/androidplayersdk/datamanager/EPStream;

    move-result-object v3

    .line 156
    invoke-static {v3}, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->setStreamObj(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 158
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    if-nez v4, :cond_1

    .line 159
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-interface {v4, v3}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamAuthorizationSucceeded(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 160
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    new-instance v5, Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    iget-object v6, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v6, v6, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-direct {v5, v3, v6, p0}, Lcom/espn/androidplayersdk/datamanager/MaintainSession;-><init>(Lcom/espn/androidplayersdk/datamanager/EPStream;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    iput-object v5, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    .line 161
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->maintain()V

    .line 163
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    # getter for: Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->pollProgramChange:Z
    invoke-static {v4}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->access$1(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 165
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    new-instance v5, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    iget-object v6, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v6, v6, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v7, v7, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->mHandler:Landroid/os/Handler;

    iget-object v8, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v8, v8, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-direct {v5, v3, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPStream;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Landroid/os/Handler;Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;)V

    iput-object v5, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    .line 166
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->monitorProgramingChange()V

    .line 195
    .end local v2    # "sessionParser":Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
    .end local v3    # "stream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :cond_0
    :goto_0
    return-void

    .line 170
    .restart local v2    # "sessionParser":Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
    .restart local v3    # "stream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :cond_1
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-interface {v4, v3}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamCookieUpdated(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 171
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    invoke-virtual {v4, v3}, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->update(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 172
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    if-eqz v4, :cond_0

    .line 173
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    invoke-virtual {v4, v3}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->update(Lcom/espn/androidplayersdk/datamanager/EPStream;)V

    .line 174
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->didProgramChanged()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 175
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->getInstance()Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->trackVideoStart()V

    .line 176
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    invoke-virtual {v4}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->resetProgramChangedFlag()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 191
    .end local v2    # "sessionParser":Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
    .end local v3    # "stream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :catch_0
    move-exception v1

    .line 192
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "PlaybackSession"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_5

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    :goto_1
    const/4 v5, 0x5

    invoke-static {v4, v5, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 193
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v5, "Session authorization failed"

    invoke-interface {v4, v5}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    goto :goto_0

    .line 180
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "sessionParser":Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
    .restart local v3    # "stream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    :cond_2
    :try_start_1
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    # getter for: Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->isSessionCancelled:Z
    invoke-static {v4}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->access$0(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 181
    invoke-virtual {v2, p1}, Lcom/espn/androidplayersdk/datamanager/StartSessionParser;->generateErrorObject(Lorg/json/JSONObject;)Lcom/espn/androidplayersdk/objects/EPAuthError;

    move-result-object v0

    .line 182
    .local v0, "authError":Lcom/espn/androidplayersdk/objects/EPAuthError;
    if-eqz v0, :cond_4

    .line 183
    invoke-virtual {v0}, Lcom/espn/androidplayersdk/objects/EPAuthError;->getType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "blackout"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 184
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-interface {v4, v0}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidEnterBlackout(Lcom/espn/androidplayersdk/objects/EPAuthError;)V

    goto :goto_0

    .line 186
    :cond_3
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-interface {v4, v0}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamAuthorizationFailedWithError(Lcom/espn/androidplayersdk/objects/EPAuthError;)V

    goto/16 :goto_0

    .line 188
    :cond_4
    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;->this$0:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v4, v4, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v5, "Session authorization failed"

    invoke-interface {v4, v5}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 192
    .end local v0    # "authError":Lcom/espn/androidplayersdk/objects/EPAuthError;
    .end local v2    # "sessionParser":Lcom/espn/androidplayersdk/datamanager/StartSessionParser;
    .end local v3    # "stream":Lcom/espn/androidplayersdk/datamanager/EPStream;
    .restart local v1    # "e":Ljava/lang/Exception;
    :cond_5
    const-string v4, ""

    goto :goto_1
.end method
