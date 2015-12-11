.class final Lorg/springframework/http/client/SimpleClientHttpResponse;
.super Lorg/springframework/http/client/AbstractClientHttpResponse;
.source "SimpleClientHttpResponse.java"


# instance fields
.field private final connection:Ljava/net/HttpURLConnection;

.field private headers:Lorg/springframework/http/HttpHeaders;


# direct methods
.method constructor <init>(Ljava/net/HttpURLConnection;)V
    .locals 0
    .param p1, "connection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 44
    invoke-direct {p0}, Lorg/springframework/http/client/AbstractClientHttpResponse;-><init>()V

    .line 45
    iput-object p1, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    .line 46
    return-void
.end method


# virtual methods
.method protected closeInternal()V
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 117
    return-void
.end method

.method protected getBodyInternal()Ljava/io/InputStream;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 110
    iget-object v1, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    .line 111
    .local v0, "errorStream":Ljava/io/InputStream;
    if-eqz v0, :cond_0

    .end local v0    # "errorStream":Ljava/io/InputStream;
    :goto_0
    return-object v0

    .restart local v0    # "errorStream":Ljava/io/InputStream;
    :cond_0
    iget-object v1, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0
.end method

.method public getHeaders()Lorg/springframework/http/HttpHeaders;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 88
    iget-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->headers:Lorg/springframework/http/HttpHeaders;

    if-nez v2, :cond_1

    .line 89
    new-instance v2, Lorg/springframework/http/HttpHeaders;

    invoke-direct {v2}, Lorg/springframework/http/HttpHeaders;-><init>()V

    iput-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->headers:Lorg/springframework/http/HttpHeaders;

    .line 91
    iget-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v2, v4}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v1

    .line 92
    .local v1, "name":Ljava/lang/String;
    invoke-static {v1}, Lorg/springframework/util/StringUtils;->hasLength(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 93
    iget-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->headers:Lorg/springframework/http/HttpHeaders;

    iget-object v3, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v3, v4}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lorg/springframework/http/HttpHeaders;->add(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    :cond_0
    const/4 v0, 0x1

    .line 97
    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v2, v0}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v1

    .line 98
    invoke-static {v1}, Lorg/springframework/util/StringUtils;->hasLength(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 105
    .end local v0    # "i":I
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->headers:Lorg/springframework/http/HttpHeaders;

    return-object v2

    .line 101
    .restart local v0    # "i":I
    .restart local v1    # "name":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->headers:Lorg/springframework/http/HttpHeaders;

    iget-object v3, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v3, v0}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Lorg/springframework/http/HttpHeaders;->add(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public getRawStatusCode()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v0

    return v0
.end method

.method public getStatusCode()Lorg/springframework/http/HttpStatus;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 55
    :try_start_0
    invoke-virtual {p0}, Lorg/springframework/http/client/SimpleClientHttpResponse;->getRawStatusCode()I

    move-result v1

    invoke-static {v1}, Lorg/springframework/http/HttpStatus;->valueOf(I)Lorg/springframework/http/HttpStatus;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 63
    :goto_0
    return-object v1

    .line 56
    :catch_0
    move-exception v0

    .line 62
    .local v0, "ex":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Received authentication challenge is null"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 63
    sget-object v1, Lorg/springframework/http/HttpStatus;->UNAUTHORIZED:Lorg/springframework/http/HttpStatus;

    goto :goto_0

    .line 65
    :cond_0
    throw v0
.end method

.method public getStatusText()Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 72
    :try_start_0
    iget-object v1, p0, Lorg/springframework/http/client/SimpleClientHttpResponse;->connection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 80
    :goto_0
    return-object v1

    .line 73
    :catch_0
    move-exception v0

    .line 79
    .local v0, "ex":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Received authentication challenge is null"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 80
    sget-object v1, Lorg/springframework/http/HttpStatus;->UNAUTHORIZED:Lorg/springframework/http/HttpStatus;

    invoke-virtual {v1}, Lorg/springframework/http/HttpStatus;->getReasonPhrase()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 82
    :cond_0
    throw v0
.end method
