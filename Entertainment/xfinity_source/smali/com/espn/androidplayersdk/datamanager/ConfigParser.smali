.class Lcom/espn/androidplayersdk/datamanager/ConfigParser;
.super Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.source "ConfigParser.java"


# instance fields
.field sendSuccessBroadcast:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;-><init>()V

    .line 20
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendSuccessBroadcast:Z

    .line 18
    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 91
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    .line 92
    const-string v0, "com.espn.action.CONFIG_DATA_ERROR"

    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendBroadcast(Ljava/lang/String;)V

    .line 93
    :cond_0
    return-void
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 9
    .param p1, "object"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v5, "ConfigParser"

    const/4 v6, 0x3

    const/4 v7, 0x0

    invoke-static {v5, v6, v7}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 27
    :try_start_0
    const-string v5, "status"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_c

    const-string v5, "status"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_c

    const-string v5, "status"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "success"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 29
    const-string v5, "config"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_a

    const-string v5, "config"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_a

    .line 30
    const-string v5, "config"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 31
    .local v1, "configObj":Lorg/json/JSONObject;
    const-string v5, "baseApiUrl"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string v5, "baseApiUrl"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 32
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "url"

    const-string v8, "baseApiUrl"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    :cond_0
    const-string v5, "baseVODApiUrl"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    const-string v5, "baseVODApiUrl"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 35
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "vodUrl"

    const-string v8, "baseVODApiUrl"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    :cond_1
    const-string v5, "eventPollingUrl"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    const-string v5, "eventPollingUrl"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 38
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "poolingInterval"

    const-string v8, "eventPollingUrl"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    :cond_2
    const-string v5, "apikey"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    const-string v5, "apikey"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 41
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "apiKey"

    const-string v8, "apikey"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    :cond_3
    const-string v5, "analytics"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    const-string v5, "analytics"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_9

    .line 44
    const-string v5, "analytics"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 45
    .local v0, "analyticsObj":Lorg/json/JSONObject;
    const-string v5, "conviva"

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    const-string v5, "conviva"

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 46
    const-string v5, "conviva"

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 47
    .local v2, "conviviaObj":Lorg/json/JSONObject;
    const-string v5, "customerKey"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    const-string v5, "customerKey"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 48
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "convivakey"

    const-string v8, "customerKey"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    :cond_4
    const-string v5, "playerName"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    const-string v5, "playerName"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 50
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "playerName"

    const-string v8, "playerName"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    .end local v2    # "conviviaObj":Lorg/json/JSONObject;
    :cond_5
    const-string v5, "omniture"

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    const-string v5, "omniture"

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_9

    .line 53
    const-string v5, "omniture"

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 54
    .local v4, "omnitureObj":Lorg/json/JSONObject;
    const-string v5, "trackingServer"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    const-string v5, "trackingServer"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 55
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    .line 56
    const-string v6, "config"

    const-string v7, "trackingServer"

    const-string v8, "trackingServer"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    :cond_6
    const-string v5, "trackingServerSecure"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    const-string v5, "trackingServerSecure"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_7

    .line 59
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "trackingServerSecure"

    .line 60
    const-string v8, "trackingServerSecure"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 59
    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    :cond_7
    const-string v5, "currencyCode"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_8

    const-string v5, "currencyCode"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_8

    .line 63
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "currencyCode"

    const-string v8, "currencyCode"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    :cond_8
    const-string v5, "androidReportSuite"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    const-string v5, "androidReportSuite"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_9

    .line 66
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "suite"

    const-string v8, "androidReportSuite"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    .end local v0    # "analyticsObj":Lorg/json/JSONObject;
    .end local v4    # "omnitureObj":Lorg/json/JSONObject;
    :cond_9
    const-string v5, "networks"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_a

    const-string v5, "networks"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_a

    .line 71
    new-instance v5, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v5}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v6, "config"

    const-string v7, "network"

    const-string v8, "networks"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v7, v8}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 84
    .end local v1    # "configObj":Lorg/json/JSONObject;
    :cond_a
    :goto_0
    iget-boolean v5, p0, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendSuccessBroadcast:Z

    if-eqz v5, :cond_b

    .line 85
    const-string v5, "com.espn.action.CONFIG_UPDATED"

    invoke-virtual {p0, v5}, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendBroadcast(Ljava/lang/String;)V

    .line 87
    :cond_b
    :goto_1
    return-void

    .line 75
    :cond_c
    const/4 v5, 0x0

    :try_start_1
    iput-boolean v5, p0, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendSuccessBroadcast:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 77
    :catch_0
    move-exception v3

    .line 79
    .local v3, "e":Ljava/lang/Exception;
    :try_start_2
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "ConfigParser: Error: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_d

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    :goto_2
    const/4 v6, 0x5

    invoke-static {v5, v6, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 80
    const/4 v5, 0x2

    invoke-virtual {p0, v5}, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->errorHandler(I)V

    .line 81
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendSuccessBroadcast:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 84
    iget-boolean v5, p0, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendSuccessBroadcast:Z

    if-eqz v5, :cond_b

    .line 85
    const-string v5, "com.espn.action.CONFIG_UPDATED"

    invoke-virtual {p0, v5}, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendBroadcast(Ljava/lang/String;)V

    goto :goto_1

    .line 79
    :cond_d
    :try_start_3
    const-string v5, ""
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 83
    .end local v3    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    .line 84
    iget-boolean v6, p0, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendSuccessBroadcast:Z

    if-eqz v6, :cond_e

    .line 85
    const-string v6, "com.espn.action.CONFIG_UPDATED"

    invoke-virtual {p0, v6}, Lcom/espn/androidplayersdk/datamanager/ConfigParser;->sendBroadcast(Ljava/lang/String;)V

    .line 86
    :cond_e
    throw v5
.end method
