.class public Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;
.super Ljava/lang/Object;
.source "PendingRequestCallbackHolder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;
    }
.end annotation


# instance fields
.field private final mIdentiferToPendingCallback:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->mIdentiferToPendingCallback:Ljava/util/Map;

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Landroid/os/Bundle;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->getAndClearInFlightCallbacksForId(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p2}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_0
    invoke-interface {v1}, Ljava/util/List;->clear()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Landroid/os/Bundle;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->getAndClearInFlightCallbacksForId(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p2}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_0
    invoke-interface {v1}, Ljava/util/List;->clear()V

    return-void
.end method

.method private declared-synchronized addEmptyListToId(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ">;"
        }
    .end annotation

    .prologue
    .line 102
    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 103
    .local v0, "inflightCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    iget-object v1, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->mIdentiferToPendingCallback:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 104
    monitor-exit p0

    return-object v0

    .line 102
    .end local v0    # "inflightCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private declared-synchronized getAndClearInFlightCallbacksForId(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ">;"
        }
    .end annotation

    .prologue
    .line 80
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->getInFlightCallbacksForId(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 81
    .local v0, "pendingCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 83
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->addEmptyListToId(Ljava/lang/String;)Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    :cond_0
    monitor-exit p0

    return-object v0

    .line 80
    .end local v0    # "pendingCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private declared-synchronized getInFlightCallbacksForId(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->mIdentiferToPendingCallback:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 92
    .local v0, "inflightCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    if-nez v0, :cond_0

    .line 94
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->addEmptyListToId(Ljava/lang/String;)Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 97
    :cond_0
    monitor-exit p0

    return-object v0

    .line 91
    .end local v0    # "inflightCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method public declared-synchronized waitForInflightRequestOrMakeRequest(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 46
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->getInFlightCallbacksForId(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 47
    .local v0, "inflightCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 48
    invoke-interface {v0}, Ljava/util/List;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    const/4 v2, 0x1

    if-le v1, v2, :cond_0

    .line 50
    const/4 v1, 0x0

    .line 53
    :goto_0
    monitor-exit p0

    return-object v1

    :cond_0
    :try_start_1
    new-instance v1, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;

    invoke-direct {v1, p0, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;-><init>(Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 46
    .end local v0    # "inflightCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/api/Callback;>;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
