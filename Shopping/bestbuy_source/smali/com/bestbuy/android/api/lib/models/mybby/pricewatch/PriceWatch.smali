.class public Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private curPrice:D

.field private enablePriceReaches:Z

.field private isPriceDropSel:Z

.field private isPriceReachSel:Z

.field private orgPrice:D

.field private prodImgURL:Ljava/lang/String;

.field private prodName:Ljava/lang/String;

.field private prodURL:Ljava/lang/String;

.field private setPrice:D

.field private sku:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 63
    new-instance v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;-><init>()V

    .line 65
    const-string v0, "item_id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->sku:Ljava/lang/String;

    .line 68
    :try_start_0
    const-string v0, "product_info"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 70
    const-string v2, "product_name"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->prodName:Ljava/lang/String;

    .line 71
    const-string v2, "image_link"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->prodImgURL:Ljava/lang/String;

    .line 72
    const-string v2, "pdp_link"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->prodURL:Ljava/lang/String;

    .line 74
    const-string v2, "watch_for_price"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->setPrice:D

    .line 75
    const-string v2, "reg_price"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->orgPrice:D

    .line 78
    const-string v2, "priceWithPlan"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 79
    const-string v2, "priceWithPlan"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 80
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v3

    if-le v3, v4, :cond_0

    .line 82
    const/4 v0, 0x0

    :try_start_1
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "newTwoYearPlan"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->curPrice:D
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .line 86
    :goto_0
    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->enablePriceReaches:Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    .line 99
    :goto_1
    const-string v0, "watch_for_drop"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->isPriceDropSel:Z

    .line 100
    const-string v0, "watch_for_price"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->isPriceReachSel:Z

    .line 102
    return-object v1

    .line 83
    :catch_0
    move-exception v0

    .line 84
    :try_start_3
    sget-object v2, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not parse current price for price watch JSON object: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 95
    :catch_1
    move-exception v0

    .line 96
    throw v0

    .line 88
    :cond_0
    :try_start_4
    const-string v2, "current_price"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->curPrice:D

    .line 89
    const/4 v0, 0x1

    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->enablePriceReaches:Z

    goto :goto_1

    .line 92
    :cond_1
    const-string v2, "current_price"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->curPrice:D

    .line 93
    const/4 v0, 0x1

    iput-boolean v0, v1, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->enablePriceReaches:Z
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_1
.end method


# virtual methods
.method public getCurPrice()D
    .locals 2

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->curPrice:D

    return-wide v0
.end method

.method public getOrgPrice()D
    .locals 2

    .prologue
    .line 44
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->orgPrice:D

    return-wide v0
.end method

.method public getProdImgURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->prodImgURL:Ljava/lang/String;

    return-object v0
.end method

.method public getProdName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->prodName:Ljava/lang/String;

    return-object v0
.end method

.method public getProdURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->prodURL:Ljava/lang/String;

    return-object v0
.end method

.method public getSetPrice()D
    .locals 2

    .prologue
    .line 50
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->setPrice:D

    return-wide v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public isEnablePriceReaches()Z
    .locals 1

    .prologue
    .line 59
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->enablePriceReaches:Z

    return v0
.end method

.method public isPriceDropSel()Z
    .locals 1

    .prologue
    .line 53
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->isPriceDropSel:Z

    return v0
.end method

.method public isPriceReachSel()Z
    .locals 1

    .prologue
    .line 56
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatch;->isPriceReachSel:Z

    return v0
.end method
