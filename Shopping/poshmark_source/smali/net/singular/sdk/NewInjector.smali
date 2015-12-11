.class Lnet/singular/sdk/NewInjector;
.super Ljava/lang/Object;
.source "NewInjector.java"


# instance fields
.field private advertisingIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

.field private collector:Lnet/singular/sdk/Collector;

.field private context:Landroid/content/Context;

.field private controller:Lnet/singular/sdk/Controller;

.field private countersLogger:Lnet/singular/sdk/CountersLogger;

.field private eventReporter:Lnet/singular/sdk/EventReporter;

.field private eventStore:Lnet/singular/sdk/EventStore;

.field private facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;

.field private logsKeeper:Lnet/singular/sdk/LogsKeeper;

.field private final manifestHelper:Lnet/singular/sdk/ManifestHelper;

.field private networkPostable:Lnet/singular/sdk/PostableWorker;

.field private random:Ljava/util/Random;

.field private saverPostable:Lnet/singular/sdk/PostableWorker;

.field private sessionManager:Lnet/singular/sdk/SessionManager;

.field private singularLog:Lnet/singular/sdk/SingularLog;

.field private singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

.field private timeHelper:Lnet/singular/sdk/TimeHelper;


# direct methods
.method public constructor <init>(Landroid/content/Context;Z)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "sandbox"    # Z

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->context:Landroid/content/Context;

    .line 29
    new-instance v0, Lnet/singular/sdk/SingularLog;

    invoke-direct {v0}, Lnet/singular/sdk/SingularLog;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    .line 30
    new-instance v0, Lnet/singular/sdk/ManifestHelper;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct {v0, p1, v1}, Lnet/singular/sdk/ManifestHelper;-><init>(Landroid/content/Context;Lnet/singular/sdk/SingularLog;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    .line 31
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    invoke-virtual {v0, v1}, Lnet/singular/sdk/SingularLog;->initialize(Lnet/singular/sdk/ManifestHelper;)V

    .line 32
    new-instance v0, Lnet/singular/sdk/TimeHelper;

    invoke-direct {v0}, Lnet/singular/sdk/TimeHelper;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->timeHelper:Lnet/singular/sdk/TimeHelper;

    .line 33
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->random:Ljava/util/Random;

    .line 34
    new-instance v0, Lnet/singular/sdk/AdvertisingIdHelper;

    invoke-direct {v0, p1}, Lnet/singular/sdk/AdvertisingIdHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->advertisingIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    .line 35
    new-instance v0, Lnet/singular/sdk/FacebookAttributionIdGetter;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct {v0, p1, v1}, Lnet/singular/sdk/FacebookAttributionIdGetter;-><init>(Landroid/content/Context;Lnet/singular/sdk/SingularLog;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;

    .line 36
    new-instance v0, Lnet/singular/sdk/EventReporter;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->timeHelper:Lnet/singular/sdk/TimeHelper;

    invoke-direct {v0, v1, v2}, Lnet/singular/sdk/EventReporter;-><init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/TimeHelper;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->eventReporter:Lnet/singular/sdk/EventReporter;

    .line 37
    new-instance v0, Lnet/singular/sdk/SingularSQLiteHelper;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct {v0, p1, v1}, Lnet/singular/sdk/SingularSQLiteHelper;-><init>(Landroid/content/Context;Lnet/singular/sdk/SingularLog;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    .line 38
    new-instance v0, Lnet/singular/sdk/PostableWorker;

    const-string v1, "saverThread"

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct {v0, v1, v2}, Lnet/singular/sdk/PostableWorker;-><init>(Ljava/lang/String;Lnet/singular/sdk/SingularLog;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->saverPostable:Lnet/singular/sdk/PostableWorker;

    .line 39
    new-instance v0, Lnet/singular/sdk/PostableWorker;

    const-string v1, "networkPostable"

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct {v0, v1, v2}, Lnet/singular/sdk/PostableWorker;-><init>(Ljava/lang/String;Lnet/singular/sdk/SingularLog;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->networkPostable:Lnet/singular/sdk/PostableWorker;

    .line 40
    new-instance v0, Lnet/singular/sdk/CountersLogger;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-direct {v0, v1, p0}, Lnet/singular/sdk/CountersLogger;-><init>(Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/NewInjector;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    .line 41
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    invoke-virtual {v0, v1}, Lnet/singular/sdk/SingularLog;->setCountersLogger(Lnet/singular/sdk/CountersLogger;)V

    .line 42
    new-instance v0, Lnet/singular/sdk/LogsKeeper;

    const/16 v1, 0x12c

    invoke-direct {v0, v1}, Lnet/singular/sdk/LogsKeeper;-><init>(I)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    .line 43
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    invoke-virtual {v0, v1}, Lnet/singular/sdk/SingularLog;->setLogsKeeper(Lnet/singular/sdk/LogsKeeper;)V

    .line 44
    new-instance v0, Lnet/singular/sdk/EventStore;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    iget-object v3, p0, Lnet/singular/sdk/NewInjector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    iget-object v4, p0, Lnet/singular/sdk/NewInjector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    invoke-direct {v0, v1, v2, v3, v4}, Lnet/singular/sdk/EventStore;-><init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/SingularSQLiteHelper;Lnet/singular/sdk/ManifestHelper;Lnet/singular/sdk/CountersLogger;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->eventStore:Lnet/singular/sdk/EventStore;

    .line 45
    new-instance v0, Lnet/singular/sdk/Controller;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->eventStore:Lnet/singular/sdk/EventStore;

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->eventReporter:Lnet/singular/sdk/EventReporter;

    iget-object v3, p0, Lnet/singular/sdk/NewInjector;->timeHelper:Lnet/singular/sdk/TimeHelper;

    iget-object v4, p0, Lnet/singular/sdk/NewInjector;->networkPostable:Lnet/singular/sdk/PostableWorker;

    iget-object v5, p0, Lnet/singular/sdk/NewInjector;->saverPostable:Lnet/singular/sdk/PostableWorker;

    iget-object v6, p0, Lnet/singular/sdk/NewInjector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    iget-object v7, p0, Lnet/singular/sdk/NewInjector;->random:Ljava/util/Random;

    iget-object v8, p0, Lnet/singular/sdk/NewInjector;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    iget-object v9, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct/range {v0 .. v9}, Lnet/singular/sdk/Controller;-><init>(Lnet/singular/sdk/EventStore;Lnet/singular/sdk/EventReporter;Lnet/singular/sdk/TimeHelper;Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/CountersLogger;Ljava/util/Random;Lnet/singular/sdk/LogsKeeper;Lnet/singular/sdk/SingularLog;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->controller:Lnet/singular/sdk/Controller;

    .line 47
    new-instance v0, Lnet/singular/sdk/SessionManager;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->controller:Lnet/singular/sdk/Controller;

    iget-object v3, p0, Lnet/singular/sdk/NewInjector;->timeHelper:Lnet/singular/sdk/TimeHelper;

    iget-object v4, p0, Lnet/singular/sdk/NewInjector;->saverPostable:Lnet/singular/sdk/PostableWorker;

    iget-object v5, p0, Lnet/singular/sdk/NewInjector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    move-object v6, p0

    invoke-direct/range {v0 .. v6}, Lnet/singular/sdk/SessionManager;-><init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/Controller;Lnet/singular/sdk/TimeHelper;Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/CountersLogger;Lnet/singular/sdk/NewInjector;)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->sessionManager:Lnet/singular/sdk/SessionManager;

    .line 49
    new-instance v0, Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v3, p0, Lnet/singular/sdk/NewInjector;->advertisingIdHelper:Lnet/singular/sdk/AdvertisingIdHelper;

    iget-object v4, p0, Lnet/singular/sdk/NewInjector;->sessionManager:Lnet/singular/sdk/SessionManager;

    iget-object v5, p0, Lnet/singular/sdk/NewInjector;->countersLogger:Lnet/singular/sdk/CountersLogger;

    iget-object v6, p0, Lnet/singular/sdk/NewInjector;->manifestHelper:Lnet/singular/sdk/ManifestHelper;

    iget-object v7, p0, Lnet/singular/sdk/NewInjector;->facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;

    move-object v2, p1

    move-object v8, p0

    move v9, p2

    invoke-direct/range {v0 .. v9}, Lnet/singular/sdk/Collector;-><init>(Lnet/singular/sdk/SingularLog;Landroid/content/Context;Lnet/singular/sdk/AdvertisingIdHelper;Lnet/singular/sdk/SessionManager;Lnet/singular/sdk/CountersLogger;Lnet/singular/sdk/ManifestHelper;Lnet/singular/sdk/FacebookAttributionIdGetter;Lnet/singular/sdk/NewInjector;Z)V

    iput-object v0, p0, Lnet/singular/sdk/NewInjector;->collector:Lnet/singular/sdk/Collector;

    .line 51
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->controller:Lnet/singular/sdk/Controller;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->sessionManager:Lnet/singular/sdk/SessionManager;

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v0, v1, v2}, Lnet/singular/sdk/Controller;->initController(Lnet/singular/sdk/SessionManager;Lnet/singular/sdk/Collector;)V

    .line 52
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v0, v1}, Lnet/singular/sdk/SingularLog;->setController(Lnet/singular/sdk/Controller;)V

    .line 53
    return-void
.end method


# virtual methods
.method public generateKeyValueStore(Ljava/lang/String;)Lnet/singular/sdk/KeyValueStore;
    .locals 3
    .param p1, "namespace"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v0, Lnet/singular/sdk/KeyValueStore;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    iget-object v2, p0, Lnet/singular/sdk/NewInjector;->singularSQLiteHelper:Lnet/singular/sdk/SingularSQLiteHelper;

    invoke-direct {v0, v1, v2, p1}, Lnet/singular/sdk/KeyValueStore;-><init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/SingularSQLiteHelper;Ljava/lang/String;)V

    return-object v0
.end method

.method public generatePostableWorker(Ljava/lang/String;)Lnet/singular/sdk/PostableWorker;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 69
    new-instance v0, Lnet/singular/sdk/PostableWorker;

    iget-object v1, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    invoke-direct {v0, p1, v1}, Lnet/singular/sdk/PostableWorker;-><init>(Ljava/lang/String;Lnet/singular/sdk/SingularLog;)V

    return-object v0
.end method

.method public getController()Lnet/singular/sdk/Controller;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->controller:Lnet/singular/sdk/Controller;

    return-object v0
.end method

.method public getSingularLog()Lnet/singular/sdk/SingularLog;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lnet/singular/sdk/NewInjector;->singularLog:Lnet/singular/sdk/SingularLog;

    return-object v0
.end method
