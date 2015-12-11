.class public Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private itemId:Ljava/lang/String;

.field private watchForDrop:Z

.field private watchForPrice:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZD)V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->itemId:Ljava/lang/String;

    .line 35
    iput-boolean p2, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->watchForDrop:Z

    .line 36
    iput-wide p3, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->watchForPrice:D

    .line 37
    return-void
.end method


# virtual methods
.method public getItemID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getJSONData()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 40
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 42
    :try_start_0
    const-string v0, "item_id"

    iget-object v2, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->itemId:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 43
    const-string v0, "watch_for_drop"

    iget-boolean v2, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->watchForDrop:Z

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 44
    const-string v0, "watch_for_price"

    iget-wide v2, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->watchForPrice:D

    invoke-virtual {v1, v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;D)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    :goto_0
    return-object v1

    .line 45
    :catch_0
    move-exception v0

    .line 46
    sget-object v2, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not build JSON object from PriceWatchRequest: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getWatchForPrice()D
    .locals 2

    .prologue
    .line 30
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->watchForPrice:D

    return-wide v0
.end method

.method public isWatchForDrop()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchRequest;->watchForDrop:Z

    return v0
.end method
