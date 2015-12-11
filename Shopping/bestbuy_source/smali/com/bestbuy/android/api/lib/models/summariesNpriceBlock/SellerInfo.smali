.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private averageScore:Ljava/lang/String;

.field private images:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/OfferImage;",
            ">;"
        }
    .end annotation
.end field

.field private numSellers:Ljava/lang/String;

.field private numSellersUrl:Ljava/lang/String;

.field private ratingRangeMax:Ljava/lang/String;

.field private ratingUrl:Ljava/lang/String;

.field private returnPolicyUrl:Ljava/lang/String;

.field private seller:Ljava/lang/String;

.field private sellerId:Ljava/lang/String;

.field private sellerUrl:Ljava/lang/String;

.field private shopSellerUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAverageScore()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->averageScore:Ljava/lang/String;

    return-object v0
.end method

.method public getImages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/OfferImage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->images:Ljava/util/List;

    return-object v0
.end method

.method public getNumSellers()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->numSellers:Ljava/lang/String;

    return-object v0
.end method

.method public getNumSellersUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->numSellersUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingRangeMax()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->ratingRangeMax:Ljava/lang/String;

    return-object v0
.end method

.method public getRatingUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->ratingUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getReturnPolicyUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->returnPolicyUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSeller()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->seller:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->sellerId:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->sellerUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getShopSellerUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->shopSellerUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setAverageScore(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->averageScore:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setImages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/OfferImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->images:Ljava/util/List;

    .line 63
    return-void
.end method

.method public setNumSellers(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->numSellers:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setNumSellersUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->numSellersUrl:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setRatingRangeMax(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->ratingRangeMax:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setRatingUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->ratingUrl:Ljava/lang/String;

    .line 95
    return-void
.end method

.method public setReturnPolicyUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->returnPolicyUrl:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setSeller(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->seller:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setSellerId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->sellerId:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setSellerUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->sellerUrl:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public setShopSellerUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 126
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->shopSellerUrl:Ljava/lang/String;

    .line 127
    return-void
.end method
