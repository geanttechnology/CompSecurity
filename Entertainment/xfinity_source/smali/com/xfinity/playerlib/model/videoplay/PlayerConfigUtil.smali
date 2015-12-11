.class public Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;
.super Ljava/lang/Object;
.source "PlayerConfigUtil.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final isDebuggable:Z

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Z)V
    .locals 0
    .param p1, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p2, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p3, "isDebuggable"    # Z

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 24
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 25
    iput-boolean p3, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->isDebuggable:Z

    .line 26
    return-void
.end method

.method static synthetic access$000()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method


# virtual methods
.method public configureESPNPlayer(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 101
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 102
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady()Z

    move-result v1

    if-nez v1, :cond_0

    .line 103
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->initializeESPN(Landroid/content/Context;Z)V

    .line 123
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$2;

    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Landroid/content/Context;)V

    .line 121
    .local v0, "listener":Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configurePlayerPlatform(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;)V

    goto :goto_0
.end method

.method public declared-synchronized configurePlayerPlatform(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;)V
    .locals 7
    .param p1, "listener"    # Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;

    .prologue
    .line 29
    monitor-enter p0

    :try_start_0
    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v4}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->wantsStaticBitrate()Z

    move-result v4

    if-nez v4, :cond_0

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsStaticBitrate()Z

    move-result v4

    if-nez v4, :cond_0

    const/4 v2, 0x1

    .line 30
    .local v2, "autoPlay":Z
    :goto_0
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v4

    invoke-virtual {v4, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->addListener(Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;)V

    .line 31
    iget-boolean v4, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->isDebuggable:Z

    if-eqz v4, :cond_1

    const-string v3, "<configuration type=\"stage\" version=\"0.10\">\n"

    .line 33
    .local v3, "version":Ljava/lang/String;
    :goto_1
    iget-boolean v4, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->isDebuggable:Z

    if-eqz v4, :cond_2

    const-string v0, "<add key=\"AnalyticsEndpoint\" value=\"http://qa-analytics.bdn.lab.xcal.tv/qa/player\"/>\n"

    .line 35
    .local v0, "analyticsEndpoint":Ljava/lang/String;
    :goto_2
    iget-boolean v4, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->isDebuggable:Z

    if-eqz v4, :cond_3

    const-string v1, "androidpts"

    .line 37
    .local v1, "auditudeParam":Ljava/lang/String;
    :goto_3
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v5

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<analyticsSettings>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"AnalyticsProtocol\" value=\"1.2-p1\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"AnalyticsDeviceType\" value=\"tvgo-android\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"MaxBatchSize\" value=\"10\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"MaxQueueSize\" value=\"100\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"BatchInterval\" value=\"5000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "</analyticsSettings>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<appSettings>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"HeartbeatInterval\" value=\"60000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"Autoplay\" value=\""

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 48
    invoke-static {v2}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"AbrPolicy\" value=\"ABR_MODERATE\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"MinimumBitrate\" value=\"150000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"MaximumBitrate\" value=\"4000000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"InitialBitrate\" value=\"150000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"InitialBuffer\" value=\"4000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"PlaybackBuffer\" value=\"80000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"PlayingLinearBufferTime\" value=\"15000\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"RetryOnMediaFailed\" value=\"true\"/>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "</appSettings>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<auditudeSettings>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"DomainId\" value=\"auditude.com\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"ZoneId\" value=\"2637\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"CustomParams\" paramKey=\"plr\" paramValue=\""

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "<add key=\"CustomParams\" paramKey=\"device\" paramValue=\""

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 63
    invoke-virtual {v4}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v4

    if-eqz v4, :cond_4

    const-string v4, "androidtablet"

    :goto_4
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "\"/>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "</auditudeSettings>\n"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, "</configuration>"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 37
    invoke-virtual {v5, v4}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->loadConfigurationFromXml(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    monitor-exit p0

    return-void

    .line 29
    .end local v0    # "analyticsEndpoint":Ljava/lang/String;
    .end local v1    # "auditudeParam":Ljava/lang/String;
    .end local v2    # "autoPlay":Z
    .end local v3    # "version":Ljava/lang/String;
    :cond_0
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 31
    .restart local v2    # "autoPlay":Z
    :cond_1
    :try_start_1
    const-string v3, "<configuration type=\"prod\" version=\"2.0\">\n"

    goto/16 :goto_1

    .line 33
    .restart local v3    # "version":Ljava/lang/String;
    :cond_2
    const-string v0, "<add key=\"AnalyticsEndpoint\" value=\"http://analytics.xcal.tv/player\"/>\n"

    goto/16 :goto_2

    .line 35
    .restart local v0    # "analyticsEndpoint":Ljava/lang/String;
    :cond_3
    const-string v1, "androidptp"

    goto/16 :goto_3

    .line 63
    .restart local v1    # "auditudeParam":Ljava/lang/String;
    :cond_4
    const-string v4, "android"
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_4

    .line 29
    .end local v0    # "analyticsEndpoint":Ljava/lang/String;
    .end local v1    # "auditudeParam":Ljava/lang/String;
    .end local v2    # "autoPlay":Z
    .end local v3    # "version":Ljava/lang/String;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public configureSynchronous(J)V
    .locals 7
    .param p1, "timeoutInSeconds"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
        }
    .end annotation

    .prologue
    .line 70
    new-instance v3, Ljava/util/concurrent/CountDownLatch;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 71
    .local v3, "waitForConfig":Ljava/util/concurrent/CountDownLatch;
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;

    invoke-direct {v2, p0, v3}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Ljava/util/concurrent/CountDownLatch;)V

    .line 88
    .local v2, "listener":Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
    :try_start_0
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configurePlayerPlatform(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;)V

    .line 89
    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, p1, p2, v4}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 95
    .local v1, "finished":Z
    if-nez v1, :cond_0

    .line 96
    new-instance v4, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v5, "Failed to Configure PlayerPlatform within allotted timeout"

    invoke-direct {v4, v5}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 90
    .end local v1    # "finished":Z
    :catch_0
    move-exception v0

    .line 91
    .local v0, "e":Ljava/lang/InterruptedException;
    new-instance v4, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v5, "Failed to Configure PlayerPlatform"

    invoke-direct {v4, v5, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4

    .line 98
    .end local v0    # "e":Ljava/lang/InterruptedException;
    .restart local v1    # "finished":Z
    :cond_0
    return-void
.end method
