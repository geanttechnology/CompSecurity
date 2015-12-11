.class public Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x7882004daefe966aL


# instance fields
.field private averageRating:Lcom/bestbuy/android/api/lib/models/home/AverageRating;

.field private averageWouldRecommend:Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;

.field private mdotUrl:Ljava/lang/String;

.field private starRatingBreakdown:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;",
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
.method public getAverageRating()Lcom/bestbuy/android/api/lib/models/home/AverageRating;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->averageRating:Lcom/bestbuy/android/api/lib/models/home/AverageRating;

    return-object v0
.end method

.method public getAverageWouldRecommend()Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->averageWouldRecommend:Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;

    return-object v0
.end method

.method public getMdotUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->mdotUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getStarRatingBreakdown()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->starRatingBreakdown:Ljava/util/List;

    return-object v0
.end method

.method public getTotalCount()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->totalCount:I

    return v0
.end method

.method public setAverageRating(Lcom/bestbuy/android/api/lib/models/home/AverageRating;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->averageRating:Lcom/bestbuy/android/api/lib/models/home/AverageRating;

    .line 44
    return-void
.end method

.method public setAverageWouldRecommend(Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->averageWouldRecommend:Lcom/bestbuy/android/api/lib/models/home/AverageWouldRecommend;

    .line 56
    return-void
.end method

.method public setMdotUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->mdotUrl:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setStarRatingBreakdown(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->starRatingBreakdown:Ljava/util/List;

    .line 68
    return-void
.end method

.method public setTotalCount(I)V
    .locals 0

    .prologue
    .line 79
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;->totalCount:I

    .line 80
    return-void
.end method
