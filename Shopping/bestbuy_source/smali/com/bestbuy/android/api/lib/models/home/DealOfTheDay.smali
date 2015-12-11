.class public Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x36e144905f1d5085L


# instance fields
.field private lid:Ljava/lang/String;

.field private offerImage:Lcom/bestbuy/android/api/lib/models/home/OfferImage;

.field private offerTitle:Ljava/lang/String;

.field private offerType:Ljava/lang/String;

.field private price:Lcom/bestbuy/android/api/lib/models/home/Price;

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->lid:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferImage()Lcom/bestbuy/android/api/lib/models/home/OfferImage;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->offerImage:Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    return-object v0
.end method

.method public getOfferTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->offerTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->offerType:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->price:Lcom/bestbuy/android/api/lib/models/home/Price;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setLid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->lid:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setOfferImage(Lcom/bestbuy/android/api/lib/models/home/OfferImage;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->offerImage:Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    .line 107
    return-void
.end method

.method public setOfferTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->offerTitle:Ljava/lang/String;

    .line 113
    return-void
.end method

.method public setOfferType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->offerType:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setPrice(Lcom/bestbuy/android/api/lib/models/home/Price;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->price:Lcom/bestbuy/android/api/lib/models/home/Price;

    .line 119
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 77
    return-void
.end method

.method public setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    .line 71
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->url:Ljava/lang/String;

    .line 125
    return-void
.end method
