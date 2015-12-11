.class public Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;
.super Ljava/lang/Object;
.source "CustomerReviewsInfo.java"


# instance fields
.field private fiveStarCount:I

.field private fourStarCount:I

.field private oneStarCount:I

.field private reviews:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;",
            ">;"
        }
    .end annotation
.end field

.field private selectedSortType:Ljava/lang/String;

.field private selectedStarFilter:Ljava/lang/Integer;

.field private sortTypes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private threeStarCount:I

.field private twoStarCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setFiveStarCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 70
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->fiveStarCount:I

    .line 71
    return-void
.end method

.method public setFourStarCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 60
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->fourStarCount:I

    .line 61
    return-void
.end method

.method public setOneStarCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 30
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->oneStarCount:I

    .line 31
    return-void
.end method

.method public setReviews(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 80
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CustomerReview;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->reviews:Ljava/util/List;

    .line 81
    return-void
.end method

.method public setSelectedSortType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->selectedSortType:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setSelectedStarFilter(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->selectedStarFilter:Ljava/lang/Integer;

    .line 104
    return-void
.end method

.method public setSortTypes(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->sortTypes:Ljava/util/List;

    .line 91
    return-void
.end method

.method public setThreeStarCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 50
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->threeStarCount:I

    .line 51
    return-void
.end method

.method public setTwoStarCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 40
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerReviewsInfo;->twoStarCount:I

    .line 41
    return-void
.end method
