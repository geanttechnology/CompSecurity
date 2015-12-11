.class public Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;
.super Ljava/lang/Object;
.source "AudienceManagerWorker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/AudienceManagerWorker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SubmitSignalTask"
.end annotation


# instance fields
.field public final callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field public final data:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Map;Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 151
    .local p1, "initData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p2, "initCallback":Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;, "Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 153
    iput-object p1, p0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->data:Ljava/util/Map;

    .line 154
    iput-object p2, p0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    .line 155
    return-void
.end method


# virtual methods
.method public run()V
    .locals 22

    .prologue
    .line 161
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 165
    .local v2, "callbackData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/adobe/mobile/MobileConfig;->mobileUsingAudienceManager()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v18

    if-nez v18, :cond_1

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    .line 254
    :cond_0
    :goto_0
    return-void

    .line 170
    :cond_1
    :try_start_1
    invoke-static {}, Lcom/adobe/mobile/MobileConfig;->getInstance()Lcom/adobe/mobile/MobileConfig;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/adobe/mobile/MobileConfig;->getPrivacyStatus()Lcom/adobe/mobile/MobilePrivacyStatus;

    move-result-object v18

    sget-object v19, Lcom/adobe/mobile/MobilePrivacyStatus;->MOBILE_PRIVACY_STATUS_OPT_OUT:Lcom/adobe/mobile/MobilePrivacyStatus;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-ne v0, v1, :cond_2

    .line 171
    const-string v18, "Audience Manager - Privacy status is set to opt out, no signals will be submitted."

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 175
    :cond_2
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->data:Ljava/util/Map;

    move-object/from16 v18, v0

    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->BuildSchemaRequest(Ljava/util/Map;)Ljava/lang/String;
    invoke-static/range {v18 .. v18}, Lcom/adobe/mobile/AudienceManagerWorker;->access$400(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v12

    .line 177
    .local v12, "requestUrl":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v18

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_3

    .line 178
    const-string v18, "Audience Manager - Unable to create URL object"

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 182
    :cond_3
    :try_start_3
    const-string v18, "Audience Manager - request (%s)"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v12, v19, v20

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 184
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    .line 185
    .local v15, "sb":Ljava/lang/StringBuilder;
    new-instance v3, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v3}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 186
    .local v3, "client":Lorg/apache/http/impl/client/DefaultHttpClient;
    new-instance v7, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v7, v12}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 188
    .local v7, "get":Lorg/apache/http/client/methods/HttpGet;
    invoke-virtual {v3, v7}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v8

    .line 190
    .local v8, "httpResponse":Lorg/apache/http/HttpResponse;
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v17

    .line 191
    .local v17, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface/range {v17 .. v17}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v16

    .line 193
    .local v16, "statusCode":I
    const/16 v18, 0xc8

    move/from16 v0, v16

    move/from16 v1, v18

    if-ne v0, v1, :cond_5

    .line 194
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v6

    .line 195
    .local v6, "entity":Lorg/apache/http/HttpEntity;
    invoke-interface {v6}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v4

    .line 196
    .local v4, "content":Ljava/io/InputStream;
    new-instance v11, Ljava/io/BufferedReader;

    new-instance v18, Ljava/io/InputStreamReader;

    const-string v19, "UTF-8"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v4, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    move-object/from16 v0, v18

    invoke-direct {v11, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 199
    .local v11, "reader":Ljava/io/BufferedReader;
    :goto_1
    invoke-virtual {v11}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v10

    .local v10, "line":Ljava/lang/String;
    if-eqz v10, :cond_4

    .line 200
    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 234
    .end local v3    # "client":Lorg/apache/http/impl/client/DefaultHttpClient;
    .end local v4    # "content":Ljava/io/InputStream;
    .end local v6    # "entity":Lorg/apache/http/HttpEntity;
    .end local v7    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v8    # "httpResponse":Lorg/apache/http/HttpResponse;
    .end local v10    # "line":Ljava/lang/String;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    .end local v12    # "requestUrl":Ljava/lang/String;
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    .end local v16    # "statusCode":I
    .end local v17    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_0
    move-exception v5

    .line 235
    .local v5, "e":Ljava/io/IOException;
    :try_start_4
    const-string v18, "Audience Manager - Unable to read response from server (%s)"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v5}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    .line 203
    .end local v5    # "e":Ljava/io/IOException;
    .restart local v3    # "client":Lorg/apache/http/impl/client/DefaultHttpClient;
    .restart local v4    # "content":Ljava/io/InputStream;
    .restart local v6    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v7    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v8    # "httpResponse":Lorg/apache/http/HttpResponse;
    .restart local v10    # "line":Ljava/lang/String;
    .restart local v11    # "reader":Ljava/io/BufferedReader;
    .restart local v12    # "requestUrl":Ljava/lang/String;
    .restart local v15    # "sb":Ljava/lang/StringBuilder;
    .restart local v16    # "statusCode":I
    .restart local v17    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_4
    :try_start_5
    invoke-virtual {v11}, Ljava/io/BufferedReader;->close()V

    .line 206
    .end local v4    # "content":Ljava/io/InputStream;
    .end local v6    # "entity":Lorg/apache/http/HttpEntity;
    .end local v10    # "line":Ljava/lang/String;
    .end local v11    # "reader":Ljava/io/BufferedReader;
    :cond_5
    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 209
    .local v13, "response":Ljava/lang/String;
    new-instance v9, Lorg/json/JSONObject;

    invoke-direct {v9, v13}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 212
    .local v9, "jsonResponse":Lorg/json/JSONObject;
    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->ProcessDestsArray(Lorg/json/JSONObject;)V
    invoke-static {v9}, Lcom/adobe/mobile/AudienceManagerWorker;->access$500(Lorg/json/JSONObject;)V

    .line 215
    const-string v18, "uuid"

    move-object/from16 v0, v18

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->SetUUID(Ljava/lang/String;)V
    invoke-static/range {v18 .. v18}, Lcom/adobe/mobile/AudienceManagerWorker;->access$600(Ljava/lang/String;)V

    .line 218
    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->ProcessStuffArray(Lorg/json/JSONObject;)Ljava/util/HashMap;
    invoke-static {v9}, Lcom/adobe/mobile/AudienceManagerWorker;->access$700(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v14

    .line 221
    .local v14, "returnedMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {v14}, Ljava/util/HashMap;->size()I

    move-result v18

    if-gtz v18, :cond_6

    .line 222
    const-string v18, "Audience Manager - response was empty"

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    .line 226
    :cond_6
    :try_start_6
    const-string v18, "Audience Manager - response (%s)"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v14, v19, v20

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 229
    # invokes: Lcom/adobe/mobile/AudienceManagerWorker;->SetVisitorProfile(Ljava/util/Map;)V
    invoke-static {v14}, Lcom/adobe/mobile/AudienceManagerWorker;->access$800(Ljava/util/Map;)V

    .line 232
    invoke-virtual {v2, v14}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    .line 237
    .end local v3    # "client":Lorg/apache/http/impl/client/DefaultHttpClient;
    .end local v7    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v8    # "httpResponse":Lorg/apache/http/HttpResponse;
    .end local v9    # "jsonResponse":Lorg/json/JSONObject;
    .end local v12    # "requestUrl":Ljava/lang/String;
    .end local v13    # "response":Ljava/lang/String;
    .end local v14    # "returnedMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v15    # "sb":Ljava/lang/StringBuilder;
    .end local v16    # "statusCode":I
    .end local v17    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_1
    move-exception v5

    .line 238
    .local v5, "e":Lorg/json/JSONException;
    :try_start_7
    const-string v18, "Audience Manager - Unable to parse JSON data (%s)"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v5}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    .line 240
    .end local v5    # "e":Lorg/json/JSONException;
    :catch_2
    move-exception v5

    .line 241
    .local v5, "e":Ljava/lang/Exception;
    :try_start_8
    const-string v18, "Audience Manager - Unexpected error parsing result (%s)"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v5}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    .line 246
    new-instance v18, Ljava/lang/Thread;

    new-instance v19, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v18 .. v19}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v18 .. v18}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    .line 245
    .end local v5    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;->callback:Lcom/adobe/mobile/AudienceManager$AudienceManagerCallback;

    move-object/from16 v19, v0

    if-eqz v19, :cond_7

    .line 246
    new-instance v19, Ljava/lang/Thread;

    new-instance v20, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v2}, Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask$1;-><init>(Lcom/adobe/mobile/AudienceManagerWorker$SubmitSignalTask;Ljava/util/HashMap;)V

    invoke-direct/range {v19 .. v20}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 251
    invoke-virtual/range {v19 .. v19}, Ljava/lang/Thread;->start()V

    :cond_7
    throw v18
.end method
