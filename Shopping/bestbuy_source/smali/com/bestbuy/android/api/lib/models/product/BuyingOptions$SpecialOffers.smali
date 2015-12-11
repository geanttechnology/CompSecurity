.class public Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private spclOfferName:Ljava/lang/String;

.field private spclOfferTarget:Ljava/lang/String;

.field private spclOfferUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 389
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadSpecialOffersData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 409
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 410
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 413
    :try_start_0
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 414
    if-eqz v1, :cond_0

    .line 415
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;-><init>()V

    .line 416
    const-string v4, "name"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->spclOfferName:Ljava/lang/String;

    .line 417
    const-string v4, "target"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->spclOfferTarget:Ljava/lang/String;

    .line 418
    const-string v4, "url"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->spclOfferUrl:Ljava/lang/String;

    .line 419
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 410
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 421
    :catch_0
    move-exception v1

    .line 422
    # getter for: Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->access$000()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Couldn\'t parse Special Offers data: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 425
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getSpclOfferName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 397
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->spclOfferName:Ljava/lang/String;

    return-object v0
.end method

.method public getSpclOfferTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 401
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->spclOfferTarget:Ljava/lang/String;

    return-object v0
.end method

.method public getSpclOfferUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 405
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$SpecialOffers;->spclOfferUrl:Ljava/lang/String;

    return-object v0
.end method
