.class public Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;
.super Ljava/lang/Object;
.source "SignedHTTPRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;"
        }
    .end annotation
.end field

.field private requestSigner:Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    .local p1, "delegateProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    .local p2, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->LOG:Lorg/slf4j/Logger;

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    .line 17
    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->requestSigner:Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    .line 18
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 45
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    return-void
.end method

.method public addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 40
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    return-void
.end method

.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 35
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    return-void
.end method

.method public createRequest()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->createRequest()Ljava/lang/Object;

    move-result-object v1

    .line 25
    .local v1, "request":Ljava/lang/Object;, "TT;"
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->requestSigner:Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    invoke-interface {v2, v1}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;->signRequest(Ljava/lang/Object;)V
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_0 .. :try_end_0} :catch_0

    .line 30
    :goto_0
    return-object v1

    .line 26
    :catch_0
    move-exception v0

    .line 27
    .local v0, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Exception occurred during signing"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public setSocketTimeout(J)V
    .locals 1
    .param p1, "timeoutInMillis"    # J

    .prologue
    .line 50
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->delegateProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->setSocketTimeout(J)V

    .line 51
    return-void
.end method
