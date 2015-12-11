.class public Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private active:Z

.field private attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

.field private availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

.field private bonusContent:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;",
            ">;"
        }
    .end annotation
.end field

.field private brand:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

.field private brandClass:Lcom/bestbuy/android/api/lib/models/home/BrandClass;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "class"
    .end annotation
.end field

.field private breadcrumb:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;",
            ">;"
        }
    .end annotation
.end field

.field private bundleItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;",
            ">;"
        }
    .end annotation
.end field

.field private castAndCrew:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

.field private categories:Lcom/bestbuy/android/api/lib/models/pdp/Categories;

.field private color:Lcom/bestbuy/android/api/lib/models/pdp/ProductColor;

.field private condition:Ljava/lang/String;

.field private customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

.field private dates:Lcom/bestbuy/android/api/lib/models/pdp/Dates;

.field private department:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

.field private descriptions:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

.field private episodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/episodes/Episode;",
            ">;"
        }
    .end annotation
.end field

.field private esrbRating:Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;

.field private features:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Feature;",
            ">;"
        }
    .end annotation
.end field

.field private gameDetails:Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

.field private includedItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/IncludedItem;",
            ">;"
        }
    .end annotation
.end field

.field private manufacturerId:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

.field private media:Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

.field private meta:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;

.field private movieDetails:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

.field private movieRatings:Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

.field private musicResponse:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

.field private names:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private productFamily:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;",
            ">;"
        }
    .end annotation
.end field

.field private productId:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private properties:Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

.field private protectionServiceMatrix:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

.field private restrictedPriceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private services:Lcom/bestbuy/android/api/lib/models/pdp/Services;

.field private skuId:Ljava/lang/String;

.field private softwareDetails:Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

.field private specialFeatures:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation
.end field

.field private specifications:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation
.end field

.field private subSections:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/SubSection;",
            ">;"
        }
    .end annotation
.end field

.field private subclass:Lcom/bestbuy/android/api/lib/models/home/SubClass;

.field private trackInfo:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;",
            ">;"
        }
    .end annotation
.end field

.field private upc:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public Availability(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    .line 330
    return-void
.end method

.method public getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    return-object v0
.end method

.method public getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    return-object v0
.end method

.method public getBonusContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 429
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->bonusContent:Ljava/util/List;

    return-object v0
.end method

.method public getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->brand:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    return-object v0
.end method

.method public getBrandClass()Lcom/bestbuy/android/api/lib/models/home/BrandClass;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->brandClass:Lcom/bestbuy/android/api/lib/models/home/BrandClass;

    return-object v0
.end method

.method public getBreadcrumb()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->breadcrumb:Ljava/util/List;

    return-object v0
.end method

.method public getBundleItems()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->bundleItems:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;
    .locals 1

    .prologue
    .line 405
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->castAndCrew:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    return-object v0
.end method

.method public getCategories()Lcom/bestbuy/android/api/lib/models/pdp/Categories;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->categories:Lcom/bestbuy/android/api/lib/models/pdp/Categories;

    return-object v0
.end method

.method public getColor()Lcom/bestbuy/android/api/lib/models/pdp/ProductColor;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->color:Lcom/bestbuy/android/api/lib/models/pdp/ProductColor;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    return-object v0
.end method

.method public getDates()Lcom/bestbuy/android/api/lib/models/pdp/Dates;
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->dates:Lcom/bestbuy/android/api/lib/models/pdp/Dates;

    return-object v0
.end method

.method public getDepartment()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->department:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

    return-object v0
.end method

.method public getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->descriptions:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    return-object v0
.end method

.method public getEpisodesList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/episodes/Episode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 401
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->episodes:Ljava/util/List;

    return-object v0
.end method

.method public getEsrbRating()Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;
    .locals 1

    .prologue
    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->esrbRating:Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;

    return-object v0
.end method

.method public getFeatures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Feature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->features:Ljava/util/List;

    return-object v0
.end method

.method public getGameDetails()Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->gameDetails:Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

    return-object v0
.end method

.method public getIncludedItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/IncludedItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->includedItems:Ljava/util/List;

    return-object v0
.end method

.method public getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->manufacturerId:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    return-object v0
.end method

.method public getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->media:Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    return-object v0
.end method

.method public getMeta()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->meta:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;

    return-object v0
.end method

.method public getMovieDetails()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->movieDetails:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    return-object v0
.end method

.method public getMovieRatings()Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;
    .locals 1

    .prologue
    .line 341
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->movieRatings:Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    return-object v0
.end method

.method public getMusicResponse()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;
    .locals 1

    .prologue
    .line 421
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->musicResponse:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->names:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getProductFamily()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;",
            ">;"
        }
    .end annotation

    .prologue
    .line 373
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->productFamily:Ljava/util/List;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->properties:Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    return-object v0
.end method

