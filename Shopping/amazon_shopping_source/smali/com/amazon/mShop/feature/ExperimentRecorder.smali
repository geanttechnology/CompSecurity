.class public Lcom/amazon/mShop/feature/ExperimentRecorder;
.super Ljava/lang/Object;
.source "ExperimentRecorder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    }
.end annotation


# static fields
.field private static final DEBUG:Z

.field private static final TAG:Ljava/lang/String;

.field private static instance:Lcom/amazon/mShop/feature/ExperimentRecorder;


# instance fields
.field private final eventLock:Ljava/lang/Object;

.field private events:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;",
            ">;"
        }
    .end annotation
.end field

.field private final features:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;",
            ">;"
        }
    .end annotation
.end field

.field private running:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    .line 67
    const-class v0, Lcom/amazon/mShop/feature/ExperimentRecorder;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->events:Ljava/util/LinkedList;

    .line 42
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->eventLock:Ljava/lang/Object;

    .line 45
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->features:Ljava/util/HashMap;

    .line 48
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->running:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 258
    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/feature/ExperimentRecorder;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->running:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/feature/ExperimentRecorder;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/feature/ExperimentRecorder;->sendEvents()V

    return-void
.end method

.method static synthetic access$600()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$900()Z
    .locals 1

    .prologue
    .line 37
    sget-boolean v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    return v0
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/feature/ExperimentRecorder;
    .locals 2

    .prologue
    .line 73
    const-class v1, Lcom/amazon/mShop/feature/ExperimentRecorder;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->instance:Lcom/amazon/mShop/feature/ExperimentRecorder;

    if-nez v0, :cond_0

    .line 74
    new-instance v0, Lcom/amazon/mShop/feature/ExperimentRecorder;

    invoke-direct {v0}, Lcom/amazon/mShop/feature/ExperimentRecorder;-><init>()V

    sput-object v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->instance:Lcom/amazon/mShop/feature/ExperimentRecorder;

    .line 77
    :cond_0
    sget-object v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->instance:Lcom/amazon/mShop/feature/ExperimentRecorder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 73
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private sendEvents()V
    .locals 12

    .prologue
    .line 178
    :try_start_0
    sget-boolean v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    if-eqz v9, :cond_0

    .line 179
    sget-object v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Sending events"

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 182
    :cond_0
    const/4 v7, 0x0

    .line 184
    .local v7, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;>;"
    iget-object v10, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->eventLock:Ljava/lang/Object;

    monitor-enter v10
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 185
    :try_start_1
    iget-object v7, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->events:Ljava/util/LinkedList;

    .line 186
    new-instance v9, Ljava/util/LinkedList;

    invoke-direct {v9}, Ljava/util/LinkedList;-><init>()V

    iput-object v9, p0, Lcom/amazon/mShop/feature/ExperimentRecorder;->events:Ljava/util/LinkedList;

    .line 187
    monitor-exit v10
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 189
    if-eqz v7, :cond_1

    :try_start_2
    invoke-interface {v7}, Ljava/util/List;->isEmpty()Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-result v9

    if-eqz v9, :cond_2

    .line 225
    .end local v7    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;>;"
    :cond_1
    :goto_0
    return-void

    .line 187
    .restart local v7    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;>;"
    :catchall_0
    move-exception v9

    :try_start_3
    monitor-exit v10
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v9
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    .line 222
    .end local v7    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;>;"
    :catch_0
    move-exception v2

    .line 223
    .local v2, "e":Ljava/lang/Exception;
    sget-object v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Failed to send events"

    invoke-static {v9, v10, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 193
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v7    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;>;"
    :cond_2
    :try_start_5
    new-instance v6, Ljava/util/ArrayList;

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    invoke-direct {v6, v9}, Ljava/util/ArrayList;-><init>(I)V

    .line 194
    .local v6, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;>;"
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v8

    .line 196
    .local v8, "session":Ljava/lang/String;
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .line 197
    .local v3, "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->session:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$000(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v8}, Lcom/amazon/mShop/util/Util;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_4

    .line 198
    sget-boolean v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    if-eqz v9, :cond_3

    .line 199
    sget-object v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Event has stale session: event: ["

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string/jumbo v11, "], session: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 204
    :cond_4
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;-><init>()V

    .line 205
    .local v4, "featureExperience":Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->featureName:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$700(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v9}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setFeatureName(Ljava/lang/String;)V

    .line 206
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->treatment:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$200(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v9}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setTreatment(Ljava/lang/String;)V

    .line 207
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->cacheStamp:Ljava/lang/Integer;
    invoke-static {v3}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$800(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v4, v9}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->setCacheStamp(Ljava/lang/Integer;)V

    .line 208
    invoke-interface {v6, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 210
    sget-boolean v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    if-eqz v9, :cond_3

    .line 211
    sget-object v9, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Logging event: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 215
    .end local v3    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .end local v4    # "featureExperience":Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
    :cond_5
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;-><init>()V

    .line 216
    .local v0, "clientLogInfo":Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
    new-instance v9, Ljava/util/Vector;

    invoke-direct {v9, v6}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0, v9}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setFeatures(Ljava/util/List;)V

    .line 217
    const-string/jumbo v9, "main"

    invoke-virtual {v0, v9}, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->setPageAssemblyType(Ljava/lang/String;)V

    .line 219
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;-><init>()V

    .line 220
    .local v1, "clientMetrics":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->setLogInfo(Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;)V

    .line 221
    invoke-direct {p0, v1}, Lcom/amazon/mShop/feature/ExperimentRecorder;->sendMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_0
.end method

.method private sendMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
    .locals 2
    .param p1, "clientMetrics"    # Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;

    .prologue
    .line 231
    new-instance v0, Lcom/amazon/mShop/feature/ExperimentRecorder$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/feature/ExperimentRecorder$2;-><init>(Lcom/amazon/mShop/feature/ExperimentRecorder;)V

    .line 252
    .local v0, "listener":Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, p1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 253
    return-void
.end method


# virtual methods
.method public getTreatment(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 84
    const/4 v0, 0x1

    const-wide/32 v1, 0x75300

    invoke-virtual {p0, p1, v0, v1, v2}, Lcom/amazon/mShop/feature/ExperimentRecorder;->getTreatment(Ljava/lang/String;ZJ)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTreatment(Ljava/lang/String;ZJ)Ljava/lang/String;
    .locals 16
    .param p1, "featureName"    # Ljava/lang/String;
    .param p2, "trigger"    # Z
    .param p3, "treatmentDuration"    # J

    .prologue
    .line 92
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 94
    .local v3, "time":J
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 95
    const-string/jumbo v6, "C"

    .line 170
    .end local v3    # "time":J
    :cond_0
    :goto_0
    return-object v6

    .line 98
    .restart local v3    # "time":J
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Lcom/amazon/mShop/feature/Features;->getFeature(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/Feature;

    move-result-object v11

    .line 100
    .local v11, "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    if-nez v11, :cond_2

    .line 101
    const-string/jumbo v6, "C"

    goto :goto_0

    .line 104
    :cond_2
    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getClientTreatmentPath()Ljava/lang/String;

    move-result-object v6

    .line 106
    .local v6, "treatment":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 107
    const-string/jumbo v6, "C"

    goto :goto_0

    .line 110
    :cond_3
    if-eqz p2, :cond_0

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getSendTrigger()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 114
    const/4 v10, 0x0

    .line 115
    .local v10, "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v2

    .line 117
    .local v2, "session":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->features:Ljava/util/HashMap;

    monitor-enter v14
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 118
    :try_start_1
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->features:Ljava/util/HashMap;

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .line 120
    .local v12, "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    if-eqz v12, :cond_6

    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->session:Ljava/lang/String;
    invoke-static {v12}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$000(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/amazon/mShop/util/Util;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->time:J
    invoke-static {v12}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$100(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)J

    move-result-wide v7

    sub-long v7, v3, v7

    cmp-long v5, v7, p3

    if-gtz v5, :cond_6

    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->treatment:Ljava/lang/String;
    invoke-static {v12}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->access$200(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 122
    sget-boolean v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    if-eqz v5, :cond_7

    .line 123
    sget-object v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Treatment is unchanged: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    move-object v1, v10

    .line 133
    .end local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .local v1, "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :cond_4
    :goto_1
    :try_start_2
    monitor-exit v14
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 135
    if-eqz v1, :cond_0

    .line 136
    :try_start_3
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->eventLock:Ljava/lang/Object;

    monitor-enter v7
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 137
    :try_start_4
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->events:Ljava/util/LinkedList;

    invoke-virtual {v5}, Ljava/util/LinkedList;->size()I

    move-result v13

    .line 139
    .local v13, "size":I
    const/16 v5, 0x1ff

    if-le v13, v5, :cond_5

    .line 140
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->events:Ljava/util/LinkedList;

    const/4 v8, 0x0

    add-int/lit16 v14, v13, -0x200

    add-int/lit8 v14, v14, 0x1

    invoke-virtual {v5, v8, v14}, Ljava/util/LinkedList;->subList(II)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 142
    sget-boolean v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    if-eqz v5, :cond_5

    .line 143
    sget-object v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Event queue exceeded capacity"

    invoke-static {v5, v8}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 147
    :cond_5
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->events:Ljava/util/LinkedList;

    invoke-virtual {v5, v1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 148
    monitor-exit v7
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 150
    :try_start_5
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->running:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v7, 0x0

    const/4 v8, 0x1

    invoke-virtual {v5, v7, v8}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 151
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    new-instance v7, Lcom/amazon/mShop/feature/ExperimentRecorder$1;

    move-object/from16 v0, p0

    invoke-direct {v7, v0}, Lcom/amazon/mShop/feature/ExperimentRecorder$1;-><init>(Lcom/amazon/mShop/feature/ExperimentRecorder;)V

    const-wide/16 v14, 0x4e20

    invoke-interface {v5, v7, v14, v15}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_0

    .line 166
    .end local v1    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .end local v2    # "session":Ljava/lang/String;
    .end local v3    # "time":J
    .end local v6    # "treatment":Ljava/lang/String;
    .end local v11    # "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .end local v12    # "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .end local v13    # "size":I
    :catch_0
    move-exception v9

    .line 167
    .local v9, "e":Ljava/lang/Exception;
    sget-object v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Failed to get treatment for feature: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p1

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 170
    const-string/jumbo v6, "C"

    goto/16 :goto_0

    .line 126
    .end local v9    # "e":Ljava/lang/Exception;
    .restart local v2    # "session":Ljava/lang/String;
    .restart local v3    # "time":J
    .restart local v6    # "treatment":Ljava/lang/String;
    .restart local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v11    # "feature":Lcom/amazon/rio/j2me/client/services/mShop/Feature;
    .restart local v12    # "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :cond_6
    :try_start_6
    new-instance v1, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    invoke-virtual {v11}, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->getCacheStamp()Ljava/lang/Integer;

    move-result-object v7

    const/4 v8, 0x0

    move-object/from16 v5, p1

    invoke-direct/range {v1 .. v8}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;-><init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/feature/ExperimentRecorder$1;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 127
    .end local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v1    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :try_start_7
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/mShop/feature/ExperimentRecorder;->features:Ljava/util/HashMap;

    move-object/from16 v0, p1

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    sget-boolean v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z

    if-eqz v5, :cond_4

    .line 130
    sget-object v5, Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Queueing event: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 133
    .end local v12    # "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :catchall_0
    move-exception v5

    :goto_2
    monitor-exit v14
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :try_start_8
    throw v5
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0

    .line 148
    .restart local v12    # "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :catchall_1
    move-exception v5

    :try_start_9
    monitor-exit v7
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    :try_start_a
    throw v5
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_0

    .line 133
    .end local v1    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .end local v12    # "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :catchall_2
    move-exception v5

    move-object v1, v10

    .end local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v1    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    goto :goto_2

    .end local v1    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v12    # "prev":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    :cond_7
    move-object v1, v10

    .end local v10    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    .restart local v1    # "event":Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
    goto/16 :goto_1
.end method
