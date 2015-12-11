.class public Lcom/bestbuy/android/api/lib/models/cms/Tiles;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static tileArray:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/cms/Tile;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private index:I

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Ljava/util/ArrayList;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/cms/Tiles;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 47
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 49
    const-string v0, "sections"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 50
    if-eqz v4, :cond_1

    move v0, v1

    .line 51
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 52
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 53
    new-instance v5, Lcom/bestbuy/android/api/lib/models/cms/Tiles;

    invoke-direct {v5}, Lcom/bestbuy/android/api/lib/models/cms/Tiles;-><init>()V

    .line 54
    const-string v6, "index"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v6

    iput v6, v5, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->index:I

    .line 55
    const-string v6, "title"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->title:Ljava/lang/String;

    .line 56
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    sput-object v6, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->tileArray:Ljava/util/ArrayList;

    .line 57
    const-string v6, "items"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 58
    if-eqz v6, :cond_0

    move v2, v1

    .line 59
    :goto_1
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v7

    if-ge v2, v7, :cond_0

    .line 60
    sget-object v7, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->tileArray:Ljava/util/ArrayList;

    invoke-virtual {v6, v2}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v8

    invoke-static {v8}, Lcom/bestbuy/android/api/lib/models/cms/Tile;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/cms/Tile;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 59
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 63
    :cond_0
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 51
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 66
    :cond_1
    return-object v3
.end method


# virtual methods
.method public getIndex()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->index:I

    return v0
.end method

.method public getTileArray()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/cms/Tile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 43
    sget-object v0, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->tileArray:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tiles;->title:Ljava/lang/String;

    return-object v0
.end method
