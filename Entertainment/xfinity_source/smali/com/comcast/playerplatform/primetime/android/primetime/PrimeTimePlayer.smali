.class public Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Lcom/comcast/playerplatform/primetime/android/player/Player;
.implements Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;
    }
.end annotation


# instance fields
.field private abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

.field private adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

.field private context:Landroid/content/Context;

.field private currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field private currentPosition:J

.field private final drmEventListener:Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

.field private drmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

.field private final drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

.field private fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

.field private handler:Landroid/os/Handler;

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private initialBuffer:J

.field private isAudioRetry:Z

.field private isStopped:Z

.field private licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

.field private listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

.field private loaderListener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

.field private logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

.field private mediaResource:Lcom/adobe/mediacore/MediaResource;

.field private pendingRetry:Z

.field private performanceMetrics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;

.field private playbackBuffer:J

.field private player:Lcom/adobe/mediacore/MediaPlayer;

.field private playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

.field private playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

.field private final playerStateEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

.field private previousAudioTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

.field private final qosEventListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

.field private qosProvider:Lcom/adobe/mediacore/qos/QOSProvider;

.field private retryCount:I

.field private retryRunnable:Ljava/lang/Runnable;

.field private startPosition:J


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;Lcom/comcast/playerplatform/drm/java/service/LicenseService;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p3, "settings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .param p4, "licenseService"    # Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    .prologue
    const/4 v2, 0x0

    const-wide/16 v0, 0x0

    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentPosition:J

    .line 68
    iput v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    .line 69
    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z

    .line 70
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->startPosition:J

    .line 74
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initialBuffer:J

    .line 75
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playbackBuffer:J

    .line 76
    sget-object v0, Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;->ABR_MODERATE:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    .line 85
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    .line 86
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->performanceMetrics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;

    .line 89
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    .line 708
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$2;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerStateEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    .line 938
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$3;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryRunnable:Ljava/lang/Runnable;

    .line 994
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosEventListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    .line 1062
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmEventListener:Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

    .line 1104
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$6;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$6;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmOperationErrorCallback:Lcom/adobe/ave/drm/DRMOperationErrorCallback;

    .line 1129
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$7;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    .line 1196
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$8;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$8;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->loaderListener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

    .line 93
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->context:Landroid/content/Context;

    .line 94
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 95
    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    .line 96
    iput-object p4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    .line 97
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initPlayer(Landroid/content/Context;)V

    .line 98
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    return-object v0
.end method

