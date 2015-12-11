.class Lcom/auditude/ads/util/PingUtil$1;
.super Ljava/lang/Object;
.source "PingUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/auditude/ads/util/PingUtil;->pingUrlHttpURLConnection(Ljava/lang/String;Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$redirect:I

.field private final synthetic val$url:Ljava/lang/String;

.field private final synthetic val$userAgent:Ljava/lang/String;


# direct methods
.method constructor <init>(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput p1, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    iput-object p2, p0, Lcom/auditude/ads/util/PingUtil$1;->val$url:Ljava/lang/String;

    iput-object p3, p0, Lcom/auditude/ads/util/PingUtil$1;->val$userAgent:Ljava/lang/String;

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 78
    const/4 v0, 0x0

    .line 79
    .local v0, "connection":Ljava/net/HttpURLConnection;
    const/4 v3, 0x0

    .line 80
    .local v3, "shouldRedirect":Z
    const-string v2, ""

    .line 83
    .local v2, "newUrl":Ljava/lang/String;
    :try_start_0
    iget-object v5, p0, Lcom/auditude/ads/util/PingUtil$1;->val$url:Ljava/lang/String;

    # invokes: Lcom/auditude/ads/util/PingUtil;->_requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    invoke-static {v5}, Lcom/auditude/ads/util/PingUtil;->access$0(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 84
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 86
    if-eqz v0, :cond_2

    .line 88
    const-string v5, "GET"

    invoke-virtual {v0, v5}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 89
    # getter for: Lcom/auditude/ads/util/PingUtil;->NETWORK_TIMEOUT:Ljava/lang/Integer;
    invoke-static {}, Lcom/auditude/ads/util/PingUtil;->access$1()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v0, v5}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 90
    # getter for: Lcom/auditude/ads/util/PingUtil;->NETWORK_TIMEOUT:Ljava/lang/Integer;
    invoke-static {}, Lcom/auditude/ads/util/PingUtil;->access$1()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v0, v5}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 92
    const-string v5, "User-Agent"

    iget-object v6, p0, Lcom/auditude/ads/util/PingUtil$1;->val$userAgent:Ljava/lang/String;

    invoke-virtual {v0, v5, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    const-string v5, "Connection"

    const-string v6, "close"

    invoke-virtual {v0, v5, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 96
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Pinging Url ["

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$url:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 99
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    .line 100
    .local v4, "statusCode":I
    const/16 v5, 0x12e

    if-eq v4, v5, :cond_0

    const/16 v5, 0x12d

    if-ne v4, v5, :cond_1

    .line 101
    :cond_0
    iget-object v5, p0, Lcom/auditude/ads/util/PingUtil$1;->val$url:Ljava/lang/String;

    const-string v6, "Location"

    invoke-virtual {v0, v6}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    # invokes: Lcom/auditude/ads/util/PingUtil;->getAbsoluteUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v5, v6}, Lcom/auditude/ads/util/PingUtil;->access$2(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 102
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_1

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    const-string v6, "http"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 103
    const/4 v3, 0x1

    .line 107
    :cond_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 116
    .end local v4    # "statusCode":I
    :cond_2
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 118
    :cond_3
    if-eqz v3, :cond_4

    .line 119
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Redirect to Url ["

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 120
    iget v5, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    add-int/lit8 v5, v5, 0x1

    invoke-static {v2, v5}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;I)V

    .line 123
    :cond_4
    :goto_0
    return-void

    .line 109
    :catch_0
    move-exception v1

    .line 110
    .local v1, "e":Ljava/net/SocketTimeoutException;
    :try_start_1
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Pinging Url: Timed out sending request to "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$url:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 116
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 118
    :cond_5
    if-eqz v3, :cond_4

    .line 119
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Redirect to Url ["

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 120
    iget v5, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    add-int/lit8 v5, v5, 0x1

    invoke-static {v2, v5}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;I)V

    goto :goto_0

    .line 111
    .end local v1    # "e":Ljava/net/SocketTimeoutException;
    :catch_1
    move-exception v1

    .line 112
    .local v1, "e":Ljava/io/IOException;
    :try_start_2
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Pinging Url: IOException while sending request, may retry("

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ")"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 116
    if-eqz v0, :cond_6

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 118
    :cond_6
    if-eqz v3, :cond_4

    .line 119
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Redirect to Url ["

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 120
    iget v5, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    add-int/lit8 v5, v5, 0x1

    invoke-static {v2, v5}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 113
    .end local v1    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v1

    .line 114
    .local v1, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Pinging Url: Unable to create HTTP connection to "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$url:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 116
    if-eqz v0, :cond_7

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 118
    :cond_7
    if-eqz v3, :cond_4

    .line 119
    const-string v5, "Ping"

    invoke-static {v5}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Redirect to Url ["

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v7, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 120
    iget v5, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    add-int/lit8 v5, v5, 0x1

    invoke-static {v2, v5}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 115
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    .line 116
    if-eqz v0, :cond_8

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 118
    :cond_8
    if-eqz v3, :cond_9

    .line 119
    const-string v6, "Ping"

    invoke-static {v6}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Redirect to Url ["

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v8, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 120
    iget v6, p0, Lcom/auditude/ads/util/PingUtil$1;->val$redirect:I

    add-int/lit8 v6, v6, 0x1

    invoke-static {v2, v6}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;I)V

    .line 122
    :cond_9
    throw v5
.end method
