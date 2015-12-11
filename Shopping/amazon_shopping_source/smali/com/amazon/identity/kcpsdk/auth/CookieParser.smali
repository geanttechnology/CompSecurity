.class public Lcom/amazon/identity/kcpsdk/auth/CookieParser;
.super Ljava/lang/Object;
.source "CookieParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method


# virtual methods
.method public parseStandardKindleCookieResponse(Lorg/w3c/dom/Element;)Ljava/util/List;
    .locals 12
    .param p1, "cookiesNode"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/w3c/dom/Element;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/auth/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 22
    .local v4, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/kcpsdk/auth/Cookie;>;"
    if-nez p1, :cond_1

    .line 52
    :cond_0
    return-object v4

    .line 27
    :cond_1
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 29
    .local v0, "children":Lorg/w3c/dom/NodeList;
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v10

    if-ge v5, v10, :cond_0

    .line 31
    invoke-interface {v0, v5}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 32
    .local v3, "cookieNode":Lorg/w3c/dom/Node;
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_2

    move-object v2, v3

    .line 34
    check-cast v2, Lorg/w3c/dom/Element;

    .line 39
    .local v2, "cookieEle":Lorg/w3c/dom/Element;
    const-string/jumbo v10, "url"

    invoke-static {v2, v10}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v6

    .line 40
    .local v6, "urlNode":Lorg/w3c/dom/Element;
    const-string/jumbo v10, "value"

    invoke-static {v2, v10}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v8

    .line 42
    .local v8, "valueNode":Lorg/w3c/dom/Element;
    invoke-static {v6}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v7

    .line 43
    .local v7, "urlString":Ljava/lang/String;
    invoke-static {v8}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v9

    .line 45
    .local v9, "valueString":Ljava/lang/String;
    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/Cookie;

    invoke-direct {v1}, Lcom/amazon/identity/kcpsdk/auth/Cookie;-><init>()V

    .line 46
    .local v1, "cookie":Lcom/amazon/identity/kcpsdk/auth/Cookie;
    invoke-virtual {v1, v7}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->setUrl(Ljava/lang/String;)Z

    .line 47
    invoke-virtual {v1, v9}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->setValue(Ljava/lang/String;)Z

    .line 49
    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 29
    .end local v1    # "cookie":Lcom/amazon/identity/kcpsdk/auth/Cookie;
    .end local v2    # "cookieEle":Lorg/w3c/dom/Element;
    .end local v6    # "urlNode":Lorg/w3c/dom/Element;
    .end local v7    # "urlString":Ljava/lang/String;
    .end local v8    # "valueNode":Lorg/w3c/dom/Element;
    .end local v9    # "valueString":Ljava/lang/String;
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method
