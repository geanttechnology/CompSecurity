.class public Lcom/amazon/device/utils/NetworkBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "NetworkBroadcastReceiver.java"


# instance fields
.field private isRegistered:Z

.field private mContext:Landroid/content/Context;

.field private mNetworkListenerList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/utils/NetworkListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mNetworkListenerList:Ljava/util/List;

    .line 30
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->isRegistered:Z

    .line 31
    iput-object p1, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mContext:Landroid/content/Context;

    .line 32
    return-void
.end method

.method private tryUnregister()V
    .locals 1

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->isRegistered:Z

    if-nez v0, :cond_1

    .line 115
    :cond_0
    :goto_0
    return-void

    .line 111
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mNetworkListenerList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mContext:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 113
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->isRegistered:Z

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 37
    monitor-enter p0

    :try_start_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v3

    if-nez v3, :cond_1

    .line 71
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 40
    :cond_1
    :try_start_1
    const-string/jumbo v3, "noConnectivity"

    const/4 v4, 0x1

    invoke-virtual {p2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    if-nez v3, :cond_0

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 45
    .local v0, "completedListenerList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/utils/NetworkListener;>;"
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/utils/NetworkManager;->isWifiConnected()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 46
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mNetworkListenerList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/utils/NetworkListener;

    .line 47
    .local v2, "listener":Lcom/amazon/device/utils/NetworkListener;
    invoke-interface {v2}, Lcom/amazon/device/utils/NetworkListener;->onWifiAvailable()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 48
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 37
    .end local v0    # "completedListenerList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/utils/NetworkListener;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 52
    .restart local v0    # "completedListenerList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/utils/NetworkListener;>;"
    :cond_3
    :try_start_2
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/utils/NetworkManager;->isEthernetConnected()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 53
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mNetworkListenerList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_4
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/utils/NetworkListener;

    .line 54
    .restart local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    invoke-interface {v2}, Lcom/amazon/device/utils/NetworkListener;->onEthernetAvailable()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 55
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 58
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    :cond_5
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/utils/NetworkManager;->isWanConnected()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 59
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mNetworkListenerList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_6
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/utils/NetworkListener;

    .line 60
    .restart local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    invoke-interface {v2}, Lcom/amazon/device/utils/NetworkListener;->onWanAvailable()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 61
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 66
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    :cond_7
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/utils/NetworkListener;

    .line 67
    .restart local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->mNetworkListenerList:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_4

    .line 70
    .end local v2    # "listener":Lcom/amazon/device/utils/NetworkListener;
    :cond_8
    invoke-direct {p0}, Lcom/amazon/device/utils/NetworkBroadcastReceiver;->tryUnregister()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_0
.end method
