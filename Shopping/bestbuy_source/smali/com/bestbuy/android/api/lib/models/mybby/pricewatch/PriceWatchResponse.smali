.class public Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private listId:Ljava/lang/String;

.field private status:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;->status:Ljava/lang/String;

    .line 16
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;->listId:Ljava/lang/String;

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;
    .locals 2

    .prologue
    .line 27
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;-><init>()V

    .line 28
    const-string v1, "status"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;->status:Ljava/lang/String;

    .line 29
    const-string v1, "list_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;->listId:Ljava/lang/String;

    .line 30
    return-object v0
.end method


# virtual methods
.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;->listId:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/pricewatch/PriceWatchResponse;->status:Ljava/lang/String;

    return-object v0
.end method
