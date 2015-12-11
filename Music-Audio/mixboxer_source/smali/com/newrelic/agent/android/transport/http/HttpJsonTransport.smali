.class public Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;
.super Ljava/lang/Object;
.source "HttpJsonTransport.java"

# interfaces
.implements Lcom/newrelic/agent/android/transport/Transport;


# static fields
.field private static final BUFFER_SIZE:I = 0x2000

.field public static final CONNECT_TIME_HEADER:Ljava/lang/String; = "X-NewRelic-Connect-Time"

.field private static final KILL_STRING:Ljava/lang/String; = "DISABLE_NEW_RELIC"

.field public static final LICENSE_KEY_HEADER:Ljava/lang/String; = "X-App-License-Key"

.field private static final TIMEOUT_IN_SECONDS:I = 0x14

.field private static final log:Lcom/newrelic/agent/android/logging/AgentLog;


# instance fields
.field private final client:Lorg/apache/http/client/HttpClient;

.field private final endpoint:Ljava/lang/String;

.field private final licenseKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    invoke-static {}, Lcom/newrelic/agent/android/logging/AgentLogManager;->getAgentLog()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "endpoint"    # Ljava/lang/String;
    .param p2, "licenseKey"    # Ljava/lang/String;

    .prologue
    const-wide/16 v3, 0x14

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->endpoint:Ljava/lang/String;

    .line 59
    iput-object p2, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->licenseKey:Ljava/lang/String;

    .line 60
    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 65
    .local v0, "params":Lorg/apache/http/params/BasicHttpParams;
    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v3, v4, v2}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    long-to-int v1, v1

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 66
    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v3, v4, v2}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v1

    long-to-int v1, v1

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 67
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setTcpNoDelay(Lorg/apache/http/params/HttpParams;Z)V

    .line 68
    const/16 v1, 0x2000

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setSocketBufferSize(Lorg/apache/http/params/HttpParams;I)V

    .line 69
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1, v0}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    iput-object v1, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->client:Lorg/apache/http/client/HttpClient;

    .line 70
    return-void
.end method

