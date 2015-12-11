.class public Lcom/amazon/sdk/availability/ConfigurationClientImpl;
.super Ljava/lang/Object;
.source "ConfigurationClientImpl.java"

# interfaces
.implements Lcom/amazon/sdk/availability/ConfigurationClient;


# instance fields
.field private webClient:Lcom/amazon/mas/http/Web;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v0, Lcom/amazon/mas/http/Web;

    invoke-direct {v0}, Lcom/amazon/mas/http/Web;-><init>()V

    iput-object v0, p0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;->webClient:Lcom/amazon/mas/http/Web;

    .line 40
    iget-object v0, p0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;->webClient:Lcom/amazon/mas/http/Web;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mas/http/Web;->setGzipCompression(Z)V

    .line 41
    iget-object v0, p0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;->webClient:Lcom/amazon/mas/http/Web;

    new-instance v1, Lcom/amazon/sdk/availability/SignatureInterceptor;

    invoke-direct {v1}, Lcom/amazon/sdk/availability/SignatureInterceptor;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/mas/http/Web;->addInterceptor(Lcom/amazon/mas/http/Web$Interceptor;)V

    .line 42
    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->isProduction()Z

    move-result v0

    if-nez v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;->webClient:Lcom/amazon/mas/http/Web;

    new-instance v1, Lcom/amazon/mas/http/LogInterceptor;

    invoke-direct {v1}, Lcom/amazon/mas/http/LogInterceptor;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/mas/http/Web;->addInterceptor(Lcom/amazon/mas/http/Web$Interceptor;)V

    .line 45
    :cond_0
    return-void
.end method


