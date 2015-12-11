.class public Lcom/newrelic/agent/android/AndroidAgentImpl;
.super Ljava/lang/Object;
.source "AndroidAgentImpl.java"

# interfaces
.implements Lcom/newrelic/agent/android/AgentImpl;
.implements Lcom/newrelic/agent/android/api/v1/ConnectionListener;
.implements Lcom/newrelic/agent/android/background/ApplicationStateListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;
    }
.end annotation


# static fields
.field private static final LOCATION_ACCURACY_THRESHOLD:F = 500.0f

.field static final NEW_RELIC_AGENT_DISABLED_VERSION_KEY:Ljava/lang/String; = "NewRelicAgentDisabledVersion"

.field public static final PREF_AGENT_VERSION:Ljava/lang/String; = "agentVersion"

.field public static final PREF_ANDROID_ID_BUG_WORK_AROUND:Ljava/lang/String; = "androidIdBugWorkAround"

.field public static final PREF_APP_TOKEN:Ljava/lang/String; = "appToken"

.field public static final PREF_COLLECT_NETWORK_ERRORS:Ljava/lang/String; = "collectNetworkErrors"

.field public static final PREF_CROSS_PROCESS_ID:Ljava/lang/String; = "crossProcessId"

.field public static final PREF_DATA_TOKEN:Ljava/lang/String; = "dataToken"

.field public static final PREF_ERROR_LIMIT:Ljava/lang/String; = "errorLimit"

.field public static final PREF_HARVEST_INTERVAL:Ljava/lang/String; = "harvestIntervalInSeconds"

.field public static final PREF_MAX_TRANSACTION_AGE:Ljava/lang/String; = "maxTransactionAgeInSeconds"

.field public static final PREF_MAX_TRANSACTION_COUNT:Ljava/lang/String; = "maxTransactionCount"

.field public static final PREF_RESPONSE_BODY_LIMIT:Ljava/lang/String; = "responseBodyLimit"

.field public static final PREF_SERVER_TIMESTAMP:Ljava/lang/String; = "serverTimestamp"

.field public static final PREF_STACK_TRACE_LIMIT:Ljava/lang/String; = "stackTraceLimit"

.field private static final cmp:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;"
        }
    .end annotation
.end field

.field private static final log:Lcom/newrelic/agent/android/logging/AgentLog;


# instance fields
.field private final api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

.field private final appToken:Ljava/lang/String;

.field private connected:Z

.field private final connectedCond:Ljava/util/concurrent/locks/Condition;

.field private connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

.field private final context:Landroid/content/Context;

.field private final encoder:Lcom/newrelic/agent/android/util/Encoder;

.field private final errorDataList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/newrelic/agent/android/api/common/ErrorData;",
            ">;"
        }
    .end annotation
.end field

.field private final heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

.field private locationListener:Landroid/location/LocationListener;

.field private final lock:Ljava/util/concurrent/locks/Lock;

.field private final packageName:Ljava/lang/String;

