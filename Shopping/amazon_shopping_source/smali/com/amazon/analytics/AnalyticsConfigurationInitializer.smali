.class public Lcom/amazon/analytics/AnalyticsConfigurationInitializer;
.super Ljava/lang/Object;
.source "AnalyticsConfigurationInitializer.java"


# static fields
.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final activityManager:Lcom/amazon/analytics/TailwindActivityManager;

.field private final config:Lcom/amazon/analytics/AnalyticsConfiguration;

.field private final context:Landroid/content/Context;

.field private initialized:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final queue:Lcom/amazon/analytics/session/PriorityQueue;

.field private final service:Ljava/util/concurrent/ScheduledExecutorService;

.field private final sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/AnalyticsConfiguration;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;Ljava/util/concurrent/ScheduledExecutorService;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activityManager"    # Lcom/amazon/analytics/TailwindActivityManager;
    .param p3, "config"    # Lcom/amazon/analytics/AnalyticsConfiguration;
    .param p4, "queue"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p5, "sessionBuilder"    # Lcom/amazon/analytics/session/PackageSessionBuilder;
    .param p6, "service"    # Ljava/util/concurrent/ScheduledExecutorService;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->initialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 40
    iput-object p1, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->context:Landroid/content/Context;

    .line 41
    iput-object p2, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->activityManager:Lcom/amazon/analytics/TailwindActivityManager;

    .line 42
    iput-object p3, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    .line 43
    iput-object p4, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    .line 44
    iput-object p5, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;

    .line 45
    iput-object p6, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->service:Ljava/util/concurrent/ScheduledExecutorService;

    .line 46
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/analytics/AnalyticsConfigurationInitializer;)Lcom/amazon/analytics/AnalyticsConfiguration;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    return-object v0
.end method

.method static synthetic access$100()Lcom/amazon/device/analytics/log/Logger;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/analytics/AnalyticsConfigurationInitializer;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->context:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public init()V
    .locals 3

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->initialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    sget-object v0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v1, "Initializing config"

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 64
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->RunningProcessPollInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-virtual {v1}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getKey()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;

    invoke-direct {v2, p0}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;-><init>(Lcom/amazon/analytics/AnalyticsConfigurationInitializer;)V

    invoke-interface {v0, v1, v2}, Lcom/amazon/analytics/AnalyticsConfiguration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 85
    :cond_0
    return-void
.end method

.method setUpPackageCheckMonitor(I)Landroid/content/BroadcastReceiver;
    .locals 8
    .param p1, "pollSeconds"    # I

    .prologue
    .line 49
    new-instance v0, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;

    iget-object v4, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->context:Landroid/content/Context;

    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->activityManager:Lcom/amazon/analytics/TailwindActivityManager;

    iget-object v6, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->queue:Lcom/amazon/analytics/session/PriorityQueue;

    iget-object v7, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->sessionBuilder:Lcom/amazon/analytics/session/PackageSessionBuilder;

    invoke-direct {v0, v4, v5, v6, v7}, Lcom/amazon/analytics/session/poller/PackageCheckRunnable;-><init>(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;)V

    .line 50
    .local v0, "runningPackageChecker":Ljava/lang/Runnable;
    new-instance v3, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;

    iget-object v4, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->service:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-direct {v3, v4, v0, p1}, Lcom/amazon/analytics/session/poller/ScreenStateMonitor;-><init>(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;I)V

    .line 51
    .local v3, "screenStateMonitor":Lcom/amazon/analytics/session/poller/ScreenStateMonitor;
    new-instance v2, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver;

    invoke-direct {v2, v3}, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver;-><init>(Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;)V

    .line 53
    .local v2, "screenReceiver":Landroid/content/BroadcastReceiver;
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 54
    .local v1, "screenFilter":Landroid/content/IntentFilter;
    const-string/jumbo v4, "android.intent.action.SCREEN_ON"

    invoke-virtual {v1, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 55
    const-string/jumbo v4, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v1, v4}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 57
    iget-object v4, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->context:Landroid/content/Context;

    invoke-virtual {v4, v2, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 58
    return-object v2
.end method
