.class Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;
.super Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
.source "MediaLicenseClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->getOrRefreshMediaLicense(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;Lcom/comcast/playerplatform/primetime/android/asset/Asset;)Ljava/util/Date;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

.field final synthetic val$cimAsset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field final synthetic val$licenseExpirationFuture:Lcom/google/common/util/concurrent/SettableFuture;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;Lcom/comcast/playerplatform/primetime/android/asset/Asset;Lcom/google/common/util/concurrent/SettableFuture;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->val$cimAsset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->val$licenseExpirationFuture:Lcom/google/common/util/concurrent/SettableFuture;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 1
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->val$cimAsset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iget-object v0, v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->manifestUri:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->val$licenseExpirationFuture:Lcom/google/common/util/concurrent/SettableFuture;

    invoke-virtual {v0, p3}, Lcom/google/common/util/concurrent/SettableFuture;->set(Ljava/lang/Object;)Z

    .line 45
    :cond_0
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 50
    new-instance v0, Lcom/comcast/cim/analytics/VideoErrorEventData;

    const-string v2, "drmFailure"

    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->hashedOmnitureGuid:Ljava/lang/String;
    invoke-static {v3}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->access$000(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->versionNumber:Ljava/lang/String;
    invoke-static {v4}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->access$100(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v2, v3, v4}, Lcom/comcast/cim/analytics/VideoErrorEventData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    .local v0, "drmFailureReportTask":Lcom/comcast/cim/analytics/VideoErrorEventData;
    invoke-virtual {v0, p1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorCodes(Ljava/lang/String;)V

    .line 52
    invoke-virtual {v0, p2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorTitle(Ljava/lang/String;)V

    .line 54
    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    invoke-direct {v1, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    .local v1, "errorException":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;
    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    invoke-static {v2}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->access$200(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v2

    invoke-interface {v2, v1}, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorMessage(Ljava/lang/String;)V

    .line 57
    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    invoke-static {v2}, Lcom/xfinity/playerlib/downloads/MediaLicenseClient;->access$300(Lcom/xfinity/playerlib/downloads/MediaLicenseClient;)Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 59
    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseClient$1;->val$licenseExpirationFuture:Lcom/google/common/util/concurrent/SettableFuture;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    invoke-direct {v3, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/google/common/util/concurrent/SettableFuture;->setException(Ljava/lang/Throwable;)Z

    .line 60
    return-void
.end method
