.class Lcom/amazon/sdk/availability/Connectivity;
.super Ljava/lang/Object;
.source "Connectivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/Connectivity$Network;
    }
.end annotation


# instance fields
.field private hasEthernet:Z

.field private hasMobile:Z

.field private hasWifi:Z


# direct methods
.method public constructor <init>(Landroid/net/ConnectivityManager;)V
    .locals 6
    .param p1, "cm"    # Landroid/net/ConnectivityManager;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    if-eqz p1, :cond_3

    .line 41
    invoke-virtual {p1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 46
    .local v1, "networkInfo":Landroid/net/NetworkInfo;
    :goto_0
    const/4 v2, 0x0

    .line 48
    .local v2, "networkType":I
    iput-boolean v5, p0, Lcom/amazon/sdk/availability/Connectivity;->hasWifi:Z

    .line 49
    iput-boolean v5, p0, Lcom/amazon/sdk/availability/Connectivity;->hasEthernet:Z

    .line 51
    if-eqz p1, :cond_4

    move v3, v4

    :goto_1
    iput-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasMobile:Z

    .line 53
    if-eqz v1, :cond_2

    .line 54
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 55
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    .line 56
    if-eq v2, v4, :cond_0

    const/4 v3, 0x6

    if-ne v2, v3, :cond_5

    :cond_0
    move v3, v4

    :goto_2
    iput-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasWifi:Z

    .line 58
    if-eqz v2, :cond_1

    const/4 v3, 0x4

    if-eq v2, v3, :cond_1

    const/4 v3, 0x5

    if-eq v2, v3, :cond_1

    const/4 v3, 0x2

    if-eq v2, v3, :cond_1

    const/4 v3, 0x3

    if-ne v2, v3, :cond_6

    :cond_1
    move v3, v4

    :goto_3
    iput-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasMobile:Z

    .line 63
    const/16 v3, 0x9

    if-ne v2, v3, :cond_7

    move v3, v4

    :goto_4
    iput-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasEthernet:Z

    .line 72
    :cond_2
    :goto_5
    iget-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasWifi:Z

    if-eqz v3, :cond_9

    .line 73
    const-string/jumbo v0, "On Wifi"

    .line 81
    .local v0, "description":Ljava/lang/String;
    :goto_6
    const-string/jumbo v3, "Device Connectivity (%s)"

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 82
    return-void

    .line 43
    .end local v0    # "description":Ljava/lang/String;
    .end local v1    # "networkInfo":Landroid/net/NetworkInfo;
    .end local v2    # "networkType":I
    :cond_3
    const/4 v1, 0x0

    .restart local v1    # "networkInfo":Landroid/net/NetworkInfo;
    goto :goto_0

    .restart local v2    # "networkType":I
    :cond_4
    move v3, v5

    .line 51
    goto :goto_1

    :cond_5
    move v3, v5

    .line 56
    goto :goto_2

    :cond_6
    move v3, v5

    .line 58
    goto :goto_3

    :cond_7
    move v3, v5

    .line 63
    goto :goto_4

    .line 67
    :cond_8
    iput-boolean v5, p0, Lcom/amazon/sdk/availability/Connectivity;->hasMobile:Z

    goto :goto_5

    .line 74
    :cond_9
    iget-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasMobile:Z

    if-eqz v3, :cond_a

    .line 75
    const-string/jumbo v0, "On mobile"

    .restart local v0    # "description":Ljava/lang/String;
    goto :goto_6

    .line 76
    .end local v0    # "description":Ljava/lang/String;
    :cond_a
    iget-boolean v3, p0, Lcom/amazon/sdk/availability/Connectivity;->hasEthernet:Z

    if-eqz v3, :cond_b

    .line 77
    const-string/jumbo v0, "On Ethernet"

    .restart local v0    # "description":Ljava/lang/String;
    goto :goto_6

    .line 79
    .end local v0    # "description":Ljava/lang/String;
    :cond_b
    const-string/jumbo v0, "No network connectivity."

    .restart local v0    # "description":Ljava/lang/String;
    goto :goto_6
.end method


# virtual methods
.method public hasEthernet()Z
    .locals 1

    .prologue
    .line 115
    iget-boolean v0, p0, Lcom/amazon/sdk/availability/Connectivity;->hasEthernet:Z

    return v0
.end method

.method public hasMobile()Z
    .locals 1

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/amazon/sdk/availability/Connectivity;->hasMobile:Z

    return v0
.end method

.method public hasWifi()Z
    .locals 1

    .prologue
    .line 99
    iget-boolean v0, p0, Lcom/amazon/sdk/availability/Connectivity;->hasWifi:Z

    return v0
.end method
