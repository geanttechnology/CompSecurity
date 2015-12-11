.class public Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;
.super Ljava/lang/Object;
.source "MicrodataUriTemplate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Resolver"
.end annotation


# instance fields
.field private final baseUrl:Ljava/lang/String;

.field private final href:Ljava/lang/String;

.field private valueMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "href"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->valueMap:Ljava/util/Map;

    .line 44
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->baseUrl:Ljava/lang/String;

    .line 45
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->href:Ljava/lang/String;

    .line 46
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$1;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public resolve()Ljava/lang/String;
    .locals 4

    .prologue
    .line 54
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->baseUrl:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 55
    const/4 v2, 0x0

    .line 62
    :goto_0
    return-object v2

    .line 57
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->href:Ljava/lang/String;

    if-nez v2, :cond_1

    .line 58
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->baseUrl:Ljava/lang/String;

    goto :goto_0

    .line 60
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->baseUrl:Ljava/lang/String;

    invoke-static {v2}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    .line 61
    .local v0, "base":Ljava/net/URI;
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->href:Ljava/lang/String;

    invoke-static {v2}, Lcom/damnhandy/uri/template/UriTemplate;->fromTemplate(Ljava/lang/String;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->valueMap:Ljava/util/Map;

    invoke-virtual {v2, v3}, Lcom/damnhandy/uri/template/UriTemplate;->expand(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    .line 62
    .local v1, "expandedHref":Ljava/lang/String;
    invoke-virtual {v0, v1}, Ljava/net/URI;->resolve(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public set(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;->valueMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    return-object p0
.end method
