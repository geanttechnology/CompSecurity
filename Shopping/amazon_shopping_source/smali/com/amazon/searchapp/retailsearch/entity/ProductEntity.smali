.class public Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ProductEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Product;


# instance fields
.field private actors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;"
        }
    .end annotation
.end field

.field private ageRange:Ljava/lang/String;

.field private altImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation
.end field

.field private asin:Ljava/lang/String;

.field private audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

.field private authors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;"
        }
    .end annotation
.end field

.field private availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

.field private bestSeller:Lcom/amazon/searchapp/retailsearch/model/BestSeller;

.field private brandName:Ljava/lang/String;

.field private byLine:Ljava/lang/String;

.field private closedCaption:Z

.field private directors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;"
        }
    .end annotation
.end field

.field private dynamicContent:Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;

.field private group:Ljava/lang/String;

.field private heroASIN:Z

.field private hidden:Lcom/amazon/searchapp/retailsearch/model/Hidden;

.field private hideAdultProduct:Z

.field private htmlMessage:Ljava/lang/String;

.field private icons:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/WebIcon;",
            ">;"
        }
    .end annotation
.end field

.field private image:Lcom/amazon/searchapp/retailsearch/model/Image;

.field private imageGallery:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation
.end field

.field private issueInfo:Ljava/lang/String;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private merchant:Lcom/amazon/searchapp/retailsearch/model/Merchant;

.field private movie:Lcom/amazon/searchapp/retailsearch/model/Movie;

.field private newerVersion:Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

.field private nonPrimeOffer:Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;

.field private offerId:Ljava/lang/String;

.field private pantryBoxFill:Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;

.field private points:Lcom/amazon/searchapp/retailsearch/model/Points;

.field private position:I

.field private prices:Lcom/amazon/searchapp/retailsearch/model/Prices;

.field private promotions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Promotion;",
            ">;"
        }
    .end annotation
.end field

.field private ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

.field private releaseDate:Ljava/lang/String;

.field private shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

.field private synopsis:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private tradeIn:Lcom/amazon/searchapp/retailsearch/model/TradeIn;

.field private truncatedTitle:Ljava/lang/String;

.field private tvSeasonAsin:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private typeName:Ljava/lang/String;

.field private unsupportedMessage:Ljava/lang/String;

.field private variations:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Variation;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getActors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 575
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->actors:Ljava/util/List;

    return-object v0
.end method

.method public getAgeRange()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1015
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->ageRange:Ljava/lang/String;

    return-object v0
.end method

.method public getAltImages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation

    .prologue
    .line 875
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->altImages:Ljava/util/List;

    return-object v0
.end method

.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 415
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getAudienceRating()Lcom/amazon/searchapp/retailsearch/model/AudienceRating;
    .locals 1

    .prologue
    .line 695
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    return-object v0
.end method

.method public getAuthors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 255
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->authors:Ljava/util/List;

    return-object v0
.end method

.method public getAvailability()Lcom/amazon/searchapp/retailsearch/model/Availability;
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

    return-object v0
.end method

.method public getBestSeller()Lcom/amazon/searchapp/retailsearch/model/BestSeller;
    .locals 1

    .prologue
    .line 715
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->bestSeller:Lcom/amazon/searchapp/retailsearch/model/BestSeller;

    return-object v0
.end method

.method public getBrandName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 555
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->brandName:Ljava/lang/String;

    return-object v0
.end method

.method public getByLine()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->byLine:Ljava/lang/String;

    return-object v0
.end method

.method public getClosedCaption()Z
    .locals 1

    .prologue
    .line 495
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->closedCaption:Z

    return v0
.end method

.method public getDirectors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 975
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->directors:Ljava/util/List;

    return-object v0
.end method

.method public getDynamicContent()Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;
    .locals 1

    .prologue
    .line 1055
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->dynamicContent:Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;

    return-object v0
.end method

.method public getGroup()Ljava/lang/String;
    .locals 1

    .prologue
    .line 435
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->group:Ljava/lang/String;

    return-object v0
.end method

.method public getHeroASIN()Z
    .locals 1

    .prologue
    .line 935
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->heroASIN:Z

    return v0
.end method

.method public getHidden()Lcom/amazon/searchapp/retailsearch/model/Hidden;
    .locals 1

    .prologue
    .line 595
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->hidden:Lcom/amazon/searchapp/retailsearch/model/Hidden;

    return-object v0
.end method

.method public getHideAdultProduct()Z
    .locals 1

    .prologue
    .line 195
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->hideAdultProduct:Z

    return v0