# virtual methods
.method public getAvailabilityConfiguration(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/amazon/sdk/availability/SubmissionState;)Lcom/amazon/sdk/availability/Configuration;
    .locals 13
    .param p1, "sdkVersion"    # Ljava/lang/String;
    .param p2, "marketplaceId"    # Ljava/lang/String;
    .param p3, "customerId"    # Ljava/lang/String;
    .param p4, "deviceType"    # Ljava/lang/String;
    .param p5, "deviceId"    # Ljava/lang/String;
    .param p6, "deviceMake"    # Ljava/lang/String;
    .param p7, "deviceModel"    # Ljava/lang/String;
    .param p8, "deviceCarrier"    # Ljava/lang/String;
    .param p9, "deviceOs"    # Ljava/lang/String;
    .param p10, "region"    # Ljava/lang/String;
    .param p11, "clientIds"    # [Ljava/lang/String;
    .param p12, "state"    # Lcom/amazon/sdk/availability/SubmissionState;

    .prologue
    .line 58
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 60
    .local v4, "requestJson":Lorg/json/JSONObject;
    if-eqz p1, :cond_0

    .line 61
    :try_start_0
    const-string/jumbo v10, "sdkVersion"

    invoke-virtual {v4, v10, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 63
    :cond_0
    if-eqz p2, :cond_1

    .line 64
    const-string/jumbo v10, "marketplaceId"

    invoke-virtual {v4, v10, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 66
    :cond_1
    if-eqz p3, :cond_2

    .line 67
    const-string/jumbo v10, "customerId"

    move-object/from16 v0, p3

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 69
    :cond_2
    if-eqz p4, :cond_3

    .line 70
    const-string/jumbo v10, "deviceType"

    move-object/from16 v0, p4

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 72
    :cond_3
    if-eqz p5, :cond_4

    .line 73
    const-string/jumbo v10, "deviceId"

    move-object/from16 v0, p5

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 75
    :cond_4
    if-eqz p6, :cond_5

    .line 76
    const-string/jumbo v10, "deviceMake"

    move-object/from16 v0, p6

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 78
    :cond_5
    if-eqz p7, :cond_6

    .line 79
    const-string/jumbo v10, "deviceModel"

    move-object/from16 v0, p7

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 81
    :cond_6
    if-eqz p8, :cond_7

    .line 82
    const-string/jumbo v10, "deviceCarrier"

    move-object/from16 v0, p8

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 84
    :cond_7
    if-eqz p9, :cond_8

    .line 85
    const-string/jumbo v10, "deviceOs"

    move-object/from16 v0, p9

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 87
    :cond_8
    if-eqz p10, :cond_9

    .line 88
    const-string/jumbo v10, "region"

    move-object/from16 v0, p10

    invoke-virtual {v4, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 90
    :cond_9
    if-eqz p12, :cond_a

    .line 91
    const-string/jumbo v10, "state"

    invoke-virtual/range {p12 .. p12}, Lcom/amazon/sdk/availability/SubmissionState;->toJson()Lorg/json/JSONObject;

    move-result-object v11

    invoke-virtual {v4, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 93
    :cond_a
    if-eqz p11, :cond_b

    .line 94
    new-instance v1, Lorg/json/JSONArray;

    invoke-static/range {p11 .. p11}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v10

    invoke-direct {v1, v10}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    .line 95
    .local v1, "clients":Lorg/json/JSONArray;
    const-string/jumbo v10, "clients"

    invoke-virtual {v4, v10, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 98
    .end local v1    # "clients":Lorg/json/JSONArray;
    :cond_b
    const-string/jumbo v10, "timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    invoke-virtual {v4, v10, v11, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 105
    :goto_0
    invoke-static {}, Lcom/amazon/sdk/availability/Stage;->getDomain()Lcom/amazon/sdk/availability/Stage$Domain;

    move-result-object v10

    sget-object v11, Lcom/amazon/sdk/availability/Stage$Domain;->PROD:Lcom/amazon/sdk/availability/Stage$Domain;

    if-ne v10, v11, :cond_c

    .line 106
    const-string/jumbo v9, "https://mas-sdk.amazon.com/service/config/getAvailabilityConfiguration"

    .line 110
    .local v9, "url":Ljava/lang/String;
    :goto_1
    new-instance v10, Lcom/amazon/mas/http/Web$Request;

    iget-object v11, p0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;->webClient:Lcom/amazon/mas/http/Web;

    invoke-virtual {v11}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v10, v11}, Lcom/amazon/mas/http/Web$Request;-><init>(Lcom/amazon/mas/http/Web;)V

    sget-object v11, Lcom/amazon/mas/http/Web$HttpMethod;->POST:Lcom/amazon/mas/http/Web$HttpMethod;

    invoke-virtual {v10, v11}, Lcom/amazon/mas/http/Web$Request;->setMethod(Lcom/amazon/mas/http/Web$HttpMethod;)Lcom/amazon/mas/http/Web$Request;

    move-result-object v10

    invoke-virtual {v10, v9}, Lcom/amazon/mas/http/Web$Request;->setUrl(Ljava/lang/String;)Lcom/amazon/mas/http/Web$Request;

    move-result-object v10

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/amazon/mas/http/Web$Request;->setPostBody(Ljava/lang/String;)Lcom/amazon/mas/http/Web$Request;

    move-result-object v3

    .line 112
    .local v3, "request":Lcom/amazon/mas/http/Web$Request;
    iget-object v10, p0, Lcom/amazon/sdk/availability/ConfigurationClientImpl;->webClient:Lcom/amazon/mas/http/Web;

    invoke-virtual {v10, v3}, Lcom/amazon/mas/http/Web;->execute(Lcom/amazon/mas/http/Web$Request;)Lcom/amazon/mas/http/Web$Response;

    move-result-object v5

    .line 115
    .local v5, "response":Lcom/amazon/mas/http/Web$Response;
    const/4 v7, 0x0

    .line 116
    .local v7, "result":Lcom/amazon/sdk/availability/Configuration;
    invoke-virtual {v5}, Lcom/amazon/mas/http/Web$Response;->getCode()I

    move-result v10

    const/16 v11, 0xc8

    if-ne v10, v11, :cond_d

    .line 118
    :try_start_1
    invoke-virtual {v5}, Lcom/amazon/mas/http/Web$Response;->getResponse()Ljava/lang/String;

    move-result-object v6

    .line 119
    .local v6, "responseStr":Ljava/lang/String;
    new-instance v8, Lcom/amazon/sdk/availability/Configuration;

    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-direct {v8, v10}, Lcom/amazon/sdk/availability/Configuration;-><init>(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .end local v7    # "result":Lcom/amazon/sdk/availability/Configuration;
    .local v8, "result":Lcom/amazon/sdk/availability/Configuration;
    move-object v7, v8

    .line 127
    .end local v6    # "responseStr":Ljava/lang/String;
    .end local v8    # "result":Lcom/amazon/sdk/availability/Configuration;
    .restart local v7    # "result":Lcom/amazon/sdk/availability/Configuration;
    :goto_2
    return-object v7

    .line 99
    .end local v3    # "request":Lcom/amazon/mas/http/Web$Request;
    .end local v5    # "response":Lcom/amazon/mas/http/Web$Response;
    .end local v7    # "result":Lcom/amazon/sdk/availability/Configuration;
    .end local v9    # "url":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 100
    .local v2, "e":Lorg/json/JSONException;
    const-string/jumbo v10, "error building configuration request body"

    invoke-static {v10, v2}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 108
    .end local v2    # "e":Lorg/json/JSONException;
    :cond_c
    const-string/jumbo v9, "https://mas-sdk.amazon.com/service/config/version/gamma/getAvailabilityConfiguration"

    .restart local v9    # "url":Ljava/lang/String;
    goto :goto_1

    .line 120
    .restart local v3    # "request":Lcom/amazon/mas/http/Web$Request;
    .restart local v5    # "response":Lcom/amazon/mas/http/Web$Response;
    .restart local v7    # "result":Lcom/amazon/sdk/availability/Configuration;
    :catch_1
    move-exception v2

    .line 121
    .restart local v2    # "e":Lorg/json/JSONException;
    const-string/jumbo v10, "error parsing service response"

    invoke-static {v10, v2}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 124
    .end local v2    # "e":Lorg/json/JSONException;
    :cond_d
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "service error: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v5}, Lcom/amazon/mas/http/Web$Response;->getMessage()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string/jumbo v11, "("

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v5}, Lcom/amazon/mas/http/Web$Response;->getCode()I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string/jumbo v11, ")"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;)V

    goto :goto_2
.end method
