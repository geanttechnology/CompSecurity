.class public Lcom/amazon/communication/authentication/DcpRequestSigner;
.super Lcom/amazon/communication/authentication/AbstractDcpRequestSigner;


# static fields
.field protected static final AUTH_TYPE:Ljava/lang/String;

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.DcpRequestSigner"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/authentication/DcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    sget-object v0, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/AuthenticationType;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/communication/authentication/DcpRequestSigner;->AUTH_TYPE:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected extractBody(Lorg/apache/http/client/methods/HttpRequestBase;)[B
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;
        }
    .end annotation

    const/4 v3, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    instance-of v1, p1, Lorg/apache/http/HttpEntityEnclosingRequest;

    if-eqz v1, :cond_5

    :try_start_0
    move-object v0, p1

    check-cast v0, Lorg/apache/http/HttpEntityEnclosingRequest;

    move-object v1, v0

    invoke-interface {v1}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v2

    if-eqz v2, :cond_4

    :try_start_1
    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/InputStream;->available()I

    move-result v1

    new-array v1, v1, [B

    invoke-virtual {v3, v1}, Ljava/io/InputStream;->read([B)I

    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->isRepeatable()Z

    move-result v3

    if-nez v3, :cond_0

    check-cast p1, Lorg/apache/http/HttpEntityEnclosingRequest;

    new-instance v3, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-direct {v3, v1}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    invoke-interface {p1, v3}, Lorg/apache/http/HttpEntityEnclosingRequest;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_0
    :goto_0
    if-eqz v2, :cond_1

    :try_start_2
    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->consumeContent()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    :cond_1
    :goto_1
    if-eqz v1, :cond_3

    :goto_2
    return-object v1

    :catch_0
    move-exception v2

    sget-object v3, Lcom/amazon/communication/authentication/DcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "extractBody"

    const-string/jumbo v5, "Error consuming remainder of entity content"

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v2, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    :catch_1
    move-exception v1

    move-object v2, v3

    :goto_3
    :try_start_3
    new-instance v3, Lamazon/communication/authentication/SigningException;

    const-string/jumbo v4, "Error getting content from http entity"

    invoke-direct {v3, v4, v1}, Lamazon/communication/authentication/SigningException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :catchall_0
    move-exception v1

    :goto_4
    if-eqz v2, :cond_2

    :try_start_4
    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->consumeContent()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    :cond_2
    :goto_5
    throw v1

    :catch_2
    move-exception v2

    sget-object v3, Lcom/amazon/communication/authentication/DcpRequestSigner;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "extractBody"

    const-string/jumbo v5, "Error consuming remainder of entity content"

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v2, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_5

    :cond_3
    sget-object v1, Lcom/amazon/communication/authentication/DcpRequestSigner;->EMPTY_BODY:[B

    goto :goto_2

    :catchall_1
    move-exception v1

    move-object v2, v3

    goto :goto_4

    :catch_3
    move-exception v1

    goto :goto_3

    :cond_4
    move-object v1, v3

    goto :goto_0

    :cond_5
    move-object v1, v3

    goto :goto_1
.end method

.method public signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/authentication/SigningException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/amazon/communication/authentication/DcpRequestSigner;->validateRequest(Lorg/apache/http/client/methods/HttpRequestBase;)V

    invoke-virtual {p1}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {p0, p1}, Lcom/amazon/communication/authentication/DcpRequestSigner;->extractBody(Lorg/apache/http/client/methods/HttpRequestBase;)[B

    move-result-object v4

    sget-object v2, Lcom/amazon/communication/authentication/DcpRequestSigner;->AUTH_TYPE:Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/communication/authentication/DcpRequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/String;Landroid/net/Uri;[BLamazon/communication/authentication/RequestContext;)V

    return-void
.end method
