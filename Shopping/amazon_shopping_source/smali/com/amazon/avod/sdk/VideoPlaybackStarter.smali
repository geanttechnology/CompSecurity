.class public Lcom/amazon/avod/sdk/VideoPlaybackStarter;
.super Ljava/lang/Object;
.source "VideoPlaybackStarter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;
    }
.end annotation


# static fields
.field private static final DEFAULT_PROFILE:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;


# instance fields
.field private final mAsin:Ljava/lang/String;

.field private mAudioLanguageCode:Ljava/lang/String;

.field private mClientSessionId:Ljava/lang/String;

.field private final mConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

.field private mPlaybackProfile:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

.field private mRefMarker:Ljava/lang/String;

.field private mTimecodeMillis:J

.field private final mUrlType:Lcom/amazon/avod/sdk/Constants$UrlType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->FULL:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    sput-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->DEFAULT_PROFILE:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    return-void
.end method

.method constructor <init>(Lcom/amazon/avod/sdk/internal/AivConnection;Ljava/lang/String;Lcom/amazon/avod/sdk/Constants$UrlType;)V
    .locals 3
    .param p1, "connection"    # Lcom/amazon/avod/sdk/internal/AivConnection;
    .param p2, "asin"    # Ljava/lang/String;
    .param p3, "urlType"    # Lcom/amazon/avod/sdk/Constants$UrlType;

    .prologue
    const/4 v2, 0x0

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mTimecodeMillis:J

    .line 62
    sget-object v0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->DEFAULT_PROFILE:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    iput-object v0, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mPlaybackProfile:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    .line 63
    iput-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mRefMarker:Ljava/lang/String;

    .line 64
    iput-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mAudioLanguageCode:Ljava/lang/String;

    .line 88
    if-nez p1, :cond_0

    .line 89
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "Need a valid AIV connection."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 93
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "A valid asin must be provided in order to start playback."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 95
    :cond_2
    if-nez p3, :cond_3

    .line 96
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "A valid urlType must be specified in order to start playback."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 99
    :cond_3
    iput-object p1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    .line 100
    iput-object p2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mAsin:Ljava/lang/String;

    .line 101
    iput-object p3, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mUrlType:Lcom/amazon/avod/sdk/Constants$UrlType;

    .line 102
    return-void
.end method

.method private generatePlaybackParameters()Ljava/util/Map;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 197
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 199
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mUrlType:Lcom/amazon/avod/sdk/Constants$UrlType;

    sget-object v2, Lcom/amazon/avod/sdk/Constants$UrlType;->TRAILER:Lcom/amazon/avod/sdk/Constants$UrlType;

    if-ne v1, v2, :cond_0

    .line 200
    const-string/jumbo v1, "playTrailer"

    const-string/jumbo v2, "T"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    :cond_0
    iget-wide v1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mTimecodeMillis:J

    const-wide/16 v3, -0x1

    cmp-long v1, v1, v3

    if-eqz v1, :cond_1

    .line 204
    const-string/jumbo v1, "playbackTimecode"

    iget-wide v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mTimecodeMillis:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    :cond_1
    const-string/jumbo v1, "playbackProfile"

    iget-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mPlaybackProfile:Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;

    invoke-virtual {v2}, Lcom/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile;->getParameterValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    iget-object v1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mRefMarker:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 210
    const-string/jumbo v1, "refMarker"

    iget-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mRefMarker:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    :cond_2
    iget-object v1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mClientSessionId:Ljava/lang/String;

    if-eqz v1, :cond_3

    .line 214
    const-string/jumbo v1, "clientSessionId"

    iget-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mClientSessionId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    :cond_3
    iget-object v1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mAudioLanguageCode:Ljava/lang/String;

    if-eqz v1, :cond_4

    .line 218
    const-string/jumbo v1, "audioLanguage"

    iget-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mAudioLanguageCode:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    :cond_4
    return-object v0
.end method


# virtual methods
.method public start()V
    .locals 3

    .prologue
    .line 192
    invoke-direct {p0}, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->generatePlaybackParameters()Ljava/util/Map;

    move-result-object v0

    .line 193
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mConnection:Lcom/amazon/avod/sdk/internal/AivConnection;

    iget-object v2, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mAsin:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Lcom/amazon/avod/sdk/internal/AivConnection;->playVideo(Ljava/lang/String;Ljava/util/Map;)V

    .line 194
    return-void
.end method

.method public withRefMarker(Ljava/lang/String;)Lcom/amazon/avod/sdk/VideoPlaybackStarter;
    .locals 0
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 158
    iput-object p1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mRefMarker:Ljava/lang/String;

    .line 159
    return-object p0
.end method

.method public withResumeTimecode(J)Lcom/amazon/avod/sdk/VideoPlaybackStarter;
    .locals 2
    .param p1, "timecodeMillis"    # J

    .prologue
    .line 114
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    const-wide/16 p1, -0x1

    .end local p1    # "timecodeMillis":J
    :cond_0
    iput-wide p1, p0, Lcom/amazon/avod/sdk/VideoPlaybackStarter;->mTimecodeMillis:J

    .line 115
    return-object p0
.end method
