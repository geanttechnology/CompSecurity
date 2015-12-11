.class public Lcom/amazon/device/ads/WebRequest$WebResponse;
.super Ljava/lang/Object;
.source "WebRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/WebRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "WebResponse"
.end annotation


# instance fields
.field private body:Ljava/lang/String;

.field private httpStatus:Ljava/lang/String;

.field private httpStatusCode:I

.field private inputStream:Ljava/io/InputStream;

.field private logEnabled:Z

.field private logTag:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/device/ads/WebRequest;


# direct methods
.method protected constructor <init>(Lcom/amazon/device/ads/WebRequest;)V
    .locals 1

    .prologue
    .line 870
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->this$0:Lcom/amazon/device/ads/WebRequest;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 864
    # getter for: Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->access$000()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logTag:Ljava/lang/String;

    .line 870
    return-void
.end method


# virtual methods
.method protected enableLog(Z)V
    .locals 0
    .param p1, "logEnabled"    # Z

    .prologue
    .line 931
    iput-boolean p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logEnabled:Z

    .line 932
    return-void
.end method

.method public getBody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 878
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->body:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 880
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->readResponseString()V

    .line 882
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->body:Ljava/lang/String;

    return-object v0
.end method

.method public getHttpStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1005
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->httpStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getHttpStatusCode()I
    .locals 1

    .prologue
    .line 981
    iget v0, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->httpStatusCode:I

    return v0
.end method

.method public getJSONObjectBody()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 890
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_0

    .line 892
    const/4 v1, 0x0

    .line 904
    :goto_0
    return-object v1

    .line 895
    :cond_0
    const/4 v1, 0x0

    .line 898
    .local v1, "jsonObject":Lorg/json/JSONObject;
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v1    # "jsonObject":Lorg/json/JSONObject;
    .local v2, "jsonObject":Lorg/json/JSONObject;
    move-object v1, v2

    .line 903
    .end local v2    # "jsonObject":Lorg/json/JSONObject;
    .restart local v1    # "jsonObject":Lorg/json/JSONObject;
    goto :goto_0

    .line 900
    :catch_0
    move-exception v0

    .line 902
    .local v0, "e":Lorg/json/JSONException;
    iget-object v3, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->this$0:Lcom/amazon/device/ads/WebRequest;

    invoke-virtual {v3}, Lcom/amazon/device/ads/WebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "Unable to parse the body into a JSONObject."

    invoke-static {v3, v4}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public isHttpStatusCodeOK()Z
    .locals 2

    .prologue
    .line 995
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getHttpStatusCode()I

    move-result v0

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected readResponseString()V
    .locals 10

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 939
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->inputStream:Ljava/io/InputStream;

    if-eqz v4, :cond_0

    .line 941
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 942
    .local v3, "out":Ljava/lang/StringBuilder;
    const/16 v4, 0x1000

    new-array v0, v4, [B

    .line 945
    .local v0, "b":[B
    :goto_0
    :try_start_0
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->inputStream:Ljava/io/InputStream;

    invoke-virtual {v4, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    .local v2, "i":I
    const/4 v4, -0x1

    if-eq v2, v4, :cond_1

    .line 947
    new-instance v4, Ljava/lang/String;

    const/4 v5, 0x0

    invoke-direct {v4, v0, v5, v2}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 950
    .end local v2    # "i":I
    :catch_0
    move-exception v1

    .line 952
    .local v1, "e":Ljava/io/IOException;
    :try_start_1
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logTag:Ljava/lang/String;

    const-string/jumbo v5, "Unable to read the stream from the network."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 958
    :try_start_2
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->inputStream:Ljava/io/InputStream;

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 965
    :goto_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setBody(Ljava/lang/String;)V

    .line 966
    iget-boolean v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logEnabled:Z

    if-eqz v4, :cond_0

    .line 968
    # getter for: Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->access$000()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "Response: %s"

    new-array v6, v7, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 972
    .end local v0    # "b":[B
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "out":Ljava/lang/StringBuilder;
    :cond_0
    :goto_2
    return-void

    .line 958
    .restart local v0    # "b":[B
    .restart local v2    # "i":I
    .restart local v3    # "out":Ljava/lang/StringBuilder;
    :cond_1
    :try_start_3
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->inputStream:Ljava/io/InputStream;

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 965
    :goto_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setBody(Ljava/lang/String;)V

    .line 966
    iget-boolean v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logEnabled:Z

    if-eqz v4, :cond_0

    .line 968
    # getter for: Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->access$000()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "Response: %s"

    new-array v6, v7, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 960
    :catch_1
    move-exception v1

    .line 962
    .restart local v1    # "e":Ljava/io/IOException;
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logTag:Ljava/lang/String;

    const-string/jumbo v5, "IOException while trying to close the stream"

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 960
    .end local v2    # "i":I
    :catch_2
    move-exception v1

    .line 962
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logTag:Ljava/lang/String;

    const-string/jumbo v5, "IOException while trying to close the stream"

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 956
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 958
    :try_start_4
    iget-object v5, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->inputStream:Ljava/io/InputStream;

    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 965
    :goto_4
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/WebRequest$WebResponse;->setBody(Ljava/lang/String;)V

    .line 966
    iget-boolean v5, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logEnabled:Z

    if-eqz v5, :cond_2

    .line 968
    # getter for: Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->access$000()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Response: %s"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    :cond_2
    throw v4

    .line 960
    :catch_3
    move-exception v1

    .line 962
    .restart local v1    # "e":Ljava/io/IOException;
    iget-object v5, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logTag:Ljava/lang/String;

    const-string/jumbo v6, "IOException while trying to close the stream"

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4
.end method

.method protected setBody(Ljava/lang/String;)V
    .locals 0
    .param p1, "body"    # Ljava/lang/String;

    .prologue
    .line 912
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->body:Ljava/lang/String;

    .line 913
    return-void
.end method

.method protected setHttpStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "httpStatus"    # Ljava/lang/String;

    .prologue
    .line 1015
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->httpStatus:Ljava/lang/String;

    .line 1016
    return-void
.end method

.method protected setHttpStatusCode(I)V
    .locals 0
    .param p1, "httpStatusCode"    # I

    .prologue
    .line 990
    iput p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->httpStatusCode:I

    .line 991
    return-void
.end method

.method protected setInputStream(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 921
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->inputStream:Ljava/io/InputStream;

    .line 922
    return-void
.end method

.method protected setLogTag(Ljava/lang/String;)V
    .locals 0
    .param p1, "logTag"    # Ljava/lang/String;

    .prologue
    .line 926
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest$WebResponse;->logTag:Ljava/lang/String;

    .line 927
    return-void
.end method
