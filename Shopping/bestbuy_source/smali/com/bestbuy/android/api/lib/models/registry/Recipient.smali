.class public Lcom/bestbuy/android/api/lib/models/registry/Recipient;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private addressCity:Ljava/lang/String;

.field private addressLine1:Ljava/lang/String;

.field private addressLine2:Ljava/lang/String;

.field private addressState:Ljava/lang/String;

.field private addressZip:Ljava/lang/String;

.field private alias:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private created:J

.field private emailAddress:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private isMobilePhoneNumber:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private modified:J

.field private name:Ljava/lang/String;

.field private parentRef:Ljava/lang/String;

.field private parentType:Ljava/lang/String;

.field private parentUuid:Ljava/lang/String;

.field private phoneNumber:Ljava/lang/String;

.field private phoneNumberType:Ljava/lang/String;

.field private transientFlag:Z

.field private type:Ljava/lang/String;

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseRecipientResponse(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Recipient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 174
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 175
    const-string v0, "entities"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 176
    if-eqz v2, :cond_2

    .line 177
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_2

    .line 178
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 179
    if-eqz v3, :cond_1

    .line 180
    new-instance v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;-><init>()V

    .line 181
    const-string v5, "uuid"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->uuid:Ljava/lang/String;

    .line 182
    const-string v5, "type"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->type:Ljava/lang/String;

    .line 183
    const-string v5, "alias"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->alias:Ljava/lang/String;

    .line 184
    const-string v5, "address-city"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressCity:Ljava/lang/String;

    .line 185
    const-string v5, "address-line1"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressLine1:Ljava/lang/String;

    .line 186
    const-string v5, "address-line2"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressLine2:Ljava/lang/String;

    .line 187
    const-string v5, "address-state"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressState:Ljava/lang/String;

    .line 188
    const-string v5, "address-zip"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressZip:Ljava/lang/String;

    .line 189
    const-string v5, "country"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->country:Ljava/lang/String;

    .line 190
    const-string v5, "email-address"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->emailAddress:Ljava/lang/String;

    .line 191
    const-string v5, "first-name"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->firstName:Ljava/lang/String;

    .line 192
    const-string v5, "last-name"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->lastName:Ljava/lang/String;

    .line 193
    const-string v5, "is-mobile-phone-number"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->isMobilePhoneNumber:Ljava/lang/String;

    .line 195
    const-string v5, "name"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->name:Ljava/lang/String;

    .line 196
    const-string v5, "parentRef"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->parentRef:Ljava/lang/String;

    .line 197
    const-string v5, "phone-number"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->phoneNumber:Ljava/lang/String;

    .line 198
    const-string v5, "phone-number-type"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->phoneNumberType:Ljava/lang/String;

    .line 199
    const-string v5, "parent"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 200
    if-eqz v5, :cond_0

    .line 201
    const-string v6, "type"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->parentType:Ljava/lang/String;

    .line 202
    const-string v6, "uuid"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->parentUuid:Ljava/lang/String;

    .line 204
    :cond_0
    const-string v5, "created"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->created:J

    .line 205
    const-string v5, "modified"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->modified:J

    .line 206
    const-string v5, "transient"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v3

    iput-boolean v3, v4, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->transientFlag:Z

    .line 207
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 177
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 211
    :cond_2
    return-object v1
.end method


# virtual methods
.method public getAddressCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressCity:Ljava/lang/String;

    return-object v0
.end method

.method public getAddressLine1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressLine1:Ljava/lang/String;

    return-object v0
.end method

.method public getAddressLine2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressLine2:Ljava/lang/String;

    return-object v0
.end method

.method public getAddressState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressState:Ljava/lang/String;

    return-object v0
.end method

.method public getAddressZip()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressZip:Ljava/lang/String;

    return-object v0
.end method

.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getCreated()J
    .locals 2

    .prologue
    .line 94
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->created:J

    return-wide v0
.end method

.method public getEmailAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->emailAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getIsMobilePhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->isMobilePhoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getModified()J
    .locals 2

    .prologue
    .line 98
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->modified:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getParentRef()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->parentRef:Ljava/lang/String;

    return-object v0
.end method

.method public getParentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->parentType:Ljava/lang/String;

    return-object v0
.end method

.method public getParentUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->parentUuid:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumberType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->phoneNumberType:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public isTransientFlag()Z
    .locals 1

    .prologue
    .line 110
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->transientFlag:Z

    return v0
.end method

.method public setAddressCity(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressCity:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setAddressLine1(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressLine1:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setAddressLine2(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressLine2:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setAddressState(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressState:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setAddressZip(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->addressZip:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setPhoneNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->phoneNumber:Ljava/lang/String;

    .line 83
    return-void
.end method
