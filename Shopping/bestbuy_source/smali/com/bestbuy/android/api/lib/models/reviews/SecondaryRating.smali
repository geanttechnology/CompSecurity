.class public Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private displayType:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private maxLabel:Ljava/lang/String;

.field private minLabel:Ljava/lang/String;

.field private ratingKey:Ljava/lang/String;

.field private value:I

.field private valueLabel:Ljava/lang/String;

.field private valueRange:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadSecondaryRatingData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 62
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 63
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 64
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 65
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 66
    if-eqz v3, :cond_0

    .line 67
    new-instance v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;-><init>()V

    .line 68
    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->ratingKey:Ljava/lang/String;

    .line 69
    const-string v0, "Value"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->value:I

    .line 70
    const-string v0, "ValueLabel"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->valueLabel:Ljava/lang/String;

    .line 71
    const-string v0, "MaxLabel"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->maxLabel:Ljava/lang/String;

    .line 72
    const-string v0, "Label"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->label:Ljava/lang/String;

    .line 73
    const-string v0, "Id"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->id:Ljava/lang/String;

    .line 74
    const-string v0, "ValueRange"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    iput v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->valueRange:I

    .line 75
    const-string v0, "MinLabel"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->minLabel:Ljava/lang/String;

    .line 76
    const-string v0, "DisplayType"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->displayType:Ljava/lang/String;

    .line 77
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 63
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 80
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getDisplayType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->displayType:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->maxLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getMinLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->minLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->ratingKey:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->value:I

    return v0
.end method

.method public getValueLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->valueLabel:Ljava/lang/String;

    return-object v0
.end method

.method public getValueRange()I
    .locals 1

    .prologue
    .line 50
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/SecondaryRating;->valueRange:I

    return v0
.end method
