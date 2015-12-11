.class public final Lcom/amazon/identity/platform/metric/MetricUtils;
.super Ljava/lang/Object;
.source "MetricUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    return-void
.end method

.method public static checkConnectivity(Landroid/content/Context;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "timer"    # Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .prologue
    const/4 v1, 0x0

    .line 141
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 143
    sget-object v2, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Running in unit test. Returning false"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    :cond_0
    :goto_0
    return v1

    .line 148
    :cond_1
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 150
    invoke-virtual {p1}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->discard()V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 151
    const/4 v1, 0x1

    goto :goto_0

    .line 154
    :catch_0
    move-exception v0

    .line 156
    .local v0, "e":Ljava/lang/SecurityException;
    sget-object v2, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "We do not have permission to get the network state. Please make sure the permission android.permission.ACCESS_NETWORK_STATE is included in your manifest"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static getAuthPortalUrlPathAndDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 47
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getAuthPortalUrlType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 48
    .local v0, "mapURL":Ljava/lang/String;
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 49
    .local v1, "uri":Ljava/net/URL;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 53
    .end local v0    # "mapURL":Ljava/lang/String;
    .end local v1    # "uri":Ljava/net/URL;
    :goto_0
    return-object v2

    :catch_0
    move-exception v2

    const-string/jumbo v2, "CannotGetURL"

    goto :goto_0
.end method

.method public static getAuthPortalUrlType(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 59
    if-nez p0, :cond_0

    .line 61
    const-string/jumbo v0, "CannotGetURL"

    .line 81
    :goto_0
    return-object v0

    .line 63
    :cond_0
    const-string/jumbo v0, "/ap/signin"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 65
    const-string/jumbo v0, "/ap/signin"

    goto :goto_0

    .line 67
    :cond_1
    const-string/jumbo v0, "/ap/forgotpassword"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 69
    const-string/jumbo v0, "/ap/forgotpassword"

    goto :goto_0

    .line 71
    :cond_2
    const-string/jumbo v0, "/ap/register"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 73
    const-string/jumbo v0, "/ap/register"

    goto :goto_0

    .line 75
    :cond_3
    const-string/jumbo v0, "/ap/challenge"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 77
    const-string/jumbo v0, "/ap/challenge"

    goto :goto_0

    .line 81
    :cond_4
    const-string/jumbo v0, "NonMAPURL"

    goto :goto_0
.end method

.method public static getAvailabilityMetricName(Ljava/net/URL;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;

    .prologue
    .line 236
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":Availability"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getIOExceptionMetricName(Ljava/net/URL;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;

    .prologue
    .line 226
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":IOException"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getIOExceptionWithSubClassMetricName(Ljava/net/URL;Ljava/io/IOException;Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "e"    # Ljava/io/IOException;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 231
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getIOExceptionMetricName(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p2}, Lcom/amazon/identity/platform/metric/MetricUtils;->getNetworkStatus(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getMAPUrlType(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 87
    if-nez p0, :cond_0

    .line 89
    const-string/jumbo v0, "CannotGetURL"

    .line 132
    :goto_0
    return-object v0

    .line 91
    :cond_0
    const-string/jumbo v0, "getNewDeviceCredentials"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 93
    const-string/jumbo v0, "getNewDeviceCredentials"

    goto :goto_0

    .line 95
    :cond_1
    const-string/jumbo v0, "registerAssociatedDevice"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 97
    const-string/jumbo v0, "registerAssociatedDevice"

    goto :goto_0

    .line 99
    :cond_2
    const-string/jumbo v0, "registerDeviceWithToken"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 101
    const-string/jumbo v0, "registerDeviceWithToken"

    goto :goto_0

    .line 103
    :cond_3
    const-string/jumbo v0, "registerDeviceToSecondaryCustomer"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 105
    const-string/jumbo v0, "registerDeviceToSecondaryCustomer"

    goto :goto_0

    .line 107
    :cond_4
    const-string/jumbo v0, "registerDevice"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 109
    const-string/jumbo v0, "registerDevice"

    goto :goto_0

    .line 111
    :cond_5
    const-string/jumbo v0, "renameFiona"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 113
    const-string/jumbo v0, "renameFiona"

    goto :goto_0

    .line 115
    :cond_6
    const-string/jumbo v0, "disownFiona"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 117
    const-string/jumbo v0, "disownFiona"

    goto :goto_0

    .line 119
    :cond_7
    const-string/jumbo v0, "/auth/register"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 121
    const-string/jumbo v0, "/auth/register"

    goto :goto_0

    .line 123
    :cond_8
    const-string/jumbo v0, "/auth/signin"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 125
    const-string/jumbo v0, "/auth/signin"

    goto :goto_0

    .line 127
    :cond_9
    const-string/jumbo v0, "/ap/exchangetoken"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 129
    const-string/jumbo v0, "/ap/exchangetoken"

    goto/16 :goto_0

    .line 132
    :cond_a
    const-string/jumbo v0, "NonMAPURL"

    goto/16 :goto_0
.end method

.method public static getNetworkStatus(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 194
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 196
    const-string/jumbo v1, "Connected"
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 206
    :goto_0
    return-object v1

    .line 198
    :cond_0
    const-string/jumbo v1, "NotConnected"

    goto :goto_0

    .line 200
    :catch_0
    move-exception v0

    .line 202
    .local v0, "e":Ljava/lang/SecurityException;
    sget-object v1, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "We do not have permission to get the network state. Please make sure the permission android.permission.ACCESS_NETWORK_STATE is included in your manifest"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 206
    const-string/jumbo v1, "NetworkStatusUnknown"

    goto :goto_0
.end method

.method public static getRetriesFailedMetricName(Ljava/net/URL;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;

    .prologue
    .line 246
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":AllRetriesFailed"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSuccessAfterRetryMetricName(Ljava/net/URL;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;

    .prologue
    .line 241
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":SuccessAfterRetry"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUrlPathAndDomain(Ljava/net/URL;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;

    .prologue
    .line 211
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUrlPathAndDomain(Ljava/net/URL;I)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "responseCode"    # I

    .prologue
    .line 216
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUrlPathAndDomain(Ljava/net/URL;ILjava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "responseCode"    # I
    .param p2, "errorCode"    # Ljava/lang/String;

    .prologue
    .line 221
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p0, p1}, Lcom/amazon/identity/platform/metric/MetricUtils;->getUrlPathAndDomain(Ljava/net/URL;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static isDeviceConnected(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 182
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/platform/metric/MetricUtils;->isNetworkAvailable(Landroid/content/Context;)Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 186
    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isNetworkAvailable(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 170
    const-string/jumbo v1, "connectivity"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    .line 171
    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 172
    .local v0, "activeNetwork":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
