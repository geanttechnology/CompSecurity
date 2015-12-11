.class final Lcom/adobe/mobile/ReferrerHandler;
.super Ljava/lang/Object;
.source "ReferrerHandler.java"


# static fields
.field static final ACQUISITION_V3_TOKEN:Ljava/lang/String; = "adb_acq_v3"

.field static final CONTEXT_DATA_KEY:Ljava/lang/String; = "contextData"

.field static final REFERRER_FIELDS:[Ljava/lang/String;

.field private static _referrerProcessed:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 37
    sput-boolean v3, Lcom/adobe/mobile/ReferrerHandler;->_referrerProcessed:Z

    .line 47
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "utm_source"

    aput-object v2, v0, v1

    const-string v1, "utm_medium"

    aput-object v1, v0, v3

    const/4 v1, 0x2

    const-string v2, "utm_term"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "utm_content"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "utm_campaign"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "trackingcode"

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mobile/ReferrerHandler;->REFERRER_FIELDS:[Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static generateURLForV3(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "ugid"    # Ljava/lang/String;
    .param p1, "adid"    # Ljava/lang/String;

    .prologue
    const/16 v8, 0x40

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 277
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v8}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 278
    .local v2, "urlSb":Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v0

    .line 279
    .local v0, "mobileConfig":Lcom/adobe/mobile/MobileConfig;
    const-string v3, "http://%s/v3/%s/end"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getAcquisitionServer()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v0}, Lcom/adobe/mobile/MobileConfig;->getAcquisitionAppId()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 281
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v8}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 282
    .local v1, "querySb":Ljava/lang/StringBuilder;
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 283
    const-string v3, "?a_ugid=%s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {p0}, Lcom/adobe/mobile/StaticMethods;->URLEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 285
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_1

    .line 286
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_2

    const-string v3, "&"

    :goto_0
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 287
    const-string v3, "a_cid=%s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {p1}, Lcom/adobe/mobile/StaticMethods;->URLEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 290
    :cond_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 286
    :cond_2
    const-string v3, "?"

    goto :goto_0
.end method

