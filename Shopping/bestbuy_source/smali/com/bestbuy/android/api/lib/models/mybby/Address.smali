.class Lcom/bestbuy/android/api/lib/models/mybby/Address;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private addressType:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

.field private addressValue:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private isPrimary:Z

.field private municipality:Ljava/lang/String;

.field private stateCode:Ljava/lang/String;

.field private typeCode:Ljava/lang/String;

.field private zip:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Address;
    .locals 2

    .prologue
    .line 55
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Address;-><init>()V

    .line 56
    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzPostal:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->addressType:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    .line 57
    const-string v1, "addressLine1"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->addressValue:Ljava/lang/String;

    .line 58
    const-string v1, "country"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->country:Ljava/lang/String;

    .line 59
    const-string v1, "municipality"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->municipality:Ljava/lang/String;

    .line 60
    const-string v1, "postalCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->zip:Ljava/lang/String;

    .line 61
    const-string v1, "typeCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->typeCode:Ljava/lang/String;

    .line 62
    const-string v1, "region"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->stateCode:Ljava/lang/String;

    .line 63
    const-string v1, "primary"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->isPrimary:Z

    .line 64
    return-object v0
.end method


# virtual methods
.method public getAddressType()Lcom/bestbuy/android/api/lib/models/mybby/AddressType;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->addressType:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    return-object v0
.end method

.method public getAddressValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->addressValue:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getMunicipality()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->municipality:Ljava/lang/String;

    return-object v0
.end method

.method public getStateCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->stateCode:Ljava/lang/String;

    return-object v0
.end method

.method public getTypeCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->typeCode:Ljava/lang/String;

    return-object v0
.end method

.method public getZip()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->zip:Ljava/lang/String;

    return-object v0
.end method

.method public isPrimary()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Address;->isPrimary:Z

    return v0
.end method
