.class Lio/branch/referral/ServerRequestLogout;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestLogout.java"


# instance fields
.field private callback_:Lio/branch/referral/Branch$LogoutStatusListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lio/branch/referral/Branch$LogoutStatusListener;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lio/branch/referral/Branch$LogoutStatusListener;

    .prologue
    .line 28
    sget-object v2, Lio/branch/referral/Defines$RequestPath;->Logout:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v2}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v2}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 29
    iput-object p2, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    .line 30
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 32
    .local v1, "post":Lorg/json/JSONObject;
    :try_start_0
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 33
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 34
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 35
    iget-object v2, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v2

    const-string v3, "bnc_no_value"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 36
    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 38
    :cond_0
    invoke-virtual {p0, v1}, Lio/branch/referral/ServerRequestLogout;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 43
    :goto_0
    return-void

    .line 39
    :catch_0
    move-exception v0

    .line 40
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 41
    const/4 v2, 0x1

    iput-boolean v2, p0, Lio/branch/referral/ServerRequestLogout;->constructError_:Z

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 0
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 47
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    .line 96
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 78
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 79
    const-string v1, "BranchSDK"

    const-string v2, "Trouble executing your request. Please add \'android.permission.INTERNET\' in your applications manifest file"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    if-eqz v1, :cond_0

    .line 81
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Logout failed"

    const/16 v4, -0x66

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v1, v0, v2}, Lio/branch/referral/Branch$LogoutStatusListener;->onLogoutFinished(ZLio/branch/referral/BranchError;)V

    .line 83
    :cond_0
    const/4 v0, 0x1

    .line 85
    :cond_1
    return v0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 5
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 71
    iget-object v0, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Logout error. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$LogoutStatusListener;->onLogoutFinished(ZLio/branch/referral/BranchError;)V

    .line 74
    :cond_0
    return-void
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 90
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 6
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 52
    :try_start_0
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/branch/referral/PrefHelper;->setSessionID(Ljava/lang/String;)V

    .line 53
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/branch/referral/PrefHelper;->setIdentityID(Ljava/lang/String;)V

    .line 54
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->Link:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/branch/referral/PrefHelper;->setUserURL(Ljava/lang/String;)V

    .line 56
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v2, "bnc_no_value"

    invoke-virtual {v1, v2}, Lio/branch/referral/PrefHelper;->setInstallParams(Ljava/lang/String;)V

    .line 57
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v2, "bnc_no_value"

    invoke-virtual {v1, v2}, Lio/branch/referral/PrefHelper;->setSessionParams(Ljava/lang/String;)V

    .line 58
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    const-string v2, "bnc_no_value"

    invoke-virtual {v1, v2}, Lio/branch/referral/PrefHelper;->setIdentity(Ljava/lang/String;)V

    .line 59
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->clearUserValues()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 63
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    if-eqz v1, :cond_0

    .line 64
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    invoke-interface {v1, v4, v5}, Lio/branch/referral/Branch$LogoutStatusListener;->onLogoutFinished(ZLio/branch/referral/BranchError;)V

    .line 67
    :cond_0
    :goto_0
    return-void

    .line 60
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Lorg/json/JSONException;
    :try_start_1
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 63
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    if-eqz v1, :cond_0

    .line 64
    iget-object v1, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    invoke-interface {v1, v4, v5}, Lio/branch/referral/Branch$LogoutStatusListener;->onLogoutFinished(ZLio/branch/referral/BranchError;)V

    goto :goto_0

    .line 63
    .end local v0    # "e":Lorg/json/JSONException;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    if-eqz v2, :cond_1

    .line 64
    iget-object v2, p0, Lio/branch/referral/ServerRequestLogout;->callback_:Lio/branch/referral/Branch$LogoutStatusListener;

    invoke-interface {v2, v4, v5}, Lio/branch/referral/Branch$LogoutStatusListener;->onLogoutFinished(ZLio/branch/referral/BranchError;)V

    :cond_1
    throw v1
.end method
