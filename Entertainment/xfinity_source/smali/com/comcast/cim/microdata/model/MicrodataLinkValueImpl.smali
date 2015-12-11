.class public Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;
.super Ljava/lang/Object;
.source "MicrodataLinkValueImpl.java"

# interfaces
.implements Lcom/comcast/cim/microdata/model/MicrodataLinkValue;


# instance fields
.field private contentType:Ljava/lang/String;

.field private context:Lcom/comcast/cim/microdata/model/MicrodataContext;

.field private href:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private templated:Z

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 0
    .param p1, "href"    # Ljava/lang/String;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "templated"    # Z
    .param p5, "contentType"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->href:Ljava/lang/String;

    .line 25
    iput-object p2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->name:Ljava/lang/String;

    .line 26
    iput-object p3, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->title:Ljava/lang/String;

    .line 27
    iput-boolean p4, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->templated:Z

    .line 28
    iput-object p5, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->contentType:Ljava/lang/String;

    .line 29
    return-void
.end method


# virtual methods
.method public getBaseUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 115
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    .line 116
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Attempted to get BaseUrl with no root context/baseUrl"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 118
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v0}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->contentType:Ljava/lang/String;

    return-object v0
.end method

.method public getHref()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->href:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isTemplated()Z
    .locals 1

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->templated:Z

    return v0
.end method

.method public resolve()Ljava/net/URI;
    .locals 3

    .prologue
    .line 79
    iget-object v1, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v1}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    .line 80
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Attempted to resolve link with no root context/baseUrl"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 83
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v1}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    .line 84
    .local v0, "base":Ljava/net/URI;
    iget-object v1, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->href:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/net/URI;->resolve(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v1

    return-object v1
.end method

.method public resolve(Ljava/util/Map;)Ljava/net/URI;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/net/URI;"
        }
    .end annotation

    .prologue
    .line 89
    .local p1, "templateParameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v2}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getBaseUrl()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    .line 90
    :cond_0
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Attempted to resolve link with no root context/baseUrl"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 93
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    invoke-virtual {v2}, Lcom/comcast/cim/microdata/model/MicrodataContext;->getBaseUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    .line 94
    .local v0, "base":Ljava/net/URI;
    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->href:Ljava/lang/String;

    invoke-static {v2}, Lcom/damnhandy/uri/template/UriTemplate;->fromTemplate(Ljava/lang/String;)Lcom/damnhandy/uri/template/UriTemplate;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/damnhandy/uri/template/UriTemplate;->expand(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v1

    .line 95
    .local v1, "expandedHref":Ljava/lang/String;
    invoke-virtual {v0, v1}, Ljava/net/URI;->resolve(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v2

    return-object v2
.end method

.method public setContext(Lcom/comcast/cim/microdata/model/MicrodataContext;)V
    .locals 0
    .param p1, "context"    # Lcom/comcast/cim/microdata/model/MicrodataContext;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->context:Lcom/comcast/cim/microdata/model/MicrodataContext;

    .line 111
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 101
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 102
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "name"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 103
    const-string v1, "title"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->title:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 104
    const-string v1, "href"

    iget-object v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->href:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 105
    const-string v1, "templated"

    iget-boolean v2, p0, Lcom/comcast/cim/microdata/model/MicrodataLinkValueImpl;->templated:Z

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Z)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 106
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
