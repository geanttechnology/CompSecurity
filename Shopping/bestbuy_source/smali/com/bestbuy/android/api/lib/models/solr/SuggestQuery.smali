.class public Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private correctedQuery:Ljava/lang/String;

.field private correctlySpelled:Z

.field private didYouMean:Ljava/lang/String;

.field private showingResultsFor:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;
    .locals 2

    .prologue
    .line 26
    new-instance v0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;-><init>()V

    .line 27
    const-string v1, "didYouMean"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->didYouMean:Ljava/lang/String;

    .line 28
    const-string v1, "showingResultsFor"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->showingResultsFor:Ljava/lang/String;

    .line 29
    const-string v1, "correctedQuery"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->correctedQuery:Ljava/lang/String;

    .line 30
    const-string v1, "correctlySpelled"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->correctlySpelled:Z

    .line 31
    return-object v0
.end method


# virtual methods
.method public getCorrectedQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->correctedQuery:Ljava/lang/String;

    return-object v0
.end method

.method public getDidYouMean()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->didYouMean:Ljava/lang/String;

    return-object v0
.end method

.method public getShowingResultsFor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->showingResultsFor:Ljava/lang/String;

    return-object v0
.end method

.method public isCorrectlySpelled()Z
    .locals 1

    .prologue
    .line 22
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/solr/SuggestQuery;->correctlySpelled:Z

    return v0
.end method
