.class public Lcom/bestbuy/android/api/lib/models/registry/Recommendations;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static TAG:Ljava/lang/String; = null

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private skuList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private total:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->skuList:Ljava/util/ArrayList;

    return-void
.end method

.method public static parseRecommendationsData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/registry/Recommendations;
    .locals 6

    .prologue
    .line 40
    new-instance v1, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;-><init>()V

    .line 41
    if-eqz p0, :cond_0

    .line 42
    const-string v0, "num_found"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v1, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->total:I

    .line 43
    const-string v0, "documents"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 44
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 45
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 46
    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 47
    iget-object v4, v1, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->skuList:Ljava/util/ArrayList;

    const-string v5, "skuid"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 45
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 51
    :cond_0
    return-object v1
.end method


# virtual methods
.method public getSkuList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->skuList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotal()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->total:I

    return v0
.end method

.method public setSkuList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->skuList:Ljava/util/ArrayList;

    .line 37
    return-void
.end method

.method public setTotal(I)V
    .locals 0

    .prologue
    .line 32
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/registry/Recommendations;->total:I

    .line 33
    return-void
.end method
