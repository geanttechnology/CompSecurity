.class public Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;
.super Ljava/lang/Object;
.source "SearchParser.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;


# static fields
.field private static final fieldMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 82
    new-instance v0, Ljava/util/HashMap;

    const/16 v1, 0x20

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    .line 83
    .local v0, "fields":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Class<*>;>;"
    const-string/jumbo v1, "trackingInfo"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    const-string/jumbo v1, "spellCorrectedResults"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    const-string/jumbo v1, "wordSplitterCorrectedResults"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    const-string/jumbo v1, "correctedCategoryResults"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    const-string/jumbo v1, "refinements"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    const-string/jumbo v1, "pagination"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    const-string/jumbo v1, "sort"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/SortEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    const-string/jumbo v1, "breadcrumb"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    const-string/jumbo v1, "didYouMean"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    const-string/jumbo v1, "relatedSearches"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    const-string/jumbo v1, "resultsMetadata"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    const-string/jumbo v1, "preloadImages"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/PreloadImagesEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    const-string/jumbo v1, "noResults"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    const-string/jumbo v1, "displaySettings"

    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/DisplaySettingsEntity;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    const-string/jumbo v1, "resources"

    const-class v2, Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->fieldMap:Ljava/util/Map;

    .line 99
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1

    .prologue
    .line 408
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v0

    return-object v0
.end method

