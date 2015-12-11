.class public final Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;
.super Ljava/lang/Object;
.source "RetailSearchDaggerGraphController.java"


# static fields
.field private static volatile graph:Ldagger/ObjectGraph;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    return-void
.end method

.method public static varargs declared-synchronized createGraph([Ljava/lang/Object;)Ldagger/ObjectGraph;
    .locals 2
    .param p0, "modules"    # [Ljava/lang/Object;

    .prologue
    .line 70
    const-class v1, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Ldagger/ObjectGraph;->create([Ljava/lang/Object;)Ldagger/ObjectGraph;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;

    .line 71
    sget-object v0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 70
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getGraph()Ldagger/ObjectGraph;
    .locals 2

    .prologue
    .line 54
    const-class v1, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;

    if-nez v0, :cond_0

    .line 56
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->createGraph([Ljava/lang/Object;)Ldagger/ObjectGraph;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;

    .line 58
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 54
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized inject(Ljava/lang/Object;)V
    .locals 2
    .param p0, "object"    # Ljava/lang/Object;

    .prologue
    .line 83
    const-class v1, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->getGraph()Ldagger/ObjectGraph;

    move-result-object v0

    invoke-virtual {v0, p0}, Ldagger/ObjectGraph;->inject(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 84
    monitor-exit v1

    return-void

    .line 83
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method static setGraph(Ldagger/ObjectGraph;)V
    .locals 0
    .param p0, "newgraph"    # Ldagger/ObjectGraph;

    .prologue
    .line 44
    sput-object p0, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->graph:Ldagger/ObjectGraph;

    .line 45
    return-void
.end method
