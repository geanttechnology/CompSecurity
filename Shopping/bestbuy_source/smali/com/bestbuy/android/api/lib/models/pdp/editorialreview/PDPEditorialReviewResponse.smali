.class public Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private editorialReviews:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/EditorialReview;",
            ">;"
        }
    .end annotation
.end field

.field private names:Lcom/bestbuy/android/api/lib/models/home/Names;

.field private productType:Ljava/lang/String;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEditorialReviews()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/EditorialReview;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->editorialReviews:Ljava/util/List;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/home/Names;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setEditorialReviews(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/EditorialReview;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->editorialReviews:Ljava/util/List;

    .line 51
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/home/Names;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    .line 43
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->productType:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/editorialreview/PDPEditorialReviewResponse;->skuId:Ljava/lang/String;

    .line 27
    return-void
.end method
