.class Lio/branch/referral/RemoteInterface;
.super Ljava/lang/Object;
.source "RemoteInterface.java"


# static fields
.field public static final BRANCH_KEY:Ljava/lang/String; = "branch_key"

.field private static final DEFAULT_TIMEOUT:I = 0xbb8

.field public static final NO_BRANCH_KEY_STATUS:I = -0x4d2

.field public static final NO_CONNECTIVITY_STATUS:I = -0x3f1

.field private static final SDK_VERSION:Ljava/lang/String; = "1.10.1"


# instance fields
.field protected prefHelper_:Lio/branch/referral/PrefHelper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    invoke-static {p1}, Lio/branch/referral/PrefHelper;->getInstance(Landroid/content/Context;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    .line 54
    return-void
.end method

.method private addCommonParams(Lorg/json/JSONObject;I)Z
    .locals 5
    .param p1, "post"    # Lorg/json/JSONObject;
    .param p2, "retryNumber"    # I

    .prologue
    const/4 v2, 0x1

    .line 122
    :try_start_0
    iget-object v3, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v1

    .line 123
    .local v1, "branch_key":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getAppKey()Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "app_key":Ljava/lang/String;
    const-string v3, "sdk"

    const-string v4, "android1.10.1"

    invoke-virtual {p1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 126
    const-string v3, "retryNumber"

    invoke-virtual {p1, v3, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 127
    const-string v3, "bnc_no_value"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 128
    const-string v3, "branch_key"

    iget-object v4, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 136
    .end local v0    # "app_key":Ljava/lang/String;
    .end local v1    # "branch_key":Ljava/lang/String;
    :goto_0
    return v2

    .line 130
    .restart local v0    # "app_key":Ljava/lang/String;
    .restart local v1    # "branch_key":Ljava/lang/String;
    :cond_0
    const-string v3, "bnc_no_value"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 131
    const-string v3, "app_id"

    iget-object v4, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getAppKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 134
    .end local v0    # "app_key":Ljava/lang/String;
    .end local v1    # "branch_key":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 136
    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private convertJSONtoString(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 10
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 356
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 358
    .local v5, "result":Ljava/lang/StringBuilder;
    if-eqz p1, :cond_1

    .line 359
    invoke-virtual {p1}, Lorg/json/JSONObject;->names()Lorg/json/JSONArray;

    move-result-object v4

    .line 360
    .local v4, "names":Lorg/json/JSONArray;
    if-eqz v4, :cond_1

    .line 361
    const/4 v1, 0x1

    .line 362
    .local v1, "first":Z
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 363
    .local v6, "size":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v6, :cond_1

    .line 365
    :try_start_0
    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 367
    .local v3, "key":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 368
    const-string v8, "?"

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 369
    const/4 v1, 0x0

    .line 374
    :goto_1
    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 375
    .local v7, "value":Ljava/lang/String;
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 363
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 371
    .end local v7    # "value":Ljava/lang/String;
    :cond_0
    const-string v8, "&"

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 376
    .end local v3    # "key":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 377
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 378
    const/4 v8, 0x0

    .line 384
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "first":Z
    .end local v2    # "i":I
    .end local v4    # "names":Lorg/json/JSONArray;
    .end local v6    # "size":I
    :goto_2
    return-object v8

    :cond_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_2
.end method

.method private make_restful_get(Ljava/lang/String;Ljava/lang/String;IIZ)Lio/branch/referral/ServerResponse;
    .locals 14
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "timeout"    # I
    .param p4, "retryNumber"    # I
    .param p5, "log"    # Z

    .prologue
    .line 152
    move-object v12, p1

    .line 153
    .local v12, "modifiedUrl":Ljava/lang/String;
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11}, Lorg/json/JSONObject;-><init>()V

    .line 154
    .local v11, "getParameters":Lorg/json/JSONObject;
    const/4 v8, 0x0

    .line 155
    .local v8, "connection":Ljavax/net/ssl/HttpsURLConnection;
    if-gtz p3, :cond_0

    .line 156
    const/16 p3, 0xbb8

    .line 158
    :cond_0
    move/from16 v0, p4

    invoke-direct {p0, v11, v0}, Lio/branch/referral/RemoteInterface;->addCommonParams(Lorg/json/JSONObject;I)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 159
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-direct {p0, v11}, Lio/branch/referral/RemoteInterface;->convertJSONtoString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 165
    if-eqz p5, :cond_1

    :try_start_0
    const-string v2, "BranchSDK"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "getting "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    :cond_1
    new-instance v13, Ljava/net/URL;

    invoke-direct {v13, v12}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 167
    .local v13, "urlObject":Ljava/net/URL;
    invoke-virtual {v13}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->openConnection(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    move-object v8, v0

    .line 168
    move/from16 v0, p3

    invoke-virtual {v8, v0}, Ljavax/net/ssl/HttpsURLConnection;->setConnectTimeout(I)V

    .line 169
    move/from16 v0, p3

    invoke-virtual {v8, v0}, Ljavax/net/ssl/HttpsURLConnection;->setReadTimeout(I)V

    .line 171
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v2

    const/16 v3, 0x1f4

    if-lt v2, v3, :cond_5

    iget-object v2, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getRetryCount()I
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    move/from16 v0, p4

    if-ge v0, v2, :cond_5

    .line 174
    :try_start_1
    iget-object v2, p0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getRetryInterval()I

    move-result v2

    int-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/net/SocketException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 178
    :goto_0
    add-int/lit8 p4, p4, 0x1

    .line 179
    :try_start_2
    invoke-direct/range {p0 .. p5}, Lio/branch/referral/RemoteInterface;->make_restful_get(Ljava/lang/String;Ljava/lang/String;IIZ)Lio/branch/referral/ServerResponse;
    :try_end_2
    .catch Ljava/net/SocketException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    .line 202
    if-eqz v8, :cond_2

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    .end local v13    # "urlObject":Ljava/net/URL;
    :cond_2
    :goto_1
    return-object v2

    .line 161
    :cond_3
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v3, -0x4d2

    move-object/from16 v0, p2

    invoke-direct {v2, v0, v3}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V

    goto :goto_1

    .line 175
    .restart local v13    # "urlObject":Ljava/net/URL;
    :catch_0
    move-exception v9

    .line 176
    .local v9, "e":Ljava/lang/InterruptedException;
    :try_start_3
    invoke-virtual {v9}, Ljava/lang/InterruptedException;->printStackTrace()V
    :try_end_3
    .catch Ljava/net/SocketException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 189
    .end local v9    # "e":Ljava/lang/InterruptedException;
    .end local v13    # "urlObject":Ljava/net/URL;
    :catch_1
    move-exception v10

    .line 190
    .local v10, "ex":Ljava/net/SocketException;
    if-eqz p5, :cond_4

    .line 191
    :try_start_4
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Http connect exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v10}, Ljava/net/SocketException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    :cond_4
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v3, -0x3f1

    move-object/from16 v0, p2

    invoke-direct {v2, v0, v3}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 202
    if-eqz v8, :cond_2

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto :goto_1

    .line 181
    .end local v10    # "ex":Ljava/net/SocketException;
    .restart local v13    # "urlObject":Ljava/net/URL;
    :cond_5
    :try_start_5
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v2

    const/16 v3, 0xc8

    if-eq v2, v3, :cond_6

    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 182
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v4

    const/4 v7, 0x0

    move-object v2, p0

    move-object/from16 v5, p2

    move/from16 v6, p5

    invoke-direct/range {v2 .. v7}, Lio/branch/referral/RemoteInterface;->processEntityForJSON(Ljava/io/InputStream;ILjava/lang/String;ZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    :try_end_5
    .catch Ljava/net/SocketException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v2

    .line 202
    if-eqz v8, :cond_2

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto :goto_1

    .line 185
    :cond_6
    :try_start_6
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v4

    const/4 v7, 0x0

    move-object v2, p0

    move-object/from16 v5, p2

    move/from16 v6, p5

    invoke-direct/range {v2 .. v7}, Lio/branch/referral/RemoteInterface;->processEntityForJSON(Ljava/io/InputStream;ILjava/lang/String;ZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    :try_end_6
    .catch Ljava/net/SocketException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v2

    .line 202
    if-eqz v8, :cond_2

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 193
    .end local v13    # "urlObject":Ljava/net/URL;
    :catch_2
    move-exception v10

    .line 194
    .local v10, "ex":Ljava/net/UnknownHostException;
    if-eqz p5, :cond_7

    .line 195
    :try_start_7
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Http connect exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v10}, Ljava/net/UnknownHostException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    :cond_7
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v3, -0x3f1

    move-object/from16 v0, p2

    invoke-direct {v2, v0, v3}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 202
    if-eqz v8, :cond_2

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 197
    .end local v10    # "ex":Ljava/net/UnknownHostException;
    :catch_3
    move-exception v10

    .line 198
    .local v10, "ex":Ljava/io/IOException;
    if-eqz p5, :cond_8

    .line 199
    :try_start_8
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "IO exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v10}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    :cond_8
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v3, 0x1f4

    move-object/from16 v0, p2

    invoke-direct {v2, v0, v3}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 202
    if-eqz v8, :cond_2

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 202
    .end local v10    # "ex":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    if-eqz v8, :cond_9

    .line 203
    invoke-virtual {v8}, Ljavax/net/ssl/HttpsURLConnection;->disconnect()V

    :cond_9
    throw v2
.end method

.method private make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IIZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    .locals 17
    .param p1, "body"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "timeout"    # I
    .param p5, "retryNumber"    # I
    .param p6, "log"    # Z
    .param p7, "linkData"    # Lio/branch/referral/BranchLinkData;

    .prologue
    .line 277
    const/4 v10, 0x0

    .line 278
    .local v10, "connection":Ljava/net/HttpURLConnection;
    if-gtz p4, :cond_0

    .line 279
    const/16 p4, 0xbb8

    .line 282
    :cond_0
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 283
    .local v3, "bodyCopy":Lorg/json/JSONObject;
    invoke-virtual/range {p1 .. p1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v14

    .line 284
    .local v14, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_0
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 285
    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 287
    .local v13, "key":Ljava/lang/String;
    :try_start_1
    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v3, v13, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/net/SocketException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 288
    :catch_0
    move-exception v11

    .line 289
    .local v11, "e":Lorg/json/JSONException;
    :try_start_2
    invoke-virtual {v11}, Lorg/json/JSONException;->printStackTrace()V
    :try_end_2
    .catch Ljava/net/SocketException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 332
    .end local v3    # "bodyCopy":Lorg/json/JSONObject;
    .end local v11    # "e":Lorg/json/JSONException;
    .end local v13    # "key":Ljava/lang/String;
    .end local v14    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :catch_1
    move-exception v12

    .line 333
    .local v12, "ex":Ljava/net/SocketException;
    if-eqz p6, :cond_1

    .line 334
    :try_start_3
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Http connect exception: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v12}, Ljava/net/SocketException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    :cond_1
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v4, -0x3f1

    move-object/from16 v0, p3

    invoke-direct {v2, v0, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    .end local v12    # "ex":Ljava/net/SocketException;
    :cond_2
    :goto_1
    return-object v2

    .line 293
    .restart local v3    # "bodyCopy":Lorg/json/JSONObject;
    .restart local v14    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :cond_3
    :try_start_4
    move-object/from16 v0, p0

    move/from16 v1, p5

    invoke-direct {v0, v3, v1}, Lio/branch/referral/RemoteInterface;->addCommonParams(Lorg/json/JSONObject;I)Z

    move-result v2

    if-nez v2, :cond_4

    .line 294
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v4, -0x4d2

    move-object/from16 v0, p3

    invoke-direct {v2, v0, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_4
    .catch Ljava/net/SocketException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_1

    .line 296
    :cond_4
    if-eqz p6, :cond_5

    .line 297
    :try_start_5
    const-string v2, "BranchSDK"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "posting to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p2

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    const-string v4, "BranchSDK"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Post value = "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/4 v6, 0x4

    instance-of v2, v3, Lorg/json/JSONObject;

    if-nez v2, :cond_6

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;

    move-result-object v2

    :goto_2
    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    :cond_5
    new-instance v16, Ljava/net/URL;

    move-object/from16 v0, v16

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 301
    .local v16, "urlObject":Ljava/net/URL;
    invoke-virtual/range {v16 .. v16}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/HttpInstrumentation;->openConnection(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v10, v0

    .line 302
    move/from16 v0, p4

    invoke-virtual {v10, v0}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 303
    move/from16 v0, p4

    invoke-virtual {v10, v0}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 304
    const/4 v2, 0x1

    invoke-virtual {v10, v2}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 305
    const/4 v2, 0x1

    invoke-virtual {v10, v2}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 306
    const-string v2, "Content-Type"

    const-string v4, "application/json"

    invoke-virtual {v10, v2, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    const-string v2, "Accept"

    const-string v4, "application/json"

    invoke-virtual {v10, v2, v4}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    const-string v2, "POST"

    invoke-virtual {v10, v2}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 310
    new-instance v15, Ljava/io/OutputStreamWriter;

    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v2

    invoke-direct {v15, v2}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 311
    .local v15, "outputStreamWriter":Ljava/io/OutputStreamWriter;
    instance-of v2, v3, Lorg/json/JSONObject;

    if-nez v2, :cond_7

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_3
    invoke-virtual {v15, v2}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 312
    invoke-virtual {v15}, Ljava/io/OutputStreamWriter;->flush()V

    .line 314
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    const/16 v4, 0x1f4

    if-lt v2, v4, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getRetryCount()I
    :try_end_5
    .catch Ljava/net/SocketException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result v2

    move/from16 v0, p5

    if-ge v0, v2, :cond_9

    .line 317
    :try_start_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lio/branch/referral/RemoteInterface;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getRetryInterval()I

    move-result v2

    int-to-long v4, v2

    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/net/SocketException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 321
    :goto_4
    add-int/lit8 p5, p5, 0x1

    move-object/from16 v2, p0

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p4

    move/from16 v7, p5

    move/from16 v8, p6

    move-object/from16 v9, p7

    .line 322
    :try_start_7
    invoke-direct/range {v2 .. v9}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IIZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    :try_end_7
    .catch Ljava/net/SocketException; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_7 .. :try_end_7} :catch_3
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_4
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    move-result-object v2

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 298
    .end local v15    # "outputStreamWriter":Ljava/io/OutputStreamWriter;
    .end local v16    # "urlObject":Ljava/net/URL;
    :cond_6
    :try_start_8
    move-object v0, v3

    check-cast v0, Lorg/json/JSONObject;

    move-object v2, v0

    invoke-static {v2, v6}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_2

    .line 311
    .restart local v15    # "outputStreamWriter":Ljava/io/OutputStreamWriter;
    .restart local v16    # "urlObject":Ljava/net/URL;
    :cond_7
    move-object v0, v3

    check-cast v0, Lorg/json/JSONObject;

    move-object v2, v0

    invoke-static {v2}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    .line 318
    :catch_2
    move-exception v11

    .line 319
    .local v11, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v11}, Ljava/lang/InterruptedException;->printStackTrace()V
    :try_end_8
    .catch Ljava/net/SocketException; {:try_start_8 .. :try_end_8} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_8 .. :try_end_8} :catch_3
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_4
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_4

    .line 336
    .end local v3    # "bodyCopy":Lorg/json/JSONObject;
    .end local v11    # "e":Ljava/lang/InterruptedException;
    .end local v14    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v15    # "outputStreamWriter":Ljava/io/OutputStreamWriter;
    .end local v16    # "urlObject":Ljava/net/URL;
    :catch_3
    move-exception v12

    .line 337
    .local v12, "ex":Ljava/net/UnknownHostException;
    if-eqz p6, :cond_8

    .line 338
    :try_start_9
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Http connect exception: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v12}, Ljava/net/UnknownHostException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    :cond_8
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v4, -0x3f1

    move-object/from16 v0, p3

    invoke-direct {v2, v0, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 324
    .end local v12    # "ex":Ljava/net/UnknownHostException;
    .restart local v3    # "bodyCopy":Lorg/json/JSONObject;
    .restart local v14    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .restart local v15    # "outputStreamWriter":Ljava/io/OutputStreamWriter;
    .restart local v16    # "urlObject":Ljava/net/URL;
    :cond_9
    :try_start_a
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    const/16 v4, 0xc8

    if-eq v2, v4, :cond_a

    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v2

    if-eqz v2, :cond_a

    .line 325
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v5

    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v6

    move-object/from16 v4, p0

    move-object/from16 v7, p3

    move/from16 v8, p6

    move-object/from16 v9, p7

    invoke-direct/range {v4 .. v9}, Lio/branch/referral/RemoteInterface;->processEntityForJSON(Ljava/io/InputStream;ILjava/lang/String;ZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    :try_end_a
    .catch Ljava/net/SocketException; {:try_start_a .. :try_end_a} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_a .. :try_end_a} :catch_3
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_4
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    move-result-object v2

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 327
    :cond_a
    :try_start_b
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v5

    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v6

    move-object/from16 v4, p0

    move-object/from16 v7, p3

    move/from16 v8, p6

    move-object/from16 v9, p7

    invoke-direct/range {v4 .. v9}, Lio/branch/referral/RemoteInterface;->processEntityForJSON(Ljava/io/InputStream;ILjava/lang/String;ZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    :try_end_b
    .catch Ljava/net/SocketException; {:try_start_b .. :try_end_b} :catch_1
    .catch Ljava/net/UnknownHostException; {:try_start_b .. :try_end_b} :catch_3
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_4
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    move-result-object v2

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 340
    .end local v3    # "bodyCopy":Lorg/json/JSONObject;
    .end local v14    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v15    # "outputStreamWriter":Ljava/io/OutputStreamWriter;
    .end local v16    # "urlObject":Ljava/net/URL;
    :catch_4
    move-exception v12

    .line 341
    .local v12, "ex":Ljava/lang/Exception;
    if-eqz p6, :cond_b

    :try_start_c
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v12}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    :cond_b
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-lt v2, v4, :cond_c

    .line 343
    instance-of v2, v12, Landroid/os/NetworkOnMainThreadException;

    if-eqz v2, :cond_c

    .line 344
    const-string v2, "BranchSDK"

    const-string v4, "Branch Error: Don\'t call our synchronous methods on the main thread!!!"

    invoke-static {v2, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 346
    :cond_c
    new-instance v2, Lio/branch/referral/ServerResponse;

    const/16 v4, 0x1f4

    move-object/from16 v0, p3

    invoke-direct {v2, v0, v4}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;I)V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    .line 348
    if-eqz v10, :cond_2

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_1

    .line 348
    .end local v12    # "ex":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    if-eqz v10, :cond_d

    .line 349
    invoke-virtual {v10}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_d
    throw v2
.end method

.method private processEntityForJSON(Ljava/io/InputStream;ILjava/lang/String;ZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    .locals 10
    .param p1, "inStream"    # Ljava/io/InputStream;
    .param p2, "statusCode"    # I
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "log"    # Z
    .param p5, "linkData"    # Lio/branch/referral/BranchLinkData;

    .prologue
    .line 76
    new-instance v6, Lio/branch/referral/ServerResponse;

    invoke-direct {v6, p3, p2, p5}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;ILio/branch/referral/BranchLinkData;)V

    .line 78
    .local v6, "result":Lio/branch/referral/ServerResponse;
    if-eqz p1, :cond_1

    .line 79
    :try_start_0
    new-instance v5, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    invoke-direct {v7, p1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v5, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 81
    .local v5, "rd":Ljava/io/BufferedReader;
    invoke-virtual {v5}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 82
    .local v4, "line":Ljava/lang/String;
    if-eqz p4, :cond_0

    const-string v7, "BranchSDK"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "returned "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 84
    :cond_0
    if-eqz v4, :cond_1

    .line 86
    :try_start_1
    new-instance v7, Lorg/json/JSONObject;

    invoke-static {v4}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 87
    .local v3, "jsonObj":Lorg/json/JSONObject;
    invoke-virtual {v6, v3}, Lio/branch/referral/ServerResponse;->setPost(Ljava/lang/Object;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 103
    .end local v3    # "jsonObj":Lorg/json/JSONObject;
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "rd":Ljava/io/BufferedReader;
    :cond_1
    :goto_0
    return-object v6

    .line 88
    .restart local v4    # "line":Ljava/lang/String;
    .restart local v5    # "rd":Ljava/io/BufferedReader;
    :catch_0
    move-exception v0

    .line 90
    .local v0, "ex":Lorg/json/JSONException;
    :try_start_2
    new-instance v7, Lorg/json/JSONArray;

    invoke-static {v4}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 91
    .local v2, "jsonArray":Lorg/json/JSONArray;
    invoke-virtual {v6, v2}, Lio/branch/referral/ServerResponse;->setPost(Ljava/lang/Object;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_0

    .line 92
    .end local v2    # "jsonArray":Lorg/json/JSONArray;
    :catch_1
    move-exception v1

    .line 93
    .local v1, "ex2":Lorg/json/JSONException;
    if-eqz p4, :cond_1

    .line 94
    :try_start_3
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "JSON exception: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_0

    .line 99
    .end local v0    # "ex":Lorg/json/JSONException;
    .end local v1    # "ex2":Lorg/json/JSONException;
    .end local v4    # "line":Ljava/lang/String;
    .end local v5    # "rd":Ljava/io/BufferedReader;
    :catch_2
    move-exception v0

    .line 100
    .local v0, "ex":Ljava/io/IOException;
    if-eqz p4, :cond_1

    .line 101
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "IO exception: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public make_restful_get(Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "timeout"    # I

    .prologue
    .line 117
    const/4 v4, 0x0

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v5}, Lio/branch/referral/RemoteInterface;->make_restful_get(Ljava/lang/String;Ljava/lang/String;IIZ)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;I)Lio/branch/referral/ServerResponse;
    .locals 8
    .param p1, "body"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "timeout"    # I

    .prologue
    .line 223
    const/4 v5, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    invoke-direct/range {v0 .. v7}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IIZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ILio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;
    .locals 8
    .param p1, "body"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "timeout"    # I
    .param p5, "linkData"    # Lio/branch/referral/BranchLinkData;

    .prologue
    .line 240
    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IIZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method

.method public make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IZ)Lio/branch/referral/ServerResponse;
    .locals 8
    .param p1, "body"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "tag"    # Ljava/lang/String;
    .param p4, "timeout"    # I
    .param p5, "log"    # Z

    .prologue
    .line 257
    const/4 v5, 0x0

    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move v6, p5

    invoke-direct/range {v0 .. v7}, Lio/branch/referral/RemoteInterface;->make_restful_post(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IIZLio/branch/referral/BranchLinkData;)Lio/branch/referral/ServerResponse;

    move-result-object v0

    return-object v0
.end method
