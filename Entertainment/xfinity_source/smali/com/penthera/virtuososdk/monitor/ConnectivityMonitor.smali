.class public final Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
.super Landroid/content/BroadcastReceiver;
.source "ConnectivityMonitor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;
    }
.end annotation


# static fields
.field private static iInstance:Ljava/lang/ref/SoftReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/SoftReference",
            "<",
            "Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private iObservers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    sput-object v0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iInstance:Ljava/lang/ref/SoftReference;

    .line 16
    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    .line 56
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    .line 57
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
    .locals 3

    .prologue
    .line 39
    const-class v2, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

    monitor-enter v2

    const/4 v0, 0x0

    .line 40
    .local v0, "instance":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iInstance:Ljava/lang/ref/SoftReference;

    if-eqz v1, :cond_0

    .line 41
    sget-object v1, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iInstance:Ljava/lang/ref/SoftReference;

    invoke-virtual {v1}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
    check-cast v0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

    .line 44
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
    :cond_0
    if-nez v0, :cond_1

    .line 45
    new-instance v0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
    invoke-direct {v0}, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;-><init>()V

    .line 46
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;
    new-instance v1, Ljava/lang/ref/SoftReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    sput-object v1, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iInstance:Ljava/lang/ref/SoftReference;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 48
    :cond_1
    monitor-exit v2

    return-object v0

    .line 39
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method private notifyObservers(Landroid/net/NetworkInfo;)V
    .locals 3
    .param p1, "aActiveNetworkInfo"    # Landroid/net/NetworkInfo;

    .prologue
    .line 107
    monitor-enter p0

    .line 109
    :try_start_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 110
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 107
    monitor-exit p0

    .line 119
    return-void

    .line 112
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;

    .line 113
    .local v1, "obs":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;
    if-eqz v1, :cond_0

    .line 115
    invoke-interface {v1, p1}, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;->onConnectivityChange(Landroid/net/NetworkInfo;)V

    goto :goto_0

    .line 107
    .end local v0    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;>;"
    .end local v1    # "obs":Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method


# virtual methods
.method public declared-synchronized addObserver(Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;)V
    .locals 3
    .param p1, "aObserver"    # Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;

    .prologue
    .line 62
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 63
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 66
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 68
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 71
    :cond_1
    monitor-exit p0

    return-void

    .line 62
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected finalize()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 92
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 93
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 98
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 100
    const-string v1, "connectivity"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 101
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->notifyObservers(Landroid/net/NetworkInfo;)V

    .line 103
    .end local v0    # "cm":Landroid/net/ConnectivityManager;
    :cond_0
    return-void
.end method
