.class public Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private fieldName:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private label:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadAdditionalFieldData(Lorg/json/JSONObject;Ljava/util/ArrayList;)Ljava/util/ArrayList;
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
            "Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 37
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 38
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 39
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 40
    if-eqz v3, :cond_0

    .line 41
    new-instance v4, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;-><init>()V

    .line 42
    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->fieldName:Ljava/lang/String;

    .line 43
    const-string v0, "Label"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->label:Ljava/lang/String;

    .line 44
    const-string v0, "Id"

    invoke-virtual {v3, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v4, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->id:Ljava/lang/String;

    .line 45
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 37
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 48
    :cond_1
    return-object v2
.end method


# virtual methods
.method public getFieldName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->fieldName:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->label:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/reviews/AdditionalField;->value:Ljava/lang/String;

    return-object v0
.end method
