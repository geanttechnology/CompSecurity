.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private averageScore:D

.field private images:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;",
            ">;"
        }
    .end annotation
.end field

.field private ratingRangeMax:D

.field private sellerId:Ljava/lang/String;

.field private sellerName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "seller"
    .end annotation
.end field

.field private sellerUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAverageScore()D
    .locals 2

    .prologue
    .line 33
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->averageScore:D

    return-wide v0
.end method

.method public getImages()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->images:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getRatingRangeMax()D
    .locals 2

    .prologue
    .line 41
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->ratingRangeMax:D

    return-wide v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->sellerId:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->sellerName:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->sellerUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setAverageScore(D)V
    .locals 1

    .prologue
    .line 37
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->averageScore:D

    .line 38
    return-void
.end method

.method public setImages(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->images:Ljava/util/ArrayList;

    .line 62
    return-void
.end method

.method public setRatingRangeMax(D)V
    .locals 1

    .prologue
    .line 45
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->ratingRangeMax:D

    .line 46
    return-void
.end method

.method public setSellerId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->sellerId:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public setSellerName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->sellerName:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setSellerUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->sellerUrl:Ljava/lang/String;

    .line 54
    return-void
.end method
