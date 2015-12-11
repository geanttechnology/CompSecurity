.class public Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "HalResponseHandler.java"


# instance fields
.field private baseUrl:Ljava/lang/String;

.field private hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

.field private microdataResource:Lcom/comcast/cim/microdata/model/MicrodataItem;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;)V
    .locals 1
    .param p1, "hypermediaClient"    # Lcom/comcast/cim/microdata/client/HypermediaClient;
    .param p2, "baseUrl"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

    .line 20
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->baseUrl:Ljava/lang/String;

    .line 21
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 22
    return-void
.end method


# virtual methods
.method public getMicrodataResource()Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->microdataResource:Lcom/comcast/cim/microdata/model/MicrodataItem;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 4
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 27
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->hypermediaClient:Lcom/comcast/cim/microdata/client/HypermediaClient;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->baseUrl:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-interface {v1, v2, p1, v3}, Lcom/comcast/cim/microdata/client/HypermediaClient;->parseResource(Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/cmasl/hal/http/HalResponseHandler;->microdataResource:Lcom/comcast/cim/microdata/model/MicrodataItem;
    :try_end_0
    .catch Lcom/comcast/cim/microdata/exception/MicrodataConversionException; {:try_start_0 .. :try_end_0} :catch_0

    .line 31
    return-void

    .line 28
    :catch_0
    move-exception v0

    .line 29
    .local v0, "e":Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
    new-instance v1, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
