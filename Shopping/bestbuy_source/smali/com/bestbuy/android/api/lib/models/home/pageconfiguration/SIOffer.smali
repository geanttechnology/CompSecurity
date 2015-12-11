.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


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
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getSerialVersionUID()J
    .locals 2

    .prologue
    .line 108
    const-wide/16 v0, 0x1

    return-wide v0
.end method


# virtual methods
.method public getLid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->lid:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferImage()Lcom/bestbuy/android/api/lib/models/home/OfferImage;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->offerImage:Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    return-object v0
.end method

.method public getOfferTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->offerTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->offerType:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->price:Lcom/bestbuy/android/api/lib/models/home/Price;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setLid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->lid:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setOfferImage(Lcom/bestbuy/android/api/lib/models/home/OfferImage;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->offerImage:Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    .line 89
    return-void
.end method

.method public setOfferTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->offerTitle:Ljava/lang/String;

    .line 97
    return-void
.end method

.method public setOfferType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->offerType:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setPrice(Lcom/bestbuy/android/api/lib/models/home/Price;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->price:Lcom/bestbuy/android/api/lib/models/home/Price;

    .line 105
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 81
    return-void
.end method

.method public setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    .line 75
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->url:Ljava/lang/String;

    .line 117
    return-void
.end method
