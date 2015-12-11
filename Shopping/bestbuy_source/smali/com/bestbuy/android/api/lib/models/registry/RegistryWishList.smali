.class public Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/io/Serializable;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
        ">;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private alias:Ljava/lang/String;

.field private baseType:Ljava/lang/String;

.field private city:Ljava/lang/String;

.field private coRegistrantFirstName:Ljava/lang/String;

.field private coRegistrantLastName:Ljava/lang/String;

.field private created:J

.field private createdBy:Ljava/lang/String;

.field private createdOnChannel:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private effectiveTTL:J

.field private firstName:Ljava/lang/String;

.field private firstUrl:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private lastUpdatedBy:Ljava/lang/String;

.field private lastUrl:Ljava/lang/String;

.field private location:Ljava/lang/String;

.field private modified:J

.field private myRegistry:Z

.field private name:Ljava/lang/String;

.field private nextUrl:Ljava/lang/String;

.field private occasionDate:Ljava/lang/String;

.field private personalizedMessage:Ljava/lang/String;

.field private prevUrl:Ljava/lang/String;

.field private privacySetting:Ljava/lang/String;

.field private recipient:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

.field private recipientList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Recipient;",
            ">;"
        }
    .end annotation
.end field

.field private registryWishlistArray:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation
.end field

.field private retailListAlias:Ljava/lang/String;

.field private schoolName:Ljava/lang/String;

.field private shippingAddress:Ljava/lang/String;

.field private shortDescription:Ljava/lang/String;

.field private state:Ljava/lang/String;

.field private tags:Ljava/lang/String;

.field private theKnot:Z

.field private transientFlag:Z

