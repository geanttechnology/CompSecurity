.class public Lcom/bestbuy/android/api/lib/models/solr/Value;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private catPath:Ljava/lang/String;

.field private count:I

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/solr/Value;
    .locals 2

    .prologue
    .line 44
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/Value;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;-><init>()V

    .line 45
    const-string v1, "value"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/Value;->value:Ljava/lang/String;

    .line 46
    const-string v1, "count"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/solr/Value;->count:I

    .line 47
    const-string v1, "cat_path"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/Value;->catPath:Ljava/lang/String;

    .line 48
    return-object v0
.end method


# virtual methods
.method public getCatPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Value;->catPath:Ljava/lang/String;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Value;->count:I

    return v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/Value;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setCount(I)V
    .locals 0

    .prologue
    .line 41
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/solr/Value;->count:I

    .line 42
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/solr/Value;->value:Ljava/lang/String;

    .line 39
    return-void
.end method
