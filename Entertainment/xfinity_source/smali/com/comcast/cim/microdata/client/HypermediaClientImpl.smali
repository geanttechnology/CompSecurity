.class public Lcom/comcast/cim/microdata/client/HypermediaClientImpl;
.super Ljava/lang/Object;
.source "HypermediaClientImpl.java"

# interfaces
.implements Lcom/comcast/cim/microdata/client/HypermediaClient;


# instance fields
.field private automaticNetworkLoadingEnabled:Z

.field private defaultAcceptContentType:Ljava/lang/String;

.field private httpRequester:Lcom/comcast/cim/microdata/http/HttpRequester;

.field private objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->automaticNetworkLoadingEnabled:Z

    .line 45
    const-string v0, "application/hal+json"

    iput-object v0, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->defaultAcceptContentType:Ljava/lang/String;

    .line 48
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 49
    return-void
.end method

.method private buildDeserializer(Ljava/lang/String;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;)Lcom/comcast/cim/microdata/deserialization/MicrodataDeserializer;
    .locals 2
    .param p1, "contentType"    # Ljava/lang/String;
    .param p2, "modelFactory"    # Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    .prologue
    .line 148
    new-instance v0, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;

    iget-object v1, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0, v1, p2}, Lcom/comcast/cim/microdata/deserialization/HalToMicrodataConverter;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;)V

    return-object v0
.end method

.method private buildModelFactory(Ljava/lang/String;)Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
    .locals 1
    .param p1, "baseUrl"    # Ljava/lang/String;

    .prologue
    .line 142
    new-instance v0, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/microdata/deserialization/ResourceMicrodataModelFactory;-><init>(Lcom/comcast/cim/microdata/client/HypermediaClient;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getDefaultAcceptContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->defaultAcceptContentType:Ljava/lang/String;

    return-object v0
.end method

.method public getHttpRequester()Lcom/comcast/cim/microdata/http/HttpRequester;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->httpRequester:Lcom/comcast/cim/microdata/http/HttpRequester;

    return-object v0
.end method

.method public isAutomaticNetworkLoadingEnabled()Z
    .locals 1

    .prologue
    .line 153
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->automaticNetworkLoadingEnabled:Z

    return v0
.end method

.method public parseResource(Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 3
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "content"    # Ljava/io/InputStream;
    .param p3, "contentType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/microdata/exception/MicrodataConversionException;
        }
    .end annotation

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->buildModelFactory(Ljava/lang/String;)Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;

    move-result-object v1

    .line 121
    .local v1, "modelFactory":Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;
    invoke-direct {p0, p3, v1}, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->buildDeserializer(Ljava/lang/String;Lcom/comcast/cim/microdata/deserialization/MicrodataModelFactory;)Lcom/comcast/cim/microdata/deserialization/MicrodataDeserializer;

    move-result-object v0

    .line 122
    .local v0, "deserializer":Lcom/comcast/cim/microdata/deserialization/MicrodataDeserializer;
    invoke-interface {v0, p2}, Lcom/comcast/cim/microdata/deserialization/MicrodataDeserializer;->convert(Ljava/io/InputStream;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v2

    return-object v2
.end method

.method public setAutomaticNetworkLoadingEnabled(Z)V
    .locals 0
    .param p1, "automaticNetworkLoadingEnabled"    # Z

    .prologue
    .line 157
    iput-boolean p1, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->automaticNetworkLoadingEnabled:Z

    .line 158
    return-void
.end method

.method public setDefaultAcceptContentType(Ljava/lang/String;)V
    .locals 0
    .param p1, "defaultAcceptContentType"    # Ljava/lang/String;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->defaultAcceptContentType:Ljava/lang/String;

    .line 174
    return-void
.end method

.method public setHttpRequester(Lcom/comcast/cim/microdata/http/HttpRequester;)V
    .locals 0
    .param p1, "httpRequester"    # Lcom/comcast/cim/microdata/http/HttpRequester;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/comcast/cim/microdata/client/HypermediaClientImpl;->httpRequester:Lcom/comcast/cim/microdata/http/HttpRequester;

    .line 166
    return-void
.end method