.field private final transactionDataList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    invoke-static {}, Lcom/newrelic/agent/android/logging/AgentLogManager;->getAgentLog()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    .line 609
    new-instance v0, Lcom/newrelic/agent/android/AndroidAgentImpl$1;

    invoke-direct {v0}, Lcom/newrelic/agent/android/AndroidAgentImpl$1;-><init>()V

    sput-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->cmp:Ljava/util/Comparator;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLcom/newrelic/agent/android/api/v1/NewRelicApi;Lcom/newrelic/agent/android/util/ConnectivitySampler;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appToken"    # Ljava/lang/String;
    .param p3, "collectorAddr"    # Ljava/lang/String;
    .param p4, "ssl"    # Z
    .param p5, "locationEnabled"    # Z
    .param p6, "api"    # Lcom/newrelic/agent/android/api/v1/NewRelicApi;
    .param p7, "connectivitySampler"    # Lcom/newrelic/agent/android/util/ConnectivitySampler;
    .param p8, "harvestInterval"    # J
    .param p10, "harvestUnit"    # Ljava/util/concurrent/TimeUnit;
    .param p11, "minDelta"    # J
    .param p13, "minDeltaUnit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/newrelic/agent/android/AgentInitializationException;
        }
    .end annotation

    .prologue
    .line 150
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    sget-object v0, Lcom/newrelic/agent/android/api/common/ConnectionState;->NULL:Lcom/newrelic/agent/android/api/common/ConnectionState;

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    .line 86
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    .line 88
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z

    .line 89
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectedCond:Ljava/util/concurrent/locks/Condition;

    .line 91
    new-instance v0, Lcom/newrelic/agent/android/util/AndroidEncoder;

    invoke-direct {v0}, Lcom/newrelic/agent/android/util/AndroidEncoder;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->encoder:Lcom/newrelic/agent/android/util/Encoder;

    .line 154
    invoke-static {p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->appContext(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    .line 156
    invoke-virtual {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isDisabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 157
    new-instance v0, Lcom/newrelic/agent/android/AgentInitializationException;

    const-string v1, "This version of the agent has been disabled"

    invoke-direct {v0, v1}, Lcom/newrelic/agent/android/AgentInitializationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 160
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    .line 161
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    .line 163
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-static {v0}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->fromContext(Landroid/content/Context;)Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;

    move-result-object v8

    .line 164
    .local v8, "appInfo":Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;
    invoke-virtual {v8}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->packageName:Ljava/lang/String;

    .line 165
    if-eqz p5, :cond_1

    invoke-virtual {v8}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    .line 166
    sget-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v1, "Location stats enabled"

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 167
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->addLocationListener()V

    .line 170
    :cond_1
    iput-object p2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->appToken:Ljava/lang/String;

    .line 171
    iput-object p6, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    move-object v0, p0

    move-wide/from16 v1, p8

    move-object/from16 v3, p10

    move-wide/from16 v4, p11

    move-object/from16 v6, p13

    move-object/from16 v7, p7

    .line 172
    invoke-direct/range {v0 .. v7}, Lcom/newrelic/agent/android/AndroidAgentImpl;->createHarvestHeartbeat(JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;Lcom/newrelic/agent/android/util/ConnectivitySampler;)Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .line 174
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->addApplicationStateListener(Lcom/newrelic/agent/android/background/ApplicationStateListener;)V

    .line 175
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    .locals 13
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "licenseKey"    # Ljava/lang/String;
    .param p3, "collectorAddr"    # Ljava/lang/String;
    .param p4, "ssl"    # Z
    .param p5, "locationEnabled"    # Z
    .param p6, "appName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/newrelic/agent/android/AgentInitializationException;
        }
    .end annotation

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    sget-object v1, Lcom/newrelic/agent/android/api/common/ConnectionState;->NULL:Lcom/newrelic/agent/android/api/common/ConnectionState;

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    .line 86
    new-instance v1, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v1}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    .line 88
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z

    .line 89
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v1

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectedCond:Ljava/util/concurrent/locks/Condition;

    .line 91
    new-instance v1, Lcom/newrelic/agent/android/util/AndroidEncoder;

    invoke-direct {v1}, Lcom/newrelic/agent/android/util/AndroidEncoder;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->encoder:Lcom/newrelic/agent/android/util/Encoder;

    .line 99
    invoke-static {p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->appContext(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    .line 101
    invoke-virtual {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isDisabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 102
    new-instance v1, Lcom/newrelic/agent/android/AgentInitializationException;

    const-string v2, "This version of the agent has been disabled"

    invoke-direct {v1, v2}, Lcom/newrelic/agent/android/AgentInitializationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 105
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    .line 106
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    .line 108
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->fromContext(Landroid/content/Context;)Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;

    move-result-object v9

    .line 109
    .local v9, "appInfo":Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;
    invoke-virtual {v9}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->packageName:Ljava/lang/String;

    .line 110
    if-eqz p5, :cond_1

    invoke-virtual {v9}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const-string v2, "android.permission.ACCESS_FINE_LOCATION"

    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 111
    sget-object v1, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v2, "Location stats enabled"

    invoke-interface {v1, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->debug(Ljava/lang/String;)V

    .line 112
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->addLocationListener()V

    .line 115
    :cond_1
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->sniffDeviceId()Ljava/lang/String;

    move-result-object v12

    .line 117
    .local v12, "deviceId":Ljava/lang/String;
    new-instance v10, Lcom/newrelic/agent/android/api/v1/Configuration;

    invoke-direct {v10}, Lcom/newrelic/agent/android/api/v1/Configuration;-><init>()V

    .line 118
    .local v10, "config":Lcom/newrelic/agent/android/api/v1/Configuration;
    if-nez p6, :cond_2

    invoke-virtual {v9}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getAppName()Ljava/lang/String;

    move-result-object p6

    .end local p6    # "appName":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, p6

    invoke-virtual {v10, v0}, Lcom/newrelic/agent/android/api/v1/Configuration;->setAppName(Ljava/lang/String;)V

    .line 119
    invoke-virtual {v9}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getAppVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/newrelic/agent/android/api/v1/Configuration;->setAppVersion(Ljava/lang/String;)V

    .line 120
    invoke-virtual {v9}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/newrelic/agent/android/api/v1/Configuration;->setPackageId(Ljava/lang/String;)V

    .line 121
    invoke-virtual {v10, p2}, Lcom/newrelic/agent/android/api/v1/Configuration;->setLicenseKey(Ljava/lang/String;)V

    .line 122
    invoke-virtual {v10, v12}, Lcom/newrelic/agent/android/api/v1/Configuration;->setDeviceId(Ljava/lang/String;)V

    .line 123
    invoke-static {p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->deviceForm(Landroid/content/Context;)Lcom/newrelic/agent/android/api/v1/DeviceForm;

    move-result-object v1

    invoke-virtual {v10, v1}, Lcom/newrelic/agent/android/api/v1/Configuration;->setDeviceForm(Lcom/newrelic/agent/android/api/v1/DeviceForm;)V

    .line 124
    move-object/from16 v0, p3

    invoke-virtual {v10, v0}, Lcom/newrelic/agent/android/api/v1/Configuration;->setCollectorHost(Ljava/lang/String;)V

    .line 125
    move/from16 v0, p4

    invoke-virtual {v10, v0}, Lcom/newrelic/agent/android/api/v1/Configuration;->setSslEnabled(Z)V

    .line 126
    sget-object v1, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v10, v1}, Lcom/newrelic/agent/android/api/v1/Configuration;->setDeviceManufacturer(Ljava/lang/String;)V

    .line 127
    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v10, v1}, Lcom/newrelic/agent/android/api/v1/Configuration;->setDeviceModel(Ljava/lang/String;)V

    .line 128
    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v10, v1}, Lcom/newrelic/agent/android/api/v1/Configuration;->setAndroidRelease(Ljava/lang/String;)V

    .line 130
    invoke-virtual {v10}, Lcom/newrelic/agent/android/api/v1/Configuration;->validate()Z

    move-result v1

    if-nez v1, :cond_3

    .line 132
    new-instance v1, Lcom/newrelic/agent/android/AgentInitializationException;

    const-string v2, "Failed to validate agent configuration"

    invoke-direct {v1, v2}, Lcom/newrelic/agent/android/AgentInitializationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 135
    :cond_3
    iput-object p2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->appToken:Ljava/lang/String;

    .line 137
    new-instance v11, Lcom/newrelic/agent/android/api/v1/DefaultNewRelicApi;

    invoke-direct {v11, v10}, Lcom/newrelic/agent/android/api/v1/DefaultNewRelicApi;-><init>(Lcom/newrelic/agent/android/api/v1/Configuration;)V

    .line 138
    .local v11, "defaultNewRelicApi":Lcom/newrelic/agent/android/api/v1/DefaultNewRelicApi;
    invoke-virtual {v11, p0}, Lcom/newrelic/agent/android/api/v1/DefaultNewRelicApi;->addConnectionListener(Lcom/newrelic/agent/android/api/v1/ConnectionListener;)V

    .line 140
    iput-object v11, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    .line 141
    const-wide/16 v2, 0x3c

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v5, 0x32

    sget-object v7, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v8, Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;

    invoke-direct {v8, p1}, Lcom/newrelic/agent/android/util/AndroidConnectivitySampler;-><init>(Landroid/content/Context;)V

    move-object v1, p0

    invoke-direct/range {v1 .. v8}, Lcom/newrelic/agent/android/AndroidAgentImpl;->createHarvestHeartbeat(JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;Lcom/newrelic/agent/android/util/ConnectivitySampler;)Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    move-result-object v1

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    .line 143
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->addApplicationStateListener(Lcom/newrelic/agent/android/background/ApplicationStateListener;)V

    .line 144
    return-void
.end method

.method static synthetic access$000(Lcom/newrelic/agent/android/AndroidAgentImpl;Landroid/location/Location;)Z
    .locals 1
    .param p0, "x0"    # Lcom/newrelic/agent/android/AndroidAgentImpl;
    .param p1, "x1"    # Landroid/location/Location;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isAccurate(Landroid/location/Location;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/newrelic/agent/android/AndroidAgentImpl;)V
    .locals 0
    .param p0, "x0"    # Lcom/newrelic/agent/android/AndroidAgentImpl;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->removeLocationListener()V

    return-void
.end method

.method static synthetic access$200()Lcom/newrelic/agent/android/logging/AgentLog;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    return-object v0
.end method

.method private addLocationListener()V
    .locals 6

    .prologue
    .line 732
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    const-string v2, "location"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 733
    .local v0, "locationManager":Landroid/location/LocationManager;
    if-nez v0, :cond_0

    .line 734
    sget-object v1, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v2, "Unable to retrieve reference to LocationManager. Disabling location listener."

    invoke-interface {v1, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    .line 764
    :goto_0
    return-void

    .line 738
    :cond_0
    new-instance v1, Lcom/newrelic/agent/android/AndroidAgentImpl$2;

    invoke-direct {v1, p0}, Lcom/newrelic/agent/android/AndroidAgentImpl$2;-><init>(Lcom/newrelic/agent/android/AndroidAgentImpl;)V

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->locationListener:Landroid/location/LocationListener;

    .line 763
    const-string v1, "passive"

    const-wide/16 v2, 0x3e8

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->locationListener:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    goto :goto_0
.end method

.method private static appContext(Landroid/content/Context;)Landroid/content/Context;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 212
    instance-of v0, p0, Landroid/app/Application;

    if-nez v0, :cond_0

    .line 213
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p0

    .line 216
    .end local p0    # "context":Landroid/content/Context;
    :cond_0
    return-object p0
.end method

.method static clearPreferences(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 430
    sget-object v2, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Clearing shared preferences in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getPreferenceFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 431
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getPreferenceFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 432
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 433
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 434
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 435
    return-void
.end method

.method private constrainTransactions(J)V
    .locals 4
    .param p1, "maxTransactionCount"    # J

    .prologue
    .line 638
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    int-to-long v0, v0

    cmp-long v0, v0, p1

    if-lez v0, :cond_0

    .line 639
    sget-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Transaction count limit ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") exceeded! Purging "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-long v2, v2

    sub-long/2addr v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " oldest transactions"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 641
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->get()Lcom/newrelic/agent/android/stats/StatsEngine;

    move-result-object v0

    const-string v1, "Supportability/MobileAgent/TransactionsDropped"

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-long v2, v2

    sub-long/2addr v2, p1

    invoke-virtual {v0, v1, v2, v3}, Lcom/newrelic/agent/android/stats/StatsEngine;->inc(Ljava/lang/String;J)V

    .line 643
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    sget-object v1, Lcom/newrelic/agent/android/AndroidAgentImpl;->cmp:Ljava/util/Comparator;

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 644
    :goto_0
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    int-to-long v0, v0

    cmp-long v0, v0, p1

    if-lez v0, :cond_0

    .line 648
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 651
    :cond_0
    return-void
.end method

.method private createHarvestHeartbeat(JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;Lcom/newrelic/agent/android/util/ConnectivitySampler;)Lcom/newrelic/agent/android/background/HarvestHeartbeat;
    .locals 10
    .param p1, "harvestInterval"    # J
    .param p3, "harvestUnit"    # Ljava/util/concurrent/TimeUnit;
    .param p4, "minDelta"    # J
    .param p6, "minDeltaUnit"    # Ljava/util/concurrent/TimeUnit;
    .param p7, "connectivitySampler"    # Lcom/newrelic/agent/android/util/ConnectivitySampler;

    .prologue
    .line 178
    new-instance v0, Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    new-instance v2, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;

    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-direct {v2, v3}, Lcom/newrelic/agent/android/util/AndroidMachineMeasurementsSampler;-><init>(Landroid/content/Context;)V

    move-object/from16 v3, p7

    move-wide v4, p1

    move-object v6, p3

    move-wide v7, p4

    move-object/from16 v9, p6

    invoke-direct/range {v0 .. v9}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;-><init>(Lcom/newrelic/agent/android/api/v1/NewRelicApi;Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;Lcom/newrelic/agent/android/util/ConnectivitySampler;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V

    return-object v0
.end method

.method private static deviceForm(Landroid/content/Context;)Lcom/newrelic/agent/android/api/v1/DeviceForm;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 182
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v1, v1, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v0, v1, 0xf

    .line 183
    .local v0, "deviceSize":I
    packed-switch v0, :pswitch_data_0

    .line 201
    const/4 v1, 0x3

    if-le v0, v1, :cond_0

    .line 202
    sget-object v1, Lcom/newrelic/agent/android/api/v1/DeviceForm;->XLARGE:Lcom/newrelic/agent/android/api/v1/DeviceForm;

    .line 205
    :goto_0
    return-object v1

    .line 186
    :pswitch_0
    sget-object v1, Lcom/newrelic/agent/android/api/v1/DeviceForm;->SMALL:Lcom/newrelic/agent/android/api/v1/DeviceForm;

    goto :goto_0

    .line 190
    :pswitch_1
    sget-object v1, Lcom/newrelic/agent/android/api/v1/DeviceForm;->NORMAL:Lcom/newrelic/agent/android/api/v1/DeviceForm;

    goto :goto_0

    .line 194
    :pswitch_2
    sget-object v1, Lcom/newrelic/agent/android/api/v1/DeviceForm;->LARGE:Lcom/newrelic/agent/android/api/v1/DeviceForm;

    goto :goto_0

    .line 205
    :cond_0
    sget-object v1, Lcom/newrelic/agent/android/api/v1/DeviceForm;->UNKNOWN:Lcom/newrelic/agent/android/api/v1/DeviceForm;

    goto :goto_0

    .line 183
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private getMaxTransactionAgeInSeconds()J
    .locals 3

    .prologue
    .line 625
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 627
    :try_start_0
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v0}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getMaxTransactionAgeInSeconds()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v0

    .line 630
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-wide v0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method static getPreferenceFileName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 710
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "com.newrelic.android.agent.v1_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSharedPreferences()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 706
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getPreferenceFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public static init(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "licenseKey"    # Ljava/lang/String;
    .param p2, "collectorAddr"    # Ljava/lang/String;
    .param p3, "ssl"    # Z
    .param p4, "location"    # Z

    .prologue
    .line 462
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Lcom/newrelic/agent/android/AndroidAgentImpl;->init(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V

    .line 463
    return-void
.end method

.method public static init(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "licenseKey"    # Ljava/lang/String;
    .param p2, "collectorAddr"    # Ljava/lang/String;
    .param p3, "ssl"    # Z
    .param p4, "location"    # Z
    .param p5, "appName"    # Ljava/lang/String;

    .prologue
    .line 452
    :try_start_0
    new-instance v0, Lcom/newrelic/agent/android/AndroidAgentImpl;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/newrelic/agent/android/AndroidAgentImpl;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V

    invoke-static {v0}, Lcom/newrelic/agent/android/Agent;->setImpl(Lcom/newrelic/agent/android/AgentImpl;)V

    .line 453
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->start()V
    :try_end_0
    .catch Lcom/newrelic/agent/android/AgentInitializationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 459
    :goto_0
    return-void

    .line 455
    :catch_0
    move-exception v7

    .line 456
    .local v7, "e":Lcom/newrelic/agent/android/AgentInitializationException;
    sget-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to initialize the agent: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v7}, Lcom/newrelic/agent/android/AgentInitializationException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private isAccurate(Landroid/location/Location;)Z
    .locals 3
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    const/4 v0, 0x0

    .line 791
    if-nez p1, :cond_1

    .line 794
    :cond_0
    :goto_0
    return v0

    :cond_1
    const/high16 v1, 0x43fa0000    # 500.0f

    invoke-virtual {p1}, Landroid/location/Location;->getAccuracy()F

    move-result v2

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isAndroidIdBuggy()Z
    .locals 3

    .prologue
    .line 848
    const-string v0, "9774d56d682e549c"

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "android_id"

    invoke-static {v1, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isConnected()Z
    .locals 2

    .prologue
    .line 852
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 854
    :try_start_0
    iget-boolean v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 857
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method private isErrorListFull(J)Z
    .locals 2
    .param p1, "maxErrorCount"    # J

    .prologue
    .line 654
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    int-to-long v0, v0

    cmp-long v0, v0, p1

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isStaleTransaction(Lcom/newrelic/agent/android/api/common/TransactionData;)Z
    .locals 6
    .param p1, "transactionData"    # Lcom/newrelic/agent/android/api/common/TransactionData;

    .prologue
    .line 714
    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getMaxTransactionAgeInSeconds()J

    move-result-wide v3

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v2, v3, v4, v5}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    .line 715
    .local v0, "maxTransactionAge":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/newrelic/agent/android/api/common/TransactionData;->getTimestamp()J

    move-result-wide v4

    sub-long/2addr v2, v4

    cmp-long v2, v2, v0

    if-lez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private isTransactionListFull(J)Z
    .locals 4
    .param p1, "maxTransactionCount"    # J

    .prologue
    .line 530
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    monitor-enter v1

    .line 531
    :try_start_0
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    int-to-long v2, v0

    cmp-long v0, v2, p1

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 532
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private loadConnectionState(Lcom/newrelic/agent/android/api/v1/NewRelicApi;)Z
    .locals 11
    .param p1, "api"    # Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    .prologue
    const/4 v10, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 663
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    .line 665
    .local v3, "prefs":Landroid/content/SharedPreferences;
    sget-object v6, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v7, "New Relic Agent v{0}"

    new-array v8, v5, [Ljava/lang/Object;

    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getVersion()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v4

    invoke-static {v7, v8}, Ljava/text/MessageFormat;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 667
    const-string v6, "agentVersion"

    invoke-interface {v3, v6, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 668
    .local v2, "lastRunVersion":Ljava/lang/String;
    iget-object v6, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    invoke-interface {v6}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->getDeviceInfo()Lcom/newrelic/agent/android/api/v1/DeviceInfo;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 672
    if-eqz v2, :cond_0

    .line 673
    sget-object v5, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v6, "New agent version detected! We\'ll need to reconnect."

    invoke-interface {v5, v6}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 675
    :cond_0
    new-instance v5, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;

    invoke-direct {v5, p0}, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p0, v5}, Lcom/newrelic/agent/android/AndroidAgentImpl;->disconnected(Lcom/newrelic/agent/android/api/v1/ConnectionEvent;)V

    .line 701
    :goto_0
    return v4

    .line 679
    :cond_1
    const-string v6, "appToken"

    invoke-interface {v3, v6, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 680
    .local v1, "lastAppToken":Ljava/lang/String;
    iget-object v6, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->appToken:Ljava/lang/String;

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 683
    sget-object v5, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v6, "App token has changed!  We\'ll need to reconnect."

    invoke-interface {v5, v6}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 684
    new-instance v5, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;

    invoke-direct {v5, p0}, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p0, v5}, Lcom/newrelic/agent/android/AndroidAgentImpl;->disconnected(Lcom/newrelic/agent/android/api/v1/ConnectionEvent;)V

    goto :goto_0

    .line 688
    :cond_2
    invoke-static {v3}, Lcom/newrelic/agent/android/util/ConnectionStateUtil;->fromSharedPreferences(Landroid/content/SharedPreferences;)Lcom/newrelic/agent/android/api/common/ConnectionState;

    move-result-object v0

    .line 689
    .local v0, "connectionState":Lcom/newrelic/agent/android/api/common/ConnectionState;
    invoke-static {v0}, Lcom/newrelic/agent/android/util/ConnectionStateUtil;->isValid(Lcom/newrelic/agent/android/api/common/ConnectionState;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 690
    invoke-interface {p1, v0}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->setConnectionState(Lcom/newrelic/agent/android/api/common/ConnectionState;)V

    .line 695
    invoke-virtual {p0, v0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->setConnectionState(Lcom/newrelic/agent/android/api/common/ConnectionState;)V

    move v4, v5

    .line 696
    goto :goto_0

    .line 699
    :cond_3
    sget-object v5, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Invalid connection state in shared preferences: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 700
    new-instance v5, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;

    invoke-direct {v5, p0}, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p0, v5}, Lcom/newrelic/agent/android/AndroidAgentImpl;->disconnected(Lcom/newrelic/agent/android/api/v1/ConnectionEvent;)V

    goto :goto_0
.end method

.method private purgeStaleTransactions(Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 719
    .local p1, "transactionDataList":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getMaxTransactionAgeInSeconds()J

    move-result-wide v1

    .line 720
    .local v1, "maxTransactionAgeInSeconds":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 721
    .local v3, "now":J
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 722
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 723
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/newrelic/agent/android/api/common/TransactionData;

    .line 724
    .local v5, "transactionData":Lcom/newrelic/agent/android/api/common/TransactionData;
    invoke-virtual {v5}, Lcom/newrelic/agent/android/api/common/TransactionData;->getTimestamp()J

    move-result-wide v6

    sub-long v6, v3, v6

    sget-object v8, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    sget-object v9, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v8, v1, v2, v9}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-lez v6, :cond_0

    .line 725
    sget-object v6, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v7, "Purging expired transaction"

    invoke-interface {v6, v7}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 726
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 729
    .end local v5    # "transactionData":Lcom/newrelic/agent/android/api/common/TransactionData;
    :cond_1
    return-void
.end method

.method private removeLocationListener()V
    .locals 3

    .prologue
    .line 767
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->locationListener:Landroid/location/LocationListener;

    if-nez v1, :cond_0

    .line 782
    :goto_0
    return-void

    .line 772
    :cond_0
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    const-string v2, "location"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 773
    .local v0, "locationManager":Landroid/location/LocationManager;
    if-nez v0, :cond_1

    .line 774
    sget-object v1, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v2, "Unable to retrieve reference to LocationManager. Can\'t unregister location listener."

    invoke-interface {v1, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 778
    :cond_1
    monitor-enter v0

    .line 779
    :try_start_0
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->locationListener:Landroid/location/LocationListener;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 780
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->locationListener:Landroid/location/LocationListener;

    .line 781
    monitor-exit v0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private sniffDeviceId()Ljava/lang/String;
    .locals 5

    .prologue
    .line 804
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isAndroidIdBuggy()Z

    move-result v3

    if-nez v3, :cond_1

    .line 805
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "android_id"

    invoke-static {v3, v4}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 816
    .local v0, "deviceId":Ljava/lang/String;
    :goto_0
    if-nez v0, :cond_0

    .line 817
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 818
    .local v2, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 819
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 820
    const-string v3, "androidIdBugWorkAround"

    invoke-interface {v1, v3, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 821
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 824
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v2    # "prefs":Landroid/content/SharedPreferences;
    :cond_0
    return-object v0

    .line 808
    .end local v0    # "deviceId":Ljava/lang/String;
    :cond_1
    sget-object v3, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v4, "The ANDROID_ID associated with this device indicates an emulator (or an old & buggy physical device). Generating a random UUID."

    invoke-interface {v3, v4}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 809
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 810
    .restart local v2    # "prefs":Landroid/content/SharedPreferences;
    const-string v3, "androidIdBugWorkAround"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "deviceId":Ljava/lang/String;
    goto :goto_0
.end method

.method private stop(Z)V
    .locals 1
    .param p1, "finalSendData"    # Z

    .prologue
    .line 398
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    invoke-virtual {v0, p1}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->stop(Z)V

    .line 399
    return-void
.end method


# virtual methods
.method public addErrorData(Lcom/newrelic/agent/android/api/common/ErrorData;)V
    .locals 8
    .param p1, "errorData"    # Lcom/newrelic/agent/android/api/common/ErrorData;

    .prologue
    .line 277
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 279
    :try_start_0
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v4}, Lcom/newrelic/agent/android/api/common/ConnectionState;->isCollectingNetworkErrors()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result v4

    if-nez v4, :cond_0

    .line 286
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 304
    :goto_0
    return-void

    .line 283
    :cond_0
    :try_start_1
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v4}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getErrorLimit()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v4

    int-to-long v2, v4

    .line 286
    .local v2, "maxErrorCount":J
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 289
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    monitor-enter v5

    .line 290
    :try_start_2
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/newrelic/agent/android/api/common/ErrorData;

    .line 291
    .local v0, "error":Lcom/newrelic/agent/android/api/common/ErrorData;
    invoke-virtual {p1}, Lcom/newrelic/agent/android/api/common/ErrorData;->getHash()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/newrelic/agent/android/api/common/ErrorData;->getHash()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 292
    invoke-virtual {v0}, Lcom/newrelic/agent/android/api/common/ErrorData;->incrementCount()V

    .line 293
    monitor-exit v5

    goto :goto_0

    .line 303
    .end local v0    # "error":Lcom/newrelic/agent/android/api/common/ErrorData;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v4

    .line 286
    .end local v2    # "maxErrorCount":J
    :catchall_1
    move-exception v4

    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v4

    .line 296
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "maxErrorCount":J
    :cond_2
    :try_start_3
    invoke-direct {p0, v2, v3}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isErrorListFull(J)Z

    move-result v4

    if-nez v4, :cond_3

    .line 297
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 303
    :goto_1
    monitor-exit v5

    goto :goto_0

    .line 300
    :cond_3
    sget-object v4, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Error limit ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ") exceeded for this harvest! Skipping new error."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 301
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->get()Lcom/newrelic/agent/android/stats/StatsEngine;

    move-result-object v4

    const-string v6, "Supportability/MobileAgent/ErrorsDropped"

    invoke-virtual {v4, v6}, Lcom/newrelic/agent/android/stats/StatsEngine;->inc(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method public addTransactionData(Lcom/newrelic/agent/android/api/common/TransactionData;)V
    .locals 5
    .param p1, "transactionData"    # Lcom/newrelic/agent/android/api/common/TransactionData;

    .prologue
    .line 222
    if-eqz p1, :cond_0

    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isStaleTransaction(Lcom/newrelic/agent/android/api/common/TransactionData;)Z

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isConnected()Z

    move-result v3

    if-nez v3, :cond_2

    .line 242
    :cond_1
    :goto_0
    return-void

    .line 227
    :cond_2
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 229
    :try_start_0
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v3}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getMaxTransactionCount()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-wide v0

    .line 232
    .local v0, "maxTransactionCount":J
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 235
    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    monitor-enter v4

    .line 236
    :try_start_1
    invoke-direct {p0, v0, v1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isTransactionListFull(J)Z

    move-result v2

    .line 237
    .local v2, "needConstraint":Z
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 238
    if-eqz v2, :cond_3

    .line 239
    invoke-direct {p0, v0, v1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->constrainTransactions(J)V

    .line 241
    :cond_3
    monitor-exit v4

    goto :goto_0

    .end local v2    # "needConstraint":Z
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3

    .line 232
    .end local v0    # "maxTransactionCount":J
    :catchall_1
    move-exception v3

    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v3
.end method

.method public applicationBackgrounded(Lcom/newrelic/agent/android/background/ApplicationStateEvent;)V
    .locals 0
    .param p1, "e"    # Lcom/newrelic/agent/android/background/ApplicationStateEvent;

    .prologue
    .line 526
    invoke-virtual {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->stop()V

    .line 527
    return-void
.end method

.method public applicationForegrounded(Lcom/newrelic/agent/android/background/ApplicationStateEvent;)V
    .locals 0
    .param p1, "e"    # Lcom/newrelic/agent/android/background/ApplicationStateEvent;

    .prologue
    .line 521
    invoke-virtual {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->start()V

    .line 522
    return-void
.end method

.method public connected(Lcom/newrelic/agent/android/api/v1/ConnectionEvent;)V
    .locals 4
    .param p1, "e"    # Lcom/newrelic/agent/android/api/v1/ConnectionEvent;

    .prologue
    .line 471
    sget-object v2, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v3, "New connection detected: updating shared preferences"

    invoke-interface {v2, v3}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 473
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 474
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-virtual {p1}, Lcom/newrelic/agent/android/api/v1/ConnectionEvent;->getConnectionState()Lcom/newrelic/agent/android/api/common/ConnectionState;

    move-result-object v0

    .line 475
    .local v0, "connectionState":Lcom/newrelic/agent/android/api/common/ConnectionState;
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    invoke-interface {v2}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->getDeviceInfo()Lcom/newrelic/agent/android/api/v1/DeviceInfo;

    move-result-object v2

    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->appToken:Ljava/lang/String;

    invoke-static {v1, v0, v2, v3}, Lcom/newrelic/agent/android/util/ConnectionStateUtil;->saveSharedPreferences(Landroid/content/SharedPreferences;Lcom/newrelic/agent/android/api/common/ConnectionState;Lcom/newrelic/agent/android/api/v1/DeviceInfo;Ljava/lang/String;)V

    .line 477
    invoke-virtual {p0, v0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->setConnectionState(Lcom/newrelic/agent/android/api/common/ConnectionState;)V

    .line 478
    return-void
.end method

.method public disable()V
    .locals 5

    .prologue
    .line 407
    sget-object v2, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "PERMANENTLY DISABLING AGENT v"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 409
    :try_start_0
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getPreferenceFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 410
    .local v1, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 411
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "NewRelicAgentDisabledVersion"

    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getVersion()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 412
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 416
    const/4 v2, 0x0

    :try_start_1
    invoke-direct {p0, v2}, Lcom/newrelic/agent/android/AndroidAgentImpl;->stop(Z)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 419
    sget-object v2, Lcom/newrelic/agent/android/NullAgentImpl;->instance:Lcom/newrelic/agent/android/NullAgentImpl;

    invoke-static {v2}, Lcom/newrelic/agent/android/Agent;->setImpl(Lcom/newrelic/agent/android/AgentImpl;)V

    .line 422
    return-void

    .line 419
    :catchall_0
    move-exception v2

    sget-object v3, Lcom/newrelic/agent/android/NullAgentImpl;->instance:Lcom/newrelic/agent/android/NullAgentImpl;

    invoke-static {v3}, Lcom/newrelic/agent/android/Agent;->setImpl(Lcom/newrelic/agent/android/AgentImpl;)V

    throw v2

    .line 415
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "prefs":Landroid/content/SharedPreferences;
    :catchall_1
    move-exception v2

    .line 416
    const/4 v3, 0x0

    :try_start_2
    invoke-direct {p0, v3}, Lcom/newrelic/agent/android/AndroidAgentImpl;->stop(Z)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 419
    sget-object v3, Lcom/newrelic/agent/android/NullAgentImpl;->instance:Lcom/newrelic/agent/android/NullAgentImpl;

    invoke-static {v3}, Lcom/newrelic/agent/android/Agent;->setImpl(Lcom/newrelic/agent/android/AgentImpl;)V

    throw v2

    :catchall_2
    move-exception v2

    sget-object v3, Lcom/newrelic/agent/android/NullAgentImpl;->instance:Lcom/newrelic/agent/android/NullAgentImpl;

    invoke-static {v3}, Lcom/newrelic/agent/android/Agent;->setImpl(Lcom/newrelic/agent/android/AgentImpl;)V

    throw v2
.end method

.method public disconnected(Lcom/newrelic/agent/android/api/v1/ConnectionEvent;)V
    .locals 3
    .param p1, "e"    # Lcom/newrelic/agent/android/api/v1/ConnectionEvent;

    .prologue
    .line 486
    sget-object v1, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v2, "Detected disconnect: clearing shared preferences"

    invoke-interface {v1, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->verbose(Ljava/lang/String;)V

    .line 493
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 494
    .local v0, "prefs":Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/newrelic/agent/android/util/ConnectionStateUtil;->clearSharedPreferences(Landroid/content/SharedPreferences;)V

    .line 496
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 498
    :try_start_0
    sget-object v1, Lcom/newrelic/agent/android/api/common/ConnectionState;->NULL:Lcom/newrelic/agent/android/api/common/ConnectionState;

    iput-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    .line 503
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 504
    :try_start_1
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 505
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 507
    :try_start_2
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    monitor-enter v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 508
    :try_start_3
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 509
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 511
    const/4 v1, 0x0

    :try_start_4
    iput-boolean v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z

    .line 512
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectedCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 515
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 517
    return-void

    .line 505
    :catchall_0
    move-exception v1

    :try_start_5
    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 515
    :catchall_1
    move-exception v1

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1

    .line 509
    :catchall_2
    move-exception v1

    :try_start_7
    monitor-exit v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    :try_start_8
    throw v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1
.end method

.method dispose()V
    .locals 1

    .prologue
    .line 402
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->dispose()V

    .line 403
    return-void
.end method

.method public getAndClearErrorData()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/api/common/ErrorData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 308
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    monitor-enter v2

    .line 309
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 310
    .local v0, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 311
    monitor-exit v2

    return-object v0

    .line 312
    .end local v0    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getAndClearTransactionData()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 267
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    monitor-enter v2

    .line 268
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 269
    .local v0, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 270
    monitor-exit v2

    return-object v0

    .line 271
    .end local v0    # "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getCrossProcessId()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 343
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 345
    :try_start_0
    const-string v3, ""

    iget-object v4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v4}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getCrossProcessId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    move-object v1, v2

    .line 346
    .local v1, "crossProcessId":Ljava/lang/String;
    :goto_0
    iget-boolean v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 347
    .local v0, "connected":Z
    if-eqz v0, :cond_1

    .line 350
    .end local v1    # "crossProcessId":Ljava/lang/String;
    :goto_1
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object v1

    .line 345
    .end local v0    # "connected":Z
    :cond_0
    :try_start_1
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v3}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getCrossProcessId()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    goto :goto_0

    .restart local v0    # "connected":Z
    .restart local v1    # "crossProcessId":Ljava/lang/String;
    :cond_1
    move-object v1, v2

    .line 347
    goto :goto_1

    .line 350
    .end local v0    # "connected":Z
    .end local v1    # "crossProcessId":Ljava/lang/String;
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2
.end method

.method public getEncoder()Lcom/newrelic/agent/android/util/Encoder;
    .locals 1

    .prologue
    .line 971
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->encoder:Lcom/newrelic/agent/android/util/Encoder;

    return-object v0
.end method

.method public getNetworkCarrier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-static {v0}, Lcom/newrelic/agent/android/util/Carrier;->nameFromContext(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getResponseBodyLimit()I
    .locals 3

    .prologue
    .line 368
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 370
    :try_start_0
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v1}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getResponseBodyLimit()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 374
    .local v0, "responseBodyLimit":I
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v0

    .end local v0    # "responseBodyLimit":I
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method public getStackTraceLimit()I
    .locals 3

    .prologue
    .line 356
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 358
    :try_start_0
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v1}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getStackTraceLimit()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 362
    .local v0, "stackTraceLimit":I
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v0

    .end local v0    # "stackTraceLimit":I
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method public isDisabled()Z
    .locals 4

    .prologue
    .line 425
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/AndroidAgentImpl;->getPreferenceFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 426
    .local v0, "prefs":Landroid/content/SharedPreferences;
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getVersion()Ljava/lang/String;

    move-result-object v1

    const-string v2, "NewRelicAgentDisabledVersion"

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method

.method public mergeErrorData(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/api/common/ErrorData;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 318
    .local p1, "errorDataList":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 320
    :try_start_0
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v5}, Lcom/newrelic/agent/android/api/common/ConnectionState;->isCollectingNetworkErrors()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    if-nez v5, :cond_0

    .line 327
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 339
    :goto_0
    return-void

    .line 324
    :cond_0
    :try_start_1
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v5}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getErrorLimit()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v5

    int-to-long v2, v5

    .line 327
    .local v2, "maxErrorCount":J
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 330
    iget-object v6, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    monitor-enter v6

    .line 331
    long-to-int v5, v2

    :try_start_2
    iget-object v7, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    sub-int v4, v5, v7

    .line 332
    .local v4, "slots":I
    if-lez v4, :cond_1

    .line 333
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 334
    .local v1, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 335
    iget-object v5, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->errorDataList:Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 334
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 327
    .end local v0    # "i":I
    .end local v1    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .end local v2    # "maxErrorCount":J
    .end local v4    # "slots":I
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v6}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v5

    .line 338
    .restart local v2    # "maxErrorCount":J
    .restart local v4    # "slots":I
    :cond_1
    :try_start_3
    monitor-exit v6

    goto :goto_0

    .end local v4    # "slots":I
    :catchall_1
    move-exception v5

    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v5
.end method

.method public mergeTransactionData(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 246
    .local p1, "transactionDataList":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isConnected()Z

    move-result v2

    if-nez v2, :cond_1

    .line 263
    :cond_0
    :goto_0
    return-void

    .line 250
    :cond_1
    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->purgeStaleTransactions(Ljava/util/List;)V

    .line 252
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 254
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 255
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;

    invoke-virtual {v2}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getMaxTransactionCount()J

    move-result-wide v0

    .line 256
    .local v0, "maxTransactionCount":J
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 258
    iget-object v3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    monitor-enter v3

    .line 259
    :try_start_0
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->transactionDataList:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 260
    invoke-direct {p0, v0, v1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->constrainTransactions(J)V

    .line 261
    monitor-exit v3

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method setConnectionState(Lcom/newrelic/agent/android/api/common/ConnectionState;)V
    .locals 4
    .param p1, "connectionState"    # Lcom/newrelic/agent/android/api/common/ConnectionState;

    .prologue
    .line 862
    invoke-static {p1}, Lcom/newrelic/agent/android/util/ConnectionStateUtil;->isValid(Lcom/newrelic/agent/android/api/common/ConnectionState;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 863
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 865
    :try_start_0
    iput-object p1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectionState:Lcom/newrelic/agent/android/api/common/ConnectionState;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 868
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 871
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    invoke-virtual {p1}, Lcom/newrelic/agent/android/api/common/ConnectionState;->getHarvestIntervalInMilliseconds()J

    move-result-wide v1

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->setInterval(JLjava/util/concurrent/TimeUnit;)V

    .line 873
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 875
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z

    .line 876
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectedCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 879
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 893
    :goto_0
    return-void

    .line 868
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    .line 879
    :catchall_1
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    .line 883
    :cond_0
    sget-object v0, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid connection state detected: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/newrelic/agent/android/api/common/ConnectionState;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 884
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 886
    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z

    .line 887
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectedCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 890
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :catchall_2
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public setLocation(Landroid/location/Location;)V
    .locals 11
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 574
    if-nez p1, :cond_0

    .line 575
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Location must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 578
    :cond_0
    new-instance v0, Landroid/location/Geocoder;

    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->context:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;)V

    .line 579
    .local v0, "coder":Landroid/location/Geocoder;
    const/4 v7, 0x0

    .line 581
    .local v7, "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    :try_start_0
    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v1

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v3

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 586
    :goto_0
    if-eqz v7, :cond_1

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_2

    .line 604
    :cond_1
    :goto_1
    return-void

    .line 582
    :catch_0
    move-exception v10

    .line 583
    .local v10, "e":Ljava/io/IOException;
    sget-object v1, Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unable to geocode location: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v10}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 591
    .end local v10    # "e":Ljava/io/IOException;
    :cond_2
    const/4 v1, 0x0

    invoke-interface {v7, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/location/Address;

    .line 592
    .local v6, "address":Landroid/location/Address;
    if-eqz v6, :cond_1

    .line 597
    invoke-virtual {v6}, Landroid/location/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v9

    .line 598
    .local v9, "countryCode":Ljava/lang/String;
    invoke-virtual {v6}, Landroid/location/Address;->getAdminArea()Ljava/lang/String;

    move-result-object v8

    .line 600
    .local v8, "adminArea":Ljava/lang/String;
    if-eqz v9, :cond_1

    if-eqz v8, :cond_1

    .line 601
    invoke-virtual {p0, v9, v8}, Lcom/newrelic/agent/android/AndroidAgentImpl;->setLocation(Ljava/lang/String;Ljava/lang/String;)V

    .line 602
    invoke-direct {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->removeLocationListener()V

    goto :goto_1
.end method

.method public setLocation(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "countryCode"    # Ljava/lang/String;
    .param p2, "adminRegion"    # Ljava/lang/String;

    .prologue
    .line 537
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 538
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Country code and administrative region are required."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 540
    :cond_1
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    new-instance v1, Lcom/newrelic/agent/android/instrumentation/Location;

    invoke-direct {v1, p1, p2}, Lcom/newrelic/agent/android/instrumentation/Location;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->setLocation(Lcom/newrelic/agent/android/instrumentation/Location;)V

    .line 541
    return-void
.end method

.method public start()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 380
    invoke-virtual {p0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->isDisabled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 381
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    invoke-interface {v1}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->reset()V

    .line 382
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->api:Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    invoke-direct {p0, v2}, Lcom/newrelic/agent/android/AndroidAgentImpl;->loadConnectionState(Lcom/newrelic/agent/android/api/v1/NewRelicApi;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v0, 0x1

    :cond_0
    invoke-virtual {v1, v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->start(Z)V

    .line 390
    :goto_0
    return-void

    .line 388
    :cond_1
    invoke-direct {p0, v0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->stop(Z)V

    goto :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 394
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->stop(Z)V

    .line 395
    return-void
.end method

.method public waitForConnect(JLjava/util/concurrent/TimeUnit;)Z
    .locals 5
    .param p1, "time"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 544
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 546
    :try_start_0
    new-instance v0, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, p1, p2, p3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v3

    add-long/2addr v1, v3

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    .line 547
    .local v0, "end":Ljava/util/Date;
    :cond_0
    iget-boolean v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connected:Z

    if-nez v1, :cond_1

    .line 548
    iget-object v1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->connectedCond:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v1, v0}, Ljava/util/concurrent/locks/Condition;->awaitUntil(Ljava/util/Date;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 549
    const/4 v1, 0x0

    .line 555
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_0
    return v1

    .line 552
    :cond_1
    const/4 v1, 0x1

    .line 555
    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    .end local v0    # "end":Ljava/util/Date;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->lock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method public waitForHarvest(JLjava/util/concurrent/TimeUnit;)Z
    .locals 1
    .param p1, "time"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 560
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    invoke-virtual {v0, p1, p2, p3}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->waitForHarvest(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    return v0
.end method

.method public waitForStop(JLjava/util/concurrent/TimeUnit;)Z
    .locals 1
    .param p1, "time"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 564
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl;->heartbeat:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    invoke-virtual {v0, p1, p2, p3}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->waitForStop(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    return v0
.end method
