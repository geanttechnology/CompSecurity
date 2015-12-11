.class public Lcom/amazon/identity/kcpsdk/common/XMLElement;
.super Lcom/amazon/identity/kcpsdk/common/XMLEntity;
.source "XMLElement.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final XML_DOCUMENT_FACTORY:Ljavax/xml/parsers/DocumentBuilderFactory;


# instance fields
.field private mEntityChildren:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/common/XMLEntity;",
            ">;"
        }
    .end annotation
.end field

.field private final mInnerText:Ljava/lang/String;

.field private final mName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->TAG:Ljava/lang/String;

    .line 30
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->XML_DOCUMENT_FACTORY:Ljavax/xml/parsers/DocumentBuilderFactory;

    return-void
.end method

.method public varargs constructor <init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "innerText"    # Ljava/lang/String;
    .param p3, "attributes"    # [Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    .prologue
    .line 39
    check-cast p3, [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    .end local p3    # "attributes":[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    .line 40
    return-void
.end method

.method private varargs constructor <init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "innerText"    # Ljava/lang/String;
    .param p3, "children"    # [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/amazon/identity/kcpsdk/common/XMLEntity;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mName:Ljava/lang/String;

    .line 50
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mInnerText:Ljava/lang/String;

    .line 51
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mEntityChildren:Ljava/util/List;

    .line 52
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mEntityChildren:Ljava/util/List;

    invoke-static {p3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 53
    return-void
.end method

.method public varargs constructor <init>(Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "children"    # [Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    .prologue
    .line 44
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLEntity;)V

    .line 45
    return-void
.end method

.method public static convertElementToString(Lorg/w3c/dom/Node;)Ljava/lang/String;
    .locals 8
    .param p0, "xmlElement"    # Lorg/w3c/dom/Node;

    .prologue
    .line 96
    invoke-static {}, Ljavax/xml/transform/TransformerFactory;->newInstance()Ljavax/xml/transform/TransformerFactory;

    move-result-object v2

    .line 97
    .local v2, "tf":Ljavax/xml/transform/TransformerFactory;
    const/4 v1, 0x0

    .line 100
    .local v1, "output":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v2}, Ljavax/xml/transform/TransformerFactory;->newTransformer()Ljavax/xml/transform/Transformer;

    move-result-object v3

    .line 101
    .local v3, "transformer":Ljavax/xml/transform/Transformer;
    const-string/jumbo v6, "omit-xml-declaration"

    instance-of v5, p0, Lorg/w3c/dom/Document;

    if-eqz v5, :cond_0

    const-string/jumbo v5, "no"

    :goto_0
    invoke-virtual {v3, v6, v5}, Ljavax/xml/transform/Transformer;->setOutputProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    new-instance v4, Ljava/io/StringWriter;

    invoke-direct {v4}, Ljava/io/StringWriter;-><init>()V

    .line 104
    .local v4, "writer":Ljava/io/StringWriter;
    new-instance v5, Ljavax/xml/transform/dom/DOMSource;

    invoke-direct {v5, p0}, Ljavax/xml/transform/dom/DOMSource;-><init>(Lorg/w3c/dom/Node;)V

    new-instance v6, Ljavax/xml/transform/stream/StreamResult;

    invoke-direct {v6, v4}, Ljavax/xml/transform/stream/StreamResult;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v3, v5, v6}, Ljavax/xml/transform/Transformer;->transform(Ljavax/xml/transform/Source;Ljavax/xml/transform/Result;)V

    .line 105
    invoke-virtual {v4}, Ljava/io/StringWriter;->getBuffer()Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    .line 117
    .end local v3    # "transformer":Ljavax/xml/transform/Transformer;
    .end local v4    # "writer":Ljava/io/StringWriter;
    :goto_1
    return-object v1

    .line 101
    .restart local v3    # "transformer":Ljavax/xml/transform/Transformer;
    :cond_0
    const-string/jumbo v5, "yes"
    :try_end_0
    .catch Ljavax/xml/transform/TransformerConfigurationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/xml/transform/TransformerException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 107
    .end local v3    # "transformer":Ljavax/xml/transform/Transformer;
    :catch_0
    move-exception v0

    .line 109
    .local v0, "e":Ljavax/xml/transform/TransformerConfigurationException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/common/XMLElement;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "convertDocumentToString: Unable to convert XML Document to text since the transformer could not be constructed. Error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljavax/xml/transform/TransformerConfigurationException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 112
    .end local v0    # "e":Ljavax/xml/transform/TransformerConfigurationException;
    :catch_1
    move-exception v0

    .line 114
    .local v0, "e":Ljavax/xml/transform/TransformerException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/common/XMLElement;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "convertDocumentToString: Unable to convert XML Document to text. Error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljavax/xml/transform/TransformerException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private createElement(Lorg/w3c/dom/Document;)Lorg/w3c/dom/Element;
    .locals 3
    .param p1, "xmlDoc"    # Lorg/w3c/dom/Document;

    .prologue
    .line 130
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mName:Ljava/lang/String;

    invoke-interface {p1, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    .line 132
    .local v1, "newElement":Lorg/w3c/dom/Element;
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mInnerText:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 134
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mInnerText:Ljava/lang/String;

    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->setTextContent(Ljava/lang/String;)V

    .line 137
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mEntityChildren:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    .line 139
    invoke-virtual {v2, v1}, Lcom/amazon/identity/kcpsdk/common/XMLEntity;->toXML(Lorg/w3c/dom/Element;)V

    goto :goto_0

    .line 142
    :cond_1
    return-object v1
.end method


# virtual methods
.method public addAttribute(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 68
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    invoke-direct {v0, p1, p2}, Lcom/amazon/identity/kcpsdk/common/XMLAttribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    .line 69
    return-object p0
.end method

.method public addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z
    .locals 1
    .param p1, "child"    # Lcom/amazon/identity/kcpsdk/common/XMLEntity;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/XMLElement;->mEntityChildren:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public addNewChildElement(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/common/XMLElement;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "innerText"    # Ljava/lang/String;

    .prologue
    .line 62
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLElement;

    const/4 v1, 0x0

    new-array v1, v1, [Lcom/amazon/identity/kcpsdk/common/XMLAttribute;

    invoke-direct {v0, p1, p2, v1}, Lcom/amazon/identity/kcpsdk/common/XMLElement;-><init>(Ljava/lang/String;Ljava/lang/String;[Lcom/amazon/identity/kcpsdk/common/XMLAttribute;)V

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->addNewChild(Lcom/amazon/identity/kcpsdk/common/XMLEntity;)Z

    .line 63
    return-object p0
.end method

.method public convertToString()Ljava/lang/String;
    .locals 8

    .prologue
    .line 74
    const/4 v2, 0x0

    .line 77
    .local v2, "output":Ljava/lang/String;
    :try_start_0
    sget-object v5, Lcom/amazon/identity/kcpsdk/common/XMLElement;->XML_DOCUMENT_FACTORY:Ljavax/xml/parsers/DocumentBuilderFactory;

    invoke-virtual {v5}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v5

    .line 78
    const/4 v0, 0x0

    .local v0, "db":Ljavax/xml/parsers/DocumentBuilder;
    invoke-virtual {v5}, Ljavax/xml/parsers/DocumentBuilder;->newDocument()Lorg/w3c/dom/Document;

    move-result-object v4

    .line 80
    .local v4, "xmlDoc":Lorg/w3c/dom/Document;
    invoke-direct {p0, v4}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->createElement(Lorg/w3c/dom/Document;)Lorg/w3c/dom/Element;

    move-result-object v3

    .line 81
    .local v3, "rootNode":Lorg/w3c/dom/Element;
    invoke-interface {v4, v3}, Lorg/w3c/dom/Document;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 83
    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->convertElementToString(Lorg/w3c/dom/Node;)Ljava/lang/String;
    :try_end_0
    .catch Ljavax/xml/parsers/ParserConfigurationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 91
    .end local v0    # "db":Ljavax/xml/parsers/DocumentBuilder;
    .end local v3    # "rootNode":Lorg/w3c/dom/Element;
    .end local v4    # "xmlDoc":Lorg/w3c/dom/Document;
    :goto_0
    return-object v2

    .line 85
    :catch_0
    move-exception v1

    .line 87
    .local v1, "e":Ljavax/xml/parsers/ParserConfigurationException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/common/XMLElement;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "convertToString: Unable to construct an XML Document since the document factory could not be constructed. Error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljavax/xml/parsers/ParserConfigurationException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method toXML(Lorg/w3c/dom/Element;)V
    .locals 2
    .param p1, "ele"    # Lorg/w3c/dom/Element;

    .prologue
    .line 123
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getOwnerDocument()Lorg/w3c/dom/Document;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->createElement(Lorg/w3c/dom/Document;)Lorg/w3c/dom/Element;

    move-result-object v0

    .line 125
    .local v0, "newElement":Lorg/w3c/dom/Element;
    invoke-interface {p1, v0}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 126
    return-void
.end method
