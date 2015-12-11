.class public Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private correctedQuery:Ljava/lang/String;

.field private correctlySpelled:Z

.field private didYouMean:Ljava/lang/String;

.field private showingResultsFor:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCorrectedQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->correctedQuery:Ljava/lang/String;

    return-object v0
.end method

.method public getDidYouMean()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->didYouMean:Ljava/lang/String;

    return-object v0
.end method

.method public getShowingResultsFor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->showingResultsFor:Ljava/lang/String;

    return-object v0
.end method

.method public isCorrectlySpelled()Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->correctlySpelled:Z

    return v0
.end method

.method public setCorrectedQuery(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->correctedQuery:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setCorrectlySpelled(Z)V
    .locals 0

    .prologue
    .line 52
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->correctlySpelled:Z

    .line 53
    return-void
.end method

.method public setDidYouMean(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->didYouMean:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setShowingResultsFor(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/SuggestQueryInfo;->showingResultsFor:Ljava/lang/String;

    .line 71
    return-void
.end method
