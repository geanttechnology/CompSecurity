.class public Lcom/xfinity/playnow/PlayNowContainer;
.super Lcom/comcast/cim/container/PlayerContainer;
.source "PlayNowContainer.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static configVersion:Ljava/lang/String;


# instance fields
.field private configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/xfinity/playnow/PlayNowContainer;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playnow/PlayNowContainer;->LOG:Lorg/slf4j/Logger;

    .line 26
    const-string v0, ""

    sput-object v0, Lcom/xfinity/playnow/PlayNowContainer;->configVersion:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;)V
    .locals 0
    .param p1, "playerApplication"    # Lcom/xfinity/playerlib/PlayerApplication;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/comcast/cim/container/PlayerContainer;-><init>(Lcom/xfinity/playerlib/PlayerApplication;)V

    .line 30
    return-void
.end method

.method public static declared-synchronized initialize(Lcom/xfinity/playerlib/PlayerApplication;)V
    .locals 2
    .param p0, "application"    # Lcom/xfinity/playerlib/PlayerApplication;

    .prologue
    .line 33
    const-class v1, Lcom/xfinity/playnow/PlayNowContainer;

    monitor-enter v1

    :try_start_0
    new-instance v0, Lcom/xfinity/playnow/PlayNowContainer;

    invoke-direct {v0, p0}, Lcom/xfinity/playnow/PlayNowContainer;-><init>(Lcom/xfinity/playerlib/PlayerApplication;)V

    sput-object v0, Lcom/xfinity/playnow/PlayNowContainer;->instance:Lcom/comcast/cim/container/PlayerContainer;

    .line 34
    sget-object v0, Lcom/xfinity/playnow/PlayNowContainer;->instance:Lcom/comcast/cim/container/PlayerContainer;

    invoke-static {v0}, Lcom/comcast/cim/container/CALContainer;->setInstance(Lcom/comcast/cim/container/CALContainer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 35
    monitor-exit v1

    return-void

    .line 33
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public createAppUpgradeHelper()Lcom/comcast/cim/android/application/AppUpgradeHelper;
    .locals 8

    .prologue
    .line 59
    new-instance v0, Lcom/xfinity/playnow/PlayNowAppUpgradHelper;

    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playnow/PlayNowContainer;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playnow/PlayNowContainer;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 60
    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getPersistentEntityCache()Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    move-result-object v5

    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getPersistentCaptionsCache()Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    move-result-object v6

    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playnow/PlayNowAppUpgradHelper;-><init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/model/user/UserManager;Landroid/content/SharedPreferences;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;)V

    return-object v0
.end method

.method public getAvailableConfigurations()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 67
    .local v0, "configurationList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/config/PlayerConfiguration;>;"
    new-instance v1, Lcom/xfinity/playnow/config/ProductionConfiguration;

    invoke-direct {v1}, Lcom/xfinity/playnow/config/ProductionConfiguration;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 68
    new-instance v1, Lcom/xfinity/playnow/config/StagingConfiguration;

    invoke-direct {v1}, Lcom/xfinity/playnow/config/StagingConfiguration;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 69
    new-instance v1, Lcom/xfinity/playnow/config/DenverStagingConfiguration;

    invoke-direct {v1}, Lcom/xfinity/playnow/config/DenverStagingConfiguration;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 70
    new-instance v1, Lcom/xfinity/playnow/config/SprintQaConfiguration;

    invoke-direct {v1}, Lcom/xfinity/playnow/config/SprintQaConfiguration;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 71
    new-instance v1, Lcom/xfinity/playnow/config/MrQaConfiguration;

    invoke-direct {v1}, Lcom/xfinity/playnow/config/MrQaConfiguration;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 73
    return-object v0
.end method

.method public bridge synthetic getConfiguration()Lcom/comcast/cim/config/CALConfiguration;
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    return-object v0
.end method

.method public getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .locals 4

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playnow/PlayNowContainer;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    if-nez v0, :cond_0

    .line 40
    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/PlayerApplication;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_1

    .line 41
    new-instance v0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;

    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getAvailableConfigurations()Ljava/util/List;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playnow/config/ProductionConfiguration;

    invoke-direct {v2}, Lcom/xfinity/playnow/config/ProductionConfiguration;-><init>()V

    .line 43
    invoke-virtual {p0}, Lcom/xfinity/playnow/PlayNowContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;-><init>(Ljava/util/List;Lcom/xfinity/playerlib/config/PlayerConfiguration;Landroid/content/SharedPreferences;)V

    iput-object v0, p0, Lcom/xfinity/playnow/PlayNowContainer;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 49
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playnow/PlayNowContainer;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    return-object v0

    .line 45
    :cond_1
    new-instance v0, Lcom/xfinity/playnow/config/ProductionConfiguration;

    invoke-direct {v0}, Lcom/xfinity/playnow/config/ProductionConfiguration;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playnow/PlayNowContainer;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    goto :goto_0
.end method

.method public getConfigurationVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/xfinity/playnow/PlayNowContainer;->configVersion:Ljava/lang/String;

    return-object v0
.end method
