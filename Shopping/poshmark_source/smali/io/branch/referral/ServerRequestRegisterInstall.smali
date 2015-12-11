.class Lio/branch/referral/ServerRequestRegisterInstall;
.super Lio/branch/referral/ServerRequestInitSession;
.source "ServerRequestRegisterInstall.java"


# instance fields
.field callback_:Lio/branch/referral/Branch$BranchReferralInitListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Lio/branch/referral/SystemObserver;Ljava/lang/String;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p3, "sysObserver"    # Lio/branch/referral/SystemObserver;
    .param p4, "installID"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    .line 31
    sget-object v5, Lio/branch/referral/Defines$RequestPath;->RegisterInstall:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v5}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, p1, v5}, Lio/branch/referral/ServerRequestInitSession;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 33
    iput-object p2, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 34
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 36
    .local v2, "installPost":Lorg/json/JSONObject;
    :try_start_0
    const-string v5, "bnc_no_value"

    invoke-virtual {p4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 37
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5, p4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 38
    :cond_0
    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->getExternDebug()Z

    move-result v5

    invoke-virtual {p3, v5}, Lio/branch/referral/SystemObserver;->getUniqueID(Z)Ljava/lang/String;

    move-result-object v3

    .line 39
    .local v3, "uniqId":Ljava/lang/String;
    const-string v5, "bnc_no_value"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 40
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->HardwareID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 41
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->IsHardwareIDReal:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->hasRealHardwareId()Z

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 43
    :cond_1
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getAppVersion()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 44
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->AppVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getAppVersion()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 45
    :cond_2
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getCarrier()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 46
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Carrier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getCarrier()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 47
    :cond_3
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0xb

    if-lt v5, v7, :cond_4

    .line 48
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Bluetooth:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getBluetoothPresent()Z

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 50
    :cond_4
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getBluetoothVersion()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 51
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->BluetoothVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getBluetoothVersion()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 52
    :cond_5
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->HasNfc:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getNFCPresent()Z

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 53
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->HasTelephone:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getTelephonePresent()Z

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 54
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getPhoneBrand()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 55
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Brand:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getPhoneBrand()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 56
    :cond_6
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getPhoneModel()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_7

    .line 57
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Model:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getPhoneModel()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 58
    :cond_7
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_8

    .line 59
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->OS:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 61
    :cond_8
    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->isDebug()Z

    move-result v5

    if-eqz v5, :cond_9

    .line 62
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getURIScheme()Ljava/lang/String;

    move-result-object v4

    .line 63
    .local v4, "uriScheme":Ljava/lang/String;
    const-string v5, "bnc_no_value"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_9

    .line 64
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->URIScheme:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 66
    .end local v4    # "uriScheme":Ljava/lang/String;
    :cond_9
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->OSVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getOSVersion()I

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 67
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getScreenDisplay()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 68
    .local v0, "dMetrics":Landroid/util/DisplayMetrics;
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->ScreenDpi:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget v7, v0, Landroid/util/DisplayMetrics;->densityDpi:I

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 69
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->ScreenHeight:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget v7, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 70
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->ScreenWidth:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget v7, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 71
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->WiFi:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getWifiConnected()Z

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 72
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->IsReferrable:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7}, Lio/branch/referral/PrefHelper;->getIsReferrable()I

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 73
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Update:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    const/4 v7, 0x1

    invoke-virtual {p3, v7}, Lio/branch/referral/SystemObserver;->getUpdateState(Z)I

    move-result v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 74
    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->getLinkClickIdentifier()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_a

    .line 75
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->LinkIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7}, Lio/branch/referral/PrefHelper;->getLinkClickIdentifier()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 77
    :cond_a
    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->getAppLink()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_b

    .line 78
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->AndroidAppLinkURL:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7}, Lio/branch/referral/PrefHelper;->getAppLink()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 81
    :cond_b
    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->getExternalIntentUri()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_c

    .line 82
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->External_Intent_URI:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7}, Lio/branch/referral/PrefHelper;->getExternalIntentUri()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 84
    :cond_c
    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->getExternalIntentExtra()Ljava/lang/String;

    move-result-object v5

    const-string v7, "bnc_no_value"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_d

    .line 85
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->External_Intent_Extra:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7}, Lio/branch/referral/PrefHelper;->getExternalIntentExtra()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 88
    :cond_d
    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Debug:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->isDebug()Z

    move-result v5

    if-nez v5, :cond_e

    iget-object v5, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v5}, Lio/branch/referral/PrefHelper;->getExternDebug()Z

    move-result v5

    if-eqz v5, :cond_f

    :cond_e
    move v5, v6

    :goto_0
    invoke-virtual {v2, v7, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 89
    invoke-virtual {p0, v2}, Lio/branch/referral/ServerRequestRegisterInstall;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    .end local v0    # "dMetrics":Landroid/util/DisplayMetrics;
    .end local v3    # "uniqId":Ljava/lang/String;
    :goto_1
    return-void

    .line 88
    .restart local v0    # "dMetrics":Landroid/util/DisplayMetrics;
    .restart local v3    # "uniqId":Ljava/lang/String;
    :cond_f
    const/4 v5, 0x0

    goto :goto_0

    .line 91
    .end local v0    # "dMetrics":Landroid/util/DisplayMetrics;
    .end local v3    # "uniqId":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 92
    .local v1, "ex":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 93
    iput-boolean v6, p0, Lio/branch/referral/ServerRequestRegisterInstall;->constructError_:Z

    goto :goto_1
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 0
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 99
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequestInitSession;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 100
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 192
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 193
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 176
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequestInitSession;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 177
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v0, :cond_0

    .line 178
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Trouble initializing Branch."

    const/16 v4, -0x66

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 180
    :cond_0
    const/4 v0, 0x1

    .line 182
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 6
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 163
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v2, :cond_0

    .line 164
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 166
    .local v1, "obj":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "error_message"

    const-string v3, "Trouble reaching server. Please try again in a few minutes"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 170
    :goto_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    new-instance v3, Lio/branch/referral/BranchError;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Trouble initializing Branch. "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v2, v1, v3}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 172
    .end local v1    # "obj":Lorg/json/JSONObject;
    :cond_0
    return-void

    .line 167
    .restart local v1    # "obj":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 168
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public hasCallBack()Z
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 187
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 6
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 110
    :try_start_0
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v4

    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setUserURL(Ljava/lang/String;)V

    .line 111
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setLinkClickIdentifier(Ljava/lang/String;)V

    .line 112
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setExternalIntentUri(Ljava/lang/String;)V

    .line 113
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setExternalIntentExtra(Ljava/lang/String;)V

    .line 114
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setAppLink(Ljava/lang/String;)V

    .line 116
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 117
    new-instance v3, Lorg/json/JSONObject;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 119
    .local v0, "dataObj":Lorg/json/JSONObject;
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->Clicked_Branch_Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->Clicked_Branch_Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 124
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getInstallParams()Ljava/lang/String;

    move-result-object v3

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 126
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIsReferrable()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 127
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 128
    .local v2, "params":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3, v2}, Lio/branch/referral/PrefHelper;->setInstallParams(Ljava/lang/String;)V

    .line 134
    .end local v0    # "dataObj":Lorg/json/JSONObject;
    .end local v2    # "params":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 135
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v4

    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setLinkClickID(Ljava/lang/String;)V

    .line 140
    :goto_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 141
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 142
    .restart local v2    # "params":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3, v2}, Lio/branch/referral/PrefHelper;->setSessionParams(Ljava/lang/String;)V

    .line 146
    .end local v2    # "params":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v3, :cond_1

    .line 147
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p2}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 153
    :cond_1
    :goto_2
    return-void

    .line 137
    :cond_2
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setLinkClickID(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 149
    :catch_0
    move-exception v1

    .line 150
    .local v1, "ex":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .line 144
    .end local v1    # "ex":Ljava/lang/Exception;
    :cond_3
    :try_start_1
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterInstall;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setSessionParams(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public setInitFinishedCallback(Lio/branch/referral/Branch$BranchReferralInitListener;)V
    .locals 0
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;

    .prologue
    .line 156
    if-eqz p1, :cond_0

    .line 157
    iput-object p1, p0, Lio/branch/referral/ServerRequestRegisterInstall;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 159
    :cond_0
    return-void
.end method