.method protected static getReferrerDataFromV3Server(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "ugid"    # Ljava/lang/String;
    .param p1, "adid"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    const/4 v4, 0x0

    .line 255
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mobile/MobileConfig;->mobileReferrerConfigured()Z

    move-result v5

    if-nez v5, :cond_0

    move-object v2, v4

    .line 272
    :goto_0
    return-object v2

    .line 258
    :cond_0
    invoke-static {p0, p1}, Lcom/adobe/mobile/ReferrerHandler;->generateURLForV3(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 259
    .local v3, "url":Ljava/lang/String;
    const-string v5, "Analytics - Trying to fetch referrer data from (%s)"

    new-array v6, v7, [Ljava/lang/Object;

    aput-object v3, v6, v8

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 261
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mobile/MobileConfig;->getReferrerTimeout()I

    move-result v5

    const-string v6, "Analytics"

    invoke-static {v3, v4, v5, v6}, Lcom/adobe/mobile/RequestHandler;->retrieveData(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)[B

    move-result-object v1

    .line 262
    .local v1, "responseByteArray":[B
    if-nez v1, :cond_1

    move-object v2, v4

    .line 263
    goto :goto_0

    .line 267
    :cond_1
    :try_start_0
    new-instance v2, Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-direct {v2, v1, v5}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .local v2, "responseString":Ljava/lang/String;
    goto :goto_0

    .line 268
    .end local v2    # "responseString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 269
    .local v0, "ex":Ljava/io/UnsupportedEncodingException;
    const-string v5, "Analytics - Unable to decode response(%s)"

    new-array v6, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v2, v4

    .line 270
    goto :goto_0
.end method

.method protected static getReferrerProcessed()Z
    .locals 1

    .prologue
    .line 44
    sget-boolean v0, Lcom/adobe/mobile/ReferrerHandler;->_referrerProcessed:Z

    return v0
.end method

.method protected static getReferrerURLFromIntent(Landroid/content/Intent;)Ljava/lang/String;
    .locals 7
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 78
    if-nez p0, :cond_1

    .line 79
    const-string v4, "Analytics - Unable to process referrer due to an invalid intent parameter"

    new-array v5, v6, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 105
    :cond_0
    :goto_0
    return-object v3

    .line 83
    :cond_1
    invoke-virtual {p0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.android.vending.INSTALL_REFERRER"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 84
    const-string v4, "Analytics - Ignoring referrer due to the intent\'s action not being handled by analytics"

    new-array v5, v6, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 90
    :cond_2
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 92
    .local v1, "extras":Landroid/os/Bundle;
    if-eqz v1, :cond_3

    .line 93
    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    :cond_3
    const-string v4, "referrer"

    invoke-virtual {p0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 103
    .local v2, "referrerURL":Ljava/lang/String;
    if-eqz v2, :cond_0

    :try_start_1
    const-string v3, "UTF-8"

    invoke-static {v2, v3}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v3

    goto :goto_0

    .line 96
    .end local v1    # "extras":Landroid/os/Bundle;
    .end local v2    # "referrerURL":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 97
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0

    .line 104
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "extras":Landroid/os/Bundle;
    .restart local v2    # "referrerURL":Ljava/lang/String;
    :catch_1
    move-exception v0

    .restart local v0    # "e":Ljava/lang/Exception;
    move-object v3, v2

    .line 105
    goto :goto_0
.end method

.method protected static handleV1Acquisition(Ljava/util/HashMap;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p0, "referrerFields":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v9, 0x1

    const/4 v5, 0x0

    .line 124
    sget-boolean v4, Lcom/adobe/mobile/Lifecycle;->lifecycleHasRun:Z

    if-eqz v4, :cond_1

    .line 125
    const-string v4, "utm_source"

    invoke-virtual {p0, v4}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string v4, "utm_campaign"

    .line 126
    invoke-virtual {p0, v4}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 128
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 129
    .local v3, "referrerLifecycleContextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v4, "a.referrer.campaign.source"

    const-string v5, "utm_source"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    const-string v4, "a.referrer.campaign.medium"

    const-string v5, "utm_medium"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    const-string v4, "a.referrer.campaign.term"

    const-string v5, "utm_term"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    const-string v4, "a.referrer.campaign.content"

    const-string v5, "utm_content"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    const-string v4, "a.referrer.campaign.name"

    const-string v5, "utm_campaign"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    const-string v4, "a.referrer.campaign.trackingcode"

    const-string v5, "trackingcode"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAnalyticsExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v4

    new-instance v5, Lcom/adobe/mobile/ReferrerHandler$1;

    invoke-direct {v5, v3}, Lcom/adobe/mobile/ReferrerHandler$1;-><init>(Ljava/util/HashMap;)V

    invoke-interface {v4, v5}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 145
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v4

    invoke-virtual {v4, v3}, Lcom/adobe/mobile/AnalyticsWorker;->kickWithReferrerData(Ljava/util/Map;)V

    .line 164
    .end local v3    # "referrerLifecycleContextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    :goto_0
    return-void

    .line 149
    :cond_1
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 151
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    sget-object v6, Lcom/adobe/mobile/ReferrerHandler;->REFERRER_FIELDS:[Ljava/lang/String;

    array-length v7, v6

    move v4, v5

    :goto_1
    if-ge v4, v7, :cond_3

    aget-object v2, v6, v4

    .line 152
    .local v2, "field":Ljava/lang/String;
    invoke-virtual {p0, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    invoke-virtual {p0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    if-eqz v8, :cond_2

    .line 153
    invoke-virtual {p0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v2, v8}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 151
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 156
    .end local v2    # "field":Ljava/lang/String;
    :cond_3
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_2
    sput-boolean v9, Lcom/adobe/mobile/ReferrerHandler;->_referrerProcessed:Z

    goto :goto_0

    .line 157
    :catch_0
    move-exception v0

    .line 158
    .local v0, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v4, "Analytics - Error persisting referrer data (%s)"

    new-array v6, v9, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v5

    invoke-static {v4, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2
.end method

.method protected static handleV3Acquisition(Ljava/util/HashMap;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p0, "referrerFields":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v9, 0x1

    .line 168
    const-string v5, "utm_content"

    invoke-virtual {p0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 169
    .local v4, "ugid":Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAdvertisingIdentifier()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/adobe/mobile/ReferrerHandler;->getReferrerDataFromV3Server(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 172
    .local v3, "jsonResponse":Ljava/lang/String;
    sget-boolean v5, Lcom/adobe/mobile/Lifecycle;->lifecycleHasRun:Z

    if-eqz v5, :cond_0

    .line 173
    invoke-static {v3}, Lcom/adobe/mobile/ReferrerHandler;->parseV3Response(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v0

    .line 175
    .local v0, "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getAnalyticsExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v5

    new-instance v6, Lcom/adobe/mobile/ReferrerHandler$2;

    invoke-direct {v6, v0}, Lcom/adobe/mobile/ReferrerHandler$2;-><init>(Ljava/util/HashMap;)V

    invoke-interface {v5, v6}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 181
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v5

    invoke-virtual {v5, v0}, Lcom/adobe/mobile/AnalyticsWorker;->kickWithReferrerData(Ljava/util/Map;)V

    .line 195
    .end local v0    # "contextData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 184
    :cond_0
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/StaticMethods;->getSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 186
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v5, "ADMS_Referrer_ContextData_Json_String"

    invoke-interface {v2, v5, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 187
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Lcom/adobe/mobile/StaticMethods$NullContextException; {:try_start_0 .. :try_end_0} :catch_0

    .line 193
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_1
    sput-boolean v9, Lcom/adobe/mobile/ReferrerHandler;->_referrerProcessed:Z

    goto :goto_0

    .line 188
    :catch_0
    move-exception v1

    .line 189
    .local v1, "e":Lcom/adobe/mobile/StaticMethods$NullContextException;
    const-string v5, "Analytics - Error persisting referrer data (%s)"

    new-array v6, v9, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v1}, Lcom/adobe/mobile/StaticMethods$NullContextException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method protected static isV3Response(Ljava/util/HashMap;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 198
    .local p0, "referrerFields":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "adb_acq_v3"

    const-string v1, "utm_source"

    invoke-virtual {p0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "adb_acq_v3"

    const-string v1, "utm_campaign"

    .line 199
    invoke-virtual {p0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected static parseReferrerURLToMap(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 9
    .param p0, "referrerURL"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 110
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 112
    .local v1, "referrerFields":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v3, "&"

    invoke-virtual {p0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    array-length v6, v5

    move v3, v4

    :goto_0
    if-ge v3, v6, :cond_1

    aget-object v0, v5, v3

    .line 113
    .local v0, "item":Ljava/lang/String;
    const-string v7, "="

    invoke-virtual {v0, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 115
    .local v2, "tokens":[Ljava/lang/String;
    array-length v7, v2

    const/4 v8, 0x2

    if-ne v7, v8, :cond_0

    .line 116
    aget-object v7, v2, v4

    const/4 v8, 0x1

    aget-object v8, v2, v8

    invoke-virtual {v1, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 119
    .end local v0    # "item":Ljava/lang/String;
    .end local v2    # "tokens":[Ljava/lang/String;
    :cond_1
    return-object v1
.end method

.method protected static parseV3Response(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 10
    .param p0, "response"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 204
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 205
    .local v1, "contextDataMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v6

    if-nez v6, :cond_1

    .line 251
    :cond_0
    :goto_0
    return-object v1

    .line 209
    :cond_1
    sget-boolean v6, Lcom/adobe/mobile/ReferrerHandler;->_referrerProcessed:Z

    if-eqz v6, :cond_2

    .line 210
    const-string v6, "Analytics - Acquisition referrer timed out"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 217
    :cond_2
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 225
    .local v5, "responseObject":Lorg/json/JSONObject;
    :try_start_1
    const-string v6, "contextData"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v0

    .line 231
    .local v0, "contextData":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 236
    const-string v6, "a.referrer.campaign.name"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 240
    invoke-virtual {v0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v4

    .line 242
    .local v4, "keys":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 243
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 245
    .local v3, "key":Ljava/lang/String;
    :try_start_2
    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v3, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    .line 246
    :catch_0
    move-exception v2

    .line 247
    .local v2, "ex":Lorg/json/JSONException;
    const-string v6, "Analytics - Unable to parse acquisition service response (the value for %s is not a string)"

    new-array v7, v8, [Ljava/lang/Object;

    aput-object v3, v7, v9

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 218
    .end local v0    # "contextData":Lorg/json/JSONObject;
    .end local v2    # "ex":Lorg/json/JSONException;
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "keys":Ljava/util/Iterator;
    .end local v5    # "responseObject":Lorg/json/JSONObject;
    :catch_1
    move-exception v2

    .line 219
    .restart local v2    # "ex":Lorg/json/JSONException;
    const-string v6, "Analytics - Unable to parse response(%s)"

    new-array v7, v8, [Ljava/lang/Object;

    invoke-virtual {v2}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 226
    .end local v2    # "ex":Lorg/json/JSONException;
    .restart local v5    # "responseObject":Lorg/json/JSONObject;
    :catch_2
    move-exception v2

    .line 227
    .restart local v2    # "ex":Lorg/json/JSONException;
    const-string v6, "Analytics - Unable to parse acquisition service response (no contextData parameter in response)"

    new-array v7, v9, [Ljava/lang/Object;

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 250
    .end local v2    # "ex":Lorg/json/JSONException;
    .restart local v0    # "contextData":Lorg/json/JSONObject;
    .restart local v4    # "keys":Ljava/util/Iterator;
    :cond_3
    const-string v6, "Analytics - Received Referrer Data(%s)"

    new-array v7, v8, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/util/HashMap;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static processIntent(Landroid/content/Intent;)V
    .locals 5
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x0

    .line 59
    invoke-static {p0}, Lcom/adobe/mobile/ReferrerHandler;->getReferrerURLFromIntent(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v1

    .line 61
    .local v1, "referrerURL":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    .line 62
    :cond_0
    const-string v2, "Analytics - Ignoring referrer due to the intent\'s referrer string being empty"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 75
    :goto_0
    return-void

    .line 66
    :cond_1
    const-string v2, "Analytics - Received referrer information(%s)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 68
    invoke-static {v1}, Lcom/adobe/mobile/ReferrerHandler;->parseReferrerURLToMap(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v0

    .line 70
    .local v0, "referrerFields":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {v0}, Lcom/adobe/mobile/ReferrerHandler;->isV3Response(Ljava/util/HashMap;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 71
    invoke-static {v0}, Lcom/adobe/mobile/ReferrerHandler;->handleV3Acquisition(Ljava/util/HashMap;)V

    goto :goto_0

    .line 73
    :cond_2
    invoke-static {v0}, Lcom/adobe/mobile/ReferrerHandler;->handleV1Acquisition(Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method protected static setReferrerProcessed(Z)V
    .locals 0
    .param p0, "processed"    # Z

    .prologue
    .line 40
    sput-boolean p0, Lcom/adobe/mobile/ReferrerHandler;->_referrerProcessed:Z

    .line 41
    return-void
.end method