.end method

.method public getHtmlMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 755
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->htmlMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getIcons()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/WebIcon;",
            ">;"
        }
    .end annotation

    .prologue
    .line 895
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->icons:Ljava/util/List;

    return-object v0
.end method

.method public getImage()Lcom/amazon/searchapp/retailsearch/model/Image;
    .locals 1

    .prologue
    .line 635
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->image:Lcom/amazon/searchapp/retailsearch/model/Image;

    return-object v0
.end method

.method public getImageGallery()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;"
        }
    .end annotation

    .prologue
    .line 355
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->imageGallery:Ljava/util/List;

    return-object v0
.end method

.method public getIssueInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->issueInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 735
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getMerchant()Lcom/amazon/searchapp/retailsearch/model/Merchant;
    .locals 1

    .prologue
    .line 655
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->merchant:Lcom/amazon/searchapp/retailsearch/model/Merchant;

    return-object v0
.end method

.method public getMovie()Lcom/amazon/searchapp/retailsearch/model/Movie;
    .locals 1

    .prologue
    .line 475
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->movie:Lcom/amazon/searchapp/retailsearch/model/Movie;

    return-object v0
.end method

.method public getNewerVersion()Lcom/amazon/searchapp/retailsearch/model/NewerVersion;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->newerVersion:Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

    return-object v0
.end method

.method public getNonPrimeOffer()Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;
    .locals 1

    .prologue
    .line 835
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->nonPrimeOffer:Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPantryBoxFill()Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;
    .locals 1

    .prologue
    .line 795
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->pantryBoxFill:Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;

    return-object v0
.end method

.method public getPoints()Lcom/amazon/searchapp/retailsearch/model/Points;
    .locals 1

    .prologue
    .line 995
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->points:Lcom/amazon/searchapp/retailsearch/model/Points;

    return-object v0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 1035
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->position:I

    return v0
.end method

.method public getPrices()Lcom/amazon/searchapp/retailsearch/model/Prices;
    .locals 1

    .prologue
    .line 775
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->prices:Lcom/amazon/searchapp/retailsearch/model/Prices;

    return-object v0
.end method

.method public getPromotions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Promotion;",
            ">;"
        }
    .end annotation

    .prologue
    .line 815
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->promotions:Ljava/util/List;

    return-object v0
.end method

.method public getRatings()Lcom/amazon/searchapp/retailsearch/model/Ratings;
    .locals 1

    .prologue
    .line 675
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    return-object v0
.end method

.method public getReleaseDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->releaseDate:Ljava/lang/String;

    return-object v0
.end method

.method public getShipping()Lcom/amazon/searchapp/retailsearch/model/Shipping;
    .locals 1

    .prologue
    .line 955
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    return-object v0
.end method

.method public getSynopsis()Ljava/lang/String;
    .locals 1

    .prologue
    .line 535
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->synopsis:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 455
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTradeIn()Lcom/amazon/searchapp/retailsearch/model/TradeIn;
    .locals 1

    .prologue
    .line 515
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->tradeIn:Lcom/amazon/searchapp/retailsearch/model/TradeIn;

    return-object v0
.end method

.method public getTruncatedTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->truncatedTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getTvSeasonAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->tvSeasonAsin:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 615
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getTypeName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->typeName:Ljava/lang/String;

    return-object v0
.end method

.method public getUnsupportedMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 855
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->unsupportedMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getVariations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Variation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 915
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->variations:Ljava/util/List;

    return-object v0
.end method

