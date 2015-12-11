.class public Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private expandedFeature:Ljava/lang/String;

.field private feature:Ljava/lang/String;

.field private negativeReviewsMentioned:I

.field private percentPositive:D

.field private positiveReviewsMentioned:I

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

.field private reviewDetailUrl:Ljava/lang/String;

.field private score:D

.field private tags:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private totalMentions:I

.field private totalReviewsMentioned:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getExpandedFeature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->expandedFeature:Ljava/lang/String;

    return-object v0
.end method

.method public getFeature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->feature:Ljava/lang/String;

    return-object v0
.end method

.method public getNegativeReviewsMentioned()I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->negativeReviewsMentioned:I

    return v0
.end method

.method public getPercentPositive()D
    .locals 2

    .prologue
    .line 69
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->percentPositive:D

    return-wide v0
.end method

.method public getPositiveReviewsMentioned()I
    .locals 1

    .prologue
    .line 85
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->positiveReviewsMentioned:I

    return v0
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
    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->representativeQuotes:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getReviewDetailUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->reviewDetailUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 53
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->score:D

    return-wide v0
.end method

.method public getTags()Ljava/util/ArrayList;
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
    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->tags:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalMentions()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->totalMentions:I

    return v0
.end method

.method public getTotalReviewsMentioned()I
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->totalReviewsMentioned:I

    return v0
.end method

.method public setExpandedFeature(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->expandedFeature:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setFeature(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->feature:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setNegativeReviewsMentioned(I)V
    .locals 0

    .prologue
    .line 97
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->negativeReviewsMentioned:I

    .line 98
    return-void
.end method

.method public setPercentPositive(D)V
    .locals 1

    .prologue
    .line 73
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->percentPositive:D

    .line 74
    return-void
.end method

.method public setPositiveReviewsMentioned(I)V
    .locals 0

    .prologue
    .line 89
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->positiveReviewsMentioned:I

    .line 90
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
    .line 113
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->representativeQuotes:Ljava/util/ArrayList;

    .line 114
    return-void
.end method

.method public setReviewDetailUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->reviewDetailUrl:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setScore(D)V
    .locals 1

    .prologue
    .line 57
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->score:D

    .line 58
    return-void
.end method

.method public setTags(Ljava/util/ArrayList;)V
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
    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->tags:Ljava/util/ArrayList;

    .line 106
    return-void
.end method

.method public setTotalMentions(I)V
    .locals 0

    .prologue
    .line 65
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->totalMentions:I

    .line 66
    return-void
.end method

.method public setTotalReviewsMentioned(I)V
    .locals 0

    .prologue
    .line 81
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->totalReviewsMentioned:I

    .line 82
    return-void
.end method
