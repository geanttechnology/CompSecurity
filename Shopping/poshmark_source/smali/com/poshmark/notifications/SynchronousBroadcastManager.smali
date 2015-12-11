.class public Lcom/poshmark/notifications/SynchronousBroadcastManager;
.super Ljava/lang/Object;
.source "SynchronousBroadcastManager.java"


# static fields
.field static listeners:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/notifications/SynchronousBroadcastListener;",
            ">;>;"
        }
    .end annotation
.end field

.field static syncBroadcastManager:Lcom/poshmark/notifications/SynchronousBroadcastManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/notifications/SynchronousBroadcastManager;->syncBroadcastManager:Lcom/poshmark/notifications/SynchronousBroadcastManager;

    .line 21
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getSyncronousBroadcastManager()Lcom/poshmark/notifications/SynchronousBroadcastManager;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/poshmark/notifications/SynchronousBroadcastManager;->syncBroadcastManager:Lcom/poshmark/notifications/SynchronousBroadcastManager;

    if-nez v0, :cond_0

    .line 16
    new-instance v0, Lcom/poshmark/notifications/SynchronousBroadcastManager;

    invoke-direct {v0}, Lcom/poshmark/notifications/SynchronousBroadcastManager;-><init>()V

    sput-object v0, Lcom/poshmark/notifications/SynchronousBroadcastManager;->syncBroadcastManager:Lcom/poshmark/notifications/SynchronousBroadcastManager;

    .line 18
    :cond_0
    sget-object v0, Lcom/poshmark/notifications/SynchronousBroadcastManager;->syncBroadcastManager:Lcom/poshmark/notifications/SynchronousBroadcastManager;

    return-object v0
.end method


# virtual methods
.method public registerSynchronousBroadcastListener(Ljava/lang/String;Lcom/poshmark/notifications/SynchronousBroadcastListener;)V
    .locals 3
    .param p1, "intent"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/poshmark/notifications/SynchronousBroadcastListener;

    .prologue
    .line 24
    sget-object v2, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 25
    sget-object v2, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 26
    .local v0, "listenerList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 27
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 34
    .end local v0    # "listenerList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    :cond_0
    :goto_0
    return-void

    .line 30
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 31
    .local v1, "newList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    invoke-virtual {v1, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 32
    sget-object v2, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public sendSynchronousBroadcast(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 5
    .param p1, "intent"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 46
    sget-object v4, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 47
    sget-object v4, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 48
    .local v2, "listenerList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 49
    .local v3, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_1

    .line 50
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/notifications/SynchronousBroadcastListener;

    .line 51
    .local v1, "listener":Lcom/poshmark/notifications/SynchronousBroadcastListener;
    if-eqz v1, :cond_0

    .line 52
    invoke-interface {v1, p1, p2}, Lcom/poshmark/notifications/SynchronousBroadcastListener;->handleSynchronousBroadcastMsg(Ljava/lang/String;Ljava/lang/Object;)V

    .line 49
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 56
    .end local v0    # "i":I
    .end local v1    # "listener":Lcom/poshmark/notifications/SynchronousBroadcastListener;
    .end local v2    # "listenerList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    .end local v3    # "size":I
    :cond_1
    return-void
.end method

.method public unregisterSynchronousBroadcastListener(Ljava/lang/String;Lcom/poshmark/notifications/SynchronousBroadcastListener;)V
    .locals 2
    .param p1, "intent"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/poshmark/notifications/SynchronousBroadcastListener;

    .prologue
    .line 37
    sget-object v1, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    sget-object v1, Lcom/poshmark/notifications/SynchronousBroadcastManager;->listeners:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 39
    .local v0, "listenerList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 40
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 43
    .end local v0    # "listenerList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/poshmark/notifications/SynchronousBroadcastListener;>;"
    :cond_0
    return-void
.end method
