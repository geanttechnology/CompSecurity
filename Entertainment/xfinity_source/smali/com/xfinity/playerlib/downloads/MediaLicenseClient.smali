.class public Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
.super Ljava/lang/Object;
.source "MediaLicenseClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/downloads/MediaLicenseClient$LicenseAcquisitionTimeoutException;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private final hashedOmnitureGuid:Ljava/lang/String;

.field private final splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field private final versionNumber:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "splunker"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .param p2, "errorFormatter"    # Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .param p3, "hashedOmnitureGuid"    # Ljava/lang/String;
    .param p4, "versionNumber"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 30
    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 31
    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->hashedOmnitureGuid:Ljava/lang/String;

    .line 32
    iput-object p4, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->versionNumber:Ljava/lang/String;

    .line 33
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->hashedOmnitureGuid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->versionNumber:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    return-object v0
.end method


# virtual methods
.method public getOrRefreshMediaLicense(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/asset/Asset;)Ljava/util/Date;
    .locals 8
    .param p1, "playerPlatformAPI"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    .param p2, "cimAsset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .prologue
    .line 37
    invoke-static {}, Lcom/google/common/util/concurrent/SettableFuture;->create()Lcom/google/common/util/concurrent/SettableFuture;

    move-result-object v3

    .line 39
    .local v3, "licenseExpirationFuture":Lcom/google/common/util/concurrent/SettableFuture;, "Lcom/google/common/util/concurrent/SettableFuture<Ljava/util/Date;>;"
    new-instance v4, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;

    invoke-direct {v4, p0, p2, v3}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;-><init>(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;Lcom/comcast/playerplatform/primetime/android/asset/Asset;Lcom/google/common/util/concurrent/SettableFuture;)V

    .line 72
    .local v4, "listener":Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
    :try_start_0
    invoke-virtual {p1, v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 73
    invoke-virtual {p1, p2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->authenticateAssetOffline(Lcom/comcast/playerplatform/primetime/android/asset/Asset;)V

    .line 75
    const-wide/16 v6, 0x1e

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, v6, v7, v5}, Lcom/google/common/util/concurrent/SettableFuture;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Date;

    .line 76
    .local v2, "licenseExpiration":Ljava/util/Date;
    sget-object v5, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->LOG:Lorg/slf4j/Logger;

    const-string v6, "License acquisition attempt complete, expiration date: {}"

    invoke-interface {v5, v6, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 90
    invoke-virtual {p1, v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 93
    return-object v2

    .line 77
    .end local v2    # "licenseExpiration":Ljava/util/Date;
    :catch_0
    move-exception v1

    .line 78
    .local v1, "e":Ljava/lang/InterruptedException;
    :try_start_1
    sget-object v5, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->LOG:Lorg/slf4j/Logger;

    const-string v6, "Caught exception acquiring license"

    invoke-interface {v5, v6, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 79
    new-instance v5, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v6, "License acquisition failed"

    invoke-direct {v5, v6, v1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 90
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v5

    invoke-virtual {p1, v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    throw v5

    .line 80
    :catch_1
    move-exception v1

    .line 81
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    :try_start_2
    invoke-virtual {v1}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 82
    .local v0, "cause":Ljava/lang/Throwable;
    instance-of v5, v0, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    if-eqz v5, :cond_0

    .line 83
    check-cast v0, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    .end local v0    # "cause":Ljava/lang/Throwable;
    throw v0

    .line 85
    .restart local v0    # "cause":Ljava/lang/Throwable;
    :cond_0
    new-instance v5, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v6, "License acquisition failed"

    invoke-direct {v5, v6, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 87
    .end local v0    # "cause":Ljava/lang/Throwable;
    .end local v1    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_2
    move-exception v1

    .line 88
    .local v1, "e":Ljava/util/concurrent/TimeoutException;
    new-instance v5, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$LicenseAcquisitionTimeoutException;

    const-string v6, "License acquisition failed"

    invoke-direct {v5, v6, v1}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$LicenseAcquisitionTimeoutException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method
