.class public Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
.super Landroid/content/BroadcastReceiver;
.source "LocalWifiMonitor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static PING_URL:Ljava/lang/String;

.field private static iAlarmHandler:Landroid/os/Handler;

.field private static iDisconnectedWifi:Z

.field private static iInstance:Ljava/lang/ref/SoftReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/SoftReference",
            "<",
            "Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;",
            ">;"
        }
    .end annotation
.end field

.field private static iResetRequested:Z

.field private static iUnknownHostCount:I


# instance fields
.field private iObservers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 31
    const-class v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    .line 38
    sput-boolean v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iDisconnectedWifi:Z

    .line 42
    sput v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iUnknownHostCount:I

    .line 43
    sput-boolean v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iResetRequested:Z

    .line 45
    const-string v0, "http://www.google.com"

    sput-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->PING_URL:Ljava/lang/String;

    .line 52
    sput-object v2, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iAlarmHandler:Landroid/os/Handler;

    .line 54
    sput-object v2, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iInstance:Ljava/lang/ref/SoftReference;

    .line 29
    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 55
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iObservers:Ljava/util/Vector;

    .line 61
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iObservers:Ljava/util/Vector;

    .line 62
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->SetupHandler()V

    .line 63
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->registerReceivers()V

    .line 64
    return-void
.end method

.method private RequestDelayedAlarm(I)V
    .locals 4
    .param p1, "millis"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "HandlerLeak"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 136
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iAlarmHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->removeMessages(I)V

    .line 137
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iAlarmHandler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 138
    .local v0, "msg":Landroid/os/Message;
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iAlarmHandler:Landroid/os/Handler;

    int-to-long v2, p1

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 139
    return-void
.end method

