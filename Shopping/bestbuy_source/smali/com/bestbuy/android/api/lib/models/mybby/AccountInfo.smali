.class public Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private accountId:Ljava/lang/String;

.field private addresses:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Address;",
            ">;"
        }
    .end annotation
.end field

.field private category:Ljava/lang/String;

.field private categoryDescription:Ljava/lang/String;

.field private certPreferenceCategory:Ljava/lang/String;

.field private emailAddress:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private partyId:Ljava/lang/String;

.field private phoneNumbers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;",
            ">;"
        }
    .end annotation
.end field

.field private typeCode:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 98
    new-instance v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;-><init>()V

    .line 101
    :try_start_0
    const-string v1, "accountId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->accountId:Ljava/lang/String;

    .line 102
    const-string v1, "partyId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->partyId:Ljava/lang/String;

    .line 103
    const-string v1, "typeCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->typeCode:Ljava/lang/String;

    .line 104
    const-string v1, "statusCode"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->category:Ljava/lang/String;

    .line 105
    const-string v1, "categoryDescription"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->categoryDescription:Ljava/lang/String;

    .line 106
    const-string v1, "firstName"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->firstName:Ljava/lang/String;

    .line 107
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->getFirstName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->getFirstName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 108
    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->firstName:Ljava/lang/String;

    .line 109
    const-string v1, "lastName"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->lastName:Ljava/lang/String;

    .line 110
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->getLastName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->getLastName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 111
    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->lastName:Ljava/lang/String;

    .line 112
    const-string v1, "certPreferenceCategory"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->certPreferenceCategory:Ljava/lang/String;

    .line 113
    const-string v1, "emails"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    const-string v3, "emailAddress"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->emailAddress:Ljava/lang/String;

    .line 114
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->addresses:Ljava/util/ArrayList;

    .line 115
    const-string v1, "addresses"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 116
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_0

    move v1, v0

    .line 117
    :goto_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v1, v4, :cond_0

    .line 118
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->addresses:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    invoke-static {v5}, Lcom/bestbuy/android/api/lib/models/mybby/Address;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Address;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 117
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 121
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->phoneNumbers:Ljava/util/ArrayList;

    .line 122
    const-string v1, "phones"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 123
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-lez v3, :cond_1

    .line 124
    :goto_1
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 125
    iget-object v3, v2, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->phoneNumbers:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    invoke-static {v4}, Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 124
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 128
    :catch_0
    move-exception v0

    .line 129
    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error Parsing RewardZone AccountInfo: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    throw v0

    .line 133
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getAccountId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->accountId:Ljava/lang/String;

    return-object v0
.end method

.method public getAddresses()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/Address;",
            ">;"
        }
    .end annotation

    .prologue
    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->addresses:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->categoryDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getCertPreferenceCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->certPreferenceCategory:Ljava/lang/String;

    return-object v0
.end method

.method public getEmailAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->emailAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getPartyId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->partyId:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumbers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/mybby/PhoneNumber;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->phoneNumbers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTypeCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->typeCode:Ljava/lang/String;

    return-object v0
.end method

.method public setCertPreferenceCategory(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/AccountInfo;->certPreferenceCategory:Ljava/lang/String;

    .line 75
    return-void
.end method
