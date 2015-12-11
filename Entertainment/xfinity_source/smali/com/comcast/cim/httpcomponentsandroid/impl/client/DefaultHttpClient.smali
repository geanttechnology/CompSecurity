.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;
.source "DefaultHttpClient.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 150
    invoke-direct {p0, v0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 151
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 0
    .param p1, "conman"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 131
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 132
    return-void
.end method

.method public static setDefaultHttpParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 4
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 178
    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    invoke-static {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    .line 179
    const-string v2, "ISO-8859-1"

    invoke-static {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setContentCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V

    .line 180
    const/4 v2, 0x1

    invoke-static {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setTcpNoDelay(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Z)V

    .line 181
    const/16 v2, 0x2000

    invoke-static {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setSocketBufferSize(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 184
    const-string v2, "com.comcast.cim.httpcomponentsandroid.client"

    const-class v3, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;

    invoke-virtual {v3}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->loadVersionInfo(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;

    move-result-object v1

    .line 186
    .local v1, "vi":Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->getRelease()Ljava/lang/String;

    move-result-object v0

    .line 188
    .local v0, "release":Ljava/lang/String;
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Apache-HttpClient/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " (java 1.5)"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setUserAgent(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V

    .line 190
    return-void

    .line 186
    .end local v0    # "release":Ljava/lang/String;
    :cond_0
    const-string v0, "UNAVAILABLE"

    goto :goto_0
.end method


# virtual methods
.method protected createHttpParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 161
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/params/SyncBasicHttpParams;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/params/SyncBasicHttpParams;-><init>()V

    .line 162
    .local v0, "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->setDefaultHttpParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 163
    return-object v0
.end method

.method protected createHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    .locals 2

    .prologue
    .line 195
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;-><init>()V

    .line 196
    .local v0, "httpproc":Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestDefaultHeaders;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestDefaultHeaders;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 198
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestContent;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestContent;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 199
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestTargetHost;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestTargetHost;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 201
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestClientConnControl;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestClientConnControl;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 202
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestUserAgent;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestUserAgent;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 203
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestExpectContinue;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/RequestExpectContinue;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 205
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAddCookies;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAddCookies;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 206
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    .line 208
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAuthCache;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAuthCache;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 209
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseAuthCache;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseAuthCache;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    .line 210
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestTargetAuthentication;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestTargetAuthentication;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 211
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestProxyAuthentication;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 212
    return-object v0
.end method