.method public setActors(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 585
    .local p1, "actors":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Contributor;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->actors:Ljava/util/List;

    .line 586
    return-void
.end method

.method public setAgeRange(Ljava/lang/String;)V
    .locals 0
    .param p1, "ageRange"    # Ljava/lang/String;

    .prologue
    .line 1025
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->ageRange:Ljava/lang/String;

    .line 1026
    return-void
.end method

.method public setAltImages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 885
    .local p1, "altImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Image;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->altImages:Ljava/util/List;

    .line 886
    return-void
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 425
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->asin:Ljava/lang/String;

    .line 426
    return-void
.end method

.method public setAudienceRating(Lcom/amazon/searchapp/retailsearch/model/AudienceRating;)V
    .locals 0
    .param p1, "audienceRating"    # Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    .prologue
    .line 705
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->audienceRating:Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    .line 706
    return-void
.end method

.method public setAuthors(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 265
    .local p1, "authors":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Contributor;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->authors:Ljava/util/List;

    .line 266
    return-void
.end method

.method public setAvailability(Lcom/amazon/searchapp/retailsearch/model/Availability;)V
    .locals 0
    .param p1, "availability"    # Lcom/amazon/searchapp/retailsearch/model/Availability;

    .prologue
    .line 405
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->availability:Lcom/amazon/searchapp/retailsearch/model/Availability;

    .line 406
    return-void
.end method

.method public setBestSeller(Lcom/amazon/searchapp/retailsearch/model/BestSeller;)V
    .locals 0
    .param p1, "bestSeller"    # Lcom/amazon/searchapp/retailsearch/model/BestSeller;

    .prologue
    .line 725
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->bestSeller:Lcom/amazon/searchapp/retailsearch/model/BestSeller;

    .line 726
    return-void
.end method

.method public setBrandName(Ljava/lang/String;)V
    .locals 0
    .param p1, "brandName"    # Ljava/lang/String;

    .prologue
    .line 565
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->brandName:Ljava/lang/String;

    .line 566
    return-void
.end method

.method public setByLine(Ljava/lang/String;)V
    .locals 0
    .param p1, "byLine"    # Ljava/lang/String;

    .prologue
    .line 185
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->byLine:Ljava/lang/String;

    .line 186
    return-void
.end method

.method public setClosedCaption(Z)V
    .locals 0
    .param p1, "closedCaption"    # Z

    .prologue
    .line 505
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->closedCaption:Z

    .line 506
    return-void
.end method

.method public setDirectors(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Contributor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 985
    .local p1, "directors":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Contributor;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->directors:Ljava/util/List;

    .line 986
    return-void
.end method

.method public setDynamicContent(Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;)V
    .locals 0
    .param p1, "dynamicContent"    # Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;

    .prologue
    .line 1065
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->dynamicContent:Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;

    .line 1066
    return-void
.end method

.method public setGroup(Ljava/lang/String;)V
    .locals 0
    .param p1, "group"    # Ljava/lang/String;

    .prologue
    .line 445
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->group:Ljava/lang/String;

    .line 446
    return-void
.end method

.method public setHeroASIN(Z)V
    .locals 0
    .param p1, "heroASIN"    # Z

    .prologue
    .line 945
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->heroASIN:Z

    .line 946
    return-void
.end method

.method public setHidden(Lcom/amazon/searchapp/retailsearch/model/Hidden;)V
    .locals 0
    .param p1, "hidden"    # Lcom/amazon/searchapp/retailsearch/model/Hidden;

    .prologue
    .line 605
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->hidden:Lcom/amazon/searchapp/retailsearch/model/Hidden;

    .line 606
    return-void
.end method

.method public setHideAdultProduct(Z)V
    .locals 0
    .param p1, "hideAdultProduct"    # Z

    .prologue
    .line 205
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->hideAdultProduct:Z

    .line 206
    return-void
.end method

.method public setHtmlMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "htmlMessage"    # Ljava/lang/String;

    .prologue
    .line 765
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->htmlMessage:Ljava/lang/String;

    .line 766
    return-void
.end method

.method public setIcons(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/WebIcon;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 905
    .local p1, "icons":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/WebIcon;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->icons:Ljava/util/List;

    .line 906
    return-void
.end method

.method public setImage(Lcom/amazon/searchapp/retailsearch/model/Image;)V
    .locals 0
    .param p1, "image"    # Lcom/amazon/searchapp/retailsearch/model/Image;

    .prologue
    .line 645
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->image:Lcom/amazon/searchapp/retailsearch/model/Image;

    .line 646
    return-void
.end method

.method public setImageGallery(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Image;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 365
    .local p1, "imageGallery":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Image;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->imageGallery:Ljava/util/List;

    .line 366
    return-void
.end method

.method public setIssueInfo(Ljava/lang/String;)V
    .locals 0
    .param p1, "issueInfo"    # Ljava/lang/String;

    .prologue
    .line 385
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->issueInfo:Ljava/lang/String;

    .line 386
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 745
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 746
    return-void
.end method

.method public setMerchant(Lcom/amazon/searchapp/retailsearch/model/Merchant;)V
    .locals 0
    .param p1, "merchant"    # Lcom/amazon/searchapp/retailsearch/model/Merchant;

    .prologue
    .line 665
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->merchant:Lcom/amazon/searchapp/retailsearch/model/Merchant;

    .line 666
    return-void
.end method

.method public setMovie(Lcom/amazon/searchapp/retailsearch/model/Movie;)V
    .locals 0
    .param p1, "movie"    # Lcom/amazon/searchapp/retailsearch/model/Movie;

    .prologue
    .line 485
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->movie:Lcom/amazon/searchapp/retailsearch/model/Movie;

    .line 486
    return-void
.end method

.method public setNewerVersion(Lcom/amazon/searchapp/retailsearch/model/NewerVersion;)V
    .locals 0
    .param p1, "newerVersion"    # Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

    .prologue
    .line 285
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->newerVersion:Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

    .line 286
    return-void
.end method

.method public setNonPrimeOffer(Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;)V
    .locals 0
    .param p1, "nonPrimeOffer"    # Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;

    .prologue
    .line 845
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->nonPrimeOffer:Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;

    .line 846
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "offerId"    # Ljava/lang/String;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->offerId:Ljava/lang/String;

    .line 306
    return-void
.end method

.method public setPantryBoxFill(Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;)V
    .locals 0
    .param p1, "pantryBoxFill"    # Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;

    .prologue
    .line 805
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->pantryBoxFill:Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;

    .line 806
    return-void
.end method

.method public setPoints(Lcom/amazon/searchapp/retailsearch/model/Points;)V
    .locals 0
    .param p1, "points"    # Lcom/amazon/searchapp/retailsearch/model/Points;

    .prologue
    .line 1005
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->points:Lcom/amazon/searchapp/retailsearch/model/Points;

    .line 1006
    return-void
.end method

.method public setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 1045
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->position:I

    .line 1046
    return-void
.end method

.method public setPrices(Lcom/amazon/searchapp/retailsearch/model/Prices;)V
    .locals 0
    .param p1, "prices"    # Lcom/amazon/searchapp/retailsearch/model/Prices;

    .prologue
    .line 785
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->prices:Lcom/amazon/searchapp/retailsearch/model/Prices;

    .line 786
    return-void
.end method

.method public setPromotions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Promotion;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 825
    .local p1, "promotions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Promotion;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->promotions:Ljava/util/List;

    .line 826
    return-void
.end method

.method public setRatings(Lcom/amazon/searchapp/retailsearch/model/Ratings;)V
    .locals 0
    .param p1, "ratings"    # Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .prologue
    .line 685
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->ratings:Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .line 686
    return-void
.end method

.method public setReleaseDate(Ljava/lang/String;)V
    .locals 0
    .param p1, "releaseDate"    # Ljava/lang/String;

    .prologue
    .line 325
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->releaseDate:Ljava/lang/String;

    .line 326
    return-void
.end method

.method public setShipping(Lcom/amazon/searchapp/retailsearch/model/Shipping;)V
    .locals 0
    .param p1, "shipping"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 965
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->shipping:Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .line 966
    return-void
.end method

.method public setSynopsis(Ljava/lang/String;)V
    .locals 0
    .param p1, "synopsis"    # Ljava/lang/String;

    .prologue
    .line 545
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->synopsis:Ljava/lang/String;

    .line 546
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 465
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->title:Ljava/lang/String;

    .line 466
    return-void
.end method

.method public setTradeIn(Lcom/amazon/searchapp/retailsearch/model/TradeIn;)V
    .locals 0
    .param p1, "tradeIn"    # Lcom/amazon/searchapp/retailsearch/model/TradeIn;

    .prologue
    .line 525
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->tradeIn:Lcom/amazon/searchapp/retailsearch/model/TradeIn;

    .line 526
    return-void
.end method

.method public setTruncatedTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "truncatedTitle"    # Ljava/lang/String;

    .prologue
    .line 245
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->truncatedTitle:Ljava/lang/String;

    .line 246
    return-void
.end method

.method public setTvSeasonAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "tvSeasonAsin"    # Ljava/lang/String;

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->tvSeasonAsin:Ljava/lang/String;

    .line 226
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 625
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->type:Ljava/lang/String;

    .line 626
    return-void
.end method

.method public setTypeName(Ljava/lang/String;)V
    .locals 0
    .param p1, "typeName"    # Ljava/lang/String;

    .prologue
    .line 345
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->typeName:Ljava/lang/String;

    .line 346
    return-void
.end method

.method public setUnsupportedMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "unsupportedMessage"    # Ljava/lang/String;

    .prologue
    .line 865
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->unsupportedMessage:Ljava/lang/String;

    .line 866
    return-void
.end method

.method public setVariations(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Variation;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 925
    .local p1, "variations":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/Variation;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->variations:Ljava/util/List;

    .line 926
    return-void
.end method
