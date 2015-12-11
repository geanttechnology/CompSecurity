.class public Lcom/xfinity/playerlib/model/TveHypermediaService;
.super Lcom/comcast/cim/cmasl/hal/task/HypermediaService;
.source "TveHypermediaService.java"


# instance fields
.field private streamMetadataTemplate:Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V
    .locals 0
    .param p1, "services"    # Lcom/comcast/cim/microdata/model/MicrodataItem;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/hal/task/HypermediaService;-><init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V

    .line 20
    return-void
.end method


# virtual methods
.method public getListingsUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 31
    const-string v0, "listings"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/TveHypermediaService;->fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public getPromotedContentUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 27
    const-string v0, "promoted/livetv"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/TveHypermediaService;->fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public getStreamMetadataUri(Ljava/lang/String;)Ljava/net/URI;
    .locals 2
    .param p1, "streamName"    # Ljava/lang/String;

    .prologue
    .line 35
    iget-object v1, p0, Lcom/xfinity/playerlib/model/TveHypermediaService;->streamMetadataTemplate:Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    if-nez v1, :cond_0

    .line 36
    const-string v1, "stream_metadata"

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/model/TveHypermediaService;->fetchServiceUriTemplate(Ljava/lang/String;)Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/model/TveHypermediaService;->streamMetadataTemplate:Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    .line 40
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/TveHypermediaService;->streamMetadataTemplate:Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->createResolver()Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;

    move-result-object v0

    .line 41
    .local v0, "streamMetadataTemplateResolver":Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;
    const-string v1, "cmsId"

    invoke-virtual {v0, v1, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;

    .line 42
    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->resolve()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v1

    return-object v1
.end method

.method public getStremsUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 23
    const-string v0, "streams2"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/TveHypermediaService;->fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method
