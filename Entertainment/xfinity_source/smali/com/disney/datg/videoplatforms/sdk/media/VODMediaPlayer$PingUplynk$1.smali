.class Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;
.super Ljava/lang/Object;
.source "VODMediaPlayer.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->ping(ILjava/lang/String;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

.field final synthetic val$event:Ljava/lang/String;

.field final synthetic val$playerTime:I


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    iput p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->val$playerTime:I

    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->val$event:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Integer;
    .locals 19
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 91
    const/4 v5, 0x0

    .line 92
    .local v5, "is":Ljava/io/InputStream;
    const-string v11, ""

    .line 93
    .local v11, "result":Ljava/lang/String;
    const-string v14, "%s/session/ping/%s.json?v=1&pt=%s"

    const/4 v15, 0x3

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->host:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    const/16 v16, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->session:Ljava/lang/String;

    move-object/from16 v17, v0

    aput-object v17, v15, v16

    const/16 v16, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->val$playerTime:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    .line 94
    .local v13, "url":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->val$event:Ljava/lang/String;

    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_0

    .line 96
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "&ev="

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->val$event:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 100
    :cond_0
    :try_start_0
    new-instance v3, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v3}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 101
    .local v3, "httpclient":Lorg/apache/http/client/HttpClient;
    new-instance v4, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v4, v13}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 102
    .local v4, "httppost":Lorg/apache/http/client/methods/HttpGet;
    invoke-interface {v3, v4}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v10

    .line 103
    .local v10, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v2

    .line 104
    .local v2, "entity":Lorg/apache/http/HttpEntity;
    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    .line 111
    :try_start_1
    new-instance v9, Ljava/io/BufferedReader;

    new-instance v14, Ljava/io/InputStreamReader;

    const-string v15, "utf-8"

    invoke-direct {v14, v5, v15}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    const/16 v15, 0x8

    invoke-direct {v9, v14, v15}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    .line 112
    .local v9, "reader":Ljava/io/BufferedReader;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    .line 113
    .local v12, "sb":Ljava/lang/StringBuilder;
    const/4 v7, 0x0

    .line 114
    .local v7, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v9}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 115
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "\n"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 119
    .end local v7    # "line":Ljava/lang/String;
    .end local v9    # "reader":Ljava/io/BufferedReader;
    .end local v12    # "sb":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v1

    .line 120
    .local v1, "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    iget-object v14, v14, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    const/4 v15, -0x1

    iput v15, v14, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->nextPingTime:I

    .line 125
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_1
    :try_start_2
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6, v11}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 126
    .local v6, "jsonObject":Lorg/json/JSONObject;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v14

    const-string v15, "result of uplynk pint ss-ad %s -- %s"

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v13, v16, v17

    const/16 v17, 0x1

    invoke-virtual {v6}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    const-string v14, "next_time"

    invoke-virtual {v6, v14}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    .line 128
    .local v8, "nextPingTime":I
    if-gez v8, :cond_2

    .line 129
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    iget-object v14, v14, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    const/4 v15, 0x0

    iput-boolean v15, v14, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->needsPing:Z

    .line 132
    :goto_2
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v14

    .line 135
    .end local v2    # "entity":Lorg/apache/http/HttpEntity;
    .end local v3    # "httpclient":Lorg/apache/http/client/HttpClient;
    .end local v4    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .end local v6    # "jsonObject":Lorg/json/JSONObject;
    .end local v8    # "nextPingTime":I
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    :goto_3
    return-object v14

    .line 105
    :catch_1
    move-exception v1

    .line 106
    .restart local v1    # "e":Ljava/lang/Exception;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    const/4 v14, -0x1

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    goto :goto_3

    .line 117
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v3    # "httpclient":Lorg/apache/http/client/HttpClient;
    .restart local v4    # "httppost":Lorg/apache/http/client/methods/HttpGet;
    .restart local v7    # "line":Ljava/lang/String;
    .restart local v9    # "reader":Ljava/io/BufferedReader;
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v12    # "sb":Ljava/lang/StringBuilder;
    :cond_1
    :try_start_3
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V

    .line 118
    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    move-result-object v11

    goto :goto_1

    .line 131
    .end local v7    # "line":Ljava/lang/String;
    .end local v9    # "reader":Ljava/io/BufferedReader;
    .end local v12    # "sb":Ljava/lang/StringBuilder;
    .restart local v6    # "jsonObject":Lorg/json/JSONObject;
    .restart local v8    # "nextPingTime":I
    :cond_2
    :try_start_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->this$1:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    iget-object v14, v14, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    const/4 v15, 0x1

    iput-boolean v15, v14, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->needsPing:Z
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_2

    .line 133
    .end local v6    # "jsonObject":Lorg/json/JSONObject;
    .end local v8    # "nextPingTime":I
    :catch_2
    move-exception v1

    .line 134
    .local v1, "e":Lorg/json/JSONException;
    # getter for: Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->access$000()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    const/4 v14, -0x1

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    goto :goto_3
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 85
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk$1;->call()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method
