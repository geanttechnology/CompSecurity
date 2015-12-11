.class Lio/branch/referral/ServerRequestIdentifyUserRequest;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestIdentifyUserRequest.java"


# instance fields
.field callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

.field userId_:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralInitListener;Ljava/lang/String;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralInitListener;
    .param p3, "userId"    # Ljava/lang/String;

    .prologue
    .line 29
    sget-object v2, Lio/branch/referral/Defines$RequestPath;->IdentifyUser:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v2}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v2}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 16
    const/4 v2, 0x0

    iput-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->userId_:Ljava/lang/String;

    .line 31
    iput-object p2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 32
    iput-object p3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->userId_:Ljava/lang/String;

    .line 34
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 36
    .local v1, "post":Lorg/json/JSONObject;
    :try_start_0
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 37
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 38
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 39
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v2

    const-string v3, "bnc_no_value"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 40
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 42
    :cond_0
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->Identity:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 43
    invoke-virtual {p0, v1}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    :goto_0
    return-void

    .line 44
    :catch_0
    move-exception v0

    .line 45
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 46
    const/4 v2, 0x1

    iput-boolean v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->constructError_:Z

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 1
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 16
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->userId_:Ljava/lang/String;

    .line 52
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 143
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    .line 144
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    .line 91
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 92
    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v3, :cond_0

    .line 93
    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    const/4 v4, 0x0

    new-instance v5, Lio/branch/referral/BranchError;

    const-string v6, "Trouble setting the user alias."

    const/16 v7, -0x66

    invoke-direct {v5, v6, v7}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v3, v4, v5}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 106
    :cond_0
    :goto_0
    return v2

    .line 98
    :cond_1
    :try_start_0
    invoke-virtual {p0}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Identity:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 99
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIdentity()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-nez v3, :cond_0

    .line 106
    const/4 v2, 0x0

    goto :goto_0

    .line 102
    .end local v1    # "userId":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 103
    .local v0, "ignore":Lorg/json/JSONException;
    goto :goto_0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 6
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 78
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v2, :cond_0

    .line 79
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 81
    .local v1, "obj":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "error_message"

    const-string v3, "Trouble reaching server. Please try again in a few minutes"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 85
    :goto_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    new-instance v3, Lio/branch/referral/BranchError;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Trouble setting the user alias. "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v2, v1, v3}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 87
    .end local v1    # "obj":Lorg/json/JSONObject;
    :cond_0
    return-void

    .line 82
    .restart local v1    # "obj":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 83
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public handleUserExist(Lio/branch/referral/Branch;)V
    .locals 3
    .param p1, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 136
    iget-object v0, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p1}, Lio/branch/referral/Branch;->getFirstReferringParams()Lorg/json/JSONObject;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V

    .line 139
    :cond_0
    return-void
.end method

.method public isExistingID()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 121
    :try_start_0
    invoke-virtual {p0}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Identity:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 122
    .local v1, "userId":Ljava/lang/String;
    if-eqz v1, :cond_0

    iget-object v3, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIdentity()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    .line 125
    .end local v1    # "userId":Ljava/lang/String;
    :cond_0
    :goto_0
    return v2

    .line 123
    :catch_0
    move-exception v0

    .line 124
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 5
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 56
    :try_start_0
    invoke-virtual {p0}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v2

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->Identity:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 57
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p0}, Lio/branch/referral/ServerRequestIdentifyUserRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Identity:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lio/branch/referral/PrefHelper;->setIdentity(Ljava/lang/String;)V

    .line 60
    :cond_0
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lio/branch/referral/PrefHelper;->setIdentityID(Ljava/lang/String;)V

    .line 61
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lio/branch/referral/PrefHelper;->setUserURL(Ljava/lang/String;)V

    .line 63
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->ReferringData:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 64
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->ReferringData:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 65
    .local v1, "params":Ljava/lang/String;
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2, v1}, Lio/branch/referral/PrefHelper;->setInstallParams(Ljava/lang/String;)V

    .line 68
    .end local v1    # "params":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    if-eqz v2, :cond_2

    .line 69
    iget-object v2, p0, Lio/branch/referral/ServerRequestIdentifyUserRequest;->callback_:Lio/branch/referral/Branch$BranchReferralInitListener;

    invoke-virtual {p2}, Lio/branch/referral/Branch;->getFirstReferringParams()Lorg/json/JSONObject;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Lio/branch/referral/Branch$BranchReferralInitListener;->onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :cond_2
    :goto_0
    return-void

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public shouldRetryOnFail()Z
    .locals 1

    .prologue
    .line 148
    const/4 v0, 0x1

    return v0
.end method
