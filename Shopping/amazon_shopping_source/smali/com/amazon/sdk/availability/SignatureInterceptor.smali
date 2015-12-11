.class public Lcom/amazon/sdk/availability/SignatureInterceptor;
.super Ljava/lang/Object;
.source "SignatureInterceptor.java"

# interfaces
.implements Lcom/amazon/mas/http/Web$Interceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public after(Lcom/amazon/mas/http/Web$Response;)V
    .locals 0
    .param p1, "response"    # Lcom/amazon/mas/http/Web$Response;

    .prologue
    .line 98
    return-void
.end method

.method public before(Lcom/amazon/mas/http/Web$Request;)V
    .locals 21
    .param p1, "request"    # Lcom/amazon/mas/http/Web$Request;

    .prologue
    .line 55
    if-eqz p1, :cond_0

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mas/http/Web$Request;->getPostBody()Ljava/lang/String;

    move-result-object v18

    if-eqz v18, :cond_0

    .line 56
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mas/http/Web$Request;->getPostBody()Ljava/lang/String;

    move-result-object v12

    .line 58
    .local v12, "postBody":Ljava/lang/String;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v12}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 60
    .local v3, "bodyJson":Lorg/json/JSONObject;
    const-string/jumbo v18, "sdkVersion"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 61
    .local v14, "sdkVersion":Ljava/lang/String;
    const-string/jumbo v18, "marketplaceId"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 62
    .local v11, "marketplaceId":Ljava/lang/String;
    const-string/jumbo v18, "customerId"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 63
    .local v4, "customerId":Ljava/lang/String;
    const-string/jumbo v18, "region"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 64
    .local v13, "region":Ljava/lang/String;
    const-string/jumbo v18, "deviceType"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 65
    .local v9, "deviceType":Ljava/lang/String;
    const-string/jumbo v18, "deviceMake"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 66
    .local v6, "deviceMake":Ljava/lang/String;
    const-string/jumbo v18, "deviceModel"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 67
    .local v7, "deviceModel":Ljava/lang/String;
    const-string/jumbo v18, "deviceOs"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 68
    .local v8, "deviceOs":Ljava/lang/String;
    const-string/jumbo v18, "deviceCarrier"

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 69
    .local v5, "deviceCarrier":Ljava/lang/String;
    const-string/jumbo v18, "timestamp"

    const-wide/16 v19, 0x0

    move-object/from16 v0, v18

    move-wide/from16 v1, v19

    invoke-virtual {v3, v0, v1, v2}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v18

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v17

    .line 71
    .local v17, "timestamp":Ljava/lang/Long;
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "&"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 82
    .local v16, "stringToSign":Ljava/lang/String;
    const-string/jumbo v18, "l1UzmagX6XhERqhgSwdSNDP4gDjEvZh5OWaEiOD5"

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-static {v0, v1}, Lcom/amazon/sdk/availability/AwsUtil;->hmacSha1(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 84
    .local v15, "signature":Ljava/lang/String;
    const-string/jumbo v18, "X-sdk-RequestSignature"

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v15}, Lcom/amazon/mas/http/Web$Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mas/http/Web$Request;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 90
    .end local v3    # "bodyJson":Lorg/json/JSONObject;
    .end local v4    # "customerId":Ljava/lang/String;
    .end local v5    # "deviceCarrier":Ljava/lang/String;
    .end local v6    # "deviceMake":Ljava/lang/String;
    .end local v7    # "deviceModel":Ljava/lang/String;
    .end local v8    # "deviceOs":Ljava/lang/String;
    .end local v9    # "deviceType":Ljava/lang/String;
    .end local v11    # "marketplaceId":Ljava/lang/String;
    .end local v12    # "postBody":Ljava/lang/String;
    .end local v13    # "region":Ljava/lang/String;
    .end local v14    # "sdkVersion":Ljava/lang/String;
    .end local v15    # "signature":Ljava/lang/String;
    .end local v16    # "stringToSign":Ljava/lang/String;
    .end local v17    # "timestamp":Ljava/lang/Long;
    :cond_0
    :goto_0
    return-void

    .line 85
    .restart local v12    # "postBody":Ljava/lang/String;
    :catch_0
    move-exception v10

    .line 86
    .local v10, "e":Lorg/json/JSONException;
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v19, "failed to parse JSON request body: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/amazon/sdk/availability/Logger;->v(Ljava/lang/String;)V

    .line 87
    const-string/jumbo v18, "failed to parse JSON request body"

    move-object/from16 v0, v18

    invoke-static {v0, v10}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
