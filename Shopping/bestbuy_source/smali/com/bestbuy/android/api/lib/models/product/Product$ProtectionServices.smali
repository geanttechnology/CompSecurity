.class public Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private commonFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation
.end field

.field private conditionalFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation
.end field

.field private protectionServicesList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation
.end field

.field private terms:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2322
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getProtectionServicesData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 2349
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;-><init>()V

    .line 2350
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->conditionalFeatures:Ljava/util/ArrayList;

    .line 2351
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->commonFeatures:Ljava/util/ArrayList;

    .line 2352
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->terms:Ljava/util/ArrayList;

    .line 2353
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    .line 2354
    const-string v0, "conditionalFeatures"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 2355
    if-eqz v3, :cond_4

    .line 2356
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "columns"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "planType"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v4, "GSP-R"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2358
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v4, "Protection Plan Benefits*"

    const-string v5, "Replacement Plan"

    const-string v6, ""

    invoke-direct {v0, v4, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2359
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_0
    :goto_0
    move v0, v1

    .line 2373
    :goto_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_4

    .line 2374
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 2375
    if-eqz v4, :cond_1

    .line 2376
    const-string v5, "columns"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "serviceInFeature"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2377
    const-string v6, "description"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2378
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v8, "title"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v7, v4, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2379
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->conditionalFeatures:Ljava/util/ArrayList;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2380
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2373
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 2361
    :cond_2
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "columns"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "planType"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v4, "GSP"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2363
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v4, "Protection Plan Benefits*"

    const-string v5, "Standard Protection Plan"

    const-string v6, ""

    invoke-direct {v0, v4, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2364
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 2366
    :cond_3
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "columns"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v4, "planType"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v4, "ADH"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2368
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v4, "Protection Plan Benefits*"

    const-string v5, "Accidental Damage\n from Handling Plans"

    const-string v6, ""

    invoke-direct {v0, v4, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2369
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 2384
    :cond_4
    const-string v0, "commonFeatures"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 2385
    if-eqz v3, :cond_6

    .line 2386
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v4, "Peace of Mind with Every Plan"

    const-string v5, ""

    const-string v6, ""

    invoke-direct {v0, v4, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2387
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 2388
    :goto_2
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_6

    .line 2389
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 2390
    if-eqz v4, :cond_5

    .line 2391
    const-string v5, "description"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2392
    const-string v6, "columns"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    invoke-virtual {v6, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "serviceInFeature"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2393
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v8, "title"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v7, v4, v6, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2394
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->commonFeatures:Ljava/util/ArrayList;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2395
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2388
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 2399
    :cond_6
    const-string v0, "terms"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 2400
    if-eqz v3, :cond_8

    .line 2401
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v4, "Available Plans"

    const-string v5, ""

    const-string v6, ""

    invoke-direct {v0, v4, v5, v6}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2402
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move v0, v1

    .line 2403
    :goto_3
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v0, v4, :cond_8

    .line 2404
    invoke-virtual {v3, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 2405
    if-eqz v4, :cond_7

    .line 2406
    const-string v5, "description"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 2407
    const-string v6, "columns"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    invoke-virtual {v6, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    const-string v7, "price"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2408
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;

    const-string v8, "term"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "$"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v7, v4, v6, v5}, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2409
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->terms:Ljava/util/ArrayList;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2410
    iget-object v4, v2, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2403
    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 2414
    :cond_8
    return-object v2
.end method


# virtual methods
.method public getCommonFeaturesList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2337
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->commonFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getConditionalFeaturesList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2333
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->conditionalFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getProtectionServicesList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2345
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->protectionServicesList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTermsList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServicesData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2341
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$ProtectionServices;->terms:Ljava/util/ArrayList;

    return-object v0
.end method
