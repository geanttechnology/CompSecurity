.class public Lcom/comcast/playerplatform/util/android/XrestHelper;
.super Ljava/lang/Object;
.source "XrestHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private currentEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

.field private endpoint:Ljava/lang/String;

.field private headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private httpMethod:Ljava/lang/String;

.field private input:Ljava/lang/String;

.field private listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

.field private moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 0
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "endpoint"    # Ljava/lang/String;
    .param p3, "httpMethod"    # Ljava/lang/String;
    .param p5, "responseEventListener"    # Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    .param p6, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 56
    .local p4, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->input:Ljava/lang/String;

    .line 58
    iput-object p2, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    .line 59
    iput-object p3, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;

    .line 60
    iput-object p4, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    .line 61
    iput-object p5, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    .line 62
    iput-object p6, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 63
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 0
    .param p1, "input"    # Ljava/lang/String;
    .param p2, "endpoint"    # Ljava/lang/String;
    .param p3, "httpMethod"    # Ljava/lang/String;
    .param p5, "responseEventListener"    # Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    .param p6, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p7, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;",
            "Lcom/comcast/playerplatform/util/android/MoneyTrace;",
            ")V"
        }
    .end annotation

    .prologue
    .line 72
    .local p4, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->input:Ljava/lang/String;

    .line 74
    iput-object p2, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    .line 75
    iput-object p3, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;

    .line 76
    iput-object p4, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    .line 77
    iput-object p5, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    .line 78
    iput-object p6, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 79
    iput-object p7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .line 80
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/util/android/XrestHelper;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/util/android/XrestHelper;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/util/android/XrestHelper;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/util/android/XrestHelper;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;

    return-object v0
.end method

.method private getHeaders(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;)V
    .locals 4
    .param p1, "httpPost"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;

    .prologue
    .line 168
    iget-object v2, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 170
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 172
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method private parseResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Ljava/lang/String;
    .locals 6
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 176
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    .line 177
    .local v1, "ips":Ljava/io/InputStream;
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    const-string v5, "UTF-8"

    invoke-direct {v4, v1, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v0, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 178
    .local v0, "buf":Ljava/io/BufferedReader;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v4

    const/16 v5, 0xc8

    if-eq v4, v5, :cond_0

    .line 180
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 181
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Network Error on request to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " Reason: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 194
    :goto_0
    return-object v4

    .line 183
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 187
    .local v3, "sb":Ljava/lang/StringBuilder;
    :goto_1
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    .line 188
    .local v2, "s":Ljava/lang/String;
    if-nez v2, :cond_1

    .line 192
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 193
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 194
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 190
    :cond_1
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method

.method private sendHttpMessage()Ljava/lang/String;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 83
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->currentEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    if-eqz v7, :cond_0

    .line 84
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->currentEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-static {v7}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 85
    iput-object v5, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->currentEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 91
    :cond_0
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;

    const-string v8, "POST"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 93
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    invoke-direct {v4, v7}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 94
    .local v4, "httpPost":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/entity/StringEntity;

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->input:Ljava/lang/String;

    invoke-direct {v0, v7}, Lcom/comcast/cim/httpcomponentsandroid/entity/StringEntity;-><init>(Ljava/lang/String;)V

    .line 95
    .local v0, "entity":Lcom/comcast/cim/httpcomponentsandroid/entity/StringEntity;
    invoke-virtual {v4, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 97
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    if-eqz v7, :cond_1

    .line 98
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getHttpHeader()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->generateHttpHeaderValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    :cond_1
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    if-eqz v7, :cond_2

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_2

    .line 103
    invoke-direct {p0, v4}, Lcom/comcast/playerplatform/util/android/XrestHelper;->getHeaders(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;)V

    .line 105
    :cond_2
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v7, v4}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v6

    .line 106
    .local v6, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-direct {p0, v6}, Lcom/comcast/playerplatform/util/android/XrestHelper;->parseResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Ljava/lang/String;

    move-result-object v5

    .line 164
    .end local v0    # "entity":Lcom/comcast/cim/httpcomponentsandroid/entity/StringEntity;
    .end local v4    # "httpPost":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;
    .end local v6    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :cond_3
    :goto_0
    return-object v5

    .line 108
    :cond_4
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;

    const-string v8, "GET"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 110
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    invoke-direct {v2, v7}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 112
    .local v2, "httpGet":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    if-eqz v7, :cond_5

    .line 113
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getHttpHeader()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->generateHttpHeaderValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    :cond_5
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    if-eqz v7, :cond_6

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_6

    .line 117
    invoke-direct {p0, v2}, Lcom/comcast/playerplatform/util/android/XrestHelper;->getHeaders(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;)V

    .line 120
    :cond_6
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v7, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v6

    .line 121
    .restart local v6    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-direct {p0, v6}, Lcom/comcast/playerplatform/util/android/XrestHelper;->parseResponse(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 123
    .end local v2    # "httpGet":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;
    .end local v6    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :cond_7
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;

    const-string v8, "HEAD"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 125
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    invoke-direct {v3, v7}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;-><init>(Ljava/lang/String;)V

    .line 127
    .local v3, "httpHead":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    if-eqz v7, :cond_8

    .line 128
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->getHttpHeader()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-virtual {v8}, Lcom/comcast/playerplatform/util/android/MoneyTrace;->generateHttpHeaderValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    :cond_8
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    if-eqz v7, :cond_9

    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->headers:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_9

    .line 133
    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/util/android/XrestHelper;->getHeaders(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;)V

    .line 137
    :cond_9
    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpHead;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v7

    const-string v8, "http.protocol.handle-redirects"

    const/4 v9, 0x0

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 139
    iget-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v7, v3}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v6

    .line 141
    .restart local v6    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v7

    iput-object v7, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->currentEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 144
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v7

    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x12e

    if-eq v7, v8, :cond_a

    .line 146
    new-instance v7, Ljava/lang/Exception;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v8

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v7

    .line 151
    :cond_a
    const-string v7, "location"

    invoke-interface {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 152
    .local v1, "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_3

    array-length v7, v1

    if-lez v7, :cond_3

    .line 153
    array-length v7, v1

    add-int/lit8 v7, v7, -0x1

    aget-object v7, v1, v7

    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    .line 154
    .local v5, "newUrl":Ljava/lang/String;
    const-string v7, ".m3u8"

    invoke-virtual {v5, v7}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 158
    iput-object v5, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    .line 159
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->sendHttpMessage()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_0
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 203
    :try_start_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->sendHttpMessage()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 210
    .local v1, "response":Ljava/lang/String;
    :goto_0
    move-object v2, v1

    .line 212
    .local v2, "responseString":Ljava/lang/String;
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ThreadManager;->getInstance()Lcom/comcast/playerplatform/util/android/ThreadManager;

    move-result-object v3

    new-instance v4, Lcom/comcast/playerplatform/util/android/XrestHelper$1;

    invoke-direct {v4, p0, v2}, Lcom/comcast/playerplatform/util/android/XrestHelper$1;-><init>(Lcom/comcast/playerplatform/util/android/XrestHelper;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/comcast/playerplatform/util/android/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 235
    return-void

    .line 205
    .end local v1    # "response":Ljava/lang/String;
    .end local v2    # "responseString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 207
    .local v0, "e":Ljava/lang/Exception;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Network Error on request to "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/util/android/XrestHelper;->endpoint:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "response":Ljava/lang/String;
    goto :goto_0
.end method
