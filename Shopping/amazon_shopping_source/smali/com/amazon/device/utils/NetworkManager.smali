.class public Lcom/amazon/device/utils/NetworkManager;
.super Ljava/lang/Object;
.source "NetworkManager.java"


# static fields
.field private static final TYPE_WAN_LIST:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static sNetworkManager:Lcom/amazon/device/utils/NetworkManager;


# instance fields
.field private final mConnectivityManager:Landroid/net/ConnectivityManager;

.field private final mContext:Landroid/content/Context;

.field private final mNetworkBroadcastReceiver:Lcom/amazon/device/utils/NetworkBroadcastReceiver;

.field private final mPowerManager:Landroid/os/PowerManager;

.field private final mWifiManager:Landroid/net/wifi/WifiManager;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x5

    const/4 v5, 0x4

    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x0

    .line 28
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/Integer;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v2

    const/4 v1, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v5

    const/4 v1, 0x6

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v6

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/utils/NetworkManager;->TYPE_WAN_LIST:Ljava/util/List;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/amazon/device/utils/NetworkManager;->mContext:Landroid/content/Context;

    .line 45
    const-string/jumbo v0, "connectivity"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mConnectivityManager:Landroid/net/ConnectivityManager;

    .line 46
    const-string/jumbo v0, "wifi"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    iput-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mWifiManager:Landroid/net/wifi/WifiManager;

    .line 47
    const-string/jumbo v0, "power"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    iput-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mPowerManager:Landroid/os/PowerManager;

    .line 48
    new-instance v0, Lcom/amazon/device/utils/NetworkBroadcastReceiver;

    iget-object v1, p0, Lcom/amazon/device/utils/NetworkManager;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/device/utils/NetworkBroadcastReceiver;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mNetworkBroadcastReceiver:Lcom/amazon/device/utils/NetworkBroadcastReceiver;

    .line 49
    return-void
.end method

.method public static declared-synchronized instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 62
    const-class v1, Lcom/amazon/device/utils/NetworkManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/device/utils/NetworkManager;->sNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    if-nez v0, :cond_0

    .line 63
    new-instance v0, Lcom/amazon/device/utils/NetworkManager;

    invoke-direct {v0, p0}, Lcom/amazon/device/utils/NetworkManager;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/device/utils/NetworkManager;->sNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    .line 66
    :cond_0
    sget-object v0, Lcom/amazon/device/utils/NetworkManager;->sNetworkManager:Lcom/amazon/device/utils/NetworkManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 62
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private isConnectedToType(Landroid/net/NetworkInfo;Ljava/lang/Integer;)Z
    .locals 2
    .param p1, "networkInfo"    # Landroid/net/NetworkInfo;
    .param p2, "type"    # Ljava/lang/Integer;

    .prologue
    .line 168
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public acquireWakeLock(Landroid/os/PowerManager$WakeLock;)V
    .locals 0
    .param p1, "wakeLock"    # Landroid/os/PowerManager$WakeLock;

    .prologue
    .line 153
    if-eqz p1, :cond_0

    .line 154
    invoke-virtual {p1}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 156
    :cond_0
    return-void
.end method

.method public acquireWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V
    .locals 0
    .param p1, "wifiLock"    # Landroid/net/wifi/WifiManager$WifiLock;

    .prologue
    .line 123
    if-eqz p1, :cond_0

    .line 124
    invoke-virtual {p1}, Landroid/net/wifi/WifiManager$WifiLock;->acquire()V

    .line 126
    :cond_0
    return-void
.end method

.method public createWakeLock(Ljava/lang/String;)Landroid/os/PowerManager$WakeLock;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mPowerManager:Landroid/os/PowerManager;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mPowerManager:Landroid/os/PowerManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p1}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    .line 145
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public createWifiLock(Ljava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mWifiManager:Landroid/net/wifi/WifiManager;

    if-eqz v0, :cond_0

    .line 113
    iget-object v0, p0, Lcom/amazon/device/utils/NetworkManager;->mWifiManager:Landroid/net/wifi/WifiManager;

    const/4 v1, 0x3

    invoke-virtual {v0, v1, p1}, Landroid/net/wifi/WifiManager;->createWifiLock(ILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;

    move-result-object v0

    .line 115
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEthernetConnected()Z
    .locals 2

    .prologue
    .line 87
    iget-object v1, p0, Lcom/amazon/device/utils/NetworkManager;->mConnectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 88
    .local v0, "networkInfo":Landroid/net/NetworkInfo;
    const/16 v1, 0x9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/device/utils/NetworkManager;->isConnectedToType(Landroid/net/NetworkInfo;Ljava/lang/Integer;)Z

    move-result v1

    return v1
.end method

.method public isWanConnected()Z
    .locals 4

    .prologue
    .line 93
    iget-object v3, p0, Lcom/amazon/device/utils/NetworkManager;->mConnectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v3}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 94
    .local v1, "networkInfo":Landroid/net/NetworkInfo;
    sget-object v3, Lcom/amazon/device/utils/NetworkManager;->TYPE_WAN_LIST:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    .line 95
    .local v2, "type":Ljava/lang/Integer;
    invoke-direct {p0, v1, v2}, Lcom/amazon/device/utils/NetworkManager;->isConnectedToType(Landroid/net/NetworkInfo;Ljava/lang/Integer;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 96
    const/4 v3, 0x1

    .line 100
    .end local v2    # "type":Ljava/lang/Integer;
    :goto_0
    return v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public isWifiConnected()Z
    .locals 2

    .prologue
    .line 82
    iget-object v1, p0, Lcom/amazon/device/utils/NetworkManager;->mConnectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 83
    .local v0, "networkInfo":Landroid/net/NetworkInfo;
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/amazon/device/utils/NetworkManager;->isConnectedToType(Landroid/net/NetworkInfo;Ljava/lang/Integer;)Z

    move-result v1

    return v1
.end method

.method public releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V
    .locals 0
    .param p1, "wakeLock"    # Landroid/os/PowerManager$WakeLock;

    .prologue
    .line 162
    if-eqz p1, :cond_0

    .line 163
    invoke-virtual {p1}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 165
    :cond_0
    return-void
.end method

.method public releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V
    .locals 0
    .param p1, "wifiLock"    # Landroid/net/wifi/WifiManager$WifiLock;

    .prologue
    .line 132
    if-eqz p1, :cond_0

    .line 133
    invoke-virtual {p1}, Landroid/net/wifi/WifiManager$WifiLock;->release()V

    .line 135
    :cond_0
    return-void
.end method
