.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;
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
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;",
            ">;"
        }
    .end annotation
.end field

.field private averageRating:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

.field private mdotUrl:Ljava/lang/String;

.field private starRatingBreakdown:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;",
            ">;"
        }
    .end annotation
.end field

.field private totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
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
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->averageFeatureRating:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->averageRating:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    return-object v0
.end method

.method public getMdotUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->mdotUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getStarRatingBreakdown()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->starRatingBreakdown:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->totalCount:I

    return v0
.end method

.method public setAverageFeatureRating(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->averageFeatureRating:Ljava/util/ArrayList;

    .line 83
    return-void
.end method

.method public setAverageRating(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->averageRating:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    .line 91
    return-void
.end method

.method public setMdotUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->mdotUrl:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setStarRatingBreakdown(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->starRatingBreakdown:Ljava/util/ArrayList;

    .line 74
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0

    .prologue
    .line 65
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->totalCount:I

    .line 66
    return-void
.end method
