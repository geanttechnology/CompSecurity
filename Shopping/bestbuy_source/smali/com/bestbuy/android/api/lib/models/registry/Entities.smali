.class public Lcom/bestbuy/android/api/lib/models/registry/Entities;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static TAG:Ljava/lang/String; = null

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private Uuid:Ljava/lang/String;

.field private createdBy:Ljava/lang/String;

.field private favoriteFlag:Z

.field private parentType:Ljava/lang/String;

.field private parentUuid:Ljava/lang/String;

.field private personalizedMsg:Ljava/lang/String;

.field private purchaseQuantity:I

.field private requiredQuantity:I

.field private sku:Ljava/lang/String;

.field private tags:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private updatedBy:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->purchaseQuantity:I

    return-void
.end method

.method public static getAddedProductsList(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 94
    if-eqz p0, :cond_2

    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_2

    .line 96
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 97
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 98
    if-eqz v2, :cond_1

    .line 99
    new-instance v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/registry/Entities;-><init>()V

    .line 100
    const-string v4, "uuid"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->Uuid:Ljava/lang/String;

    .line 101
    const-string v4, "type"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->type:Ljava/lang/String;

    .line 102
    const-string v4, "created-by"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->createdBy:Ljava/lang/String;

    .line 103
    const-string v4, "last-updated-by"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->updatedBy:Ljava/lang/String;

    .line 104
    const-string v4, "required-quantity"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->requiredQuantity:I

    .line 105
    const-string v4, "purchased-quantity"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->purchaseQuantity:I

    .line 106
    const-string v4, "sku"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->sku:Ljava/lang/String;

    .line 107
    const-string v4, "tags"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->tags:Ljava/lang/String;

    .line 108
    const-string v4, "personalized-message"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->personalizedMsg:Ljava/lang/String;

    .line 109
    const-string v4, "favorite"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v4

    iput-boolean v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->favoriteFlag:Z

    .line 110
    const-string v4, "parent"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 111
    if-eqz v2, :cond_0

    .line 112
    const-string v4, "uuid"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->parentUuid:Ljava/lang/String;

    .line 113
    const-string v4, "type"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/registry/Entities;->parentType:Ljava/lang/String;

    .line 115
    :cond_0
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 96
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 119
    :cond_2
    return-object v1
.end method


# virtual methods
.method public getCreatedBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->createdBy:Ljava/lang/String;

    return-object v0
.end method

.method public getParentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->parentType:Ljava/lang/String;

    return-object v0
.end method

.method public getParentUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->parentUuid:Ljava/lang/String;

    return-object v0
.end method

.method public getPersonalizedMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->personalizedMsg:Ljava/lang/String;

    return-object v0
.end method

.method public getPurchaseQuantity()I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->purchaseQuantity:I

    return v0
.end method

.method public getRequiredQuantity()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->requiredQuantity:I

    return v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->tags:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUpdatedBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->updatedBy:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->Uuid:Ljava/lang/String;

    return-object v0
.end method

.method public isFavorite()Z
    .locals 1

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->favoriteFlag:Z

    return v0
.end method

.method public setFavorite(Z)V
    .locals 0

    .prologue
    .line 89
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->favoriteFlag:Z

    .line 90
    return-void
.end method

.method public setPurchaseQuantity(I)V
    .locals 0

    .prologue
    .line 37
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->purchaseQuantity:I

    .line 38
    return-void
.end method

.method public setRequiredQuantity(I)V
    .locals 0

    .prologue
    .line 85
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Entities;->requiredQuantity:I

    .line 86
    return-void
.end method