.method private processFkmr(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonParser;Ljava/util/List;Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)V
    .locals 4
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p4, "result"    # Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;
    .param p5, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/FKMR;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;",
            "Lcom/amazon/searchapp/retailsearch/client/SearchListener;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 385
    .local p3, "fkmrList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/FKMR;>;"
    const/4 v1, 0x0

    .line 387
    .local v1, "index":I
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    const-string/jumbo v3, "fkmrResults"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-le v2, v3, :cond_0

    .line 388
    const-string/jumbo v2, "fkmrResults"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 391
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 392
    const-class v2, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;

    invoke-virtual {p2, v2}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;

    .line 394
    .local v0, "fkmr":Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;
    if-eqz v0, :cond_1

    .line 395
    invoke-virtual {v0, v1}, Lcom/amazon/searchapp/retailsearch/entity/FKMREntity;->setIndex(I)V

    .line 396
    invoke-interface {p3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 398
    if-eqz p5, :cond_1

    .line 399
    invoke-interface {p5, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V

    .line 402
    :cond_1
    return-void
.end method

.method private processItems(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)V
    .locals 6
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "section"    # Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 352
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 353
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4}, Ljava/io/IOException;-><init>()V

    throw v4

    .line 356
    :cond_0
    new-instance v3, Ljava/util/ArrayList;

    const/16 v4, 0x14

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 357
    .local v3, "products":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/searchapp/retailsearch/model/Product;>;"
    const/4 v0, 0x0

    .line 359
    .local v0, "position":I
    :goto_0
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 360
    const-class v4, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;

    invoke-virtual {p1, v4}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;

    .line 361
    .local v2, "product":Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "position":I
    .local v1, "position":I
    invoke-virtual {v2, v0}, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->setPosition(I)V

    .line 362
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 364
    if-eqz p3, :cond_1

    .line 365
    invoke-interface {p3, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->product(Lcom/amazon/searchapp/retailsearch/model/Product;)V

    :cond_1
    move v0, v1

    .line 367
    .end local v1    # "position":I
    .restart local v0    # "position":I
    goto :goto_0

    .line 369
    .end local v2    # "product":Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;
    :cond_2
    invoke-static {v3}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v4

    invoke-static {v4}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v4

    invoke-virtual {p2, v4}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->setItems(Ljava/util/List;)V

    .line 370
    return-void
.end method

.method private processProductSection(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;
    .locals 4
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "result"    # Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 310
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 311
    const/4 v1, 0x0

    .line 340
    :cond_0
    return-object v1

    .line 314
    :cond_1
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 315
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2}, Ljava/io/IOException;-><init>()V

    throw v2

    .line 318
    :cond_2
    new-instance v1, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;-><init>()V

    .line 320
    .local v1, "section":Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;
    :goto_0
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 321
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 323
    .local v0, "name":Ljava/lang/String;
    const-string/jumbo v2, "items"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 324
    invoke-direct {p0, p1, v1, p3}, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->processItems(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)V

    goto :goto_0

    .line 325
    :cond_3
    const-string/jumbo v2, "section"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 326
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 327
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->setSection(I)V

    goto :goto_0

    .line 328
    :cond_4
    const-string/jumbo v2, "numSections"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 329
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 330
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->setNumSections(I)V

    goto :goto_0

    .line 331
    :cond_5
    const-string/jumbo v2, "page"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 332
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 333
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;->setPage(I)V

    goto :goto_0

    .line 335
    :cond_6
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextValue()Lcom/fasterxml/jackson/core/JsonToken;

    .line 336
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_0
.end method

.method private processResults(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)V
    .locals 5
    .param p1, "parser"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "result"    # Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;
    .param p3, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 267
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 268
    new-instance v3, Ljava/io/IOException;

    invoke-direct {v3}, Ljava/io/IOException;-><init>()V

    throw v3

    .line 271
    :cond_0
    new-instance v1, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;-><init>()V

    .line 272
    .local v1, "sectionSet":Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;
    invoke-virtual {p2, v1}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setResults(Lcom/amazon/searchapp/retailsearch/model/ProductSectionSet;)V

    .line 274
    new-instance v2, Ljava/util/ArrayList;

    const/4 v3, 0x2

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 275
    .local v2, "sections":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/ProductSection;>;"
    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;->setSections(Ljava/util/List;)V

    .line 277
    :cond_1
    :goto_0
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 278
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 280
    .local v0, "name":Ljava/lang/String;
    const-string/jumbo v3, "sections"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 281
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->START_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 282
    new-instance v3, Ljava/io/IOException;

    invoke-direct {v3}, Ljava/io/IOException;-><init>()V

    throw v3

    .line 285
    :cond_2
    :goto_1
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 286
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->processProductSection(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/entity/ProductSectionEntity;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 289
    :cond_3
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextValue()Lcom/fasterxml/jackson/core/JsonToken;

    .line 290
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_0

    .line 294
    .end local v0    # "name":Ljava/lang/String;
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;->getSections()Ljava/util/List;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/searchapp/retailsearch/entity/ProductSectionSetEntity;->setSections(Ljava/util/List;)V

    .line 296
    return-void
.end method


# virtual methods
.method public parse(Ljava/io/InputStream;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .locals 10
    .param p1, "content"    # Ljava/io/InputStream;
    .param p2, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    new-instance v4, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;

    invoke-direct {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;-><init>()V

    .line 111
    .local v4, "result":Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;
    if-eqz p2, :cond_0

    .line 112
    invoke-interface {p2, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->startParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    .line 115
    :cond_0
    const/4 v3, 0x0

    .line 117
    .local v3, "fkmrList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/FKMR;>;"
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->getFactory()Lcom/fasterxml/jackson/core/JsonFactory;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/core/JsonFactory;->createParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v2

    .line 119
    .local v2, "parser":Lcom/fasterxml/jackson/core/JsonParser;
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 120
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 123
    :cond_1
    :goto_0
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/fasterxml/jackson/core/JsonToken;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_14

    .line 124
    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v1

    .line 126
    .local v1, "name":Ljava/lang/String;
    const-string/jumbo v0, "results"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 127
    invoke-direct {p0, v2, v4, p2}, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->processResults(Lcom/fasterxml/jackson/core/JsonParser;Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)V

    goto :goto_0

    .line 128
    :cond_2
    const-string/jumbo v0, "fkmrResults"

    invoke-virtual {v1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 129
    if-nez v3, :cond_3

    .line 130
    new-instance v3, Ljava/util/ArrayList;

    .end local v3    # "fkmrList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/FKMR;>;"
    const/4 v0, 0x4

    invoke-direct {v3, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 131
    .restart local v3    # "fkmrList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/FKMR;>;"
    invoke-virtual {v4, v3}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setFkmr(Ljava/util/List;)V

    :cond_3
    move-object v0, p0

    move-object v5, p2

    .line 134
    invoke-direct/range {v0 .. v5}, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->processFkmr(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonParser;Ljava/util/List;Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)V

    goto :goto_0

    .line 136
    :cond_4
    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 137
    const/4 v7, 0x0

    .line 139
    .local v7, "found":Z
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/jackson/SearchParser;->fieldMap:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Class;

    .line 141
    .local v8, "model":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz v8, :cond_5

    .line 142
    const/4 v7, 0x1

    .line 144
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 145
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/RefinementsEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 147
    if-eqz p2, :cond_5

    .line 148
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->refinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 234
    :cond_5
    :goto_1
    if-nez v7, :cond_1

    .line 235
    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAsTree()Lcom/fasterxml/jackson/core/TreeNode;

    move-result-object v9

    check-cast v9, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 237
    .local v9, "node":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz p2, :cond_1

    .line 238
    new-instance v6, Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;

    invoke-direct {v6}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;-><init>()V

    .line 239
    .local v6, "dataItem":Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;
    invoke-virtual {v6, v1}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;->setName(Ljava/lang/String;)V

    .line 240
    invoke-virtual {v9}, Lcom/fasterxml/jackson/databind/JsonNode;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;->setValue(Ljava/lang/String;)V

    .line 241
    invoke-interface {p2, v6}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->dataItem(Lcom/amazon/searchapp/retailsearch/model/SearchResultDataItem;)V

    goto :goto_0

    .line 150
    .end local v6    # "dataItem":Lcom/amazon/searchapp/retailsearch/entity/SearchResultDataItemEntity;
    .end local v9    # "node":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_6
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 151
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/TrackingInfoEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setTrackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V

    .line 153
    if-eqz p2, :cond_5

    .line 154
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getTrackingInfo()Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V

    goto :goto_1

    .line 156
    :cond_7
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 157
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/PaginationEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setPagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V

    .line 159
    if-eqz p2, :cond_5

    .line 160
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getPagination()Lcom/amazon/searchapp/retailsearch/model/Pagination;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->pagination(Lcom/amazon/searchapp/retailsearch/model/Pagination;)V

    goto :goto_1

    .line 162
    :cond_8
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/SortEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 163
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/SortEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V

    .line 165
    if-eqz p2, :cond_5

    .line 166
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getSort()Lcom/amazon/searchapp/retailsearch/model/Sort;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->sort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V

    goto :goto_1

    .line 168
    :cond_9
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 169
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/BreadcrumbEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setBreadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V

    .line 171
    if-eqz p2, :cond_5

    .line 172
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getBreadcrumb()Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->breadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V

    goto/16 :goto_1

    .line 174
    :cond_a
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 175
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/DidYouMeanEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    .line 177
    if-eqz p2, :cond_5

    .line 178
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getDidYouMean()Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->didYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    goto/16 :goto_1

    .line 180
    :cond_b
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 181
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/RelatedSearchesEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V

    .line 183
    if-eqz p2, :cond_5

    .line 184
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getRelatedSearches()Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->relatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V

    goto/16 :goto_1

    .line 186
    :cond_c
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/ResultsMetadataEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 187
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setResultsMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V

    .line 189
    if-eqz p2, :cond_5

    .line 190
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getResultsMetadata()Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->resultMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V

    goto/16 :goto_1

    .line 192
    :cond_d
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 193
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/SpellCorrectedEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setSpellCorrectedResults(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    .line 195
    if-eqz p2, :cond_5

    .line 196
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getSpellCorrectedResults()Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    goto/16 :goto_1

    .line 198
    :cond_e
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 199
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/entity/CategoryCorrectedEntity;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setCorrectedCategoryResults(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V

    .line 202
    if-eqz p2, :cond_5

    .line 203
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getCorrectedCategoryResults()Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V

    goto/16 :goto_1

    .line 205
    :cond_f
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/PreloadImagesEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 206
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setPreloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V

    .line 208
    if-eqz p2, :cond_5

    .line 209
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getPreloadImages()Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V

    goto/16 :goto_1

    .line 211
    :cond_10
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/NoResultsSetEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 212
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setNoResults(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V

    .line 214
    if-eqz p2, :cond_5

    .line 215
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getNoResults()Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V

    goto/16 :goto_1

    .line 217
    :cond_11
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/DisplaySettingsEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 218
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setDisplaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V

    .line 220
    if-eqz p2, :cond_5

    .line 221
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getDisplaySettings()Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->displaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V

    goto/16 :goto_1

    .line 223
    :cond_12
    const-class v0, Lcom/amazon/searchapp/retailsearch/entity/SearchResourcesEntity;

    invoke-virtual {v0, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 224
    invoke-virtual {v2, v8}, Lcom/fasterxml/jackson/core/JsonParser;->readValueAs(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setResources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V

    .line 226
    if-eqz p2, :cond_5

    .line 227
    invoke-virtual {v4}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->getResources()Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V

    goto/16 :goto_1

    .line 230
    :cond_13
    const/4 v7, 0x0

    goto/16 :goto_1

    .line 247
    .end local v1    # "name":Ljava/lang/String;
    .end local v7    # "found":Z
    .end local v8    # "model":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :cond_14
    if-eqz v3, :cond_15

    .line 248
    invoke-static {v3}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/amazon/searchapp/retailsearch/entity/SearchResultEntity;->setFkmr(Ljava/util/List;)V

    .line 251
    :cond_15
    if-eqz p2, :cond_16

    .line 252
    invoke-interface {p2, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchListener;->endParse(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    .line 255
    :cond_16
    return-object v4
.end method
