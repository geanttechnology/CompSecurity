.class public Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private averageFeatureRating:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;",
            ">;"
        }
    .end annotation
.end field

.field private averageRating:Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;

.field private starRatingBreakdown:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;",
            ">;"
        }
    .end annotation
.end field

.field private totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAverageFeatureRating()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->averageFeatureRating:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAverageRating()Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->averageRating:Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;

    return-object v0
.end method

.method public getStarRatingBreakdown()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->starRatingBreakdown:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->totalCount:I

    return v0
.end method

.method public setAverageFeatureRating(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->averageFeatureRating:Ljava/util/ArrayList;

    .line 26
    return-void
.end method

.method public setAverageRating(Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->averageRating:Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;

    .line 34
    return-void
.end method

.method public setStarRatingBreakdown(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->starRatingBreakdown:Ljava/util/ArrayList;

    .line 42
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0

    .prologue
    .line 49
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleCustomerRatings;->totalCount:I

    .line 50
    return-void
.end method
