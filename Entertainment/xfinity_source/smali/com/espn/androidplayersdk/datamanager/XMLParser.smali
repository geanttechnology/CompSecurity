.class Lcom/espn/androidplayersdk/datamanager/XMLParser;
.super Ljava/lang/Object;
.source "XMLParser.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/XMLParserInterface;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public errorHandler(I)V
    .locals 0
    .param p1, "errorCode"    # I

    .prologue
    .line 132
    return-void
.end method

.method public getDomElement(Ljava/lang/String;)Lorg/w3c/dom/Document;
    .locals 5
    .param p1, "xml"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/xml/parsers/ParserConfigurationException;,
            Lorg/xml/sax/SAXException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 95
    const/4 v2, 0x0

    .line 96
    .local v2, "doc":Lorg/w3c/dom/Document;
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v1

    .line 97
    .local v1, "dbf":Ljavax/xml/parsers/DocumentBuilderFactory;
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljavax/xml/parsers/DocumentBuilderFactory;->setCoalescing(Z)V

    .line 98
    invoke-virtual {v1}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v0

    .line 99
    .local v0, "db":Ljavax/xml/parsers/DocumentBuilder;
    new-instance v3, Lorg/xml/sax/InputSource;

    invoke-direct {v3}, Lorg/xml/sax/InputSource;-><init>()V

    .line 100
    .local v3, "is":Lorg/xml/sax/InputSource;
    new-instance v4, Ljava/io/StringReader;

    invoke-direct {v4, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lorg/xml/sax/InputSource;->setCharacterStream(Ljava/io/Reader;)V

    .line 101
    invoke-virtual {v0, v3}, Ljavax/xml/parsers/DocumentBuilder;->parse(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;

    move-result-object v2

    .line 103
    return-object v2
.end method

.method public final getElementsBoolValue(Lorg/w3c/dom/Node;)Z
    .locals 4
    .param p1, "elem"    # Lorg/w3c/dom/Node;

    .prologue
    const/4 v1, 0x1

    .line 81
    if-eqz p1, :cond_0

    .line 82
    invoke-interface {p1}, Lorg/w3c/dom/Node;->hasChildNodes()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 83
    invoke-interface {p1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v0

    .local v0, "child":Lorg/w3c/dom/Node;
    :goto_0
    if-nez v0, :cond_2

    .line 91
    .end local v0    # "child":Lorg/w3c/dom/Node;
    :cond_0
    const/4 v1, 0x0

    :cond_1
    return v1

    .line 84
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_2
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v2

    if-ne v2, v1, :cond_3

    .line 85
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "successStatus"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 83
    :cond_3
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNextSibling()Lorg/w3c/dom/Node;

    move-result-object v0

    goto :goto_0
.end method

.method public final getElementsStringValue(Lorg/w3c/dom/Node;)Ljava/lang/String;
    .locals 3
    .param p1, "elem"    # Lorg/w3c/dom/Node;

    .prologue
    .line 113
    if-eqz p1, :cond_0

    .line 114
    invoke-interface {p1}, Lorg/w3c/dom/Node;->hasChildNodes()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 115
    invoke-interface {p1}, Lorg/w3c/dom/Node;->getFirstChild()Lorg/w3c/dom/Node;

    move-result-object v0

    .local v0, "child":Lorg/w3c/dom/Node;
    :goto_0
    if-nez v0, :cond_1

    .line 126
    .end local v0    # "child":Lorg/w3c/dom/Node;
    :cond_0
    const-string v1, ""

    :goto_1
    return-object v1

    .line 116
    .restart local v0    # "child":Lorg/w3c/dom/Node;
    :cond_1
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_2

    .line 117
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 118
    :cond_2
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_3

    .line 120
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 115
    :cond_3
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNextSibling()Lorg/w3c/dom/Node;

    move-result-object v0

    goto :goto_0
.end method

.method public getValue(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "item"    # Lorg/w3c/dom/Element;
    .param p2, "str"    # Ljava/lang/String;

    .prologue
    .line 107
    invoke-interface {p1, p2}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 108
    .local v0, "n":Lorg/w3c/dom/NodeList;
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->getElementsStringValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public parse(Lorg/apache/http/HttpEntity;)V
    .locals 15
    .param p1, "httpEntity"    # Lorg/apache/http/HttpEntity;

    .prologue
    .line 35
    const-string v10, ""

    .line 36
    .local v10, "playBackURL":Ljava/lang/String;
    const/4 v3, 0x0

    .line 37
    .local v3, "blackOutStatus":Z
    const/4 v0, 0x0

    .line 38
    .local v0, "authStatus":Z
    const-string v7, ""

    .line 41
    .local v7, "errorMsg":Ljava/lang/String;
    :try_start_0
    invoke-static/range {p1 .. p1}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v12

    .line 42
    .local v12, "xml":Ljava/lang/String;
    invoke-virtual {p0, v12}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->getDomElement(Ljava/lang/String;)Lorg/w3c/dom/Document;

    move-result-object v4

    .line 43
    .local v4, "doc":Lorg/w3c/dom/Document;
    if-eqz v4, :cond_0

    .line 45
    const-string v13, "user-verified-media-item"

    invoke-interface {v4, v13}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v9

    .line 46
    .local v9, "nl":Lorg/w3c/dom/NodeList;
    const/4 v13, 0x0

    invoke-interface {v9, v13}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v5

    check-cast v5, Lorg/w3c/dom/Element;

    .line 48
    .local v5, "e":Lorg/w3c/dom/Element;
    const-string v13, "url"

    invoke-interface {v5, v13}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v13

    const/4 v14, 0x0

    invoke-interface {v13, v14}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v11

    .line 49
    .local v11, "urlNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v11}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->getElementsStringValue(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v10

    .line 51
    const-string v13, "blackout-status"

    invoke-interface {v5, v13}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v13

    const/4 v14, 0x0

    invoke-interface {v13, v14}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 52
    .local v2, "blackOutNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v2}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->getElementsBoolValue(Lorg/w3c/dom/Node;)Z

    move-result v3

    .line 54
    const-string v13, "auth-status"

    invoke-interface {v5, v13}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v13

    const/4 v14, 0x0

    invoke-interface {v13, v14}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 55
    .local v1, "authtNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->getElementsBoolValue(Lorg/w3c/dom/Node;)Z

    move-result v0

    .line 57
    if-nez v0, :cond_0

    .line 58
    const-string v13, "errorMessage"

    invoke-interface {v5, v13}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v13

    const/4 v14, 0x0

    invoke-interface {v13, v14}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v8

    .line 59
    .local v8, "errorNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v8}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->getElementsStringValue(Lorg/w3c/dom/Node;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/xml/sax/SAXException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v7

    .line 77
    .end local v1    # "authtNode":Lorg/w3c/dom/Node;
    .end local v2    # "blackOutNode":Lorg/w3c/dom/Node;
    .end local v4    # "doc":Lorg/w3c/dom/Document;
    .end local v5    # "e":Lorg/w3c/dom/Element;
    .end local v8    # "errorNode":Lorg/w3c/dom/Node;
    .end local v9    # "nl":Lorg/w3c/dom/NodeList;
    .end local v11    # "urlNode":Lorg/w3c/dom/Node;
    .end local v12    # "xml":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 64
    :catch_0
    move-exception v5

    .line 65
    .local v5, "e":Ljava/io/IOException;
    const-string v13, "XMLParser.Parse(); Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 66
    const/4 v13, 0x5

    invoke-virtual {p0, v13}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->errorHandler(I)V

    goto :goto_0

    .line 67
    .end local v5    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v6

    .line 68
    .local v6, "e1":Ljavax/xml/parsers/ParserConfigurationException;
    const-string v13, "XMLParser.Parse(); Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 69
    const/4 v13, 0x5

    invoke-virtual {p0, v13}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->errorHandler(I)V

    goto :goto_0

    .line 70
    .end local v6    # "e1":Ljavax/xml/parsers/ParserConfigurationException;
    :catch_2
    move-exception v6

    .line 71
    .local v6, "e1":Lorg/xml/sax/SAXException;
    const-string v13, "XMLParser.Parse(); Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 72
    const/4 v13, 0x5

    invoke-virtual {p0, v13}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->errorHandler(I)V

    goto :goto_0

    .line 73
    .end local v6    # "e1":Lorg/xml/sax/SAXException;
    :catch_3
    move-exception v6

    .line 74
    .local v6, "e1":Ljava/lang/Exception;
    const-string v13, "XMLParser.Parse(); Error: "

    const/4 v14, 0x5

    invoke-static {v13, v14, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 75
    const/4 v13, 0x5

    invoke-virtual {p0, v13}, Lcom/espn/androidplayersdk/datamanager/XMLParser;->errorHandler(I)V

    goto :goto_0
.end method
