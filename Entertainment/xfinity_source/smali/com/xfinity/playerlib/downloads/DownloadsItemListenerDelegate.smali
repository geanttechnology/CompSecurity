.class public Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;
.super Ljava/lang/Object;
.source "DownloadsItemListenerDelegate.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Landroid/content/Context;)V
    .locals 0
    .param p1, "downloadsManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 26
    return-void
.end method


# virtual methods
.method public onCancelDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 49
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1, p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteFile(Lcom/comcast/cim/downloads/DownloadFile;)Ljava/util/Map;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 54
    :goto_0
    return-void

    .line 50
    :catch_0
    move-exception v0

    .line 51
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onHotwireDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 30
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1, p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->startDownloadImmediately(Lcom/comcast/cim/downloads/DownloadFile;)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 35
    :goto_0
    return-void

    .line 31
    :catch_0
    move-exception v0

    .line 32
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onPlayEntitledDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 57
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    .line 58
    .local v2, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v1

    .line 59
    .local v1, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 60
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-nez v4, :cond_0

    .line 61
    invoke-static {v0, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 65
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    return-void
.end method

.method public onPlayUnentitledDownloadPressed(Landroid/app/FragmentManager;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 2
    .param p1, "fragmentManager"    # Landroid/app/FragmentManager;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 68
    sget-object v1, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_DOWNLOADED:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v1, p2}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v0

    .line 69
    .local v0, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v1, "upsell_dialog"

    invoke-virtual {v0, p1, v1}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 70
    return-void
.end method

.method public onRetryDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 40
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->resumeDownloading()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    :goto_0
    return-void

    .line 41
    :catch_0
    move-exception v0

    .line 42
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/downloads/DownloadsItemListenerDelegate;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
