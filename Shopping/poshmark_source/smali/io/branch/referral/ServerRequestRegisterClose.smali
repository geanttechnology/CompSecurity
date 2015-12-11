.class Lio/branch/referral/ServerRequestRegisterClose;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestRegisterClose.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    sget-object v2, Lio/branch/referral/Defines$RequestPath;->RegisterClose:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v2}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v2}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 25
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 27
    .local v0, "closePost":Lorg/json/JSONObject;
    :try_start_0
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterClose;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 28
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterClose;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 29
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterClose;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 30
    iget-object v2, p0, Lio/branch/referral/ServerRequestRegisterClose;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v2

    const-string v3, "bnc_no_value"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 31
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestRegisterClose;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 33
    :cond_0
    invoke-virtual {p0, v0}, Lio/branch/referral/ServerRequestRegisterClose;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    :goto_0
    return-void

    .line 34
    :catch_0
    move-exception v1

    .line 35
    .local v1, "ex":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 36
    const/4 v2, 0x1

    iput-boolean v2, p0, Lio/branch/referral/ServerRequestRegisterClose;->constructError_:Z

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 0
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 42
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 0

    .prologue
    .line 72
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 47
    const-string v0, "BranchSDK"

    const-string v1, "Trouble executing your request. Please add \'android.permission.INTERNET\' in your applications manifest file"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 48
    const/4 v0, 0x1

    .line 50
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 0
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 62
    return-void
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 2
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 56
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterClose;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Lio/branch/referral/PrefHelper;->setSessionParams(Ljava/lang/String;)V

    .line 57
    return-void
.end method