.method public getProtectionServiceMatrix()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;
    .locals 1

    .prologue
    .line 413
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->protectionServiceMatrix:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    return-object v0
.end method

.method public getRestrictedPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 437
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->restrictedPriceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getServices()Lcom/bestbuy/android/api/lib/models/pdp/Services;
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->services:Lcom/bestbuy/android/api/lib/models/pdp/Services;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSoftwareDetails()Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;
    .locals 1

    .prologue
    .line 349
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->softwareDetails:Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

    return-object v0
.end method

.method public getSpecialFeatures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->specialFeatures:Ljava/util/List;

    return-object v0
.end method

.method public getSpecifications()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->specifications:Ljava/util/List;

    return-object v0
.end method

.method public getSubSections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/SubSection;",
            ">;"
        }
    .end annotation

    .prologue
    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->subSections:Ljava/util/List;

    return-object v0
.end method

.method public getSubclass()Lcom/bestbuy/android/api/lib/models/home/SubClass;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->subclass:Lcom/bestbuy/android/api/lib/models/home/SubClass;

    return-object v0
.end method

.method public getTrackInfo()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 381
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->trackInfo:Ljava/util/List;

    return-object v0
.end method

.method public getUpc()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->upc:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->active:Z

    return v0
.end method

.method public setActive(Z)V
    .locals 0

    .prologue
    .line 113
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->active:Z

    .line 114
    return-void
.end method

