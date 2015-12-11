.class public Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private certNumber:Ljava/lang/String;

.field private certStatus:Ljava/lang/String;

.field private certValue:Ljava/lang/String;

.field private expirationDate:Ljava/lang/String;

.field private issueDate:Ljava/lang/String;

.field private legacyCertNumber:Ljava/lang/String;

.field private pointBalance:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;
    .locals 3

    .prologue
    .line 76
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;-><init>()V

    .line 77
    const-string v1, "certNumber"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certNumber:Ljava/lang/String;

    .line 78
    const-string v1, "certStatus"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certStatus:Ljava/lang/String;

    .line 80
    const-string v1, "certValue"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certValue:Ljava/lang/String;

    .line 82
    const-string v1, "expirationDate"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->expirationDate:Ljava/lang/String;

    .line 83
    const-string v1, "issueDate"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->issueDate:Ljava/lang/String;

    .line 84
    const-string v1, "legacyCertNumber"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->legacyCertNumber:Ljava/lang/String;

    .line 86
    const-string v1, "pointsBalance"

    const-string v2, ""

    invoke-virtual {p1, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->setPointBalance(Ljava/lang/String;)V

    .line 88
    return-object v0
.end method


# virtual methods
.method public getCertNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getCertStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getCertValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certValue:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->expirationDate:Ljava/lang/String;

    return-object v0
.end method

.method public getIssueDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->issueDate:Ljava/lang/String;

    return-object v0
.end method

.method public getLegacyCertNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->legacyCertNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getPointBalance()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->pointBalance:Ljava/lang/String;

    return-object v0
.end method

.method public setCertNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certNumber:Ljava/lang/String;

    .line 23
    return-void
.end method

.method public setCertStatus(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certStatus:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setCertValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->certValue:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setExpirationDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->expirationDate:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setIssueDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->issueDate:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setLegacyCertNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->legacyCertNumber:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setPointBalance(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/IssuedMyBBYCert;->pointBalance:Ljava/lang/String;

    .line 71
    return-void
.end method
