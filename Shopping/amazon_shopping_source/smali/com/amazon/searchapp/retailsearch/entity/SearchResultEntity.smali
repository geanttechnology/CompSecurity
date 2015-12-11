.class public Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SearchResultEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SearchResult;


# instance fields
.field private breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

.field private correctedCategoryResults:Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

.field private didYouMean:Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

.field private displaySettings:Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

.field private dynamicContent:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/DynamicContent;",
            ">;"
        }
    .end annotation
.end field

.field private featuredContent:Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;

.field private fkmr:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FKMR;",
            ">;"
        }
    .end annotation
.end field

.field private mShopResult:Lcom/amazon/searchapp/retailsearch/model/MShopResult;

.field private noResults:Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

.field private pagination:Lcom/amazon/searchapp/retailsearch/model/Pagination;

.field private pastPurchases:Lcom/amazon/searchapp/retailsearch/model/PastPurchases;

.field private preloadImages:Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

.field private quartzBacklink:Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;

.field private refinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

.field private relatedSearches:Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

.field private resources:Lcom/amazon/searchapp/retailsearch/model/SearchResources;

.field private responseMetadata:Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;

.field private results:Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;

.field private resultsMetadata:Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

.field private similarities:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

.field private sort:Lcom/amazon/searchapp/retailsearch/model/Sort;

.field private spellCorrectedResults:Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

.field private trackingInfo:Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

.field private wordSplitterCorrectedResults:Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBreadcrumb()Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    return-object v0
.end method

.method public getCorrectedCategoryResults()Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->correctedCategoryResults:Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    return-object v0
.end method

.method public getDidYouMean()Lcom/amazon/searchapp/retailsearch/model/DidYouMean;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->didYouMean:Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    return-object v0
.end method

.method public getDisplaySettings()Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;
    .locals 1

    .prologue
    .line 354
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->displaySettings:Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    return-object v0
.end method

.method public getDynamicContent()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/DynamicContent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 554
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->dynamicContent:Ljava/util/List;

    return-object v0
.end method

.method public getFeaturedContent()Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;
    .locals 1

    .prologue
    .line 434
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->featuredContent:Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;

    return-object v0
.end method

.method public getFkmr()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FKMR;",
            ">;"
        }
    .end annotation

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->fkmr:Ljava/util/List;

    return-object v0
.end method

.method public getMShopResult()Lcom/amazon/searchapp/retailsearch/model/MShopResult;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->mShopResult:Lcom/amazon/searchapp/retailsearch/model/MShopResult;

    return-object v0
.end method

.method public getNoResults()Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->noResults:Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    return-object v0
.end method

.method public getPagination()Lcom/amazon/searchapp/retailsearch/model/Pagination;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->pagination:Lcom/amazon/searchapp/retailsearch/model/Pagination;

    return-object v0
.end method

.method public getPastPurchases()Lcom/amazon/searchapp/retailsearch/model/PastPurchases;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->pastPurchases:Lcom/amazon/searchapp/retailsearch/model/PastPurchases;

    return-object v0
.end method

.method public getPreloadImages()Lcom/amazon/searchapp/retailsearch/model/PreloadImages;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->preloadImages:Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    return-object v0
.end method

.method public getQuartzBacklink()Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;
    .locals 1

    .prologue
    .line 314
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->quartzBacklink:Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;

    return-object v0
.end method

.method public getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;
    .locals 1

    .prologue
    .line 414
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->refinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    return-object v0
.end method

.method public getRelatedSearches()Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->relatedSearches:Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    return-object v0
.end method

.method public getResources()Lcom/amazon/searchapp/retailsearch/model/SearchResources;
    .locals 1

    .prologue
    .line 574
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->resources:Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    return-object v0
.end method

.method public getResponseMetadata()Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->responseMetadata:Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;

    return-object v0
.end method

.method public getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;

    return-object v0
.end method

.method public getResultsMetadata()Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;
    .locals 1

    .prologue
    .line 514
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->resultsMetadata:Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    return-object v0
.end method

.method public getSimilarities()Lcom/amazon/searchapp/retailsearch/model/ProductSection;
    .locals 1

    .prologue
    .line 534
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->similarities:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    return-object v0
.end method

.method public getSort()Lcom/amazon/searchapp/retailsearch/model/Sort;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->sort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    return-object v0
.end method

.method public getSpellCorrectedResults()Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
    .locals 1

    .prologue
    .line 474
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->spellCorrectedResults:Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    return-object v0
.end method

.method public getTrackingInfo()Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;
    .locals 1

    .prologue
    .line 494
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->trackingInfo:Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    return-object v0
.end method

