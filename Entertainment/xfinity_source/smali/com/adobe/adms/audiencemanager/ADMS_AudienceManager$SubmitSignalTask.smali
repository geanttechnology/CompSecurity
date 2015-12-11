.class Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;
.super Ljava/lang/Object;
.source "ADMS_AudienceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SubmitSignalTask"
.end annotation


# instance fields
.field public callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback",
            "<",
            "Ljava/util/HashMap;",
            ">;"
        }
    .end annotation
.end field

.field public data:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/HashMap;Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback",
            "<",
            "Ljava/util/HashMap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 122
    .local p1, "initData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p2, "initCallback":Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;, "Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback<Ljava/util/HashMap;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 124
    iput-object p1, p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->data:Ljava/util/HashMap;

    .line 125
    iput-object p2, p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    .line 126
    return-void
.end method


# virtual methods
.method public run()V
    .locals 29

    .prologue
    .line 130
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->data:Ljava/util/HashMap;

    move-object/from16 v25, v0

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->BuildSchemaRequest(Ljava/util/HashMap;)Ljava/lang/String;
    invoke-static/range {v25 .. v25}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$000(Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v16

    .line 132
    .local v16, "requestUrl":Ljava/lang/String;
    const-string v25, "Audience Manager - request (%s)"

    const/16 v26, 0x1

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    aput-object v16, v26, v27

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$100(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 134
    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v25

    if-lez v25, :cond_9

    .line 135
    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    .line 136
    .local v19, "sb":Ljava/lang/StringBuilder;
    new-instance v3, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v3}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 139
    .local v3, "client":Lorg/apache/http/client/HttpClient;
    :try_start_0
    new-instance v9, Lorg/apache/http/client/methods/HttpGet;

    move-object/from16 v0, v16

    invoke-direct {v9, v0}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 146
    .local v9, "get":Lorg/apache/http/client/methods/HttpGet;
    const/4 v4, 0x0

    .line 147
    .local v4, "content":Ljava/io/InputStream;
    const/4 v14, 0x0

    .line 150
    .local v14, "reader":Ljava/io/BufferedReader;
    :try_start_1
    invoke-interface {v3, v9}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v17

    .line 151
    .local v17, "response":Lorg/apache/http/HttpResponse;
    invoke-interface/range {v17 .. v17}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v21

    .line 152
    .local v21, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface/range {v21 .. v21}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v20

    .line 153
    .local v20, "statusCode":I
    const/16 v25, 0xc8

    move/from16 v0, v20

    move/from16 v1, v25

    if-ne v0, v1, :cond_2

    .line 154
    invoke-interface/range {v17 .. v17}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v8

    .line 155
    .local v8, "entity":Lorg/apache/http/HttpEntity;
    invoke-interface {v8}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v4

    .line 156
    new-instance v15, Ljava/io/BufferedReader;

    new-instance v25, Ljava/io/InputStreamReader;

    const-string v26, "UTF-8"

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v0, v4, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    move-object/from16 v0, v25

    invoke-direct {v15, v0}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_7
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 158
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .local v15, "reader":Ljava/io/BufferedReader;
    :goto_0
    :try_start_2
    invoke-virtual {v15}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v13

    .local v13, "line":Ljava/lang/String;
    if-eqz v13, :cond_4

    .line 159
    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 217
    .end local v13    # "line":Ljava/lang/String;
    :catch_0
    move-exception v7

    move-object v14, v15

    .line 218
    .end local v8    # "entity":Lorg/apache/http/HttpEntity;
    .end local v15    # "reader":Ljava/io/BufferedReader;
    .end local v17    # "response":Lorg/apache/http/HttpResponse;
    .end local v20    # "statusCode":I
    .end local v21    # "statusLine":Lorg/apache/http/StatusLine;
    .local v7, "e":Ljava/lang/Exception;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    :goto_1
    :try_start_3
    const-string v25, "Audience Manager - Problem communicating with the server (%s)"

    const/16 v26, 0x1

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    invoke-virtual {v7}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v28

    aput-object v28, v26, v27

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$200(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 219
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    if-eqz v25, :cond_0

    .line 220
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    invoke-interface/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;->call(Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 226
    :cond_0
    :try_start_4
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 227
    invoke-virtual {v14}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_6

    .line 238
    .end local v3    # "client":Lorg/apache/http/client/HttpClient;
    .end local v4    # "content":Ljava/io/InputStream;
    .end local v7    # "e":Ljava/lang/Exception;
    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .end local v19    # "sb":Ljava/lang/StringBuilder;
    :cond_1
    :goto_2
    return-void

    .line 141
    .restart local v3    # "client":Lorg/apache/http/client/HttpClient;
    .restart local v19    # "sb":Ljava/lang/StringBuilder;
    :catch_1
    move-exception v7

    .line 142
    .restart local v7    # "e":Ljava/lang/Exception;
    const-string v25, "Audience Manager - Error creating URL query string (%s)"

    const/16 v26, 0x1

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    invoke-virtual {v7}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v28

    aput-object v28, v26, v27

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$200(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 163
    .end local v7    # "e":Ljava/lang/Exception;
    .restart local v4    # "content":Ljava/io/InputStream;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v17    # "response":Lorg/apache/http/HttpResponse;
    .restart local v20    # "statusCode":I
    .restart local v21    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_2
    :try_start_5
    const-string v25, "Audience Manager - No response from server"

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$200(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 164
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    if-eqz v25, :cond_3

    .line 165
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    invoke-interface/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;->call(Ljava/lang/Object;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_7
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 226
    :cond_3
    :try_start_6
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 227
    invoke-virtual {v14}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    goto :goto_2

    .line 228
    :catch_2
    move-exception v25

    goto :goto_2

    .line 171
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v8    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v13    # "line":Ljava/lang/String;
    .restart local v15    # "reader":Ljava/io/BufferedReader;
    :cond_4
    :try_start_7
    new-instance v12, Lorg/json/JSONObject;

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-direct {v12, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 174
    .local v12, "jsonResponse":Lorg/json/JSONObject;
    const-string v25, "dests"

    move-object/from16 v0, v25

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    move-result-object v6

    .line 175
    .local v6, "dests":Lorg/json/JSONArray;
    const/4 v11, 0x0

    .local v11, "i":I
    move-object v10, v9

    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .local v10, "get":Lorg/apache/http/client/methods/HttpGet;
    :goto_3
    :try_start_8
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v25

    move/from16 v0, v25

    if-ge v11, v0, :cond_5

    .line 176
    invoke-virtual {v6, v11}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 177
    .local v5, "dest":Lorg/json/JSONObject;
    const-string v25, "c"

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 178
    .local v24, "url":Ljava/lang/String;
    const-string v25, "Audience Manager - forwarding \'dests\' request (%s)"

    const/16 v26, 0x1

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    aput-object v24, v26, v27

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$100(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 179
    if-eqz v24, :cond_a

    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v25

    if-lez v25, :cond_a

    .line 180
    new-instance v9, Lorg/apache/http/client/methods/HttpGet;

    move-object/from16 v0, v24

    invoke-direct {v9, v0}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    .line 183
    .end local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    :try_start_9
    invoke-interface {v3, v9}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_3
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 175
    :goto_4
    add-int/lit8 v11, v11, 0x1

    move-object v10, v9

    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    goto :goto_3

    .line 185
    .end local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    :catch_3
    move-exception v7

    .line 186
    .restart local v7    # "e":Ljava/lang/Exception;
    :try_start_a
    const-string v25, "Audience Manager - Unable to send dests hit for url (%s), (%s)"

    const/16 v26, 0x2

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    aput-object v24, v26, v27

    const/16 v27, 0x1

    invoke-virtual {v7}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v28

    aput-object v28, v26, v27

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$200(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_0
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto :goto_4

    .line 225
    .end local v5    # "dest":Lorg/json/JSONObject;
    .end local v6    # "dests":Lorg/json/JSONArray;
    .end local v7    # "e":Ljava/lang/Exception;
    .end local v11    # "i":I
    .end local v12    # "jsonResponse":Lorg/json/JSONObject;
    .end local v13    # "line":Ljava/lang/String;
    .end local v24    # "url":Ljava/lang/String;
    :catchall_0
    move-exception v25

    move-object v14, v15

    .line 226
    .end local v8    # "entity":Lorg/apache/http/HttpEntity;
    .end local v15    # "reader":Ljava/io/BufferedReader;
    .end local v17    # "response":Lorg/apache/http/HttpResponse;
    .end local v20    # "statusCode":I
    .end local v21    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    :goto_5
    :try_start_b
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 227
    invoke-virtual {v14}, Ljava/io/BufferedReader;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_5

    .line 228
    :goto_6
    throw v25

    .line 192
    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "dests":Lorg/json/JSONArray;
    .restart local v8    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v11    # "i":I
    .restart local v12    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v13    # "line":Ljava/lang/String;
    .restart local v15    # "reader":Ljava/io/BufferedReader;
    .restart local v17    # "response":Lorg/apache/http/HttpResponse;
    .restart local v20    # "statusCode":I
    .restart local v21    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_5
    :try_start_c
    const-string v25, "uuid"

    move-object/from16 v0, v25

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SetUUID(Ljava/lang/String;)V
    invoke-static/range {v25 .. v25}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$300(Ljava/lang/String;)V

    .line 195
    const-string v25, "stuff"

    move-object/from16 v0, v25

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v23

    .line 198
    .local v23, "stuffArray":Lorg/json/JSONArray;
    new-instance v18, Ljava/util/HashMap;

    invoke-direct/range {v18 .. v18}, Ljava/util/HashMap;-><init>()V

    .line 199
    .local v18, "returnedMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v11, 0x0

    :goto_7
    invoke-virtual/range {v23 .. v23}, Lorg/json/JSONArray;->length()I

    move-result v25

    move/from16 v0, v25

    if-ge v11, v0, :cond_7

    .line 200
    move-object/from16 v0, v23

    invoke-virtual {v0, v11}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v22

    .line 201
    .local v22, "stuff":Lorg/json/JSONObject;
    if-eqz v22, :cond_6

    .line 202
    const-string v25, "cn"

    move-object/from16 v0, v22

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    const-string v26, "cv"

    move-object/from16 v0, v22

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v18

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 199
    :cond_6
    add-int/lit8 v11, v11, 0x1

    goto :goto_7

    .line 207
    .end local v22    # "stuff":Lorg/json/JSONObject;
    :cond_7
    const-string v25, "Audience Manager - response (%s)"

    const/16 v26, 0x1

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    const/16 v27, 0x0

    aput-object v18, v26, v27

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$100(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 210
    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SetVisitorProfile(Ljava/util/HashMap;)V
    invoke-static/range {v18 .. v18}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$400(Ljava/util/HashMap;)V

    .line 213
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    if-eqz v25, :cond_8

    .line 214
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;->call(Ljava/lang/Object;)V
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_8
    .catchall {:try_start_c .. :try_end_c} :catchall_2

    .line 226
    :cond_8
    :try_start_d
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 227
    invoke-virtual {v15}, Ljava/io/BufferedReader;->close()V
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_4

    goto/16 :goto_2

    .line 228
    :catch_4
    move-exception v25

    goto/16 :goto_2

    .line 232
    .end local v3    # "client":Lorg/apache/http/client/HttpClient;
    .end local v4    # "content":Ljava/io/InputStream;
    .end local v6    # "dests":Lorg/json/JSONArray;
    .end local v8    # "entity":Lorg/apache/http/HttpEntity;
    .end local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v11    # "i":I
    .end local v12    # "jsonResponse":Lorg/json/JSONObject;
    .end local v13    # "line":Ljava/lang/String;
    .end local v15    # "reader":Ljava/io/BufferedReader;
    .end local v17    # "response":Lorg/apache/http/HttpResponse;
    .end local v18    # "returnedMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v19    # "sb":Ljava/lang/StringBuilder;
    .end local v20    # "statusCode":I
    .end local v21    # "statusLine":Lorg/apache/http/StatusLine;
    .end local v23    # "stuffArray":Lorg/json/JSONArray;
    :cond_9
    const-string v25, "Audience Manager - Unable to create URL object"

    const/16 v26, 0x0

    move/from16 v0, v26

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v26, v0

    # invokes: Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    invoke-static/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->access$200(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 234
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    if-eqz v25, :cond_1

    .line 235
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;->callback:Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    invoke-interface/range {v25 .. v26}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;->call(Ljava/lang/Object;)V

    goto/16 :goto_2

    .line 228
    .restart local v3    # "client":Lorg/apache/http/client/HttpClient;
    .restart local v4    # "content":Ljava/io/InputStream;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v19    # "sb":Ljava/lang/StringBuilder;
    :catch_5
    move-exception v26

    goto/16 :goto_6

    .line 225
    :catchall_1
    move-exception v25

    goto/16 :goto_5

    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "dests":Lorg/json/JSONArray;
    .restart local v8    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v11    # "i":I
    .restart local v12    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v13    # "line":Ljava/lang/String;
    .restart local v15    # "reader":Ljava/io/BufferedReader;
    .restart local v17    # "response":Lorg/apache/http/HttpResponse;
    .restart local v20    # "statusCode":I
    .restart local v21    # "statusLine":Lorg/apache/http/StatusLine;
    :catchall_2
    move-exception v25

    move-object v14, v15

    .end local v15    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    move-object v9, v10

    .end local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    goto/16 :goto_5

    .line 228
    .end local v6    # "dests":Lorg/json/JSONArray;
    .end local v8    # "entity":Lorg/apache/http/HttpEntity;
    .end local v11    # "i":I
    .end local v12    # "jsonResponse":Lorg/json/JSONObject;
    .end local v13    # "line":Ljava/lang/String;
    .end local v17    # "response":Lorg/apache/http/HttpResponse;
    .end local v20    # "statusCode":I
    .end local v21    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v7    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v25

    goto/16 :goto_2

    .line 217
    .end local v7    # "e":Ljava/lang/Exception;
    :catch_7
    move-exception v7

    goto/16 :goto_1

    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v6    # "dests":Lorg/json/JSONArray;
    .restart local v8    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v11    # "i":I
    .restart local v12    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v13    # "line":Ljava/lang/String;
    .restart local v15    # "reader":Ljava/io/BufferedReader;
    .restart local v17    # "response":Lorg/apache/http/HttpResponse;
    .restart local v20    # "statusCode":I
    .restart local v21    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_8
    move-exception v7

    move-object v14, v15

    .end local v15    # "reader":Ljava/io/BufferedReader;
    .restart local v14    # "reader":Ljava/io/BufferedReader;
    move-object v9, v10

    .end local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    goto/16 :goto_1

    .end local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v14    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "dest":Lorg/json/JSONObject;
    .restart local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v15    # "reader":Ljava/io/BufferedReader;
    .restart local v24    # "url":Ljava/lang/String;
    :cond_a
    move-object v9, v10

    .end local v10    # "get":Lorg/apache/http/client/methods/HttpGet;
    .restart local v9    # "get":Lorg/apache/http/client/methods/HttpGet;
    goto/16 :goto_4
.end method
