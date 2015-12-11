.class public Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

.field private distilledReviewSummary:Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

.field private hasErrors:Z

.field private results:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
            ">;"
        }
    .end annotation
.end field

.field private totalResults:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    return-object v0
.end method

.method public getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->distilledReviewSummary:Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    return-object v0
.end method

.method public getResults()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->results:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalResults()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->totalResults:I

    return v0
.end method

.method public isHasErrors()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->hasErrors:Z

    return v0
.end method

.method public setCustomerRatings(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    .line 36
    return-void
.end method

.method public setDistilledReviewSummary(Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;)V
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->distilledReviewSummary:Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    .line 28
    return-void
.end method

.method public setHasErrors(Z)V
    .locals 0

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->hasErrors:Z

    .line 44
    return-void
.end method

.method public setResults(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->results:Ljava/util/ArrayList;

    .line 52
    return-void
.end method

.method public setTotalResults(I)V
    .locals 0

    .prologue
    .line 59
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->totalResults:I

    .line 60
    return-void
.end method
