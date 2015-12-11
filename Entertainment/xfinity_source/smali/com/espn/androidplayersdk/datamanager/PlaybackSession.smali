.class Lcom/espn/androidplayersdk/datamanager/PlaybackSession;
.super Ljava/lang/Thread;
.source "PlaybackSession.java"


# instance fields
.field epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

.field private isSessionCancelled:Z

.field mHandler:Landroid/os/Handler;

.field maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

.field playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

.field playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

.field private pollProgramChange:Z

.field programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

.field startSessionListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field videoUrl:Ljava/lang/String;

.field wait:J


# direct methods
.method constructor <init>(Ljava/lang/String;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;Z)V
    .locals 2
    .param p1, "videoUrl"    # Ljava/lang/String;
    .param p2, "playBackManagerLsnr"    # Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;
    .param p3, "epPlaybackManager"    # Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;
    .param p4, "pollSession"    # Z

    .prologue
    const/4 v0, 0x0

    .line 31
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 27
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->pollProgramChange:Z

    .line 28
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->isSessionCancelled:Z

    .line 29
    const-wide/16 v0, 0x7530

    iput-wide v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->wait:J

    .line 143
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$1;-><init>(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->startSessionListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 32
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->videoUrl:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    .line 34
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    .line 35
    iput-object p0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    .line 36
    iput-boolean p4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->pollProgramChange:Z

    .line 37
    return-void
.end method

.method static synthetic access$0(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->isSessionCancelled:Z

    return v0
.end method

.method static synthetic access$1(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->pollProgramChange:Z

    return v0
.end method


# virtual methods
.method getStartSessionParameters()Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 112
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "&v=2.0.0&platform="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getPlatformForStartSession()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->sdkVersion:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&partner="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 113
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 112
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "authArg":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&affiliateID="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 119
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->getAffiliateID()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 120
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->getAffiliateID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 125
    :goto_0
    new-instance v2, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v2}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v3, "startSession"

    const-string v4, "inittype"

    invoke-virtual {v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 127
    .local v1, "initType":Ljava/lang/String;
    const-string v2, "1"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 128
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&token="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "udid"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/espn/androidplayersdk/utilities/Utils;->toBase64fromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 129
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&tokenType="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "tokenType"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 140
    :cond_0
    :goto_1
    return-object v0

    .line 122
    .end local v1    # "initType":Ljava/lang/String;
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiPartnerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 130
    .restart local v1    # "initType":Ljava/lang/String;
    :cond_2
    const-string v2, "2"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 131
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&token="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "token"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/espn/androidplayersdk/utilities/Utils;->toBase64fromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 132
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&tokenType="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "affiliate"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 133
    goto :goto_1

    :cond_3
    const-string v2, "3"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 134
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&token="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "adobepasscontentproviderid"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/espn/androidplayersdk/utilities/Utils;->toBase64fromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 135
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&tokenType="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "tokenType"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 136
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&resource="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "startSession"

    const-string v5, "resource"

    invoke-virtual {v3, v4, v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/espn/androidplayersdk/utilities/Utils;->toBase64fromString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1
.end method

.method protected initiateStartSessionRequest()V
    .locals 7

    .prologue
    const/4 v6, 0x5

    .line 56
    :try_start_0
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    monitor-enter v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 58
    :try_start_1
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-interface {v1}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->shouldWaitForUpdatedAdobePassParams()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    invoke-interface {v1}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->shouldWaitForUpdatedAffiliateToken()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 59
    :cond_0
    const-string v1, "Waiting for updated AuthZtoken"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v1, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 60
    iget-wide v4, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->wait:J

    invoke-virtual {p0, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 56
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 67
    :try_start_3
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->videoUrl:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->getStartSessionParameters()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->videoUrl:Ljava/lang/String;

    .line 68
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->startSessionListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-direct {v1, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->videoUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getStartSessionResponse(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 74
    :goto_1
    return-void

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 64
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "PlaybackSession"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_2
    const/4 v3, 0x5

    invoke-static {v1, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 56
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    .line 70
    :catch_1
    move-exception v0

    .line 71
    .restart local v0    # "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PlaybackSession"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_3
    invoke-static {v1, v6, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 72
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playBackManagerLsnr:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    const-string v2, "Session authorization failed"

    invoke-interface {v1, v2}, Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;->streamDidFailAuthorizationWithMessage(Ljava/lang/String;)V

    goto :goto_1

    .line 64
    :cond_2
    :try_start_6
    const-string v1, ""
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_2

    .line 71
    :cond_3
    const-string v1, ""

    goto :goto_3
.end method

.method protected releaseWaitForUpdateToken()V
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    if-eqz v0, :cond_0

    .line 105
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    monitor-enter v1

    .line 106
    :try_start_0
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->playbackSessioMonitor:Lcom/espn/androidplayersdk/datamanager/PlaybackSession;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 105
    monitor-exit v1

    .line 108
    :cond_0
    return-void

    .line 105
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected removeMaintainRequest()V
    .locals 3

    .prologue
    .line 82
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->isSessionCancelled:Z

    .line 83
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    if-eqz v1, :cond_0

    .line 84
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->maintainSession:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->cancel()V

    .line 85
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    if-eqz v1, :cond_1

    .line 86
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->programingChange:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->cancel()V

    .line 87
    :cond_1
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 88
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->mHandler:Landroid/os/Handler;

    new-instance v2, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$2;

    invoke-direct {v2, p0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession$2;-><init>(Lcom/espn/androidplayersdk/datamanager/PlaybackSession;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 98
    :cond_2
    :goto_0
    return-void

    .line 95
    :catch_0
    move-exception v0

    .line 96
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PlaybackSession"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_3
    const-string v1, ""

    goto :goto_1
.end method

.method public run()V
    .locals 3

    .prologue
    .line 41
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 43
    :try_start_0
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 44
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->mHandler:Landroid/os/Handler;

    .line 45
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->initiateStartSessionRequest()V

    .line 46
    invoke-static {}, Landroid/os/Looper;->loop()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 52
    :goto_0
    return-void

    .line 47
    :catch_0
    move-exception v0

    .line 49
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "PlaybackSession"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_0
    const-string v1, ""

    goto :goto_1
.end method

.method updateVideoUrlForSessionChange(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/PlaybackSession;->videoUrl:Ljava/lang/String;

    .line 78
    return-void
.end method
