.class public Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;
.super Ljava/lang/Object;
.source "AndroidConnectivitySampler.java"

# interfaces
.implements Lcom/newrelic/agent/android/util/ConnectivitySampler;


# static fields
.field private static log:Lcom/newrelic/agent/android/logging/AgentLog;


# instance fields
.field private final context:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    invoke-static {}, Lcom/newrelic/agent/android/logging/AgentLogManager;->getAgentLog()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;->context:Landroid/content/Context;

    .line 17
    return-void
.end method


# virtual methods
.method public sample()Z
    .locals 5

    .prologue
    .line 21
    :try_start_0
    iget-object v3, p0, Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;->context:Landroid/content/Context;

    const-string v4, "connectivity"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 23
    .local v0, "connectivityManager":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v2

    .line 24
    .local v2, "networkInfo":Landroid/net/NetworkInfo;
    if-eqz v2, :cond_0

    .line 25
    invoke-virtual {v2}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 31
    .end local v0    # "connectivityManager":Landroid/net/ConnectivityManager;
    .end local v2    # "networkInfo":Landroid/net/NetworkInfo;
    :goto_0
    return v3

    .line 27
    .restart local v0    # "connectivityManager":Landroid/net/ConnectivityManager;
    .restart local v2    # "networkInfo":Landroid/net/NetworkInfo;
    :cond_0
    const/4 v3, 0x0

    goto :goto_0

    .line 29
    .end local v0    # "connectivityManager":Landroid/net/ConnectivityManager;
    .end local v2    # "networkInfo":Landroid/net/NetworkInfo;
    :catch_0
    move-exception v1

    .line 30
    .local v1, "e":Ljava/lang/SecurityException;
    sget-object v3, Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v4, "Unable to call ConnectivityManager.getActiveNetworkInfo(). Please add the android.permission.ACCESS_NETWORK_STATE permission to your AndroidManifest.xml"

    invoke-interface {v3, v4}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 31
    const/4 v3, 0x1

    goto :goto_0
.end method
