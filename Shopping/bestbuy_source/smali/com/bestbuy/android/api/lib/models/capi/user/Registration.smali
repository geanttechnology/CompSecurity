.class public Lcom/bestbuy/android/api/lib/models/capi/user/Registration;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private confirmEmail:Ljava/lang/String;

.field private confirmPassword:Ljava/lang/String;

.field private email:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private middleName:Ljava/lang/String;

.field private password:Ljava/lang/String;

.field private rewardZoneId:Ljava/lang/String;

.field private zip:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/user/Registration;
    .locals 1

    .prologue
    .line 58
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;-><init>()V

    .line 59
    iput-object p0, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->firstName:Ljava/lang/String;

    .line 60
    iput-object p1, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->middleName:Ljava/lang/String;

    .line 61
    iput-object p2, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->lastName:Ljava/lang/String;

    .line 62
    iput-object p3, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->email:Ljava/lang/String;

    .line 63
    iput-object p4, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->confirmEmail:Ljava/lang/String;

    .line 64
    iput-object p5, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->password:Ljava/lang/String;

    .line 65
    iput-object p5, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->confirmPassword:Ljava/lang/String;

    .line 66
    iput-object p7, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->zip:Ljava/lang/String;

    .line 67
    iput-object p8, v0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->rewardZoneId:Ljava/lang/String;

    .line 69
    return-object v0
.end method


# virtual methods
.method public getConfirmEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->confirmEmail:Ljava/lang/String;

    return-object v0
.end method

.method public getConfirmPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->confirmPassword:Ljava/lang/String;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getMiddleName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->middleName:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getRewardZoneId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->rewardZoneId:Ljava/lang/String;

    return-object v0
.end method

.method public getXML()Lorg/w3c/dom/Document;
    .locals 4

    .prologue
    .line 73
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v0

    .line 74
    invoke-virtual {v0}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v0

    .line 75
    invoke-virtual {v0}, Ljavax/xml/parsers/DocumentBuilder;->newDocument()Lorg/w3c/dom/Document;

    move-result-object v0

    .line 76
    const-string v1, "user"

    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    .line 77
    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 79
    const-string v2, "firstname"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 80
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->firstName:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 81
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 83
    const-string v2, "middlename"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 84
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->middleName:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 85
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 87
    const-string v2, "lastname"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 88
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->lastName:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 89
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 91
    const-string v2, "emailaddress"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 92
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->email:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 93
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 95
    const-string v2, "confirmemailaddress"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 96
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->confirmEmail:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 97
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 99
    const-string v2, "password"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 100
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->password:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 101
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 103
    const-string v2, "confirmpassword"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 104
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->confirmPassword:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 105
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 107
    const-string v2, "postalcode"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 108
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->zip:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 109
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 111
    const-string v2, "rewardzoneid"

    invoke-interface {v0, v2}, Lorg/w3c/dom/Document;->createElement(Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    .line 112
    iget-object v3, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->rewardZoneId:Ljava/lang/String;

    invoke-interface {v2, v3}, Lorg/w3c/dom/Node;->setTextContent(Ljava/lang/String;)V

    .line 113
    invoke-interface {v1, v2}, Lorg/w3c/dom/Element;->appendChild(Lorg/w3c/dom/Node;)Lorg/w3c/dom/Node;

    .line 115
    return-object v0
.end method

.method public getZip()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/capi/user/Registration;->zip:Ljava/lang/String;

    return-object v0
.end method