.field private type:Ljava/lang/String;

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseRegistryWishListData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 4

    .prologue
    .line 422
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;-><init>()V

    .line 423
    if-eqz p0, :cond_3

    .line 424
    const-string v1, "uuid"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->uuid:Ljava/lang/String;

    .line 425
    const-string v1, "type"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->type:Ljava/lang/String;

    .line 426
    iget-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->type:Ljava/lang/String;

    const-string v2, "s"

    invoke-virtual {v1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 427
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->type:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "s"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->type:Ljava/lang/String;

    .line 428
    :cond_0
    const-string v1, "created"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->created:J

    .line 429
    const-string v1, "modified"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->modified:J

    .line 430
    const-string v1, "transient"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->transientFlag:Z

    .line 431
    const-string v1, "base-type"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->baseType:Ljava/lang/String;

    .line 432
    const-string v1, "alias"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->alias:Ljava/lang/String;

    .line 433
    const-string v1, "created-by"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->createdBy:Ljava/lang/String;

    .line 434
    const-string v1, "last-updated-by"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastUpdatedBy:Ljava/lang/String;

    .line 435
    const-string v1, "name"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->name:Ljava/lang/String;

    .line 436
    const-string v1, "created-on-channel"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->createdOnChannel:Ljava/lang/String;

    .line 437
    const-string v1, "occasion-date"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->occasionDate:Ljava/lang/String;

    .line 438
    const-string v1, "personalized-message"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->personalizedMessage:Ljava/lang/String;

    .line 439
    const-string v1, "privacy-setting"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->privacySetting:Ljava/lang/String;

    .line 440
    const-string v1, "short-description"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->shortDescription:Ljava/lang/String;

    .line 441
    const-string v1, "description"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->description:Ljava/lang/String;

    .line 442
    const-string v1, "tags"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->tags:Ljava/lang/String;

    .line 443
    const-string v1, "effectiveTTL"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->effectiveTTL:J

    .line 444
    const-string v1, "occasion-notes"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 445
    if-eqz v1, :cond_1

    .line 446
    const-string v2, "location"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->location:Ljava/lang/String;

    .line 447
    const-string v2, "city"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->city:Ljava/lang/String;

    .line 448
    const-string v2, "state"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->state:Ljava/lang/String;

    .line 450
    :cond_1
    const-string v1, "list-notes"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 451
    if-eqz v1, :cond_2

    .line 452
    const-string v2, "first-name"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->firstName:Ljava/lang/String;

    .line 453
    const-string v2, "last-name"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastName:Ljava/lang/String;

    .line 455
    :cond_2
    const-string v1, "co-registrant-first-name"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->coRegistrantFirstName:Ljava/lang/String;

    .line 456
    const-string v1, "co-registrant-last-name"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->coRegistrantLastName:Ljava/lang/String;

    .line 457
    const-string v1, "retail-list-alias"

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->retailListAlias:Ljava/lang/String;

    .line 459
    :cond_3
    return-object v0
.end method


# virtual methods
.method public compareTo(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)I
    .locals 4

    .prologue
    .line 465
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->created:J

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCreated()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 13
    check-cast p1, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {p0, p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->compareTo(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)I

    move-result v0

    return v0
.end method

.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getBaseType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->baseType:Ljava/lang/String;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getCoRegistrantFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 292
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->coRegistrantFirstName:Ljava/lang/String;

    return-object v0
.end method

.method public getCoRegistrantLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 296
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->coRegistrantLastName:Ljava/lang/String;

    return-object v0
.end method

.method public getCreated()J
    .locals 2

    .prologue
    .line 224
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->created:J

    return-wide v0
.end method

.method public getCreatedBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->createdBy:Ljava/lang/String;

    return-object v0
.end method

.method public getCreatedOnChannel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->createdOnChannel:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getEffectiveTTL()J
    .locals 2

    .prologue
    .line 288
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->effectiveTTL:J

    return-wide v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->firstUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getLastUpdatedBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastUpdatedBy:Ljava/lang/String;

    return-object v0
.end method

.method public getLastUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->location:Ljava/lang/String;

    return-object v0
.end method

.method public getModified()J
    .locals 2

    .prologue
    .line 228
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->modified:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNextUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->nextUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getOccasionDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->occasionDate:Ljava/lang/String;

    return-object v0
.end method

.method public getPersonalizedMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->personalizedMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getPrevUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->prevUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getPrivacySetting()Ljava/lang/String;
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->privacySetting:Ljava/lang/String;

    return-object v0
.end method

.method public getRecipient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->recipient:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    return-object v0
.end method

.method public getRecipientList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Recipient;",
            ">;"
        }
    .end annotation

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->recipientList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getRegistryWishlistArray()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->registryWishlistArray:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getRetailListAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 411
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->retailListAlias:Ljava/lang/String;

    return-object v0
.end method

.method public getSchoolName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->schoolName:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->shippingAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getShortDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->shortDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/lang/String;
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->tags:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public isMyRegistry()Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->myRegistry:Z

    return v0
.end method

.method public isTheKnot()Z
    .locals 1

    .prologue
    .line 61
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->theKnot:Z

    return v0
.end method

.method public isTransientFlag()Z
    .locals 1

    .prologue
    .line 232
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->transientFlag:Z

    return v0
.end method

.method public setAlias(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 328
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->alias:Ljava/lang/String;

    .line 329
    return-void
.end method

.method public setBaseType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 344
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->baseType:Ljava/lang/String;

    .line 345
    return-void
.end method

.method public setCity(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 396
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->city:Ljava/lang/String;

    .line 397
    return-void
.end method

.method public setCoRegistrantFirstName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 384
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->coRegistrantFirstName:Ljava/lang/String;

    .line 385
    return-void
.end method

.method public setCoRegistrantLastName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 388
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->coRegistrantLastName:Ljava/lang/String;

    .line 389
    return-void
.end method

.method public setCreated(J)V
    .locals 1

    .prologue
    .line 316
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->created:J

    .line 317
    return-void
.end method

.method public setCreatedBy(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->createdBy:Ljava/lang/String;

    .line 333
    return-void
.end method

.method public setCreatedOnChannel(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 348
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->createdOnChannel:Ljava/lang/String;

    .line 349
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->description:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setEffectiveTTL(J)V
    .locals 1

    .prologue
    .line 380
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->effectiveTTL:J

    .line 381
    return-void
.end method

.method public setFirstName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->firstName:Ljava/lang/String;

    .line 198
    return-void
.end method

.method public setFirstUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->firstUrl:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setLastName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastName:Ljava/lang/String;

    .line 205
    return-void
.end method

.method public setLastUpdatedBy(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 336
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastUpdatedBy:Ljava/lang/String;

    .line 337
    return-void
.end method

.method public setLastUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->lastUrl:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public setLocation(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 360
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->location:Ljava/lang/String;

    .line 361
    return-void
.end method

.method public setModified(J)V
    .locals 1

    .prologue
    .line 320
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->modified:J

    .line 321
    return-void
.end method

.method public setMyRegistry(Z)V
    .locals 0

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->myRegistry:Z

    .line 74
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 340
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->name:Ljava/lang/String;

    .line 341
    return-void
.end method

.method public setNextUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->nextUrl:Ljava/lang/String;

    .line 170
    return-void
.end method

.method public setOccasionDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 352
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->occasionDate:Ljava/lang/String;

    .line 353
    return-void
.end method

.method public setPersonalizedMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->personalizedMessage:Ljava/lang/String;

    .line 365
    return-void
.end method

.method public setPrevUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->prevUrl:Ljava/lang/String;

    .line 177
    return-void
.end method

.method public setPrivacySetting(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 368
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->privacySetting:Ljava/lang/String;

    .line 369
    return-void
.end method

.method public setRecipient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->recipient:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    .line 209
    return-void
.end method

.method public setRecipientList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Recipient;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->recipientList:Ljava/util/ArrayList;

    .line 88
    return-void
.end method

.method public setRegistryWishlistArray(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 120
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->registryWishlistArray:Ljava/util/ArrayList;

    .line 121
    return-void
.end method

.method public setRetailListAlias(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 418
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->retailListAlias:Ljava/lang/String;

    .line 419
    return-void
.end method

.method public setSchoolName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 356
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->schoolName:Ljava/lang/String;

    .line 357
    return-void
.end method

.method public setShippingAddress(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 304
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->shippingAddress:Ljava/lang/String;

    .line 305
    return-void
.end method

.method public setShortDescription(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 372
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->shortDescription:Ljava/lang/String;

    .line 373
    return-void
.end method

.method public setState(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 404
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->state:Ljava/lang/String;

    .line 405
    return-void
.end method

.method public setTags(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 376
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->tags:Ljava/lang/String;

    .line 377
    return-void
.end method

.method public setTheKnot(Z)V
    .locals 0

    .prologue
    .line 69
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->theKnot:Z

    .line 70
    return-void
.end method

.method public setTransientFlag(Z)V
    .locals 0

    .prologue
    .line 324
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->transientFlag:Z

    .line 325
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 312
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->type:Ljava/lang/String;

    .line 313
    return-void
.end method

.method public setUuid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 308
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->uuid:Ljava/lang/String;

    .line 309
    return-void
.end method
