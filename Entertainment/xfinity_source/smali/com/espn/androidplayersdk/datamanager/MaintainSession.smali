.class Lcom/espn/androidplayersdk/datamanager/MaintainSession;
.super Ljava/lang/Object;
.source "MaintainSession.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;
    }
.end annotation


# instance fields
.field listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field playbackInterface:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

.field stream:Lcom/espn/androidplayersdk/datamanager/EPStream;

.field timer:Ljava/util/Timer;

.field ttlMargin:I


# direct methods
.method protected constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPStream;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V
    .locals 1
    .param p1, "stream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;
    .param p2, "playbackInterface"    # Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;
    .param p3, "listener"    # Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const v0, 0x15f90

    iput v0, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->ttlMargin:I

    .line 26
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->stream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    .line 27
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->playbackInterface:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    .line 28
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 29
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    .line 30
    return-void
.end method


# virtual methods
.method protected cancel()V
    .locals 3

    .prologue
    .line 57
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    if-eqz v1, :cond_0

    .line 58
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 59
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    invoke-virtual {v1}, Ljava/util/Timer;->purge()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :cond_0
    :goto_0
    return-void

    .line 61
    :catch_0
    move-exception v0

    .line 62
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "MaintainSession error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    :goto_1
    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_1
    const-string v1, ""

    goto :goto_1
.end method

.method protected maintain()V
    .locals 6

    .prologue
    .line 34
    :try_start_0
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->stream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getTtl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 35
    .local v1, "ttl":I
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;-><init>(Lcom/espn/androidplayersdk/datamanager/MaintainSession;Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;)V

    iget v4, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->ttlMargin:I

    sub-int v4, v1, v4

    int-to-long v4, v4

    invoke-virtual {v2, v3, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 39
    .end local v1    # "ttl":I
    :goto_0
    return-void

    .line 36
    :catch_0
    move-exception v0

    .line 37
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "MaintainSession error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    :goto_1
    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_0
    const-string v2, ""

    goto :goto_1
.end method

.method protected update(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 6
    .param p1, "stream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 44
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->cancel()V

    .line 45
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->stream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    .line 46
    invoke-virtual {p1}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getTtl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 47
    .local v1, "ttl":I
    new-instance v2, Ljava/util/Timer;

    invoke-direct {v2}, Ljava/util/Timer;-><init>()V

    iput-object v2, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    .line 48
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->timer:Ljava/util/Timer;

    new-instance v3, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;-><init>(Lcom/espn/androidplayersdk/datamanager/MaintainSession;Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;)V

    iget v4, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->ttlMargin:I

    sub-int v4, v1, v4

    int-to-long v4, v4

    invoke-virtual {v2, v3, v4, v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 53
    .end local v1    # "ttl":I
    :goto_0
    return-void

    .line 49
    :catch_0
    move-exception v0

    .line 51
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "MaintainSession error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    :goto_1
    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_0
    const-string v2, ""

    goto :goto_1
.end method
