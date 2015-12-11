.class public Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;
.super Ljava/lang/Object;
.source "MicrodataUriTemplate.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$1;,
        Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;
    }
.end annotation


# instance fields
.field private final baseUrl:Ljava/lang/String;

.field private final href:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataLinkValue;)V
    .locals 1
    .param p1, "linkValue"    # Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    .line 18
    invoke-interface {p1}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    .line 19
    return-void
.end method


# virtual methods
.method public createResolver()Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;
    .locals 4

    .prologue
    .line 27
    new-instance v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$Resolver;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate$1;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 68
    if-ne p0, p1, :cond_1

    .line 82
    :cond_0
    :goto_0
    return v1

    .line 71
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 72
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 74
    check-cast v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;

    .line 75
    .local v0, "that":Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 76
    goto :goto_0

    .line 75
    :cond_5
    iget-object v3, v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    if-nez v3, :cond_4

    .line 79
    :cond_6
    iget-object v3, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 80
    goto :goto_0

    .line 79
    :cond_7
    iget-object v3, v0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getBaseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getHref()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 87
    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->baseUrl:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 88
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/model/MicrodataUriTemplate;->href:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 89
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 87
    goto :goto_0
.end method
