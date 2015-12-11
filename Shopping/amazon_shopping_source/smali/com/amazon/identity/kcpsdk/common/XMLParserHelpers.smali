.class public final Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;
.super Ljava/lang/Object;
.source "XMLParserHelpers.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method

.method public static getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;
    .locals 3
    .param p0, "ele"    # Lorg/w3c/dom/Element;
    .param p1, "tagName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 20
    if-nez p0, :cond_1

    .line 32
    :cond_0
    :goto_0
    return-object v1

    .line 25
    :cond_1
    invoke-interface {p0, p1}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 27
    .local v0, "errorNodes":Lorg/w3c/dom/NodeList;
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v2

    if-eqz v2, :cond_0

    .line 32
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    check-cast v1, Lorg/w3c/dom/Element;

    goto :goto_0
.end method

.method public static getFirstTextElementValue(Lorg/w3c/dom/Element;)Ljava/lang/String;
    .locals 6
    .param p0, "ele"    # Lorg/w3c/dom/Element;

    .prologue
    const/4 v3, 0x0

    .line 92
    if-nez p0, :cond_1

    .line 110
    :cond_0
    :goto_0
    return-object v3

    .line 97
    :cond_1
    invoke-interface {p0}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 98
    .local v2, "nodes":Lorg/w3c/dom/NodeList;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v0, v4, :cond_0

    .line 100
    invoke-interface {v2, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 101
    .local v1, "node":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_2

    .line 103
    check-cast v1, Lorg/w3c/dom/Text;

    .line 107
    .end local v1    # "node":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Text;->getNodeValue()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 98
    .restart local v1    # "node":Lorg/w3c/dom/Node;
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public static getMapOfChildElements(Lorg/w3c/dom/Element;)Ljava/util/Map;
    .locals 7
    .param p0, "ele"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/w3c/dom/Element;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 37
    if-nez p0, :cond_1

    move-object v2, v4

    .line 58
    :cond_0
    :goto_0
    return-object v2

    .line 41
    :cond_1
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 43
    .local v2, "elementMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p0}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 44
    .local v1, "childNodesList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_3

    .line 46
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 48
    check-cast v0, Lorg/w3c/dom/Element;

    .line 49
    .local v0, "childEle":Lorg/w3c/dom/Element;
    if-eqz v0, :cond_2

    .line 51
    invoke-interface {v0}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 54
    .end local v0    # "childEle":Lorg/w3c/dom/Element;
    :cond_3
    invoke-interface {v2}, Ljava/util/Map;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_0

    move-object v2, v4

    .line 56
    goto :goto_0
.end method

.method public static getNextChildElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;
    .locals 7
    .param p0, "ele"    # Lorg/w3c/dom/Element;
    .param p1, "tagName"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 66
    if-nez p0, :cond_1

    move-object v2, v4

    .line 87
    :cond_0
    :goto_0
    return-object v2

    .line 71
    :cond_1
    invoke-interface {p0}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 72
    .local v1, "childNodesList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_3

    .line 74
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 75
    .local v0, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_2

    move-object v2, v0

    .line 77
    check-cast v2, Lorg/w3c/dom/Element;

    .line 81
    .local v2, "elem":Lorg/w3c/dom/Element;
    invoke-interface {v2}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 72
    .end local v2    # "elem":Lorg/w3c/dom/Element;
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .end local v0    # "childNode":Lorg/w3c/dom/Node;
    :cond_3
    move-object v2, v4

    .line 87
    goto :goto_0
.end method

.method public static getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;
    .locals 1
    .param p0, "ele"    # Lorg/w3c/dom/Element;

    .prologue
    .line 120
    if-nez p0, :cond_0

    .line 122
    const/4 v0, 0x0

    .line 125
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p0}, Lorg/w3c/dom/Element;->getTextContent()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static hasElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    .locals 1
    .param p0, "ele"    # Lorg/w3c/dom/Element;
    .param p1, "tagName"    # Ljava/lang/String;

    .prologue
    .line 115
    if-eqz p0, :cond_0

    invoke-interface {p0, p1}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v0

    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