.method private SetupHandler()V
    .locals 1

    .prologue
    .line 88
    new-instance v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$1;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$1;-><init>(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V

    sput-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iAlarmHandler:Landroid/os/Handler;

    .line 103
    const v0, 0x249f0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->RequestDelayedAlarm(I)V

    .line 104
    return-void
.end method

.method static synthetic access$0(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V
    .locals 0

    .prologue
    .line 231
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleAlarm()V

    return-void
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->PING_URL:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 263
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->pingWifi(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$4(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V
    .locals 0

    .prologue
    .line 293
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->disconnectWifi()V

    return-void
.end method

.method static synthetic access$5(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;Z)V
    .locals 0

    .prologue
    .line 118
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->notifyObservers(Z)V

    return-void
.end method

.method static synthetic access$6(I)V
    .locals 0

    .prologue
    .line 42
    sput p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iUnknownHostCount:I

    return-void
.end method

.method static synthetic access$7(Z)V
    .locals 0

    .prologue
    .line 43
    sput-boolean p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iResetRequested:Z

    return-void
.end method

.method private disconnectWifi()V
    .locals 7

    .prologue
    .line 295
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 298
    .local v0, "context":Landroid/content/Context;
    const-string v4, "wifi"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/wifi/WifiManager;

    .line 299
    .local v3, "theMan":Landroid/net/wifi/WifiManager;
    if-nez v3, :cond_1

    .line 300
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v5, "disconnectWifi(): Could not access the Wifi manager"

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 325
    :cond_0
    :goto_0
    return-void

    .line 305
    :cond_1
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->isWifiEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 309
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/wifi/WifiInfo;->getSupplicantState()Landroid/net/wifi/SupplicantState;

    move-result-object v2

    .line 310
    .local v2, "supplicantState":Landroid/net/wifi/SupplicantState;
    if-nez v2, :cond_2

    .line 311
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v5, "disconnectWifi(): Could not access supplicant state"

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 315
    :cond_2
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "disconnectWifi(): supplicantState"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 318
    :try_start_0
    sget-object v4, Landroid/net/wifi/SupplicantState;->DISCONNECTED:Landroid/net/wifi/SupplicantState;

    if-eq v2, v4, :cond_0

    .line 319
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->disconnect()Z

    .line 320
    const/4 v4, 0x1

    sput-boolean v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iDisconnectedWifi:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 322
    :catch_0
    move-exception v1

    .line 323
    .local v1, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "disconnectWifi(): Caught exception disconnecting WIFI"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private handleAlarm()V
    .locals 4

    .prologue
    .line 233
    sget v2, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iUnknownHostCount:I

    const/4 v3, 0x3

    if-ge v2, v3, :cond_0

    sget-boolean v2, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iResetRequested:Z

    if-eqz v2, :cond_1

    .line 235
    :cond_0
    new-instance v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;-><init>(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V

    .line 249
    .local v0, "r":Ljava/lang/Runnable;
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 250
    .local v1, "t":Ljava/lang/Thread;
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 252
    .end local v0    # "r":Ljava/lang/Runnable;
    .end local v1    # "t":Ljava/lang/Thread;
    :cond_1
    const v2, 0x249f0

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->RequestDelayedAlarm(I)V

    .line 253
    return-void
.end method

.method private handleConnectionGain(Landroid/net/NetworkInfo;)V
    .locals 2
    .param p1, "netInfo"    # Landroid/net/NetworkInfo;

    .prologue
    .line 216
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->getType()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 217
    const/4 v0, 0x0

    sput-boolean v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iDisconnectedWifi:Z

    .line 218
    :cond_0
    return-void
.end method

.method private handleConnectionLoss()V
    .locals 2

    .prologue
    .line 202
    sget-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v1, "handleConnectionLoss()"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    sget-boolean v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iDisconnectedWifi:Z

    if-eqz v0, :cond_0

    .line 204
    sget-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v1, "attempting reconnect()"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->reconnectWifi()V

    .line 207
    :cond_0
    return-void
.end method

.method private handleConnectivity()V
    .locals 4

    .prologue
    .line 179
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 180
    .local v1, "context":Landroid/content/Context;
    if-nez v1, :cond_1

    .line 194
    :cond_0
    :goto_0
    return-void

    .line 182
    :cond_1
    const-string v3, "connectivity"

    invoke-virtual {v1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 183
    .local v0, "cm":Landroid/net/ConnectivityManager;
    if-eqz v0, :cond_0

    .line 186
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v2

    .line 189
    .local v2, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v3

    if-nez v3, :cond_3

    .line 190
    :cond_2
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleConnectionLoss()V

    goto :goto_0

    .line 192
    :cond_3
    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleConnectionGain(Landroid/net/NetworkInfo;)V

    goto :goto_0
.end method

.method private handleReset()V
    .locals 1

    .prologue
    .line 287
    const/4 v0, 0x1

    sput-boolean v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iResetRequested:Z

    .line 288
    return-void
.end method

.method private handleUnknownHost()V
    .locals 1

    .prologue
    .line 225
    sget v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iUnknownHostCount:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iUnknownHostCount:I

    .line 226
    return-void
.end method

.method public static declared-synchronized instance()Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
    .locals 3

    .prologue
    .line 68
    const-class v2, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    monitor-enter v2

    const/4 v0, 0x0

    .line 69
    .local v0, "instance":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iInstance:Ljava/lang/ref/SoftReference;

    if-eqz v1, :cond_0

    .line 70
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iInstance:Ljava/lang/ref/SoftReference;

    invoke-virtual {v1}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
    check-cast v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    .line 73
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
    :cond_0
    if-nez v0, :cond_1

    .line 74
    new-instance v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    .end local v0    # "instance":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
    invoke-direct {v0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;-><init>()V

    .line 75
    .restart local v0    # "instance":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;
    new-instance v1, Ljava/lang/ref/SoftReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    sput-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iInstance:Ljava/lang/ref/SoftReference;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    :cond_1
    monitor-exit v2

    return-object v0

    .line 68
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method private notifyObservers(Z)V
    .locals 3
    .param p1, "b"    # Z

    .prologue
    .line 120
    monitor-enter p0

    .line 122
    :try_start_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 123
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 120
    monitor-exit p0

    .line 132
    return-void

    .line 125
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;

    .line 126
    .local v1, "obs":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;
    if-eqz v1, :cond_0

    .line 128
    invoke-interface {v1, p1}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;->isOkay(Z)V

    goto :goto_0

    .line 120
    .end local v0    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;>;"
    .end local v1    # "obs":Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private pingWifi(Ljava/lang/String;)Z
    .locals 8
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    const/16 v6, 0x7530

    const/4 v5, 0x0

    .line 266
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v3, p1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 269
    .local v3, "method":Lorg/apache/http/client/methods/HttpGet;
    new-instance v2, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v2}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 270
    .local v2, "httpParams":Lorg/apache/http/params/HttpParams;
    invoke-static {v2, v6}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 271
    invoke-static {v2, v6}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 272
    new-instance v0, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v0, v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    .line 275
    .local v0, "client":Lorg/apache/http/impl/client/DefaultHttpClient;
    const/4 v4, 0x0

    .line 277
    .local v4, "response":Lorg/apache/http/HttpResponse;
    :try_start_0
    invoke-virtual {v0, v3}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 283
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v6

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v6

    const/16 v7, 0xc8

    if-ne v6, v7, :cond_0

    const/4 v5, 0x1

    :cond_0
    :goto_0
    return v5

    .line 278
    :catch_0
    move-exception v1

    .line 279
    .local v1, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method private reconnectWifi()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 332
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 335
    .local v0, "context":Landroid/content/Context;
    const-string v4, "wifi"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/wifi/WifiManager;

    .line 337
    .local v3, "theMan":Landroid/net/wifi/WifiManager;
    if-eqz v3, :cond_2

    .line 340
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/wifi/WifiInfo;->getSupplicantState()Landroid/net/wifi/SupplicantState;

    move-result-object v2

    .line 342
    .local v2, "supplicantState":Landroid/net/wifi/SupplicantState;
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->isWifiEnabled()Z

    move-result v4

    if-nez v4, :cond_0

    .line 343
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v5, "reconnectWifi(): Wifi not enabled"

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 357
    .end local v2    # "supplicantState":Landroid/net/wifi/SupplicantState;
    :goto_0
    sput-boolean v7, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iDisconnectedWifi:Z

    .line 358
    sput v7, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iUnknownHostCount:I

    .line 359
    return-void

    .line 344
    .restart local v2    # "supplicantState":Landroid/net/wifi/SupplicantState;
    :cond_0
    if-nez v2, :cond_1

    .line 345
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v5, "reconnectWifi(): Could not access supplicant state"

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 347
    :cond_1
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "reconnectWifi(): supplicantState"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 349
    :try_start_0
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->reassociate()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 350
    :catch_0
    move-exception v1

    .line 351
    .local v1, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "reconnectWifi(): Caught exception disconnecting WIFI"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 355
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "supplicantState":Landroid/net/wifi/SupplicantState;
    :cond_2
    sget-object v4, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    const-string v5, "reconnectWifi(): Could not access the Wifi manager"

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private registerReceivers()V
    .locals 2

    .prologue
    .line 81
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "virtuoso.intent.action.WIFI_RESET"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {p0, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 82
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "virtuoso.intent.action.UNKNOWN_HOST"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {p0, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 84
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {p0, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 85
    return-void
.end method


# virtual methods
.method public declared-synchronized addObserver(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;)V
    .locals 1
    .param p1, "aObserver"    # Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;

    .prologue
    .line 107
    monitor-enter p0

    if-eqz p1, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 111
    :cond_0
    monitor-exit p0

    return-void

    .line 107
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
    .line 364
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iObservers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 365
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 366
    return-void
.end method

.method public declared-synchronized onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 154
    monitor-enter p0

    const/16 v1, 0x3a98

    :try_start_0
    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->RequestDelayedAlarm(I)V

    .line 155
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 156
    .local v0, "action":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 171
    :goto_0
    monitor-exit p0

    return-void

    .line 159
    :cond_0
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "WifiMonitor(): received action: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 161
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleConnectivity()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 154
    .end local v0    # "action":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 162
    .restart local v0    # "action":Ljava/lang/String;
    :cond_1
    :try_start_2
    const-string v1, "virtuoso.intent.action.UNKNOWN_HOST"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 163
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleUnknownHost()V

    goto :goto_0

    .line 164
    :cond_2
    const-string v1, "virtuoso.intent.action.WIFI_MONITOR_ALARM"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 165
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleAlarm()V

    goto :goto_0

    .line 166
    :cond_3
    const-string v1, "virtuoso.intent.action.WIFI_RESET"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 167
    invoke-direct {p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleReset()V

    goto :goto_0

    .line 169
    :cond_4
    sget-object v1, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "WifiMonitor(): Unknown broadcast action: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public release()V
    .locals 2

    .prologue
    .line 143
    :try_start_0
    invoke-static {p0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->unregisterLocalReceiver(Landroid/content/BroadcastReceiver;)V

    .line 144
    invoke-static {p0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 146
    :goto_0
    sget-object v0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->iAlarmHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 147
    return-void

    .line 145
    :catch_0
    move-exception v0

    goto :goto_0
.end method
