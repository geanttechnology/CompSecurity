.class public Lio/branch/referral/BranchRemoteInterface;
.super Lio/branch/referral/RemoteInterface;
.source "BranchRemoteInterface.java"


# instance fields
.field private callback_:Lio/branch/referral/NetworkCallback;

.field private sysObserver_:Lio/branch/referral/SystemObserver;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lio/branch/referral/RemoteInterface;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lio/branch/referral/RemoteInterface;-><init>(Landroid/content/Context;)V

    .line 42
    new-instance v0, Lio/branch/referral/SystemObserver;

    invoke-direct {v0, p1}, Lio/branch/referral/SystemObserver;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    .line 43
    return-void
.end method


# virtual methods
.method public connectToDebug()V
    .locals 9

    .prologue
    .line 77
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    new-instance v2, Lio/branch/referral/ServerResponse;

    const-string v3, "t_debug_connect"

    const/16 v4, -0x3f1

    invoke-direct {v2, v3, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v2}, Lio/branch/referral/NetworkCallback;->finished(Lio/branch/referral/ServerResponse;)V

    .line 102
    :goto_0
    return-void

    .line 81
    :cond_0
    :try_start_0
    const-string v7, "v1/debug/connect"

    .line 82
    .local v7, "urlExtend":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 83
    .local v1, "post":Lorg/json/JSONObject;
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 84
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    invoke-virtual {v0}, Lio/branch/referral/SystemObserver;->getBluetoothPresent()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 85
    const-string v0, "device_name"

    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v2

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothAdapter;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 89
    :goto_1
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->OS:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 90
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->OSVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getOSVersion()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 91
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->Model:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getPhoneModel()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 92
    const-string v0, "is_simulator"

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->isSimulator()Z

    move-result v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 93
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 94
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 95
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 97
    :cond_1
    iget-object v8, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getAPIBaseUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "t_debug_connect"

    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getTimeout()I

    move-result v4

    const/4 v5, 0x1

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/BranchRemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IZ)Lio/branch/referral/ServerResponse;

    move-result-object v0

    invoke-interface {v8, v0}, Lio/branch/referral/NetworkCallback;->finished(Lio/branch/referral/ServerResponse;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 98
    .end local v1    # "post":Lorg/json/JSONObject;
    .end local v7    # "urlExtend":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 99
    .local v6, "ex":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0

    .line 87
    .end local v6    # "ex":Lorg/json/JSONException;
    .restart local v1    # "post":Lorg/json/JSONObject;
    .restart local v7    # "urlExtend":Ljava/lang/String;
    :cond_2
    :try_start_1
    const-string v0, "device_name"

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getPhoneModel()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method public createCustomUrlSync(Lorg/json/JSONObject;)Lio/branch/referral/ServerResponse;
    .locals 7
    .param p1, "post"    # Lorg/json/JSONObject;

    .prologue
    .line 63
    const-string v6, "v1/url"

    .line 64
    .local v6, "urlExtend":Ljava/lang/String;
    const/4 v5, 0x0

    .line 65
    .local v5, "linkData":Lio/branch/referral/BranchLinkData;
    instance-of v0, p1, Lio/branch/referral/BranchLinkData;

    if-eqz v0, :cond_0

    move-object v5, p1

    .line 66
    check-cast v5, Lio/branch/referral/BranchLinkData;

    .line 69
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getAPIBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget-object v0, Lio/branch/referral/Defines$RequestPath;->GetURL:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v0}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getTimeout()I

    move-result v4

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/BranchRemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public disconnectFromDebug()V
    .locals 9

    .prologue
    .line 109
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    new-instance v2, Lio/branch/referral/ServerResponse;

    const-string v3, "t_debug_connect"

    const/16 v4, -0x3f1

    invoke-direct {v2, v3, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v2}, Lio/branch/referral/NetworkCallback;->finished(Lio/branch/referral/ServerResponse;)V

    .line 127
    :goto_0
    return-void

    .line 113
    :cond_0
    :try_start_0
    const-string v7, "v1/debug/disconnect"

    .line 114
    .local v7, "urlExtend":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 115
    .local v1, "post":Lorg/json/JSONObject;
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 116
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 117
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 119
    :cond_1
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 120
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 122
    :cond_2
    iget-object v8, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getAPIBaseUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "t_debug_disconnect"

    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getTimeout()I

    move-result v4

    const/4 v5, 0x1

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/BranchRemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IZ)Lio/branch/referral/ServerResponse;

    move-result-object v0

    invoke-interface {v8, v0}, Lio/branch/referral/NetworkCallback;->finished(Lio/branch/referral/ServerResponse;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 123
    .end local v1    # "post":Lorg/json/JSONObject;
    .end local v7    # "urlExtend":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 124
    .local v6, "ex":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public getSystemObserver()Lio/branch/referral/SystemObserver;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->sysObserver_:Lio/branch/referral/SystemObserver;

    return-object v0
.end method

.method public bridge synthetic make_restful_get(Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # I

    .prologue
    .line 9
    invoke-super {p0, p1, p2, p3}, Lio/branch/referral/RemoteInterface;->make_restful_get(Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;
    .locals 1
    .param p1, "x0"    # Lorg/json/JSONObject;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # I

    .prologue
    .line 9
    invoke-super {p0, p1, p2, p3, p4}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    .locals 1
    .param p1, "x0"    # Lorg/json/JSONObject;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # I
    .param p5, "x4"    # Lio/branch/referral/BranchLinkData;

    .prologue
    .line 9
    invoke-super/range {p0 .. p5}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IZ)Lio/branch/referral/ServerResponse;
    .locals 1
    .param p1, "x0"    # Lorg/json/JSONObject;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # I
    .param p5, "x4"    # Z

    .prologue
    .line 9
    invoke-super/range {p0 .. p5}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IZ)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public sendLog(Ljava/lang/String;)V
    .locals 9
    .param p1, "log"    # Ljava/lang/String;

    .prologue
    .line 136
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    new-instance v2, Lio/branch/referral/ServerResponse;

    const-string v3, "t_debug_connect"

    const/16 v4, -0x3f1

    invoke-direct {v2, v3, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v2}, Lio/branch/referral/NetworkCallback;->finished(Lio/branch/referral/ServerResponse;)V

    .line 155
    :goto_0
    return-void

    .line 140
    :cond_0
    :try_start_0
    const-string v7, "v1/debug/log"

    .line 141
    .local v7, "urlExtend":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 142
    .local v1, "post":Lorg/json/JSONObject;
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 143
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 144
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 146
    :cond_1
    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bnc_no_value"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 147
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 149
    :cond_2
    const-string v0, "log"

    invoke-virtual {v1, v0, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 150
    iget-object v8, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getAPIBaseUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "t_debug_log"

    iget-object v0, p0, Lio/branch/referral/BranchRemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getTimeout()I

    move-result v4

    const/4 v5, 0x1

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lio/branch/referral/BranchRemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IZ)Lio/branch/referral/ServerResponse;

    move-result-object v0

    invoke-interface {v8, v0}, Lio/branch/referral/NetworkCallback;->finished(Lio/branch/referral/ServerResponse;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 151
    .end local v1    # "post":Lorg/json/JSONObject;
    .end local v7    # "urlExtend":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 152
    .local v6, "ex":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0
.end method

.method public setNetworkCallbackListener(Lio/branch/referral/NetworkCallback;)V
    .locals 0
    .param p1, "callback"    # Lio/branch/referral/NetworkCallback;

    .prologue
    .line 52
    iput-object p1, p0, Lio/branch/referral/BranchRemoteInterface;->callback_:Lio/branch/referral/NetworkCallback;

    .line 53
    return-void
.end method
