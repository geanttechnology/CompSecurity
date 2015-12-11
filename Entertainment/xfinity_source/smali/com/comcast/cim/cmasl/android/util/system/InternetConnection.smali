.class public Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
.super Ljava/lang/Object;
.source "InternetConnection.java"


# instance fields
.field private connectivityManager:Landroid/net/ConnectivityManager;

.field private telephonyManager:Landroid/telephony/TelephonyManager;


# direct methods
.method public constructor <init>(Landroid/net/ConnectivityManager;Landroid/telephony/TelephonyManager;)V
    .locals 0
    .param p1, "connectivityManager"    # Landroid/net/ConnectivityManager;
    .param p2, "telephonyManager"    # Landroid/telephony/TelephonyManager;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->connectivityManager:Landroid/net/ConnectivityManager;

    .line 14
    iput-object p2, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->telephonyManager:Landroid/telephony/TelephonyManager;

    .line 15
    return-void
.end method

.method private mobileNetworkIsHighspeed()Z
    .locals 2

    .prologue
    .line 41
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->telephonyManager:Landroid/telephony/TelephonyManager;

    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getNetworkType()I

    move-result v0

    .line 42
    .local v0, "mobileNetwork":I
    const/16 v1, 0xd

    if-eq v0, v1, :cond_0

    const/16 v1, 0xf

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public isConnected()Z
    .locals 2

    .prologue
    .line 18
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 19
    .local v0, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isConnectedNotOnWiFi()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 28
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v2}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 29
    .local v0, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    if-eq v2, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isConnectedOnHighspeedMobile()Z
    .locals 2

    .prologue
    .line 33
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 34
    .local v0, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    if-nez v1, :cond_0

    .line 35
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->mobileNetworkIsHighspeed()Z

    move-result v1

    .line 37
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isConnectedOnWiFi()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 23
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->connectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v2}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 24
    .local v0, "netInfo":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    if-ne v2, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
