.class public Lcom/comcast/cim/cmasl/hal/task/HypermediaService;
.super Ljava/lang/Object;
.source "HypermediaService.java"


# instance fields
.field services:Lcom/comcast/cim/microdata/model/MicrodataItem;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V
    .locals 0
    .param p1, "services"    # Lcom/comcast/cim/microdata/model/MicrodataItem;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaService;->services:Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 15
    return-void
.end method


# virtual methods
.method protected fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;
    .locals 2
    .param p1, "service"    # Ljava/lang/String;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaService;->services:Lcom/comcast/cim/microdata/model/MicrodataItem;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Lcom/comcast/cim/microdata/model/MicrodataItem;->get(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->resolve()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method protected fetchServiceUriPath(Ljava/lang/String;Ljava/util/Map;)Ljava/net/URI;
    .locals 2
    .param p1, "service"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/net/URI;"
        }
    .end annotation

    .prologue
    .line 22
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaService;->services:Lcom/comcast/cim/microdata/model/MicrodataItem;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Lcom/comcast/cim/microdata/model/MicrodataItem;->get(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v0

    invoke-interface {v0, p2}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->resolve(Ljava/util/Map;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method protected fetchServiceUriTemplate(Ljava/lang/String;)Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;
    .locals 2
    .param p1, "service"    # Ljava/lang/String;

    .prologue
    .line 26
    new-instance v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaService;->services:Lcom/comcast/cim/microdata/model/MicrodataItem;

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;-><init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V

    .line 27
    .local v0, "resolver":Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchLinkAsUriTemplate(Ljava/lang/String;)Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    move-result-object v1

    return-object v1
.end method
