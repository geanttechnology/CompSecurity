.class Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private areaCode:Ljava/lang/String;

.field private countryCode:Ljava/lang/String;

.field private isPrimary:Z

.field private number:Ljava/lang/String;

.field private typeCode:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;
    .locals 2

    .prologue
    .line 43
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;-><init>()V

    .line 44
    const-string v1, "areaCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->areaCode:Ljava/lang/String;

    .line 45
    const-string v1, "countryCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->countryCode:Ljava/lang/String;

    .line 46
    const-string v1, "number"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->number:Ljava/lang/String;

    .line 47
    const-string v1, "typeCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->typeCode:Ljava/lang/String;

    .line 48
    const-string v1, "primary"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->isPrimary:Z

    .line 49
    return-object v0
.end method


# virtual methods
.method public getAreaCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->areaCode:Ljava/lang/String;

    return-object v0
.end method

.method public getCountryCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->countryCode:Ljava/lang/String;

    return-object v0
.end method

.method public getNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->number:Ljava/lang/String;

    return-object v0
.end method

.method public getTypeCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->typeCode:Ljava/lang/String;

    return-object v0
.end method

.method public isPrimary()Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->isPrimary:Z

    return v0
.end method
