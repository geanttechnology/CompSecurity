.class public Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final serialVersionUID:J = 0x1L


# instance fields
.field private financeOfferName:Ljava/lang/String;

.field private financeOfferUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 433
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadFinanceOffersData(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 448
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 449
    new-instance v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;-><init>()V

    .line 450
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 452
    :try_start_0
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 453
    const-string v4, "name"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;->financeOfferName:Ljava/lang/String;

    .line 454
    const-string v4, "url"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;->financeOfferUrl:Ljava/lang/String;

    .line 455
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 450
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 456
    :catch_0
    move-exception v1

    .line 457
    # getter for: Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions;->access$000()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Couldn\'t parse Finance Offers Data: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 460
    :cond_0
    return-object v2
.end method


# virtual methods
.method public getFinanceOfferName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 440
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;->financeOfferName:Ljava/lang/String;

    return-object v0
.end method

.method public getFinanceOfferUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 444
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/BuyingOptions$FinancingOffers;->financeOfferUrl:Ljava/lang/String;

    return-object v0
.end method
