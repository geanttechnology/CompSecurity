.class public Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private averageRating:D

.field private bestFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;"
        }
    .end annotation
.end field

.field private overallScore:D

.field private percentPositive:D

.field private representativeQuotes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;",
            ">;"
        }
    .end annotation
.end field

.field private topRated:Z

.field private totalOpinions:I

.field private totalRatings:D

.field private worstFeatures:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAverageRating()D
    .locals 2

    .prologue
    .line 35
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->averageRating:D

    return-wide v0
.end method

.method public getBestFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->bestFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getOverallScore()D
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->overallScore:D

    return-wide v0
.end method

.method public getPercentPositive()D
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->percentPositive:D

    return-wide v0
.end method

.method public getRepresentativeQuotes()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->representativeQuotes:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalOpinions()I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->totalOpinions:I

    return v0
.end method

.method public getTotalRatings()D
    .locals 2

    .prologue
    .line 27
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->totalRatings:D

    return-wide v0
.end method

.method public getWorstFeatures()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->worstFeatures:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isTopRated()Z
    .locals 1

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->topRated:Z

    return v0
.end method

.method public setAverageRating(D)V
    .locals 1

    .prologue
    .line 39
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->averageRating:D

    .line 40
    return-void
.end method

.method public setBestFeatures(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->bestFeatures:Ljava/util/ArrayList;

    .line 88
    return-void
.end method

.method public setOverallScore(D)V
    .locals 1

    .prologue
    .line 63
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->overallScore:D

    .line 64
    return-void
.end method

.method public setPercentPositive(D)V
    .locals 1

    .prologue
    .line 55
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->percentPositive:D

    .line 56
    return-void
.end method

.method public setRepresentativeQuotes(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/RepresentativeQuotes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->representativeQuotes:Ljava/util/ArrayList;

    .line 80
    return-void
.end method

.method public setTopRated(Z)V
    .locals 0

    .prologue
    .line 71
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->topRated:Z

    .line 72
    return-void
.end method

.method public setTotalOpinions(I)V
    .locals 0

    .prologue
    .line 47
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->totalOpinions:I

    .line 48
    return-void
.end method

.method public setTotalRatings(D)V
    .locals 1

    .prologue
    .line 31
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->totalRatings:D

    .line 32
    return-void
.end method

.method public setWorstFeatures(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->worstFeatures:Ljava/util/ArrayList;

    .line 96
    return-void
.end method
