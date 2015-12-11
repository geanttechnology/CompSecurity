.class Lio/branch/referral/ServerRequestSendAppList;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestSendAppList.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    sget-object v3, Lio/branch/referral/Defines$RequestPath;->SendAPPList:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v3}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, p1, v3}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 40
    new-instance v2, Lio/branch/referral/SystemObserver;

    invoke-direct {v2, p1}, Lio/branch/referral/SystemObserver;-><init>(Landroid/content/Context;)V

    .line 41
    .local v2, "sysObserver":Lio/branch/referral/SystemObserver;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 43
    .local v1, "post":Lorg/json/JSONObject;
    :try_start_0
    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v3

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 44
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->OS:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 45
    :cond_0
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lio/branch/referral/ServerRequestSendAppList;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 46
    const-string v3, "apps_data"

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->getListOfApps()Lorg/json/JSONArray;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 47
    invoke-virtual {p0, v1}, Lio/branch/referral/ServerRequestSendAppList;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 52
    :goto_0
    return-void

    .line 48
    :catch_0
    move-exception v0

    .line 49
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 50
    const/4 v3, 0x1

    iput-boolean v3, p0, Lio/branch/referral/ServerRequestSendAppList;->constructError_:Z

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 0
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 55
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 56
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 0

    .prologue
    .line 85
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 71
    const-string v0, "BranchSDK"

    const-string v1, "Trouble executing your request. Please add \'android.permission.INTERNET\' in your applications manifest file"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    const/4 v0, 0x1

    .line 74
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
    .line 66
    return-void
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 1
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 60
    iget-object v0, p0, Lio/branch/referral/ServerRequestSendAppList;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->clearSystemReadStatus()V

    .line 61
    return-void
.end method
