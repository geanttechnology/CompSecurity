.class final Lcom/adobe/mobile/WearableFunction;
.super Ljava/lang/Object;
.source "WearableFunction.java"


# static fields
.field private static sendHitFlag:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    sput-boolean v0, Lcom/adobe/mobile/WearableFunction;->sendHitFlag:Z

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static isHandheldAppStarted()Z
    .locals 8

    .prologue
    const-wide/16 v6, 0x0

    const/4 v1, 0x0

    .line 28
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "ADMS_Handheld_App_InstallDate"

    const-wide/16 v4, 0x0

    invoke-interface {v2, v3, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    cmp-long v2, v2, v6

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 32
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :cond_0
    :goto_0
    return v1

    .line 29
    .end local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    :catch_0
    move-exception v0

    .line 30
    .restart local v0    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v2, "Wearable - Error getting install date of handheld app"

    new-array v3, v1, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected static retrieveData(Ljava/lang/String;I)[B
    .locals 8
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "readTimeout"    # I

    .prologue
    const/4 v3, 0x0

    .line 60
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 61
    const/4 v0, 0x0

    .line 63
    .local v0, "appCtx":Landroid/content/Context;
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 68
    new-instance v4, Lcom/adobe/mobile/WearableDataConnection;

    invoke-direct {v4, v0}, Lcom/adobe/mobile/WearableDataConnection;-><init>(Landroid/content/Context;)V

    invoke-static {p0, p1}, Lcom/adobe/mobile/WearableDataRequest;->createGetRequest(Ljava/lang/String;I)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/adobe/mobile/WearableDataConnection;->send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;

    move-result-object v2

    check-cast v2, Lcom/adobe/mobile/WearableDataResponse$GetResponse;

    .line 69
    .local v2, "response":Lcom/adobe/mobile/WearableDataResponse$GetResponse;
    if-nez v2, :cond_1

    .line 71
    .end local v0    # "appCtx":Landroid/content/Context;
    .end local v2    # "response":Lcom/adobe/mobile/WearableDataResponse$GetResponse;
    :cond_0
    :goto_0
    return-object v3

    .line 64
    .restart local v0    # "appCtx":Landroid/content/Context;
    :catch_0
    move-exception v1

    .line 65
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v4, "Analytics - Error registering network receiver (%s)"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 69
    .end local v1    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .restart local v2    # "response":Lcom/adobe/mobile/WearableDataResponse$GetResponse;
    :cond_1
    invoke-virtual {v2}, Lcom/adobe/mobile/WearableDataResponse$GetResponse;->getResult()[B

    move-result-object v3

    goto :goto_0
.end method

.method protected static sendAnalyticsRequest(Ljava/lang/String;Ljava/lang/String;I)Z
    .locals 7
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "postBody"    # Ljava/lang/String;
    .param p2, "timeout"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 76
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 77
    const/4 v0, 0x0

    .line 79
    .local v0, "appCtx":Landroid/content/Context;
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 84
    new-instance v5, Lcom/adobe/mobile/WearableDataConnection;

    invoke-direct {v5, v0}, Lcom/adobe/mobile/WearableDataConnection;-><init>(Landroid/content/Context;)V

    invoke-static {p0, p1, p2}, Lcom/adobe/mobile/WearableDataRequest;->createPostRequest(Ljava/lang/String;Ljava/lang/String;I)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/adobe/mobile/WearableDataConnection;->send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;

    move-result-object v2

    .line 85
    .local v2, "response":Lcom/adobe/mobile/WearableDataResponse;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/adobe/mobile/WearableDataResponse;->isSuccess()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 87
    .end local v0    # "appCtx":Landroid/content/Context;
    .end local v2    # "response":Lcom/adobe/mobile/WearableDataResponse;
    :cond_0
    :goto_0
    return v3

    .line 80
    .restart local v0    # "appCtx":Landroid/content/Context;
    :catch_0
    move-exception v1

    .line 81
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v5, "Analytics - Error registering network receiver (%s)"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    move v3, v4

    .line 82
    goto :goto_0

    .end local v1    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .restart local v2    # "response":Lcom/adobe/mobile/WearableDataResponse;
    :cond_1
    move v3, v4

    .line 85
    goto :goto_0
.end method

.method protected static sendGenericRequest(Ljava/lang/String;I)V
    .locals 0
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "timeout"    # I

    .prologue
    .line 56
    invoke-static {p0, p1}, Lcom/adobe/mobile/WearableFunction;->retrieveData(Ljava/lang/String;I)[B

    .line 57
    return-void
.end method

.method protected static sendThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z
    .locals 7
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "postBody"    # Ljava/lang/String;
    .param p2, "timeout"    # I
    .param p3, "postType"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 92
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->isWearableApp()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 93
    const/4 v0, 0x0

    .line 95
    .local v0, "appCtx":Landroid/content/Context;
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 101
    new-instance v5, Lcom/adobe/mobile/WearableDataConnection;

    invoke-direct {v5, v0}, Lcom/adobe/mobile/WearableDataConnection;-><init>(Landroid/content/Context;)V

    invoke-static {p0, p1, p2, p3}, Lcom/adobe/mobile/WearableDataRequest;->createThirdPartyRequest(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/adobe/mobile/WearableDataConnection;->send(Lcom/adobe/mobile/WearableDataRequest;)Lcom/adobe/mobile/WearableDataResponse;

    move-result-object v2

    .line 103
    .local v2, "response":Lcom/adobe/mobile/WearableDataResponse;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/adobe/mobile/WearableDataResponse;->isSuccess()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 105
    .end local v0    # "appCtx":Landroid/content/Context;
    .end local v2    # "response":Lcom/adobe/mobile/WearableDataResponse;
    :cond_0
    :goto_0
    return v3

    .line 96
    .restart local v0    # "appCtx":Landroid/content/Context;
    :catch_0
    move-exception v1

    .line 97
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v5, "External Callback - Error registering network receiver (%s)"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v5, v3}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    move v3, v4

    .line 98
    goto :goto_0

    .end local v1    # "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    .restart local v2    # "response":Lcom/adobe/mobile/WearableDataResponse;
    :cond_1
    move v3, v4

    .line 103
    goto :goto_0
.end method

.method protected static shouldSendHit()Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 37
    sget-boolean v2, Lcom/adobe/mobile/WearableFunction;->sendHitFlag:Z

    if-eqz v2, :cond_0

    .line 51
    :goto_0
    return v0

    .line 40
    :cond_0
    invoke-static {}, Lcom/adobe/mobile/Config;->getApplicationType()Lcom/adobe/mobile/Config$ApplicationType;

    move-result-object v2

    sget-object v3, Lcom/adobe/mobile/Config$ApplicationType;->APPLICATION_TYPE_WEARABLE:Lcom/adobe/mobile/Config$ApplicationType;

    if-eq v2, v3, :cond_1

    .line 41
    sput-boolean v0, Lcom/adobe/mobile/WearableFunction;->sendHitFlag:Z

    goto :goto_0

    .line 44
    :cond_1
    invoke-static {}, Lcom/adobe/mobile/WearableFunction;->isHandheldAppStarted()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 45
    sput-boolean v0, Lcom/adobe/mobile/WearableFunction;->sendHitFlag:Z

    goto :goto_0

    .line 48
    :cond_2
    const-string v0, "Analytics - Failed to send the Wearable request, containing app should get launched before Wearable app."

    new-array v2, v1, [Ljava/lang/Object;

    invoke-static {v0, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    move v0, v1

    .line 51
    goto :goto_0
.end method
