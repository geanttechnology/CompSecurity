.class public Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private firstUrl:Ljava/lang/String;

.field private lastUrl:Ljava/lang/String;

.field private nextUrl:Ljava/lang/String;

.field private prevUrl:Ljava/lang/String;

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


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->registryWishlistArray:Ljava/util/ArrayList;

    return-void
.end method

.method public static getRegistryWishListData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;
    .locals 7

    .prologue
    .line 99
    new-instance v2, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;-><init>()V

    .line 100
    if-eqz p0, :cond_0

    .line 101
    const-string v0, "first"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->firstUrl:Ljava/lang/String;

    .line 102
    const-string v0, "last"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->lastUrl:Ljava/lang/String;

    .line 103
    const-string v0, "next"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->nextUrl:Ljava/lang/String;

    .line 104
    const-string v0, "prev"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->prevUrl:Ljava/lang/String;

    .line 105
    const-string v0, "entities"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 106
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 107
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 110
    :try_start_0
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 111
    invoke-static {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->parseRegistryWishListData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v4

    .line 112
    const-string v5, "coRegistrantFirstName"

    const-string v6, ""

    invoke-virtual {v1, v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setCoRegistrantFirstName(Ljava/lang/String;)V

    .line 113
    const-string v5, "coRegistrantLastName"

    const-string v6, ""

    invoke-virtual {v1, v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setCoRegistrantLastName(Ljava/lang/String;)V

    .line 114
    iget-object v1, v2, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->registryWishlistArray:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 115
    :catch_0
    move-exception v1

    .line 116
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 121
    :cond_0
    return-object v2
.end method


# virtual methods
.method public getFirstUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->firstUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getLastUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->lastUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getNextUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->nextUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getPrevUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->prevUrl:Ljava/lang/String;

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
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->registryWishlistArray:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setFirstUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->firstUrl:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setLastUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->lastUrl:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setNextUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->nextUrl:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setPrevUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->prevUrl:Ljava/lang/String;

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
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->registryWishlistArray:Ljava/util/ArrayList;

    .line 96
    return-void
.end method
