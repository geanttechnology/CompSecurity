.class Lio/branch/referral/ServerRequestRegisterOpen;
.super Lio/branch/referral/ServerRequestInitSession;
.source "ServerRequestRegisterOpen.java"


# instance fields
.field callback_:Lio/branch/referral/Branch$BranchReferralInitListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Lio/branch/referral/SystemObserver;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p3, "sysObserver"    # Lio/branch/referral/SystemObserver;

    .prologue
    const/4 v3, 0x1

    .line 28
    sget-object v2, Lio/branch/referral/Defines$RequestPath;->RegisterOpen:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v2}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v2}, Lio/branch/referral/ServerRequestInitSession;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 30
    iput-object p2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 31
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 33
    .local v1, "openPost":Lorg/json/JSONObject;
    :try_start_0
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 34
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 35
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->IsReferrable:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getIsReferrable()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 36
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getAppVersion()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bnc_no_value"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 37
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->AppVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getAppVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 38
    :cond_0
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->OSVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getOSVersion()I

    move-result v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 39
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->Update:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x1

    invoke-virtual {p3, v4}, Lio/branch/referral/SystemObserver;->getUpdateState(Z)I

    move-result v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 40
    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bnc_no_value"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 41
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->OS:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p3}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 42
    :cond_1
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getLinkClickIdentifier()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bnc_no_value"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 43
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->LinkIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getLinkClickIdentifier()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 45
    :cond_2
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getAppLink()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bnc_no_value"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 46
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->AndroidAppLinkURL:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getAppLink()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 49
    :cond_3
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getExternalIntentUri()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bnc_no_value"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 50
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->External_Intent_URI:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getExternalIntentUri()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 52
    :cond_4
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getExternalIntentExtra()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bnc_no_value"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 53
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->External_Intent_Extra:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getExternalIntentExtra()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 56
    :cond_5
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->Debug:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->isDebug()Z

    move-result v2

    if-nez v2, :cond_6

    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getExternDebug()Z

    move-result v2

    if-eqz v2, :cond_7

    :cond_6
    move v2, v3

    :goto_0
    invoke-virtual {v1, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 58
    invoke-virtual {p0, v1}, Lio/branch/referral/ServerRequestRegisterOpen;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :goto_1
    return-void

    .line 56
    :cond_7
    const/4 v2, 0x0

    goto :goto_0

    .line 59
    :catch_0
    move-exception v0

    .line 60
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 61
    iput-boolean v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->constructError_:Z

    goto :goto_1
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 0
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequestInitSession;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 68
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 154
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 155
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 138
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequestInitSession;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 139
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Trouble initializing Branch."

    const/16 v4, -0x66

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 142
    :cond_0
    const/4 v0, 0x1

    .line 144
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
    .line 125
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v2, :cond_0

    .line 126
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 128
    .local v1, "obj":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "error_message"

    const-string v3, "Trouble reaching server. Please try again in a few minutes"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 132
    :goto_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

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

    .line 134
    .end local v1    # "obj":Lorg/json/JSONObject;
    :cond_0
    return-void

    .line 129
    .restart local v1    # "obj":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 130
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public hasCallBack()Z
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

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
    .line 149
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 6
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 73
    :try_start_0
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setLinkClickIdentifier(Ljava/lang/String;)V

    .line 74
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setExternalIntentUri(Ljava/lang/String;)V

    .line 75
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setExternalIntentExtra(Ljava/lang/String;)V

    .line 76
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setAppLink(Ljava/lang/String;)V

    .line 77
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 78
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v4

    sget-object v5, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v5}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setLinkClickID(Ljava/lang/String;)V

    .line 83
    :goto_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 84
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

    .line 86
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

    .line 91
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getInstallParams()Ljava/lang/String;

    move-result-object v3

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 93
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIsReferrable()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 94
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 95
    .local v2, "params":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3, v2}, Lio/branch/referral/PrefHelper;->setInstallParams(Ljava/lang/String;)V

    .line 101
    .end local v0    # "dataObj":Lorg/json/JSONObject;
    .end local v2    # "params":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 102
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Data:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 103
    .restart local v2    # "params":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3, v2}, Lio/branch/referral/PrefHelper;->setSessionParams(Ljava/lang/String;)V

    .line 108
    .end local v2    # "params":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v3, :cond_1

    .line 109
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p2}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 115
    :cond_1
    :goto_2
    return-void

    .line 80
    :cond_2
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Lio/branch/referral/PrefHelper;->setLinkClickID(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 111
    :catch_0
    move-exception v1

    .line 112
    .local v1, "ex":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .line 105
    .end local v1    # "ex":Ljava/lang/Exception;
    :cond_3
    :try_start_1
    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterOpen;->prefHelper_:Lio/branch/referral/PrefHelper;

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
    .line 118
    if-eqz p1, :cond_0

    .line 119
    iput-object p1, p0, Lio/branch/referral/ServerRequestRegisterOpen;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 121
    :cond_0
    return-void
.end method
