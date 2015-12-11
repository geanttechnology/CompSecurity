.class public Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
.super Ljava/lang/Object;
.source "VPPlayerManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$2;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;

.field private static _instance:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;


# instance fields
.field private catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

.field private configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

.field private currentMediaPlayer:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<",
            "Landroid/media/MediaPlayer;",
            ">;"
        }
    .end annotation
.end field

.field private executorService:Ljava/util/concurrent/ThreadPoolExecutor;

.field private isCancelled:Z

.field private requestInProgress:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->TAG:Ljava/lang/String;

    .line 33
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->_instance:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z

    .line 65
    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z

    .line 79
    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    return-object v0
.end method

.method static synthetic access$102(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
    .param p1, "x1"    # Z

    .prologue
    .line 28
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z

    return p1
.end method

.method static synthetic access$200(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z

    return v0
.end method

.method static synthetic access$300()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private static getInstance()Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->_instance:Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    return-object v0
.end method

.method public static getPlayerManager(Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
    .locals 6
    .param p0, "partnerName"    # Ljava/lang/String;
    .param p1, "network"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 38
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 39
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v5, "invalid partnerName"

    invoke-direct {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v3

    .line 41
    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 42
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v5, "invalid network identifier"

    invoke-direct {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v3

    .line 45
    :cond_1
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-direct {v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;-><init>()V

    .line 46
    .local v1, "configuration":Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    invoke-virtual {v1, p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->initialize(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getInstance()Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;

    move-result-object v2

    .line 51
    .local v2, "manager":Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;
    invoke-virtual {v2, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 52
    const/4 v3, 0x0

    invoke-static {v3, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;->getCatalogManager(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    move-result-object v0

    .line 53
    .local v0, "catalogManager":Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    invoke-virtual {v2, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->setCatalogManager(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;)V

    .line 54
    return-object v2
.end method

.method private declared-synchronized shutdown()V
    .locals 1

    .prologue
    .line 402
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    if-eqz v0, :cond_0

    .line 404
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 406
    :cond_0
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->forceCancel()V

    .line 407
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 408
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z

    .line 409
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 410
    monitor-exit p0

    return-void

    .line 402
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method protected finalize()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 454
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->shutdown()V

    .line 455
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->TAG:Ljava/lang/String;

    const-string v1, "Removing VPPlayerManager and shutting down resources"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    .line 457
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 458
    return-void
.end method

.method public getCatalogManager()Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;
    .locals 1

    .prologue
    .line 390
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    return-object v0
.end method

.method public declared-synchronized getPlayer(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;Landroid/app/Activity;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;)Landroid/media/MediaPlayer;
    .locals 5
    .param p1, "playerType"    # Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;
    .param p2, "context"    # Landroid/app/Activity;
    .param p3, "holder"    # Landroid/view/SurfaceHolder;
    .param p4, "ccContainer"    # Landroid/widget/RelativeLayout;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 349
    monitor-enter p0

    const/4 v1, 0x0

    .line 351
    .local v1, "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    :try_start_0
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$2;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType:[I

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 372
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 375
    :catch_0
    move-exception v0

    .line 376
    .local v0, "e":Ljava/lang/Exception;
    :goto_0
    :try_start_1
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v3, v4, v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 349
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    :goto_1
    monitor-exit p0

    throw v3

    .line 353
    :pswitch_0
    :try_start_2
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-direct {v2, p2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;-><init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 354
    .end local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .local v2, "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    if-eqz p3, :cond_0

    .line 355
    :try_start_3
    invoke-virtual {v2, p3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 357
    :cond_0
    invoke-virtual {v2, p4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setClosedCaptionContainer(Landroid/widget/RelativeLayout;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-object v1, v2

    .line 378
    .end local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    :goto_2
    monitor-exit p0

    return-object v1

    .line 360
    :pswitch_1
    :try_start_4
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-direct {v2, p2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;-><init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 361
    .end local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    if-eqz p3, :cond_1

    .line 362
    :try_start_5
    invoke-virtual {v2, p3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 364
    :cond_1
    invoke-virtual {v2, p4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setClosedCaptionContainer(Landroid/widget/RelativeLayout;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    move-object v1, v2

    .line 365
    .end local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    goto :goto_2

    .line 367
    :pswitch_2
    :try_start_6
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-direct {v2, p2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;-><init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 368
    .end local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    if-eqz p3, :cond_2

    .line 369
    :try_start_7
    invoke-virtual {v2, p3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    move-object v1, v2

    .end local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    goto :goto_2

    .line 375
    .end local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    :catch_1
    move-exception v0

    move-object v1, v2

    .end local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    goto :goto_0

    .line 349
    .end local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    :catchall_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    goto :goto_1

    .end local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    :cond_2
    move-object v1, v2

    .end local v2    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .restart local v1    # "player":Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    goto :goto_2

    .line 351
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getPlayer(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 9
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .param p3, "holder"    # Landroid/view/SurfaceHolder;
    .param p4, "ccContainer"    # Landroid/widget/RelativeLayout;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            "Landroid/view/SurfaceHolder;",
            "Landroid/widget/RelativeLayout;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Landroid/media/MediaPlayer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Landroid/media/MediaPlayer;",
            ">;"
        }
    .end annotation

    .prologue
    .local p5, "handler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Landroid/media/MediaPlayer;>;"
    const/4 v8, 0x1

    .line 99
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_5

    .line 100
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    invoke-interface {v0}, Ljava/util/concurrent/Future;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    invoke-interface {v0}, Ljava/util/concurrent/Future;->isDone()Z

    move-result v0

    if-nez v0, :cond_1

    .line 101
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    invoke-interface {v0, v8}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 102
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->shutdown()V

    .line 110
    :cond_1
    :goto_0
    monitor-enter p0

    .line 112
    :try_start_0
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    if-nez v0, :cond_3

    .line 113
    :cond_2
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const/16 v2, 0xa

    const/16 v3, 0xa

    const-wide/16 v4, 0xc

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v0, 0xa

    invoke-direct {v7, v0}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 114
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 116
    :cond_3
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 118
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p5

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;)V

    invoke-virtual {v7, v0}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    .line 324
    iput-boolean v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->requestInProgress:Z

    .line 326
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_4

    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z

    if-eqz v0, :cond_4

    .line 327
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    invoke-interface {v0, v8}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 329
    :cond_4
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->currentMediaPlayer:Ljava/util/concurrent/Future;

    return-object v0

    .line 106
    :cond_5
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->isCancelled:Z

    goto :goto_0

    .line 116
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public getPlayer(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Landroid/view/SurfaceHolder;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 6
    .param p1, "context"    # Landroid/app/Activity;
    .param p2, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .param p3, "holder"    # Landroid/view/SurfaceHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            "Landroid/view/SurfaceHolder;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Landroid/media/MediaPlayer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Landroid/media/MediaPlayer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    .local p4, "handler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Landroid/media/MediaPlayer;>;"
    const/4 v4, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->getPlayer(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Landroid/view/SurfaceHolder;Landroid/widget/RelativeLayout;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public setCatalogManager(Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;)V
    .locals 0
    .param p1, "catalogManager"    # Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    .prologue
    .line 394
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->catalogManager:Lcom/disney/datg/videoplatforms/sdk/media/VPCatalogManager;

    .line 395
    return-void
.end method

.method public setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 0
    .param p1, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 386
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPPlayerManager;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 387
    return-void
.end method
