.class Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;
.super Ljava/lang/Object;
.source "FeedsServerCom.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "execTaskRunnable"
.end annotation


# static fields
.field private static final SECOND_IN_MILLIS:I = 0x3e8


# instance fields
.field downloadType:I

.field httpType:I

.field mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

.field url:Ljava/lang/String;

.field values:Ljava/util/HashMap;
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
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    .locals 0
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "httpType"    # I
    .param p4, "downloadType"    # I
    .param p5, "pListener"    # Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "II",
            "Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 99
    .local p6, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->this$0:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    .line 101
    iput p3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpType:I

    .line 102
    iput p4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->downloadType:I

    .line 103
    if-eqz p6, :cond_0

    .end local p6    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    iput-object p6, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    .line 104
    if-eqz p5, :cond_1

    .end local p5    # "pListener":Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;
    :goto_1
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 106
    return-void

    .line 103
    .restart local p5    # "pListener":Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;
    .restart local p6    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    new-instance p6, Ljava/util/HashMap;

    .end local p6    # "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p6}, Ljava/util/HashMap;-><init>()V

    goto :goto_0

    .line 104
    :cond_1
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;->intiListener()Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;

    move-result-object p5

    goto :goto_1
.end method

.method private PostRequest(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 13
    .param p1, "pURL"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    const/4 v12, 0x5

    .line 307
    const/4 v0, 0x0

    .line 308
    .local v0, "dataout":Ljava/io/DataOutputStream;
    const/4 v3, 0x0

    .line 309
    .local v3, "in":Ljava/io/BufferedReader;
    const/4 v5, 0x0

    .line 311
    .local v5, "response":Ljava/lang/String;
    :try_start_0
    new-instance v8, Ljava/net/URL;

    invoke-direct {v8, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 312
    .local v8, "url":Ljava/net/URL;
    invoke-virtual {v8}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v9

    check-cast v9, Ljava/net/HttpURLConnection;

    .line 313
    .local v9, "urlc":Ljava/net/HttpURLConnection;
    const-string v10, "POST"

    invoke-virtual {v9, v10}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 314
    const/16 v10, 0x7530

    invoke-virtual {v9, v10}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 315
    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 316
    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 317
    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 318
    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Ljava/net/HttpURLConnection;->setAllowUserInteraction(Z)V

    .line 319
    const-string v10, "Content-Type"

    const-string v11, "application/x-www-form-urlencoded"

    invoke-virtual {v9, v10, v11}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    new-instance v1, Ljava/io/DataOutputStream;

    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v10

    invoke-direct {v1, v10}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/net/ProtocolException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 322
    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .local v1, "dataout":Ljava/io/DataOutputStream;
    :try_start_1
    invoke-virtual {v1, p2}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 323
    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v6

    .line 324
    .local v6, "responseCode":I
    const/16 v10, 0xc8

    if-ne v6, v10, :cond_a

    .line 325
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/InputStreamReader;

    invoke-virtual {v9}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    const/16 v11, 0x1fa0

    invoke-direct {v4, v10, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V
    :try_end_1
    .catch Ljava/net/ProtocolException; {:try_start_1 .. :try_end_1} :catch_d
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_b
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_9
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 326
    .end local v3    # "in":Ljava/io/BufferedReader;
    .local v4, "in":Ljava/io/BufferedReader;
    :try_start_2
    const-string v7, ""

    .line 327
    .local v7, "totalResponse":Ljava/lang/String;
    :goto_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_2

    .line 329
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V

    .line 330
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v10

    if-lez v10, :cond_9

    .line 331
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10, v7}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/net/ProtocolException; {:try_start_2 .. :try_end_2} :catch_e
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_c
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_a
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 341
    if-eqz v4, :cond_0

    .line 342
    :try_start_3
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V

    .line 343
    :cond_0
    if-eqz v1, :cond_1

    .line 344
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    :cond_1
    :goto_1
    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    move-object v0, v1

    .line 349
    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .end local v6    # "responseCode":I
    .end local v7    # "totalResponse":Ljava/lang/String;
    .end local v8    # "url":Ljava/net/URL;
    .end local v9    # "urlc":Ljava/net/HttpURLConnection;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    :goto_2
    return-object v10

    .line 328
    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    .restart local v6    # "responseCode":I
    .restart local v7    # "totalResponse":Ljava/lang/String;
    .restart local v8    # "url":Ljava/net/URL;
    .restart local v9    # "urlc":Ljava/net/HttpURLConnection;
    :cond_2
    :try_start_4
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_4
    .catch Ljava/net/ProtocolException; {:try_start_4 .. :try_end_4} :catch_e
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_c
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_a
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-result-object v7

    goto :goto_0

    .line 345
    :catch_0
    move-exception v2

    .line 346
    .local v2, "e":Ljava/io/IOException;
    const-string v11, "Error: "

    invoke-static {v11, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 333
    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .end local v2    # "e":Ljava/io/IOException;
    .end local v4    # "in":Ljava/io/BufferedReader;
    .end local v6    # "responseCode":I
    .end local v7    # "totalResponse":Ljava/lang/String;
    .end local v8    # "url":Ljava/net/URL;
    .end local v9    # "urlc":Ljava/net/HttpURLConnection;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    :catch_1
    move-exception v2

    .line 334
    .local v2, "e":Ljava/net/ProtocolException;
    :goto_3
    :try_start_5
    const-string v10, "Error: "

    const/4 v11, 0x5

    invoke-static {v10, v11, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 341
    if-eqz v3, :cond_3

    .line 342
    :try_start_6
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 343
    :cond_3
    if-eqz v0, :cond_4

    .line 344
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    .line 349
    .end local v2    # "e":Ljava/net/ProtocolException;
    :cond_4
    :goto_4
    const/4 v10, 0x0

    goto :goto_2

    .line 345
    .restart local v2    # "e":Ljava/net/ProtocolException;
    :catch_2
    move-exception v2

    .line 346
    .local v2, "e":Ljava/io/IOException;
    const-string v10, "Error: "

    invoke-static {v10, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_4

    .line 335
    .end local v2    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v2

    .line 336
    .restart local v2    # "e":Ljava/io/IOException;
    :goto_5
    :try_start_7
    const-string v10, "Error: "

    const/4 v11, 0x5

    invoke-static {v10, v11, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 341
    if-eqz v3, :cond_5

    .line 342
    :try_start_8
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 343
    :cond_5
    if-eqz v0, :cond_4

    .line 344
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_4

    goto :goto_4

    .line 345
    :catch_4
    move-exception v2

    .line 346
    const-string v10, "Error: "

    invoke-static {v10, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_4

    .line 337
    .end local v2    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v2

    .line 338
    .local v2, "e":Lorg/json/JSONException;
    :goto_6
    :try_start_9
    const-string v10, "Error: "

    const/4 v11, 0x5

    invoke-static {v10, v11, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 341
    if-eqz v3, :cond_6

    .line 342
    :try_start_a
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 343
    :cond_6
    if-eqz v0, :cond_4

    .line 344
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_6

    goto :goto_4

    .line 345
    :catch_6
    move-exception v2

    .line 346
    .local v2, "e":Ljava/io/IOException;
    const-string v10, "Error: "

    invoke-static {v10, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_4

    .line 339
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 341
    :goto_7
    if-eqz v3, :cond_7

    .line 342
    :try_start_b
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 343
    :cond_7
    if-eqz v0, :cond_8

    .line 344
    invoke-virtual {v0}, Ljava/io/DataOutputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_7

    .line 348
    :cond_8
    :goto_8
    throw v10

    .line 345
    :catch_7
    move-exception v2

    .line 346
    .restart local v2    # "e":Ljava/io/IOException;
    const-string v11, "Error: "

    invoke-static {v11, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_8

    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    .restart local v6    # "responseCode":I
    .restart local v7    # "totalResponse":Ljava/lang/String;
    .restart local v8    # "url":Ljava/net/URL;
    .restart local v9    # "urlc":Ljava/net/HttpURLConnection;
    :cond_9
    move-object v3, v4

    .line 341
    .end local v4    # "in":Ljava/io/BufferedReader;
    .end local v7    # "totalResponse":Ljava/lang/String;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    :cond_a
    if-eqz v3, :cond_b

    .line 342
    :try_start_c
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 343
    :cond_b
    if-eqz v1, :cond_c

    .line 344
    invoke-virtual {v1}, Ljava/io/DataOutputStream;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_8

    move-object v0, v1

    .line 345
    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_4

    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    :catch_8
    move-exception v2

    .line 346
    .restart local v2    # "e":Ljava/io/IOException;
    const-string v10, "Error: "

    invoke-static {v10, v12, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .end local v2    # "e":Ljava/io/IOException;
    :cond_c
    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_4

    .line 339
    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v6    # "responseCode":I
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    :catchall_1
    move-exception v10

    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_7

    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    .restart local v6    # "responseCode":I
    :catchall_2
    move-exception v10

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_7

    .line 337
    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v6    # "responseCode":I
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    :catch_9
    move-exception v2

    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_6

    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    .restart local v6    # "responseCode":I
    :catch_a
    move-exception v2

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_6

    .line 335
    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v6    # "responseCode":I
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    :catch_b
    move-exception v2

    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_5

    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    .restart local v6    # "responseCode":I
    :catch_c
    move-exception v2

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto :goto_5

    .line 333
    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v6    # "responseCode":I
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    :catch_d
    move-exception v2

    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto/16 :goto_3

    .end local v0    # "dataout":Ljava/io/DataOutputStream;
    .end local v3    # "in":Ljava/io/BufferedReader;
    .restart local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v4    # "in":Ljava/io/BufferedReader;
    .restart local v6    # "responseCode":I
    :catch_e
    move-exception v2

    move-object v3, v4

    .end local v4    # "in":Ljava/io/BufferedReader;
    .restart local v3    # "in":Ljava/io/BufferedReader;
    move-object v0, v1

    .end local v1    # "dataout":Ljava/io/DataOutputStream;
    .restart local v0    # "dataout":Ljava/io/DataOutputStream;
    goto/16 :goto_3
.end method

.method private httpGetJson(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 12
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 189
    const/4 v5, 0x0

    .line 191
    .local v5, "json":Lorg/json/JSONObject;
    const/16 v9, 0x1e

    invoke-direct {p0, v9}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->initHttpClient(I)Lorg/apache/http/impl/client/DefaultHttpClient;

    move-result-object v0

    .line 195
    .local v0, "client":Lorg/apache/http/client/HttpClient;
    :try_start_0
    new-instance v4, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v4, p1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 196
    .local v4, "httpGet":Lorg/apache/http/client/methods/HttpGet;
    invoke-interface {v0, v4}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v6

    .line 197
    .local v6, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v8

    .line 198
    .local v8, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {v8}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    .line 199
    .local v7, "statusCode":I
    const/16 v9, 0xc8

    if-ne v7, v9, :cond_0

    .line 200
    invoke-direct {p0, v6}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->readHeaderForTTL(Lorg/apache/http/HttpResponse;)V

    .line 201
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v2

    .line 202
    .local v2, "entity":Lorg/apache/http/HttpEntity;
    invoke-static {v2}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v3

    .line 203
    .local v3, "entityStr":Ljava/lang/String;
    new-instance v5, Lorg/json/JSONObject;

    .end local v5    # "json":Lorg/json/JSONObject;
    invoke-direct {v5, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 226
    .end local v2    # "entity":Lorg/apache/http/HttpEntity;
    .end local v3    # "entityStr":Ljava/lang/String;
    .end local v4    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v6    # "response":Lorg/apache/http/HttpResponse;
    .end local v7    # "statusCode":I
    .end local v8    # "statusLine":Lorg/apache/http/StatusLine;
    .restart local v5    # "json":Lorg/json/JSONObject;
    :goto_0
    return-object v5

    .line 205
    .restart local v4    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v6    # "response":Lorg/apache/http/HttpResponse;
    .restart local v7    # "statusCode":I
    .restart local v8    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_0
    const-string v9, "Error: Failed to download JSON"

    const/4 v10, 0x5

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 207
    .end local v4    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v5    # "json":Lorg/json/JSONObject;
    .end local v6    # "response":Lorg/apache/http/HttpResponse;
    .end local v7    # "statusCode":I
    .end local v8    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_0
    move-exception v1

    .line 208
    .local v1, "e":Lorg/apache/http/client/ClientProtocolException;
    :try_start_1
    const-string v9, "Error: "

    const/4 v10, 0x5

    invoke-static {v9, v10, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 209
    const/4 v5, 0x0

    .restart local v5    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .line 210
    .end local v1    # "e":Lorg/apache/http/client/ClientProtocolException;
    .end local v5    # "json":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    .line 211
    .local v1, "e":Ljava/io/IOException;
    const-string v9, "Error: "

    const/4 v10, 0x5

    invoke-static {v9, v10, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 212
    const/4 v5, 0x0

    .restart local v5    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .line 213
    .end local v1    # "e":Ljava/io/IOException;
    .end local v5    # "json":Lorg/json/JSONObject;
    :catch_2
    move-exception v1

    .line 214
    .local v1, "e":Lorg/json/JSONException;
    const-string v9, "Error: "

    const/4 v10, 0x5

    invoke-static {v9, v10, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 215
    const/4 v5, 0x0

    .restart local v5    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .line 216
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v5    # "json":Lorg/json/JSONObject;
    :catch_3
    move-exception v1

    .line 217
    .local v1, "e":Ljava/lang/Exception;
    const-string v9, "Error: "

    const/4 v10, 0x5

    invoke-static {v9, v10, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 218
    const/4 v5, 0x0

    .restart local v5    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .line 219
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v5    # "json":Lorg/json/JSONObject;
    :catchall_0
    move-exception v9

    .line 225
    throw v9
.end method

.method private httpGetXML(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    .locals 11
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x5

    .line 281
    const/16 v7, 0x1e

    invoke-direct {p0, v7}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->initHttpClient(I)Lorg/apache/http/impl/client/DefaultHttpClient;

    move-result-object v0

    .line 282
    .local v0, "client":Lorg/apache/http/client/HttpClient;
    const/4 v2, 0x0

    .line 285
    .local v2, "entity":Lorg/apache/http/HttpEntity;
    :try_start_0
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v3, p1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 286
    .local v3, "httpGet":Lorg/apache/http/client/methods/HttpGet;
    invoke-interface {v0, v3}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v4

    .line 287
    .local v4, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v6

    .line 288
    .local v6, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v5

    .line 289
    .local v5, "statusCode":I
    const/16 v7, 0xc8

    if-ne v5, v7, :cond_0

    .line 290
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v2

    .line 303
    .end local v3    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "response":Lorg/apache/http/HttpResponse;
    .end local v5    # "statusCode":I
    .end local v6    # "statusLine":Lorg/apache/http/StatusLine;
    :goto_0
    return-object v2

    .line 293
    .restart local v3    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "response":Lorg/apache/http/HttpResponse;
    .restart local v5    # "statusCode":I
    .restart local v6    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_0
    const-string v7, "Failed to download XML"

    const/4 v8, 0x5

    const/4 v9, 0x0

    invoke-static {v7, v8, v9}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 296
    .end local v3    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "response":Lorg/apache/http/HttpResponse;
    .end local v5    # "statusCode":I
    .end local v6    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_0
    move-exception v1

    .line 297
    .local v1, "e":Lorg/apache/http/client/ClientProtocolException;
    const/4 v2, 0x0

    .line 298
    const-string v7, "Error: "

    invoke-static {v7, v10, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 299
    .end local v1    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_1
    move-exception v1

    .line 300
    .local v1, "e":Ljava/io/IOException;
    const/4 v2, 0x0

    .line 301
    const-string v7, "Error: "

    invoke-static {v7, v10, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method private httpsGetJson(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 16
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 232
    const/4 v7, 0x0

    .line 233
    .local v7, "json":Lorg/json/JSONObject;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 234
    .local v1, "builder":Ljava/lang/StringBuilder;
    const/16 v13, 0x1e

    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->initHttpClient(I)Lorg/apache/http/impl/client/DefaultHttpClient;

    move-result-object v2

    .line 235
    .local v2, "client":Lorg/apache/http/client/HttpClient;
    const/4 v3, 0x0

    .line 238
    .local v3, "content":Ljava/io/InputStream;
    :try_start_0
    new-instance v6, Lorg/apache/http/client/methods/HttpGet;

    move-object/from16 v0, p1

    invoke-direct {v6, v0}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 239
    .local v6, "httpGet":Lorg/apache/http/client/methods/HttpGet;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getStartSessionCookie()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_0

    .line 240
    const-string v13, "cookie"

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getStartSessionCookie()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v6, v13, v14}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 241
    :cond_0
    invoke-interface {v2, v6}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v10

    .line 242
    .local v10, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v12

    .line 243
    .local v12, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface {v12}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v11

    .line 244
    .local v11, "statusCode":I
    const/16 v13, 0xc8

    if-ne v11, v13, :cond_1

    .line 245
    move-object/from16 v0, p0

    invoke-direct {v0, v10}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->readHeaderForTTL(Lorg/apache/http/HttpResponse;)V

    .line 247
    :cond_1
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v5

    .line 248
    .local v5, "entity":Lorg/apache/http/HttpEntity;
    invoke-interface {v5}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v3

    .line 249
    new-instance v9, Ljava/io/BufferedReader;

    new-instance v13, Ljava/io/InputStreamReader;

    invoke-direct {v13, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v9, v13}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 251
    .local v9, "reader":Ljava/io/BufferedReader;
    :goto_0
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v8

    .local v8, "line":Ljava/lang/String;
    if-nez v8, :cond_2

    .line 254
    new-instance v7, Lorg/json/JSONObject;

    .end local v7    # "json":Lorg/json/JSONObject;
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v7, v13}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_6
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 270
    .restart local v7    # "json":Lorg/json/JSONObject;
    :try_start_1
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_9

    .line 275
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v6    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v8    # "line":Ljava/lang/String;
    .end local v9    # "reader":Ljava/io/BufferedReader;
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "statusCode":I
    .end local v12    # "statusLine":Lorg/apache/http/StatusLine;
    :goto_1
    return-object v7

    .line 252
    .restart local v5    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v6    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v8    # "line":Ljava/lang/String;
    .restart local v9    # "reader":Ljava/io/BufferedReader;
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v11    # "statusCode":I
    .restart local v12    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_2
    :try_start_2
    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 256
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v6    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v7    # "json":Lorg/json/JSONObject;
    .end local v8    # "line":Ljava/lang/String;
    .end local v9    # "reader":Ljava/io/BufferedReader;
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "statusCode":I
    .end local v12    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_0
    move-exception v4

    .line 257
    .local v4, "e":Lorg/apache/http/client/ClientProtocolException;
    :try_start_3
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 258
    const/4 v7, 0x0

    .line 270
    .restart local v7    # "json":Lorg/json/JSONObject;
    :try_start_4
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_1

    .line 271
    :catch_1
    move-exception v4

    .line 272
    .local v4, "e":Ljava/lang/Exception;
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 259
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v7    # "json":Lorg/json/JSONObject;
    :catch_2
    move-exception v4

    .line 260
    .local v4, "e":Ljava/io/IOException;
    :try_start_5
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 261
    const/4 v7, 0x0

    .line 270
    .restart local v7    # "json":Lorg/json/JSONObject;
    :try_start_6
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_1

    .line 271
    :catch_3
    move-exception v4

    .line 272
    .local v4, "e":Ljava/lang/Exception;
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 262
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v7    # "json":Lorg/json/JSONObject;
    :catch_4
    move-exception v4

    .line 263
    .local v4, "e":Lorg/json/JSONException;
    :try_start_7
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 264
    const/4 v7, 0x0

    .line 270
    .restart local v7    # "json":Lorg/json/JSONObject;
    :try_start_8
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto :goto_1

    .line 271
    :catch_5
    move-exception v4

    .line 272
    .local v4, "e":Ljava/lang/Exception;
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 265
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v7    # "json":Lorg/json/JSONObject;
    :catch_6
    move-exception v4

    .line 266
    .restart local v4    # "e":Ljava/lang/Exception;
    :try_start_9
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 267
    const/4 v7, 0x0

    .line 270
    .restart local v7    # "json":Lorg/json/JSONObject;
    :try_start_a
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_7

    goto :goto_1

    .line 271
    :catch_7
    move-exception v4

    .line 272
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 268
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v7    # "json":Lorg/json/JSONObject;
    :catchall_0
    move-exception v13

    .line 270
    :try_start_b
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_8

    .line 274
    :goto_2
    throw v13

    .line 271
    :catch_8
    move-exception v4

    .line 272
    .restart local v4    # "e":Ljava/lang/Exception;
    const-string v14, "Error: "

    const/4 v15, 0x5

    invoke-static {v14, v15, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 271
    .end local v4    # "e":Ljava/lang/Exception;
    .restart local v5    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v6    # "httpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v7    # "json":Lorg/json/JSONObject;
    .restart local v8    # "line":Ljava/lang/String;
    .restart local v9    # "reader":Ljava/io/BufferedReader;
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v11    # "statusCode":I
    .restart local v12    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_9
    move-exception v4

    .line 272
    .restart local v4    # "e":Ljava/lang/Exception;
    const-string v13, "Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1
.end method

.method private initHttpClient(I)Lorg/apache/http/impl/client/DefaultHttpClient;
    .locals 2
    .param p1, "waitSecs"    # I

    .prologue
    .line 166
    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 168
    .local v0, "params":Lorg/apache/http/params/HttpParams;
    mul-int/lit16 v1, p1, 0x3e8

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 169
    mul-int/lit16 v1, p1, 0x3e8

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 170
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1, v0}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    return-object v1
.end method

.method private readHeaderForTTL(Lorg/apache/http/HttpResponse;)V
    .locals 6
    .param p1, "response"    # Lorg/apache/http/HttpResponse;

    .prologue
    .line 175
    :try_start_0
    const-string v3, "Cache-Control"

    invoke-interface {p1, v3}, Lorg/apache/http/HttpResponse;->getHeaders(Ljava/lang/String;)[Lorg/apache/http/Header;

    move-result-object v2

    .line 176
    .local v2, "header":[Lorg/apache/http/Header;
    array-length v3, v2

    if-lez v3, :cond_0

    .line 177
    const/4 v3, 0x0

    aget-object v3, v2, v3

    invoke-interface {v3}, Lorg/apache/http/Header;->getElements()[Lorg/apache/http/HeaderElement;

    move-result-object v1

    .line 178
    .local v1, "heaaderElements":[Lorg/apache/http/HeaderElement;
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    const-string v4, "ttl"

    const/4 v5, 0x0

    aget-object v5, v1, v5

    invoke-interface {v5}, Lorg/apache/http/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 184
    .end local v1    # "heaaderElements":[Lorg/apache/http/HeaderElement;
    .end local v2    # "header":[Lorg/apache/http/Header;
    :cond_0
    :goto_0
    return-void

    .line 180
    :catch_0
    move-exception v0

    .line 181
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Error Reading TTL: Setting default:  "

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 182
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    const-string v4, "ttl"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x5

    const/4 v5, 0x1

    .line 111
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpType:I

    if-ne v2, v5, :cond_4

    .line 113
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->downloadType:I

    if-ne v2, v6, :cond_2

    .line 114
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpGetJson(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 115
    .local v1, "object":Lorg/json/JSONObject;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    if-eqz v2, :cond_0

    .line 117
    if-eqz v1, :cond_1

    .line 118
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    invoke-interface {v2, v1, v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 162
    .end local v1    # "object":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    return-void

    .line 120
    .restart local v1    # "object":Lorg/json/JSONObject;
    :cond_1
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-interface {v2, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->handleError(I)V

    goto :goto_0

    .line 123
    .end local v1    # "object":Lorg/json/JSONObject;
    :cond_2
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->downloadType:I

    const/4 v3, 0x6

    if-ne v2, v3, :cond_0

    .line 124
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpGetXML(Ljava/lang/String;)Lorg/apache/http/HttpEntity;

    move-result-object v0

    .line 125
    .local v0, "entity":Lorg/apache/http/HttpEntity;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    if-eqz v2, :cond_0

    .line 126
    if-eqz v0, :cond_3

    .line 127
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    const-string v3, "XML"

    invoke-interface {v2, v0, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V

    goto :goto_0

    .line 129
    :cond_3
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-interface {v2, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->handleError(I)V

    goto :goto_0

    .line 133
    .end local v0    # "entity":Lorg/apache/http/HttpEntity;
    :cond_4
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpType:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_6

    .line 136
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    const-string v3, "https"

    const-string v4, "http"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    .line 139
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->downloadType:I

    if-ne v2, v6, :cond_0

    .line 140
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpsGetJson(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 141
    .restart local v1    # "object":Lorg/json/JSONObject;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    if-eqz v2, :cond_0

    .line 143
    if-eqz v1, :cond_5

    .line 144
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    invoke-interface {v2, v1, v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 146
    :cond_5
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-interface {v2, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->handleError(I)V

    goto :goto_0

    .line 150
    .end local v1    # "object":Lorg/json/JSONObject;
    :cond_6
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->httpType:I

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    .line 152
    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->downloadType:I

    if-ne v2, v6, :cond_0

    .line 153
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    const-string v4, "POSTMSG"

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->PostRequest(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 154
    .restart local v1    # "object":Lorg/json/JSONObject;
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    if-eqz v2, :cond_0

    .line 155
    if-eqz v1, :cond_7

    .line 156
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->url:Ljava/lang/String;

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->values:Ljava/util/HashMap;

    invoke-interface {v2, v1, v3, v4}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 158
    :cond_7
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;->mListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-interface {v2, v5}, Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;->handleError(I)V

    goto/16 :goto_0
.end method
