.class public Lcom/igexin/sdk/task/FeedbackTask;
.super Lcom/igexin/sdk/task/HttpTask;
.source "FeedbackTask.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "data"    # [B
    .param p3, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;
    .param p4, "isEncrypt"    # Z

    .prologue
    .line 18
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/igexin/sdk/task/HttpTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V

    .line 19
    return-void
.end method


# virtual methods
.method public parseData([B)V
    .locals 7
    .param p1, "data"    # [B

    .prologue
    .line 24
    :try_start_0
    new-instance v0, Ljava/lang/String;

    const-string/jumbo v4, "utf-8"

    invoke-direct {v0, p1, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 26
    .local v0, "byteData":Ljava/lang/String;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 27
    .local v2, "jsonObject":Lorg/json/JSONObject;
    const-string/jumbo v4, "ok"

    const-string/jumbo v5, "result"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 28
    const-string/jumbo v4, "result"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 29
    .local v3, "result":Ljava/lang/String;
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "result: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 37
    .end local v0    # "byteData":Ljava/lang/String;
    .end local v2    # "jsonObject":Lorg/json/JSONObject;
    .end local v3    # "result":Ljava/lang/String;
    :goto_0
    return-void

    .line 31
    .restart local v0    # "byteData":Ljava/lang/String;
    .restart local v2    # "jsonObject":Lorg/json/JSONObject;
    :cond_0
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Error: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "errormsg"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 33
    .end local v0    # "byteData":Ljava/lang/String;
    .end local v2    # "jsonObject":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 34
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