.method public setAttributes(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    .line 122
    return-void
.end method

.method public setBonusContent(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BonusContent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 433
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->bonusContent:Ljava/util/List;

    .line 434
    return-void
.end method

.method public setBrand(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->brand:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    .line 130
    return-void
.end method

.method public setBrandClass(Lcom/bestbuy/android/api/lib/models/home/BrandClass;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->brandClass:Lcom/bestbuy/android/api/lib/models/home/BrandClass;

    .line 138
    return-void
.end method

.method public setBreadcrumb(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 145
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->breadcrumb:Ljava/util/List;

    .line 146
    return-void
.end method

.method public setBundleItems(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->bundleItems:Ljava/util/ArrayList;

    .line 98
    return-void
.end method

.method public setCastAndCrew(Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;)V
    .locals 0

    .prologue
    .line 409
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->castAndCrew:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    .line 410
    return-void
.end method

.method public setCategories(Lcom/bestbuy/android/api/lib/models/pdp/Categories;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->categories:Lcom/bestbuy/android/api/lib/models/pdp/Categories;

    .line 154
    return-void
.end method

.method public setColor(Lcom/bestbuy/android/api/lib/models/pdp/ProductColor;)V
    .locals 0

    .prologue
    .line 337
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->color:Lcom/bestbuy/android/api/lib/models/pdp/ProductColor;

    .line 338
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->condition:Ljava/lang/String;

    .line 162
    return-void
.end method

.method public setCustomerRatings(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    .line 170
    return-void
.end method

.method public setDates(Lcom/bestbuy/android/api/lib/models/pdp/Dates;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->dates:Lcom/bestbuy/android/api/lib/models/pdp/Dates;

    .line 370
    return-void
.end method

.method public setDepartment(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->department:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

    .line 178
    return-void
.end method

.method public setDescriptions(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;)V
    .locals 0

    .prologue
    .line 185
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->descriptions:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    .line 186
    return-void
.end method

.method public setEpisodesList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/episodes/Episode;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 397
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->episodes:Ljava/util/List;

    .line 398
    return-void
.end method

.method public setEsrbRating(Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;)V
    .locals 0

    .prologue
    .line 361
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->esrbRating:Lcom/bestbuy/android/api/lib/models/pdp/ESRBRating;

    .line 362
    return-void
.end method

.method public setFeatures(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Feature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 193
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->features:Ljava/util/List;

    .line 194
    return-void
.end method

.method public setGameDetails(Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->gameDetails:Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

    .line 106
    return-void
.end method

.method public setIncludedItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/IncludedItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 201
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->includedItems:Ljava/util/List;

    .line 202
    return-void
.end method

.method public setManufacturerId(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;)V
    .locals 0

    .prologue
    .line 209
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->manufacturerId:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    .line 210
    return-void
.end method

.method public setMedia(Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;)V
    .locals 0

    .prologue
    .line 217
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->media:Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    .line 218
    return-void
.end method

.method public setMeta(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->meta:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;

    .line 226
    return-void
.end method

.method public setMovieDetails(Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;)V
    .locals 0

    .prologue
    .line 393
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->movieDetails:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    .line 394
    return-void
.end method

.method public setMovieRatings(Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;)V
    .locals 0

    .prologue
    .line 345
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->movieRatings:Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    .line 346
    return-void
.end method

.method public setMusicResponse(Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;)V
    .locals 0

    .prologue
    .line 425
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->musicResponse:Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    .line 426
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;)V
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->names:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    .line 234
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 241
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 242
    return-void
.end method

.method public setProductFamily(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 377
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->productFamily:Ljava/util/List;

    .line 378
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->productId:Ljava/lang/String;

    .line 250
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 257
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->productType:Ljava/lang/String;

    .line 258
    return-void
.end method

.method public setProperties(Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;)V
    .locals 0

    .prologue
    .line 265
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->properties:Lcom/bestbuy/android/api/lib/models/pdpmusic/Properties;

    .line 266
    return-void
.end method

.method public setProtectionServiceMatrix(Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;)V
    .locals 0

    .prologue
    .line 417
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->protectionServiceMatrix:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionServiceMatrix;

    .line 418
    return-void
.end method

.method public setRestrictedPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 441
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->restrictedPriceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 442
    return-void
.end method

.method public setServices(Lcom/bestbuy/android/api/lib/models/pdp/Services;)V
    .locals 0

    .prologue
    .line 273
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->services:Lcom/bestbuy/android/api/lib/models/pdp/Services;

    .line 274
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 281
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->skuId:Ljava/lang/String;

    .line 282
    return-void
.end method

.method public setSoftwareDetails(Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;)V
    .locals 0

    .prologue
    .line 353
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->softwareDetails:Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

    .line 354
    return-void
.end method

.method public setSpecialFeatures(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 89
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->specialFeatures:Ljava/util/List;

    .line 90
    return-void
.end method

.method public setSpecifications(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 289
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->specifications:Ljava/util/List;

    .line 290
    return-void
.end method

.method public setSubSections(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/SubSection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 305
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->subSections:Ljava/util/List;

    .line 306
    return-void
.end method

.method public setSubclass(Lcom/bestbuy/android/api/lib/models/home/SubClass;)V
    .locals 0

    .prologue
    .line 297
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->subclass:Lcom/bestbuy/android/api/lib/models/home/SubClass;

    .line 298
    return-void
.end method

.method public setTrackInfo(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/TrackInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 385
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->trackInfo:Ljava/util/List;

    .line 386
    return-void
.end method

.method public setUpc(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->upc:Ljava/lang/String;

    .line 314
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->url:Ljava/lang/String;

    .line 322
    return-void
.end method
