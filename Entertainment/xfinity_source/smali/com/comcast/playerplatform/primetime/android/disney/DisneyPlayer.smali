.class public Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
.super Ljava/lang/Object;
.source "DisneyPlayer.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnErrorListener;
.implements Landroid/view/SurfaceHolder$Callback;
.implements Lcom/comcast/playerplatform/primetime/android/player/Player;
.implements Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;
.implements Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$5;
    }
.end annotation


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private activity:Landroid/app/Activity;

.field private captioningTracks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;"
        }
    .end annotation
.end field

.field private ccContainer:Landroid/widget/RelativeLayout;

.field private closedCaptionOptions:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

.field private currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field private disneyCaptionTrack:Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

.field private disneyNetwordIdMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field isDrmComplete:Z

.field private isRetryAttempting:Z

.field private listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

.field private mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

.field private newPlayerHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Landroid/media/MediaPlayer;",
            ">;"
        }
    .end annotation
.end field

.field private playerManager:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

.field private playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

.field private playerSurface:Landroid/view/SurfaceView;

.field private provider:Ljava/lang/String;

.field private refreshPlayerHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    const-class v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;
    .param p3, "settings"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    .prologue
    const/4 v2, -0x1

    const/4 v1, 0x0

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    const-string v0, "comcast"

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->provider:Ljava/lang/String;

    .line 66
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isDrmComplete:Z

    .line 70
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;-><init>(Z)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyCaptionTrack:Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

    .line 73
    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    .line 243
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$2;-><init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->refreshPlayerHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    .line 273
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$3;-><init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->newPlayerHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    .line 76
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-direct {v0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    .line 77
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 78
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->captioningTracks:Ljava/util/ArrayList;

    .line 79
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->captioningTracks:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyCaptionTrack:Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 80
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 81
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->getDisneyNetwordIdMap()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    .line 82
    new-instance v0, Landroid/view/SurfaceView;

    invoke-direct {v0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    .line 83
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    invoke-virtual {v0}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 84
    iput-object p3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    .line 85
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->addListener(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;)V

    .line 86
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->activity:Landroid/app/Activity;

    .line 87
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setClosedCaptionsOptions()V

    .line 88
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
    .param p1, "x1"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    return-void
.end method

.method static synthetic access$1100(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    return v0
.end method

.method static synthetic access$1102(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    return p1
.end method

.method static synthetic access$1200(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Landroid/media/MediaPlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
    .param p1, "x1"    # Landroid/media/MediaPlayer;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setUpPlayer(Landroid/media/MediaPlayer;)V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Landroid/view/SurfaceView;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->newPlayerHandler:Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerManager:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Ljava/lang/Exception;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
    .param p1, "x1"    # Ljava/lang/Exception;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->handleDisneyException(Ljava/lang/Exception;)V

    return-void
.end method

.method static synthetic access$700()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;)Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    return-object v0
.end method

.method static synthetic access$902(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;
    .param p1, "x1"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object p1
.end method

.method private getMediaFromCatalog()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .locals 8

    .prologue
    .line 190
    const/4 v4, 0x0

    .line 192
    .local v4, "media":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerManager:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getCatalogManager()Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getChannelCatalog(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v3

    .line 195
    .local v3, "catalogFuture":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;>;"
    const-wide/16 v6, 0x5

    :try_start_0
    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v3, v6, v7, v5}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;

    .line 196
    .local v2, "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->getCollection()Ljava/util/List;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->getCollection()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 197
    sget-object v5, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v5}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 198
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;->getCollection()Ljava/util/List;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-object v4, v0

    .line 199
    invoke-virtual {v4, p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->setOnAuthorizationListener(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$VPMediaAuthorizationListener;)V

    .line 200
    sget-object v5, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v5}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0

    .line 211
    .end local v2    # "catalog":Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
    :cond_0
    :goto_0
    if-nez v4, :cond_1

    .line 212
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v5, :cond_1

    .line 213
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    const-string v6, "2002"

    const-string v7, "Failed to acquire Disney Media"

    invoke-virtual {v5, v6, v7}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 217
    :cond_1
    return-object v4

    .line 207
    :catch_0
    move-exception v5

    goto :goto_0

    .line 205
    :catch_1
    move-exception v5

    goto :goto_0

    .line 203
    :catch_2
    move-exception v5

    goto :goto_0
.end method

.method private handleDisneyException(Ljava/lang/Exception;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 294
    instance-of v0, p1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    if-eqz v0, :cond_0

    .line 295
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    move-object v0, p1

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getErrorCode()I

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    check-cast p1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    .end local p1    # "e":Ljava/lang/Exception;
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    :goto_0
    return-void

    .line 298
    .restart local p1    # "e":Ljava/lang/Exception;
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    const-string v1, "2003"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Generic disney playback failure. "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private playMedia(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 2
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 221
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$1;-><init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 241
    return-void
.end method

.method private refreshCaptionContainer()V
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 186
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    invoke-virtual {v0}, Landroid/view/SurfaceView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 187
    return-void
.end method

.method private retryAsset()V
    .locals 5

    .prologue
    .line 114
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v2, "teatime-retryAsset"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 116
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    .line 117
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isDrmComplete:Z

    .line 119
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v1, :cond_0

    .line 120
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->onBufferStart()V

    .line 124
    :cond_0
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    invoke-virtual {v1}, Landroid/view/SurfaceView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 125
    .local v0, "layout":Landroid/widget/FrameLayout;
    invoke-virtual {v0}, Landroid/widget/FrameLayout;->removeAllViews()V

    .line 126
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 128
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    const-wide/16 v2, -0x1

    const/4 v4, 0x0

    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V

    .line 129
    return-void
.end method

.method private setUpPlayer(Landroid/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 303
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    .line 304
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->release()V

    .line 308
    :cond_0
    check-cast p1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    .end local p1    # "mp":Landroid/media/MediaPlayer;
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    .line 311
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0, p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 313
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setClosedCaptionContainer(Landroid/widget/RelativeLayout;)V

    .line 314
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyCaptionTrack:Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;->isSelected()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->enableClosedCaptioning(Z)V

    .line 315
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->closedCaptionOptions:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    if-eqz v0, :cond_1

    .line 316
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->closedCaptionOptions:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->toVPCaptionStyle()Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setCaptionStyle(Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;)V

    .line 319
    :cond_1
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 320
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 322
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_2

    .line 323
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->onBufferComplete()V

    .line 326
    :cond_2
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    if-eqz v0, :cond_4

    .line 327
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->play()V

    .line 333
    :cond_3
    :goto_0
    return-void

    .line 328
    :cond_4
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->isAutoplay()Z

    move-result v0

    if-nez v0, :cond_3

    .line 329
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 330
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 331
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    goto :goto_0
.end method

.method private declared-synchronized updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 2
    .param p1, "newStatus"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 336
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    if-nez v0, :cond_0

    .line 337
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 338
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 339
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 341
    :cond_0
    monitor-exit p0

    return-void

    .line 336
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 0
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 511
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 512
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->reset()V

    .line 97
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->removeListener(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;)V

    .line 98
    return-void
.end method

.method public getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 1

    .prologue
    .line 501
    const/4 v0, 0x0

    return-object v0
.end method

.method public getAvailableAudioLanguages()Ljava/util/List;
    .locals 2
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
    .line 430
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 431
    .local v0, "tracks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    return-object v0
.end method

.method public getAvailableBitrates()Ljava/util/List;
    .locals 1
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
    .line 476
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getAvailableClosedCaptionTracks()Ljava/util/List;
    .locals 1
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
    .line 441
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->captioningTracks:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAvailableProfiles()Ljava/util/List;
    .locals 1
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
    .line 471
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getChannelId(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "channelName"    # Ljava/lang/String;

    .prologue
    .line 595
    const-string v1, " "

    const-string v2, ""

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 596
    .local v0, "channelTrimed":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->setChannelName(Ljava/lang/String;)V

    .line 597
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    return-object v1
.end method

.method public getClosedCaptionsStatus()Z
    .locals 1

    .prologue
    .line 456
    const/4 v0, 0x1

    return v0
.end method

.method public getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 1

    .prologue
    .line 436
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCurrentBitrate()I
    .locals 1

    .prologue
    .line 466
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1

    .prologue
    .line 496
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method public getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .locals 1

    .prologue
    .line 446
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyCaptionTrack:Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

    return-object v0
.end method

.method public getCurrentPlaybackSpeed()F
    .locals 1

    .prologue
    .line 424
    const/high16 v0, 0x3f800000    # 1.0f

    return v0
.end method

.method public getCurrentPosition()J
    .locals 2

    .prologue
    .line 409
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentPosition()I

    move-result v0

    int-to-long v0, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getDisneyNetwordIdMap()Ljava/util/Map;
    .locals 3
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
    .line 583
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 584
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    .line 585
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    const-string v1, "disneychannel"

    const-string v2, "004"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 586
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    const-string v1, "disneyjunior"

    const-string v2, "008"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 587
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    const-string v1, "disneyxd"

    const-string v2, "009"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 588
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    const-string v1, "abcfamily"

    const-string v2, "002"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 591
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyNetwordIdMap:Ljava/util/Map;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 414
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getEndPosition()J
    .locals 2

    .prologue
    .line 404
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getDuration()I

    move-result v0

    int-to-long v0, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getFragmentInfo()Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    .locals 1

    .prologue
    .line 557
    const/4 v0, 0x0

    return-object v0
.end method

.method public getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 1

    .prologue
    .line 491
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1

    .prologue
    .line 451
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method

.method public getSupportedClosedCaptionsOptions()Ljava/util/List;
    .locals 1
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
    .line 481
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getSupportedPlaybackSpeeds()Ljava/util/List;
    .locals 1
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
    .line 419
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 1

    .prologue
    .line 521
    const/4 v0, 0x0

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 506
    const/4 v0, 0x0

    return-object v0
.end method

.method public getVideoHeight()J
    .locals 2

    .prologue
    .line 541
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getVideoHeight()I

    move-result v0

    int-to-long v0, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 547
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    return-object v0
.end method

.method public getVideoWidth()J
    .locals 2

    .prologue
    .line 536
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getVideoWidth()I

    move-result v0

    int-to-long v0, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getView()Landroid/view/View;
    .locals 1

    .prologue
    .line 461
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSurface:Landroid/view/SurfaceView;

    return-object v0
.end method

.method public hasCC()Z
    .locals 1

    .prologue
    .line 531
    const/4 v0, 0x1

    return v0
.end method

.method public hasDRM()Z
    .locals 1

    .prologue
    .line 526
    const/4 v0, 0x1

    return v0
.end method

.method public onAuthorizationFailure(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Ljava/lang/String;)V
    .locals 3
    .param p1, "vpMedia"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .param p2, "failureMessage"    # Ljava/lang/String;

    .prologue
    .line 614
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "TeaTime-Disney Media Authorization failed with message: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 615
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 616
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    const-string v1, "40102"

    invoke-virtual {v0, v1, p2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 618
    :cond_0
    return-void
.end method

.method public onAuthorizationSuccess(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 3
    .param p1, "vpMedia"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    const/4 v2, 0x0

    .line 602
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isDrmComplete:Z

    .line 604
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    if-nez v0, :cond_0

    .line 606
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 607
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v2, v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V

    .line 610
    :cond_0
    return-void
.end method

.method public onAuthorizationTokenRequest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 3
    .param p1, "vpMedia"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 622
    move-object v0, p1

    .line 623
    .local v0, "mediaToAuthorize":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v1

    new-instance v2, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;

    invoke-direct {v2, p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$4;-><init>(Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 644
    return-void
.end method

.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 648
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v1, "TeaTime-media player error"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 649
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    if-nez v0, :cond_1

    .line 650
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 651
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->retryAsset()V

    .line 659
    :cond_0
    :goto_0
    const/4 v0, 0x0

    return v0

    .line 653
    :cond_1
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->ERROR:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 655
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 656
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "An error has occuring with playing this stream"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->pause()V

    .line 137
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 138
    return-void
.end method

.method public play()V
    .locals 2

    .prologue
    .line 102
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v1, "teatime-play()"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 103
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    if-nez v0, :cond_0

    .line 105
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->retryAsset()V

    .line 111
    :goto_0
    return-void

    .line 107
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isRetryAttempting:Z

    .line 108
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->start()V

    .line 109
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    goto :goto_0
.end method

.method public removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 516
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 517
    return-void
.end method

.method public seekToLive()V
    .locals 0

    .prologue
    .line 346
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 8
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # J
    .param p4, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    const/4 v7, 0x0

    .line 149
    iput-boolean v7, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->isDrmComplete:Z

    .line 151
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 152
    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->updatePlayState(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    .line 153
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->refreshCaptionContainer()V

    .line 156
    :try_start_0
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getNetworkId()Ljava/lang/String;

    move-result-object v2

    .line 158
    .local v2, "networkId":Ljava/lang/String;
    invoke-static {v2}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 159
    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getChannelName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->getChannelId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 162
    :cond_0
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->provider:Ljava/lang/String;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getPlayerManager(Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerManager:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    .line 164
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->getMediaFromCatalog()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    .line 166
    .local v1, "media":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    if-nez v1, :cond_2

    .line 180
    .end local v1    # "media":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v2    # "networkId":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 171
    .restart local v1    # "media":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .restart local v2    # "networkId":Ljava/lang/String;
    :cond_2
    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playMedia(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    :try_end_0
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 173
    .end local v1    # "media":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .end local v2    # "networkId":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 174
    .local v0, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    sget-object v3, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v4, "TeaTime-error: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 176
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v3, :cond_1

    .line 177
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getErrorCode()Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    move-result-object v4

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getErrorCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setClosedCaptionsEnabled(Z)V
    .locals 2
    .param p1, "flag"    # Z

    .prologue
    .line 360
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->disneyCaptionTrack:Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyClosedCaptionTrack;->setIsSelected(Z)V

    .line 361
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    .line 362
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->enableClosedCaptioning(Z)V

    .line 365
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_1

    .line 366
    if-eqz p1, :cond_2

    .line 367
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 372
    :cond_1
    :goto_0
    return-void

    .line 369
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->ccContainer:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public setClosedCaptionsOptions()V
    .locals 3

    .prologue
    .line 396
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v1, :cond_0

    .line 397
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getCaptionFormat()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v0

    .line 398
    .local v0, "closedCaptionsOptions":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->toVPCaptionStyle()Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setCaptionStyle(Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;)V

    .line 400
    .end local v0    # "closedCaptionsOptions":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    :cond_0
    return-void
.end method

.method public setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
    .locals 0
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .prologue
    .line 377
    return-void
.end method

.method public setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
    .locals 0
    .param p1, "logFactory"    # Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .prologue
    .line 487
    return-void
.end method

.method public setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 0
    .param p1, "verbosity"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 553
    return-void
.end method

.method public setPosition(JZ)V
    .locals 0
    .param p1, "seconds"    # J
    .param p3, "skipAds"    # Z

    .prologue
    .line 351
    return-void
.end method

.method public setPositionRelative(J)V
    .locals 0
    .param p1, "seconds"    # J

    .prologue
    .line 356
    return-void
.end method

.method public setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 0
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 382
    return-void
.end method

.method public setVolume(I)V
    .locals 0
    .param p1, "volume"    # I

    .prologue
    .line 393
    return-void
.end method

.method public settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V
    .locals 2
    .param p1, "setting"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .prologue
    .line 664
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer$5;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 678
    :goto_0
    return-void

    .line 666
    :pswitch_0
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setClosedCaptionsOptions()V

    goto :goto_0

    .line 669
    :pswitch_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClosedCaptionsEnabled()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setClosedCaptionsEnabled(Z)V

    goto :goto_0

    .line 672
    :pswitch_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getClosedCaptionsTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V

    goto :goto_0

    .line 675
    :pswitch_3
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->playerSettings:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->getPreferredAudioLanguage()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    goto :goto_0

    .line 664
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->reset()V

    .line 145
    :cond_0
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 2
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 570
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v1, "TeaTime-Surface Changed"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 571
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    .line 572
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 574
    :cond_0
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 562
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v1, "TeaTime- Surface Created"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 563
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    if-eqz v0, :cond_0

    .line 564
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->mediaPlayer:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;

    invoke-virtual {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 566
    :cond_0
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 578
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/disney/DisneyPlayer;->logger:Lorg/slf4j/Logger;

    const-string v1, "TeaTime-Surface Destroyed"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 580
    return-void
.end method