.method private deflate(Ljava/lang/String;)[B
    .locals 6
    .param p1, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/newrelic/agent/android/transport/TransportException;
        }
    .end annotation

    .prologue
    .line 207
    new-instance v3, Ljava/util/zip/Deflater;

    invoke-direct {v3}, Ljava/util/zip/Deflater;-><init>()V

    .line 208
    .local v3, "deflater":Ljava/util/zip/Deflater;
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/zip/Deflater;->setInput([B)V

    .line 209
    invoke-virtual {v3}, Ljava/util/zip/Deflater;->finish()V

    .line 211
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 212
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v4, 0x2000

    new-array v1, v4, [B

    .line 213
    .local v1, "buf":[B
    :goto_0
    invoke-virtual {v3}, Ljava/util/zip/Deflater;->finished()Z

    move-result v4

    if-nez v4, :cond_1

    .line 214
    invoke-virtual {v3, v1}, Ljava/util/zip/Deflater;->deflate([B)I

    move-result v2

    .line 218
    .local v2, "byteCount":I
    if-gtz v2, :cond_0

    .line 219
    new-instance v4, Lcom/newrelic/agent/android/transport/TransportException;

    const-string v5, "HTTP request contains an incomplete payload"

    invoke-direct {v4, v5}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 221
    :cond_0
    const/4 v4, 0x0

    invoke-virtual {v0, v1, v4, v2}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_0

    .line 223
    .end local v2    # "byteCount":I
    :cond_1
    invoke-virtual {v3}, Ljava/util/zip/Deflater;->end()V

    .line 224
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    return-object v4
.end method

.method private getMessageEndpoint(Lcom/newrelic/agent/android/transport/Transport$MessageType;)Ljava/lang/String;
    .locals 4
    .param p1, "type"    # Lcom/newrelic/agent/android/transport/Transport$MessageType;

    .prologue
    .line 228
    const-string v0, "{0}/{1}"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->endpoint:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/newrelic/agent/android/transport/Transport$MessageType;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/text/MessageFormat;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private recordCollectorError(I)V
    .locals 3
    .param p1, "errorCode"    # I

    .prologue
    .line 73
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->get()Lcom/newrelic/agent/android/stats/StatsEngine;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Supportability/MobileAgent/Collector/ResponseErrorCodes/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/agent/android/stats/StatsEngine;->inc(Ljava/lang/String;)V

    .line 74
    return-void
.end method


# virtual methods
.method public send(Lcom/newrelic/agent/android/transport/Transport$MessageType;Ljava/lang/String;J)Ljava/lang/String;
    .locals 13
    .param p1, "type"    # Lcom/newrelic/agent/android/transport/Transport$MessageType;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "serverTimestamp"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/InterruptedIOException;,
            Lcom/newrelic/agent/android/transport/DisableAgentException;,
            Lcom/newrelic/agent/android/transport/DisconnectAgentException;,
            Lcom/newrelic/agent/android/transport/FlushTransactionDataException;,
            Lcom/newrelic/agent/android/transport/TransportException;
        }
    .end annotation

    .prologue
    .line 78
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v9

    const/16 v10, 0x200

    if-gt v9, v10, :cond_2

    const-string v1, "identity"

    .line 79
    .local v1, "contentEncoding":Ljava/lang/String;
    :goto_0
    new-instance v8, Lcom/newrelic/agent/android/stats/TicToc;

    invoke-direct {v8}, Lcom/newrelic/agent/android/stats/TicToc;-><init>()V

    .line 81
    .local v8, "timer":Lcom/newrelic/agent/android/stats/TicToc;
    invoke-virtual {v8}, Lcom/newrelic/agent/android/stats/TicToc;->tic()V

    .line 86
    new-instance v5, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->getMessageEndpoint(Lcom/newrelic/agent/android/transport/Transport$MessageType;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v5, v9}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 87
    .local v5, "post":Lorg/apache/http/client/methods/HttpPost;
    const-string v9, "Content-Type"

    const-string v10, "application/json"

    invoke-virtual {v5, v9, v10}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    const-string v9, "Content-Encoding"

    invoke-virtual {v5, v9, v1}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    const-string v9, "X-App-License-Key"

    iget-object v10, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->licenseKey:Ljava/lang/String;

    invoke-virtual {v5, v9, v10}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string v9, "User-Agent"

    const-string v10, "http.agent"

    invoke-static {v10}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-wide/16 v9, 0x0

    cmp-long v9, p3, v9

    if-eqz v9, :cond_0

    .line 92
    const-string v9, "X-NewRelic-Connect-Time"

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    :cond_0
    const-string v9, "deflate"

    invoke-virtual {v9, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 96
    invoke-direct {p0, p2}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->deflate(Ljava/lang/String;)[B

    move-result-object v2

    .line 97
    .local v2, "deflated":[B
    new-instance v9, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-direct {v9, v2}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    invoke-virtual {v5, v9}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 109
    .end local v2    # "deflated":[B
    :goto_1
    :try_start_0
    iget-object v9, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->client:Lorg/apache/http/client/HttpClient;

    invoke-interface {v9, v5}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v6

    .line 147
    .local v6, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v9

    invoke-interface {v9}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v9

    const/16 v10, 0x190

    if-ge v9, v10, :cond_1

    .line 148
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->reset()V

    .line 151
    :cond_1
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->get()Lcom/newrelic/agent/android/stats/StatsEngine;

    move-result-object v9

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Supportability/MobileAgent/Collector/ResponseStatusCodes/"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8}, Lcom/newrelic/agent/android/stats/TicToc;->toc()J

    move-result-wide v11

    invoke-virtual {v9, v10, v11, v12}, Lcom/newrelic/agent/android/stats/StatsEngine;->recordTimeMs(Ljava/lang/String;J)V

    .line 153
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v9

    invoke-interface {v9}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v9

    const/16 v10, 0x190

    if-ge v9, v10, :cond_b

    .line 159
    :try_start_1
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v9

    invoke-interface {v9}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v4

    .line 161
    .local v4, "in":Ljava/io/InputStream;
    :try_start_2
    invoke-static {v4}, Lcom/newrelic/agent/android/util/Util;->slurp(Ljava/io/InputStream;)Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v7

    .line 164
    .local v7, "responseJson":Ljava/lang/String;
    :try_start_3
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3

    .line 171
    return-object v7

    .line 78
    .end local v1    # "contentEncoding":Ljava/lang/String;
    .end local v4    # "in":Ljava/io/InputStream;
    .end local v5    # "post":Lorg/apache/http/client/methods/HttpPost;
    .end local v6    # "response":Lorg/apache/http/HttpResponse;
    .end local v7    # "responseJson":Ljava/lang/String;
    .end local v8    # "timer":Lcom/newrelic/agent/android/stats/TicToc;
    :cond_2
    const-string v1, "deflate"

    goto/16 :goto_0

    .line 100
    .restart local v1    # "contentEncoding":Ljava/lang/String;
    .restart local v5    # "post":Lorg/apache/http/client/methods/HttpPost;
    .restart local v8    # "timer":Lcom/newrelic/agent/android/stats/TicToc;
    :cond_3
    :try_start_4
    new-instance v9, Lorg/apache/http/entity/StringEntity;

    const-string v10, "utf-8"

    invoke-direct {v9, p2, v10}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5, v9}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_4
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_4} :catch_0

    goto :goto_1

    .line 102
    :catch_0
    move-exception v3

    .line 103
    .local v3, "e":Ljava/io/UnsupportedEncodingException;
    sget-object v9, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v10, "UTF-8 is unsupported"

    invoke-interface {v9, v10}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    .line 104
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    invoke-direct {v9, v3}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 111
    .end local v3    # "e":Ljava/io/UnsupportedEncodingException;
    :catch_1
    move-exception v3

    .line 112
    .local v3, "e":Lorg/apache/http/client/ClientProtocolException;
    sget-object v9, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "HTTP protocol error during "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p1}, Lcom/newrelic/agent/android/transport/Transport$MessageType;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;)V

    .line 113
    const/16 v9, -0x3f3

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    .line 114
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    invoke-direct {v9, v3}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 116
    .end local v3    # "e":Lorg/apache/http/client/ClientProtocolException;
    :catch_2
    move-exception v3

    .line 117
    .local v3, "e":Ljava/io/IOException;
    instance-of v9, v3, Ljava/net/UnknownHostException;

    if-eqz v9, :cond_4

    .line 118
    const/16 v9, -0x3ee

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    .line 136
    :goto_2
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v9

    const-class v10, Ljava/io/InterruptedIOException;

    if-ne v9, v10, :cond_a

    .line 137
    sget-object v9, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    const-string v10, "Interrupted during an I/O operation"

    invoke-interface {v9, v10}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 138
    check-cast v3, Ljava/io/InterruptedIOException;

    .end local v3    # "e":Ljava/io/IOException;
    throw v3

    .line 119
    .restart local v3    # "e":Ljava/io/IOException;
    :cond_4
    instance-of v9, v3, Ljava/net/SocketTimeoutException;

    if-eqz v9, :cond_5

    .line 120
    const/16 v9, -0x3e9

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    goto :goto_2

    .line 121
    :cond_5
    instance-of v9, v3, Lorg/apache/http/conn/ConnectTimeoutException;

    if-eqz v9, :cond_6

    .line 122
    const/16 v9, -0x3e9

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    goto :goto_2

    .line 123
    :cond_6
    instance-of v9, v3, Ljava/net/ConnectException;

    if-eqz v9, :cond_7

    .line 124
    const/16 v9, -0x3ec

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    goto :goto_2

    .line 125
    :cond_7
    instance-of v9, v3, Ljava/net/MalformedURLException;

    if-eqz v9, :cond_8

    .line 126
    const/16 v9, -0x3e8

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    goto :goto_2

    .line 127
    :cond_8
    instance-of v9, v3, Ljavax/net/ssl/SSLException;

    if-eqz v9, :cond_9

    .line 128
    const/16 v9, -0x4b0

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    goto :goto_2

    .line 130
    :cond_9
    const/4 v9, -0x1

    invoke-direct {p0, v9}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->recordCollectorError(I)V

    goto :goto_2

    .line 140
    :cond_a
    sget-object v9, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "I/O error during "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p1}, Lcom/newrelic/agent/android/transport/Transport$MessageType;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 141
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    invoke-direct {v9, v3}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 164
    .end local v3    # "e":Ljava/io/IOException;
    .restart local v4    # "in":Ljava/io/InputStream;
    .restart local v6    # "response":Lorg/apache/http/HttpResponse;
    :catchall_0
    move-exception v9

    :try_start_5
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    throw v9
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 167
    .end local v4    # "in":Ljava/io/InputStream;
    :catch_3
    move-exception v3

    .line 168
    .restart local v3    # "e":Ljava/io/IOException;
    sget-object v9, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Failed to read JSON response during "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p1}, Lcom/newrelic/agent/android/transport/Transport$MessageType;->name()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 169
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    invoke-direct {v9, v3}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 174
    .end local v3    # "e":Ljava/io/IOException;
    :cond_b
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v9

    invoke-interface {v9}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v9

    sparse-switch v9, :sswitch_data_0

    .line 200
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v10

    invoke-interface {v10}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v10

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/newrelic/agent/android/transport/Transport$MessageType;->name()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " failed with status code "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v12

    invoke-interface {v12}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(ILjava/lang/String;)V

    throw v9

    .line 177
    :sswitch_0
    new-instance v9, Lcom/newrelic/agent/android/transport/DisconnectAgentException;

    invoke-direct {v9}, Lcom/newrelic/agent/android/transport/DisconnectAgentException;-><init>()V

    throw v9

    .line 181
    :sswitch_1
    :try_start_6
    invoke-interface {v6}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v9

    invoke-interface {v9}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v9

    invoke-static {v9}, Lcom/newrelic/agent/android/util/Util;->slurp(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_4

    move-result-object v0

    .line 187
    .local v0, "content":Ljava/lang/String;
    const-string v9, "DISABLE_NEW_RELIC"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 188
    new-instance v9, Lcom/newrelic/agent/android/transport/DisableAgentException;

    invoke-direct {v9}, Lcom/newrelic/agent/android/transport/DisableAgentException;-><init>()V

    throw v9

    .line 183
    .end local v0    # "content":Ljava/lang/String;
    :catch_4
    move-exception v3

    .line 184
    .local v3, "e":Ljava/lang/Throwable;
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    invoke-direct {v9, v3}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 191
    .end local v3    # "e":Ljava/lang/Throwable;
    .restart local v0    # "content":Ljava/lang/String;
    :cond_c
    new-instance v9, Lcom/newrelic/agent/android/transport/TransportException;

    const-string v10, "Unexpected HTTP 403 from the collector"

    invoke-direct {v9, v10}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 198
    .end local v0    # "content":Ljava/lang/String;
    :sswitch_2
    new-instance v9, Lcom/newrelic/agent/android/transport/FlushTransactionDataException;

    invoke-direct {v9}, Lcom/newrelic/agent/android/transport/FlushTransactionDataException;-><init>()V

    throw v9

    .line 174
    :sswitch_data_0
    .sparse-switch
        0x191 -> :sswitch_0
        0x193 -> :sswitch_1
        0x19d -> :sswitch_2
        0x19f -> :sswitch_2
        0x1c2 -> :sswitch_0
    .end sparse-switch
.end method
