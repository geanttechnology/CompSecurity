.class public Lcom/flow/android/engine/library/impl/servermatch/HttpManager;
.super Ljava/lang/Object;
.source "HttpManager.java"

# interfaces
.implements Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;


# static fields
.field static m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

.field private static s_metricsServer:Ljava/lang/String;


# instance fields
.field final m_cb:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

.field m_outstandingFseThreads:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-string/jumbo v0, "https://eventlog-visualsearch.amazon.com/vsmetrics"

    sput-object v0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->s_metricsServer:Ljava/lang/String;

    .line 31
    const/4 v0, 0x0

    sput-object v0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    return-void
.end method

.method public constructor <init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;)V
    .locals 1
    .param p1, "a_cb"    # Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;
    .param p2, "a_clientInfo"    # Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    .line 36
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_cb:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    .line 37
    sput-object p2, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    .line 38
    return-void
.end method


# virtual methods
.method public cancelFSERequests()V
    .locals 3

    .prologue
    .line 44
    const/4 v1, 0x0

    .line 45
    .local v1, "key":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 46
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v1

    .line 47
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    invoke-virtual {v2, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;

    invoke-virtual {v2}, Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;->cancelRequest()V

    .line 45
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 49
    :cond_0
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->clear()V

    .line 50
    return-void
.end method

.method public doImageMatch(Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V
    .locals 9
    .param p1, "inputStream"    # Ljava/io/ByteArrayInputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/ByteArrayInputStream;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 53
    .local p2, "customParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "metadataParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_cb:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    sget-object v3, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    sget-object v2, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v2}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getHttpImageMatchServer()Ljava/lang/String;

    move-result-object v4

    sget-object v2, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v2}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getImageMatchServerResponseType()Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    move-result-object v5

    move-object v2, p0

    move-object v6, p1

    move-object v7, p2

    move-object v8, p3

    invoke-direct/range {v0 .. v8}, Lcom/flow/android/engine/library/impl/servermatch/threads/ImageServerMatch;-><init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V

    .line 54
    .local v0, "imageMatchThread":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 55
    return-void
.end method

.method public doMetricsReporting(Lcom/flow/android/engine/library/FlowStateEngineMetrics;)V
    .locals 8
    .param p1, "a_engineMetrics"    # Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    .prologue
    const/4 v5, 0x0

    .line 68
    new-instance v0, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_cb:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    sget-object v3, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    sget-object v4, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->s_metricsServer:Ljava/lang/String;

    move-object v2, p0

    move-object v6, v5

    move-object v7, p1

    invoke-direct/range {v0 .. v7}, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;-><init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Lcom/flow/android/engine/library/FlowStateEngineMetrics;)V

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/servermatch/threads/MetricsReporter;->start()V

    .line 69
    return-void
.end method

.method public doTextMatch(Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V
    .locals 9
    .param p1, "inputStream"    # Ljava/io/ByteArrayInputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/ByteArrayInputStream;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 58
    .local p2, "customParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "metadataParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/flow/android/engine/library/impl/servermatch/threads/TextServerMatcher;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_cb:Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;

    sget-object v3, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    sget-object v2, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v2}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getHttpTextServer()Ljava/lang/String;

    move-result-object v4

    sget-object v2, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_clientDevice:Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    invoke-virtual {v2}, Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;->getTextServerResponseType()Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    move-result-object v5

    move-object v2, p0

    move-object v6, p1

    move-object v7, p2

    move-object v8, p3

    invoke-direct/range {v0 .. v8}, Lcom/flow/android/engine/library/impl/servermatch/threads/TextServerMatcher;-><init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/threads/ThreadPoolManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V

    .line 59
    .local v0, "textMatchThread":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 61
    return-void
.end method

.method public onFinish(I)V
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 78
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->remove(I)V

    .line 79
    return-void
.end method

.method public onRun(ILcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;)V
    .locals 1
    .param p1, "id"    # I
    .param p2, "thread"    # Lcom/flow/android/engine/library/impl/servermatch/threads/FlowServerRequestThread;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->m_outstandingFseThreads:Landroid/util/SparseArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    .line 74
    return-void
.end method
