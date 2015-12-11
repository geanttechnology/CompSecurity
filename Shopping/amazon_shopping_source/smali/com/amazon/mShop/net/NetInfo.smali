.class public Lcom/amazon/mShop/net/NetInfo;
.super Ljava/lang/Object;
.source "NetInfo.java"


# static fields
.field private static final DEBUG:Z

.field private static final sNetworkConnectionMonitor:Ljava/lang/Object;

.field private static sNetworkInfo:Landroid/net/NetworkInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 28
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v2

    sput-boolean v2, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    .line 237
    new-instance v0, Lcom/amazon/mShop/net/NetInfo$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/NetInfo$1;-><init>()V

    .line 255
    .local v0, "broadcastReceiver":Landroid/content/BroadcastReceiver;
    new-instance v1, Landroid/content/IntentFilter;

    const-string/jumbo v2, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 256
    .local v1, "filter":Landroid/content/IntentFilter;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 262
    new-instance v2, Ljava/lang/Object;

    invoke-direct {v2}, Ljava/lang/Object;-><init>()V

    sput-object v2, Lcom/amazon/mShop/net/NetInfo;->sNetworkConnectionMonitor:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Landroid/net/NetworkInfo;)V
    .locals 0
    .param p0, "x0"    # Landroid/net/NetworkInfo;

    .prologue
    .line 21
    invoke-static {p0}, Lcom/amazon/mShop/net/NetInfo;->setActiveNetworkInfo(Landroid/net/NetworkInfo;)V

    return-void
.end method

.method static synthetic access$100()V
    .locals 0

    .prologue
    .line 21
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->collectNetworkInfoCosting()V

    return-void
.end method

.method private static collectNetworkInfoCosting()V
    .locals 3

    .prologue
    .line 223
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    .line 225
    .local v0, "sTopActivity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz v0, :cond_1

    .line 226
    sget-boolean v1, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 227
    const-class v1, Lcom/amazon/mShop/net/NetInfo;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Network collection network type changed"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 229
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->logTimeWhenNetworkTypeChanged()V

    .line 231
    :cond_1
    return-void
.end method

