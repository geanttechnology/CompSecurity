.class Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;
.super Ljava/lang/Object;
.source "EPPlaybackManager.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

.field private final synthetic val$pollSessionForLinearNetwork:Z


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Z)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iput-boolean p2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->val$pollSessionForLinearNetwork:Z

    .line 166
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEventRetrivalError(I)V
    .locals 2
    .param p1, "errorCode"    # I

    .prologue
    .line 195
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v1, "Event can not be found"

    invoke-interface {v0, v1}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    .line 196
    return-void
.end method

.method public onEventUpdate(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V
    .locals 9
    .param p1, "event"    # Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .prologue
    .line 170
    invoke-static {p1}, Lcom/espn/androidplayersdk/datamanager/EPVideoTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 171
    invoke-static {p1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->setEventObj(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 173
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->getVideoInfoForDevice(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 174
    .local v3, "videoInfo":[Ljava/lang/String;
    const/4 v5, 0x0

    aget-object v4, v3, v5

    .line 175
    .local v4, "videoUrl":Ljava/lang/String;
    const/4 v5, 0x1

    aget-object v0, v3, v5

    .line 176
    .local v0, "eventType":Ljava/lang/String;
    const/4 v5, 0x2

    aget-object v1, v3, v5

    .line 177
    .local v1, "networkType":Ljava/lang/String;
    const/4 v2, 0x0

    .line 179
    .local v2, "pollSession":Z
    const-string v5, "live"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v5, "linear"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 180
    const/4 v2, 0x1

    .line 184
    :goto_0
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v5, v5, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    if-nez v5, :cond_1

    .line 185
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    new-instance v6, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v7, v7, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    iget-object v8, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-direct {v6, v4, v7, v8, v2}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;-><init>(Ljava/lang/String;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Z)V

    iput-object v6, v5, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    .line 186
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v5, v5, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->start()V

    .line 191
    :goto_1
    return-void

    .line 182
    :cond_0
    iget-boolean v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->val$pollSessionForLinearNetwork:Z

    goto :goto_0

    .line 188
    :cond_1
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v5, v5, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v5, v4}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->updateVideoUrlForSessionChange(Ljava/lang/String;)V

    .line 189
    iget-object v5, p0, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    iget-object v5, v5, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->playbackSession:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v5}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->initiateStartSessionRequest()V

    goto :goto_1
.end method
