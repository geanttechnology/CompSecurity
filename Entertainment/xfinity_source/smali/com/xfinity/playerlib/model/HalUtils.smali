.class public Lcom/xfinity/playerlib/model/HalUtils;
.super Ljava/lang/Object;
.source "HalUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static resolveOptionalLink(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)Ljava/lang/String;
    .locals 3
    .param p0, "propertyName"    # Ljava/lang/String;
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 17
    invoke-virtual {p1, p0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->getProperty(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataProperty;

    move-result-object v1

    .line 19
    .local v1, "urlProperty":Lcom/comcast/cim/microdata/model/MicrodataProperty;
    const/4 v0, 0x0

    .line 21
    .local v0, "url":Ljava/lang/String;
    invoke-interface {v1}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->isMissing()Z

    move-result v2

    if-nez v2, :cond_0

    .line 22
    invoke-static {v1}, Lcom/xfinity/playerlib/model/HalUtils;->resolveUrl(Lcom/comcast/cim/microdata/model/MicrodataProperty;)Ljava/lang/String;

    move-result-object v0

    .line 25
    :cond_0
    return-object v0
.end method

.method private static resolveUrl(Lcom/comcast/cim/microdata/model/MicrodataProperty;)Ljava/lang/String;
    .locals 8
    .param p0, "urlProperty"    # Lcom/comcast/cim/microdata/model/MicrodataProperty;

    .prologue
    const/4 v7, 0x0

    .line 29
    const/4 v4, 0x0

    .line 31
    .local v4, "url":Ljava/lang/String;
    invoke-interface {p0}, Lcom/comcast/cim/microdata/model/MicrodataProperty;->asLink()Lcom/comcast/cim/microdata/model/MicrodataLinkValue;

    move-result-object v2

    .line 32
    .local v2, "link":Lcom/comcast/cim/microdata/model/MicrodataLinkValue;
    invoke-interface {v2}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getHref()Ljava/lang/String;

    move-result-object v1

    .line 33
    .local v1, "href":Ljava/lang/String;
    const-string v5, "../"

    invoke-virtual {v1, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 35
    invoke-interface {v2}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getBaseUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2}, Lcom/comcast/cim/microdata/model/MicrodataLinkValue;->getBaseUrl()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {v5, v7, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "baseUrl":Ljava/lang/String;
    const-string v5, "/"

    invoke-virtual {v0, v5}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    invoke-virtual {v0, v7, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 38
    const/4 v5, 0x3

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    .line 39
    .local v3, "path":Ljava/lang/String;
    invoke-virtual {v0, v3}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 44
    .end local v0    # "baseUrl":Ljava/lang/String;
    .end local v3    # "path":Ljava/lang/String;
    :goto_0
    return-object v4

    .line 41
    :cond_0
    move-object v4, v1

    goto :goto_0
.end method
