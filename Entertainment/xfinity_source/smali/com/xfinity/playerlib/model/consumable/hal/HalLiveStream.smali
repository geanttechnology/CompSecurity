.class public Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
.super Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;
.source "HalLiveStream.java"


# instance fields
.field private isAdultContent:Z

.field private networkLogoUrl:Ljava/lang/String;

.field private providerCodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private scm:Ljava/lang/String;

.field private streamId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;-><init>()V

    return-void
.end method

.method public static getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;
    .locals 4
    .param p0, "template"    # Ljava/lang/String;
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 37
    :try_start_0
    invoke-static {p0}, Lcom/damnhandy/uri/template/UriTemplate;->fromTemplate(Ljava/lang/String;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v1

    const-string v2, "width"

    .line 38
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/damnhandy/uri/template/UriTemplate;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v1

    const-string v2, "height"

    .line 39
    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/damnhandy/uri/template/UriTemplate;->set(Ljava/lang/String;Ljava/lang/Object;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v1

    .line 40
    invoke-virtual {v1}, Lcom/damnhandy/uri/template/UriTemplate;->expand()Ljava/lang/String;
    :try_end_0
    .catch Lcom/damnhandy/uri/template/impl/ExpressionParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    .line 42
    .end local p0    # "template":Ljava/lang/String;
    :goto_0
    return-object p0

    .line 41
    .restart local p0    # "template":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 42
    .local v0, "e":Lcom/damnhandy/uri/template/impl/ExpressionParseException;
    goto :goto_0
.end method

.method private getScheme()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    .line 64
    .local v0, "uri":Ljava/net/URI;
    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public getNetworkLogoUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->networkLogoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getProviderCodes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->providerCodes:Ljava/util/List;

    return-object v0
.end method

.method public getSchemeSpecificPart()Ljava/lang/String;
    .locals 2

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    .line 69
    .local v0, "uri":Ljava/net/URI;
    invoke-virtual {v0}, Ljava/net/URI;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getScm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->scm:Ljava/lang/String;

    return-object v0
.end method

.method public getStreamId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->streamId:Ljava/lang/String;

    return-object v0
.end method

.method public isAdultContent()Z
    .locals 1

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isAdultContent:Z

    return v0
.end method

.method public isDisney()Z
    .locals 2

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getScheme()Ljava/lang/String;

    move-result-object v0

    const-string v1, "disney"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public isEspn()Z
    .locals 2

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getScheme()Ljava/lang/String;

    move-result-object v0

    const-string v1, "espn"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 1
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 23
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 25
    const-string v0, "networkLogo"

    invoke-static {v0, p1}, Lcom/xfinity/playerlib/model/HalUtils;->resolveOptionalLink(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->networkLogoUrl:Ljava/lang/String;

    .line 26
    const-string v0, "scm"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->scm:Ljava/lang/String;

    .line 27
    const-string v0, "providerCodes"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->providerCodes:Ljava/util/List;

    .line 28
    const-string v0, "id"

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->streamId:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setArtworkLink(Ljava/lang/String;)V
    .locals 0
    .param p1, "artworkLink"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->artworkLink:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setStreamId(Ljava/lang/String;)V
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->streamId:Ljava/lang/String;

    .line 56
    return-void
.end method
