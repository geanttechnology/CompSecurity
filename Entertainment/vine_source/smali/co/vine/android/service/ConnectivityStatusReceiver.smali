.class public Lco/vine/android/service/ConnectivityStatusReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ConnectivityStatusReceiver.java"


# static fields
.field private static sLastTypeChanged:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, -0x1

    sput v0, Lco/vine/android/service/ConnectivityStatusReceiver;->sLastTypeChanged:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 16
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 23
    :try_start_0
    const-string v12, "connectivity"

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/ConnectivityManager;

    .line 25
    .local v3, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v3}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 26
    .local v1, "activeNetwork":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v12

    if-eqz v12, :cond_0

    sget v12, Lco/vine/android/service/ConnectivityStatusReceiver;->sLastTypeChanged:I

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v13

    if-eq v12, v13, :cond_0

    .line 28
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v7

    .line 30
    .local v7, "networkType":I
    invoke-static/range {p1 .. p1}, Lco/vine/android/util/ClientFlagsHelper;->isClientFlagsTtlInRange(Landroid/content/Context;)Z

    move-result v11

    .line 31
    .local v11, "ttlIsInRange":Z
    invoke-static/range {p1 .. p1}, Lco/vine/android/util/ClientFlagsHelper;->getLastCheckMillis(Landroid/content/Context;)J

    move-result-wide v5

    .line 32
    .local v5, "lastChecked":J
    const-wide/32 v9, 0x493e0

    .line 33
    .local v9, "throttle":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    sub-long/2addr v12, v5

    const-wide/32 v14, 0x493e0

    cmp-long v12, v12, v14

    if-gez v12, :cond_1

    const/4 v8, 0x1

    .line 35
    .local v8, "rateLimitClientFlagsFetch":Z
    :goto_0
    if-nez v7, :cond_0

    .line 36
    invoke-static/range {p1 .. p1}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v2

    .line 37
    .local v2, "appController":Lco/vine/android/client/AppController;
    invoke-virtual {v2}, Lco/vine/android/client/AppController;->onMobileDataNetworkActivated()V

    .line 38
    if-nez v11, :cond_0

    if-nez v8, :cond_0

    .line 39
    const/4 v12, 0x1

    invoke-virtual {v2, v12}, Lco/vine/android/client/AppController;->fetchClientFlags(Z)V

    .line 46
    .end local v2    # "appController":Lco/vine/android/client/AppController;
    .end local v5    # "lastChecked":J
    .end local v7    # "networkType":I
    .end local v8    # "rateLimitClientFlagsFetch":Z
    .end local v9    # "throttle":J
    .end local v11    # "ttlIsInRange":Z
    :cond_0
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v12

    :goto_1
    sput v12, Lco/vine/android/service/ConnectivityStatusReceiver;->sLastTypeChanged:I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 51
    .end local v1    # "activeNetwork":Landroid/net/NetworkInfo;
    .end local v3    # "cm":Landroid/net/ConnectivityManager;
    :goto_2
    return-void

    .line 33
    .restart local v1    # "activeNetwork":Landroid/net/NetworkInfo;
    .restart local v3    # "cm":Landroid/net/ConnectivityManager;
    .restart local v5    # "lastChecked":J
    .restart local v7    # "networkType":I
    .restart local v9    # "throttle":J
    .restart local v11    # "ttlIsInRange":Z
    :cond_1
    const/4 v8, 0x0

    goto :goto_0

    .line 46
    .end local v5    # "lastChecked":J
    .end local v7    # "networkType":I
    .end local v9    # "throttle":J
    .end local v11    # "ttlIsInRange":Z
    :cond_2
    const/4 v12, -0x1

    goto :goto_1

    .line 47
    .end local v1    # "activeNetwork":Landroid/net/NetworkInfo;
    .end local v3    # "cm":Landroid/net/ConnectivityManager;
    :catch_0
    move-exception v4

    .line 49
    .local v4, "e":Ljava/lang/Throwable;
    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_2
.end method
