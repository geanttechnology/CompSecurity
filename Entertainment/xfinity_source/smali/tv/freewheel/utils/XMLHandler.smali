.class public Ltv/freewheel/utils/XMLHandler;
.super Ljava/lang/Object;
.source "XMLHandler.java"


# static fields
.field private static logger:Ltv/freewheel/utils/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-string v0, "XMLHandler"

    invoke-static {v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/utils/XMLHandler;->logger:Ltv/freewheel/utils/Logger;

    return-void
.end method

.method public static createXMLDocument(Ltv/freewheel/utils/XMLElement;)Ljava/lang/String;
    .locals 4
    .param p0, "root"    # Ltv/freewheel/utils/XMLElement;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 28
    sget-object v2, Ltv/freewheel/utils/XMLHandler;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "Create xml document"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    invoke-static {}, Landroid/util/Xml;->newSerializer()Lorg/xmlpull/v1/XmlSerializer;

    move-result-object v0

    .line 30
    .local v0, "serializer":Lorg/xmlpull/v1/XmlSerializer;
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 32
    .local v1, "writer":Ljava/io/StringWriter;
    invoke-interface {v0, v1}, Lorg/xmlpull/v1/XmlSerializer;->setOutput(Ljava/io/Writer;)V

    .line 33
    const-string v2, "UTF-8"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lorg/xmlpull/v1/XmlSerializer;->startDocument(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 34
    invoke-virtual {p0, v0}, Ltv/freewheel/utils/XMLElement;->toXML(Lorg/xmlpull/v1/XmlSerializer;)V

    .line 35
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlSerializer;->endDocument()V

    .line 37
    const/4 p0, 0x0

    .line 38
    invoke-virtual {v1}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;
    .locals 5
    .param p0, "node"    # Lorg/w3c/dom/Node;

    .prologue
    .line 79
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 80
    .local v2, "nList":Lorg/w3c/dom/NodeList;
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_0
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 81
    invoke-interface {v2, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "c":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 83
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 86
    .end local v0    # "c":Ljava/lang/String;
    :goto_1
    return-object v3

    .line 80
    .restart local v0    # "c":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 86
    .end local v0    # "c":Ljava/lang/String;
    :cond_1
    const-string v3, ""

    goto :goto_1
.end method

.method public static final getXMLElementFromString(Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/Element;
    .locals 11
    .param p0, "data"    # Ljava/lang/String;
    .param p1, "rootName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 42
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v6

    .line 43
    .local v6, "factory":Ljavax/xml/parsers/DocumentBuilderFactory;
    const/4 v1, 0x0

    .line 45
    .local v1, "builder":Ljavax/xml/parsers/DocumentBuilder;
    :try_start_0
    invoke-virtual {v6}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;
    :try_end_0
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 50
    const/4 v2, 0x0

    .line 52
    .local v2, "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    :try_start_1
    new-instance v2, Ljava/io/ByteArrayInputStream;

    .end local v2    # "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    const-string v8, "UTF-8"

    invoke-virtual {p0, v8}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_2

    .line 57
    .restart local v2    # "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    :goto_0
    const/4 v3, 0x0

    .line 58
    .local v3, "document":Lorg/w3c/dom/Document;
    const/4 v0, 0x0

    .line 60
    .local v0, "adResponseElement":Lorg/w3c/dom/Element;
    :try_start_2
    invoke-virtual {v1, v2}, Ljavax/xml/parsers/DocumentBuilder;->parse(Ljava/io/InputStream;)Lorg/w3c/dom/Document;

    move-result-object v3

    .line 61
    invoke-interface {v3, p1}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v7

    .line 62
    .local v7, "rootList":Lorg/w3c/dom/NodeList;
    invoke-interface {v7}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v8

    if-nez v8, :cond_1

    .line 63
    new-instance v8, Ljava/lang/Exception;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "no root node"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " found in document"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_2
    .catch Lorg/xml/sax/SAXException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 66
    .end local v0    # "adResponseElement":Lorg/w3c/dom/Element;
    .end local v7    # "rootList":Lorg/w3c/dom/NodeList;
    :catch_0
    move-exception v4

    .line 67
    .local v4, "e":Lorg/xml/sax/SAXException;
    :try_start_3
    new-instance v8, Ljava/lang/Exception;

    const-string v9, "parse xml failed"

    invoke-direct {v8, v9}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 71
    .end local v4    # "e":Lorg/xml/sax/SAXException;
    :catchall_0
    move-exception v8

    if-eqz v2, :cond_0

    .line 72
    invoke-virtual {v2}, Ljava/io/ByteArrayInputStream;->close()V

    :cond_0
    throw v8

    .line 46
    .end local v2    # "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    .end local v3    # "document":Lorg/w3c/dom/Document;
    :catch_1
    move-exception v4

    .line 47
    .local v4, "e":Ljavax/xml/parsers/ParserConfigurationException;
    new-instance v8, Ljava/lang/Exception;

    const-string v9, "new DocumentBuilder failed"

    invoke-direct {v8, v9}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v8

    .line 53
    .end local v4    # "e":Ljavax/xml/parsers/ParserConfigurationException;
    :catch_2
    move-exception v5

    .line 54
    .local v5, "e1":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .restart local v2    # "byteArrayInputStream":Ljava/io/ByteArrayInputStream;
    goto :goto_0

    .line 65
    .end local v5    # "e1":Ljava/io/UnsupportedEncodingException;
    .restart local v0    # "adResponseElement":Lorg/w3c/dom/Element;
    .restart local v3    # "document":Lorg/w3c/dom/Document;
    .restart local v7    # "rootList":Lorg/w3c/dom/NodeList;
    :cond_1
    const/4 v8, 0x0

    :try_start_4
    invoke-interface {v7, v8}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .end local v0    # "adResponseElement":Lorg/w3c/dom/Element;
    check-cast v0, Lorg/w3c/dom/Element;
    :try_end_4
    .catch Lorg/xml/sax/SAXException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 71
    .restart local v0    # "adResponseElement":Lorg/w3c/dom/Element;
    if-eqz v2, :cond_2

    .line 72
    invoke-virtual {v2}, Ljava/io/ByteArrayInputStream;->close()V

    .line 75
    :cond_2
    return-object v0

    .line 68
    .end local v0    # "adResponseElement":Lorg/w3c/dom/Element;
    .end local v7    # "rootList":Lorg/w3c/dom/NodeList;
    :catch_3
    move-exception v4

    .line 69
    .local v4, "e":Ljava/io/IOException;
    :try_start_5
    new-instance v8, Ljava/lang/Exception;

    const-string v9, "IO Error occurred"

    invoke-direct {v8, v9}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method
