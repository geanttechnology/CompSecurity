.class Lcom/conviva/utils/Utils$HTTPTask;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/conviva/utils/Utils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HTTPTask"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;
    }
.end annotation


# instance fields
.field private _callback:Lcom/conviva/utils/CallableWithParameters$With1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/conviva/utils/CallableWithParameters$With1",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private _client:Lorg/apache/http/client/HttpClient;

.field private _contentT:Ljava/lang/String;

.field private _data:Ljava/lang/String;

.field private _isPost:Ljava/lang/Boolean;

.field private _method:Lorg/apache/http/client/methods/HttpUriRequest;

.field private _responseHandler:Lorg/apache/http/client/ResponseHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/apache/http/client/ResponseHandler",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private _url:Ljava/lang/String;

.field final synthetic this$0:Lcom/conviva/utils/Utils;


# direct methods
.method private constructor <init>(Lcom/conviva/utils/Utils;)V
    .locals 1

    const/4 v0, 0x0

    iput-object p1, p0, Lcom/conviva/utils/Utils$HTTPTask;->this$0:Lcom/conviva/utils/Utils;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_callback:Lcom/conviva/utils/CallableWithParameters$With1;

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_client:Lorg/apache/http/client/HttpClient;

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_method:Lorg/apache/http/client/methods/HttpUriRequest;

    return-void
.end method