.method public getWordSplitterCorrectedResults()Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
    .locals 1

    .prologue
    .line 294
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->wordSplitterCorrectedResults:Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    return-object v0
.end method

.method public setBreadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
    .locals 0
    .param p1, "breadcrumb"    # Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .prologue
    .line 404
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .line 405
    return-void
.end method

.method public setCorrectedCategoryResults(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 0
    .param p1, "correctedCategoryResults"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 144
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->correctedCategoryResults:Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .line 145
    return-void
.end method

.method public setDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 0
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 224
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->didYouMean:Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .line 225
    return-void
.end method

.method public setDisplaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V
    .locals 0
    .param p1, "displaySettings"    # Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    .prologue
    .line 364
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->displaySettings:Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    .line 365
    return-void
.end method

.method public setDynamicContent(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/DynamicContent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 564
    .local p1, "dynamicContent":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/DynamicContent;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->dynamicContent:Ljava/util/List;

    .line 565
    return-void
.end method

.method public setFeaturedContent(Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;)V
    .locals 0
    .param p1, "featuredContent"    # Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;

    .prologue
    .line 444
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->featuredContent:Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;

    .line 445
    return-void
.end method

.method public setFkmr(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FKMR;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 164
    .local p1, "fkmr":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/FKMR;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->fkmr:Ljava/util/List;

    .line 165
    return-void
.end method

.method public setMShopResult(Lcom/amazon/searchapp/retailsearch/model/MShopResult;)V
    .locals 0
    .param p1, "mShopResult"    # Lcom/amazon/searchapp/retailsearch/model/MShopResult;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->mShopResult:Lcom/amazon/searchapp/retailsearch/model/MShopResult;

    .line 205
    return-void
.end method

.method public setNoResults(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 0
    .param p1, "noResults"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 464
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->noResults:Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .line 465
    return-void
.end method

.method public setPagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V
    .locals 0
    .param p1, "pagination"    # Lcom/amazon/searchapp/retailsearch/model/Pagination;

    .prologue
    .line 344
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->pagination:Lcom/amazon/searchapp/retailsearch/model/Pagination;

    .line 345
    return-void
.end method

.method public setPastPurchases(Lcom/amazon/searchapp/retailsearch/model/PastPurchases;)V
    .locals 0
    .param p1, "pastPurchases"    # Lcom/amazon/searchapp/retailsearch/model/PastPurchases;

    .prologue
    .line 264
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->pastPurchases:Lcom/amazon/searchapp/retailsearch/model/PastPurchases;

    .line 265
    return-void
.end method

.method public setPreloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 0
    .param p1, "preloadImages"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 244
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->preloadImages:Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .line 245
    return-void
.end method

.method public setQuartzBacklink(Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;)V
    .locals 0
    .param p1, "quartzBacklink"    # Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;

    .prologue
    .line 324
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->quartzBacklink:Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;

    .line 325
    return-void
.end method

.method public setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 0
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 424
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->refinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .line 425
    return-void
.end method

.method public setRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 0
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 284
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->relatedSearches:Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .line 285
    return-void
.end method

.method public setResources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
    .locals 0
    .param p1, "resources"    # Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    .prologue
    .line 584
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->resources:Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    .line 585
    return-void
.end method

.method public setResponseMetadata(Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;)V
    .locals 0
    .param p1, "responseMetadata"    # Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;

    .prologue
    .line 384
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->responseMetadata:Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;

    .line 385
    return-void
.end method

.method public setResults(Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;)V
    .locals 0
    .param p1, "results"    # Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;

    .prologue
    .line 184
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->results:Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;

    .line 185
    return-void
.end method

.method public setResultsMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V
    .locals 0
    .param p1, "resultsMetadata"    # Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    .prologue
    .line 524
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->resultsMetadata:Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    .line 525
    return-void
.end method

.method public setSimilarities(Lcom/amazon/searchapp/retailsearch/model/ProductSection;)V
    .locals 0
    .param p1, "similarities"    # Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .prologue
    .line 544
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->similarities:Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    .line 545
    return-void
.end method

.method public setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 0
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->sort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    .line 125
    return-void
.end method

.method public setSpellCorrectedResults(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 0
    .param p1, "spellCorrectedResults"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 484
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->spellCorrectedResults:Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .line 485
    return-void
.end method

.method public setTrackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 0
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 504
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->trackingInfo:Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .line 505
    return-void
.end method

.method public setWordSplitterCorrectedResults(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 0
    .param p1, "wordSplitterCorrectedResults"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 304
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->wordSplitterCorrectedResults:Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .line 305
    return-void
.end method