.method static synthetic access$102(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->previousAudioTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    return-object p1
.end method

.method static synthetic access$1102(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;I)I
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # I

    .prologue
    .line 57
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    return p1
.end method

.method static synthetic access$1104(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    return v0
.end method

.method static synthetic access$1200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->startPosition:J

    return-wide v0
.end method

.method static synthetic access$1300(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->updateAbrControlParameters()V

    return-void
.end method

.method static synthetic access$1400(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionSettings()V

    return-void
.end method

.method static synthetic access$1500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Lcom/adobe/mediacore/MediaPlayerNotification;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handlePlayerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-void
.end method

.method static synthetic access$1600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z

    return v0
.end method

.method static synthetic access$1602(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 57
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z

    return p1
.end method

.method static synthetic access$1700(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentPosition:J

    return-wide v0
.end method

.method static synthetic access$1800(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioRetry:Z

    return v0
.end method

.method static synthetic access$1802(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 57
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioRetry:Z

    return p1
.end method

.method static synthetic access$1900(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # I

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setViewColor(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/DRMMetadataInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Lcom/adobe/mediacore/DRMMetadataInfo;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->acquireLicenseForStreaming(Lcom/adobe/mediacore/DRMMetadataInfo;)V

    return-void
.end method

.method static synthetic access$2300(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->acquireLicenseForOffline()V

    return-void
.end method

.method static synthetic access$2400(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/DRMMetadataInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Lcom/adobe/mediacore/DRMMetadataInfo;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->acquireLicenseForWhitelist(Lcom/adobe/mediacore/DRMMetadataInfo;)V

    return-void
.end method

.method static synthetic access$2500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playWithoutDrmWorkflow()V

    return-void
.end method

.method static synthetic access$2600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/util/Map;

    .prologue
    .line 57
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setPreferredAudioLanguageByLanguage(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/qos/QOSProvider;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosProvider:Lcom/adobe/mediacore/qos/QOSProvider;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initialBuffer:J

    return-wide v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)J
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playbackBuffer:J

    return-wide v0
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    return-object v0
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    return-object v0
.end method

.method private acquireLicenseForOffline()V
    .locals 3

    .prologue
    .line 1093
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLocalLicense(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;)V

    .line 1094
    return-void
.end method

.method private acquireLicenseForStreaming(Lcom/adobe/mediacore/DRMMetadataInfo;)V
    .locals 7
    .param p1, "info"    # Lcom/adobe/mediacore/DRMMetadataInfo;

    .prologue
    .line 1097
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v5

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v6}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getMoneyTraceId()Lcom/comcast/playerplatform/util/android/MoneyTrace;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForStreaming(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/adobe/ave/drm/DRMMetadata;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 1098
    return-void
.end method

.method private acquireLicenseForWhitelist(Lcom/adobe/mediacore/DRMMetadataInfo;)V
    .locals 4
    .param p1, "info"    # Lcom/adobe/mediacore/DRMMetadataInfo;

    .prologue
    .line 1101
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmLicenseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/service/LicenseService;->acquireLicenseForWhitelist(Ljava/lang/String;Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 1102
    return-void
.end method

.method private applyPlayerSettings()V
    .locals 0

    .prologue
    .line 121
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->registerAdBreakPolicy()V

    .line 122
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->updateAbrControlParameters()V

    .line 123
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionSettings()V

    .line 124
    return-void
.end method

.method private canUpdatePlayerSettings()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 443
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-nez v1, :cond_1

    .line 447
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v1, v2, :cond_2

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v1, v2, :cond_2

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v1, v2, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private extractMetadata(Ljava/util/Map;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 3
    .param p1, "parameters"    # Ljava/util/Map;
    .param p2, "metadata"    # Lcom/adobe/mediacore/metadata/Metadata;

    .prologue
    .line 985
    if-eqz p2, :cond_1

    invoke-interface {p2}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 986
    invoke-interface {p2}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 987
    .local v1, "key":Ljava/lang/String;
    invoke-interface {p2, v1}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 988
    invoke-interface {p2, v1}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 992
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private getConfigValues()V
    .locals 6

    .prologue
    .line 135
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 137
    .local v0, "configurationHelper":Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getAbrPolicy()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;->valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    .line 138
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getInitialBuffer()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initialBuffer:J

    .line 139
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getPlaybackBuffer()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playbackBuffer:J

    .line 140
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->initialBuffer:J

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playbackBuffer:J

    invoke-static {v2, v3, v4, v5}, Lcom/adobe/mediacore/BufferControlParameters;->createDual(JJ)Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V

    .line 143
    return-void
.end method

.method private getRetryDelay()J
    .locals 2

    .prologue
    .line 951
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    const/4 v1, 0x2

    invoke-static {v0, v1}, Lorg/apache/commons/math/util/MathUtils;->pow(II)I

    move-result v0

    mul-int/lit16 v0, v0, 0x3e8

    int-to-long v0, v0

    return-wide v0
.end method

.method private handlePlayerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 10
    .param p1, "mediaPlayerNotification"    # Lcom/adobe/mediacore/MediaPlayerNotification;

    .prologue
    .line 868
    const/4 v0, 0x0

    .line 869
    .local v0, "audioFailure":Z
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 870
    .local v1, "code":Ljava/lang/StringBuffer;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 871
    .local v2, "description":Ljava/lang/StringBuffer;
    new-instance v4, Ljava/util/Hashtable;

    invoke-direct {v4}, Ljava/util/Hashtable;-><init>()V

    .line 873
    .local v4, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v5

    invoke-interface {v5}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getCode()J

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    .line 874
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 875
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v5

    invoke-direct {p0, v4, v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->extractMetadata(Ljava/util/Map;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 876
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v5

    invoke-interface {v5}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getCode()J

    move-result-wide v6

    sget-object v5, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->NATIVE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    invoke-virtual {v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->getCode()J

    move-result-wide v8

    cmp-long v5, v6, v8

    if-nez v5, :cond_2

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v5

    const-string v6, "NATIVE_ERROR_CODE"

    invoke-interface {v5, v6}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 877
    const-string v5, "."

    invoke-virtual {v1, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v6

    const-string v7, "NATIVE_ERROR_CODE"

    invoke-interface {v6, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 895
    :cond_0
    sget-object v5, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getType()Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 917
    :cond_1
    :goto_0
    return-void

    .line 880
    :cond_2
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getInnerNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v3

    .line 882
    .local v3, "innerNotification":Lcom/adobe/mediacore/MediaPlayerNotification;
    :goto_1
    if-eqz v3, :cond_0

    .line 884
    if-nez v0, :cond_3

    .line 885
    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioFailure(Lcom/adobe/mediacore/MediaPlayerNotification;)Z

    move-result v0

    .line 888
    :cond_3
    const-string v5, "."

    invoke-virtual {v1, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v6

    invoke-interface {v6}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getCode()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    .line 889
    const-string v5, " Caused by \'"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaPlayerNotification;->getDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 890
    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaPlayerNotification;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v5

    invoke-direct {p0, v4, v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->extractMetadata(Ljava/util/Map;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 891
    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaPlayerNotification;->getInnerNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v3

    goto :goto_1

    .line 897
    .end local v3    # "innerNotification":Lcom/adobe/mediacore/MediaPlayerNotification;
    :pswitch_0
    iget-boolean v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isStopped:Z

    if-nez v5, :cond_1

    .line 898
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->stop()V

    .line 899
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryPreviousAsset(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 904
    :pswitch_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v5

    invoke-interface {v5}, Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;->getCode()J

    move-result-wide v6

    const-wide/32 v8, 0x330cc

    cmp-long v5, v6, v8

    if-nez v5, :cond_4

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v5

    const-string v6, "NATIVE_ERROR_CODE"

    invoke-interface {v5, v6}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/adobe/ave/MediaErrorCode;->LIVE_WINDOW_MOVED_BACKWARD:Lcom/adobe/ave/MediaErrorCode;

    invoke-virtual {v6}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 905
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->stop()V

    .line 906
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryPreviousAsset(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 907
    :cond_4
    if-eqz v0, :cond_5

    iget-boolean v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioRetry:Z

    if-nez v5, :cond_5

    .line 908
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v5, v6, v4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryPreviousAudio(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 910
    :cond_5
    invoke-direct {p0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->sendMediaWarning(Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V

    goto/16 :goto_0

    .line 895
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private hookEvents()V
    .locals 3

    .prologue
    .line 146
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerStateEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 147
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->DRM:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmEventListener:Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 148
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosEventListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 149
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->performanceMetrics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 150
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->addListener(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;)V

    .line 151
    return-void
.end method

.method private initPlayer(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 106
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handler:Landroid/os/Handler;

    .line 107
    invoke-static {p1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->create(Landroid/content/Context;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    .line 109
    const-class v0, Lcom/adobe/mediacore/MediaPlayer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/logging/Logger$Verbosity;->NONE:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/logging/Logger;->setVerbosityLevel(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V

    .line 111
    new-instance v0, Lcom/adobe/mediacore/qos/QOSProvider;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/qos/QOSProvider;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosProvider:Lcom/adobe/mediacore/qos/QOSProvider;

    .line 112
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosProvider:Lcom/adobe/mediacore/qos/QOSProvider;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/qos/QOSProvider;->attachMediaPlayer(Lcom/adobe/mediacore/MediaPlayer;)V

    .line 113
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getView()Landroid/view/View;

    move-result-object v0

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 115
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getConfigValues()V

    .line 117
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->hookEvents()V

    .line 118
    return-void
.end method

.method private isAudioFailure(Lcom/adobe/mediacore/MediaPlayerNotification;)Z
    .locals 2
    .param p1, "innerNotification"    # Lcom/adobe/mediacore/MediaPlayerNotification;

    .prologue
    .line 965
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AUDIO_TRACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private playWithoutDrmWorkflow()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1087
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 1088
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v2, v2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V

    .line 1090
    :cond_0
    return-void
.end method

.method private registerAdBreakPolicy()V
    .locals 8

    .prologue
    .line 127
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-nez v0, :cond_1

    .line 132
    :cond_0
    :goto_0
    return-void

    .line 131
    :cond_1
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-wide v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->startPosition:J

    const-wide/16 v6, 0x1

    cmp-long v0, v4, v6

    if-lez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    invoke-direct {v2, v3, v0}, Lcom/comcast/playerplatform/primetime/android/ads/CustomAdvertisingFactory;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;Z)V

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->registerAdClientFactory(Lcom/adobe/mediacore/AdClientFactory;)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private declared-synchronized retryPreviousAsset(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 920
    .local p3, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    iget v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    const/4 v3, 0x3

    if-ge v2, v3, :cond_2

    .line 921
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v2, :cond_0

    .line 922
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    iget v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    invoke-virtual {v2, p1, p2, v3}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->retryAttempted(Ljava/lang/String;Ljava/lang/String;I)V

    .line 925
    :cond_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getRetryDelay()J

    move-result-wide v0

    .line 927
    .local v0, "retryDelay":J
    iget-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z

    if-nez v2, :cond_1

    .line 928
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->pendingRetry:Z

    .line 929
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryRunnable:Ljava/lang/Runnable;

    invoke-virtual {v2, v3, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 936
    .end local v0    # "retryDelay":J
    :cond_1
    :goto_0
    monitor-exit p0

    return-void

    .line 933
    :cond_2
    const/4 v2, 0x0

    :try_start_1
    iput v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    .line 934
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 920
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method private retryPreviousAudio(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 955
    .local p3, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->previousAudioTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    if-eqz v0, :cond_0

    .line 956
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isAudioRetry:Z

    .line 957
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->previousAudioTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    .line 962
    :goto_0
    return-void

    .line 960
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->sendMediaFailed(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method private declared-synchronized sendMediaFailed(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 977
    .local p3, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "com.comcast.playerplatform.primetime::primetimeplayer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Code:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " Description:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 979
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 980
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 982
    :cond_0
    monitor-exit p0

    return-void

    .line 977
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private sendMediaWarning(Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;)V
    .locals 4
    .param p1, "code"    # Ljava/lang/StringBuffer;
    .param p2, "description"    # Ljava/lang/StringBuffer;

    .prologue
    .line 969
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v1, "com.comcast.playerplatform.primetime::primetimeplayer"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Code:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " Description:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 970
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    if-eqz v0, :cond_0

    .line 971
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {p1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaWarning(Ljava/lang/String;Ljava/lang/String;)V

    .line 974
    :cond_0
    return-void
.end method

.method private setClosedCaptionSettings()V
    .locals 3

    .prologue
    .line 858
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClosedCaptionsEnabled()Z

    move-result v1

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionsEnabled(Z)V

    .line 860
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getCaptionFormat()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v0

    .line 861
    .local v0, "closedCaptionFormatBuilder":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->canUpdatePlayerSettings()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 862
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->toTextFormat()Lcom/adobe/mediacore/TextFormat;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->setCCStyle(Lcom/adobe/mediacore/TextFormat;)V

    .line 864
    :cond_0
    return-void
.end method

.method private setClosedCaptionsTrackByName(Ljava/lang/String;)V
    .locals 3
    .param p1, "trackName"    # Ljava/lang/String;

    .prologue
    .line 359
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v2

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerItem;->getClosedCaptionsTracks()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    .line 360
    .local v1, "track":Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    invoke-virtual {v1}, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 361
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v2

    invoke-interface {v2, v1}, Lcom/adobe/mediacore/MediaPlayerItem;->selectClosedCaptionsTrack(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;)Z

    .line 365
    .end local v1    # "track":Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    :cond_1
    return-void
.end method

.method private setPlayerContent(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 5
    .param p1, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    .line 263
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v2, v3, :cond_1

    .line 264
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->stop()V

    .line 268
    :cond_1
    iget v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryCount:I

    if-nez v2, :cond_2

    .line 271
    :cond_2
    const/4 v0, 0x0

    .line 272
    .local v0, "adMetadata":Lcom/adobe/mediacore/metadata/MetadataNode;
    if-eqz p1, :cond_3

    .line 273
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .line 274
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v3, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/MediaPlayer;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 275
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getMetadataForAdobe()Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    .line 278
    :cond_3
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->applyPlayerSettings()V

    .line 283
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getMoneyTrace()Lcom/comcast/playerplatform/util/android/MoneyTrace;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;-><init>(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 289
    .local v1, "networkUtils":Lcom/comcast/playerplatform/primetime/android/primetime/AdobeMoneyTrace;
    if-nez v0, :cond_4

    .line 290
    new-instance v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    .end local v0    # "adMetadata":Lcom/adobe/mediacore/metadata/MetadataNode;
    invoke-direct {v0}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    .line 292
    .restart local v0    # "adMetadata":Lcom/adobe/mediacore/metadata/MetadataNode;
    :cond_4
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NETWORK_CONFIGURATION:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 293
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Lcom/adobe/mediacore/MediaResource;->createFromUrl(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->mediaResource:Lcom/adobe/mediacore/MediaResource;

    .line 295
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-interface {v2, v3}, Lcom/adobe/mediacore/MediaPlayer;->replaceCurrentItem(Lcom/adobe/mediacore/MediaResource;)V

    .line 296
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isStopped:Z

    .line 297
    return-void
.end method

.method private setPreferredAudioLanguageByLanguage(Ljava/lang/String;)V
    .locals 3
    .param p1, "language"    # Ljava/lang/String;

    .prologue
    .line 391
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 392
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v2

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerItem;->getAudioTracks()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/AudioTrack;

    .line 393
    .local v0, "audioTrack":Lcom/adobe/mediacore/info/AudioTrack;
    invoke-virtual {v0}, Lcom/adobe/mediacore/info/AudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->contentEquals(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 395
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->previousAudioTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .line 396
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/adobe/mediacore/MediaPlayerItem;->selectAudioTrack(Lcom/adobe/mediacore/info/AudioTrack;)Z

    goto :goto_0

    .line 400
    .end local v0    # "audioTrack":Lcom/adobe/mediacore/info/AudioTrack;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method private setViewColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 1189
    const/high16 v0, -0x1000000

    if-eq p1, v0, :cond_0

    if-nez p1, :cond_1

    .line 1190
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 1192
    :cond_1
    return-void
.end method

.method private updateAbrControlParameters()V
    .locals 7

    .prologue
    .line 428
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v2, :cond_0

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->canUpdatePlayerSettings()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 430
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getInitialBitrate()I

    move-result v1

    .line 431
    .local v1, "intialBitrate":I
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getBitRange()Lcom/comcast/playerplatform/util/android/Range;

    move-result-object v0

    .line 433
    .local v0, "bitrateRange":Lcom/comcast/playerplatform/util/android/Range;
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    new-instance v6, Lcom/adobe/mediacore/ABRControlParameters;

    if-lez v1, :cond_1

    .end local v1    # "intialBitrate":I
    :goto_0
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Range;->getMin()I

    move-result v2

    move v4, v2

    :goto_1
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/Range;->getMax()I

    move-result v2

    :goto_2
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->abrPolicy:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    :goto_3
    invoke-direct {v6, v1, v4, v2, v3}, Lcom/adobe/mediacore/ABRControlParameters;-><init>(IIILcom/adobe/mediacore/ABRControlParameters$ABRPolicy;)V

    invoke-interface {v5, v6}, Lcom/adobe/mediacore/MediaPlayer;->setABRControlParameters(Lcom/adobe/mediacore/ABRControlParameters;)V

    .line 440
    .end local v0    # "bitrateRange":Lcom/comcast/playerplatform/util/android/Range;
    :cond_0
    return-void

    .line 433
    .restart local v0    # "bitrateRange":Lcom/comcast/playerplatform/util/android/Range;
    .restart local v1    # "intialBitrate":I
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .end local v1    # "intialBitrate":I
    :cond_2
    const/high16 v2, -0x80000000

    move v4, v2

    goto :goto_1

    :cond_3
    const v2, 0x7fffffff

    goto :goto_2

    :cond_4
    sget-object v3, Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;->ABR_MODERATE:Lcom/adobe/mediacore/ABRControlParameters$ABRPolicy;

    goto :goto_3
.end method


# virtual methods
.method public addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 2
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 157
    check-cast p1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .end local p1    # "videoEventListener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 159
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->addPlayerEventManager(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    .line 162
    :cond_0
    return-void
.end method

.method public destroy()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 176
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->retryRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 177
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handler:Landroid/os/Handler;

    .line 179
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 181
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerStateEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 182
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->DRM:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->drmEventListener:Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 183
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosEventListener:Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 184
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->performanceMetrics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 185
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->removeListener(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;)V

    .line 187
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 189
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->removePlayerEventManager()V

    .line 190
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->clearPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 191
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .line 194
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->release()V

    .line 196
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    .line 197
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->licenseService:Lcom/comcast/playerplatform/drm/java/service/LicenseService;

    .line 198
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->mediaResource:Lcom/adobe/mediacore/MediaResource;

    .line 199
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 200
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 201
    return-void
.end method

.method public getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 1

    .prologue
    .line 655
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    return-object v0
.end method

.method public getAvailableAudioLanguages()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;",
            ">;"
        }
    .end annotation

    .prologue
    .line 505
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 507
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 508
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayerItem;->getSelectedAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;

    move-result-object v1

    .line 510
    .local v1, "currentTrack":Lcom/adobe/mediacore/info/AudioTrack;
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayerItem;->getAudioTracks()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/info/AudioTrack;

    .line 511
    .local v0, "audioTrack":Lcom/adobe/mediacore/info/AudioTrack;
    new-instance v4, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    invoke-direct {v4, v0, v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;-><init>(Lcom/adobe/mediacore/info/AudioTrack;Z)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 514
    .end local v0    # "audioTrack":Lcom/adobe/mediacore/info/AudioTrack;
    .end local v1    # "currentTrack":Lcom/adobe/mediacore/info/AudioTrack;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_0
    return-object v3
.end method

.method public getAvailableBitrates()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 618
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 620
    .local v0, "bitrates":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v3}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 621
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v3}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v3

    invoke-interface {v3}, Lcom/adobe/mediacore/MediaPlayerItem;->getProfiles()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/info/Profile;

    .line 622
    .local v2, "profile":Lcom/adobe/mediacore/info/Profile;
    invoke-virtual {v2}, Lcom/adobe/mediacore/info/Profile;->getBitrate()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 626
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "profile":Lcom/adobe/mediacore/info/Profile;
    :cond_0
    return-object v0
.end method

.method public getAvailableClosedCaptionTracks()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;"
        }
    .end annotation

    .prologue
    .line 533
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 535
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 536
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayerItem;->getSelectedClosedCaptionsTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    move-result-object v0

    .line 538
    .local v0, "currentTrack":Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayerItem;->getClosedCaptionsTracks()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    .line 539
    .local v3, "track":Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    new-instance v4, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    invoke-virtual {v3, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    invoke-direct {v4, v3, v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;-><init>(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;Z)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 543
    .end local v0    # "currentTrack":Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "track":Lcom/adobe/mediacore/info/ClosedCaptionsTrack;
    :cond_0
    return-object v2
.end method

.method public getAvailableProfiles()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 601
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 603
    .local v0, "bitrates":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;>;"
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 604
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v4

    invoke-interface {v4}, Lcom/adobe/mediacore/MediaPlayerItem;->getProfiles()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/adobe/mediacore/info/Profile;

    .line 605
    .local v3, "profile":Lcom/adobe/mediacore/info/Profile;
    new-instance v2, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;

    invoke-virtual {v3}, Lcom/adobe/mediacore/info/Profile;->getBitrate()I

    move-result v4

    invoke-virtual {v3}, Lcom/adobe/mediacore/info/Profile;->getWidth()I

    move-result v5

    invoke-virtual {v3}, Lcom/adobe/mediacore/info/Profile;->getHeight()I

    move-result v6

    invoke-direct {v2, v4, v5, v6}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;-><init>(III)V

    .line 606
    .local v2, "playerProfile":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 610
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "playerProfile":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;
    .end local v3    # "profile":Lcom/adobe/mediacore/info/Profile;
    :cond_0
    return-object v0
.end method

.method public getClosedCaptionsStatus()Z
    .locals 2

    .prologue
    .line 567
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCCVisibility()Lcom/adobe/mediacore/MediaPlayer$Visibility;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Visibility;->VISIBLE:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 3

    .prologue
    .line 522
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getSelectedAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 523
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayerItem;->getSelectedAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;-><init>(Lcom/adobe/mediacore/info/AudioTrack;Z)V

    .line 525
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentBitrate()I
    .locals 2

    .prologue
    .line 591
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->qosProvider:Lcom/adobe/mediacore/qos/QOSProvider;

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/QOSProvider;->getPlaybackInformation()Lcom/adobe/mediacore/qos/PlaybackInformation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->setPlaybackInformation(Lcom/adobe/mediacore/qos/PlaybackInformation;)V

    .line 593
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getBitrate()J

    move-result-wide v0

    long-to-int v0, v0

    return v0
.end method

.method public getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1

    .prologue
    .line 650
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method public getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .locals 3

    .prologue
    .line 548
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getSelectedClosedCaptionsTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 549
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayerItem;->getSelectedClosedCaptionsTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;-><init>(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;Z)V

    .line 551
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentPlaybackSpeed()F
    .locals 1

    .prologue
    .line 497
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getRate()F

    move-result v0

    return v0
.end method

.method public getCurrentPosition()J
    .locals 4

    .prologue
    .line 463
    const-wide/16 v0, 0x0

    .line 464
    .local v0, "offset":J
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v2, :cond_0

    .line 465
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getAdOffset()J

    move-result-wide v0

    .line 467
    :cond_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentTime()J

    move-result-wide v2

    sub-long/2addr v2, v0

    return-wide v2
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 475
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getEndPosition()J
    .locals 2

    .prologue
    .line 455
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getFragmentInfo()Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    .locals 1

    .prologue
    .line 1126
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->fragmentInfo:Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    return-object v0
.end method

.method public getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 1

    .prologue
    .line 642
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    return-object v0
.end method

.method public getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1

    .prologue
    .line 559
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->name()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    return-object v0
.end method

.method public getSupportedClosedCaptionsOptions()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 575
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "fontSize"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "fontStyle"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "textForegroundColor"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "textForegroundOpacity"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "windowFillColor"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "windowFillOpacity"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "windowBorderEdgeColor"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "windowBorderEdgeStyle"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public getSupportedPlaybackSpeeds()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    .prologue
    .line 483
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 485
    .local v0, "availableSpeeds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Float;>;"
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v2

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerItem;->getAvailablePlaybackRates()Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 489
    :goto_0
    return-object v0

    .line 486
    :catch_0
    move-exception v1

    .line 487
    .local v1, "e":Ljava/lang/Exception;
    const/high16 v2, 0x3f800000    # 1.0f

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 2

    .prologue
    .line 674
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getTimeline()Lcom/adobe/mediacore/timeline/Timeline;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;-><init>(Ljava/util/List;)V

    goto :goto_0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 3

    .prologue
    .line 664
    new-instance v0, Lcom/adobe/mediacore/Version;

    invoke-direct {v0}, Lcom/adobe/mediacore/Version;-><init>()V

    .line 666
    .local v0, "version":Lcom/adobe/mediacore/Version;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PSDK Version : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/adobe/mediacore/Version;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "AVE Version : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/adobe/mediacore/Version;->getAVEVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getVideoHeight()J
    .locals 2

    .prologue
    .line 696
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 701
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 702
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .line 704
    :goto_0
    return-object v0

    .line 702
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    goto :goto_0

    .line 704
    :cond_1
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    goto :goto_0
.end method

.method public getVideoWidth()J
    .locals 2

    .prologue
    .line 691
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getView()Landroid/view/View;
    .locals 1

    .prologue
    .line 634
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getView()Lcom/adobe/mediacore/MediaPlayerView;

    move-result-object v0

    return-object v0
.end method

.method public hasCC()Z
    .locals 1

    .prologue
    .line 686
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->hasClosedCaptions()Z

    move-result v0

    return v0
.end method

.method public hasDRM()Z
    .locals 1

    .prologue
    .line 681
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->isProtected()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_0

    .line 221
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->pause()V

    .line 223
    :cond_0
    return-void
.end method

.method public play()V
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->play()V

    .line 211
    :cond_0
    return-void
.end method

.method public removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 168
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    .line 169
    return-void
.end method

.method public seekToLive()V
    .locals 4

    .prologue
    .line 304
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    const-wide/16 v2, -0x2

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer;->seek(J)V

    .line 305
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 6
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # J
    .param p4, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    const-wide/16 v0, 0x0

    .line 249
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->clearLatencyValues()V

    .line 250
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerMetrics:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;

    invoke-static {}, Lcom/comcast/playerplatform/util/android/TimeUtil;->getClockMonoTonicMillis()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerMetrics;->setLatencyStart(J)V

    .line 251
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->performanceMetrics:Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;

    invoke-virtual {v2, p1}, Lcom/comcast/playerplatform/primetime/android/analytics/PlayerPerformanceMetrics;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;)V

    .line 252
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 254
    iput-wide p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->startPosition:J

    .line 255
    cmp-long v2, p2, v0

    if-lez v2, :cond_0

    .end local p2    # "startPosition":J
    :goto_0
    iput-wide p2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentPosition:J

    .line 258
    invoke-direct {p0, p4}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setPlayerContent(Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 259
    return-void

    .restart local p2    # "startPosition":J
    :cond_0
    move-wide p2, v0

    .line 255
    goto :goto_0
.end method

.method public setClosedCaptionsEnabled(Z)V
    .locals 2
    .param p1, "flag"    # Z

    .prologue
    .line 331
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    if-eqz v0, :cond_0

    .line 332
    if-eqz p1, :cond_1

    .line 333
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Visibility;->VISIBLE:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/MediaPlayer;->setCCVisibility(Lcom/adobe/mediacore/MediaPlayer$Visibility;)V

    .line 338
    :cond_0
    :goto_0
    return-void

    .line 335
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Visibility;->INVISIBLE:Lcom/adobe/mediacore/MediaPlayer$Visibility;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/MediaPlayer;->setCCVisibility(Lcom/adobe/mediacore/MediaPlayer$Visibility;)V

    goto :goto_0
.end method

.method public setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
    .locals 4
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .prologue
    .line 346
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 347
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getTrack()Lcom/adobe/mediacore/info/ClosedCaptionsTrack;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/adobe/mediacore/MediaPlayerItem;->selectClosedCaptionsTrack(Lcom/adobe/mediacore/info/ClosedCaptionsTrack;)Z

    .line 356
    :goto_0
    return-void

    .line 350
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    const-string v2, "com.comcast.playerplatform.primetime::primetimeplayer"

    const-string v3, "ClosedCaptions not set. Player\'s currentItem not set."

    invoke-virtual {v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 353
    :catch_0
    move-exception v0

    .line 354
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionsTrackByName(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
    .locals 1
    .param p1, "logFactory"    # Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .prologue
    .line 423
    const-string v0, ""

    invoke-virtual {p1, v0}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getLogger(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->logger:Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    .line 424
    invoke-static {p1}, Lcom/adobe/mediacore/logging/Log;->setLogFactory(Lcom/adobe/mediacore/logging/LogFactory;)V

    .line 425
    return-void
.end method

.method public setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 2
    .param p1, "verbosity"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 1212
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/LogFactory;->getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->name()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/adobe/mediacore/logging/Logger$Verbosity;->valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger$Verbosity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;->setVerbosityLevel(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V

    .line 1213
    return-void
.end method

.method public setPosition(JZ)V
    .locals 5
    .param p1, "seconds"    # J
    .param p3, "ignoreAds"    # Z

    .prologue
    .line 312
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getDuration()J

    move-result-wide v2

    cmp-long v2, p1, v2

    if-lez v2, :cond_0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getDuration()J

    move-result-wide v0

    .line 313
    .local v0, "seekPoint":J
    :goto_0
    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentPosition:J

    .line 315
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v2, v0, v1}, Lcom/adobe/mediacore/MediaPlayer;->seek(J)V

    .line 316
    return-void

    .end local v0    # "seekPoint":J
    :cond_0
    move-wide v0, p1

    .line 312
    goto :goto_0
.end method

.method public setPositionRelative(J)V
    .locals 5
    .param p1, "seconds"    # J

    .prologue
    .line 323
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->getCurrentPosition()J

    move-result-wide v2

    add-long/2addr v2, p1

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer;->seek(J)V

    .line 324
    return-void
.end method

.method public setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 2
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 372
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$1;-><init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 388
    return-void
.end method

.method public setVolume(I)V
    .locals 1
    .param p1, "volume"    # I

    .prologue
    .line 415
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0, p1}, Lcom/adobe/mediacore/MediaPlayer;->setVolume(I)V

    .line 416
    return-void
.end method

.method public settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V
    .locals 2
    .param p1, "setting"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .prologue
    .line 1217
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1238
    :goto_0
    return-void

    .line 1221
    :pswitch_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->updateAbrControlParameters()V

    goto :goto_0

    .line 1225
    :pswitch_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getCaptionFormat()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1226
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionSettings()V

    goto :goto_0

    .line 1228
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClosedCaptionsEnabled()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionsEnabled(Z)V

    goto :goto_0

    .line 1232
    :pswitch_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClosedCaptionsTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V

    goto :goto_0

    .line 1235
    :pswitch_3
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getPreferredAudioLanguage()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    goto :goto_0

    .line 1217
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public stop()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 233
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->isStopped:Z

    .line 236
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    if-eqz v0, :cond_0

    .line 237
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->getTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    .line 238
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->removePlayerEventManager()V

    .line 239
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->clearPlayer()Lcom/comcast/playerplatform/primetime/android/player/Player;

    .line 240
    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->adManager:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .line 243
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer;->reset()V

    .line 245
    return-void
.end method