.method synthetic constructor <init>(Lcom/conviva/utils/Utils;Lcom/conviva/utils/Utils$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/conviva/utils/Utils$HTTPTask;-><init>(Lcom/conviva/utils/Utils;)V

    return-void
.end method

.method static synthetic access$200(Lcom/conviva/utils/Utils$HTTPTask;Ljava/lang/Exception;[B)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/conviva/utils/Utils$HTTPTask;->doneHandler(Ljava/lang/Exception;[B)V

    return-void
.end method

.method private doneHandler(Ljava/lang/Exception;[B)V
    .locals 5

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/conviva/utils/Utils$HTTPTask;->_callback:Lcom/conviva/utils/CallableWithParameters$With1;

    iput-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_callback:Lcom/conviva/utils/CallableWithParameters$With1;

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->this$0:Lcom/conviva/utils/Utils;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to send heartbeat: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/conviva/utils/Utils;->err(Ljava/lang/String;)V

    :cond_0
    if-nez p2, :cond_2

    move-object v0, v1

    :goto_0
    if-eqz v2, :cond_1

    if-nez p1, :cond_3

    :goto_1
    invoke-interface {v2, v0}, Lcom/conviva/utils/CallableWithParameters$With1;->exec(Ljava/lang/Object;)V

    :cond_1
    return-void

    :cond_2
    const-string v0, "UTF-8"

    invoke-static {p2, v0}, Lorg/apache/http/util/EncodingUtils;->getString([BLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    move-object v0, v1

    goto :goto_1
.end method

.method private shouldUseSsl(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 1

    const-string v0, "https://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method private sslClient(Lorg/apache/http/client/HttpClient;)Lorg/apache/http/client/HttpClient;
    .locals 7

    const/4 v1, 0x0

    :try_start_0
    new-instance v0, Lcom/conviva/utils/Utils$HTTPTask$1;

    invoke-direct {v0, p0}, Lcom/conviva/utils/Utils$HTTPTask$1;-><init>(Lcom/conviva/utils/Utils$HTTPTask;)V

    const-string v2, "TLS"

    invoke-static {v2}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    new-array v4, v4, [Ljavax/net/ssl/TrustManager;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    const/4 v0, 0x0

    invoke-virtual {v2, v3, v4, v0}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V

    new-instance v0, Lcom/conviva/platforms/ConvivaSSLSocketFactory;

    invoke-direct {v0, v2}, Lcom/conviva/platforms/ConvivaSSLSocketFactory;-><init>(Ljavax/net/ssl/SSLContext;)V

    sget-object v2, Lorg/apache/http/conn/ssl/SSLSocketFactory;->ALLOW_ALL_HOSTNAME_VERIFIER:Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    invoke-virtual {v0, v2}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->setHostnameVerifier(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V

    invoke-interface {p1}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/conn/ClientConnectionManager;->getSchemeRegistry()Lorg/apache/http/conn/scheme/SchemeRegistry;

    move-result-object v3

    new-instance v4, Lorg/apache/http/conn/scheme/Scheme;

    const-string v5, "https"

    const/16 v6, 0x1bb

    invoke-direct {v4, v5, v0, v6}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v4}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    new-instance v0, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-interface {p1}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->this$0:Lcom/conviva/utils/Utils;

    const-string v2, "Error in creating SSL client"

    invoke-virtual {v0, v2}, Lcom/conviva/utils/Utils;->log(Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 5

    const/4 v4, 0x0

    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    sget-object v1, Lorg/apache/http/HttpVersion;->HTTP_1_1:Lorg/apache/http/HttpVersion;

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpProtocolParams;->setVersion(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V

    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpProtocolParams;->setContentCharset(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpProtocolParams;->setUseExpectContinue(Lorg/apache/http/params/HttpParams;Z)V

    const v1, 0xea60

    invoke-static {v0, v1}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1, v0}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_url:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/conviva/utils/Utils$HTTPTask;->shouldUseSsl(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, v1}, Lcom/conviva/utils/Utils$HTTPTask;->sslClient(Lorg/apache/http/client/HttpClient;)Lorg/apache/http/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_client:Lorg/apache/http/client/HttpClient;

    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_isPost:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Lorg/apache/http/client/methods/HttpPost;

    iget-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_url:Ljava/lang/String;

    invoke-direct {v0, v1}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    new-instance v1, Lorg/apache/http/entity/ByteArrayEntity;

    iget-object v2, p0, Lcom/conviva/utils/Utils$HTTPTask;->_data:Ljava/lang/String;

    const-string v3, "UTF-8"

    invoke-virtual {v2, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    invoke-virtual {v0, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_method:Lorg/apache/http/client/methods/HttpUriRequest;

    :goto_1
    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_contentT:Ljava/lang/String;

    if-nez v0, :cond_2

    const-string v0, "application/json"

    :goto_2
    iget-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_method:Lorg/apache/http/client/methods/HttpUriRequest;

    const-string v2, "Content-Type"

    invoke-interface {v1, v2, v0}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/conviva/utils/Utils$HTTPTask$HttpResponseHandler;-><init>(Lcom/conviva/utils/Utils$HTTPTask;Lcom/conviva/utils/Utils$1;)V

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_responseHandler:Lorg/apache/http/client/ResponseHandler;

    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_client:Lorg/apache/http/client/HttpClient;

    iget-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_method:Lorg/apache/http/client/methods/HttpUriRequest;

    iget-object v2, p0, Lcom/conviva/utils/Utils$HTTPTask;->_responseHandler:Lorg/apache/http/client/ResponseHandler;

    invoke-interface {v0, v1, v2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_3
    return-void

    :cond_0
    iput-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_client:Lorg/apache/http/client/HttpClient;

    goto :goto_0

    :cond_1
    :try_start_1
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    iget-object v1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_url:Ljava/lang/String;

    invoke-direct {v0, v1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_method:Lorg/apache/http/client/methods/HttpUriRequest;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    invoke-direct {p0, v0, v4}, Lcom/conviva/utils/Utils$HTTPTask;->doneHandler(Ljava/lang/Exception;[B)V

    goto :goto_3

    :cond_2
    :try_start_2
    iget-object v0, p0, Lcom/conviva/utils/Utils$HTTPTask;->_contentT:Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2
.end method

.method public setState(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/conviva/utils/CallableWithParameters$With1;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Boolean;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/conviva/utils/CallableWithParameters$With1",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/conviva/utils/Utils$HTTPTask;->_isPost:Ljava/lang/Boolean;

    iput-object p2, p0, Lcom/conviva/utils/Utils$HTTPTask;->_url:Ljava/lang/String;

    iput-object p3, p0, Lcom/conviva/utils/Utils$HTTPTask;->_data:Ljava/lang/String;

    iput-object p4, p0, Lcom/conviva/utils/Utils$HTTPTask;->_contentT:Ljava/lang/String;

    iput-object p5, p0, Lcom/conviva/utils/Utils$HTTPTask;->_callback:Lcom/conviva/utils/CallableWithParameters$With1;

    return-void
.end method
