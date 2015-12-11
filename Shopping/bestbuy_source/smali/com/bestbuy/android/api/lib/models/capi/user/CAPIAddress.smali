.class public Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private address1:Ljava/lang/String;

.field private address2:Ljava/lang/String;

.field private altPhone:Ljava/lang/String;

.field private city:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private email:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private fulfillmentId:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private middleName:Ljava/lang/String;

.field private phoneNumber:Ljava/lang/String;

.field private state:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private verified:Z

.field private zip:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;
    .locals 1

    .prologue
    .line 160
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;-><init>()V

    .line 161
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->type:Ljava/lang/String;

    .line 162
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->firstName:Ljava/lang/String;

    .line 163
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->lastName:Ljava/lang/String;

    .line 164
    iput-object p3, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address1:Ljava/lang/String;

    .line 165
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address2:Ljava/lang/String;

    .line 166
    iput-object p5, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->city:Ljava/lang/String;

    .line 167
    iput-object p6, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->state:Ljava/lang/String;

    .line 168
    iput-object p7, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->zip:Ljava/lang/String;

    .line 169
    iput-object p8, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->country:Ljava/lang/String;

    .line 170
    iput-object p9, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->email:Ljava/lang/String;

    .line 171
    iput-object p10, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->phoneNumber:Ljava/lang/String;

    .line 172
    return-object v0
.end method

.method public static loadData(Lorg/w3c/dom/Node;)Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;
    .locals 3

    .prologue
    .line 180
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;-><init>()V

    .line 181
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getAttributes()Lorg/w3c/dom/NamedNodeMap;

    move-result-object v1

    .line 182
    const-string v2, "type"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 183
    if-eqz v2, :cond_0

    .line 184
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->type:Ljava/lang/String;

    .line 187
    :cond_0
    const-string v2, "firstname"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 188
    if-eqz v2, :cond_1

    .line 189
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->firstName:Ljava/lang/String;

    .line 192
    :cond_1
    const-string v2, "middlename"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 193
    if-eqz v2, :cond_2

    .line 194
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->middleName:Ljava/lang/String;

    .line 197
    :cond_2
    const-string v2, "lastname"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 198
    if-eqz v2, :cond_3

    .line 199
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->lastName:Ljava/lang/String;

    .line 202
    :cond_3
    const-string v2, "address1"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 203
    if-eqz v2, :cond_4

    .line 204
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address1:Ljava/lang/String;

    .line 207
    :cond_4
    const-string v2, "address2"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 208
    if-eqz v2, :cond_5

    .line 209
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address2:Ljava/lang/String;

    .line 213
    :cond_5
    const-string v2, "city"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 214
    if-eqz v2, :cond_6

    .line 215
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->city:Ljava/lang/String;

    .line 218
    :cond_6
    const-string v2, "state"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 219
    if-eqz v2, :cond_7

    .line 220
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->state:Ljava/lang/String;

    .line 223
    :cond_7
    const-string v2, "postalcode"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 224
    if-eqz v2, :cond_8

    .line 225
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->zip:Ljava/lang/String;

    .line 228
    :cond_8
    const-string v2, "country"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 229
    if-eqz v2, :cond_9

    .line 230
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->country:Ljava/lang/String;

    .line 233
    :cond_9
    const-string v2, "phonenumber"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 234
    if-eqz v2, :cond_a

    .line 235
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->phoneNumber:Ljava/lang/String;

    .line 238
    :cond_a
    const-string v2, "email"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 239
    if-eqz v2, :cond_b

    .line 240
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->email:Ljava/lang/String;

    .line 243
    :cond_b
    const-string v2, "fulfillment-id"

    invoke-interface {v1, v2}, Lorg/w3c/dom/NamedNodeMap;->getNamedItem(Ljava/lang/String;)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 244
    if-eqz v1, :cond_c

    .line 245
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->fulfillmentId:Ljava/lang/String;

    .line 248
    :cond_c
    return-object v0
.end method


# virtual methods
.method public getAddress1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address1:Ljava/lang/String;

    return-object v0
.end method

.method public getAddress2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address2:Ljava/lang/String;

    return-object v0
.end method

.method public getAltPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->altPhone:Ljava/lang/String;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getFulfillmentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->fulfillmentId:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getMiddleName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->middleName:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getXML()Lorg/w3c/dom/Document;
    .locals 4

    .prologue
    .line 95
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v0

    .line 96
    invoke-virtual {v0}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v0

    .line 97
    invoke-virtual {v0}, Ljavax/xml/parsers/DocumentBuilder;->newDocument()Lorg/w3c/dom/Document;

    move-result-object v0

    .line 99
    const-string v1, "address"

    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    .line 100
    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->type:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->type:Ljava/lang/String;

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-eqz v2, :cond_0

    .line 101
    const-string v2, "type"

    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->type:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Lorg/w3c/dom/Element;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    :cond_0
    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 106
    const-string v2, "firstname"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 107
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->firstName:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 108
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 110
    const-string v2, "lastname"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 111
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->lastName:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 112
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 114
    const-string v2, "address1"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 115
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address1:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 116
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 118
    const-string v2, "address2"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 119
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->address2:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 120
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 122
    const-string v2, "city"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 123
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->city:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 124
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 126
    const-string v2, "state"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 127
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->state:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 128
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 130
    const-string v2, "country"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 131
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->country:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 132
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 134
    const-string v2, "postalcode"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 135
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->zip:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 136
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 138
    const-string v2, "phonenumber"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 139
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->phoneNumber:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 140
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 142
    const-string v2, "otherphone"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 143
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->altPhone:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 144
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 146
    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->fulfillmentId:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 147
    const-string v2, "fulfillment-id"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 148
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->fulfillmentId:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 149
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 152
    :cond_1
    return-object v0
.end method

.method public getZip()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->zip:Ljava/lang/String;

    return-object v0
.end method

.method public isVerified()Z
    .locals 1

    .prologue
    .line 79
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/CAPIAddress;->verified:Z

    return v0
.end method
