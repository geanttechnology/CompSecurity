.class public Lcom/amazon/searchapp/retailsearch/client/jackson/EntityMap;
.super Ljava/lang/Object;
.source "EntityMap.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 156
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static mapTypes(Lcom/fasterxml/jackson/databind/module/SimpleModule;)V
    .locals 2
    .param p0, "module"    # Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .prologue
    .line 163
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Assets;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/AssetsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 164
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/AudienceRating;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/AudienceRatingEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 165
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Availability;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 166
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/BestSeller;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/BestSellerEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 167
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 168
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 169
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Contributor;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 170
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Department;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/DepartmentEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 171
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 172
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/DisplaySettingsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 173
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/DynamicContent;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/DynamicContentEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 174
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/DynamicProductContent;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/DynamicProductContentEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 175
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/EditionsMetadataEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 176
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/EditionsPriceInfo;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/EditionsPriceInfoEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 177
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/FKMR;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 178
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/FeaturedContent;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 179
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/FeaturedContentItem;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/FeaturedContentItemEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 180
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/FeaturedPromotion;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/FeaturedPromotionEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 181
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Hidden;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/HiddenEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 182
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Image;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ImageEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 183
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ImageResource;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ImageResourceEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 184
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/KindleUnlimitedEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 185
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Link;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 186
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/MShopResult;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/MShopResultEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 187
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Merchant;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/MerchantEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 188
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Movie;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/MovieEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 189
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/NewerVersion;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/NewerVersionEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 190
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 191
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/NonPrimeOfferEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 192
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Page;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 193
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Pagination;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 194
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/PantryBoxFill;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PantryBoxFillEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 195
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/PastPurchases;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PastPurchasesEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 196
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 197
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestionsResult;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PersonalizedSuggestionsResultEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 198
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Points;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PointsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 199
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PreloadImagesEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 200
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/PriceInfo;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PriceInfoEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 201
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Prices;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PricesEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 202
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Product;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 203
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ProductSection;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 204
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 205
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Promotion;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PromotionEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 206
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Purchase;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 207
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/QuartzBacklink;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/QuartzBacklinkEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 208
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Ratings;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/RatingsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 209
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/RefinementFilterEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 210
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/RefinementLinkEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 211
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Refinements;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 212
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 213
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ResourceSet;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ResourceSetEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 214
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ResponseMetadata;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ResponseMetadataEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 215
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 216
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SearchResourcesEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 217
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 218
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 219
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SearchSuggestionsEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 220
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SearchedText;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 221
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 222
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Shipping;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ShippingEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 223
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/ShippingStatusEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 224
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Sort;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SortEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 225
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 226
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/StringResource;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/StringResourceEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 227
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/StyledText;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/StyledTextEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 228
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Suggestion;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SuggestionEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 229
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/SuggestionDepartment;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/SuggestionDepartmentEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 230
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 231
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/TradeIn;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/TradeInEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 232
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/TypedContent;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/TypedContentEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 233
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/Variation;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/VariationEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 234
    const-class v0, Lcom/amazon/searchapp/retailsearch/model/WebIcon;

    const-class v1, Lcom/amazon/searchapp/retailsearch/entity/WebIconEntity;

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/module/SimpleModule;->addAbstractTypeMapping(Ljava/lang/Class;Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .line 235
    return-void
.end method
