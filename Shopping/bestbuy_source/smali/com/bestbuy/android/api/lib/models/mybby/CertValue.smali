.class public Lcom/bestbuy/android/api/lib/models/mybby/CertValue;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private description:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private displaySequence:I

.field private name:Ljava/lang/String;

.field private requiredPoints:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/CertValue;
    .locals 2

    .prologue
    .line 55
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;-><init>()V

    .line 56
    const-string v1, "description"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->description:Ljava/lang/String;

    .line 57
    const-string v1, "displayName"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->displayName:Ljava/lang/String;

    .line 58
    const-string v1, "displaySequence"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->displaySequence:I

    .line 59
    const-string v1, "name"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->name:Ljava/lang/String;

    .line 61
    return-object v0
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplaySequence()I
    .locals 1

    .prologue
    .line 15
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->displaySequence:I

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getRequiredPoints()I
    .locals 1

    .prologue
    .line 47
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->requiredPoints:I

    return v0
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->description:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->displayName:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setDisplaySequence(I)V
    .locals 0

    .prologue
    .line 19
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->displaySequence:I

    .line 20
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->name:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setRequiredPoints(I)V
    .locals 0

    .prologue
    .line 51
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/CertValue;->requiredPoints:I

    .line 52
    return-void
.end method
