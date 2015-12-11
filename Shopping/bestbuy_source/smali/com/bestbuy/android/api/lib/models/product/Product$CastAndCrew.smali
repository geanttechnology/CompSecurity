.class public Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private castAndCrewList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation
.end field

.field private castMembers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation
.end field

.field private directors:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation
.end field

.field private otherCrew:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation
.end field

.field private writers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2504
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCastAndCrewData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;
    .locals 9

    .prologue
    const/4 v1, 0x0

    .line 2536
    new-instance v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;-><init>()V

    .line 2537
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castMembers:Ljava/util/ArrayList;

    .line 2538
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    .line 2539
    const-string v0, "castMembers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 2540
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v2, "Cast Members"

    const-string v3, ""

    const-string v6, ""

    const-string v7, ""

    invoke-direct {v0, v2, v3, v6, v7}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2541
    iget-object v2, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2542
    if-eqz v5, :cond_3

    move v0, v1

    .line 2543
    :goto_0
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_3

    .line 2545
    invoke-virtual {v5, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2546
    if-eqz v3, :cond_0

    .line 2547
    const-string v2, "displayName"

    invoke-virtual {v3, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2548
    const-string v2, "characterNames"

    invoke-virtual {v3, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-nez v2, :cond_1

    const-string v2, ""

    .line 2550
    :goto_1
    const-string v7, "headshotImage"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    if-nez v7, :cond_2

    const-string v3, ""

    .line 2551
    :goto_2
    new-instance v7, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v8, ""

    invoke-direct {v7, v6, v2, v3, v8}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2552
    iget-object v2, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castMembers:Ljava/util/ArrayList;

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2553
    iget-object v2, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2543
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2548
    :cond_1
    const-string v2, "characterNames"

    invoke-virtual {v3, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const-string v7, "displayName"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 2550
    :cond_2
    const-string v7, "headshotImage"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    const-string v7, "url"

    invoke-virtual {v3, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_2

    .line 2559
    :cond_3
    const-string v0, "crewMembers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "writers"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 2560
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->writers:Ljava/util/ArrayList;

    .line 2561
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v3, "Writers"

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    invoke-direct {v0, v3, v5, v6, v7}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2562
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2563
    if-eqz v2, :cond_5

    move v0, v1

    .line 2564
    :goto_3
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_5

    .line 2566
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2567
    if-eqz v3, :cond_4

    .line 2568
    const-string v5, "displayName"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 2569
    new-instance v5, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v6, "no char name"

    const-string v7, "no image"

    const-string v8, ""

    invoke-direct {v5, v3, v6, v7, v8}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2570
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->writers:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2571
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2564
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 2577
    :cond_5
    const-string v0, "crewMembers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "directors"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 2578
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->directors:Ljava/util/ArrayList;

    .line 2579
    new-instance v0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v3, "Directors"

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    invoke-direct {v0, v3, v5, v6, v7}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2580
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2581
    if-eqz v2, :cond_7

    move v0, v1

    .line 2582
    :goto_4
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_7

    .line 2584
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 2585
    if-eqz v3, :cond_6

    .line 2586
    const-string v5, "displayName"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 2587
    new-instance v5, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v6, "no char name"

    const-string v7, "no image"

    const-string v8, ""

    invoke-direct {v5, v3, v6, v7, v8}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2588
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->directors:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2589
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2582
    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 2595
    :cond_7
    const-string v0, "crewMembers"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "otherCrew"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 2596
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->otherCrew:Ljava/util/ArrayList;

    .line 2597
    new-instance v2, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v3, "Other Crew"

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    invoke-direct {v2, v3, v5, v6, v7}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2598
    iget-object v3, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2599
    if-eqz v0, :cond_9

    .line 2600
    :goto_5
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v1, v2, :cond_9

    .line 2602
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 2603
    if-eqz v2, :cond_8

    .line 2604
    const-string v3, "role"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 2605
    const-string v5, "displayName"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 2606
    new-instance v5, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;

    const-string v6, ""

    const-string v7, "no image"

    invoke-direct {v5, v2, v6, v7, v3}, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 2607
    iget-object v2, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->otherCrew:Ljava/util/ArrayList;

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2608
    iget-object v2, v4, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2600
    :cond_8
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 2615
    :cond_9
    return-object v4
.end method


# virtual methods
.method public getCastAndCrewList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2531
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castAndCrewList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCastMembers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2514
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->castMembers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getDirectors()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2522
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->directors:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getOtherCrew()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2526
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->otherCrew:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getWriters()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrewData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2518
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/product/Product$CastAndCrew;->writers:Ljava/util/ArrayList;

    return-object v0
.end method
