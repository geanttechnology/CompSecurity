.class public Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private email:Ljava/lang/String;

.field private ffDefault:Z

.field private firstName:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 85
    new-instance v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;-><init>()V

    .line 87
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v2

    .line 88
    const-string v3, "default"

    invoke-interface {v2, v3}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 89
    if-eqz v2, :cond_0

    .line 90
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    const-string v3, "true"

    invoke-virtual {v2, v3}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_2

    .line 91
    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->ffDefault:Z

    .line 96
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 97
    :goto_1
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v0, v3, :cond_6

    .line 98
    invoke-interface {v2, v0}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    .line 99
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "firstname"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_3

    .line 100
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->firstName:Ljava/lang/String;

    .line 97
    :cond_1
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 93
    :cond_2
    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->ffDefault:Z

    goto :goto_0

    .line 101
    :cond_3
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "lastname"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_4

    .line 102
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->lastName:Ljava/lang/String;

    goto :goto_2

    .line 103
    :cond_4
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "emailaddress"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_5

    .line 104
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->email:Ljava/lang/String;

    goto :goto_2

    .line 105
    :cond_5
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "phonenumber"

    invoke-virtual {v4, v5}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v4

    if-nez v4, :cond_1

    .line 106
    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->phoneNumber:Ljava/lang/String;

    goto :goto_2

    .line 109
    :cond_6
    return-object v1
.end method

.method public static loadData(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;
    .locals 1

    .prologue
    .line 75
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;-><init>()V

    .line 76
    iput-boolean p0, v0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->ffDefault:Z

    .line 77
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->firstName:Ljava/lang/String;

    .line 78
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->lastName:Ljava/lang/String;

    .line 79
    iput-object p3, v0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->email:Ljava/lang/String;

    .line 80
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->phoneNumber:Ljava/lang/String;

    .line 81
    return-object v0
.end method


# virtual methods
.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getXML()Lorg/w3c/dom/Document;
    .locals 4

    .prologue
    .line 46
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v0

    .line 49
    invoke-virtual {v0}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v0

    .line 50
    invoke-virtual {v0}, Ljavax/xml/parsers/DocumentBuilder;->newDocument()Lorg/w3c/dom/Document;

    move-result-object v1

    .line 51
    const-string v0, "friends-family-details"

    invoke-interface {v1, v0}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 52
    const-string v3, "default"

    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->ffDefault:Z

    if-eqz v0, :cond_0

    const-string v0, "true"

    :goto_0
    invoke-interface {v2, v3, v0}, Lorg/w3c/dom/Element;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    invoke-interface {v1, v2}, Lorg/w3c/dom/Document;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 55
    const-string v0, "firstname"

    invoke-interface {v1, v0}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v0

    .line 56
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->firstName:Ljava/lang/String;

    invoke-interface {v0, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 57
    invoke-interface {v2, v0}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 59
    const-string v0, "lastname"

    invoke-interface {v1, v0}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v0

    .line 60
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->lastName:Ljava/lang/String;

    invoke-interface {v0, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 61
    invoke-interface {v2, v0}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 63
    const-string v0, "emailaddress"

    invoke-interface {v1, v0}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v0

    .line 64
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->email:Ljava/lang/String;

    invoke-interface {v0, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 65
    invoke-interface {v2, v0}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 67
    const-string v0, "phonenumber"

    invoke-interface {v1, v0}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v0

    .line 68
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->phoneNumber:Ljava/lang/String;

    invoke-interface {v0, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 69
    invoke-interface {v2, v0}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 71
    return-object v1

    .line 52
    :cond_0
    const-string v0, "false"

    goto :goto_0
.end method

.method public isFfDefault()Z
    .locals 1

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/FriendsFamily;->ffDefault:Z

    return v0
.end method
