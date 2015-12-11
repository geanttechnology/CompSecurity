.class public Lcom/amazon/analytics/TailwindModule;
.super Ljava/lang/Object;
.source "TailwindModule.java"


# annotations
.annotation runtime Ldagger/Module;
    complete = false
    includes = {
        Lcom/amazon/android/dagger/application/ContextModule;,
        Lcom/amazon/mas/client/featureconfig/FeatureConfigModule;
    }
    injects = {
        Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;,
        Lcom/amazon/analytics/session/PackageSession;
    }
.end annotation


# static fields
.field private static final API_VERSION:Ljava/lang/String; = "ver"

.field private static final API_VERSION_VALUE:Ljava/lang/String; = "v2.0"

.field private static final MAS_APPLICATION_KEY:Ljava/lang/String; = "MasApplicationKey"

.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private tailwindAcitivtyClazz:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/analytics/TailwindActivityManager;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-class v0, Lcom/amazon/analytics/TailwindModule;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/TailwindModule;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const-class v0, Lcom/amazon/analytics/TailwindActivityManagerImpl;

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule;->tailwindAcitivtyClazz:Ljava/lang/Class;

    return-void
.end method


# virtual methods
.method getAnalyticsConfiguration(Lcom/amazon/analytics/AnalyticsConfigurationImpl;)Lcom/amazon/analytics/AnalyticsConfiguration;
    .locals 0
    .param p1, "configImpl"    # Lcom/amazon/analytics/AnalyticsConfigurationImpl;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 75
    return-object p1
.end method

.method getAnalyticsConfigurationImpl(Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;)Lcom/amazon/analytics/AnalyticsConfigurationImpl;
    .locals 1
    .param p1, "featureConfigLocator"    # Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 70
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;

    invoke-direct {v0, p1}, Lcom/amazon/analytics/AnalyticsConfigurationImpl;-><init>(Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;)V

    return-object v0
.end method

.method getAnalyticsConfigurationInitializer(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/AnalyticsConfiguration;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;Ljava/util/concurrent/ScheduledExecutorService;)Lcom/amazon/analytics/AnalyticsConfigurationInitializer;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activityManager"    # Lcom/amazon/analytics/TailwindActivityManager;
    .param p3, "config"    # Lcom/amazon/analytics/AnalyticsConfiguration;
    .param p4, "queue"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p5, "sessionBuilder"    # Lcom/amazon/analytics/session/PackageSessionBuilder;
    .param p6, "service"    # Ljava/util/concurrent/ScheduledExecutorService;
        .annotation runtime Ljavax/inject/Named;
            value = "TailwindExecutorService"
        .end annotation
    .end param
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 110
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;-><init>(Landroid/content/Context;Lcom/amazon/analytics/TailwindActivityManager;Lcom/amazon/analytics/AnalyticsConfiguration;Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PackageSessionBuilder;Ljava/util/concurrent/ScheduledExecutorService;)V

    return-object v0
.end method

.method getEventRecorder(Landroid/content/Context;Lcom/amazon/analytics/AnalyticsConfigurationImpl;)Lcom/amazon/device/analytics/events/EventRecorder;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configImpl"    # Lcom/amazon/analytics/AnalyticsConfigurationImpl;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 81
    invoke-virtual {p2}, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->getUnderlyingConfig()Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    move-result-object v1

    invoke-static {p1, v1}, Lcom/amazon/device/analytics/AnalyticsClient;->newInstance(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)Lcom/amazon/device/analytics/AnalyticsClient;

    move-result-object v1

    const-string/jumbo v2, "MasApplicationKey"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/AnalyticsClient;->newEventRecorder(Ljava/lang/String;)Lcom/amazon/device/analytics/events/EventRecorder;

    move-result-object v0

    .line 83
    .local v0, "recorder":Lcom/amazon/device/analytics/events/EventRecorder;
    const-string/jumbo v1, "ver"

    const-string/jumbo v2, "v2.0"

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/analytics/events/EventRecorder;->addGlobalAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    return-object v0
.end method

.method getPackageSessionBuilder()Lcom/amazon/analytics/session/PackageSessionBuilder;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 88
    new-instance v0, Lcom/amazon/analytics/session/PackageSessionBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/session/PackageSessionBuilder;-><init>()V

    return-object v0
.end method

.method getPriorityQueue(Lcom/amazon/analytics/session/SessionObserver;Lcom/amazon/analytics/AnalyticsConfiguration;)Lcom/amazon/analytics/session/PriorityQueue;
    .locals 1
    .param p1, "sessionObserver"    # Lcom/amazon/analytics/session/SessionObserver;
    .param p2, "config"    # Lcom/amazon/analytics/AnalyticsConfiguration;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 100
    new-instance v0, Lcom/amazon/analytics/session/PriorityQueue;

    invoke-direct {v0, p1, p2}, Lcom/amazon/analytics/session/PriorityQueue;-><init>(Lcom/amazon/analytics/session/SessionObserver;Lcom/amazon/analytics/AnalyticsConfiguration;)V

    return-object v0
.end method

.method getScheduledExecutorService()Ljava/util/concurrent/ScheduledExecutorService;
    .locals 1
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Named;
        value = "TailwindExecutorService"
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 65
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    return-object v0
.end method

.method getSessionObserver(Lcom/amazon/device/analytics/events/EventRecorder;Lcom/amazon/analytics/session/PackageSessionBuilder;)Lcom/amazon/analytics/session/SessionObserver;
    .locals 1
    .param p1, "recorder"    # Lcom/amazon/device/analytics/events/EventRecorder;
    .param p2, "sessionBuilder"    # Lcom/amazon/analytics/session/PackageSessionBuilder;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 94
    new-instance v0, Lcom/amazon/analytics/session/SessionObserver;

    invoke-direct {v0, p1, p2}, Lcom/amazon/analytics/session/SessionObserver;-><init>(Lcom/amazon/device/analytics/events/EventRecorder;Lcom/amazon/analytics/session/PackageSessionBuilder;)V

    return-object v0
.end method

.method getTailwindActivityManager(Landroid/app/ActivityManager;)Lcom/amazon/analytics/TailwindActivityManager;
    .locals 5
    .param p1, "activityManager"    # Landroid/app/ActivityManager;
    .annotation runtime Ldagger/Provides;
    .end annotation

    .annotation runtime Ljavax/inject/Singleton;
    .end annotation

    .prologue
    .line 54
    :try_start_0
    iget-object v1, p0, Lcom/amazon/analytics/TailwindModule;->tailwindAcitivtyClazz:Ljava/lang/Class;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    const/4 v3, 0x0

    const-class v4, Landroid/app/ActivityManager;

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/analytics/TailwindActivityManager;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 58
    :goto_0
    return-object v1

    .line 55
    :catch_0
    move-exception v0

    .line 56
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/analytics/TailwindModule;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "Tailwind activity manager impl class does not have right constructor signature, using default"

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 58
    new-instance v1, Lcom/amazon/analytics/TailwindActivityManagerImpl;

    invoke-direct {v1, p1}, Lcom/amazon/analytics/TailwindActivityManagerImpl;-><init>(Landroid/app/ActivityManager;)V

    goto :goto_0
.end method

.method public setTailwindActivityManagerClass(Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/analytics/TailwindActivityManager;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/amazon/analytics/TailwindActivityManager;>;"
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule;->tailwindAcitivtyClazz:Ljava/lang/Class;

    .line 49
    return-void
.end method
