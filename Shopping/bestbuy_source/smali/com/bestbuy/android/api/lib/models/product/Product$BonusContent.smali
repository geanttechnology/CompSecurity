.class public Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availability:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private displayName:Ljava/lang/String;

.field private imageUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1793
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadFreeBonusContent(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1820
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1821
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 1822
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 1823
    if-eqz v2, :cond_1

    .line 1824
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;-><init>()V

    .line 1825
    const-string v4, "displayName"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->displayName:Ljava/lang/String;

    .line 1826
    const-string v4, "description"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->description:Ljava/lang/String;

    .line 1827
    const-string v4, "availabilityMessage"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->availability:Ljava/lang/String;

    .line 1828
    const-string v4, "primaryImage"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 1829
    if-eqz v2, :cond_0

    .line 1830
    const-string v4, "url"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->imageUrl:Ljava/lang/String;

    .line 1832
    :cond_0
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1821
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1835
    :cond_2
    return-object v1
.end method


# virtual methods
.method public getAvailability()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1812
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->availability:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1808
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1804
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1816
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$BonusContent;->imageUrl:Ljava/lang/String;

    return-object v0
.end method
