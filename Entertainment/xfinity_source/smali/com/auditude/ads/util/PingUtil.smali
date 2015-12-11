.class public final Lcom/auditude/ads/util/PingUtil;
.super Ljava/lang/Object;
.source "PingUtil.java"


# static fields
.field private static final NETWORK_TIMEOUT:Ljava/lang/Integer;

.field private static POOL_NUM:I

.field private static REDIRECT_LIMIT:I

.field private static _executor:Ljava/util/concurrent/ExecutorService;

.field private static volatile _executor_pred:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x5

    .line 38
    const/16 v0, 0x2710

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/auditude/ads/util/PingUtil;->NETWORK_TIMEOUT:Ljava/lang/Integer;

    .line 39
    sput v1, Lcom/auditude/ads/util/PingUtil;->POOL_NUM:I

    .line 40
    sput v1, Lcom/auditude/ads/util/PingUtil;->REDIRECT_LIMIT:I

    .line 43
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/auditude/ads/util/PingUtil;->_executor_pred:Ljava/lang/Boolean;

    return-void
.end method

.method private static _requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 6
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 173
    :try_start_0
    new-instance v1, Ljava/net/URL;

    invoke-direct {v1, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 175
    .local v1, "requestURL":Ljava/net/URL;
    invoke-virtual {v1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v3

    const-string v4, "https"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 176
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    check-cast v2, Ljavax/net/ssl/HttpsURLConnection;

    .line 177
    .local v2, "secureConnection":Ljavax/net/ssl/HttpsURLConnection;
    new-instance v3, Lorg/apache/http/conn/ssl/StrictHostnameVerifier;

    invoke-direct {v3}, Lorg/apache/http/conn/ssl/StrictHostnameVerifier;-><init>()V

    invoke-virtual {v2, v3}, Ljavax/net/ssl/HttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 188
    .end local v1    # "requestURL":Ljava/net/URL;
    .end local v2    # "secureConnection":Ljavax/net/ssl/HttpsURLConnection;
    :goto_0
    return-object v2

    .line 180
    .restart local v1    # "requestURL":Ljava/net/URL;
    :cond_0
    invoke-virtual {v1}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v3

    check-cast v3, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-object v2, v3

    goto :goto_0

    .line 182
    .end local v1    # "requestURL":Ljava/net/URL;
    :catch_0
    move-exception v0

    .line 183
    .local v0, "e":Ljava/net/MalformedURLException;
    const-string v3, "Ping"

    invoke-static {v3}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Pinging Url: MalformedURL "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .line 188
    .end local v0    # "e":Ljava/net/MalformedURLException;
    :goto_1
    const/4 v2, 0x0

    goto :goto_0

    .line 184
    :catch_1
    move-exception v0

    .line 185
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "Ping"

    invoke-static {v3}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Pinging Url: Exception opening url ("

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    goto :goto_1
.end method

.method static synthetic access$0(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 1

    .prologue
    .line 170
    invoke-static {p0}, Lcom/auditude/ads/util/PingUtil;->_requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/auditude/ads/util/PingUtil;->NETWORK_TIMEOUT:Ljava/lang/Integer;

    return-object v0
.end method

.method static synthetic access$2(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    invoke-static {p0, p1}, Lcom/auditude/ads/util/PingUtil;->getAbsoluteUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static final getAbsoluteUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "redirectUrl"    # Ljava/lang/String;

    .prologue
    .line 132
    const-string v3, ""

    .line 133
    .local v3, "newUrl":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_1

    .line 135
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    const-string v8, "http"

    invoke-virtual {v7, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 167
    .end local p1    # "redirectUrl":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 139
    .restart local p1    # "redirectUrl":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 143
    :try_start_0
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 144
    .local v4, "oldUrl":Ljava/net/URL;
    new-instance v6, Ljava/net/URL;

    invoke-virtual {v4}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4}, Ljava/net/URL;->getPort()I

    move-result v9

    invoke-direct {v6, v7, v8, v9, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 145
    .local v6, "result":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    goto :goto_0

    .line 146
    .end local v4    # "oldUrl":Ljava/net/URL;
    .end local v6    # "result":Ljava/net/URL;
    :catch_0
    move-exception v1

    .line 147
    .local v1, "e":Ljava/lang/Exception;
    const-string v7, "Ping"

    invoke-static {v7}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v7

    const-string v8, "Pinging Url: Exception when building redirect url."

    invoke-interface {v7, v8}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    :goto_1
    move-object p1, v3

    .line 167
    goto :goto_0

    .line 154
    :cond_2
    :try_start_1
    new-instance v4, Ljava/net/URL;

    invoke-direct {v4, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 155
    .restart local v4    # "oldUrl":Ljava/net/URL;
    invoke-virtual {v4}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v5

    .line 156
    .local v5, "path":Ljava/lang/String;
    const-string v7, "/"

    invoke-virtual {v5, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    .line 157
    .local v2, "index":I
    if-gez v2, :cond_3

    const-string v0, "/"

    .line 158
    .local v0, "directory":Ljava/lang/String;
    :goto_2
    new-instance v6, Ljava/net/URL;

    invoke-virtual {v4}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4}, Ljava/net/URL;->getPort()I

    move-result v9

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v6, v7, v8, v9, v10}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 159
    .restart local v6    # "result":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 157
    .end local v0    # "directory":Ljava/lang/String;
    .end local v6    # "result":Ljava/net/URL;
    :cond_3
    const/4 v7, 0x0

    add-int/lit8 v8, v2, 0x1

    invoke-virtual {v5, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    goto :goto_2

    .line 161
    .end local v2    # "index":I
    .end local v4    # "oldUrl":Ljava/net/URL;
    .end local v5    # "path":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 163
    .restart local v1    # "e":Ljava/lang/Exception;
    const-string v7, "Ping"

    invoke-static {v7}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v7

    const-string v8, "Pinging Url: Exception when building redirect url."

    invoke-interface {v7, v8}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private static declared-synchronized getExecutor()Ljava/util/concurrent/ExecutorService;
    .locals 2

    .prologue
    .line 46
    const-class v1, Lcom/auditude/ads/util/PingUtil;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/auditude/ads/util/PingUtil;->_executor_pred:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 48
    sget v0, Lcom/auditude/ads/util/PingUtil;->POOL_NUM:I

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/auditude/ads/util/PingUtil;->_executor:Ljava/util/concurrent/ExecutorService;

    .line 49
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/auditude/ads/util/PingUtil;->_executor_pred:Ljava/lang/Boolean;

    .line 51
    :cond_0
    sget-object v0, Lcom/auditude/ads/util/PingUtil;->_executor:Ljava/util/concurrent/ExecutorService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 46
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static final pingUrl(Ljava/lang/String;)V
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 56
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;I)V

    .line 57
    return-void
.end method

.method public static final pingUrl(Ljava/lang/String;I)V
    .locals 2
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "redirect"    # I

    .prologue
    .line 62
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/core/AdSettings;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    .line 63
    .local v0, "userAgent":Ljava/lang/String;
    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 65
    const-string v1, "http.agent"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 68
    :cond_0
    invoke-static {p0, v0, p1}, Lcom/auditude/ads/util/PingUtil;->pingUrlHttpURLConnection(Ljava/lang/String;Ljava/lang/String;I)V

    .line 69
    return-void
.end method

.method private static final pingUrlHttpURLConnection(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 3
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "userAgent"    # Ljava/lang/String;
    .param p2, "redirect"    # I

    .prologue
    .line 73
    sget v0, Lcom/auditude/ads/util/PingUtil;->REDIRECT_LIMIT:I

    if-ge p2, v0, :cond_0

    .line 75
    invoke-static {}, Lcom/auditude/ads/util/PingUtil;->getExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/auditude/ads/util/PingUtil$1;

    invoke-direct {v1, p2, p0, p1}, Lcom/auditude/ads/util/PingUtil$1;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 128
    :goto_0
    return-void

    .line 126
    :cond_0
    const-string v0, "Ping"

    invoke-static {v0}, Lcom/auditude/ads/util/log/Log;->getLogger(Ljava/lang/String;)Lcom/auditude/ads/util/log/ILogger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Too many redirects. Abandon Url: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/auditude/ads/util/log/ILogger;->info(Ljava/lang/Object;)V

    goto :goto_0
.end method
