.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$NetworkHelpers;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "NetworkHelpers"
.end annotation


# direct methods
.method public static dump(Landroid/net/NetworkInfo;)V
    .locals 3
    .param p0, "nInfo"    # Landroid/net/NetworkInfo;

    .prologue
    .line 533
    if-nez p0, :cond_0

    .line 534
    const-string v0, "NetworkHelpers"

    const-string v1, "NetworkInfo is null: There is no connection"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 548
    :goto_0
    return-void

    .line 538
    :cond_0
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "isAvailable: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 539
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "isConnected: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 540
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "isConnectedOrConnecting: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 541
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "isRoaming: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isRoaming()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 542
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "getState: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 543
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "getDetailedState: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->getDetailedState()Landroid/net/NetworkInfo$DetailedState;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 544
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "getReason: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->getReason()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 545
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "getTypeName: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 546
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "getSubTypeName: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->getSubtypeName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 547
    const-string v0, "NetworkHelpers"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "isFailOver: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/NetworkInfo;->isFailover()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public static dump(Landroid/net/wifi/WifiManager;)V
    .locals 4
    .param p0, "theMan"    # Landroid/net/wifi/WifiManager;

    .prologue
    .line 557
    if-nez p0, :cond_0

    .line 558
    :try_start_0
    const-string v1, "NetworkHelpers"

    const-string v2, "WifiManager is null: There is no WIFI"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 568
    :goto_0
    return-void

    .line 562
    :cond_0
    const-string v1, "NetworkHelpers"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "isWifiEnabled: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/wifi/WifiManager;->isWifiEnabled()Z

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 563
    const-string v1, "NetworkHelpers"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "getWifiState: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v3

    invoke-static {v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$NetworkHelpers;->wifiStateToString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 564
    const-string v1, "NetworkHelpers"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "getConnectionInfo: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 565
    :catch_0
    move-exception v0

    .line 566
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "NetworkHelpers"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Caught exception taking a dump: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static isCell(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 478
    const-string v3, "connectivity"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 479
    .local v0, "cm":Landroid/net/ConnectivityManager;
    if-nez v0, :cond_1

    .line 486
    :cond_0
    :goto_0
    return v2

    .line 482
    :cond_1
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 483
    .local v1, "nInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    .line 486
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    if-nez v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0
.end method

.method public static wifiStateToString(I)Ljava/lang/String;
    .locals 1
    .param p0, "state"    # I

    .prologue
    .line 578
    packed-switch p0, :pswitch_data_0

    .line 591
    const-string v0, "WHOPPER_JAWED"

    :goto_0
    return-object v0

    .line 581
    :pswitch_0
    const-string v0, "WIFI_STATE_DISABLED"

    goto :goto_0

    .line 583
    :pswitch_1
    const-string v0, "WIFI_STATE_DISABLING"

    goto :goto_0

    .line 585
    :pswitch_2
    const-string v0, "WIFI_STATE_ENABLED"

    goto :goto_0

    .line 587
    :pswitch_3
    const-string v0, "WIFI_STATE_ENABLING"

    goto :goto_0

    .line 589
    :pswitch_4
    const-string v0, "WIFI_STATE_UNKNOWN"

    goto :goto_0

    .line 578
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_4
    .end packed-switch
.end method