.method public static getActiveNetworkInfo()Landroid/net/NetworkInfo;
    .locals 6

    .prologue
    .line 176
    sget-object v4, Lcom/amazon/mShop/net/NetInfo;->sNetworkConnectionMonitor:Ljava/lang/Object;

    monitor-enter v4

    .line 177
    :try_start_0
    sget-object v3, Lcom/amazon/mShop/net/NetInfo;->sNetworkInfo:Landroid/net/NetworkInfo;

    if-nez v3, :cond_0

    .line 178
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 180
    .local v0, "applicationContext":Landroid/content/Context;
    :try_start_1
    const-string/jumbo v3, "connectivity"

    invoke-virtual {v0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    .line 183
    .local v1, "connectivity":Landroid/net/ConnectivityManager;
    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/net/NetInfo;->setActiveNetworkInfo(Landroid/net/NetworkInfo;)V
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 190
    .end local v1    # "connectivity":Landroid/net/ConnectivityManager;
    :cond_0
    :goto_0
    :try_start_2
    sget-object v3, Lcom/amazon/mShop/net/NetInfo;->sNetworkInfo:Landroid/net/NetworkInfo;

    monitor-exit v4

    return-object v3

    .line 184
    :catch_0
    move-exception v2

    .line 186
    .local v2, "e":Ljava/lang/SecurityException;
    sget-boolean v3, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 187
    const-string/jumbo v3, "Amazon"

    invoke-virtual {v2}, Ljava/lang/SecurityException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 191
    .end local v2    # "e":Ljava/lang/SecurityException;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method public static final getCurrentCarrierName()Ljava/lang/String;
    .locals 9

    .prologue
    .line 40
    const-string/jumbo v1, "unknown"

    .line 41
    .local v1, "carrier":Ljava/lang/String;
    const/4 v2, 0x0

    .line 42
    .local v2, "hasConnection":Z
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 43
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v3

    .line 44
    .local v3, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 45
    const/4 v2, 0x1

    .line 46
    const/4 v6, 0x1

    invoke-virtual {v3}, Landroid/net/NetworkInfo;->getType()I

    move-result v7

    if-ne v6, v7, :cond_0

    .line 47
    const-string/jumbo v1, "Wifi"

    .line 52
    :cond_0
    :goto_0
    if-eqz v2, :cond_3

    .line 53
    const-string/jumbo v6, "unknown"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 54
    const-string/jumbo v6, "phone"

    invoke-virtual {v0, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/telephony/TelephonyManager;

    .line 55
    .local v5, "telephonyManager":Landroid/telephony/TelephonyManager;
    invoke-virtual {v5}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v4

    .line 56
    .local v4, "operator":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 57
    move-object v1, v4

    .line 63
    .end local v4    # "operator":Ljava/lang/String;
    .end local v5    # "telephonyManager":Landroid/telephony/TelephonyManager;
    :cond_1
    :goto_1
    return-object v1

    .line 49
    :cond_2
    const-string/jumbo v6, "Amazon"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "getActiveNetworkInfo: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 61
    :cond_3
    const-string/jumbo v1, "none"

    goto :goto_1
.end method

.method public static getNetworkType()Ljava/lang/String;
    .locals 6

    .prologue
    .line 74
    const-string/jumbo v1, "none"

    .line 75
    .local v1, "carrier":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 76
    .local v0, "activeNetwork":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v3

    if-nez v3, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-object v1

    .line 79
    :cond_1
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    .line 80
    .local v2, "type":I
    const/4 v3, 0x1

    if-ne v3, v2, :cond_4

    .line 81
    const-string/jumbo v1, "Wifi"

    .line 91
    :goto_1
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 92
    const-string/jumbo v1, "unknown"

    .line 96
    :cond_2
    const-string/jumbo v3, "+"

    invoke-virtual {v1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 99
    const-string/jumbo v3, "\\+"

    const-string/jumbo v4, "PLUS"

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 102
    :cond_3
    sget-boolean v3, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 103
    const-class v3, Lcom/amazon/mShop/net/NetInfo;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Network collection get the network type is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 83
    :cond_4
    if-nez v2, :cond_5

    .line 85
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtypeName()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 88
    :cond_5
    const-string/jumbo v1, "unknown"

    goto :goto_1
.end method

.method public static hasNetworkConnection()Z
    .locals 2

    .prologue
    .line 113
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 114
    .local v0, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static setActiveNetworkInfo(Landroid/net/NetworkInfo;)V
    .locals 4
    .param p0, "networkInfo"    # Landroid/net/NetworkInfo;

    .prologue
    .line 204
    sget-object v1, Lcom/amazon/mShop/net/NetInfo;->sNetworkConnectionMonitor:Ljava/lang/Object;

    monitor-enter v1

    .line 205
    :try_start_0
    sput-object p0, Lcom/amazon/mShop/net/NetInfo;->sNetworkInfo:Landroid/net/NetworkInfo;

    .line 207
    sget-boolean v0, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 208
    const-string/jumbo v0, "Amazon"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "NetworkInfo Changed"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 210
    :cond_0
    if-eqz p0, :cond_1

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 212
    sget-object v0, Lcom/amazon/mShop/net/NetInfo;->sNetworkConnectionMonitor:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    .line 214
    :cond_1
    monitor-exit v1

    .line 215
    return-void

    .line 214
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static waitForNetworkConnectivity()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/mShop/net/NetworkDisconnectedException;
        }
    .end annotation

    .prologue
    .line 292
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 295
    .local v1, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v2

    sget-object v3, Landroid/net/NetworkInfo$State;->DISCONNECTED:Landroid/net/NetworkInfo$State;

    if-ne v2, v3, :cond_1

    .line 296
    :cond_0
    new-instance v2, Lcom/amazon/mShop/net/NetworkDisconnectedException;

    invoke-direct {v2}, Lcom/amazon/mShop/net/NetworkDisconnectedException;-><init>()V

    throw v2

    .line 299
    :cond_1
    sget-object v3, Lcom/amazon/mShop/net/NetInfo;->sNetworkConnectionMonitor:Ljava/lang/Object;

    monitor-enter v3

    .line 301
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v2

    if-nez v2, :cond_4

    .line 302
    sget-boolean v2, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v2, :cond_2

    .line 303
    const-string/jumbo v2, "Amazon"

    const-string/jumbo v4, "waitForNetworkConnectivity START"

    invoke-static {v2, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 307
    :cond_2
    :try_start_1
    sget-object v2, Lcom/amazon/mShop/net/NetInfo;->sNetworkConnectionMonitor:Ljava/lang/Object;

    const-wide/16 v4, 0x2710

    invoke-virtual {v2, v4, v5}, Ljava/lang/Object;->wait(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 315
    :cond_3
    :goto_0
    :try_start_2
    sget-boolean v2, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v2, :cond_4

    .line 316
    const-string/jumbo v2, "Amazon"

    const-string/jumbo v4, "waitForNetworkConnectivity END"

    invoke-static {v2, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 319
    :cond_4
    monitor-exit v3

    .line 320
    return-void

    .line 308
    :catch_0
    move-exception v0

    .line 309
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-boolean v2, Lcom/amazon/mShop/net/NetInfo;->DEBUG:Z

    if-eqz v2, :cond_3

    .line 310
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    .line 311
    const-string/jumbo v2, "Amazon"

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 319
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method
